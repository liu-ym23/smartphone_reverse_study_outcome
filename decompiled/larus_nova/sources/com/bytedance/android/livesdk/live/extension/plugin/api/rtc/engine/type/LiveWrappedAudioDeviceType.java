package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/type/LiveWrappedAudioDeviceType;", "", "", "value", "I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "AUDIO_DEVICE_TYPE_UNKNOWN", "AUDIO_DEVICE_TYPE_RENDER_DEVICE", "AUDIO_DEVICE_TYPE_CAPTURE_DEVICE", "AUDIO_DEVICE_TYPE_SCREEN_CAPTURE_DEVICE", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedAudioDeviceType extends Enum<LiveWrappedAudioDeviceType> {
    public static final LiveWrappedAudioDeviceType AUDIO_DEVICE_TYPE_CAPTURE_DEVICE = null;
    public static final LiveWrappedAudioDeviceType AUDIO_DEVICE_TYPE_RENDER_DEVICE = null;
    public static final LiveWrappedAudioDeviceType AUDIO_DEVICE_TYPE_SCREEN_CAPTURE_DEVICE = null;
    public static final LiveWrappedAudioDeviceType AUDIO_DEVICE_TYPE_UNKNOWN = null;
    public static final a Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedAudioDeviceType[] f147411a = null;
    private final int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedAudioDeviceType$a] */
    static {
        LiveWrappedAudioDeviceType r100 = new LiveWrappedAudioDeviceType("AUDIO_DEVICE_TYPE_UNKNOWN", 0, -1);
        AUDIO_DEVICE_TYPE_UNKNOWN = r100;
        LiveWrappedAudioDeviceType r101 = new LiveWrappedAudioDeviceType("AUDIO_DEVICE_TYPE_RENDER_DEVICE", 1, 0);
        AUDIO_DEVICE_TYPE_RENDER_DEVICE = r101;
        LiveWrappedAudioDeviceType r102 = new LiveWrappedAudioDeviceType("AUDIO_DEVICE_TYPE_CAPTURE_DEVICE", 2, 1);
        AUDIO_DEVICE_TYPE_CAPTURE_DEVICE = r102;
        LiveWrappedAudioDeviceType r103 = new LiveWrappedAudioDeviceType("AUDIO_DEVICE_TYPE_SCREEN_CAPTURE_DEVICE", 3, 2);
        AUDIO_DEVICE_TYPE_SCREEN_CAPTURE_DEVICE = r103;
        f147411a = new LiveWrappedAudioDeviceType[]{r100, r101, r102, r103};
        Companion = new a();
    }

    public static LiveWrappedAudioDeviceType valueOf(String r100) {
        return (LiveWrappedAudioDeviceType) r27.a.a(LiveWrappedAudioDeviceType.class, r100);
    }

    public static LiveWrappedAudioDeviceType[] values() {
        return (LiveWrappedAudioDeviceType[]) f147411a.clone();
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedAudioDeviceType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
