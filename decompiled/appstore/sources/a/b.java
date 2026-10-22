package a;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f4a = "_COROUTINE";

    static {
    }

    public static final /* synthetic */ StackTraceElement a(Throwable r10, String r11) {
        return b(r10, r11);
    }

    public static final StackTraceElement b(Throwable r10, String r11) {
        StackTraceElement r12 = r10.getStackTrace()[0];
        return new StackTraceElement(f4a + '.' + r11, "_", r12.getFileName(), r12.getLineNumber());
    }
}
