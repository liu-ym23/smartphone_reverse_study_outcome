package pb;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f23417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f23418b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f23419c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f23420d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f23421e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f23422f;

    public b(float r10, float r11, float r12, float r13, float r14, float r15) {
        this.f23417a = r10;
        this.f23418b = r11;
        this.f23419c = r12;
        this.f23420d = r13;
        this.f23421e = r14;
        this.f23422f = r15;
    }

    public final float a() {
        return this.f23421e;
    }

    public final float b() {
        return this.f23422f;
    }

    public final float c() {
        return this.f23419c;
    }

    public final float d() {
        return this.f23418b;
    }

    public final float e() {
        return this.f23417a;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof b) == false) goto L18;
        b r11 = (b) r10;
        if (Float.compare(this.f23417a, r11.f23417a) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.f23418b, r11.f23418b) == 0) goto L10;
        return false;
    L10:
        if (Float.compare(this.f23419c, r11.f23419c) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.f23420d, r11.f23420d) == 0) goto L14;
        return false;
    L14:
        if (Float.compare(this.f23421e, r11.f23421e) == 0) goto L16;
        return false;
    L16:
        if (Float.compare(this.f23422f, r11.f23422f) == 0) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final float f() {
        return this.f23420d;
    }

    public int hashCode() {
        return (((((((((Float.hashCode(this.f23417a) * 31) + Float.hashCode(this.f23418b)) * 31) + Float.hashCode(this.f23419c)) * 31) + Float.hashCode(this.f23420d)) * 31) + Float.hashCode(this.f23421e)) * 31) + Float.hashCode(this.f23422f);
    }

    public String toString() {
        return "ControlPoint(handleLarge=" + this.f23417a + ", distanceOuter=" + this.f23418b + ", distanceInner=" + this.f23419c + ", handleMedium=" + this.f23420d + ", curveInner=" + this.f23421e + ", curveOuter=" + this.f23422f + ")";
    }
}
