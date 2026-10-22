package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import zf2.q0;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedSubscribeStateChangeReason;", "", "", "value", "", "toString", "I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "SUBSCRIBE", "UNSUBSCRIBE", "REMOTE_PUBLISH", "REMOTE_UNPUBLISH", "STREAM_FAILED_5XX", "STREAM_FAILED_404", "OVER_STREAM_SUBSCRIBE_LIMIT", "NO_SUBSCRIBE_PERMISSION", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedSubscribeStateChangeReason extends Enum<LiveWrappedSubscribeStateChangeReason> {
    public static final a Companion = null;
    public static final LiveWrappedSubscribeStateChangeReason NO_SUBSCRIBE_PERMISSION = null;
    public static final LiveWrappedSubscribeStateChangeReason OVER_STREAM_SUBSCRIBE_LIMIT = null;
    public static final LiveWrappedSubscribeStateChangeReason REMOTE_PUBLISH = null;
    public static final LiveWrappedSubscribeStateChangeReason REMOTE_UNPUBLISH = null;
    public static final LiveWrappedSubscribeStateChangeReason STREAM_FAILED_404 = null;
    public static final LiveWrappedSubscribeStateChangeReason STREAM_FAILED_5XX = null;
    public static final LiveWrappedSubscribeStateChangeReason SUBSCRIBE = null;
    public static final LiveWrappedSubscribeStateChangeReason UNSUBSCRIBE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedSubscribeStateChangeReason[] f147363a = null;
    private int value;

    public static LiveWrappedSubscribeStateChangeReason valueOf(String r100) {
        return (LiveWrappedSubscribeStateChangeReason) r27.a.a(LiveWrappedSubscribeStateChangeReason.class, r100);
    }

    public static LiveWrappedSubscribeStateChangeReason[] values() {
        return (LiveWrappedSubscribeStateChangeReason[]) f147363a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedSubscribeStateChangeReason$a] */
    static {
        LiveWrappedSubscribeStateChangeReason r100 = new LiveWrappedSubscribeStateChangeReason("SUBSCRIBE", 0, 0);
        SUBSCRIBE = r100;
        LiveWrappedSubscribeStateChangeReason r101 = new LiveWrappedSubscribeStateChangeReason("UNSUBSCRIBE", 1, 1);
        UNSUBSCRIBE = r101;
        LiveWrappedSubscribeStateChangeReason r102 = new LiveWrappedSubscribeStateChangeReason("REMOTE_PUBLISH", 2, 2);
        REMOTE_PUBLISH = r102;
        LiveWrappedSubscribeStateChangeReason r103 = new LiveWrappedSubscribeStateChangeReason("REMOTE_UNPUBLISH", 3, 3);
        REMOTE_UNPUBLISH = r103;
        LiveWrappedSubscribeStateChangeReason r104 = new LiveWrappedSubscribeStateChangeReason("STREAM_FAILED_5XX", 4, 4);
        STREAM_FAILED_5XX = r104;
        LiveWrappedSubscribeStateChangeReason r105 = new LiveWrappedSubscribeStateChangeReason("STREAM_FAILED_404", 5, 5);
        STREAM_FAILED_404 = r105;
        LiveWrappedSubscribeStateChangeReason r106 = new LiveWrappedSubscribeStateChangeReason("OVER_STREAM_SUBSCRIBE_LIMIT", 6, 6);
        OVER_STREAM_SUBSCRIBE_LIMIT = r106;
        LiveWrappedSubscribeStateChangeReason r107 = new LiveWrappedSubscribeStateChangeReason("NO_SUBSCRIBE_PERMISSION", 7, 7);
        NO_SUBSCRIBE_PERMISSION = r107;
        f147363a = new LiveWrappedSubscribeStateChangeReason[]{r100, r101, r102, r103, r104, r105, r106, r107};
        Companion = new a();
    }

    @Override // java.lang.Enum
    public String toString() {
        switch(q0.f571742a[ordinal()]) {
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
        return "kSubscribeStateChangeReasonNoSubscribePermission";
    L6:
        return "kSubscribeStateChangeReasonOverStreamSubscribeLimit";
    L7:
        return "kSubscribeStateChangeReasonStreamFailed404";
    L8:
        return "kSubscribeStateChangeReasonStreamFailed5xx";
    L9:
        return "kSubscribeStateChangeReasonRemoteUnpublish";
    L10:
        return "kSubscribeStateChangeReasonRemotePublish";
    L11:
        return "kSubscribeStateChangeReasonUnsubscribe";
    L12:
        return "kSubscribeStateChangeReasonSubscribe";
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedSubscribeStateChangeReason(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
