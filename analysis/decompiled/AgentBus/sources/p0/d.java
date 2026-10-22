package p0;

import m.x;
import q7.k;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final int f8259a;

    /* renamed from: b, reason: collision with root package name */
    public final long f8260b;

    /* renamed from: c, reason: collision with root package name */
    public final e f8261c;

    /* renamed from: d, reason: collision with root package name */
    public final a7.d f8262d;

    public d(int i2, long j2, e eVar, a7.d dVar) {
        this.f8259a = i2;
        this.f8260b = j2;
        this.f8261c = eVar;
        this.f8262d = dVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f8259a == dVar.f8259a && this.f8260b == dVar.f8260b && this.f8261c == dVar.f8261c && k.a(this.f8262d, dVar.f8262d);
    }

    public final int hashCode() {
        int iHashCode = (this.f8261c.hashCode() + x.f(this.f8260b, Integer.hashCode(this.f8259a) * 31, 31)) * 31;
        a7.d dVar = this.f8262d;
        return iHashCode + (dVar == null ? 0 : dVar.hashCode());
    }

    public final String toString() {
        return "ContentCaptureEvent(id=" + this.f8259a + ", timestamp=" + this.f8260b + ", type=" + this.f8261c + ", structureCompat=" + this.f8262d + ')';
    }
}
