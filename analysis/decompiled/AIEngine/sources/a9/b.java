package a9;

import android.os.Build;
import android.os.SystemClock;
import b7.k;
import com.stepos.aicgroup.AiDispatchers;
import com.stepos.aicgroup.AiDispatchersManager;
import com.stepos.aicgroup.internal.strategy.NativeCGroupStrategy;
import com.stepos.aiengine.AIEngineApplication;
import com.stepos.aiengine.modelmanager.ModelManagerActivity;
import com.stepos.base.concurrency.data.PoolType;
import com.stepos.base.model.InferenceConfig;
import com.stepos.core.ability.AbilityManager;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.net.NetWorkManager;
import com.stepos.core.common.notification.ModelDownloadNotificationRegistry;
import com.stepos.core.common.notification.NotificationDismissStore;
import com.stepos.core.common.ota.FrameworkStringBuilder;
import com.stepos.core.common.telemetry.CpuPerCoreSampler;
import com.stepos.core.model.concurrency.ThreadPoolManagerImpl;
import com.stepos.core.ota.crypto.AtRestDecryptorBootstrap;
import com.stepos.core.ota.crypto.OtaAtRestDecryptor;
import com.stepos.core.ota.display.ModelDisplayResourceStore;
import com.stepos.core.ota.monitor.ActiveDownloadConditionMonitor;
import com.stepos.core.ota.process.PendingActivationStore;
import com.stepos.core.ota.push.ModelAutoUpdateManager;
import com.stepos.core.ota.push.ModelUpdateConditionManager;
import com.stepos.core.ota.push.PendingAutoUpdateStore;
import com.stepos.core.ota.storage.OtaFailureMarker;
import com.stepos.core.ota.storage.OtaTaskSnapshotStore;
import com.stepos.core.ota.storage.SilentInstallFailureStore;
import com.stepos.cpuset.NeoDispatchers;
import com.stepos.deepbinder.core.exception.ErrorCodes;
import f6.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.EmptyList;
import mb.m;
import mb.q;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements zb.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f70a;

    public /* synthetic */ b(int i10) {
        this.f70a = i10;
    }

    @Override // zb.a
    public final Object invoke() {
        int i10 = 0;
        z = false;
        boolean z = false;
        switch (this.f70a) {
            case 0:
                return Build.HARDWARE;
            case 1:
                int i11 = AIEngineApplication.f5748d;
                List<p6.a> allAbilityConfigs = AbilityManager.INSTANCE.getAllAbilityConfigs();
                ArrayList arrayList = new ArrayList();
                Iterator<T> it = allAbilityConfigs.iterator();
                while (it.hasNext()) {
                    q.g0(arrayList, ((p6.a) it.next()).f11419d);
                }
                ArrayList arrayList2 = new ArrayList(m.Z(arrayList, 10));
                int size = arrayList.size();
                while (i10 < size) {
                    Object obj = arrayList.get(i10);
                    i10++;
                    arrayList2.add(new InferenceConfig.a(((k) obj).f3096g.f6263a));
                }
                return FrameworkStringBuilder.INSTANCE.build(kotlin.collections.a.R0(arrayList2));
            case 2:
                int i12 = AIEngineApplication.f5748d;
                boolean z3 = ModelManagerActivity.f5846t;
                return Boolean.valueOf(ModelManagerActivity.f5846t);
            case 3:
                int i13 = AIEngineApplication.f5748d;
                ThreadPoolManagerImpl threadPoolManagerImplLatestInstanceOrNull = ThreadPoolManagerImpl.Companion.latestInstanceOrNull();
                if (threadPoolManagerImplLatestInstanceOrNull != null && threadPoolManagerImplLatestInstanceOrNull.getInflightCount(PoolType.f6216d) + threadPoolManagerImplLatestInstanceOrNull.getInflightCount(PoolType.f6215c) > 0) {
                    z = true;
                }
                return Boolean.valueOf(z);
            case 4:
                int i14 = AIEngineApplication.f5748d;
                return Integer.valueOf(c.a(true));
            case 5:
                int i15 = AIEngineApplication.f5748d;
                return Integer.valueOf(c.a(true));
            case 6:
                AiDispatchers aiDispatchers = AiDispatchers.INSTANCE;
                AiDispatchers.DispatcherPriority dispatcherPriority = AiDispatchers.DispatcherPriority.REALTIME;
                aiDispatchers.getClass();
                return AiDispatchers.a(2, "AI-Realtime", "Realtime", dispatcherPriority);
            case 7:
                AiDispatchers aiDispatchers2 = AiDispatchers.INSTANCE;
                AiDispatchers.DispatcherPriority dispatcherPriority2 = AiDispatchers.DispatcherPriority.NORMAL;
                aiDispatchers2.getClass();
                return AiDispatchers.a(3, "AI-Normal", "Normal", dispatcherPriority2);
            case 8:
                AiDispatchers aiDispatchers3 = AiDispatchers.INSTANCE;
                return new NativeCGroupStrategy();
            case 9:
                return m.b0(AiDispatchersManager.f5613a, AiDispatchersManager.f5614b, AiDispatchersManager.f5615c, AiDispatchersManager.f5616d, AiDispatchersManager.f5617e, AiDispatchersManager.f5618f);
            case 10:
                return AIEngineLogger.logBuffer_delegate$lambda$0();
            case 11:
                return NetWorkManager.base_delegate$lambda$1();
            case 12:
                return ModelDownloadNotificationRegistry.kv_delegate$lambda$0();
            case 13:
                return NotificationDismissStore.kv_delegate$lambda$0();
            case 14:
                return CpuPerCoreSampler.cachedCoreClasses_delegate$lambda$1();
            case 15:
                return Long.valueOf(SystemClock.elapsedRealtime());
            case 16:
                return EmptyList.f10001a;
            case 17:
                return Boolean.valueOf(AtRestDecryptorBootstrap.install$lambda$3$lambda$1());
            case 18:
                return Boolean.valueOf(OtaAtRestDecryptor._init_$lambda$0());
            case 19:
                return ModelDisplayResourceStore.client_delegate$lambda$0();
            case 20:
                return ActiveDownloadConditionMonitor.startListeners$lambda$5();
            case 21:
                return Boolean.valueOf(ActiveDownloadConditionMonitor.managerForeground$lambda$0());
            case 22:
                return PendingActivationStore.kv_delegate$lambda$0();
            case 23:
                return ModelAutoUpdateManager.start$lambda$0();
            case ErrorCodes.GET_INSTANCE_METHOD_INVOCATION_ERROR /* 24 */:
                return ModelUpdateConditionManager.start$lambda$1();
            case 25:
                return PendingAutoUpdateStore.kv_delegate$lambda$0();
            case 26:
                return OtaFailureMarker.kv_delegate$lambda$0();
            case 27:
                return Integer.valueOf(OtaTaskSnapshotStore.pausedOrdinal_delegate$lambda$1());
            case ErrorCodes.GET_CONTENT_URI_ERROR /* 28 */:
                return SilentInstallFailureStore.kv_delegate$lambda$0();
            default:
                return NeoDispatchers.CPU.POWER_LOWEST_delegate$lambda$1();
        }
    }
}
