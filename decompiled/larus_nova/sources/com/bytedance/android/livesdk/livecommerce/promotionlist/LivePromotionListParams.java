package com.bytedance.android.livesdk.livecommerce.promotionlist;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010$\n\u0002\b7\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u008d\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\b\u0012\b\b\u0002\u0010\u0014\u001a\u00020\b\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\n\u0012\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u001dJ\t\u00108\u001a\u00020\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010;\u001a\u00020\bHÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010=\u001a\u00020\bHÆ\u0003J\t\u0010>\u001a\u00020\bHÆ\u0003J\t\u0010?\u001a\u00020\bHÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\nHÆ\u0003J\u0017\u0010E\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001aHÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\bHÆ\u0003J\t\u0010K\u001a\u00020\nHÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010M\u001a\u00020\u0003HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0091\u0002\u0010O\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0010\u001a\u00020\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0018\u001a\u00020\n2\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010P\u001a\u00020\b2\b\u0010Q\u001a\u0004\u0018\u00010RHÖ\u0003J\t\u0010S\u001a\u00020\nHÖ\u0001J\t\u0010T\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001fR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001fR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001fR\u0011\u0010\u0012\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\"R\u0011\u0010\u0010\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\"R\u0011\u0010\u0013\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\"R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001fR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001fR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001fR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001fR\u0011\u0010\u0014\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\"R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001fR\u001f\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001fR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001fR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001fR\u0011\u0010\u0018\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b4\u0010(R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001f\"\u0004\b6\u00107¨\u0006U"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotionlist/LivePromotionListParams;", "Ljava/io/Serializable;", "roomId", "", "containerRoomId", "anchorId", "anchorSecId", "autoApplyCoupon", "", "listApplyCoupon", "", "openMethod", "monitorName", "couponId", "liveListChannel", "scrollPromotionId", "isPromotionId", "extraEntranceInfo", "isFromLiveRoom", "isVsVerticalVideo", "recommendProductDisplayed", "tabUniqueIndex", "shoppingCartTaskItemId", "shoppingCartTaskMetaID", "shoppingCartTaskScene", "schemaEventParams", "", "cartAnimRelatedInfo", "preferredCoupon", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/Map;Ljava/lang/String;Ljava/lang/String;)V", "getAnchorId", "()Ljava/lang/String;", "getAnchorSecId", "getAutoApplyCoupon", "()Z", "getCartAnimRelatedInfo", "getContainerRoomId", "getCouponId", "getExtraEntranceInfo", "getListApplyCoupon", "()I", "getLiveListChannel", "getMonitorName", "getOpenMethod", "getPreferredCoupon", "getRecommendProductDisplayed", "getRoomId", "getSchemaEventParams", "()Ljava/util/Map;", "getScrollPromotionId", "getShoppingCartTaskItemId", "getShoppingCartTaskMetaID", "getShoppingCartTaskScene", "getTabUniqueIndex", "setTabUniqueIndex", "(Ljava/lang/String;)V", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "toString", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivePromotionListParams implements Serializable {
    private final String anchorId;
    private final String anchorSecId;
    private final boolean autoApplyCoupon;
    private final String cartAnimRelatedInfo;
    private final String containerRoomId;
    private final String couponId;
    private final String extraEntranceInfo;
    private final boolean isFromLiveRoom;
    private final boolean isPromotionId;
    private final boolean isVsVerticalVideo;
    private final int listApplyCoupon;
    private final String liveListChannel;
    private final String monitorName;
    private final String openMethod;

    @SerializedName("preferred_coupon")
    private final String preferredCoupon;
    private final boolean recommendProductDisplayed;
    private final String roomId;
    private final Map<String, String> schemaEventParams;
    private final String scrollPromotionId;
    private final String shoppingCartTaskItemId;
    private final String shoppingCartTaskMetaID;
    private final int shoppingCartTaskScene;
    private String tabUniqueIndex;

    public LivePromotionListParams() {
        this(null, null, null, null, false, 0, null, null, null, null, null, false, null, false, false, false, null, null, null, 0, null, null, null, 8388607, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LivePromotionListParams copy$default(LivePromotionListParams r110, String r111, String r112, String r210, String r211, boolean r212, int r213, String r214, String r215, String r216, String r217, String r218, boolean r219, String r310, boolean r311, boolean r312, boolean r313, String r314, String r315, String r316, int r317, Map r318, String r319, String r410, int r411, Object r412) {
        if ((r411 & 1) == 0) goto L5;
        String r100 = r110.roomId;
    L7:
        if ((r411 & 2) == 0) goto L9;
        String r101 = r110.containerRoomId;
    L11:
        if ((r411 & 4) == 0) goto L13;
        String r102 = r110.anchorId;
    L15:
        if ((r411 & 8) == 0) goto L17;
        String r103 = r110.anchorSecId;
    L19:
        if ((r411 & 16) == 0) goto L21;
        boolean r104 = r110.autoApplyCoupon;
    L23:
        if ((r411 & 32) == 0) goto L25;
        int r105 = r110.listApplyCoupon;
    L27:
        if ((r411 & 64) == 0) goto L29;
        String r106 = r110.openMethod;
    L31:
        if ((r411 & 128) == 0) goto L33;
        String r107 = r110.monitorName;
    L35:
        if ((r411 & 256) == 0) goto L37;
        String r113 = r110.couponId;
    L39:
        if ((r411 & 512) == 0) goto L41;
        String r114 = r110.liveListChannel;
    L43:
        if ((r411 & 1024) == 0) goto L45;
        String r115 = r110.scrollPromotionId;
    L47:
        if ((r411 & 2048) == 0) goto L49;
        boolean r116 = r110.isPromotionId;
    L51:
        if ((r411 & 4096) == 0) goto L53;
        String r117 = r110.extraEntranceInfo;
    L55:
        if ((r411 & 8192) == 0) goto L57;
        boolean r118 = r110.isFromLiveRoom;
    L58:
        boolean r320 = r118;
        if ((r411 & 16384) == 0) goto L61;
        boolean r119 = r110.isVsVerticalVideo;
    L62:
        boolean r321 = r119;
        if ((r411 & 32768) == 0) goto L65;
        boolean r120 = r110.recommendProductDisplayed;
    L66:
        boolean r322 = r120;
        if ((r411 & 65536) == 0) goto L69;
        String r121 = r110.tabUniqueIndex;
    L70:
        String r323 = r121;
        if ((r411 & 131072) == 0) goto L73;
        String r122 = r110.shoppingCartTaskItemId;
    L74:
        String r324 = r122;
        if ((r411 & 262144) == 0) goto L77;
        String r123 = r110.shoppingCartTaskMetaID;
    L78:
        String r325 = r123;
        if ((r411 & 524288) == 0) goto L81;
        int r124 = r110.shoppingCartTaskScene;
    L82:
        int r326 = r124;
        if ((r411 & 1048576) == 0) goto L85;
        Map r125 = r110.schemaEventParams;
    L86:
        Map r327 = r125;
        if ((r411 & 2097152) == 0) goto L89;
        String r126 = r110.cartAnimRelatedInfo;
    L91:
        if ((r411 & 4194304) == 0) goto L93;
        String r108 = r110.preferredCoupon;
    L95:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r320, r321, r322, r323, r324, r325, r326, r327, r126, r108);
    L93:
        r108 = r410;
        goto L95
    L89:
        r126 = r319;
        goto L91
    L85:
        r125 = r318;
        goto L86
    L81:
        r124 = r317;
        goto L82
    L77:
        r123 = r316;
        goto L78
    L73:
        r122 = r315;
        goto L74
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
        return this.roomId;
    }

    public final String component10() {
        return this.liveListChannel;
    }

    public final String component11() {
        return this.scrollPromotionId;
    }

    public final boolean component12() {
        return this.isPromotionId;
    }

    public final String component13() {
        return this.extraEntranceInfo;
    }

    public final boolean component14() {
        return this.isFromLiveRoom;
    }

    public final boolean component15() {
        return this.isVsVerticalVideo;
    }

    public final boolean component16() {
        return this.recommendProductDisplayed;
    }

    public final String component17() {
        return this.tabUniqueIndex;
    }

    public final String component18() {
        return this.shoppingCartTaskItemId;
    }

    public final String component19() {
        return this.shoppingCartTaskMetaID;
    }

    public final String component2() {
        return this.containerRoomId;
    }

    public final int component20() {
        return this.shoppingCartTaskScene;
    }

    public final Map<String, String> component21() {
        return this.schemaEventParams;
    }

    public final String component22() {
        return this.cartAnimRelatedInfo;
    }

    public final String component23() {
        return this.preferredCoupon;
    }

    public final String component3() {
        return this.anchorId;
    }

    public final String component4() {
        return this.anchorSecId;
    }

    public final boolean component5() {
        return this.autoApplyCoupon;
    }

    public final int component6() {
        return this.listApplyCoupon;
    }

    public final String component7() {
        return this.openMethod;
    }

    public final String component8() {
        return this.monitorName;
    }

    public final String component9() {
        return this.couponId;
    }

    public final LivePromotionListParams copy(String r210, String r211, String r212, String r310, boolean r311, int r312, String r313, String r314, String r315, String r316, String r317, boolean r318, String r319, boolean r410, boolean r411, boolean r412, String r413, String r414, String r415, int r416, Map<String, String> r417, String r418, String r419) {
        Intrinsics.checkNotNullParameter(r210, "roomId");
        Intrinsics.checkNotNullParameter(r211, "containerRoomId");
        Intrinsics.checkNotNullParameter(r212, "anchorId");
        Intrinsics.checkNotNullParameter(r310, "anchorSecId");
        Intrinsics.checkNotNullParameter(r314, "monitorName");
        return new LivePromotionListParams(r210, r211, r212, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LivePromotionListParams) == false) goto L52;
        LivePromotionListParams r101 = (LivePromotionListParams) r100;
        if (Intrinsics.areEqual(this.roomId, r101.roomId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.containerRoomId, r101.containerRoomId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.anchorId, r101.anchorId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.anchorSecId, r101.anchorSecId) == true) goto L14;
        return false;
    L14:
        if (this.autoApplyCoupon == r101.autoApplyCoupon) goto L16;
        return false;
    L16:
        if (this.listApplyCoupon == r101.listApplyCoupon) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.openMethod, r101.openMethod) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.monitorName, r101.monitorName) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.couponId, r101.couponId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.liveListChannel, r101.liveListChannel) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.scrollPromotionId, r101.scrollPromotionId) == true) goto L28;
        return false;
    L28:
        if (this.isPromotionId == r101.isPromotionId) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.extraEntranceInfo, r101.extraEntranceInfo) == true) goto L32;
        return false;
    L32:
        if (this.isFromLiveRoom == r101.isFromLiveRoom) goto L34;
        return false;
    L34:
        if (this.isVsVerticalVideo == r101.isVsVerticalVideo) goto L36;
        return false;
    L36:
        if (this.recommendProductDisplayed == r101.recommendProductDisplayed) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.tabUniqueIndex, r101.tabUniqueIndex) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.shoppingCartTaskItemId, r101.shoppingCartTaskItemId) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.shoppingCartTaskMetaID, r101.shoppingCartTaskMetaID) == true) goto L44;
        return false;
    L44:
        if (this.shoppingCartTaskScene == r101.shoppingCartTaskScene) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.schemaEventParams, r101.schemaEventParams) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.cartAnimRelatedInfo, r101.cartAnimRelatedInfo) == true) goto L50;
        return false;
    L50:
        if (Intrinsics.areEqual(this.preferredCoupon, r101.preferredCoupon) == true) goto L79;
        return false;
    L79:
        return true;
    L52:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v28, types: [int] */
    /* JADX WARN: Type inference failed for: r2v33, types: [int] */
    /* JADX WARN: Type inference failed for: r2v35, types: [int] */
    /* JADX WARN: Type inference failed for: r2v59 */
    /* JADX WARN: Type inference failed for: r2v60 */
    /* JADX WARN: Type inference failed for: r2v62 */
    /* JADX WARN: Type inference failed for: r2v68 */
    /* JADX WARN: Type inference failed for: r2v72 */
    /* JADX WARN: Type inference failed for: r2v73 */
    /* JADX WARN: Type inference failed for: r2v74 */
    /* JADX WARN: Type inference failed for: r2v75 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        String r100 = this.roomId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.containerRoomId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.anchorId;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.anchorSecId;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        boolean r113 = this.autoApplyCoupon;
        ?? r114 = 1;
        ?? r115 = r113;
        if (r113 == false) goto L21;
        r115 = 1;
    L21:
        int r116 = (((r112 + r115) * 31) + this.listApplyCoupon) * 31;
        String r117 = this.openMethod;
        if (r117 == null) goto L24;
        int r118 = r117.hashCode();
    L25:
        int r119 = (r116 + r118) * 31;
        String r120 = this.monitorName;
        if (r120 == null) goto L28;
        int r121 = r120.hashCode();
    L29:
        int r122 = (r119 + r121) * 31;
        String r123 = this.couponId;
        if (r123 == null) goto L32;
        int r124 = r123.hashCode();
    L33:
        int r125 = (r122 + r124) * 31;
        String r126 = this.liveListChannel;
        if (r126 == null) goto L36;
        int r127 = r126.hashCode();
    L37:
        int r128 = (r125 + r127) * 31;
        String r129 = this.scrollPromotionId;
        if (r129 == null) goto L40;
        int r130 = r129.hashCode();
    L41:
        int r131 = (r128 + r130) * 31;
        boolean r132 = this.isPromotionId;
        ?? r133 = r132;
        if (r132 == false) goto L44;
        r133 = 1;
    L44:
        int r134 = (r131 + r133) * 31;
        String r135 = this.extraEntranceInfo;
        if (r135 == null) goto L47;
        int r136 = r135.hashCode();
    L48:
        int r137 = (r134 + r136) * 31;
        boolean r138 = this.isFromLiveRoom;
        ?? r139 = r138;
        if (r138 == false) goto L51;
        r139 = 1;
    L51:
        int r140 = (r137 + r139) * 31;
        boolean r141 = this.isVsVerticalVideo;
        ?? r142 = r141;
        if (r141 == false) goto L54;
        r142 = 1;
    L54:
        int r143 = (r140 + r142) * 31;
        boolean r144 = this.recommendProductDisplayed;
        if (r144 == true) goto L58;
        r114 = r144;
    L58:
        int r145 = (r143 + r114) * 31;
        String r146 = this.tabUniqueIndex;
        if (r146 == null) goto L61;
        int r147 = r146.hashCode();
    L62:
        int r148 = (r145 + r147) * 31;
        String r149 = this.shoppingCartTaskItemId;
        if (r149 == null) goto L65;
        int r150 = r149.hashCode();
    L66:
        int r151 = (r148 + r150) * 31;
        String r152 = this.shoppingCartTaskMetaID;
        if (r152 == null) goto L69;
        int r153 = r152.hashCode();
    L70:
        int r154 = (((r151 + r153) * 31) + this.shoppingCartTaskScene) * 31;
        Map<String, String> r155 = this.schemaEventParams;
        if (r155 == null) goto L73;
        int r156 = r155.hashCode();
    L74:
        int r157 = (r154 + r156) * 31;
        String r158 = this.cartAnimRelatedInfo;
        if (r158 == null) goto L77;
        int r159 = r158.hashCode();
    L78:
        int r160 = (r157 + r159) * 31;
        String r161 = this.preferredCoupon;
        if (r161 == null) goto L82;
        r101 = r161.hashCode();
    L82:
        return r160 + r101;
    L77:
        r159 = 0;
        goto L78
    L73:
        r156 = 0;
        goto L74
    L69:
        r153 = 0;
        goto L70
    L65:
        r150 = 0;
        goto L66
    L61:
        r147 = 0;
        goto L62
    L47:
        r136 = 0;
        goto L48
    L40:
        r130 = 0;
        goto L41
    L36:
        r127 = 0;
        goto L37
    L32:
        r124 = 0;
        goto L33
    L28:
        r121 = 0;
        goto L29
    L24:
        r118 = 0;
        goto L25
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

    public String toString() {
        return "LivePromotionListParams(roomId=" + this.roomId + ", containerRoomId=" + this.containerRoomId + ", anchorId=" + this.anchorId + ", anchorSecId=" + this.anchorSecId + ", autoApplyCoupon=" + this.autoApplyCoupon + ", listApplyCoupon=" + this.listApplyCoupon + ", openMethod=" + this.openMethod + ", monitorName=" + this.monitorName + ", couponId=" + this.couponId + ", liveListChannel=" + this.liveListChannel + ", scrollPromotionId=" + this.scrollPromotionId + ", isPromotionId=" + this.isPromotionId + ", extraEntranceInfo=" + this.extraEntranceInfo + ", isFromLiveRoom=" + this.isFromLiveRoom + ", isVsVerticalVideo=" + this.isVsVerticalVideo + ", recommendProductDisplayed=" + this.recommendProductDisplayed + ", tabUniqueIndex=" + this.tabUniqueIndex + ", shoppingCartTaskItemId=" + this.shoppingCartTaskItemId + ", shoppingCartTaskMetaID=" + this.shoppingCartTaskMetaID + ", shoppingCartTaskScene=" + this.shoppingCartTaskScene + ", schemaEventParams=" + this.schemaEventParams + ", cartAnimRelatedInfo=" + this.cartAnimRelatedInfo + ", preferredCoupon=" + this.preferredCoupon + ")";
    }

    public final String getAnchorId() {
        return this.anchorId;
    }

    public final String getAnchorSecId() {
        return this.anchorSecId;
    }

    public final boolean getAutoApplyCoupon() {
        return this.autoApplyCoupon;
    }

    public final String getCartAnimRelatedInfo() {
        return this.cartAnimRelatedInfo;
    }

    public final String getContainerRoomId() {
        return this.containerRoomId;
    }

    public final String getCouponId() {
        return this.couponId;
    }

    public final String getExtraEntranceInfo() {
        return this.extraEntranceInfo;
    }

    public final int getListApplyCoupon() {
        return this.listApplyCoupon;
    }

    public final String getLiveListChannel() {
        return this.liveListChannel;
    }

    public final String getMonitorName() {
        return this.monitorName;
    }

    public final String getOpenMethod() {
        return this.openMethod;
    }

    public final String getPreferredCoupon() {
        return this.preferredCoupon;
    }

    public final boolean getRecommendProductDisplayed() {
        return this.recommendProductDisplayed;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final Map<String, String> getSchemaEventParams() {
        return this.schemaEventParams;
    }

    public final String getScrollPromotionId() {
        return this.scrollPromotionId;
    }

    public final String getShoppingCartTaskItemId() {
        return this.shoppingCartTaskItemId;
    }

    public final String getShoppingCartTaskMetaID() {
        return this.shoppingCartTaskMetaID;
    }

    public final int getShoppingCartTaskScene() {
        return this.shoppingCartTaskScene;
    }

    public final String getTabUniqueIndex() {
        return this.tabUniqueIndex;
    }

    public final boolean isFromLiveRoom() {
        return this.isFromLiveRoom;
    }

    public final boolean isPromotionId() {
        return this.isPromotionId;
    }

    public final boolean isVsVerticalVideo() {
        return this.isVsVerticalVideo;
    }

    public final void setTabUniqueIndex(String r100) {
        this.tabUniqueIndex = r100;
    }

    public LivePromotionListParams(String r100, String r101, String r110, String r111, boolean r112, int r113, String r114, String r115, String r116, String r117, String r118, boolean r119, String r210, boolean r211, boolean r212, boolean r213, String r214, String r215, String r216, int r217, Map<String, String> r218, String r219, String r310) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        Intrinsics.checkNotNullParameter(r101, "containerRoomId");
        Intrinsics.checkNotNullParameter(r110, "anchorId");
        Intrinsics.checkNotNullParameter(r111, "anchorSecId");
        Intrinsics.checkNotNullParameter(r115, "monitorName");
        this.roomId = r100;
        this.containerRoomId = r101;
        this.anchorId = r110;
        this.anchorSecId = r111;
        this.autoApplyCoupon = r112;
        this.listApplyCoupon = r113;
        this.openMethod = r114;
        this.monitorName = r115;
        this.couponId = r116;
        this.liveListChannel = r117;
        this.scrollPromotionId = r118;
        this.isPromotionId = r119;
        this.extraEntranceInfo = r210;
        this.isFromLiveRoom = r211;
        this.isVsVerticalVideo = r212;
        this.recommendProductDisplayed = r213;
        this.tabUniqueIndex = r214;
        this.shoppingCartTaskItemId = r215;
        this.shoppingCartTaskMetaID = r216;
        this.shoppingCartTaskScene = r217;
        this.schemaEventParams = r218;
        this.cartAnimRelatedInfo = r219;
        this.preferredCoupon = r310;
    }

    public /* synthetic */ LivePromotionListParams(String r210, String r211, String r212, String r213, boolean r214, int r310, String r311, String r312, String r313, String r314, String r315, boolean r316, String r317, boolean r318, boolean r319, boolean r410, String r411, String r412, String r413, int r414, Map r415, String r416, String r417, int r418, DefaultConstructorMarker r419) {
        String r100 = "";
        if ((r418 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r418 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r418 & 4) == 0) goto L13;
        String r103 = "";
    L15:
        if ((r418 & 8) == 0) goto L17;
        String r104 = "";
    L19:
        if ((r418 & 16) == 0) goto L21;
        boolean r105 = false;
    L23:
        if ((r418 & 32) == 0) goto L25;
        int r106 = -1;
    L27:
        if ((r418 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r418 & 128) != 0) goto L35;
        r100 = r312;
    L35:
        if ((r418 & 256) == 0) goto L37;
        String r110 = null;
    L39:
        if ((r418 & 512) == 0) goto L41;
        String r111 = null;
    L43:
        if ((r418 & 1024) == 0) goto L45;
        String r112 = null;
    L47:
        if ((r418 & 2048) == 0) goto L49;
        boolean r113 = false;
    L51:
        if ((r418 & 4096) == 0) goto L53;
        String r114 = null;
    L55:
        if ((r418 & 8192) == 0) goto L57;
        boolean r108 = true;
    L59:
        if ((r418 & 16384) == 0) goto L61;
        boolean r115 = false;
    L63:
        if ((r418 & 32768) == 0) goto L65;
        boolean r116 = false;
    L67:
        if ((r418 & 65536) == 0) goto L69;
        String r117 = null;
    L71:
        if ((r418 & 131072) == 0) goto L73;
        String r118 = null;
    L75:
        if ((r418 & 262144) == 0) goto L77;
        String r119 = null;
    L79:
        if ((r418 & 524288) == 0) goto L81;
        int r215 = 0;
    L83:
        if ((r418 & 1048576) == 0) goto L85;
        Map r216 = null;
    L87:
        if ((r418 & 2097152) == 0) goto L89;
        String r217 = null;
    L91:
        if ((r418 & 4194304) == 0) goto L93;
        String r109 = null;
    L94:
        this(r101, r102, r103, r104, r105, r106, r107, r100, r110, r111, r112, r113, r114, r108, r115, r116, r117, r118, r119, r215, r216, r217, r109);
        return;
    L93:
        r109 = r417;
        goto L94
    L89:
        r217 = r416;
        goto L91
    L85:
        r216 = r415;
        goto L87
    L81:
        r215 = r414;
        goto L83
    L77:
        r119 = r413;
        goto L79
    L73:
        r118 = r412;
        goto L75
    L69:
        r117 = r411;
        goto L71
    L65:
        r116 = r410;
        goto L67
    L61:
        r115 = r319;
        goto L63
    L57:
        r108 = r318;
        goto L59
    L53:
        r114 = r317;
        goto L55
    L49:
        r113 = r316;
        goto L51
    L45:
        r112 = r315;
        goto L47
    L41:
        r111 = r314;
        goto L43
    L37:
        r110 = r313;
        goto L39
    L29:
        r107 = r311;
        goto L31
    L25:
        r106 = r310;
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
        r101 = r210;
        goto L7
    }
}
