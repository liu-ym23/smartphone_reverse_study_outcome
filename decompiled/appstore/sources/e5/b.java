package e5;

import com.bytedance.framwork.core.sdklib.thread.IMonitorTimeTask;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static long f19297e = 5000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f19298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f19299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Runnable f19300c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CopyOnWriteArraySet f19301d;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f19302a;

        public a(b r10) {
            this.f19302a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator r10 = this.f19302a.f19301d.iterator();     // Catch: OutOfMemoryError -> L10
        L4:
            if (r10.hasNext() == false) goto L7;
            ((IMonitorTimeTask) r10.next()).onTimeEvent(System.currentTimeMillis());     // Catch: OutOfMemoryError -> L10
            goto L4
        L7:
            if (b.a(this.f19302a) == false) goto L14;
            b.c(this.f19302a).h(this, b.b());     // Catch: OutOfMemoryError -> L10
            return;
        L14:
            return;
        }
    }

    /* JADX INFO: renamed from: e5.b$b, reason: collision with other inner class name */
    public static final class C0241b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f19303a = null;

        static {
            f19303a = new b(null);
        }
    }

    static {
    }

    public /* synthetic */ b(a r10) {
        this();
    }

    public static /* synthetic */ boolean a(b r10) {
        return r10.f19299b;
    }

    public static /* synthetic */ long b() {
        return f19297e;
    }

    public static /* synthetic */ c c(b r10) {
        return r10.f19298a;
    }

    public static b e() {
        return C0241b.f19303a;
    }

    public void d(IMonitorTimeTask r10) {
        if (r10 == null) goto L10;
        this.f19301d.add(r10);     // Catch: Throwable -> L7
        if (this.f19299b == false) goto L11;
        this.f19298a.i(this.f19300c);     // Catch: Throwable -> L7
        this.f19298a.h(this.f19300c, f19297e);     // Catch: Throwable -> L7
        return;
    L11:
        return;
    L12:
        return;
    }

    public b() {
        this.f19299b = true;
        this.f19300c = new a(this);
        this.f19301d = new CopyOnWriteArraySet();
        c r10 = new c("LogSendManager-Thread");
        this.f19298a = r10;
        r10.l();
    }
}
