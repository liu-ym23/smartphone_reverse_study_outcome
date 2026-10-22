package com.bytedance.android.shopping.anchorv3.matchpurchase.model;

import com.ss.android.ugc.aweme.kiwi.model.QModel;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b1\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B¿\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0004¢\u0006\u0002\u0010\u0019J\t\u00100\u001a\u00020\u0004HÆ\u0003J\t\u00101\u001a\u00020\u0004HÆ\u0003J\t\u00102\u001a\u00020\u0004HÆ\u0003J\t\u00103\u001a\u00020\u0004HÆ\u0003J\t\u00104\u001a\u00020\u0004HÆ\u0003J\t\u00105\u001a\u00020\u0004HÆ\u0003J\u0010\u00106\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010#J\t\u00107\u001a\u00020\u0015HÆ\u0003J\t\u00108\u001a\u00020\u0015HÆ\u0003J\t\u00109\u001a\u00020\u0004HÆ\u0003J\t\u0010:\u001a\u00020\u0004HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010<\u001a\u00020\u0004HÆ\u0003J\t\u0010=\u001a\u00020\bHÆ\u0003J\t\u0010>\u001a\u00020\bHÆ\u0003J\t\u0010?\u001a\u00020\u0004HÆ\u0003J\t\u0010@\u001a\u00020\u0004HÆ\u0003J\t\u0010A\u001a\u00020\u0004HÆ\u0003J\t\u0010B\u001a\u00020\u0004HÆ\u0003JÐ\u0001\u0010C\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00042\b\b\u0002\u0010\u0018\u001a\u00020\u0004HÆ\u0001¢\u0006\u0002\u0010DJ\u0013\u0010E\u001a\u00020\u00152\b\u0010F\u001a\u0004\u0018\u00010GHÖ\u0003J\b\u0010H\u001a\u0004\u0018\u00010\u0004J\t\u0010I\u001a\u00020\bHÖ\u0001J\b\u0010J\u001a\u00020\bH\u0016J\t\u0010K\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0018\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0011\u0010\u0010\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\n\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001bR\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001bR\u0015\u0010\u0013\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u0011\u0010\u0016\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010%R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010%R\u0011\u0010\f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001bR\u0011\u0010\u0011\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001bR\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001bR\u0011\u0010\u0012\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001bR\u0011\u0010\u000e\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001bR\u0011\u0010\u0017\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001bR\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001f¨\u0006L"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/matchpurchase/model/MatchPurchaseParams;", "Lcom/ss/android/ugc/aweme/kiwi/model/QModel;", "Ljava/io/Serializable;", "productId", "", "promotionId", "combinationIds", "tag", "", "curPageIndex", "enterFrom", "sourcePage", "kolId", "metaParam", "requestAdditions", "entranceInfo", "cpsTrack", "marketingChannel", "newSourceType", "heightPercent", "isPicMatching", "", "isFullScreen", "sourceBtmToken", "combinationPromotionList", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ZZLjava/lang/String;Ljava/lang/String;)V", "getCombinationIds", "()Ljava/lang/String;", "getCombinationPromotionList", "getCpsTrack", "getCurPageIndex", "()I", "getEnterFrom", "getEntranceInfo", "getHeightPercent", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "()Z", "getKolId", "getMarketingChannel", "getMetaParam", "getNewSourceType", "getProductId", "getPromotionId", "getRequestAdditions", "getSourceBtmToken", "getSourcePage", "getTag", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ZZLjava/lang/String;Ljava/lang/String;)Lcom/bytedance/android/shopping/anchorv3/matchpurchase/model/MatchPurchaseParams;", "equals", "other", "", "getCurPageCombinationId", "hashCode", "modelType", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MatchPurchaseParams implements QModel, Serializable {
    private final String combinationIds;
    private final String combinationPromotionList;
    private final String cpsTrack;
    private final int curPageIndex;
    private final String enterFrom;
    private final String entranceInfo;
    private final Integer heightPercent;
    private final boolean isFullScreen;
    private final boolean isPicMatching;
    private final String kolId;
    private final String marketingChannel;
    private final String metaParam;
    private final String newSourceType;
    private final String productId;
    private final String promotionId;
    private final String requestAdditions;
    private final String sourceBtmToken;
    private final String sourcePage;
    private final int tag;

    public static /* synthetic */ MatchPurchaseParams copy$default(MatchPurchaseParams r110, String r111, String r112, String r210, int r211, int r212, String r213, String r214, String r215, String r216, String r217, String r218, String r219, String r310, String r311, Integer r312, boolean r313, boolean r314, String r315, String r316, int r317, Object r318) {
        if ((r317 & 1) == 0) goto L5;
        String r100 = r110.productId;
    L7:
        if ((r317 & 2) == 0) goto L9;
        String r101 = r110.promotionId;
    L11:
        if ((r317 & 4) == 0) goto L13;
        String r102 = r110.combinationIds;
    L15:
        if ((r317 & 8) == 0) goto L17;
        int r103 = r110.tag;
    L19:
        if ((r317 & 16) == 0) goto L21;
        int r104 = r110.curPageIndex;
    L23:
        if ((r317 & 32) == 0) goto L25;
        String r105 = r110.enterFrom;
    L27:
        if ((r317 & 64) == 0) goto L29;
        String r106 = r110.sourcePage;
    L31:
        if ((r317 & 128) == 0) goto L33;
        String r107 = r110.kolId;
    L35:
        if ((r317 & 256) == 0) goto L37;
        String r113 = r110.metaParam;
    L39:
        if ((r317 & 512) == 0) goto L41;
        String r114 = r110.requestAdditions;
    L43:
        if ((r317 & 1024) == 0) goto L45;
        String r115 = r110.entranceInfo;
    L47:
        if ((r317 & 2048) == 0) goto L49;
        String r116 = r110.cpsTrack;
    L51:
        if ((r317 & 4096) == 0) goto L53;
        String r117 = r110.marketingChannel;
    L55:
        if ((r317 & 8192) == 0) goto L57;
        String r118 = r110.newSourceType;
    L58:
        String r319 = r118;
        if ((r317 & 16384) == 0) goto L61;
        Integer r119 = r110.heightPercent;
    L62:
        Integer r320 = r119;
        if ((r317 & 32768) == 0) goto L65;
        boolean r120 = r110.isPicMatching;
    L66:
        boolean r321 = r120;
        if ((r317 & 65536) == 0) goto L69;
        boolean r121 = r110.isFullScreen;
    L70:
        boolean r322 = r121;
        if ((r317 & 131072) == 0) goto L73;
        String r122 = r110.sourceBtmToken;
    L75:
        if ((r317 & 262144) == 0) goto L77;
        String r108 = r110.combinationPromotionList;
    L79:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r319, r320, r321, r322, r122, r108);
    L77:
        r108 = r316;
        goto L79
    L73:
        r122 = r315;
        goto L75
    L69:
        r121 = r314;
        goto L70
    L65:
        r120 = r313;
        goto L66
    L61:
        r119 = r312;
        goto L62
    L57:
        r118 = r311;
        goto L58
    L53:
        r117 = r310;
        goto L55
    L49:
        r116 = r219;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.productId;
    }

    public final String component10() {
        return this.requestAdditions;
    }

    public final String component11() {
        return this.entranceInfo;
    }

    public final String component12() {
        return this.cpsTrack;
    }

    public final String component13() {
        return this.marketingChannel;
    }

    public final String component14() {
        return this.newSourceType;
    }

    public final Integer component15() {
        return this.heightPercent;
    }

    public final boolean component16() {
        return this.isPicMatching;
    }

    public final boolean component17() {
        return this.isFullScreen;
    }

    public final String component18() {
        return this.sourceBtmToken;
    }

    public final String component19() {
        return this.combinationPromotionList;
    }

    public final String component2() {
        return this.promotionId;
    }

    public final String component3() {
        return this.combinationIds;
    }

    public final int component4() {
        return this.tag;
    }

    public final int component5() {
        return this.curPageIndex;
    }

    public final String component6() {
        return this.enterFrom;
    }

    public final String component7() {
        return this.sourcePage;
    }

    public final String component8() {
        return this.kolId;
    }

    public final String component9() {
        return this.metaParam;
    }

    public final MatchPurchaseParams copy(String r210, String r211, String r212, int r213, int r214, String r215, String r216, String r310, String r311, String r312, String r313, String r314, String r315, String r316, Integer r317, boolean r318, boolean r319, String r410, String r411) {
        Intrinsics.checkNotNullParameter(r210, "productId");
        Intrinsics.checkNotNullParameter(r212, "combinationIds");
        Intrinsics.checkNotNullParameter(r215, "enterFrom");
        Intrinsics.checkNotNullParameter(r216, "sourcePage");
        Intrinsics.checkNotNullParameter(r310, "kolId");
        Intrinsics.checkNotNullParameter(r311, "metaParam");
        Intrinsics.checkNotNullParameter(r312, "requestAdditions");
        Intrinsics.checkNotNullParameter(r313, "entranceInfo");
        Intrinsics.checkNotNullParameter(r314, "cpsTrack");
        Intrinsics.checkNotNullParameter(r315, "marketingChannel");
        Intrinsics.checkNotNullParameter(r316, "newSourceType");
        Intrinsics.checkNotNullParameter(r410, "sourceBtmToken");
        Intrinsics.checkNotNullParameter(r411, "combinationPromotionList");
        return new MatchPurchaseParams(r210, r211, r212, r213, r214, r215, r216, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof MatchPurchaseParams) == false) goto L44;
        MatchPurchaseParams r101 = (MatchPurchaseParams) r100;
        if (Intrinsics.areEqual(this.productId, r101.productId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.promotionId, r101.promotionId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.combinationIds, r101.combinationIds) == true) goto L12;
        return false;
    L12:
        if (this.tag == r101.tag) goto L14;
        return false;
    L14:
        if (this.curPageIndex == r101.curPageIndex) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.enterFrom, r101.enterFrom) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.sourcePage, r101.sourcePage) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.kolId, r101.kolId) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.metaParam, r101.metaParam) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.requestAdditions, r101.requestAdditions) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.entranceInfo, r101.entranceInfo) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.cpsTrack, r101.cpsTrack) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.marketingChannel, r101.marketingChannel) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.newSourceType, r101.newSourceType) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.heightPercent, r101.heightPercent) == true) goto L36;
        return false;
    L36:
        if (this.isPicMatching == r101.isPicMatching) goto L38;
        return false;
    L38:
        if (this.isFullScreen == r101.isFullScreen) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.sourceBtmToken, r101.sourceBtmToken) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.combinationPromotionList, r101.combinationPromotionList) == true) goto L67;
        return false;
    L67:
        return true;
    L44:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v32, types: [int] */
    /* JADX WARN: Type inference failed for: r2v39, types: [int] */
    /* JADX WARN: Type inference failed for: r2v46 */
    /* JADX WARN: Type inference failed for: r2v59 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        String r100 = this.productId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.promotionId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.combinationIds;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (((((r106 + r108) * 31) + this.tag) * 31) + this.curPageIndex) * 31;
        String r110 = this.enterFrom;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.sourcePage;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.kolId;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.metaParam;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.requestAdditions;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.entranceInfo;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.cpsTrack;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.marketingChannel;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.newSourceType;
        if (r134 == null) goto L49;
        int r135 = r134.hashCode();
    L50:
        int r136 = (r133 + r135) * 31;
        Integer r137 = this.heightPercent;
        if (r137 == null) goto L53;
        int r138 = r137.hashCode();
    L54:
        int r139 = (r136 + r138) * 31;
        boolean r140 = this.isPicMatching;
        ?? r141 = 1;
        ?? r142 = r140;
        if (r140 == false) goto L57;
        r142 = 1;
    L57:
        int r143 = (r139 + r142) * 31;
        boolean r144 = this.isFullScreen;
        if (r144 == true) goto L61;
        r141 = r144;
    L61:
        int r145 = (r143 + r141) * 31;
        String r146 = this.sourceBtmToken;
        if (r146 == null) goto L64;
        int r147 = r146.hashCode();
    L65:
        int r148 = (r145 + r147) * 31;
        String r149 = this.combinationPromotionList;
        if (r149 == null) goto L69;
        r101 = r149.hashCode();
    L69:
        return r148 + r101;
    L64:
        r147 = 0;
        goto L65
    L53:
        r138 = 0;
        goto L54
    L49:
        r135 = 0;
        goto L50
    L45:
        r132 = 0;
        goto L46
    L41:
        r129 = 0;
        goto L42
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

    @Override // com.ss.android.ugc.aweme.kiwi.model.QModel
    public int modelType() {
        return 0;
    }

    public String toString() {
        return "MatchPurchaseParams(productId=" + this.productId + ", promotionId=" + this.promotionId + ", combinationIds=" + this.combinationIds + ", tag=" + this.tag + ", curPageIndex=" + this.curPageIndex + ", enterFrom=" + this.enterFrom + ", sourcePage=" + this.sourcePage + ", kolId=" + this.kolId + ", metaParam=" + this.metaParam + ", requestAdditions=" + this.requestAdditions + ", entranceInfo=" + this.entranceInfo + ", cpsTrack=" + this.cpsTrack + ", marketingChannel=" + this.marketingChannel + ", newSourceType=" + this.newSourceType + ", heightPercent=" + this.heightPercent + ", isPicMatching=" + this.isPicMatching + ", isFullScreen=" + this.isFullScreen + ", sourceBtmToken=" + this.sourceBtmToken + ", combinationPromotionList=" + this.combinationPromotionList + ")";
    }

    public final String getCurPageCombinationId() {
        return (String) CollectionsKt.getOrNull(StringsKt.split$default(this.combinationIds, new String[]{","}, false, 0, 6, null), this.curPageIndex);
    }

    public final String getCombinationIds() {
        return this.combinationIds;
    }

    public final String getCombinationPromotionList() {
        return this.combinationPromotionList;
    }

    public final String getCpsTrack() {
        return this.cpsTrack;
    }

    public final int getCurPageIndex() {
        return this.curPageIndex;
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final String getEntranceInfo() {
        return this.entranceInfo;
    }

    public final Integer getHeightPercent() {
        return this.heightPercent;
    }

    public final String getKolId() {
        return this.kolId;
    }

    public final String getMarketingChannel() {
        return this.marketingChannel;
    }

    public final String getMetaParam() {
        return this.metaParam;
    }

    public final String getNewSourceType() {
        return this.newSourceType;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final String getPromotionId() {
        return this.promotionId;
    }

    public final String getRequestAdditions() {
        return this.requestAdditions;
    }

    public final String getSourceBtmToken() {
        return this.sourceBtmToken;
    }

    public final String getSourcePage() {
        return this.sourcePage;
    }

    public final int getTag() {
        return this.tag;
    }

    public final boolean isFullScreen() {
        return this.isFullScreen;
    }

    public final boolean isPicMatching() {
        return this.isPicMatching;
    }

    public MatchPurchaseParams(String r110, String r111, String r112, int r113, int r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, String r219, Integer r310, boolean r311, boolean r312, String r313, String r314) {
        Intrinsics.checkNotNullParameter(r110, "productId");
        Intrinsics.checkNotNullParameter(r112, "combinationIds");
        Intrinsics.checkNotNullParameter(r211, "enterFrom");
        Intrinsics.checkNotNullParameter(r212, "sourcePage");
        Intrinsics.checkNotNullParameter(r213, "kolId");
        Intrinsics.checkNotNullParameter(r214, "metaParam");
        Intrinsics.checkNotNullParameter(r215, "requestAdditions");
        Intrinsics.checkNotNullParameter(r216, "entranceInfo");
        Intrinsics.checkNotNullParameter(r217, "cpsTrack");
        Intrinsics.checkNotNullParameter(r218, "marketingChannel");
        Intrinsics.checkNotNullParameter(r219, "newSourceType");
        Intrinsics.checkNotNullParameter(r313, "sourceBtmToken");
        Intrinsics.checkNotNullParameter(r314, "combinationPromotionList");
        this.productId = r110;
        this.promotionId = r111;
        this.combinationIds = r112;
        this.tag = r113;
        this.curPageIndex = r210;
        this.enterFrom = r211;
        this.sourcePage = r212;
        this.kolId = r213;
        this.metaParam = r214;
        this.requestAdditions = r215;
        this.entranceInfo = r216;
        this.cpsTrack = r217;
        this.marketingChannel = r218;
        this.newSourceType = r219;
        this.heightPercent = r310;
        this.isPicMatching = r311;
        this.isFullScreen = r312;
        this.sourceBtmToken = r313;
        this.combinationPromotionList = r314;
    }

    public /* synthetic */ MatchPurchaseParams(String r210, String r211, String r212, int r213, int r214, String r215, String r310, String r311, String r312, String r313, String r314, String r315, String r316, String r317, Integer r318, boolean r319, boolean r410, String r411, String r412, int r413, DefaultConstructorMarker r414) {
        if ((r413 & 16) == 0) goto L5;
        int r100 = 0;
    L7:
        if ((r413 & 32) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r413 & 64) == 0) goto L13;
        String r110 = "";
    L15:
        if ((r413 & 128) == 0) goto L17;
        String r111 = "";
    L19:
        if ((r413 & 256) == 0) goto L21;
        String r112 = "";
    L23:
        if ((r413 & 512) == 0) goto L25;
        String r113 = "";
    L27:
        if ((r413 & 1024) == 0) goto L29;
        String r114 = "";
    L31:
        if ((r413 & 2048) == 0) goto L33;
        String r115 = "";
    L35:
        if ((r413 & 4096) == 0) goto L37;
        String r116 = "";
    L39:
        if ((r413 & 8192) == 0) goto L41;
        String r117 = "";
    L43:
        if ((r413 & 16384) == 0) goto L45;
        Integer r118 = 0;
    L47:
        if ((32768 & r413) == 0) goto L49;
        boolean r119 = true;
    L51:
        if ((65536 & r413) == 0) goto L53;
        boolean r216 = true;
    L55:
        if ((131072 & r413) == 0) goto L57;
        String r217 = "";
    L59:
        if ((r413 & 262144) == 0) goto L61;
        String r218 = "";
    L62:
        this(r210, r211, r212, r213, r100, r101, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r216, r217, r218);
        return;
    L61:
        r218 = r412;
        goto L62
    L57:
        r217 = r411;
        goto L59
    L53:
        r216 = r410;
        goto L55
    L49:
        r119 = r319;
        goto L51
    L45:
        r118 = r318;
        goto L47
    L41:
        r117 = r317;
        goto L43
    L37:
        r116 = r316;
        goto L39
    L33:
        r115 = r315;
        goto L35
    L29:
        r114 = r314;
        goto L31
    L25:
        r113 = r313;
        goto L27
    L21:
        r112 = r312;
        goto L23
    L17:
        r111 = r311;
        goto L19
    L13:
        r110 = r310;
        goto L15
    L9:
        r101 = r215;
        goto L11
    L5:
        r100 = r214;
        goto L7
    }
}
