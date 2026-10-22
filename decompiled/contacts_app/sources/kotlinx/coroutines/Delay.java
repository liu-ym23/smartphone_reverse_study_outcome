package kotlinx.coroutines;

import com.bytedance.framwork.core.sdklib.DBHelper;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;

/* JADX INFO: compiled from: Delay.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0097@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J$\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\n\u0010\n\u001a\u00060\u000bj\u0002`\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001e\u0010\u000f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0011H&\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/Delay;", "", "delay", "", DBHelper.COL_TIME, "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "context", "Lkotlin/coroutines/CoroutineContext;", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface Delay {

    /* JADX INFO: compiled from: Delay.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated without replacement as an internal method never intended for public use")
        public static Object delay(Delay r3, long r4, Continuation<? super Unit> r6) {
            if (r4 <= 0) goto L5;
            CancellableContinuationImpl r0 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(r6), 1);
            r0.initCancellability();
            r3.mo2377scheduleResumeAfterDelay(r4, r0);
            Object r5 = r0.getResult();
            if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
            DebugProbesKt.probeCoroutineSuspended(r6);
        L10:
            if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L13;
            return r5;
        L13:
            return Unit.INSTANCE;
        L5:
            return Unit.INSTANCE;
        }

        public static DisposableHandle invokeOnTimeout(Delay r0, long r1, Runnable r3, CoroutineContext r4) {
            return DefaultExecutorKt.getDefaultDelay().invokeOnTimeout(r1, r3, r4);
        }
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated without replacement as an internal method never intended for public use")
    Object delay(long r1, Continuation<? super Unit> r3);

    DisposableHandle invokeOnTimeout(long r1, Runnable r3, CoroutineContext r4);

    /* JADX INFO: renamed from: scheduleResumeAfterDelay */
    void mo2377scheduleResumeAfterDelay(long r1, CancellableContinuation<? super Unit> r3);
}
