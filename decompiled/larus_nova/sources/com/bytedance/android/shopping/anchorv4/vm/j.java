package com.bytedance.android.shopping.anchorv4.vm;

import com.bytedance.android.shopping.anchorv3.repository.dto.PromotionRecommendResponse;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<com.bytedance.android.ecom.arch.slice.adapter.b> f167762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.shopping.anchorv4.voavhs.detailhead.d f167763b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<com.bytedance.android.shopping.anchorv4.voavhs.detailimages.d> f167764c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<d63.d> f167765d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<j63.c> f167766e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final j63.a f167767f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f167768g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final PromotionRecommendResponse f167769h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<com.bytedance.android.ecom.arch.slice.adapter.b> f167770i;

    public j() {
        this(null, null, null, null, null, null, null, null, null, 511);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j) == false) goto L24;
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f167762a, r101.f167762a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f167763b, r101.f167763b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f167764c, r101.f167764c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f167765d, r101.f167765d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f167766e, r101.f167766e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f167767f, r101.f167767f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f167768g, r101.f167768g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f167769h, r101.f167769h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f167770i, r101.f167770i) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public final int hashCode() {
        List<com.bytedance.android.ecom.arch.slice.adapter.b> r100 = this.f167762a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        com.bytedance.android.shopping.anchorv4.voavhs.detailhead.d r104 = this.f167763b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<com.bytedance.android.shopping.anchorv4.voavhs.detailimages.d> r107 = this.f167764c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<d63.d> r110 = this.f167765d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        List<j63.c> r113 = this.f167766e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        j63.a r116 = this.f167767f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        a r119 = this.f167768g;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        PromotionRecommendResponse r122 = this.f167769h;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        List<com.bytedance.android.ecom.arch.slice.adapter.b> r125 = this.f167770i;
        if (r125 == null) goto L38;
        r101 = r125.hashCode();
    L38:
        return r124 + r101;
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "PdListStateHolder(componentVOS=" + this.f167762a + ", detailHeadVO=" + this.f167763b + ", detailImageVOS=" + this.f167764c + ", unifiedTipsVOS=" + this.f167765d + ", guessUVOS=" + this.f167766e + ", showGuessULike=" + this.f167767f + ", collapseInfo=" + this.f167768g + ", shopRecommends=" + this.f167769h + ", instantRevisionRecommendData=" + this.f167770i + ")";
    }

    public static j a(j r110, List r111) {
        List<com.bytedance.android.ecom.arch.slice.adapter.b> r100 = r110.f167762a;
        com.bytedance.android.shopping.anchorv4.voavhs.detailhead.d r101 = r110.f167763b;
        List<com.bytedance.android.shopping.anchorv4.voavhs.detailimages.d> r102 = r110.f167764c;
        List<d63.d> r103 = r110.f167765d;
        List<j63.c> r104 = r110.f167766e;
        j63.a r105 = r110.f167767f;
        a r106 = r110.f167768g;
        PromotionRecommendResponse r107 = r110.f167769h;
        r110.getClass();
        return new j(r100, r101, r102, r103, r104, r105, r106, r107, r111);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j(List<? extends com.bytedance.android.ecom.arch.slice.adapter.b> r100, com.bytedance.android.shopping.anchorv4.voavhs.detailhead.d r101, List<com.bytedance.android.shopping.anchorv4.voavhs.detailimages.d> r102, List<d63.d> r103, List<j63.c> r104, j63.a r105, a r106, PromotionRecommendResponse r107, List<? extends com.bytedance.android.ecom.arch.slice.adapter.b> r108) {
        this.f167762a = r100;
        this.f167763b = r101;
        this.f167764c = r102;
        this.f167765d = r103;
        this.f167766e = r104;
        this.f167767f = r105;
        this.f167768g = r106;
        this.f167769h = r107;
        this.f167770i = r108;
    }

    public /* synthetic */ j(List r110, com.bytedance.android.shopping.anchorv4.voavhs.detailhead.d r111, List r112, List r113, List r114, j63.a r115, a r116, PromotionRecommendResponse r117, List r118, int r210) {
        List r100 = null;
        if ((r210 & 1) == 0) goto L5;
        List r101 = null;
    L7:
        if ((r210 & 2) == 0) goto L9;
        com.bytedance.android.shopping.anchorv4.voavhs.detailhead.d r102 = null;
    L11:
        if ((r210 & 4) == 0) goto L13;
        List r103 = null;
    L15:
        if ((r210 & 8) == 0) goto L17;
        List r104 = null;
    L19:
        if ((r210 & 16) == 0) goto L21;
        List r105 = null;
    L23:
        if ((r210 & 32) == 0) goto L25;
        j63.a r106 = null;
    L27:
        if ((r210 & 64) == 0) goto L29;
        a r107 = null;
    L31:
        if ((r210 & 128) == 0) goto L33;
        PromotionRecommendResponse r108 = null;
    L35:
        if ((r210 & 256) != 0) goto L38;
        r100 = r118;
    L38:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r100);
        return;
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
