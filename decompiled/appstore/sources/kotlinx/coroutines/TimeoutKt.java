package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.time.DurationUnit;

/* JADX INFO: loaded from: classes4.dex */
public abstract class TimeoutKt {
    public static final TimeoutCancellationException a(long r10, Delay r11, Job r12) {
        if ((r11 instanceof DelayWithTimeoutDiagnostics) == false) goto L5;
        DelayWithTimeoutDiagnostics r13 = (DelayWithTimeoutDiagnostics) r11;
    L6:
        if (r13 == null) goto L9;
        kotlin.time.b.a r14 = kotlin.time.b.f21273a;
        String r15 = r13.m50timeoutMessageLRDsOJo(kotlin.time.d.h(r10, DurationUnit.MILLISECONDS));
        if (r15 == null) goto L9;
    L11:
        return new TimeoutCancellationException(r15, r12);
    L9:
        r15 = "Timed out waiting for " + r10 + " ms";
        goto L11
    L5:
        r13 = null;
        goto L6
    }

    public static final Object b(b2 r10, Function2 r11) {
        h1.g(r10, DelayKt.c(r10.f21628d.getContext()).invokeOnTimeout(r10.f21317e, r10, r10.getContext()));
        return cg.b.d(r10, r10, r11);
    }

    public static final Object c(long r10, Function2 r11, Continuation r12) {
        if (r10 <= 0) goto L9;
        Object r13 = b(new b2(r10, r12), r11);
        if (r13 != kotlin.coroutines.intrinsics.a.d()) goto L7;
        tf.d.c(r12);
    L7:
        return r13;
    L9:
        throw new TimeoutCancellationException("Timed out immediately");
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, kotlinx.coroutines.b2] */
    public static final Object d(long r10, Function2 r11, Continuation r12) {
        if ((r12 instanceof TimeoutKt$withTimeoutOrNull$1) == false) goto L7;
        TimeoutKt$withTimeoutOrNull$1 r13 = (TimeoutKt$withTimeoutOrNull$1) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = kotlin.coroutines.intrinsics.a.d();
        int r17 = r13.label;
        if (r17 == 0) goto L18;
        if (r17 != 1) goto L17;
        Ref$ObjectRef r18 = (Ref$ObjectRef) r13.L$1;
        Function2 r19 = (Function2) r13.L$0;
        kotlin.c.b(r15);     // Catch: TimeoutCancellationException -> L14
        return r15;
    L14:
        e = e;
    L33:
        if (e.coroutine != r18.element) goto L35;
        return null;
    L35:
        throw e;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        kotlin.c.b(r15);
        if (r10 > 0) goto L21;
        return null;
    L21:
        Ref$ObjectRef r110 = new Ref$ObjectRef();
        r13.L$0 = r11;     // Catch: TimeoutCancellationException -> L26
        r13.L$1 = r110;     // Catch: TimeoutCancellationException -> L26
        r13.J$0 = r10;     // Catch: TimeoutCancellationException -> L26
        r13.label = 1;     // Catch: TimeoutCancellationException -> L26
        ?? r20 = new b2(r10, r13);     // Catch: TimeoutCancellationException -> L26
        r110.element = r20;     // Catch: TimeoutCancellationException -> L26
        Object r21 = b(r20, r11);     // Catch: TimeoutCancellationException -> L26
        if (r21 != kotlin.coroutines.intrinsics.a.d()) goto L28;
        tf.d.c(r13);     // Catch: TimeoutCancellationException -> L26
    L28:
        if (r21 != r16) goto L31;
        return r16;
    L31:
        return r21;
    L26:
        e = e;
        r18 = r110;
    L7:
        r13 = new TimeoutKt$withTimeoutOrNull$1(r12);
        goto L8
    }
}
