package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a0 {
    public static final void a(CoroutineContext r10, Throwable r11) {
        CoroutineExceptionHandler r12 = (CoroutineExceptionHandler) r10.get(CoroutineExceptionHandler.Key);     // Catch: Throwable -> L6
        if (r12 == null) goto L8;
        r12.handleException(r10, r11);     // Catch: Throwable -> L6
        return;
    L8:
        kotlinx.coroutines.internal.h.a(r10, r11);
        return;
    L6:
        th = move-exception;
        kotlinx.coroutines.internal.h.a(r10, b(r11, th));
    }

    public static final Throwable b(Throwable r10, Throwable r11) {
        if (r10 != r11) goto L4;
        return r10;
    L4:
        RuntimeException r12 = new RuntimeException("Exception while trying to handle coroutine exception", r11);
        kotlin.a.a(r12, r10);
        return r12;
    }
}
