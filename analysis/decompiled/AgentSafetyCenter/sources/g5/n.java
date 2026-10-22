package g5;

import java.lang.invoke.VarHandle;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class n implements t2.k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4331a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Executor f4332b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ yb.l f4333c;

    public /* synthetic */ n(int i) {
        this.f4331a = i;
    }

    @Override // t2.k
    public final Object a(t2.j jVar) {
        int i = this.f4331a;
        k kVar = k.f4325c;
        switch (i) {
            case 0:
                Executor executor = this.f4332b;
                a1.b bVar = (a1.b) this.f4333c;
                AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                o oVar = new o(0);
                oVar.f4335f = atomicBoolean;
                VarHandle.storeStoreFence();
                t2.n nVar = jVar.f13161c;
                if (nVar != null) {
                    nVar.b(oVar, kVar);
                }
                a4.l lVar = new a4.l(2);
                lVar.f185f = atomicBoolean;
                lVar.f186g = jVar;
                lVar.f187h = bVar;
                VarHandle.storeStoreFence();
                executor.execute(lVar);
                return "loadStatusFuture";
            default:
                ExecutorService executorService = (ExecutorService) this.f4332b;
                ad.l lVar2 = (ad.l) this.f4333c;
                AtomicBoolean atomicBoolean2 = new AtomicBoolean(false);
                o oVar2 = new o(1);
                oVar2.f4335f = atomicBoolean2;
                VarHandle.storeStoreFence();
                t2.n nVar2 = jVar.f13161c;
                if (nVar2 != null) {
                    nVar2.b(oVar2, kVar);
                }
                a4.l lVar3 = new a4.l(3);
                lVar3.f185f = atomicBoolean2;
                lVar3.f186g = jVar;
                lVar3.f187h = lVar2;
                VarHandle.storeStoreFence();
                executorService.execute(lVar3);
                return jb.v.f6774a;
        }
    }
}
