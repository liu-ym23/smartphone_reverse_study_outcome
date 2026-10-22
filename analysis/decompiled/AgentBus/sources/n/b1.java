package n;

import b0.o1;
import b0.v2;

/* loaded from: classes.dex */
public final class b1 {

    /* renamed from: a, reason: collision with root package name */
    public final q6.b f6546a;

    /* renamed from: b, reason: collision with root package name */
    public final b1 f6547b;

    /* renamed from: c, reason: collision with root package name */
    public final String f6548c;

    /* renamed from: d, reason: collision with root package name */
    public final o1 f6549d = b0.b.n(c());

    /* renamed from: e, reason: collision with root package name */
    public final o1 f6550e = b0.b.n(new v0(c(), c()));

    /* renamed from: f, reason: collision with root package name */
    public final b0.m1 f6551f = new b0.m1(0);

    /* renamed from: g, reason: collision with root package name */
    public final b0.m1 f6552g = new b0.m1(Long.MIN_VALUE);

    /* renamed from: h, reason: collision with root package name */
    public final o1 f6553h;

    /* renamed from: i, reason: collision with root package name */
    public final l0.q f6554i;

    /* renamed from: j, reason: collision with root package name */
    public final l0.q f6555j;

    /* renamed from: k, reason: collision with root package name */
    public final o1 f6556k;

    public b1(String str, b1 b1Var, q6.b bVar) {
        this.f6546a = bVar;
        this.f6547b = b1Var;
        this.f6548c = str;
        Boolean bool = Boolean.FALSE;
        this.f6553h = b0.b.n(bool);
        this.f6554i = new l0.q();
        this.f6555j = new l0.q();
        this.f6556k = b0.b.n(bool);
        b0.b.j(new m.e(this, 1));
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x008d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(java.lang.Boolean r10, b0.p r11, int r12) {
        /*
            Method dump skipped, instructions count: 239
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n.b1.a(java.lang.Boolean, b0.p, int):void");
    }

    public final long b() {
        l0.q qVar = this.f6554i;
        int size = qVar.size();
        long jMax = 0;
        for (int i2 = 0; i2 < size; i2++) {
            b0.m1 m1Var = ((w0) qVar.get(i2)).f6752o;
            jMax = Math.max(jMax, ((v2) l0.m.t(m1Var.f1241g, m1Var)).f1386c);
        }
        l0.q qVar2 = this.f6555j;
        int size2 = qVar2.size();
        for (int i10 = 0; i10 < size2; i10++) {
            jMax = Math.max(jMax, ((b1) qVar2.get(i10)).b());
        }
        return jMax;
    }

    public final Object c() {
        return ((o1) this.f6546a.f8787g).getValue();
    }

    public final boolean d() {
        l0.q qVar = this.f6554i;
        int size = qVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((w0) qVar.get(i2)).getClass();
        }
        l0.q qVar2 = this.f6555j;
        int size2 = qVar2.size();
        for (int i10 = 0; i10 < size2; i10++) {
            if (((b1) qVar2.get(i10)).d()) {
                return true;
            }
        }
        return false;
    }

    public final long e() {
        b1 b1Var = this.f6547b;
        if (b1Var != null) {
            return b1Var.e();
        }
        b0.m1 m1Var = this.f6551f;
        return ((v2) l0.m.t(m1Var.f1241g, m1Var)).f1386c;
    }

    public final v0 f() {
        return (v0) this.f6550e.getValue();
    }

    public final boolean g() {
        return ((Boolean) this.f6556k.getValue()).booleanValue();
    }

    public final void h(long j2, boolean z4) {
        q6.b bVar = this.f6546a;
        o1 o1Var = (o1) bVar.f8788h;
        b0.m1 m1Var = this.f6552g;
        if (((v2) l0.m.t(m1Var.f1241g, m1Var)).f1386c == Long.MIN_VALUE) {
            m1Var.e(j2);
            ((o1) bVar.f8788h).setValue(Boolean.TRUE);
        } else if (!((Boolean) o1Var.getValue()).booleanValue()) {
            o1Var.setValue(Boolean.TRUE);
        }
        this.f6553h.setValue(Boolean.FALSE);
        l0.q qVar = this.f6554i;
        int size = qVar.size();
        boolean z10 = true;
        for (int i2 = 0; i2 < size; i2++) {
            w0 w0Var = (w0) qVar.get(i2);
            o1 o1Var2 = w0Var.f6747j;
            o1 o1Var3 = w0Var.f6747j;
            if (!((Boolean) o1Var2.getValue()).booleanValue()) {
                long jD = z4 ? w0Var.a().d() : j2;
                w0Var.f6750m.setValue(w0Var.a().c(jD));
                w0Var.f6751n = w0Var.a().g(jD);
                if (w0Var.a().i(jD)) {
                    o1Var3.setValue(Boolean.TRUE);
                }
            }
            if (!((Boolean) o1Var3.getValue()).booleanValue()) {
                z10 = false;
            }
        }
        l0.q qVar2 = this.f6555j;
        int size2 = qVar2.size();
        for (int i10 = 0; i10 < size2; i10++) {
            b1 b1Var = (b1) qVar2.get(i10);
            if (!q7.k.a(b1Var.f6549d.getValue(), b1Var.c())) {
                b1Var.h(j2, z4);
            }
            if (!q7.k.a(b1Var.f6549d.getValue(), b1Var.c())) {
                z10 = false;
            }
        }
        if (z10) {
            i();
        }
    }

    public final void i() {
        this.f6552g.e(Long.MIN_VALUE);
        Object value = this.f6549d.getValue();
        q6.b bVar = this.f6546a;
        ((o1) bVar.f8787g).setValue(value);
        if (this.f6547b == null) {
            this.f6551f.e(0L);
        }
        ((o1) bVar.f8788h).setValue(Boolean.FALSE);
        l0.q qVar = this.f6555j;
        int size = qVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((b1) qVar.get(i2)).i();
        }
    }

    public final void j() {
        l0.q qVar = this.f6554i;
        int size = qVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((w0) qVar.get(i2)).f6748k.e(-2.0f);
        }
        l0.q qVar2 = this.f6555j;
        int size2 = qVar2.size();
        for (int i10 = 0; i10 < size2; i10++) {
            ((b1) qVar2.get(i10)).j();
        }
    }

    public final void k(Object obj, Object obj2) {
        this.f6552g.e(Long.MIN_VALUE);
        q6.b bVar = this.f6546a;
        ((o1) bVar.f8788h).setValue(Boolean.FALSE);
        boolean zG = g();
        o1 o1Var = this.f6549d;
        if (!zG || !q7.k.a(c(), obj) || !q7.k.a(o1Var.getValue(), obj2)) {
            if (!q7.k.a(c(), obj)) {
                ((o1) bVar.f8787g).setValue(obj);
            }
            o1Var.setValue(obj2);
            this.f6556k.setValue(Boolean.TRUE);
            this.f6550e.setValue(new v0(obj, obj2));
        }
        l0.q qVar = this.f6555j;
        int size = qVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            b1 b1Var = (b1) qVar.get(i2);
            q7.k.c(b1Var, "null cannot be cast to non-null type androidx.compose.animation.core.Transition<kotlin.Any>");
            if (b1Var.g()) {
                b1Var.k(b1Var.c(), b1Var.f6549d.getValue());
            }
        }
        l0.q qVar2 = this.f6554i;
        int size2 = qVar2.size();
        for (int i10 = 0; i10 < size2; i10++) {
            ((w0) qVar2.get(i10)).e();
        }
    }

    public final void l(Object obj) {
        o1 o1Var = this.f6549d;
        if (q7.k.a(o1Var.getValue(), obj)) {
            return;
        }
        this.f6550e.setValue(new v0(o1Var.getValue(), obj));
        if (!q7.k.a(c(), o1Var.getValue())) {
            ((o1) this.f6546a.f8787g).setValue(o1Var.getValue());
        }
        o1Var.setValue(obj);
        b0.m1 m1Var = this.f6552g;
        if (((v2) l0.m.t(m1Var.f1241g, m1Var)).f1386c == Long.MIN_VALUE) {
            this.f6553h.setValue(Boolean.TRUE);
        }
        j();
    }

    public final String toString() {
        l0.q qVar = this.f6554i;
        int size = qVar.size();
        String str = "Transition animation values: ";
        for (int i2 = 0; i2 < size; i2++) {
            str = str + ((w0) qVar.get(i2)) + ", ";
        }
        return str;
    }
}
