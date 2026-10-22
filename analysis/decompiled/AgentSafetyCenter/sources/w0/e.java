package w0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final float f15106a;

    /* renamed from: b, reason: collision with root package name */
    public final float f15107b;

    public e(float f5, float f10) {
        this.f15106a = f5;
        this.f15107b = f10;
    }

    public final long a(long j10, long j11, o2.l lVar) {
        float f5 = (((int) (j11 >> 32)) - ((int) (j10 >> 32))) / 2.0f;
        float f10 = (((int) (j11 & 4294967295L)) - ((int) (j10 & 4294967295L))) / 2.0f;
        o2.l lVar2 = o2.l.f9123c;
        float f11 = this.f15106a;
        if (lVar != lVar2) {
            f11 *= -1;
        }
        float f12 = 1;
        float f13 = (f11 + f12) * f5;
        float f14 = (f12 + this.f15107b) * f10;
        int iRound = Math.round(f13);
        return (Math.round(f14) & 4294967295L) | (iRound << 32);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return Float.compare(this.f15106a, eVar.f15106a) == 0 && Float.compare(this.f15107b, eVar.f15107b) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.f15107b) + (Float.hashCode(this.f15106a) * 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("BiasAlignment(horizontalBias=");
        sb2.append(this.f15106a);
        sb2.append(", verticalBias=");
        return k0.a.q(sb2, this.f15107b, ')');
    }
}
