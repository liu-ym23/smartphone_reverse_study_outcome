package b8;

import java.math.BigInteger;

/* loaded from: classes4.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public BigInteger f15285a;

    public long a() {
        if (this.f15285a.bitLength() < 64) {
            return this.f15285a.longValue();
        }
        throw new IllegalArgumentException("size-in-bytes value is out of range for a 64-bit long: '" + this.f15285a + "'");
    }

    public boolean equals(Object obj) {
        if (obj instanceof h) {
            return ((h) obj).f15285a.equals(this.f15285a);
        }
        return false;
    }

    public int hashCode() {
        return this.f15285a.hashCode();
    }

    public String toString() {
        return "ConfigMemorySize(" + this.f15285a + ")";
    }
}
