package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b+\u0018\u00002\u00020\u0001B¥\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000e¢\u0006\u0002\u0010\u0014R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001cR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001cR\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0016\"\u0004\b\"\u0010\u0018R\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018R\u001e\u0010\u0010\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0016\"\u0004\b&\u0010\u0018R\u001e\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0016\"\u0004\b(\u0010\u0018R\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0016\"\u0004\b*\u0010\u0018R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0016\"\u0004\b,\u0010\u0018R\u001e\u0010\u0011\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0016\"\u0004\b.\u0010\u0018R\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0016\"\u0004\b0\u0010\u0018R\u001e\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0016\"\u0004\b2\u0010\u0018R\u001e\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0016\"\u0004\b4\u0010\u0018R\u001e\u0010\f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0016\"\u0004\b6\u0010\u0018R\u001e\u0010\u0012\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0016\"\u0004\b8\u0010\u0018¨\u00069"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/PlayerLivePlayerConfig;", "", "h264DecodeEnable", "", "byteVc1DecodeEnable", "ntpEnable", "fastOpenEnable", "enableBlurEffect", "enableHttpkDegrade", "enableUploadTimeLine", "rtsPreload", "previewRtsPreload", "tfoPreConnect", "dnsRequestRetryInterval", "", "dnsRequestMaxRetryTimes", "enableSessionId", "liveAudioMixedOpt", "useNewLivePlayerSDK", "clearObserverFixType", "(ZZZZZZZZZZIIZZZI)V", "getByteVc1DecodeEnable", "()Z", "setByteVc1DecodeEnable", "(Z)V", "getClearObserverFixType", "()I", "setClearObserverFixType", "(I)V", "getDnsRequestMaxRetryTimes", "setDnsRequestMaxRetryTimes", "getDnsRequestRetryInterval", "setDnsRequestRetryInterval", "getEnableBlurEffect", "setEnableBlurEffect", "getEnableHttpkDegrade", "setEnableHttpkDegrade", "getEnableSessionId", "setEnableSessionId", "getEnableUploadTimeLine", "setEnableUploadTimeLine", "getFastOpenEnable", "setFastOpenEnable", "getH264DecodeEnable", "setH264DecodeEnable", "getLiveAudioMixedOpt", "setLiveAudioMixedOpt", "getNtpEnable", "setNtpEnable", "getPreviewRtsPreload", "setPreviewRtsPreload", "getRtsPreload", "setRtsPreload", "getTfoPreConnect", "setTfoPreConnect", "getUseNewLivePlayerSDK", "setUseNewLivePlayerSDK", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayerLivePlayerConfig {

    @SerializedName("byte_vc1_decode_enable")
    private boolean byteVc1DecodeEnable;

    @SerializedName("clear_observer_fix_type")
    private int clearObserverFixType;

    @SerializedName("dns_request_max_retry_times")
    private int dnsRequestMaxRetryTimes;

    @SerializedName("dns_request_retry_intervar")
    private int dnsRequestRetryInterval;

    @SerializedName("enable_blur_effect")
    private boolean enableBlurEffect;

    @SerializedName("enable_httpk_degrade")
    private boolean enableHttpkDegrade;

    @SerializedName("enable_session_id")
    private boolean enableSessionId;

    @SerializedName("enable_upload_time_line")
    private boolean enableUploadTimeLine;

    @SerializedName("fast_open_enable")
    private boolean fastOpenEnable;

    @SerializedName("h264_decode_enable")
    private boolean h264DecodeEnable;

    @SerializedName("live_audio_mixed_opt")
    private boolean liveAudioMixedOpt;

    @SerializedName("ntp_enable")
    private boolean ntpEnable;

    @SerializedName("preview_rts_preload")
    private boolean previewRtsPreload;

    @SerializedName("rts_preload")
    private boolean rtsPreload;

    @SerializedName("tfo_pre_connect")
    private boolean tfoPreConnect;

    @SerializedName("use_new_live_player_sdk")
    private boolean useNewLivePlayerSDK;

    public PlayerLivePlayerConfig() {
        this(false, false, false, false, false, false, false, false, false, false, 0, 0, false, false, false, 0, 65535, null);
    }

    public final boolean getByteVc1DecodeEnable() {
        return this.byteVc1DecodeEnable;
    }

    public final int getClearObserverFixType() {
        return this.clearObserverFixType;
    }

    public final int getDnsRequestMaxRetryTimes() {
        return this.dnsRequestMaxRetryTimes;
    }

    public final int getDnsRequestRetryInterval() {
        return this.dnsRequestRetryInterval;
    }

    public final boolean getEnableBlurEffect() {
        return this.enableBlurEffect;
    }

    public final boolean getEnableHttpkDegrade() {
        return this.enableHttpkDegrade;
    }

    public final boolean getEnableSessionId() {
        return this.enableSessionId;
    }

    public final boolean getEnableUploadTimeLine() {
        return this.enableUploadTimeLine;
    }

    public final boolean getFastOpenEnable() {
        return this.fastOpenEnable;
    }

    public final boolean getH264DecodeEnable() {
        return this.h264DecodeEnable;
    }

    public final boolean getLiveAudioMixedOpt() {
        return this.liveAudioMixedOpt;
    }

    public final boolean getNtpEnable() {
        return this.ntpEnable;
    }

    public final boolean getPreviewRtsPreload() {
        return this.previewRtsPreload;
    }

    public final boolean getRtsPreload() {
        return this.rtsPreload;
    }

    public final boolean getTfoPreConnect() {
        return this.tfoPreConnect;
    }

    public final boolean getUseNewLivePlayerSDK() {
        return this.useNewLivePlayerSDK;
    }

    public final void setByteVc1DecodeEnable(boolean r100) {
        this.byteVc1DecodeEnable = r100;
    }

    public final void setClearObserverFixType(int r100) {
        this.clearObserverFixType = r100;
    }

    public final void setDnsRequestMaxRetryTimes(int r100) {
        this.dnsRequestMaxRetryTimes = r100;
    }

    public final void setDnsRequestRetryInterval(int r100) {
        this.dnsRequestRetryInterval = r100;
    }

    public final void setEnableBlurEffect(boolean r100) {
        this.enableBlurEffect = r100;
    }

    public final void setEnableHttpkDegrade(boolean r100) {
        this.enableHttpkDegrade = r100;
    }

    public final void setEnableSessionId(boolean r100) {
        this.enableSessionId = r100;
    }

    public final void setEnableUploadTimeLine(boolean r100) {
        this.enableUploadTimeLine = r100;
    }

    public final void setFastOpenEnable(boolean r100) {
        this.fastOpenEnable = r100;
    }

    public final void setH264DecodeEnable(boolean r100) {
        this.h264DecodeEnable = r100;
    }

    public final void setLiveAudioMixedOpt(boolean r100) {
        this.liveAudioMixedOpt = r100;
    }

    public final void setNtpEnable(boolean r100) {
        this.ntpEnable = r100;
    }

    public final void setPreviewRtsPreload(boolean r100) {
        this.previewRtsPreload = r100;
    }

    public final void setRtsPreload(boolean r100) {
        this.rtsPreload = r100;
    }

    public final void setTfoPreConnect(boolean r100) {
        this.tfoPreConnect = r100;
    }

    public final void setUseNewLivePlayerSDK(boolean r100) {
        this.useNewLivePlayerSDK = r100;
    }

    public PlayerLivePlayerConfig(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104, boolean r105, boolean r106, boolean r110, boolean r111, boolean r112, int r113, int r114, boolean r115, boolean r116, boolean r117, int r118) {
        this.h264DecodeEnable = r100;
        this.byteVc1DecodeEnable = r101;
        this.ntpEnable = r102;
        this.fastOpenEnable = r103;
        this.enableBlurEffect = r104;
        this.enableHttpkDegrade = r105;
        this.enableUploadTimeLine = r106;
        this.rtsPreload = r110;
        this.previewRtsPreload = r111;
        this.tfoPreConnect = r112;
        this.dnsRequestRetryInterval = r113;
        this.dnsRequestMaxRetryTimes = r114;
        this.enableSessionId = r115;
        this.liveAudioMixedOpt = r116;
        this.useNewLivePlayerSDK = r117;
        this.clearObserverFixType = r118;
    }

    public /* synthetic */ PlayerLivePlayerConfig(boolean r110, boolean r111, boolean r210, boolean r211, boolean r212, boolean r213, boolean r214, boolean r215, boolean r216, boolean r217, int r218, int r219, boolean r310, boolean r311, boolean r312, int r313, int r314, DefaultConstructorMarker r315) {
        boolean r100 = true;
        if ((r314 & 1) == 0) goto L5;
        boolean r101 = true;
    L7:
        if ((r314 & 2) == 0) goto L9;
        boolean r102 = true;
    L11:
        if ((r314 & 4) == 0) goto L13;
        boolean r103 = true;
    L15:
        if ((r314 & 8) == 0) goto L17;
        boolean r104 = true;
    L19:
        if ((r314 & 16) == 0) goto L21;
        boolean r105 = true;
    L23:
        if ((r314 & 32) == 0) goto L25;
        boolean r106 = false;
    L27:
        if ((r314 & 64) == 0) goto L29;
        boolean r107 = true;
    L31:
        if ((r314 & 128) == 0) goto L33;
        boolean r112 = true;
    L35:
        if ((r314 & 256) == 0) goto L37;
        boolean r113 = true;
    L39:
        if ((r314 & 512) != 0) goto L42;
        r100 = r217;
    L42:
        int r114 = 5;
        if ((r314 & 1024) == 0) goto L45;
        int r115 = 5;
    L47:
        if ((r314 & 2048) != 0) goto L51;
        r114 = r219;
    L51:
        if ((r314 & 4096) == 0) goto L53;
        boolean r116 = false;
    L55:
        if ((r314 & 8192) == 0) goto L57;
        boolean r117 = false;
    L59:
        if ((r314 & 16384) == 0) goto L61;
        boolean r108 = false;
    L63:
        if ((r314 & 32768) == 0) goto L65;
        int r109 = 0;
    L66:
        this(r101, r102, r103, r104, r105, r106, r107, r112, r113, r100, r115, r114, r116, r117, r108, r109);
        return;
    L65:
        r109 = r313;
        goto L66
    L61:
        r108 = r312;
        goto L63
    L57:
        r117 = r311;
        goto L59
    L53:
        r116 = r310;
        goto L55
    L45:
        r115 = r218;
        goto L47
    L37:
        r113 = r216;
        goto L39
    L33:
        r112 = r215;
        goto L35
    L29:
        r107 = r214;
        goto L31
    L25:
        r106 = r213;
        goto L27
    L21:
        r105 = r212;
        goto L23
    L17:
        r104 = r211;
        goto L19
    L13:
        r103 = r210;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
