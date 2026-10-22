package tf;

import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public abstract class d {
    public static final Continuation a(Continuation r10) {
        q.g(r10, "completion");
        return r10;
    }

    public static final void b(Continuation r10) {
        q.g(r10, "frame");
    }

    public static final void c(Continuation r10) {
        q.g(r10, "frame");
    }
}
