package androidx.work;

import com.google.common.util.concurrent.ListenableFuture;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.i;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n"}, d2 = {"R", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class ListenableFutureKt$await$2$1 implements Runnable {
    final /* synthetic */ i<R> $cancellableContinuation;
    final /* synthetic */ ListenableFuture<R> $this_await;

    /* JADX WARN: Multi-variable type inference failed */
    public ListenableFutureKt$await$2$1(i<? super R> r100, ListenableFuture<R> r101) {
        this.$cancellableContinuation = r100;
        this.$this_await = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        androidx_work_ListenableFutureKt$await$2$1_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public final void androidx_work_ListenableFutureKt$await$2$1__run$___twin___() {
        this.$cancellableContinuation.resumeWith(Result.m9449constructorimpl(this.$this_await.get()));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Throwable r100 = th.getCause();
        if (r100 != null) goto L9;
        r100 = th;
    L9:
        if ((th instanceof CancellationException) == false) goto L11;
        this.$cancellableContinuation.cancel(r100);
        return;
    L11:
        Continuation r101 = this.$cancellableContinuation;
        Result.Companion r102 = Result.Companion;
        r101.resumeWith(Result.m9449constructorimpl(ResultKt.createFailure(r100)));
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void androidx_work_ListenableFutureKt$await$2$1_com_larus_apm_impl_protector_RunnableLancet_run(ListenableFutureKt$await$2$1 r100) {
        r100.androidx_work_ListenableFutureKt$await$2$1__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
