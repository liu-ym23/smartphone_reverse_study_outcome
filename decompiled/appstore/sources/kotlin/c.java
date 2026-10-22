package kotlin;

import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public abstract class c {
    public static final Object a(Throwable r10) {
        q.g(r10, "exception");
        return new Result.Failure(r10);
    }

    public static final void b(Object r10) {
        if ((r10 instanceof Result.Failure) == true) goto L6;
        return;
    L6:
        throw ((Result.Failure) r10).exception;
    }
}
