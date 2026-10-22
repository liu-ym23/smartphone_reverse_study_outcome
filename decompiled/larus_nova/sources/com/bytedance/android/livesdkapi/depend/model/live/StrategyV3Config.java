package com.bytedance.android.livesdkapi.depend.model.live;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/StrategyV3Config;", "", "()V", "enable_v3", "", "getEnable_v3", "()Z", "setEnable_v3", "(Z)V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class StrategyV3Config {

    @SerializedName("enable_v3")
    private boolean enable_v3;

    public StrategyV3Config() {
    }

    public final boolean getEnable_v3() {
        return this.enable_v3;
    }

    public final void setEnable_v3(boolean r100) {
        this.enable_v3 = r100;
    }
}
