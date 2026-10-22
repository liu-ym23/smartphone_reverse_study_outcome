package androidx.datastore.preferences.protobuf;

/* loaded from: classes.dex */
public final class r0 implements z0 {

    /* renamed from: a, reason: collision with root package name */
    public final a f938a;

    /* renamed from: b, reason: collision with root package name */
    public final k1 f939b;

    /* renamed from: c, reason: collision with root package name */
    public final p f940c;

    public r0(k1 k1Var, p pVar, a aVar) {
        this.f939b = k1Var;
        pVar.getClass();
        this.f940c = pVar;
        this.f938a = aVar;
    }

    @Override // androidx.datastore.preferences.protobuf.z0
    public final void a(Object obj, Object obj2) {
        a1.x(this.f939b, obj, obj2);
    }

    @Override // androidx.datastore.preferences.protobuf.z0
    public final void b(Object obj) {
        this.f939b.getClass();
        ((w) obj).unknownFields.f891e = false;
        this.f940c.getClass();
        a1.a.t(obj);
        throw null;
    }

    @Override // androidx.datastore.preferences.protobuf.z0
    public final boolean c(Object obj) {
        this.f940c.getClass();
        a1.a.t(obj);
        throw null;
    }

    @Override // androidx.datastore.preferences.protobuf.z0
    public final w d() {
        a aVar = this.f938a;
        return aVar instanceof w ? ((w) aVar).i() : ((u) ((w) aVar).c(5)).b();
    }

    @Override // androidx.datastore.preferences.protobuf.z0
    public final void e(Object obj, i0 i0Var) {
        this.f940c.getClass();
        a1.a.t(obj);
        throw null;
    }

    @Override // androidx.datastore.preferences.protobuf.z0
    public final int f(w wVar) {
        this.f939b.getClass();
        return wVar.unknownFields.hashCode();
    }

    @Override // androidx.datastore.preferences.protobuf.z0
    public final boolean g(w wVar, w wVar2) {
        this.f939b.getClass();
        return wVar.unknownFields.equals(wVar2.unknownFields);
    }

    @Override // androidx.datastore.preferences.protobuf.z0
    public final void h(Object obj, k kVar, o oVar) {
        this.f939b.getClass();
        k1.a(obj);
        this.f940c.getClass();
        obj.getClass();
        throw new ClassCastException();
    }

    @Override // androidx.datastore.preferences.protobuf.z0
    public final int i(w wVar) {
        this.f939b.getClass();
        j1 j1Var = wVar.unknownFields;
        int i2 = j1Var.f890d;
        if (i2 != -1) {
            return i2;
        }
        int iL = 0;
        for (int i10 = 0; i10 < j1Var.f887a; i10++) {
            int i11 = j1Var.f888b[i10] >>> 3;
            iL += m.l(3, (g) j1Var.f889c[i10]) + m.t(i11) + m.s(2) + (m.s(1) * 2);
        }
        j1Var.f890d = iL;
        return iL;
    }
}
