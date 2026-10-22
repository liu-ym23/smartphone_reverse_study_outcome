package com.bytedance.android.ec.model.sku;

import com.android.ttcjpaysdk.integrated.sign.counter.activity.SignCounterLaunchArgs;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Be\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\fJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0012Jn\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\bHÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000eR\u001a\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0017\u0010\u0012¨\u0006("}, d2 = {"Lcom/bytedance/android/ec/model/sku/SkuChainInfo;", "Ljava/io/Serializable;", ReportConstant.COMMON_ACTION_TYPE, "", SignCounterLaunchArgs.EXTRA_SCENE_TYPE, "marketingChannel", RemoteMessageConst.Notification.CHANNEL_ID, "channelType", "", "enterFrom", "bizCampaignType", "touTiaoAppId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getActionType", "()Ljava/lang/String;", "getBizCampaignType", "getChannelId", "getChannelType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEnterFrom", "getMarketingChannel", "getSceneType", "getTouTiaoAppId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/bytedance/android/ec/model/sku/SkuChainInfo;", "equals", "", "other", "", "hashCode", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class SkuChainInfo implements Serializable {

    @SerializedName("action_type")
    private final String actionType;

    @SerializedName("biz_campaign_type")
    private final String bizCampaignType;

    @SerializedName("channel_id")
    private final String channelId;

    @SerializedName(WsConstants.KEY_CHANNEL_TYPE)
    private final Integer channelType;

    @SerializedName("enter_from")
    private final String enterFrom;

    @SerializedName(a.KEY_MARKET_CHANNEL)
    private final String marketingChannel;

    @SerializedName("scene_type")
    private final String sceneType;

    @SerializedName("toutiao_app_id")
    private final Integer touTiaoAppId;

    public SkuChainInfo() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public static /* synthetic */ SkuChainInfo copy$default(SkuChainInfo r100, String r110, String r111, String r112, String r113, Integer r114, String r115, String r116, Integer r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        String r101 = r100.actionType;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = r100.sceneType;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = r100.marketingChannel;
    L15:
        if ((r118 & 8) == 0) goto L17;
        String r104 = r100.channelId;
    L19:
        if ((r118 & 16) == 0) goto L21;
        Integer r105 = r100.channelType;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = r100.enterFrom;
    L27:
        if ((r118 & 64) == 0) goto L29;
        String r107 = r100.bizCampaignType;
    L31:
        if ((r118 & 128) == 0) goto L33;
        Integer r108 = r100.touTiaoAppId;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final String component1() {
        return this.actionType;
    }

    public final String component2() {
        return this.sceneType;
    }

    public final String component3() {
        return this.marketingChannel;
    }

    public final String component4() {
        return this.channelId;
    }

    public final Integer component5() {
        return this.channelType;
    }

    public final String component6() {
        return this.enterFrom;
    }

    public final String component7() {
        return this.bizCampaignType;
    }

    public final Integer component8() {
        return this.touTiaoAppId;
    }

    public final SkuChainInfo copy(String r110, String r111, String r112, String r113, Integer r114, String r115, String r116, Integer r117) {
        return new SkuChainInfo(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SkuChainInfo) == false) goto L22;
        SkuChainInfo r101 = (SkuChainInfo) r100;
        if (Intrinsics.areEqual(this.actionType, r101.actionType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.sceneType, r101.sceneType) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.marketingChannel, r101.marketingChannel) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.channelId, r101.channelId) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.channelType, r101.channelType) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.enterFrom, r101.enterFrom) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.bizCampaignType, r101.bizCampaignType) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.touTiaoAppId, r101.touTiaoAppId) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public int hashCode() {
        String r100 = this.actionType;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.sceneType;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.marketingChannel;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.channelId;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.channelType;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.enterFrom;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.bizCampaignType;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.touTiaoAppId;
        if (r122 == null) goto L34;
        r101 = r122.hashCode();
    L34:
        return r121 + r101;
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
        return "SkuChainInfo(actionType=" + this.actionType + ", sceneType=" + this.sceneType + ", marketingChannel=" + this.marketingChannel + ", channelId=" + this.channelId + ", channelType=" + this.channelType + ", enterFrom=" + this.enterFrom + ", bizCampaignType=" + this.bizCampaignType + ", touTiaoAppId=" + this.touTiaoAppId + ")";
    }

    public final String getActionType() {
        return this.actionType;
    }

    public final String getBizCampaignType() {
        return this.bizCampaignType;
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final Integer getChannelType() {
        return this.channelType;
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final String getMarketingChannel() {
        return this.marketingChannel;
    }

    public final String getSceneType() {
        return this.sceneType;
    }

    public final Integer getTouTiaoAppId() {
        return this.touTiaoAppId;
    }

    public SkuChainInfo(String r100, String r101, String r102, String r103, Integer r104, String r105, String r106, Integer r107) {
        this.actionType = r100;
        this.sceneType = r101;
        this.marketingChannel = r102;
        this.channelId = r103;
        this.channelType = r104;
        this.enterFrom = r105;
        this.bizCampaignType = r106;
        this.touTiaoAppId = r107;
    }

    public /* synthetic */ SkuChainInfo(String r110, String r111, String r112, String r113, Integer r114, String r115, String r116, Integer r117, int r118, DefaultConstructorMarker r119) {
        Integer r100 = null;
        if ((r118 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r118 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r118 & 16) == 0) goto L21;
        Integer r105 = null;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r118 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r118 & 128) != 0) goto L34;
        r100 = r117;
    L34:
        this(r101, r102, r103, r104, r105, r106, r107, r100);
        return;
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
