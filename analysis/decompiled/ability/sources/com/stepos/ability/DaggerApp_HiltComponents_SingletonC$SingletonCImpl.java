package com.stepos.ability;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.stepos.ability.api.ability.calltool.ICallTool;
import com.stepos.ability.api.ability.monitor.IMonitor;
import com.stepos.ability.api.application.IApp;
import com.stepos.ability.api.init.IInit;
import com.stepos.ability.api.task.executor.ITaskExecutor;
import com.stepos.ability.commoninternal.ability.IAbilityManager;
import com.stepos.ability.database.repository.RepositoryInit;
import com.stepos.ability.mcpserver.McpServerInit;
import com.stepos.ability.mcpserver.security.KeyValidator;
import com.stepos.ability.runtime.RuntimeManager_MembersInjector;
import com.stepos.ability.task.executor.ExecutorInit;
import com.stepos.ability.task.executor.ToolTaskExecutor_MembersInjector;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideContextFactory;
import h4.C1486a;
import i4.C1554b;
import java.util.Map;
import java.util.Set;
import k4.n;
import k4.z;
import y7.C2136a;
import y7.InterfaceC2137b;

/* loaded from: classes3.dex */
final class DaggerApp_HiltComponents_SingletonC$SingletonCImpl extends App_HiltComponents$SingletonC {
    InterfaceC2137b abilityCallExecutorProvider;
    InterfaceC2137b abilityCatalogImplProvider;
    InterfaceC2137b abilityListExecutorProvider;
    InterfaceC2137b abilityManagerProvider;
    InterfaceC2137b accountUtilProvider;
    InterfaceC2137b agentBusClientInitProvider;
    InterfaceC2137b appIdentityResolverProvider;
    InterfaceC2137b appProvider;
    private final ApplicationContextModule applicationContextModule;
    InterfaceC2137b authCallbackInboxProvider;
    InterfaceC2137b authSessionStoreProvider;
    InterfaceC2137b batchExecutorProvider;
    InterfaceC2137b bindAppProvider;
    InterfaceC2137b bindGuiTaskExecutorProvider;
    InterfaceC2137b bindTaskExecutorProvider;
    InterfaceC2137b bindTaskListenerProvider;
    InterfaceC2137b bindToolTaskExecutorProvider;
    InterfaceC2137b callToolImplProvider;
    InterfaceC2137b callerIdentityRegistryProvider;
    InterfaceC2137b deviceIdManagerImplProvider;
    InterfaceC2137b envManagerProvider;
    InterfaceC2137b getMonitorProvider;
    InterfaceC2137b getRuntimeManagerProvider;
    InterfaceC2137b getRuntimeManagerProvider2;
    InterfaceC2137b guiTaskExecutorProvider;
    InterfaceC2137b handshakeGateProvider;
    InterfaceC2137b mcpPackageChangeReceiverProvider;
    InterfaceC2137b mcpServerInitProvider;
    InterfaceC2137b mcpServerMonitorProvider;
    InterfaceC2137b mcpServerToolBridgeProvider;
    InterfaceC2137b monitorImplProvider;
    InterfaceC2137b netImplProvider;
    InterfaceC2137b pendingPermissionAuthProvider;
    InterfaceC2137b permissionAuthCoordinatorProvider;
    InterfaceC2137b permissionAuthProcessorProvider;
    InterfaceC2137b provideAtomicAbilityRepositoryProvider;
    InterfaceC2137b provideConfigProvider;
    InterfaceC2137b provideDagSchedulerProvider;
    InterfaceC2137b provideKeyValidatorProvider;
    InterfaceC2137b provideKeyVerifierProvider;
    InterfaceC2137b provideSessionManagerProvider;
    InterfaceC2137b rateLimiterProvider;
    InterfaceC2137b reportManagerProvider;
    InterfaceC2137b runtimeManagerProvider;
    InterfaceC2137b screenOpsInitProvider;
    InterfaceC2137b securityManagerImplProvider;
    InterfaceC2137b serverNonceProvider;
    InterfaceC2137b settingsProviderInitProvider;
    private final DaggerApp_HiltComponents_SingletonC$SingletonCImpl singletonCImpl = this;
    InterfaceC2137b slaPermissionInitProvider;
    InterfaceC2137b slaPermissionManagerImplProvider;
    InterfaceC2137b taskExecutorProvider;
    InterfaceC2137b taskListenerProvider;
    InterfaceC2137b taskRegistryProvider;
    InterfaceC2137b taskRobotAccountUtilProvider;
    InterfaceC2137b taskRobotInitProvider;
    InterfaceC2137b taskSchedulerProvider;
    InterfaceC2137b toolDescribeEngineProvider;
    InterfaceC2137b toolSearchEngineProvider;
    InterfaceC2137b toolTaskExecutorProvider;
    InterfaceC2137b traceLoggerProvider;
    InterfaceC2137b voiceWakeupInitProvider;

    public DaggerApp_HiltComponents_SingletonC$SingletonCImpl(ApplicationContextModule applicationContextModule) {
        this.applicationContextModule = applicationContextModule;
        initialize(applicationContextModule);
        initialize2(applicationContextModule);
        initialize3(applicationContextModule);
    }

    private void initialize(ApplicationContextModule applicationContextModule) {
        this.deviceIdManagerImplProvider = C2136a.a(new f(this.singletonCImpl, 1));
        this.provideConfigProvider = C2136a.a(new f(this.singletonCImpl, 3));
        this.provideAtomicAbilityRepositoryProvider = C2136a.a(new f(this.singletonCImpl, 5));
        this.toolSearchEngineProvider = C2136a.a(new f(this.singletonCImpl, 4));
        this.envManagerProvider = C2136a.a(new f(this.singletonCImpl, 9));
        this.netImplProvider = C2136a.a(new f(this.singletonCImpl, 8));
        this.accountUtilProvider = C2136a.a(new f(this.singletonCImpl, 10));
        this.abilityManagerProvider = C2136a.a(new f(this.singletonCImpl, 7));
        this.toolDescribeEngineProvider = C2136a.a(new f(this.singletonCImpl, 6));
        this.reportManagerProvider = C2136a.a(new f(this.singletonCImpl, 13));
        this.traceLoggerProvider = C2136a.a(new f(this.singletonCImpl, 14));
        this.callToolImplProvider = C2136a.a(new f(this.singletonCImpl, 12));
        this.mcpServerToolBridgeProvider = C2136a.a(new f(this.singletonCImpl, 11));
        this.provideDagSchedulerProvider = C2136a.a(new f(this.singletonCImpl, 15));
        this.batchExecutorProvider = C2136a.a(new f(this.singletonCImpl, 16));
        this.provideSessionManagerProvider = C2136a.a(new f(this.singletonCImpl, 17));
        this.mcpServerMonitorProvider = C2136a.a(new f(this.singletonCImpl, 18));
        this.serverNonceProvider = C2136a.a(new f(this.singletonCImpl, 19));
        this.callerIdentityRegistryProvider = C2136a.a(new f(this.singletonCImpl, 21));
        this.appIdentityResolverProvider = C2136a.a(new f(this.singletonCImpl, 22));
        this.provideKeyVerifierProvider = C2136a.a(new f(this.singletonCImpl, 23));
        this.provideKeyValidatorProvider = C2136a.a(new f(this.singletonCImpl, 20));
        this.rateLimiterProvider = C2136a.a(new f(this.singletonCImpl, 24));
        this.mcpPackageChangeReceiverProvider = C2136a.a(new f(this.singletonCImpl, 25));
        this.mcpServerInitProvider = C2136a.a(new f(this.singletonCImpl, 2));
    }

    private void initialize2(ApplicationContextModule applicationContextModule) {
        this.abilityCallExecutorProvider = C2136a.a(new f(this.singletonCImpl, 27));
        this.abilityCatalogImplProvider = C2136a.a(new f(this.singletonCImpl, 29));
        this.abilityListExecutorProvider = C2136a.a(new f(this.singletonCImpl, 28));
        this.agentBusClientInitProvider = C2136a.a(new f(this.singletonCImpl, 26));
        this.screenOpsInitProvider = C2136a.a(new f(this.singletonCImpl, 30));
        this.settingsProviderInitProvider = C2136a.a(new f(this.singletonCImpl, 31));
        this.slaPermissionManagerImplProvider = C2136a.a(new f(this.singletonCImpl, 33));
        this.slaPermissionInitProvider = C2136a.a(new f(this.singletonCImpl, 32));
        this.taskRobotAccountUtilProvider = C2136a.a(new f(this.singletonCImpl, 35));
        this.taskRobotInitProvider = C2136a.a(new f(this.singletonCImpl, 34));
        this.voiceWakeupInitProvider = C2136a.a(new f(this.singletonCImpl, 36));
        f fVar = new f(this.singletonCImpl, 0);
        this.appProvider = fVar;
        this.bindAppProvider = C2136a.a(fVar);
        this.handshakeGateProvider = C2136a.a(new f(this.singletonCImpl, 37));
        this.taskRegistryProvider = C2136a.a(new f(this.singletonCImpl, 41));
        f fVar2 = new f(this.singletonCImpl, 40);
        this.taskListenerProvider = fVar2;
        this.bindTaskListenerProvider = C2136a.a(fVar2);
        this.pendingPermissionAuthProvider = C2136a.a(new f(this.singletonCImpl, 44));
        this.permissionAuthCoordinatorProvider = C2136a.a(new f(this.singletonCImpl, 43));
        this.permissionAuthProcessorProvider = C2136a.a(new f(this.singletonCImpl, 45));
        this.authSessionStoreProvider = C2136a.a(new f(this.singletonCImpl, 46));
        this.authCallbackInboxProvider = C2136a.a(new f(this.singletonCImpl, 47));
        f fVar3 = new f(this.singletonCImpl, 42);
        this.toolTaskExecutorProvider = fVar3;
        this.bindToolTaskExecutorProvider = C2136a.a(fVar3);
        this.guiTaskExecutorProvider = new f(this.singletonCImpl, 48);
    }

    private void initialize3(ApplicationContextModule applicationContextModule) {
        this.bindGuiTaskExecutorProvider = C2136a.a(this.guiTaskExecutorProvider);
        f fVar = new f(this.singletonCImpl, 39);
        this.taskExecutorProvider = fVar;
        this.bindTaskExecutorProvider = C2136a.a(fVar);
        this.taskSchedulerProvider = C2136a.a(new f(this.singletonCImpl, 38));
        f fVar2 = new f(this.singletonCImpl, 50);
        this.monitorImplProvider = fVar2;
        this.getMonitorProvider = C2136a.a(fVar2);
        f fVar3 = new f(this.singletonCImpl, 49);
        this.runtimeManagerProvider = fVar3;
        this.getRuntimeManagerProvider = C2136a.a(fVar3);
        f fVar4 = new f(this.singletonCImpl, 51);
        this.securityManagerImplProvider = fVar4;
        this.getRuntimeManagerProvider2 = C2136a.a(fVar4);
    }

    private App injectApp2(App app) {
        App_MembersInjector.injectApp(app, (IApp) this.bindAppProvider.get());
        return app;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public K3.a injectApp3(K3.a aVar) {
        com.stepos.ability.application.App_MembersInjector.injectSet(aVar, setOfIInit());
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.stepos.ability.runtime.b injectRuntimeManager(com.stepos.ability.runtime.b bVar) {
        RuntimeManager_MembersInjector.injectCallTool(bVar, (ICallTool) this.callToolImplProvider.get());
        RuntimeManager_MembersInjector.injectMonitor(bVar, (IMonitor) this.getMonitorProvider.get());
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.stepos.ability.task.executor.g injectToolTaskExecutor(com.stepos.ability.task.executor.g gVar) {
        ToolTaskExecutor_MembersInjector.injectContext(gVar, ApplicationContextModule_ProvideContextFactory.provideContext(this.applicationContextModule));
        return gVar;
    }

    @Override // com.stepos.ability.service.invoke.AbilityInvokeEntryPoint
    public IAbilityManager abilityManager() {
        return (IAbilityManager) this.abilityManagerProvider.get();
    }

    public k4.h bearerAuthenticator() {
        return new k4.h((KeyValidator) this.provideKeyValidatorProvider.get());
    }

    public IInit bindInit() {
        McpServerInit init = (McpServerInit) this.mcpServerInitProvider.get();
        kotlin.jvm.internal.k.f(init, "init");
        return init;
    }

    @Override // com.stepos.ability.service.invoke.AbilityInvokeEntryPoint
    public ICallTool callTool() {
        return (ICallTool) this.callToolImplProvider.get();
    }

    @Override // dagger.hilt.android.flags.FragmentGetContextFix.FragmentGetContextFixEntryPoint
    public Set<Boolean> getDisableFragmentGetContextFix() {
        return ImmutableSet.n();
    }

    @Override // com.stepos.ability.mcpserver.handshake.McpHandshakeEntryPoint
    public C1486a handshakeGate() {
        return (C1486a) this.handshakeGateProvider.get();
    }

    @Override // com.stepos.ability.mcpserver.handshake.McpHandshakeEntryPoint
    public n identityRegistry() {
        return (n) this.callerIdentityRegistryProvider.get();
    }

    @Override // com.stepos.ability.mcpserver.handshake.McpHandshakeEntryPoint
    public k4.d identityResolver() {
        return (k4.d) this.appIdentityResolverProvider.get();
    }

    @Override // com.stepos.ability.App_GeneratedInjector
    public void injectApp(App app) {
        injectApp2(app);
    }

    public Map<Integer, ITaskExecutor> mapOfIntegerAndITaskExecutor() {
        return ImmutableMap.d((ITaskExecutor) this.bindToolTaskExecutorProvider.get(), (ITaskExecutor) this.bindGuiTaskExecutorProvider.get());
    }

    @Override // com.stepos.ability.mcpserver.handshake.McpHandshakeEntryPoint
    public C1554b monitor() {
        return (C1554b) this.mcpServerMonitorProvider.get();
    }

    @Override // dagger.hilt.android.internal.managers.ActivityRetainedComponentManager.ActivityRetainedComponentBuilderEntryPoint
    public ActivityRetainedComponentBuilder retainedComponentBuilder() {
        return new b(this.singletonCImpl);
    }

    @Override // com.stepos.ability.mcpserver.handshake.McpHandshakeEntryPoint
    public z serverNonce() {
        return (z) this.serverNonceProvider.get();
    }

    @Override // dagger.hilt.android.internal.managers.ServiceComponentManager.ServiceComponentBuilderEntryPoint
    public ServiceComponentBuilder serviceComponentBuilder() {
        return new e(this.singletonCImpl);
    }

    public Set<IInit> setOfIInit() {
        IInit iInitBindInit = bindInit();
        IInit iInit = (IInit) this.abilityManagerProvider.get();
        IInit iInit2 = (IInit) this.agentBusClientInitProvider.get();
        IInit iInit3 = (IInit) this.callToolImplProvider.get();
        ExecutorInit executorInit = new ExecutorInit();
        IInit iInit4 = (IInit) this.netImplProvider.get();
        IInit[] iInitArr = {(IInit) this.reportManagerProvider.get(), new RepositoryInit(), (IInit) this.screenOpsInitProvider.get(), (IInit) this.settingsProviderInitProvider.get(), (IInit) this.slaPermissionInitProvider.get(), (IInit) this.taskRobotInitProvider.get(), (IInit) this.voiceWakeupInitProvider.get()};
        int i = ImmutableSet.c;
        Object[] objArr = new Object[13];
        objArr[0] = iInitBindInit;
        objArr[1] = iInit;
        objArr[2] = iInit2;
        objArr[3] = iInit3;
        objArr[4] = executorInit;
        objArr[5] = iInit4;
        System.arraycopy(iInitArr, 0, objArr, 6, 7);
        return ImmutableSet.j(13, objArr);
    }
}
