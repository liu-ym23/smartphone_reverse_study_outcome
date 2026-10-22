package com.bytedance.android.livesdk.schema.model;

import com.bytedance.android.livesdk.schema.constants.SchemaHandlerHostConstants;
import com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.minigame.SeiMessageConst;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001d\b\u0007\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0010J\b\u0010\u001f\u001a\u00020\u0003H\u0016R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0012¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/schema/model/OfficialRoomSchemaModel;", "Lcom/bytedance/android/livesdk/schema/interfaces/BaseSchemaModel;", "userId", "", "creativeId", "logExtra", "enterLiveSource", "enterFromV3", "enterMethod", "enterFromMerge", "enterFromModule", "msgType", "giftId", AppConstants.BUNDLE_TIP, "videoId", "tipI18n", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCreativeId", "()Ljava/lang/String;", "getEnterFromMerge", "getEnterFromModule", "getEnterFromV3", "getEnterLiveSource", "getEnterMethod", "getGiftId", "getLogExtra", "getMsgType", "getTip", "getTipI18n", "getUserId", "getVideoId", "getSchemaHost", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OfficialRoomSchemaModel extends BaseSchemaModel {

    @SerializedName("creative_id")
    private final String creativeId;

    @SerializedName("enter_from_merge")
    private final String enterFromMerge;

    @SerializedName("enter_from_module")
    private final String enterFromModule;

    @SerializedName("enter_from_v3")
    private final String enterFromV3;

    @SerializedName("enter_live_source")
    private final String enterLiveSource;

    @SerializedName("enter_method")
    private final String enterMethod;

    @SerializedName(ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID)
    private final String giftId;

    @SerializedName("log_extra")
    private final String logExtra;

    @SerializedName(SeiMessageConst.MSG_TYPE)
    private final String msgType;

    @SerializedName(AppConstants.BUNDLE_TIP)
    private final String tip;

    @SerializedName("tip_i18n")
    private final String tipI18n;

    @SerializedName("user_id")
    private final String userId;

    @SerializedName("video_id")
    private final String videoId;

    @Override // com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel
    public String getSchemaHost() {
        return SchemaHandlerHostConstants.OFFICIAL_CHANNEL_ROOM_SCHEMA_HOST;
    }

    public final String getCreativeId() {
        return this.creativeId;
    }

    public final String getEnterFromMerge() {
        return this.enterFromMerge;
    }

    public final String getEnterFromModule() {
        return this.enterFromModule;
    }

    public final String getEnterFromV3() {
        return this.enterFromV3;
    }

    public final String getEnterLiveSource() {
        return this.enterLiveSource;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final String getGiftId() {
        return this.giftId;
    }

    public final String getLogExtra() {
        return this.logExtra;
    }

    public final String getMsgType() {
        return this.msgType;
    }

    public final String getTip() {
        return this.tip;
    }

    public final String getTipI18n() {
        return this.tipI18n;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getVideoId() {
        return this.videoId;
    }

    public OfficialRoomSchemaModel(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r108, String r110, String r111, String r112, String r113) {
        this.userId = r100;
        this.creativeId = r101;
        this.logExtra = r102;
        this.enterLiveSource = r103;
        this.enterFromV3 = r104;
        this.enterMethod = r105;
        this.enterFromMerge = r106;
        this.enterFromModule = r107;
        this.msgType = r108;
        this.giftId = r110;
        this.tip = r111;
        this.videoId = r112;
        this.tipI18n = r113;
    }
}
