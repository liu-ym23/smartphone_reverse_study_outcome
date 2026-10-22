package ya;

/* renamed from: ya.g0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5996g0 extends AbstractC6019z implements I0 {

    /* renamed from: b, reason: collision with root package name */
    public final AbstractC5990d0 f44087b;

    /* renamed from: c, reason: collision with root package name */
    public final S f44088c;

    public C5996g0(AbstractC5990d0 delegate, S enhancement) {
        kotlin.jvm.internal.p.i(delegate, "delegate");
        kotlin.jvm.internal.p.i(enhancement, "enhancement");
        this.f44087b = delegate;
        this.f44088c = enhancement;
    }

    @Override // ya.K0
    /* renamed from: O0 */
    public AbstractC5990d0 L0(boolean z10) {
        K0 k0D = J0.d(A0().L0(z10), c0().K0().L0(z10));
        kotlin.jvm.internal.p.g(k0D, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return (AbstractC5990d0) k0D;
    }

    @Override // ya.K0
    /* renamed from: P0 */
    public AbstractC5990d0 N0(s0 newAttributes) {
        kotlin.jvm.internal.p.i(newAttributes, "newAttributes");
        K0 k0D = J0.d(A0().N0(newAttributes), c0());
        kotlin.jvm.internal.p.g(k0D, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return (AbstractC5990d0) k0D;
    }

    @Override // ya.AbstractC6019z
    public AbstractC5990d0 Q0() {
        return this.f44087b;
    }

    @Override // ya.I0
    /* renamed from: T0, reason: merged with bridge method [inline-methods] */
    public AbstractC5990d0 A0() {
        return Q0();
    }

    @Override // ya.AbstractC6019z
    /* renamed from: U0, reason: merged with bridge method [inline-methods] */
    public C5996g0 R0(kotlin.reflect.jvm.internal.impl.types.checker.c kotlinTypeRefiner) {
        kotlin.jvm.internal.p.i(kotlinTypeRefiner, "kotlinTypeRefiner");
        S sA = kotlinTypeRefiner.a(Q0());
        kotlin.jvm.internal.p.g(sA, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return new C5996g0((AbstractC5990d0) sA, kotlinTypeRefiner.a(c0()));
    }

    @Override // ya.AbstractC6019z
    /* renamed from: V0, reason: merged with bridge method [inline-methods] */
    public C5996g0 S0(AbstractC5990d0 delegate) {
        kotlin.jvm.internal.p.i(delegate, "delegate");
        return new C5996g0(delegate, c0());
    }

    @Override // ya.I0
    public S c0() {
        return this.f44088c;
    }

    @Override // ya.AbstractC5990d0
    public String toString() {
        return "[@EnhancedForWarnings(" + c0() + ")] " + A0();
    }
}
