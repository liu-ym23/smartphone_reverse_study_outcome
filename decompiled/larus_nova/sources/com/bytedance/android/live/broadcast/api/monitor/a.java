package com.bytedance.android.live.broadcast.api.monitor;

import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f59061a = 0;

    static {
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        JSONObject r101 = new JSONObject();
        BaseMonitor.add(r101, "msg", r100);
        JSONObject r102 = new JSONObject();
        BaseMonitor.add(r102, "status_code", 0);
        LiveTracingMonitor.f("ttlive_anchor_screenshot_bw_probe_track", LiveTracingMonitor.EventModule.GAME_LIVE, r102, new JSONObject(), r101);
        LocalTestManager.a(new Class[]{wy.a.class});
    }
}
