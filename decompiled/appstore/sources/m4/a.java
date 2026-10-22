package m4;

import android.net.TrafficStats;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.connectionclass.ConnectionClassManager;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static long f22071g = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConnectionClassManager f22072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AtomicInteger f22073b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f22074c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public HandlerThread f22075d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f22076e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f22077f;

    /* JADX INFO: renamed from: m4.a$a, reason: collision with other inner class name */
    public static class C0312a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f22078a = null;

        static {
            f22078a = new a(ConnectionClassManager.c());
        }
    }

    public class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f22079a;

        public b(a r10, Looper r11) {
            this.f22079a = r10;
            super(r11);
        }

        public void a() {
            sendEmptyMessage(1);
        }

        public void b() {
            removeMessages(1);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r10) {
        L7:
            th = move-exception;
            th.printStackTrace();
            return;
        L3:
            if (r10.what != 1) goto L12;
            this.f22079a.b();     // Catch: Throwable -> L7
            sendEmptyMessageDelayed(1, 1000);     // Catch: Throwable -> L7
            return;
        }
    }

    static {
    }

    public a(ConnectionClassManager r10) {
        this.f22076e = false;
        this.f22072a = r10;
        this.f22073b = new AtomicInteger();     // Catch: Throwable -> L5
        HandlerThread r11 = com.bytedance.platform.thread.a.a("ParseThread");     // Catch: Throwable -> L5
        this.f22075d = r11;     // Catch: Throwable -> L5
        r11.start();     // Catch: Throwable -> L5
        this.f22074c = new b(this, this.f22075d.getLooper());     // Catch: Throwable -> L5
        return;
    L5:
        this.f22076e = true;
    }

    public static a c() {
        return C0312a.f22078a;
    }

    public void a() {
        b();
        f22071g = -1;
    }

    public void b() {
        long r10 = TrafficStats.getTotalRxBytes();     // Catch: Throwable -> L11
        long r11 = f22071g;     // Catch: Throwable -> L11
        long r12 = r10 - r11;     // Catch: Throwable -> L11
        if (r11 < 0) goto L13;
        monitor-enter(this);     // Catch: Throwable -> L11
        long r13 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L8
        this.f22072a.a(r12, r13 - this.f22077f);     // Catch: Throwable -> L8
        this.f22077f = r13;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L13:
        f22071g = r10;     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        th.printStackTrace();
    }

    public void d() {
        if (this.f22076e == false) goto L6;
        return;
    L6:
        if (this.f22073b.getAndIncrement() == 0) goto L8;
        return;
    L8:
        if (Logger.debug() == false) goto L10;
        Logger.d("ConnectionClassManager", "startSampling");     // Catch: Throwable -> L12
    L10:
        this.f22074c.a();     // Catch: Throwable -> L12
        this.f22077f = SystemClock.elapsedRealtime();     // Catch: Throwable -> L12
        return;
    }

    public void e() {
        if (this.f22076e == false) goto L6;
        return;
    L6:
        if (this.f22073b.decrementAndGet() == 0) goto L8;
        return;
    L8:
        if (Logger.debug() == false) goto L10;
        Logger.d("ConnectionClassManager", "stopSampling");     // Catch: Throwable -> L12
    L10:
        this.f22074c.b();     // Catch: Throwable -> L12
        a();     // Catch: Throwable -> L12
        return;
    }
}
