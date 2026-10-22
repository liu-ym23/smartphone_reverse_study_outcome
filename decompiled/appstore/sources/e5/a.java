package e5;

import com.bytedance.framwork.core.sdklib.thread.IMonitorTimeTask;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static long f19290e = 30000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f19291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f19292b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Runnable f19293c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CopyOnWriteArraySet f19294d;

    /* JADX INFO: renamed from: e5.a$a, reason: collision with other inner class name */
    public class RunnableC0240a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f19295a;

        public RunnableC0240a(a r10) {
            this.f19295a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator r10 = this.f19295a.f19294d.iterator();     // Catch: OutOfMemoryError -> L10
        L4:
            if (r10.hasNext() == false) goto L7;
            ((IMonitorTimeTask) r10.next()).onTimeEvent(System.currentTimeMillis());     // Catch: OutOfMemoryError -> L10
            goto L4
        L7:
            if (a.a(this.f19295a) == false) goto L14;
            a.c(this.f19295a).h(this, a.b());     // Catch: OutOfMemoryError -> L10
            return;
        L14:
            return;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f19296a = null;

        static {
            f19296a = new a(null);
        }
    }

    static {
    }

    public /* synthetic */ a(RunnableC0240a r10) {
        this();
    }

    public static /* synthetic */ boolean a(a r10) {
        return r10.f19292b;
    }

    public static /* synthetic */ long b() {
        return f19290e;
    }

    public static /* synthetic */ c c(a r10) {
        return r10.f19291a;
    }

    public static a e() {
        return b.f19296a;
    }

    public void d(IMonitorTimeTask r10) {
        if (r10 == null) goto L10;
        this.f19294d.add(r10);     // Catch: Throwable -> L7
        if (this.f19292b == false) goto L11;
        this.f19291a.i(this.f19293c);     // Catch: Throwable -> L7
        this.f19291a.h(this.f19293c, f19290e);     // Catch: Throwable -> L7
        return;
    L11:
        return;
    L12:
        return;
    }

    public void f(Runnable r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        this.f19291a.g(r10);
    }

    public void g(Runnable r10, long r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        this.f19291a.h(r10, r11);
    }

    public a() {
        this.f19292b = true;
        this.f19293c = new RunnableC0240a(this);
        this.f19294d = new CopyOnWriteArraySet();
        c r10 = new c("AsyncEventManager-Thread");
        this.f19291a = r10;
        r10.l();
    }
}
