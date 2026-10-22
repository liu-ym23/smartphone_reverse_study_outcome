package ed;

import ad.q;
import ad.w;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public ad.d f3796c;

    /* renamed from: f, reason: collision with root package name */
    public volatile AtomicInteger f3797f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ j f3798g;

    @Override // java.lang.Runnable
    public final void run() {
        ad.d dVar = this.f3796c;
        j jVar = this.f3798g;
        w wVar = jVar.f3801c;
        String strConcat = "OkHttp ".concat(((q) jVar.f3802f.f637b).f());
        Thread threadCurrentThread = Thread.currentThread();
        String name = threadCurrentThread.getName();
        threadCurrentThread.setName(strConcat);
        try {
            jVar.f3804h.h();
            boolean z10 = false;
            try {
                try {
                } catch (Throwable th) {
                    wVar.f603c.u(this);
                    throw th;
                }
            } catch (IOException e10) {
                e = e10;
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                dVar.e(jVar.h());
            } catch (IOException e11) {
                e = e11;
                z10 = true;
                if (z10) {
                    id.n.Companion.getClass();
                    id.n.platform.log("Callback failure for ".concat(j.a(jVar)), 4, e);
                } else {
                    dVar.a(jVar, e);
                }
                wVar.f603c.u(this);
            } catch (Throwable th3) {
                th = th3;
                z10 = true;
                jVar.cancel();
                if (!z10) {
                    IOException iOException = new IOException("canceled due to " + th);
                    com.stepos.statsrpk.h.b(iOException, th);
                    dVar.a(jVar, iOException);
                }
                throw th;
            }
            wVar.f603c.u(this);
        } finally {
            threadCurrentThread.setName(name);
        }
    }
}
