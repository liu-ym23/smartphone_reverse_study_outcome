package org.libpag;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

/* loaded from: classes5.dex */
class d extends Handler {

    public static final class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final b f37915a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f37916b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f37917c = false;

        public a(b bVar) {
            this.f37915a = bVar;
        }

        public boolean a(Handler handler, long j10) {
            if (!handler.post(this)) {
                return false;
            }
            synchronized (this) {
                if (j10 > 0) {
                    long jUptimeMillis = SystemClock.uptimeMillis() + j10;
                    while (!this.f37916b) {
                        long jUptimeMillis2 = jUptimeMillis - SystemClock.uptimeMillis();
                        if (jUptimeMillis2 <= 0) {
                            this.f37917c = true;
                            return false;
                        }
                        try {
                            wait(jUptimeMillis2);
                        } catch (InterruptedException unused) {
                        }
                    }
                } else {
                    while (!this.f37916b) {
                        try {
                            wait();
                        } catch (InterruptedException unused2) {
                        }
                    }
                }
                return true;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f37915a.run();
                synchronized (this) {
                    this.f37916b = true;
                    notifyAll();
                    this.f37915a.a(this.f37917c);
                }
            } catch (Throwable th) {
                synchronized (this) {
                    this.f37916b = true;
                    notifyAll();
                    this.f37915a.a(this.f37917c);
                    throw th;
                }
            }
        }
    }

    public interface b extends Runnable {
        void a(boolean z10);
    }

    public d(Looper looper) {
        super(looper);
    }

    public final boolean a(b bVar, long j10) {
        if (bVar == null) {
            throw new IllegalArgumentException("runnable must not be null");
        }
        if (j10 < 0) {
            throw new IllegalArgumentException("timeout must be non-negative");
        }
        if (Looper.myLooper() != getLooper()) {
            return new a(bVar).a(this, j10);
        }
        bVar.run();
        return true;
    }
}
