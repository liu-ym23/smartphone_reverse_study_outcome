package cg;

import kotlin.Result;
import kotlin.c;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.internal.x;
import kotlinx.coroutines.l1;
import kotlinx.coroutines.w;
import tf.d;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b {
    public static final void a(Function1 r10, Continuation r11) {
        Continuation r12 = d.a(r11);
        CoroutineContext r13 = r11.getContext();     // Catch: Throwable -> L10
        Object r14 = ThreadContextKt.c(r13, null);     // Catch: Throwable -> L10
        Object r15 = ((Function1) y.e(r10, 1)).invoke(r12);     // Catch: Throwable -> L12
        ThreadContextKt.a(r13, r14);     // Catch: Throwable -> L10
        if (r15 == kotlin.coroutines.intrinsics.a.d()) goto L20;
        r12.resumeWith(Result.m35constructorimpl(r15));
        return;
    L20:
        return;
    L12:
        th = move-exception;
        ThreadContextKt.a(r13, r14);     // Catch: Throwable -> L10
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Result.a r16 = Result.Companion;
        r12.resumeWith(Result.m35constructorimpl(c.a(th)));
    }

    public static final void b(Function2 r10, Object r11, Continuation r12) {
        Continuation r13 = d.a(r12);
        CoroutineContext r14 = r12.getContext();     // Catch: Throwable -> L10
        Object r15 = ThreadContextKt.c(r14, null);     // Catch: Throwable -> L10
        Object r16 = ((Function2) y.e(r10, 2)).mo0invoke(r11, r13);     // Catch: Throwable -> L12
        ThreadContextKt.a(r14, r15);     // Catch: Throwable -> L10
        if (r16 == kotlin.coroutines.intrinsics.a.d()) goto L20;
        r13.resumeWith(Result.m35constructorimpl(r16));
        return;
    L20:
        return;
    L12:
        th = move-exception;
        ThreadContextKt.a(r14, r15);     // Catch: Throwable -> L10
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Result.a r17 = Result.Companion;
        r13.resumeWith(Result.m35constructorimpl(c.a(th)));
    }

    public static final Object c(x r10, Object r11, Function2 r12) {
        Object r13 = ((Function2) y.e(r12, 2)).mo0invoke(r11, r10);     // Catch: Throwable -> L5
    L8:
        if (r13 == kotlin.coroutines.intrinsics.a.d()) goto L21;
        Object r14 = r10.N(r13);
        if (r14 != l1.f21639b) goto L14;
        return kotlin.coroutines.intrinsics.a.d();
    L14:
        if ((r14 instanceof w) == true) goto L18;
        return l1.h(r14);
    L18:
        throw ((w) r14).f21768a;
    L21:
        return kotlin.coroutines.intrinsics.a.d();
    L5:
        th = move-exception;
        r13 = new w(th, false, 2, null);
        goto L8
    }

    public static final Object d(x r10, Object r11, Function2 r12) {
        Object r13 = ((Function2) y.e(r12, 2)).mo0invoke(r11, r10);     // Catch: Throwable -> L5
    L8:
        if (r13 == kotlin.coroutines.intrinsics.a.d()) goto L31;
        Object r14 = r10.N(r13);
        if (r14 != l1.f21639b) goto L14;
        return kotlin.coroutines.intrinsics.a.d();
    L14:
        if ((r14 instanceof w) == false) goto L25;
        Throwable r15 = ((w) r14).f21768a;
        if ((r15 instanceof TimeoutCancellationException) == true) goto L18;
        throw r15;
    L18:
        if (((TimeoutCancellationException) r15).coroutine == r10) goto L20;
        throw r15;
    L20:
        if ((r13 instanceof w) == false) goto L27;
        throw ((w) r13).f21768a;
    L27:
        return r13;
    L25:
        r13 = l1.h(r14);
        goto L27
    L31:
        return kotlin.coroutines.intrinsics.a.d();
    L5:
        th = move-exception;
        r13 = new w(th, false, 2, null);
        goto L8
    }
}
