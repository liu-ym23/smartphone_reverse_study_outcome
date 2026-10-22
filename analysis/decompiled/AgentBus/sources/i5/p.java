package i5;

import m.x;

/* loaded from: classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public final long f4695a;

    /* renamed from: b, reason: collision with root package name */
    public final c5.b f4696b;

    /* renamed from: c, reason: collision with root package name */
    public final long f4697c;

    /* renamed from: d, reason: collision with root package name */
    public final long f4698d;

    public p(long j2, c5.b bVar, long j4, long j10) {
        this.f4695a = j2;
        this.f4696b = bVar;
        this.f4697c = j4;
        this.f4698d = j10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return this.f4695a == pVar.f4695a && q7.k.a(this.f4696b, pVar.f4696b) && this.f4697c == pVar.f4697c && this.f4698d == pVar.f4698d;
    }

    public final int hashCode() {
        return Long.hashCode(this.f4698d) + x.f(this.f4697c, (this.f4696b.hashCode() + (Long.hashCode(this.f4695a) * 31)) * 31, 31);
    }

    public final String toString() {
        return "QueuedFrame(id=" + this.f4695a + ", frame=" + this.f4696b + ", createdAt=" + this.f4697c + ", ttlExpiresAt=" + this.f4698d + ")";
    }
}
