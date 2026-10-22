package androidx.datastore.preferences.protobuf;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class o0 implements w0 {

    /* renamed from: a, reason: collision with root package name */
    public a f1174a;

    /* renamed from: b, reason: collision with root package name */
    public e1 f1175b;

    /* renamed from: c, reason: collision with root package name */
    public o f1176c;

    @Override // androidx.datastore.preferences.protobuf.w0
    public final void a(Object obj, f0 f0Var) {
        this.f1176c.getClass();
        w2.c.d(obj);
        throw null;
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public final int b(v vVar) {
        this.f1175b.getClass();
        d1 d1Var = vVar.unknownFields;
        int i = d1Var.f1101d;
        if (i != -1) {
            return i;
        }
        int iF = 0;
        for (int i3 = 0; i3 < d1Var.f1098a; i3++) {
            int i10 = d1Var.f1099b[i3] >>> 3;
            iF += l.f(3, (f) d1Var.f1100c[i3]) + l.i(i10) + l.h(2) + (l.h(1) * 2);
        }
        d1Var.f1101d = iF;
        return iF;
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public final int c(v vVar) {
        this.f1175b.getClass();
        return vVar.unknownFields.hashCode();
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public final boolean d(v vVar, v vVar2) {
        this.f1175b.getClass();
        return vVar.unknownFields.equals(vVar2.unknownFields);
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public final void e(Object obj, j jVar, n nVar) {
        e1 e1Var = this.f1175b;
        o oVar = this.f1176c;
        e1Var.getClass();
        e1.a(obj);
        oVar.getClass();
        obj.getClass();
        throw new ClassCastException();
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public final boolean isInitialized(Object obj) {
        this.f1176c.getClass();
        w2.c.d(obj);
        throw null;
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public final void makeImmutable(Object obj) {
        this.f1175b.getClass();
        d1 d1Var = ((v) obj).unknownFields;
        if (d1Var.f1102e) {
            d1Var.f1102e = false;
        }
        this.f1176c.getClass();
        w2.c.d(obj);
        throw null;
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public final void mergeFrom(Object obj, Object obj2) {
        x0.k(this.f1175b, obj, obj2);
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public final v newInstance() {
        a aVar = this.f1174a;
        return aVar instanceof v ? ((v) aVar).j() : ((t) ((v) aVar).c(5)).b();
    }
}
