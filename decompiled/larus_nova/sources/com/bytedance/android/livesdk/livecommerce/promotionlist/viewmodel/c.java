package com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel;

import com.bytedance.android.livesdk.livecommerce.base.paging.PageListLoadStatus;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionList;
import com.bytedance.android.livesdk.livecommerce.network.response.PromotionCategory;
import com.bytedance.android.livesdk.livecommerce.promotionlist.model.LivePromotionPageBottomData;
import com.bytedance.android.livesdk.livecommerce.promotionlist.model.LivePromotionPageDynamicOpenRegion;
import com.bytedance.android.livesdk.livecommerce.promotionlist.model.Toggle;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import mj2.h;

/* JADX INFO: loaded from: classes10.dex */
public final class c implements com.bytedance.android.ec.core.arch.state.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<PromotionCategory> f151335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f151336b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f151337c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ECPromotionList.r f151338d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LivePromotionPageBottomData f151339e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ECPromotionList.o f151340f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final h<PageListLoadStatus> f151341g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f151342h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Toggle f151343i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final LivePromotionPageDynamicOpenRegion f151344j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f151345k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f151346l;

    public c() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L30;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f151335a, r101.f151335a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f151336b, r101.f151336b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f151337c, r101.f151337c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f151338d, r101.f151338d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f151339e, r101.f151339e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f151340f, r101.f151340f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f151341g, r101.f151341g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f151342h, r101.f151342h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f151343i, r101.f151343i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f151344j, r101.f151344j) == true) goto L26;
        return false;
    L26:
        if (this.f151345k == r101.f151345k) goto L28;
        return false;
    L28:
        if (this.f151346l == r101.f151346l) goto L46;
        return false;
    L46:
        return true;
    L30:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v22, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public final int hashCode() {
        List<PromotionCategory> r100 = this.f151335a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f151336b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f151337c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        ECPromotionList.r r110 = this.f151338d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        LivePromotionPageBottomData r113 = this.f151339e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        ECPromotionList.o r116 = this.f151340f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        h<PageListLoadStatus> r119 = this.f151341g;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f151342h;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        Toggle r125 = this.f151343i;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        LivePromotionPageDynamicOpenRegion r128 = this.f151344j;
        if (r128 == null) goto L41;
        r101 = r128.hashCode();
    L41:
        int r129 = (r127 + r101) * 31;
        boolean r130 = this.f151345k;
        ?? r131 = r130;
        if (r130 == false) goto L45;
        r131 = 1;
    L45:
        return ((r129 + r131) * 31) + this.f151346l;
    L37:
        r126 = 0;
        goto L38
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
        return "LivePromotionListState(categoryInfo=" + this.f151335a + ", categoryStyle=" + this.f151336b + ", categorySkinType=" + this.f151337c + ", promotionBackground=" + this.f151338d + ", bottomData=" + this.f151339e + ", listBannerInfo=" + this.f151340f + ", loadInitialStatus=" + this.f151341g + ", listBackgroundColor=" + this.f151342h + ", toggle=" + this.f151343i + ", openRegion=" + this.f151344j + ", showProductCardStyle=" + this.f151345k + ", headerAreaMarginBottom=" + this.f151346l + ")";
    }

    public /* synthetic */ c(int r110) {
        this(null, null, null, null, null, null, null, null, null, null, false, 0);
    }

    public c(List<PromotionCategory> r100, Integer r101, String r102, ECPromotionList.r r103, LivePromotionPageBottomData r104, ECPromotionList.o r105, h<PageListLoadStatus> r106, String r107, Toggle r108, LivePromotionPageDynamicOpenRegion r110, boolean r111, int r112) {
        this.f151335a = r100;
        this.f151336b = r101;
        this.f151337c = r102;
        this.f151338d = r103;
        this.f151339e = r104;
        this.f151340f = r105;
        this.f151341g = r106;
        this.f151342h = r107;
        this.f151343i = r108;
        this.f151344j = r110;
        this.f151345k = r111;
        this.f151346l = r112;
    }

    public static c a(c r110, List r111, Integer r112, String r113, ECPromotionList.r r114, ECPromotionList.o r115, h r116, String r210, Toggle r211, LivePromotionPageDynamicOpenRegion r212, boolean r213, int r214, int r215) {
        if ((r215 & 1) == 0) goto L5;
        List r100 = r110.f151335a;
    L7:
        if ((r215 & 2) == 0) goto L9;
        Integer r101 = r110.f151336b;
    L11:
        if ((r215 & 4) == 0) goto L13;
        String r102 = r110.f151337c;
    L15:
        if ((r215 & 8) == 0) goto L17;
        ECPromotionList.r r103 = r110.f151338d;
    L19:
        if ((r215 & 16) == 0) goto L21;
        LivePromotionPageBottomData r104 = r110.f151339e;
    L23:
        if ((r215 & 32) == 0) goto L25;
        ECPromotionList.o r105 = r110.f151340f;
    L27:
        if ((r215 & 64) == 0) goto L29;
        h r106 = r110.f151341g;
    L31:
        if ((r215 & 128) == 0) goto L33;
        String r107 = r110.f151342h;
    L35:
        if ((r215 & 256) == 0) goto L37;
        Toggle r117 = r110.f151343i;
    L39:
        if ((r215 & 512) == 0) goto L41;
        LivePromotionPageDynamicOpenRegion r118 = r110.f151344j;
    L43:
        if ((r215 & 1024) == 0) goto L45;
        boolean r119 = r110.f151345k;
    L47:
        if ((r215 & 2048) == 0) goto L49;
        int r108 = r110.f151346l;
    L50:
        r110.getClass();
        return new c(r100, r101, r102, r103, r104, r105, r106, r107, r117, r118, r119, r108);
    L49:
        r108 = r214;
        goto L50
    L45:
        r119 = r213;
        goto L47
    L41:
        r118 = r212;
        goto L43
    L37:
        r117 = r211;
        goto L39
    L33:
        r107 = r210;
        goto L35
    L29:
        r106 = r116;
        goto L31
    L25:
        r105 = r115;
        goto L27
    L21:
        r104 = null;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }
}
