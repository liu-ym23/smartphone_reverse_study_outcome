package com.bytedance.android.livesdk.schema.model;

import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.bytedance.android.livesdk.schema.constants.SchemaHandlerHostConstants;
import com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b9\b\u0007\u0018\u00002\u00020\u0001B§\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010 J\b\u0010;\u001a\u00020\u0003H\u0016R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\"R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\"R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\"R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\"R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\"R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\"R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\"R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\"R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\"R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\"R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\"R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\"R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\"R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\"R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\"R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\"R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\"R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\"R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\"R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\"R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\"R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\"R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\"R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\"R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\"R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\"R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\"¨\u0006<"}, d2 = {"Lcom/bytedance/android/livesdk/schema/model/AudienceGamePromoteDetailSchemaModel;", "Lcom/bytedance/android/livesdk/schema/interfaces/BaseSchemaModel;", "gameId", "", "enterFrom", "reportParams", "gameStage", "videoId", "promoterId", "roomId", "promoterScene", "bizType", "bizId", "isFullScreen", "canHalfscreen", "useBackIcon", "defaultTabId", "bizMode", "twoPartReserve", "isRsvp", "reserveId", "allChannelInstallEnable", "trackId", "tabControlMsg", "promoteInstanceId", "isLiveCellReport", "isInPreviewExp", "supportTransfer", "extra", "preloadLynxCardIds", "disableCacheData", "prefixCacheKey", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAllChannelInstallEnable", "()Ljava/lang/String;", "getBizId", "getBizMode", "getBizType", "getCanHalfscreen", "getDefaultTabId", "getDisableCacheData", "getEnterFrom", "getExtra", "getGameId", "getGameStage", "getPrefixCacheKey", "getPreloadLynxCardIds", "getPromoteInstanceId", "getPromoterId", "getPromoterScene", "getReportParams", "getReserveId", "getRoomId", "getSupportTransfer", "getTabControlMsg", "getTrackId", "getTwoPartReserve", "getUseBackIcon", "getVideoId", "getSchemaHost", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudienceGamePromoteDetailSchemaModel extends BaseSchemaModel {

    @SerializedName(AudienceGamePromoteDetailActionHandler.PARA_ALL_CHANNEL_INSTALL_ENABLE)
    private final String allChannelInstallEnable;

    @SerializedName(AudienceGamePromoteDetailActionHandler.PARA_BIZ_ID)
    private final String bizId;

    @SerializedName(AudienceGamePromoteDetailActionHandler.PARA_BIZ_MODE)
    private final String bizMode;

    @SerializedName("biz_type")
    private final String bizType;

    @SerializedName(AudienceGamePromoteDetailActionHandler.PARA_CAN_HALFSCREEN)
    private final String canHalfscreen;

    @SerializedName(AudienceGamePromoteDetailActionHandler.PARA_DEFAULT_TAB_ID)
    private final String defaultTabId;

    @SerializedName(AudienceGamePromoteDetailActionHandler.DISABLE_CACHE_DATA)
    private final String disableCacheData;

    @SerializedName("enter_from")
    private final String enterFrom;

    @SerializedName("extra")
    private final String extra;

    @SerializedName("game_id")
    private final String gameId;

    @SerializedName(AudienceGamePromoteDetailActionHandler.PARA_GAME_STAGE)
    private final String gameStage;

    @SerializedName("is_fullscreen")
    private final String isFullScreen;

    @SerializedName(AudienceGamePromoteDetailActionHandler.PARA_IS_IN_PREVIEW_EXP)
    private final String isInPreviewExp;

    @SerializedName(AudienceGamePromoteDetailActionHandler.PARA_IS_LIVE_CELL_REPORT)
    private final String isLiveCellReport;

    @SerializedName(AudienceGamePromoteDetailActionHandler.PARA_IS_RSVP)
    private final String isRsvp;

    @SerializedName(AudienceGamePromoteDetailActionHandler.PREFIX_CACHE_KEY)
    private final String prefixCacheKey;

    @SerializedName(AudienceGamePromoteDetailActionHandler.PRELOAD_LYNX_CARD_IDS)
    private final String preloadLynxCardIds;

    @SerializedName(AudienceGamePromoteDetailActionHandler.PROMOTE_INSTANCE_ID)
    private final String promoteInstanceId;

    @SerializedName(AudienceGamePromoteDetailActionHandler.PARA_PROMOTER_ID)
    private final String promoterId;

    @SerializedName(AudienceGamePromoteDetailActionHandler.PARA_PROMOTER_SCENE)
    private final String promoterScene;

    @SerializedName("report_params")
    private final String reportParams;

    @SerializedName(AudienceGamePromoteDetailActionHandler.PARA_RESERVE_ID)
    private final String reserveId;

    @SerializedName("roomId")
    private final String roomId;

    @SerializedName(AudienceGamePromoteDetailActionHandler.PARA_SUPPORT_TRANSFER)
    private final String supportTransfer;

    @SerializedName(AudienceGamePromoteDetailActionHandler.PARA_TAB_CONTROL_MSG)
    private final String tabControlMsg;

    @SerializedName("client_track_id")
    private final String trackId;

    @SerializedName(AudienceGamePromoteDetailActionHandler.PARA_TWO_PART_RESERVE)
    private final String twoPartReserve;

    @SerializedName(AudienceGamePromoteDetailActionHandler.PARA_USE_BACK_ICON)
    private final String useBackIcon;

    @SerializedName("video_id")
    private final String videoId;

    @Override // com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel
    public String getSchemaHost() {
        return SchemaHandlerHostConstants.AUDIENCE_GAME_PROMOTE_DETAIL_SCHEMA_HOST;
    }

    public final String getAllChannelInstallEnable() {
        return this.allChannelInstallEnable;
    }

    public final String getBizId() {
        return this.bizId;
    }

    public final String getBizMode() {
        return this.bizMode;
    }

    public final String getBizType() {
        return this.bizType;
    }

    public final String getCanHalfscreen() {
        return this.canHalfscreen;
    }

    public final String getDefaultTabId() {
        return this.defaultTabId;
    }

    public final String getDisableCacheData() {
        return this.disableCacheData;
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final String getGameId() {
        return this.gameId;
    }

    public final String getGameStage() {
        return this.gameStage;
    }

    public final String getPrefixCacheKey() {
        return this.prefixCacheKey;
    }

    public final String getPreloadLynxCardIds() {
        return this.preloadLynxCardIds;
    }

    public final String getPromoteInstanceId() {
        return this.promoteInstanceId;
    }

    public final String getPromoterId() {
        return this.promoterId;
    }

    public final String getPromoterScene() {
        return this.promoterScene;
    }

    public final String getReportParams() {
        return this.reportParams;
    }

    public final String getReserveId() {
        return this.reserveId;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final String getSupportTransfer() {
        return this.supportTransfer;
    }

    public final String getTabControlMsg() {
        return this.tabControlMsg;
    }

    public final String getTrackId() {
        return this.trackId;
    }

    public final String getTwoPartReserve() {
        return this.twoPartReserve;
    }

    public final String getUseBackIcon() {
        return this.useBackIcon;
    }

    public final String getVideoId() {
        return this.videoId;
    }

    public final String isFullScreen() {
        return this.isFullScreen;
    }

    public final String isInPreviewExp() {
        return this.isInPreviewExp;
    }

    public final String isLiveCellReport() {
        return this.isLiveCellReport;
    }

    public final String isRsvp() {
        return this.isRsvp;
    }

    public AudienceGamePromoteDetailSchemaModel(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117, String r118, String r119, String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, String r219, String r310, String r311) {
        this.gameId = r100;
        this.enterFrom = r101;
        this.reportParams = r102;
        this.gameStage = r103;
        this.videoId = r104;
        this.promoterId = r105;
        this.roomId = r106;
        this.promoterScene = r110;
        this.bizType = r111;
        this.bizId = r112;
        this.isFullScreen = r113;
        this.canHalfscreen = r114;
        this.useBackIcon = r115;
        this.defaultTabId = r116;
        this.bizMode = r117;
        this.twoPartReserve = r118;
        this.isRsvp = r119;
        this.reserveId = r210;
        this.allChannelInstallEnable = r211;
        this.trackId = r212;
        this.tabControlMsg = r213;
        this.promoteInstanceId = r214;
        this.isLiveCellReport = r215;
        this.isInPreviewExp = r216;
        this.supportTransfer = r217;
        this.extra = r218;
        this.preloadLynxCardIds = r219;
        this.disableCacheData = r310;
        this.prefixCacheKey = r311;
    }
}
