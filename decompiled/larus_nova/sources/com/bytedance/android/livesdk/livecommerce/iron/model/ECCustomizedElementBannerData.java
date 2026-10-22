package com.bytedance.android.livesdk.livecommerce.iron.model;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.live.b;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\"\u0010#R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR*\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R*\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R0\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006$"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/model/ECCustomizedElementBannerData;", "Ljava/io/Serializable;", "", "jumpUrl", "Ljava/lang/String;", "getJumpUrl", "()Ljava/lang/String;", "setJumpUrl", "(Ljava/lang/String;)V", "Lcom/bytedance/android/ec/model/ECUrlModel;", "bgImage", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getBgImage", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "setBgImage", "(Lcom/bytedance/android/ec/model/ECUrlModel;)V", "", "Lcom/bytedance/android/ec/model/live/b;", "leftContent", "Ljava/util/List;", "getLeftContent", "()Ljava/util/List;", "setLeftContent", "(Ljava/util/List;)V", "rightContent", "getRightContent", "setRightContent", "", "trackParam", "Ljava/util/Map;", "getTrackParam", "()Ljava/util/Map;", "setTrackParam", "(Ljava/util/Map;)V", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECCustomizedElementBannerData implements Serializable {

    @SerializedName("bg_image")
    private ECUrlModel bgImage;

    @SerializedName("jump_url")
    private String jumpUrl;

    @SerializedName("left_content")
    private List<b> leftContent;

    @SerializedName("right_content")
    private List<b> rightContent;

    @SerializedName("track_param")
    private Map<String, String> trackParam;

    public ECCustomizedElementBannerData() {
    }

    public final ECUrlModel getBgImage() {
        return this.bgImage;
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final List<b> getLeftContent() {
        return this.leftContent;
    }

    public final List<b> getRightContent() {
        return this.rightContent;
    }

    public final Map<String, String> getTrackParam() {
        return this.trackParam;
    }

    public final void setBgImage(ECUrlModel r100) {
        this.bgImage = r100;
    }

    public final void setJumpUrl(String r100) {
        this.jumpUrl = r100;
    }

    public final void setLeftContent(List<b> r100) {
        this.leftContent = r100;
    }

    public final void setRightContent(List<b> r100) {
        this.rightContent = r100;
    }

    public final void setTrackParam(Map<String, String> r100) {
        this.trackParam = r100;
    }
}
