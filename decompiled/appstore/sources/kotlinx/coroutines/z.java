package kotlinx.coroutines;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes4.dex */
public abstract class z {
    public static final Object a(Object r10, Continuation r11) {
        if ((r10 instanceof w) == false) goto L6;
        Result.a r12 = Result.Companion;
        return Result.m35constructorimpl(kotlin.c.a(((w) r10).f21768a));
    L6:
        return Result.m35constructorimpl(r10);
    }

    public static final Object b(Object r10, Function1 r11) {
        Throwable r12 = Result.m38exceptionOrNullimpl(r10);
        if (r12 != null) goto L7;
        if (r11 != null) goto L9;
        return r10;
    L9:
        return new x(r10, r11);
    L7:
        return new w(r12, false, 2, null);
    }

    public static final Object c(Object r10, CancellableContinuation r11) {
        Throwable r12 = Result.m38exceptionOrNullimpl(r10);
        if (r12 != null) goto L6;
        return r10;
    L6:
        return new w(r12, false, 2, null);
    }

    public static /* synthetic */ Object d(Object r10, Function1 r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r11 = null;
    L6:
        return b(r10, r11);
    }
}
