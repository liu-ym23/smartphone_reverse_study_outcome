package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.NotNullTypeParameter;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* JADX INFO: compiled from: typeEnhancement.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class NotNullTypeParameterImpl extends DelegatingSimpleType implements NotNullTypeParameter {
    private final SimpleType delegate;

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public boolean isMarkedNullable() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.CustomTypeParameter
    public boolean isTypeParameter() {
        return true;
    }

    public NotNullTypeParameterImpl(SimpleType r2) {
        Intrinsics.checkNotNullParameter(r2, "delegate");
        this.delegate = r2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    protected SimpleType getDelegate() {
        return this.delegate;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public /* bridge */ /* synthetic */ UnwrappedType makeNullableAsSpecified(boolean r1) {
        return makeNullableAsSpecified(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public /* bridge */ /* synthetic */ SimpleType replaceAttributes(TypeAttributes r1) {
        return replaceAttributes(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public /* bridge */ /* synthetic */ UnwrappedType replaceAttributes(TypeAttributes r1) {
        return replaceAttributes(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    public /* bridge */ /* synthetic */ DelegatingSimpleType replaceDelegate(SimpleType r1) {
        return replaceDelegate(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.CustomTypeParameter
    public KotlinType substitutionResult(KotlinType r3) {
        Intrinsics.checkNotNullParameter(r3, "replacement");
        UnwrappedType r4 = r3.unwrap();
        UnwrappedType r0 = r4;
        if (TypeUtilsKt.isTypeParameter(r0) == true) goto L8;
        if (TypeUtils.isNullableType(r0) == true) goto L8;
        return r0;
    L8:
        if ((r4 instanceof SimpleType) == false) goto L11;
        return prepareReplacement((SimpleType) r4);
    L11:
        if ((r4 instanceof FlexibleType) == false) goto L15;
        FlexibleType r5 = (FlexibleType) r4;
        return TypeWithEnhancementKt.wrapEnhancement(KotlinTypeFactory.flexibleType(prepareReplacement(r5.getLowerBound()), prepareReplacement(r5.getUpperBound())), TypeWithEnhancementKt.getEnhancement(r0));
    L15:
        throw new IllegalStateException(("Incorrect type: " + r4).toString());
    }

    private final SimpleType prepareReplacement(SimpleType r1) {
        SimpleType r0 = r1.makeNullableAsSpecified(false);
        if (TypeUtilsKt.isTypeParameter(r1) == true) goto L6;
        return r0;
    L6:
        return new NotNullTypeParameterImpl(r0);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public NotNullTypeParameterImpl replaceAttributes(TypeAttributes r2) {
        Intrinsics.checkNotNullParameter(r2, "newAttributes");
        return new NotNullTypeParameterImpl(getDelegate().replaceAttributes(r2));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public SimpleType makeNullableAsSpecified(boolean r1) {
        if (r1 == false) goto L5;
        return getDelegate().makeNullableAsSpecified(true);
    L5:
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    public NotNullTypeParameterImpl replaceDelegate(SimpleType r1) {
        Intrinsics.checkNotNullParameter(r1, "delegate");
        return new NotNullTypeParameterImpl(r1);
    }
}
