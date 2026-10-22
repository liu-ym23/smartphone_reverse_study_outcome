package n;

import b0.b3;
import b0.o1;
import b0.t2;
import b0.v2;

/* loaded from: classes.dex */
public final class w0 implements b3 {

    /* renamed from: f, reason: collision with root package name */
    public final q6.b f6743f;

    /* renamed from: g, reason: collision with root package name */
    public final o1 f6744g;

    /* renamed from: h, reason: collision with root package name */
    public final o1 f6745h;

    /* renamed from: i, reason: collision with root package name */
    public final o1 f6746i;

    /* renamed from: j, reason: collision with root package name */
    public final o1 f6747j;

    /* renamed from: k, reason: collision with root package name */
    public final b0.k1 f6748k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f6749l;

    /* renamed from: m, reason: collision with root package name */
    public final o1 f6750m;

    /* renamed from: n, reason: collision with root package name */
    public n f6751n;

    /* renamed from: o, reason: collision with root package name */
    public final b0.m1 f6752o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f6753p;

    /* renamed from: q, reason: collision with root package name */
    public final l0 f6754q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ b1 f6755r;

    /* JADX WARN: Type inference failed for: r9v9, types: [java.lang.Object, java.util.Map] */
    public w0(b1 b1Var, Object obj, n nVar, q6.b bVar) {
        this.f6755r = b1Var;
        this.f6743f = bVar;
        o1 o1VarN = b0.b.n(obj);
        this.f6744g = o1VarN;
        Object objInvoke = null;
        this.f6745h = b0.b.n(d.i(7, null));
        this.f6746i = b0.b.n(new s0(c(), bVar, obj, o1VarN.getValue(), nVar));
        this.f6747j = b0.b.n(Boolean.TRUE);
        this.f6748k = new b0.k1(-1.0f);
        this.f6750m = b0.b.n(obj);
        this.f6751n = nVar;
        this.f6752o = new b0.m1(a().d());
        Float f10 = (Float) n1.f6676a.get(bVar);
        if (f10 != null) {
            float fFloatValue = f10.floatValue();
            n nVar2 = (n) ((p7.k) bVar.f8788h).invoke(obj);
            int iB = nVar2.b();
            for (int i2 = 0; i2 < iB; i2++) {
                nVar2.e(i2, fFloatValue);
            }
            objInvoke = ((p7.k) this.f6743f.f8787g).invoke(nVar2);
        }
        this.f6754q = d.i(3, objInvoke);
    }

    public final s0 a() {
        return (s0) this.f6746i.getValue();
    }

    public final v c() {
        return (v) this.f6745h.getValue();
    }

    public final float d() {
        b0.k1 k1Var = this.f6748k;
        return ((t2) l0.m.t(k1Var.f1230g, k1Var)).f1375c;
    }

    public final void e() {
        if (d() == -1.0f) {
            this.f6753p = true;
            boolean zA = q7.k.a(a().f6725c, a().f6726d);
            o1 o1Var = this.f6750m;
            if (zA) {
                o1Var.setValue(a().f6725c);
            } else {
                o1Var.setValue(a().c(0L));
                this.f6751n = a().g(0L);
            }
        }
    }

    public final void f(Object obj, boolean z4) {
        b1 b1Var = this.f6755r;
        o1 o1Var = b1Var.f6553h;
        o1 o1Var2 = this.f6744g;
        boolean zA = q7.k.a(null, o1Var2.getValue());
        b0.m1 m1Var = this.f6752o;
        o1 o1Var3 = this.f6746i;
        q6.b bVar = this.f6743f;
        if (zA) {
            o1Var3.setValue(new s0(this.f6754q, bVar, obj, obj, this.f6751n.c()));
            this.f6749l = true;
            m1Var.e(a().d());
            return;
        }
        v vVarC = (!z4 || this.f6753p || (c() instanceof l0)) ? c() : this.f6754q;
        long jMax = 0;
        o1Var3.setValue(new s0(b1Var.e() <= 0 ? vVarC : new m0(vVarC, b1Var.e()), bVar, obj, o1Var2.getValue(), this.f6751n));
        m1Var.e(a().d());
        this.f6749l = false;
        o1Var.setValue(Boolean.TRUE);
        if (b1Var.g()) {
            l0.q qVar = b1Var.f6554i;
            int size = qVar.size();
            for (int i2 = 0; i2 < size; i2++) {
                w0 w0Var = (w0) qVar.get(i2);
                b0.m1 m1Var2 = w0Var.f6752o;
                jMax = Math.max(jMax, ((v2) l0.m.t(m1Var2.f1241g, m1Var2)).f1386c);
                w0Var.e();
            }
            o1Var.setValue(Boolean.FALSE);
        }
    }

    public final void g(Object obj, Object obj2, v vVar) {
        this.f6744g.setValue(obj2);
        this.f6745h.setValue(vVar);
        if (q7.k.a(a().f6726d, obj) && q7.k.a(a().f6725c, obj2)) {
            return;
        }
        f(obj, false);
    }

    @Override // b0.b3
    public final Object getValue() {
        return this.f6750m.getValue();
    }

    public final String toString() {
        return "current value: " + this.f6750m.getValue() + ", target: " + this.f6744g.getValue() + ", spec: " + c();
    }
}
