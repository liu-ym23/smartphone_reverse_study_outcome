package kotlinx.coroutines.sync;

import kotlin.jvm.internal.FunctionReferenceImpl;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public /* synthetic */ class SemaphoreAndMutexImpl$tryResumeNextFromQueue$createNewSegment$1 extends FunctionReferenceImpl implements p<Long, SemaphoreSegment, SemaphoreSegment> {
    public static final SemaphoreAndMutexImpl$tryResumeNextFromQueue$createNewSegment$1 INSTANCE = new SemaphoreAndMutexImpl$tryResumeNextFromQueue$createNewSegment$1();

    public SemaphoreAndMutexImpl$tryResumeNextFromQueue$createNewSegment$1() {
        super(2, SemaphoreKt.class, "createSegment", "createSegment(JLkotlinx/coroutines/sync/SemaphoreSegment;)Lkotlinx/coroutines/sync/SemaphoreSegment;", 1);
    }

    @Override // zb.p
    public /* bridge */ /* synthetic */ SemaphoreSegment invoke(Long l10, SemaphoreSegment semaphoreSegment) {
        return invoke(l10.longValue(), semaphoreSegment);
    }

    public final SemaphoreSegment invoke(long j10, SemaphoreSegment semaphoreSegment) {
        return SemaphoreKt.createSegment(j10, semaphoreSegment);
    }
}
