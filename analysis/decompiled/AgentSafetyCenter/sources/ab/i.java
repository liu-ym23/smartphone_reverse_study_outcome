package ab;

import aa.r;
import aa.t;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import y9.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class i implements a {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ float f417a;

    @Override // ab.a
    public final y9.f b(y9.f fVar) {
        float f5 = this.f417a;
        fVar.getClass();
        aa.f fVar2 = new aa.f();
        fVar2.f315c = 30.0f;
        fVar2.f317e = 0.06f;
        ArrayList arrayList = fVar.f16050b;
        y9.e eVar = new y9.e();
        eVar.f16047a = l.f16062a;
        eVar.f16048b = fVar2;
        VarHandle.storeStoreFence();
        arrayList.add(eVar);
        fVar.b(l.f16063b, new a9.d(11));
        r rVar = new r();
        rVar.f358c = 855638015;
        rVar.f359d = f5 * 6.0f;
        rVar.f360e = 0.15f;
        y9.e eVar2 = new y9.e();
        eVar2.f16047a = l.f16064c;
        eVar2.f16048b = rVar;
        VarHandle.storeStoreFence();
        arrayList.add(eVar2);
        t tVar = new t();
        tVar.f363c = 64.0f;
        tVar.f364d = 99.0f;
        tVar.f365e = 20.0f;
        tVar.f366f = 0.2f;
        y9.e eVar3 = new y9.e();
        eVar3.f16047a = l.f16065d;
        eVar3.f16048b = tVar;
        VarHandle.storeStoreFence();
        arrayList.add(eVar3);
        aa.d dVar = new aa.d();
        dVar.f310c = ac.a.E(new jb.g(0, 731486617));
        y9.e eVar4 = new y9.e();
        eVar4.f16047a = l.f16066e;
        eVar4.f16048b = dVar;
        VarHandle.storeStoreFence();
        arrayList.add(eVar4);
        return fVar;
    }
}
