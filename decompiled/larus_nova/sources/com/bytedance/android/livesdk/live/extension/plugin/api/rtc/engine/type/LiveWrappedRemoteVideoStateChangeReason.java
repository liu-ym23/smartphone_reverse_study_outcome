package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006J\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/type/LiveWrappedRemoteVideoStateChangeReason;", "", "", "value", "I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "REMOTE_VIDEO_STATE_CHANGE_REASON_INTERNAL", "REMOTE_VIDEO_STATE_CHANGE_REASON_NETWORK_CONGESTION", "REMOTE_VIDEO_STATE_CHANGE_REASON_NETWORK_RECOVERY", "REMOTE_VIDEO_STATE_CHANGE_REASON_LOCAL_MUTED", "REMOTE_VIDEO_STATE_CHANGE_REASON_LOCAL_UNMUTED", "REMOTE_VIDEO_STATE_CHANGE_REASON_REMOTE_MUTED", "REMOTE_VIDEO_STATE_CHANGE_REASON_REMOTE_UNMUTED", "REMOTE_VIDEO_STATE_CHANGE_REASON_REMOTE_OFFLINE", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedRemoteVideoStateChangeReason extends Enum<LiveWrappedRemoteVideoStateChangeReason> {
    public static final a Companion = null;
    public static final LiveWrappedRemoteVideoStateChangeReason REMOTE_VIDEO_STATE_CHANGE_REASON_INTERNAL = null;
    public static final LiveWrappedRemoteVideoStateChangeReason REMOTE_VIDEO_STATE_CHANGE_REASON_LOCAL_MUTED = null;
    public static final LiveWrappedRemoteVideoStateChangeReason REMOTE_VIDEO_STATE_CHANGE_REASON_LOCAL_UNMUTED = null;
    public static final LiveWrappedRemoteVideoStateChangeReason REMOTE_VIDEO_STATE_CHANGE_REASON_NETWORK_CONGESTION = null;
    public static final LiveWrappedRemoteVideoStateChangeReason REMOTE_VIDEO_STATE_CHANGE_REASON_NETWORK_RECOVERY = null;
    public static final LiveWrappedRemoteVideoStateChangeReason REMOTE_VIDEO_STATE_CHANGE_REASON_REMOTE_MUTED = null;
    public static final LiveWrappedRemoteVideoStateChangeReason REMOTE_VIDEO_STATE_CHANGE_REASON_REMOTE_OFFLINE = null;
    public static final LiveWrappedRemoteVideoStateChangeReason REMOTE_VIDEO_STATE_CHANGE_REASON_REMOTE_UNMUTED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedRemoteVideoStateChangeReason[] f147440a = null;
    private int value;

    public static LiveWrappedRemoteVideoStateChangeReason valueOf(String r100) {
        return (LiveWrappedRemoteVideoStateChangeReason) r27.a.a(LiveWrappedRemoteVideoStateChangeReason.class, r100);
    }

    public static LiveWrappedRemoteVideoStateChangeReason[] values() {
        return (LiveWrappedRemoteVideoStateChangeReason[]) f147440a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedRemoteVideoStateChangeReason$a] */
    static {
        LiveWrappedRemoteVideoStateChangeReason r100 = new LiveWrappedRemoteVideoStateChangeReason("REMOTE_VIDEO_STATE_CHANGE_REASON_INTERNAL", 0, 0);
        REMOTE_VIDEO_STATE_CHANGE_REASON_INTERNAL = r100;
        LiveWrappedRemoteVideoStateChangeReason r101 = new LiveWrappedRemoteVideoStateChangeReason("REMOTE_VIDEO_STATE_CHANGE_REASON_NETWORK_CONGESTION", 1, 1);
        REMOTE_VIDEO_STATE_CHANGE_REASON_NETWORK_CONGESTION = r101;
        LiveWrappedRemoteVideoStateChangeReason r102 = new LiveWrappedRemoteVideoStateChangeReason("REMOTE_VIDEO_STATE_CHANGE_REASON_NETWORK_RECOVERY", 2, 2);
        REMOTE_VIDEO_STATE_CHANGE_REASON_NETWORK_RECOVERY = r102;
        LiveWrappedRemoteVideoStateChangeReason r103 = new LiveWrappedRemoteVideoStateChangeReason("REMOTE_VIDEO_STATE_CHANGE_REASON_LOCAL_MUTED", 3, 3);
        REMOTE_VIDEO_STATE_CHANGE_REASON_LOCAL_MUTED = r103;
        LiveWrappedRemoteVideoStateChangeReason r104 = new LiveWrappedRemoteVideoStateChangeReason("REMOTE_VIDEO_STATE_CHANGE_REASON_LOCAL_UNMUTED", 4, 4);
        REMOTE_VIDEO_STATE_CHANGE_REASON_LOCAL_UNMUTED = r104;
        LiveWrappedRemoteVideoStateChangeReason r105 = new LiveWrappedRemoteVideoStateChangeReason("REMOTE_VIDEO_STATE_CHANGE_REASON_REMOTE_MUTED", 5, 5);
        REMOTE_VIDEO_STATE_CHANGE_REASON_REMOTE_MUTED = r105;
        LiveWrappedRemoteVideoStateChangeReason r106 = new LiveWrappedRemoteVideoStateChangeReason("REMOTE_VIDEO_STATE_CHANGE_REASON_REMOTE_UNMUTED", 6, 6);
        REMOTE_VIDEO_STATE_CHANGE_REASON_REMOTE_UNMUTED = r106;
        LiveWrappedRemoteVideoStateChangeReason r107 = new LiveWrappedRemoteVideoStateChangeReason("REMOTE_VIDEO_STATE_CHANGE_REASON_REMOTE_OFFLINE", 7, 7);
        REMOTE_VIDEO_STATE_CHANGE_REASON_REMOTE_OFFLINE = r107;
        f147440a = new LiveWrappedRemoteVideoStateChangeReason[]{r100, r101, r102, r103, r104, r105, r106, r107};
        Companion = new a();
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedRemoteVideoStateChangeReason(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
