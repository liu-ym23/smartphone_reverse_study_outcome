package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import zf2.o;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedCameraId;", "", "", "value", "", "toString", "I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "CAMERA_ID_FRONT", "CAMERA_ID_BACK", "CAMERA_ID_EXTERNAL", "CAMERA_ID_INVALID", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedCameraId extends Enum<LiveWrappedCameraId> {
    public static final LiveWrappedCameraId CAMERA_ID_BACK = null;
    public static final LiveWrappedCameraId CAMERA_ID_EXTERNAL = null;
    public static final LiveWrappedCameraId CAMERA_ID_FRONT = null;
    public static final LiveWrappedCameraId CAMERA_ID_INVALID = null;
    public static final a Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedCameraId[] f147332a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedCameraId$a] */
    static {
        LiveWrappedCameraId r100 = new LiveWrappedCameraId("CAMERA_ID_FRONT", 0, 0);
        CAMERA_ID_FRONT = r100;
        LiveWrappedCameraId r101 = new LiveWrappedCameraId("CAMERA_ID_BACK", 1, 1);
        CAMERA_ID_BACK = r101;
        LiveWrappedCameraId r102 = new LiveWrappedCameraId("CAMERA_ID_EXTERNAL", 2, 2);
        CAMERA_ID_EXTERNAL = r102;
        LiveWrappedCameraId r103 = new LiveWrappedCameraId("CAMERA_ID_INVALID", 3, 3);
        CAMERA_ID_INVALID = r103;
        f147332a = new LiveWrappedCameraId[]{r100, r101, r102, r103};
        Companion = new a();
    }

    public static LiveWrappedCameraId valueOf(String r100) {
        return (LiveWrappedCameraId) r27.a.a(LiveWrappedCameraId.class, r100);
    }

    public static LiveWrappedCameraId[] values() {
        return (LiveWrappedCameraId[]) f147332a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = o.f571737a[ordinal()];
        if (r100 != 1) goto L5;
        return "kCameraIDFront";
    L5:
        if (r100 == 2) goto L7;
        return "";
    L7:
        return "kCameraIDBack";
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedCameraId(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
