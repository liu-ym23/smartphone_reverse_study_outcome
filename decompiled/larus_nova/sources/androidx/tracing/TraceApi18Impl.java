package androidx.tracing;

/* JADX INFO: loaded from: classes3.dex */
final class TraceApi18Impl {
    private TraceApi18Impl() {
    }

    public static void endSection() {
        android.os.Trace.endSection();
    }

    public static void beginSection(String r100) {
        android.os.Trace.beginSection(r100);
    }
}
