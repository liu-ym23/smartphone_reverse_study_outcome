package com.bytedance.android.live.base.model.media;

import com.bytedance.android.live.base.model.share.ShareSourceInfo;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.google.gson.annotations.SerializedName;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.List;
import py.k;

/* JADX INFO: loaded from: classes45.dex */
public class Media implements IPlayable {
    public static final int CELL_STYLE_A = 1;
    public static final int CELL_STYLE_B = 2;
    public static final int CELL_STYLE_C = 3;
    public static final int MEDIA_DETAIL_TYPE_AD = 1;
    public static final int MEDIA_DETAIL_TYPE_MEDIA = 0;

    @SerializedName("ad_info")
    private MediaAdInfo adInfo;

    @SerializedName("at_users")
    private List<TextExtraStruct> aiteUserItems;

    @SerializedName("allow_comment")
    private boolean allowComment;

    @SerializedName("allow_dislike")
    private boolean allowDislike;

    @SerializedName("allow_share")
    private boolean allowShare;
    private long apiTime;

    @SerializedName("author")
    private IBaseUser author;

    @SerializedName("auto_play")
    private int autoPlay;

    @SerializedName("cell_height")
    private int cellHeight;

    @SerializedName("cell_style")
    private int cellStyle;

    @SerializedName("cell_width")
    private int cellWidth;

    @SerializedName("comment_delay")
    private int commentDelay;

    @SerializedName("comment_prompts")
    private String commentPrompts;

    @SerializedName("commerce")
    private a commerce;

    @SerializedName("create_time")
    private long createTime;
    private long danmakuShowTime;

    @SerializedName("private_info")
    private MediaDebugInfo debugInfo;

    @SerializedName("description")
    private String description;

    @SerializedName("display_style")
    private int displayStyle;

    @SerializedName("enable_send_flame")
    private boolean enableSendFlame;

    @SerializedName("feed_tips")
    private String feedTips;

    @SerializedName("feed_tips_type")
    private int feedTipsType;

    @SerializedName("from_ad")
    private boolean fromAd;

    @SerializedName("guide_card_id")
    private int guideCardId;

    @SerializedName("has_free_flame")
    private boolean hasFreeFlame;

    @SerializedName("has_sync_aweme")
    private boolean hasSyncAweme;

    @SerializedName("hashtag")
    private HashTag hashTag;

    @SerializedName("hide_nickname")
    private boolean hideNickName;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private long f58843id;
    private boolean isDeleted;

    @SerializedName("is_rich")
    private int isRich;

    @SerializedName("stats")
    private MediaItemStats itemStats;

    @SerializedName("location")
    private String location;
    private int mDetailType;

    @SerializedName("mark")
    private VideoMark mark;

    @SerializedName("recommend_reason")
    private MediaRecommendReason mediaRecommendReason;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_MEDIA_TYPE)
    private int mediaType;

    @SerializedName(Keys.API_EVENT_KEY_SONG)
    private Music music;

    @SerializedName("new_cell_style")
    private int newCellStyle;
    private boolean noNeedQuery;

    @SerializedName("position")
    private String position;

    @SerializedName("share_description")
    private String shareDesc;

    @SerializedName("share_enable")
    private boolean shareEnable;

    @SerializedName("share_prompts")
    private String sharePrompts;

    @SerializedName("share_source_info")
    private ShareSourceInfo shareSourceInfo;

    @SerializedName("share_strong_guide")
    private int shareStrongGuide;

    @SerializedName("share_text")
    private String shareText;

    @SerializedName("share_tips")
    private String shareTips;

    @SerializedName("share_title")
    private String shareTitle;

    @SerializedName("share_url")
    private String shareUrl;

    @SerializedName("status")
    private int status;

    @SerializedName("title")
    private String text;

    @SerializedName("tips")
    private String tips;

    @SerializedName("tips_url")
    private String tipsUrl;

    @SerializedName("user_bury")
    private int userBury;

    @SerializedName("user_digg")
    private int userDigg;

    @SerializedName("video")
    private VideoModel videoModel;

    @SerializedName("video_pic_num")
    private int videoPicNum;

    @SerializedName("weibo_share_title")
    private String weiboShareTitle;

    public @interface MediaDetailType {
    }

    @Override // com.bytedance.android.live.base.model.media.IPlayable
    public String getPlayKey() {
        return null;
    }

    public boolean isNativeAd() {
        return false;
    }

    @Override // com.bytedance.android.live.base.model.media.IPlayable
    public k getVideoCoverImage() {
        VideoModel r100 = this.videoModel;
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.getCoverType() == VideoModel.CoverType.MEDIUM) goto L8;
        return this.videoModel.getCoverModel();
    L8:
        return this.videoModel.getCoverMediumModel();
    }

    public Media() {
        this.mDetailType = 0;
        this.fromAd = false;
    }

    public String getAdStatus() {
        if (isNativeAd() == false) goto L6;
        return "ad";
    L6:
        if (isFromAd() == false) goto L8;
        return "normal";
    L8:
        return "";
    }

    @Override // com.bytedance.android.live.base.model.media.IPlayable
    public boolean isBitRate() {
        if (getVideoModel() != null) goto L5;
        return false;
    L5:
        if (getVideoModel().getQualityInfo() != null) goto L7;
        return false;
    L7:
        if (getVideoModel().getQualityInfo().size() <= 1) goto L12;
        return true;
    L12:
        return false;
    }

    public MediaAdInfo getAdInfo() {
        return this.adInfo;
    }

    public List<TextExtraStruct> getAiteUserItems() {
        return this.aiteUserItems;
    }

    public long getApiTime() {
        return this.apiTime;
    }

    public IBaseUser getAuthor() {
        return this.author;
    }

    public int getAutoPlay() {
        return this.autoPlay;
    }

    public int getCellHeight() {
        return this.cellHeight;
    }

    public int getCellStyle() {
        return this.cellStyle;
    }

    public int getCellWidth() {
        return this.cellWidth;
    }

    public int getCommentDelay() {
        return this.commentDelay;
    }

    public String getCommentPrompts() {
        return this.commentPrompts;
    }

    public a getCommerce() {
        return this.commerce;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public long getDanmakuShowTime() {
        return this.danmakuShowTime;
    }

    public MediaDebugInfo getDebugInfo() {
        return this.debugInfo;
    }

    public String getDescription() {
        return this.description;
    }

    public int getDetailType() {
        return this.mDetailType;
    }

    public int getDisplayStyle() {
        return this.displayStyle;
    }

    public String getFeedTips() {
        return this.feedTips;
    }

    public int getFeedTipsType() {
        return this.feedTipsType;
    }

    public int getGuideCardId() {
        return this.guideCardId;
    }

    public HashTag getHashTag() {
        return this.hashTag;
    }

    @Override // com.bytedance.android.live.base.model.media.IPlayable
    public long getId() {
        return this.f58843id;
    }

    public int getIsRich() {
        return this.isRich;
    }

    public MediaItemStats getItemStats() {
        return this.itemStats;
    }

    public String getLocation() {
        return this.location;
    }

    public VideoMark getMark() {
        return this.mark;
    }

    public MediaRecommendReason getMediaRecommendReason() {
        return this.mediaRecommendReason;
    }

    public int getMediaType() {
        return this.mediaType;
    }

    public Music getMusic() {
        return this.music;
    }

    public int getNewCellStyle() {
        return this.newCellStyle;
    }

    public String getPosition() {
        return this.position;
    }

    public String getShareDesc() {
        return this.shareDesc;
    }

    public boolean getShareEnable() {
        return this.shareEnable;
    }

    public String getSharePrompts() {
        return this.sharePrompts;
    }

    public ShareSourceInfo getShareSourceInfo() {
        return this.shareSourceInfo;
    }

    public int getShareStrongGuide() {
        return this.shareStrongGuide;
    }

    public String getShareText() {
        return this.shareText;
    }

    public String getShareTips() {
        return this.shareTips;
    }

    public String getShareTitle() {
        return this.shareTitle;
    }

    public String getShareUrl() {
        return this.shareUrl;
    }

    public int getStatus() {
        return this.status;
    }

    public String getText() {
        return this.text;
    }

    public String getTips() {
        return this.tips;
    }

    public String getTipsUrl() {
        return this.tipsUrl;
    }

    public int getUserBury() {
        return this.userBury;
    }

    public int getUserDigg() {
        return this.userDigg;
    }

    @Override // com.bytedance.android.live.base.model.media.IPlayable
    public VideoModel getVideoModel() {
        return this.videoModel;
    }

    public int getVideoPicNum() {
        return this.videoPicNum;
    }

    public String getWeiboShareTitle() {
        return this.weiboShareTitle;
    }

    public boolean isAllowComment() {
        return this.allowComment;
    }

    public boolean isAllowDislike() {
        return this.allowDislike;
    }

    public boolean isAllowShare() {
        return this.allowShare;
    }

    @Override // com.bytedance.android.live.base.model.media.IPlayable
    public boolean isDeleted() {
        return this.isDeleted;
    }

    public boolean isEnableSendFlame() {
        return this.enableSendFlame;
    }

    public boolean isFromAd() {
        return this.fromAd;
    }

    public boolean isHasFreeFlame() {
        return this.hasFreeFlame;
    }

    public boolean isHasSyncAweme() {
        return this.hasSyncAweme;
    }

    public boolean isHideNickName() {
        return this.hideNickName;
    }

    public boolean isNoNeedQuery() {
        return this.noNeedQuery;
    }

    public boolean isShareEnable() {
        return this.shareEnable;
    }

    public void setAdInfo(MediaAdInfo r100) {
        this.adInfo = r100;
    }

    public void setAiteUserItems(List<TextExtraStruct> r100) {
        this.aiteUserItems = r100;
    }

    public void setAllowComment(boolean r100) {
        this.allowComment = r100;
    }

    public void setAllowDislike(boolean r100) {
        this.allowDislike = r100;
    }

    public void setAllowShare(boolean r100) {
        this.allowShare = r100;
    }

    public void setApiTime(long r100) {
        this.apiTime = r100;
    }

    public void setAuthor(IBaseUser r100) {
        this.author = r100;
    }

    public void setAutoPlay(int r100) {
        this.autoPlay = r100;
    }

    public void setCellHeight(int r100) {
        this.cellHeight = r100;
    }

    public void setCellStyle(int r100) {
        if (r100 != 1) goto L5;
    L9:
        this.cellStyle = r100;
        return;
    L5:
        if (r100 == 2) goto L9;
        if (r100 == 3) goto L9;
        r100 = 1;
        goto L9
    }

    public void setCellWidth(int r100) {
        this.cellWidth = r100;
    }

    public void setCommentDelay(int r100) {
        this.commentDelay = r100;
    }

    public void setCommentPrompts(String r100) {
        this.commentPrompts = r100;
    }

    public void setCommerce(a r100) {
        this.commerce = r100;
    }

    public void setCreateTime(long r100) {
        this.createTime = r100;
    }

    public void setDanmakuShowTime(long r100) {
        this.danmakuShowTime = r100;
    }

    public void setDebugInfo(MediaDebugInfo r100) {
        this.debugInfo = r100;
    }

    public void setDeleted(boolean r100) {
        this.isDeleted = r100;
    }

    public void setDescription(String r100) {
        this.description = r100;
    }

    public void setDetailType(int r100) {
        this.mDetailType = r100;
    }

    public void setDisplayStyle(int r100) {
        this.displayStyle = r100;
    }

    public void setEnableSendFlame(boolean r100) {
        this.enableSendFlame = r100;
    }

    public void setFeedTips(String r100) {
        this.feedTips = r100;
    }

    public void setFeedTipsType(int r100) {
        this.feedTipsType = r100;
    }

    public void setFromAd(boolean r100) {
        this.fromAd = r100;
    }

    public void setGuideCardId(int r100) {
        this.guideCardId = r100;
    }

    public void setHasFreeFlame(boolean r100) {
        this.hasFreeFlame = r100;
    }

    public void setHasSyncAweme(boolean r100) {
        this.hasSyncAweme = r100;
    }

    public void setHashTag(HashTag r100) {
        this.hashTag = r100;
    }

    public void setHideNickName(boolean r100) {
        this.hideNickName = r100;
    }

    public void setId(long r100) {
        this.f58843id = r100;
    }

    public void setIsRich(int r100) {
        this.isRich = r100;
    }

    public void setItemStats(MediaItemStats r100) {
        this.itemStats = r100;
    }

    public void setLocation(String r100) {
        this.location = r100;
    }

    public void setMark(VideoMark r100) {
        this.mark = r100;
    }

    public void setMediaRecommendReason(MediaRecommendReason r100) {
        this.mediaRecommendReason = r100;
    }

    public void setMediaType(int r100) {
        this.mediaType = r100;
    }

    public void setMusic(Music r100) {
        this.music = r100;
    }

    public void setNewCellStyle(int r100) {
        this.newCellStyle = r100;
    }

    public void setNoNeedQuery(boolean r100) {
        this.noNeedQuery = r100;
    }

    public void setPosition(String r100) {
        this.position = r100;
    }

    public void setShareDesc(String r100) {
        this.shareDesc = r100;
    }

    public void setShareEnable(boolean r100) {
        this.shareEnable = r100;
    }

    public void setSharePrompts(String r100) {
        this.sharePrompts = r100;
    }

    public void setShareSourceInfo(ShareSourceInfo r100) {
        this.shareSourceInfo = r100;
    }

    public void setShareStrongGuide(int r100) {
        this.shareStrongGuide = r100;
    }

    public void setShareText(String r100) {
        this.shareText = r100;
    }

    public void setShareTips(String r100) {
        this.shareTips = r100;
    }

    public void setShareTitle(String r100) {
        this.shareTitle = r100;
    }

    public void setShareUrl(String r100) {
        this.shareUrl = r100;
    }

    public void setStatus(int r100) {
        this.status = r100;
    }

    public void setText(String r100) {
        this.text = r100;
    }

    public void setTips(String r100) {
        this.tips = r100;
    }

    public void setTipsUrl(String r100) {
        this.tipsUrl = r100;
    }

    public void setUserBury(int r100) {
        this.userBury = r100;
    }

    public void setUserDigg(int r100) {
        this.userDigg = r100;
    }

    public void setVideoModel(VideoModel r100) {
        this.videoModel = r100;
    }

    public void setVideoPicNum(int r100) {
        this.videoPicNum = r100;
    }

    public void setWeiboShareTitle(String r100) {
        this.weiboShareTitle = r100;
    }

    public void update(Media r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.getId() == this.f58843id) goto L7;
        return;
    L7:
        this.text = r100.text;
        this.createTime = r100.createTime;
        this.userDigg = r100.userDigg;
        this.userBury = r100.userBury;
        this.mediaType = r100.mediaType;
        this.status = r100.status;
        updateItemStats(r100.itemStats);
        IBaseUser r101 = r100.author;
        if (r101 == null) goto L10;
        this.author = r101;
    L10:
        VideoModel r102 = r100.videoModel;
        if (r102 == null) goto L13;
        this.videoModel = r102;
    L13:
        this.shareUrl = r100.shareUrl;
        this.shareTitle = r100.shareTitle;
        this.shareDesc = r100.shareDesc;
        this.shareEnable = r100.shareEnable;
        this.allowShare = r100.allowShare;
        this.allowComment = r100.allowComment;
        this.allowDislike = r100.allowDislike;
        this.cellStyle = r100.cellStyle;
        this.tips = r100.tips;
        this.tipsUrl = r100.tipsUrl;
        MediaDebugInfo r103 = r100.debugInfo;
        if (r103 == null) goto L16;
        this.debugInfo = r103;
    L16:
        VideoMark r104 = r100.mark;
        if (r104 == null) goto L19;
        this.mark = r104;
    L19:
        this.shareText = r100.shareText;
        this.cellHeight = r100.cellHeight;
        this.cellWidth = r100.cellWidth;
        this.feedTipsType = r100.feedTipsType;
        this.feedTips = r100.feedTips;
        this.location = r100.location;
        this.displayStyle = r100.displayStyle;
        this.commentDelay = r100.commentDelay;
        this.guideCardId = r100.guideCardId;
        this.sharePrompts = r100.sharePrompts;
        this.commentPrompts = r100.commentPrompts;
        this.weiboShareTitle = r100.weiboShareTitle;
        this.shareTips = r100.shareTips;
        this.enableSendFlame = r100.enableSendFlame;
        this.hideNickName = r100.hideNickName;
        this.music = r100.music;
        this.videoPicNum = r100.videoPicNum;
        this.apiTime = r100.getApiTime();
        this.noNeedQuery = r100.noNeedQuery;
        a r105 = r100.commerce;
        if (r105 == null) goto L23;
        this.commerce = r105;
        return;
    }

    public void updateItemStats(MediaItemStats r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        MediaItemStats r101 = this.itemStats;
        if (r101 != null) goto L7;
        this.itemStats = r100;
        return;
    L7:
        r101.setCommentCount(r100.getCommentCount());
        this.itemStats.setDiggCount(Math.max(r100.getDiggCount(), this.itemStats.getDiggCount()));
        this.itemStats.setPlayCount(Math.max(r100.getPlayCount(), this.itemStats.getPlayCount()));
        this.itemStats.setShareCount(Math.max(r100.getShareCount(), this.itemStats.getShareCount()));
    }
}
