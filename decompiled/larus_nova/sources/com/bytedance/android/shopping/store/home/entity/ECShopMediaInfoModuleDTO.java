package com.bytedance.android.shopping.store.home.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/ECShopMediaInfoModuleDTO;", "Ljava/io/Serializable;", "Lim/v;", "liveInfo", "Lim/v;", "getLiveInfo", "()Lim/v;", "setLiveInfo", "(Lim/v;)V", "", "Lcom/bytedance/android/shopping/store/home/entity/ShopHeaderVideoInfo;", "videoInfos", "Ljava/util/List;", "getVideoInfos", "()Ljava/util/List;", "setVideoInfos", "(Ljava/util/List;)V", "", "showType", "Ljava/lang/Integer;", "getShowType", "()Ljava/lang/Integer;", "setShowType", "(Ljava/lang/Integer;)V", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopMediaInfoModuleDTO implements Serializable {

    @SerializedName("live_info")
    private im.v liveInfo;

    @SerializedName("show_type")
    private Integer showType;

    @SerializedName("video_infos")
    private List<ShopHeaderVideoInfo> videoInfos;

    public ECShopMediaInfoModuleDTO() {
    }

    public final im.v getLiveInfo() {
        return this.liveInfo;
    }

    public final Integer getShowType() {
        return this.showType;
    }

    public final List<ShopHeaderVideoInfo> getVideoInfos() {
        return this.videoInfos;
    }

    public final void setLiveInfo(im.v r100) {
        this.liveInfo = r100;
    }

    public final void setShowType(Integer r100) {
        this.showType = r100;
    }

    public final void setVideoInfos(List<ShopHeaderVideoInfo> r100) {
        this.videoInfos = r100;
    }
}
