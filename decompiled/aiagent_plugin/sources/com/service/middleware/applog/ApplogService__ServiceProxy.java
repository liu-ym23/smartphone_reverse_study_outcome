package com.service.middleware.applog;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.ss.android.common.applog.ApplogServiceImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class ApplogService__ServiceProxy implements IServiceProxy<ApplogService> {
    public ApplogService__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ ApplogService newInstance() {
        return newInstance();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public ApplogService newInstance() {
        return new ApplogServiceImpl();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r2) {
        ((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin")).put("com.service.middleware.applog.ApplogService", "com.ss.android.common.applog.ApplogServiceImpl");
    }
}
