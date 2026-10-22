package com.bytedance.android.shopping.feed.viewmodel;

import com.bytedance.android.shopping.anchorv3.activities.vo.ActivityVO;
import com.bytedance.jedi.arch.State;
import d63.q;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import yd3.p;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/feed/viewmodel/ProductFeedState;", "Lcom/bytedance/jedi/arch/State;", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductFeedState implements State {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f175698a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ActivityVO f175699b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f175700c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f175701d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<Object> f175702e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<rd3.a> f175703f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<rd3.a> f175704g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f175705h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f175706i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<rd3.a> f175707j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f175708k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final p f175709l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f175710m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final p f175711n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List<rd3.a> f175712o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final List<rd3.a> f175713p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f175714q;

    public ProductFeedState() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ProductFeedState) == false) goto L40;
        ProductFeedState r101 = (ProductFeedState) r100;
        if (Intrinsics.areEqual(this.f175698a, r101.f175698a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f175699b, r101.f175699b) == true) goto L10;
        return false;
    L10:
        if (this.f175700c == r101.f175700c) goto L12;
        return false;
    L12:
        if (this.f175701d == r101.f175701d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f175702e, r101.f175702e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f175703f, r101.f175703f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f175704g, r101.f175704g) == true) goto L20;
        return false;
    L20:
        if (this.f175705h == r101.f175705h) goto L22;
        return false;
    L22:
        if (this.f175706i == r101.f175706i) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f175707j, r101.f175707j) == true) goto L26;
        return false;
    L26:
        if (this.f175708k == r101.f175708k) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f175709l, r101.f175709l) == true) goto L30;
        return false;
    L30:
        if (this.f175710m == r101.f175710m) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.f175711n, r101.f175711n) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.f175712o, r101.f175712o) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f175713p, r101.f175713p) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.f175714q, r101.f175714q) == true) goto L61;
        return false;
    L61:
        return true;
    L40:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v17, types: [int] */
    /* JADX WARN: Type inference failed for: r2v19, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v43 */
    /* JADX WARN: Type inference failed for: r2v44 */
    /* JADX WARN: Type inference failed for: r2v48 */
    /* JADX WARN: Type inference failed for: r2v49 */
    /* JADX WARN: Type inference failed for: r2v51 */
    /* JADX WARN: Type inference failed for: r2v52 */
    /* JADX WARN: Type inference failed for: r2v53 */
    /* JADX WARN: Type inference failed for: r2v54 */
    /* JADX WARN: Type inference failed for: r2v6, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        q r100 = this.f175698a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        ActivityVO r104 = this.f175699b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.f175700c;
        ?? r108 = 1;
        ?? r109 = r107;
        if (r107 == false) goto L13;
        r109 = 1;
    L13:
        int r110 = (r106 + r109) * 31;
        boolean r111 = this.f175701d;
        ?? r112 = r111;
        if (r111 == false) goto L16;
        r112 = 1;
    L16:
        int r113 = (r110 + r112) * 31;
        List<Object> r114 = this.f175702e;
        if (r114 == null) goto L19;
        int r115 = r114.hashCode();
    L20:
        int r116 = (r113 + r115) * 31;
        List<rd3.a> r117 = this.f175703f;
        if (r117 == null) goto L23;
        int r118 = r117.hashCode();
    L24:
        int r119 = (r116 + r118) * 31;
        List<rd3.a> r120 = this.f175704g;
        if (r120 == null) goto L27;
        int r121 = r120.hashCode();
    L28:
        int r122 = (r119 + r121) * 31;
        boolean r123 = this.f175705h;
        ?? r124 = r123;
        if (r123 == false) goto L31;
        r124 = 1;
    L31:
        int r125 = (r122 + r124) * 31;
        boolean r126 = this.f175706i;
        ?? r127 = r126;
        if (r126 == false) goto L34;
        r127 = 1;
    L34:
        int r128 = (r125 + r127) * 31;
        List<rd3.a> r129 = this.f175707j;
        if (r129 == null) goto L37;
        int r130 = r129.hashCode();
    L38:
        int r131 = (((r128 + r130) * 31) + this.f175708k) * 31;
        p r132 = this.f175709l;
        if (r132 == null) goto L41;
        int r133 = r132.hashCode();
    L42:
        int r134 = (r131 + r133) * 31;
        boolean r135 = this.f175710m;
        if (r135 == true) goto L46;
        r108 = r135;
    L46:
        int r136 = (r134 + r108) * 31;
        p r137 = this.f175711n;
        if (r137 == null) goto L49;
        int r138 = r137.hashCode();
    L50:
        int r139 = (r136 + r138) * 31;
        List<rd3.a> r140 = this.f175712o;
        if (r140 == null) goto L53;
        int r141 = r140.hashCode();
    L54:
        int r142 = (r139 + r141) * 31;
        List<rd3.a> r143 = this.f175713p;
        if (r143 == null) goto L57;
        int r144 = r143.hashCode();
    L58:
        int r145 = (r142 + r144) * 31;
        String r146 = this.f175714q;
        if (r146 == null) goto L62;
        r101 = r146.hashCode();
    L62:
        return r145 + r101;
    L57:
        r144 = 0;
        goto L58
    L53:
        r141 = 0;
        goto L54
    L49:
        r138 = 0;
        goto L50
    L41:
        r133 = 0;
        goto L42
    L37:
        r130 = 0;
        goto L38
    L27:
        r121 = 0;
        goto L28
    L23:
        r118 = 0;
        goto L24
    L19:
        r115 = 0;
        goto L20
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ProductFeedState(navBtnVO=" + this.f175698a + ", activityVO=" + this.f175699b + ", isLoadingMore=" + this.f175700c + ", hasMore=" + this.f175701d + ", headerList=" + this.f175702e + ", guessULikeList=" + this.f175703f + ", firstLoadGuessULikeResourceCardList=" + this.f175704g + ", isRecommendUpdateRequest=" + this.f175705h + ", isResourceCardLoaded=" + this.f175706i + ", cardList=" + this.f175707j + ", topicCardPosition=" + this.f175708k + ", mallDivertResourceCard=" + this.f175709l + ", isFloatMallIconVisible=" + this.f175710m + ", searchCard=" + this.f175711n + ", goodPriceCards=" + this.f175712o + ", goodPriceStrips=" + this.f175713p + ", removeGoodPriceCardByProdId=" + this.f175714q + ")";
    }

    public /* synthetic */ ProductFeedState(int r110) {
        this(null, null, false, true, CollectionsKt.emptyList(), new ArrayList(), new ArrayList(), false, false, new ArrayList(), -1, null, false, null, null, null, null);
    }

    public ProductFeedState(q r100, ActivityVO r101, boolean r102, boolean r110, List<? extends Object> r111, List<rd3.a> r112, List<rd3.a> r113, boolean r114, boolean r115, List<rd3.a> r116, int r117, p r118, boolean r119, p r210, List<rd3.a> r211, List<rd3.a> r212, String r213) {
        Intrinsics.checkNotNullParameter(r111, "headerList");
        Intrinsics.checkNotNullParameter(r112, "guessULikeList");
        Intrinsics.checkNotNullParameter(r113, "firstLoadGuessULikeResourceCardList");
        Intrinsics.checkNotNullParameter(r116, "cardList");
        this.f175698a = r100;
        this.f175699b = r101;
        this.f175700c = r102;
        this.f175701d = r110;
        this.f175702e = r111;
        this.f175703f = r112;
        this.f175704g = r113;
        this.f175705h = r114;
        this.f175706i = r115;
        this.f175707j = r116;
        this.f175708k = r117;
        this.f175709l = r118;
        this.f175710m = r119;
        this.f175711n = r210;
        this.f175712o = r211;
        this.f175713p = r212;
        this.f175714q = r213;
    }

    public static ProductFeedState a(ProductFeedState r210, ActivityVO r211, boolean r212, boolean r213, List r214, List r215, List r216, boolean r217, boolean r310, int r311, p r312, boolean r313, p r314, List r315, List r316, String r317, int r318) {
        List<rd3.a> r100 = null;
        if ((r318 & 1) == 0) goto L5;
        q r101 = r210.f175698a;
    L7:
        if ((r318 & 2) == 0) goto L9;
        ActivityVO r102 = r210.f175699b;
    L11:
        if ((r318 & 4) == 0) goto L13;
        boolean r103 = r210.f175700c;
    L15:
        if ((r318 & 8) == 0) goto L17;
        boolean r104 = r210.f175701d;
    L19:
        if ((r318 & 16) == 0) goto L21;
        List r105 = r210.f175702e;
    L23:
        if ((r318 & 32) == 0) goto L25;
        List r110 = r210.f175703f;
    L27:
        if ((r318 & 64) == 0) goto L29;
        List r111 = r210.f175704g;
    L31:
        if ((r318 & 128) == 0) goto L33;
        boolean r112 = r210.f175705h;
    L35:
        if ((r318 & 256) == 0) goto L37;
        boolean r113 = r210.f175706i;
    L39:
        if ((r318 & 512) == 0) goto L41;
        r100 = r210.f175707j;
    L41:
        List<rd3.a> r114 = r100;
        if ((r318 & 1024) == 0) goto L44;
        int r115 = r210.f175708k;
    L46:
        if ((r318 & 2048) == 0) goto L48;
        p r116 = r210.f175709l;
    L50:
        if ((r318 & 4096) == 0) goto L52;
        boolean r117 = r210.f175710m;
    L54:
        if ((r318 & 8192) == 0) goto L56;
        p r118 = r210.f175711n;
    L58:
        if ((r318 & 16384) == 0) goto L60;
        List r119 = r210.f175712o;
    L62:
        if ((32768 & r318) == 0) goto L64;
        List r218 = r210.f175713p;
    L66:
        if ((r318 & 65536) == 0) goto L68;
        String r219 = r210.f175714q;
    L69:
        r210.getClass();
        Intrinsics.checkNotNullParameter(r105, "headerList");
        Intrinsics.checkNotNullParameter(r110, "guessULikeList");
        Intrinsics.checkNotNullParameter(r111, "firstLoadGuessULikeResourceCardList");
        Intrinsics.checkNotNullParameter(r114, "cardList");
        return new ProductFeedState(r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r218, r219);
    L68:
        r219 = r317;
        goto L69
    L64:
        r218 = r316;
        goto L66
    L60:
        r119 = r315;
        goto L62
    L56:
        r118 = r314;
        goto L58
    L52:
        r117 = r313;
        goto L54
    L48:
        r116 = r312;
        goto L50
    L44:
        r115 = r311;
        goto L46
    L37:
        r113 = r310;
        goto L39
    L33:
        r112 = r217;
        goto L35
    L29:
        r111 = r216;
        goto L31
    L25:
        r110 = r215;
        goto L27
    L21:
        r105 = r214;
        goto L23
    L17:
        r104 = r213;
        goto L19
    L13:
        r103 = r212;
        goto L15
    L9:
        r102 = r211;
        goto L11
    L5:
        r101 = null;
        goto L7
    }
}
