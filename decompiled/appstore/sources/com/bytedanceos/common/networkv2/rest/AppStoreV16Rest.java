package com.bytedanceos.common.networkv2.rest;

import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.networkv2.entity.GameSubListEntity;
import com.bytedanceos.common.networkv2.entity.ManagerSubListEntity;
import com.bytedanceos.common.networkv2.service.AppStoreV16Service;
import com.bytedanceos.common.networkv2.subscriber.NSubscriber;
import java.util.HashMap;
import pg.a;
import rx.Observable;
import rx.Subscriber;

/* JADX INFO: loaded from: classes2.dex */
public class AppStoreV16Rest extends AbstractRest {
    private static volatile AppStoreV16Rest sInstance;
    private AppStoreV16Service mService;

    private AppStoreV16Rest() {
        init();
    }

    public static AppStoreV16Rest instance() {
        if (sInstance != null) goto L16;
        monitor-enter(AppStoreV16Rest.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L11;
        sInstance = new AppStoreV16Rest();     // Catch: Throwable -> L9
    L11:
        monitor-exit(AppStoreV16Rest.class);     // Catch: Throwable -> L9
    L16:
        return sInstance;
    }

    public void getAppManagerRecommendApps(String r10, Subscriber r11) {
        HashMap r12 = new HashMap();
        if (BaseApplication.c().o() == false) goto L5;
        r12.put("source", "1");
    L6:
        this.mService.getAppManagerRecommendApps(r10, getUrlParams(r12)).s(a.c()).g(mg.a.b()).q(r11);
        return;
    L5:
        r12.put("source", "2");
        goto L6
    }

    @Override // com.bytedanceos.common.networkv2.rest.AbstractRest
    public String getBaseUrl() {
        return "";
    }

    public void getCountData(Subscriber r10) {
        HashMap r11 = new HashMap();
        if (BaseApplication.c().o() == false) goto L5;
        r11.put("source", "1");
    L6:
        this.mService.getCountData(getUrlParams(r11)).s(a.c()).g(mg.a.b()).q(r10);
        return;
    L5:
        r11.put("source", "2");
        goto L6
    }

    public Observable getFirstRecommendList() {
        HashMap r10 = new HashMap();
        return this.mService.getFirstRecommendList(getUrlParams(r10)).s(a.c()).g(mg.a.b());
    }

    public void getGameSubcribeList(NSubscriber<GameSubListEntity> r10) {
        this.mService.getGameSubcribeList(getUrlParams(null)).a(schedulersTransformer()).f(this.parseFun).f(new AnonymousClass1(this)).q(r10);
    }

    public void getManagerSubList(NSubscriber<ManagerSubListEntity> r10) {
        this.mService.getManagerSubList(getUrlParams(null)).a(schedulersTransformer()).f(this.parseFun).f(new AnonymousClass2(this)).q(r10);
    }

    @Override // com.bytedanceos.common.networkv2.rest.AbstractRest
    public void setService() {
        this.mService = (AppStoreV16Service) this.retrofit.d(AppStoreV16Service.class);
    }
}
