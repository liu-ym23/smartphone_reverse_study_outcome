package kotlinx.coroutines.sync;

import androidx.exifinterface.media.ExifInterface;
import com.obric.contactsdk.loader.CallFeatureEntityUtilKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.SystemPropsKt;

/* JADX INFO: compiled from: Semaphore.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u001a\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\rH\u0002\u001a6\u0010\u0011\u001a\u0002H\u0012\"\u0004\b\u0000\u0010\u0012*\u00020\t2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0014H\u0086Hø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0015\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"BROKEN", "Lkotlinx/coroutines/internal/Symbol;", "CANCELLED", "MAX_SPIN_CYCLES", "", "PERMIT", "SEGMENT_SIZE", "TAKEN", "Semaphore", "Lkotlinx/coroutines/sync/Semaphore;", "permits", "acquiredPermits", "createSegment", "Lkotlinx/coroutines/sync/SemaphoreSegment;", "id", "", "prev", "withPermit", ExifInterface.GPS_DIRECTION_TRUE, CallFeatureEntityUtilKt.PARAM_KEY_ACTION, "Lkotlin/Function0;", "(Lkotlinx/coroutines/sync/Semaphore;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SemaphoreKt {
    private static final Symbol BROKEN = null;
    private static final Symbol CANCELLED = null;
    private static final int MAX_SPIN_CYCLES = 0;
    private static final Symbol PERMIT = null;
    private static final int SEGMENT_SIZE = 0;
    private static final Symbol TAKEN = null;

    /* JADX INFO: renamed from: kotlinx.coroutines.sync.SemaphoreKt$withPermit$1, reason: invalid class name */
    /* JADX INFO: compiled from: Semaphore.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 176)
    @DebugMetadata(c = "kotlinx.coroutines.sync.SemaphoreKt", f = "Semaphore.kt", i = {0, 0}, l = {86}, m = "withPermit", n = {"$this$withPermit", CallFeatureEntityUtilKt.PARAM_KEY_ACTION}, s = {"L$0", "L$1"})
    static final class AnonymousClass1<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> r1) {
            super(r1);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return SemaphoreKt.withPermit(null, null, this);
        }
    }

    public static final /* synthetic */ SemaphoreSegment access$createSegment(long r0, SemaphoreSegment r2) {
        return createSegment(r0, r2);
    }

    public static final /* synthetic */ Symbol access$getBROKEN$p() {
        return BROKEN;
    }

    public static final /* synthetic */ Symbol access$getCANCELLED$p() {
        return CANCELLED;
    }

    public static final /* synthetic */ int access$getMAX_SPIN_CYCLES$p() {
        return MAX_SPIN_CYCLES;
    }

    public static final /* synthetic */ Symbol access$getPERMIT$p() {
        return PERMIT;
    }

    public static final /* synthetic */ int access$getSEGMENT_SIZE$p() {
        return SEGMENT_SIZE;
    }

    public static final /* synthetic */ Symbol access$getTAKEN$p() {
        return TAKEN;
    }

    public static final Semaphore Semaphore(int r1, int r2) {
        return new SemaphoreImpl(r1, r2);
    }

    public static /* synthetic */ Semaphore Semaphore$default(int r0, int r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L6;
        r1 = 0;
    L6:
        return Semaphore(r0, r1);
    }

    public static final <T> Object withPermit(Semaphore r4, Function0<? extends T> r5, Continuation<? super T> r6) {
        if ((r6 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r6;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        r5 = (Function0) r0.L$1;
        r4 = (Semaphore) r0.L$0;
        ResultKt.throwOnFailure(r7);
    L23:
        T r8 = r5.invoke();     // Catch: Throwable -> L20
        InlineMarker.finallyStart(1);
        r4.release();
        InlineMarker.finallyEnd(1);
        return r8;
    L20:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r4.release();
        InlineMarker.finallyEnd(1);
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        r0.L$0 = r4;
        r0.L$1 = r5;
        r0.label = 1;
        if (r4.acquire(r0) != r1) goto L23;
        return r1;
    L7:
        r0 = new AnonymousClass1(r6);
        goto L8
    }

    private static final <T> Object withPermit$$forInline(Semaphore r1, Function0<? extends T> r2, Continuation<? super T> r3) {
        InlineMarker.mark(0);
        r1.acquire(r3);
        InlineMarker.mark(1);
        T r4 = r2.invoke();     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r1.release();
        InlineMarker.finallyEnd(1);
        return r4;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r1.release();
        InlineMarker.finallyEnd(1);
        throw th;
    }

    private static final SemaphoreSegment createSegment(long r2, SemaphoreSegment r4) {
        return new SemaphoreSegment(r2, r4, 0);
    }

    static {
        MAX_SPIN_CYCLES = SystemPropsKt.systemProp$default("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 0, 0, 12, null);
        PERMIT = new Symbol("PERMIT");
        TAKEN = new Symbol("TAKEN");
        BROKEN = new Symbol("BROKEN");
        CANCELLED = new Symbol("CANCELLED");
        SEGMENT_SIZE = SystemPropsKt.systemProp$default("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12, null);
    }
}
