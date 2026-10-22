package com.bytedance.android.livesdk.interactivity.api.settings.config;

import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/settings/config/h0;", "", "", "trackCount", "I", "d", "()I", "setTrackCount", "(I)V", "speedStyle", "c", "setSpeedStyle", "fontSizeStyle", "b", "setFontSizeStyle", "", "alphaPercent", FaceService.girlLabel, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()F", "setAlphaPercent", "(F)V", "<init>", "()V", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h0 {

    @SerializedName("alpha_percent")
    private float alphaPercent;

    @SerializedName("font_size_style")
    private int fontSizeStyle;

    @SerializedName("speed_style")
    private int speedStyle;

    @SerializedName("track_count")
    private int trackCount;

    public h0() {
        this.trackCount = 2;
        this.speedStyle = 2;
        this.fontSizeStyle = 2;
        this.alphaPercent = 80.0f;
    }

    public final float a() {
        return this.alphaPercent;
    }

    public final int b() {
        return this.fontSizeStyle;
    }

    public final int c() {
        return this.speedStyle;
    }

    public final int d() {
        return this.trackCount;
    }
}
