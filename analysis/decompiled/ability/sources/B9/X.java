package B9;

/* loaded from: classes4.dex */
public final class X extends I {
    public final String b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public X(z9.g primitive) {
        super(primitive);
        kotlin.jvm.internal.k.f(primitive, "primitive");
        this.b = primitive.h() + "Array";
    }

    @Override // z9.g
    public final String h() {
        return this.b;
    }
}
