package ya;

import kotlin.NoWhenBranchMatchedException;

/* renamed from: ya.J, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5975J extends AbstractC5974I implements InterfaceC6015v {

    /* renamed from: e, reason: collision with root package name */
    public static final a f44030e = new a(null);

    /* renamed from: f, reason: collision with root package name */
    public static boolean f44031f;

    /* renamed from: d, reason: collision with root package name */
    public boolean f44032d;

    /* renamed from: ya.J$a */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5975J(AbstractC5990d0 lowerBound, AbstractC5990d0 upperBound) {
        super(lowerBound, upperBound);
        kotlin.jvm.internal.p.i(lowerBound, "lowerBound");
        kotlin.jvm.internal.p.i(upperBound, "upperBound");
    }

    @Override // ya.K0
    public K0 L0(boolean z10) {
        return V.e(P0().L0(z10), Q0().L0(z10));
    }

    @Override // ya.K0
    public K0 N0(s0 newAttributes) {
        kotlin.jvm.internal.p.i(newAttributes, "newAttributes");
        return V.e(P0().N0(newAttributes), Q0().N0(newAttributes));
    }

    @Override // ya.AbstractC5974I
    public AbstractC5990d0 O0() {
        T0();
        return P0();
    }

    @Override // ya.AbstractC5974I
    public String R0(kotlin.reflect.jvm.internal.impl.renderer.b renderer, kotlin.reflect.jvm.internal.impl.renderer.c options) {
        kotlin.jvm.internal.p.i(renderer, "renderer");
        kotlin.jvm.internal.p.i(options, "options");
        if (!options.i()) {
            return renderer.P(renderer.S(P0()), renderer.S(Q0()), Da.d.n(this));
        }
        return '(' + renderer.S(P0()) + ".." + renderer.S(Q0()) + ')';
    }

    @Override // ya.K0
    /* renamed from: S0, reason: merged with bridge method [inline-methods] */
    public AbstractC5974I R0(kotlin.reflect.jvm.internal.impl.types.checker.c kotlinTypeRefiner) {
        kotlin.jvm.internal.p.i(kotlinTypeRefiner, "kotlinTypeRefiner");
        S sA = kotlinTypeRefiner.a(P0());
        kotlin.jvm.internal.p.g(sA, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        S sA2 = kotlinTypeRefiner.a(Q0());
        kotlin.jvm.internal.p.g(sA2, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return new C5975J((AbstractC5990d0) sA, (AbstractC5990d0) sA2);
    }

    @Override // ya.InterfaceC6015v
    public S T(S replacement) {
        K0 k0E;
        kotlin.jvm.internal.p.i(replacement, "replacement");
        K0 K02 = replacement.K0();
        if (K02 instanceof AbstractC5974I) {
            k0E = K02;
        } else {
            if (!(K02 instanceof AbstractC5990d0)) {
                throw new NoWhenBranchMatchedException();
            }
            AbstractC5990d0 abstractC5990d0 = (AbstractC5990d0) K02;
            k0E = V.e(abstractC5990d0, abstractC5990d0.L0(true));
        }
        return J0.b(k0E, K02);
    }

    public final void T0() {
        if (!f44031f || this.f44032d) {
            return;
        }
        this.f44032d = true;
        C5977L.b(P0());
        C5977L.b(Q0());
        kotlin.jvm.internal.p.d(P0(), Q0());
        kotlin.reflect.jvm.internal.impl.types.checker.b.f36098a.b(P0(), Q0());
    }

    @Override // ya.AbstractC5974I
    public String toString() {
        return '(' + P0() + ".." + Q0() + ')';
    }

    @Override // ya.InterfaceC6015v
    public boolean y0() {
        return (P0().H0().d() instanceof E9.b0) && kotlin.jvm.internal.p.d(P0().H0(), Q0().H0());
    }
}
