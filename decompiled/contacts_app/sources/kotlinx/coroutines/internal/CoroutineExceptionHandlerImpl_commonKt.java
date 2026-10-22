package kotlinx.coroutines.internal;

import java.util.Iterator;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;

/* JADX INFO: compiled from: CoroutineExceptionHandlerImpl.common.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, d2 = {"handleUncaughtCoroutineException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CoroutineExceptionHandlerImpl_commonKt {
    public static final void handleUncaughtCoroutineException(CoroutineContext r2, Throwable r3) {
        Iterator<CoroutineExceptionHandler> r0 = CoroutineExceptionHandlerImplKt.getPlatformExceptionHandlers().iterator();
    L4:
        if (r0.hasNext() == true) goto L17;
        ExceptionsKt.addSuppressed(r3, new DiagnosticCoroutineContextException(r2));     // Catch: Throwable -> L14
    L12:
        CoroutineExceptionHandlerImplKt.propagateExceptionFinalResort(r3);
        return;
    L17:
        r0.next().handleException(r2, r3);     // Catch: Throwable -> L8 ExceptionSuccessfullyProcessed -> L10
    L10:
        return;
    L8:
        th = move-exception;
        CoroutineExceptionHandlerImplKt.propagateExceptionFinalResort(CoroutineExceptionHandlerKt.handlerException(r3, th));
        goto L4
    }
}
