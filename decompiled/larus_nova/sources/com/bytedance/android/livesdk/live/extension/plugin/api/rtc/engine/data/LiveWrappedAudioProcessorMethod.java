package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import zf2.i;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedAudioProcessorMethod;", "", "", "value", "", "toString", "I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "AUDIO_FRAME_PROCESSOR_RECORD", "AUDIO_FRAME_PROCESSOR_PLAYBACK", "AUDIO_FRAME_PROCESSOR_REMOTE_USER", "AUDIO_FRAME_PROCESSOR_EAR_MONITOR", "AUDIO_FRAME_PROCESSOR_SCREEN", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedAudioProcessorMethod extends Enum<LiveWrappedAudioProcessorMethod> {
    public static final LiveWrappedAudioProcessorMethod AUDIO_FRAME_PROCESSOR_EAR_MONITOR = null;
    public static final LiveWrappedAudioProcessorMethod AUDIO_FRAME_PROCESSOR_PLAYBACK = null;
    public static final LiveWrappedAudioProcessorMethod AUDIO_FRAME_PROCESSOR_RECORD = null;
    public static final LiveWrappedAudioProcessorMethod AUDIO_FRAME_PROCESSOR_REMOTE_USER = null;
    public static final LiveWrappedAudioProcessorMethod AUDIO_FRAME_PROCESSOR_SCREEN = null;
    public static final a Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedAudioProcessorMethod[] f147325a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedAudioProcessorMethod$a] */
    static {
        LiveWrappedAudioProcessorMethod r100 = new LiveWrappedAudioProcessorMethod("AUDIO_FRAME_PROCESSOR_RECORD", 0, 0);
        AUDIO_FRAME_PROCESSOR_RECORD = r100;
        LiveWrappedAudioProcessorMethod r101 = new LiveWrappedAudioProcessorMethod("AUDIO_FRAME_PROCESSOR_PLAYBACK", 1, 1);
        AUDIO_FRAME_PROCESSOR_PLAYBACK = r101;
        LiveWrappedAudioProcessorMethod r102 = new LiveWrappedAudioProcessorMethod("AUDIO_FRAME_PROCESSOR_REMOTE_USER", 2, 2);
        AUDIO_FRAME_PROCESSOR_REMOTE_USER = r102;
        LiveWrappedAudioProcessorMethod r103 = new LiveWrappedAudioProcessorMethod("AUDIO_FRAME_PROCESSOR_EAR_MONITOR", 3, 3);
        AUDIO_FRAME_PROCESSOR_EAR_MONITOR = r103;
        LiveWrappedAudioProcessorMethod r104 = new LiveWrappedAudioProcessorMethod("AUDIO_FRAME_PROCESSOR_SCREEN", 4, 4);
        AUDIO_FRAME_PROCESSOR_SCREEN = r104;
        f147325a = new LiveWrappedAudioProcessorMethod[]{r100, r101, r102, r103, r104};
        Companion = new a();
    }

    public static LiveWrappedAudioProcessorMethod valueOf(String r100) {
        return (LiveWrappedAudioProcessorMethod) r27.a.a(LiveWrappedAudioProcessorMethod.class, r100);
    }

    public static LiveWrappedAudioProcessorMethod[] values() {
        return (LiveWrappedAudioProcessorMethod[]) f147325a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = i.f571717a[ordinal()];
        if (r100 != 1) goto L5;
        return "AUDIO_FRAME_PROCESSOR_RECORD";
    L5:
        if (r100 != 2) goto L7;
        return "AUDIO_FRAME_PROCESSOR_PLAYBACK";
    L7:
        if (r100 != 3) goto L9;
        return "AUDIO_FRAME_PROCESSOR_REMOTE_USER";
    L9:
        if (r100 != 4) goto L11;
        return "AUDIO_FRAME_PROCESSOR_EAR_MONITOR";
    L11:
        if (r100 == 5) goto L13;
        return "";
    L13:
        return "AUDIO_FRAME_PROCESSOR_SCREEN";
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedAudioProcessorMethod(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
