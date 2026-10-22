package kotlinx.coroutines.selects;

import kotlin.Result;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes4.dex */
public abstract class f {
    public static final /* synthetic */ void a(CancellableContinuation r10, Object r11) {
        c(r10, r11);
    }

    public static final /* synthetic */ void b(CancellableContinuation r10, Throwable r11) {
        d(r10, r11);
    }

    public static final void c(CancellableContinuation r10, Object r11) {
        CoroutineDispatcher r12 = (CoroutineDispatcher) r10.getContext().get(CoroutineDispatcher.f21279b);
        if (r12 == null) goto L5;
        r10.resumeUndispatched(r12, r11);
        return;
    L5:
        r10.resumeWith(Result.m35constructorimpl(r11));
    }

    public static final void d(CancellableContinuation r10, Throwable r11) {
        CoroutineDispatcher r12 = (CoroutineDispatcher) r10.getContext().get(CoroutineDispatcher.f21279b);
        if (r12 == null) goto L5;
        r10.resumeUndispatchedWithException(r12, r11);
        return;
    L5:
        Result.a r13 = Result.Companion;
        r10.resumeWith(Result.m35constructorimpl(kotlin.c.a(r11)));
    }
}
