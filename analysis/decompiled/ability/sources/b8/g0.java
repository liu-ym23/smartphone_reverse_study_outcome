package b8;

import i8.C1560f;

/* loaded from: classes4.dex */
public final class g0 implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2042a;
    public final h0 b;

    public /* synthetic */ g0(h0 h0Var, int i) {
        this.f2042a = i;
        this.b = h0Var;
    }

    @Override // S7.a
    public final Object invoke() {
        switch (this.f2042a) {
            case 0:
                h0 h0Var = this.b;
                k8.J setter = h0Var.p().g().getSetter();
                return setter == null ? J8.m.g(h0Var.p().g(), C1560f.f4611a) : setter;
            default:
                return D7.N.i(this.b, false);
        }
    }
}
