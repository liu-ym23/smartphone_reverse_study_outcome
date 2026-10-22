package h;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class d extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f20142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ExecutorService f20143b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile Handler f20144c;

    public class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicInteger f20145a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f20146b;

        public a(d r10) {
            this.f20146b = r10;
            this.f20145a = new AtomicInteger(0);
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r10) {
            Thread r11 = new Thread(r10);
            r11.setName("arch_disk_io_" + this.f20145a.getAndIncrement());
            return r11;
        }
    }

    public static class b {
        public static Handler a(Looper r10) {
            return Handler.createAsync(r10);
        }
    }

    public d() {
        this.f20142a = new Object();
        this.f20143b = Executors.newFixedThreadPool(4, new a(this));
    }

    public static Handler e(Looper r10) {
        return b.a(r10);
    }

    @Override // h.e
    public void a(Runnable r10) {
        this.f20143b.execute(r10);
    }

    @Override // h.e
    public boolean c() {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // h.e
    public void d(Runnable r10) {
        if (this.f20144c != null) goto L15;
        Object r11 = this.f20142a;
        monitor-enter(r11);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (this.f20144c != null) goto L11;
        this.f20144c = e(Looper.getMainLooper());     // Catch: Throwable -> L9
    L11:
        monitor-exit(r11);     // Catch: Throwable -> L9
    L15:
        this.f20144c.post(r10);
    }
}
