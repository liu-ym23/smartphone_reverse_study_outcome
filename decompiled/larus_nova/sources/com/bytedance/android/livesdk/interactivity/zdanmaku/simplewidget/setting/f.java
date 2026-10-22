package com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting;

import com.larus.nova.R;

/* JADX INFO: loaded from: classes9.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f141772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f141773b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f141774c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f141775d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f141776e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f141777f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f141778g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f141779h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f141780i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f141781j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f141782k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f141783l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f141784m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f141785n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f141786o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f141787p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f141788q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f141789r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f141790s;

    public f() {
        this(0, 524287);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L44;
        f r101 = (f) r100;
        if (this.f141772a == r101.f141772a) goto L8;
        return false;
    L8:
        if (this.f141773b == r101.f141773b) goto L10;
        return false;
    L10:
        if (this.f141774c == r101.f141774c) goto L12;
        return false;
    L12:
        if (this.f141775d == r101.f141775d) goto L14;
        return false;
    L14:
        if (this.f141776e == r101.f141776e) goto L16;
        return false;
    L16:
        if (this.f141777f == r101.f141777f) goto L18;
        return false;
    L18:
        if (this.f141778g == r101.f141778g) goto L20;
        return false;
    L20:
        if (this.f141779h == r101.f141779h) goto L22;
        return false;
    L22:
        if (this.f141780i == r101.f141780i) goto L24;
        return false;
    L24:
        if (this.f141781j == r101.f141781j) goto L26;
        return false;
    L26:
        if (this.f141782k == r101.f141782k) goto L28;
        return false;
    L28:
        if (this.f141783l == r101.f141783l) goto L30;
        return false;
    L30:
        if (this.f141784m == r101.f141784m) goto L32;
        return false;
    L32:
        if (this.f141785n == r101.f141785n) goto L34;
        return false;
    L34:
        if (this.f141786o == r101.f141786o) goto L36;
        return false;
    L36:
        if (this.f141787p == r101.f141787p) goto L38;
        return false;
    L38:
        if (this.f141788q == r101.f141788q) goto L40;
        return false;
    L40:
        if (this.f141789r == r101.f141789r) goto L42;
        return false;
    L42:
        if (this.f141790s == r101.f141790s) goto L67;
        return false;
    L67:
        return true;
    L44:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    public final int hashCode() {
        int r100 = ((((((((((this.f141772a * 31) + this.f141773b) * 31) + this.f141774c) * 31) + this.f141775d) * 31) + this.f141776e) * 31) + this.f141777f) * 31;
        boolean r101 = this.f141778g;
        ?? r102 = r101;
        if (r101 == false) goto L6;
        r102 = 1;
    L6:
        return ((((((((((((((((((((((((r100 + r102) * 31) + this.f141779h) * 31) + this.f141780i) * 31) + this.f141781j) * 31) + this.f141782k) * 31) + this.f141783l) * 31) + this.f141784m) * 31) + this.f141785n) * 31) + this.f141786o) * 31) + this.f141787p) * 31) + this.f141788q) * 31) + this.f141789r) * 31) + this.f141790s;
    }

    public final String toString() {
        return "RangeSeekBarConfig(gravity=" + this.f141772a + ", seekBarMode=" + this.f141773b + ", progressColor=" + this.f141774c + ", progressDefaultColor=" + this.f141775d + ", progressHeight=" + this.f141776e + ", progressRadius=" + this.f141777f + ", isStepCircleStyle=" + this.f141778g + ", stepsColor=" + this.f141779h + ", stepsCircleBorderColor=" + this.f141780i + ", stepsHeight=" + this.f141781j + ", stepsWidth=" + this.f141782k + ", thumbBorderColor=" + this.f141783l + ", leftThumbHeight=" + this.f141784m + ", leftThumbWidth=" + this.f141785n + ", rightThumbHeight=" + this.f141786o + ", rightThumbWidth=" + this.f141787p + ", leftIndicatorShowMode=" + this.f141788q + ", rightIndicatorShowMode=" + this.f141789r + ", stepCount=" + this.f141790s + ")";
    }

    public f(int r210, int r211) {
        int r100 = 2;
        if ((r211 & 1) == 0) goto L5;
        int r101 = 2;
    L7:
        if ((r211 & 2) == 0) goto L9;
        int r102 = 1;
    L11:
        if ((r211 & 4) == 0) goto L13;
        int r103 = R.color.ttlive_simple_setting_range_seek_bar_color;
    L15:
        if ((r211 & 8) == 0) goto L17;
        int r104 = R.color.ttlive_simple_setting_range_seek_bar_default_color;
    L18:
        int r110 = 3;
        if ((r211 & 16) == 0) goto L21;
        int r105 = 3;
    L23:
        if ((r211 & 32) != 0) goto L27;
        r100 = 0;
    L27:
        if ((r211 & 64) == 0) goto L29;
        boolean r111 = true;
    L31:
        if ((r211 & 128) == 0) goto L33;
        int r112 = R.color.ttlive_simple_setting_range_seek_bar_step_color;
    L35:
        if ((r211 & 256) == 0) goto L37;
        int r113 = R.color.ttlive_simple_setting_range_seek_bar_step_border_color;
    L39:
        if ((r211 & 512) == 0) goto L41;
        int r114 = 3;
    L43:
        if ((r211 & 1024) != 0) goto L47;
        r110 = 0;
    L47:
        if ((r211 & 2048) == 0) goto L49;
        int r115 = R.color.ttlive_simple_setting_range_seek_bar_thumb_border_color;
    L51:
        if ((r211 & 4096) == 0) goto L53;
        int r106 = 12;
    L55:
        if ((r211 & 8192) == 0) goto L57;
        int r107 = 12;
    L58:
        int r116 = r107;
        if ((r211 & 16384) == 0) goto L61;
        int r108 = 12;
    L63:
        if ((r211 & 32768) == 0) goto L65;
        int r117 = 12;
    L67:
        if ((r211 & 65536) == 0) goto L69;
        int r212 = 1;
    L71:
        if ((r211 & 131072) == 0) goto L73;
        int r213 = 1;
    L75:
        if ((r211 & 262144) == 0) goto L77;
        int r109 = 0;
    L78:
        this.f141772a = r101;
        this.f141773b = r102;
        this.f141774c = r103;
        this.f141775d = r104;
        this.f141776e = r105;
        this.f141777f = r100;
        this.f141778g = r111;
        this.f141779h = r112;
        this.f141780i = r113;
        this.f141781j = r114;
        this.f141782k = r110;
        this.f141783l = r115;
        this.f141784m = r106;
        this.f141785n = r116;
        this.f141786o = r108;
        this.f141787p = r117;
        this.f141788q = r212;
        this.f141789r = r213;
        this.f141790s = r109;
        return;
    L77:
        r109 = r210;
        goto L78
    L73:
        r213 = 0;
        goto L75
    L69:
        r212 = 0;
        goto L71
    L65:
        r117 = 0;
        goto L67
    L61:
        r108 = 0;
        goto L63
    L57:
        r107 = 0;
        goto L58
    L53:
        r106 = 0;
        goto L55
    L49:
        r115 = 0;
        goto L51
    L41:
        r114 = 0;
        goto L43
    L37:
        r113 = 0;
        goto L39
    L33:
        r112 = 0;
        goto L35
    L29:
        r111 = false;
        goto L31
    L21:
        r105 = 0;
        goto L23
    L17:
        r104 = 0;
        goto L18
    L13:
        r103 = 0;
        goto L15
    L9:
        r102 = 0;
        goto L11
    L5:
        r101 = 0;
        goto L7
    }
}
