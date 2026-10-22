package t;

import u1.v1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e1 extends w0.l implements v1 {

    /* renamed from: s, reason: collision with root package name */
    public h1 f12967s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f12968t;

    @Override // u1.v1
    public final void f0(a2.k kVar) {
        fc.c[] cVarArr = a2.w.f144a;
        a2.x xVar = a2.u.f128m;
        fc.c[] cVarArr2 = a2.w.f144a;
        fc.c cVar = cVarArr2[6];
        kVar.d(xVar, Boolean.TRUE);
        a2.h hVar = new a2.h(new d1(this, 0), new d1(this, 1));
        if (this.f12968t) {
            a2.x xVar2 = a2.u.f136u;
            fc.c cVar2 = cVarArr2[12];
            kVar.d(xVar2, hVar);
        } else {
            a2.x xVar3 = a2.u.f135t;
            fc.c cVar3 = cVarArr2[11];
            kVar.d(xVar3, hVar);
        }
    }
}
