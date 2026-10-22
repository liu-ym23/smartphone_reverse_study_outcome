package pg;

import androidx.lifecycle.p;
import java.util.concurrent.atomic.AtomicReference;
import og.c;
import og.f;
import og.g;
import rx.internal.schedulers.SchedulerLifecycle;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicReference f23464d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final jg.a f23465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final jg.a f23466b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final jg.a f23467c;

    static {
        f23464d = new AtomicReference();
    }

    public a() {
        g r10 = f.c().f();
        jg.a r11 = r10.g();
        if (r11 == null) goto L5;
        this.f23465a = r11;
    L6:
        jg.a r12 = r10.i();
        if (r12 == null) goto L9;
        this.f23466b = r12;
    L10:
        jg.a r13 = r10.j();
        if (r13 == null) goto L13;
        this.f23467c = r13;
        return;
    L13:
        this.f23467c = g.e();
        return;
    L9:
        this.f23466b = g.c();
        goto L10
    L5:
        this.f23465a = g.a();
        goto L6
    }

    public static jg.a a() {
        return c.f(b().f23465a);
    }

    public static a b() {
    L2:
        AtomicReference r10 = f23464d;
        a r11 = (a) r10.get();
        if (r11 != null) goto L4;
        a r12 = new a();
        if (p.a(r10, null, r12) == true) goto L7;
        r12.d();
        goto L2
    L7:
        return r12;
    L4:
        return r11;
    }

    public static jg.a c() {
        return c.k(b().f23466b);
    }

    public synchronized void d() {
        monitor-enter(this);
        Object r10 = this.f23465a;     // Catch: Throwable -> L6
        if ((r10 instanceof SchedulerLifecycle) == false) goto L8;
        ((SchedulerLifecycle) r10).shutdown();     // Catch: Throwable -> L6
    L8:
        Object r11 = this.f23466b;     // Catch: Throwable -> L6
        if ((r11 instanceof SchedulerLifecycle) == false) goto L11;
        ((SchedulerLifecycle) r11).shutdown();     // Catch: Throwable -> L6
    L11:
        Object r12 = this.f23467c;     // Catch: Throwable -> L6
        if ((r12 instanceof SchedulerLifecycle) == false) goto L14;
        ((SchedulerLifecycle) r12).shutdown();     // Catch: Throwable -> L6
    L14:
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
