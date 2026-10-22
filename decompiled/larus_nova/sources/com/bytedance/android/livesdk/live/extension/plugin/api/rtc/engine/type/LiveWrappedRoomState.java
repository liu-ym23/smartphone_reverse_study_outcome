package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/type/LiveWrappedRoomState;", "", "", "value", "I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "JOIN_SUCCESS", "JOIN_FAILED", "LEFT", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedRoomState extends Enum<LiveWrappedRoomState> {
    public static final a Companion = null;
    public static final LiveWrappedRoomState JOIN_FAILED = null;
    public static final LiveWrappedRoomState JOIN_SUCCESS = null;
    public static final LiveWrappedRoomState LEFT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedRoomState[] f147444a = null;
    private final int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedRoomState$a] */
    static {
        LiveWrappedRoomState r100 = new LiveWrappedRoomState("JOIN_SUCCESS", 0, 0);
        JOIN_SUCCESS = r100;
        LiveWrappedRoomState r101 = new LiveWrappedRoomState("JOIN_FAILED", 1, 1);
        JOIN_FAILED = r101;
        LiveWrappedRoomState r102 = new LiveWrappedRoomState("LEFT", 2, 2);
        LEFT = r102;
        f147444a = new LiveWrappedRoomState[]{r100, r101, r102};
        Companion = new a();
    }

    public static LiveWrappedRoomState valueOf(String r100) {
        return (LiveWrappedRoomState) r27.a.a(LiveWrappedRoomState.class, r100);
    }

    public static LiveWrappedRoomState[] values() {
        return (LiveWrappedRoomState[]) f147444a.clone();
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedRoomState(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
