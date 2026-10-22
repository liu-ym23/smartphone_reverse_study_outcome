package com.bytedance.android.livesdkapi.model.com.bytedance.android.live.core.log;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/live/core/log/ALoggerConfig;", "", "()V", "enable", "", "getEnable", "()Z", "setEnable", "(Z)V", "enablePreCheck", "getEnablePreCheck", "setEnablePreCheck", "enableRestrictLevel", "getEnableRestrictLevel", "setEnableRestrictLevel", "enableTest", "getEnableTest", "setEnableTest", "restrictLevel", "", "getRestrictLevel", "()I", "setRestrictLevel", "(I)V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ALoggerConfig {

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("enable_pre_check")
    private boolean enablePreCheck;

    @SerializedName("enable_restrict_level")
    private boolean enableRestrictLevel;

    @SerializedName("enable_test")
    private boolean enableTest;

    @SerializedName("restrict_level")
    private int restrictLevel;

    public ALoggerConfig() {
        this.enable = true;
        this.restrictLevel = 3;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final boolean getEnablePreCheck() {
        return this.enablePreCheck;
    }

    public final boolean getEnableRestrictLevel() {
        return this.enableRestrictLevel;
    }

    public final boolean getEnableTest() {
        return this.enableTest;
    }

    public final int getRestrictLevel() {
        return this.restrictLevel;
    }

    public final void setEnable(boolean r100) {
        this.enable = r100;
    }

    public final void setEnablePreCheck(boolean r100) {
        this.enablePreCheck = r100;
    }

    public final void setEnableRestrictLevel(boolean r100) {
        this.enableRestrictLevel = r100;
    }

    public final void setEnableTest(boolean r100) {
        this.enableTest = r100;
    }

    public final void setRestrictLevel(int r100) {
        this.restrictLevel = r100;
    }
}
