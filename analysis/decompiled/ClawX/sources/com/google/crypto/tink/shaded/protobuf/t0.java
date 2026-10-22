package com.google.crypto.tink.shaded.protobuf;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class t0 implements b1 {

    /* renamed from: a, reason: collision with root package name */
    public final a f1533a;

    /* renamed from: b, reason: collision with root package name */
    public final f1 f1534b;

    /* renamed from: c, reason: collision with root package name */
    public final p f1535c;

    public t0(f1 f1Var, p pVar, a aVar) {
        this.f1534b = f1Var;
        pVar.getClass();
        this.f1535c = pVar;
        this.f1533a = aVar;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.b1
    public final void a(Object obj, Object obj2) {
        c1.w(this.f1534b, obj, obj2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.b1
    public final void b(Object obj) {
        this.f1534b.getClass();
        ((w) obj).unknownFields.f1458e = false;
        this.f1535c.getClass();
        a8.b.x(obj);
        throw null;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.b1
    public final boolean c(Object obj) {
        this.f1535c.getClass();
        a8.b.x(obj);
        throw null;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.b1
    public final Object d() {
        a aVar = this.f1533a;
        return aVar instanceof w ? ((w) aVar).q() : aVar.d().c();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.b1
    public final int e(w wVar) {
        this.f1534b.getClass();
        e1 e1Var = wVar.unknownFields;
        int i8 = e1Var.d;
        if (i8 != -1) {
            return i8;
        }
        int iS = 0;
        for (int i9 = 0; i9 < e1Var.f1455a; i9++) {
            int i10 = e1Var.f1456b[i9] >>> 3;
            iS += l.S(3, (i) e1Var.f1457c[i9]) + l.a0(i10) + l.Z(2) + (l.Z(1) * 2);
        }
        e1Var.d = iS;
        return iS;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.b1
    public final void f(Object obj, byte[] bArr, int i8, int i9, d dVar) {
        w wVar = (w) obj;
        if (wVar.unknownFields == e1.f1454f) {
            wVar.unknownFields = e1.c();
        }
        obj.getClass();
        throw new ClassCastException();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.b1
    public final boolean g(w wVar, w wVar2) {
        this.f1534b.getClass();
        return wVar.unknownFields.equals(wVar2.unknownFields);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.b1
    public final void h(Object obj, l0 l0Var) {
        this.f1535c.getClass();
        a8.b.x(obj);
        throw null;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.b1
    public final int i(w wVar) {
        this.f1534b.getClass();
        return wVar.unknownFields.hashCode();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.b1
    public final void j(Object obj, androidx.datastore.preferences.protobuf.j jVar, o oVar) {
        this.f1534b.getClass();
        f1.a(obj);
        this.f1535c.getClass();
        obj.getClass();
        throw new ClassCastException();
    }
}
