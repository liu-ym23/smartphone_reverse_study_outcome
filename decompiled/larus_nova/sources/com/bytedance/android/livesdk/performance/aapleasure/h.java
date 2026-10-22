package com.bytedance.android.livesdk.performance.aapleasure;

/* JADX INFO: loaded from: classes11.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f154445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f154446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f154447c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L12;
        h r101 = (h) r100;
        if (Float.compare(this.f154445a, r101.f154445a) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.f154446b, r101.f154446b) == 0) goto L10;
        return false;
    L10:
        if (Float.compare(this.f154447c, r101.f154447c) == 0) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        return (((Float.floatToIntBits(this.f154445a) * 31) + Float.floatToIntBits(this.f154446b)) * 31) + Float.floatToIntBits(this.f154447c);
    }

    public final String toString() {
        return "EffectResult(aTemp=" + this.f154445a + ", aBattery=" + this.f154446b + ", aStall=" + this.f154447c + ")";
    }

    public h(float r100, float r101, float r102) {
        this.f154445a = r100;
        this.f154446b = r101;
        this.f154447c = r102;
    }
}
