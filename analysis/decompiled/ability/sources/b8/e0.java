package b8;

import i8.C1560f;

/* loaded from: classes4.dex */
public final class e0 implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2040a;
    public final f0 b;

    public /* synthetic */ e0(f0 f0Var, int i) {
        this.f2040a = i;
        this.b = f0Var;
    }

    @Override // S7.a
    public final Object invoke() {
        switch (this.f2040a) {
            case 0:
                f0 f0Var = this.b;
                k8.I getter = f0Var.p().g().getGetter();
                return getter == null ? J8.m.f(f0Var.p().g(), C1560f.f4611a) : getter;
            default:
                return D7.N.i(this.b, true);
        }
    }
}
