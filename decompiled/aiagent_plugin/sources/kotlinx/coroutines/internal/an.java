package kotlinx.coroutines.internal;

/* JADX INFO: compiled from: SystemProps.kt */
/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class an {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f39370a = 0;

    static {
        f39370a = Runtime.getRuntime().availableProcessors();
    }

    public static final int a() {
        return f39370a;
    }

    public static final String a(String r0) {
        return System.getProperty(r0);
    L4:
        return null;
    }
}
