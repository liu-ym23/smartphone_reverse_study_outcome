package com.bytedance.android.live.liveinteract.wrds;

import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f81172a = 0;

    static {
    }

    public static void a(String r100, long r101, long r102, String r103, long r104, TalkRoomBusinessFullLinkMonitor.WrdsStatusType r110) {
        Intrinsics.checkNotNullParameter(r100, "apiName");
        Intrinsics.checkNotNullParameter(r103, "uid");
        Intrinsics.checkNotNullParameter(r110, "wrdsStatusType");
        long r105 = System.currentTimeMillis() - r101;
        JSONObject r106 = new JSONObject();
        r106.put("status", r110.getCode());
        r106.put("api_name", r100);
        JSONObject r107 = new JSONObject();
        r107.put("duration", r105);
        JSONObject r108 = new JSONObject();
        r108.put("version", r102);
        r108.put("room_id", r104);
        r108.put("uid", r103);
        LiveTracingMonitor.f("ttlive_wrds_request_duration", LiveTracingMonitor.EventModule.WRDS, r106, r107, r108);
    }
}
