package com.stepos.ability.task.executor;

import android.content.Context;
import com.stepos.ability.api.ability.calltool.ICallTool;
import com.stepos.ability.api.ability.permission.ISlaPermissionManager;
import com.stepos.ability.api.task.listener.ITaskListener;
import com.stepos.ability.commoninternal.ability.IAbilityManager;
import com.stepos.ability.report.IReportManager;
import y7.InterfaceC2137b;
import z4.C2169a;
import z4.C2172d;
import z4.C2175g;
import z4.m;

/* loaded from: classes3.dex */
public final class ToolTaskExecutor_Factory implements InterfaceC2137b {
    private final InterfaceC2137b abilityManagerProvider;
    private final InterfaceC2137b authCallbackInboxProvider;
    private final InterfaceC2137b authSessionStoreProvider;
    private final InterfaceC2137b callToolProvider;
    private final InterfaceC2137b contextProvider;
    private final InterfaceC2137b pendingPermissionAuthProvider;
    private final InterfaceC2137b permissionAuthCoordinatorProvider;
    private final InterfaceC2137b permissionAuthProcessorProvider;
    private final InterfaceC2137b reportManagerProvider;
    private final InterfaceC2137b slaPermissionMngProvider;
    private final InterfaceC2137b taskListenerProvider;

    private ToolTaskExecutor_Factory(InterfaceC2137b interfaceC2137b, InterfaceC2137b interfaceC2137b2, InterfaceC2137b interfaceC2137b3, InterfaceC2137b interfaceC2137b4, InterfaceC2137b interfaceC2137b5, InterfaceC2137b interfaceC2137b6, InterfaceC2137b interfaceC2137b7, InterfaceC2137b interfaceC2137b8, InterfaceC2137b interfaceC2137b9, InterfaceC2137b interfaceC2137b10, InterfaceC2137b interfaceC2137b11) {
        this.taskListenerProvider = interfaceC2137b;
        this.callToolProvider = interfaceC2137b2;
        this.abilityManagerProvider = interfaceC2137b3;
        this.reportManagerProvider = interfaceC2137b4;
        this.permissionAuthCoordinatorProvider = interfaceC2137b5;
        this.pendingPermissionAuthProvider = interfaceC2137b6;
        this.permissionAuthProcessorProvider = interfaceC2137b7;
        this.authSessionStoreProvider = interfaceC2137b8;
        this.authCallbackInboxProvider = interfaceC2137b9;
        this.slaPermissionMngProvider = interfaceC2137b10;
        this.contextProvider = interfaceC2137b11;
    }

    public static ToolTaskExecutor_Factory create(InterfaceC2137b interfaceC2137b, InterfaceC2137b interfaceC2137b2, InterfaceC2137b interfaceC2137b3, InterfaceC2137b interfaceC2137b4, InterfaceC2137b interfaceC2137b5, InterfaceC2137b interfaceC2137b6, InterfaceC2137b interfaceC2137b7, InterfaceC2137b interfaceC2137b8, InterfaceC2137b interfaceC2137b9, InterfaceC2137b interfaceC2137b10, InterfaceC2137b interfaceC2137b11) {
        return new ToolTaskExecutor_Factory(interfaceC2137b, interfaceC2137b2, interfaceC2137b3, interfaceC2137b4, interfaceC2137b5, interfaceC2137b6, interfaceC2137b7, interfaceC2137b8, interfaceC2137b9, interfaceC2137b10, interfaceC2137b11);
    }

    public static g newInstance(ITaskListener iTaskListener, ICallTool iCallTool, IAbilityManager iAbilityManager, IReportManager iReportManager, com.stepos.ability.task.executor.permissionauth.a aVar, C2175g c2175g, m mVar, C2172d c2172d, C2169a c2169a, ISlaPermissionManager iSlaPermissionManager) {
        return new g(iTaskListener, iCallTool, iAbilityManager, iReportManager, aVar, c2175g, mVar, c2172d, c2169a, iSlaPermissionManager);
    }

    @Override // javax.inject.Provider
    public g get() {
        g gVarNewInstance = newInstance((ITaskListener) this.taskListenerProvider.get(), (ICallTool) this.callToolProvider.get(), (IAbilityManager) this.abilityManagerProvider.get(), (IReportManager) this.reportManagerProvider.get(), (com.stepos.ability.task.executor.permissionauth.a) this.permissionAuthCoordinatorProvider.get(), (C2175g) this.pendingPermissionAuthProvider.get(), (m) this.permissionAuthProcessorProvider.get(), (C2172d) this.authSessionStoreProvider.get(), (C2169a) this.authCallbackInboxProvider.get(), (ISlaPermissionManager) this.slaPermissionMngProvider.get());
        ToolTaskExecutor_MembersInjector.injectContext(gVarNewInstance, (Context) this.contextProvider.get());
        return gVarNewInstance;
    }
}
