package ya;

import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: classes5.dex */
public abstract class C0 implements B0 {
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof B0)) {
            return false;
        }
        B0 b02 = (B0) obj;
        return b() == b02.b() && c() == b02.c() && getType().equals(b02.getType());
    }

    public int hashCode() {
        int iHashCode = c().hashCode();
        if (H0.w(getType())) {
            return (iHashCode * 31) + 19;
        }
        return (iHashCode * 31) + (b() ? 17 : getType().hashCode());
    }

    public String toString() {
        if (b()) {
            return "*";
        }
        if (c() == Variance.INVARIANT) {
            return getType().toString();
        }
        return c() + " " + getType();
    }
}
