package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/type/LiveWrappedVideoDeviceType;", "", "", "value", "I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "VIDEO_DEVICE_TYPE_UNKNOWN", "VIDEO_DEVICE_TYPE_RENDER_DEVICE", "VIDEO_DEVICE_TYPE_CAPTURE_DEVICE", "VIDEO_DEVICE_TYPE_SCREEN_CAPTURE_DEVICE", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedVideoDeviceType extends Enum<LiveWrappedVideoDeviceType> {
    public static final a Companion = null;
    public static final LiveWrappedVideoDeviceType VIDEO_DEVICE_TYPE_CAPTURE_DEVICE = null;
    public static final LiveWrappedVideoDeviceType VIDEO_DEVICE_TYPE_RENDER_DEVICE = null;
    public static final LiveWrappedVideoDeviceType VIDEO_DEVICE_TYPE_SCREEN_CAPTURE_DEVICE = null;
    public static final LiveWrappedVideoDeviceType VIDEO_DEVICE_TYPE_UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedVideoDeviceType[] f147454a = null;
    private final int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedVideoDeviceType$a] */
    static {
        LiveWrappedVideoDeviceType r100 = new LiveWrappedVideoDeviceType("VIDEO_DEVICE_TYPE_UNKNOWN", 0, -1);
        VIDEO_DEVICE_TYPE_UNKNOWN = r100;
        LiveWrappedVideoDeviceType r101 = new LiveWrappedVideoDeviceType("VIDEO_DEVICE_TYPE_RENDER_DEVICE", 1, 0);
        VIDEO_DEVICE_TYPE_RENDER_DEVICE = r101;
        LiveWrappedVideoDeviceType r102 = new LiveWrappedVideoDeviceType("VIDEO_DEVICE_TYPE_CAPTURE_DEVICE", 2, 1);
        VIDEO_DEVICE_TYPE_CAPTURE_DEVICE = r102;
        LiveWrappedVideoDeviceType r103 = new LiveWrappedVideoDeviceType("VIDEO_DEVICE_TYPE_SCREEN_CAPTURE_DEVICE", 3, 2);
        VIDEO_DEVICE_TYPE_SCREEN_CAPTURE_DEVICE = r103;
        f147454a = new LiveWrappedVideoDeviceType[]{r100, r101, r102, r103};
        Companion = new a();
    }

    public static LiveWrappedVideoDeviceType valueOf(String r100) {
        return (LiveWrappedVideoDeviceType) r27.a.a(LiveWrappedVideoDeviceType.class, r100);
    }

    public static LiveWrappedVideoDeviceType[] values() {
        return (LiveWrappedVideoDeviceType[]) f147454a.clone();
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedVideoDeviceType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
