package com.bytedance.android.livesdk.live.extension.plugin.api.bytebench;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0015\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/bytebench/LiveWrappedBTCFeature;", "", "", "value", "I", "getValue", "()I", "DEVICE_OVERALL_SCORE", "DEVICE_CPU_SCORE", "DEVICE_GPU_SCORE", "DEVICE_MEMORY_SCORE", "DEVICE_VIDEO_SCORE", "DEVICE_IO_SCORE", "DEVICE_VIDEO_PLAY_SCENE_SCORE", "DEVICE_APP_LAUNCH_SCENE_SCORE", "DEVICE_VIDEO_RECORD_SCENE_SCORE", "DEVICE_RUNTIME_VIRTUAL_MEMORY", "DEVICE_RUNTIME_TEMPERATURE", "DEVICE_RUNTIME_BATTERY_LEVEL", "DEVICE_RUNTIME_CPU_SPEED", "DEVICE_RUNTIME_CPU_PROCESS_USAGE", "DEVICE_RUNTIME_REMAIN_MEMORY", "DEVICE_RUNTIME_BATTERYEL_ECTRICCURRENT", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedBTCFeature extends Enum<LiveWrappedBTCFeature> {
    public static final LiveWrappedBTCFeature DEVICE_APP_LAUNCH_SCENE_SCORE = null;
    public static final LiveWrappedBTCFeature DEVICE_CPU_SCORE = null;
    public static final LiveWrappedBTCFeature DEVICE_GPU_SCORE = null;
    public static final LiveWrappedBTCFeature DEVICE_IO_SCORE = null;
    public static final LiveWrappedBTCFeature DEVICE_MEMORY_SCORE = null;
    public static final LiveWrappedBTCFeature DEVICE_OVERALL_SCORE = null;
    public static final LiveWrappedBTCFeature DEVICE_RUNTIME_BATTERYEL_ECTRICCURRENT = null;
    public static final LiveWrappedBTCFeature DEVICE_RUNTIME_BATTERY_LEVEL = null;
    public static final LiveWrappedBTCFeature DEVICE_RUNTIME_CPU_PROCESS_USAGE = null;
    public static final LiveWrappedBTCFeature DEVICE_RUNTIME_CPU_SPEED = null;
    public static final LiveWrappedBTCFeature DEVICE_RUNTIME_REMAIN_MEMORY = null;
    public static final LiveWrappedBTCFeature DEVICE_RUNTIME_TEMPERATURE = null;
    public static final LiveWrappedBTCFeature DEVICE_RUNTIME_VIRTUAL_MEMORY = null;
    public static final LiveWrappedBTCFeature DEVICE_VIDEO_PLAY_SCENE_SCORE = null;
    public static final LiveWrappedBTCFeature DEVICE_VIDEO_RECORD_SCENE_SCORE = null;
    public static final LiveWrappedBTCFeature DEVICE_VIDEO_SCORE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedBTCFeature[] f147282a = null;
    private final int value;

    public static LiveWrappedBTCFeature valueOf(String r100) {
        return (LiveWrappedBTCFeature) a.a(LiveWrappedBTCFeature.class, r100);
    }

    public static LiveWrappedBTCFeature[] values() {
        return (LiveWrappedBTCFeature[]) f147282a.clone();
    }

    static {
        LiveWrappedBTCFeature r100 = new LiveWrappedBTCFeature("DEVICE_OVERALL_SCORE", 0, 0);
        DEVICE_OVERALL_SCORE = r100;
        LiveWrappedBTCFeature r101 = new LiveWrappedBTCFeature("DEVICE_CPU_SCORE", 1, 1);
        DEVICE_CPU_SCORE = r101;
        LiveWrappedBTCFeature r102 = new LiveWrappedBTCFeature("DEVICE_GPU_SCORE", 2, 2);
        DEVICE_GPU_SCORE = r102;
        LiveWrappedBTCFeature r103 = new LiveWrappedBTCFeature("DEVICE_MEMORY_SCORE", 3, 3);
        DEVICE_MEMORY_SCORE = r103;
        LiveWrappedBTCFeature r104 = new LiveWrappedBTCFeature("DEVICE_VIDEO_SCORE", 4, 4);
        DEVICE_VIDEO_SCORE = r104;
        LiveWrappedBTCFeature r105 = new LiveWrappedBTCFeature("DEVICE_IO_SCORE", 5, 5);
        DEVICE_IO_SCORE = r105;
        LiveWrappedBTCFeature r106 = new LiveWrappedBTCFeature("DEVICE_VIDEO_PLAY_SCENE_SCORE", 6, 6);
        DEVICE_VIDEO_PLAY_SCENE_SCORE = r106;
        LiveWrappedBTCFeature r107 = new LiveWrappedBTCFeature("DEVICE_APP_LAUNCH_SCENE_SCORE", 7, 7);
        DEVICE_APP_LAUNCH_SCENE_SCORE = r107;
        LiveWrappedBTCFeature r108 = new LiveWrappedBTCFeature("DEVICE_VIDEO_RECORD_SCENE_SCORE", 8, 8);
        DEVICE_VIDEO_RECORD_SCENE_SCORE = r108;
        LiveWrappedBTCFeature r109 = new LiveWrappedBTCFeature("DEVICE_RUNTIME_VIRTUAL_MEMORY", 9, 9);
        DEVICE_RUNTIME_VIRTUAL_MEMORY = r109;
        LiveWrappedBTCFeature r110 = new LiveWrappedBTCFeature("DEVICE_RUNTIME_TEMPERATURE", 10, 10);
        DEVICE_RUNTIME_TEMPERATURE = r110;
        LiveWrappedBTCFeature r111 = new LiveWrappedBTCFeature("DEVICE_RUNTIME_BATTERY_LEVEL", 11, 11);
        DEVICE_RUNTIME_BATTERY_LEVEL = r111;
        LiveWrappedBTCFeature r112 = new LiveWrappedBTCFeature("DEVICE_RUNTIME_CPU_SPEED", 12, 12);
        DEVICE_RUNTIME_CPU_SPEED = r112;
        LiveWrappedBTCFeature r113 = new LiveWrappedBTCFeature("DEVICE_RUNTIME_CPU_PROCESS_USAGE", 13, 13);
        DEVICE_RUNTIME_CPU_PROCESS_USAGE = r113;
        LiveWrappedBTCFeature r114 = new LiveWrappedBTCFeature("DEVICE_RUNTIME_REMAIN_MEMORY", 14, 14);
        DEVICE_RUNTIME_REMAIN_MEMORY = r114;
        LiveWrappedBTCFeature r115 = new LiveWrappedBTCFeature("DEVICE_RUNTIME_BATTERYEL_ECTRICCURRENT", 15, 15);
        DEVICE_RUNTIME_BATTERYEL_ECTRICCURRENT = r115;
        f147282a = new LiveWrappedBTCFeature[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115};
    }

    public final int getValue() {
        return this.value;
    }

    public LiveWrappedBTCFeature(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
