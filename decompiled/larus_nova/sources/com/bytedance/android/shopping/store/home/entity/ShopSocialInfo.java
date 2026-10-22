package com.bytedance.android.shopping.store.home.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR&\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000e\"\u0004\b\u0017\u0010\u0010¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/ShopSocialInfo;", "Ljava/io/Serializable;", "()V", "showType", "", "getShowType", "()Ljava/lang/Integer;", "setShowType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "videoInfos", "", "Lcom/bytedance/android/shopping/store/home/entity/ShopHeaderVideoInfo;", "getVideoInfos", "()Ljava/util/List;", "setVideoInfos", "(Ljava/util/List;)V", "worksNum", "getWorksNum", "setWorksNum", "worksNumString", "", "getWorksNumString", "setWorksNumString", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopSocialInfo implements Serializable {

    @SerializedName("show_type")
    private Integer showType;

    @SerializedName("video_infos")
    private List<ShopHeaderVideoInfo> videoInfos;

    @SerializedName("works_num")
    private Integer worksNum;

    @SerializedName("works_num_text")
    private List<String> worksNumString;

    public ShopSocialInfo() {
    }

    public final Integer getShowType() {
        return this.showType;
    }

    public final List<ShopHeaderVideoInfo> getVideoInfos() {
        return this.videoInfos;
    }

    public final Integer getWorksNum() {
        return this.worksNum;
    }

    public final List<String> getWorksNumString() {
        return this.worksNumString;
    }

    public final void setShowType(Integer r100) {
        this.showType = r100;
    }

    public final void setVideoInfos(List<ShopHeaderVideoInfo> r100) {
        this.videoInfos = r100;
    }

    public final void setWorksNum(Integer r100) {
        this.worksNum = r100;
    }

    public final void setWorksNumString(List<String> r100) {
        this.worksNumString = r100;
    }
}
