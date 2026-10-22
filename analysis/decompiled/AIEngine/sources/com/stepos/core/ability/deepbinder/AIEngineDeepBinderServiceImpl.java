package com.stepos.core.ability.deepbinder;

import android.content.Context;
import android.os.Binder;
import android.util.Log;
import b7.k;
import com.stepos.core.ability.AbilityInfo;
import com.stepos.core.ability.AbilityManager;
import com.stepos.core.ability.security.PermissionGuard;
import com.stepos.core.ability.settings.EnhancedServiceLauncherKt;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.cta.CTADialogGate;
import com.stepos.core.deepbinder.IAIEngineDeepBinderService;
import com.stepos.core.deepbinder.ICTACallback;
import com.stepos.core.deepbinder.IModelChangeListener;
import com.stepos.core.model.device.DeviceCapability;
import com.stepos.deepbinder.core.api.IRecycle;
import f7.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import mb.m;
import p6.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AIEngineDeepBinderServiceImpl implements IAIEngineDeepBinderService, IRecycle {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "AIEngineDeepBinderSvcImpl";
    private static volatile Context appContext;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final Context getAppContext() {
            return AIEngineDeepBinderServiceImpl.appContext;
        }

        public final void onCTAStateChanged(int i10, boolean z) {
            CTADialogGate.dispatchResult$default(CTADialogGate.INSTANCE, i10, z, null, 4, null);
        }

        public final void setAppContext(Context context) {
            AIEngineDeepBinderServiceImpl.appContext = context;
        }

        private Companion() {
        }
    }

    @Override // com.stepos.core.deepbinder.IAIEngineDeepBinderService
    public boolean checkCloudEnable(String id2) {
        g.f(id2, "id");
        if (PermissionGuard.INSTANCE.checkQuery(Binder.getCallingUid(), Binder.getCallingPid())) {
            return AbilityManager.INSTANCE.isCloudEnabled(id2);
        }
        return false;
    }

    @Override // com.stepos.core.deepbinder.IAIEngineDeepBinderService
    public boolean checkEnable(String id2) {
        g.f(id2, "id");
        if (PermissionGuard.INSTANCE.checkQuery(Binder.getCallingUid(), Binder.getCallingPid())) {
            return AbilityManager.INSTANCE.isAbilityEnabled(id2);
        }
        return false;
    }

    @Override // com.stepos.core.deepbinder.IAIEngineDeepBinderService
    public Boolean checkModelReady(String id2) {
        g.f(id2, "id");
        if (PermissionGuard.INSTANCE.checkQuery(Binder.getCallingUid(), Binder.getCallingPid())) {
            return AbilityManager.INSTANCE.checkModelFilesExist(id2);
        }
        return null;
    }

    @Override // com.stepos.core.deepbinder.IAIEngineDeepBinderService
    public boolean containsAbility(String id2) {
        g.f(id2, "id");
        if (PermissionGuard.INSTANCE.checkQuery(Binder.getCallingUid(), Binder.getCallingPid())) {
            return AbilityManager.INSTANCE.containsAbility(id2);
        }
        return false;
    }

    @Override // com.stepos.core.deepbinder.IAIEngineDeepBinderService
    public List<AbilityInfo> getAbilities() {
        if (!PermissionGuard.INSTANCE.checkQuery(Binder.getCallingUid(), Binder.getCallingPid())) {
            return EmptyList.f10001a;
        }
        List<AbilityInfo> abilities = AbilityManager.INSTANCE.getAbilities();
        LogModule logModule = LogModule.ABILITY;
        int size = abilities.size();
        ArrayList arrayList = new ArrayList(m.Z(abilities, 10));
        Iterator<T> it = abilities.iterator();
        while (it.hasNext()) {
            arrayList.add(((AbilityInfo) it.next()).getId());
        }
        AIEngineLogger.i(logModule, TAG, "[v2] getAbilities: count=" + size + " ids=" + arrayList);
        return abilities;
    }

    @Override // com.stepos.core.deepbinder.IAIEngineDeepBinderService
    public String getAbilityProperty(String id2, String name) {
        g.f(id2, "id");
        g.f(name, "name");
        if (PermissionGuard.INSTANCE.checkQuery(Binder.getCallingUid(), Binder.getCallingPid())) {
            return AbilityManager.INSTANCE.getAbilityProperty(id2, name);
        }
        return null;
    }

    @Override // com.stepos.core.deepbinder.IAIEngineDeepBinderService
    public int getAbilityState(String id2) {
        g.f(id2, "id");
        if (!PermissionGuard.INSTANCE.checkQuery(Binder.getCallingUid(), Binder.getCallingPid())) {
            return -2;
        }
        AbilityManager abilityManager = AbilityManager.INSTANCE;
        if (!abilityManager.containsAbility(id2)) {
            return -2;
        }
        Boolean boolCheckModelFilesExist = abilityManager.checkModelFilesExist(id2);
        if (g.b(boolCheckModelFilesExist, Boolean.TRUE)) {
            return 1;
        }
        if (g.b(boolCheckModelFilesExist, Boolean.FALSE)) {
            return 0;
        }
        if (boolCheckModelFilesExist == null) {
            return -2;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.stepos.core.deepbinder.IAIEngineDeepBinderService
    public boolean isDeviceSupported(String id2) {
        a abilityConfig;
        g.f(id2, "id");
        if (!PermissionGuard.INSTANCE.checkQuery(Binder.getCallingUid(), Binder.getCallingPid()) || (abilityConfig = AbilityManager.INSTANCE.getAbilityConfig(id2)) == null) {
            return false;
        }
        List<k> list = abilityConfig.f11419d;
        if (list != null && list.isEmpty()) {
            return false;
        }
        for (k kVar : list) {
            if (DeviceCapability.INSTANCE.isModelSupported(kVar.f3099k, kVar.f3100l)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.stepos.core.deepbinder.IAIEngineDeepBinderService
    public int openEnhancedServiceSettings() {
        int callingUid = Binder.getCallingUid();
        if (PermissionGuard.INSTANCE.checkInfer(callingUid, Binder.getCallingPid())) {
            return EnhancedServiceLauncherKt.launchEnhancedServiceSettings(appContext, callingUid);
        }
        AIEngineLogger.w(LogModule.ABILITY, TAG, "openEnhancedServiceSettings: permission denied uid=" + callingUid);
        return 2;
    }

    @Override // com.stepos.core.deepbinder.IAIEngineDeepBinderService
    public void registerGlobalModelChangeListener(String listenerId, IModelChangeListener listener) {
        g.f(listenerId, "listenerId");
        g.f(listener, "listener");
        if (PermissionGuard.INSTANCE.checkQuery(Binder.getCallingUid(), Binder.getCallingPid())) {
            ConcurrentHashMap<String, ConcurrentHashMap<String, IModelChangeListener>> concurrentHashMap = c.f8774a;
            ConcurrentHashMap<String, IModelChangeListener> concurrentHashMap2 = c.f8775b;
            IModelChangeListener iModelChangeListenerPut = concurrentHashMap2.put(listenerId, listener);
            if (iModelChangeListenerPut != null && iModelChangeListenerPut != listener) {
                try {
                    iModelChangeListenerPut.onRecycle();
                } catch (Exception e10) {
                    a0.a.w("registerGlobal: old listener onRecycle failed for ", listenerId, ": ", e10.getMessage(), "ModelChangeBroadcaster");
                }
            }
            Log.d("ModelChangeBroadcaster", ai.onnxruntime.a.i("registerGlobal: listenerId=", concurrentHashMap2.size(), listenerId, " (total=", ")"));
            AIEngineLogger.i(LogModule.ABILITY, TAG, "registerGlobalModelChangeListener: listenerId=".concat(listenerId));
        }
    }

    @Override // com.stepos.core.deepbinder.IAIEngineDeepBinderService
    public boolean setAbilityProperty(String id2, String name, String value) {
        g.f(id2, "id");
        g.f(name, "name");
        g.f(value, "value");
        if (PermissionGuard.INSTANCE.checkManage(Binder.getCallingUid(), Binder.getCallingPid())) {
            return AbilityManager.INSTANCE.setAbilityProperty(id2, name, value);
        }
        return false;
    }

    @Override // com.stepos.core.deepbinder.IAIEngineDeepBinderService
    public void showCTADialog(ICTACallback callback) {
        g.f(callback, "callback");
        int callingUid = Binder.getCallingUid();
        if (PermissionGuard.INSTANCE.checkInfer(callingUid, Binder.getCallingPid())) {
            CTADialogGate.INSTANCE.requestWithCallback(callingUid, callback);
            return;
        }
        AIEngineLogger.w(LogModule.ABILITY, TAG, "showCTADialog: permission denied uid=" + callingUid);
        callback.onResult(false);
    }

    @Override // com.stepos.core.deepbinder.IAIEngineDeepBinderService
    public void unregisterGlobalModelChangeListener(String listenerId) {
        g.f(listenerId, "listenerId");
        if (PermissionGuard.INSTANCE.checkQuery(Binder.getCallingUid(), Binder.getCallingPid())) {
            ConcurrentHashMap<String, ConcurrentHashMap<String, IModelChangeListener>> concurrentHashMap = c.f8774a;
            c.f8775b.remove(listenerId);
            Log.d("ModelChangeBroadcaster", "unregisterGlobal: listenerId=".concat(listenerId));
            AIEngineLogger.i(LogModule.ABILITY, TAG, "unregisterGlobalModelChangeListener: listenerId=".concat(listenerId));
        }
    }

    @Override // com.stepos.deepbinder.core.api.IRecycle
    public void onRecycle() {
    }
}
