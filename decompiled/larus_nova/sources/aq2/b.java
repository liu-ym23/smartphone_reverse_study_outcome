package aq2;

/* JADX INFO: loaded from: classes11.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f15884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f15885b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f15886c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f15887d;

    public b() {
        this(0, 0, 0, 0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L14;
        b r101 = (b) r100;
        if (this.f15884a == r101.f15884a) goto L8;
        return false;
    L8:
        if (this.f15885b == r101.f15885b) goto L10;
        return false;
    L10:
        if (this.f15886c == r101.f15886c) goto L12;
        return false;
    L12:
        if (this.f15887d == r101.f15887d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        return (((((this.f15884a * 31) + this.f15885b) * 31) + this.f15886c) * 31) + this.f15887d;
    }

    public final String toString() {
        return "RevCardMargin(left=" + this.f15884a + ", top=" + this.f15885b + ", right=" + this.f15886c + ", bottom=" + this.f15887d + ")";
    }

    public b(int r100, int r101, int r102, int r103) {
        this.f15884a = r100;
        this.f15885b = r101;
        this.f15886c = r102;
        this.f15887d = r103;
    }
}
