package com.bytedance.android.live.ai.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/ai/config/LiveSmartPlayerConfig;", "", "()V", "enableSmartPlayer", "", "getEnableSmartPlayer", "()Z", "setEnableSmartPlayer", "(Z)V", "liveai-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveSmartPlayerConfig {

    @SerializedName("enable_smart_player")
    private boolean enableSmartPlayer;

    public LiveSmartPlayerConfig() {
    }

    public final boolean getEnableSmartPlayer() {
        return this.enableSmartPlayer;
    }

    public final void setEnableSmartPlayer(boolean r100) {
        this.enableSmartPlayer = r100;
    }
}
