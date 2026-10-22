package androidx.compose.runtime.snapshots;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateObserverLoggerProvider;", "Landroidx/compose/runtime/snapshots/SnapshotStateObserverLogger;", "<init>", "()V", "logger", "onNonUIThread", "", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SnapshotStateObserverLoggerProvider implements SnapshotStateObserverLogger {
    public static final int $stable = 0;
    public static final SnapshotStateObserverLoggerProvider INSTANCE = null;
    private static SnapshotStateObserverLogger logger;

    static {
        INSTANCE = new SnapshotStateObserverLoggerProvider();
        $stable = 8;
    }

    private SnapshotStateObserverLoggerProvider() {
    }

    @Override // androidx.compose.runtime.snapshots.SnapshotStateObserverLogger
    public void onNonUIThread() {
        SnapshotStateObserverLogger r100 = logger;
        if (r100 == null) goto L6;
        r100.onNonUIThread();
        return;
    }
}
