package com.bytedance.lego.init;

import com.bytedance.news.common.service.manager.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ServiceManagerProxy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ServiceManagerProxy implements IServiceManagerProxy {
    public static final ServiceManagerProxy INSTANCE = null;
    private static IServiceManagerProxy proxy;

    static {
        INSTANCE = new ServiceManagerProxy();
    }

    private ServiceManagerProxy() {
    }

    public final IServiceManagerProxy getProxy$initscheduler_release() {
        return proxy;
    }

    public final void setProxy$initscheduler_release(IServiceManagerProxy r2) {
        proxy = (IServiceManagerProxy) ZeusTransformUtils.wrapperContextForParams(r2, IServiceManagerProxy.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.lego.init.IServiceManagerProxy
    public <T> T getService(Class<T> r1) {
        o.d(r1, "clazz");
        IServiceManagerProxy r0 = proxy;
        if (r0 == null) goto L9;
        if (r0 != null) goto L10;
        return null;
    L10:
        return (T) r0.getService(r1);
    L9:
        return (T) d.a(r1);
    }
}
