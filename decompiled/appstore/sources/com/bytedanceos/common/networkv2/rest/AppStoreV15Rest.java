package com.bytedanceos.common.networkv2.rest;

import com.bytedanceos.common.networkv2.entity.AppInfosEntity;
import com.bytedanceos.common.networkv2.entity.BaseEntity;
import com.bytedanceos.common.networkv2.entity.CategoryAppListEntity;
import com.bytedanceos.common.networkv2.entity.GameSubInfoEntity;
import com.bytedanceos.common.networkv2.entity.MySubListEntity;
import com.bytedanceos.common.networkv2.params.NetKey;
import com.bytedanceos.common.networkv2.service.AppStoreV15Service;
import com.bytedanceos.common.networkv2.subscriber.NSubscriber;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class AppStoreV15Rest extends AbstractRest {
    private static volatile AppStoreV15Rest sInstance;
    private AppStoreV15Service mService;

    private AppStoreV15Rest() {
        init();
    }

    public static AppStoreV15Rest instance() {
        if (sInstance != null) goto L16;
        monitor-enter(AppStoreV15Rest.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L11;
        sInstance = new AppStoreV15Rest();     // Catch: Throwable -> L9
    L11:
        monitor-exit(AppStoreV15Rest.class);     // Catch: Throwable -> L9
    L16:
        return sInstance;
    }

    public void doSubscribe(String r10, String r11, NSubscriber<BaseEntity> r12) {
        HashMap r13 = new HashMap();
        r13.put("id", r10);
        r13.put("status", r11);
        this.mService.doSubcribe(getUrlParams(r13)).a(schedulersTransformer()).f(this.parseFun).q(r12);
    }

    public void getAppInfo(String r10, NSubscriber<AppInfosEntity> r11) {
        HashMap r12 = new HashMap();
        r12.put("package", r10);
        this.mService.getAppInfo(getUrlParams(r12)).a(schedulersTransformer()).f(this.parseFun).f(new AnonymousClass5(this)).q(r11);
    }

    @Override // com.bytedanceos.common.networkv2.rest.AbstractRest
    public String getBaseUrl() {
        return "";
    }

    public void getCategoryApps(String r10, String r11, String r12, NSubscriber<CategoryAppListEntity> r13) {
        HashMap r14 = new HashMap();
        r14.put("cid", r10);
        r14.put("type", r11);
        r14.put(NetKey.PAGE_SOURCE, r12);
        this.mService.getCategoryApps(getUrlParams(r14)).a(schedulersTransformer()).f(this.parseFun).f(new AnonymousClass3(this)).q(r13);
    }

    public void getGameSubcribeInfo(String r10, NSubscriber<GameSubInfoEntity> r11) {
        HashMap r12 = new HashMap();
        r12.put("id", r10);
        this.mService.getGameSubcribeInfo(getUrlParams(r12)).a(schedulersTransformer()).f(this.parseFun).f(new AnonymousClass2(this)).q(r11);
    }

    public void getMySubList(NSubscriber<MySubListEntity> r10) {
        this.mService.getMySubList(getUrlParams(null)).a(schedulersTransformer()).f(this.parseFun).f(new AnonymousClass1(this)).q(r10);
    }

    public void reportUserInfo(NSubscriber<BaseEntity> r10) {
        if (r10 != null) goto L4;
        r10 = new AnonymousClass4(this);
    L4:
        this.mService.reportUserInfo(getUrlParams(null)).a(schedulersTransformer()).f(this.parseFun).q(r10);
    }

    @Override // com.bytedanceos.common.networkv2.rest.AbstractRest
    public void setService() {
        this.mService = (AppStoreV15Service) this.retrofit.d(AppStoreV15Service.class);
    }
}
