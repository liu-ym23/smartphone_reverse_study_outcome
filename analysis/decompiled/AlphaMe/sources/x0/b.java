package x0;

import ch.qos.logback.core.CoreConstants;

/* loaded from: classes.dex */
public final class b extends c {

    /* renamed from: a, reason: collision with root package name */
    public final int f15870a;

    public b(int i4) {
        this.f15870a = i4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof b) && this.f15870a == ((b) obj).f15870a;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f15870a);
    }

    public final String toString() {
        return B0.g.o(new StringBuilder("ConstraintsNotMet(reason="), this.f15870a, CoreConstants.RIGHT_PARENTHESIS_CHAR);
    }
}
