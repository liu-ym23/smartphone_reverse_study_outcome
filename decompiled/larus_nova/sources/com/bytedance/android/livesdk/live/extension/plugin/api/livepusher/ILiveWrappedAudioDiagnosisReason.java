package com.bytedance.android.livesdk.live.extension.plugin.api.livepusher;

import com.ss.bytertc.engine.type.WarningCode;
import com.ss.ttvideoengine.log.VideoEventOnePlay;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/livepusher/ILiveWrappedAudioDiagnosisReason;", "", "", "value", "I", "AudioDiagnosisReasonNoAbnormality", "AudioDiagnosisReasonCaptureMutedData", "AudioDiagnosisReasonCaptureFrameRateZero", "AudioDiagnosisReasonPlaybackFrameRateZero", "AudioDiagnosisReasonPermissionDenied", "AudioDiagnosisReasonAndroidDeviceOccupied", "AudioDiagnosisReasonSpeakerSystemMuted", "AudioDiagnosisReasonLowSpeakerSystemVolume", "AudioDiagnosisReasonLowCaptureLevel", "AudioDiagnosisReasonHighAecSuppression", "AudioDiagnosisReasonHighMediaPlayerLevel", "AudioDiagnosisReasonCaptureDeviceNotStart", "AudioDiagnosisReasonLowCaptureVolume", "AudioDiagnosisReasonCaptureFrameRateError", "AudioDiagnosisReasonPlaybackFrameRateError", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ILiveWrappedAudioDiagnosisReason extends Enum<ILiveWrappedAudioDiagnosisReason> {
    public static final ILiveWrappedAudioDiagnosisReason AudioDiagnosisReasonAndroidDeviceOccupied = null;
    public static final ILiveWrappedAudioDiagnosisReason AudioDiagnosisReasonCaptureDeviceNotStart = null;
    public static final ILiveWrappedAudioDiagnosisReason AudioDiagnosisReasonCaptureFrameRateError = null;
    public static final ILiveWrappedAudioDiagnosisReason AudioDiagnosisReasonCaptureFrameRateZero = null;
    public static final ILiveWrappedAudioDiagnosisReason AudioDiagnosisReasonCaptureMutedData = null;
    public static final ILiveWrappedAudioDiagnosisReason AudioDiagnosisReasonHighAecSuppression = null;
    public static final ILiveWrappedAudioDiagnosisReason AudioDiagnosisReasonHighMediaPlayerLevel = null;
    public static final ILiveWrappedAudioDiagnosisReason AudioDiagnosisReasonLowCaptureLevel = null;
    public static final ILiveWrappedAudioDiagnosisReason AudioDiagnosisReasonLowCaptureVolume = null;
    public static final ILiveWrappedAudioDiagnosisReason AudioDiagnosisReasonLowSpeakerSystemVolume = null;
    public static final ILiveWrappedAudioDiagnosisReason AudioDiagnosisReasonNoAbnormality = null;
    public static final ILiveWrappedAudioDiagnosisReason AudioDiagnosisReasonPermissionDenied = null;
    public static final ILiveWrappedAudioDiagnosisReason AudioDiagnosisReasonPlaybackFrameRateError = null;
    public static final ILiveWrappedAudioDiagnosisReason AudioDiagnosisReasonPlaybackFrameRateZero = null;
    public static final ILiveWrappedAudioDiagnosisReason AudioDiagnosisReasonSpeakerSystemMuted = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ILiveWrappedAudioDiagnosisReason[] f147288a = null;
    private final int value;

    public static ILiveWrappedAudioDiagnosisReason valueOf(String r100) {
        return (ILiveWrappedAudioDiagnosisReason) a.a(ILiveWrappedAudioDiagnosisReason.class, r100);
    }

    public static ILiveWrappedAudioDiagnosisReason[] values() {
        return (ILiveWrappedAudioDiagnosisReason[]) f147288a.clone();
    }

    static {
        ILiveWrappedAudioDiagnosisReason r100 = new ILiveWrappedAudioDiagnosisReason("AudioDiagnosisReasonNoAbnormality", 0, 0);
        AudioDiagnosisReasonNoAbnormality = r100;
        ILiveWrappedAudioDiagnosisReason r101 = new ILiveWrappedAudioDiagnosisReason("AudioDiagnosisReasonCaptureMutedData", 1, -1000);
        AudioDiagnosisReasonCaptureMutedData = r101;
        ILiveWrappedAudioDiagnosisReason r102 = new ILiveWrappedAudioDiagnosisReason("AudioDiagnosisReasonCaptureFrameRateZero", 2, -1001);
        AudioDiagnosisReasonCaptureFrameRateZero = r102;
        ILiveWrappedAudioDiagnosisReason r103 = new ILiveWrappedAudioDiagnosisReason("AudioDiagnosisReasonPlaybackFrameRateZero", 3, -1002);
        AudioDiagnosisReasonPlaybackFrameRateZero = r103;
        ILiveWrappedAudioDiagnosisReason r104 = new ILiveWrappedAudioDiagnosisReason("AudioDiagnosisReasonPermissionDenied", 4, -1005);
        AudioDiagnosisReasonPermissionDenied = r104;
        ILiveWrappedAudioDiagnosisReason r105 = new ILiveWrappedAudioDiagnosisReason("AudioDiagnosisReasonAndroidDeviceOccupied", 5, -2005);
        AudioDiagnosisReasonAndroidDeviceOccupied = r105;
        ILiveWrappedAudioDiagnosisReason r106 = new ILiveWrappedAudioDiagnosisReason("AudioDiagnosisReasonSpeakerSystemMuted", 6, -2006);
        AudioDiagnosisReasonSpeakerSystemMuted = r106;
        ILiveWrappedAudioDiagnosisReason r107 = new ILiveWrappedAudioDiagnosisReason("AudioDiagnosisReasonLowSpeakerSystemVolume", 7, -2007);
        AudioDiagnosisReasonLowSpeakerSystemVolume = r107;
        ILiveWrappedAudioDiagnosisReason r108 = new ILiveWrappedAudioDiagnosisReason("AudioDiagnosisReasonLowCaptureLevel", 8, VideoEventOnePlay.EXIT_CODE_AFTER_NO_AUDIO_RENDER);
        AudioDiagnosisReasonLowCaptureLevel = r108;
        ILiveWrappedAudioDiagnosisReason r109 = new ILiveWrappedAudioDiagnosisReason("AudioDiagnosisReasonHighAecSuppression", 9, -2009);
        AudioDiagnosisReasonHighAecSuppression = r109;
        ILiveWrappedAudioDiagnosisReason r110 = new ILiveWrappedAudioDiagnosisReason("AudioDiagnosisReasonHighMediaPlayerLevel", 10, WarningCode.WARNING_CODE_SUBSCRIBE_STREAM_FORBIDEN);
        AudioDiagnosisReasonHighMediaPlayerLevel = r110;
        ILiveWrappedAudioDiagnosisReason r111 = new ILiveWrappedAudioDiagnosisReason("AudioDiagnosisReasonCaptureDeviceNotStart", 11, WarningCode.WARNING_CODE_SEND_CUSTOM_MESSAGE);
        AudioDiagnosisReasonCaptureDeviceNotStart = r111;
        ILiveWrappedAudioDiagnosisReason r112 = new ILiveWrappedAudioDiagnosisReason("AudioDiagnosisReasonLowCaptureVolume", 12, WarningCode.WARNING_CODE_RECEIVE_USER_NOTIFY_STOP);
        AudioDiagnosisReasonLowCaptureVolume = r112;
        ILiveWrappedAudioDiagnosisReason r113 = new ILiveWrappedAudioDiagnosisReason("AudioDiagnosisReasonCaptureFrameRateError", 13, WarningCode.WARNING_CODE_ROOM_ID_ALREADY_EXIST);
        AudioDiagnosisReasonCaptureFrameRateError = r113;
        ILiveWrappedAudioDiagnosisReason r114 = new ILiveWrappedAudioDiagnosisReason("AudioDiagnosisReasonPlaybackFrameRateError", 14, -2016);
        AudioDiagnosisReasonPlaybackFrameRateError = r114;
        f147288a = new ILiveWrappedAudioDiagnosisReason[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114};
    }

    public final int value() {
        return this.value;
    }

    public ILiveWrappedAudioDiagnosisReason(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
