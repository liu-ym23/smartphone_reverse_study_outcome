package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.framwork.core.sdklib.DBHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.intrinsics.UndispatchedKt;

/* JADX INFO: compiled from: Timeout.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a_\u0010\b\u001a\u0004\u0018\u00010\t\"\u0004\b\u0000\u0010\n\"\b\b\u0001\u0010\u000b*\u0002H\n2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000b0\f2'\u0010\r\u001a#\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000e¢\u0006\u0002\b\u0011H\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001aU\u0010\u0013\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b2\u0006\u0010\u0014\u001a\u00020\u00032'\u0010\r\u001a#\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000e¢\u0006\u0002\b\u0011H\u0086@ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u0010\u0015\u001a]\u0010\u0013\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b2\u0006\u0010\u0016\u001a\u00020\u00172'\u0010\r\u001a#\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000e¢\u0006\u0002\b\u0011H\u0086@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\b\u0018\u0010\u0015\u001aJ\u0010\u0019\u001a\u0004\u0018\u0001H\u000b\"\u0004\b\u0000\u0010\u000b2\u0006\u0010\u0014\u001a\u00020\u00032'\u0010\r\u001a#\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000e¢\u0006\u0002\b\u0011H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0015\u001aR\u0010\u0019\u001a\u0004\u0018\u0001H\u000b\"\u0004\b\u0000\u0010\u000b2\u0006\u0010\u0016\u001a\u00020\u00172'\u0010\r\u001a#\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000e¢\u0006\u0002\b\u0011H\u0086@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0015\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, d2 = {"TimeoutCancellationException", "Lkotlinx/coroutines/TimeoutCancellationException;", DBHelper.COL_TIME, "", "delay", "Lkotlinx/coroutines/Delay;", "coroutine", "Lkotlinx/coroutines/Job;", "setupTimeout", "", "U", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/TimeoutCoroutine;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/TimeoutCoroutine;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "withTimeout", "timeMillis", "(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "timeout", "Lkotlin/time/Duration;", "withTimeout-KLykuaI", "withTimeoutOrNull", "withTimeoutOrNull-KLykuaI", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TimeoutKt {

    /* JADX INFO: renamed from: kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1, reason: invalid class name */
    /* JADX INFO: compiled from: Timeout.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.TimeoutKt", f = "Timeout.kt", i = {0, 0, 0}, l = {104}, m = "withTimeoutOrNull", n = {"block", "coroutine", "timeMillis"}, s = {"L$0", "L$1", "J$0"})
    static final class AnonymousClass1<T> extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> r1) {
            super(r1);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return TimeoutKt.withTimeoutOrNull(0, null, this);
        }
    }

    public static final <T> Object withTimeout(long r2, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> r4, Continuation<? super T> r5) {
        if (r2 <= 0) goto L9;
        Object r3 = setupTimeout(new TimeoutCoroutine(r2, r5), r4);
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L7;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L7:
        return r3;
    L9:
        throw new TimeoutCancellationException("Timed out immediately");
    }

    /* JADX INFO: renamed from: withTimeout-KLykuaI, reason: not valid java name */
    public static final <T> Object m2317withTimeoutKLykuaI(long r0, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> r2, Continuation<? super T> r3) {
        return withTimeout(DelayKt.m2309toDelayMillisLRDsOJo(r0), r2, r3);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [T, kotlinx.coroutines.TimeoutCoroutine] */
    public static final <T> Object withTimeoutOrNull(long r7, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> r9, Continuation<? super T> r10) {
        if ((r10 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r10;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L18;
        if (r2 != 1) goto L17;
        long r8 = r0.J$0;
        Ref.ObjectRef r12 = (Ref.ObjectRef) r0.L$1;
        Function2 r13 = (Function2) r0.L$0;
        ResultKt.throwOnFailure(r11);     // Catch: TimeoutCancellationException -> L14
        return r11;
    L14:
        e = e;
    L32:
        if (e.coroutine != r12.element) goto L34;
        return null;
    L34:
        throw e;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r11);
        if (r7 > 0) goto L21;
        return null;
    L21:
        Ref.ObjectRef r14 = new Ref.ObjectRef();
        r0.L$0 = r9;     // Catch: TimeoutCancellationException -> L29
        r0.L$1 = r14;     // Catch: TimeoutCancellationException -> L29
        r0.J$0 = r7;     // Catch: TimeoutCancellationException -> L29
        r0.label = 1;     // Catch: TimeoutCancellationException -> L29
        ?? r4 = (T) new TimeoutCoroutine(r7, r0);
        r14.element = r4;     // Catch: TimeoutCancellationException -> L29
        Object r15 = setupTimeout(r4, r9);     // Catch: TimeoutCancellationException -> L29
        if (r15 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L25;
        DebugProbesKt.probeCoroutineSuspended(r0);     // Catch: TimeoutCancellationException -> L29
    L25:
        if (r15 != r1) goto L28;
        return r1;
    L28:
        return r15;
    L29:
        e = e;
        r12 = r14;
    L7:
        r0 = new AnonymousClass1(r10);
        goto L8
    }

    /* JADX INFO: renamed from: withTimeoutOrNull-KLykuaI, reason: not valid java name */
    public static final <T> Object m2318withTimeoutOrNullKLykuaI(long r0, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> r2, Continuation<? super T> r3) {
        return withTimeoutOrNull(DelayKt.m2309toDelayMillisLRDsOJo(r0), r2, r3);
    }

    private static final <U, T extends U> Object setupTimeout(TimeoutCoroutine<U, ? super T> r6, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> r7) {
        JobKt.disposeOnCompletion(r6, DelayKt.getDelay(r6.uCont.getContext()).invokeOnTimeout(r6.time, r6, r6.getContext()));
        return UndispatchedKt.startUndispatchedOrReturnIgnoreTimeout(r6, r6, r7);
    }

    public static final TimeoutCancellationException TimeoutCancellationException(long r2, Delay r4, Job r5) {
        if ((r4 instanceof DelayWithTimeoutDiagnostics) == false) goto L5;
        DelayWithTimeoutDiagnostics r6 = (DelayWithTimeoutDiagnostics) r4;
    L6:
        if (r6 == null) goto L9;
        Duration.Companion r0 = Duration.Companion;
        String r7 = r6.m2310timeoutMessageLRDsOJo(DurationKt.toDuration(r2, DurationUnit.MILLISECONDS));
        if (r7 == null) goto L9;
    L11:
        return new TimeoutCancellationException(r7, r5);
    L9:
        r7 = "Timed out waiting for " + r2 + " ms";
        goto L11
    L5:
        r6 = null;
        goto L6
    }
}
