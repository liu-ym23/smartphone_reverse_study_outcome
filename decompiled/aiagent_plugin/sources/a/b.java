package a;

/* JADX INFO: compiled from: CoroutineDebugging.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f2a = "_COROUTINE";

    static {
    }

    public static final /* synthetic */ StackTraceElement a(Throwable r0, String r1) {
        return b(r0, r1);
    }

    public static final String a() {
        return f2a;
    }

    private static final StackTraceElement b(Throwable r3, String r4) {
        StackTraceElement r5 = r3.getStackTrace()[0];
        return new StackTraceElement(f2a + '.' + r4, "_", r5.getFileName(), r5.getLineNumber());
    }
}
