package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.GameDisplayRatioConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/com/bytedance/android/livesdk/config/GameDisplayFixedRatio;", "", "()V", "onlyScreen", "", "getOnlyScreen", "()Z", "preview43Ratio", "Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/GameDisplayRatioConfig$SupportRatio;", "getPreview43Ratio", "()Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/GameDisplayRatioConfig$SupportRatio;", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GameDisplayFixedRatio {

    @SerializedName("only_screen")
    private final boolean onlyScreen;

    @SerializedName("preview_43_ratio")
    private final GameDisplayRatioConfig.SupportRatio preview43Ratio;

    public GameDisplayFixedRatio() {
        this.onlyScreen = true;
    }

    public final boolean getOnlyScreen() {
        return this.onlyScreen;
    }

    public final GameDisplayRatioConfig.SupportRatio getPreview43Ratio() {
        return this.preview43Ratio;
    }
}
