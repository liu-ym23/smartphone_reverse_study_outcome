package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/live/LiveWrappedInterpolationMode;", "", "", "value", "mode", "I", "LAST_FRAME_FILL", "BACKGROUND_IMAGE_FILL", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedInterpolationMode extends Enum<LiveWrappedInterpolationMode> {
    public static final LiveWrappedInterpolationMode BACKGROUND_IMAGE_FILL = null;
    public static final LiveWrappedInterpolationMode LAST_FRAME_FILL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedInterpolationMode[] f147388a = null;
    private final int mode;

    static {
        LiveWrappedInterpolationMode r100 = new LiveWrappedInterpolationMode("LAST_FRAME_FILL", 0, 0);
        LAST_FRAME_FILL = r100;
        LiveWrappedInterpolationMode r101 = new LiveWrappedInterpolationMode("BACKGROUND_IMAGE_FILL", 1, 1);
        BACKGROUND_IMAGE_FILL = r101;
        f147388a = new LiveWrappedInterpolationMode[]{r100, r101};
    }

    public static LiveWrappedInterpolationMode valueOf(String r100) {
        return (LiveWrappedInterpolationMode) a.a(LiveWrappedInterpolationMode.class, r100);
    }

    public static LiveWrappedInterpolationMode[] values() {
        return (LiveWrappedInterpolationMode[]) f147388a.clone();
    }

    public final int value() {
        return this.mode;
    }

    public LiveWrappedInterpolationMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.mode = r102;
    }
}
