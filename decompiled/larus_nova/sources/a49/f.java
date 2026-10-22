package a49;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1798b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f1799c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f1800d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f1801e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f1802f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Long f1803g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f1804h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f1805i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f1806j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f1807k;

    public f() {
        this(null, null, null, null, 2047);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f1797a, r101.f1797a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f1798b, r101.f1798b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f1799c, r101.f1799c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f1800d, r101.f1800d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f1801e, r101.f1801e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f1802f, r101.f1802f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f1803g, r101.f1803g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f1804h, r101.f1804h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f1805i, r101.f1805i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f1806j, r101.f1806j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f1807k, r101.f1807k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f1797a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f1798b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f1799c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f1800d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f1801e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f1802f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Long r119 = this.f1803g;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f1804h;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.f1805i;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.f1806j;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.f1807k;
        if (r131 == null) goto L47;
        r101 = r131.hashCode();
    L47:
        return r130 + r101;
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
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
        return "DiaryCardContent(id=" + this.f1797a + ", title=" + this.f1798b + ", diaryTitle=" + this.f1799c + ", subtitle=" + this.f1800d + ", content=" + this.f1801e + ", date=" + this.f1802f + ", createTime=" + this.f1803g + ", emotion=" + this.f1804h + ", emotionUrl=" + this.f1805i + ", updateTime=" + this.f1806j + ", thumbnail=" + this.f1807k + ')';
    }

    public /* synthetic */ f(String r110, String r111, String r112, String r113, int r114) {
        if ((r114 & 8) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r114 & 16) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r114 & 32) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r114 & 1024) == 0) goto L17;
        String r115 = null;
    L18:
        this(null, null, null, r100, r101, r102, null, null, null, null, r115);
        return;
    L17:
        r115 = r113;
        goto L18
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public f(String r100, String r101, String r102, String r103, String r104, String r105, Long r106, String r107, String r108, String r110, String r111) {
        this.f1797a = r100;
        this.f1798b = r101;
        this.f1799c = r102;
        this.f1800d = r103;
        this.f1801e = r104;
        this.f1802f = r105;
        this.f1803g = r106;
        this.f1804h = r107;
        this.f1805i = r108;
        this.f1806j = r110;
        this.f1807k = r111;
    }
}
