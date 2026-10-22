package com.bytedance.android.livesdk.utils;

import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class a4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f158819a = 0;

    static {
    }

    @JvmStatic
    public static final void a(int r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "logId");
        JSONObject r103 = new JSONObject();
        if (r102 == null) goto L5;
        r103.put(ILiveRoomPlayFragmentConstant.EXTRA_LOG_ROOM_TAG, r102);
    L5:
        JSONObject r104 = new JSONObject();
        r104.put("log_id", r101);
        LiveMonitor.a r105 = new LiveMonitor.a("ttlive_realtime_msg_http_pull_error", LiveTracingMonitor.EventModule.LIVE_MESSAGE);
        r105.l(r100);
        r105.b(r103);
        r105.f64902e = r104;
        r105.f64903f = true;
        r105.a().report();
    }
}
