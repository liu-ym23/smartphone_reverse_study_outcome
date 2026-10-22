package X8;

import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: classes4.dex */
public abstract class N {
    public abstract Variance a();

    public abstract w b();

    public abstract boolean c();

    public abstract N d(Y8.f fVar);

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof N)) {
            return false;
        }
        N n = (N) obj;
        return c() == n.c() && a() == n.a() && b().equals(n.b());
    }

    public final int hashCode() {
        int iHashCode = a().hashCode();
        if (S.l(b())) {
            return (iHashCode * 31) + 19;
        }
        return (iHashCode * 31) + (c() ? 17 : b().hashCode());
    }

    public final String toString() {
        if (c()) {
            return "*";
        }
        if (a() == Variance.c) {
            return b().toString();
        }
        return a() + " " + b();
    }
}
