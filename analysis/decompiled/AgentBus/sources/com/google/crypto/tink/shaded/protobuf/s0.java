package com.google.crypto.tink.shaded.protobuf;

/* loaded from: classes.dex */
public final class s0 implements a1 {

    /* renamed from: a, reason: collision with root package name */
    public final a f2283a;

    /* renamed from: b, reason: collision with root package name */
    public final e1 f2284b;

    /* renamed from: c, reason: collision with root package name */
    public final o f2285c;

    public s0(e1 e1Var, o oVar, a aVar) {
        this.f2284b = e1Var;
        oVar.getClass();
        this.f2285c = oVar;
        this.f2283a = aVar;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.a1
    public final void a(Object obj, Object obj2) {
        b1.w(this.f2284b, obj, obj2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.a1
    public final void b(Object obj) {
        this.f2284b.getClass();
        ((v) obj).unknownFields.f2201e = false;
        this.f2285c.getClass();
        a1.a.t(obj);
        throw null;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.a1
    public final boolean c(Object obj) {
        this.f2285c.getClass();
        a1.a.t(obj);
        throw null;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.a1
    public final Object d() {
        a aVar = this.f2283a;
        return aVar instanceof v ? ((v) aVar).p() : aVar.c().b();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.a1
    public final int e(v vVar) {
        this.f2284b.getClass();
        d1 d1Var = vVar.unknownFields;
        int i2 = d1Var.f2200d;
        if (i2 != -1) {
            return i2;
        }
        int iQ = 0;
        for (int i10 = 0; i10 < d1Var.f2197a; i10++) {
            int i11 = d1Var.f2198b[i10] >>> 3;
            iQ += k.Q(3, (h) d1Var.f2199c[i10]) + k.Y(i11) + k.X(2) + (k.X(1) * 2);
        }
        d1Var.f2200d = iQ;
        return iQ;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.a1
    public final void f(Object obj, byte[] bArr, int i2, int i10, a7.e eVar) {
        v vVar = (v) obj;
        if (vVar.unknownFields == d1.f2196f) {
            vVar.unknownFields = d1.c();
        }
        obj.getClass();
        throw new ClassCastException();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.a1
    public final boolean g(v vVar, v vVar2) {
        this.f2284b.getClass();
        return vVar.unknownFields.equals(vVar2.unknownFields);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.a1
    public final void h(Object obj, k0 k0Var) {
        this.f2285c.getClass();
        a1.a.t(obj);
        throw null;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.a1
    public final int i(v vVar) {
        this.f2284b.getClass();
        return vVar.unknownFields.hashCode();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.a1
    public final void j(Object obj, androidx.datastore.preferences.protobuf.k kVar, n nVar) {
        this.f2284b.getClass();
        e1.a(obj);
        this.f2285c.getClass();
        obj.getClass();
        throw new ClassCastException();
    }
}
