package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.coroutines.d;
import kotlinx.coroutines.internal.Segment;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
final class SemaphoreSegment extends Segment<SemaphoreSegment> {
    private final /* synthetic */ AtomicReferenceArray acquirers;

    public SemaphoreSegment(long j10, SemaphoreSegment semaphoreSegment, int i10) {
        super(j10, semaphoreSegment, i10);
        this.acquirers = new AtomicReferenceArray(SemaphoreKt.SEGMENT_SIZE);
    }

    public final /* synthetic */ AtomicReferenceArray getAcquirers() {
        return this.acquirers;
    }

    @Override // kotlinx.coroutines.internal.Segment
    public int getNumberOfSlots() {
        return SemaphoreKt.SEGMENT_SIZE;
    }

    @Override // kotlinx.coroutines.internal.Segment
    public void onCancellation(int i10, Throwable th, d dVar) {
        getAcquirers().set(i10, SemaphoreKt.CANCELLED);
        onSlotCleaned();
    }

    public String toString() {
        return "SemaphoreSegment[id=" + this.f10114id + ", hashCode=" + hashCode() + ']';
    }
}
