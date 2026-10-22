package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import zf2.v;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedLocalAudioStreamState;", "", "", "value", "", "toString", "I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "LOCAL_AUDIO_STREAM_STATE_STOPPED", "LOCAL_AUDIO_STREAM_STATE_RECORDING", "LOCAL_AUDIO_STREAM_STATE_ENCODING", "LOCAL_AUDIO_STREAM_STATE_FAILED", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedLocalAudioStreamState extends Enum<LiveWrappedLocalAudioStreamState> {
    public static final a Companion = null;
    public static final LiveWrappedLocalAudioStreamState LOCAL_AUDIO_STREAM_STATE_ENCODING = null;
    public static final LiveWrappedLocalAudioStreamState LOCAL_AUDIO_STREAM_STATE_FAILED = null;
    public static final LiveWrappedLocalAudioStreamState LOCAL_AUDIO_STREAM_STATE_RECORDING = null;
    public static final LiveWrappedLocalAudioStreamState LOCAL_AUDIO_STREAM_STATE_STOPPED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedLocalAudioStreamState[] f147339a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedLocalAudioStreamState$a] */
    static {
        LiveWrappedLocalAudioStreamState r100 = new LiveWrappedLocalAudioStreamState("LOCAL_AUDIO_STREAM_STATE_STOPPED", 0, 0);
        LOCAL_AUDIO_STREAM_STATE_STOPPED = r100;
        LiveWrappedLocalAudioStreamState r101 = new LiveWrappedLocalAudioStreamState("LOCAL_AUDIO_STREAM_STATE_RECORDING", 1, 1);
        LOCAL_AUDIO_STREAM_STATE_RECORDING = r101;
        LiveWrappedLocalAudioStreamState r102 = new LiveWrappedLocalAudioStreamState("LOCAL_AUDIO_STREAM_STATE_ENCODING", 2, 2);
        LOCAL_AUDIO_STREAM_STATE_ENCODING = r102;
        LiveWrappedLocalAudioStreamState r103 = new LiveWrappedLocalAudioStreamState("LOCAL_AUDIO_STREAM_STATE_FAILED", 3, 3);
        LOCAL_AUDIO_STREAM_STATE_FAILED = r103;
        f147339a = new LiveWrappedLocalAudioStreamState[]{r100, r101, r102, r103};
        Companion = new a();
    }

    public static LiveWrappedLocalAudioStreamState valueOf(String r100) {
        return (LiveWrappedLocalAudioStreamState) r27.a.a(LiveWrappedLocalAudioStreamState.class, r100);
    }

    public static LiveWrappedLocalAudioStreamState[] values() {
        return (LiveWrappedLocalAudioStreamState[]) f147339a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = v.f571746a[ordinal()];
        if (r100 != 1) goto L5;
        return "kLocalAudioStreamStateStopped";
    L5:
        if (r100 != 2) goto L7;
        return "kLocalAudioStreamStateRecording";
    L7:
        if (r100 != 3) goto L9;
        return "kLocalAudioStreamStateEncoding";
    L9:
        if (r100 == 4) goto L11;
        return "";
    L11:
        return "kLocalAudioStreamStateFailed";
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedLocalAudioStreamState(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
