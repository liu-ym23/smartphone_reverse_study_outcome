package com.ss.android.ugc.aweme.framework.services;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public final class Binding<T> {
    Class<T> klass;
    ServiceManager serviceManager;
    ServiceProvider<T> serviceProvider;

    Binding(ServiceManager r1, Class<T> r2, ServiceProvider<T> r3) {
        this.serviceManager = r1;
        this.klass = r2;
        this.serviceProvider = r3;
        Set<ServiceProvider<?>> r0 = r1.classServiceProviderConcurrentHashMap.get(r2);
        if (r0 != null) goto L5;
        Set<ServiceProvider<?>> r4 = Collections.synchronizedSet(new LinkedHashSet());
        r4.add(r3);
        r1.classServiceProviderConcurrentHashMap.put(r2, r4);
        return;
    L5:
        r0.add(r3);
    }

    public Binding<T> asSingleton() {
        Set r0 = this.serviceManager.classServiceProviderConcurrentHashMap.get(this.klass);
        ServiceProvider<T> r1 = this.serviceProvider;
        if ((r1 instanceof SingletonProvider) == true) goto L5;
        r0.remove(r1);
        SingletonProvider r2 = new SingletonProvider(this.serviceProvider);
        this.serviceProvider = r2;
        r0.add(r2);
    L5:
        return this;
    }
}
