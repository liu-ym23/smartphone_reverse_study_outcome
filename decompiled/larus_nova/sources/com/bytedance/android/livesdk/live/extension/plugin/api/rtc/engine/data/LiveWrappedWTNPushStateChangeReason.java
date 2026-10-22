package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import zf2.y0;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedWTNPushStateChangeReason;", "", "", "value", "", "toString", "I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "PushSuccess", "StartPush", "StopPush", "InRetry", "RetryFail", "NoPushPermission", "StreamPushByOther", "Internal", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedWTNPushStateChangeReason extends Enum<LiveWrappedWTNPushStateChangeReason> {
    public static final a Companion = null;
    public static final LiveWrappedWTNPushStateChangeReason InRetry = null;
    public static final LiveWrappedWTNPushStateChangeReason Internal = null;
    public static final LiveWrappedWTNPushStateChangeReason NoPushPermission = null;
    public static final LiveWrappedWTNPushStateChangeReason PushSuccess = null;
    public static final LiveWrappedWTNPushStateChangeReason RetryFail = null;
    public static final LiveWrappedWTNPushStateChangeReason StartPush = null;
    public static final LiveWrappedWTNPushStateChangeReason StopPush = null;
    public static final LiveWrappedWTNPushStateChangeReason StreamPushByOther = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedWTNPushStateChangeReason[] f147380a = null;
    private int value;

    public static LiveWrappedWTNPushStateChangeReason valueOf(String r100) {
        return (LiveWrappedWTNPushStateChangeReason) r27.a.a(LiveWrappedWTNPushStateChangeReason.class, r100);
    }

    public static LiveWrappedWTNPushStateChangeReason[] values() {
        return (LiveWrappedWTNPushStateChangeReason[]) f147380a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedWTNPushStateChangeReason$a] */
    static {
        LiveWrappedWTNPushStateChangeReason r100 = new LiveWrappedWTNPushStateChangeReason("PushSuccess", 0, 0);
        PushSuccess = r100;
        LiveWrappedWTNPushStateChangeReason r101 = new LiveWrappedWTNPushStateChangeReason("StartPush", 1, 1);
        StartPush = r101;
        LiveWrappedWTNPushStateChangeReason r102 = new LiveWrappedWTNPushStateChangeReason("StopPush", 2, 2);
        StopPush = r102;
        LiveWrappedWTNPushStateChangeReason r103 = new LiveWrappedWTNPushStateChangeReason("InRetry", 3, 3);
        InRetry = r103;
        LiveWrappedWTNPushStateChangeReason r104 = new LiveWrappedWTNPushStateChangeReason("RetryFail", 4, 4);
        RetryFail = r104;
        LiveWrappedWTNPushStateChangeReason r105 = new LiveWrappedWTNPushStateChangeReason("NoPushPermission", 5, 5);
        NoPushPermission = r105;
        LiveWrappedWTNPushStateChangeReason r106 = new LiveWrappedWTNPushStateChangeReason("StreamPushByOther", 6, 6);
        StreamPushByOther = r106;
        LiveWrappedWTNPushStateChangeReason r107 = new LiveWrappedWTNPushStateChangeReason("Internal", 7, 7);
        Internal = r107;
        f147380a = new LiveWrappedWTNPushStateChangeReason[]{r100, r101, r102, r103, r104, r105, r106, r107};
        Companion = new a();
    }

    @Override // java.lang.Enum
    public String toString() {
        switch(y0.f571753a[ordinal()]) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            case 8: goto L5;
            default: goto L4;
        };
    L4:
        return "";
    L5:
        return "kWTNPushStateChangeReasonInternal";
    L6:
        return "kWTNPushStateChangeReasonStreamPushByOther";
    L7:
        return "kWTNPushStateChangeReasonNoPushPermission";
    L8:
        return "kWTNPushStateChangeReasonRetryFail";
    L9:
        return "kWTNPushStateChangeReasonInRetry";
    L10:
        return "kWTNPushStateChangeReasonStopPush";
    L11:
        return "kWTNPushStateChangeReasonStartPush";
    L12:
        return "kWTNPushStateChangeReasonPushSuccess";
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedWTNPushStateChangeReason(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
