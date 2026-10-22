package androidx.datastore.preferences.protobuf;

/* loaded from: classes.dex */
class q0 extends o0<p0, p0> {
    q0() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.o0
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public p0 g(Object obj) {
        return ((AbstractC0504y) obj).unknownFields;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.o0
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public int h(p0 p0Var) {
        return p0Var.f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.o0
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public int i(p0 p0Var) {
        return p0Var.g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.o0
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public p0 k(p0 p0Var, p0 p0Var2) {
        return p0Var2.equals(p0.e()) ? p0Var : p0.k(p0Var, p0Var2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.o0
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public p0 n() {
        return p0.l();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.o0
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public void o(Object obj, p0 p0Var) {
        p(obj, p0Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.o0
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public void p(Object obj, p0 p0Var) {
        ((AbstractC0504y) obj).unknownFields = p0Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.o0
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public p0 r(p0 p0Var) {
        p0Var.j();
        return p0Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.o0
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public void s(p0 p0Var, v0 v0Var) {
        p0Var.o(v0Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.o0
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public void t(p0 p0Var, v0 v0Var) {
        p0Var.q(v0Var);
    }

    @Override // androidx.datastore.preferences.protobuf.o0
    void j(Object obj) {
        g(obj).j();
    }

    @Override // androidx.datastore.preferences.protobuf.o0
    boolean q(g0 g0Var) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.o0
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void a(p0 p0Var, int i5, int i6) {
        p0Var.n(u0.c(i5, 5), Integer.valueOf(i6));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.o0
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public void b(p0 p0Var, int i5, long j5) {
        p0Var.n(u0.c(i5, 1), Long.valueOf(j5));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.o0
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void c(p0 p0Var, int i5, p0 p0Var2) {
        p0Var.n(u0.c(i5, 3), p0Var2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.o0
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void d(p0 p0Var, int i5, AbstractC0488h abstractC0488h) {
        p0Var.n(u0.c(i5, 2), abstractC0488h);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.o0
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void e(p0 p0Var, int i5, long j5) {
        p0Var.n(u0.c(i5, 0), Long.valueOf(j5));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.o0
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public p0 f(Object obj) {
        p0 p0VarG = g(obj);
        if (p0VarG != p0.e()) {
            return p0VarG;
        }
        p0 p0VarL = p0.l();
        p(obj, p0VarL);
        return p0VarL;
    }
}
