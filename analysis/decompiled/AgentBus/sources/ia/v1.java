package ia;

/* loaded from: classes.dex */
public final class v1 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f5013f = 0;

    /* renamed from: g, reason: collision with root package name */
    public Object f5014g;

    /* renamed from: h, reason: collision with root package name */
    public final Object f5015h;

    public v1(na.h hVar, Runnable runnable) {
        this.f5015h = hVar;
        this.f5014g = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5013f) {
            case 0:
                ((m) this.f5015h).D((z0) this.f5014g);
                return;
            default:
                int i2 = 0;
                while (true) {
                    try {
                        ((Runnable) this.f5014g).run();
                    } catch (Throwable th) {
                        d0.n(g7.m.f3866f, th);
                    }
                    Runnable runnableU = ((na.h) this.f5015h).U();
                    if (runnableU == null) {
                        return;
                    }
                    try {
                        this.f5014g = runnableU;
                        i2++;
                        if (i2 >= 16) {
                            na.h hVar = (na.h) this.f5015h;
                            if (na.b.j(hVar.f6906i, hVar)) {
                                na.h hVar2 = (na.h) this.f5015h;
                                na.b.i(hVar2.f6906i, hVar2, this);
                                return;
                            }
                        }
                    } catch (Throwable th2) {
                        na.h hVar3 = (na.h) this.f5015h;
                        synchronized (hVar3.f6909l) {
                            na.h.f6904m.decrementAndGet(hVar3);
                            throw th2;
                        }
                    }
                }
        }
    }

    public v1(z0 z0Var, m mVar) {
        this.f5014g = z0Var;
        this.f5015h = mVar;
    }
}
