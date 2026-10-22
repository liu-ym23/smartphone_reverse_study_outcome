package org.libpag;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

/* loaded from: classes.dex */
class t extends Handler {

    private static final class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final b f19258a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f19259b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f19260c = false;

        public a(b bVar) {
            this.f19258a = bVar;
        }

        public boolean a(Handler handler, long j5) {
            if (!handler.post(this)) {
                return false;
            }
            synchronized (this) {
                if (j5 > 0) {
                    long jUptimeMillis = SystemClock.uptimeMillis() + j5;
                    while (!this.f19259b) {
                        long jUptimeMillis2 = jUptimeMillis - SystemClock.uptimeMillis();
                        if (jUptimeMillis2 <= 0) {
                            this.f19260c = true;
                            return false;
                        }
                        try {
                            wait(jUptimeMillis2);
                        } catch (InterruptedException unused) {
                        }
                    }
                } else {
                    while (!this.f19259b) {
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
                this.f19258a.run();
                synchronized (this) {
                    this.f19259b = true;
                    notifyAll();
                    this.f19258a.a(this.f19260c);
                }
            } catch (Throwable th) {
                synchronized (this) {
                    this.f19259b = true;
                    notifyAll();
                    this.f19258a.a(this.f19260c);
                    throw th;
                }
            }
        }
    }

    interface b extends Runnable {
        void a(boolean z5);
    }

    public t(Looper looper) {
        super(looper);
    }

    public final boolean a(b bVar, long j5) {
        if (bVar == null) {
            throw new IllegalArgumentException("runnable must not be null");
        }
        if (j5 < 0) {
            throw new IllegalArgumentException("timeout must be non-negative");
        }
        if (Looper.myLooper() != getLooper()) {
            return new a(bVar).a(this, j5);
        }
        bVar.run();
        return true;
    }
}
