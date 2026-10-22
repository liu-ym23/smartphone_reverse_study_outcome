package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/type/LiveWrappedHardwareEchoDetectionResult;", "", "", "value", "I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "HARDWARE_ECHO_RESULT_CANCELED", "HARDWARE_ECHO_RESULT_UNKNOWN", "HARDWARE_ECHO_RESULT_NORMAL", "HARDWARE_ECHO_RESULT_POOR", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedHardwareEchoDetectionResult extends Enum<LiveWrappedHardwareEchoDetectionResult> {
    public static final a Companion = null;
    public static final LiveWrappedHardwareEchoDetectionResult HARDWARE_ECHO_RESULT_CANCELED = null;
    public static final LiveWrappedHardwareEchoDetectionResult HARDWARE_ECHO_RESULT_NORMAL = null;
    public static final LiveWrappedHardwareEchoDetectionResult HARDWARE_ECHO_RESULT_POOR = null;
    public static final LiveWrappedHardwareEchoDetectionResult HARDWARE_ECHO_RESULT_UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedHardwareEchoDetectionResult[] f147422a = null;
    private final int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedHardwareEchoDetectionResult$a] */
    static {
        LiveWrappedHardwareEchoDetectionResult r100 = new LiveWrappedHardwareEchoDetectionResult("HARDWARE_ECHO_RESULT_CANCELED", 0, 0);
        HARDWARE_ECHO_RESULT_CANCELED = r100;
        LiveWrappedHardwareEchoDetectionResult r101 = new LiveWrappedHardwareEchoDetectionResult("HARDWARE_ECHO_RESULT_UNKNOWN", 1, 1);
        HARDWARE_ECHO_RESULT_UNKNOWN = r101;
        LiveWrappedHardwareEchoDetectionResult r102 = new LiveWrappedHardwareEchoDetectionResult("HARDWARE_ECHO_RESULT_NORMAL", 2, 2);
        HARDWARE_ECHO_RESULT_NORMAL = r102;
        LiveWrappedHardwareEchoDetectionResult r103 = new LiveWrappedHardwareEchoDetectionResult("HARDWARE_ECHO_RESULT_POOR", 3, 3);
        HARDWARE_ECHO_RESULT_POOR = r103;
        f147422a = new LiveWrappedHardwareEchoDetectionResult[]{r100, r101, r102, r103};
        Companion = new a();
    }

    public static LiveWrappedHardwareEchoDetectionResult valueOf(String r100) {
        return (LiveWrappedHardwareEchoDetectionResult) r27.a.a(LiveWrappedHardwareEchoDetectionResult.class, r100);
    }

    public static LiveWrappedHardwareEchoDetectionResult[] values() {
        return (LiveWrappedHardwareEchoDetectionResult[]) f147422a.clone();
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedHardwareEchoDetectionResult(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
