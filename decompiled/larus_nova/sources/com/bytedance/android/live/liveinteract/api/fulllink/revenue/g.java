package com.bytedance.android.live.liveinteract.api.fulllink.revenue;

import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.plantform.monitor.MultiLinkEventModule;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MultiLinkEventModule f71493a = null;

    static {
        f71493a = MultiLinkEventModule.PAID_LINK_MIC;
    }

    public static long b(long r100) {
        if (r100 > 0) goto L5;
        return 0;
    L5:
        if (r100 < System.currentTimeMillis()) goto L7;
        return 0;
    L7:
        return System.currentTimeMillis() - r100;
    }

    public static void c(String r110) {
        Intrinsics.checkNotNullParameter(r110, "requestPage");
        JSONObject r100 = new JSONObject();
        r100.put("request_page", r110);
        nd0.c.p(nd0.c.f518746a, LinkMonitorData.OpenNormalPaidApplyPanel, r100, f71493a, 0, null, false, null, 120);
    }

    public static void a(int r100, int r110) {
        JSONObject r101 = new JSONObject();
        r101.put("mode", r110);
        r101.put("state", r100);
        nd0.c.p(nd0.c.f518746a, LinkMonitorData.AddPriceButtonClick, r101, f71493a, 0, null, false, null, 120);
    }
}
