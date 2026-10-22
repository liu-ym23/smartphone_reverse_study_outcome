package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType;
import kotlin.reflect.jvm.internal.impl.types.checker.NewTypeVariableConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.NullabilityChecker;
import kotlin.reflect.jvm.internal.impl.types.model.DefinitelyNotNullTypeMarker;

/* JADX INFO: compiled from: SpecialTypes.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class DefinitelyNotNullType extends DelegatingSimpleType implements CustomTypeParameter, DefinitelyNotNullTypeMarker {
    public static final Companion Companion = null;
    private final SimpleType original;
    private final boolean useCorrectedNullabilityForTypeParameters;

    /* JADX INFO: compiled from: SpecialTypes.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ DefinitelyNotNullType makeDefinitelyNotNull$default(Companion r0, UnwrappedType r1, boolean r2, int r3, Object r4) {
            if ((r3 & 2) == 0) goto L6;
            r2 = false;
        L6:
            return r0.makeDefinitelyNotNull(r1, r2);
        }

        public final DefinitelyNotNullType makeDefinitelyNotNull(UnwrappedType r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r3, "type");
            if ((r3 instanceof DefinitelyNotNullType) == true) goto L13;
            DefaultConstructorMarker r0 = null;
            if (makesSenseToBeDefinitelyNotNull(r3, r4) == false) goto L12;
            if ((r3 instanceof FlexibleType) == false) goto L14;
            FlexibleType r2 = (FlexibleType) r3;
            Intrinsics.areEqual(r2.getLowerBound().getConstructor(), r2.getUpperBound().getConstructor());
        L14:
            return new DefinitelyNotNullType(FlexibleTypesKt.lowerIfFlexible(r3).makeNullableAsSpecified(false), r4, r0);
        L12:
            return null;
        L13:
            return (DefinitelyNotNullType) r3;
        }

        private final boolean makesSenseToBeDefinitelyNotNull(UnwrappedType r3, boolean r4) {
            boolean r0 = false;
            if (canHaveUndefinedNullability(r3) == true) goto L6;
            return false;
        L6:
            if ((r3 instanceof StubTypeForBuilderInference) == true) goto L8;
            ClassifierDescriptor r2 = r3.getConstructor().mo2083getDeclarationDescriptor();
            if ((r2 instanceof TypeParameterDescriptorImpl) == false) goto L12;
            TypeParameterDescriptorImpl r5 = (TypeParameterDescriptorImpl) r2;
        L14:
            if (r5 != null) goto L16;
        L18:
            if (r0 == false) goto L20;
            return true;
        L20:
            if (r4 == false) goto L26;
            if ((r3.getConstructor().mo2083getDeclarationDescriptor() instanceof TypeParameterDescriptor) == false) goto L26;
            return TypeUtils.isNullableType(r3);
        L26:
            return !NullabilityChecker.INSTANCE.isSubtypeOfAny(r3);
        L16:
            if (r5.isInitialized() == true) goto L18;
            r0 = true;
            goto L18
        L12:
            r5 = null;
            goto L14
        L8:
            return TypeUtils.isNullableType(r3);
        }

        private final boolean canHaveUndefinedNullability(UnwrappedType r1) {
            if ((r1.getConstructor() instanceof NewTypeVariableConstructor) == false) goto L5;
        L12:
            return true;
        L5:
            if ((r1.getConstructor().mo2083getDeclarationDescriptor() instanceof TypeParameterDescriptor) == true) goto L12;
            if ((r1 instanceof NewCapturedType) == true) goto L12;
            if ((r1 instanceof StubTypeForBuilderInference) == true) goto L12;
            return false;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ DefinitelyNotNullType(SimpleType r1, boolean r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public boolean isMarkedNullable() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public /* bridge */ /* synthetic */ UnwrappedType makeNullableAsSpecified(boolean r1) {
        return makeNullableAsSpecified(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public /* bridge */ /* synthetic */ UnwrappedType replaceAttributes(TypeAttributes r1) {
        return replaceAttributes(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    public /* bridge */ /* synthetic */ DelegatingSimpleType replaceDelegate(SimpleType r1) {
        return replaceDelegate(r1);
    }

    public final SimpleType getOriginal() {
        return this.original;
    }

    private DefinitelyNotNullType(SimpleType r1, boolean r2) {
        this.original = r1;
        this.useCorrectedNullabilityForTypeParameters = r2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    protected SimpleType getDelegate() {
        return this.original;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.CustomTypeParameter
    public boolean isTypeParameter() {
        if ((getDelegate().getConstructor() instanceof NewTypeVariableConstructor) == false) goto L5;
    L8:
        return true;
    L5:
        if ((getDelegate().getConstructor().mo2083getDeclarationDescriptor() instanceof TypeParameterDescriptor) == true) goto L8;
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.CustomTypeParameter
    public KotlinType substitutionResult(KotlinType r2) {
        Intrinsics.checkNotNullParameter(r2, "replacement");
        return SpecialTypesKt.makeDefinitelyNotNullOrNotNull(r2.unwrap(), this.useCorrectedNullabilityForTypeParameters);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public SimpleType replaceAttributes(TypeAttributes r3) {
        Intrinsics.checkNotNullParameter(r3, "newAttributes");
        return new DefinitelyNotNullType(getDelegate().replaceAttributes(r3), this.useCorrectedNullabilityForTypeParameters);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public SimpleType makeNullableAsSpecified(boolean r1) {
        if (r1 == false) goto L5;
        return getDelegate().makeNullableAsSpecified(r1);
    L5:
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType
    public String toString() {
        return getDelegate() + " & Any";
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    public DefinitelyNotNullType replaceDelegate(SimpleType r2) {
        Intrinsics.checkNotNullParameter(r2, "delegate");
        return new DefinitelyNotNullType(r2, this.useCorrectedNullabilityForTypeParameters);
    }
}
