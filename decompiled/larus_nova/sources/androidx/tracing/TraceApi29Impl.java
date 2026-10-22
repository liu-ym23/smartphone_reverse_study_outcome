package androidx.tracing;

/* JADX INFO: loaded from: classes6.dex */
final class TraceApi29Impl {
    public static boolean isEnabled() {
        return android.os.Trace.isEnabled();
    }

    private TraceApi29Impl() {
    }

    public static void beginAsyncSection(String r100, int r101) {
        android.os.Trace.beginAsyncSection(r100, r101);
    }

    public static void endAsyncSection(String r100, int r101) {
        android.os.Trace.endAsyncSection(r100, r101);
    }

    public static void setCounter(String r100, int r101) {
        android.os.Trace.setCounter(r100, r101);
    }
}
