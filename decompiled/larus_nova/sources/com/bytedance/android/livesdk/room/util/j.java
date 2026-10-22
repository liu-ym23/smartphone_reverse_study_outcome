package com.bytedance.android.livesdk.room.util;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.SettingKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f157836a = false;

    static {
        Boolean r100 = Boolean.TRUE;
        f157836a = ((Boolean) new SettingKey("live_room_controller_log_enable", "controller生命周期日志开关", r100, r100, true).getValue()).booleanValue();
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        if (f157836a == false) goto L6;
        ALogger.i("PreviewRoomControllerTracer", r100);
        return;
    }

    public static void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        if (f157836a == false) goto L6;
        ALogger.i("RoomControllerTracer", r100);
        return;
    }
}
