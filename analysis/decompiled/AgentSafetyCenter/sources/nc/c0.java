package nc;

import androidx.work.impl.WorkDatabase_Impl;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c0 implements g {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f8828c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ g f8829f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f8830g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ jb.b f8831h;

    public /* synthetic */ c0(int i) {
        this.f8828c = i;
    }

    @Override // nc.g
    public final Object collect(h hVar, nb.c cVar) {
        int i = this.f8828c;
        jb.v vVar = jb.v.f6774a;
        switch (i) {
            case 0:
                oc.o oVar = new oc.o(new g[]{this.f8829f, (c) this.f8830g}, d0.f8835c, new v((i9.z) this.f8831h, (nb.c) null), hVar, null);
                oc.q qVar = new oc.q(cVar, cVar.getContext());
                Object objY = ac.a.Y(qVar, qVar, oVar);
                ob.a aVar = ob.a.f9351c;
                if (objY != aVar) {
                    objY = vVar;
                }
                return objY == aVar ? objY : vVar;
            default:
                g gVar = this.f8829f;
                WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.f8830g;
                a9.e eVar = (a9.e) this.f8831h;
                s sVar = new s(1);
                sVar.f8915f = hVar;
                sVar.f8916g = workDatabase_Impl;
                sVar.f8917h = eVar;
                VarHandle.storeStoreFence();
                Object objCollect = gVar.collect(sVar, cVar);
                return objCollect == ob.a.f9351c ? objCollect : vVar;
        }
    }
}
