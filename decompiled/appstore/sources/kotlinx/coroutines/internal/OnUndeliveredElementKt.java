package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes4.dex */
public abstract class OnUndeliveredElementKt {
    public static final Function1 a(final Function1 r10, final Object r11, final CoroutineContext r12) {
        return new OnUndeliveredElementKt$bindCancellationFun$1(r10, r11, r12);
    }

    public static final void b(Function1 r10, Object r11, CoroutineContext r12) {
        UndeliveredElementException r13 = c(r10, r11, null);
        if (r13 == null) goto L6;
        kotlinx.coroutines.a0.a(r12, r13);
        return;
    }

    public static final UndeliveredElementException c(Function1 r10, Object r11, UndeliveredElementException r12) {
        r10.invoke(r11);     // Catch: Throwable -> L4
    L9:
        return r12;
    L4:
        th = move-exception;
        if (r12 == null) goto L11;
        if (r12.getCause() == th) goto L11;
        kotlin.a.a(r12, th);
    L11:
        return new UndeliveredElementException("Exception in undelivered element handler for " + r11, th);
    }

    public static /* synthetic */ UndeliveredElementException d(Function1 r10, Object r11, UndeliveredElementException r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = null;
    L6:
        return c(r10, r11, r12);
    }
}
