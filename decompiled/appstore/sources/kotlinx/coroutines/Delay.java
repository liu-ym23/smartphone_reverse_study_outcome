package kotlinx.coroutines;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@InternalCoroutinesApi
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0097@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J$\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\n\u0010\n\u001a\u00060\u000bj\u0002`\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001e\u0010\u000f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0011H&\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/Delay;", "", "delay", "", "time", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "context", "Lkotlin/coroutines/CoroutineContext;", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface Delay {

    public static final class a {
        public static Object a(Delay r10, long r11, Continuation r12) {
            if (r11 <= 0) goto L5;
            n r13 = new n(IntrinsicsKt__IntrinsicsJvmKt.c(r12), 1);
            r13.initCancellability();
            r10.scheduleResumeAfterDelay(r11, r13);
            Object r14 = r13.q();
            if (r14 != kotlin.coroutines.intrinsics.a.d()) goto L10;
            tf.d.c(r12);
        L10:
            if (r14 != kotlin.coroutines.intrinsics.a.d()) goto L13;
            return r14;
        L13:
            return Unit.f21064a;
        L5:
            return Unit.f21064a;
        }

        public static DisposableHandle b(Delay r10, long r11, Runnable r12, CoroutineContext r13) {
            return g0.a().invokeOnTimeout(r11, r12, r13);
        }
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated without replacement as an internal method never intended for public use")
    @Nullable
    Object delay(long r10, @NotNull Continuation<? super Unit> r11);

    @NotNull
    DisposableHandle invokeOnTimeout(long r10, @NotNull Runnable r11, @NotNull CoroutineContext r12);

    void scheduleResumeAfterDelay(long r10, @NotNull CancellableContinuation<? super Unit> r11);
}
