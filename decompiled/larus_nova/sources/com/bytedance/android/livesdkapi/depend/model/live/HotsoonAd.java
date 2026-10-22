package com.bytedance.android.livesdkapi.depend.model.live;

import android.text.TextUtils;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.Item;
import com.bytedance.android.live.base.model.user.IUser;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public class HotsoonAd implements Item {
    public static final int DISPLAY_PICTURE = 1;
    public static final int DISPLAY_POSITION_INVALID = 0;
    public static final int DISPLAY_POSITION_LIVE_FEED = 1;
    public static final int DISPLAY_VIDEO = 0;

    @SerializedName("allow_comment")
    private boolean allowComment;

    @SerializedName("allow_dislike")
    private boolean allowDislike;

    @SerializedName("allow_share")
    private boolean allowShare;

    @SerializedName("app_name")
    private String appName;

    @SerializedName("appleid")
    private String appleId;

    @SerializedName("author")
    private AuthorInfo author;

    @SerializedName("auto_open")
    private int autoOpen;

    @SerializedName("button_text")
    private String buttonText;

    @SerializedName("click_track_url_list")
    private List<String> clickTrackUrlList;

    @SerializedName("digg_count")
    private long diggCount;

    @SerializedName("display_type")
    private int displayType;

    @SerializedName("download_url")
    private String downloadUrl;

    @SerializedName("effective_play_time")
    private int effectivePlayTime;

    @SerializedName("effective_play_track_url_list")
    private List<String> effectivePlayTrackUrlList;

    @SerializedName("filter_words")
    private List<FilterWord> filterWords;

    @SerializedName("hide_if_exists")
    private int hideIfExists;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private long f162583id;

    @SerializedName("image_list")
    private List<SimpleImage> imageList;

    @SerializedName("label")
    private String label;

    @SerializedName("learn_more_bg_color")
    private String learnMoreBgColor;

    @SerializedName("log_extra")
    private String logExtra;
    private String log_pb;

    @SerializedName("open_url")
    private String openUrl;

    @SerializedName("package")
    private String packages;

    @SerializedName("play_track_url_list")
    private List<String> playTrackUrlList;

    @SerializedName("playover_track_url_list")
    private List<String> playover_track_url_list;
    private String requestId;

    @SerializedName("show_button_seconds")
    private int showButtonSeconds;

    @SerializedName("show_mask_times")
    private int showMaskTimes;
    private long subId;

    @SerializedName("title")
    private String title;

    @SerializedName("track_url_list")
    private List<String> trackUrlList;

    @SerializedName("type")
    private String type;

    @SerializedName("use_compound_land_page")
    private boolean useCompoundLandPage;

    @SerializedName(a.KEY_VIDEO_INFO)
    private VideoInfo videoInfo;

    @SerializedName(BytedCertConstant.WebInfo.WEB_TITLE)
    private String webTitle;

    @SerializedName("web_url")
    private String webUrl;

    public static class ActionType {
        public static final int CONVERT_CLICK = 4;
        public static final int OPEN_LANDING_PAGE = 3;
        public static final int OPEN_VIDEO_DETAIL = 2;
        public static final int OPEN_WEB = 1;

        public ActionType() {
        }
    }

    public static class AdType {
        public static final String TYPE_APP = "app";

        public AdType() {
        }
    }

    public static class AuthorInfo {

        @SerializedName("avatar")
        private SimpleImage avatar;

        @SerializedName(InstantPlayContext.NICKNAME)
        private String nickname;

        public AuthorInfo() {
        }
    }

    public static class FilterWord {
        public FilterWord() {
        }
    }

    public @interface HotsoonAdDisplayPosition {
    }

    public static class SimpleImage {

        @SerializedName("height")
        private int height;

        @SerializedName("uri")
        private String uri;

        @SerializedName(ScoreTags.STAR_URL_LIST)
        private List<String> urlList;

        @SerializedName("width")
        private int width;

        public SimpleImage() {
        }

        public int getHeight() {
            return this.height;
        }

        public String getUri() {
            return this.uri;
        }

        public List<String> getUrlList() {
            return this.urlList;
        }

        public int getWidth() {
            return this.width;
        }

        public void setHeight(int r100) {
            this.height = r100;
        }

        public void setUri(String r100) {
            this.uri = r100;
        }

        public void setUrlList(List<String> r100) {
            this.urlList = r100;
        }

        public void setWidth(int r100) {
            this.width = r100;
        }
    }

    public static class VideoInfo {

        @SerializedName(ScoreTags.STAR_URL_LIST)
        private List<String> stringList;

        @SerializedName("thumb_height")
        private int thumbHeight;

        @SerializedName("thumb_width")
        private int thumbWidth;

        @SerializedName("video_duration")
        private int videoDuration;

        @SerializedName("video_id")
        private String videoId;

        @SerializedName("video_transpose")
        private int videoTranspose;

        public VideoInfo() {
        }

        public List<String> getStringList() {
            return this.stringList;
        }

        public int getThumbHeight() {
            return this.thumbHeight;
        }

        public int getThumbWidth() {
            return this.thumbWidth;
        }

        public int getVideoDuration() {
            return this.videoDuration;
        }

        public String getVideoId() {
            return this.videoId;
        }

        public int getVideoTranspose() {
            return this.videoTranspose;
        }

        public void setStringList(List<String> r100) {
            this.stringList = r100;
        }

        public void setThumbHeight(int r100) {
            this.thumbHeight = r100;
        }

        public void setThumbWidth(int r100) {
            this.thumbWidth = r100;
        }

        public void setVideoDuration(int r100) {
            this.videoDuration = r100;
        }

        public void setVideoId(String r100) {
            this.videoId = r100;
        }

        public void setVideoTranspose(int r100) {
            this.videoTranspose = r100;
        }
    }

    @Override // com.bytedance.android.live.base.model.Item
    public IUser author() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.Item
    public ImageModel cover() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.Item
    public List<Object> getDislikeReason() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.Item
    public String getVideoUrl() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.Item
    public String subtitle() {
        return null;
    }

    public JSONObject buildEventCommonParams() {
        return buildEventCommonParams("", 0);
    }

    public String getHostMixId() {
        return String.valueOf(this.f162583id) + "_" + String.valueOf(this.subId);
    }

    @Override // com.bytedance.android.live.base.model.Item
    public String getMixId() {
        return String.valueOf(this.f162583id);
    }

    public HotsoonAd() {
        this.displayType = 0;
    }

    public String getAppName() {
        return this.appName;
    }

    public String getAppleId() {
        return this.appleId;
    }

    public AuthorInfo getAuthor() {
        return this.author;
    }

    public int getAutoOpen() {
        return this.autoOpen;
    }

    public String getButtonText() {
        return this.buttonText;
    }

    public List<String> getClickTrackUrlList() {
        return this.clickTrackUrlList;
    }

    public long getDiggCount() {
        return this.diggCount;
    }

    public int getDisplayType() {
        return this.displayType;
    }

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public int getEffectivePlayTime() {
        return this.effectivePlayTime;
    }

    public List<String> getEffectivePlayTrackUrlList() {
        return this.effectivePlayTrackUrlList;
    }

    public List<FilterWord> getFilterWords() {
        return this.filterWords;
    }

    public int getHideIfExists() {
        return this.hideIfExists;
    }

    @Override // com.bytedance.android.live.base.model.Item
    public long getId() {
        return this.f162583id;
    }

    public List<SimpleImage> getImageList() {
        return this.imageList;
    }

    public String getLabel() {
        return this.label;
    }

    public String getLearnMoreBgColor() {
        return this.learnMoreBgColor;
    }

    public String getLogExtra() {
        return this.logExtra;
    }

    public String getLog_pb() {
        return this.log_pb;
    }

    public String getOpenUrl() {
        return this.openUrl;
    }

    public String getPackages() {
        return this.packages;
    }

    public List<String> getPlayTrackUrlList() {
        return this.playTrackUrlList;
    }

    public List<String> getPlayover_track_url_list() {
        return this.playover_track_url_list;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public int getShowButtonSeconds() {
        return this.showButtonSeconds;
    }

    public int getShowMaskTimes() {
        return this.showMaskTimes;
    }

    public long getSubId() {
        return this.subId;
    }

    public String getTitle() {
        return this.title;
    }

    public List<String> getTrackUrlList() {
        return this.trackUrlList;
    }

    public String getType() {
        return this.type;
    }

    public VideoInfo getVideoInfo() {
        return this.videoInfo;
    }

    public String getWebTitle() {
        return this.webTitle;
    }

    public String getWebUrl() {
        return this.webUrl;
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

    public boolean isUseCompoundLandPage() {
        return this.useCompoundLandPage;
    }

    @Override // com.bytedance.android.live.base.model.Item
    public String title() {
        return this.title;
    }

    public String getTrackMixId(int r100) {
        return String.valueOf(this.f162583id) + "_" + String.valueOf(this.subId) + "_" + String.valueOf(r100);
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

    public void setAppName(String r100) {
        this.appName = r100;
    }

    public void setAppleId(String r100) {
        this.appleId = r100;
    }

    public void setAuthor(AuthorInfo r100) {
        this.author = r100;
    }

    public void setAutoOpen(int r100) {
        this.autoOpen = r100;
    }

    public void setButtonText(String r100) {
        this.buttonText = r100;
    }

    public void setClickTrackUrlList(List<String> r100) {
        this.clickTrackUrlList = r100;
    }

    public void setDiggCount(long r100) {
        this.diggCount = r100;
    }

    public void setDisplayType(int r100) {
        this.displayType = r100;
    }

    public void setDownloadUrl(String r100) {
        this.downloadUrl = r100;
    }

    public void setEffectivePlayTime(int r100) {
        this.effectivePlayTime = r100;
    }

    public void setEffectivePlayTrackUrlList(List<String> r100) {
        this.effectivePlayTrackUrlList = r100;
    }

    public void setFilterWords(List<FilterWord> r100) {
        this.filterWords = r100;
    }

    public void setHideIfExists(int r100) {
        this.hideIfExists = r100;
    }

    public void setId(long r100) {
        this.f162583id = r100;
    }

    public void setImageList(List<SimpleImage> r100) {
        this.imageList = r100;
    }

    public void setLabel(String r100) {
        this.label = r100;
    }

    public void setLearnMoreBgColor(String r100) {
        this.learnMoreBgColor = r100;
    }

    public void setLogExtra(String r100) {
        this.logExtra = r100;
    }

    public void setLog_pb(String r100) {
        this.log_pb = r100;
    }

    public void setOpenUrl(String r100) {
        this.openUrl = r100;
    }

    public void setPackages(String r100) {
        this.packages = r100;
    }

    public void setPlayTrackUrlList(List<String> r100) {
        this.playTrackUrlList = r100;
    }

    public void setPlayover_track_url_list(List<String> r100) {
        this.playover_track_url_list = r100;
    }

    public void setRequestId(String r100) {
        this.requestId = r100;
    }

    public void setShowButtonSeconds(int r100) {
        this.showButtonSeconds = r100;
    }

    public void setShowMaskTimes(int r100) {
        this.showMaskTimes = r100;
    }

    public void setSubId(long r100) {
        this.subId = r100;
    }

    public void setTitle(String r100) {
        this.title = r100;
    }

    public void setTrackUrlList(List<String> r100) {
        this.trackUrlList = r100;
    }

    public void setType(String r100) {
        this.type = r100;
    }

    public void setUseCompoundLandPage(boolean r100) {
        this.useCompoundLandPage = r100;
    }

    public void setVideoInfo(VideoInfo r100) {
        this.videoInfo = r100;
    }

    public void setWebTitle(String r100) {
        this.webTitle = r100;
    }

    public void setWebUrl(String r100) {
        this.webUrl = r100;
    }

    public JSONObject buildEventCommonParams(String r100, long r101) {
        JSONObject r102 = new JSONObject();
        r102.put("is_ad_event", 1);     // Catch: JSONException -> L10
        r102.put("log_extra", getLogExtra());     // Catch: JSONException -> L10
        if (r101 <= 0) goto L7;
        r102.put("duration", r101);     // Catch: JSONException -> L10
    L7:
        if (TextUtils.isEmpty(r100) == true) goto L12;
        r102.put("refer", r100);     // Catch: JSONException -> L10
    L12:
        return r102;
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }
}
