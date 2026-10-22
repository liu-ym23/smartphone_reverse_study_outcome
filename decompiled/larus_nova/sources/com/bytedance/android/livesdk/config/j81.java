package com.bytedance.android.livesdk.config;

import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0018\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bH\u0010IR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010&\u001a\u00020%8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010,\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010\u0004\u001a\u0004\b-\u0010\u0006\"\u0004\b.\u0010\bR\"\u0010/\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010\u0004\u001a\u0004\b0\u0010\u0006\"\u0004\b1\u0010\bR\"\u00103\u001a\u0002028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u00109\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b9\u0010 \u001a\u0004\b:\u0010\"\"\u0004\b;\u0010$R\"\u0010<\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b<\u0010 \u001a\u0004\b=\u0010\"\"\u0004\b>\u0010$R\"\u0010?\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b?\u0010\u0004\u001a\u0004\b@\u0010\u0006\"\u0004\bA\u0010\bR\"\u0010B\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bB\u0010 \u001a\u0004\bC\u0010\"\"\u0004\bD\u0010$R\"\u0010E\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bE\u0010 \u001a\u0004\bF\u0010\"\"\u0004\bG\u0010$¨\u0006J"}, d2 = {"Lcom/bytedance/android/livesdk/config/j81;", "", "", "aedDetectionTime", "I", "b", "()I", "setAedDetectionTime", "(I)V", "aedDetectionEnterCount", "getAedDetectionEnterCount", "setAedDetectionEnterCount", "aedDetectionQuitCount", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setAedDetectionQuitCount", "audioCacheDuration", "d", "setAudioCacheDuration", "audioCacheDurationV2", "e", "setAudioCacheDurationV2", "recognitionRetryCount", "getRecognitionRetryCount", "setRecognitionRetryCount", "fingerprintThreshold", "getFingerprintThreshold", "setFingerprintThreshold", "verifyThreshold", OfficeSDKRequestTag.KEY_NEW_USER, "setVerifyThreshold", "", "enableVerity", "Z", com.amap.api.col.s.ce.f26396k, "()Z", "setEnableVerity", "(Z)V", "", "verityInterval", "J", "o", "()J", "setVerityInterval", "(J)V", "recognitionProgressDelayTime", "l", "setRecognitionProgressDelayTime", "seiInterval", "m", "setSeiInterval", "", "cacheBufferPercentage", FaceService.girlLabel, "f", "()F", "setCacheBufferPercentage", "(F)V", "enableCoverPriority", "h", "setEnableCoverPriority", "enableResultCheck", com.amap.api.col.s.ce.f26395j, "setEnableResultCheck", "aedDurationTime", "c", "setAedDurationTime", "enableGuestStream", RXScreenCaptureService.KEY_INDEX, "setEnableGuestStream", "disableAnchorStream", com.amap.api.col.s.ce.f26391f, "setDisableAnchorStream", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class j81 {

    @SerializedName("aed_detection_enter_count")
    private int aedDetectionEnterCount;

    @SerializedName("aed_detection_quit_count")
    private int aedDetectionQuitCount;

    @SerializedName("aed_detection_time")
    private int aedDetectionTime;

    @SerializedName("aed_duration_time")
    private int aedDurationTime;

    @SerializedName("audio_cache_duration")
    private int audioCacheDuration;

    @SerializedName("audio_cache_duration_v2")
    private int audioCacheDurationV2;

    @SerializedName("cache_buffer_percentage")
    private float cacheBufferPercentage;

    @SerializedName("disable_anchor_stream")
    private boolean disableAnchorStream;

    @SerializedName("enable_cover_priority")
    private boolean enableCoverPriority;

    @SerializedName("enable_guest_stream")
    private boolean enableGuestStream;

    @SerializedName("enable_result_check")
    private boolean enableResultCheck;

    @SerializedName("enable_verify")
    private boolean enableVerity;

    @SerializedName("origin_threshold")
    private int fingerprintThreshold;

    @SerializedName("android_anchor_time_delay")
    private int recognitionProgressDelayTime;

    @SerializedName("audio_retry_count")
    private int recognitionRetryCount;

    @SerializedName("lyric_recognization_sei_interval")
    private int seiInterval;

    @SerializedName("verify_threshold")
    private int verifyThreshold;

    @SerializedName("verify_interval")
    private long verityInterval;

    public j81() {
        this.aedDetectionTime = 2000;
        this.aedDetectionEnterCount = 2;
        this.aedDetectionQuitCount = 3;
        this.audioCacheDuration = 15000;
        this.audioCacheDurationV2 = 20000;
        this.recognitionRetryCount = 1;
        this.fingerprintThreshold = 70;
        this.verifyThreshold = 70;
        this.enableVerity = true;
        this.verityInterval = 60;
        this.recognitionProgressDelayTime = 300;
        this.seiInterval = 1000;
        this.cacheBufferPercentage = 0.75f;
        this.enableCoverPriority = true;
        this.aedDurationTime = 50;
        this.enableGuestStream = true;
    }

    public final int a() {
        return this.aedDetectionQuitCount;
    }

    public final int b() {
        return this.aedDetectionTime;
    }

    public final int c() {
        return this.aedDurationTime;
    }

    public final int d() {
        return this.audioCacheDuration;
    }

    public final int e() {
        return this.audioCacheDurationV2;
    }

    public final float f() {
        return this.cacheBufferPercentage;
    }

    public final boolean g() {
        return this.disableAnchorStream;
    }

    public final boolean h() {
        return this.enableCoverPriority;
    }

    public final boolean i() {
        return this.enableGuestStream;
    }

    public final boolean j() {
        return this.enableResultCheck;
    }

    public final boolean k() {
        return this.enableVerity;
    }

    public final int l() {
        return this.recognitionProgressDelayTime;
    }

    public final int m() {
        return this.seiInterval;
    }

    public final int n() {
        return this.verifyThreshold;
    }

    public final long o() {
        return this.verityInterval;
    }
}
