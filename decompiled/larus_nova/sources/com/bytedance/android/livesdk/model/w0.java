package com.bytedance.android.livesdk.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/model/w0;", "", "Lcom/bytedance/android/livesdk/model/d;", "videoDynamicFloatSpatialAudioPositionContent", "Lcom/bytedance/android/livesdk/model/d;", "c", "()Lcom/bytedance/android/livesdk/model/d;", "setVideoDynamicFloatSpatialAudioPositionContent", "(Lcom/bytedance/android/livesdk/model/d;)V", "videoDynamicEqualSpatialAudioPositionContent", "b", "setVideoDynamicEqualSpatialAudioPositionContent", "Lcom/bytedance/android/livesdk/model/f0;", "normalSpatialAudioPositionContent", "Lcom/bytedance/android/livesdk/model/f0;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/livesdk/model/f0;", "setNormalSpatialAudioPositionContent", "(Lcom/bytedance/android/livesdk/model/f0;)V", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class w0 {

    @SerializedName("normal_spatial_position_content")
    private f0 normalSpatialAudioPositionContent;

    @SerializedName("video_dynamic_equal_spatial_position_content")
    private d videoDynamicEqualSpatialAudioPositionContent;

    @SerializedName("video_dynamic_float_spatial_position_content")
    private d videoDynamicFloatSpatialAudioPositionContent;

    public w0() {
    }

    public final f0 a() {
        return this.normalSpatialAudioPositionContent;
    }

    public final d b() {
        return this.videoDynamicEqualSpatialAudioPositionContent;
    }

    public final d c() {
        return this.videoDynamicFloatSpatialAudioPositionContent;
    }
}
