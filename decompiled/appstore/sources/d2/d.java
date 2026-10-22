package d2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bytedance.apm.MonitorCoreExceptionManager;
import com.bytedance.apm.util.ListUtils;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ListUtils.ComparableDiffType f19032g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ListUtils.ComparableDiffType f19033h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HandlerThread f19034a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Queue f19035b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Queue f19036c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile Handler f19037d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f19038e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f19039f;

    public static class a implements ListUtils.ComparableDiffType {
        public a() {
        }

        public boolean a(e r10, Runnable r11) {
            if (r11 != null) goto L12;
            if (r10 == null) goto L20;
            Message r12 = r10.f19042a;
            if (r12 != null) goto L8;
            return true;
        L8:
            if (r12.getCallback() != null) goto L11;
            return true;
        L11:
            return false;
        L20:
            return true;
        L12:
            if (r10 == null) goto L19;
            Message r13 = r10.f19042a;
            if (r13 == null) goto L19;
            if (r11.equals(r13.getCallback()) == false) goto L19;
            return true;
        L19:
            return false;
        }

        @Override // com.bytedance.apm.util.ListUtils.ComparableDiffType
        public /* bridge */ /* synthetic */ boolean equals(Object r10, Object r11) {
            return a((e) r10, (Runnable) r11);
        }
    }

    public static class b implements ListUtils.ComparableDiffType {
        public b() {
        }

        public boolean a(Message r10, Runnable r11) {
            if (r11 != null) goto L10;
            if (r10 != null) goto L6;
            return true;
        L6:
            if (r10.getCallback() != null) goto L9;
            return true;
        L9:
            return false;
        L10:
            if (r10 == null) goto L15;
            if (r11.equals(r10.getCallback()) == false) goto L15;
            return true;
        L15:
            return false;
        }

        @Override // com.bytedance.apm.util.ListUtils.ComparableDiffType
        public /* bridge */ /* synthetic */ boolean equals(Object r10, Object r11) {
            return a((Message) r10, (Runnable) r11);
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f19040a;

        public c(d r10) {
            this.f19040a = r10;
        }

        public void a() {
        L3:
            if (d.c(this.f19040a).isEmpty() == true) goto L15;
            Object r10 = d.a(this.f19040a);
            monitor-enter(r10);
            if (this.f19040a.f19037d == null) goto L11;
            this.f19040a.f19037d.sendMessageAtFrontOfQueue((Message) d.c(this.f19040a).poll());     // Catch: Throwable -> L9
        L11:
            monitor-exit(r10);     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            throw th;
        }

        public void b() {
        L3:
            if (d.b(this.f19040a).isEmpty() == true) goto L15;
            Object r10 = d.a(this.f19040a);
            monitor-enter(r10);
            e r11 = (e) d.b(this.f19040a).poll();     // Catch: Throwable -> L9
            if (this.f19040a.f19037d == null) goto L11;
            this.f19040a.f19037d.sendMessageAtTime(r11.f19042a, r11.f19043b);     // Catch: Throwable -> L9
        L11:
            monitor-exit(r10);     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            throw th;
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
            b();
        }
    }

    /* JADX INFO: renamed from: d2.d$d, reason: collision with other inner class name */
    public class HandlerThreadC0231d extends HandlerThread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f19041a;

        public HandlerThreadC0231d(d r10, String r11) {
            this.f19041a = r10;
            super(r11);
        }

        /* JADX INFO: Infinite loop detected, blocks: 9, insns: 0 */
        @Override // android.os.HandlerThread
        public void onLooperPrepared() {
            super.onLooperPrepared();
            Object r10 = d.a(this.f19041a);
            monitor-enter(r10);
            d r11 = this.f19041a;     // Catch: Throwable -> L11
            r11.f19037d = new Handler();     // Catch: Throwable -> L11
            monitor-exit(r10);     // Catch: Throwable -> L11
            this.f19041a.f19037d.post(new c(this.f19041a));
        L16:
            Looper.loop();     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            MonitorCoreExceptionManager.e().b(th, "apm_error");
        L11:
            th = move-exception;
            throw th;
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Message f19042a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f19043b;

        public e(Message r10, long r11) {
            this.f19042a = r10;
            this.f19043b = r11;
        }
    }

    static {
        f19032g = new a();
        f19033h = new b();
    }

    public d(String r10) {
        this.f19035b = new ConcurrentLinkedQueue();
        this.f19036c = new ConcurrentLinkedQueue();
        this.f19038e = 0;
        this.f19039f = new Object();
        this.f19034a = new HandlerThreadC0231d(this, r10);
    }

    public static /* synthetic */ Object a(d r10) {
        return r10.f19039f;
    }

    public static /* synthetic */ Queue b(d r10) {
        return r10.f19035b;
    }

    public static /* synthetic */ Queue c(d r10) {
        return r10.f19036c;
    }

    public Message d(Runnable r10) {
        return Message.obtain(this.f19037d, r10);
    }

    public boolean e() {
        if (this.f19037d == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean f(Runnable r10) {
        return j(d(r10), 0);
    }

    public final boolean g(Runnable r10, long r11) {
        return j(d(r10), r11);
    }

    public final void h(Runnable r10) {
        if (this.f19035b.isEmpty() == true) goto L5;
    L6:
        ListUtils.d(this.f19035b, r10, f19032g);
        ListUtils.d(this.f19036c, r10, f19033h);
    L8:
        if (this.f19037d == null) goto L11;
        this.f19037d.removeCallbacks(r10);
        return;
    L11:
        return;
    L5:
        if (this.f19036c.isEmpty() == true) goto L8;
        goto L6
    }

    public final boolean i(Message r10, long r11) {
        if (this.f19037d != null) goto L19;
        Object r12 = this.f19039f;
        monitor-enter(r12);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (this.f19037d != null) goto L14;
        this.f19035b.add(new e(r10, r11));     // Catch: Throwable -> L12
        monitor-exit(r12);     // Catch: Throwable -> L12
        return true;
    L14:
        monitor-exit(r12);     // Catch: Throwable -> L12
    L19:
        return this.f19037d.sendMessageAtTime(r10, r11);
    }

    public final boolean j(Message r10, long r11) {
        if (r11 >= 0) goto L6;
        r11 = 0;
    L6:
        return i(r10, SystemClock.uptimeMillis() + r11);
    }

    public void k() {
        this.f19034a.start();
    }
}
