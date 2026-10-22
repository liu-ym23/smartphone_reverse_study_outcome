package rc;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f10567b = AtomicReferenceFieldUpdater.newUpdater(l.class, Object.class, "lastScheduledTask$volatile");

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f10568c = AtomicIntegerFieldUpdater.newUpdater(l.class, "producerIndex$volatile");

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f10569d = AtomicIntegerFieldUpdater.newUpdater(l.class, "consumerIndex$volatile");

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f10570e = AtomicIntegerFieldUpdater.newUpdater(l.class, "blockingTasksInBuffer$volatile");

    /* renamed from: a, reason: collision with root package name */
    public AtomicReferenceArray f10571a;
    private volatile /* synthetic */ int blockingTasksInBuffer$volatile;
    private volatile /* synthetic */ int consumerIndex$volatile;
    private volatile /* synthetic */ Object lastScheduledTask$volatile;
    private volatile /* synthetic */ int producerIndex$volatile;

    public final h a(h hVar) {
        AtomicReferenceArray atomicReferenceArray = this.f10571a;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f10568c;
        if (atomicIntegerFieldUpdater.get(this) - f10569d.get(this) == 127) {
            return hVar;
        }
        if (hVar.f10558f) {
            f10570e.incrementAndGet(this);
        }
        int i = atomicIntegerFieldUpdater.get(this) & 127;
        while (atomicReferenceArray.get(i) != null) {
            Thread.yield();
        }
        atomicReferenceArray.lazySet(i, hVar);
        atomicIntegerFieldUpdater.incrementAndGet(this);
        return null;
    }

    public final h b() {
        h hVar;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f10569d;
            int i = atomicIntegerFieldUpdater.get(this);
            if (i - f10568c.get(this) == 0) {
                return null;
            }
            int i3 = i & 127;
            if (atomicIntegerFieldUpdater.compareAndSet(this, i, i + 1) && (hVar = (h) this.f10571a.getAndSet(i3, null)) != null) {
                if (hVar.f10558f) {
                    f10570e.decrementAndGet(this);
                }
                return hVar;
            }
        }
    }

    public final h c(int i, boolean z10) {
        int i3 = i & 127;
        AtomicReferenceArray atomicReferenceArray = this.f10571a;
        h hVar = (h) atomicReferenceArray.get(i3);
        if (hVar == null || hVar.f10558f != z10 || !atomicReferenceArray.compareAndSet(i3, hVar, null)) {
            return null;
        }
        if (z10) {
            f10570e.decrementAndGet(this);
        }
        return hVar;
    }
}
