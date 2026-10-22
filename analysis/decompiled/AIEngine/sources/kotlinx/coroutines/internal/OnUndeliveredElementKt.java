package kotlinx.coroutines.internal;

import jd.b;
import kotlin.coroutines.d;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import lb.n;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class OnUndeliveredElementKt {
    public static final <E> void callUndeliveredElement(l<? super E, n> lVar, E e10, d dVar) {
        UndeliveredElementException undeliveredElementExceptionCallUndeliveredElementCatchingException = callUndeliveredElementCatchingException(lVar, e10, null);
        if (undeliveredElementExceptionCallUndeliveredElementCatchingException != null) {
            CoroutineExceptionHandlerKt.handleCoroutineException(dVar, undeliveredElementExceptionCallUndeliveredElementCatchingException);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <E> UndeliveredElementException callUndeliveredElementCatchingException(l<? super E, n> lVar, E e10, UndeliveredElementException undeliveredElementException) {
        try {
            lVar.invoke(e10);
            return undeliveredElementException;
        } catch (Throwable th) {
            if (undeliveredElementException != null && undeliveredElementException.getCause() != th) {
                b.c(undeliveredElementException, th);
                return undeliveredElementException;
            }
            return new UndeliveredElementException("Exception in undelivered element handler for " + e10, th);
        }
    }

    public static /* synthetic */ UndeliveredElementException callUndeliveredElementCatchingException$default(l lVar, Object obj, UndeliveredElementException undeliveredElementException, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            undeliveredElementException = null;
        }
        return callUndeliveredElementCatchingException(lVar, obj, undeliveredElementException);
    }
}
