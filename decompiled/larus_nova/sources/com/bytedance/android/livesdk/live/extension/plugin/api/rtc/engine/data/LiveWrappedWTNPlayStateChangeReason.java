package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import zf2.w0;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedWTNPlayStateChangeReason;", "", "", "value", "", "toString", "I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "PlaySuccess", "StartPlay", "StopPlay", "RemoteStop", "RemoteFailure", "StreamBanned", "NoPlayPermission", "StreamNotExist", "InRetry", "RetryFail", "Internal", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedWTNPlayStateChangeReason extends Enum<LiveWrappedWTNPlayStateChangeReason> {
    public static final a Companion = null;
    public static final LiveWrappedWTNPlayStateChangeReason InRetry = null;
    public static final LiveWrappedWTNPlayStateChangeReason Internal = null;
    public static final LiveWrappedWTNPlayStateChangeReason NoPlayPermission = null;
    public static final LiveWrappedWTNPlayStateChangeReason PlaySuccess = null;
    public static final LiveWrappedWTNPlayStateChangeReason RemoteFailure = null;
    public static final LiveWrappedWTNPlayStateChangeReason RemoteStop = null;
    public static final LiveWrappedWTNPlayStateChangeReason RetryFail = null;
    public static final LiveWrappedWTNPlayStateChangeReason StartPlay = null;
    public static final LiveWrappedWTNPlayStateChangeReason StopPlay = null;
    public static final LiveWrappedWTNPlayStateChangeReason StreamBanned = null;
    public static final LiveWrappedWTNPlayStateChangeReason StreamNotExist = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedWTNPlayStateChangeReason[] f147378a = null;
    private int value;

    public static LiveWrappedWTNPlayStateChangeReason valueOf(String r100) {
        return (LiveWrappedWTNPlayStateChangeReason) r27.a.a(LiveWrappedWTNPlayStateChangeReason.class, r100);
    }

    public static LiveWrappedWTNPlayStateChangeReason[] values() {
        return (LiveWrappedWTNPlayStateChangeReason[]) f147378a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedWTNPlayStateChangeReason$a] */
    static {
        LiveWrappedWTNPlayStateChangeReason r100 = new LiveWrappedWTNPlayStateChangeReason("PlaySuccess", 0, 0);
        PlaySuccess = r100;
        LiveWrappedWTNPlayStateChangeReason r101 = new LiveWrappedWTNPlayStateChangeReason("StartPlay", 1, 1);
        StartPlay = r101;
        LiveWrappedWTNPlayStateChangeReason r102 = new LiveWrappedWTNPlayStateChangeReason("StopPlay", 2, 2);
        StopPlay = r102;
        LiveWrappedWTNPlayStateChangeReason r103 = new LiveWrappedWTNPlayStateChangeReason("RemoteStop", 3, 3);
        RemoteStop = r103;
        LiveWrappedWTNPlayStateChangeReason r104 = new LiveWrappedWTNPlayStateChangeReason("RemoteFailure", 4, 4);
        RemoteFailure = r104;
        LiveWrappedWTNPlayStateChangeReason r105 = new LiveWrappedWTNPlayStateChangeReason("StreamBanned", 5, 5);
        StreamBanned = r105;
        LiveWrappedWTNPlayStateChangeReason r106 = new LiveWrappedWTNPlayStateChangeReason("NoPlayPermission", 6, 6);
        NoPlayPermission = r106;
        LiveWrappedWTNPlayStateChangeReason r107 = new LiveWrappedWTNPlayStateChangeReason("StreamNotExist", 7, 7);
        StreamNotExist = r107;
        LiveWrappedWTNPlayStateChangeReason r108 = new LiveWrappedWTNPlayStateChangeReason("InRetry", 8, 8);
        InRetry = r108;
        LiveWrappedWTNPlayStateChangeReason r109 = new LiveWrappedWTNPlayStateChangeReason("RetryFail", 9, 9);
        RetryFail = r109;
        LiveWrappedWTNPlayStateChangeReason r110 = new LiveWrappedWTNPlayStateChangeReason("Internal", 10, 10);
        Internal = r110;
        f147378a = new LiveWrappedWTNPlayStateChangeReason[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110};
        Companion = new a();
    }

    @Override // java.lang.Enum
    public String toString() {
        switch(w0.f571749a[ordinal()]) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L7;
            case 10: goto L6;
            case 11: goto L5;
            default: goto L4;
        };
    L4:
        return "";
    L5:
        return "kWTNPlayStateChangeReasonInternal";
    L6:
        return "kWTNPlayStateChangeReasonRetryFail";
    L7:
        return "kWTNPlayStateChangeReasonInRetry";
    L8:
        return "kWTNPlayStateChangeReasonStreamNotExist";
    L9:
        return "kWTNPlayStateChangeReasonNoPlayPermission";
    L10:
        return "kWTNPlayStateChangeReasonStreamBanned";
    L11:
        return "kWTNPlayStateChangeReasonRemoteFailure";
    L12:
        return "kWTNPlayStateChangeReasonRemoteStop";
    L13:
        return "kWTNPlayStateChangeReasonStopPlay";
    L14:
        return "kWTNPlayStateChangeReasonStartPlay";
    L15:
        return "kWTNPlayStateChangeReasonPlaySuccess";
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedWTNPlayStateChangeReason(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
