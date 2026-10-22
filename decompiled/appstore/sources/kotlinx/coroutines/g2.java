package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;

/* JADX INFO: loaded from: classes4.dex */
public abstract class g2 {
    public static final Object a(Continuation r10) {
        CoroutineContext r11 = r10.getContext();
        h1.h(r11);
        Continuation r12 = IntrinsicsKt__IntrinsicsJvmKt.c(r10);
        if ((r12 instanceof kotlinx.coroutines.internal.i) == false) goto L5;
        kotlinx.coroutines.internal.i r13 = (kotlinx.coroutines.internal.i) r12;
    L6:
        if (r13 != null) goto L9;
        Object r14 = Unit.f21064a;
    L19:
        if (r14 != kotlin.coroutines.intrinsics.a.d()) goto L22;
        tf.d.c(r10);
    L22:
        if (r14 != kotlin.coroutines.intrinsics.a.d()) goto L25;
        return r14;
    L25:
        return Unit.f21064a;
    L9:
        if (r13.f21594d.c(r11) == false) goto L11;
        r13.i(r11, Unit.f21064a);
    L17:
        r14 = kotlin.coroutines.intrinsics.a.d();
        goto L19
    L11:
        f2 r15 = new f2();
        CoroutineContext r16 = r11.plus(r15);
        Unit r17 = Unit.f21064a;
        r13.i(r16, r17);
        if (r15.f21425b == false) goto L17;
        if (kotlinx.coroutines.internal.j.d(r13) == false) goto L16;
        r14 = kotlin.coroutines.intrinsics.a.d();
        goto L19
    L16:
        r14 = r17;
        goto L19
    L5:
        r13 = null;
        goto L6
    }
}
