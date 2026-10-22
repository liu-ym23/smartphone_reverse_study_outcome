package ya;

/* renamed from: ya.f0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5994f0 extends AbstractC5966A {

    /* renamed from: c, reason: collision with root package name */
    public final s0 f44085c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5994f0(AbstractC5990d0 delegate, s0 attributes) {
        super(delegate);
        kotlin.jvm.internal.p.i(delegate, "delegate");
        kotlin.jvm.internal.p.i(attributes, "attributes");
        this.f44085c = attributes;
    }

    @Override // ya.AbstractC6019z, ya.S
    public s0 G0() {
        return this.f44085c;
    }

    @Override // ya.AbstractC6019z
    /* renamed from: T0, reason: merged with bridge method [inline-methods] */
    public C5994f0 S0(AbstractC5990d0 delegate) {
        kotlin.jvm.internal.p.i(delegate, "delegate");
        return new C5994f0(delegate, G0());
    }
}
