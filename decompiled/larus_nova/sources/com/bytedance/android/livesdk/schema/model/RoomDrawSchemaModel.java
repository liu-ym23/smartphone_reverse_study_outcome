package com.bytedance.android.livesdk.schema.model;

import com.bytedance.android.live.core.feed.FeedApi;
import com.bytedance.android.livesdk.schema.constants.SchemaHandlerHostConstants;
import com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u001b\b\u0007\u0018\u00002\u00020\u0001B¥\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0015J\b\u0010*\u001a\u00020\u0003H\u0016R\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b!\u0010\u0017R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u001aR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001aR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001aR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001aR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001aR\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010)\u001a\u0004\b'\u0010(¨\u0006+"}, d2 = {"Lcom/bytedance/android/livesdk/schema/model/RoomDrawSchemaModel;", "Lcom/bytedance/android/livesdk/schema/interfaces/BaseSchemaModel;", "enterFromMerge", "", "enterMethod", "giftId", "popType", RemoteMessageConst.Notification.CHANNEL_ID, "businessExtra", "ecomLiveParams", "hometownCityCode", "isFirstReq", "reqParam", "bottomBarType", "", "whiteFirstLevelTagId", "", "sourceKey", "interceptFromLinkmic", "tabId", "pushTemplateId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getBottomBarType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBusinessExtra", "()Ljava/lang/String;", "getChannelId", "getEcomLiveParams", "getEnterFromMerge", "getEnterMethod", "getGiftId", "getHometownCityCode", "getInterceptFromLinkmic", "getPopType", "getPushTemplateId", "getReqParam", "getSourceKey", "getTabId", "getWhiteFirstLevelTagId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSchemaHost", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomDrawSchemaModel extends BaseSchemaModel {

    @SerializedName("relevant_category")
    private final Integer bottomBarType;

    @SerializedName("business_extra")
    private final String businessExtra;

    @SerializedName("channel_id")
    private final String channelId;

    @SerializedName(ILiveRoomPlayFragmentConstant.ENTER_ECOM_LIVE_PARAMS)
    private final String ecomLiveParams;

    @SerializedName("enter_from_merge")
    private final String enterFromMerge;

    @SerializedName("enter_method")
    private final String enterMethod;

    @SerializedName(ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID)
    private final String giftId;

    @SerializedName("hometown_city_code")
    private final String hometownCityCode;

    @SerializedName("intercept_from_linkmic")
    private final Integer interceptFromLinkmic;

    @SerializedName("is_first_req")
    private final String isFirstReq;

    @SerializedName(ILiveRoomPlayFragmentConstant.ENTER_LIVE_POP_TYPE)
    private final String popType;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID)
    private final String pushTemplateId;

    @SerializedName("req_param")
    private final String reqParam;

    @SerializedName(FeedApi.SOURCE_KEY)
    private final String sourceKey;

    @SerializedName("tab_id")
    private final String tabId;

    @SerializedName("white_cate_first_level_tag_id")
    private final Long whiteFirstLevelTagId;

    @Override // com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel
    public String getSchemaHost() {
        return SchemaHandlerHostConstants.LIVE_ROOM_DRAW_SCHEMA_HOST;
    }

    public final Integer getBottomBarType() {
        return this.bottomBarType;
    }

    public final String getBusinessExtra() {
        return this.businessExtra;
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final String getEcomLiveParams() {
        return this.ecomLiveParams;
    }

    public final String getEnterFromMerge() {
        return this.enterFromMerge;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final String getGiftId() {
        return this.giftId;
    }

    public final String getHometownCityCode() {
        return this.hometownCityCode;
    }

    public final Integer getInterceptFromLinkmic() {
        return this.interceptFromLinkmic;
    }

    public final String getPopType() {
        return this.popType;
    }

    public final String getPushTemplateId() {
        return this.pushTemplateId;
    }

    public final String getReqParam() {
        return this.reqParam;
    }

    public final String getSourceKey() {
        return this.sourceKey;
    }

    public final String getTabId() {
        return this.tabId;
    }

    public final Long getWhiteFirstLevelTagId() {
        return this.whiteFirstLevelTagId;
    }

    public final String isFirstReq() {
        return this.isFirstReq;
    }

    public RoomDrawSchemaModel(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r110, String r111, String r112, Integer r113, Long r114, String r115, Integer r116, String r117, String r118) {
        this.enterFromMerge = r100;
        this.enterMethod = r101;
        this.giftId = r102;
        this.popType = r103;
        this.channelId = r104;
        this.businessExtra = r105;
        this.ecomLiveParams = r106;
        this.hometownCityCode = r110;
        this.isFirstReq = r111;
        this.reqParam = r112;
        this.bottomBarType = r113;
        this.whiteFirstLevelTagId = r114;
        this.sourceKey = r115;
        this.interceptFromLinkmic = r116;
        this.tabId = r117;
        this.pushTemplateId = r118;
    }
}
