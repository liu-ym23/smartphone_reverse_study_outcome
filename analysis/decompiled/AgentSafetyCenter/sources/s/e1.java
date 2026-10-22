package s;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e1 {

    /* renamed from: a, reason: collision with root package name */
    public final p5.u f10989a;

    /* renamed from: b, reason: collision with root package name */
    public final e1 f10990b;

    /* renamed from: c, reason: collision with root package name */
    public final String f10991c;

    /* renamed from: d, reason: collision with root package name */
    public final k0.k1 f10992d = k0.z.v(c());

    /* renamed from: e, reason: collision with root package name */
    public final k0.k1 f10993e = k0.z.v(new a1(c(), c()));

    /* renamed from: f, reason: collision with root package name */
    public final k0.i1 f10994f = new k0.i1(0);

    /* renamed from: g, reason: collision with root package name */
    public final k0.i1 f10995g = new k0.i1(Long.MIN_VALUE);

    /* renamed from: h, reason: collision with root package name */
    public final k0.k1 f10996h;
    public final u0.q i;

    /* renamed from: j, reason: collision with root package name */
    public final u0.q f10997j;

    /* renamed from: k, reason: collision with root package name */
    public final k0.k1 f10998k;

    public e1(p5.u uVar, e1 e1Var, String str) {
        this.f10989a = uVar;
        this.f10990b = e1Var;
        this.f10991c = str;
        Boolean bool = Boolean.FALSE;
        this.f10996h = k0.z.v(bool);
        this.i = new u0.q();
        this.f10997j = new u0.q();
        this.f10998k = k0.z.v(bool);
        k0.z.q(new r.q(this, 1));
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(java.lang.Object r10, k0.s r11, int r12) {
        /*
            Method dump skipped, instructions count: 232
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s.e1.a(java.lang.Object, k0.s, int):void");
    }

    public final long b() {
        u0.q qVar = this.i;
        int size = qVar.size();
        long jMax = 0;
        for (int i = 0; i < size; i++) {
            jMax = Math.max(jMax, ((b1) qVar.get(i)).f10953n.g());
        }
        u0.q qVar2 = this.f10997j;
        int size2 = qVar2.size();
        for (int i3 = 0; i3 < size2; i3++) {
            jMax = Math.max(jMax, ((e1) qVar2.get(i3)).b());
        }
        return jMax;
    }

    public final Object c() {
        return ((k0.k1) this.f10989a.f9808g).getValue();
    }

    public final boolean d() {
        u0.q qVar = this.i;
        int size = qVar.size();
        for (int i = 0; i < size; i++) {
            ((b1) qVar.get(i)).getClass();
        }
        u0.q qVar2 = this.f10997j;
        int size2 = qVar2.size();
        for (int i3 = 0; i3 < size2; i3++) {
            if (((e1) qVar2.get(i3)).d()) {
                return true;
            }
        }
        return false;
    }

    public final long e() {
        e1 e1Var = this.f10990b;
        return e1Var != null ? e1Var.e() : this.f10994f.g();
    }

    public final z0 f() {
        return (z0) this.f10993e.getValue();
    }

    public final boolean g() {
        return ((Boolean) this.f10998k.getValue()).booleanValue();
    }

    public final void h(long j10, boolean z10) {
        p5.u uVar = this.f10989a;
        k0.k1 k1Var = (k0.k1) uVar.f9807f;
        k0.i1 i1Var = this.f10995g;
        if (i1Var.g() == Long.MIN_VALUE) {
            i1Var.h(j10);
            ((k0.k1) uVar.f9807f).setValue(Boolean.TRUE);
        } else if (!((Boolean) k1Var.getValue()).booleanValue()) {
            k1Var.setValue(Boolean.TRUE);
        }
        this.f10996h.setValue(Boolean.FALSE);
        u0.q qVar = this.i;
        int size = qVar.size();
        boolean z11 = true;
        for (int i = 0; i < size; i++) {
            b1 b1Var = (b1) qVar.get(i);
            k0.k1 k1Var2 = b1Var.i;
            k0.k1 k1Var3 = b1Var.i;
            if (!((Boolean) k1Var2.getValue()).booleanValue()) {
                long jB = z10 ? b1Var.a().b() : j10;
                b1Var.f10951l.setValue(b1Var.a().f(jB));
                b1Var.f10952m = b1Var.a().d(jB);
                if (b1Var.a().e(jB)) {
                    k1Var3.setValue(Boolean.TRUE);
                }
            }
            if (!((Boolean) k1Var3.getValue()).booleanValue()) {
                z11 = false;
            }
        }
        u0.q qVar2 = this.f10997j;
        int size2 = qVar2.size();
        for (int i3 = 0; i3 < size2; i3++) {
            e1 e1Var = (e1) qVar2.get(i3);
            if (!yb.k.a(e1Var.f10992d.getValue(), e1Var.c())) {
                e1Var.h(j10, z10);
            }
            if (!yb.k.a(e1Var.f10992d.getValue(), e1Var.c())) {
                z11 = false;
            }
        }
        if (z11) {
            i();
        }
    }

    public final void i() {
        this.f10995g.h(Long.MIN_VALUE);
        Object value = this.f10992d.getValue();
        p5.u uVar = this.f10989a;
        ((k0.k1) uVar.f9808g).setValue(value);
        if (this.f10990b == null) {
            this.f10994f.h(0L);
        }
        ((k0.k1) uVar.f9807f).setValue(Boolean.FALSE);
        u0.q qVar = this.f10997j;
        int size = qVar.size();
        for (int i = 0; i < size; i++) {
            ((e1) qVar.get(i)).i();
        }
    }

    public final void j() {
        u0.q qVar = this.i;
        int size = qVar.size();
        for (int i = 0; i < size; i++) {
            ((b1) qVar.get(i)).f10949j.h(-2.0f);
        }
        u0.q qVar2 = this.f10997j;
        int size2 = qVar2.size();
        for (int i3 = 0; i3 < size2; i3++) {
            ((e1) qVar2.get(i3)).j();
        }
    }

    public final void k(Object obj, Object obj2) {
        this.f10995g.h(Long.MIN_VALUE);
        p5.u uVar = this.f10989a;
        ((k0.k1) uVar.f9807f).setValue(Boolean.FALSE);
        boolean zG = g();
        k0.k1 k1Var = this.f10992d;
        if (!zG || !yb.k.a(c(), obj) || !yb.k.a(k1Var.getValue(), obj2)) {
            if (!yb.k.a(c(), obj)) {
                ((k0.k1) uVar.f9808g).setValue(obj);
            }
            k1Var.setValue(obj2);
            this.f10998k.setValue(Boolean.TRUE);
            this.f10993e.setValue(new a1(obj, obj2));
        }
        u0.q qVar = this.f10997j;
        int size = qVar.size();
        for (int i = 0; i < size; i++) {
            e1 e1Var = (e1) qVar.get(i);
            e1Var.getClass();
            if (e1Var.g()) {
                e1Var.k(e1Var.c(), e1Var.f10992d.getValue());
            }
        }
        u0.q qVar2 = this.i;
        int size2 = qVar2.size();
        for (int i3 = 0; i3 < size2; i3++) {
            ((b1) qVar2.get(i3)).d();
        }
    }

    public final void l(Object obj) {
        k0.k1 k1Var = this.f10992d;
        if (yb.k.a(k1Var.getValue(), obj)) {
            return;
        }
        this.f10993e.setValue(new a1(k1Var.getValue(), obj));
        if (!yb.k.a(c(), k1Var.getValue())) {
            ((k0.k1) this.f10989a.f9808g).setValue(k1Var.getValue());
        }
        k1Var.setValue(obj);
        if (this.f10995g.g() == Long.MIN_VALUE) {
            this.f10996h.setValue(Boolean.TRUE);
        }
        j();
    }

    public final String toString() {
        u0.q qVar = this.i;
        int size = qVar.size();
        String str = "Transition animation values: ";
        for (int i = 0; i < size; i++) {
            str = str + ((b1) qVar.get(i)) + ", ";
        }
        return str;
    }
}
