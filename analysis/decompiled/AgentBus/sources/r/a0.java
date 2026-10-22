package r;

import i1.n1;

/* loaded from: classes.dex */
public final class a0 extends n0.l implements n1 {

    /* renamed from: t, reason: collision with root package name */
    public float f8841t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f8842u;

    @Override // i1.n1
    public final Object S(Object obj) {
        f0 f0Var = obj instanceof f0 ? (f0) obj : null;
        if (f0Var == null) {
            f0Var = new f0();
            f0Var.f8858a = 0.0f;
            f0Var.f8859b = true;
        }
        f0Var.f8858a = this.f8841t;
        f0Var.f8859b = this.f8842u;
        return f0Var;
    }
}
