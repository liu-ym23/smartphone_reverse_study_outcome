package kotlinx.coroutines.flow;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes4.dex */
public abstract /* synthetic */ class FlowKt__ErrorsKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final Object a(Flow r10, FlowCollector r11, Continuation r12) {
        if ((r12 instanceof FlowKt__ErrorsKt$catchImpl$1) == false) goto L7;
        FlowKt__ErrorsKt$catchImpl$1 r13 = (FlowKt__ErrorsKt$catchImpl$1) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = kotlin.coroutines.intrinsics.a.d();
        int r17 = r13.label;
        if (r17 == 0) goto L18;
        if (r17 != 1) goto L17;
        Ref$ObjectRef r18 = (Ref$ObjectRef) r13.L$0;
        kotlin.c.b(r15);     // Catch: Throwable -> L14
        return null;
    L14:
        th = th;
    L26:
        Throwable r19 = (Throwable) r18.element;
        if (c(th, r19) == false) goto L29;
    L38:
        throw th;
    L29:
        if (b(th, r13.getContext()) == true) goto L38;
        if (r19 != null) goto L33;
        return th;
    L33:
        if ((th instanceof CancellationException) == false) goto L36;
        kotlin.a.a(r19, th);
        throw r19;
    L36:
        kotlin.a.a(th, r19);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        kotlin.c.b(r15);
        Ref$ObjectRef r20 = new Ref$ObjectRef();
        FlowKt__ErrorsKt$catchImpl$2 r21 = new FlowKt__ErrorsKt$catchImpl$2(r11, r20);     // Catch: Throwable -> L24
        r13.L$0 = r20;     // Catch: Throwable -> L24
        r13.label = 1;     // Catch: Throwable -> L24
        if (r10.collect(r21, r13) != r16) goto L22;
        return r16;
    L22:
        return null;
    L24:
        th = th;
        r18 = r20;
    L7:
        r13 = new FlowKt__ErrorsKt$catchImpl$1(r12);
        goto L8
    }

    public static final boolean b(Throwable r10, CoroutineContext r11) {
        Job r12 = (Job) r11.get(Job.Key);
        if (r12 != null) goto L5;
        return false;
    L5:
        if (r12.isCancelled() == true) goto L8;
        return false;
    L8:
        return c(r10, r12.getCancellationException());
    }

    public static final boolean c(Throwable r10, Throwable r11) {
        if (r11 != null) goto L4;
    L6:
        return false;
    L4:
        if (kotlin.jvm.internal.q.b(r11, r10) == false) goto L6;
        return true;
    }
}
