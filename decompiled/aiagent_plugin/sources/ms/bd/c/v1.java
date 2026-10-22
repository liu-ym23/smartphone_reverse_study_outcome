package ms.bd.c;

/* JADX INFO: loaded from: classes4.dex */
public final class v1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile v1 f39669a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f39670b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Throwable f39671c;

    private v1() {
        this.f39670b = 0;
        this.f39671c = null;
    }

    public static v1 a() {
        if (f39669a != null) goto L15;
        monitor-enter(v1.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f39669a != null) goto L9;
        f39669a = new v1();     // Catch: Throwable -> L11
    L9:
        monitor-exit(v1.class);     // Catch: Throwable -> L11
    L15:
        return f39669a;
    }

    public final synchronized void b() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.f39671c != null) goto L11;
        int r0 = this.f39670b;     // Catch: Throwable -> L13
        this.f39670b = r0 + 1;     // Catch: Throwable -> L13
        if (r0 < 30) goto L11;
        this.f39670b = 0;     // Catch: Throwable -> L13
        this.f39671c = new Throwable();     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L11:
        monitor-exit(this);
    }

    public final synchronized Throwable c() {
        monitor-enter(this);
        Throwable r0 = this.f39671c;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }
}
