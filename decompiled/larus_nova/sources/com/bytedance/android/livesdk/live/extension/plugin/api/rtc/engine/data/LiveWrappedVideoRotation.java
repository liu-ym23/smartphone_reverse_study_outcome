package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006J\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedVideoRotation;", "", "", "value", "I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "VIDEO_ROTATION_0", "VIDEO_ROTATION_90", "VIDEO_ROTATION_180", "VIDEO_ROTATION_270", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedVideoRotation extends Enum<LiveWrappedVideoRotation> {
    public static final a Companion = null;
    public static final LiveWrappedVideoRotation VIDEO_ROTATION_0 = null;
    public static final LiveWrappedVideoRotation VIDEO_ROTATION_180 = null;
    public static final LiveWrappedVideoRotation VIDEO_ROTATION_270 = null;
    public static final LiveWrappedVideoRotation VIDEO_ROTATION_90 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedVideoRotation[] f147371a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedVideoRotation$a] */
    static {
        LiveWrappedVideoRotation r100 = new LiveWrappedVideoRotation("VIDEO_ROTATION_0", 0, 0);
        VIDEO_ROTATION_0 = r100;
        LiveWrappedVideoRotation r101 = new LiveWrappedVideoRotation("VIDEO_ROTATION_90", 1, 90);
        VIDEO_ROTATION_90 = r101;
        LiveWrappedVideoRotation r102 = new LiveWrappedVideoRotation("VIDEO_ROTATION_180", 2, 180);
        VIDEO_ROTATION_180 = r102;
        LiveWrappedVideoRotation r103 = new LiveWrappedVideoRotation("VIDEO_ROTATION_270", 3, 270);
        VIDEO_ROTATION_270 = r103;
        f147371a = new LiveWrappedVideoRotation[]{r100, r101, r102, r103};
        Companion = new a();
    }

    public static LiveWrappedVideoRotation valueOf(String r100) {
        return (LiveWrappedVideoRotation) r27.a.a(LiveWrappedVideoRotation.class, r100);
    }

    public static LiveWrappedVideoRotation[] values() {
        return (LiveWrappedVideoRotation[]) f147371a.clone();
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedVideoRotation(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
