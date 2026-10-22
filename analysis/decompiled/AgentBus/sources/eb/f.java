package eb;

import ab.t;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class f implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    public final ab.d f3267f;

    /* renamed from: g, reason: collision with root package name */
    public volatile AtomicInteger f3268g = new AtomicInteger(0);

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ i f3269h;

    public f(i iVar, ab.d dVar) {
        this.f3269h = iVar;
        this.f3267f = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        t tVar;
        String strConcat = "OkHttp ".concat(this.f3269h.f3273g.f661a.f());
        i iVar = this.f3269h;
        Thread threadCurrentThread = Thread.currentThread();
        String name = threadCurrentThread.getName();
        threadCurrentThread.setName(strConcat);
        try {
            iVar.f3276j.i();
            boolean z4 = false;
            try {
                try {
                } catch (Throwable th) {
                    iVar.f3272f.f627f.H(this);
                    throw th;
                }
            } catch (IOException e10) {
                e = e10;
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.f3267f.l(iVar, iVar.i());
                tVar = iVar.f3272f;
            } catch (IOException e11) {
                e = e11;
                z4 = true;
                if (z4) {
                    ib.m mVar = ib.m.f5049a;
                    ib.m mVar2 = ib.m.f5049a;
                    String str = "Callback failure for " + i.a(iVar);
                    mVar2.getClass();
                    ib.m.g(4, str, e);
                } else {
                    this.f3267f.b(iVar, e);
                }
                tVar = iVar.f3272f;
                tVar.f627f.H(this);
            } catch (Throwable th3) {
                th = th3;
                z4 = true;
                iVar.e();
                if (!z4) {
                    IOException iOException = new IOException("canceled due to " + th);
                    ib.k.e(iOException, th);
                    this.f3267f.b(iVar, iOException);
                }
                throw th;
            }
            tVar.f627f.H(this);
        } finally {
            threadCurrentThread.setName(name);
        }
    }
}
