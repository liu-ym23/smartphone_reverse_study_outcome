package androidx.activity;

import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b0 implements androidx.lifecycle.v, d {

    /* renamed from: c, reason: collision with root package name */
    public androidx.lifecycle.q f651c;

    /* renamed from: f, reason: collision with root package name */
    public u f652f;

    /* renamed from: g, reason: collision with root package name */
    public c0 f653g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ e0 f654h;

    @Override // androidx.activity.d
    public final void cancel() {
        this.f651c.c(this);
        u uVar = this.f652f;
        uVar.getClass();
        uVar.f700b.remove(this);
        c0 c0Var = this.f653g;
        if (c0Var != null) {
            c0Var.cancel();
        }
        this.f653g = null;
    }

    @Override // androidx.lifecycle.v
    public final void e(androidx.lifecycle.x xVar, androidx.lifecycle.o oVar) {
        if (oVar != androidx.lifecycle.o.ON_START) {
            if (oVar != androidx.lifecycle.o.ON_STOP) {
                if (oVar == androidx.lifecycle.o.ON_DESTROY) {
                    cancel();
                    return;
                }
                return;
            } else {
                c0 c0Var = this.f653g;
                if (c0Var != null) {
                    c0Var.cancel();
                    return;
                }
                return;
            }
        }
        e0 e0Var = this.f654h;
        u uVar = this.f652f;
        uVar.getClass();
        e0Var.f665b.addLast(uVar);
        c0 c0Var2 = new c0();
        c0Var2.f660f = e0Var;
        c0Var2.f659c = uVar;
        VarHandle.storeStoreFence();
        uVar.f700b.add(c0Var2);
        e0Var.d();
        uVar.f701c = new d0(0, e0Var, e0.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0, 0, 1);
        this.f653g = c0Var2;
    }
}
