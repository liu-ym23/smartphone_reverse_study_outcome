package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006J\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/type/LiveWrappedSubscribeFallbackOptions;", "", "", "value", "I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "SUBSCRIBE_FALLBACK_OPTIONS_DISABLED", "SUBSCRIBE_FALLBACK_OPTIONS_STREAM_LOW", "SUBSCRIBE_FALLBACK_OPTIONS_AUDIO_ONLY", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedSubscribeFallbackOptions extends Enum<LiveWrappedSubscribeFallbackOptions> {
    public static final a Companion = null;
    public static final LiveWrappedSubscribeFallbackOptions SUBSCRIBE_FALLBACK_OPTIONS_AUDIO_ONLY = null;
    public static final LiveWrappedSubscribeFallbackOptions SUBSCRIBE_FALLBACK_OPTIONS_DISABLED = null;
    public static final LiveWrappedSubscribeFallbackOptions SUBSCRIBE_FALLBACK_OPTIONS_STREAM_LOW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedSubscribeFallbackOptions[] f147449a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedSubscribeFallbackOptions$a] */
    static {
        LiveWrappedSubscribeFallbackOptions r100 = new LiveWrappedSubscribeFallbackOptions("SUBSCRIBE_FALLBACK_OPTIONS_DISABLED", 0, 0);
        SUBSCRIBE_FALLBACK_OPTIONS_DISABLED = r100;
        LiveWrappedSubscribeFallbackOptions r101 = new LiveWrappedSubscribeFallbackOptions("SUBSCRIBE_FALLBACK_OPTIONS_STREAM_LOW", 1, 1);
        SUBSCRIBE_FALLBACK_OPTIONS_STREAM_LOW = r101;
        LiveWrappedSubscribeFallbackOptions r102 = new LiveWrappedSubscribeFallbackOptions("SUBSCRIBE_FALLBACK_OPTIONS_AUDIO_ONLY", 2, 2);
        SUBSCRIBE_FALLBACK_OPTIONS_AUDIO_ONLY = r102;
        f147449a = new LiveWrappedSubscribeFallbackOptions[]{r100, r101, r102};
        Companion = new a();
    }

    public static LiveWrappedSubscribeFallbackOptions valueOf(String r100) {
        return (LiveWrappedSubscribeFallbackOptions) r27.a.a(LiveWrappedSubscribeFallbackOptions.class, r100);
    }

    public static LiveWrappedSubscribeFallbackOptions[] values() {
        return (LiveWrappedSubscribeFallbackOptions[]) f147449a.clone();
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedSubscribeFallbackOptions(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
