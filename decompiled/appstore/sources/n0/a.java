package n0;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler.Callback f22340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f22341b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Lock f22342c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C0320a f22343d;

    /* JADX INFO: renamed from: n0.a$a, reason: collision with other inner class name */
    public static class C0320a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public C0320a f22344a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public C0320a f22345b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Runnable f22346c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final c f22347d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Lock f22348e;

        public C0320a(Lock r10, Runnable r11) {
            this.f22346c = r11;
            this.f22348e = r10;
            this.f22347d = new c(new WeakReference(r11), new WeakReference(this));
        }

        public c a() {
            this.f22348e.lock();
            C0320a r10 = this.f22345b;     // Catch: Throwable -> L6
            if (r10 == null) goto L8;
            r10.f22344a = this.f22344a;     // Catch: Throwable -> L6
        L8:
            C0320a r11 = this.f22344a;     // Catch: Throwable -> L6
            if (r11 == null) goto L11;
            r11.f22345b = r10;     // Catch: Throwable -> L6
        L11:
            this.f22345b = null;     // Catch: Throwable -> L6
            this.f22344a = null;     // Catch: Throwable -> L6
            this.f22348e.unlock();
            return this.f22347d;
        L6:
            th = move-exception;
            this.f22348e.unlock();
            throw th;
        }
    }

    public static class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference f22349a;

        public b(WeakReference r10) {
            this.f22349a = r10;
        }

        @Override // android.os.Handler
        public void handleMessage(Message r10) {
            WeakReference r11 = this.f22349a;
            if (r11 != null) goto L5;
            return;
        L5:
            Handler.Callback r12 = (Handler.Callback) r11.get();
            if (r12 != null) goto L8;
            return;
        L8:
            r12.handleMessage(r10);
        }
    }

    public static class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference f22350a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final WeakReference f22351b;

        public c(WeakReference r10, WeakReference r11) {
            this.f22350a = r10;
            this.f22351b = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable r10 = (Runnable) this.f22350a.get();
            C0320a r11 = (C0320a) this.f22351b.get();
            if (r11 == null) goto L5;
            r11.a();
        L5:
            if (r10 == null) goto L8;
            r10.run();
            return;
        }
    }

    public a(Handler.Callback r10) {
        ReentrantLock r11 = new ReentrantLock();
        this.f22342c = r11;
        this.f22343d = new C0320a(r11, null);
        this.f22340a = r10;
        this.f22341b = new b(new WeakReference(r10));
    }
}
