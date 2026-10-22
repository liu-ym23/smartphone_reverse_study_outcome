package com.stepos.cpuset;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.lifecycle.j0;
import com.stepos.agentcache.sdk.api.AgentCacheSdk;
import com.stepos.aiengine.modelmanager.ModelManagerFragment;
import com.stepos.aiengine.modelmanager.OtaModelClient;
import com.stepos.aiengine.usagestats.WifiAutoUpdateSwitchTracker;
import com.stepos.base.ability.AbilityBase;
import com.stepos.core.common.loadguard.LoadJournal;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.common.runtime.EngineRuntimeConfig;
import com.stepos.core.common.storage.ModelPathStore;
import com.stepos.core.cta.CTAPermissionManager;
import com.stepos.core.model.ModelLifecycleImpl;
import com.stepos.core.ota.remote.RemoteModelsRepository;
import com.stepos.cpuset.NeoDispatchers;
import com.tencent.mmkv.MMKV;
import kotlin.Pair;
import kotlin.Result;
import kotlin.jvm.internal.g;
import kotlin.random.Random;
import lb.n;
import mb.v;
import uc.q;
import uc.s;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements zb.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7619a;

    public /* synthetic */ b(int i10) {
        this.f7619a = i10;
    }

    @Override // zb.a
    public final Object invoke() {
        Object objA;
        Object objA2;
        boolean z;
        switch (this.f7619a) {
            case 0:
                return NeoDispatchers.CPU.POWER_SAVE_delegate$lambda$0();
            case 1:
                return NeoDispatchers.IO.POWER_SAVE_delegate$lambda$0();
            case 2:
                Random.f10088a.getClass();
                return Integer.valueOf(Random.f10089b.e().nextInt(2147418112) + 65536);
            case 3:
                return Long.valueOf(SystemClock.elapsedRealtimeNanos());
            case 4:
                return Long.valueOf(EngineRuntimeConfig.INSTANCE.getSnapshot().getCameraCooldownMs());
            case 5:
                return RemoteModelsRepository.frameworkProvider$lambda$0();
            case 6:
                return MMKV.o("sandbox_state");
            case 7:
                j0 j0Var = OtaModelClient.f5878i;
                if (j0Var != null) {
                    return ((ModelManagerFragment) j0Var.f2277b).getActivity();
                }
                return null;
            case 8:
                try {
                    objA2 = MMKV.o("aiengine_preheat_guard");
                } catch (Throwable th) {
                    objA2 = kotlin.c.a(th);
                }
                if (objA2 instanceof Result.Failure) {
                    objA2 = null;
                }
                return (MMKV) objA2;
            case 9:
                try {
                    objA = MMKV.o("aiengine_preheat_guard");
                } catch (Throwable th2) {
                    objA = kotlin.c.a(th2);
                }
                Throwable thB = Result.b(objA);
                if (thB != null) {
                    AIEngineLogger.w(LogModule.SERVICE, "RestartLedger", "MMKV unavailable, ledger disabled: " + thB);
                }
                if (objA instanceof Result.Failure) {
                    objA = null;
                }
                return (MMKV) objA;
            case 10:
                return Long.valueOf(SystemClock.uptimeMillis());
            case 11:
                WifiAutoUpdateSwitchTracker.f5937a.getClass();
                boolean zIsWlanAutoUpgradeEnabled = CTAPermissionManager.INSTANCE.isWlanAutoUpgradeEnabled();
                synchronized (WifiAutoUpdateSwitchTracker.f5938b) {
                    if (WifiAutoUpdateSwitchTracker.f5939c != null) {
                        if (g.b(WifiAutoUpdateSwitchTracker.f5940d, Boolean.valueOf(zIsWlanAutoUpgradeEnabled))) {
                            z = false;
                        } else {
                            WifiAutoUpdateSwitchTracker.f5940d = Boolean.valueOf(zIsWlanAutoUpgradeEnabled);
                            z = true;
                        }
                        if (z) {
                            AIEngineLogger.i(LogModule.SYSTEM, "WifiAutoUpdateSwitchTracker", "wifi auto-update switch changed → " + zIsWlanAutoUpgradeEnabled);
                            n6.a.f10642a.getClass();
                            n6.a.a("model_auto_update_switch", v.b0(new Pair("switch_status", zIsWlanAutoUpgradeEnabled ? "on" : "off")));
                        }
                    }
                }
                return n.f10413a;
            case 12:
                return AbilityBase.protocolManager_delegate$lambda$0();
            case 13:
                return AbilityBase.modelCache_delegate$lambda$2();
            case 14:
                return LoadJournal.kv_delegate$lambda$2();
            case 15:
                return q.f13220b;
            case 16:
                return s.f13223b;
            case 17:
                return new Handler(Looper.getMainLooper());
            case 18:
                return ModelPathStore.kv_delegate$lambda$0();
            case 19:
                return AgentCacheSdk.init$lambda$0();
            case 20:
                return Boolean.valueOf(ModelLifecycleImpl.warmup$lambda$3());
            default:
                return Boolean.valueOf(ModelLifecycleImpl.init$lambda$2$lambda$1());
        }
    }
}
