package n;

import b0.o1;

/* loaded from: classes.dex */
public final class u0 {

    /* renamed from: a, reason: collision with root package name */
    public final q6.b f6738a;

    /* renamed from: b, reason: collision with root package name */
    public final o1 f6739b = b0.b.n(null);

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b1 f6740c;

    public u0(String str, b1 b1Var, q6.b bVar) {
        this.f6740c = b1Var;
        this.f6738a = bVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final t0 a(p7.k kVar, p7.k kVar2) {
        o1 o1Var = this.f6739b;
        t0 t0Var = (t0) o1Var.getValue();
        b1 b1Var = this.f6740c;
        if (t0Var == null) {
            Object objInvoke = kVar2.invoke(b1Var.c());
            Object objInvoke2 = kVar2.invoke(b1Var.c());
            q6.b bVar = this.f6738a;
            n nVar = (n) ((p7.k) bVar.f8788h).invoke(objInvoke2);
            nVar.d();
            w0 w0Var = new w0(b1Var, objInvoke, nVar, bVar);
            t0Var = new t0(this, w0Var, kVar, kVar2);
            o1Var.setValue(t0Var);
            b1Var.f6554i.add(w0Var);
        }
        t0Var.f6734h = (q7.m) kVar2;
        t0Var.f6733g = kVar;
        t0Var.a(b1Var.f());
        return t0Var;
    }
}
