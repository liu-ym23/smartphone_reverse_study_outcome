package com.bytedance.android.ec.model;

import com.bytedance.android.ec.model.response.anchorv3.PromotionDiscountLabel;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0087\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0013\u0012\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017\u0012\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0017¢\u0006\u0002\u0010\u001bJ\u0006\u00103\u001a\u000204J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00107\u001a\u00020\u000eHÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010;\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0013HÆ\u0003J\u0017\u0010<\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0013HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\u0011\u0010>\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017HÆ\u0003J\u000f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0017HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u008b\u0002\u0010H\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00132\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00032\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00172\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0017HÆ\u0001J\u0013\u0010I\u001a\u00020\u000e2\b\u0010J\u001a\u0004\u0018\u00010KHÖ\u0003J\t\u0010L\u001a\u00020MHÖ\u0001J\t\u0010N\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001dR\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001dR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001dR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001dR\u001f\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001dR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001dR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001dR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001dR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001dR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001dR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001dR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001dR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001dR\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0017¢\u0006\b\n\u0000\u001a\u0004\b1\u0010!R\u001f\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b2\u0010'¨\u0006O"}, d2 = {"Lcom/bytedance/android/ec/model/ClickButtonParam;", "Ljava/io/Serializable;", "productId", "", "promotionId", "promotionSource", "authorId", "secAuthorId", "groupId", "shopId", "itemId", "metaParams", "roomId", "back2AnchorV3Page", "", "schema", "enterFrom", "marketingChannel", "logExtra", "", "trackAdditions", "entranceInfo", "discountLabels", "", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionDiscountLabel;", "singleClickParams", "Lcom/bytedance/android/ec/model/SingleClickParam;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getAuthorId", "()Ljava/lang/String;", "getBack2AnchorV3Page", "()Z", "getDiscountLabels", "()Ljava/util/List;", "getEnterFrom", "getEntranceInfo", "getGroupId", "getItemId", "getLogExtra", "()Ljava/util/Map;", "getMarketingChannel", "getMetaParams", "getProductId", "getPromotionId", "getPromotionSource", "getRoomId", "getSchema", "getSecAuthorId", "getShopId", "getSingleClickParams", "getTrackAdditions", "asJSONDescription", "Lorg/json/JSONObject;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ClickButtonParam implements Serializable {
    private final String authorId;
    private final boolean back2AnchorV3Page;
    private final List<PromotionDiscountLabel> discountLabels;
    private final String enterFrom;
    private final String entranceInfo;
    private final String groupId;
    private final String itemId;
    private final Map<String, String> logExtra;
    private final String marketingChannel;
    private final String metaParams;
    private final String productId;
    private final String promotionId;
    private final String promotionSource;
    private final String roomId;
    private final String schema;
    private final String secAuthorId;
    private final String shopId;
    private final List<SingleClickParam> singleClickParams;
    private final Map<String, String> trackAdditions;

    public ClickButtonParam() {
        this(null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, 524287, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ClickButtonParam copy$default(ClickButtonParam r110, String r111, String r112, String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, boolean r218, String r219, String r310, String r311, Map r312, Map r313, String r314, List r315, List r316, int r317, Object r318) {
        if ((r317 & 1) == 0) goto L5;
        String r100 = r110.productId;
    L7:
        if ((r317 & 2) == 0) goto L9;
        String r101 = r110.promotionId;
    L11:
        if ((r317 & 4) == 0) goto L13;
        String r102 = r110.promotionSource;
    L15:
        if ((r317 & 8) == 0) goto L17;
        String r103 = r110.authorId;
    L19:
        if ((r317 & 16) == 0) goto L21;
        String r104 = r110.secAuthorId;
    L23:
        if ((r317 & 32) == 0) goto L25;
        String r105 = r110.groupId;
    L27:
        if ((r317 & 64) == 0) goto L29;
        String r106 = r110.shopId;
    L31:
        if ((r317 & 128) == 0) goto L33;
        String r107 = r110.itemId;
    L35:
        if ((r317 & 256) == 0) goto L37;
        String r113 = r110.metaParams;
    L39:
        if ((r317 & 512) == 0) goto L41;
        String r114 = r110.roomId;
    L43:
        if ((r317 & 1024) == 0) goto L45;
        boolean r115 = r110.back2AnchorV3Page;
    L47:
        if ((r317 & 2048) == 0) goto L49;
        String r116 = r110.schema;
    L51:
        if ((r317 & 4096) == 0) goto L53;
        String r117 = r110.enterFrom;
    L55:
        if ((r317 & 8192) == 0) goto L57;
        String r118 = r110.marketingChannel;
    L58:
        String r319 = r118;
        if ((r317 & 16384) == 0) goto L61;
        Map r119 = r110.logExtra;
    L62:
        Map r320 = r119;
        if ((r317 & 32768) == 0) goto L65;
        Map r120 = r110.trackAdditions;
    L66:
        Map r321 = r120;
        if ((r317 & 65536) == 0) goto L69;
        String r121 = r110.entranceInfo;
    L70:
        String r322 = r121;
        if ((r317 & 131072) == 0) goto L73;
        List r122 = r110.discountLabels;
    L75:
        if ((r317 & 262144) == 0) goto L77;
        List r108 = r110.singleClickParams;
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
        return this.roomId;
    }

    public final boolean component11() {
        return this.back2AnchorV3Page;
    }

    public final String component12() {
        return this.schema;
    }

    public final String component13() {
        return this.enterFrom;
    }

    public final String component14() {
        return this.marketingChannel;
    }

    public final Map<String, String> component15() {
        return this.logExtra;
    }

    public final Map<String, String> component16() {
        return this.trackAdditions;
    }

    public final String component17() {
        return this.entranceInfo;
    }

    public final List<PromotionDiscountLabel> component18() {
        return this.discountLabels;
    }

    public final List<SingleClickParam> component19() {
        return this.singleClickParams;
    }

    public final String component2() {
        return this.promotionId;
    }

    public final String component3() {
        return this.promotionSource;
    }

    public final String component4() {
        return this.authorId;
    }

    public final String component5() {
        return this.secAuthorId;
    }

    public final String component6() {
        return this.groupId;
    }

    public final String component7() {
        return this.shopId;
    }

    public final String component8() {
        return this.itemId;
    }

    public final String component9() {
        return this.metaParams;
    }

    public final ClickButtonParam copy(String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r310, String r311, boolean r312, String r313, String r314, String r315, Map<String, String> r316, Map<String, String> r317, String r318, List<PromotionDiscountLabel> r319, List<SingleClickParam> r410) {
        Intrinsics.checkNotNullParameter(r318, "entranceInfo");
        Intrinsics.checkNotNullParameter(r410, "singleClickParams");
        return new ClickButtonParam(r210, r211, r212, r213, r214, r215, r216, r217, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ClickButtonParam) == false) goto L44;
        ClickButtonParam r101 = (ClickButtonParam) r100;
        if (Intrinsics.areEqual(this.productId, r101.productId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.promotionId, r101.promotionId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.promotionSource, r101.promotionSource) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.authorId, r101.authorId) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.secAuthorId, r101.secAuthorId) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.groupId, r101.groupId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.shopId, r101.shopId) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.itemId, r101.itemId) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.metaParams, r101.metaParams) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.roomId, r101.roomId) == true) goto L26;
        return false;
    L26:
        if (this.back2AnchorV3Page == r101.back2AnchorV3Page) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.schema, r101.schema) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.enterFrom, r101.enterFrom) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.marketingChannel, r101.marketingChannel) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.logExtra, r101.logExtra) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.trackAdditions, r101.trackAdditions) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.entranceInfo, r101.entranceInfo) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.discountLabels, r101.discountLabels) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.singleClickParams, r101.singleClickParams) == true) goto L67;
        return false;
    L67:
        return true;
    L44:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v22, types: [int] */
    /* JADX WARN: Type inference failed for: r2v28, types: [int] */
    /* JADX WARN: Type inference failed for: r2v58 */
    /* JADX WARN: Type inference failed for: r2v68 */
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
        String r107 = this.promotionSource;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.authorId;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.secAuthorId;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.groupId;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.shopId;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.itemId;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.metaParams;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.roomId;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        boolean r131 = this.back2AnchorV3Page;
        ?? r132 = r131;
        if (r131 == false) goto L45;
        r132 = 1;
    L45:
        int r133 = (r130 + r132) * 31;
        String r134 = this.schema;
        if (r134 == null) goto L48;
        int r135 = r134.hashCode();
    L49:
        int r136 = (r133 + r135) * 31;
        String r137 = this.enterFrom;
        if (r137 == null) goto L52;
        int r138 = r137.hashCode();
    L53:
        int r139 = (r136 + r138) * 31;
        String r140 = this.marketingChannel;
        if (r140 == null) goto L56;
        int r141 = r140.hashCode();
    L57:
        int r142 = (r139 + r141) * 31;
        Map<String, String> r143 = this.logExtra;
        if (r143 == null) goto L60;
        int r144 = r143.hashCode();
    L61:
        int r145 = (r142 + r144) * 31;
        Map<String, String> r146 = this.trackAdditions;
        if (r146 == null) goto L64;
        int r147 = r146.hashCode();
    L65:
        int r148 = (r145 + r147) * 31;
        String r149 = this.entranceInfo;
        if (r149 == null) goto L68;
        int r150 = r149.hashCode();
    L69:
        int r151 = (r148 + r150) * 31;
        List<PromotionDiscountLabel> r152 = this.discountLabels;
        if (r152 == null) goto L72;
        int r153 = r152.hashCode();
    L73:
        int r154 = (r151 + r153) * 31;
        List<SingleClickParam> r155 = this.singleClickParams;
        if (r155 == null) goto L77;
        r101 = r155.hashCode();
    L77:
        return r154 + r101;
    L72:
        r153 = 0;
        goto L73
    L68:
        r150 = 0;
        goto L69
    L64:
        r147 = 0;
        goto L65
    L60:
        r144 = 0;
        goto L61
    L56:
        r141 = 0;
        goto L57
    L52:
        r138 = 0;
        goto L53
    L48:
        r135 = 0;
        goto L49
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

    public String toString() {
        return "ClickButtonParam(productId=" + this.productId + ", promotionId=" + this.promotionId + ", promotionSource=" + this.promotionSource + ", authorId=" + this.authorId + ", secAuthorId=" + this.secAuthorId + ", groupId=" + this.groupId + ", shopId=" + this.shopId + ", itemId=" + this.itemId + ", metaParams=" + this.metaParams + ", roomId=" + this.roomId + ", back2AnchorV3Page=" + this.back2AnchorV3Page + ", schema=" + this.schema + ", enterFrom=" + this.enterFrom + ", marketingChannel=" + this.marketingChannel + ", logExtra=" + this.logExtra + ", trackAdditions=" + this.trackAdditions + ", entranceInfo=" + this.entranceInfo + ", discountLabels=" + this.discountLabels + ", singleClickParams=" + this.singleClickParams + ")";
    }

    public final JSONObject asJSONDescription() {
        JSONObject r100 = new JSONObject();
        r100.put("product_id", this.productId);
        r100.put("promotion_id", this.promotionId);
        r100.put(PdpOpenThirdParam.KEY_PROMOTION_SOURCE, this.promotionSource);
        r100.put("author_id", this.authorId);
        r100.put("sec_author_id", this.secAuthorId);
        r100.put("group_id", this.groupId);
        r100.put(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID, this.shopId);
        r100.put("item_id", this.itemId);
        r100.put("meta_params", this.metaParams);
        r100.put("room_id", this.roomId);
        r100.put("back2_anchor_v3_page", this.back2AnchorV3Page);
        r100.put("schema", this.schema);
        r100.put("enter_from", this.enterFrom);
        r100.put(com.bytedance.android.ec.core.event.a.KEY_MARKET_CHANNEL, this.marketingChannel);
        Map<String, String> r101 = this.logExtra;
        String r102 = null;
        if (r101 == null) goto L9;
        ArrayList r103 = new ArrayList(r101.size());
        Iterator<Map.Entry<String, String>> r104 = r101.entrySet().iterator();
    L6:
        if (r104.hasNext() == false) goto L8;
        Map.Entry<String, String> r105 = r104.next();
        r103.add(r105.getKey() + r105.getValue());
        goto L6
    L8:
        String r106 = CollectionsKt.joinToString$default(r103, ",", null, null, 0, null, null, 62, null);
    L10:
        r100.put("log_extra", r106);
        Map<String, String> r107 = this.trackAdditions;
        if (r107 == null) goto L17;
        ArrayList r108 = new ArrayList(r107.size());
        Iterator<Map.Entry<String, String>> r109 = r107.entrySet().iterator();
    L14:
        if (r109.hasNext() == false) goto L16;
        Map.Entry<String, String> r110 = r109.next();
        r108.add(r110.getKey() + r110.getValue());
        goto L14
    L16:
        r102 = CollectionsKt.joinToString$default(r108, ",", null, null, 0, null, null, 62, null);
    L17:
        r100.put("track_additions", r102);
        r100.put(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, this.entranceInfo);
        return r100;
    L9:
        r106 = null;
        goto L10
    }

    public final String getAuthorId() {
        return this.authorId;
    }

    public final boolean getBack2AnchorV3Page() {
        return this.back2AnchorV3Page;
    }

    public final List<PromotionDiscountLabel> getDiscountLabels() {
        return this.discountLabels;
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final String getEntranceInfo() {
        return this.entranceInfo;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final String getItemId() {
        return this.itemId;
    }

    public final Map<String, String> getLogExtra() {
        return this.logExtra;
    }

    public final String getMarketingChannel() {
        return this.marketingChannel;
    }

    public final String getMetaParams() {
        return this.metaParams;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final String getPromotionId() {
        return this.promotionId;
    }

    public final String getPromotionSource() {
        return this.promotionSource;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final String getSecAuthorId() {
        return this.secAuthorId;
    }

    public final String getShopId() {
        return this.shopId;
    }

    public final List<SingleClickParam> getSingleClickParams() {
        return this.singleClickParams;
    }

    public final Map<String, String> getTrackAdditions() {
        return this.trackAdditions;
    }

    public ClickButtonParam(String r100, String r101, String r102, String r103, String r104, String r110, String r111, String r112, String r113, String r114, boolean r115, String r116, String r117, String r118, Map<String, String> r119, Map<String, String> r210, String r211, List<PromotionDiscountLabel> r212, List<SingleClickParam> r213) {
        Intrinsics.checkNotNullParameter(r211, "entranceInfo");
        Intrinsics.checkNotNullParameter(r213, "singleClickParams");
        this.productId = r100;
        this.promotionId = r101;
        this.promotionSource = r102;
        this.authorId = r103;
        this.secAuthorId = r104;
        this.groupId = r110;
        this.shopId = r111;
        this.itemId = r112;
        this.metaParams = r113;
        this.roomId = r114;
        this.back2AnchorV3Page = r115;
        this.schema = r116;
        this.enterFrom = r117;
        this.marketingChannel = r118;
        this.logExtra = r119;
        this.trackAdditions = r210;
        this.entranceInfo = r211;
        this.discountLabels = r212;
        this.singleClickParams = r213;
    }

    public /* synthetic */ ClickButtonParam(String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, String r310, boolean r311, String r312, String r313, String r314, Map r315, Map r316, String r317, List r318, List r319, int r410, DefaultConstructorMarker r411) {
        if ((r410 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r410 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r410 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r410 & 8) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r410 & 16) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r410 & 32) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r410 & 64) == 0) goto L29;
        String r106 = null;
    L31:
        if ((r410 & 128) == 0) goto L33;
        String r107 = null;
    L35:
        if ((r410 & 256) == 0) goto L37;
        String r110 = null;
    L39:
        if ((r410 & 512) == 0) goto L41;
        String r111 = null;
    L43:
        if ((r410 & 1024) == 0) goto L45;
        boolean r112 = false;
    L47:
        if ((r410 & 2048) == 0) goto L49;
        String r113 = null;
    L51:
        if ((r410 & 4096) == 0) goto L53;
        String r114 = null;
    L55:
        if ((r410 & 8192) == 0) goto L57;
        String r115 = null;
    L59:
        if ((r410 & 16384) == 0) goto L61;
        Map r108 = null;
    L63:
        if ((r410 & 32768) == 0) goto L65;
        Map r116 = null;
    L67:
        if ((r410 & 65536) == 0) goto L69;
        String r117 = "";
    L71:
        if ((r410 & 131072) == 0) goto L73;
        List r118 = null;
    L75:
        if ((r410 & 262144) == 0) goto L77;
        List r109 = CollectionsKt.emptyList();
    L78:
        this(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r115, r108, r116, r117, r118, r109);
        return;
    L77:
        r109 = r319;
        goto L78
    L73:
        r118 = r318;
        goto L75
    L69:
        r117 = r317;
        goto L71
    L65:
        r116 = r316;
        goto L67
    L61:
        r108 = r315;
        goto L63
    L57:
        r115 = r314;
        goto L59
    L53:
        r114 = r313;
        goto L55
    L49:
        r113 = r312;
        goto L51
    L45:
        r112 = r311;
        goto L47
    L41:
        r111 = r310;
        goto L43
    L37:
        r110 = r218;
        goto L39
    L33:
        r107 = r217;
        goto L35
    L29:
        r106 = r216;
        goto L31
    L25:
        r105 = r215;
        goto L27
    L21:
        r104 = r214;
        goto L23
    L17:
        r103 = r213;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
