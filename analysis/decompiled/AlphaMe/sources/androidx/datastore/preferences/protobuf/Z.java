package androidx.datastore.preferences.protobuf;

import d.C0527a;

/* loaded from: classes.dex */
public final class Z implements InterfaceC0262i0 {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC0247b f3459a;

    /* renamed from: b, reason: collision with root package name */
    public final r0 f3460b;

    /* renamed from: c, reason: collision with root package name */
    public final C0271s f3461c;

    public Z(r0 r0Var, C0271s c0271s, AbstractC0247b abstractC0247b) {
        this.f3460b = r0Var;
        c0271s.getClass();
        this.f3461c = c0271s;
        this.f3459a = abstractC0247b;
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC0262i0
    public final void a(Object obj, InterfaceC0260h0 interfaceC0260h0, r rVar) {
        this.f3460b.getClass();
        A a4 = (A) obj;
        if (a4.unknownFields == q0.f3526f) {
            a4.unknownFields = q0.b();
        }
        this.f3461c.getClass();
        B0.g.y(obj);
        throw null;
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC0262i0
    public final void b(Object obj, Object obj2) {
        j0.B(this.f3460b, obj, obj2);
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC0262i0
    public final void c(Object obj, C0527a c0527a) {
        this.f3461c.getClass();
        B0.g.y(obj);
        throw null;
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC0262i0
    public final void d(Object obj) {
        this.f3460b.getClass();
        ((A) obj).unknownFields.f3531e = false;
        this.f3461c.getClass();
        B0.g.y(obj);
        throw null;
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC0262i0
    public final boolean e(Object obj) {
        this.f3461c.getClass();
        B0.g.y(obj);
        throw null;
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC0262i0
    public final boolean f(Object obj, Object obj2) {
        r0 r0Var = this.f3460b;
        r0Var.getClass();
        q0 q0Var = ((A) obj).unknownFields;
        r0Var.getClass();
        return q0Var.equals(((A) obj2).unknownFields);
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC0262i0
    public final int g(Object obj) {
        this.f3460b.getClass();
        q0 q0Var = ((A) obj).unknownFields;
        int i4 = q0Var.f3530d;
        if (i4 != -1) {
            return i4;
        }
        int iL = 0;
        for (int i5 = 0; i5 < q0Var.f3527a; i5++) {
            int i6 = q0Var.f3528b[i5] >>> 3;
            iL += AbstractC0268o.l(3, (AbstractC0259h) q0Var.f3529c[i5]) + AbstractC0268o.D(2, i6) + (AbstractC0268o.C(1) * 2);
        }
        q0Var.f3530d = iL;
        return iL;
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC0262i0
    public final Object h() {
        return ((AbstractC0277y) ((A) this.f3459a).d(5)).b();
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC0262i0
    public final int i(Object obj) {
        this.f3460b.getClass();
        return ((A) obj).unknownFields.hashCode();
    }
}
