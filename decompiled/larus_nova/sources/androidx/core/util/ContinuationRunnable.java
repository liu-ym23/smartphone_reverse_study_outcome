package androidx.core.util;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\tH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/core/util/ContinuationRunnable;", "Ljava/lang/Runnable;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "continuation", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/coroutines/Continuation;)V", "run", "toString", "", "core-ktx_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class ContinuationRunnable extends AtomicBoolean implements Runnable {
    private final Continuation<Unit> continuation;

    public void androidx_core_util_ContinuationRunnable__run$___twin___() {
        if (compareAndSet(false, true) == false) goto L6;
        Continuation<Unit> r100 = this.continuation;
        Result.Companion r101 = Result.Companion;
        r100.resumeWith(Result.m9449constructorimpl(Unit.INSTANCE));
        return;
    }

    @Override // java.lang.Runnable
    public void run() {
        androidx_core_util_ContinuationRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public String toString() {
        return "ContinuationRunnable(ran = " + get() + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ContinuationRunnable(Continuation<? super Unit> r100) {
        super(false);
        this.continuation = r100;
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void androidx_core_util_ContinuationRunnable_com_larus_apm_impl_protector_RunnableLancet_run(ContinuationRunnable r100) {
        r100.androidx_core_util_ContinuationRunnable__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
