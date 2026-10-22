package com.stepos.deepbinder.service.api;

import com.stepos.deepbinder.core.entity.ext.BlackAndWhiteConfig;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.g;
import mb.l;
import n9.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@f.a
/* loaded from: classes.dex */
public class BaseDynamicConfig {
    public static final a Companion = new a();
    private static final ConcurrentHashMap<String, ConcurrentHashMap<String, BlackAndWhiteConfig>> methodBlackWhiteConfigMap = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, BlackAndWhiteConfig> serviceBlackWhiteConfigMap = new ConcurrentHashMap<>();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {
    }

    public final void clearAllMethodBlackWhiteConfigs() {
        methodBlackWhiteConfigMap.remove(getClass().getName());
    }

    public final void clearServiceBlackWhiteConfig() {
        ConcurrentHashMap<String, BlackAndWhiteConfig> concurrentHashMap = serviceBlackWhiteConfigMap;
        concurrentHashMap.remove(getClass().getName());
        if (concurrentHashMap.isEmpty()) {
            concurrentHashMap.clear();
        }
    }

    public final BlackAndWhiteConfig getMethodBlackWhiteConfig(String serviceName, String methodId) {
        g.f(serviceName, "serviceName");
        g.f(methodId, "methodId");
        ConcurrentHashMap<String, BlackAndWhiteConfig> concurrentHashMap = methodBlackWhiteConfigMap.get(serviceName);
        if (concurrentHashMap != null) {
            return concurrentHashMap.get(methodId);
        }
        return null;
    }

    public final BlackAndWhiteConfig getServiceBlackWhiteConfig(String serviceName) {
        g.f(serviceName, "serviceName");
        return serviceBlackWhiteConfigMap.get(serviceName);
    }

    public final void notifyMethodBlackWhiteConfigUpdate(Method method, BlackAndWhiteConfig config) {
        ConcurrentHashMap<String, BlackAndWhiteConfig> concurrentHashMapPutIfAbsent;
        g.f(method, "method");
        g.f(config, "config");
        if (getClass().isAssignableFrom(method.getDeclaringClass())) {
            ConcurrentHashMap<String, ConcurrentHashMap<String, BlackAndWhiteConfig>> concurrentHashMap = methodBlackWhiteConfigMap;
            String name = getClass().getName();
            ConcurrentHashMap<String, BlackAndWhiteConfig> concurrentHashMap2 = concurrentHashMap.get(name);
            if (concurrentHashMap2 == null && (concurrentHashMapPutIfAbsent = concurrentHashMap.putIfAbsent(name, (concurrentHashMap2 = new ConcurrentHashMap<>()))) != null) {
                concurrentHashMap2 = concurrentHashMapPutIfAbsent;
            }
            String name2 = method.getName();
            Class<?>[] parameterTypes = method.getParameterTypes();
            g.e(parameterTypes, "getParameterTypes(...)");
            concurrentHashMap2.put(name2 + "(" + l.j0(parameterTypes, new d(4), 30) + ")", config);
        }
    }

    public final void notifyServiceBlackWhiteConfigUpdate(BlackAndWhiteConfig config) {
        g.f(config, "config");
        serviceBlackWhiteConfigMap.put(getClass().getName(), config);
    }

    public final void removeMethodBlackWhiteConfig(Method method) {
        g.f(method, "method");
        ConcurrentHashMap<String, ConcurrentHashMap<String, BlackAndWhiteConfig>> concurrentHashMap = methodBlackWhiteConfigMap;
        ConcurrentHashMap<String, BlackAndWhiteConfig> concurrentHashMap2 = concurrentHashMap.get(getClass().getName());
        if (concurrentHashMap2 != null) {
            String name = method.getName();
            Class<?>[] parameterTypes = method.getParameterTypes();
            g.e(parameterTypes, "getParameterTypes(...)");
            concurrentHashMap2.remove(name + "(" + l.j0(parameterTypes, new d(4), 30) + ")");
        }
        if (concurrentHashMap2 == null || !concurrentHashMap2.isEmpty()) {
            return;
        }
        concurrentHashMap.remove(getClass().getName());
    }
}
