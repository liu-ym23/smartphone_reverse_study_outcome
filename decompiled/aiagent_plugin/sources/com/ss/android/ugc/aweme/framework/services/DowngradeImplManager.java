package com.ss.android.ugc.aweme.framework.services;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
public class DowngradeImplManager {
    final Map<String, String> componentsMap;
    final Set<String> downgradeComponents;
    private Map<String, ServiceProvider> downgradeImplMap;
    private Map<String, Object> staticDowngradeImplCache;
    final Set<String> staticDowngradeNotExistSet;

    private static class SingleInstanceHolder {
        private static final DowngradeImplManager INSTANCE = null;

        private SingleInstanceHolder() {
        }

        static /* synthetic */ DowngradeImplManager access$000() {
            return INSTANCE;
        }

        static {
            INSTANCE = new DowngradeImplManager();
        }
    }

    public DowngradeImplManager() {
        this.downgradeImplMap = new ConcurrentHashMap();
        this.staticDowngradeImplCache = new ConcurrentHashMap();
        this.componentsMap = new ConcurrentHashMap();
        this.downgradeComponents = Collections.synchronizedSet(new HashSet());
        this.staticDowngradeNotExistSet = Collections.synchronizedSet(new HashSet());
    }

    private void addServiceComponent(String r1, String r2) {
        this.componentsMap.put(r1, r2);
    }

    public static DowngradeImplManager getInstance() {
        return SingleInstanceHolder.access$000();
    }

    public <T> T getDowngradeImpl(Class<T> r5) {
        String r0 = r5.getName();
        ServiceProvider r1 = (ServiceProvider) ZeusTransformUtils.preCheckCast(this.downgradeImplMap.get(r0), ServiceProvider.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L5;
        T r2 = (T) this.staticDowngradeImplCache.get(r0);
        if (r2 == null) goto L9;
    L12:
        return r2;
    L9:
        if (this.staticDowngradeNotExistSet.contains(r0) == true) goto L12;
        return (T) getStaticDowngradeImpl(r5);
    L5:
        return (T) r1.get();
    }

    private <T> T getStaticDowngradeImpl(Class<T> r1) {
        this.staticDowngradeNotExistSet.add(r1.getName());
        return null;
    }

    private void putStaticDowngradeImplCache(String r1, Object r2) {
        this.staticDowngradeImplCache.put(r1, r2);
    }

    public <T> void bindDowngradeImpl(Class<T> r3, ServiceProvider<T> r4) {
        ServiceProvider r5 = (ServiceProvider) ZeusTransformUtils.wrapperContextForParams(r4, ServiceProvider.class, "com.obric.aiagent.plugin");
        this.downgradeImplMap.put(r3.getName(), r5);
    }

    public void downgradeComponent(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        if (this.downgradeComponents.contains(r2) == true) goto L9;
        this.downgradeComponents.add(r2);
        return;
    }

    public boolean isServiceForceDowngrade(Class r3) {
        String r4 = (String) ZeusTransformUtils.preCheckCast(this.componentsMap.get(r3.getName()), String.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return false;
    L5:
        return this.downgradeComponents.contains(r4);
    }
}
