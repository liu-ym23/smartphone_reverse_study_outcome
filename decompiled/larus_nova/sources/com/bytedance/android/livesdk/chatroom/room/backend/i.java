package com.bytedance.android.livesdk.chatroom.room.backend;

import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class i extends BaseMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f110827a = null;

    static {
        f110827a = new i();
    }

    public static String l() {
        StackTraceElement[] r100 = ThreadMethodProxy.currentThread().getStackTrace();
        StringBuilder r101 = new StringBuilder();
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L6;
        r101.append(r100[r103].toString());
        r101.append("\n");
        r103 = r103 + 1;
        goto L3
    L6:
        return r101.toString();
    }

    public i() {
    }

    public static void m(String r100, String r101, String r102, String r110) {
        Intrinsics.checkNotNullParameter(r100, "errorMsg");
        Intrinsics.checkNotNullParameter(r101, "roomId");
        Intrinsics.checkNotNullParameter(r102, "clazzName");
        if (LiveInfraSettingKeys.LIVE_BACKEND_TASK_CONFIG.getValue().canUseBackendTask() == true) goto L5;
        return;
    L5:
        JSONObject r103 = new JSONObject();
        JSONObject r104 = new JSONObject();
        BaseMonitor.add(r103, "room_id", r101);
        BaseMonitor.add(r103, "biz_class_name", r102);
        if (r110 == null) goto L8;
        BaseMonitor.add(r103, "server_room_id", r110);
    L8:
        BaseMonitor.add(r104, "error_message", r100);
        LiveTracingMonitor.e("ttlive_backend_business_fail", LiveTracingMonitor.EventModule.BACKEND, LiveTracingMonitor.EventType.SERVER_API_CALL, null, r104, r103);
    }
}
