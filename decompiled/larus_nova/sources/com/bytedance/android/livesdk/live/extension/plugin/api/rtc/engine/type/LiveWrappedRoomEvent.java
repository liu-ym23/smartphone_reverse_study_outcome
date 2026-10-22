package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.engine.type.WarningCode;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/type/LiveWrappedRoomEvent;", "", "", "value", "I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "USER_NOTIFY_STOP", "FORBIDDEN", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedRoomEvent extends Enum<LiveWrappedRoomEvent> {
    public static final a Companion = null;
    public static final LiveWrappedRoomEvent FORBIDDEN = null;
    public static final LiveWrappedRoomEvent USER_NOTIFY_STOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedRoomEvent[] f147442a = null;
    private final int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedRoomEvent$a] */
    static {
        LiveWrappedRoomEvent r100 = new LiveWrappedRoomEvent("USER_NOTIFY_STOP", 0, WarningCode.WARNING_CODE_RECEIVE_USER_NOTIFY_STOP);
        USER_NOTIFY_STOP = r100;
        LiveWrappedRoomEvent r101 = new LiveWrappedRoomEvent("FORBIDDEN", 1, -2012);
        FORBIDDEN = r101;
        f147442a = new LiveWrappedRoomEvent[]{r100, r101};
        Companion = new a();
    }

    public static LiveWrappedRoomEvent valueOf(String r100) {
        return (LiveWrappedRoomEvent) r27.a.a(LiveWrappedRoomEvent.class, r100);
    }

    public static LiveWrappedRoomEvent[] values() {
        return (LiveWrappedRoomEvent[]) f147442a.clone();
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedRoomEvent(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
