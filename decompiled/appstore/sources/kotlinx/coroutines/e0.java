package kotlinx.coroutines;

import kotlin.Result;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes4.dex */
public abstract class e0 {
    public static final String a(Object r10) {
        return r10.getClass().getSimpleName();
    }

    public static final String b(Object r10) {
        return Integer.toHexString(System.identityHashCode(r10));
    }

    public static final String c(Continuation r10) {
        if ((r10 instanceof kotlinx.coroutines.internal.i) == false) goto L16;
        return r10.toString();
    L16:
        Result.a r11 = Result.Companion;     // Catch: Throwable -> L8
        Object r12 = Result.m35constructorimpl(r10 + '@' + b(r10));     // Catch: Throwable -> L8
    L11:
        if (Result.m38exceptionOrNullimpl(r12) == null) goto L15;
        r12 = r10.getClass().getName() + '@' + b(r10);
    L15:
        return (String) r12;
    L8:
        th = move-exception;
        Result.a r13 = Result.Companion;
        r12 = Result.m35constructorimpl(kotlin.c.a(th));
        goto L11
    }
}
