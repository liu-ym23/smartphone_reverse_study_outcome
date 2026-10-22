package cmb;

/* JADX INFO: loaded from: classes36.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile com.ss.android.lark.integrator.ccm.spacekit.b f24251a;

    public f() {
    }

    public static com.ss.android.lark.integrator.ccm.spacekit.b a() {
        if (f24251a != null) goto L15;
        monitor-enter(f.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f24251a != null) goto L9;
        f24251a = new com.ss.android.lark.integrator.ccm.spacekit.b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(f.class);     // Catch: Throwable -> L11
    L15:
        return f24251a;
    }
}
