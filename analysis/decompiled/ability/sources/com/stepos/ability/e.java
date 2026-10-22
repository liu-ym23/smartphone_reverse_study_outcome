package com.stepos.ability;

import android.app.Service;
import com.stepos.ability.App_HiltComponents$ServiceC;
import com.stepos.ability.api.ability.calltool.ICallTool;
import com.stepos.ability.api.ability.monitor.IMonitor;
import com.stepos.ability.api.ability.permission.ISlaPermissionManager;
import com.stepos.ability.api.ability.runtime.IRuntimeManager;
import com.stepos.ability.api.ability.security.ISecurityManager;
import com.stepos.ability.api.task.executor.ITaskExecutor;
import com.stepos.ability.api.task.registry.ITaskRegistry;
import com.stepos.ability.api.task.schduler.ITaskScheduler;
import com.stepos.ability.commoninternal.ability.IAbilityManager;
import com.stepos.ability.service.AgentService;
import com.stepos.ability.service.AgentService_MembersInjector;
import com.stepos.ability.tracelogger.ITraceLogger;
import dagger.hilt.android.components.ServiceComponent;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;

/* loaded from: classes3.dex */
public final class e implements App_HiltComponents$ServiceC.Builder {

    /* renamed from: a, reason: collision with root package name */
    public final DaggerApp_HiltComponents_SingletonC$SingletonCImpl f3094a;
    public Service b;

    public e(DaggerApp_HiltComponents_SingletonC$SingletonCImpl daggerApp_HiltComponents_SingletonC$SingletonCImpl) {
        this.f3094a = daggerApp_HiltComponents_SingletonC$SingletonCImpl;
    }

    @Override // dagger.hilt.android.internal.builders.ServiceComponentBuilder
    public final ServiceComponent build() {
        com.stepos.ability.task.executor.e.r(Service.class, this.b);
        final DaggerApp_HiltComponents_SingletonC$SingletonCImpl daggerApp_HiltComponents_SingletonC$SingletonCImpl = this.f3094a;
        final Service service = this.b;
        return new App_HiltComponents$ServiceC(daggerApp_HiltComponents_SingletonC$SingletonCImpl, service) { // from class: com.stepos.ability.DaggerApp_HiltComponents_SingletonC$ServiceCImpl
            private final DaggerApp_HiltComponents_SingletonC$ServiceCImpl serviceCImpl = this;
            private final DaggerApp_HiltComponents_SingletonC$SingletonCImpl singletonCImpl;

            {
                this.singletonCImpl = daggerApp_HiltComponents_SingletonC$SingletonCImpl;
            }

            private AgentService injectAgentService2(AgentService agentService) {
                AgentService_MembersInjector.injectTaskScheduler(agentService, (ITaskScheduler) this.singletonCImpl.taskSchedulerProvider.get());
                AgentService_MembersInjector.injectTaskExecutor(agentService, (ITaskExecutor) this.singletonCImpl.bindTaskExecutorProvider.get());
                AgentService_MembersInjector.injectTaskRegistry(agentService, (ITaskRegistry) this.singletonCImpl.taskRegistryProvider.get());
                AgentService_MembersInjector.injectTaskListener(agentService, (com.stepos.ability.api.task.listener.ITaskListener) this.singletonCImpl.bindTaskListenerProvider.get());
                AgentService_MembersInjector.injectAbilityMng(agentService, (IAbilityManager) this.singletonCImpl.abilityManagerProvider.get());
                AgentService_MembersInjector.injectRuntimeMng(agentService, (IRuntimeManager) this.singletonCImpl.getRuntimeManagerProvider.get());
                AgentService_MembersInjector.injectSecurityMng(agentService, (ISecurityManager) this.singletonCImpl.getRuntimeManagerProvider2.get());
                AgentService_MembersInjector.injectSlaPermissionMng(agentService, (ISlaPermissionManager) this.singletonCImpl.slaPermissionManagerImplProvider.get());
                AgentService_MembersInjector.injectCallTool(agentService, (ICallTool) this.singletonCImpl.callToolImplProvider.get());
                AgentService_MembersInjector.injectMonitor(agentService, (IMonitor) this.singletonCImpl.getMonitorProvider.get());
                AgentService_MembersInjector.injectTraceLogger(agentService, (ITraceLogger) this.singletonCImpl.traceLoggerProvider.get());
                return agentService;
            }

            @Override // com.stepos.ability.service.AgentService_GeneratedInjector
            public void injectAgentService(AgentService agentService) {
                injectAgentService2(agentService);
            }
        };
    }

    @Override // dagger.hilt.android.internal.builders.ServiceComponentBuilder
    public final ServiceComponentBuilder service(Service service) {
        service.getClass();
        this.b = service;
        return this;
    }
}
