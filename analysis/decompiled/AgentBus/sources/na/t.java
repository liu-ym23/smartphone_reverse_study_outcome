package na;

import w7.e0;

/* loaded from: classes.dex */
public abstract class t {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f6928a = 0;

    static {
        Object objN;
        Object objN2;
        Exception exc = new Exception();
        String simpleName = a.a.class.getSimpleName();
        StackTraceElement stackTraceElement = exc.getStackTrace()[0];
        new StackTraceElement("_COROUTINE.".concat(simpleName), "_", stackTraceElement.getFileName(), stackTraceElement.getLineNumber());
        try {
            objN = i7.a.class.getCanonicalName();
        } catch (Throwable th) {
            objN = e0.n(th);
        }
        if (c7.m.a(objN) != null) {
            objN = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        try {
            objN2 = t.class.getCanonicalName();
        } catch (Throwable th2) {
            objN2 = e0.n(th2);
        }
        if (c7.m.a(objN2) != null) {
            objN2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
    }
}
