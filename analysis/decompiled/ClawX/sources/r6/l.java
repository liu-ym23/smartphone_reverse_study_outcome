package r6;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.internal.platform.Platform;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class l implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final androidx.emoji2.text.p f5152a;

    /* renamed from: b, reason: collision with root package name */
    public volatile AtomicInteger f5153b = new AtomicInteger(0);

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ o f5154c;

    public l(o oVar, androidx.emoji2.text.p pVar) {
        this.f5154c = oVar;
        this.f5152a = pVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a1.w wVar;
        androidx.emoji2.text.p pVar = this.f5152a;
        b7.h hVar = (b7.h) pVar.f623b;
        StringBuilder sb = new StringBuilder("OkHttp ");
        o oVar = this.f5154c;
        n6.q qVar = oVar.f5157a;
        sb.append(oVar.f5158b.f4128a.f());
        String string = sb.toString();
        Thread threadCurrentThread = Thread.currentThread();
        String name = threadCurrentThread.getName();
        threadCurrentThread.setName(string);
        try {
            oVar.d.i();
            boolean z = false;
            try {
                try {
                } catch (Throwable th) {
                    a1.w wVar2 = qVar.f4096a;
                    wVar2.getClass();
                    a1.w.j(wVar2, null, this, 3);
                    throw th;
                }
            } catch (IOException e9) {
                e = e9;
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                pVar.q(oVar, oVar.f());
                wVar = qVar.f4096a;
            } catch (IOException e10) {
                e = e10;
                z = true;
                if (z) {
                    Platform.INSTANCE.get().log("Callback failure for " + o.a(oVar), 4, e);
                } else {
                    b7.h.c(hVar, e, null, 6);
                }
                wVar = qVar.f4096a;
                wVar.getClass();
                a1.w.j(wVar, null, this, 3);
            } catch (Throwable th3) {
                th = th3;
                z = true;
                oVar.d();
                if (!z) {
                    IOException iOException = new IOException("canceled due to " + th);
                    iOException.initCause(th);
                    b7.h.c(hVar, iOException, null, 6);
                }
                if (!(th instanceof InterruptedException)) {
                    throw th;
                }
                Thread.currentThread().interrupt();
                wVar = qVar.f4096a;
                wVar.getClass();
                a1.w.j(wVar, null, this, 3);
            }
            wVar.getClass();
            a1.w.j(wVar, null, this, 3);
        } finally {
            threadCurrentThread.setName(name);
        }
    }
}
