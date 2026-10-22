package cg;

import kotlin.Result;
import kotlin.Unit;
import kotlin.c;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.internal.j;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a {
    public static final void a(Continuation r10, Throwable r11) {
        Result.a r12 = Result.Companion;
        r10.resumeWith(Result.m35constructorimpl(c.a(r11)));
        throw r11;
    }

    public static final void b(Continuation r10, Continuation r11) {
        Continuation r12 = IntrinsicsKt__IntrinsicsJvmKt.c(r10);     // Catch: Throwable -> L4
        Result.a r13 = Result.Companion;     // Catch: Throwable -> L4
        j.c(r12, Result.m35constructorimpl(Unit.f21064a), null, 2, null);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        a(r11, th);
    }

    public static final void c(Function1 r10, Continuation r11) {
        Continuation r12 = IntrinsicsKt__IntrinsicsJvmKt.c(IntrinsicsKt__IntrinsicsJvmKt.a(r10, r11));     // Catch: Throwable -> L4
        Result.a r13 = Result.Companion;     // Catch: Throwable -> L4
        j.c(r12, Result.m35constructorimpl(Unit.f21064a), null, 2, null);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        a(r11, th);
    }

    public static final void d(Function2 r10, Object r11, Continuation r12, Function1 r13) {
        Continuation r14 = IntrinsicsKt__IntrinsicsJvmKt.c(IntrinsicsKt__IntrinsicsJvmKt.b(r10, r11, r12));     // Catch: Throwable -> L4
        Result.a r15 = Result.Companion;     // Catch: Throwable -> L4
        j.b(r14, Result.m35constructorimpl(Unit.f21064a), r13);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        a(r12, th);
    }

    public static /* synthetic */ void e(Function2 r10, Object r11, Continuation r12, Function1 r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L5;
        r13 = null;
    L5:
        d(r10, r11, r12, r13);
    }
}
