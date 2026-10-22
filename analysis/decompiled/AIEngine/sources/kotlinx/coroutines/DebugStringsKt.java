package kotlinx.coroutines;

import kotlin.Result;
import kotlin.c;
import kotlinx.coroutines.internal.DispatchedContinuation;
import qb.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class DebugStringsKt {
    public static final String getClassSimpleName(Object obj) {
        return obj.getClass().getSimpleName();
    }

    public static final String getHexAddress(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final String toDebugString(b<?> bVar) {
        Object objA;
        if (bVar instanceof DispatchedContinuation) {
            return ((DispatchedContinuation) bVar).toString();
        }
        try {
            objA = bVar + '@' + getHexAddress(bVar);
        } catch (Throwable th) {
            objA = c.a(th);
        }
        if (Result.b(objA) != null) {
            objA = bVar.getClass().getName() + '@' + getHexAddress(bVar);
        }
        return (String) objA;
    }
}
