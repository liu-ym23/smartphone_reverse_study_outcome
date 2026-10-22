package pc;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class s {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f9983a = 0;

    static {
        Object objL;
        Object objL2;
        Exception exc = new Exception();
        String simpleName = a.a.class.getSimpleName();
        StackTraceElement stackTraceElement = exc.getStackTrace()[0];
        new StackTraceElement("_COROUTINE.".concat(simpleName), "_", stackTraceElement.getFileName(), stackTraceElement.getLineNumber());
        try {
            objL = pb.a.class.getCanonicalName();
        } catch (Throwable th) {
            objL = id.c.l(th);
        }
        if (jb.i.b(objL) != null) {
            objL = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        try {
            objL2 = s.class.getCanonicalName();
        } catch (Throwable th2) {
            objL2 = id.c.l(th2);
        }
        if (jb.i.b(objL2) != null) {
            objL2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
    }
}
