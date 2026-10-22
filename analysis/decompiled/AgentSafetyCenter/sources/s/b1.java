package s;

import java.lang.invoke.VarHandle;
import k0.r2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b1 implements r2 {

    /* renamed from: c, reason: collision with root package name */
    public n6.a f10945c;

    /* renamed from: f, reason: collision with root package name */
    public k0.k1 f10946f;

    /* renamed from: g, reason: collision with root package name */
    public k0.k1 f10947g;

    /* renamed from: h, reason: collision with root package name */
    public k0.k1 f10948h;
    public k0.k1 i;

    /* renamed from: j, reason: collision with root package name */
    public k0.g1 f10949j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f10950k;

    /* renamed from: l, reason: collision with root package name */
    public k0.k1 f10951l;

    /* renamed from: m, reason: collision with root package name */
    public n f10952m;

    /* renamed from: n, reason: collision with root package name */
    public k0.i1 f10953n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f10954o;

    /* renamed from: p, reason: collision with root package name */
    public o0 f10955p;

    /* renamed from: q, reason: collision with root package name */
    public /* synthetic */ e1 f10956q;

    public final w0 a() {
        return (w0) this.f10948h.getValue();
    }

    public final x c() {
        return (x) this.f10947g.getValue();
    }

    public final void d() {
        k0.k1 k1Var = this.f10951l;
        if (this.f10949j.g() == -1.0f) {
            this.f10954o = true;
            if (yb.k.a(a().f11156c, a().f11157d)) {
                k1Var.setValue(a().f11156c);
            } else {
                k1Var.setValue(a().f(0L));
                this.f10952m = a().d(0L);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e(Object obj, boolean z10) {
        x xVar;
        k0.i1 i1Var = this.f10953n;
        k0.k1 k1Var = this.f10948h;
        e1 e1Var = this.f10956q;
        k0.k1 k1Var2 = e1Var.f10996h;
        k0.k1 k1Var3 = this.f10946f;
        if (yb.k.a(null, k1Var3.getValue())) {
            k1Var.setValue(new w0(this.f10955p, this.f10945c, obj, obj, this.f10952m.c()));
            this.f10950k = true;
            i1Var.h(a().b());
            return;
        }
        x xVarC = (!z10 || this.f10954o || (c() instanceof o0)) ? c() : this.f10955p;
        long jMax = 0;
        if (e1Var.e() <= 0) {
            xVar = xVarC;
        } else {
            long jE = e1Var.e();
            p0 p0Var = new p0();
            p0Var.f11094a = xVarC;
            p0Var.f11095b = jE;
            VarHandle.storeStoreFence();
            xVar = p0Var;
        }
        k1Var.setValue(new w0(xVar, this.f10945c, obj, k1Var3.getValue(), this.f10952m));
        i1Var.h(a().b());
        this.f10950k = false;
        k1Var2.setValue(Boolean.TRUE);
        if (e1Var.g()) {
            u0.q qVar = e1Var.i;
            int size = qVar.size();
            for (int i = 0; i < size; i++) {
                b1 b1Var = (b1) qVar.get(i);
                jMax = Math.max(jMax, b1Var.f10953n.g());
                b1Var.d();
            }
            k1Var2.setValue(Boolean.FALSE);
        }
    }

    public final void f(Object obj, Object obj2, x xVar) {
        this.f10946f.setValue(obj2);
        this.f10947g.setValue(xVar);
        if (yb.k.a(a().f11157d, obj) && yb.k.a(a().f11156c, obj2)) {
            return;
        }
        e(obj, false);
    }

    @Override // k0.r2
    public final Object getValue() {
        return this.f10951l.getValue();
    }

    public final String toString() {
        return "current value: " + this.f10951l.getValue() + ", target: " + this.f10946f.getValue() + ", spec: " + c();
    }
}
