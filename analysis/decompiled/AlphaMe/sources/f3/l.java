package f3;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.Volatile;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes2.dex */
public final class l {

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f12582b = AtomicReferenceFieldUpdater.newUpdater(l.class, Object.class, "lastScheduledTask");

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f12583c = AtomicIntegerFieldUpdater.newUpdater(l.class, "producerIndex");

    /* renamed from: d, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f12584d = AtomicIntegerFieldUpdater.newUpdater(l.class, "consumerIndex");

    /* renamed from: e, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f12585e = AtomicIntegerFieldUpdater.newUpdater(l.class, "blockingTasksInBuffer");

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReferenceArray f12586a = new AtomicReferenceArray(128);

    @Volatile
    private volatile int blockingTasksInBuffer;

    @Volatile
    private volatile int consumerIndex;

    @Volatile
    @Nullable
    private volatile Object lastScheduledTask;

    @Volatile
    private volatile int producerIndex;

    public final h a(h hVar) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f12583c;
        if (atomicIntegerFieldUpdater.get(this) - f12584d.get(this) == 127) {
            return hVar;
        }
        if (hVar.f12571b.f411a == 1) {
            f12585e.incrementAndGet(this);
        }
        int i4 = atomicIntegerFieldUpdater.get(this) & 127;
        while (true) {
            AtomicReferenceArray atomicReferenceArray = this.f12586a;
            if (atomicReferenceArray.get(i4) == null) {
                atomicReferenceArray.lazySet(i4, hVar);
                atomicIntegerFieldUpdater.incrementAndGet(this);
                return null;
            }
            Thread.yield();
        }
    }

    public final h b() {
        h hVar;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f12584d;
            int i4 = atomicIntegerFieldUpdater.get(this);
            if (i4 - f12583c.get(this) == 0) {
                return null;
            }
            int i5 = i4 & 127;
            if (atomicIntegerFieldUpdater.compareAndSet(this, i4, i4 + 1) && (hVar = (h) this.f12586a.getAndSet(i5, null)) != null) {
                if (hVar.f12571b.f411a == 1) {
                    f12585e.decrementAndGet(this);
                }
                return hVar;
            }
        }
    }

    public final h c(int i4, boolean z4) {
        int i5 = i4 & 127;
        AtomicReferenceArray atomicReferenceArray = this.f12586a;
        h hVar = (h) atomicReferenceArray.get(i5);
        if (hVar != null) {
            if ((hVar.f12571b.f411a == 1) == z4 && atomicReferenceArray.compareAndSet(i5, hVar, null)) {
                if (z4) {
                    f12585e.decrementAndGet(this);
                }
                return hVar;
            }
        }
        return null;
    }
}
