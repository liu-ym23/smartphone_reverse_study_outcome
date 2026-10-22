package com.bytedance.android.shopping.api.video;

import com.bytedance.android.ec.model.playback.ExplainReplaySubTitle;
import com.google.gson.JsonElement;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f170650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f170651b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f170652c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<b> f170653d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<b> f170654e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d f170655f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f170656g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f170657h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<JsonElement> f170658i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f170659j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f170660k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<ExplainReplaySubTitle> f170661l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final da3.c f170662m;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L32;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f170650a, r101.f170650a) == true) goto L8;
        return false;
    L8:
        if (this.f170651b == r101.f170651b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f170652c, r101.f170652c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f170653d, r101.f170653d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f170654e, r101.f170654e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f170655f, r101.f170655f) == true) goto L18;
        return false;
    L18:
        if (this.f170656g == r101.f170656g) goto L20;
        return false;
    L20:
        if (Float.compare(this.f170657h, r101.f170657h) == 0) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f170658i, r101.f170658i) == true) goto L24;
        return false;
    L24:
        if (this.f170659j == r101.f170659j) goto L26;
        return false;
    L26:
        if (this.f170660k == r101.f170660k) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f170661l, r101.f170661l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f170662m, r101.f170662m) == true) goto L49;
        return false;
    L49:
        return true;
    L32:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f170650a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        long r103 = this.f170651b;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        String r105 = this.f170652c;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        List<b> r108 = this.f170653d;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (r107 + r109) * 31;
        List<b> r111 = this.f170654e;
        if (r111 == null) goto L17;
        int r112 = r111.hashCode();
    L18:
        int r113 = (r110 + r112) * 31;
        d r114 = this.f170655f;
        if (r114 == null) goto L21;
        int r115 = r114.hashCode();
    L22:
        int r116 = (r113 + r115) * 31;
        long r117 = this.f170656g;
        int r118 = (((r116 + ((int) (r117 ^ (r117 >>> 32)))) * 31) + Float.floatToIntBits(this.f170657h)) * 31;
        List<JsonElement> r119 = this.f170658i;
        if (r119 == null) goto L25;
        int r120 = r119.hashCode();
    L26:
        int r121 = (((((r118 + r120) * 31) + this.f170659j) * 31) + this.f170660k) * 31;
        List<ExplainReplaySubTitle> r122 = this.f170661l;
        if (r122 == null) goto L29;
        int r123 = r122.hashCode();
    L30:
        int r124 = (r121 + r123) * 31;
        da3.c r125 = this.f170662m;
        if (r125 == null) goto L34;
        r101 = r125.hashCode();
    L34:
        return r124 + r101;
    L29:
        r123 = 0;
        goto L30
    L25:
        r120 = 0;
        goto L26
    L21:
        r115 = 0;
        goto L22
    L17:
        r112 = 0;
        goto L18
    L13:
        r109 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ECVideoModel(key=" + this.f170650a + ", duration=" + this.f170651b + ", ratio=" + this.f170652c + ", playItems=" + this.f170653d + ", selectablePlayItems=" + this.f170654e + ", playerOptions=" + this.f170655f + ", cdnUrlExpired=" + this.f170656g + ", aspectRatio=" + this.f170657h + ", videoThumbs=" + this.f170658i + ", height=" + this.f170659j + ", width=" + this.f170660k + ", subTitle=" + this.f170661l + ", subTitleCallback=" + this.f170662m + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(String r100, long r101, String r102, List<b> r110, List<b> r111, d r112, long r113, float r114, List<? extends JsonElement> r115, int r116, int r117, List<ExplainReplaySubTitle> r118, da3.c r210) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r110, "playItems");
        this.f170650a = r100;
        this.f170651b = r101;
        this.f170652c = r102;
        this.f170653d = r110;
        this.f170654e = r111;
        this.f170655f = r112;
        this.f170656g = r113;
        this.f170657h = r114;
        this.f170658i = r115;
        this.f170659j = r116;
        this.f170660k = r117;
        this.f170661l = r118;
        this.f170662m = r210;
    }
}
