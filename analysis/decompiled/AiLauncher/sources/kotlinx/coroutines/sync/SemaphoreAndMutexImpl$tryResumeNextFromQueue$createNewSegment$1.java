package kotlinx.coroutines.sync;

import eb.j;
import eb.k;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import p9.p;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* synthetic */ class SemaphoreAndMutexImpl$tryResumeNextFromQueue$createNewSegment$1 extends FunctionReferenceImpl implements p<Long, k, k> {

    /* renamed from: a, reason: collision with root package name */
    public static final SemaphoreAndMutexImpl$tryResumeNextFromQueue$createNewSegment$1 f36826a = new SemaphoreAndMutexImpl$tryResumeNextFromQueue$createNewSegment$1();

    public SemaphoreAndMutexImpl$tryResumeNextFromQueue$createNewSegment$1() {
        super(2, j.class, "createSegment", "createSegment(JLkotlinx/coroutines/sync/SemaphoreSegment;)Lkotlinx/coroutines/sync/SemaphoreSegment;", 1);
    }

    @Override // p9.p
    public /* bridge */ /* synthetic */ k invoke(Long l10, k kVar) {
        return l(l10.longValue(), kVar);
    }

    public final k l(long j10, k kVar) {
        return j.j(j10, kVar);
    }
}
