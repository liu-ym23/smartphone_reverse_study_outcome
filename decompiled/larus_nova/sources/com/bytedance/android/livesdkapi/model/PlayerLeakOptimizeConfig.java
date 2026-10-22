package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0016\u0010\t\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0016\u0010\u000b\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/PlayerLeakOptimizeConfig;", "", "()V", "clearBindView", "", "getClearBindView", "()Z", "enableCheck", "getEnableCheck", "fixTTLivePlayer", "getFixTTLivePlayer", "viewWeakRef", "getViewWeakRef", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayerLeakOptimizeConfig {

    @SerializedName("enable_clear_view_fix")
    private final boolean clearBindView;

    @SerializedName("enable_check")
    private final boolean enableCheck;

    @SerializedName("fix_ttlive_player")
    private final boolean fixTTLivePlayer;

    @SerializedName("view_weak_ref")
    private final boolean viewWeakRef;

    public PlayerLeakOptimizeConfig() {
    }

    public final boolean getClearBindView() {
        return this.clearBindView;
    }

    public final boolean getEnableCheck() {
        return this.enableCheck;
    }

    public final boolean getFixTTLivePlayer() {
        return this.fixTTLivePlayer;
    }

    public final boolean getViewWeakRef() {
        return this.viewWeakRef;
    }
}
