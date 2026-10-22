package e5;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bytedance.framwork.core.sdklib.util.ListUtils;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ListUtils.ComparableDiffType f19304f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ListUtils.ComparableDiffType f19305g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HandlerThread f19306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Queue f19307b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Queue f19308c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile Handler f19309d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f19310e;

    public static class a implements ListUtils.ComparableDiffType {
        public a() {
        }

        public boolean a(e r10, Runnable r11) {
            if (r11 != null) goto L12;
            if (r10 == null) goto L20;
            Message r12 = r10.f19313a;
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
            Message r13 = r10.f19313a;
            if (r13 == null) goto L19;
            if (r11.equals(r13.getCallback()) == false) goto L19;
            return true;
        L19:
            return false;
        }

        @Override // com.bytedance.framwork.core.sdklib.util.ListUtils.ComparableDiffType
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

        @Override // com.bytedance.framwork.core.sdklib.util.ListUtils.ComparableDiffType
        public /* bridge */ /* synthetic */ boolean equals(Object r10, Object r11) {
            return a((Message) r10, (Runnable) r11);
        }
    }

    /* JADX INFO: renamed from: e5.c$c, reason: collision with other inner class name */
    public class RunnableC0242c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f19311a;

        public RunnableC0242c(c r10) {
            this.f19311a = r10;
        }

        public void a() {
        L3:
            if (c.e(this.f19311a).isEmpty() == true) goto L7;
            if (c.b(this.f19311a) == null) goto L3;
            c.b(this.f19311a).sendMessageAtFrontOfQueue((Message) c.e(this.f19311a).poll());
            goto L3
        }

        public void b() {
        L3:
            if (c.d(this.f19311a).isEmpty() == true) goto L7;
            e r10 = (e) c.d(this.f19311a).poll();
            if (c.b(this.f19311a) == null) goto L3;
            c.b(this.f19311a).sendMessageAtTime(r10.f19313a, r10.f19314b);
            goto L3
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
            b();
        }
    }

    public class d extends HandlerThread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f19312a;

        public d(c r10, String r11) {
            this.f19312a = r10;
            super(r11);
        }

        /* JADX INFO: Infinite loop detected, blocks: 7, insns: 0 */
        @Override // android.os.HandlerThread
        public void onLooperPrepared() {
            super.onLooperPrepared();
            Object r10 = c.a(this.f19312a);
            monitor-enter(r10);
            c.c(this.f19312a, new Handler());     // Catch: Throwable -> L9
            monitor-exit(r10);     // Catch: Throwable -> L9
            c.b(this.f19312a).post(new RunnableC0242c(this.f19312a));
        L13:
            Looper.loop();     // Catch: Throwable -> L12
        L9:
            th = move-exception;
            throw th;
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Message f19313a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f19314b;

        public e(Message r10, long r11) {
            this.f19313a = r10;
            this.f19314b = r11;
        }
    }

    static {
        f19304f = new a();
        f19305g = new b();
    }

    public c(String r10) {
        this.f19307b = new ConcurrentLinkedQueue();
        this.f19308c = new ConcurrentLinkedQueue();
        this.f19310e = new Object();
        this.f19306a = new d(this, r10);
    }

    public static /* synthetic */ Object a(c r10) {
        return r10.f19310e;
    }

    public static /* synthetic */ Handler b(c r10) {
        return r10.f19309d;
    }

    public static /* synthetic */ Handler c(c r10, Handler r11) {
        r10.f19309d = r11;
        return r11;
    }

    public static /* synthetic */ Queue d(c r10) {
        return r10.f19307b;
    }

    public static /* synthetic */ Queue e(c r10) {
        return r10.f19308c;
    }

    public final Message f(Runnable r10) {
        return Message.obtain(this.f19309d, r10);
    }

    public final boolean g(Runnable r10) {
        return k(f(r10), 0);
    }

    public final boolean h(Runnable r10, long r11) {
        return k(f(r10), r11);
    }

    public final void i(Runnable r10) {
        if (this.f19307b.isEmpty() == true) goto L5;
    L6:
        ListUtils.b(this.f19307b, r10, f19304f);
        ListUtils.b(this.f19308c, r10, f19305g);
    L8:
        if (this.f19309d == null) goto L11;
        this.f19309d.removeCallbacks(r10);
        return;
    L11:
        return;
    L5:
        if (this.f19308c.isEmpty() == true) goto L8;
        goto L6
    }

    public final boolean j(Message r10, long r11) {
        if (this.f19309d != null) goto L19;
        Object r12 = this.f19310e;
        monitor-enter(r12);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (this.f19309d != null) goto L14;
        this.f19307b.add(new e(r10, r11));     // Catch: Throwable -> L12
        monitor-exit(r12);     // Catch: Throwable -> L12
        return true;
    L14:
        monitor-exit(r12);     // Catch: Throwable -> L12
    L19:
        return this.f19309d.sendMessageAtTime(r10, r11);
    }

    public final boolean k(Message r10, long r11) {
        if (r11 >= 0) goto L6;
        r11 = 0;
    L6:
        return j(r10, SystemClock.uptimeMillis() + r11);
    }

    public void l() {
        this.f19306a.start();
    }
}
