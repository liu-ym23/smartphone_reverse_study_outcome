package com.bytedance.android.ec.hybrid.data.entity;

import com.google.gson.annotations.SerializedName;
import com.optimize.statistics.FrescoMonitorConst;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR&\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/ec/hybrid/data/entity/ECImageDTO;", "Ljava/io/Serializable;", "()V", "bizTag", "", "getBizTag", "()Ljava/lang/String;", "setBizTag", "(Ljava/lang/String;)V", "sceneTag", "getSceneTag", "setSceneTag", "specifiedDiskCache", "getSpecifiedDiskCache", "setSpecifiedDiskCache", "url", "getUrl", "setUrl", "urls", "", "getUrls", "()Ljava/util/List;", "setUrls", "(Ljava/util/List;)V", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECImageDTO implements Serializable {

    @SerializedName("biz_tag")
    private String bizTag;

    @SerializedName(FrescoMonitorConst.SCENE_TAG)
    private String sceneTag;

    @SerializedName("specified_disk_cache")
    private String specifiedDiskCache;

    @SerializedName("url")
    private String url;

    @SerializedName("urls")
    private List<String> urls;

    public ECImageDTO() {
    }

    public final String getBizTag() {
        return this.bizTag;
    }

    public final String getSceneTag() {
        return this.sceneTag;
    }

    public final String getSpecifiedDiskCache() {
        return this.specifiedDiskCache;
    }

    public final String getUrl() {
        return this.url;
    }

    public final List<String> getUrls() {
        return this.urls;
    }

    public final void setBizTag(String r100) {
        this.bizTag = r100;
    }

    public final void setSceneTag(String r100) {
        this.sceneTag = r100;
    }

    public final void setSpecifiedDiskCache(String r100) {
        this.specifiedDiskCache = r100;
    }

    public final void setUrl(String r100) {
        this.url = r100;
    }

    public final void setUrls(List<String> r100) {
        this.urls = r100;
    }
}
