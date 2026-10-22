package com.ss.android.ugc.aweme.framework.services;

import android.text.TextUtils;
import com.google.protobuf.SmallSortedMap;
import com.ss.android.ugc.aweme.framework.services.plugin.PluginInstaller;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
public final class ServiceManager {
    final ConcurrentHashMap<Class<?>, Set<ServiceProvider<?>>> classServiceProviderConcurrentHashMap;
    public volatile boolean enableDynamicProxyDefault;
    final Map<Class<?>, Map<String, ServiceProvider<?>>> groupServiceProviderConcurrentHashMap;
    final Set<String> legacyServiceSet;
    final Set<Class<?>> resolvedClasses;

    /* JADX INFO: renamed from: com.ss.android.ugc.aweme.framework.services.ServiceManager$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class Holder {
        private static final ServiceManager INSTANCE = null;

        private Holder() {
        }

        static /* synthetic */ ServiceManager access$000() {
            return INSTANCE;
        }

        static {
            INSTANCE = new ServiceManager(null);
        }
    }

    /* synthetic */ ServiceManager(AnonymousClass1 r1) {
        this();
    }

    public void setDynamicProxyEnableDefault(boolean r1) {
        this.enableDynamicProxyDefault = r1;
    }

    public void addLegacyService(Set<String> r3) {
        Set r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin");
        this.legacyServiceSet.addAll(r4);
    }

    public void addLegacyService(String r1) {
        this.legacyServiceSet.add(r1);
    }

    public <T> T getService(Class<T> r2, boolean r3) {
        return (T) getService(r2, r3, this.enableDynamicProxyDefault);
    }

    public <T> T getService(Class<T> r2) {
        return (T) getService(r2, false);
    }

    public <T> T getService(Class<T> r2, boolean r3, boolean r4) {
        return (T) getService(r2, r3, r4, false);
    }

    public <T> T getServiceForReal(Class<T> r4) {
        return (T) getService(r4, false, this.enableDynamicProxyDefault, true);
    }

    public <T> T getService(Class<T> r8, boolean r9, boolean r10, boolean r11) {
        if (r11 == false) goto L5;
    L10:
        boolean r3 = false;
        T r2 = null;
    L11:
        Set r4 = (Set) ZeusTransformUtils.preCheckCast(this.classServiceProviderConcurrentHashMap.get(r8), Set.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L14;
    L19:
        if (r2 == null) goto L22;
        markResolved(r8);
        return r2;
    L22:
        T r12 = (T) StaticServiceImplManager.getInstance().getStaticServiceImpl(r8);
        if (r12 == null) goto L26;
        markResolved(r8);
        return r12;
    L26:
        if (r11 == false) goto L28;
        return null;
    L28:
        T r13 = (T) getLegacyService(r8);
        if (r13 == null) goto L32;
        markResolved(r8);
        return r13;
    L32:
        if (r3 == true) goto L34;
        r13 = (T) DowngradeImplManager.getInstance().getDowngradeImpl(r8);
    L34:
        if (r13 != null) goto L38;
        if (r10 == false) goto L39;
        new DynamicProxy();
        return (T) DynamicProxy.get(r8);
    L39:
        return r13;
    L38:
        return r13;
    L14:
        if (r4.isEmpty() == true) goto L19;
        if (r9 == true) goto L19;
        Object[] r14 = r4.toArray();
        if (r14.length <= 0) goto L19;
        r2 = (T) ((ServiceProvider) ZeusTransformUtils.preCheckCast(r14[0], ServiceProvider.class, "com.obric.aiagent.plugin")).get();
        goto L19
    L5:
        if (DowngradeImplManager.getInstance().isServiceForceDowngrade(r8) == false) goto L10;
        r2 = (T) DowngradeImplManager.getInstance().getDowngradeImpl(r8);
        if (r2 == null) goto L9;
        return r2;
    L9:
        r3 = true;
        goto L11
    }

    private void markResolved(Class r1) {
        this.resolvedClasses.add(r1);
    }

    public <T> void bindDowngradeImpl(Class<T> r3, ServiceProvider<T> r4) {
        bindDowngradeImpl(r3, (ServiceProvider) ZeusTransformUtils.wrapperContextForParams(r4, ServiceProvider.class, "com.obric.aiagent.plugin"), true);
    }

    public <T> void bindDowngradeImpl(Class<T> r2, ServiceProvider<T> r3, boolean r4) {
        ServiceProvider<T> r1 = (ServiceProvider) ZeusTransformUtils.wrapperContextForParams(r3, ServiceProvider.class, "com.obric.aiagent.plugin");
        if (r4 == false) goto L5;
        r1 = new SingletonProvider(r1);
    L5:
        DowngradeImplManager.getInstance().bindDowngradeImpl(r2, r1);
    }

    public boolean downgradeComponent(String r2) {
        return downgradeComponent(r2, false);
    }

    public boolean downgradeComponent(String r5, boolean r6) {
        if (r6 == true) goto L12;
        Map<String, String> r7 = DowngradeImplManager.getInstance().componentsMap;
        Iterator<String> r0 = r7.keySet().iterator();
    L5:
        if (r0.hasNext() == false) goto L12;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.aiagent.plugin");
        if (this.resolvedClasses.contains(r1) == false) goto L5;
        if (TextUtils.equals((CharSequence) ZeusTransformUtils.preCheckCast(r7.get(r1), CharSequence.class, "com.obric.aiagent.plugin"), r5) == false) goto L5;
        return false;
    L12:
        DowngradeImplManager.getInstance().downgradeComponent(r5);
        return true;
    }

    private <T> T getLegacyService(Class<T> r2) {
        if (this.legacyServiceSet.contains(r2.getName()) == true) goto L5;
        return null;
    L5:
        Iterator r1 = ConfigLoader.iterator(r2);
        if (r1.hasNext() == true) goto L8;
        return null;
    L8:
        return (T) r1.next();
    }

    public ConcurrentHashMap getServiceProviderMap() {
        return this.classServiceProviderConcurrentHashMap;
    }

    public Map<Class<?>, Map<String, ServiceProvider<?>>> getGroupServiceProviderMap() {
        return this.groupServiceProviderConcurrentHashMap;
    }

    public <T> Set<T> getServices(Class<T> r2) {
        return getServices(r2, false);
    }

    public <T> Set<T> getServices(Class<T> r7, boolean r8) {
        Set r0 = (Set) ZeusTransformUtils.preCheckCast(this.classServiceProviderConcurrentHashMap.get(r7), Set.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L17:
        Set<T> r9 = StaticServiceImplManager.getInstance().getStaticServiceImplSet(r7);
        if (r9 == null) goto L23;
        if (r9.isEmpty() == true) goto L23;
        return r9;
    L23:
        return getLegacyServices(r7);
    L5:
        if (r0.isEmpty() == true) goto L17;
        SmallSortedMap.DescendingEntrySet r6 = (Set<T>) Collections.synchronizedSet(new LinkedHashSet());
        Object[] r1 = r0.toArray();
        int r2 = r1.length;
        int r3 = 0;
    L8:
        if (r3 >= r2) goto L10;
        r6.add(((ServiceProvider) ZeusTransformUtils.preCheckCast(r1[r3], ServiceProvider.class, "com.obric.aiagent.plugin")).get());
        r3 = r3 + 1;
        goto L8
    L10:
        if (r8 == false) goto L16;
        Set<T> r10 = StaticServiceImplManager.getInstance().getStaticServiceImplSet(r7);
        if (r10 == null) goto L16;
        if (r10.isEmpty() == true) goto L16;
        r6.addAll(r10);
    L16:
        return r6;
    }

    public <T> Set<T> getLegacyServices(Class<T> r3) {
        SmallSortedMap.DescendingEntrySet r0 = (Set<T>) Collections.synchronizedSet(new LinkedHashSet());
        if (this.legacyServiceSet.contains(r3.getName()) == true) goto L5;
        return r0;
    L5:
        Iterator r2 = ConfigLoader.iterator(r3);
    L7:
        if (r2.hasNext() == false) goto L9;
        r0.add(r2.next());
        goto L7
    L9:
        return r0;
    }

    public boolean onPluginInstall(String r1) {
        return PluginInstaller.INSTANCE.onPluginInstall(r1);
    }

    public <T> Binding bind(Class<T> r3, ServiceProvider<T> r4) {
        return new Binding(this, r3, (ServiceProvider) ZeusTransformUtils.wrapperContextForParams(r4, ServiceProvider.class, "com.obric.aiagent.plugin"));
    }

    public <T> GroupBinding bind(Class<T> r3, String r4, ServiceProvider<T> r5) {
        ServiceProvider r6 = (ServiceProvider) ZeusTransformUtils.wrapperContextForParams(r5, ServiceProvider.class, "com.obric.aiagent.plugin");
        return new GroupBinding(this.groupServiceProviderConcurrentHashMap, r3, r4, r6);
    }

    public <T> T getServiceByGroup(Class<T> r2, String r3) {
        Map r1 = (Map) ZeusTransformUtils.preCheckCast(this.groupServiceProviderConcurrentHashMap.get(r2), Map.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L5;
        return null;
    L5:
        if (r1.containsKey(r3) == true) goto L8;
        return null;
    L8:
        return (T) ((ServiceProvider) ZeusTransformUtils.preCheckCast(r1.get(r3), ServiceProvider.class, "com.obric.aiagent.plugin")).get();
    }

    public static ServiceManager get() {
        return Holder.access$000();
    }

    private ServiceManager() {
        this.classServiceProviderConcurrentHashMap = new ConcurrentHashMap();
        this.groupServiceProviderConcurrentHashMap = Collections.synchronizedMap(new HashMap());
        this.legacyServiceSet = Collections.synchronizedSet(new HashSet());
        this.enableDynamicProxyDefault = true;
        this.resolvedClasses = Collections.synchronizedSet(new HashSet());
    }
}
