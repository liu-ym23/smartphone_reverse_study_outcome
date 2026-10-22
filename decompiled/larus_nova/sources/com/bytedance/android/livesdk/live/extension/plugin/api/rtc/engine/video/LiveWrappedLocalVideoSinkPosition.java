package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.video;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/video/LiveWrappedLocalVideoSinkPosition;", "", "", "value", "I", "getValue", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "AFTER_CAPTURE", "AFTER_PREPROCESS", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedLocalVideoSinkPosition extends Enum<LiveWrappedLocalVideoSinkPosition> {
    public static final LiveWrappedLocalVideoSinkPosition AFTER_CAPTURE = null;
    public static final LiveWrappedLocalVideoSinkPosition AFTER_PREPROCESS = null;
    public static final a Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedLocalVideoSinkPosition[] f147460a = null;
    private final int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.video.LiveWrappedLocalVideoSinkPosition$a] */
    static {
        LiveWrappedLocalVideoSinkPosition r100 = new LiveWrappedLocalVideoSinkPosition("AFTER_CAPTURE", 0, 0);
        AFTER_CAPTURE = r100;
        LiveWrappedLocalVideoSinkPosition r101 = new LiveWrappedLocalVideoSinkPosition("AFTER_PREPROCESS", 1, 1);
        AFTER_PREPROCESS = r101;
        f147460a = new LiveWrappedLocalVideoSinkPosition[]{r100, r101};
        Companion = new a();
    }

    public static LiveWrappedLocalVideoSinkPosition valueOf(String r100) {
        return (LiveWrappedLocalVideoSinkPosition) r27.a.a(LiveWrappedLocalVideoSinkPosition.class, r100);
    }

    public static LiveWrappedLocalVideoSinkPosition[] values() {
        return (LiveWrappedLocalVideoSinkPosition[]) f147460a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public LiveWrappedLocalVideoSinkPosition(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
