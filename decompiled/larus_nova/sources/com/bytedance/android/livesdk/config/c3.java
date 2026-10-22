package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b!\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b!\u0010\"R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\"\u0010\u001e\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\b¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdk/config/c3;", "", "", "enableFollowNinePng", "Z", "getEnableFollowNinePng", "()Z", "setEnableFollowNinePng", "(Z)V", "enableShopPaint", "getEnableShopPaint", "setEnableShopPaint", "enableBackgroundWebp", "getEnableBackgroundWebp", "setEnableBackgroundWebp", "enableExtendTopBorder", "getEnableExtendTopBorder", "setEnableExtendTopBorder", "enableEnterAnimation", "getEnableEnterAnimation", "setEnableEnterAnimation", "enableExitAnimation", "getEnableExitAnimation", "setEnableExitAnimation", "enableWebpOpt", "getEnableWebpOpt", "setEnableWebpOpt", "enableWebpPlaceholderOpt", "getEnableWebpPlaceholderOpt", "setEnableWebpPlaceholderOpt", "enablePrepareWebpOpt", "getEnablePrepareWebpOpt", "setEnablePrepareWebpOpt", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c3 {

    @SerializedName("enable_background_webp")
    private boolean enableBackgroundWebp;

    @SerializedName("enable_enter_animation")
    private boolean enableEnterAnimation;

    @SerializedName("enable_exit_animation")
    private boolean enableExitAnimation;

    @SerializedName("enable_extend_top_border")
    private boolean enableExtendTopBorder;

    @SerializedName("enable_follow_nine_png")
    private boolean enableFollowNinePng;

    @SerializedName("enable_prepare_webp_opt")
    private boolean enablePrepareWebpOpt;

    @SerializedName("enable_shop_paint")
    private boolean enableShopPaint;

    @SerializedName("enable_webp_opt")
    private boolean enableWebpOpt;

    @SerializedName("enable_webp_placeholder_opt")
    private boolean enableWebpPlaceholderOpt;

    public c3() {
        this.enableFollowNinePng = true;
        this.enableShopPaint = true;
        this.enableBackgroundWebp = true;
        this.enableExtendTopBorder = true;
        this.enableEnterAnimation = true;
        this.enableExitAnimation = true;
        this.enableWebpOpt = true;
        this.enableWebpPlaceholderOpt = true;
        this.enablePrepareWebpOpt = true;
    }
}
