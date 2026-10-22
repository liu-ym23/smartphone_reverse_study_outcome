package com.bytedance.android.livesdk.livecommerce.utils;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00048F@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001e\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/utils/ECLiveFpsOptConfig;", "Ljava/io/Serializable;", "()V", "enableCacheDensity", "", "getEnableCacheDensity", "()Z", "setEnableCacheDensity", "(Z)V", "enableClearFullScreen", "getEnableClearFullScreen", "setEnableClearFullScreen", "enableIdleLoadCard", "getEnableIdleLoadCard", "setEnableIdleLoadCard", "enableIdleLoadCardNoImage", "getEnableIdleLoadCardNoImage", "setEnableIdleLoadCardNoImage", "enableOpt", "getEnableOpt", "setEnableOpt", "enableSwitchResolution", "getEnableSwitchResolution", "setEnableSwitchResolution", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECLiveFpsOptConfig implements Serializable {

    @SerializedName("enable_cache_density")
    private boolean enableCacheDensity;

    @SerializedName("enable_clear_full_screen")
    private boolean enableClearFullScreen;

    @SerializedName("enalbe_idle_load_card")
    private boolean enableIdleLoadCard;

    @SerializedName("enalbe_idle_load_card_no_image")
    private boolean enableIdleLoadCardNoImage;

    @SerializedName("enable_common_opt")
    private boolean enableOpt;

    @SerializedName("enable_switch_resolution")
    private boolean enableSwitchResolution;

    public ECLiveFpsOptConfig() {
    }

    public final boolean getEnableIdleLoadCardNoImage() {
        if (this.enableIdleLoadCardNoImage == true) goto L5;
    L7:
        return false;
    L5:
        if (this.enableIdleLoadCard == false) goto L7;
        return true;
    }

    public final boolean getEnableCacheDensity() {
        return this.enableCacheDensity;
    }

    public final boolean getEnableClearFullScreen() {
        return this.enableClearFullScreen;
    }

    public final boolean getEnableIdleLoadCard() {
        return this.enableIdleLoadCard;
    }

    public final boolean getEnableOpt() {
        return this.enableOpt;
    }

    public final boolean getEnableSwitchResolution() {
        return this.enableSwitchResolution;
    }

    public final void setEnableCacheDensity(boolean r100) {
        this.enableCacheDensity = r100;
    }

    public final void setEnableClearFullScreen(boolean r100) {
        this.enableClearFullScreen = r100;
    }

    public final void setEnableIdleLoadCard(boolean r100) {
        this.enableIdleLoadCard = r100;
    }

    public final void setEnableIdleLoadCardNoImage(boolean r100) {
        this.enableIdleLoadCardNoImage = r100;
    }

    public final void setEnableOpt(boolean r100) {
        this.enableOpt = r100;
    }

    public final void setEnableSwitchResolution(boolean r100) {
        this.enableSwitchResolution = r100;
    }
}
