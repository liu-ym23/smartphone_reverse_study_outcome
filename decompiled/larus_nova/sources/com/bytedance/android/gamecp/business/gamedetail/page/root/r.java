package com.bytedance.android.gamecp.business.gamedetail.page.root;

import com.bytedance.android.gamecp.common.monitor_v1.FMPMonitorTracker;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class r implements n0<JSONObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n0 f55581a;

    public r(n0 r100) {
        this.f55581a = r100;
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.page.root.n0
    public final void a(n r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        n0 r101 = this.f55581a;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.page.root.n0
    public final void d(n r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        String r101 = r100.f55564a.f469963l0;
        if (r101 == null) goto L5;
        FMPMonitorTracker.k(r101, "custom_page_net_begin", "custom_page_net_duration", true, 16);
    L5:
        n0 r102 = this.f55581a;
        if (r102 == null) goto L9;
        r102.d(r100);
        return;
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.page.root.n0
    public final void b(n r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        String r102 = r100.f55564a.f469963l0;
        if (r102 == null) goto L9;
        FMPMonitorTracker r103 = FMPMonitorTracker.f56555g;
        FMPMonitorTracker.i(r102, "custom_page_net_begin");
        if (r101 != null) goto L7;
        String r104 = "";
    L8:
        FMPMonitorTracker.a(r103, r102, "custom_page_net_log_id", r104, false, 24);
        goto L9
    L7:
        r104 = r101;
    L9:
        n0 r105 = this.f55581a;
        if (r105 == null) goto L13;
        r105.b(r100, r101);
        return;
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.page.root.o0
    public final void c(n r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        String r102 = r100.f55564a.f469963l0;
        if (r102 == null) goto L5;
        FMPMonitorTracker.i(r102, "custom_page_dispatch_begin");
    L5:
        n0 r103 = this.f55581a;
        if (r103 == null) goto L9;
        r103.c(r100, r101);
        return;
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.page.root.n0
    public final JSONObject e(n r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        String r102 = r100.f55564a.f469963l0;
        if (r102 == null) goto L5;
        FMPMonitorTracker.k(r102, "custom_page_json_begin", "custom_page_json_duration", true, 16);
    L5:
        n0 r103 = this.f55581a;
        if (r103 == null) goto L8;
        JSONObject r104 = (JSONObject) r103.e(r100, r101);
    L9:
        if (r104 != null) goto L11;
        r104 = new JSONObject(JSONObjectProtectorUtils.getString(tv5.a.b(r101), "data")).optJSONObject("structure");
        LocalTestManager.a(new Class[]{uv.a.class});
    L11:
        String r105 = r100.f55564a.f469963l0;
        if (r105 == null) goto L14;
        FMPMonitorTracker.i(r105, "custom_page_json_begin");
        FMPMonitorTracker.k(r105, "custom_page_dispatch_begin", "custom_page_dispatch_duration", true, 16);
    L14:
        return r104;
    L8:
        r104 = null;
        goto L9
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.page.root.o0
    public final void f(n r100, Object r101) {
        JSONObject r102 = (JSONObject) r101;
        Intrinsics.checkNotNullParameter(r100, "params");
        String r103 = r100.f55564a.f469963l0;
        if (r103 == null) goto L5;
        FMPMonitorTracker.i(r103, "custom_page_dispatch_begin");
    L5:
        n0 r104 = this.f55581a;
        if (r104 == null) goto L9;
        r104.f(r100, r102);
        return;
    }
}
