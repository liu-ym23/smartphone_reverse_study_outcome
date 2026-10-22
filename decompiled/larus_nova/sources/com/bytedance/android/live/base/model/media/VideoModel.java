package com.bytedance.android.live.base.model.media;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import com.ss.ttvideoengine.portrait.PortraitEngine;
import java.util.List;
import py.k;

/* JADX INFO: loaded from: classes45.dex */
public class VideoModel {
    private static final CoverType DEFAULT_COVER_TYPE = null;
    public static final int GIF_TYPE = 0;
    public static final int WEBP_TYPE = 1;

    @SerializedName("allow_cache")
    private boolean allowCache;

    @SerializedName("avg_color")
    private int avgColor;

    @SerializedName("cover_medium")
    private k coverMediumModel;

    @SerializedName("cover")
    private k coverModel;

    @SerializedName("cover_thumb")
    private k coverThumbModel;

    @SerializedName("download_url")
    private List<String> downloadList;

    @SerializedName("duration")
    private double duration;

    @SerializedName(alternate = {"dynamic_cover"}, value = "cover_animated")
    private k dynamicCoverModel;

    @SerializedName(PortraitEngine.LABEL_FIRST_FRAME)
    private k firstFrame;

    @SerializedName("gif_type")
    private int gifType;

    @SerializedName("gif_url_list")
    private List<String> gifUrlList;

    @SerializedName("height")
    private int height;

    @SerializedName("long_duration")
    private float longDuration;

    @SerializedName("long_uri")
    private String longUri;

    @SerializedName("long_url")
    private List<String> longUrls;
    private CoverType mCoverType;

    @SerializedName("preload_size")
    private int preloadSize;

    @SerializedName("quality_info")
    private List<c> qualityInfo;

    @SerializedName("uri")
    private String uri;

    @SerializedName(ScoreTags.STAR_URL_LIST)
    private List<String> urlList;

    @SerializedName("videoLocalPath")
    private String videoLocalPath;

    @SerializedName("watermark")
    private boolean waterMark;

    @SerializedName("width")
    private int width;

    public static final enum CoverType extends Enum<CoverType> {
        public static final CoverType LARGE = null;
        public static final CoverType MEDIUM = null;
        public static final CoverType THUMB = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CoverType[] f58847a = null;

        static {
            CoverType r100 = new CoverType("LARGE", 0);
            LARGE = r100;
            CoverType r101 = new CoverType("MEDIUM", 1);
            MEDIUM = r101;
            CoverType r102 = new CoverType("THUMB", 2);
            THUMB = r102;
            f58847a = new CoverType[]{r100, r101, r102};
        }

        public static CoverType[] values() {
            return (CoverType[]) f58847a.clone();
        }

        public static CoverType valueOf(String r100) {
            return (CoverType) r27.a.a(CoverType.class, r100);
        }

        public CoverType(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
        DEFAULT_COVER_TYPE = CoverType.LARGE;
    }

    public VideoModel() {
        this.preloadSize = 512000;
        this.mCoverType = DEFAULT_COVER_TYPE;
    }

    public String getUnbitratedUri() {
        if (TextUtils.isEmpty(getUri()) == false) goto L6;
        return "";
    L6:
        return getUri();
    }

    public List<c> getBitRate() {
        return this.qualityInfo;
    }

    public k getCoverMediumModel() {
        return this.coverMediumModel;
    }

    public k getCoverModel() {
        return this.coverModel;
    }

    public k getCoverThumbModel() {
        return this.coverThumbModel;
    }

    public CoverType getCoverType() {
        return this.mCoverType;
    }

    public List<String> getDownloadList() {
        return this.downloadList;
    }

    public double getDuration() {
        return this.duration;
    }

    public k getDynamicCoverModel() {
        return this.dynamicCoverModel;
    }

    public k getFirstFrame() {
        return this.firstFrame;
    }

    public int getGifType() {
        return this.gifType;
    }

    public List<String> getGifUrlList() {
        return this.gifUrlList;
    }

    public int getHeight() {
        return this.height;
    }

    public float getLongDuration() {
        return this.longDuration;
    }

    public String getLongUri() {
        return this.longUri;
    }

    public List<String> getLongUrls() {
        return this.longUrls;
    }

    public int getPreloadSize() {
        return this.preloadSize;
    }

    public List<c> getQualityInfo() {
        return this.qualityInfo;
    }

    public String getUri() {
        return this.uri;
    }

    public List<String> getUrlList() {
        return this.urlList;
    }

    public String getVideoLocalPath() {
        return this.videoLocalPath;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean isAllowCache() {
        return this.allowCache;
    }

    public boolean isWaterMark() {
        return this.waterMark;
    }

    public void setAllowCache(boolean r100) {
        this.allowCache = r100;
    }

    public void setCoverMediumModel(k r100) {
        this.coverMediumModel = r100;
    }

    public void setCoverModel(k r100) {
        this.coverModel = r100;
    }

    public void setCoverThumbModel(k r100) {
        this.coverThumbModel = r100;
    }

    public void setCoverType(CoverType r100) {
        this.mCoverType = r100;
    }

    public void setDownloadList(List<String> r100) {
        this.downloadList = r100;
    }

    public void setDuration(double r100) {
        this.duration = r100;
    }

    public void setDynamicCoverModel(k r100) {
        this.dynamicCoverModel = r100;
    }

    public void setFirstFrame(k r100) {
        this.firstFrame = r100;
    }

    public void setGifType(int r100) {
        this.gifType = r100;
    }

    public void setGifUrlList(List<String> r100) {
        this.gifUrlList = r100;
    }

    public void setHeight(int r100) {
        this.height = r100;
    }

    public void setLongDuration(float r100) {
        this.longDuration = r100;
    }

    public void setLongUri(String r100) {
        this.longUri = r100;
    }

    public void setLongUrls(List<String> r100) {
        this.longUrls = r100;
    }

    public void setPreloadSize(int r100) {
        this.preloadSize = r100;
    }

    public void setQualityInfo(List<c> r100) {
        this.qualityInfo = r100;
    }

    public void setUri(String r100) {
        this.uri = r100;
    }

    public void setUrlList(List<String> r100) {
        this.urlList = r100;
    }

    public void setVideoLocalPath(String r100) {
        this.videoLocalPath = r100;
    }

    public void setWaterMark(boolean r100) {
        this.waterMark = r100;
    }

    public void setWidth(int r100) {
        this.width = r100;
    }
}
