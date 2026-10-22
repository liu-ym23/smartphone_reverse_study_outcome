package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006J\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/type/LiveWrappedRecordingErrorCode;", "", "", "value", "I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "RECORDING_ERROR_CODE_OK", "RECORDING_ERROR_CODE_NO_PERMISSION", "RECORDING_ERROR_CODE_NOT_SUPPORT", "RECORDING_ERROR_CODE_NO_OTHER", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedRecordingErrorCode extends Enum<LiveWrappedRecordingErrorCode> {
    public static final a Companion = null;
    public static final LiveWrappedRecordingErrorCode RECORDING_ERROR_CODE_NOT_SUPPORT = null;
    public static final LiveWrappedRecordingErrorCode RECORDING_ERROR_CODE_NO_OTHER = null;
    public static final LiveWrappedRecordingErrorCode RECORDING_ERROR_CODE_NO_PERMISSION = null;
    public static final LiveWrappedRecordingErrorCode RECORDING_ERROR_CODE_OK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedRecordingErrorCode[] f147436a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedRecordingErrorCode$a] */
    static {
        LiveWrappedRecordingErrorCode r100 = new LiveWrappedRecordingErrorCode("RECORDING_ERROR_CODE_OK", 0, 0);
        RECORDING_ERROR_CODE_OK = r100;
        LiveWrappedRecordingErrorCode r101 = new LiveWrappedRecordingErrorCode("RECORDING_ERROR_CODE_NO_PERMISSION", 1, -1);
        RECORDING_ERROR_CODE_NO_PERMISSION = r101;
        LiveWrappedRecordingErrorCode r102 = new LiveWrappedRecordingErrorCode("RECORDING_ERROR_CODE_NOT_SUPPORT", 2, -2);
        RECORDING_ERROR_CODE_NOT_SUPPORT = r102;
        LiveWrappedRecordingErrorCode r103 = new LiveWrappedRecordingErrorCode("RECORDING_ERROR_CODE_NO_OTHER", 3, -3);
        RECORDING_ERROR_CODE_NO_OTHER = r103;
        f147436a = new LiveWrappedRecordingErrorCode[]{r100, r101, r102, r103};
        Companion = new a();
    }

    public static LiveWrappedRecordingErrorCode valueOf(String r100) {
        return (LiveWrappedRecordingErrorCode) r27.a.a(LiveWrappedRecordingErrorCode.class, r100);
    }

    public static LiveWrappedRecordingErrorCode[] values() {
        return (LiveWrappedRecordingErrorCode[]) f147436a.clone();
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedRecordingErrorCode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
