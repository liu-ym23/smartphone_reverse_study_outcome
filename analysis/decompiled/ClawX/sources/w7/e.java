package w7;

import java.math.BigInteger;

/* loaded from: classes.dex */
public final class e implements a {

    /* renamed from: a, reason: collision with root package name */
    public final BigInteger f6229a;

    public e(BigInteger bigInteger) {
        this.f6229a = bigInteger;
    }

    @Override // w7.a
    public final int a() {
        return 1;
    }

    @Override // w7.a
    public final BigInteger b() {
        return this.f6229a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e) {
            return this.f6229a.equals(((e) obj).f6229a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f6229a.hashCode();
    }
}
