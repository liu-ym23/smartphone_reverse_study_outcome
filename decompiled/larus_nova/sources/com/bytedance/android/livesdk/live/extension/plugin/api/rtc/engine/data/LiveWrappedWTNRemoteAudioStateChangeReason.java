package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import zf2.a1;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedWTNRemoteAudioStateChangeReason;", "", "", "value", "", "toString", "I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Internal", "NetworkCongestion", "NetworkRecovery", "LocalUnmute", "LocalMute", "RemoteStart", "RemoteStop", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedWTNRemoteAudioStateChangeReason extends Enum<LiveWrappedWTNRemoteAudioStateChangeReason> {
    public static final a Companion = null;
    public static final LiveWrappedWTNRemoteAudioStateChangeReason Internal = null;
    public static final LiveWrappedWTNRemoteAudioStateChangeReason LocalMute = null;
    public static final LiveWrappedWTNRemoteAudioStateChangeReason LocalUnmute = null;
    public static final LiveWrappedWTNRemoteAudioStateChangeReason NetworkCongestion = null;
    public static final LiveWrappedWTNRemoteAudioStateChangeReason NetworkRecovery = null;
    public static final LiveWrappedWTNRemoteAudioStateChangeReason RemoteStart = null;
    public static final LiveWrappedWTNRemoteAudioStateChangeReason RemoteStop = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedWTNRemoteAudioStateChangeReason[] f147382a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedWTNRemoteAudioStateChangeReason$a] */
    static {
        LiveWrappedWTNRemoteAudioStateChangeReason r100 = new LiveWrappedWTNRemoteAudioStateChangeReason("Internal", 0, 0);
        Internal = r100;
        LiveWrappedWTNRemoteAudioStateChangeReason r101 = new LiveWrappedWTNRemoteAudioStateChangeReason("NetworkCongestion", 1, 1);
        NetworkCongestion = r101;
        LiveWrappedWTNRemoteAudioStateChangeReason r102 = new LiveWrappedWTNRemoteAudioStateChangeReason("NetworkRecovery", 2, 2);
        NetworkRecovery = r102;
        LiveWrappedWTNRemoteAudioStateChangeReason r103 = new LiveWrappedWTNRemoteAudioStateChangeReason("LocalUnmute", 3, 3);
        LocalUnmute = r103;
        LiveWrappedWTNRemoteAudioStateChangeReason r104 = new LiveWrappedWTNRemoteAudioStateChangeReason("LocalMute", 4, 4);
        LocalMute = r104;
        LiveWrappedWTNRemoteAudioStateChangeReason r105 = new LiveWrappedWTNRemoteAudioStateChangeReason("RemoteStart", 5, 5);
        RemoteStart = r105;
        LiveWrappedWTNRemoteAudioStateChangeReason r106 = new LiveWrappedWTNRemoteAudioStateChangeReason("RemoteStop", 6, 6);
        RemoteStop = r106;
        f147382a = new LiveWrappedWTNRemoteAudioStateChangeReason[]{r100, r101, r102, r103, r104, r105, r106};
        Companion = new a();
    }

    public static LiveWrappedWTNRemoteAudioStateChangeReason valueOf(String r100) {
        return (LiveWrappedWTNRemoteAudioStateChangeReason) r27.a.a(LiveWrappedWTNRemoteAudioStateChangeReason.class, r100);
    }

    public static LiveWrappedWTNRemoteAudioStateChangeReason[] values() {
        return (LiveWrappedWTNRemoteAudioStateChangeReason[]) f147382a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        switch(a1.f571692a[ordinal()]) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            case 7: goto L5;
            default: goto L4;
        };
    L4:
        return "";
    L5:
        return "RemoteStop";
    L6:
        return "RemoteStart";
    L7:
        return "LocalMute";
    L8:
        return "LocalUnmute";
    L9:
        return "NetworkRecovery";
    L10:
        return "NetworkCongestion";
    L11:
        return "Internal";
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedWTNRemoteAudioStateChangeReason(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
