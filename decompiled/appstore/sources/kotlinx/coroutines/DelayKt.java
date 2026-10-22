package kotlinx.coroutines;

import kotlin.KotlinNothingValueException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;

/* JADX INFO: loaded from: classes4.dex */
public abstract class DelayKt {
    public static final Object a(Continuation r10) {
        if ((r10 instanceof DelayKt$awaitCancellation$1) == false) goto L7;
        DelayKt$awaitCancellation$1 r11 = (DelayKt$awaitCancellation$1) r10;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = kotlin.coroutines.intrinsics.a.d();
        int r15 = r11.label;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L12;
        kotlin.c.b(r13);
    L20:
        throw new KotlinNothingValueException();
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        kotlin.c.b(r13);
        r11.label = 1;
        n r16 = new n(IntrinsicsKt__IntrinsicsJvmKt.c(r11), 1);
        r16.initCancellability();
        Object r17 = r16.q();
        if (r17 != kotlin.coroutines.intrinsics.a.d()) goto L17;
        tf.d.c(r11);
    L17:
        if (r17 != r14) goto L20;
        return r14;
    L7:
        r11 = new DelayKt$awaitCancellation$1(r10);
        goto L8
    }

    public static final Object b(long r10, Continuation r11) {
        if (r10 <= 0) goto L5;
        n r12 = new n(IntrinsicsKt__IntrinsicsJvmKt.c(r11), 1);
        r12.initCancellability();
        if (r10 >= Long.MAX_VALUE) goto L9;
        c(r12.getContext()).scheduleResumeAfterDelay(r10, r12);
    L9:
        Object r13 = r12.q();
        if (r13 != kotlin.coroutines.intrinsics.a.d()) goto L13;
        tf.d.c(r11);
    L13:
        if (r13 != kotlin.coroutines.intrinsics.a.d()) goto L16;
        return r13;
    L16:
        return Unit.f21064a;
    L5:
        return Unit.f21064a;
    }

    public static final Delay c(CoroutineContext r10) {
        CoroutineContext.Element r11 = r10.get(ContinuationInterceptor.Key);
        if ((r11 instanceof Delay) == false) goto L5;
        Delay r12 = (Delay) r11;
    L6:
        if (r12 == null) goto L8;
        return r12;
    L8:
        return g0.a();
    L5:
        r12 = null;
        goto L6
    }

    public static final long d(long r10) {
        if (kotlin.time.b.c(r10, kotlin.time.b.f21273a.a()) > 0) goto L7;
        return 0;
    L7:
        return bg.h.e(kotlin.time.b.i(r10), 1);
    }
}
