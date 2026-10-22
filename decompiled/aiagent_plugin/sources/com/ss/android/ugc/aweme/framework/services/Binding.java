package com.ss.android.ugc.aweme.framework.services;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public final class Binding<T> {
    Class<T> klass;
    ServiceManager serviceManager;
    ServiceProvider<T> serviceProvider;

    Binding(ServiceManager r3, Class<T> r4, ServiceProvider<T> r5) {
        ServiceProvider<T> r6 = (ServiceProvider) ZeusTransformUtils.wrapperContextForParams(r5, ServiceProvider.class, "com.obric.aiagent.plugin");
        this.serviceManager = r3;
        this.klass = r4;
        this.serviceProvider = r6;
        Set r2 = (Set) ZeusTransformUtils.preCheckCast(r3.classServiceProviderConcurrentHashMap.get(r4), Set.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L5;
        Set<ServiceProvider<?>> r7 = Collections.synchronizedSet(new LinkedHashSet());
        r7.add(r6);
        r3.classServiceProviderConcurrentHashMap.put(r4, r7);
        return;
    L5:
        r2.add(r6);
    }

    public Binding<T> asSingleton() {
        Set r0 = (Set) ZeusTransformUtils.preCheckCast(this.serviceManager.classServiceProviderConcurrentHashMap.get(this.klass), Set.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(this.serviceProvider, SingletonProvider.class) == true) goto L5;
        r0.remove(this.serviceProvider);
        SingletonProvider r1 = new SingletonProvider(this.serviceProvider);
        this.serviceProvider = r1;
        r0.add(r1);
    L5:
        return this;
    }
}
