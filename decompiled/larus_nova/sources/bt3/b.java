package bt3;

import com.bytedance.monitor.util.thread.AsyncTaskType;
import com.bytedance.ugc.glue.monitor.UGCMonitor;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import f27.g;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile ExecutorService f20530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f20531b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f27.d f20532c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f20533d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final C0360b f20534e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CopyOnWriteArraySet<e> f20535f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CopyOnWriteArraySet<e> f20536g;

    public class a implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f20537a;

        @Override // java.lang.Runnable
        public final void run() {
            Iterator<e> r100 = this.f20537a.f20535f.iterator();
        L4:
            if (r100.hasNext() == false) goto L7;
            r100.next().onTimeEvent(System.currentTimeMillis());
            goto L4
        L7:
            if (this.f20537a.f20531b == false) goto L11;
            this.f20537a.f(this);
            return;
        }

        @Override // f27.g
        public final AsyncTaskType getTaskType() {
            return AsyncTaskType.LIGHT_WEIGHT;
        }

        public a(b r100) {
            this.f20537a = r100;
        }
    }

    /* JADX INFO: renamed from: bt3.b$b, reason: collision with other inner class name */
    public class C0360b implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f20538a;

        @Override // java.lang.Runnable
        public final void run() {
            Iterator<e> r100 = this.f20538a.f20536g.iterator();
        L4:
            if (r100.hasNext() == false) goto L7;
            r100.next().onTimeEvent(System.currentTimeMillis());
            goto L4
        L7:
            if (this.f20538a.f20531b == false) goto L11;
            this.f20538a.f(this);
            return;
        }

        @Override // f27.g
        public final AsyncTaskType getTaskType() {
            return AsyncTaskType.LIGHT_WEIGHT;
        }

        public C0360b(b r100) {
            this.f20538a = r100;
        }
    }

    /* JADX INFO: loaded from: classes14.dex */
    public class c implements ThreadFactory {
        public c() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r100) {
            return new PthreadThreadV2(r100, "Apm_Normal");
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f20539a = null;

        static {
            f20539a = new b();
        }
    }

    public interface e {
        void onTimeEvent(long r100);
    }

    public final boolean c() {
        if (this.f20532c == null) goto L11;
        long r100 = ThreadMethodProxy.currentThread().getId();
        f27.d r101 = this.f20532c;
        AsyncTaskType r102 = AsyncTaskType.LIGHT_WEIGHT;
        Long r103 = (Long) ((ConcurrentHashMap) r101.f475220d).get(r102);
        if (r103 == null) goto L7;
        long r104 = r103.longValue();
    L9:
        if (r100 != r104) goto L11;
        return true;
    L7:
        r104 = -1;
    L11:
        return false;
    }

    public b() {
        this.f20531b = true;
        this.f20533d = new a(this);
        this.f20534e = new C0360b(this);
        this.f20535f = new CopyOnWriteArraySet();
        this.f20536g = new CopyOnWriteArraySet();
        Object r100 = f27.d.f475214f;
        this.f20532c = f27.d.a.f475222a;
    }

    public final void a(e r100) {
        if (r100 == null) goto L12;
        if (this.f20531b == true) goto L6;
        return;
    L6:
        if (this.f20535f.contains(r100) == true) goto L14;
        this.f20535f.add(r100);     // Catch: Throwable -> L9
        h(this.f20533d);     // Catch: Throwable -> L9
        f(this.f20533d);     // Catch: Throwable -> L9
        return;
    L14:
        return;
    L15:
        return;
    }

    public final void b(Runnable r100) {
        f27.d r101 = this.f20532c;
        if (r101 == null) goto L8;
        if (r100 == null) goto L9;
        r101.h(k(r100, UGCMonitor.TYPE_POST));
        return;
    L9:
        return;
    }

    public final void d(ExecutorService r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        monitor-enter(this);
        this.f20530a = r100;     // Catch: Throwable -> L10
        f27.d r101 = this.f20532c;     // Catch: Throwable -> L10
        if (r101 == null) goto L8;
        r101.k(r100);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final void e(Runnable r100) {
        if (this.f20532c == null) goto L10;
        if (r100 != null) goto L6;
        return;
    L6:
        if (this.f20531b == false) goto L12;
        this.f20532c.h(k(r100, UGCMonitor.TYPE_POST));
        return;
    L12:
        return;
    }

    public final void f(g r100) {
        if (this.f20532c == null) goto L10;
        if (r100 != null) goto L6;
        return;
    L6:
        if (this.f20531b == false) goto L12;
        this.f20532c.i(r100, 30000);
        return;
    L12:
        return;
    }

    public final void h(g r100) {
        f27.d r101 = this.f20532c;
        if (r101 == null) goto L8;
        if (r100 == null) goto L9;
        r101.j(r100);
        return;
    L9:
        return;
    }

    public final void i(e r100) {
        if (r100 == null) goto L8;
        this.f20535f.remove(r100);     // Catch: Throwable -> L5
        return;
    L9:
        return;
    }

    public final void j(Runnable r100) {
        if (this.f20530a != null) goto L16;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L6:
        if (this.f20530a != null) goto L11;
        f27.d r101 = this.f20532c;     // Catch: Throwable -> L13
        if (r101 == null) goto L10;
        this.f20530a = r101.c();     // Catch: Throwable -> L13
        goto L11
    L10:
        this.f20530a = PThreadExecutorsUtils.newFixedThreadPool(1, new c());     // Catch: Throwable -> L13
    L11:
        monitor-exit(this);     // Catch: Throwable -> L13
    L16:
        this.f20530a.submit(r100);
    }

    public static f27.e k(Runnable r100, String r101) {
        return new f27.e("AsyncEventManager-".concat(r101), AsyncTaskType.LIGHT_WEIGHT, r100);
    }

    public final void g(Runnable r100, long r101) {
        if (this.f20532c != null) goto L5;
        return;
    L5:
        if (this.f20531b == false) goto L10;
        this.f20532c.i(k(r100, "postDelayed"), r101);
        return;
    }
}
