package androidx.compose.runtime.internal;

import androidx.exifinterface.media.ExifInterface;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u000e\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u000fJ\u0015\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0013R \u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0014\u0010\n\u001a\u00060\u0002j\u0002`\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0012\u0010\r\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\f¨\u0006\u0014"}, d2 = {"Landroidx/compose/runtime/internal/SnapshotThreadLocal;", ExifInterface.GPS_DIRECTION_TRUE, "", "<init>", "()V", "map", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/runtime/internal/ThreadMap;", "Landroidx/compose/runtime/internal/AtomicReference;", "Ljava/util/concurrent/atomic/AtomicReference;", "writeMutex", "Landroidx/compose/runtime/platform/SynchronizedObject;", "Ljava/lang/Object;", "mainThreadValue", MonitorConstants.CONNECT_TYPE_GET, "()Ljava/lang/Object;", "set", "", "value", "(Ljava/lang/Object;)V", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SnapshotThreadLocal<T> {
    public static final int $stable = 8;
    private T mainThreadValue;
    private final AtomicReference<ThreadMap> map;
    private final Object writeMutex;

    public SnapshotThreadLocal() {
        this.map = new AtomicReference(SnapshotThreadLocalKt.access$getEmptyThreadMap$p());
        this.writeMutex = new Object();
    }

    public final T get() {
        long r100 = Thread_jvmKt.currentThreadId();
        if (r100 != Thread_androidKt.getMainThreadId()) goto L6;
        return this.mainThreadValue;
    L6:
        return (T) this.map.get().get(r100);
    }

    public final void set(T r100) {
        long r101 = Thread_jvmKt.currentThreadId();
        if (r101 != Thread_androidKt.getMainThreadId()) goto L5;
        this.mainThreadValue = r100;
        return;
    L5:
        Object r102 = this.writeMutex;
        monitor-enter(r102);
        ThreadMap r103 = this.map.get();     // Catch: Throwable -> L14
        if (r103.trySet(r101, r100) == false) goto L11;
        monitor-exit(r102);
        return;
    L11:
        this.map.set(r103.newWith(r101, r100));     // Catch: Throwable -> L14
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r102);
        return;
    L14:
        th = move-exception;
        throw th;
    }
}
