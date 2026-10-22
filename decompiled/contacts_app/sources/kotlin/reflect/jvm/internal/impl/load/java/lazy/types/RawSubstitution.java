package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.ErasureProjectionComputer;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.text.Typography;

/* JADX INFO: compiled from: RawSubstitution.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class RawSubstitution extends TypeSubstitution {
    public static final Companion Companion = null;
    private static final JavaTypeAttributes lowerTypeAttr = null;
    private static final JavaTypeAttributes upperTypeAttr = null;
    private final RawProjectionComputer projectionComputer;
    private final TypeParameterUpperBoundEraser typeParameterUpperBoundEraser;

    /* JADX INFO: compiled from: RawSubstitution.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RawSubstitution() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public boolean isEmpty() {
        return false;
    }

    public RawSubstitution(TypeParameterUpperBoundEraser r4) {
        RawProjectionComputer r0 = new RawProjectionComputer();
        this.projectionComputer = r0;
        if (r4 != null) goto L5;
        r4 = new TypeParameterUpperBoundEraser(r0, null, 2, null);
    L5:
        this.typeParameterUpperBoundEraser = r4;
    }

    public /* synthetic */ RawSubstitution(TypeParameterUpperBoundEraser r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }

    public static final /* synthetic */ Pair access$eraseInflexibleBasedOnClassDescriptor(RawSubstitution r0, SimpleType r1, ClassDescriptor r2, JavaTypeAttributes r3) {
        return r0.eraseInflexibleBasedOnClassDescriptor(r1, r2, r3);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    /* JADX INFO: renamed from: get */
    public /* bridge */ /* synthetic */ TypeProjection mo2088get(KotlinType r1) {
        return mo2088get(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    /* JADX INFO: renamed from: get */
    public TypeProjectionImpl mo2088get(KotlinType r4) {
        Intrinsics.checkNotNullParameter(r4, "key");
        return new TypeProjectionImpl(eraseType$default(this, r4, null, 2, null));
    }

    static /* synthetic */ KotlinType eraseType$default(RawSubstitution r9, KotlinType r10, JavaTypeAttributes r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L6;
        r11 = new JavaTypeAttributes(TypeUsage.COMMON, null, false, false, null, null, 62, null);
    L6:
        return r9.eraseType(r10, r11);
    }

    private final KotlinType eraseType(KotlinType r4, JavaTypeAttributes r5) {
        ClassifierDescriptor r0 = r4.getConstructor().mo2083getDeclarationDescriptor();
        if ((r0 instanceof TypeParameterDescriptor) == false) goto L6;
        return eraseType(this.typeParameterUpperBoundEraser.getErasedUpperBound((TypeParameterDescriptor) r0, r5.markIsRaw(true)), r5);
    L6:
        if ((r0 instanceof ClassDescriptor) == false) goto L20;
        ClassifierDescriptor r6 = FlexibleTypesKt.upperIfFlexible(r4).getConstructor().mo2083getDeclarationDescriptor();
        if ((r6 instanceof ClassDescriptor) == false) goto L18;
        Pair<SimpleType, Boolean> r1 = eraseInflexibleBasedOnClassDescriptor(FlexibleTypesKt.lowerIfFlexible(r4), (ClassDescriptor) r0, lowerTypeAttr);
        SimpleType r2 = r1.component1();
        boolean r3 = r1.component2().booleanValue();
        Pair<SimpleType, Boolean> r7 = eraseInflexibleBasedOnClassDescriptor(FlexibleTypesKt.upperIfFlexible(r4), (ClassDescriptor) r6, upperTypeAttr);
        SimpleType r8 = r7.component1();
        boolean r9 = r7.component2().booleanValue();
        if (r3 == true) goto L14;
        if (r9 == true) goto L14;
        RawTypeImpl r10 = KotlinTypeFactory.flexibleType(r2, r8);
    L16:
        return r10;
    L14:
        r10 = new RawTypeImpl(r2, r8);
        goto L16
    L18:
        throw new IllegalStateException(("For some reason declaration for upper bound is not a class but \"" + r6 + "\" while for lower it's \"" + r0 + Typography.quote).toString());
    L20:
        throw new IllegalStateException(("Unexpected declaration kind: " + r0).toString());
    }

    private final Pair<SimpleType, Boolean> eraseInflexibleBasedOnClassDescriptor(final SimpleType r21, final ClassDescriptor r22, final JavaTypeAttributes r23) {
        if (r21.getConstructor().getParameters().isEmpty() == true) goto L5;
        SimpleType r4 = r21;
        if (KotlinBuiltIns.isArray(r4) == false) goto L11;
        TypeProjection r2 = r21.getArguments().get(0);
        Variance r5 = r2.getProjectionKind();
        KotlinType r3 = r2.getType();
        Intrinsics.checkNotNullExpressionValue(r3, "componentTypeProjection.type");
        return TuplesKt.to(KotlinTypeFactory.simpleType$default(r21.getAttributes(), r21.getConstructor(), CollectionsKt.listOf(new TypeProjectionImpl(r5, eraseType(r3, r23))), r21.isMarkedNullable(), null, 16, null), false);
    L11:
        if (KotlinTypeKt.isError(r4) == true) goto L13;
        MemberScope r12 = r22.getMemberScope(this);
        Intrinsics.checkNotNullExpressionValue(r12, "declaration.getMemberScope(this)");
        TypeAttributes r8 = r21.getAttributes();
        TypeConstructor r9 = r22.getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(r9, "declaration.typeConstructor");
        List<TypeParameterDescriptor> r6 = r22.getTypeConstructor().getParameters();
        Intrinsics.checkNotNullExpressionValue(r6, "declaration.typeConstructor.parameters");
        List<TypeParameterDescriptor> r7 = r6;
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator<T> r11 = r7.iterator();
    L16:
        if (r11.hasNext() == false) goto L19;
        TypeParameterDescriptor r14 = (TypeParameterDescriptor) r11.next();
        RawProjectionComputer r13 = this.projectionComputer;
        Intrinsics.checkNotNullExpressionValue(r14, "parameter");
        r10.add(ErasureProjectionComputer.computeProjection$default(r13, r14, r23, this.typeParameterUpperBoundEraser, null, 8, null));
        goto L16
    L19:
        return TuplesKt.to(KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(r8, r9, r10, r21.isMarkedNullable(), r12, new AnonymousClass2(r22, this, r21, r23)), true);
    L13:
        return TuplesKt.to(ErrorUtils.createErrorType(ErrorTypeKind.ERROR_RAW_TYPE, new String[]{r21.getConstructor().toString()}), false);
    L5:
        return TuplesKt.to(r21, false);
    }

    static {
        Companion = new Companion(null);
        lowerTypeAttr = JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, false, true, null, 5, null).withFlexibility(JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND);
        upperTypeAttr = JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, false, true, null, 5, null).withFlexibility(JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND);
    }
}
