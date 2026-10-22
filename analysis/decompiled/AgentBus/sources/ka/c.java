package ka;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/* loaded from: classes.dex */
public final /* synthetic */ class c extends q7.i implements p7.o {

    /* renamed from: n, reason: collision with root package name */
    public static final c f5669n = new c(3, g.class, "registerSelectForReceive", "registerSelectForReceive(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);

    @Override // p7.o
    public final Object j(Object obj, Object obj2, Object obj3) {
        o oVar;
        g gVar = (g) obj;
        if (obj2 != null) {
            throw new ClassCastException();
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater = g.f5677g;
        gVar.getClass();
        o oVar2 = (o) g.f5682l.get(gVar);
        while (!gVar.x()) {
            long andIncrement = g.f5678h.getAndIncrement(gVar);
            long j2 = i.f5689b;
            long j4 = andIncrement / j2;
            int i2 = (int) (andIncrement % j2);
            if (oVar2.f6927c != j4) {
                o oVarN = gVar.n(j4, oVar2);
                if (oVarN == null) {
                    continue;
                } else {
                    oVar = oVarN;
                }
            } else {
                oVar = oVar2;
            }
            Object objI = gVar.I(oVar, i2, andIncrement, null);
            if (objI == i.f5700m) {
                return c7.r.f1986a;
            }
            if (objI != i.f5702o) {
                if (objI == i.f5701n) {
                    throw new IllegalStateException("unexpected");
                }
                oVar.b();
                throw null;
            }
            if (andIncrement < gVar.s()) {
                oVar.b();
            }
            oVar2 = oVar;
        }
        o oVar3 = i.f5688a;
        throw null;
    }
}
