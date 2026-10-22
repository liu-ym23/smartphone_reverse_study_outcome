package n0;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final float f6789a;

    /* renamed from: b, reason: collision with root package name */
    public final float f6790b;

    public e(float f10, float f11) {
        this.f6789a = f10;
        this.f6790b = f11;
    }

    public final long a(long j2, long j4, d2.l lVar) {
        float f10 = (((int) (j4 >> 32)) - ((int) (j2 >> 32))) / 2.0f;
        float f11 = (((int) (j4 & 4294967295L)) - ((int) (j2 & 4294967295L))) / 2.0f;
        d2.l lVar2 = d2.l.f2793f;
        float f12 = this.f6789a;
        if (lVar != lVar2) {
            f12 *= -1;
        }
        float f13 = 1;
        float f14 = (f12 + f13) * f10;
        float f15 = (f13 + this.f6790b) * f11;
        int iRound = Math.round(f14);
        return (Math.round(f15) & 4294967295L) | (iRound << 32);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return Float.compare(this.f6789a, eVar.f6789a) == 0 && Float.compare(this.f6790b, eVar.f6790b) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.f6790b) + (Float.hashCode(this.f6789a) * 31);
    }

    public final String toString() {
        return "BiasAlignment(horizontalBias=" + this.f6789a + ", verticalBias=" + this.f6790b + ')';
    }
}
