package kotlinx.coroutines;

import kotlin.Result;
import kotlin.c;
import qb.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CompletionStateKt {
    public static final <T> Object recoverResult(Object obj, b<? super T> bVar) {
        return obj instanceof CompletedExceptionally ? c.a(((CompletedExceptionally) obj).cause) : obj;
    }

    public static final <T> Object toState(Object obj) {
        Throwable thB = Result.b(obj);
        return thB == null ? obj : new CompletedExceptionally(thB, false, 2, null);
    }

    public static final <T> Object toState(Object obj, CancellableContinuation<?> cancellableContinuation) {
        Throwable thB = Result.b(obj);
        return thB == null ? obj : new CompletedExceptionally(thB, false, 2, null);
    }
}
