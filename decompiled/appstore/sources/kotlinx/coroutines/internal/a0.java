package kotlinx.coroutines.internal;

import kotlin.Result;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final StackTraceElement f21577a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f21578b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f21579c = null;

    static {
        f21577a = new a.a().a();
        Result.a r10 = Result.Companion;     // Catch: Throwable -> L5
        Object r11 = Result.m35constructorimpl(BaseContinuationImpl.class.getCanonicalName());     // Catch: Throwable -> L5
    L8:
        if (Result.m38exceptionOrNullimpl(r11) == null) goto L11;
        r11 = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
    L11:
        f21578b = (String) r11;
        Object r12 = Result.m35constructorimpl(a0.class.getCanonicalName());     // Catch: Throwable -> L14
    L17:
        if (Result.m38exceptionOrNullimpl(r12) == null) goto L20;
        r12 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
    L20:
        f21579c = (String) r12;
        return;
    L14:
        th = move-exception;
        Result.a r13 = Result.Companion;
        r12 = Result.m35constructorimpl(kotlin.c.a(th));
    L5:
        th = move-exception;
        Result.a r14 = Result.Companion;
        r11 = Result.m35constructorimpl(kotlin.c.a(th));
        goto L8
    }

    public static final Throwable a(Throwable r10) {
        return r10;
    }
}
