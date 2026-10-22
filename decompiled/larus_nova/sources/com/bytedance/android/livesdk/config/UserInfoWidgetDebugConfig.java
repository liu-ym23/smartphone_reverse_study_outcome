package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/config/UserInfoWidgetDebugConfig;", "", "()V", "anchorTabType", "", "getAnchorTabType", "()I", "setAnchorTabType", "(I)V", "isDebug", "", "()Z", "setDebug", "(Z)V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UserInfoWidgetDebugConfig {

    @SerializedName("middle_anchor_tab_type")
    private int anchorTabType;

    @SerializedName("debug_mode")
    private boolean isDebug;

    public UserInfoWidgetDebugConfig() {
        this.anchorTabType = 3;
    }

    public final int getAnchorTabType() {
        return this.anchorTabType;
    }

    public final boolean isDebug() {
        return this.isDebug;
    }

    public final void setAnchorTabType(int r100) {
        this.anchorTabType = r100;
    }

    public final void setDebug(boolean r100) {
        this.isDebug = r100;
    }
}
