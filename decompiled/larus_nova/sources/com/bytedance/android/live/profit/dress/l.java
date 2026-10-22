package com.bytedance.android.live.profit.dress;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.profit.dress.config.TextAlignType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class l extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f87138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final py.k f87139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f87140c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a5 f87141d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final py.k f87142e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f87143f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final py.k f87144g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f87145h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final py.k f87146i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f87147j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f87148k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f87149l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final a5 f87150m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.bytedance.android.live.profit.dress.config.h f87151n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f87152o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final TextAlignType f87153p;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof l) == false) goto L38;
        l r101 = (l) r100;
        if (this.f87138a == r101.f87138a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f87139b, r101.f87139b) == true) goto L10;
        return false;
    L10:
        if (this.f87140c == r101.f87140c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f87141d, r101.f87141d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f87142e, r101.f87142e) == true) goto L16;
        return false;
    L16:
        if (this.f87143f == r101.f87143f) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f87144g, r101.f87144g) == true) goto L20;
        return false;
    L20:
        if (this.f87145h == r101.f87145h) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f87146i, r101.f87146i) == true) goto L24;
        return false;
    L24:
        if (this.f87147j == r101.f87147j) goto L26;
        return false;
    L26:
        if (this.f87148k == r101.f87148k) goto L28;
        return false;
    L28:
        if (this.f87149l == r101.f87149l) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f87150m, r101.f87150m) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.f87151n, r101.f87151n) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.f87152o, r101.f87152o) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f87153p, r101.f87153p) == true) goto L58;
        return false;
    L58:
        return true;
    L38:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f87138a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        py.k r102 = this.f87139b;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        long r105 = this.f87140c;
        int r106 = (((r101 + r104) * 31) + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        a5 r107 = this.f87141d;
        if (r107 == null) goto L9;
        int r108 = r107.hashCode();
    L10:
        int r109 = (r106 + r108) * 31;
        py.k r110 = this.f87142e;
        if (r110 == null) goto L13;
        int r111 = r110.hashCode();
    L14:
        long r112 = this.f87143f;
        int r113 = (((r109 + r111) * 31) + ((int) (r112 ^ (r112 >>> 32)))) * 31;
        py.k r114 = this.f87144g;
        if (r114 == null) goto L17;
        int r115 = r114.hashCode();
    L18:
        long r116 = this.f87145h;
        int r117 = (((r113 + r115) * 31) + ((int) (r116 ^ (r116 >>> 32)))) * 31;
        py.k r118 = this.f87146i;
        if (r118 == null) goto L21;
        int r119 = r118.hashCode();
    L22:
        long r120 = this.f87147j;
        int r121 = (((r117 + r119) * 31) + ((int) (r120 ^ (r120 >>> 32)))) * 31;
        long r122 = this.f87148k;
        int r123 = (r121 + ((int) (r122 ^ (r122 >>> 32)))) * 31;
        long r124 = this.f87149l;
        int r125 = (r123 + ((int) (r124 ^ (r124 >>> 32)))) * 31;
        a5 r126 = this.f87150m;
        if (r126 == null) goto L25;
        int r127 = r126.hashCode();
    L26:
        int r128 = (r125 + r127) * 31;
        com.bytedance.android.live.profit.dress.config.h r129 = this.f87151n;
        if (r129 == null) goto L29;
        int r130 = r129.hashCode();
    L30:
        int r131 = (r128 + r130) * 31;
        String r132 = this.f87152o;
        if (r132 == null) goto L33;
        int r133 = r132.hashCode();
    L34:
        int r134 = (r131 + r133) * 31;
        TextAlignType r135 = this.f87153p;
        if (r135 == null) goto L38;
        r103 = r135.hashCode();
    L38:
        return r134 + r103;
    L33:
        r133 = 0;
        goto L34
    L29:
        r130 = 0;
        goto L30
    L25:
        r127 = 0;
        goto L26
    L21:
        r119 = 0;
        goto L22
    L17:
        r115 = 0;
        goto L18
    L13:
        r111 = 0;
        goto L14
    L9:
        r108 = 0;
        goto L10
    L5:
        r104 = 0;
        goto L6
    }

    public final String toString() {
        return "EnterEffectDress(type=" + this.f87138a + ", icon=" + this.f87139b + ", avatarPos=" + this.f87140c + ", text=" + this.f87141d + ", textIcon=" + this.f87142e + ", animAssetId=" + this.f87143f + ", textIconOverlay=" + this.f87144g + ", centerAnimAssetId=" + this.f87145h + ", dynamicImage=" + this.f87146i + ", mp4AnimAssetId=" + this.f87147j + ", alignment=" + this.f87148k + ", alignmentOffset=" + this.f87149l + ", template=" + this.f87150m + ", profilePreviewConfig=" + this.f87151n + ", avatarBorderDressId=" + this.f87152o + ", textAlignType=" + this.f87153p + ")";
    }

    public final long getType() {
        return this.f87138a;
    }

    public l(long r100, py.k r101, long r102, a5 r110, py.k r111, long r112, py.k r113, long r114, py.k r115, long r116, long r210, long r211, a5 r212, com.bytedance.android.live.profit.dress.config.h r213, String r214, TextAlignType r215) {
        Intrinsics.checkNotNullParameter(r215, "textAlignType");
        this.f87138a = r100;
        this.f87139b = r101;
        this.f87140c = r102;
        this.f87141d = r110;
        this.f87142e = r111;
        this.f87143f = r112;
        this.f87144g = r113;
        this.f87145h = r114;
        this.f87146i = r115;
        this.f87147j = r116;
        this.f87148k = r210;
        this.f87149l = r211;
        this.f87150m = r212;
        this.f87151n = r213;
        this.f87152o = r214;
        this.f87153p = r215;
    }
}
