package kotlin;

import kotlin.Result;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public abstract class b {
    public static final Result.Failure a(Throwable exception) {
        k.f(exception, "exception");
        return new Result.Failure(exception);
    }

    public static final void b(Object obj) {
        if (obj instanceof Result.Failure) {
            throw ((Result.Failure) obj).f4888a;
        }
    }
}
