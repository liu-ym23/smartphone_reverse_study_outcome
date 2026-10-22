package d3;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;

/* loaded from: classes2.dex */
public abstract class w {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f12482a = 0;

    static {
        Object objM22constructorimpl;
        Object objM22constructorimpl2;
        Exception exc = new Exception();
        String simpleName = B0.f.class.getSimpleName();
        StackTraceElement stackTraceElement = exc.getStackTrace()[0];
        new StackTraceElement("_COROUTINE.".concat(simpleName), "_", stackTraceElement.getFileName(), stackTraceElement.getLineNumber());
        try {
            Result.Companion companion = Result.INSTANCE;
            objM22constructorimpl = Result.m22constructorimpl(BaseContinuationImpl.class.getCanonicalName());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM22constructorimpl = Result.m22constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m25exceptionOrNullimpl(objM22constructorimpl) != null) {
            objM22constructorimpl = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        try {
            objM22constructorimpl2 = Result.m22constructorimpl(w.class.getCanonicalName());
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            objM22constructorimpl2 = Result.m22constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m25exceptionOrNullimpl(objM22constructorimpl2) != null) {
            objM22constructorimpl2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
    }
}
