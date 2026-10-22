package androidx.datastore.preferences.protobuf;

import java.io.IOException;

/* loaded from: classes.dex */
public class h0 extends f0<g0, g0> {
    @Override // androidx.datastore.preferences.protobuf.f0
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public g0 g(Object obj) {
        return ((GeneratedMessageLite) obj).unknownFields;
    }

    @Override // androidx.datastore.preferences.protobuf.f0
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public int h(g0 g0Var) {
        return g0Var.f();
    }

    @Override // androidx.datastore.preferences.protobuf.f0
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public int i(g0 g0Var) {
        return g0Var.g();
    }

    @Override // androidx.datastore.preferences.protobuf.f0
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public g0 k(g0 g0Var, g0 g0Var2) {
        return g0Var2.equals(g0.e()) ? g0Var : g0.k(g0Var, g0Var2);
    }

    @Override // androidx.datastore.preferences.protobuf.f0
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public g0 n() {
        return g0.l();
    }

    @Override // androidx.datastore.preferences.protobuf.f0
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public void o(Object obj, g0 g0Var) {
        p(obj, g0Var);
    }

    @Override // androidx.datastore.preferences.protobuf.f0
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public void p(Object obj, g0 g0Var) {
        ((GeneratedMessageLite) obj).unknownFields = g0Var;
    }

    @Override // androidx.datastore.preferences.protobuf.f0
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public g0 r(g0 g0Var) {
        g0Var.j();
        return g0Var;
    }

    @Override // androidx.datastore.preferences.protobuf.f0
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public void s(g0 g0Var, Writer writer) throws IOException {
        g0Var.o(writer);
    }

    @Override // androidx.datastore.preferences.protobuf.f0
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public void t(g0 g0Var, Writer writer) throws IOException {
        g0Var.q(writer);
    }

    @Override // androidx.datastore.preferences.protobuf.f0
    public void j(Object obj) {
        g(obj).j();
    }

    @Override // androidx.datastore.preferences.protobuf.f0
    public boolean q(Y y10) {
        return false;
    }

    @Override // androidx.datastore.preferences.protobuf.f0
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void a(g0 g0Var, int i10, int i11) {
        g0Var.n(WireFormat.c(i10, 5), Integer.valueOf(i11));
    }

    @Override // androidx.datastore.preferences.protobuf.f0
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public void b(g0 g0Var, int i10, long j10) {
        g0Var.n(WireFormat.c(i10, 1), Long.valueOf(j10));
    }

    @Override // androidx.datastore.preferences.protobuf.f0
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void c(g0 g0Var, int i10, g0 g0Var2) {
        g0Var.n(WireFormat.c(i10, 3), g0Var2);
    }

    @Override // androidx.datastore.preferences.protobuf.f0
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void d(g0 g0Var, int i10, ByteString byteString) {
        g0Var.n(WireFormat.c(i10, 2), byteString);
    }

    @Override // androidx.datastore.preferences.protobuf.f0
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void e(g0 g0Var, int i10, long j10) {
        g0Var.n(WireFormat.c(i10, 0), Long.valueOf(j10));
    }

    @Override // androidx.datastore.preferences.protobuf.f0
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public g0 f(Object obj) {
        g0 g0VarG = g(obj);
        if (g0VarG != g0.e()) {
            return g0VarG;
        }
        g0 g0VarL = g0.l();
        p(obj, g0VarL);
        return g0VarL;
    }
}
