package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ttvecamera.TECameraResult;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/type/LiveWrappedSetRoomExtraInfoResult;", "", "", "value", "I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "SUCCESS", "NOT_JOIN_ROOM", "KEY_IS_NULL", "VALUE_IS_NULL", "UNKNOW", "KEY_IS_EMPTY", "TOO_OFTEN", "SILENT_USER", "KEY_TOO_LONG", "VALUE_TOO_LONG", "SERVER_ERROR", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedSetRoomExtraInfoResult extends Enum<LiveWrappedSetRoomExtraInfoResult> {
    public static final a Companion = null;
    public static final LiveWrappedSetRoomExtraInfoResult KEY_IS_EMPTY = null;
    public static final LiveWrappedSetRoomExtraInfoResult KEY_IS_NULL = null;
    public static final LiveWrappedSetRoomExtraInfoResult KEY_TOO_LONG = null;
    public static final LiveWrappedSetRoomExtraInfoResult NOT_JOIN_ROOM = null;
    public static final LiveWrappedSetRoomExtraInfoResult SERVER_ERROR = null;
    public static final LiveWrappedSetRoomExtraInfoResult SILENT_USER = null;
    public static final LiveWrappedSetRoomExtraInfoResult SUCCESS = null;
    public static final LiveWrappedSetRoomExtraInfoResult TOO_OFTEN = null;
    public static final LiveWrappedSetRoomExtraInfoResult UNKNOW = null;
    public static final LiveWrappedSetRoomExtraInfoResult VALUE_IS_NULL = null;
    public static final LiveWrappedSetRoomExtraInfoResult VALUE_TOO_LONG = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedSetRoomExtraInfoResult[] f147447a = null;
    private final int value;

    public static LiveWrappedSetRoomExtraInfoResult valueOf(String r100) {
        return (LiveWrappedSetRoomExtraInfoResult) r27.a.a(LiveWrappedSetRoomExtraInfoResult.class, r100);
    }

    public static LiveWrappedSetRoomExtraInfoResult[] values() {
        return (LiveWrappedSetRoomExtraInfoResult[]) f147447a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedSetRoomExtraInfoResult$a] */
    static {
        LiveWrappedSetRoomExtraInfoResult r100 = new LiveWrappedSetRoomExtraInfoResult("SUCCESS", 0, 0);
        SUCCESS = r100;
        LiveWrappedSetRoomExtraInfoResult r101 = new LiveWrappedSetRoomExtraInfoResult("NOT_JOIN_ROOM", 1, -1);
        NOT_JOIN_ROOM = r101;
        LiveWrappedSetRoomExtraInfoResult r102 = new LiveWrappedSetRoomExtraInfoResult("KEY_IS_NULL", 2, -2);
        KEY_IS_NULL = r102;
        LiveWrappedSetRoomExtraInfoResult r103 = new LiveWrappedSetRoomExtraInfoResult("VALUE_IS_NULL", 3, -3);
        VALUE_IS_NULL = r103;
        LiveWrappedSetRoomExtraInfoResult r104 = new LiveWrappedSetRoomExtraInfoResult("UNKNOW", 4, -99);
        UNKNOW = r104;
        LiveWrappedSetRoomExtraInfoResult r105 = new LiveWrappedSetRoomExtraInfoResult("KEY_IS_EMPTY", 5, -400);
        KEY_IS_EMPTY = r105;
        LiveWrappedSetRoomExtraInfoResult r106 = new LiveWrappedSetRoomExtraInfoResult("TOO_OFTEN", 6, -406);
        TOO_OFTEN = r106;
        LiveWrappedSetRoomExtraInfoResult r107 = new LiveWrappedSetRoomExtraInfoResult("SILENT_USER", 7, -412);
        SILENT_USER = r107;
        LiveWrappedSetRoomExtraInfoResult r108 = new LiveWrappedSetRoomExtraInfoResult("KEY_TOO_LONG", 8, -413);
        KEY_TOO_LONG = r108;
        LiveWrappedSetRoomExtraInfoResult r109 = new LiveWrappedSetRoomExtraInfoResult("VALUE_TOO_LONG", 9, TECameraResult.TER_CAMERA_EC_NOT_SUPPORT);
        VALUE_TOO_LONG = r109;
        LiveWrappedSetRoomExtraInfoResult r110 = new LiveWrappedSetRoomExtraInfoResult("SERVER_ERROR", 10, -500);
        SERVER_ERROR = r110;
        f147447a = new LiveWrappedSetRoomExtraInfoResult[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110};
        Companion = new a();
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedSetRoomExtraInfoResult(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
