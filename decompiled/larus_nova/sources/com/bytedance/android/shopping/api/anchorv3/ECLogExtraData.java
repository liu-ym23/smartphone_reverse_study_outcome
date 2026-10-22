package com.bytedance.android.shopping.api.anchorv3;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b+\u0018\u00002\u00020\u0001BÙ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0015R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0017\"\u0004\b$\u0010\u0019R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0017\"\u0004\b&\u0010\u0019R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0017R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0017R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0017R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0017R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0017R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0017R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0017¨\u0006."}, d2 = {"Lcom/bytedance/android/shopping/api/anchorv3/ECLogExtraData;", "Ljava/io/Serializable;", "enterFrom", "", "enterMethod", "eComEntranceForm", "v3EventsAdditions", "whichAccount", "recommendInfo", "requestId", "productSourcePage", "moduleLabel", "labelNameFromLive", "baseVerifiedCategory", "labelNameLive", "transitionTrackerData", "threeDLogData", "inflowRecommendType", "adType", "ecomShareTrackParams", "shareGroupInfo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAdType", "()Ljava/lang/String;", "setAdType", "(Ljava/lang/String;)V", "getBaseVerifiedCategory", "getEComEntranceForm", "getEcomShareTrackParams", "setEcomShareTrackParams", "getEnterFrom", "getEnterMethod", "getInflowRecommendType", "getLabelNameFromLive", "getLabelNameLive", "getModuleLabel", "setModuleLabel", "getProductSourcePage", "setProductSourcePage", "getRecommendInfo", "getRequestId", "getShareGroupInfo", "getThreeDLogData", "getTransitionTrackerData", "getV3EventsAdditions", "getWhichAccount", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ECLogExtraData implements Serializable {
    private String adType;
    private final String baseVerifiedCategory;
    private final String eComEntranceForm;
    private String ecomShareTrackParams;
    private final String enterFrom;
    private final String enterMethod;
    private final String inflowRecommendType;
    private final String labelNameFromLive;
    private final String labelNameLive;
    private String moduleLabel;
    private String productSourcePage;
    private final String recommendInfo;
    private final String requestId;
    private final String shareGroupInfo;
    private final String threeDLogData;
    private final String transitionTrackerData;
    private final String v3EventsAdditions;
    private final String whichAccount;

    public ECLogExtraData() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 262143, null);
    }

    public final String getAdType() {
        return this.adType;
    }

    public final String getBaseVerifiedCategory() {
        return this.baseVerifiedCategory;
    }

    public final String getEComEntranceForm() {
        return this.eComEntranceForm;
    }

    public final String getEcomShareTrackParams() {
        return this.ecomShareTrackParams;
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final String getInflowRecommendType() {
        return this.inflowRecommendType;
    }

    public final String getLabelNameFromLive() {
        return this.labelNameFromLive;
    }

    public final String getLabelNameLive() {
        return this.labelNameLive;
    }

    public final String getModuleLabel() {
        return this.moduleLabel;
    }

    public final String getProductSourcePage() {
        return this.productSourcePage;
    }

    public final String getRecommendInfo() {
        return this.recommendInfo;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final String getShareGroupInfo() {
        return this.shareGroupInfo;
    }

    public final String getThreeDLogData() {
        return this.threeDLogData;
    }

    public final String getTransitionTrackerData() {
        return this.transitionTrackerData;
    }

    public final String getV3EventsAdditions() {
        return this.v3EventsAdditions;
    }

    public final String getWhichAccount() {
        return this.whichAccount;
    }

    public final void setAdType(String r100) {
        this.adType = r100;
    }

    public final void setEcomShareTrackParams(String r100) {
        this.ecomShareTrackParams = r100;
    }

    public final void setModuleLabel(String r100) {
        this.moduleLabel = r100;
    }

    public final void setProductSourcePage(String r100) {
        this.productSourcePage = r100;
    }

    public ECLogExtraData(String r100, String r101, String r102, String r103, String r104, String r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117, String r118, String r119, String r210, String r211, String r212) {
        Intrinsics.checkNotNullParameter(r100, "enterFrom");
        Intrinsics.checkNotNullParameter(r101, "enterMethod");
        this.enterFrom = r100;
        this.enterMethod = r101;
        this.eComEntranceForm = r102;
        this.v3EventsAdditions = r103;
        this.whichAccount = r104;
        this.recommendInfo = r110;
        this.requestId = r111;
        this.productSourcePage = r112;
        this.moduleLabel = r113;
        this.labelNameFromLive = r114;
        this.baseVerifiedCategory = r115;
        this.labelNameLive = r116;
        this.transitionTrackerData = r117;
        this.threeDLogData = r118;
        this.inflowRecommendType = r119;
        this.adType = r210;
        this.ecomShareTrackParams = r211;
        this.shareGroupInfo = r212;
    }

    public /* synthetic */ ECLogExtraData(String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, String r219, String r310, String r311, String r312, String r313, String r314, String r315, String r316, String r317, int r318, DefaultConstructorMarker r319) {
        String r100 = "";
        if ((r318 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r318 & 2) != 0) goto L11;
        r100 = r211;
    L11:
        if ((r318 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r318 & 8) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r318 & 16) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r318 & 32) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r318 & 64) == 0) goto L29;
        String r106 = null;
    L31:
        if ((r318 & 128) == 0) goto L33;
        String r107 = null;
    L35:
        if ((r318 & 256) == 0) goto L37;
        String r110 = null;
    L39:
        if ((r318 & 512) == 0) goto L41;
        String r111 = null;
    L43:
        if ((r318 & 1024) == 0) goto L45;
        String r112 = null;
    L47:
        if ((r318 & 2048) == 0) goto L49;
        String r113 = null;
    L51:
        if ((r318 & 4096) == 0) goto L53;
        String r114 = null;
    L55:
        if ((r318 & 8192) == 0) goto L57;
        String r115 = null;
    L59:
        if ((r318 & 16384) == 0) goto L61;
        String r108 = null;
    L63:
        if ((r318 & 32768) == 0) goto L65;
        String r116 = null;
    L67:
        if ((r318 & 65536) == 0) goto L69;
        String r117 = null;
    L71:
        if ((r318 & 131072) == 0) goto L73;
        String r109 = null;
    L74:
        this(r101, r100, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r115, r108, r116, r117, r109);
        return;
    L73:
        r109 = r317;
        goto L74
    L69:
        r117 = r316;
        goto L71
    L65:
        r116 = r315;
        goto L67
    L61:
        r108 = r314;
        goto L63
    L57:
        r115 = r313;
        goto L59
    L53:
        r114 = r312;
        goto L55
    L49:
        r113 = r311;
        goto L51
    L45:
        r112 = r310;
        goto L47
    L41:
        r111 = r219;
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
    L5:
        r101 = r210;
        goto L7
    }
}
