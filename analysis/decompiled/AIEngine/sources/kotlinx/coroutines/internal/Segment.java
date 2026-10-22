package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.d;
import kotlinx.coroutines.NotCompleted;
import kotlinx.coroutines.internal.Segment;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class Segment<S extends Segment<S>> extends ConcurrentLinkedListNode<S> implements NotCompleted {
    private static final /* synthetic */ AtomicIntegerFieldUpdater cleanedAndPointers$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(Segment.class, "cleanedAndPointers$volatile");
    private volatile /* synthetic */ int cleanedAndPointers$volatile;

    /* renamed from: id, reason: collision with root package name */
    public final long f10114id;

    public Segment(long j10, S s8, int i10) {
        super(s8);
        this.f10114id = j10;
        this.cleanedAndPointers$volatile = i10 << 16;
    }

    public final boolean decPointers$kotlinx_coroutines_core() {
        return cleanedAndPointers$volatile$FU.addAndGet(this, -65536) == getNumberOfSlots() && !isTail();
    }

    public abstract int getNumberOfSlots();

    @Override // kotlinx.coroutines.internal.ConcurrentLinkedListNode
    public boolean isRemoved() {
        return cleanedAndPointers$volatile$FU.get(this) == getNumberOfSlots() && !isTail();
    }

    public abstract void onCancellation(int i10, Throwable th, d dVar);

    public final void onSlotCleaned() {
        if (cleanedAndPointers$volatile$FU.incrementAndGet(this) == getNumberOfSlots()) {
            remove();
        }
    }

    public final boolean tryIncPointers$kotlinx_coroutines_core() {
        int i10;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = cleanedAndPointers$volatile$FU;
        do {
            i10 = atomicIntegerFieldUpdater.get(this);
            if (i10 == getNumberOfSlots() && !isTail()) {
                return false;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i10, 65536 + i10));
        return true;
    }
}
