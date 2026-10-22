package androidx.work;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.n;

/* JADX INFO: loaded from: classes.dex */
public abstract class OperationKt {
    public static final Object a(Operation r10, Continuation r11) {
        if ((r11 instanceof OperationKt$await$1) == false) goto L7;
        OperationKt$await$1 r12 = (OperationKt$await$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = kotlin.coroutines.intrinsics.a.d();
        int r16 = r12.label;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        ListenableFuture r17 = (ListenableFuture) r12.L$0;
        kotlin.c.b(r14);
    L29:
        Object r18 = r14;
    L30:
        q.f(r18, "result.await()");
        return r18;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        kotlin.c.b(r14);
        final ListenableFuture<Operation.b.c> r19 = r10.getResult();
        q.f(r19, "result");
        if (r19.isDone() == true) goto L32;
        r12.L$0 = r19;
        r12.label = 1;
        n r20 = new n(IntrinsicsKt__IntrinsicsJvmKt.c(r12), 1);
        r20.initCancellability();
        r19.addListener(new g(r20, r19), DirectExecutor.INSTANCE);
        r20.invokeOnCancellation(new ListenableFutureKt$await$2$2(r19));
        r14 = r20.q();
        if (r14 != kotlin.coroutines.intrinsics.a.d()) goto L27;
        tf.d.c(r12);
    L27:
        if (r14 != r15) goto L29;
        return r15;
    L32:
        r18 = r19.get();     // Catch: ExecutionException -> L18
    L18:
        e = move-exception;
        Throwable r21 = e.getCause();
        if (r21 != null) goto L23;
        throw e;
    L23:
        throw r21;
    L7:
        r12 = new OperationKt$await$1(r11);
        goto L8
    }
}
