package com.bytedance.android.livesdk.config;

import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/config/e8;", "", "", "resultImgScale", FaceService.girlLabel, "d", "()F", "setResultImgScale", "(F)V", "identifyAreaScale", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setIdentifyAreaScale", "identifyAreaScaleThreshold", "b", "setIdentifyAreaScaleThreshold", "", "identifyAreaSizeThreshold", "I", "c", "()I", "setIdentifyAreaSizeThreshold", "(I)V", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e8 {

    @SerializedName("identify_area_scale")
    private float identifyAreaScale;

    @SerializedName("identify_area_scale_threshold")
    private float identifyAreaScaleThreshold;

    @SerializedName("identify_area_size_threshold")
    private int identifyAreaSizeThreshold;

    @SerializedName("result_img_scale")
    private float resultImgScale;

    public e8() {
        this.resultImgScale = 1.5f;
        this.identifyAreaScale = 1.2f;
        this.identifyAreaScaleThreshold = 0.4f;
    }

    public final float a() {
        return this.identifyAreaScale;
    }

    public final float b() {
        return this.identifyAreaScaleThreshold;
    }

    public final int c() {
        return this.identifyAreaSizeThreshold;
    }

    public final float d() {
        return this.resultImgScale;
    }
}
