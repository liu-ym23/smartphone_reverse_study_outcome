package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/type/LiveWrappedSubtitleState;", "", "", "value", "I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "SUBTITLE_STATE_STARTED", "SUBTITLE_STATE_STOPED", "SUBTITLE_STATE_ERROR", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedSubtitleState extends Enum<LiveWrappedSubtitleState> {
    public static final a Companion = null;
    public static final LiveWrappedSubtitleState SUBTITLE_STATE_ERROR = null;
    public static final LiveWrappedSubtitleState SUBTITLE_STATE_STARTED = null;
    public static final LiveWrappedSubtitleState SUBTITLE_STATE_STOPED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedSubtitleState[] f147452a = null;
    private final int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedSubtitleState$a] */
    static {
        LiveWrappedSubtitleState r100 = new LiveWrappedSubtitleState("SUBTITLE_STATE_STARTED", 0, 0);
        SUBTITLE_STATE_STARTED = r100;
        LiveWrappedSubtitleState r101 = new LiveWrappedSubtitleState("SUBTITLE_STATE_STOPED", 1, 1);
        SUBTITLE_STATE_STOPED = r101;
        LiveWrappedSubtitleState r102 = new LiveWrappedSubtitleState("SUBTITLE_STATE_ERROR", 2, 2);
        SUBTITLE_STATE_ERROR = r102;
        f147452a = new LiveWrappedSubtitleState[]{r100, r101, r102};
        Companion = new a();
    }

    public static LiveWrappedSubtitleState valueOf(String r100) {
        return (LiveWrappedSubtitleState) r27.a.a(LiveWrappedSubtitleState.class, r100);
    }

    public static LiveWrappedSubtitleState[] values() {
        return (LiveWrappedSubtitleState[]) f147452a.clone();
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedSubtitleState(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
