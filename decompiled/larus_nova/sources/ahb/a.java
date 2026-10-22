package ahb;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f3702a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f3703b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f3704c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f3705d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f3706e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f3707f;

    /* JADX INFO: renamed from: ahb.a$a, reason: collision with other inner class name */
    public static final class C0070a {
    }

    static {
    }

    public a() {
        this(0.0f, 0.0f, 0.0f, 0.0f, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Float.compare(this.f3702a, r101.f3702a) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.f3703b, r101.f3703b) == 0) goto L15;
        return false;
    L15:
        if (Float.compare(this.f3704c, r101.f3704c) == 0) goto L18;
        return false;
    L18:
        if (Float.compare(this.f3705d, r101.f3705d) == 0) goto L21;
        return false;
    L21:
        if (Float.compare(this.f3706e, r101.f3706e) == 0) goto L24;
        return false;
    L24:
        if (Float.compare(this.f3707f, r101.f3707f) == 0) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return (((((((((Float.floatToIntBits(this.f3702a) * 31) + Float.floatToIntBits(this.f3703b)) * 31) + Float.floatToIntBits(this.f3704c)) * 31) + Float.floatToIntBits(this.f3705d)) * 31) + Float.floatToIntBits(this.f3706e)) * 31) + Float.floatToIntBits(this.f3707f);
    }

    public final String toString() {
        return "FlowTagStyle(textSizeSp=" + this.f3702a + ", horizontalPaddingDp=" + this.f3703b + ", tagHeightDp=" + this.f3704c + ", cornerRadiusDp=" + this.f3705d + ", iconSizeDp=" + this.f3706e + ", iconTextSpacingDp=" + this.f3707f + ')';
    }

    public a(float r100, float r101, float r102, float r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r100 = 11.0f;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = 6.0f;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = 22.0f;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = 6.0f;
    L14:
        float r105 = 0.0f;
        if ((r104 & 16) == 0) goto L17;
        float r106 = 12.0f;
    L19:
        if ((r104 & 32) == 0) goto L21;
        r105 = 2.0f;
    L21:
        this.f3702a = r100;
        this.f3703b = r101;
        this.f3704c = r102;
        this.f3705d = r103;
        this.f3706e = r106;
        this.f3707f = r105;
        return;
    L17:
        r106 = 0.0f;
        goto L19
    }
}
