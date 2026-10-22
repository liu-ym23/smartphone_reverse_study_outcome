package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"com/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/LiveWrappedVideoStreamDescription$LiveWrappedEncoderPreference", "", "Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/LiveWrappedVideoStreamDescription$LiveWrappedEncoderPreference;", "", "value", "I", "getValue", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Disabled", "MaintainFramerate", "MaintainQuality", "Balance", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedVideoStreamDescription$LiveWrappedEncoderPreference extends Enum<LiveWrappedVideoStreamDescription$LiveWrappedEncoderPreference> {
    public static final LiveWrappedVideoStreamDescription$LiveWrappedEncoderPreference Balance = null;
    public static final a Companion = null;
    public static final LiveWrappedVideoStreamDescription$LiveWrappedEncoderPreference Disabled = null;
    public static final LiveWrappedVideoStreamDescription$LiveWrappedEncoderPreference MaintainFramerate = null;
    public static final LiveWrappedVideoStreamDescription$LiveWrappedEncoderPreference MaintainQuality = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedVideoStreamDescription$LiveWrappedEncoderPreference[] f147317a = null;
    private final int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.LiveWrappedVideoStreamDescription$LiveWrappedEncoderPreference$a] */
    static {
        LiveWrappedVideoStreamDescription$LiveWrappedEncoderPreference r100 = new LiveWrappedVideoStreamDescription$LiveWrappedEncoderPreference("Disabled", 0, 0);
        Disabled = r100;
        LiveWrappedVideoStreamDescription$LiveWrappedEncoderPreference r101 = new LiveWrappedVideoStreamDescription$LiveWrappedEncoderPreference("MaintainFramerate", 1, 1);
        MaintainFramerate = r101;
        LiveWrappedVideoStreamDescription$LiveWrappedEncoderPreference r102 = new LiveWrappedVideoStreamDescription$LiveWrappedEncoderPreference("MaintainQuality", 2, 2);
        MaintainQuality = r102;
        LiveWrappedVideoStreamDescription$LiveWrappedEncoderPreference r103 = new LiveWrappedVideoStreamDescription$LiveWrappedEncoderPreference("Balance", 3, 3);
        Balance = r103;
        f147317a = new LiveWrappedVideoStreamDescription$LiveWrappedEncoderPreference[]{r100, r101, r102, r103};
        Companion = new a();
    }

    public static LiveWrappedVideoStreamDescription$LiveWrappedEncoderPreference valueOf(String r100) {
        return (LiveWrappedVideoStreamDescription$LiveWrappedEncoderPreference) r27.a.a(LiveWrappedVideoStreamDescription$LiveWrappedEncoderPreference.class, r100);
    }

    public static LiveWrappedVideoStreamDescription$LiveWrappedEncoderPreference[] values() {
        return (LiveWrappedVideoStreamDescription$LiveWrappedEncoderPreference[]) f147317a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public LiveWrappedVideoStreamDescription$LiveWrappedEncoderPreference(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
