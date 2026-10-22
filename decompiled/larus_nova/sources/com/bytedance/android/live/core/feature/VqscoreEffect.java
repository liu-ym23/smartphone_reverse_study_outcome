package com.bytedance.android.live.core.feature;

import com.facebook.imagepipeline.utils.ImageCenterStrategy;
import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.log.IVideoEventLogger;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/core/feature/VqscoreEffect;", "", "()V", ImageCenterStrategy.IMAGE_RESULT_KEY_SHARPEN, "Lcom/bytedance/android/live/core/feature/VqscoreEffectItem;", "getSharpen", "()Lcom/bytedance/android/live/core/feature/VqscoreEffectItem;", IVideoEventLogger.FEATURE_KEY_SR, "", "getSr", "()Ljava/util/List;", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VqscoreEffect {

    @SerializedName(ImageCenterStrategy.IMAGE_RESULT_KEY_SHARPEN)
    private final VqscoreEffectItem sharpen;

    /* JADX INFO: renamed from: sr, reason: collision with root package name */
    @SerializedName(IVideoEventLogger.FEATURE_KEY_SR)
    private final List<VqscoreEffectItem> f64786sr;

    public VqscoreEffect() {
    }

    public final VqscoreEffectItem getSharpen() {
        return this.sharpen;
    }

    public final List<VqscoreEffectItem> getSr() {
        return this.f64786sr;
    }
}
