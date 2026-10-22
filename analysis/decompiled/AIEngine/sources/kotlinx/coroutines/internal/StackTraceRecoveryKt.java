package kotlinx.coroutines.internal;

import kotlin.Result;
import kotlin.c;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class StackTraceRecoveryKt {
    private static final StackTraceElement ARTIFICIAL_FRAME;
    private static final String baseContinuationImplClassName;
    private static final String stackTraceRecoveryClassName;

    static {
        Object objA;
        Object objA2;
        Exception exc = new Exception();
        String simpleName = a.a.class.getSimpleName();
        StackTraceElement stackTraceElement = exc.getStackTrace()[0];
        ARTIFICIAL_FRAME = new StackTraceElement("_COROUTINE.".concat(simpleName), "_", stackTraceElement.getFileName(), stackTraceElement.getLineNumber());
        try {
            objA = BaseContinuationImpl.class.getCanonicalName();
        } catch (Throwable th) {
            objA = c.a(th);
        }
        if (Result.b(objA) != null) {
            objA = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        baseContinuationImplClassName = (String) objA;
        try {
            objA2 = StackTraceRecoveryKt.class.getCanonicalName();
        } catch (Throwable th2) {
            objA2 = c.a(th2);
        }
        if (Result.b(objA2) != null) {
            objA2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
        stackTraceRecoveryClassName = (String) objA2;
    }

    public static final <E extends Throwable> E recoverStackTrace(E e10) {
        return e10;
    }
}
