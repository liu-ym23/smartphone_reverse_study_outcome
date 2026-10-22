package com.bytedance.android.shopping.api.anchorv3;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b3\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bé\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\t\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001b\u001a\u00020\t¢\u0006\u0002\u0010\u001cJ\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\tHÆ\u0003J\t\u0010;\u001a\u00020\tHÆ\u0003J\u0011\u0010<\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0015HÆ\u0003J\u0010\u0010=\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010$J\u0010\u0010>\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010$J\u0010\u0010?\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010$J\u000b\u0010@\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\tHÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\u0010\u0010D\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010$J\t\u0010E\u001a\u00020\tHÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010G\u001a\u00020\tHÆ\u0003J\t\u0010H\u001a\u00020\u0007HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jò\u0001\u0010J\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\t2\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\tHÆ\u0001¢\u0006\u0002\u0010KJ\u0013\u0010L\u001a\u00020\t2\b\u0010M\u001a\u0004\u0018\u00010NHÖ\u0003J\t\u0010O\u001a\u00020\u0007HÖ\u0001J\t\u0010P\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0016\u0010\u001b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010%\u001a\u0004\b#\u0010$R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010%\u001a\u0004\b(\u0010$R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010%\u001a\u0004\b)\u0010$R\u0019\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010%\u001a\u0004\b,\u0010$R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\"R\u0011\u0010\u0013\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\"R\u0011\u0010\u0012\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\"R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001eR\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001eR\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\"R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001eR\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u001e¨\u0006Q"}, d2 = {"Lcom/bytedance/android/shopping/api/anchorv3/ECAwemeItemInfo;", "Ljava/io/Serializable;", "itemId", "", "userId", "secUid", "followStatus", "", "isAd", "", "adType", "shouldEnterProductFeed", "pageInternalFlowStyle", "topLabelText", "aggParams", "Lorg/json/JSONObject;", "rawCreativeId", "userOpenId", "isStar", "isAds", "goodPriceParam", "", "goodPriceCardGuessLikeOpt", "goodPriceCardMainOpt", "innerLandingImageSearch", "fullProductFlowConfig", "Lcom/google/gson/JsonObject;", "enableInflowList", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ZLjava/lang/String;ZILjava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;ZZLjava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/google/gson/JsonObject;Z)V", "getAdType", "()Ljava/lang/String;", "getAggParams", "()Lorg/json/JSONObject;", "getEnableInflowList", "()Z", "getFollowStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFullProductFlowConfig", "()Lcom/google/gson/JsonObject;", "getGoodPriceCardGuessLikeOpt", "getGoodPriceCardMainOpt", "getGoodPriceParam", "()Ljava/util/List;", "getInnerLandingImageSearch", "getItemId", "getPageInternalFlowStyle", "()I", "getRawCreativeId", "getSecUid", "getShouldEnterProductFeed", "getTopLabelText", "getUserId", "getUserOpenId", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ZLjava/lang/String;ZILjava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;ZZLjava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/google/gson/JsonObject;Z)Lcom/bytedance/android/shopping/api/anchorv3/ECAwemeItemInfo;", "equals", "other", "", "hashCode", "toString", "ec-shopping-api_release"}, k = 1, mv = {1, 4, 3})
public final class ECAwemeItemInfo implements Serializable {
    private final String adType;
    private final JSONObject aggParams;

    @SerializedName("enable_inflow_list")
    private final boolean enableInflowList;
    private final Integer followStatus;

    @SerializedName("full_product_flow_config")
    private final JsonObject fullProductFlowConfig;
    private final Integer goodPriceCardGuessLikeOpt;
    private final Integer goodPriceCardMainOpt;
    private final List<String> goodPriceParam;
    private final Integer innerLandingImageSearch;
    private final boolean isAd;
    private final boolean isAds;
    private final boolean isStar;
    private final String itemId;
    private final int pageInternalFlowStyle;
    private final String rawCreativeId;
    private final String secUid;
    private final boolean shouldEnterProductFeed;
    private final String topLabelText;
    private final String userId;
    private final String userOpenId;

    public ECAwemeItemInfo() {
        this(null, null, null, null, false, null, false, 0, null, null, null, null, false, false, null, null, null, null, null, false, 1048575, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ECAwemeItemInfo copy$default(ECAwemeItemInfo r110, String r111, String r112, String r210, Integer r211, boolean r212, String r213, boolean r214, int r215, String r216, JSONObject r217, String r218, String r219, boolean r310, boolean r311, List r312, Integer r313, Integer r314, Integer r315, JsonObject r316, boolean r317, int r318, Object r319) {
        if ((r318 & 1) == 0) goto L5;
        String r100 = r110.itemId;
    L7:
        if ((r318 & 2) == 0) goto L9;
        String r101 = r110.userId;
    L11:
        if ((r318 & 4) == 0) goto L13;
        String r102 = r110.secUid;
    L15:
        if ((r318 & 8) == 0) goto L17;
        Integer r103 = r110.followStatus;
    L19:
        if ((r318 & 16) == 0) goto L21;
        boolean r104 = r110.isAd;
    L23:
        if ((r318 & 32) == 0) goto L25;
        String r105 = r110.adType;
    L27:
        if ((r318 & 64) == 0) goto L29;
        boolean r106 = r110.shouldEnterProductFeed;
    L31:
        if ((r318 & 128) == 0) goto L33;
        int r107 = r110.pageInternalFlowStyle;
    L35:
        if ((r318 & 256) == 0) goto L37;
        String r113 = r110.topLabelText;
    L39:
        if ((r318 & 512) == 0) goto L41;
        JSONObject r114 = r110.aggParams;
    L43:
        if ((r318 & 1024) == 0) goto L45;
        String r115 = r110.rawCreativeId;
    L47:
        if ((r318 & 2048) == 0) goto L49;
        String r116 = r110.userOpenId;
    L51:
        if ((r318 & 4096) == 0) goto L53;
        boolean r117 = r110.isStar;
    L55:
        if ((r318 & 8192) == 0) goto L57;
        boolean r118 = r110.isAds;
    L58:
        boolean r320 = r118;
        if ((r318 & 16384) == 0) goto L61;
        List r119 = r110.goodPriceParam;
    L62:
        List r321 = r119;
        if ((r318 & 32768) == 0) goto L65;
        Integer r120 = r110.goodPriceCardGuessLikeOpt;
    L66:
        Integer r322 = r120;
        if ((r318 & 65536) == 0) goto L69;
        Integer r121 = r110.goodPriceCardMainOpt;
    L70:
        Integer r323 = r121;
        if ((r318 & 131072) == 0) goto L73;
        Integer r122 = r110.innerLandingImageSearch;
    L74:
        Integer r324 = r122;
        if ((r318 & 262144) == 0) goto L77;
        JsonObject r123 = r110.fullProductFlowConfig;
    L79:
        if ((r318 & 524288) == 0) goto L81;
        boolean r108 = r110.enableInflowList;
    L83:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r320, r321, r322, r323, r324, r123, r108);
    L81:
        r108 = r317;
        goto L83
    L77:
        r123 = r316;
        goto L79
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
        return this.itemId;
    }

    public final JSONObject component10() {
        return this.aggParams;
    }

    public final String component11() {
        return this.rawCreativeId;
    }

    public final String component12() {
        return this.userOpenId;
    }

    public final boolean component13() {
        return this.isStar;
    }

    public final boolean component14() {
        return this.isAds;
    }

    public final List<String> component15() {
        return this.goodPriceParam;
    }

    public final Integer component16() {
        return this.goodPriceCardGuessLikeOpt;
    }

    public final Integer component17() {
        return this.goodPriceCardMainOpt;
    }

    public final Integer component18() {
        return this.innerLandingImageSearch;
    }

    public final JsonObject component19() {
        return this.fullProductFlowConfig;
    }

    public final String component2() {
        return this.userId;
    }

    public final boolean component20() {
        return this.enableInflowList;
    }

    public final String component3() {
        return this.secUid;
    }

    public final Integer component4() {
        return this.followStatus;
    }

    public final boolean component5() {
        return this.isAd;
    }

    public final String component6() {
        return this.adType;
    }

    public final boolean component7() {
        return this.shouldEnterProductFeed;
    }

    public final int component8() {
        return this.pageInternalFlowStyle;
    }

    public final String component9() {
        return this.topLabelText;
    }

    public final ECAwemeItemInfo copy(String r210, String r211, String r212, Integer r213, boolean r214, String r215, boolean r216, int r310, String r311, JSONObject r312, String r313, String r314, boolean r315, boolean r316, List<String> r317, Integer r318, Integer r319, Integer r410, JsonObject r411, boolean r412) {
        Intrinsics.checkNotNullParameter(r211, "userId");
        Intrinsics.checkNotNullParameter(r212, "secUid");
        Intrinsics.checkNotNullParameter(r314, "userOpenId");
        return new ECAwemeItemInfo(r210, r211, r212, r213, r214, r215, r216, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECAwemeItemInfo) == false) goto L46;
        ECAwemeItemInfo r101 = (ECAwemeItemInfo) r100;
        if (Intrinsics.areEqual(this.itemId, r101.itemId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.userId, r101.userId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.secUid, r101.secUid) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.followStatus, r101.followStatus) == true) goto L14;
        return false;
    L14:
        if (this.isAd == r101.isAd) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.adType, r101.adType) == true) goto L18;
        return false;
    L18:
        if (this.shouldEnterProductFeed == r101.shouldEnterProductFeed) goto L20;
        return false;
    L20:
        if (this.pageInternalFlowStyle == r101.pageInternalFlowStyle) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.topLabelText, r101.topLabelText) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.aggParams, r101.aggParams) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.rawCreativeId, r101.rawCreativeId) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.userOpenId, r101.userOpenId) == true) goto L30;
        return false;
    L30:
        if (this.isStar == r101.isStar) goto L32;
        return false;
    L32:
        if (this.isAds == r101.isAds) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.goodPriceParam, r101.goodPriceParam) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.goodPriceCardGuessLikeOpt, r101.goodPriceCardGuessLikeOpt) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.goodPriceCardMainOpt, r101.goodPriceCardMainOpt) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.innerLandingImageSearch, r101.innerLandingImageSearch) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.fullProductFlowConfig, r101.fullProductFlowConfig) == true) goto L44;
        return false;
    L44:
        if (this.enableInflowList == r101.enableInflowList) goto L70;
        return false;
    L70:
        return true;
    L46:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v40, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v15, types: [int] */
    /* JADX WARN: Type inference failed for: r2v30, types: [int] */
    /* JADX WARN: Type inference failed for: r2v32, types: [int] */
    /* JADX WARN: Type inference failed for: r2v50 */
    /* JADX WARN: Type inference failed for: r2v51 */
    /* JADX WARN: Type inference failed for: r2v56 */
    /* JADX WARN: Type inference failed for: r2v58 */
    /* JADX WARN: Type inference failed for: r2v62 */
    /* JADX WARN: Type inference failed for: r2v63 */
    /* JADX WARN: Type inference failed for: r2v64 */
    /* JADX WARN: Type inference failed for: r2v65 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        String r100 = this.itemId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.userId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.secUid;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.followStatus;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        boolean r113 = this.isAd;
        ?? r114 = 1;
        ?? r115 = r113;
        if (r113 == false) goto L21;
        r115 = 1;
    L21:
        int r116 = (r112 + r115) * 31;
        String r117 = this.adType;
        if (r117 == null) goto L24;
        int r118 = r117.hashCode();
    L25:
        int r119 = (r116 + r118) * 31;
        boolean r120 = this.shouldEnterProductFeed;
        ?? r121 = r120;
        if (r120 == false) goto L28;
        r121 = 1;
    L28:
        int r122 = (((r119 + r121) * 31) + this.pageInternalFlowStyle) * 31;
        String r123 = this.topLabelText;
        if (r123 == null) goto L31;
        int r124 = r123.hashCode();
    L32:
        int r125 = (r122 + r124) * 31;
        JSONObject r126 = this.aggParams;
        if (r126 == null) goto L35;
        int r127 = r126.hashCode();
    L36:
        int r128 = (r125 + r127) * 31;
        String r129 = this.rawCreativeId;
        if (r129 == null) goto L39;
        int r130 = r129.hashCode();
    L40:
        int r131 = (r128 + r130) * 31;
        String r132 = this.userOpenId;
        if (r132 == null) goto L43;
        int r133 = r132.hashCode();
    L44:
        int r134 = (r131 + r133) * 31;
        boolean r135 = this.isStar;
        ?? r136 = r135;
        if (r135 == false) goto L47;
        r136 = 1;
    L47:
        int r137 = (r134 + r136) * 31;
        boolean r138 = this.isAds;
        ?? r139 = r138;
        if (r138 == false) goto L50;
        r139 = 1;
    L50:
        int r140 = (r137 + r139) * 31;
        List<String> r141 = this.goodPriceParam;
        if (r141 == null) goto L53;
        int r142 = r141.hashCode();
    L54:
        int r143 = (r140 + r142) * 31;
        Integer r144 = this.goodPriceCardGuessLikeOpt;
        if (r144 == null) goto L57;
        int r145 = r144.hashCode();
    L58:
        int r146 = (r143 + r145) * 31;
        Integer r147 = this.goodPriceCardMainOpt;
        if (r147 == null) goto L61;
        int r148 = r147.hashCode();
    L62:
        int r149 = (r146 + r148) * 31;
        Integer r150 = this.innerLandingImageSearch;
        if (r150 == null) goto L65;
        int r151 = r150.hashCode();
    L66:
        int r152 = (r149 + r151) * 31;
        JsonObject r153 = this.fullProductFlowConfig;
        if (r153 == null) goto L69;
        r101 = r153.hashCode();
    L69:
        int r154 = (r152 + r101) * 31;
        boolean r155 = this.enableInflowList;
        if (r155 == true) goto L74;
        r114 = r155;
    L74:
        return r154 + r114;
    L65:
        r151 = 0;
        goto L66
    L61:
        r148 = 0;
        goto L62
    L57:
        r145 = 0;
        goto L58
    L53:
        r142 = 0;
        goto L54
    L43:
        r133 = 0;
        goto L44
    L39:
        r130 = 0;
        goto L40
    L35:
        r127 = 0;
        goto L36
    L31:
        r124 = 0;
        goto L32
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
        return "ECAwemeItemInfo(itemId=" + this.itemId + ", userId=" + this.userId + ", secUid=" + this.secUid + ", followStatus=" + this.followStatus + ", isAd=" + this.isAd + ", adType=" + this.adType + ", shouldEnterProductFeed=" + this.shouldEnterProductFeed + ", pageInternalFlowStyle=" + this.pageInternalFlowStyle + ", topLabelText=" + this.topLabelText + ", aggParams=" + this.aggParams + ", rawCreativeId=" + this.rawCreativeId + ", userOpenId=" + this.userOpenId + ", isStar=" + this.isStar + ", isAds=" + this.isAds + ", goodPriceParam=" + this.goodPriceParam + ", goodPriceCardGuessLikeOpt=" + this.goodPriceCardGuessLikeOpt + ", goodPriceCardMainOpt=" + this.goodPriceCardMainOpt + ", innerLandingImageSearch=" + this.innerLandingImageSearch + ", fullProductFlowConfig=" + this.fullProductFlowConfig + ", enableInflowList=" + this.enableInflowList + ")";
    }

    public final String getAdType() {
        return this.adType;
    }

    public final JSONObject getAggParams() {
        return this.aggParams;
    }

    public final boolean getEnableInflowList() {
        return this.enableInflowList;
    }

    public final Integer getFollowStatus() {
        return this.followStatus;
    }

    public final JsonObject getFullProductFlowConfig() {
        return this.fullProductFlowConfig;
    }

    public final Integer getGoodPriceCardGuessLikeOpt() {
        return this.goodPriceCardGuessLikeOpt;
    }

    public final Integer getGoodPriceCardMainOpt() {
        return this.goodPriceCardMainOpt;
    }

    public final List<String> getGoodPriceParam() {
        return this.goodPriceParam;
    }

    public final Integer getInnerLandingImageSearch() {
        return this.innerLandingImageSearch;
    }

    public final String getItemId() {
        return this.itemId;
    }

    public final int getPageInternalFlowStyle() {
        return this.pageInternalFlowStyle;
    }

    public final String getRawCreativeId() {
        return this.rawCreativeId;
    }

    public final String getSecUid() {
        return this.secUid;
    }

    public final boolean getShouldEnterProductFeed() {
        return this.shouldEnterProductFeed;
    }

    public final String getTopLabelText() {
        return this.topLabelText;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUserOpenId() {
        return this.userOpenId;
    }

    public final boolean isAd() {
        return this.isAd;
    }

    public final boolean isAds() {
        return this.isAds;
    }

    public final boolean isStar() {
        return this.isStar;
    }

    public ECAwemeItemInfo(String r100, String r101, String r102, Integer r103, boolean r110, String r111, boolean r112, int r113, String r114, JSONObject r115, String r116, String r117, boolean r118, boolean r119, List<String> r210, Integer r211, Integer r212, Integer r213, JsonObject r214, boolean r215) {
        Intrinsics.checkNotNullParameter(r101, "userId");
        Intrinsics.checkNotNullParameter(r102, "secUid");
        Intrinsics.checkNotNullParameter(r117, "userOpenId");
        this.itemId = r100;
        this.userId = r101;
        this.secUid = r102;
        this.followStatus = r103;
        this.isAd = r110;
        this.adType = r111;
        this.shouldEnterProductFeed = r112;
        this.pageInternalFlowStyle = r113;
        this.topLabelText = r114;
        this.aggParams = r115;
        this.rawCreativeId = r116;
        this.userOpenId = r117;
        this.isStar = r118;
        this.isAds = r119;
        this.goodPriceParam = r210;
        this.goodPriceCardGuessLikeOpt = r211;
        this.goodPriceCardMainOpt = r212;
        this.innerLandingImageSearch = r213;
        this.fullProductFlowConfig = r214;
        this.enableInflowList = r215;
    }

    public /* synthetic */ ECAwemeItemInfo(String r210, String r211, String r212, Integer r213, boolean r214, String r215, boolean r216, int r310, String r311, JSONObject r312, String r313, String r314, boolean r315, boolean r316, List r317, Integer r318, Integer r319, Integer r410, JsonObject r411, boolean r412, int r413, DefaultConstructorMarker r414) {
        if ((r413 & 1) == 0) goto L5;
        String r100 = null;
    L6:
        String r101 = "";
        if ((r413 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r413 & 4) == 0) goto L13;
        String r103 = "";
    L15:
        if ((r413 & 8) == 0) goto L17;
        Integer r104 = null;
    L19:
        if ((r413 & 16) == 0) goto L21;
        boolean r105 = false;
    L23:
        if ((r413 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r413 & 64) == 0) goto L29;
        boolean r110 = false;
    L31:
        if ((r413 & 128) == 0) goto L33;
        int r111 = 0;
    L35:
        if ((r413 & 256) == 0) goto L37;
        String r112 = null;
    L39:
        if ((r413 & 512) == 0) goto L41;
        JSONObject r113 = null;
    L43:
        if ((r413 & 1024) == 0) goto L45;
        String r114 = null;
    L47:
        if ((r413 & 2048) != 0) goto L51;
        r101 = r314;
    L51:
        if ((r413 & 4096) == 0) goto L53;
        boolean r115 = false;
    L55:
        if ((r413 & 8192) == 0) goto L57;
        boolean r107 = false;
    L59:
        if ((r413 & 16384) == 0) goto L61;
        List r108 = null;
    L63:
        if ((r413 & 32768) == 0) goto L65;
        boolean r116 = false;
        Integer r117 = 0;
    L67:
        if ((r413 & 65536) == 0) goto L69;
        Integer r118 = Integer.valueOf(r116 ? 1 : 0);
    L71:
        if ((r413 & 131072) == 0) goto L73;
        Integer r119 = null;
    L75:
        if ((r413 & 262144) == 0) goto L77;
        JsonObject r217 = null;
    L79:
        if ((r413 & 524288) != 0) goto L82;
        r116 = r412;
    L82:
        this(r100, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r101, r115, r107, r108, r117, r118, r119, r217, r116);
        return;
    L77:
        r217 = r411;
        goto L79
    L73:
        r119 = r410;
        goto L75
    L69:
        r118 = r319;
        goto L71
    L65:
        r116 = false;
        r117 = r318;
        goto L67
    L61:
        r108 = r317;
        goto L63
    L57:
        r107 = r316;
        goto L59
    L53:
        r115 = r315;
        goto L55
    L45:
        r114 = r313;
        goto L47
    L41:
        r113 = r312;
        goto L43
    L37:
        r112 = r311;
        goto L39
    L33:
        r111 = r310;
        goto L35
    L29:
        r110 = r216;
        goto L31
    L25:
        r106 = r215;
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
        r100 = r210;
        goto L6
    }
}
