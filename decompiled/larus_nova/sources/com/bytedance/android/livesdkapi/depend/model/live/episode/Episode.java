package com.bytedance.android.livesdkapi.depend.model.live.episode;

import android.text.TextUtils;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.matchroom.EpisodeBasicInfo;
import com.bytedance.android.livesdkapi.util.KotlinTypeUtilsKt;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoDecode;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import py.k;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class Episode extends FlexModelBase<IEpisode> implements IEpisode {

    @SerializedName("attach_room_id")
    public long attachRoomId;

    @SerializedName("attach_room_id_str")
    public String attachRoomIdStr;

    @SerializedName("background")
    public k background;

    @SerializedName("brief_info_json")
    public String briefInfoJson;

    @SerializedName("collected")
    public boolean collected;

    @SerializedName("item_comment_icon")
    public k commentIcon;

    @SerializedName("cover")
    k cover;

    @SerializedName("cover_vertical")
    public k coverVertical;

    @SerializedName("current_period")
    public String currentPeriod;

    @SerializedName("draw_sub_title")
    public String drawSubTitle;

    @SerializedName("episode_basic_info")
    public EpisodeBasicInfo episodeBasicInfo;

    @SerializedName("episode_correlation_season_info")
    public EpisodeCorrelationSeasonInfo episodeCorrelationSeasonInfo;

    @SerializedName("episode_extra_basic_info")
    public EpisodeExtraBasicInfo episodeExtraBasicInfo;

    @SerializedName("episode_type")
    public EpisodeMod episodeMod;

    @SerializedName("status")
    public int episodeStatus;

    @SerializedName("stats")
    public EpisodeStats episodeTopRightStats;

    @SerializedName("watch_info")
    public EpisodeWatchInfo episodeWatchInfo;

    @SerializedName("player_extention_config")
    public String extensionConfig;

    @SerializedName("player_extention_config_h5")
    public String extensionConfigH5;

    @SerializedName("extention_using_collect")
    public boolean extensionUsingCollect;

    @SerializedName("play_control")
    public EpisodePremierePlay firstShowPlayControl;

    @SerializedName("gift_pannel")
    public VSGiftPannel giftPannel;

    @SerializedName("start_hl_first")
    public boolean highLightFirst;

    @SerializedName("highlights")
    public List<EpisodeHighLight> highlights;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("episode_id")
    long f162616id;

    @SerializedName("episode_id_str")
    public String idStr;

    @SerializedName("index_in_album_list")
    public long indexInAlbumList;

    @SerializedName("item_comment")
    public ItemComment itemComment;

    @SerializedName("item_id")
    public String itemId;

    @SerializedName("latest_period_str")
    public String lastPeriodStr;

    @SerializedName("latest_period")
    public long latestPeriod;

    @SerializedName("live_id")
    public String liveId;
    private String logPb;

    @SerializedName("comment_config")
    public CommentConfig mCommentConfig;

    @SerializedName("more_high_light_list")
    public MoreHighLightList moreHighLightList;

    @IgnoreProtoDecode
    public MoreSpectacular moreSpectacular;

    @SerializedName("multi_season_tag")
    public String multiSeasonTag;
    public boolean notReportPV;

    @SerializedName("only_ta")
    public EpisodeOnlyTaInfo onlyTaInfo;

    @SerializedName("operation_place_text_list")
    public List<String> operationPlaceTextList;

    @SerializedName("owner")
    IBaseUser owner;

    @SerializedName("paid_info")
    public EpisodePaidInfo paidInfo;

    @SerializedName("pannel_icon")
    public VSPanelIcon panelIcon;

    @SerializedName("pannel_toolbar")
    List<VSToolbarConfigData> pannelToolbarList;

    @SerializedName("current_period_raw")
    public int period;
    public long pingDuration;

    @SerializedName("priority_camera")
    public VSCameraInfo priorityCameraInfo;

    @SerializedName("relation_place_text")
    public String relationPlaceText;

    @SerializedName("release_time")
    public String releaseTime;
    private String requestId;
    public String requestLogID;

    @SerializedName("room_auth")
    IRoomAuthStatus roomAuthStatus;

    @SerializedName("room_id")
    public long roomId;

    @SerializedName("season_basic_info")
    public SeasonBasicInfo seasonBasicInfo;

    @SerializedName("season_cover")
    public k seasonCover;

    @SerializedName("season_cover_vertical")
    public k seasonCoverVertical;

    @SerializedName("season_id")
    public String seasonId;

    @SerializedName("season_pv")
    public long seasonPV;

    @SerializedName("season_type_name")
    public String seasonTypeName;

    @SerializedName("season_update_status")
    public int seasonUpdateStatus;

    @SerializedName("season_watch_info")
    public EpisodeWatchInfo seasonWatchInfo;

    @SerializedName("selection_url")
    public String selectionUrl;

    @SerializedName("share")
    public EpisodeShare share;

    @SerializedName("show_distribution_info")
    public ShowDistributionInfo showDistributionInfo;

    @SerializedName("show_experience_info")
    public ShowExperienceInfo showExperienceInfo;

    @SerializedName("show_general_info")
    public ShowGeneralInfo showGeneralInfo;

    @SerializedName("show_name")
    public String showName;

    @SerializedName("start_hl")
    public EpisodeStartHighLight startHighLight;

    @SerializedName("statistics")
    public EpisodeStatistics statistics;

    @SerializedName("style")
    public int style;

    @SerializedName("title")
    public String title;

    @SerializedName("toolbar_background_config")
    public ToolbarBackgroundConfig toolbarBackgroundConfig;

    @SerializedName("toolbar_list")
    public List<VSToolbarConfigData> toolbarList;

    @SerializedName("lynx_topic_info_url")
    public String topicInfoLynxUrl;

    @SerializedName("topic_info_url")
    public String topicInfoUrl;

    @SerializedName("topic_list")
    public List<VsTopicInfo> topicList;

    @SerializedName("user_statistics")
    public EpisodeUserStatistics userStatistics;

    @SerializedName(a.KEY_VIDEO_INFO)
    public EpisodeVideo video;

    @SerializedName("vs_bar")
    public VSBar vsBar;

    @SerializedName("vs_watermark")
    public VSWatermark vsWatermark;

    @SerializedName("watch_period_text_v2")
    public String watchPeriodTextV2;

    @SerializedName("watch_pv_raw")
    public String watchPvRaw;

    public List<Object> getDislikeReason() {
        return null;
    }

    public Episode() {
        super(IEpisode.class);
        this.highLightFirst = true;
        this.indexInAlbumList = -1;
        this.notReportPV = false;
    }

    public String getMixId() {
        return String.valueOf(this.f162616id);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisode
    public List<IVSToolbarConfigData> getPannelToolbarList() {
        return KotlinTypeUtilsKt.castElementType(this.pannelToolbarList);
    }

    public String getPlayVideoId() {
        EpisodeVideo r100 = this.video;
        if (r100 != null) goto L5;
    L7:
        return "";
    L5:
        if (r100.getVid() == null) goto L7;
        return this.video.getVid();
    }

    public String getPlayVideoModel() {
        EpisodeVideo r100 = this.video;
        if (r100 != null) goto L5;
    L9:
        return "";
    L5:
        if (r100.getPlayInfo() == null) goto L9;
        if (this.video.getPlayInfo().getJson() == null) goto L9;
        return this.video.getPlayInfo().getJson();
    }

    public boolean isMatchEpisode() {
        EpisodeMod r100 = this.episodeMod;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.episodeSubType != EpisodeMod.EpisodeSubType.MATCH) goto L10;
        return true;
    L10:
        return false;
    }

    public boolean isReplay() {
        EpisodeMod r100 = this.episodeMod;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.episodeStage != EpisodeMod.EpisodeStageType.REPLAY) goto L7;
        return true;
    }

    public boolean isStreamVideoType() {
        EpisodeVideo r100 = this.video;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isStreamVideoType() == false) goto L7;
        return true;
    }

    public boolean isSupportAIDanmaku() {
        EpisodeVideo r100 = this.video;
        if (r100 != null) goto L5;
    L11:
        return false;
    L5:
        if (r100.getPlayInfo() == null) goto L11;
        if (TextUtils.isEmpty(this.video.getPlayInfo().getJson()) == true) goto L11;
        if (this.video.isSupportSpecialEffectComment() == false) goto L11;
        return true;
    }

    public IBaseUser author() {
        return this.owner;
    }

    public k cover() {
        return this.cover;
    }

    public k getCommentIcon() {
        return this.commentIcon;
    }

    public EpisodeBasicInfo getEpisodeBasicInfo() {
        return this.episodeBasicInfo;
    }

    public EpisodeCorrelationSeasonInfo getEpisodeCorrelationSeasonInfo() {
        return this.episodeCorrelationSeasonInfo;
    }

    public EpisodeMod getEpisodeMod() {
        return this.episodeMod;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisode
    public VSGiftPannel getGiftPanel() {
        return this.giftPannel;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisode
    public long getId() {
        return this.f162616id;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisode
    public long getIdExt() {
        return this.f162616id;
    }

    public long getLatestPeriod() {
        return this.latestPeriod;
    }

    public String getLogPb() {
        return this.logPb;
    }

    public IBaseUser getOwner() {
        return this.owner;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisode
    public IBaseUser getOwnerExt() {
        return this.owner;
    }

    public VSPanelIcon getPanelIcon() {
        return this.panelIcon;
    }

    public int getPeriod() {
        return this.period;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public String getRequestLogID() {
        return this.requestLogID;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisode
    public IRoomAuthStatus getRoomAuthStatus() {
        return this.roomAuthStatus;
    }

    public long getRoomId() {
        return this.roomId;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisode
    public long getRoomIdExt() {
        return this.roomId;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisode
    public String getSeasonIdFlex() {
        return this.seasonId;
    }

    public int getSeasonUpdateStatus() {
        return this.seasonUpdateStatus;
    }

    public String getTitleOpt() {
        return this.title;
    }

    public String title() {
        return this.title;
    }

    public void setCover(k r100) {
        this.cover = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisode
    public void setId(long r100) {
        this.f162616id = r100;
    }

    public void setLogPb(String r100) {
        this.logPb = r100;
    }

    public void setOwner(IBaseUser r100) {
        this.owner = r100;
    }

    public void setPlayVideoModel(EpisodeVideo r100) {
        this.video = r100;
    }

    public void setRequestId(String r100) {
        this.requestId = r100;
    }

    public void setRequestLogID(String r100) {
        this.requestLogID = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisode
    public void setRoomAuthStatus(IRoomAuthStatus r100) {
        this.roomAuthStatus = r100;
    }
}
