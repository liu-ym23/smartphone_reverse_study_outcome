package tc;

import java.util.Iterator;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class o<Element, Collection, Builder> extends a<Element, Collection, Builder> {

    /* renamed from: a, reason: collision with root package name */
    public final pc.a<Element> f13022a;

    public o(pc.a aVar) {
        this.f13022a = aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // pc.c
    public void a(vc.k kVar, Object obj) {
        int iH = h(obj);
        rc.e eVarD = d();
        sc.c cVarC = kVar.C(eVarD);
        Iterator<Element> itG = g(obj);
        for (int i10 = 0; i10 < iH; i10++) {
            cVarC.g(d(), i10, this.f13022a, itG.next());
        }
        cVarC.a(eVarD);
    }

    @Override // tc.a
    public void j(sc.b bVar, int i10, Object obj) {
        m(i10, obj, bVar.c(d(), i10, this.f13022a, null));
    }

    public abstract void m(int i10, Object obj, Object obj2);
}
