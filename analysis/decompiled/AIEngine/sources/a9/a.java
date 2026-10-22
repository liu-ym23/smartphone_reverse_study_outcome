package a9;

import com.stepos.aicgroup.AiDispatchers;
import com.stepos.aiengine.AIEngineApplication;
import com.stepos.core.ability.AbilityBinderImpl;
import com.stepos.core.ability.AbilityManager;
import com.stepos.core.ability.converter.AbilityInputConverter;
import com.stepos.core.common.cloud.CloudInferenceClient;
import com.stepos.core.common.log.SimpleDumpProvider;
import com.stepos.core.common.net.NetWorkManager;
import com.stepos.core.common.notification.NotificationCancelSuppressStore;
import com.stepos.core.common.runtime.EngineRuntimeConfig;
import com.stepos.core.common.telemetry.AiPowerEventBus;
import com.stepos.core.model.concurrency.ThreadPoolManagerImpl;
import com.stepos.core.model.device.DeviceCapability;
import com.stepos.core.ota.OtaContainer;
import com.stepos.core.ota.OtaEngine;
import com.stepos.core.ota.display.ModelDisplayResourceStore;
import com.stepos.core.ota.domain.OtaStore;
import com.stepos.core.ota.install.PreInstallModels;
import com.stepos.core.ota.process.OtaAbilityMappingCache;
import com.stepos.core.ota.push.AutoUpdateTunables;
import com.stepos.core.ota.push.NoNetworkPromptStore;
import com.stepos.core.ota.push.OtaPushSubscribeClient;
import com.stepos.core.ota.storage.ModelsVersionStore;
import com.stepos.core.ota.storage.OtaTaskSnapshotStore;
import com.stepos.core.ota.storage.RemoteManifestEpoch;
import com.stepos.core.ota.storage.UserUninstallStore;
import com.stepos.deepbinder.core.exception.ErrorCodes;
import f6.c;
import kotlin.collections.EmptyList;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements zb.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f69a;

    public /* synthetic */ a(int i10) {
        this.f69a = i10;
    }

    @Override // zb.a
    public final Object invoke() {
        switch (this.f69a) {
            case 0:
                return DeviceCapability.socModel_delegate$lambda$1();
            case 1:
                int i10 = AIEngineApplication.f5748d;
                return AbilityManager.INSTANCE.getAllAbilityConfigs();
            case 2:
                int i11 = AIEngineApplication.f5748d;
                return Integer.valueOf(c.a(false));
            case 3:
                int i12 = AIEngineApplication.f5748d;
                ThreadPoolManagerImpl threadPoolManagerImplLatestInstanceOrNull = ThreadPoolManagerImpl.Companion.latestInstanceOrNull();
                return Boolean.valueOf(threadPoolManagerImplLatestInstanceOrNull != null ? threadPoolManagerImplLatestInstanceOrNull.hasForegroundTaskInWindow(EngineRuntimeConfig.INSTANCE.getSnapshot().getFgTaskWindowMs()) : false);
            case 4:
                return n.f10413a;
            case 5:
                AiDispatchers aiDispatchers = AiDispatchers.INSTANCE;
                AiDispatchers.DispatcherPriority dispatcherPriority = AiDispatchers.DispatcherPriority.IMPORTANT;
                aiDispatchers.getClass();
                return AiDispatchers.a(3, "AI-Important", "Important", dispatcherPriority);
            case 6:
                AiDispatchers aiDispatchers2 = AiDispatchers.INSTANCE;
                AiDispatchers.DispatcherPriority dispatcherPriority2 = AiDispatchers.DispatcherPriority.BACKGROUND;
                aiDispatchers2.getClass();
                return AiDispatchers.a(2, "AI-Background", "Background", dispatcherPriority2);
            case 7:
                return AbilityBinderImpl.tierArbiter_delegate$lambda$57();
            case 8:
                return AbilityInputConverter.decodeFdWithBytes$lambda$3();
            case 9:
                return CloudInferenceClient.client_delegate$lambda$8();
            case 10:
                return SimpleDumpProvider._init_$lambda$0();
            case 11:
                return NetWorkManager.transport_delegate$lambda$2();
            case 12:
                return NotificationCancelSuppressStore.kv_delegate$lambda$0();
            case 13:
                return AiPowerEventBus.dispatcher_delegate$lambda$3();
            case 14:
                return Boolean.valueOf(OtaContainer.init$lambda$5());
            case 15:
                return OtaContainer.init$lambda$7();
            case 16:
                return EmptyList.f10001a;
            case 17:
                return OtaEngine.init$lambda$2();
            case 18:
                return OtaEngine.initInOtaProcess$lambda$8();
            case 19:
                return ModelDisplayResourceStore.warmExecutor_delegate$lambda$5();
            case 20:
                return OtaStore._init_$lambda$0();
            case 21:
                return PreInstallModels.presetSealer_delegate$lambda$1();
            case 22:
                return OtaAbilityMappingCache.kv_delegate$lambda$0();
            case 23:
                return AutoUpdateTunables.kv_delegate$lambda$0();
            case ErrorCodes.GET_INSTANCE_METHOD_INVOCATION_ERROR /* 24 */:
                return NoNetworkPromptStore.kv_delegate$lambda$0();
            case 25:
                return OtaPushSubscribeClient.httpClient_delegate$lambda$1();
            case 26:
                return ModelsVersionStore.kv_delegate$lambda$0();
            case 27:
                return OtaTaskSnapshotStore.kv_delegate$lambda$0();
            case ErrorCodes.GET_CONTENT_URI_ERROR /* 28 */:
                return RemoteManifestEpoch.kv_delegate$lambda$0();
            default:
                return UserUninstallStore.kv_delegate$lambda$0();
        }
    }
}
