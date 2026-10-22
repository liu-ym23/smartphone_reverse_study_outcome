package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedAudioFrameCallbackMethod;", "", "", "value", "I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "AUDIO_FRAME_CALLBACK_RECORD", "AUDIO_FRAME_CALLBACK_PLAYBACK", "AUDIO_FRAME_CALLBACK_MIXED", "AUDIO_FRAME_CALLBACK_REMOTE_USER", "AUDIO_FRAME_CALLBACK_CAPTURE_MIXED", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedAudioFrameCallbackMethod extends Enum<LiveWrappedAudioFrameCallbackMethod> {
    public static final LiveWrappedAudioFrameCallbackMethod AUDIO_FRAME_CALLBACK_CAPTURE_MIXED = null;
    public static final LiveWrappedAudioFrameCallbackMethod AUDIO_FRAME_CALLBACK_MIXED = null;
    public static final LiveWrappedAudioFrameCallbackMethod AUDIO_FRAME_CALLBACK_PLAYBACK = null;
    public static final LiveWrappedAudioFrameCallbackMethod AUDIO_FRAME_CALLBACK_RECORD = null;
    public static final LiveWrappedAudioFrameCallbackMethod AUDIO_FRAME_CALLBACK_REMOTE_USER = null;
    public static final a Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedAudioFrameCallbackMethod[] f147321a = null;
    private final int value;

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedAudioFrameCallbackMethod$a] */
    static {
        LiveWrappedAudioFrameCallbackMethod r100 = new LiveWrappedAudioFrameCallbackMethod("AUDIO_FRAME_CALLBACK_RECORD", 0, 0);
        AUDIO_FRAME_CALLBACK_RECORD = r100;
        LiveWrappedAudioFrameCallbackMethod r101 = new LiveWrappedAudioFrameCallbackMethod("AUDIO_FRAME_CALLBACK_PLAYBACK", 1, 1);
        AUDIO_FRAME_CALLBACK_PLAYBACK = r101;
        LiveWrappedAudioFrameCallbackMethod r102 = new LiveWrappedAudioFrameCallbackMethod("AUDIO_FRAME_CALLBACK_MIXED", 2, 2);
        AUDIO_FRAME_CALLBACK_MIXED = r102;
        LiveWrappedAudioFrameCallbackMethod r103 = new LiveWrappedAudioFrameCallbackMethod("AUDIO_FRAME_CALLBACK_REMOTE_USER", 3, 3);
        AUDIO_FRAME_CALLBACK_REMOTE_USER = r103;
        LiveWrappedAudioFrameCallbackMethod r104 = new LiveWrappedAudioFrameCallbackMethod("AUDIO_FRAME_CALLBACK_CAPTURE_MIXED", 4, 5);
        AUDIO_FRAME_CALLBACK_CAPTURE_MIXED = r104;
        f147321a = new LiveWrappedAudioFrameCallbackMethod[]{r100, r101, r102, r103, r104};
        Companion = new a();
    }

    public static LiveWrappedAudioFrameCallbackMethod valueOf(String r100) {
        return (LiveWrappedAudioFrameCallbackMethod) r27.a.a(LiveWrappedAudioFrameCallbackMethod.class, r100);
    }

    public static LiveWrappedAudioFrameCallbackMethod[] values() {
        return (LiveWrappedAudioFrameCallbackMethod[]) f147321a.clone();
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedAudioFrameCallbackMethod(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
