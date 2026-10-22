package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedVideoDenoiseMode;", "", "", "value", "", "toString", "I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "VIDEO_DENOISE_MODE_OFF", "VIDEO_DENOISE_MODE_AUTO", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedVideoDenoiseMode extends Enum<LiveWrappedVideoDenoiseMode> {
    public static final a Companion = null;
    public static final LiveWrappedVideoDenoiseMode VIDEO_DENOISE_MODE_AUTO = null;
    public static final LiveWrappedVideoDenoiseMode VIDEO_DENOISE_MODE_OFF = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedVideoDenoiseMode[] f147367a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedVideoDenoiseMode$a] */
    static {
        LiveWrappedVideoDenoiseMode r100 = new LiveWrappedVideoDenoiseMode("VIDEO_DENOISE_MODE_OFF", 0, 0);
        VIDEO_DENOISE_MODE_OFF = r100;
        LiveWrappedVideoDenoiseMode r101 = new LiveWrappedVideoDenoiseMode("VIDEO_DENOISE_MODE_AUTO", 1, 1);
        VIDEO_DENOISE_MODE_AUTO = r101;
        f147367a = new LiveWrappedVideoDenoiseMode[]{r100, r101};
        Companion = new a();
    }

    public static LiveWrappedVideoDenoiseMode valueOf(String r100) {
        return (LiveWrappedVideoDenoiseMode) r27.a.a(LiveWrappedVideoDenoiseMode.class, r100);
    }

    public static LiveWrappedVideoDenoiseMode[] values() {
        return (LiveWrappedVideoDenoiseMode[]) f147367a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = this.value;
        if (r100 != 0) goto L5;
        return "kVideoDenoiseModeOff";
    L5:
        if (r100 == 1) goto L8;
        return "";
    L8:
        return "kVideoDenoiseModeAuto";
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedVideoDenoiseMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
