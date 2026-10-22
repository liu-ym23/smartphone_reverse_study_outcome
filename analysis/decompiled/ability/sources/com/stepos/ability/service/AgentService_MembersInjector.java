package com.stepos.ability.service;

import com.stepos.ability.api.ability.calltool.ICallTool;
import com.stepos.ability.api.ability.monitor.IMonitor;
import com.stepos.ability.api.ability.permission.ISlaPermissionManager;
import com.stepos.ability.api.ability.runtime.IRuntimeManager;
import com.stepos.ability.api.ability.security.ISecurityManager;
import com.stepos.ability.api.task.executor.ITaskExecutor;
import com.stepos.ability.api.task.listener.ITaskListener;
import com.stepos.ability.api.task.registry.ITaskRegistry;
import com.stepos.ability.api.task.schduler.ITaskScheduler;
import com.stepos.ability.commoninternal.ability.IAbilityManager;
import com.stepos.ability.tracelogger.ITraceLogger;
import x7.InterfaceC2117a;
import y7.InterfaceC2137b;

/* loaded from: classes3.dex */
public final class AgentService_MembersInjector implements InterfaceC2117a {
    private final InterfaceC2137b abilityMngProvider;
    private final InterfaceC2137b callToolProvider;
    private final InterfaceC2137b monitorProvider;
    private final InterfaceC2137b runtimeMngProvider;
    private final InterfaceC2137b securityMngProvider;
    private final InterfaceC2137b slaPermissionMngProvider;
    private final InterfaceC2137b taskExecutorProvider;
    private final InterfaceC2137b taskListenerProvider;
    private final InterfaceC2137b taskRegistryProvider;
    private final InterfaceC2137b taskSchedulerProvider;
    private final InterfaceC2137b traceLoggerProvider;

    private AgentService_MembersInjector(InterfaceC2137b interfaceC2137b, InterfaceC2137b interfaceC2137b2, InterfaceC2137b interfaceC2137b3, InterfaceC2137b interfaceC2137b4, InterfaceC2137b interfaceC2137b5, InterfaceC2137b interfaceC2137b6, InterfaceC2137b interfaceC2137b7, InterfaceC2137b interfaceC2137b8, InterfaceC2137b interfaceC2137b9, InterfaceC2137b interfaceC2137b10, InterfaceC2137b interfaceC2137b11) {
        this.taskSchedulerProvider = interfaceC2137b;
        this.taskExecutorProvider = interfaceC2137b2;
        this.taskRegistryProvider = interfaceC2137b3;
        this.taskListenerProvider = interfaceC2137b4;
        this.abilityMngProvider = interfaceC2137b5;
        this.runtimeMngProvider = interfaceC2137b6;
        this.securityMngProvider = interfaceC2137b7;
        this.slaPermissionMngProvider = interfaceC2137b8;
        this.callToolProvider = interfaceC2137b9;
        this.monitorProvider = interfaceC2137b10;
        this.traceLoggerProvider = interfaceC2137b11;
    }

    public static InterfaceC2117a create(InterfaceC2137b interfaceC2137b, InterfaceC2137b interfaceC2137b2, InterfaceC2137b interfaceC2137b3, InterfaceC2137b interfaceC2137b4, InterfaceC2137b interfaceC2137b5, InterfaceC2137b interfaceC2137b6, InterfaceC2137b interfaceC2137b7, InterfaceC2137b interfaceC2137b8, InterfaceC2137b interfaceC2137b9, InterfaceC2137b interfaceC2137b10, InterfaceC2137b interfaceC2137b11) {
        return new AgentService_MembersInjector(interfaceC2137b, interfaceC2137b2, interfaceC2137b3, interfaceC2137b4, interfaceC2137b5, interfaceC2137b6, interfaceC2137b7, interfaceC2137b8, interfaceC2137b9, interfaceC2137b10, interfaceC2137b11);
    }

    public static void injectAbilityMng(AgentService agentService, IAbilityManager iAbilityManager) {
        agentService.abilityMng = iAbilityManager;
    }

    public static void injectCallTool(AgentService agentService, ICallTool iCallTool) {
        agentService.callTool = iCallTool;
    }

    public static void injectMonitor(AgentService agentService, IMonitor iMonitor) {
        agentService.monitor = iMonitor;
    }

    public static void injectRuntimeMng(AgentService agentService, IRuntimeManager iRuntimeManager) {
        agentService.runtimeMng = iRuntimeManager;
    }

    public static void injectSecurityMng(AgentService agentService, ISecurityManager iSecurityManager) {
        agentService.securityMng = iSecurityManager;
    }

    public static void injectSlaPermissionMng(AgentService agentService, ISlaPermissionManager iSlaPermissionManager) {
        agentService.slaPermissionMng = iSlaPermissionManager;
    }

    public static void injectTaskExecutor(AgentService agentService, ITaskExecutor iTaskExecutor) {
        agentService.taskExecutor = iTaskExecutor;
    }

    public static void injectTaskListener(AgentService agentService, ITaskListener iTaskListener) {
        agentService.taskListener = iTaskListener;
    }

    public static void injectTaskRegistry(AgentService agentService, ITaskRegistry iTaskRegistry) {
        agentService.taskRegistry = iTaskRegistry;
    }

    public static void injectTaskScheduler(AgentService agentService, ITaskScheduler iTaskScheduler) {
        agentService.taskScheduler = iTaskScheduler;
    }

    public static void injectTraceLogger(AgentService agentService, ITraceLogger iTraceLogger) {
        agentService.traceLogger = iTraceLogger;
    }

    public void injectMembers(AgentService agentService) {
        injectTaskScheduler(agentService, (ITaskScheduler) this.taskSchedulerProvider.get());
        injectTaskExecutor(agentService, (ITaskExecutor) this.taskExecutorProvider.get());
        injectTaskRegistry(agentService, (ITaskRegistry) this.taskRegistryProvider.get());
        injectTaskListener(agentService, (ITaskListener) this.taskListenerProvider.get());
        injectAbilityMng(agentService, (IAbilityManager) this.abilityMngProvider.get());
        injectRuntimeMng(agentService, (IRuntimeManager) this.runtimeMngProvider.get());
        injectSecurityMng(agentService, (ISecurityManager) this.securityMngProvider.get());
        injectSlaPermissionMng(agentService, (ISlaPermissionManager) this.slaPermissionMngProvider.get());
        injectCallTool(agentService, (ICallTool) this.callToolProvider.get());
        injectMonitor(agentService, (IMonitor) this.monitorProvider.get());
        injectTraceLogger(agentService, (ITraceLogger) this.traceLoggerProvider.get());
    }
}
