package ya;

/* renamed from: ya.K, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5976K extends AbstractC5974I implements I0 {

    /* renamed from: d, reason: collision with root package name */
    public final AbstractC5974I f44033d;

    /* renamed from: e, reason: collision with root package name */
    public final S f44034e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5976K(AbstractC5974I origin, S enhancement) {
        super(origin.P0(), origin.Q0());
        kotlin.jvm.internal.p.i(origin, "origin");
        kotlin.jvm.internal.p.i(enhancement, "enhancement");
        this.f44033d = origin;
        this.f44034e = enhancement;
    }

    @Override // ya.K0
    public K0 L0(boolean z10) {
        return J0.d(A0().L0(z10), c0().K0().L0(z10));
    }

    @Override // ya.K0
    public K0 N0(s0 newAttributes) {
        kotlin.jvm.internal.p.i(newAttributes, "newAttributes");
        return J0.d(A0().N0(newAttributes), c0());
    }

    @Override // ya.AbstractC5974I
    public AbstractC5990d0 O0() {
        return A0().O0();
    }

    @Override // ya.AbstractC5974I
    public String R0(kotlin.reflect.jvm.internal.impl.renderer.b renderer, kotlin.reflect.jvm.internal.impl.renderer.c options) {
        kotlin.jvm.internal.p.i(renderer, "renderer");
        kotlin.jvm.internal.p.i(options, "options");
        return options.d() ? renderer.S(c0()) : A0().R0(renderer, options);
    }

    @Override // ya.I0
    /* renamed from: S0, reason: merged with bridge method [inline-methods] */
    public AbstractC5974I A0() {
        return this.f44033d;
    }

    @Override // ya.K0
    /* renamed from: T0, reason: merged with bridge method [inline-methods] */
    public C5976K R0(kotlin.reflect.jvm.internal.impl.types.checker.c kotlinTypeRefiner) {
        kotlin.jvm.internal.p.i(kotlinTypeRefiner, "kotlinTypeRefiner");
        S sA = kotlinTypeRefiner.a(A0());
        kotlin.jvm.internal.p.g(sA, "null cannot be cast to non-null type org.jetbrains.kotlin.types.FlexibleType");
        return new C5976K((AbstractC5974I) sA, kotlinTypeRefiner.a(c0()));
    }

    @Override // ya.I0
    public S c0() {
        return this.f44034e;
    }

    @Override // ya.AbstractC5974I
    public String toString() {
        return "[@EnhancedForWarnings(" + c0() + ")] " + A0();
    }
}
