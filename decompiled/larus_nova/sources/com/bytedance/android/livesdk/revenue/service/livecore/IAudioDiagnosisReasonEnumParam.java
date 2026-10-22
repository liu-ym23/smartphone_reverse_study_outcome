package com.bytedance.android.livesdk.revenue.service.livecore;

import com.ss.bytertc.engine.type.WarningCode;
import com.ss.ttvideoengine.log.VideoEventOnePlay;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0014\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/revenue/service/livecore/IAudioDiagnosisReasonEnumParam;", "", "", "value", "I", "getValue", "()I", "AudioDiagnosisReasonNoAbnormality", "AudioDiagnosisReasonCaptureMutedData", "AudioDiagnosisReasonCaptureFrameRateZero", "AudioDiagnosisReasonPlaybackFrameRateZero", "AudioDiagnosisReasonPermissionDenied", "AudioDiagnosisReasonAndroidDeviceOccupied", "AudioDiagnosisReasonSpeakerSystemMuted", "AudioDiagnosisReasonLowSpeakerSystemVolume", "AudioDiagnosisReasonLowCaptureLevel", "AudioDiagnosisReasonHighAecSuppression", "AudioDiagnosisReasonHighMediaPlayerLevel", "AudioDiagnosisReasonCaptureDeviceNotStart", "AudioDiagnosisReasonLowCaptureVolume", "AudioDiagnosisReasonCaptureFrameRateError", "AudioDiagnosisReasonPlaybackFrameRateError", "live-kmp-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum IAudioDiagnosisReasonEnumParam extends Enum<IAudioDiagnosisReasonEnumParam> {
    public static final IAudioDiagnosisReasonEnumParam AudioDiagnosisReasonAndroidDeviceOccupied = null;
    public static final IAudioDiagnosisReasonEnumParam AudioDiagnosisReasonCaptureDeviceNotStart = null;
    public static final IAudioDiagnosisReasonEnumParam AudioDiagnosisReasonCaptureFrameRateError = null;
    public static final IAudioDiagnosisReasonEnumParam AudioDiagnosisReasonCaptureFrameRateZero = null;
    public static final IAudioDiagnosisReasonEnumParam AudioDiagnosisReasonCaptureMutedData = null;
    public static final IAudioDiagnosisReasonEnumParam AudioDiagnosisReasonHighAecSuppression = null;
    public static final IAudioDiagnosisReasonEnumParam AudioDiagnosisReasonHighMediaPlayerLevel = null;
    public static final IAudioDiagnosisReasonEnumParam AudioDiagnosisReasonLowCaptureLevel = null;
    public static final IAudioDiagnosisReasonEnumParam AudioDiagnosisReasonLowCaptureVolume = null;
    public static final IAudioDiagnosisReasonEnumParam AudioDiagnosisReasonLowSpeakerSystemVolume = null;
    public static final IAudioDiagnosisReasonEnumParam AudioDiagnosisReasonNoAbnormality = null;
    public static final IAudioDiagnosisReasonEnumParam AudioDiagnosisReasonPermissionDenied = null;
    public static final IAudioDiagnosisReasonEnumParam AudioDiagnosisReasonPlaybackFrameRateError = null;
    public static final IAudioDiagnosisReasonEnumParam AudioDiagnosisReasonPlaybackFrameRateZero = null;
    public static final IAudioDiagnosisReasonEnumParam AudioDiagnosisReasonSpeakerSystemMuted = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IAudioDiagnosisReasonEnumParam[] f157365a = null;
    private final int value;

    public static IAudioDiagnosisReasonEnumParam valueOf(String r100) {
        return (IAudioDiagnosisReasonEnumParam) a.a(IAudioDiagnosisReasonEnumParam.class, r100);
    }

    public static IAudioDiagnosisReasonEnumParam[] values() {
        return (IAudioDiagnosisReasonEnumParam[]) f157365a.clone();
    }

    static {
        IAudioDiagnosisReasonEnumParam r100 = new IAudioDiagnosisReasonEnumParam("AudioDiagnosisReasonNoAbnormality", 0, 0);
        AudioDiagnosisReasonNoAbnormality = r100;
        IAudioDiagnosisReasonEnumParam r101 = new IAudioDiagnosisReasonEnumParam("AudioDiagnosisReasonCaptureMutedData", 1, -1000);
        AudioDiagnosisReasonCaptureMutedData = r101;
        IAudioDiagnosisReasonEnumParam r102 = new IAudioDiagnosisReasonEnumParam("AudioDiagnosisReasonCaptureFrameRateZero", 2, -1001);
        AudioDiagnosisReasonCaptureFrameRateZero = r102;
        IAudioDiagnosisReasonEnumParam r103 = new IAudioDiagnosisReasonEnumParam("AudioDiagnosisReasonPlaybackFrameRateZero", 3, -1002);
        AudioDiagnosisReasonPlaybackFrameRateZero = r103;
        IAudioDiagnosisReasonEnumParam r104 = new IAudioDiagnosisReasonEnumParam("AudioDiagnosisReasonPermissionDenied", 4, -1005);
        AudioDiagnosisReasonPermissionDenied = r104;
        IAudioDiagnosisReasonEnumParam r105 = new IAudioDiagnosisReasonEnumParam("AudioDiagnosisReasonAndroidDeviceOccupied", 5, -2005);
        AudioDiagnosisReasonAndroidDeviceOccupied = r105;
        IAudioDiagnosisReasonEnumParam r106 = new IAudioDiagnosisReasonEnumParam("AudioDiagnosisReasonSpeakerSystemMuted", 6, -2006);
        AudioDiagnosisReasonSpeakerSystemMuted = r106;
        IAudioDiagnosisReasonEnumParam r107 = new IAudioDiagnosisReasonEnumParam("AudioDiagnosisReasonLowSpeakerSystemVolume", 7, -2007);
        AudioDiagnosisReasonLowSpeakerSystemVolume = r107;
        IAudioDiagnosisReasonEnumParam r108 = new IAudioDiagnosisReasonEnumParam("AudioDiagnosisReasonLowCaptureLevel", 8, VideoEventOnePlay.EXIT_CODE_AFTER_NO_AUDIO_RENDER);
        AudioDiagnosisReasonLowCaptureLevel = r108;
        IAudioDiagnosisReasonEnumParam r109 = new IAudioDiagnosisReasonEnumParam("AudioDiagnosisReasonHighAecSuppression", 9, -2009);
        AudioDiagnosisReasonHighAecSuppression = r109;
        IAudioDiagnosisReasonEnumParam r110 = new IAudioDiagnosisReasonEnumParam("AudioDiagnosisReasonHighMediaPlayerLevel", 10, WarningCode.WARNING_CODE_SUBSCRIBE_STREAM_FORBIDEN);
        AudioDiagnosisReasonHighMediaPlayerLevel = r110;
        IAudioDiagnosisReasonEnumParam r111 = new IAudioDiagnosisReasonEnumParam("AudioDiagnosisReasonCaptureDeviceNotStart", 11, WarningCode.WARNING_CODE_SEND_CUSTOM_MESSAGE);
        AudioDiagnosisReasonCaptureDeviceNotStart = r111;
        IAudioDiagnosisReasonEnumParam r112 = new IAudioDiagnosisReasonEnumParam("AudioDiagnosisReasonLowCaptureVolume", 12, WarningCode.WARNING_CODE_RECEIVE_USER_NOTIFY_STOP);
        AudioDiagnosisReasonLowCaptureVolume = r112;
        IAudioDiagnosisReasonEnumParam r113 = new IAudioDiagnosisReasonEnumParam("AudioDiagnosisReasonCaptureFrameRateError", 13, WarningCode.WARNING_CODE_ROOM_ID_ALREADY_EXIST);
        AudioDiagnosisReasonCaptureFrameRateError = r113;
        IAudioDiagnosisReasonEnumParam r114 = new IAudioDiagnosisReasonEnumParam("AudioDiagnosisReasonPlaybackFrameRateError", 14, -2016);
        AudioDiagnosisReasonPlaybackFrameRateError = r114;
        f157365a = new IAudioDiagnosisReasonEnumParam[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114};
    }

    public final int getValue() {
        return this.value;
    }

    public IAudioDiagnosisReasonEnumParam(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
