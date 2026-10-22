package kotlin.coroutines.intrinsics;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.q;
import tf.d;

/* JADX INFO: loaded from: classes4.dex */
public abstract class IntrinsicsKt__IntrinsicsJvmKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static Continuation a(final Function1 r10, Continuation r11) {
        q.g(r10, "<this>");
        q.g(r11, "completion");
        final Continuation<?> r12 = d.a(r11);
        if ((r10 instanceof BaseContinuationImpl) == true) goto L10;
        final CoroutineContext r13 = r12.getContext();
        if (r13 != EmptyCoroutineContext.INSTANCE) goto L9;
        return new IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$1(r12, r10);
    L9:
        return new IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$2(r12, r13, r10);
    L10:
        return ((BaseContinuationImpl) r10).create(r12);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Continuation b(final Function2 r10, final Object r11, Continuation r12) {
        q.g(r10, "<this>");
        q.g(r12, "completion");
        final Continuation<?> r13 = d.a(r12);
        if ((r10 instanceof BaseContinuationImpl) == true) goto L10;
        final CoroutineContext r14 = r13.getContext();
        if (r14 != EmptyCoroutineContext.INSTANCE) goto L9;
        return new IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$3(r13, r10, r11);
    L9:
        return new IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$4(r13, r14, r10, r11);
    L10:
        return ((BaseContinuationImpl) r10).create(r11, r13);
    }

    public static Continuation c(Continuation r10) {
        q.g(r10, "<this>");
        if ((r10 instanceof ContinuationImpl) == false) goto L5;
        ContinuationImpl r11 = (ContinuationImpl) r10;
    L6:
        if (r11 == null) goto L12;
        Continuation<Object> r12 = r11.intercepted();
        if (r12 != null) goto L11;
        return r10;
    L11:
        return r12;
    L12:
        return r10;
    L5:
        r11 = null;
        goto L6
    }
}
