package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006J\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/type/LiveWrappedLocalVideoStreamState;", "", "", "value", "I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "LOCAL_VIDEO_STREAM_STATE_STOPPED", "LOCAL_VIDEO_STREAM_STATE_RECORDING", "LOCAL_VIDEO_STREAM_STATE_ENCODING", "LOCAL_VIDEO_STREAM_STATE_FAILED", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedLocalVideoStreamState extends Enum<LiveWrappedLocalVideoStreamState> {
    public static final a Companion = null;
    public static final LiveWrappedLocalVideoStreamState LOCAL_VIDEO_STREAM_STATE_ENCODING = null;
    public static final LiveWrappedLocalVideoStreamState LOCAL_VIDEO_STREAM_STATE_FAILED = null;
    public static final LiveWrappedLocalVideoStreamState LOCAL_VIDEO_STREAM_STATE_RECORDING = null;
    public static final LiveWrappedLocalVideoStreamState LOCAL_VIDEO_STREAM_STATE_STOPPED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedLocalVideoStreamState[] f147427a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedLocalVideoStreamState$a] */
    static {
        LiveWrappedLocalVideoStreamState r100 = new LiveWrappedLocalVideoStreamState("LOCAL_VIDEO_STREAM_STATE_STOPPED", 0, 0);
        LOCAL_VIDEO_STREAM_STATE_STOPPED = r100;
        LiveWrappedLocalVideoStreamState r101 = new LiveWrappedLocalVideoStreamState("LOCAL_VIDEO_STREAM_STATE_RECORDING", 1, 1);
        LOCAL_VIDEO_STREAM_STATE_RECORDING = r101;
        LiveWrappedLocalVideoStreamState r102 = new LiveWrappedLocalVideoStreamState("LOCAL_VIDEO_STREAM_STATE_ENCODING", 2, 2);
        LOCAL_VIDEO_STREAM_STATE_ENCODING = r102;
        LiveWrappedLocalVideoStreamState r103 = new LiveWrappedLocalVideoStreamState("LOCAL_VIDEO_STREAM_STATE_FAILED", 3, 3);
        LOCAL_VIDEO_STREAM_STATE_FAILED = r103;
        f147427a = new LiveWrappedLocalVideoStreamState[]{r100, r101, r102, r103};
        Companion = new a();
    }

    public static LiveWrappedLocalVideoStreamState valueOf(String r100) {
        return (LiveWrappedLocalVideoStreamState) r27.a.a(LiveWrappedLocalVideoStreamState.class, r100);
    }

    public static LiveWrappedLocalVideoStreamState[] values() {
        return (LiveWrappedLocalVideoStreamState[]) f147427a.clone();
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedLocalVideoStreamState(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
