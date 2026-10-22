package kotlin.reflect.jvm.internal.impl.types;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* JADX INFO: compiled from: flexibleTypes.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class FlexibleTypeImpl extends FlexibleType implements CustomTypeParameter {
    public static final Companion Companion = null;
    public static boolean RUN_SLOW_ASSERTIONS;
    private boolean assertionsDone;

    /* JADX INFO: compiled from: flexibleTypes.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public FlexibleTypeImpl(SimpleType r2, SimpleType r3) {
        Intrinsics.checkNotNullParameter(r2, "lowerBound");
        Intrinsics.checkNotNullParameter(r3, "upperBound");
        super(r2, r3);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public /* bridge */ /* synthetic */ KotlinType refine(KotlinTypeRefiner r1) {
        return refine(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public /* bridge */ /* synthetic */ UnwrappedType refine(KotlinTypeRefiner r1) {
        return refine(r1);
    }

    private final void runAssertions() {
        if (RUN_SLOW_ASSERTIONS == true) goto L5;
        return;
    L5:
        if (this.assertionsDone == true) goto L10;
        this.assertionsDone = true;
        FlexibleTypesKt.isFlexible(getLowerBound());
        FlexibleTypesKt.isFlexible(getUpperBound());
        Intrinsics.areEqual(getLowerBound(), getUpperBound());
        KotlinTypeChecker.DEFAULT.isSubtypeOf(getLowerBound(), getUpperBound());
        return;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.FlexibleType
    public SimpleType getDelegate() {
        runAssertions();
        return getLowerBound();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.CustomTypeParameter
    public boolean isTypeParameter() {
        if ((getLowerBound().getConstructor().mo2083getDeclarationDescriptor() instanceof TypeParameterDescriptor) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(getLowerBound().getConstructor(), getUpperBound().getConstructor()) == false) goto L7;
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.CustomTypeParameter
    public KotlinType substitutionResult(KotlinType r2) {
        Intrinsics.checkNotNullParameter(r2, "replacement");
        UnwrappedType r1 = r2.unwrap();
        if ((r1 instanceof FlexibleType) == false) goto L6;
        UnwrappedType r3 = r1;
    L9:
        return TypeWithEnhancementKt.inheritEnhancement(r3, r1);
    L6:
        if ((r1 instanceof SimpleType) == false) goto L11;
        SimpleType r4 = (SimpleType) r1;
        r3 = KotlinTypeFactory.flexibleType(r4, r4.makeNullableAsSpecified(true));
        goto L9
    L11:
        throw new NoWhenBranchMatchedException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public UnwrappedType replaceAttributes(TypeAttributes r2) {
        Intrinsics.checkNotNullParameter(r2, "newAttributes");
        return KotlinTypeFactory.flexibleType(getLowerBound().replaceAttributes(r2), getUpperBound().replaceAttributes(r2));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.FlexibleType
    public String render(DescriptorRenderer r2, DescriptorRendererOptions r3) {
        Intrinsics.checkNotNullParameter(r2, "renderer");
        Intrinsics.checkNotNullParameter(r3, "options");
        if (r3.getDebugMode() == false) goto L7;
        return "(" + r2.renderType(getLowerBound()) + ".." + r2.renderType(getUpperBound()) + ')';
    L7:
        return r2.renderFlexibleType(r2.renderType(getLowerBound()), r2.renderType(getUpperBound()), TypeUtilsKt.getBuiltIns(this));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.FlexibleType
    public String toString() {
        return "(" + getLowerBound() + ".." + getUpperBound() + ')';
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public UnwrappedType makeNullableAsSpecified(boolean r2) {
        return KotlinTypeFactory.flexibleType(getLowerBound().makeNullableAsSpecified(r2), getUpperBound().makeNullableAsSpecified(r2));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public FlexibleType refine(KotlinTypeRefiner r4) {
        Intrinsics.checkNotNullParameter(r4, "kotlinTypeRefiner");
        KotlinType r1 = r4.refineType(getLowerBound());
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        KotlinType r3 = r4.refineType(getUpperBound());
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return new FlexibleTypeImpl((SimpleType) r1, (SimpleType) r3);
    }
}
