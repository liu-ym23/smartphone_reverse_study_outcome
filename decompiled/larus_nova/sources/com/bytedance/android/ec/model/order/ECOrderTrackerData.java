package com.bytedance.android.ec.model.order;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.android.ec.model.ECBoltParam;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b-\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001BÙ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0019J\u0006\u0010B\u001a\u00020CR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001fR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001f\"\u0004\b&\u0010!R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001f\"\u0004\b,\u0010!R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001fR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001f\"\u0004\b/\u0010!R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001f\"\u0004\b1\u0010!R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u00106\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u00107\"\u0004\b8\u00109R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u001fR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\u001fR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u001f\"\u0004\b=\u0010!R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\u001fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u001f\"\u0004\b@\u0010!R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\u001f¨\u0006D"}, d2 = {"Lcom/bytedance/android/ec/model/order/ECOrderTrackerData;", "Ljava/io/Serializable;", "entranceInfo", "", "sourcePage", "followStatus", "", "authorId", "secAuthorId", "videoId", "eComEntranceFrom", "enterMethod", "adLogExtra", "Lcom/bytedance/android/ec/model/ECAdLogExtra;", "boltParam", "Lcom/bytedance/android/ec/model/ECBoltParam;", "applyCouponIds", "labelNameFromLive", "baseVerifiedCategory", "labelNameLive", "isFromFeedProductGuessULike", "", "cardStatus", "recommendInfo", "authorOpenId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ec/model/ECAdLogExtra;Lcom/bytedance/android/ec/model/ECBoltParam;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAdLogExtra", "()Lcom/bytedance/android/ec/model/ECAdLogExtra;", "setAdLogExtra", "(Lcom/bytedance/android/ec/model/ECAdLogExtra;)V", "getApplyCouponIds", "()Ljava/lang/String;", "setApplyCouponIds", "(Ljava/lang/String;)V", "getAuthorId", "getAuthorOpenId", "setAuthorOpenId", "getBaseVerifiedCategory", "setBaseVerifiedCategory", "getBoltParam", "()Lcom/bytedance/android/ec/model/ECBoltParam;", "setBoltParam", "(Lcom/bytedance/android/ec/model/ECBoltParam;)V", "getCardStatus", "setCardStatus", "getEComEntranceFrom", "getEnterMethod", "setEnterMethod", "getEntranceInfo", "setEntranceInfo", "getFollowStatus", "()Ljava/lang/Integer;", "setFollowStatus", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "()Z", "setFromFeedProductGuessULike", "(Z)V", "getLabelNameFromLive", "getLabelNameLive", "getRecommendInfo", "setRecommendInfo", "getSecAuthorId", "getSourcePage", "setSourcePage", "getVideoId", "asJsonDescription", "Lorg/json/JSONObject;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ECOrderTrackerData implements Serializable {
    private ECAdLogExtra adLogExtra;
    private String applyCouponIds;
    private final String authorId;
    private String authorOpenId;
    private String baseVerifiedCategory;
    private ECBoltParam boltParam;
    private String cardStatus;
    private final String eComEntranceFrom;
    private String enterMethod;
    private String entranceInfo;
    private Integer followStatus;
    private boolean isFromFeedProductGuessULike;
    private final String labelNameFromLive;
    private final String labelNameLive;
    private String recommendInfo;
    private final String secAuthorId;
    private String sourcePage;
    private final String videoId;

    public ECOrderTrackerData() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, 262143, null);
    }

    public final JSONObject asJsonDescription() {
        JSONObject r100 = new JSONObject();
        r100.put(a.KEY_ENTRANCE_INFO, this.entranceInfo);
        r100.put("source_page", this.sourcePage);
        r100.put("follow_status", this.followStatus);
        r100.put("author_id", this.authorId);
        r100.put("sec_author_id", this.secAuthorId);
        r100.put("video_id", this.videoId);
        r100.put("e_com_entrance_from", this.eComEntranceFrom);
        r100.put("enter_method", this.enterMethod);
        r100.put(PdpOpenThirdParam.KEY_AD_LOG_EXTRA, GsonProtectorUtils.toJson(new Gson(), this.adLogExtra));
        r100.put("bolt_param", GsonProtectorUtils.toJson(new Gson(), this.boltParam));
        r100.put("apply_coupon_ids", this.applyCouponIds);
        r100.put("label_name_from_live", this.labelNameFromLive);
        r100.put(a.KEY_BASE_VERIFIED_CATEGORY, this.baseVerifiedCategory);
        r100.put(a.KEY_LABEL_NAME_LIVE, this.labelNameLive);
        r100.put("is_from_feed_product_guess_u_like", this.isFromFeedProductGuessULike);
        r100.put(a.KEY_CARD_STATUS, this.cardStatus);
        r100.put(a.KEY_RECOMMEND_INFO, this.recommendInfo);
        r100.put("author_open_id", this.authorOpenId);
        return r100;
    }

    public final ECAdLogExtra getAdLogExtra() {
        return this.adLogExtra;
    }

    public final String getApplyCouponIds() {
        return this.applyCouponIds;
    }

    public final String getAuthorId() {
        return this.authorId;
    }

    public final String getAuthorOpenId() {
        return this.authorOpenId;
    }

    public final String getBaseVerifiedCategory() {
        return this.baseVerifiedCategory;
    }

    public final ECBoltParam getBoltParam() {
        return this.boltParam;
    }

    public final String getCardStatus() {
        return this.cardStatus;
    }

    public final String getEComEntranceFrom() {
        return this.eComEntranceFrom;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final String getEntranceInfo() {
        return this.entranceInfo;
    }

    public final Integer getFollowStatus() {
        return this.followStatus;
    }

    public final String getLabelNameFromLive() {
        return this.labelNameFromLive;
    }

    public final String getLabelNameLive() {
        return this.labelNameLive;
    }

    public final String getRecommendInfo() {
        return this.recommendInfo;
    }

    public final String getSecAuthorId() {
        return this.secAuthorId;
    }

    public final String getSourcePage() {
        return this.sourcePage;
    }

    public final String getVideoId() {
        return this.videoId;
    }

    public final boolean isFromFeedProductGuessULike() {
        return this.isFromFeedProductGuessULike;
    }

    public final void setAdLogExtra(ECAdLogExtra r100) {
        this.adLogExtra = r100;
    }

    public final void setApplyCouponIds(String r100) {
        this.applyCouponIds = r100;
    }

    public final void setAuthorOpenId(String r100) {
        this.authorOpenId = r100;
    }

    public final void setBaseVerifiedCategory(String r100) {
        this.baseVerifiedCategory = r100;
    }

    public final void setBoltParam(ECBoltParam r100) {
        this.boltParam = r100;
    }

    public final void setCardStatus(String r100) {
        this.cardStatus = r100;
    }

    public final void setEnterMethod(String r100) {
        this.enterMethod = r100;
    }

    public final void setEntranceInfo(String r100) {
        this.entranceInfo = r100;
    }

    public final void setFollowStatus(Integer r100) {
        this.followStatus = r100;
    }

    public final void setFromFeedProductGuessULike(boolean r100) {
        this.isFromFeedProductGuessULike = r100;
    }

    public final void setRecommendInfo(String r100) {
        this.recommendInfo = r100;
    }

    public final void setSourcePage(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.sourcePage = r100;
    }

    public ECOrderTrackerData(String r100, String r101, Integer r102, String r103, String r104, String r105, String r110, String r111, ECAdLogExtra r112, ECBoltParam r113, String r114, String r115, String r116, String r117, boolean r118, String r119, String r210, String r211) {
        Intrinsics.checkNotNullParameter(r101, "sourcePage");
        this.entranceInfo = r100;
        this.sourcePage = r101;
        this.followStatus = r102;
        this.authorId = r103;
        this.secAuthorId = r104;
        this.videoId = r105;
        this.eComEntranceFrom = r110;
        this.enterMethod = r111;
        this.adLogExtra = r112;
        this.boltParam = r113;
        this.applyCouponIds = r114;
        this.labelNameFromLive = r115;
        this.baseVerifiedCategory = r116;
        this.labelNameLive = r117;
        this.isFromFeedProductGuessULike = r118;
        this.cardStatus = r119;
        this.recommendInfo = r210;
        this.authorOpenId = r211;
    }

    public /* synthetic */ ECOrderTrackerData(String r210, String r211, Integer r212, String r213, String r214, String r215, String r216, String r217, ECAdLogExtra r218, ECBoltParam r219, String r310, String r311, String r312, String r313, boolean r314, String r315, String r316, String r317, int r318, DefaultConstructorMarker r319) {
        if ((r318 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r318 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r318 & 4) == 0) goto L13;
        Integer r102 = null;
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
        ECAdLogExtra r110 = null;
    L39:
        if ((r318 & 512) == 0) goto L41;
        ECBoltParam r111 = null;
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
        boolean r108 = false;
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
        this(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r115, r108, r116, r117, r109);
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
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
