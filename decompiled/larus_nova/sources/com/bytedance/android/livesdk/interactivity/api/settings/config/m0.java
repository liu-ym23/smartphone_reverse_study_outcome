package com.bytedance.android.livesdk.interactivity.api.settings.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\b¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/settings/config/m0;", "", "", "enable", "Z", "c", "()Z", "setEnable", "(Z)V", "", "defaultHeight", "I", "b", "()I", "setDefaultHeight", "(I)V", "defaultFontSize", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setDefaultFontSize", "fullWidth", "e", "setFullWidth", "enableStickerOpt", "d", "setEnableStickerOpt", "mockSmallScreen", "f", "setMockSmallScreen", "<init>", "()V", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class m0 {

    @SerializedName("default_font_size")
    private int defaultFontSize;

    @SerializedName("default_height")
    private int defaultHeight;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("enable_sticker_opt")
    private boolean enableStickerOpt;

    @SerializedName("full_width")
    private boolean fullWidth;

    @SerializedName("mock_small_screen")
    private boolean mockSmallScreen;

    public m0() {
        this.enable = true;
        this.fullWidth = true;
        this.enableStickerOpt = true;
    }

    public final int a() {
        return this.defaultFontSize;
    }

    public final int b() {
        return this.defaultHeight;
    }

    public final boolean c() {
        return this.enable;
    }

    public final boolean d() {
        return this.enableStickerOpt;
    }

    public final boolean e() {
        return this.fullWidth;
    }

    public final boolean f() {
        return this.mockSmallScreen;
    }
}
