package androidx.datastore.preferences.protobuf;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class n0 implements u0 {

    /* renamed from: a, reason: collision with root package name */
    public final a f531a;

    /* renamed from: b, reason: collision with root package name */
    public final c1 f532b;

    /* renamed from: c, reason: collision with root package name */
    public final o f533c;

    public n0(c1 c1Var, o oVar, a aVar) {
        this.f532b = c1Var;
        oVar.getClass();
        this.f533c = oVar;
        this.f531a = aVar;
    }

    @Override // androidx.datastore.preferences.protobuf.u0
    public final void a(Object obj, Object obj2) {
        v0.k(this.f532b, obj, obj2);
    }

    @Override // androidx.datastore.preferences.protobuf.u0
    public final void b(Object obj) {
        this.f532b.getClass();
        b1 b1Var = ((v) obj).unknownFields;
        if (b1Var.f455e) {
            b1Var.f455e = false;
        }
        this.f533c.getClass();
        a8.b.x(obj);
        throw null;
    }

    @Override // androidx.datastore.preferences.protobuf.u0
    public final boolean c(Object obj) {
        this.f533c.getClass();
        a8.b.x(obj);
        throw null;
    }

    @Override // androidx.datastore.preferences.protobuf.u0
    public final v d() {
        a aVar = this.f531a;
        return aVar instanceof v ? ((v) aVar).i() : ((t) ((v) aVar).c(5)).b();
    }

    @Override // androidx.datastore.preferences.protobuf.u0
    public final void e(Object obj, e0 e0Var) {
        this.f533c.getClass();
        a8.b.x(obj);
        throw null;
    }

    @Override // androidx.datastore.preferences.protobuf.u0
    public final int f(v vVar) {
        this.f532b.getClass();
        return vVar.unknownFields.hashCode();
    }

    @Override // androidx.datastore.preferences.protobuf.u0
    public final boolean g(v vVar, v vVar2) {
        this.f532b.getClass();
        return vVar.unknownFields.equals(vVar2.unknownFields);
    }

    @Override // androidx.datastore.preferences.protobuf.u0
    public final void h(Object obj, j jVar, n nVar) {
        this.f532b.getClass();
        c1.a(obj);
        this.f533c.getClass();
        obj.getClass();
        throw new ClassCastException();
    }

    @Override // androidx.datastore.preferences.protobuf.u0
    public final int i(v vVar) {
        this.f532b.getClass();
        b1 b1Var = vVar.unknownFields;
        int i8 = b1Var.d;
        if (i8 != -1) {
            return i8;
        }
        int iO0 = 0;
        for (int i9 = 0; i9 < b1Var.f452a; i9++) {
            int i10 = b1Var.f453b[i9] >>> 3;
            iO0 += l.o0(3, (g) b1Var.f454c[i9]) + l.r0(i10) + l.q0(2) + (l.q0(1) * 2);
        }
        b1Var.d = iO0;
        return iO0;
    }
}
