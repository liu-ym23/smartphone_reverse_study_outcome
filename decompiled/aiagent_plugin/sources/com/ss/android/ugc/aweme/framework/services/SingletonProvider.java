package com.ss.android.ugc.aweme.framework.services;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public class SingletonProvider<T> implements ServiceProvider<T> {
    volatile T service;
    ServiceProvider<T> serviceProvider;

    public SingletonProvider(ServiceProvider r3) {
        this.serviceProvider = (ServiceProvider) ZeusTransformUtils.wrapperContextForParams(r3, ServiceProvider.class, "com.obric.aiagent.plugin");
    }

    @Override // com.ss.android.ugc.aweme.framework.services.ServiceProvider
    public synchronized T get() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.service != null) goto L6;
        this.service = this.serviceProvider.get();     // Catch: Throwable -> L9
    L6:
        T r0 = this.service;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }
}
