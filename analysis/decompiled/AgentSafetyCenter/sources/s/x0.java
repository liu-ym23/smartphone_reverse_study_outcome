package s;

import k0.r2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class x0 implements r2 {

    /* renamed from: c, reason: collision with root package name */
    public b1 f11162c;

    /* renamed from: f, reason: collision with root package name */
    public xb.l f11163f;

    /* renamed from: g, reason: collision with root package name */
    public yb.l f11164g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ y0 f11165h;

    /* JADX WARN: Type inference failed for: r1v3, types: [xb.l, yb.l] */
    /* JADX WARN: Type inference failed for: r5v0, types: [xb.l, yb.l] */
    public final void a(z0 z0Var) {
        b1 b1Var = this.f11162c;
        k0.k1 k1Var = b1Var.i;
        k0.k1 k1Var2 = b1Var.f10946f;
        k0.g1 g1Var = b1Var.f10949j;
        k0.k1 k1Var3 = b1Var.f10951l;
        Object objInvoke = this.f11164g.invoke(z0Var.c());
        if (this.f11165h.f11168c.g()) {
            b1Var.f(this.f11164g.invoke(z0Var.b()), objInvoke, (x) this.f11163f.invoke(z0Var));
            return;
        }
        x xVar = (x) this.f11163f.invoke(z0Var);
        if (b1Var.f10950k && yb.k.a(objInvoke, null)) {
            return;
        }
        if (yb.k.a(k1Var2.getValue(), objInvoke) && g1Var.g() == -1.0f) {
            return;
        }
        k1Var2.setValue(objInvoke);
        b1Var.f10947g.setValue(xVar);
        b1Var.e(g1Var.g() == -3.0f ? objInvoke : k1Var3.getValue(), !((Boolean) k1Var.getValue()).booleanValue());
        k1Var.setValue(Boolean.valueOf(g1Var.g() == -3.0f));
        if (g1Var.g() >= 0.0f) {
            k1Var3.setValue(b1Var.a().f((long) (g1Var.g() * b1Var.a().b())));
        } else if (g1Var.g() == -3.0f) {
            k1Var3.setValue(objInvoke);
        }
        b1Var.f10950k = false;
        g1Var.h(-1.0f);
    }

    @Override // k0.r2
    public final Object getValue() {
        a(this.f11165h.f11168c.f());
        return this.f11162c.f10951l.getValue();
    }
}
