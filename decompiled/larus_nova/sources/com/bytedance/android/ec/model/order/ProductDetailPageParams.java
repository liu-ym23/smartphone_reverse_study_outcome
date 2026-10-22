package com.bytedance.android.ec.model.order;

import com.bytedance.android.ec.core.event.a;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b&\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B¿\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0015J\u0006\u00103\u001a\u000204R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001bR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0017\"\u0004\b \u0010!R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0017R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0017R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0017\"\u0004\b)\u0010!R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0017\"\u0004\b+\u0010!R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0017R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0017\"\u0004\b.\u0010!R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0017\"\u0004\b0\u0010!R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0017\"\u0004\b2\u0010!¨\u00065"}, d2 = {"Lcom/bytedance/android/ec/model/order/ProductDetailPageParams;", "Ljava/io/Serializable;", "requestAdditions", "", "v3EventsAdditions", "metaParam", "fromVideo", "", "fromLive", "roomId", "transmissibleJson", "promotionLogId", "pageResumeDuration", "", "whichAccount", "messagePVInfo", "pageType", "receiveAddressId", "threeDLogData", "bizCampaignType", "nGroupBuyToken", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBizCampaignType", "()Ljava/lang/String;", "getFromLive", "()Z", "setFromLive", "(Z)V", "getFromVideo", "setFromVideo", "getMessagePVInfo", "getMetaParam", "setMetaParam", "(Ljava/lang/String;)V", "getNGroupBuyToken", "getPageResumeDuration", "()J", "getPageType", "getPromotionLogId", "getReceiveAddressId", "getRequestAdditions", "setRequestAdditions", "getRoomId", "setRoomId", "getThreeDLogData", "getTransmissibleJson", "setTransmissibleJson", "getV3EventsAdditions", "setV3EventsAdditions", "getWhichAccount", "setWhichAccount", "asJsonDescription", "Lorg/json/JSONObject;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ProductDetailPageParams implements Serializable {
    private final String bizCampaignType;
    private boolean fromLive;
    private boolean fromVideo;
    private final String messagePVInfo;
    private String metaParam;
    private final String nGroupBuyToken;
    private final long pageResumeDuration;
    private final String pageType;
    private final String promotionLogId;
    private final String receiveAddressId;
    private String requestAdditions;
    private String roomId;
    private final String threeDLogData;
    private String transmissibleJson;
    private String v3EventsAdditions;
    private String whichAccount;

    public ProductDetailPageParams() {
        this(null, null, null, false, false, null, null, null, 0, null, null, null, null, null, null, null, 65535, null);
    }

    public final JSONObject asJsonDescription() {
        JSONObject r100 = new JSONObject();
        r100.put(a.KEY_REQUEST_ADDITIONS, this.requestAdditions);
        r100.put("v3_events_additions", this.v3EventsAdditions);
        r100.put(a.KEY_META_PARAM, this.metaParam);
        r100.put("from_video", this.fromVideo);
        r100.put("from_live", this.fromLive);
        r100.put("room_id", this.roomId);
        r100.put("transmissible_json", this.transmissibleJson);
        r100.put("promotion_log_id", this.promotionLogId);
        r100.put("page_resume_duration", this.pageResumeDuration);
        r100.put(a.KEY_WHICH_ACCOUNT, this.whichAccount);
        r100.put("message_pv_info", this.messagePVInfo);
        r100.put("page_type", this.pageType);
        r100.put("receive_address_id", this.receiveAddressId);
        r100.put("three_d_log_data", this.threeDLogData);
        return r100;
    }

    public final String getBizCampaignType() {
        return this.bizCampaignType;
    }

    public final boolean getFromLive() {
        return this.fromLive;
    }

    public final boolean getFromVideo() {
        return this.fromVideo;
    }

    public final String getMessagePVInfo() {
        return this.messagePVInfo;
    }

    public final String getMetaParam() {
        return this.metaParam;
    }

    public final String getNGroupBuyToken() {
        return this.nGroupBuyToken;
    }

    public final long getPageResumeDuration() {
        return this.pageResumeDuration;
    }

    public final String getPageType() {
        return this.pageType;
    }

    public final String getPromotionLogId() {
        return this.promotionLogId;
    }

    public final String getReceiveAddressId() {
        return this.receiveAddressId;
    }

    public final String getRequestAdditions() {
        return this.requestAdditions;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final String getThreeDLogData() {
        return this.threeDLogData;
    }

    public final String getTransmissibleJson() {
        return this.transmissibleJson;
    }

    public final String getV3EventsAdditions() {
        return this.v3EventsAdditions;
    }

    public final String getWhichAccount() {
        return this.whichAccount;
    }

    public final void setFromLive(boolean r100) {
        this.fromLive = r100;
    }

    public final void setFromVideo(boolean r100) {
        this.fromVideo = r100;
    }

    public final void setMetaParam(String r100) {
        this.metaParam = r100;
    }

    public final void setRequestAdditions(String r100) {
        this.requestAdditions = r100;
    }

    public final void setRoomId(String r100) {
        this.roomId = r100;
    }

    public final void setTransmissibleJson(String r100) {
        this.transmissibleJson = r100;
    }

    public final void setV3EventsAdditions(String r100) {
        this.v3EventsAdditions = r100;
    }

    public final void setWhichAccount(String r100) {
        this.whichAccount = r100;
    }

    public ProductDetailPageParams(String r100, String r101, String r102, boolean r103, boolean r104, String r105, String r110, String r111, long r112, String r113, String r114, String r115, String r116, String r117, String r118, String r210) {
        this.requestAdditions = r100;
        this.v3EventsAdditions = r101;
        this.metaParam = r102;
        this.fromVideo = r103;
        this.fromLive = r104;
        this.roomId = r105;
        this.transmissibleJson = r110;
        this.promotionLogId = r111;
        this.pageResumeDuration = r112;
        this.whichAccount = r113;
        this.messagePVInfo = r114;
        this.pageType = r115;
        this.receiveAddressId = r116;
        this.threeDLogData = r117;
        this.bizCampaignType = r118;
        this.nGroupBuyToken = r210;
    }

    public /* synthetic */ ProductDetailPageParams(String r110, String r210, String r211, boolean r212, boolean r213, String r214, String r215, String r216, long r217, String r218, String r310, String r311, String r312, String r313, String r314, String r315, int r316, DefaultConstructorMarker r317) {
        if ((r316 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r316 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r316 & 4) == 0) goto L13;
        String r102 = null;
    L14:
        boolean r103 = false;
        if ((r316 & 8) == 0) goto L17;
        boolean r104 = false;
    L19:
        if ((r316 & 16) != 0) goto L23;
        r103 = r213;
    L23:
        if ((r316 & 32) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r316 & 64) == 0) goto L29;
        String r106 = null;
    L31:
        if ((r316 & 128) == 0) goto L33;
        String r107 = null;
    L35:
        if ((r316 & 256) == 0) goto L37;
        long r111 = 0;
    L39:
        if ((r316 & 512) == 0) goto L41;
        String r112 = null;
    L43:
        if ((r316 & 1024) == 0) goto L45;
        String r113 = null;
    L47:
        if ((r316 & 2048) == 0) goto L49;
        String r114 = null;
    L51:
        if ((r316 & 4096) == 0) goto L53;
        String r115 = null;
    L55:
        if ((r316 & 8192) == 0) goto L57;
        String r108 = null;
    L58:
        String r116 = r108;
        if ((r316 & 16384) == 0) goto L61;
        String r109 = null;
    L63:
        if ((r316 & 32768) == 0) goto L65;
        String r117 = null;
    L66:
        this(r100, r101, r102, r104, r103, r105, r106, r107, r111, r112, r113, r114, r115, r116, r109, r117);
        return;
    L65:
        r117 = r315;
        goto L66
    L61:
        r109 = r314;
        goto L63
    L57:
        r108 = r313;
        goto L58
    L53:
        r115 = r312;
        goto L55
    L49:
        r114 = r311;
        goto L51
    L45:
        r113 = r310;
        goto L47
    L41:
        r112 = r218;
        goto L43
    L37:
        r111 = r217;
        goto L39
    L33:
        r107 = r216;
        goto L35
    L29:
        r106 = r215;
        goto L31
    L25:
        r105 = r214;
        goto L27
    L17:
        r104 = r212;
        goto L19
    L13:
        r102 = r211;
        goto L14
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
