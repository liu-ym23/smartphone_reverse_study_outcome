package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f114556a = 0;

    static {
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        JSONObject r101 = new JSONObject();
        BaseMonitor.add(r101, "msg", r100);
        JSONObject r102 = new JSONObject();
        JSONObject r103 = new JSONObject();
        BaseMonitor.add(r103, "status_code", 0);
        LiveTracingMonitor.f("ttlive_anchor_screenshot_bw_probe_track", LiveTracingMonitor.EventModule.GAME_LIVE, r103, r102, r101);
        LocalTestManager.a(new Class[]{wy.a.class});
    }
}
