package ca0;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f22915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f22916b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f22917c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f22918d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L14;
        a r101 = (a) r100;
        if (this.f22915a == r101.f22915a) goto L8;
        return false;
    L8:
        if (this.f22916b == r101.f22916b) goto L10;
        return false;
    L10:
        if (this.f22917c == r101.f22917c) goto L12;
        return false;
    L12:
        if (this.f22918d == r101.f22918d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        return (((((this.f22915a * 31) + this.f22916b) * 31) + this.f22917c) * 31) + this.f22918d;
    }

    public final String toString() {
        return "GiftHeightModel(giftPadding=" + this.f22915a + ", giftAnimPaddingBottom=" + this.f22916b + ", giftPositionHeight=" + this.f22917c + ", giftPaddingBottom=" + this.f22918d + ")";
    }

    public a(int r100, int r101, int r102, int r103) {
        this.f22915a = r100;
        this.f22916b = r101;
        this.f22917c = r102;
        this.f22918d = r103;
    }
}
