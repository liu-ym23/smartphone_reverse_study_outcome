package ck8;

import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f24052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f24053b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f24054c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f24055d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f24056e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f24057f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f24058g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Pair<Integer, Integer> f24059h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f24060i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f24061j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Integer f24062k;

    public g() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f24052a, r101.f24052a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f24053b, r101.f24053b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f24054c, r101.f24054c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f24055d, r101.f24055d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f24056e, r101.f24056e) == true) goto L24;
        return false;
    L24:
        if (this.f24057f == r101.f24057f) goto L27;
        return false;
    L27:
        if (this.f24058g == r101.f24058g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f24059h, r101.f24059h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f24060i, r101.f24060i) == true) goto L36;
        return false;
    L36:
        if (this.f24061j == r101.f24061j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f24062k, r101.f24062k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f24052a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f24053b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f24054c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.f24055d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f24056e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        int r116 = 1231;
        if (this.f24057f == false) goto L25;
        int r117 = 1231;
    L26:
        int r118 = (r115 + r117) * 31;
        if (this.f24058g == true) goto L30;
        r116 = 1237;
    L30:
        int r119 = (r118 + r116) * 31;
        Pair<Integer, Integer> r120 = this.f24059h;
        if (r120 != null) goto L33;
        int r121 = 0;
    L34:
        int r122 = (r119 + r121) * 31;
        String r123 = this.f24060i;
        if (r123 != null) goto L37;
        int r124 = 0;
    L38:
        int r125 = (((r122 + r124) * 31) + this.f24061j) * 31;
        Integer r126 = this.f24062k;
        if (r126 == null) goto L43;
        r101 = r126.hashCode();
    L43:
        return r125 + r101;
    L37:
        r124 = r123.hashCode();
        goto L38
    L33:
        r121 = r120.hashCode();
        goto L34
    L25:
        r117 = 1237;
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
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
        return "ComplexTaskColorCapsuleViewInput(iconUrl=" + this.f24052a + ", name=" + this.f24053b + ", nameColor=" + this.f24054c + ", pillColor=" + this.f24055d + ", summary=" + this.f24056e + ", showShimmer=" + this.f24057f + ", showArrow=" + this.f24058g + ", topAndBottomMarginPair=" + this.f24059h + ", messageId=" + this.f24060i + ", cardPosition=" + this.f24061j + ", backgroundRes=" + this.f24062k + ')';
    }

    public /* synthetic */ g(int r110) {
        this(null, null, null, null, null, false, false, null, null, 0, null);
    }

    public g(String r100, String r101, Integer r102, Integer r103, String r104, boolean r105, boolean r106, Pair<Integer, Integer> r107, String r108, int r110, Integer r111) {
        this.f24052a = r100;
        this.f24053b = r101;
        this.f24054c = r102;
        this.f24055d = r103;
        this.f24056e = r104;
        this.f24057f = r105;
        this.f24058g = r106;
        this.f24059h = r107;
        this.f24060i = r108;
        this.f24061j = r110;
        this.f24062k = r111;
    }
}
