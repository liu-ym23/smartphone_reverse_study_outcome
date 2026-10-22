package androidx.concurrent.futures;

import androidx.exifinterface.media.ExifInterface;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\u001a!\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0003\u001a\f\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H\u0002\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"await", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/google/common/util/concurrent/ListenableFuture;", "(Lcom/google/common/util/concurrent/ListenableFuture;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "nonNullCause", "", "Ljava/util/concurrent/ExecutionException;", "concurrent-futures-ktx"}, k = 2, mv = {1, 1, 16})
public final class ListenableFutureKt {
    public static final /* synthetic */ Throwable access$nonNullCause(ExecutionException r100) {
        return nonNullCause(r100);
    }

    private static final Throwable nonNullCause(ExecutionException r100) {
        Throwable r101 = r100.getCause();
        if (r101 != null) goto L5;
        Intrinsics.throwNpe();
    L5:
        return r101;
    }

    public static final <T> Object await(final ListenableFuture<T> r100, Continuation<? super T> r101) {
    L10:
        e = move-exception;
        throw nonNullCause(e);
    L3:
        if (r100.isDone() == false) goto L6;
        return AbstractResolvableFuture.getUninterruptibly(r100);
    L6:
        j r102 = new j(IntrinsicsKt.intercepted(r101), 1);
        r100.addListener(new ToContinuation(r100, r102), DirectExecutor.INSTANCE);
        r102.i(new ListenableFutureKt$await$$inlined$suspendCancellableCoroutine$lambda$1(r100));
        Object r103 = r102.B();
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        DebugProbesKt.probeCoroutineSuspended(r101);
    L9:
        return r103;
    }
}
