package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KotlinTypeFactory.kt */
/* JADX INFO: loaded from: classes4.dex */
final class SimpleTypeWithAttributes extends DelegatingSimpleTypeImpl {
    private final TypeAttributes attributes;

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    public /* bridge */ /* synthetic */ DelegatingSimpleType replaceDelegate(SimpleType r1) {
        return replaceDelegate(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public TypeAttributes getAttributes() {
        return this.attributes;
    }

    public SimpleTypeWithAttributes(SimpleType r2, TypeAttributes r3) {
        Intrinsics.checkNotNullParameter(r2, "delegate");
        Intrinsics.checkNotNullParameter(r3, "attributes");
        super(r2);
        this.attributes = r3;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    public SimpleTypeWithAttributes replaceDelegate(SimpleType r2) {
        Intrinsics.checkNotNullParameter(r2, "delegate");
        return new SimpleTypeWithAttributes(r2, getAttributes());
    }
}
