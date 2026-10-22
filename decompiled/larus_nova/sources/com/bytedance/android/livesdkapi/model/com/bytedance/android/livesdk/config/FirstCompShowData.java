package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0006\"\u0004\b\n\u0010\bR\u001e\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\u001e\u0010\r\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0006\"\u0004\b\u000f\u0010\bR\u001e\u0010\u0010\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\u001e\u0010\u0013\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/FirstCompShowData;", "", "()V", "disableFollowEnter", "", "getDisableFollowEnter", "()Z", "setDisableFollowEnter", "(Z)V", "isDelayClose", "setDelayClose", "isPreloadInPlay", "setPreloadInPlay", "onlyPreloadClick", "getOnlyPreloadClick", "setOnlyPreloadClick", "preloadUserInfoClick", "getPreloadUserInfoClick", "setPreloadUserInfoClick", "usePreloadData", "getUsePreloadData", "setUsePreloadData", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FirstCompShowData {

    @SerializedName("disable_follow_enter")
    private boolean disableFollowEnter;

    @SerializedName("is_delay_close")
    private boolean isDelayClose;

    @SerializedName("is_preload_in_play")
    private boolean isPreloadInPlay;

    @SerializedName("only_preload_click")
    private boolean onlyPreloadClick;

    @SerializedName("preload_user_info_click")
    private boolean preloadUserInfoClick;

    @SerializedName(a.KEY_USE_PRELOAD_DATA)
    private boolean usePreloadData;

    public FirstCompShowData() {
        this.disableFollowEnter = true;
    }

    public final boolean getDisableFollowEnter() {
        return this.disableFollowEnter;
    }

    public final boolean getOnlyPreloadClick() {
        return this.onlyPreloadClick;
    }

    public final boolean getPreloadUserInfoClick() {
        return this.preloadUserInfoClick;
    }

    public final boolean getUsePreloadData() {
        return this.usePreloadData;
    }

    public final boolean isDelayClose() {
        return this.isDelayClose;
    }

    public final boolean isPreloadInPlay() {
        return this.isPreloadInPlay;
    }

    public final void setDelayClose(boolean r100) {
        this.isDelayClose = r100;
    }

    public final void setDisableFollowEnter(boolean r100) {
        this.disableFollowEnter = r100;
    }

    public final void setOnlyPreloadClick(boolean r100) {
        this.onlyPreloadClick = r100;
    }

    public final void setPreloadInPlay(boolean r100) {
        this.isPreloadInPlay = r100;
    }

    public final void setPreloadUserInfoClick(boolean r100) {
        this.preloadUserInfoClick = r100;
    }

    public final void setUsePreloadData(boolean r100) {
        this.usePreloadData = r100;
    }
}
