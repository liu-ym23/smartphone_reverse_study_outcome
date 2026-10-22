package Z7;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

/* loaded from: classes4.dex */
public final class B extends Thread {

    /* renamed from: e, reason: collision with root package name */
    public A f7310e;

    /* renamed from: a, reason: collision with root package name */
    public boolean f7306a = false;

    /* renamed from: b, reason: collision with root package name */
    public boolean f7307b = true;

    /* renamed from: c, reason: collision with root package name */
    public boolean f7308c = false;

    /* renamed from: d, reason: collision with root package name */
    public int f7309d = 1;

    /* renamed from: f, reason: collision with root package name */
    public boolean f7311f = true;

    public final synchronized void a(A a10) {
        if (this.f7307b) {
            return;
        }
        if (this.f7308c && !a10.a()) {
            C1139k.h("Restart getting main stack trace.", new Object[0]);
            this.f7307b = true;
            this.f7308c = false;
        }
    }

    public final boolean b() {
        this.f7306a = true;
        if (!isAlive()) {
            return false;
        }
        try {
            interrupt();
        } catch (Exception e10) {
            C1139k.g(e10);
        }
        C1139k.i("MainHandlerChecker is reset to null.", new Object[0]);
        this.f7310e = null;
        return true;
    }

    public final boolean c() {
        Handler handler = new Handler(Looper.getMainLooper());
        A a10 = this.f7310e;
        if (a10 != null) {
            a10.f7302d = 5000L;
        } else {
            this.f7310e = new A(handler, handler.getLooper().getThread().getName());
        }
        if (isAlive()) {
            return false;
        }
        try {
            start();
            return true;
        } catch (Exception e10) {
            C1139k.g(e10);
            return false;
        }
    }

    public final synchronized void d() {
        this.f7307b = false;
        C1139k.h("Record stack trace is disabled.", new Object[0]);
    }

    public final synchronized void e() {
        this.f7308c = true;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        A a10;
        boolean z10;
        long jCurrentTimeMillis = System.currentTimeMillis();
        while (!this.f7306a) {
            try {
                a10 = this.f7310e;
                z10 = false;
            } catch (Exception e10) {
                C1139k.g(e10);
            } catch (OutOfMemoryError e11) {
                C1139k.g(e11);
            }
            if (a10 == null) {
                C1139k.h("Main handler checker is null. Stop thread monitor.", new Object[0]);
                return;
            }
            if (a10.f7304f) {
                a10.f7304f = false;
                a10.f7305g = SystemClock.uptimeMillis();
                a10.f7299a.post(a10);
            }
            a(a10);
            if (this.f7311f && this.f7307b) {
                long jB = a10.b();
                if (jB > 1510 && jB < 199990) {
                    boolean z11 = true;
                    if (jB <= 5010) {
                        this.f7309d = 1;
                        C1139k.h("timeSinceMsgSent in [2s, 5s], record stack", new Object[0]);
                    } else {
                        int i10 = this.f7309d;
                        int i11 = i10 + 1;
                        this.f7309d = i11;
                        if ((i10 & i11) != 0) {
                            z11 = false;
                        }
                        if (z11) {
                            C1139k.h("timeSinceMsgSent in (5s, 200s), should record stack:true", new Object[0]);
                        }
                    }
                    z10 = z11;
                }
            }
            if (z10) {
                a10.d();
            }
            C1143o.C(500 - ((System.currentTimeMillis() - jCurrentTimeMillis) % 500));
        }
    }
}
