package com.bytedance.android.window.shop.repository.dto;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u0019\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/j;", "", "Lcom/bytedance/android/ec/model/ECUrlModel;", "url", "Lcom/bytedance/android/ec/model/ECUrlModel;", "f", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "coverUrl", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", "duration", "Ljava/lang/Long;", "d", "()Ljava/lang/Long;", "", SocialConstants.PARAM_APP_DESC, "Ljava/lang/String;", "c", "()Ljava/lang/String;", "", "cuttingRatio", "Ljava/lang/Double;", "b", "()Ljava/lang/Double;", "maxPlayDurationMs", "e", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j {

    @SerializedName("video_cover")
    private final ECUrlModel coverUrl;

    @SerializedName("cutting_ratio")
    private final Double cuttingRatio;

    @SerializedName("content_title")
    private final String desc;

    @SerializedName("video_duration")
    private final Long duration;

    @SerializedName("max_play_duration")
    private final Long maxPlayDurationMs;

    @SerializedName("video_play_addr")
    private final ECUrlModel url;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j) == false) goto L18;
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.coverUrl, r101.coverUrl) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.duration, r101.duration) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.desc, r101.desc) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.cuttingRatio, r101.cuttingRatio) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.maxPlayDurationMs, r101.maxPlayDurationMs) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        ECUrlModel r100 = this.url;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        ECUrlModel r104 = this.coverUrl;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.duration;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.desc;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Double r113 = this.cuttingRatio;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Long r116 = this.maxPlayDurationMs;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "VideoInfoDTO(url=" + this.url + ", coverUrl=" + this.coverUrl + ", duration=" + this.duration + ", desc=" + this.desc + ", cuttingRatio=" + this.cuttingRatio + ", maxPlayDurationMs=" + this.maxPlayDurationMs + ")";
    }

    public final ECUrlModel a() {
        return this.coverUrl;
    }

    public final Double b() {
        return this.cuttingRatio;
    }

    public final String c() {
        return this.desc;
    }

    public final Long d() {
        return this.duration;
    }

    public final Long e() {
        return this.maxPlayDurationMs;
    }

    public final ECUrlModel f() {
        return this.url;
    }
}
