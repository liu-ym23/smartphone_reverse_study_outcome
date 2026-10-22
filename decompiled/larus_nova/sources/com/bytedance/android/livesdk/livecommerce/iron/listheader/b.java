package com.bytedance.android.livesdk.livecommerce.iron.listheader;

import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionEnhancedSearchEntry;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionEntry;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionHeaderLayoutControl;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionList;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionSingleEntry;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class b {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f148779m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, List<ECRitTag>> f148780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ECPromotionList.d f148781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ECPromotionList.v f148782c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ECPromotionList.f f148783d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<ECPromotionEntry> f148784e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, String> f148785f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f148786g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f148787h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f148788i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ECPromotionHeaderLayoutControl f148789j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ECPromotionEnhancedSearchEntry f148790k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ECPromotionSingleEntry f148791l;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L30;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f148780a, r101.f148780a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f148781b, r101.f148781b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f148782c, r101.f148782c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f148783d, r101.f148783d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f148784e, r101.f148784e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f148785f, r101.f148785f) == true) goto L18;
        return false;
    L18:
        if (this.f148786g == r101.f148786g) goto L20;
        return false;
    L20:
        if (this.f148787h == r101.f148787h) goto L22;
        return false;
    L22:
        if (this.f148788i == r101.f148788i) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f148789j, r101.f148789j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f148790k, r101.f148790k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f148791l, r101.f148791l) == true) goto L46;
        return false;
    L46:
        return true;
    L30:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v16, types: [int] */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        Map<String, List<ECRitTag>> r100 = this.f148780a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        ECPromotionList.d r104 = this.f148781b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        ECPromotionList.v r107 = this.f148782c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        ECPromotionList.f r110 = this.f148783d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        List<ECPromotionEntry> r113 = this.f148784e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Map<String, String> r116 = this.f148785f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        boolean r119 = this.f148786g;
        ?? r120 = 1;
        ?? r121 = r119;
        if (r119 == false) goto L29;
        r121 = 1;
    L29:
        int r122 = (((r118 + r121) * 31) + this.f148787h) * 31;
        boolean r123 = this.f148788i;
        if (r123 == true) goto L33;
        r120 = r123;
    L33:
        int r124 = (r122 + r120) * 31;
        ECPromotionHeaderLayoutControl r125 = this.f148789j;
        if (r125 == null) goto L36;
        int r126 = r125.hashCode();
    L37:
        int r127 = (r124 + r126) * 31;
        ECPromotionEnhancedSearchEntry r128 = this.f148790k;
        if (r128 == null) goto L40;
        int r129 = r128.hashCode();
    L41:
        int r130 = (r127 + r129) * 31;
        ECPromotionSingleEntry r131 = this.f148791l;
        if (r131 == null) goto L45;
        r101 = r131.hashCode();
    L45:
        return r130 + r101;
    L40:
        r129 = 0;
        goto L41
    L36:
        r126 = 0;
        goto L37
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
        return "IronListHeaderData(anchorTags=" + this.f148780a + ", authorReputation=" + this.f148781b + ", storeEntranceInfo=" + this.f148782c + ", authorShopInfo=" + this.f148783d + ", entries=" + this.f148784e + ", extraParams=" + this.f148785f + ", isCouponList=" + this.f148786g + ", promotionCount=" + this.f148787h + ", isFlashRoom=" + this.f148788i + ", layoutControl=" + this.f148789j + ", searchEntry=" + this.f148790k + ", singleEntry=" + this.f148791l + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(Map<String, ? extends List<ECRitTag>> r100, ECPromotionList.d r101, ECPromotionList.v r102, ECPromotionList.f r103, List<ECPromotionEntry> r104, Map<String, String> r105, boolean r106, int r107, boolean r110, ECPromotionHeaderLayoutControl r111, ECPromotionEnhancedSearchEntry r112, ECPromotionSingleEntry r113) {
        Intrinsics.checkNotNullParameter(r105, "extraParams");
        this.f148780a = r100;
        this.f148781b = r101;
        this.f148782c = r102;
        this.f148783d = r103;
        this.f148784e = r104;
        this.f148785f = r105;
        this.f148786g = r106;
        this.f148787h = r107;
        this.f148788i = r110;
        this.f148789j = r111;
        this.f148790k = r112;
        this.f148791l = r113;
    }
}
