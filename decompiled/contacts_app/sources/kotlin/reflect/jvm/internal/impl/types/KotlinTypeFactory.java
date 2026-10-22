package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptorKt;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorScopeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;

/* JADX INFO: compiled from: KotlinTypeFactory.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class KotlinTypeFactory {
    private static final Function1<KotlinTypeRefiner, SimpleType> EMPTY_REFINED_TYPE_FACTORY = null;
    public static final KotlinTypeFactory INSTANCE = null;

    /* JADX INFO: compiled from: KotlinTypeFactory.kt */
    private static final class ExpandedTypeOrRefinedConstructor {
        private final SimpleType expandedType;
        private final TypeConstructor refinedConstructor;

        public ExpandedTypeOrRefinedConstructor(SimpleType r1, TypeConstructor r2) {
            this.expandedType = r1;
            this.refinedConstructor = r2;
        }

        public final SimpleType getExpandedType() {
            return this.expandedType;
        }

        public final TypeConstructor getRefinedConstructor() {
            return this.refinedConstructor;
        }
    }

    private KotlinTypeFactory() {
    }

    public static final /* synthetic */ ExpandedTypeOrRefinedConstructor access$refineConstructor(KotlinTypeFactory r0, TypeConstructor r1, KotlinTypeRefiner r2, List r3) {
        return r0.refineConstructor(r1, r2, r3);
    }

    static {
        INSTANCE = new KotlinTypeFactory();
        EMPTY_REFINED_TYPE_FACTORY = KotlinTypeFactory$EMPTY_REFINED_TYPE_FACTORY$1.INSTANCE;
    }

    private final MemberScope computeMemberScope(TypeConstructor r2, List<? extends TypeProjection> r3, KotlinTypeRefiner r4) {
        ClassifierDescriptor r1 = r2.mo2083getDeclarationDescriptor();
        if ((r1 instanceof TypeParameterDescriptor) == false) goto L6;
        return ((TypeParameterDescriptor) r1).getDefaultType().getMemberScope();
    L6:
        if ((r1 instanceof ClassDescriptor) == false) goto L14;
        if (r4 != null) goto L10;
        r4 = DescriptorUtilsKt.getKotlinTypeRefiner(DescriptorUtilsKt.getModule(r1));
    L10:
        if (r3.isEmpty() == false) goto L25;
        return ModuleAwareClassDescriptorKt.getRefinedUnsubstitutedMemberScopeIfPossible((ClassDescriptor) r1, r4);
    L25:
        return ModuleAwareClassDescriptorKt.getRefinedMemberScopeIfPossible((ClassDescriptor) r1, TypeConstructorSubstitution.Companion.create(r2, r3), r4);
    L14:
        if ((r1 instanceof TypeAliasDescriptor) == false) goto L18;
        ErrorScopeKind r5 = ErrorScopeKind.SCOPE_FOR_ABBREVIATION_TYPE;
        String r6 = ((TypeAliasDescriptor) r1).getName().toString();
        Intrinsics.checkNotNullExpressionValue(r6, "descriptor.name.toString()");
        return ErrorUtils.createErrorScope(r5, true, new String[]{r6});
    L18:
        if ((r2 instanceof IntersectionTypeConstructor) == false) goto L22;
        return ((IntersectionTypeConstructor) r2).createScopeForKotlinType();
    L22:
        throw new IllegalStateException("Unsupported classifier: " + r1 + " for constructor: " + r2);
    }

    public static /* synthetic */ SimpleType simpleType$default(TypeAttributes r0, TypeConstructor r1, List r2, boolean r3, KotlinTypeRefiner r4, int r5, Object r6) {
        if ((r5 & 16) == 0) goto L6;
        r4 = null;
    L6:
        return simpleType(r0, r1, r2, r3, r4);
    }

    @JvmStatic
    public static final SimpleType simpleType(final TypeAttributes r7, final TypeConstructor r8, final List<? extends TypeProjection> r9, final boolean r10, KotlinTypeRefiner r11) {
        Intrinsics.checkNotNullParameter(r7, "attributes");
        Intrinsics.checkNotNullParameter(r8, "constructor");
        Intrinsics.checkNotNullParameter(r9, "arguments");
        if (r7.isEmpty() == false) goto L12;
        if (r9.isEmpty() == false) goto L12;
        if (r10 == true) goto L12;
        if (r8.mo2083getDeclarationDescriptor() == null) goto L12;
        ClassifierDescriptor r12 = r8.mo2083getDeclarationDescriptor();
        Intrinsics.checkNotNull(r12);
        SimpleType r13 = r12.getDefaultType();
        Intrinsics.checkNotNullExpressionValue(r13, "constructor.declarationDescriptor!!.defaultType");
        return r13;
    L12:
        return simpleTypeWithNonTrivialMemberScope(r7, r8, r9, r10, INSTANCE.computeMemberScope(r8, r9, r11), new AnonymousClass1(r8, r9, r7, r10));
    }

    @JvmStatic
    public static final SimpleType computeExpandedType(TypeAliasDescriptor r3, List<? extends TypeProjection> r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "arguments");
        return new TypeAliasExpander(TypeAliasExpansionReportStrategy.DO_NOTHING.INSTANCE, false).expand(TypeAliasExpansion.Companion.create(null, r3, r4), TypeAttributes.Companion.getEmpty());
    }

    private final ExpandedTypeOrRefinedConstructor refineConstructor(TypeConstructor r2, KotlinTypeRefiner r3, List<? extends TypeProjection> r4) {
        ClassifierDescriptor r1 = r2.mo2083getDeclarationDescriptor();
        if (r1 == null) goto L13;
        ClassifierDescriptor r5 = r3.refineDescriptor(r1);
        if (r5 == null) goto L13;
        if ((r5 instanceof TypeAliasDescriptor) == true) goto L10;
        TypeConstructor r6 = r5.getTypeConstructor().refine(r3);
        Intrinsics.checkNotNullExpressionValue(r6, "descriptor.typeConstruct…refine(kotlinTypeRefiner)");
        return new ExpandedTypeOrRefinedConstructor(null, r6);
    L10:
        return new ExpandedTypeOrRefinedConstructor(computeExpandedType((TypeAliasDescriptor) r5, r4), null);
    L13:
        return null;
    }

    @JvmStatic
    public static final SimpleType simpleTypeWithNonTrivialMemberScope(final TypeAttributes r8, final TypeConstructor r9, final List<? extends TypeProjection> r10, final boolean r11, final MemberScope r12) {
        Intrinsics.checkNotNullParameter(r8, "attributes");
        Intrinsics.checkNotNullParameter(r9, "constructor");
        Intrinsics.checkNotNullParameter(r10, "arguments");
        Intrinsics.checkNotNullParameter(r12, "memberScope");
        SimpleTypeImpl r0 = new SimpleTypeImpl(r9, r10, r11, r12, new C04831(r9, r10, r8, r11, r12));
        if (r8.isEmpty() == false) goto L6;
        return r0;
    L6:
        return new SimpleTypeWithAttributes(r0, r8);
    }

    @JvmStatic
    public static final SimpleType simpleTypeWithNonTrivialMemberScope(TypeAttributes r7, TypeConstructor r8, List<? extends TypeProjection> r9, boolean r10, MemberScope r11, Function1<? super KotlinTypeRefiner, ? extends SimpleType> r12) {
        Intrinsics.checkNotNullParameter(r7, "attributes");
        Intrinsics.checkNotNullParameter(r8, "constructor");
        Intrinsics.checkNotNullParameter(r9, "arguments");
        Intrinsics.checkNotNullParameter(r11, "memberScope");
        Intrinsics.checkNotNullParameter(r12, "refinedTypeFactory");
        SimpleTypeImpl r0 = new SimpleTypeImpl(r8, r9, r10, r11, r12);
        if (r7.isEmpty() == false) goto L6;
        return r0;
    L6:
        return new SimpleTypeWithAttributes(r0, r7);
    }

    @JvmStatic
    public static final SimpleType simpleNotNullType(TypeAttributes r8, ClassDescriptor r9, List<? extends TypeProjection> r10) {
        Intrinsics.checkNotNullParameter(r8, "attributes");
        Intrinsics.checkNotNullParameter(r9, "descriptor");
        Intrinsics.checkNotNullParameter(r10, "arguments");
        TypeConstructor r2 = r9.getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(r2, "descriptor.typeConstructor");
        return simpleType$default(r8, r2, r10, false, null, 16, null);
    }

    public static /* synthetic */ SimpleType simpleType$default(SimpleType r0, TypeAttributes r1, TypeConstructor r2, List r3, boolean r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r1 = r0.getAttributes();
    L6:
        if ((r5 & 4) == 0) goto L9;
        r2 = r0.getConstructor();
    L9:
        if ((r5 & 8) == 0) goto L12;
        r3 = r0.getArguments();
    L12:
        if ((r5 & 16) == 0) goto L15;
        r4 = r0.isMarkedNullable();
    L15:
        return simpleType(r0, r1, r2, r3, r4);
    }

    @JvmStatic
    public static final SimpleType simpleType(SimpleType r7, TypeAttributes r8, TypeConstructor r9, List<? extends TypeProjection> r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r7, "baseType");
        Intrinsics.checkNotNullParameter(r8, "annotations");
        Intrinsics.checkNotNullParameter(r9, "constructor");
        Intrinsics.checkNotNullParameter(r10, "arguments");
        return simpleType$default(r8, r9, r10, r11, null, 16, null);
    }

    @JvmStatic
    public static final UnwrappedType flexibleType(SimpleType r1, SimpleType r2) {
        Intrinsics.checkNotNullParameter(r1, "lowerBound");
        Intrinsics.checkNotNullParameter(r2, "upperBound");
        if (Intrinsics.areEqual(r1, r2) == false) goto L7;
        return r1;
    L7:
        return new FlexibleTypeImpl(r1, r2);
    }

    @JvmStatic
    public static final SimpleType integerLiteralType(TypeAttributes r4, IntegerLiteralTypeConstructor r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r4, "attributes");
        Intrinsics.checkNotNullParameter(r5, "constructor");
        return simpleTypeWithNonTrivialMemberScope(r4, r5, CollectionsKt.emptyList(), r6, ErrorUtils.createErrorScope(ErrorScopeKind.INTEGER_LITERAL_TYPE_SCOPE, true, new String[]{"unknown integer literal type"}));
    }
}
