package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

import com.bytedance.apm.battery.config.BatteryTypeInf;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefinerKt;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeRefinementSupport;
import kotlin.reflect.jvm.internal.impl.utils.DFS;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: compiled from: DescriptorUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class DescriptorUtilsKt {
    private static final Name RETENTION_PARAMETER_NAME = null;

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt$declaresOrInheritsDefaultValue$2, reason: invalid class name */
    /* JADX INFO: compiled from: DescriptorUtils.kt */
    /* synthetic */ class AnonymousClass2 extends FunctionReference implements Function1<ValueParameterDescriptor, Boolean> {
        public static final AnonymousClass2 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass2();
        }

        AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
        public final String getName() {
            return "declaresDefaultValue";
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final String getSignature() {
            return "declaresDefaultValue()Z";
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final KDeclarationContainer getOwner() {
            return Reflection.getOrCreateKotlinClass(ValueParameterDescriptor.class);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Boolean invoke2(ValueParameterDescriptor r1) {
            Intrinsics.checkNotNullParameter(r1, "p0");
            return Boolean.valueOf(r1.declaresDefaultValue());
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(ValueParameterDescriptor r1) {
            return invoke2(r1);
        }
    }

    static {
        Name r0 = Name.identifier("value");
        Intrinsics.checkNotNullExpressionValue(r0, "identifier(\"value\")");
        RETENTION_PARAMETER_NAME = r0;
    }

    public static final FqNameUnsafe getFqNameUnsafe(DeclarationDescriptor r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        FqNameUnsafe r2 = DescriptorUtils.getFqName(r1);
        Intrinsics.checkNotNullExpressionValue(r2, "getFqName(this)");
        return r2;
    }

    public static final FqName getFqNameSafe(DeclarationDescriptor r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        FqName r2 = DescriptorUtils.getFqNameSafe(r1);
        Intrinsics.checkNotNullExpressionValue(r2, "getFqNameSafe(this)");
        return r2;
    }

    public static final ModuleDescriptor getModule(DeclarationDescriptor r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        ModuleDescriptor r2 = DescriptorUtils.getContainingModule(r1);
        Intrinsics.checkNotNullExpressionValue(r2, "getContainingModule(this)");
        return r2;
    }

    public static final ClassDescriptor resolveTopLevelClass(ModuleDescriptor r2, FqName r3, LookupLocation r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "topLevelClassFqName");
        Intrinsics.checkNotNullParameter(r4, BatteryTypeInf.BATTERY_LOC_API);
        r3.isRoot();
        FqName r0 = r3.parent();
        Intrinsics.checkNotNullExpressionValue(r0, "topLevelClassFqName.parent()");
        MemberScope r5 = r2.getPackage(r0).getMemberScope();
        Name r6 = r3.shortName();
        Intrinsics.checkNotNullExpressionValue(r6, "topLevelClassFqName.shortName()");
        ClassifierDescriptor r7 = r5.mo2085getContributedClassifier(r6, r4);
        if ((r7 instanceof ClassDescriptor) == true) goto L7;
        return null;
    L7:
        return (ClassDescriptor) r7;
    }

    public static final ClassId getClassId(ClassifierDescriptor r3) {
        if (r3 == null) goto L15;
        DeclarationDescriptor r1 = r3.getContainingDeclaration();
        if (r1 != null) goto L7;
        return null;
    L7:
        if ((r1 instanceof PackageFragmentDescriptor) == false) goto L10;
        return new ClassId(((PackageFragmentDescriptor) r1).getFqName(), r3.getName());
    L10:
        if ((r1 instanceof ClassifierDescriptorWithTypeParameters) == false) goto L18;
        ClassId r2 = getClassId((ClassifierDescriptor) r1);
        if (r2 != null) goto L14;
        return null;
    L14:
        return r2.createNestedClassId(r3.getName());
    L18:
        return null;
    L15:
        return null;
    }

    public static final ClassDescriptor getSuperClassNotAny(ClassDescriptor r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Iterator<KotlinType> r3 = r2.getDefaultType().getConstructor().mo2084getSupertypes().iterator();
    L4:
        if (r3.hasNext() == false) goto L11;
        KotlinType r0 = r3.next();
        if (KotlinBuiltIns.isAnyOrNullableAny(r0) == true) goto L4;
        ClassifierDescriptor r1 = r0.getConstructor().mo2083getDeclarationDescriptor();
        if (DescriptorUtils.isClassOrEnumClass(r1) == false) goto L4;
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        return (ClassDescriptor) r1;
    L11:
        return null;
    }

    public static final KotlinBuiltIns getBuiltIns(DeclarationDescriptor r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return getModule(r1).getBuiltIns();
    }

    public static final boolean declaresOrInheritsDefaultValue(ValueParameterDescriptor r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Boolean r3 = DFS.ifAny(CollectionsKt.listOf(r2), AnonymousClass1.INSTANCE, AnonymousClass2.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(r3, "ifAny(\n        listOf(th…eclaresDefaultValue\n    )");
        return r3.booleanValue();
    }

    public static final Sequence<DeclarationDescriptor> getParentsWithSelf(DeclarationDescriptor r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return SequencesKt.generateSequence(r1, DescriptorUtilsKt$parentsWithSelf$1.INSTANCE);
    }

    public static final Sequence<DeclarationDescriptor> getParents(DeclarationDescriptor r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return SequencesKt.drop(getParentsWithSelf(r1), 1);
    }

    public static final CallableMemberDescriptor getPropertyIfAccessor(CallableMemberDescriptor r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if ((r1 instanceof PropertyAccessorDescriptor) == false) goto L6;
        PropertyDescriptor r2 = ((PropertyAccessorDescriptor) r1).getCorrespondingProperty();
        Intrinsics.checkNotNullExpressionValue(r2, "correspondingProperty");
        return r2;
    L6:
        return r1;
    }

    public static final FqName fqNameOrNull(DeclarationDescriptor r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        FqNameUnsafe r3 = getFqNameUnsafe(r2);
        if (r3.isSafe() == true) goto L6;
        r3 = null;
    L6:
        if (r3 != null) goto L8;
        return null;
    L8:
        return r3.toSafe();
    }

    public static /* synthetic */ CallableMemberDescriptor firstOverridden$default(CallableMemberDescriptor r0, boolean r1, Function1 r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = false;
    L6:
        return firstOverridden(r0, r1, r2);
    }

    public static final CallableMemberDescriptor firstOverridden(CallableMemberDescriptor r2, final boolean r3, final Function1<? super CallableMemberDescriptor, Boolean> r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r4, "predicate");
        final Ref.ObjectRef r0 = new Ref.ObjectRef();
        return (CallableMemberDescriptor) DFS.dfs(CollectionsKt.listOf(r2), new C04771(r3), new C04782(r0, r4));
    }

    public static final ClassDescriptor getAnnotationClass(AnnotationDescriptor r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        ClassifierDescriptor r2 = r1.getType().getConstructor().mo2083getDeclarationDescriptor();
        if ((r2 instanceof ClassDescriptor) == true) goto L7;
        return null;
    L7:
        return (ClassDescriptor) r2;
    }

    public static final KotlinTypeRefiner getKotlinTypeRefiner(ModuleDescriptor r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        kotlin.reflect.jvm.internal.impl.types.checker.Ref r2 = (kotlin.reflect.jvm.internal.impl.types.checker.Ref) r1.getCapability(KotlinTypeRefinerKt.getREFINER_CAPABILITY());
        if (r2 == null) goto L5;
        TypeRefinementSupport r3 = (TypeRefinementSupport) r2.getValue();
    L7:
        if ((r3 instanceof TypeRefinementSupport.Enabled) == false) goto L10;
        return ((TypeRefinementSupport.Enabled) r3).getTypeRefiner();
    L10:
        return KotlinTypeRefiner.Default.INSTANCE;
    L5:
        r3 = null;
        goto L7
    }

    public static final boolean isTypeRefinementEnabled(ModuleDescriptor r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        kotlin.reflect.jvm.internal.impl.types.checker.Ref r3 = (kotlin.reflect.jvm.internal.impl.types.checker.Ref) r2.getCapability(KotlinTypeRefinerKt.getREFINER_CAPABILITY());
        if (r3 == null) goto L10;
        TypeRefinementSupport r4 = (TypeRefinementSupport) r3.getValue();
        if (r4 != null) goto L7;
        return false;
    L7:
        if (r4.isEnabled() == true) goto L9;
        return false;
    L9:
        return true;
    L10:
        return false;
    }

    public static final InlineClassRepresentation<SimpleType> getInlineClassRepresentation(ClassDescriptor r2) {
        if (r2 == null) goto L5;
        ValueClassRepresentation<SimpleType> r3 = r2.getValueClassRepresentation();
    L7:
        if ((r3 instanceof InlineClassRepresentation) == true) goto L9;
        return null;
    L9:
        return (InlineClassRepresentation) r3;
    L5:
        r3 = null;
        goto L7
    }
}
