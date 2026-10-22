package x0;

import ch.qos.logback.core.CoreConstants;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f15871a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f15872b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f15873c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f15874d;

    public d(boolean z4, boolean z5, boolean z6, boolean z7) {
        this.f15871a = z4;
        this.f15872b = z5;
        this.f15873c = z6;
        this.f15874d = z7;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f15871a == dVar.f15871a && this.f15872b == dVar.f15872b && this.f15873c == dVar.f15873c && this.f15874d == dVar.f15874d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        boolean z4 = this.f15871a;
        int i4 = z4;
        if (z4 != 0) {
            i4 = 1;
        }
        int i5 = i4 * 31;
        boolean z5 = this.f15872b;
        int i6 = z5;
        if (z5 != 0) {
            i6 = 1;
        }
        int i7 = (i5 + i6) * 31;
        boolean z6 = this.f15873c;
        int i8 = z6;
        if (z6 != 0) {
            i8 = 1;
        }
        int i9 = (i7 + i8) * 31;
        boolean z7 = this.f15874d;
        return i9 + (z7 ? 1 : z7 ? 1 : 0);
    }

    public final String toString() {
        return "NetworkState(isConnected=" + this.f15871a + ", isValidated=" + this.f15872b + ", isMetered=" + this.f15873c + ", isNotRoaming=" + this.f15874d + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
