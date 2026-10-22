package ab;

import aa.r;
import aa.t;
import aa.u;
import androidx.lifecycle.d0;
import g5.z;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import jb.v;
import t2.k;
import y9.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class h implements a, k {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f412a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f413b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f414c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f415d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f416e;

    @Override // t2.k
    public Object a(t2.j jVar) {
        Executor executor = (Executor) this.f412a;
        g5.j jVar2 = (g5.j) this.f413b;
        String str = (String) this.f414c;
        xb.a aVar = (xb.a) this.f415d;
        d0 d0Var = (d0) this.f416e;
        z zVar = new z();
        zVar.f4347c = jVar2;
        zVar.f4348f = str;
        zVar.f4349g = aVar;
        zVar.f4350h = d0Var;
        zVar.i = jVar;
        VarHandle.storeStoreFence();
        executor.execute(zVar);
        return v.f6774a;
    }

    @Override // ab.a
    public y9.f b(y9.f fVar) {
        aa.f fVar2 = (aa.f) this.f412a;
        u uVar = (u) this.f413b;
        r rVar = (r) this.f414c;
        t tVar = (t) this.f415d;
        aa.d dVar = (aa.d) this.f416e;
        fVar.getClass();
        f7.f fVar3 = l.f16062a;
        y9.j jVarO = fVar3.o();
        aa.f fVar4 = (aa.f) jVarO;
        fVar4.f315c = fVar2.f315c;
        fVar4.f316d = fVar2.f316d;
        fVar4.f317e = fVar2.f317e;
        ArrayList arrayList = fVar.f16050b;
        y9.e eVar = new y9.e();
        eVar.f16047a = fVar3;
        eVar.f16048b = jVarO;
        VarHandle.storeStoreFence();
        arrayList.add(eVar);
        aa.c cVar = new aa.c(2);
        cVar.f309f = uVar;
        VarHandle.storeStoreFence();
        fVar.b(l.f16063b, cVar);
        f7.f fVar5 = l.f16064c;
        y9.j jVarO2 = fVar5.o();
        r rVar2 = (r) jVarO2;
        rVar2.f358c = rVar.f358c;
        rVar2.f359d = rVar.f359d;
        rVar2.f360e = rVar.f360e;
        y9.e eVar2 = new y9.e();
        eVar2.f16047a = fVar5;
        eVar2.f16048b = jVarO2;
        VarHandle.storeStoreFence();
        arrayList.add(eVar2);
        t tVar2 = new t();
        tVar2.f363c = tVar.f363c;
        tVar2.f364d = tVar.f364d;
        tVar2.f365e = tVar.f365e;
        tVar2.f366f = tVar.f366f;
        y9.e eVar3 = new y9.e();
        eVar3.f16047a = l.f16065d;
        eVar3.f16048b = tVar2;
        VarHandle.storeStoreFence();
        arrayList.add(eVar3);
        aa.d dVar2 = new aa.d();
        dVar2.f310c = dVar.f310c;
        y9.e eVar4 = new y9.e();
        eVar4.f16047a = l.f16066e;
        eVar4.f16048b = dVar2;
        VarHandle.storeStoreFence();
        arrayList.add(eVar4);
        return fVar;
    }
}
