package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import zf2.m;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedAudioRoute;", "", "", "value", "", "toString", "I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "AUDIO_ROUTE_DEFAULT", "AUDIO_ROUTE_HEADSET", "AUDIO_ROUTE_EARPIECE", "AUDIO_ROUTE_SPEAKERPHONE", "AUDIO_ROUTE_HEADSET_BLUETOOTH", "AUDIO_ROUTE_HEADSET_USB", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedAudioRoute extends Enum<LiveWrappedAudioRoute> {
    public static final LiveWrappedAudioRoute AUDIO_ROUTE_DEFAULT = null;
    public static final LiveWrappedAudioRoute AUDIO_ROUTE_EARPIECE = null;
    public static final LiveWrappedAudioRoute AUDIO_ROUTE_HEADSET = null;
    public static final LiveWrappedAudioRoute AUDIO_ROUTE_HEADSET_BLUETOOTH = null;
    public static final LiveWrappedAudioRoute AUDIO_ROUTE_HEADSET_USB = null;
    public static final LiveWrappedAudioRoute AUDIO_ROUTE_SPEAKERPHONE = null;
    public static final a Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedAudioRoute[] f147329a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedAudioRoute$a] */
    static {
        LiveWrappedAudioRoute r100 = new LiveWrappedAudioRoute("AUDIO_ROUTE_DEFAULT", 0, -1);
        AUDIO_ROUTE_DEFAULT = r100;
        LiveWrappedAudioRoute r101 = new LiveWrappedAudioRoute("AUDIO_ROUTE_HEADSET", 1, 1);
        AUDIO_ROUTE_HEADSET = r101;
        LiveWrappedAudioRoute r102 = new LiveWrappedAudioRoute("AUDIO_ROUTE_EARPIECE", 2, 2);
        AUDIO_ROUTE_EARPIECE = r102;
        LiveWrappedAudioRoute r103 = new LiveWrappedAudioRoute("AUDIO_ROUTE_SPEAKERPHONE", 3, 3);
        AUDIO_ROUTE_SPEAKERPHONE = r103;
        LiveWrappedAudioRoute r104 = new LiveWrappedAudioRoute("AUDIO_ROUTE_HEADSET_BLUETOOTH", 4, 4);
        AUDIO_ROUTE_HEADSET_BLUETOOTH = r104;
        LiveWrappedAudioRoute r105 = new LiveWrappedAudioRoute("AUDIO_ROUTE_HEADSET_USB", 5, 5);
        AUDIO_ROUTE_HEADSET_USB = r105;
        f147329a = new LiveWrappedAudioRoute[]{r100, r101, r102, r103, r104, r105};
        Companion = new a();
    }

    public static LiveWrappedAudioRoute valueOf(String r100) {
        return (LiveWrappedAudioRoute) r27.a.a(LiveWrappedAudioRoute.class, r100);
    }

    public static LiveWrappedAudioRoute[] values() {
        return (LiveWrappedAudioRoute[]) f147329a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        switch(m.f571733a[ordinal()]) {
            case 1: goto L11;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L5;
            default: goto L11;
        };
    L5:
        return "AUDIO_ROUTE_HEADSET_BLUETOOTH";
    L6:
        return "AUDIO_ROUTE_HEADSET_USB";
    L7:
        return "AUDIO_ROUTE_HEADSET";
    L8:
        return "AUDIO_ROUTE_SPEAKERPHONE";
    L9:
        return "AUDIO_ROUTE_EARPIECE";
    L11:
        return "AUDIO_ROUTE_DEFAULT";
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedAudioRoute(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
