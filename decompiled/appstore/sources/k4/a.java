package k4;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f21030a = false;

    static {
    }

    public static synchronized void a() {
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (f21030a == false) goto L8;
        monitor-exit(a.class);
        return;
    L8:
        System.loadLibrary("bdzstd");     // Catch: Throwable -> L11
        f21030a = true;     // Catch: Throwable -> L11
        monitor-exit(a.class);
    }
}
