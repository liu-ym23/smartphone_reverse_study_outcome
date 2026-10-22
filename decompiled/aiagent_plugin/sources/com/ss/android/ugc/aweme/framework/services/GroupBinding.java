package com.ss.android.ugc.aweme.framework.services;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class GroupBinding<T> {
    Map<Class<?>, Map<String, ServiceProvider<?>>> classProviderMaps;
    String groupName;
    Class<T> klass;
    ServiceProvider<T> serviceProvider;

    GroupBinding(Map<Class<?>, Map<String, ServiceProvider<?>>> r3, Class<T> r4, String r5, ServiceProvider<T> r6) {
        Map<Class<?>, Map<String, ServiceProvider<?>>> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        ServiceProvider<T> r8 = (ServiceProvider) ZeusTransformUtils.wrapperContextForParams(r6, ServiceProvider.class, "com.obric.aiagent.plugin");
        this.classProviderMaps = r7;
        this.groupName = r5;
        this.klass = r4;
        this.serviceProvider = r8;
        Map<String, ServiceProvider<?>> r9 = (Map) ZeusTransformUtils.preCheckCast(r7.get(r4), Map.class, "com.obric.aiagent.plugin");
        if (r9 != null) goto L5;
        r9 = Collections.synchronizedMap(new HashMap());
        this.classProviderMaps.put(r4, r9);
    L5:
        r9.put(r5, r8);
    }

    public GroupBinding<T> asSingleton() {
        if (ZeusTransformUtils.instanceOf(this.serviceProvider, SingletonProvider.class) == true) goto L5;
        Map r0 = (Map) ZeusTransformUtils.preCheckCast(this.classProviderMaps.get(this.klass), Map.class, "com.obric.aiagent.plugin");
        r0.remove(this.serviceProvider);
        SingletonProvider r1 = new SingletonProvider(this.serviceProvider);
        this.serviceProvider = r1;
        r0.put(this.groupName, r1);
    L5:
        return this;
    }
}
