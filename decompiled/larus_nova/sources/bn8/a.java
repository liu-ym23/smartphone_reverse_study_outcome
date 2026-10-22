package bn8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f19765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Float f19766b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f19767c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f19768d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f19769e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f19770f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f19771g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f19772h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f19765a, r101.f19765a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f19766b, r101.f19766b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f19767c, r101.f19767c) == true) goto L18;
        return false;
    L18:
        if (Float.compare(this.f19768d, r101.f19768d) == 0) goto L21;
        return false;
    L21:
        if (this.f19769e == r101.f19769e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f19770f, r101.f19770f) == true) goto L27;
        return false;
    L27:
        if (this.f19771g == r101.f19771g) goto L30;
        return false;
    L30:
        if (this.f19772h == r101.f19772h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f19765a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Float r104 = this.f19766b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f19767c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (((r106 + r108) * 31) + Float.floatToIntBits(this.f19768d)) * 31;
        int r110 = 1231;
        if (this.f19769e == false) goto L17;
        int r111 = 1231;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f19770f;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        int r114 = (r112 + r101) * 31;
        if (this.f19771g == false) goto L25;
        int r115 = 1231;
    L26:
        int r116 = (r114 + r115) * 31;
        if (this.f19772h == true) goto L31;
        r110 = 1237;
    L31:
        return r116 + r110;
    L25:
        r115 = 1237;
        goto L26
    L17:
        r111 = 1237;
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ReplyTextLoadingViewInput(textColorRes=" + this.f19765a + ", textSize=" + this.f19766b + ", textContent=" + this.f19767c + ", fontScale=" + this.f19768d + ", isImmersive=" + this.f19769e + ", icon=" + this.f19770f + ", needShimmer=" + this.f19771g + ", needThreeLoading=" + this.f19772h + ')';
    }

    public a(Integer r100, Float r101, String r102, float r103, boolean r104, String r105, boolean r106, boolean r107) {
        this.f19765a = r100;
        this.f19766b = r101;
        this.f19767c = r102;
        this.f19768d = r103;
        this.f19769e = r104;
        this.f19770f = r105;
        this.f19771g = r106;
        this.f19772h = r107;
    }
}
