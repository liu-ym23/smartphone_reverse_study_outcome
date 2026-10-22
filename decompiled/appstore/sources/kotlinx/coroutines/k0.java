package kotlinx.coroutines;

import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.ThreadContextKt;

/* JADX INFO: loaded from: classes4.dex */
public abstract class k0 {
    public static final void a(j0 r10, int r11) {
        Continuation r12 = r10.b();
        if (r11 != 4) goto L5;
        boolean r13 = true;
    L6:
        if (r13 == false) goto L8;
    L15:
        d(r10, r12, r13);
        return;
    L8:
        if ((r12 instanceof kotlinx.coroutines.internal.i) == false) goto L15;
        if (b(r11) != b(r10.f21631c)) goto L15;
        CoroutineDispatcher r14 = ((kotlinx.coroutines.internal.i) r12).f21594d;
        CoroutineContext r15 = r12.getContext();
        if (r14.c(r15) == false) goto L14;
        r14.a(r15, r10);
        return;
    L14:
        e(r10);
        return;
    L5:
        r13 = false;
        goto L6
    }

    public static final boolean b(int r10) {
        if (r10 != 1) goto L5;
        return true;
    L5:
        if (r10 == 2) goto L10;
        return false;
    L10:
        return true;
    }

    public static final boolean c(int r10) {
        if (r10 != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public static final void d(j0 r10, Continuation r11, boolean r12) {
        Object r13 = r10.f();
        Throwable r14 = r10.c(r13);
        if (r14 == null) goto L6;
        Result.a r15 = Result.Companion;
        Object r16 = kotlin.c.a(r14);
    L5:
        Object r17 = Result.m35constructorimpl(r16);
        if (r12 == false) goto L23;
        kotlin.jvm.internal.q.e(r11, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
        kotlinx.coroutines.internal.i r18 = (kotlinx.coroutines.internal.i) r11;
        Continuation r19 = r18.f21595e;
        Object r20 = r18.f21597g;
        CoroutineContext r21 = r19.getContext();
        Object r22 = ThreadContextKt.c(r21, r20);
        if (r22 == ThreadContextKt.f21572a) goto L11;
        d2 r23 = CoroutineContextKt.g(r19, r21, r22);
    L25:
        r18.f21595e.resumeWith(r17);     // Catch: Throwable -> L17
        Unit r24 = Unit.f21064a;     // Catch: Throwable -> L17
        if (r23 != null) goto L15;
    L16:
        ThreadContextKt.a(r21, r22);
        return;
    L15:
        if (r23.r0() == true) goto L16;
        return;
    L17:
        th = move-exception;
        if (r23 != null) goto L20;
    L21:
        ThreadContextKt.a(r21, r22);
    L22:
        throw th;
    L20:
        if (r23.r0() == false) goto L22;
    L11:
        r23 = null;
        goto L25
    L23:
        r11.resumeWith(r17);
        return;
    L6:
        Result.a r25 = Result.Companion;
        r16 = r10.d(r13);
        goto L5
    }

    public static final void e(j0 r10) {
        q0 r11 = z1.f21774a.b();
        if (r11.l() == false) goto L5;
        r11.h(r10);
        return;
    L5:
        r11.j(true);
        d(r10, r10.b(), true);     // Catch: Throwable -> L10
    L7:
        if (r11.o() == true) goto L7;
    L9:
        r11.e(true);
        return;
    L10:
        th = move-exception;
        r10.e(th, null);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        r11.e(true);
        throw th;
    }
}
