package bu6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f20737b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f20738c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f20739d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f20740e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f20741f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f20742g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f20743h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f20744i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f20736a, r101.f20736a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f20737b, r101.f20737b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f20738c, r101.f20738c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f20739d, r101.f20739d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f20740e, r101.f20740e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f20741f, r101.f20741f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f20742g, r101.f20742g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f20743h, r101.f20743h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f20744i, r101.f20744i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f20736a.hashCode() * 31;
        String r101 = this.f20737b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f20738c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((((r104 + r106) * 31) + this.f20739d.hashCode()) * 31) + this.f20740e.hashCode()) * 31;
        String r108 = this.f20741f;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f20742g;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f20743h;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        String r117 = this.f20744i;
        if (r117 == null) goto L27;
        r102 = r117.hashCode();
    L27:
        return r116 + r102;
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "SearchRouteParams(enterFrom=" + this.f20736a + ", spuId=" + this.f20737b + ", poiId=" + this.f20738c + ", enterFromSecond=" + this.f20739d + ", hintWord=" + this.f20740e + ", suggestWord=" + this.f20741f + ", lifeHomepageFreshType=" + this.f20742g + ", saleChannel=" + this.f20743h + ", extraMobParamsStr=" + this.f20744i + ')';
    }

    public c(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r110) {
        Intrinsics.checkNotNullParameter("product_page", "enterFrom");
        Intrinsics.checkNotNullParameter(r102, "enterFromSecond");
        Intrinsics.checkNotNullParameter(r103, "hintWord");
        this.f20736a = "product_page";
        this.f20737b = r100;
        this.f20738c = r101;
        this.f20739d = r102;
        this.f20740e = r103;
        this.f20741f = r104;
        this.f20742g = r105;
        this.f20743h = r106;
        this.f20744i = r110;
    }
}
