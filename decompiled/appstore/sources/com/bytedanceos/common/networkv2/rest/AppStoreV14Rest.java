package com.bytedanceos.common.networkv2.rest;

import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.networkv2.service.AppStoreV14Service;
import com.bytedanceos.common.toolbox.e;
import java.util.HashMap;
import pg.a;
import rx.Subscriber;

/* JADX INFO: loaded from: classes2.dex */
public class AppStoreV14Rest extends AbstractRest {
    private static volatile AppStoreV14Rest sInstance;
    private AppStoreV14Service mService;

    private AppStoreV14Rest() {
        init();
    }

    public static AppStoreV14Rest instance() {
        if (sInstance != null) goto L16;
        monitor-enter(AppStoreV14Rest.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L11;
        sInstance = new AppStoreV14Rest();     // Catch: Throwable -> L9
    L11:
        monitor-exit(AppStoreV14Rest.class);     // Catch: Throwable -> L9
    L16:
        return sInstance;
    }

    @Override // com.bytedanceos.common.networkv2.rest.AbstractRest
    public String getBaseUrl() {
        return "";
    }

    public void getCategoryApps(String r10, int r11, Subscriber r12) {
        HashMap r13 = new HashMap();
        if (BaseApplication.c().o() == false) goto L5;
        r13.put("source", "1");
    L6:
        r13.put("size", "20");
        r13.put("page", String.valueOf(r11));
        e.U(false);
        this.mService.getCategoryApps(r10, getUrlParams(r13)).s(a.c()).g(mg.a.b()).q(r12);
        return;
    L5:
        r13.put("source", "2");
        goto L6
    }

    @Override // com.bytedanceos.common.networkv2.rest.AbstractRest
    public void setService() {
        this.mService = (AppStoreV14Service) this.retrofit.d(AppStoreV14Service.class);
    }
}
