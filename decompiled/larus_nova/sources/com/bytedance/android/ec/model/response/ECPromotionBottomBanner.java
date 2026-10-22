package com.bytedance.android.ec.model.response;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001b\u001a\u00020\u001cR \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR \u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR,\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/ec/model/response/ECPromotionBottomBanner;", "Ljava/io/Serializable;", "()V", "jumpUrl", "", "getJumpUrl", "()Ljava/lang/String;", "setJumpUrl", "(Ljava/lang/String;)V", "rightIcon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getRightIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "setRightIcon", "(Lcom/bytedance/android/ec/model/ECUrlModel;)V", "text", "getText", "setText", "trackName", "getTrackName", "setTrackName", "trackParam", "", "getTrackParam", "()Ljava/util/Map;", "setTrackParam", "(Ljava/util/Map;)V", "isSampleRoom", "", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ECPromotionBottomBanner implements Serializable {

    @SerializedName("jump_url")
    private String jumpUrl;

    @SerializedName("right_icon")
    private ECUrlModel rightIcon;

    @SerializedName("text")
    private String text;

    @SerializedName("track_name")
    private String trackName;

    @SerializedName("track_param")
    private Map<String, String> trackParam;

    public ECPromotionBottomBanner() {
    }

    public final boolean isSampleRoom() {
        Map<String, String> r100 = this.trackParam;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(r100.get(AdDownloadModel.JsonKey.MODEL_TYPE), "sample_room") == false) goto L10;
        return true;
    L10:
        return false;
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final ECUrlModel getRightIcon() {
        return this.rightIcon;
    }

    public final String getText() {
        return this.text;
    }

    public final String getTrackName() {
        return this.trackName;
    }

    public final Map<String, String> getTrackParam() {
        return this.trackParam;
    }

    public final void setJumpUrl(String r100) {
        this.jumpUrl = r100;
    }

    public final void setRightIcon(ECUrlModel r100) {
        this.rightIcon = r100;
    }

    public final void setText(String r100) {
        this.text = r100;
    }

    public final void setTrackName(String r100) {
        this.trackName = r100;
    }

    public final void setTrackParam(Map<String, String> r100) {
        this.trackParam = r100;
    }
}
