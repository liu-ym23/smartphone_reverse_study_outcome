package p4;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile b f23323b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f23324a;

    public b() {
        this.f23324a = false;
    }

    public static b b() {
        if (f23323b != null) goto L16;
        monitor-enter(b.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f23323b != null) goto L11;
        f23323b = new b();     // Catch: Throwable -> L9
    L11:
        monitor-exit(b.class);     // Catch: Throwable -> L9
    L16:
        return f23323b;
    }

    public a a() {
        return null;
    }
}
