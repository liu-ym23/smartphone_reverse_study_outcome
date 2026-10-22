package am2;

/* JADX INFO: loaded from: classes10.dex */
public final class j {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f4288d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static j f4289e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f4290a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f4291b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f4292c;

    public interface a {
        String getDefinition();
    }

    public interface b {
        int a();
    }

    public interface c {
        int getNetQuality();
    }

    public static synchronized j a() {
        monitor-enter(j.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f4289e != null) goto L7;
        f4289e = new j();     // Catch: Throwable -> L10
    L7:
        j r100 = f4289e;     // Catch: Throwable -> L10
        monitor-exit(j.class);
        return r100;
    }

    public j() {
        this.f4290a = null;
        this.f4291b = null;
        this.f4292c = null;
    }
}
