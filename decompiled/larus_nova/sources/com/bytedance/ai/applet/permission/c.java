package com.bytedance.ai.applet.permission;

import com.bytedance.ai.bridge.remote.model.AppletPermissionDetail;
import com.bytedance.ai.monitor.AppletMonitorableEvent;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import k5.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class c implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f34938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f34939b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AppletPermissionDetail f34940c;

    @Override // k5.j
    public final void a(AppletMonitorableEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        r100.f("current_page", "doubao_apps_detail");
        r100.f(BdpAppEventConstant.PARAMS_AUTH_TYPE, this.f34938a);
        r100.f("app_key", this.f34939b);
        String r101 = this.f34940c.getAppletName();
        if (r101 != null) goto L5;
        r101 = this.f34939b;
    L5:
        r100.f("app_name", r101);
    }

    public c(String r100, String r101, AppletPermissionDetail r102) {
        this.f34938a = r100;
        this.f34939b = r101;
        this.f34940c = r102;
    }
}
