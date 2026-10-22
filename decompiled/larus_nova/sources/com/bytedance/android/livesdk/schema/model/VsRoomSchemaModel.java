package com.bytedance.android.livesdk.schema.model;

import com.bytedance.android.livehostapi.business.depend.share.ShareConstants;
import com.bytedance.android.livesdk.schema.constants.SchemaHandlerHostConstants;
import com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\bT\b\u0007\u0018\u00002\u00020\u0001B\u009f\u0003\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010)\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010+\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010,J\b\u0010U\u001a\u00020\u0003H\u0016J\b\u0010V\u001a\u00020\u0003H\u0016R\u0018\u0010&\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010.R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010.R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010.R\u0018\u0010%\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010.R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010.R\u0018\u0010(\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010.R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010.R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010.R\u0018\u0010*\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010.R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010.R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010.R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010.R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010.R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010.R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010.R\u0018\u0010$\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010.R\u0018\u0010'\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010.R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010.R\u0018\u0010)\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010.R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010.R\u0018\u0010 \u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010.R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010.R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010.R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010.R\u0018\u0010+\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010.R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010.R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010.R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010.R\u0018\u0010#\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u0010.R\u0018\u0010\"\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010.R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u0010.R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bL\u0010.R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u0010.R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bN\u0010.R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bO\u0010.R\u0018\u0010!\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bP\u0010.R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010.R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bR\u0010.R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bS\u0010.R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bT\u0010.¨\u0006W"}, d2 = {"Lcom/bytedance/android/livesdk/schema/model/VsRoomSchemaModel;", "Lcom/bytedance/android/livesdk/schema/interfaces/BaseSchemaModel;", "episodeStage", "", "enterFromMerge", "enterMethod", "enterFrom", "episodeId", "roomId", "vsWatchRecord", "sendShowEventInside", "startLocation", "backActivityUrl", "isSingleRoom", ShortVideoSegments.KEY_CAMERA_ID, "startHighlight", "standard", "startHlFirst", SocialConstants.PARAM_APP_DESC, "enterFromAdType", "enterLiveSource", "enterFromV3", "previousPage", "vsFromOthersHomepageUid", "vsExtensionType", "popType", "vsPanelUrl", "requestId", "logPb", "searchParams", "carrySearchParams", "pushType", "orientation", "userId", "secUserId", "secUid", "formatCenterPosition", "creativeId", "adId", "isOtherChannel", "douplusChannel", "logExtra", "enterFromDouPlus", "replayId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAdId", "()Ljava/lang/String;", "getBackActivityUrl", "getCameraId", "getCarrySearchParams", "getCreativeId", "getDesc", "getDouplusChannel", "getEnterFrom", "getEnterFromAdType", "getEnterFromDouPlus", "getEnterFromMerge", "getEnterFromV3", "getEnterLiveSource", "getEnterMethod", "getEpisodeId", "getEpisodeStage", "getFormatCenterPosition", "getLogExtra", "getLogPb", "getOrientation", "getPopType", "getPreviousPage", "getPushType", "getReplayId", "getRequestId", "getRoomId", "getSearchParams", "getSecUid", "getSecUserId", "getSendShowEventInside", "getStandard", "getStartHighlight", "getStartHlFirst", "getStartLocation", "getUserId", "getVsExtensionType", "getVsFromOthersHomepageUid", "getVsPanelUrl", "getVsWatchRecord", "getSchemaHost", "subSchemaHost", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VsRoomSchemaModel extends BaseSchemaModel {

    @SerializedName("ad_id")
    private final String adId;

    @SerializedName("back_activity_url")
    private final String backActivityUrl;

    @SerializedName(VSConstants.VS_CAMERA_ID)
    private final String cameraId;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_CARRY_SEARCH_PARAMS)
    private final String carrySearchParams;

    @SerializedName("creative_id")
    private final String creativeId;

    @SerializedName(SocialConstants.PARAM_APP_DESC)
    private final String desc;

    @SerializedName("douplus_channel")
    private final String douplusChannel;

    @SerializedName("enter_from")
    private final String enterFrom;

    @SerializedName("enter_from_ad_type")
    private final String enterFromAdType;

    @SerializedName("enter_from_dou_plus")
    private final String enterFromDouPlus;

    @SerializedName("enter_from_merge")
    private final String enterFromMerge;

    @SerializedName("enter_from_v3")
    private final String enterFromV3;

    @SerializedName("enter_live_source")
    private final String enterLiveSource;

    @SerializedName("enter_method")
    private final String enterMethod;

    @SerializedName("episode_id")
    private final String episodeId;

    @SerializedName("episode_stage")
    private final String episodeStage;

    @SerializedName("format_center_position")
    private final String formatCenterPosition;

    @SerializedName("is_other_channel")
    private final String isOtherChannel;

    @SerializedName("is_single_room")
    private final String isSingleRoom;

    @SerializedName("log_extra")
    private final String logExtra;

    @SerializedName("log_pb")
    private final String logPb;

    @SerializedName("orientation")
    private final String orientation;

    @SerializedName(ILiveRoomPlayFragmentConstant.ENTER_LIVE_POP_TYPE)
    private final String popType;

    @SerializedName("previous_page")
    private final String previousPage;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_PUSH_TYPE)
    private final String pushType;

    @SerializedName(ShareConstants.REPLAY_ID)
    private final String replayId;

    @SerializedName("request_id")
    private final String requestId;

    @SerializedName("room_id")
    private final String roomId;

    @SerializedName("search_params")
    private final String searchParams;

    @SerializedName("sec_uid")
    private final String secUid;

    @SerializedName("sec_user_id")
    private final String secUserId;

    @SerializedName("send_show_event_inside")
    private final String sendShowEventInside;

    @SerializedName("standard")
    private final String standard;

    @SerializedName("start_highlight")
    private final String startHighlight;

    @SerializedName("start_hl_first")
    private final String startHlFirst;

    @SerializedName("start_location")
    private final String startLocation;

    @SerializedName("user_id")
    private final String userId;

    @SerializedName("vs_extension_type")
    private final String vsExtensionType;

    @SerializedName("vs_from_others_homepage_uid")
    private final String vsFromOthersHomepageUid;

    @SerializedName(ILiveRoomPlayFragmentConstant.ENTER_VS_POP_PANEL_URL)
    private final String vsPanelUrl;

    @SerializedName("vs_watch_record")
    private final String vsWatchRecord;

    @Override // com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel
    public String getSchemaHost() {
        return SchemaHandlerHostConstants.VS_ROOM_SCHEMA_HOST;
    }

    @Override // com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel
    public String subSchemaHost() {
        return SchemaHandlerHostConstants.VS_DRAW_SCHEMA_HOST;
    }

    public final String getAdId() {
        return this.adId;
    }

    public final String getBackActivityUrl() {
        return this.backActivityUrl;
    }

    public final String getCameraId() {
        return this.cameraId;
    }

    public final String getCarrySearchParams() {
        return this.carrySearchParams;
    }

    public final String getCreativeId() {
        return this.creativeId;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getDouplusChannel() {
        return this.douplusChannel;
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final String getEnterFromAdType() {
        return this.enterFromAdType;
    }

    public final String getEnterFromDouPlus() {
        return this.enterFromDouPlus;
    }

    public final String getEnterFromMerge() {
        return this.enterFromMerge;
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

    public final String getEpisodeId() {
        return this.episodeId;
    }

    public final String getEpisodeStage() {
        return this.episodeStage;
    }

    public final String getFormatCenterPosition() {
        return this.formatCenterPosition;
    }

    public final String getLogExtra() {
        return this.logExtra;
    }

    public final String getLogPb() {
        return this.logPb;
    }

    public final String getOrientation() {
        return this.orientation;
    }

    public final String getPopType() {
        return this.popType;
    }

    public final String getPreviousPage() {
        return this.previousPage;
    }

    public final String getPushType() {
        return this.pushType;
    }

    public final String getReplayId() {
        return this.replayId;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final String getSearchParams() {
        return this.searchParams;
    }

    public final String getSecUid() {
        return this.secUid;
    }

    public final String getSecUserId() {
        return this.secUserId;
    }

    public final String getSendShowEventInside() {
        return this.sendShowEventInside;
    }

    public final String getStandard() {
        return this.standard;
    }

    public final String getStartHighlight() {
        return this.startHighlight;
    }

    public final String getStartHlFirst() {
        return this.startHlFirst;
    }

    public final String getStartLocation() {
        return this.startLocation;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getVsExtensionType() {
        return this.vsExtensionType;
    }

    public final String getVsFromOthersHomepageUid() {
        return this.vsFromOthersHomepageUid;
    }

    public final String getVsPanelUrl() {
        return this.vsPanelUrl;
    }

    public final String getVsWatchRecord() {
        return this.vsWatchRecord;
    }

    public final String isOtherChannel() {
        return this.isOtherChannel;
    }

    public final String isSingleRoom() {
        return this.isSingleRoom;
    }

    public VsRoomSchemaModel(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117, String r118, String r119, String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, String r219, String r310, String r311, String r312, String r313, String r314, String r315, String r316, String r317, String r318, String r319, String r410, String r411, String r412, String r413) {
        this.episodeStage = r100;
        this.enterFromMerge = r101;
        this.enterMethod = r102;
        this.enterFrom = r103;
        this.episodeId = r104;
        this.roomId = r105;
        this.vsWatchRecord = r106;
        this.sendShowEventInside = r110;
        this.startLocation = r111;
        this.backActivityUrl = r112;
        this.isSingleRoom = r113;
        this.cameraId = r114;
        this.startHighlight = r115;
        this.standard = r116;
        this.startHlFirst = r117;
        this.desc = r118;
        this.enterFromAdType = r119;
        this.enterLiveSource = r210;
        this.enterFromV3 = r211;
        this.previousPage = r212;
        this.vsFromOthersHomepageUid = r213;
        this.vsExtensionType = r214;
        this.popType = r215;
        this.vsPanelUrl = r216;
        this.requestId = r217;
        this.logPb = r218;
        this.searchParams = r219;
        this.carrySearchParams = r310;
        this.pushType = r311;
        this.orientation = r312;
        this.userId = r313;
        this.secUserId = r314;
        this.secUid = r315;
        this.formatCenterPosition = r316;
        this.creativeId = r317;
        this.adId = r318;
        this.isOtherChannel = r319;
        this.douplusChannel = r410;
        this.logExtra = r411;
        this.enterFromDouPlus = r412;
        this.replayId = r413;
    }
}
