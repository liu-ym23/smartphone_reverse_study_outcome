package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import com.bytedance.apm.constant.PerfConsts;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: LockFreeTaskQueue.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0010\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00028\u0000¢\u0006\u0002\u0010\u0012J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0004J&\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00180\u0017\"\u0004\b\u0001\u0010\u00182\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u00180\u001aJ\r\u0010\u001b\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u001cR\u001f\u0010\u0006\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00028\u00000\bj\b\u0012\u0004\u0012\u00028\u0000`\t0\u0007X\u0082\u0004R\u0011\u0010\n\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueue;", ExifInterface.LONGITUDE_EAST, "", "singleConsumer", "", "(Z)V", "_cur", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "Lkotlinx/coroutines/internal/Core;", "isEmpty", "()Z", PerfConsts.PERF_DISK_FILE_SIZE, "", "getSize", "()I", "addLast", "element", "(Ljava/lang/Object;)Z", "close", "", "isClosed", "map", "", "R", "transform", "Lkotlin/Function1;", "removeFirstOrNull", "()Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class LockFreeTaskQueue<E> {
    private static final AtomicReferenceFieldUpdater _cur$FU = null;

    @Volatile
    private volatile Object _cur;

    static {
        _cur$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeTaskQueue.class, Object.class, "_cur");
    }

    private final void loop$atomicfu(AtomicReferenceFieldUpdater r1, Function1<Object, Unit> r2, Object r3) {
    L2:
        r2.invoke(r1.get(r3));
        goto L2
    }

    public LockFreeTaskQueue(boolean r3) {
        this._cur = new LockFreeTaskQueueCore(8, r3);
    }

    public final boolean isEmpty() {
        return ((LockFreeTaskQueueCore) _cur$FU.get(this)).isEmpty();
    }

    public final int getSize() {
        return ((LockFreeTaskQueueCore) _cur$FU.get(this)).getSize();
    }

    public final void close() {
        AtomicReferenceFieldUpdater r0 = _cur$FU;
    L3:
        LockFreeTaskQueueCore r1 = (LockFreeTaskQueueCore) r0.get(this);
        if (r1.close() == true) goto L5;
        LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(_cur$FU, this, r1, r1.next());
        goto L3
    }

    public final boolean addLast(E r5) {
        AtomicReferenceFieldUpdater r0 = _cur$FU;
    L3:
        LockFreeTaskQueueCore r1 = (LockFreeTaskQueueCore) r0.get(this);
        int r2 = r1.addLast(r5);
        if (r2 == 0) goto L12;
        if (r2 != 1) goto L7;
        LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(_cur$FU, this, r1, r1.next());
        goto L3
    L7:
        if (r2 != 2) goto L3;
        return false;
    L12:
        return true;
    }

    public final E removeFirstOrNull() {
        AtomicReferenceFieldUpdater r0 = _cur$FU;
    L3:
        LockFreeTaskQueueCore r1 = (LockFreeTaskQueueCore) r0.get(this);
        E r2 = (E) r1.removeFirstOrNull();
        if (r2 != LockFreeTaskQueueCore.REMOVE_FROZEN) goto L5;
        LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(_cur$FU, this, r1, r1.next());
        goto L3
    L5:
        return r2;
    }

    public final <R> List<R> map(Function1<? super E, ? extends R> r2) {
        return ((LockFreeTaskQueueCore) _cur$FU.get(this)).map(r2);
    }

    public final boolean isClosed() {
        return ((LockFreeTaskQueueCore) _cur$FU.get(this)).isClosed();
    }
}
