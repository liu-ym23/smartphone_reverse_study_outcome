package d;

import q7.k;

/* loaded from: classes.dex */
public final class a extends a.a {

    /* renamed from: a, reason: collision with root package name */
    public final Object f2728a;

    /* renamed from: b, reason: collision with root package name */
    public final long f2729b;

    public a(long j2, Object obj) {
        this.f2728a = obj;
        this.f2729b = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return k.a(this.f2728a, aVar.f2728a) && this.f2729b == aVar.f2729b;
    }

    public final int hashCode() {
        return Long.hashCode(this.f2729b) + (this.f2728a.hashCode() * 31);
    }

    public final String toString() {
        return "BackHandlerInfo(owner=" + this.f2728a + ", compositeKey=" + this.f2729b + ')';
    }
}
