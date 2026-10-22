package com.bytedance.android.live.base.model.emoji;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import com.bytedance.android.livesdkapi.depend.model.live.emoji.ISelfEmoji;
import com.bytedance.sdk.account.platform.api.IGoogleService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import py.k;

/* JADX INFO: loaded from: classes45.dex */
public class SelfEmoji extends BaseEmoji implements Serializable, ISelfEmoji {
    private static final long serialVersionUID = 0;

    @SerializedName("animate_type")
    private String animateType;

    @SerializedName("animatedImage")
    private ImageModel animatedImage;

    @SerializedName(IGoogleService.ResponseKey.DISPLAY_NAME)
    private String displayName;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private String f58830id;

    @SerializedName("isFromCache")
    private boolean isFromCache;

    @SerializedName("is_gif")
    private boolean isGif;

    @SerializedName(ScoreTags.STAR_URL_LIST)
    private List<String> mUrls;

    @SerializedName("origin_package_id")
    private long resourcesId;

    @SerializedName("selfPosition")
    private int[] selfPosition;

    @SerializedName("staticImage")
    private ImageModel staticImage;

    @SerializedName("sticker_type")
    private int stickerType;

    @SerializedName("height")
    private int viewHeight;

    @SerializedName("width")
    private int viewWidth;

    @SerializedName("web_uri")
    private String webUri;

    public SelfEmoji() {
        this.mUrls = new ArrayList();
        setType(BaseEmoji.Type.SelfEmoji);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.emoji.ISelfEmoji
    public /* bridge */ /* synthetic */ k getAnimatedImage() {
        return getAnimatedImage();
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.emoji.ISelfEmoji
    public /* bridge */ /* synthetic */ k getStaticImage() {
        return getStaticImage();
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.emoji.ISelfEmoji
    public String getAnimateType() {
        return this.animateType;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.emoji.ISelfEmoji
    public String getDisplayName() {
        return this.displayName;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.emoji.ISelfEmoji
    public String getId() {
        return this.f58830id;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.emoji.ISelfEmoji
    public long getResourcesId() {
        return this.resourcesId;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.emoji.ISelfEmoji
    public int[] getSelfPosition() {
        return this.selfPosition;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.emoji.ISelfEmoji
    public int getStickerType() {
        return this.stickerType;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.emoji.ISelfEmoji
    public int getViewHeight() {
        return this.viewHeight;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.emoji.ISelfEmoji
    public int getViewWidth() {
        return this.viewWidth;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.emoji.ISelfEmoji
    public String getWebUri() {
        return this.webUri;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.emoji.ISelfEmoji
    public List<String> getmUrls() {
        return this.mUrls;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.emoji.ISelfEmoji
    public boolean isFromCache() {
        return this.isFromCache;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.emoji.ISelfEmoji
    public boolean isGif() {
        return this.isGif;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.emoji.ISelfEmoji
    public ImageModel getAnimatedImage() {
        return this.animatedImage;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.emoji.ISelfEmoji
    public ImageModel getStaticImage() {
        return this.staticImage;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.emoji.ISelfEmoji
    public void setAnimateType(String r100) {
        this.animateType = r100;
    }

    public void setAnimatedImage(ImageModel r100) {
        this.animatedImage = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.emoji.ISelfEmoji
    public void setDisplayName(String r100) {
        this.displayName = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.emoji.ISelfEmoji
    public void setGif(boolean r100) {
        this.isGif = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.emoji.ISelfEmoji
    public void setId(String r100) {
        this.f58830id = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.emoji.ISelfEmoji
    public void setIsFromCache(boolean r100) {
        this.isFromCache = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.emoji.ISelfEmoji
    public void setResourcesId(long r100) {
        this.resourcesId = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.emoji.ISelfEmoji
    public void setSelfPosition(int[] r100) {
        this.selfPosition = r100;
    }

    public void setStaticImage(ImageModel r100) {
        this.staticImage = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.emoji.ISelfEmoji
    public void setStickerType(int r100) {
        this.stickerType = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.emoji.ISelfEmoji
    public void setUrls(List<String> r100) {
        this.mUrls = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.emoji.ISelfEmoji
    public void setViewHeight(int r100) {
        this.viewHeight = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.emoji.ISelfEmoji
    public void setViewWidth(int r100) {
        this.viewWidth = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.emoji.ISelfEmoji
    public void setWebUri(String r100) {
        this.webUri = r100;
    }
}
