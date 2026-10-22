package V3;

import V3.n;

/* loaded from: classes.dex */
public final class o {
    public static final Object a(Throwable th) {
        j4.k.g(th, "exception");
        return new n.b(th);
    }

    public static final void b(Object obj) {
        if (obj instanceof n.b) {
            throw ((n.b) obj).f5532a;
        }
    }
}
