package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006J\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/type/LiveWrappedAudioDumpStatus;", "", "", "value", "I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "AUDIO_DUMP_START_FAILURE", "AUDIO_DUMP_START_SUCCESS", "AUDIO_DUMP_STOP_FAILURE", "AUDIO_DUMP_STOP_SUCCESS", "AUDIO_DUMP_RUNNING_FAILURE", "AUDIO_DUMP_RUNNING_SUCCESS", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedAudioDumpStatus extends Enum<LiveWrappedAudioDumpStatus> {
    public static final LiveWrappedAudioDumpStatus AUDIO_DUMP_RUNNING_FAILURE = null;
    public static final LiveWrappedAudioDumpStatus AUDIO_DUMP_RUNNING_SUCCESS = null;
    public static final LiveWrappedAudioDumpStatus AUDIO_DUMP_START_FAILURE = null;
    public static final LiveWrappedAudioDumpStatus AUDIO_DUMP_START_SUCCESS = null;
    public static final LiveWrappedAudioDumpStatus AUDIO_DUMP_STOP_FAILURE = null;
    public static final LiveWrappedAudioDumpStatus AUDIO_DUMP_STOP_SUCCESS = null;
    public static final a Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedAudioDumpStatus[] f147412a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedAudioDumpStatus$a] */
    static {
        LiveWrappedAudioDumpStatus r100 = new LiveWrappedAudioDumpStatus("AUDIO_DUMP_START_FAILURE", 0, 0);
        AUDIO_DUMP_START_FAILURE = r100;
        LiveWrappedAudioDumpStatus r101 = new LiveWrappedAudioDumpStatus("AUDIO_DUMP_START_SUCCESS", 1, 1);
        AUDIO_DUMP_START_SUCCESS = r101;
        LiveWrappedAudioDumpStatus r102 = new LiveWrappedAudioDumpStatus("AUDIO_DUMP_STOP_FAILURE", 2, 2);
        AUDIO_DUMP_STOP_FAILURE = r102;
        LiveWrappedAudioDumpStatus r103 = new LiveWrappedAudioDumpStatus("AUDIO_DUMP_STOP_SUCCESS", 3, 3);
        AUDIO_DUMP_STOP_SUCCESS = r103;
        LiveWrappedAudioDumpStatus r104 = new LiveWrappedAudioDumpStatus("AUDIO_DUMP_RUNNING_FAILURE", 4, 4);
        AUDIO_DUMP_RUNNING_FAILURE = r104;
        LiveWrappedAudioDumpStatus r105 = new LiveWrappedAudioDumpStatus("AUDIO_DUMP_RUNNING_SUCCESS", 5, 5);
        AUDIO_DUMP_RUNNING_SUCCESS = r105;
        f147412a = new LiveWrappedAudioDumpStatus[]{r100, r101, r102, r103, r104, r105};
        Companion = new a();
    }

    public static LiveWrappedAudioDumpStatus valueOf(String r100) {
        return (LiveWrappedAudioDumpStatus) r27.a.a(LiveWrappedAudioDumpStatus.class, r100);
    }

    public static LiveWrappedAudioDumpStatus[] values() {
        return (LiveWrappedAudioDumpStatus[]) f147412a.clone();
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedAudioDumpStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
