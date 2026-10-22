package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.video;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/video/LiveWrappedVideoApplyRotation;", "", "", "value", "I", "getValue", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "DEFAULT", "DEGREE_0", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedVideoApplyRotation extends Enum<LiveWrappedVideoApplyRotation> {
    public static final a Companion = null;
    public static final LiveWrappedVideoApplyRotation DEFAULT = null;
    public static final LiveWrappedVideoApplyRotation DEGREE_0 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedVideoApplyRotation[] f147462a = null;
    private final int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.video.LiveWrappedVideoApplyRotation$a] */
    static {
        LiveWrappedVideoApplyRotation r100 = new LiveWrappedVideoApplyRotation("DEFAULT", 0, -1);
        DEFAULT = r100;
        LiveWrappedVideoApplyRotation r101 = new LiveWrappedVideoApplyRotation("DEGREE_0", 1, 0);
        DEGREE_0 = r101;
        f147462a = new LiveWrappedVideoApplyRotation[]{r100, r101};
        Companion = new a();
    }

    public static LiveWrappedVideoApplyRotation valueOf(String r100) {
        return (LiveWrappedVideoApplyRotation) r27.a.a(LiveWrappedVideoApplyRotation.class, r100);
    }

    public static LiveWrappedVideoApplyRotation[] values() {
        return (LiveWrappedVideoApplyRotation[]) f147462a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public LiveWrappedVideoApplyRotation(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
