package com.bytedance.android.ec.hybrid.list.entity.dto;

import com.google.gson.annotations.SerializedName;
import com.optimize.statistics.FrescoMonitorConst;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/ec/hybrid/list/entity/dto/ChipData;", "Ljava/io/Serializable;", "()V", "bizTag", "", "getBizTag", "()Ljava/lang/String;", "setBizTag", "(Ljava/lang/String;)V", "imageUrl", "getImageUrl", "setImageUrl", "sceneTag", "getSceneTag", "setSceneTag", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChipData implements Serializable {

    @SerializedName("biz_tag")
    private String bizTag;

    @SerializedName("image_url")
    private String imageUrl;

    @SerializedName(FrescoMonitorConst.SCENE_TAG)
    private String sceneTag;

    public ChipData() {
    }

    public final String getBizTag() {
        return this.bizTag;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final String getSceneTag() {
        return this.sceneTag;
    }

    public final void setBizTag(String r100) {
        this.bizTag = r100;
    }

    public final void setImageUrl(String r100) {
        this.imageUrl = r100;
    }

    public final void setSceneTag(String r100) {
        this.sceneTag = r100;
    }
}
