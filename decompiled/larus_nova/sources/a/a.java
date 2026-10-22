package a;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static final StackTraceElement a(Throwable r100, String r101) {
        StackTraceElement r102 = r100.getStackTrace()[0];
        return new StackTraceElement("_COROUTINE.".concat(r101), "_", r102.getFileName(), r102.getLineNumber());
    }
}
