package com.bytedance.ai.applet.permission;

import com.bytedance.ai.bridge.remote.model.AppletPermissionDetail;
import com.bytedance.ai.monitor.AppletMonitorableEvent;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import k5.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f34934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f34935b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f34936c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AppletPermissionDetail f34937d;

    @Override // k5.j
    public final void a(AppletMonitorableEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        r100.f("current_page", "doubao_apps_detail");
        r100.f(BdpAppEventConstant.PARAMS_AUTH_TYPE, this.f34934a);
        r100.f("click_from", this.f34935b);
        r100.f("app_key", this.f34936c);
        String r101 = this.f34937d.getAppletName();
        if (r101 != null) goto L5;
        r101 = this.f34936c;
    L5:
        r100.f("app_name", r101);
    }

    public b(String r100, String r101, String r102, AppletPermissionDetail r103) {
        this.f34934a = r100;
        this.f34935b = r101;
        this.f34936c = r102;
        this.f34937d = r103;
    }
}
