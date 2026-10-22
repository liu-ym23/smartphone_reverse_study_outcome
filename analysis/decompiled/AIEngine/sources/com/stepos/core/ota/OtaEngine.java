package com.stepos.core.ota;

import a6.e;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import b7.k;
import com.stepos.core.ability.speech.AsrFilePcmSegmentPolicy;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.common.notification.ModelDownloadNotifier;
import com.stepos.core.common.storage.ModelPathStore;
import com.stepos.core.ota.domain.TriggerSource;
import com.stepos.core.ota.domain.port.ModelActivator;
import com.stepos.core.ota.downloader.DownloadEngine;
import com.stepos.core.ota.downloader.Fetch2DownloadEngine;
import com.stepos.core.ota.install.ExtractMode;
import com.stepos.core.ota.install.PreInstallModels;
import com.stepos.core.ota.install.PreInstallOptions;
import com.stepos.core.ota.process.OtaAbilityMappingCache;
import com.stepos.core.ota.process.OtaProcessConfig;
import com.stepos.core.ota.process.OtaRuntime;
import com.stepos.core.ota.remote.RemoteModelsRepository;
import com.stepos.core.ota.storage.ModelsVersionStore;
import com.tencent.mmkv.MMKV;
import gc.q;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.g;
import mb.v;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class OtaEngine {
    private static final String TAG = "OtaEngine";
    private static volatile Context _appContext;
    private static volatile DownloadEngine downloadEngine;
    private static volatile boolean initialized;
    public static final OtaEngine INSTANCE = new OtaEngine();
    private static volatile Map<String, ? extends Set<String>> otaToAbility = kotlin.collections.b.d0();
    private static volatile Map<String, ? extends Set<String>> abilityToOta = kotlin.collections.b.d0();
    private static volatile Map<String, String> anyIdToOta = kotlin.collections.b.d0();
    private static volatile zb.a<? extends List<p6.a>> abilityProvider = new a9.a(16);

    private OtaEngine() {
    }

    private final List<OtaAbilityMappingCache.Row> buildMappingRows() {
        Object objA;
        ArrayList arrayList = new ArrayList();
        try {
            objA = (List) abilityProvider.invoke();
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Object obj = EmptyList.f10001a;
        if (objA instanceof Result.Failure) {
            objA = obj;
        }
        for (p6.a aVar : (List) objA) {
            for (k kVar : aVar.f11419d) {
                if (kVar.f3101m) {
                    arrayList.add(new OtaAbilityMappingCache.Row(aVar.f11416a, kVar.f3090a));
                }
            }
        }
        return arrayList;
    }

    public static /* synthetic */ boolean fetchAllKnownModels$default(OtaEngine otaEngine, Context context, boolean z, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z = false;
        }
        return otaEngine.fetchAllKnownModels(context, z);
    }

    public static /* synthetic */ void init$default(OtaEngine otaEngine, Context context, zb.a aVar, l lVar, l lVar2, zb.a aVar2, boolean z, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            aVar = new a9.a(17);
        }
        zb.a aVar3 = aVar;
        if ((i10 & 4) != 0) {
            lVar = new com.stepos.core.common.telemetry.b(8);
        }
        l lVar3 = lVar;
        if ((i10 & 8) != 0) {
            lVar2 = new com.stepos.core.common.cloud.d(12);
        }
        l lVar4 = lVar2;
        if ((i10 & 16) != 0) {
            aVar2 = new a9.b(16);
        }
        zb.a aVar4 = aVar2;
        if ((i10 & 32) != 0) {
            z = true;
        }
        otaEngine.init(context, aVar3, lVar3, lVar4, aVar4, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String init$lambda$2() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ModelDownloadNotifier init$lambda$3(Context it) {
        g.f(it, "it");
        return new ModelDownloadNotifier(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Fetch2DownloadEngine init$lambda$4(Context it) {
        g.f(it, "it");
        return new Fetch2DownloadEngine(it);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void initInOtaProcess$default(OtaEngine otaEngine, Context context, ModelActivator modelActivator, l lVar, l lVar2, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            lVar = new com.stepos.core.common.cloud.d(11);
        }
        if ((i10 & 8) != 0) {
            lVar2 = new com.stepos.core.common.telemetry.b(7);
        }
        otaEngine.initInOtaProcess(context, modelActivator, lVar, lVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ModelDownloadNotifier initInOtaProcess$lambda$6(Context it) {
        g.f(it, "it");
        return new ModelDownloadNotifier(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Fetch2DownloadEngine initInOtaProcess$lambda$7(Context it) {
        g.f(it, "it");
        return new Fetch2DownloadEngine(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String initInOtaProcess$lambda$8() {
        return OtaAbilityMappingCache.INSTANCE.loadFramework();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String initInOtaProcess$lambda$9(String id2) {
        g.f(id2, "id");
        return INSTANCE.resolveAnyToOta(id2);
    }

    private final void publishMappings(Map<String, ? extends Set<String>> map, Map<String, ? extends Set<String>> map2, Map<String, String> map3) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(v.a0(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), kotlin.collections.a.R0((Iterable) entry.getValue()));
        }
        otaToAbility = linkedHashMap;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(v.a0(map2.size()));
        Iterator<T> it2 = map2.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it2.next();
            linkedHashMap2.put(entry2.getKey(), kotlin.collections.a.R0((Iterable) entry2.getValue()));
        }
        abilityToOta = linkedHashMap2;
        anyIdToOta = map3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String release$lambda$25(String it) {
        g.f(it, "it");
        return it;
    }

    private final void syncMappingCache(String str) {
        OtaRuntime.INSTANCE.syncAbilityMappings(buildMappingRows(), str);
    }

    private final void wireSharedRuntime(Context context, boolean z) {
        ModelPathStore.INSTANCE.setKeyNormalizer(new com.stepos.core.common.cloud.d(13));
        jd.b.f9768a = new d(0);
        PreInstallModels preInstallModels = PreInstallModels.INSTANCE;
        preInstallModels.checkAndInstall(PreInstallOptions.copy$default(preInstallModels.getDefaultOptions(), ExtractMode.SKIP_IF_MISSING, 0, false, false, false, 30, null), context);
        new Handler(Looper.getMainLooper()).postDelayed(new e(context, 3), AsrFilePcmSegmentPolicy.MAX_SEGMENT_MS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String wireSharedRuntime$lambda$10(String id2) {
        g.f(id2, "id");
        return INSTANCE.resolveAnyToOta(id2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String wireSharedRuntime$lambda$11(String abilityId, String registered) {
        g.f(abilityId, "abilityId");
        g.f(registered, "registered");
        String path = ModelPathStore.INSTANCE.getPath(abilityId);
        return (q.t0(path) || !new File(path).isDirectory()) ? registered : path;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wireSharedRuntime$lambda$12(Context context) {
        AIEngineLogger.i(LogModule.OTA, TAG, "delayed preinstall extract trigger (T+30s)");
        PreInstallModels preInstallModels = PreInstallModels.INSTANCE;
        preInstallModels.checkAndInstall(PreInstallOptions.copy$default(preInstallModels.getDefaultOptions(), ExtractMode.ASYNC, 0, false, false, false, 30, null), context);
    }

    public final String bucketDirOf(String modelId) {
        g.f(modelId, "modelId");
        String absolutePath = getAppContext().getFilesDir().getAbsolutePath();
        g.e(absolutePath, "getAbsolutePath(...)");
        return d.i(absolutePath, "/models/", modelId);
    }

    public final void checkAllUpdates() {
        Object objA;
        OtaDispatcher otaDispatcherDispatcher = OtaRuntime.INSTANCE.dispatcher();
        for (String str : getAllOtaNames()) {
            try {
                objA = Boolean.valueOf(otaDispatcherDispatcher.checkUpdate(str, TriggerSource.AUTO_DAILY));
            } catch (Throwable th) {
                objA = kotlin.c.a(th);
            }
            Throwable thB = Result.b(objA);
            if (thB != null) {
                AIEngineLogger.e(LogModule.OTA, TAG, "checkAllUpdates error: " + str, thB);
            }
        }
    }

    public final boolean fetchAllKnownModels(Context context, boolean z) {
        g.f(context, "context");
        String strZ0 = kotlin.collections.a.z0(getAllOtaNames(), "|", null, null, null, 62);
        if (strZ0.length() != 0) {
            return RemoteModelsRepository.fetch(context, strZ0, z);
        }
        AIEngineLogger.w(LogModule.OTA, TAG, "fetchAllKnownModels: no OTA names known, skip");
        return false;
    }

    public final Set<String> getAbilityIdsForOta(String otaName) {
        g.f(otaName, "otaName");
        Set<String> set = otaToAbility.get(otaName);
        return set == null ? EmptySet.f10003a : set;
    }

    public final Set<String> getAllOtaNames() {
        return otaToAbility.keySet();
    }

    public final Context getAppContext() {
        Context context = _appContext;
        if (context != null) {
            return context;
        }
        throw new IllegalStateException("OtaEngine not initialized");
    }

    public final String getModelDir(String modelType) {
        g.f(modelType, "modelType");
        return bucketDirOf(modelType);
    }

    public final Set<String> getOtaNamesForAbility(String abilityId) {
        g.f(abilityId, "abilityId");
        Set<String> set = abilityToOta.get(abilityId);
        return set == null ? EmptySet.f10003a : set;
    }

    public final int getVersionCode(String modelType) {
        g.f(modelType, "modelType");
        return ModelsVersionStore.INSTANCE.getVersionCode(modelType);
    }

    public final void init(Context context, zb.a<String> frameworkProvider, l<? super Context, ? extends ModelDownloadNotifier> notifierFactory, l<? super Context, ? extends DownloadEngine> engineFactory, zb.a<? extends List<p6.a>> abilityProvider2, boolean z) {
        g.f(context, "context");
        g.f(frameworkProvider, "frameworkProvider");
        g.f(notifierFactory, "notifierFactory");
        g.f(engineFactory, "engineFactory");
        g.f(abilityProvider2, "abilityProvider");
        if (initialized) {
            return;
        }
        initialized = true;
        abilityProvider = abilityProvider2;
        Context applicationContext = context.getApplicationContext();
        _appContext = applicationContext;
        MMKV.m(applicationContext);
        OtaProcessConfig otaProcessConfig = OtaProcessConfig.INSTANCE;
        otaProcessConfig.init(applicationContext);
        RemoteModelsRepository remoteModelsRepository = RemoteModelsRepository.INSTANCE;
        remoteModelsRepository.setFrameworkProvider(frameworkProvider);
        remoteModelsRepository.loadResults(applicationContext);
        rebuildMappings();
        if (otaProcessConfig.getEnabled()) {
            OtaRuntime.INSTANCE.init(applicationContext);
            syncMappingCache(frameworkProvider.invoke());
            wireSharedRuntime(applicationContext, z);
            AIEngineLogger.i(LogModule.OTA, TAG, "OtaEngine initialized (split: main → :ota IPC)");
            return;
        }
        DownloadEngine downloadEngineInvoke = engineFactory.invoke(applicationContext);
        downloadEngine = downloadEngineInvoke;
        OtaContainer.init$default(OtaContainer.INSTANCE, applicationContext, downloadEngineInvoke, notifierFactory.invoke(applicationContext), null, 8, null);
        wireSharedRuntime(applicationContext, z);
        AIEngineLogger.i(LogModule.OTA, TAG, "OtaEngine initialized (in-process)");
    }

    public final void initInOtaProcess(Context context, ModelActivator modelActivator, l<? super Context, ? extends ModelDownloadNotifier> notifierFactory, l<? super Context, ? extends DownloadEngine> engineFactory) {
        g.f(context, "context");
        g.f(modelActivator, "modelActivator");
        g.f(notifierFactory, "notifierFactory");
        g.f(engineFactory, "engineFactory");
        if (initialized) {
            return;
        }
        initialized = true;
        Context applicationContext = context.getApplicationContext();
        _appContext = applicationContext;
        MMKV.m(applicationContext);
        OtaProcessConfig.INSTANCE.init(applicationContext);
        RemoteModelsRepository remoteModelsRepository = RemoteModelsRepository.INSTANCE;
        remoteModelsRepository.setFrameworkProvider(new a9.a(18));
        remoteModelsRepository.loadResults(applicationContext);
        DownloadEngine downloadEngineInvoke = engineFactory.invoke(applicationContext);
        downloadEngine = downloadEngineInvoke;
        OtaContainer.INSTANCE.init(applicationContext, downloadEngineInvoke, notifierFactory.invoke(applicationContext), modelActivator);
        rebuildMappingsFromCache();
        ModelPathStore.INSTANCE.setKeyNormalizer(new com.stepos.core.common.telemetry.b(6));
        AIEngineLogger.i(LogModule.OTA, TAG, "OtaEngine initialized (:ota process)");
    }

    public final synchronized void rebuildMappings() {
        Object objA;
        try {
            try {
                objA = (List) abilityProvider.invoke();
            } catch (Throwable th) {
                objA = kotlin.c.a(th);
            }
            Throwable thB = Result.b(objA);
            if (thB != null) {
                AIEngineLogger.e(LogModule.OTA, TAG, "rebuildMappings: abilityProvider failed", thB);
                return;
            }
            List<p6.a> list = (List) objA;
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            HashMap map3 = new HashMap();
            for (p6.a aVar : list) {
                String str = aVar.f11416a;
                for (k kVar : aVar.f11419d) {
                    if (kVar.f3101m) {
                        String str2 = kVar.f3090a;
                        Object linkedHashSet = map.get(str2);
                        if (linkedHashSet == null) {
                            linkedHashSet = new LinkedHashSet();
                            map.put(str2, linkedHashSet);
                        }
                        ((Set) linkedHashSet).add(str);
                        Object linkedHashSet2 = map2.get(str);
                        if (linkedHashSet2 == null) {
                            linkedHashSet2 = new LinkedHashSet();
                            map2.put(str, linkedHashSet2);
                        }
                        ((Set) linkedHashSet2).add(str2);
                        map3.put(str, str2);
                        map3.put(str2, str2);
                    }
                }
            }
            publishMappings(map, map2, map3);
            AIEngineLogger.i(LogModule.OTA, TAG, "rebuildMappings: " + list.size() + " abilities → " + map.size() + " OTA names, anyIdToOta=" + map3.size());
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized void rebuildMappingsFromCache() {
        try {
            HashMap map = new HashMap();
            Map<String, ? extends Set<String>> map2 = new HashMap<>();
            HashMap map3 = new HashMap();
            for (OtaAbilityMappingCache.Row row : OtaAbilityMappingCache.INSTANCE.load()) {
                String modelId = row.getModelId();
                if (!q.t0(modelId)) {
                    Object linkedHashSet = map.get(modelId);
                    if (linkedHashSet == null) {
                        linkedHashSet = new LinkedHashSet();
                        map.put(modelId, linkedHashSet);
                    }
                    ((Set) linkedHashSet).add(row.getAbilityId());
                    String abilityId = row.getAbilityId();
                    Object linkedHashSet2 = map2.get(abilityId);
                    if (linkedHashSet2 == null) {
                        linkedHashSet2 = new LinkedHashSet();
                        map2.put(abilityId, linkedHashSet2);
                    }
                    ((Set) linkedHashSet2).add(modelId);
                    map3.put(row.getAbilityId(), modelId);
                    map3.put(modelId, modelId);
                }
            }
            publishMappings(map, map2, map3);
            AIEngineLogger.i(LogModule.OTA, TAG, "rebuildMappingsFromCache: " + map.size() + " OTA names, anyIdToOta=" + map3.size());
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void release() {
        OtaContainer.INSTANCE.stop();
        DownloadEngine downloadEngine2 = downloadEngine;
        if (downloadEngine2 != null) {
            downloadEngine2.release();
        }
        downloadEngine = null;
        ModelPathStore.INSTANCE.setKeyNormalizer(new com.stepos.core.common.telemetry.b(9));
        jd.b.f9768a = null;
        _appContext = null;
        initialized = false;
    }

    public final String resolveAnyToOta(String id2) {
        g.f(id2, "id");
        String str = anyIdToOta.get(id2);
        return str == null ? id2 : str;
    }

    public final void setVersionCode(String modelType, int i10) {
        g.f(modelType, "modelType");
        ModelsVersionStore.INSTANCE.setVersionCode(modelType, i10);
    }
}
