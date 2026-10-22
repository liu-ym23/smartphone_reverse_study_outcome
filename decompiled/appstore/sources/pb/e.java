package pb;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f23428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f23429b;

    public e(float r10, float r11) {
        this.f23428a = r10;
        this.f23429b = r11;
    }

    public final float a() {
        return this.f23428a;
    }

    public final float b() {
        return this.f23429b;
    }

    public final float c() {
        return this.f23428a;
    }

    public final float d() {
        return this.f23429b;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof e) == false) goto L10;
        e r11 = (e) r10;
        if (Float.compare(this.f23428a, r11.f23428a) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.f23429b, r11.f23429b) == 0) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        return (Float.hashCode(this.f23428a) * 31) + Float.hashCode(this.f23429b);
    }

    public String toString() {
        return "Point(x=" + this.f23428a + ", y=" + this.f23429b + ")";
    }
}
