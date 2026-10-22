package com.bytedance.android.live.revlink.impl.multianchor.profit;

import com.bytedance.android.live.core.monitor.LiveTracingMonitorKt;
import com.bytedance.android.live.revenuelink.f;
import com.bytedance.android.live.revlink.impl.global.LinkFakeGlobalService;
import com.bytedance.android.live.revlink.impl.multianchor.utils.e;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class a extends e {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f94618e = 0;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.multianchor.profit.a$a, reason: collision with other inner class name */
    public static final class C1464a {
    }

    static {
    }

    public final void m(Throwable r100) {
        if (k() == true) goto L5;
        return;
    L5:
        JSONObject r101 = new JSONObject();
        if (r100 == null) goto L8;
        e.l(r100, r101);
        o("manual_clear_link_score_failed", r101);
        return;
    L8:
        o("manual_clear_link_score_success", r101);
    }

    public final void n(boolean r100, Throwable r101) {
        if (k() == true) goto L5;
        return;
    L5:
        JSONObject r102 = new JSONObject();
        y50.b.a.e(r102, "show_score", r100);
        if (r101 == null) goto L8;
        e.l(r101, r102);
        o("manual_switch_link_score_status_failed", r102);
        return;
    L8:
        o("manual_switch_link_score_status_success", r102);
    }

    public final void o(String r110, JSONObject r111) {
        Intrinsics.checkNotNullParameter(r110, "event");
        Intrinsics.checkNotNullParameter(r111, "params");
        g(r111);
        c(r111);
        y50.b.a.d(r111, "event", r110);
        JSONObject r100 = new JSONObject();
        JSONObject r112 = new JSONObject();
        HashMap r101 = new HashMap();
        r101.put("android_event_key", r110);
        com.bytedance.android.live.revlink.impl.global.c r102 = this.f94912d;
        if (r102 == null) goto L5;
        f r103 = r102.getRevenueLinkTraceMonitor();
    L6:
        f r104 = r103;
        if (r104 == null) goto L10;
        r104.Y(r110, LiveTracingMonitorKt.EventModule.MULTI_LINKER, 0, null, r101, r111, r100, r112);
        return;
    L10:
        return;
    L5:
        r103 = null;
        goto L6
    }

    public a(ld.a r100, com.bytedance.android.livesdk.revenue.service.room.c r101, LinkFakeGlobalService r102) {
        super(r100, r101, r102);
    }
}
