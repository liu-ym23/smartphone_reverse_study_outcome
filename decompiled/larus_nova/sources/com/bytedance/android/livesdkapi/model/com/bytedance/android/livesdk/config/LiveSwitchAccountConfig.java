package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/LiveSwitchAccountConfig;", "", "()V", "enable", "", "getEnable", "()Z", "setEnable", "(Z)V", "minLevel", "", "getMinLevel", "()I", "setMinLevel", "(I)V", "scheme", "", "getScheme", "()Ljava/lang/String;", "setScheme", "(Ljava/lang/String;)V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveSwitchAccountConfig {

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("min_level")
    private int minLevel;

    @SerializedName("enter_room_scheme")
    private String scheme;

    public LiveSwitchAccountConfig() {
        this.scheme = "";
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final int getMinLevel() {
        return this.minLevel;
    }

    public final String getScheme() {
        return this.scheme;
    }

    public final void setEnable(boolean r100) {
        this.enable = r100;
    }

    public final void setMinLevel(int r100) {
        this.minLevel = r100;
    }

    public final void setScheme(String r100) {
        this.scheme = r100;
    }
}
