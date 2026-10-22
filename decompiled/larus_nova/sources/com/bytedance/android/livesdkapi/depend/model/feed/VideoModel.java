package com.bytedance.android.livesdkapi.depend.model.feed;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.media.c;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import java.util.List;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
public class VideoModel {
    private static final CoverType DEFAULT_COVER_TYPE = null;

    @SerializedName("allow_cache")
    private boolean allowCache;

    @SerializedName("avg_color")
    private int avgColor;

    @SerializedName("cover_medium")
    private ImageModel coverMediumModel;

    @SerializedName("cover")
    private ImageModel coverModel;

    @SerializedName("cover_thumb")
    private ImageModel coverThumbModel;

    @SerializedName("download_url")
    private List<String> downloadList;

    @SerializedName("duration")
    private double duration;

    @SerializedName("dynamic_cover")
    private ImageModel dynamicCoverModel;

    @SerializedName("height")
    private int height;
    private CoverType mCoverType;

    @SerializedName("preload_size")
    private int preloadSize;

    @SerializedName("quality_info")
    private List<c> qualityInfo;

    @SerializedName("uri")
    private String uri;

    @SerializedName(ScoreTags.STAR_URL_LIST)
    private List<String> urlList;

    @SerializedName("width")
    private int width;

    public static final enum CoverType extends Enum<CoverType> {
        private static final /* synthetic */ CoverType[] $VALUES = null;
        public static final CoverType LARGE = null;
        public static final CoverType MEDIUM = null;
        public static final CoverType THUMB = null;

        static {
            CoverType r100 = new CoverType("LARGE", 0);
            LARGE = r100;
            CoverType r101 = new CoverType("MEDIUM", 1);
            MEDIUM = r101;
            CoverType r102 = new CoverType("THUMB", 2);
            THUMB = r102;
            $VALUES = new CoverType[]{r100, r101, r102};
        }

        public static CoverType[] values() {
            return (CoverType[]) $VALUES.clone();
        }

        public static CoverType valueOf(String r100) {
            return (CoverType) a.a(CoverType.class, r100);
        }

        private CoverType(String r100, int r101) {
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

    public ImageModel getCoverMediumModel() {
        return this.coverMediumModel;
    }

    public ImageModel getCoverModel() {
        return this.coverModel;
    }

    public ImageModel getCoverThumbModel() {
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

    public ImageModel getDynamicCoverModel() {
        return this.dynamicCoverModel;
    }

    public int getHeight() {
        return this.height;
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

    public int getWidth() {
        return this.width;
    }

    public boolean isAllowCache() {
        return this.allowCache;
    }

    public void setAllowCache(boolean r100) {
        this.allowCache = r100;
    }

    public void setCoverMediumModel(ImageModel r100) {
        this.coverMediumModel = r100;
    }

    public void setCoverModel(ImageModel r100) {
        this.coverModel = r100;
    }

    public void setCoverThumbModel(ImageModel r100) {
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

    public void setDynamicCoverModel(ImageModel r100) {
        this.dynamicCoverModel = r100;
    }

    public void setHeight(int r100) {
        this.height = r100;
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

    public void setWidth(int r100) {
        this.width = r100;
    }
}
