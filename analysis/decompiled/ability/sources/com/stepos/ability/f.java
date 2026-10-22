package com.stepos.ability;

import D7.q;
import android.content.Context;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.util.Log;
import com.stepos.ability.agentbusclient.AbilityCallExecutor;
import com.stepos.ability.agentbusclient.AbilityListExecutor;
import com.stepos.ability.agentbusclient.AgentBusClientInit;
import com.stepos.ability.api.ability.calltool.ICallTool;
import com.stepos.ability.api.ability.permission.ISlaPermissionManager;
import com.stepos.ability.api.ability.repository.IAtomicAbilityRepository;
import com.stepos.ability.api.agentbus.IAbilityCatalog;
import com.stepos.ability.api.task.executor.ITaskExecutor;
import com.stepos.ability.api.task.registry.ITaskRegistry;
import com.stepos.ability.application.App_Factory;
import com.stepos.ability.calltool.CallToolImpl;
import com.stepos.ability.commoninternal.ability.IAbilityManager;
import com.stepos.ability.manager.AbilityManager;
import com.stepos.ability.mcpserver.McpServerInit;
import com.stepos.ability.mcpserver.model.McpServerConfig;
import com.stepos.ability.mcpserver.security.KeyVerifier;
import com.stepos.ability.net.INet;
import com.stepos.ability.net.NetImpl;
import com.stepos.ability.permission.init.SlaPermissionInit;
import com.stepos.ability.report.IReportManager;
import com.stepos.ability.report.ReportManager;
import com.stepos.ability.runtime.RuntimeManager_Factory;
import com.stepos.ability.screenops.init.ScreenOpsInit;
import com.stepos.ability.task.executor.ToolTaskExecutor_Factory;
import com.stepos.ability.tracelogger.ITraceLogger;
import com.stepos.ability.tracelogger.TraceLogger;
import com.stepos.ability.voicewakeup.service.VoiceWakeupInit;
import com.stepos.taskrobot.app.init.TaskRobotInit;
import com.stepos.taskrobot.settingsprovider.init.SettingsProviderInit;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideContextFactory;
import f4.C1434a;
import f6.C1438c;
import h4.C1486a;
import i4.C1554b;
import j9.AbstractC1607a;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import k4.n;
import k4.r;
import k4.s;
import k4.w;
import k4.y;
import k4.z;
import y4.C2130a;
import y7.InterfaceC2137b;
import z4.C2169a;
import z4.C2172d;
import z4.C2175g;
import z4.m;

/* loaded from: classes3.dex */
public final class f implements InterfaceC2137b {

    /* renamed from: a, reason: collision with root package name */
    public final DaggerApp_HiltComponents_SingletonC$SingletonCImpl f3095a;
    public final int b;

    public f(DaggerApp_HiltComponents_SingletonC$SingletonCImpl daggerApp_HiltComponents_SingletonC$SingletonCImpl, int i) {
        this.f3095a = daggerApp_HiltComponents_SingletonC$SingletonCImpl;
        this.b = i;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        String str;
        Cipher cipher;
        SigningInfo signingInfo;
        Signature[] apkContentsSigners;
        Signature signature;
        DaggerApp_HiltComponents_SingletonC$SingletonCImpl daggerApp_HiltComponents_SingletonC$SingletonCImpl = this.f3095a;
        int i = this.b;
        switch (i) {
            case 0:
                return daggerApp_HiltComponents_SingletonC$SingletonCImpl.injectApp3(App_Factory.newInstance(ApplicationContextModule_ProvideContextFactory.provideContext(daggerApp_HiltComponents_SingletonC$SingletonCImpl.applicationContextModule), (T3.c) daggerApp_HiltComponents_SingletonC$SingletonCImpl.deviceIdManagerImplProvider.get()));
            case 1:
                return new T3.b(ApplicationContextModule_ProvideContextFactory.provideContext(daggerApp_HiltComponents_SingletonC$SingletonCImpl.applicationContextModule));
            case 2:
                return new McpServerInit((McpServerConfig) daggerApp_HiltComponents_SingletonC$SingletonCImpl.provideConfigProvider.get(), (com.stepos.ability.mcpserver.search.b) daggerApp_HiltComponents_SingletonC$SingletonCImpl.toolSearchEngineProvider.get(), (com.stepos.ability.mcpserver.describe.a) daggerApp_HiltComponents_SingletonC$SingletonCImpl.toolDescribeEngineProvider.get(), (com.stepos.ability.mcpserver.executor.b) daggerApp_HiltComponents_SingletonC$SingletonCImpl.mcpServerToolBridgeProvider.get(), (C1434a) daggerApp_HiltComponents_SingletonC$SingletonCImpl.provideDagSchedulerProvider.get(), (com.stepos.ability.mcpserver.executor.a) daggerApp_HiltComponents_SingletonC$SingletonCImpl.batchExecutorProvider.get(), (com.stepos.ability.mcpserver.endpoint.b) daggerApp_HiltComponents_SingletonC$SingletonCImpl.provideSessionManagerProvider.get(), (C1554b) daggerApp_HiltComponents_SingletonC$SingletonCImpl.mcpServerMonitorProvider.get(), (z) daggerApp_HiltComponents_SingletonC$SingletonCImpl.serverNonceProvider.get(), daggerApp_HiltComponents_SingletonC$SingletonCImpl.bearerAuthenticator(), (w) daggerApp_HiltComponents_SingletonC$SingletonCImpl.rateLimiterProvider.get(), (s) daggerApp_HiltComponents_SingletonC$SingletonCImpl.mcpPackageChangeReceiverProvider.get());
            case 3:
                return new McpServerConfig(null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0L, 0L, 0L, 0L, 0, 0, 0, 0, 0, 8388607, null);
            case 4:
                return new com.stepos.ability.mcpserver.search.b((IAtomicAbilityRepository) daggerApp_HiltComponents_SingletonC$SingletonCImpl.provideAtomicAbilityRepositoryProvider.get());
            case 5:
                Context context = ApplicationContextModule_ProvideContextFactory.provideContext(daggerApp_HiltComponents_SingletonC$SingletonCImpl.applicationContextModule);
                kotlin.jvm.internal.k.f(context, "context");
                return new com.stepos.ability.manager.cache.b(com.stepos.ability.manager.cache.a.e.x(context));
            case 6:
                return new com.stepos.ability.mcpserver.describe.a((IAbilityManager) daggerApp_HiltComponents_SingletonC$SingletonCImpl.abilityManagerProvider.get(), (IAtomicAbilityRepository) daggerApp_HiltComponents_SingletonC$SingletonCImpl.provideAtomicAbilityRepositoryProvider.get());
            case 7:
                return new AbilityManager((INet) daggerApp_HiltComponents_SingletonC$SingletonCImpl.netImplProvider.get(), (T3.c) daggerApp_HiltComponents_SingletonC$SingletonCImpl.deviceIdManagerImplProvider.get(), (H3.b) daggerApp_HiltComponents_SingletonC$SingletonCImpl.accountUtilProvider.get());
            case 8:
                return new NetImpl((T3.c) daggerApp_HiltComponents_SingletonC$SingletonCImpl.deviceIdManagerImplProvider.get(), (U3.b) daggerApp_HiltComponents_SingletonC$SingletonCImpl.envManagerProvider.get());
            case 9:
                return new U3.a(ApplicationContextModule_ProvideContextFactory.provideContext(daggerApp_HiltComponents_SingletonC$SingletonCImpl.applicationContextModule));
            case 10:
                return new H3.b(ApplicationContextModule_ProvideContextFactory.provideContext(daggerApp_HiltComponents_SingletonC$SingletonCImpl.applicationContextModule));
            case 11:
                return new com.stepos.ability.mcpserver.executor.b((ICallTool) daggerApp_HiltComponents_SingletonC$SingletonCImpl.callToolImplProvider.get(), (IAbilityManager) daggerApp_HiltComponents_SingletonC$SingletonCImpl.abilityManagerProvider.get());
            case 12:
                return new CallToolImpl((INet) daggerApp_HiltComponents_SingletonC$SingletonCImpl.netImplProvider.get(), (IReportManager) daggerApp_HiltComponents_SingletonC$SingletonCImpl.reportManagerProvider.get(), (ITraceLogger) daggerApp_HiltComponents_SingletonC$SingletonCImpl.traceLoggerProvider.get());
            case 13:
                return new ReportManager();
            case 14:
                return new TraceLogger(ApplicationContextModule_ProvideContextFactory.provideContext(daggerApp_HiltComponents_SingletonC$SingletonCImpl.applicationContextModule));
            case 15:
                McpServerConfig config = (McpServerConfig) daggerApp_HiltComponents_SingletonC$SingletonCImpl.provideConfigProvider.get();
                kotlin.jvm.internal.k.f(config, "config");
                return new C1434a(config);
            case 16:
                return new com.stepos.ability.mcpserver.executor.a((com.stepos.ability.mcpserver.executor.b) daggerApp_HiltComponents_SingletonC$SingletonCImpl.mcpServerToolBridgeProvider.get(), (McpServerConfig) daggerApp_HiltComponents_SingletonC$SingletonCImpl.provideConfigProvider.get());
            case 17:
                McpServerConfig config2 = (McpServerConfig) daggerApp_HiltComponents_SingletonC$SingletonCImpl.provideConfigProvider.get();
                kotlin.jvm.internal.k.f(config2, "config");
                return new com.stepos.ability.mcpserver.endpoint.b(config2);
            case 18:
                return new C1554b((McpServerConfig) daggerApp_HiltComponents_SingletonC$SingletonCImpl.provideConfigProvider.get());
            case 19:
                return new z();
            case 20:
                return com.stepos.ability.mcpserver.a.a((n) daggerApp_HiltComponents_SingletonC$SingletonCImpl.callerIdentityRegistryProvider.get(), (k4.d) daggerApp_HiltComponents_SingletonC$SingletonCImpl.appIdentityResolverProvider.get(), (KeyVerifier) daggerApp_HiltComponents_SingletonC$SingletonCImpl.provideKeyVerifierProvider.get());
            case 21:
                return new n((McpServerConfig) daggerApp_HiltComponents_SingletonC$SingletonCImpl.provideConfigProvider.get());
            case 22:
                return new k4.d(ApplicationContextModule_ProvideContextFactory.provideContext(daggerApp_HiltComponents_SingletonC$SingletonCImpl.applicationContextModule));
            case 23:
                McpServerConfig config3 = (McpServerConfig) daggerApp_HiltComponents_SingletonC$SingletonCImpl.provideConfigProvider.get();
                C1554b monitor = (C1554b) daggerApp_HiltComponents_SingletonC$SingletonCImpl.mcpServerMonitorProvider.get();
                U3.b envManager = (U3.b) daggerApp_HiltComponents_SingletonC$SingletonCImpl.envManagerProvider.get();
                H3.b accountUtil = (H3.b) daggerApp_HiltComponents_SingletonC$SingletonCImpl.accountUtilProvider.get();
                Context context2 = ApplicationContextModule_ProvideContextFactory.provideContext(daggerApp_HiltComponents_SingletonC$SingletonCImpl.applicationContextModule);
                kotlin.jvm.internal.k.f(config3, "config");
                kotlin.jvm.internal.k.f(monitor, "monitor");
                kotlin.jvm.internal.k.f(envManager, "envManager");
                kotlin.jvm.internal.k.f(accountUtil, "accountUtil");
                kotlin.jvm.internal.k.f(context2, "context");
                boolean z10 = envManager.a() instanceof V3.a;
                byte[] bArr = z10 ? r.f4812a : r.b;
                try {
                    cipher = Cipher.getInstance("AES/GCM/NoPadding");
                    signingInfo = context2.getPackageManager().getPackageInfo(context2.getPackageName(), 134217728).signingInfo;
                } catch (Throwable th) {
                    Log.e("McpGatewayParams", "decrypt gateway secret failed (repack or wrong signature?): " + th.getMessage());
                    str = "";
                }
                if (signingInfo == null || (apkContentsSigners = signingInfo.getApkContentsSigners()) == null || (signature = (Signature) q.n0(apkContentsSigners)) == null) {
                    throw new IllegalStateException("no signing certificate available");
                }
                byte[] bArrDigest = MessageDigest.getInstance("SHA-256").digest(signature.toByteArray());
                kotlin.jvm.internal.k.e(bArrDigest, "digest(...)");
                cipher.init(2, new SecretKeySpec(bArrDigest, "AES"), new GCMParameterSpec(128, bArr, 0, 12));
                byte[] bArrDoFinal = cipher.doFinal(bArr, 12, bArr.length - 12);
                kotlin.jvm.internal.k.e(bArrDoFinal, "doFinal(...)");
                str = new String(bArrDoFinal, AbstractC1607a.f4778a);
                return new com.stepos.ability.mcpserver.security.a(new y(z10 ? "https://test-otter-gateway-in.t-stepos.com/api/ide-ability/v1/verify" : "https://otter-gateway.stepaos.com/api/ide-ability/v1/verify", new A6.i(16, accountUtil, str)), config3.getKeyPositiveTtlMs(), config3.getKeyMaxStaleAgeMs(), new M0.k(config3), config3.getVerifyCacheMaxValid(), config3.getVerifyCacheMaxInvalid(), monitor);
            case 24:
                return new w((McpServerConfig) daggerApp_HiltComponents_SingletonC$SingletonCImpl.provideConfigProvider.get());
            case 25:
                return new s((n) daggerApp_HiltComponents_SingletonC$SingletonCImpl.callerIdentityRegistryProvider.get());
            case 26:
                return new AgentBusClientInit((AbilityCallExecutor) daggerApp_HiltComponents_SingletonC$SingletonCImpl.abilityCallExecutorProvider.get(), (AbilityListExecutor) daggerApp_HiltComponents_SingletonC$SingletonCImpl.abilityListExecutorProvider.get());
            case 27:
                return new AbilityCallExecutor(ApplicationContextModule_ProvideContextFactory.provideContext(daggerApp_HiltComponents_SingletonC$SingletonCImpl.applicationContextModule));
            case 28:
                return new AbilityListExecutor(ApplicationContextModule_ProvideContextFactory.provideContext(daggerApp_HiltComponents_SingletonC$SingletonCImpl.applicationContextModule), (IAbilityCatalog) daggerApp_HiltComponents_SingletonC$SingletonCImpl.abilityCatalogImplProvider.get());
            case 29:
                return new com.stepos.ability.manager.a(ApplicationContextModule_ProvideContextFactory.provideContext(daggerApp_HiltComponents_SingletonC$SingletonCImpl.applicationContextModule), (IAbilityManager) daggerApp_HiltComponents_SingletonC$SingletonCImpl.abilityManagerProvider.get());
            case 30:
                return new ScreenOpsInit();
            case 31:
                return new SettingsProviderInit();
            case 32:
                return new SlaPermissionInit((ISlaPermissionManager) daggerApp_HiltComponents_SingletonC$SingletonCImpl.slaPermissionManagerImplProvider.get(), (H3.b) daggerApp_HiltComponents_SingletonC$SingletonCImpl.accountUtilProvider.get());
            case 33:
                return new o4.d();
            case 34:
                return new TaskRobotInit((C1438c) daggerApp_HiltComponents_SingletonC$SingletonCImpl.taskRobotAccountUtilProvider.get());
            case 35:
                return new C1438c(ApplicationContextModule_ProvideContextFactory.provideContext(daggerApp_HiltComponents_SingletonC$SingletonCImpl.applicationContextModule));
            case 36:
                return new VoiceWakeupInit(ApplicationContextModule_ProvideContextFactory.provideContext(daggerApp_HiltComponents_SingletonC$SingletonCImpl.applicationContextModule));
            case 37:
                return new C1486a((McpServerConfig) daggerApp_HiltComponents_SingletonC$SingletonCImpl.provideConfigProvider.get());
            case 38:
                return new com.stepos.ability.task.scheduler.a((ITaskExecutor) daggerApp_HiltComponents_SingletonC$SingletonCImpl.bindTaskExecutorProvider.get());
            case 39:
                return new com.stepos.ability.task.executor.f((com.stepos.ability.api.task.listener.ITaskListener) daggerApp_HiltComponents_SingletonC$SingletonCImpl.bindTaskListenerProvider.get(), daggerApp_HiltComponents_SingletonC$SingletonCImpl.mapOfIntegerAndITaskExecutor());
            case 40:
                return new A4.a((ITaskRegistry) daggerApp_HiltComponents_SingletonC$SingletonCImpl.taskRegistryProvider.get());
            case 41:
                return new B4.b();
            case 42:
                return daggerApp_HiltComponents_SingletonC$SingletonCImpl.injectToolTaskExecutor(ToolTaskExecutor_Factory.newInstance((com.stepos.ability.api.task.listener.ITaskListener) daggerApp_HiltComponents_SingletonC$SingletonCImpl.bindTaskListenerProvider.get(), (ICallTool) daggerApp_HiltComponents_SingletonC$SingletonCImpl.callToolImplProvider.get(), (IAbilityManager) daggerApp_HiltComponents_SingletonC$SingletonCImpl.abilityManagerProvider.get(), (IReportManager) daggerApp_HiltComponents_SingletonC$SingletonCImpl.reportManagerProvider.get(), (com.stepos.ability.task.executor.permissionauth.a) daggerApp_HiltComponents_SingletonC$SingletonCImpl.permissionAuthCoordinatorProvider.get(), (C2175g) daggerApp_HiltComponents_SingletonC$SingletonCImpl.pendingPermissionAuthProvider.get(), (m) daggerApp_HiltComponents_SingletonC$SingletonCImpl.permissionAuthProcessorProvider.get(), (C2172d) daggerApp_HiltComponents_SingletonC$SingletonCImpl.authSessionStoreProvider.get(), (C2169a) daggerApp_HiltComponents_SingletonC$SingletonCImpl.authCallbackInboxProvider.get(), (ISlaPermissionManager) daggerApp_HiltComponents_SingletonC$SingletonCImpl.slaPermissionManagerImplProvider.get()));
            case 43:
                return new com.stepos.ability.task.executor.permissionauth.a((C2175g) daggerApp_HiltComponents_SingletonC$SingletonCImpl.pendingPermissionAuthProvider.get());
            case 44:
                return new C2175g();
            case 45:
                return new m();
            case 46:
                return new C2172d();
            case 47:
                return new C2169a();
            case 48:
                return new com.stepos.ability.task.executor.d((com.stepos.ability.api.task.listener.ITaskListener) daggerApp_HiltComponents_SingletonC$SingletonCImpl.bindTaskListenerProvider.get(), (IReportManager) daggerApp_HiltComponents_SingletonC$SingletonCImpl.reportManagerProvider.get());
            case 49:
                return daggerApp_HiltComponents_SingletonC$SingletonCImpl.injectRuntimeManager(RuntimeManager_Factory.newInstance());
            case 50:
                return new com.stepos.ability.monitor.a();
            case 51:
                return new C2130a();
            default:
                throw new AssertionError(i);
        }
    }
}
