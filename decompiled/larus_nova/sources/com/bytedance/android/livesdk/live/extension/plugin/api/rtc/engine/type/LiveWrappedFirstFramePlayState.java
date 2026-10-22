package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007J\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0004\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/type/LiveWrappedFirstFramePlayState;", "", "", "value", "state", "I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "FIRST_FRAME_PLAY_STATE_PLAYING", "FIRST_FRAME_PLAY_STATE_PLAYED", "FIRST_FRAME_PLAY_STATE_END", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedFirstFramePlayState extends Enum<LiveWrappedFirstFramePlayState> {
    public static final a Companion = null;
    public static final LiveWrappedFirstFramePlayState FIRST_FRAME_PLAY_STATE_END = null;
    public static final LiveWrappedFirstFramePlayState FIRST_FRAME_PLAY_STATE_PLAYED = null;
    public static final LiveWrappedFirstFramePlayState FIRST_FRAME_PLAY_STATE_PLAYING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedFirstFramePlayState[] f147420a = null;
    private int state;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedFirstFramePlayState$a] */
    static {
        LiveWrappedFirstFramePlayState r100 = new LiveWrappedFirstFramePlayState("FIRST_FRAME_PLAY_STATE_PLAYING", 0, 0);
        FIRST_FRAME_PLAY_STATE_PLAYING = r100;
        LiveWrappedFirstFramePlayState r101 = new LiveWrappedFirstFramePlayState("FIRST_FRAME_PLAY_STATE_PLAYED", 1, 1);
        FIRST_FRAME_PLAY_STATE_PLAYED = r101;
        LiveWrappedFirstFramePlayState r102 = new LiveWrappedFirstFramePlayState("FIRST_FRAME_PLAY_STATE_END", 2, 2);
        FIRST_FRAME_PLAY_STATE_END = r102;
        f147420a = new LiveWrappedFirstFramePlayState[]{r100, r101, r102};
        Companion = new a();
    }

    public static LiveWrappedFirstFramePlayState valueOf(String r100) {
        return (LiveWrappedFirstFramePlayState) r27.a.a(LiveWrappedFirstFramePlayState.class, r100);
    }

    public static LiveWrappedFirstFramePlayState[] values() {
        return (LiveWrappedFirstFramePlayState[]) f147420a.clone();
    }

    public final int value() {
        return this.state;
    }

    public LiveWrappedFirstFramePlayState(String r100, int r101, int r102) {
        super(r100, r101);
        this.state = r102;
    }
}
