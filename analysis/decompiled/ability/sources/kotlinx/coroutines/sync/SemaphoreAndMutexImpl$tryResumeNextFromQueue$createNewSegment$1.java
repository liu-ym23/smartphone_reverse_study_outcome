package kotlinx.coroutines.sync;

import S7.n;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import w9.g;
import w9.h;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
final /* synthetic */ class SemaphoreAndMutexImpl$tryResumeNextFromQueue$createNewSegment$1 extends FunctionReferenceImpl implements n {

    /* renamed from: a, reason: collision with root package name */
    public static final SemaphoreAndMutexImpl$tryResumeNextFromQueue$createNewSegment$1 f5260a = new SemaphoreAndMutexImpl$tryResumeNextFromQueue$createNewSegment$1();

    public SemaphoreAndMutexImpl$tryResumeNextFromQueue$createNewSegment$1() {
        super(2, g.class, "createSegment", "createSegment(JLkotlinx/coroutines/sync/SemaphoreSegment;)Lkotlinx/coroutines/sync/SemaphoreSegment;", 1);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        int i = g.f6856a;
        return new h(((Number) obj).longValue(), (h) obj2, 0);
    }
}
