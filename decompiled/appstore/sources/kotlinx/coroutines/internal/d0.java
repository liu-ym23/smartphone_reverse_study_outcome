package kotlinx.coroutines.internal;

/* JADX INFO: loaded from: classes4.dex */
public abstract /* synthetic */ class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f21584a = 0;

    static {
        f21584a = Runtime.getRuntime().availableProcessors();
    }

    public static final int a() {
        return f21584a;
    }

    public static final String b(String r10) {
        return System.getProperty(r10);
    L4:
        return null;
    }
}
