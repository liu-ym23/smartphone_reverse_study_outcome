package kotlinx.coroutines.android;

import Z2.C0128h;
import Z2.InterfaceC0126g;
import Z2.K;
import Z2.L;
import Z2.T;
import Z2.y0;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u00008&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0001\u0001\b¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/android/HandlerDispatcher;", "LZ2/y0;", "LZ2/L;", "getImmediate", "()Lkotlinx/coroutines/android/HandlerDispatcher;", "immediate", "<init>", "()V", "Lkotlinx/coroutines/android/HandlerContext;", "kotlinx-coroutines-android"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes2.dex */
public abstract class HandlerDispatcher extends y0 implements L {
    public /* synthetic */ HandlerDispatcher(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated without replacement as an internal method never intended for public use")
    @Nullable
    public Object delay(long j4, @NotNull Continuation<? super Unit> continuation) {
        if (j4 <= 0) {
            return Unit.INSTANCE;
        }
        C0128h c0128h = new C0128h(1, IntrinsicsKt.intercepted(continuation));
        c0128h.u();
        scheduleResumeAfterDelay(j4, c0128h);
        Object objT = c0128h.t();
        if (objT == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return objT == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objT : Unit.INSTANCE;
    }

    @Override // Z2.y0
    @NotNull
    public abstract HandlerDispatcher getImmediate();

    @NotNull
    public T invokeOnTimeout(long j4, @NotNull Runnable runnable, @NotNull CoroutineContext coroutineContext) {
        return K.f2184a.invokeOnTimeout(j4, runnable, coroutineContext);
    }

    public abstract /* synthetic */ void scheduleResumeAfterDelay(long j4, @NotNull InterfaceC0126g interfaceC0126g);

    private HandlerDispatcher() {
    }
}
