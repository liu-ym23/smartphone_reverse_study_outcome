package androidx.concurrent.futures;

import androidx.exifinterface.media.ExifInterface;
import com.google.common.util.concurrent.ListenableFuture;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.ExecutionException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlinx.coroutines.i;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B#\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Landroidx/concurrent/futures/ToContinuation;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Runnable;", "", "run", "Lcom/google/common/util/concurrent/ListenableFuture;", "futureToObserve", "Lcom/google/common/util/concurrent/ListenableFuture;", "getFutureToObserve", "()Lcom/google/common/util/concurrent/ListenableFuture;", "Lkotlinx/coroutines/i;", "continuation", "Lkotlinx/coroutines/i;", "getContinuation", "()Lkotlinx/coroutines/i;", "<init>", "(Lcom/google/common/util/concurrent/ListenableFuture;Lkotlinx/coroutines/i;)V", "concurrent-futures-ktx"}, k = 1, mv = {1, 4, 0})
final class ToContinuation<T> implements Runnable {
    private final i<T> continuation;
    private final ListenableFuture<T> futureToObserve;

    @Override // java.lang.Runnable
    public void run() {
        androidx_concurrent_futures_ToContinuation_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void androidx_concurrent_futures_ToContinuation__run$___twin___() {
        if (this.futureToObserve.isCancelled() == false) goto L10;
        this.continuation.cancel(null);
        return;
    L10:
        i<T> r100 = this.continuation;     // Catch: ExecutionException -> L7
        Result.Companion r101 = Result.Companion;     // Catch: ExecutionException -> L7
        r100.resumeWith(Result.m9449constructorimpl(AbstractResolvableFuture.getUninterruptibly(this.futureToObserve)));     // Catch: ExecutionException -> L7
        return;
    L7:
        e = move-exception;
        i<T> r102 = this.continuation;
        Throwable r103 = ListenableFutureKt.access$nonNullCause(e);
        Result.Companion r104 = Result.Companion;
        r102.resumeWith(Result.m9449constructorimpl(ResultKt.createFailure(r103)));
    }

    public final i<T> getContinuation() {
        return this.continuation;
    }

    public final ListenableFuture<T> getFutureToObserve() {
        return this.futureToObserve;
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void androidx_concurrent_futures_ToContinuation_com_larus_apm_impl_protector_RunnableLancet_run(ToContinuation r100) {
        r100.androidx_concurrent_futures_ToContinuation__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ToContinuation(ListenableFuture<T> r100, i<? super T> r101) {
        this.futureToObserve = r100;
        this.continuation = r101;
    }
}
