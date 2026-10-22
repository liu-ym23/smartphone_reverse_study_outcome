package com.bytedance.android.livehostapi.business.castscreen.bean;

import com.baidu.platform.comapi.map.MapBundleKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u00102\u001a\u00020!H\u0016J\b\u00103\u001a\u00020\u0012H\u0016R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001a\u0010\u001a\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u001a\u0010\u001d\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016R\u001a\u0010 \u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010&\u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001e\u0010,\u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\b-\u0010(\"\u0004\b.\u0010*¨\u00064"}, d2 = {"Lcom/bytedance/android/livehostapi/business/castscreen/bean/LiveCastResolutionInfo;", "", "()V", "pixelCount", "", "getPixelCount", "()Ljava/lang/Long;", "setPixelCount", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", MapBundleKey.OfflineMapKey.OFFLINE_RATION, "", "getRatio", "()Ljava/lang/Float;", "setRatio", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "resolution", "", "getResolution", "()Ljava/lang/String;", "setResolution", "(Ljava/lang/String;)V", "resolutionText", "getResolutionText", "setResolutionText", "showResolution", "getShowResolution", "setShowResolution", "url", "getUrl", "setUrl", "urlExpire", "", "getUrlExpire", "()I", "setUrlExpire", "(I)V", "videoHeight", "getVideoHeight", "()Ljava/lang/Integer;", "setVideoHeight", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "videoWidth", "getVideoWidth", "setVideoWidth", "equals", "", "other", "hashCode", "toString", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveCastResolutionInfo {
    private Long pixelCount;
    private Float ratio;
    private String resolution;
    private String resolutionText;
    private String showResolution;
    private String url;
    private int urlExpire;
    private Integer videoHeight;
    private Integer videoWidth;

    public int hashCode() {
        return (this.url + this.resolution + this.showResolution).hashCode();
    }

    public String toString() {
        return "LiveCastResolutionInfo(url='" + this.url + "', resolution='" + this.resolution + "', showResolution='" + this.showResolution + "')";
    }

    public LiveCastResolutionInfo() {
        this.url = "";
        this.resolution = "";
        this.showResolution = "";
        this.resolutionText = "";
        this.pixelCount = 0L;
        this.videoWidth = 0;
        this.videoHeight = 0;
        this.ratio = Float.valueOf(0.0f);
    }

    public final Long getPixelCount() {
        return this.pixelCount;
    }

    public final Float getRatio() {
        return this.ratio;
    }

    public final String getResolution() {
        return this.resolution;
    }

    public final String getResolutionText() {
        return this.resolutionText;
    }

    public final String getShowResolution() {
        return this.showResolution;
    }

    public final String getUrl() {
        return this.url;
    }

    public final int getUrlExpire() {
        return this.urlExpire;
    }

    public final Integer getVideoHeight() {
        return this.videoHeight;
    }

    public final Integer getVideoWidth() {
        return this.videoWidth;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof LiveCastResolutionInfo) == false) goto L12;
        LiveCastResolutionInfo r101 = (LiveCastResolutionInfo) r100;
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L7;
        return false;
    L7:
        if (Intrinsics.areEqual(this.resolution, r101.resolution) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.showResolution, r101.showResolution) == false) goto L15;
        return true;
    L15:
        return false;
    L12:
        return false;
    }

    public final void setPixelCount(Long r100) {
        this.pixelCount = r100;
    }

    public final void setRatio(Float r100) {
        this.ratio = r100;
    }

    public final void setResolution(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.resolution = r100;
    }

    public final void setResolutionText(String r100) {
        this.resolutionText = r100;
    }

    public final void setShowResolution(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.showResolution = r100;
    }

    public final void setUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.url = r100;
    }

    public final void setUrlExpire(int r100) {
        this.urlExpire = r100;
    }

    public final void setVideoHeight(Integer r100) {
        this.videoHeight = r100;
    }

    public final void setVideoWidth(Integer r100) {
        this.videoWidth = r100;
    }
}
