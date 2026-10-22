package o5;

import n7.o;

/* loaded from: classes.dex */
public final class h extends o {

    /* renamed from: b, reason: collision with root package name */
    public final long f7762b;

    public h(long j2) {
        super(2);
        this.f7762b = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof h) && this.f7762b == ((h) obj).f7762b;
    }

    @Override // n7.o
    public final int hashCode() {
        return Long.hashCode(this.f7762b) - 899683589;
    }

    @Override // n7.o
    public final String toString() {
        return "Degraded(reason=bff ws connected, awaiting auth, sinceMs=" + this.f7762b + ")";
    }
}
