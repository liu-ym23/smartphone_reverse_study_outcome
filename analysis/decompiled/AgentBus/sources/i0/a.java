package i0;

import m.x;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public int f4393a;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && this.f4393a == ((a) obj).f4393a;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f4393a);
    }

    public final String toString() {
        return x.m(new StringBuilder("DeltaCounter(count="), this.f4393a, ')');
    }
}
