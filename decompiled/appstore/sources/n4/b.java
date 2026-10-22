package n4;

import com.bytedance.frameworks.baselib.network.dispatcher.IRequestQueue;

/* JADX INFO: loaded from: classes.dex */
public class b implements IRequestQueue {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f22390a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile c f22391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile b f22392c;

    static {
    }

    public b() {
        this(8, 8);
    }

    public static b a() {
        if (f22392c != null) goto L16;
        monitor-enter(b.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f22392c != null) goto L11;
        f22392c = new b();     // Catch: Throwable -> L9
    L11:
        monitor-exit(b.class);     // Catch: Throwable -> L9
    L16:
        return f22392c;
    }

    public static synchronized c b() {
        monitor-enter(b.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (f22391b != null) goto L9;
        f22391b = c.m().o(8, 8).q(8, 8).n(30).s(10).p(10).r(true).m();     // Catch: Throwable -> L7
    L9:
        c r10 = f22391b;     // Catch: Throwable -> L7
        monitor-exit(b.class);
        return r10;
    }

    public static synchronized void c(boolean r10) {
        monitor-enter(b.class);
        f22390a = r10;     // Catch: Throwable -> L8
        if (f22391b == null) goto L10;
        f22391b.n(f22390a);     // Catch: Throwable -> L8
    L10:
        monitor-exit(b.class);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.frameworks.baselib.network.dispatcher.IRequestQueue
    public synchronized void add(a r10) {
        monitor-enter(this);
        if (r10 != null) goto L10;
    L8:
        monitor-exit(this);
        return;
    L10:
        com.bytedance.frameworks.baselib.network.dispatcher.c.f7148g.c(r10);     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.frameworks.baselib.network.dispatcher.IRequestQueue
    public synchronized void addDownload(a r10) {
        monitor-enter(this);
        if (r10 != null) goto L10;
    L8:
        monitor-exit(this);
        return;
    L10:
        com.bytedance.frameworks.baselib.network.dispatcher.c.f7148g.d(r10);     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        throw th;
    }

    public b(int r10, int r11) {
        if (f22391b != null) goto L6;
        f22391b = c.m().o(8, 8).q(8, 8).n(30).s(10).p(10).r(true).m();
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.dispatcher.IRequestQueue
    public synchronized void add(com.bytedance.frameworks.baselib.network.dispatcher.b r10) {
        monitor-enter(this);
        monitor-exit(this);
    }

    @Override // com.bytedance.frameworks.baselib.network.dispatcher.IRequestQueue
    public synchronized void addDownload(com.bytedance.frameworks.baselib.network.dispatcher.b r10) {
        monitor-enter(this);
        monitor-exit(this);
    }
}
