package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/LiveMockStrategyDescriptorLoadConfig;", "", "()V", "enable", "", "getEnable", "()Z", "setEnable", "(Z)V", "mockLandscape", "", "getMockLandscape", "()I", "setMockLandscape", "(I)V", "mockPortrait", "getMockPortrait", "setMockPortrait", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveMockStrategyDescriptorLoadConfig {

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("mock_landscape")
    private int mockLandscape;

    @SerializedName("mock_portrait")
    private int mockPortrait;

    public LiveMockStrategyDescriptorLoadConfig() {
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final int getMockLandscape() {
        return this.mockLandscape;
    }

    public final int getMockPortrait() {
        return this.mockPortrait;
    }

    public final void setEnable(boolean r100) {
        this.enable = r100;
    }

    public final void setMockLandscape(int r100) {
        this.mockLandscape = r100;
    }

    public final void setMockPortrait(int r100) {
        this.mockPortrait = r100;
    }
}
