package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0011\u0018\u00002\u00020\u0001BY\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\n\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/PlayerVrConfig;", "", "vrEnable", "", "backgroundImgEnable", "subcameraBgImgEnable", "vpaasResolutionDisable", "defaultBackgroundImgUrl", "", "backgroundImgOnly180", "backgroundImgPico180", "vrSensorSmoothFactor", "", "(ZZZZLjava/lang/String;ZLjava/lang/String;F)V", "getBackgroundImgEnable", "()Z", "getBackgroundImgOnly180", "getBackgroundImgPico180", "()Ljava/lang/String;", "getDefaultBackgroundImgUrl", "getSubcameraBgImgEnable", "getVpaasResolutionDisable", "getVrEnable", "setVrEnable", "(Z)V", "getVrSensorSmoothFactor", "()F", "setVrSensorSmoothFactor", "(F)V", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayerVrConfig {

    @SerializedName("background_img_enable")
    private final boolean backgroundImgEnable;

    @SerializedName("background_img_only_180")
    private final boolean backgroundImgOnly180;

    @SerializedName("background_img_pico_180")
    private final String backgroundImgPico180;

    @SerializedName("background_img_url")
    private final String defaultBackgroundImgUrl;

    @SerializedName("subcamera_bg_img_enable")
    private final boolean subcameraBgImgEnable;

    @SerializedName("vpaas_resolution_disable")
    private final boolean vpaasResolutionDisable;

    @SerializedName("enable")
    private boolean vrEnable;

    @SerializedName("vr_sensor_smooth_factor")
    private float vrSensorSmoothFactor;

    public PlayerVrConfig() {
        this(false, false, false, false, null, false, null, 0.0f, 255, null);
    }

    public final boolean getBackgroundImgEnable() {
        return this.backgroundImgEnable;
    }

    public final boolean getBackgroundImgOnly180() {
        return this.backgroundImgOnly180;
    }

    public final String getBackgroundImgPico180() {
        return this.backgroundImgPico180;
    }

    public final String getDefaultBackgroundImgUrl() {
        return this.defaultBackgroundImgUrl;
    }

    public final boolean getSubcameraBgImgEnable() {
        return this.subcameraBgImgEnable;
    }

    public final boolean getVpaasResolutionDisable() {
        return this.vpaasResolutionDisable;
    }

    public final boolean getVrEnable() {
        return this.vrEnable;
    }

    public final float getVrSensorSmoothFactor() {
        return this.vrSensorSmoothFactor;
    }

    public final void setVrEnable(boolean r100) {
        this.vrEnable = r100;
    }

    public final void setVrSensorSmoothFactor(float r100) {
        this.vrSensorSmoothFactor = r100;
    }

    public PlayerVrConfig(boolean r100, boolean r101, boolean r102, boolean r103, String r104, boolean r105, String r106, float r107) {
        this.vrEnable = r100;
        this.backgroundImgEnable = r101;
        this.subcameraBgImgEnable = r102;
        this.vpaasResolutionDisable = r103;
        this.defaultBackgroundImgUrl = r104;
        this.backgroundImgOnly180 = r105;
        this.backgroundImgPico180 = r106;
        this.vrSensorSmoothFactor = r107;
    }

    public /* synthetic */ PlayerVrConfig(boolean r110, boolean r111, boolean r112, boolean r113, String r114, boolean r115, String r116, float r117, int r118, DefaultConstructorMarker r119) {
        boolean r100 = true;
        if ((r118 & 1) == 0) goto L5;
        boolean r101 = true;
    L7:
        if ((r118 & 2) == 0) goto L9;
        boolean r102 = true;
    L11:
        if ((r118 & 4) == 0) goto L13;
        boolean r103 = true;
    L15:
        if ((r118 & 8) == 0) goto L17;
        boolean r104 = true;
    L18:
        String r105 = "";
        if ((r118 & 16) == 0) goto L21;
        String r106 = "";
    L23:
        if ((r118 & 32) != 0) goto L27;
        r100 = r115;
    L27:
        if ((r118 & 64) != 0) goto L31;
        r105 = r116;
    L31:
        if ((r118 & 128) == 0) goto L33;
        float r107 = -1.0f;
    L34:
        this(r101, r102, r103, r104, r106, r100, r105, r107);
        return;
    L33:
        r107 = r117;
        goto L34
    L21:
        r106 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L18
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
