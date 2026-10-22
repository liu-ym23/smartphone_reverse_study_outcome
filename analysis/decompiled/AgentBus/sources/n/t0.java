package n;

import b0.b3;
import b0.o1;

/* loaded from: classes.dex */
public final class t0 implements b3 {

    /* renamed from: f, reason: collision with root package name */
    public final w0 f6732f;

    /* renamed from: g, reason: collision with root package name */
    public p7.k f6733g;

    /* renamed from: h, reason: collision with root package name */
    public q7.m f6734h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ u0 f6735i;

    /* JADX WARN: Multi-variable type inference failed */
    public t0(u0 u0Var, w0 w0Var, p7.k kVar, p7.k kVar2) {
        this.f6735i = u0Var;
        this.f6732f = w0Var;
        this.f6733g = kVar;
        this.f6734h = (q7.m) kVar2;
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [p7.k, q7.m] */
    /* JADX WARN: Type inference failed for: r4v0, types: [p7.k, q7.m] */
    public final void a(v0 v0Var) {
        w0 w0Var = this.f6732f;
        o1 o1Var = w0Var.f6747j;
        o1 o1Var2 = w0Var.f6744g;
        o1 o1Var3 = w0Var.f6750m;
        Object objInvoke = this.f6734h.invoke(v0Var.f6742b);
        if (this.f6735i.f6740c.g()) {
            w0Var.g(this.f6734h.invoke(v0Var.f6741a), objInvoke, (v) this.f6733g.invoke(v0Var));
            return;
        }
        v vVar = (v) this.f6733g.invoke(v0Var);
        if (w0Var.f6749l && q7.k.a(objInvoke, null)) {
            return;
        }
        if (q7.k.a(o1Var2.getValue(), objInvoke) && w0Var.d() == -1.0f) {
            return;
        }
        o1Var2.setValue(objInvoke);
        w0Var.f6745h.setValue(vVar);
        w0Var.f(w0Var.d() == -3.0f ? objInvoke : o1Var3.getValue(), !((Boolean) o1Var.getValue()).booleanValue());
        o1Var.setValue(Boolean.valueOf(w0Var.d() == -3.0f));
        if (w0Var.d() >= 0.0f) {
            o1Var3.setValue(w0Var.a().c((long) (w0Var.d() * w0Var.a().d())));
        } else if (w0Var.d() == -3.0f) {
            o1Var3.setValue(objInvoke);
        }
        w0Var.f6749l = false;
        w0Var.f6748k.e(-1.0f);
    }

    @Override // b0.b3
    public final Object getValue() {
        a(this.f6735i.f6740c.f());
        return this.f6732f.f6750m.getValue();
    }
}
