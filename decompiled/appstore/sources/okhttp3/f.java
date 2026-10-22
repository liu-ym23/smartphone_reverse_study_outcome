package okhttp3;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlinx.coroutines.channels.Channel;
import okhttp3.internal.Util;

/* JADX INFO: loaded from: classes4.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f22936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f22937b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Runnable f22938c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ExecutorService f22939d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Deque f22940e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Deque f22941f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Deque f22942g;

    public f() {
        this.f22936a = 64;
        this.f22937b = 5;
        this.f22940e = new ArrayDeque();
        this.f22941f = new ArrayDeque();
        this.f22942g = new ArrayDeque();
    }

    public synchronized void a(j.a r10) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.f22941f.size() < this.f22936a) goto L6;
    L10:
        this.f22940e.add(r10);     // Catch: Throwable -> L8
    L11:
        monitor-exit(this);
        return;
    L6:
        if (i(r10) >= this.f22937b) goto L10;
        this.f22941f.add(r10);     // Catch: Throwable -> L8
        c().execute(r10);     // Catch: Throwable -> L8
        goto L11
    }

    public synchronized void b(j r10) {
        monitor-enter(this);
        this.f22942g.add(r10);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized ExecutorService c() {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.f22939d != null) goto L8;
        this.f22939d = new ThreadPoolExecutor(0, Channel.UNLIMITED, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp Dispatcher", false));     // Catch: Throwable -> L6
    L8:
        ExecutorService r10 = this.f22939d;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    }

    public final void d(Deque r10, Object r11, boolean r12) {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (r10.remove(r11) == false) goto L16;
        if (r12 == false) goto L9;
        g();     // Catch: Throwable -> L7
    L9:
        int r13 = h();     // Catch: Throwable -> L7
        Runnable r14 = this.f22938c;     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        if (r13 != 0) goto L20;
        if (r14 == null) goto L21;
        r14.run();
        return;
    L21:
        return;
    L20:
        return;
    L16:
        throw new AssertionError("Call wasn't in-flight!");     // Catch: Throwable -> L7
    }

    public void e(j.a r10) {
        d(this.f22941f, r10, true);
    }

    public void f(j r10) {
        d(this.f22942g, r10, false);
    }

    public final void g() {
        if (this.f22941f.size() < this.f22936a) goto L6;
        return;
    L6:
        if (this.f22940e.isEmpty() == false) goto L8;
        return;
    L8:
        Iterator r10 = this.f22940e.iterator();
    L10:
        if (r10.hasNext() == false) goto L16;
        j.a r11 = (j.a) r10.next();
        if (i(r11) >= this.f22937b) goto L15;
        r10.remove();
        this.f22941f.add(r11);
        c().execute(r11);
    L15:
        if (this.f22941f.size() < this.f22936a) goto L10;
        return;
    }

    public synchronized int h() {
        monitor-enter(this);
        int r10 = this.f22941f.size() + this.f22942g.size();
        monitor-exit(this);
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public final int i(j.a r10) {
        Iterator r11 = this.f22941f.iterator();
        int r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L11;
        j.a r13 = (j.a) r11.next();
        if (r13.a().f23007e == true) goto L4;
        if (r13.b().equals(r10.b()) == false) goto L4;
        r12 = r12 + 1;
        goto L4
    L11:
        return r12;
    }
}
