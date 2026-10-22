package com.bytedanceos.appstore.PreloadInstall;

import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.networkv2.params.NetKey;
import com.bytedanceos.common.networkv2.rest.AbstractRest;
import com.bytedanceos.common.toolbox.e;
import java.util.HashMap;
import java.util.Map;
import rx.Subscriber;

/* JADX INFO: loaded from: classes2.dex */
public class c extends AbstractRest {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile c f8270b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SyncPreloadInstallAppsService f8271a;

    public c() {
        init();
    }

    public static c c() {
        if (f8270b != null) goto L16;
        monitor-enter(c.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f8270b != null) goto L11;
        f8270b = new c();     // Catch: Throwable -> L9
    L11:
        monitor-exit(c.class);     // Catch: Throwable -> L9
    L16:
        return f8270b;
    }

    public void a(Subscriber r10) {
        this.f8271a.getNeedInstallPreloadApps(b()).s(pg.a.c()).q(r10);
    }

    public final Map b() {
        HashMap r10 = new HashMap();
        r10.put(NetKey.IMEI, BaseApplication.c().i().getClientId());
        r10.put(NetKey.OTA_VERSION, e.U(false));
        return r10;
    }

    @Override // com.bytedanceos.common.networkv2.rest.AbstractRest
    public String getBaseUrl() {
        return "";
    }

    @Override // com.bytedanceos.common.networkv2.rest.AbstractRest
    public void setService() {
        this.f8271a = (SyncPreloadInstallAppsService) this.retrofit.d(SyncPreloadInstallAppsService.class);
    }
}
