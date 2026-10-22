package J9;

import F9.C0238p;
import F9.F;
import F9.InterfaceC0229g;
import N9.m;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public final class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0229g f895a;
    public volatile AtomicInteger b = new AtomicInteger(0);
    public final /* synthetic */ i c;

    public f(i iVar, InterfaceC0229g interfaceC0229g) {
        this.c = iVar;
        this.f895a = interfaceC0229g;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0238p c0238p;
        InterfaceC0229g interfaceC0229g = this.f895a;
        i iVar = this.c;
        F f = iVar.f897a;
        String strConcat = "OkHttp ".concat(iVar.b.f626a.h());
        Thread threadCurrentThread = Thread.currentThread();
        String name = threadCurrentThread.getName();
        threadCurrentThread.setName(strConcat);
        try {
            iVar.e.h();
            boolean z10 = false;
            try {
                try {
                } catch (Throwable th) {
                    f.f616a.d(this);
                    throw th;
                }
            } catch (IOException e) {
                e = e;
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                interfaceC0229g.k(iVar, iVar.f());
                c0238p = f.f616a;
            } catch (IOException e6) {
                e = e6;
                z10 = true;
                if (z10) {
                    m.Companion.getClass();
                    m mVar = m.platform;
                    StringBuilder sb = new StringBuilder("Callback failure for ");
                    StringBuilder sb2 = new StringBuilder();
                    androidx.compose.foundation.b.C(sb2, iVar.o ? "canceled " : "", "call", " to ");
                    sb2.append(iVar.b.f626a.h());
                    sb.append(sb2.toString());
                    mVar.log(sb.toString(), 4, e);
                } else {
                    interfaceC0229g.j(iVar, e);
                }
                c0238p = f.f616a;
                c0238p.d(this);
            } catch (Throwable th3) {
                th = th3;
                z10 = true;
                iVar.cancel();
                if (!z10) {
                    IOException iOException = new IOException("canceled due to " + th);
                    S0.b.e0(iOException, th);
                    interfaceC0229g.j(iVar, iOException);
                }
                throw th;
            }
            c0238p.d(this);
        } finally {
            threadCurrentThread.setName(name);
        }
    }
}
