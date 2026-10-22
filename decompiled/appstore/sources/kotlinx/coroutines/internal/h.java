package kotlinx.coroutines.internal;

import java.util.Iterator;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* JADX INFO: loaded from: classes4.dex */
public abstract class h {
    public static final void a(CoroutineContext r10, Throwable r11) {
        Iterator r12 = g.a().iterator();
    L4:
        if (r12.hasNext() == true) goto L17;
        kotlin.a.a(r11, new DiagnosticCoroutineContextException(r10));     // Catch: Throwable -> L14
    L12:
        g.b(r11);
        return;
    L17:
        ((CoroutineExceptionHandler) r12.next()).handleException(r10, r11);     // Catch: Throwable -> L8 ExceptionSuccessfullyProcessed -> L10
    L10:
        return;
    L8:
        th = move-exception;
        g.b(kotlinx.coroutines.a0.b(r11, th));
        goto L4
    }
}
