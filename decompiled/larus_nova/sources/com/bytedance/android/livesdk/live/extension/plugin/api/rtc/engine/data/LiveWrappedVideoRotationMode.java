package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedVideoRotationMode;", "", "", "value", "", "toString", "I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "FOLLOW_APP", "FOLLOW_GSENSOR", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedVideoRotationMode extends Enum<LiveWrappedVideoRotationMode> {
    public static final a Companion = null;
    public static final LiveWrappedVideoRotationMode FOLLOW_APP = null;
    public static final LiveWrappedVideoRotationMode FOLLOW_GSENSOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedVideoRotationMode[] f147372a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedVideoRotationMode$a] */
    static {
        LiveWrappedVideoRotationMode r100 = new LiveWrappedVideoRotationMode("FOLLOW_APP", 0, 0);
        FOLLOW_APP = r100;
        LiveWrappedVideoRotationMode r101 = new LiveWrappedVideoRotationMode("FOLLOW_GSENSOR", 1, 1);
        FOLLOW_GSENSOR = r101;
        f147372a = new LiveWrappedVideoRotationMode[]{r100, r101};
        Companion = new a();
    }

    public static LiveWrappedVideoRotationMode valueOf(String r100) {
        return (LiveWrappedVideoRotationMode) r27.a.a(LiveWrappedVideoRotationMode.class, r100);
    }

    public static LiveWrappedVideoRotationMode[] values() {
        return (LiveWrappedVideoRotationMode[]) f147372a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        if (this != FOLLOW_GSENSOR) goto L5;
        return "kVideoRotationModeFollowGSensor";
    L5:
        return "kVideoRotationModeFollowApp";
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedVideoRotationMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
