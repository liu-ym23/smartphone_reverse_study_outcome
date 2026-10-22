package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006J\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/type/LiveWrappedAudioRecordingErrorCode;", "", "", "value", "I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "AUDIO_RECORDING_ERROR_CODE_OK", "AUDIO_RECORDING_ERROR_CODE_NO_PERMISSION", "AUDIO_RECORDING_ERROR_CODE_NOT_IN_ROOM", "AUDIO_RECORDING_ERROR_CODE_ALREADY_STARTED", "AUDIO_RECORDING_ERROR_CODE_NOT_STARTED", "AUDIO_RECORDING_ERROR_CODE_NOT_SUPPORT", "AUDIO_RECORDING_ERROR_CODE_OTHER", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedAudioRecordingErrorCode extends Enum<LiveWrappedAudioRecordingErrorCode> {
    public static final LiveWrappedAudioRecordingErrorCode AUDIO_RECORDING_ERROR_CODE_ALREADY_STARTED = null;
    public static final LiveWrappedAudioRecordingErrorCode AUDIO_RECORDING_ERROR_CODE_NOT_IN_ROOM = null;
    public static final LiveWrappedAudioRecordingErrorCode AUDIO_RECORDING_ERROR_CODE_NOT_STARTED = null;
    public static final LiveWrappedAudioRecordingErrorCode AUDIO_RECORDING_ERROR_CODE_NOT_SUPPORT = null;
    public static final LiveWrappedAudioRecordingErrorCode AUDIO_RECORDING_ERROR_CODE_NO_PERMISSION = null;
    public static final LiveWrappedAudioRecordingErrorCode AUDIO_RECORDING_ERROR_CODE_OK = null;
    public static final LiveWrappedAudioRecordingErrorCode AUDIO_RECORDING_ERROR_CODE_OTHER = null;
    public static final a Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedAudioRecordingErrorCode[] f147414a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedAudioRecordingErrorCode$a] */
    static {
        LiveWrappedAudioRecordingErrorCode r100 = new LiveWrappedAudioRecordingErrorCode("AUDIO_RECORDING_ERROR_CODE_OK", 0, 0);
        AUDIO_RECORDING_ERROR_CODE_OK = r100;
        LiveWrappedAudioRecordingErrorCode r101 = new LiveWrappedAudioRecordingErrorCode("AUDIO_RECORDING_ERROR_CODE_NO_PERMISSION", 1, -1);
        AUDIO_RECORDING_ERROR_CODE_NO_PERMISSION = r101;
        LiveWrappedAudioRecordingErrorCode r102 = new LiveWrappedAudioRecordingErrorCode("AUDIO_RECORDING_ERROR_CODE_NOT_IN_ROOM", 2, -2);
        AUDIO_RECORDING_ERROR_CODE_NOT_IN_ROOM = r102;
        LiveWrappedAudioRecordingErrorCode r103 = new LiveWrappedAudioRecordingErrorCode("AUDIO_RECORDING_ERROR_CODE_ALREADY_STARTED", 3, -3);
        AUDIO_RECORDING_ERROR_CODE_ALREADY_STARTED = r103;
        LiveWrappedAudioRecordingErrorCode r104 = new LiveWrappedAudioRecordingErrorCode("AUDIO_RECORDING_ERROR_CODE_NOT_STARTED", 4, -4);
        AUDIO_RECORDING_ERROR_CODE_NOT_STARTED = r104;
        LiveWrappedAudioRecordingErrorCode r105 = new LiveWrappedAudioRecordingErrorCode("AUDIO_RECORDING_ERROR_CODE_NOT_SUPPORT", 5, -5);
        AUDIO_RECORDING_ERROR_CODE_NOT_SUPPORT = r105;
        LiveWrappedAudioRecordingErrorCode r106 = new LiveWrappedAudioRecordingErrorCode("AUDIO_RECORDING_ERROR_CODE_OTHER", 6, -6);
        AUDIO_RECORDING_ERROR_CODE_OTHER = r106;
        f147414a = new LiveWrappedAudioRecordingErrorCode[]{r100, r101, r102, r103, r104, r105, r106};
        Companion = new a();
    }

    public static LiveWrappedAudioRecordingErrorCode valueOf(String r100) {
        return (LiveWrappedAudioRecordingErrorCode) r27.a.a(LiveWrappedAudioRecordingErrorCode.class, r100);
    }

    public static LiveWrappedAudioRecordingErrorCode[] values() {
        return (LiveWrappedAudioRecordingErrorCode[]) f147414a.clone();
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedAudioRecordingErrorCode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
