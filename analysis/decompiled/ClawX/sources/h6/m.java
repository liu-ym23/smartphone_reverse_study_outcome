package h6;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f3071b = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "lastScheduledTask$volatile");

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f3072c = AtomicIntegerFieldUpdater.newUpdater(m.class, "producerIndex$volatile");
    public static final /* synthetic */ AtomicIntegerFieldUpdater d = AtomicIntegerFieldUpdater.newUpdater(m.class, "consumerIndex$volatile");

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f3073e = AtomicIntegerFieldUpdater.newUpdater(m.class, "blockingTasksInBuffer$volatile");

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReferenceArray f3074a = new AtomicReferenceArray(128);
    private volatile /* synthetic */ int blockingTasksInBuffer$volatile;
    private volatile /* synthetic */ int consumerIndex$volatile;
    private volatile /* synthetic */ Object lastScheduledTask$volatile;
    private volatile /* synthetic */ int producerIndex$volatile;

    public final i a(i iVar) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f3072c;
        if (atomicIntegerFieldUpdater.get(this) - d.get(this) == 127) {
            return iVar;
        }
        if (iVar.f3063b) {
            f3073e.incrementAndGet(this);
        }
        int i8 = atomicIntegerFieldUpdater.get(this) & 127;
        while (true) {
            AtomicReferenceArray atomicReferenceArray = this.f3074a;
            if (atomicReferenceArray.get(i8) == null) {
                atomicReferenceArray.lazySet(i8, iVar);
                atomicIntegerFieldUpdater.incrementAndGet(this);
                return null;
            }
            Thread.yield();
        }
    }

    public final i b() {
        i iVar;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = d;
            int i8 = atomicIntegerFieldUpdater.get(this);
            if (i8 - f3072c.get(this) == 0) {
                return null;
            }
            int i9 = i8 & 127;
            if (atomicIntegerFieldUpdater.compareAndSet(this, i8, i8 + 1) && (iVar = (i) this.f3074a.getAndSet(i9, null)) != null) {
                if (iVar.f3063b) {
                    f3073e.decrementAndGet(this);
                }
                return iVar;
            }
        }
    }

    public final i c(int i8, boolean z) {
        int i9 = i8 & 127;
        AtomicReferenceArray atomicReferenceArray = this.f3074a;
        i iVar = (i) atomicReferenceArray.get(i9);
        if (iVar != null && iVar.f3063b == z) {
            while (!atomicReferenceArray.compareAndSet(i9, iVar, null)) {
                if (atomicReferenceArray.get(i9) != iVar) {
                }
            }
            if (z) {
                f3073e.decrementAndGet(this);
            }
            return iVar;
        }
        return null;
    }
}
