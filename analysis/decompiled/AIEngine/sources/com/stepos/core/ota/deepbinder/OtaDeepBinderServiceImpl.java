package com.stepos.core.ota.deepbinder;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.StatFs;
import android.os.SystemClock;
import androidx.datastore.preferences.protobuf.b1;
import com.stepos.aiengine.model.AlgorithmModelInfo;
import com.stepos.aiengine.model.AvailableModelInfo;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.common.notification.ModelDownloadNotifier;
import com.stepos.core.common.notification.NotificationCancelSuppressStore;
import com.stepos.core.common.storage.InstalledModelMetaStore;
import com.stepos.core.cta.CTADialogGate;
import com.stepos.core.cta.CTAPermissionManager;
import com.stepos.core.deepbinder.ICtaResultCallback;
import com.stepos.core.deepbinder.IOtaDeepBinderService;
import com.stepos.core.deepbinder.IOtaTaskStateCallback;
import com.stepos.core.download.IDownloadCallback;
import com.stepos.core.download.ModelFlowMeta;
import com.stepos.core.ota.OtaAlgorithmUpdater;
import com.stepos.core.ota.OtaDispatcher;
import com.stepos.core.ota.OtaEngine;
import com.stepos.core.ota.bridge.CallbackSubscriber;
import com.stepos.core.ota.bridge.OtaTaskStateBroadcaster;
import com.stepos.core.ota.confirm.DownloadConfirmPlanner;
import com.stepos.core.ota.confirm.InteractiveSessionRegistry;
import com.stepos.core.ota.confirm.UpdateConfirmPlanner;
import com.stepos.core.ota.data.OtaRemoteModel;
import com.stepos.core.ota.data.UpdateInfoI18nKt;
import com.stepos.core.ota.deepbinder.DownloadResourceGate;
import com.stepos.core.ota.display.DisplayResourcePolicy;
import com.stepos.core.ota.display.ModelDisplayLookup;
import com.stepos.core.ota.display.ModelDisplayResourceStore;
import com.stepos.core.ota.display.ModelLabelResolver;
import com.stepos.core.ota.domain.ModelUninstaller;
import com.stepos.core.ota.domain.OtaErrorKt;
import com.stepos.core.ota.domain.OtaState;
import com.stepos.core.ota.domain.OtaStateSnapshot;
import com.stepos.core.ota.domain.TriggerSource;
import com.stepos.core.ota.install.InstalledPathResolver;
import com.stepos.core.ota.install.OtaBucketLegacy;
import com.stepos.core.ota.install.PreInstallModels;
import com.stepos.core.ota.process.OtaProcess;
import com.stepos.core.ota.process.OtaRuntime;
import com.stepos.core.ota.push.AutoUpdateEnv;
import com.stepos.core.ota.push.ModelAutoUpdateManager;
import com.stepos.core.ota.push.ModelUpdateConditionManager;
import com.stepos.core.ota.push.NoNetworkPromptStore;
import com.stepos.core.ota.push.PendingAutoUpdateStore;
import com.stepos.core.ota.push.UpdatablePendingScanner;
import com.stepos.core.ota.remote.RemoteModelsRepository;
import com.stepos.core.ota.storage.ModelsVersionStore;
import com.stepos.core.ota.storage.OtaFailureMarker;
import com.stepos.core.ota.storage.UserUninstallStore;
import com.stepos.deepbinder.core.api.IRecycle;
import com.tonyodev.fetch2core.server.FileResponse;
import fc.i;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.g;
import lb.n;
import mb.l;
import mb.m;
import mb.q;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class OtaDeepBinderServiceImpl implements IOtaDeepBinderService, IRecycle {
    public static final Companion Companion = new Companion(null);
    private static final String PERF_TAG = "OtaConfirmPerf";
    private final String TAG = "OtaDeepBinderSvcImpl";
    private final ConcurrentHashMap<IDownloadCallback, String> callbackIds = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<IOtaTaskStateCallback, String> taskStateCallbackIds = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, String> activeClientTags = new ConcurrentHashMap<>();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        public final void continueAfterCtaIfNeeded(Context context, List<String> algorithmIds) {
            g.f(context, "context");
            g.f(algorithmIds, "algorithmIds");
            OtaInteractiveDownloadFlow.INSTANCE.continueAfterCtaIfNeeded(context, algorithmIds);
        }

        public final void flushPendingAfterCta(Context context) {
            g.f(context, "context");
            OtaInteractiveDownloadFlow.INSTANCE.flushAfterCta(context);
        }

        public final boolean hasPendingInteractiveDownload() {
            return OtaInteractiveDownloadFlow.INSTANCE.hasPending();
        }

        public final int localCheckState(String algorithmId) {
            g.f(algorithmId, "algorithmId");
            String strResolveAnyToOta = OtaEngine.INSTANCE.resolveAnyToOta(algorithmId);
            if (UserUninstallStore.INSTANCE.contains(strResolveAnyToOta)) {
                return 0;
            }
            if (PreInstallModels.INSTANCE.isExtracting(strResolveAnyToOta)) {
                return 6;
            }
            return InstalledPathResolver.INSTANCE.isUsable(algorithmId, strResolveAnyToOta, true) ? 1 : 0;
        }

        public final void rescanUpdatablePendingAfterRegrant(Context context) {
            g.f(context, "context");
            UpdatablePendingScanner.INSTANCE.seed(context, false);
            ModelAutoUpdateManager.tryRun$default(ModelAutoUpdateManager.INSTANCE, "cta_regrant_rescan", false, 2, null);
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[DownloadConfirmPlanner.Plan.values().length];
            try {
                iArr[DownloadConfirmPlanner.Plan.NO_NETWORK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DownloadConfirmPlanner.Plan.CONFIRM_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DownloadConfirmPlanner.Plan.CONFIRM_THEN_CELLULAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[UpdateConfirmPlanner.UpdatePlan.values().length];
            try {
                iArr2[UpdateConfirmPlanner.UpdatePlan.NO_NETWORK.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[UpdateConfirmPlanner.UpdatePlan.WIFI_AUTO_ON.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[UpdateConfirmPlanner.UpdatePlan.WIFI_AUTO_OFF.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[UpdateConfirmPlanner.UpdatePlan.CELLULAR_AUTO_ON.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[UpdateConfirmPlanner.UpdatePlan.CELLULAR_AUTO_OFF.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    private final String binderClientTag(String str) {
        return ai.onnxruntime.a.k("binder:", str);
    }

    private final Bundle blockedFetchMeta(String str, boolean z) {
        String strResolveAnyToOta = OtaEngine.INSTANCE.resolveAnyToOta(str);
        Bundle bundle = new Bundle();
        bundle.putBoolean(ModelFlowMeta.KEY_INSTALLED, false);
        bundle.putBoolean(ModelFlowMeta.KEY_ACTIVE, false);
        bundle.putBoolean(z ? ModelFlowMeta.KEY_HAS_UPDATE : ModelFlowMeta.KEY_CAN_UPDATE, false);
        bundle.putLong("sizeBytes", 0L);
        bundle.putString("updateInfo", "");
        bundle.putString("plan", ModelFlowMeta.PLAN_NONE);
        bundle.putString("modelLabel", resolveModelLabel(strResolveAnyToOta));
        bundle.putBoolean(ModelFlowMeta.KEY_FETCH_OK, false);
        bundle.putBoolean(ModelFlowMeta.KEY_REMOTE_AVAILABLE, false);
        bundle.putBoolean(ModelFlowMeta.KEY_SERVER_REACHED, false);
        bundle.putBoolean(ModelFlowMeta.KEY_CTA_BLOCKED, true);
        bundle.putBoolean(ModelFlowMeta.KEY_SERVICE_ENABLED, CTAPermissionManager.INSTANCE.isModelServiceEnabled());
        return bundle;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:135:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0190  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.util.List<com.stepos.aiengine.model.AvailableModelInfo> buildModelInfos(java.lang.String r32, java.util.Map<java.lang.String, com.stepos.core.ota.domain.OtaStateSnapshot> r33, com.stepos.core.ota.data.OtaRemoteModel r34) {
        /*
            Method dump skipped, instructions count: 748
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.deepbinder.OtaDeepBinderServiceImpl.buildModelInfos(java.lang.String, java.util.Map, com.stepos.core.ota.data.OtaRemoteModel):java.util.List");
    }

    private final int callingUid() {
        return Binder.getCallingUid();
    }

    private final int checkInstallState(String str) {
        String strResolveAnyToOta = OtaEngine.INSTANCE.resolveAnyToOta(str);
        if (UserUninstallStore.INSTANCE.contains(strResolveAnyToOta)) {
            return 0;
        }
        if (PreInstallModels.INSTANCE.isExtracting(strResolveAnyToOta)) {
            return 6;
        }
        if (InstalledPathResolver.INSTANCE.isUsable(str, strResolveAnyToOta, true)) {
            return 1;
        }
        return !OtaAlgorithmUpdater.INSTANCE.getUpdates(ctx(), new String[]{strResolveAnyToOta}).isEmpty() ? 5 : 0;
    }

    private final Context ctx() {
        return OtaEngine.INSTANCE.getAppContext();
    }

    private final String downloadPlanString() {
        int i10 = WhenMappings.$EnumSwitchMapping$0[DownloadConfirmPlanner.INSTANCE.planFor(ctx()).ordinal()];
        if (i10 == 1) {
            return ModelFlowMeta.PLAN_NO_NETWORK;
        }
        if (i10 == 2) {
            return ModelFlowMeta.PLAN_DL_CONFIRM_ONLY;
        }
        if (i10 == 3) {
            return ModelFlowMeta.PLAN_DL_CONFIRM_THEN_CELLULAR;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n executeDownload$lambda$49(String str, OtaDeepBinderServiceImpl otaDeepBinderServiceImpl) {
        InteractiveSessionRegistry interactiveSessionRegistry = InteractiveSessionRegistry.INSTANCE;
        OtaEngine otaEngine = OtaEngine.INSTANCE;
        interactiveSessionRegistry.end(otaEngine.resolveAnyToOta(str));
        try {
            CallbackSubscriber.emitTransient$default(OtaRuntime.INSTANCE.callbacks(), otaEngine.resolveAnyToOta(str), 14, 0, 4, null);
            n nVar = n.f10413a;
        } catch (Throwable th) {
            kotlin.c.a(th);
        }
        return n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bundle fetchDownloadMeta$lambda$34(OtaDeepBinderServiceImpl otaDeepBinderServiceImpl, String str) {
        Bundle bundleServiceDisabledFetchMeta = otaDeepBinderServiceImpl.serviceDisabledFetchMeta(str, false);
        return bundleServiceDisabledFetchMeta == null ? otaDeepBinderServiceImpl.fetchMetaAfterCta(str, false) : bundleServiceDisabledFetchMeta;
    }

    private final Bundle fetchMetaAfterCta(String str, boolean z) {
        LogModule logModule;
        OtaRemoteModel otaRemoteModel;
        OtaBucketLegacy otaBucketLegacy;
        PreInstallModels preInstallModels;
        boolean z3;
        boolean z10;
        String strLocalizedUpdateInfo;
        OtaEngine otaEngine = OtaEngine.INSTANCE;
        String strResolveAnyToOta = otaEngine.resolveAnyToOta(str);
        boolean z11 = z || isInstallBroken(strResolveAnyToOta) || OtaFailureMarker.INSTANCE.requiresCleanRedownload(strResolveAnyToOta);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        boolean zRefreshRemote$default = OtaAlgorithmUpdater.refreshRemote$default(OtaAlgorithmUpdater.INSTANCE, ctx(), strResolveAnyToOta, z11, 0L, 8, null);
        LogModule logModule2 = LogModule.OTA;
        StringBuilder sbO = a0.a.o("OCPERF tid=- stage=OTA_REFRESH_REMOTE dur=", SystemClock.elapsedRealtime() - jElapsedRealtime, "ms modelId=", strResolveAnyToOta);
        sbO.append(" fetchOk=");
        sbO.append(zRefreshRemote$default);
        sbO.append(" force=");
        sbO.append(z11);
        AIEngineLogger.i(logModule2, PERF_TAG, sbO.toString());
        OtaRemoteModel otaRemoteModel2 = RemoteModelsRepository.get(strResolveAnyToOta);
        String strBucketDirOf = otaEngine.bucketDirOf(strResolveAnyToOta);
        long jElapsedRealtime2 = SystemClock.elapsedRealtime();
        OtaBucketLegacy otaBucketLegacy2 = OtaBucketLegacy.INSTANCE;
        int iEffectiveVersion = otaBucketLegacy2.effectiveVersion(strResolveAnyToOta);
        boolean z12 = !UserUninstallStore.INSTANCE.contains(strResolveAnyToOta) && iEffectiveVersion > 0 && InstalledPathResolver.INSTANCE.isUsable(str, strResolveAnyToOta, true);
        int version_code = z12 ? iEffectiveVersion : otaRemoteModel2 != null ? otaRemoteModel2.getVersion_code() : 0;
        DisplayResourcePolicy displayResourcePolicy = DisplayResourcePolicy.INSTANCE;
        PreInstallModels preInstallModels2 = PreInstallModels.INSTANCE;
        DisplayResourcePolicy.Decision decisionDecide = displayResourcePolicy.decide(preInstallModels2.isPreset(strResolveAnyToOta), z12, iEffectiveVersion, otaRemoteModel2 != null, otaRemoteModel2 != null ? otaRemoteModel2.getResource_url() : null, otaRemoteModel2 != null ? otaRemoteModel2.getVersion_code() : 0, InstalledModelMetaStore.INSTANCE.getDisplayKey(ctx(), strResolveAnyToOta));
        String downloadUrl = decisionDecide.getDownloadUrl();
        if (decisionDecide.getDropRemoteLeftover()) {
            otaRemoteModel = otaRemoteModel2;
            preInstallModels = preInstallModels2;
            logModule = logModule2;
            otaBucketLegacy = otaBucketLegacy2;
            ModelDisplayResourceStore.purgeForeign$default(ModelDisplayResourceStore.INSTANCE, ctx(), strResolveAnyToOta, strBucketDirOf, null, 8, null);
        } else {
            logModule = logModule2;
            otaRemoteModel = otaRemoteModel2;
            otaBucketLegacy = otaBucketLegacy2;
            preInstallModels = preInstallModels2;
        }
        Set<String> abilityIdsForOta = otaEngine.getAbilityIdsForOta(strResolveAnyToOta);
        if (abilityIdsForOta.isEmpty()) {
            abilityIdsForOta = l.s0(new String[]{str, strResolveAnyToOta});
        }
        Set<String> set = abilityIdsForOta;
        boolean zIsPreset = preInstallModels.isPreset(strResolveAnyToOta);
        String str2 = "";
        String strPresetDisplaySourceDir = (zIsPreset && z12) ? presetDisplaySourceDir(strResolveAnyToOta, set, true) : "";
        ModelDisplayResourceStore modelDisplayResourceStore = ModelDisplayResourceStore.INSTANCE;
        String strEnsure = modelDisplayResourceStore.ensure(ctx(), strResolveAnyToOta, downloadUrl, strBucketDirOf, version_code, strPresetDisplaySourceDir);
        if (strEnsure == null) {
            strEnsure = ModelDisplayResourceStore.existingDisplayDir$default(modelDisplayResourceStore, ctx(), strResolveAnyToOta, strBucketDirOf, null, 8, null);
        }
        if (strEnsure == null) {
            strEnsure = "";
        }
        long jElapsedRealtime3 = SystemClock.elapsedRealtime() - jElapsedRealtime2;
        OtaRemoteModel otaRemoteModel3 = otaRemoteModel;
        String resource_url = otaRemoteModel3 != null ? otaRemoteModel3.getResource_url() : null;
        boolean z13 = !(resource_url == null || resource_url.length() == 0);
        boolean z14 = strEnsure.length() > 0;
        StringBuilder sbO2 = a0.a.o("OCPERF tid=- stage=OTA_DISPLAY_ENSURE dur=", jElapsedRealtime3, "ms modelId=", strResolveAnyToOta);
        sbO2.append(" hasUrl=");
        sbO2.append(z13);
        sbO2.append(" dirOk=");
        sbO2.append(z14);
        a0.a.z(sbO2, " blocking=true", logModule, PERF_TAG);
        String strResolve = ModelLabelResolver.INSTANCE.resolve(ctx(), strResolveAnyToOta, strEnsure);
        boolean zIsInstalled = isInstalled(str, strResolveAnyToOta, z);
        boolean z15 = zIsInstalled && otaRemoteModel3 != null && otaBucketLegacy.effectiveVersion(strResolveAnyToOta) < otaRemoteModel3.getVersion_code();
        Bundle bundle = new Bundle();
        bundle.putBoolean(ModelFlowMeta.KEY_INSTALLED, zIsInstalled);
        bundle.putBoolean(ModelFlowMeta.KEY_ACTIVE, isTaskActive(str, strResolveAnyToOta));
        bundle.putBoolean(z ? ModelFlowMeta.KEY_HAS_UPDATE : ModelFlowMeta.KEY_CAN_UPDATE, z15);
        bundle.putLong("sizeBytes", otaRemoteModel3 != null ? otaRemoteModel3.getFile_size() : 0L);
        if (otaRemoteModel3 != null && (strLocalizedUpdateInfo = UpdateInfoI18nKt.localizedUpdateInfo(otaRemoteModel3, ctx())) != null) {
            str2 = strLocalizedUpdateInfo;
        }
        bundle.putString("updateInfo", str2);
        bundle.putString("plan", z ? updatePlanString() : downloadPlanString());
        bundle.putString("modelLabel", strResolve);
        bundle.putBoolean(ModelFlowMeta.KEY_FETCH_OK, zRefreshRemote$default);
        bundle.putBoolean(ModelFlowMeta.KEY_REMOTE_AVAILABLE, otaRemoteModel3 != null);
        if (!zRefreshRemote$default && otaRemoteModel3 == null) {
            z3 = true;
            if (!RemoteModelsRepository.wasServerReachedRecently$default(0L, 1, null)) {
                z10 = false;
            }
            bundle.putBoolean(ModelFlowMeta.KEY_SERVER_REACHED, z10);
            bundle.putBoolean(ModelFlowMeta.KEY_SERVICE_ENABLED, CTAPermissionManager.INSTANCE.isModelServiceEnabled());
            return bundle;
        }
        z3 = true;
        z10 = z3;
        bundle.putBoolean(ModelFlowMeta.KEY_SERVER_REACHED, z10);
        bundle.putBoolean(ModelFlowMeta.KEY_SERVICE_ENABLED, CTAPermissionManager.INSTANCE.isModelServiceEnabled());
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bundle fetchUpdateMeta$lambda$35(OtaDeepBinderServiceImpl otaDeepBinderServiceImpl, String str) {
        Bundle bundleServiceDisabledFetchMeta = otaDeepBinderServiceImpl.serviceDisabledFetchMeta(str, true);
        return bundleServiceDisabledFetchMeta == null ? otaDeepBinderServiceImpl.fetchMetaAfterCta(str, true) : bundleServiceDisabledFetchMeta;
    }

    private final <T> T gateNetworkRead(T t8, zb.a<? extends T> aVar) {
        if (hasCTA()) {
            return aVar.invoke();
        }
        requireCTA$default(this, new CTADialogGate.CtaContinuation() { // from class: com.stepos.core.ota.deepbinder.OtaDeepBinderServiceImpl.gateNetworkRead.1
            @Override // com.stepos.core.cta.CTADialogGate.CtaContinuation
            public boolean getRunsOnMainThread() {
                return CTADialogGate.CtaContinuation.DefaultImpls.getRunsOnMainThread(this);
            }

            @Override // com.stepos.core.cta.CTADialogGate.CtaContinuation
            public final void onContinue(Context context) {
                g.f(context, "<unused var>");
            }
        }, null, 2, null);
        return t8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getAvailableModels$lambda$6(OtaDeepBinderServiceImpl otaDeepBinderServiceImpl) {
        return otaDeepBinderServiceImpl.getAvailableModelsAfterCta(false);
    }

    private final List<AvailableModelInfo> getAvailableModelsAfterCta(boolean z) {
        OtaEngine otaEngine = OtaEngine.INSTANCE;
        otaEngine.fetchAllKnownModels(ctx(), z);
        Map<String, OtaStateSnapshot> mapSnapshot = OtaRuntime.INSTANCE.snapshot();
        Set<String> allOtaNames = otaEngine.getAllOtaNames();
        ArrayList arrayList = new ArrayList();
        for (String str : allOtaNames) {
            q.g0(arrayList, buildModelInfos(str, mapSnapshot, RemoteModelsRepository.get(str)));
        }
        if (recordUpdatablePending(arrayList)) {
            ModelAutoUpdateManager.INSTANCE.tryRun("model_manager_open", true);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getAvailableModelsForce$lambda$7(OtaDeepBinderServiceImpl otaDeepBinderServiceImpl) {
        return otaDeepBinderServiceImpl.getAvailableModelsAfterCta(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getPresetModels$lambda$11(OtaDeepBinderServiceImpl otaDeepBinderServiceImpl) {
        Map<String, OtaStateSnapshot> mapSnapshot = OtaRuntime.INSTANCE.snapshot();
        Set<String> allOtaNames = OtaEngine.INSTANCE.getAllOtaNames();
        ArrayList arrayList = new ArrayList();
        for (Object obj : allOtaNames) {
            if (PreInstallModels.INSTANCE.isPreset((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj2 = arrayList.get(i10);
            i10++;
            q.g0(arrayList2, otaDeepBinderServiceImpl.buildModelInfos((String) obj2, mapSnapshot, null));
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bundle getUpdateInfoAfterCta(String str) {
        String str2;
        OtaRemoteModel otaRemoteModel;
        String name;
        List<String> abilities;
        List<String> dependencies;
        String strResolveAnyToOta = OtaEngine.INSTANCE.resolveAnyToOta(str);
        OtaRemoteModel otaRemoteModel2 = RemoteModelsRepository.get(strResolveAnyToOta);
        int versionCode = ModelsVersionStore.INSTANCE.getVersionCode(strResolveAnyToOta);
        PendingAutoUpdateStore.Record record = PendingAutoUpdateStore.INSTANCE.get(strResolveAnyToOta);
        if (record == null || record.getVersionCode() <= versionCode) {
            str2 = strResolveAnyToOta;
            otaRemoteModel = otaRemoteModel2;
        } else {
            otaRemoteModel = otaRemoteModel2;
            if (record.getVersionCode() > (otaRemoteModel2 != null ? otaRemoteModel2.getVersion_code() : 0)) {
                LogModule logModule = LogModule.OTA;
                String str3 = this.TAG;
                StringBuilder sbF = h0.e.f("getUpdateInfo: ", str, " answered by push record ver=", record.getVersionCode(), " local=");
                sbF.append(versionCode);
                AIEngineLogger.i(logModule, str3, sbF.toString());
                OtaRemoteModel otaRemoteModel3 = (otaRemoteModel == null || otaRemoteModel.getVersion_code() != record.getVersionCode()) ? null : otaRemoteModel;
                Bundle bundle = new Bundle();
                if (otaRemoteModel == null || (name = otaRemoteModel.getName()) == null) {
                    name = strResolveAnyToOta;
                }
                bundle.putString("name", name);
                String url = otaRemoteModel3 != null ? otaRemoteModel3.getUrl() : null;
                if (url == null) {
                    url = "";
                }
                bundle.putString("url", url);
                String md5 = otaRemoteModel3 != null ? otaRemoteModel3.getMd5() : null;
                if (md5 == null) {
                    md5 = "";
                }
                bundle.putString(FileResponse.FIELD_MD5, md5);
                bundle.putLong("fileSize", record.getSizeBytes());
                bundle.putInt("versionCode", record.getVersionCode());
                String strLocalizedUpdateInfo = otaRemoteModel3 != null ? UpdateInfoI18nKt.localizedUpdateInfo(otaRemoteModel3, ctx()) : null;
                bundle.putString("updateInfo", strLocalizedUpdateInfo != null ? strLocalizedUpdateInfo : "");
                bundle.putLong("updateTime", otaRemoteModel3 != null ? otaRemoteModel3.getUpdate_time() : 0L);
                if (otaRemoteModel == null || (abilities = otaRemoteModel.getAbilities()) == null) {
                    abilities = EmptyList.f10001a;
                }
                bundle.putStringArrayList("abilities", new ArrayList<>(abilities));
                if (otaRemoteModel == null || (dependencies = otaRemoteModel.getDependencies()) == null) {
                    dependencies = EmptyList.f10001a;
                }
                bundle.putStringArrayList("dependencies", new ArrayList<>(dependencies));
                return bundle;
            }
            str2 = strResolveAnyToOta;
        }
        String str4 = str2;
        if (!OtaAlgorithmUpdater.INSTANCE.getUpdates(ctx(), new String[]{str2}).contains(str4)) {
            AIEngineLogger.d(LogModule.OTA, this.TAG, ai.onnxruntime.a.l("getUpdateInfo: not in updates abilityId=", str, " otaId=", str4));
            return null;
        }
        if (otaRemoteModel == null) {
            ai.onnxruntime.a.w("getUpdateInfo: no remote model cached for otaId=", str4, LogModule.OTA, this.TAG);
            return null;
        }
        LogModule logModule2 = LogModule.OTA;
        String str5 = this.TAG;
        String url2 = otaRemoteModel.getUrl();
        long file_size = otaRemoteModel.getFile_size();
        int version_code = otaRemoteModel.getVersion_code();
        StringBuilder sbS = ai.onnxruntime.a.s("getUpdateInfo: ", str, " url=", url2, " size=");
        sbS.append(file_size);
        sbS.append(" ver=");
        sbS.append(version_code);
        AIEngineLogger.i(logModule2, str5, sbS.toString());
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", otaRemoteModel.getName());
        bundle2.putString("url", otaRemoteModel.getUrl());
        bundle2.putString(FileResponse.FIELD_MD5, otaRemoteModel.getMd5());
        bundle2.putLong("fileSize", otaRemoteModel.getFile_size());
        bundle2.putInt("versionCode", otaRemoteModel.getVersion_code());
        OtaRemoteModel otaRemoteModel4 = otaRemoteModel;
        bundle2.putString("updateInfo", UpdateInfoI18nKt.localizedUpdateInfo(otaRemoteModel4, ctx()));
        bundle2.putLong("updateTime", otaRemoteModel4.getUpdate_time());
        bundle2.putStringArrayList("abilities", new ArrayList<>(otaRemoteModel4.getAbilities()));
        List<String> dependencies2 = otaRemoteModel4.getDependencies();
        if (dependencies2 == null) {
            dependencies2 = EmptyList.f10001a;
        }
        bundle2.putStringArrayList("dependencies", new ArrayList<>(dependencies2));
        return bundle2;
    }

    private final boolean hasCTA() {
        return CTAPermissionManager.INSTANCE.hasCTAPermission();
    }

    private final boolean isInstallBroken(String str) {
        OtaStateSnapshot otaStateSnapshot = OtaRuntime.INSTANCE.snapshot().get(str);
        OtaState state = otaStateSnapshot != null ? otaStateSnapshot.getState() : null;
        OtaState.Failed failed = state instanceof OtaState.Failed ? (OtaState.Failed) state : null;
        if (failed == null) {
            return false;
        }
        return OtaErrorKt.requiresCleanRedownload(failed.getError());
    }

    private final boolean isInstalled(String str, String str2, boolean z) {
        return InstalledMetaResolver.INSTANCE.isInstalled(isInstallBroken(str2), z, new d(0, str2, str));
    }

    public static /* synthetic */ boolean isInstalled$default(OtaDeepBinderServiceImpl otaDeepBinderServiceImpl, String str, String str2, boolean z, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z = false;
        }
        return otaDeepBinderServiceImpl.isInstalled(str, str2, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isInstalled$lambda$29(String str, String str2) {
        return !UserUninstallStore.INSTANCE.contains(str) && InstalledPathResolver.INSTANCE.isUsable(str2, str, true);
    }

    private final boolean isRealTaskActive(String str) {
        OtaState state;
        OtaStateSnapshot otaStateSnapshotSnapshotOf = snapshotOf(str);
        return (otaStateSnapshotSnapshotOf == null || (state = otaStateSnapshotSnapshotOf.getState()) == null || !state.isActive()) ? false : true;
    }

    private final boolean isTaskActive(String str, String str2) {
        OtaState state;
        OtaStateSnapshot otaStateSnapshotSnapshotOf = snapshotOf(str);
        return !(otaStateSnapshotSnapshotOf == null || (state = otaStateSnapshotSnapshotOf.getState()) == null || !state.isActive()) || InteractiveSessionRegistry.isActive$default(InteractiveSessionRegistry.INSTANCE, str2, 0L, 2, null) || OtaInteractiveDownloadFlow.INSTANCE.hasPendingConfirm(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final String presetDisplaySourceDir(String str, Set<String> set, boolean z) {
        fc.g gVar;
        String strPresetDisplaySourceDir$lambda$30;
        i iVarZ = l.Z(new i[]{l.Z(new String[]{str}), kotlin.collections.a.l0(set)});
        com.stepos.core.common.telemetry.b bVar = new com.stepos.core.common.telemetry.b(25);
        int i10 = 26;
        if (iVarZ instanceof fc.q) {
            fc.q qVar = (fc.q) iVarZ;
            gVar = new fc.g(qVar.f8828a, qVar.f8829b, bVar);
        } else {
            gVar = new fc.g(iVarZ, new com.stepos.core.common.telemetry.b(i10), bVar);
        }
        fc.b bVar2 = new fc.b(gVar.iterator(), new com.stepos.core.common.telemetry.b(i10));
        while (true) {
            if (!bVar2.hasNext()) {
                strPresetDisplaySourceDir$lambda$30 = null;
                break;
            }
            strPresetDisplaySourceDir$lambda$30 = presetDisplaySourceDir$lambda$30(str, z, (String) bVar2.next());
            if (!gc.q.t0(strPresetDisplaySourceDir$lambda$30)) {
                break;
            }
        }
        return strPresetDisplaySourceDir$lambda$30 == null ? "" : strPresetDisplaySourceDir$lambda$30;
    }

    private static final String presetDisplaySourceDir$lambda$30(String str, boolean z, String it) {
        g.f(it, "it");
        return InstalledPathResolver.INSTANCE.resolve(it, str, z);
    }

    private final boolean recordUpdatablePending(List<AvailableModelInfo> list) {
        Object objA;
        Collection<AvailableModelInfo> collectionP;
        try {
            fc.b bVar = new fc.b(new fc.f(new fc.f(kotlin.collections.a.l0(list), new com.stepos.core.common.cloud.d(17)), new com.stepos.core.common.telemetry.b(12)).iterator(), new com.stepos.core.common.cloud.d(18));
            if (bVar.hasNext()) {
                T next = bVar.next();
                if (bVar.hasNext()) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(next);
                    while (bVar.hasNext()) {
                        arrayList.add(bVar.next());
                    }
                    collectionP = arrayList;
                } else {
                    collectionP = b1.P(next);
                }
            } else {
                collectionP = EmptyList.f10001a;
            }
            for (AvailableModelInfo availableModelInfo : collectionP) {
                PendingAutoUpdateStore.INSTANCE.put(new PendingAutoUpdateStore.Record(availableModelInfo.getOtaName(), availableModelInfo.getRemoteVersionCode(), false, availableModelInfo.getFileSize(), null, System.currentTimeMillis(), false, 64, null));
            }
            objA = Boolean.valueOf(!collectionP.isEmpty());
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            AIEngineLogger.w(LogModule.OTA, this.TAG, "recordUpdatablePending failed", thB);
        }
        Boolean bool = Boolean.FALSE;
        if (objA instanceof Result.Failure) {
            objA = bool;
        }
        return ((Boolean) objA).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean recordUpdatablePending$lambda$24$lambda$20(AvailableModelInfo it) {
        g.f(it, "it");
        return it.getInstallStatus() == 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean recordUpdatablePending$lambda$24$lambda$21(AvailableModelInfo it) {
        g.f(it, "it");
        return !UserUninstallStore.INSTANCE.contains(it.getOtaName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String recordUpdatablePending$lambda$24$lambda$22(AvailableModelInfo it) {
        g.f(it, "it");
        return it.getOtaName();
    }

    private final OtaRemoteModel remoteIfCtaGranted(String str) {
        if (hasCTA()) {
            return RemoteModelsRepository.get(str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n requestCta$lambda$45(OtaDeepBinderServiceImpl otaDeepBinderServiceImpl, ICtaResultCallback iCtaResultCallback) {
        try {
            iCtaResultCallback.onResult(false);
            n nVar = n.f10413a;
        } catch (Throwable th) {
            kotlin.c.a(th);
        }
        return n.f10413a;
    }

    private final void requireCTA(CTADialogGate.CtaContinuation ctaContinuation, zb.a<n> aVar) {
        if (hasCTA()) {
            ctaContinuation.onContinue(ctx());
            return;
        }
        if (OtaProcess.INSTANCE.isOtaProcess(ctx())) {
            AIEngineLogger.d(LogModule.OTA, this.TAG, "CTA not granted in :ota process, skip dialog");
            if (aVar != null) {
                aVar.invoke();
                return;
            }
            return;
        }
        int iCallingUid = callingUid();
        AIEngineLogger.i(LogModule.OTA, this.TAG, "CTA not granted, requesting dialog uid=" + iCallingUid);
        CTADialogGate.INSTANCE.ensureGranted(iCallingUid, ctaContinuation, aVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void requireCTA$default(OtaDeepBinderServiceImpl otaDeepBinderServiceImpl, CTADialogGate.CtaContinuation ctaContinuation, zb.a aVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            aVar = null;
        }
        otaDeepBinderServiceImpl.requireCTA(ctaContinuation, aVar);
    }

    private final String resolveModelLabel(String str) {
        return ModelLabelResolver.INSTANCE.resolve(ctx(), str, ModelDisplayLookup.INSTANCE.readDir(ctx(), str, OtaEngine.INSTANCE.bucketDirOf(str)));
    }

    private final Bundle serviceDisabledFetchMeta(String str, boolean z) {
        if (CTAPermissionManager.INSTANCE.isModelServiceEnabled()) {
            return null;
        }
        String strResolveAnyToOta = OtaEngine.INSTANCE.resolveAnyToOta(str);
        AIEngineLogger.i(LogModule.OTA, this.TAG, "fetchMeta short-circuit: model service disabled, no network for " + strResolveAnyToOta);
        Bundle bundle = new Bundle();
        bundle.putBoolean(ModelFlowMeta.KEY_INSTALLED, isInstalled(str, strResolveAnyToOta, z));
        bundle.putBoolean(ModelFlowMeta.KEY_ACTIVE, isTaskActive(str, strResolveAnyToOta));
        bundle.putBoolean(z ? ModelFlowMeta.KEY_HAS_UPDATE : ModelFlowMeta.KEY_CAN_UPDATE, false);
        bundle.putLong("sizeBytes", 0L);
        bundle.putString("updateInfo", "");
        bundle.putString("plan", ModelFlowMeta.PLAN_NONE);
        bundle.putString("modelLabel", resolveModelLabel(strResolveAnyToOta));
        bundle.putBoolean(ModelFlowMeta.KEY_FETCH_OK, false);
        bundle.putBoolean(ModelFlowMeta.KEY_REMOTE_AVAILABLE, false);
        bundle.putBoolean(ModelFlowMeta.KEY_SERVER_REACHED, false);
        bundle.putBoolean(ModelFlowMeta.KEY_SERVICE_ENABLED, false);
        return bundle;
    }

    private final OtaStateSnapshot snapshotOf(String str) {
        return OtaRuntime.INSTANCE.snapshot().get(OtaEngine.INSTANCE.resolveAnyToOta(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void triggerCheckUpdateAsync(String str) {
        String strResolveAnyToOta = OtaEngine.INSTANCE.resolveAnyToOta(str);
        AIEngineLogger.i(LogModule.OTA, this.TAG, ai.onnxruntime.a.l("triggerCheckUpdate(async): abilityId=", str, " otaId=", strResolveAnyToOta));
        OtaAlgorithmUpdater.INSTANCE.checkUpdatesAsync(ctx(), new String[]{strResolveAnyToOta});
    }

    private final void triggerCheckUpdateBlocking(String str) throws ExecutionException, InterruptedException, TimeoutException {
        String strResolveAnyToOta = OtaEngine.INSTANCE.resolveAnyToOta(str);
        AIEngineLogger.i(LogModule.OTA, this.TAG, ai.onnxruntime.a.l("triggerCheckUpdate(sync): abilityId=", str, " otaId=", strResolveAnyToOta));
        OtaAlgorithmUpdater.INSTANCE.checkUpdates(ctx(), new String[]{strResolveAnyToOta});
    }

    private final String updatePlanString() {
        int i10 = WhenMappings.$EnumSwitchMapping$1[UpdateConfirmPlanner.INSTANCE.planFor(ctx()).ordinal()];
        if (i10 == 1) {
            return ModelFlowMeta.PLAN_NO_NETWORK;
        }
        if (i10 == 2) {
            return ModelFlowMeta.PLAN_UPD_WIFI_AUTO_ON;
        }
        if (i10 == 3) {
            return ModelFlowMeta.PLAN_UPD_WIFI_AUTO_OFF;
        }
        if (i10 == 4) {
            return ModelFlowMeta.PLAN_UPD_CELLULAR_AUTO_ON;
        }
        if (i10 == 5) {
            return ModelFlowMeta.PLAN_UPD_CELLULAR_AUTO_OFF;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.stepos.core.deepbinder.IOtaDeepBinderService
    public void beginInteractiveSession(String algorithmId) {
        g.f(algorithmId, "algorithmId");
        InteractiveSessionRegistry.INSTANCE.begin(OtaEngine.INSTANCE.resolveAnyToOta(algorithmId));
    }

    @Override // com.stepos.core.deepbinder.IOtaDeepBinderService
    public void cancelDownload(String algorithmId) {
        g.f(algorithmId, "algorithmId");
        AIEngineLogger.i(LogModule.OTA, this.TAG, "cancelDownload: ".concat(algorithmId));
        String strResolveAnyToOta = OtaEngine.INSTANCE.resolveAnyToOta(algorithmId);
        NotificationCancelSuppressStore.INSTANCE.mark(strResolveAnyToOta);
        new ModelDownloadNotifier(ctx()).dismissForModel(strResolveAnyToOta);
        this.activeClientTags.remove(algorithmId);
        OtaRuntime.INSTANCE.dispatcher().cancel(algorithmId);
    }

    @Override // com.stepos.core.deepbinder.IOtaDeepBinderService
    public int checkResources(String algorithmId) {
        g.f(algorithmId, "algorithmId");
        OtaStateSnapshot otaStateSnapshotSnapshotOf = snapshotOf(algorithmId);
        OtaState state = otaStateSnapshotSnapshotOf != null ? otaStateSnapshotSnapshotOf.getState() : null;
        int iCheckInstallState = ((state instanceof OtaState.Downloading) || (state instanceof OtaState.Paused)) ? 3 : ((state instanceof OtaState.Checking) || (state instanceof OtaState.Verifying) || (state instanceof OtaState.Installing) || (state instanceof OtaState.Activating)) ? 4 : checkInstallState(algorithmId);
        AIEngineLogger.d(LogModule.OTA, this.TAG, com.stepos.core.ota.d.h("checkResources: ", iCheckInstallState, algorithmId, " -> "));
        return iCheckInstallState;
    }

    @Override // com.stepos.core.deepbinder.IOtaDeepBinderService
    public void endInteractiveSession(String algorithmId) {
        g.f(algorithmId, "algorithmId");
        InteractiveSessionRegistry.INSTANCE.end(OtaEngine.INSTANCE.resolveAnyToOta(algorithmId));
    }

    @Override // com.stepos.core.deepbinder.IOtaDeepBinderService
    public void executeDownload(final String algorithmId, final boolean z, final boolean z3) {
        g.f(algorithmId, "algorithmId");
        LogModule logModule = LogModule.OTA;
        String str = this.TAG;
        boolean zHasCTA = hasCTA();
        StringBuilder sbM = com.stepos.core.ota.d.m("executeDownload: ", algorithmId, " cellularAllowed=", " enableWifiAuto=", z);
        sbM.append(z3);
        sbM.append(" hasCta=");
        sbM.append(zHasCTA);
        AIEngineLogger.i(logModule, str, sbM.toString());
        if (CTAPermissionManager.INSTANCE.isModelServiceEnabled()) {
            requireCTA(new CTADialogGate.CtaContinuation() { // from class: com.stepos.core.ota.deepbinder.OtaDeepBinderServiceImpl.executeDownload.3
                @Override // com.stepos.core.cta.CTADialogGate.CtaContinuation
                public boolean getRunsOnMainThread() {
                    return CTADialogGate.CtaContinuation.DefaultImpls.getRunsOnMainThread(this);
                }

                @Override // com.stepos.core.cta.CTADialogGate.CtaContinuation
                public final void onContinue(Context context) {
                    g.f(context, "<unused var>");
                    OtaInteractiveDownloadFlow.INSTANCE.executeConfirmedDownload(algorithmId, z, z3);
                }
            }, new a(algorithmId, this));
            return;
        }
        String strResolveAnyToOta = OtaEngine.INSTANCE.resolveAnyToOta(algorithmId);
        AIEngineLogger.i(logModule, this.TAG, "executeDownload blocked: model service disabled ".concat(algorithmId));
        InteractiveSessionRegistry.INSTANCE.end(strResolveAnyToOta);
        try {
            CallbackSubscriber.emitTransient$default(OtaRuntime.INSTANCE.callbacks(), strResolveAnyToOta, 16, 0, 4, null);
            n nVar = n.f10413a;
        } catch (Throwable th) {
            kotlin.c.a(th);
        }
        try {
            CallbackSubscriber.emitTransient$default(OtaRuntime.INSTANCE.callbacks(), strResolveAnyToOta, 14, 0, 4, null);
            n nVar2 = n.f10413a;
        } catch (Throwable th2) {
            kotlin.c.a(th2);
        }
    }

    @Override // com.stepos.core.deepbinder.IOtaDeepBinderService
    public Bundle fetchDownloadMeta(String algorithmId) {
        g.f(algorithmId, "algorithmId");
        return (Bundle) gateNetworkRead(blockedFetchMeta(algorithmId, false), new c(this, algorithmId, 1));
    }

    @Override // com.stepos.core.deepbinder.IOtaDeepBinderService
    public Bundle fetchUpdateMeta(String algorithmId) {
        g.f(algorithmId, "algorithmId");
        return (Bundle) gateNetworkRead(blockedFetchMeta(algorithmId, true), new a(this, algorithmId));
    }

    @Override // com.stepos.core.deepbinder.IOtaDeepBinderService
    public List<AvailableModelInfo> getAvailableModels() {
        return (List) gateNetworkRead(EmptyList.f10001a, new b(this, 1));
    }

    @Override // com.stepos.core.deepbinder.IOtaDeepBinderService
    public List<AvailableModelInfo> getAvailableModelsForce() {
        return (List) gateNetworkRead(EmptyList.f10001a, new b6.g(this, 7));
    }

    @Override // com.stepos.core.deepbinder.IOtaDeepBinderService
    public int getDownloadProgress(String algorithmId) {
        g.f(algorithmId, "algorithmId");
        OtaStateSnapshot otaStateSnapshotSnapshotOf = snapshotOf(algorithmId);
        if (otaStateSnapshotSnapshotOf != null) {
            return otaStateSnapshotSnapshotOf.getProgress();
        }
        return 0;
    }

    @Override // com.stepos.core.deepbinder.IOtaDeepBinderService
    public int getDownloadStatus(String algorithmId) {
        g.f(algorithmId, "algorithmId");
        if (NotificationCancelSuppressStore.INSTANCE.isSuppressed(OtaEngine.INSTANCE.resolveAnyToOta(algorithmId))) {
            return 0;
        }
        OtaStateSnapshot otaStateSnapshotSnapshotOf = snapshotOf(algorithmId);
        OtaState state = otaStateSnapshotSnapshotOf != null ? otaStateSnapshotSnapshotOf.getState() : null;
        if (state instanceof OtaState.Downloading) {
            return 2;
        }
        if (state instanceof OtaState.Checking) {
            return 1;
        }
        if ((state instanceof OtaState.Verifying) || (state instanceof OtaState.Installing) || (state instanceof OtaState.Activating)) {
            return 5;
        }
        if (state instanceof OtaState.Paused) {
            return 4;
        }
        if (state instanceof OtaState.Installed) {
            return 6;
        }
        if (state instanceof OtaState.Failed) {
            return 3;
        }
        return state instanceof OtaState.Removed ? 7 : 0;
    }

    @Override // com.stepos.core.deepbinder.IOtaDeepBinderService
    public List<AlgorithmModelInfo> getModels(String algorithmId) {
        List listP;
        g.f(algorithmId, "algorithmId");
        OtaEngine otaEngine = OtaEngine.INSTANCE;
        String strResolveAnyToOta = otaEngine.resolveAnyToOta(algorithmId);
        String strBucketDirOf = otaEngine.bucketDirOf(strResolveAnyToOta);
        File file = new File(strBucketDirOf);
        Set setS0 = l.s0(new String[]{ModelDisplayResourceStore.DISPLAY_SUBDIR, ModelDisplayResourceStore.LOCAL_ZIP_NAME});
        if (file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null) {
                ArrayList arrayList = new ArrayList();
                int i10 = 0;
                for (File file2 : fileArrListFiles) {
                    if (!setS0.contains(file2.getName())) {
                        arrayList.add(file2);
                    }
                }
                listP = new ArrayList(m.Z(arrayList, 10));
                int size = arrayList.size();
                while (i10 < size) {
                    Object obj = arrayList.get(i10);
                    i10++;
                    listP.add(((File) obj).getName());
                }
            } else {
                listP = EmptyList.f10001a;
            }
        } else {
            listP = file.exists() ? b1.P(file.getName()) : EmptyList.f10001a;
        }
        return b1.P(new AlgorithmModelInfo(algorithmId, strResolveAnyToOta, OtaBucketLegacy.INSTANCE.effectiveVersion(strResolveAnyToOta), null, strBucketDirOf, listP, null, OtaDeepBinderServiceImplKt.totalBytes(file, setS0), null, null, null, PreInstallModels.INSTANCE.isPreset(strResolveAnyToOta), 1864, null));
    }

    @Override // com.stepos.core.deepbinder.IOtaDeepBinderService
    public List<AvailableModelInfo> getPresetModels() {
        return (List) gateNetworkRead(EmptyList.f10001a, new b(this, 0));
    }

    @Override // com.stepos.core.deepbinder.IOtaDeepBinderService
    public Bundle getUpdateInfo(String algorithmId) {
        g.f(algorithmId, "algorithmId");
        return (Bundle) gateNetworkRead(null, new c(this, algorithmId, 0));
    }

    @Override // com.stepos.core.deepbinder.IOtaDeepBinderService
    public boolean install(String algorithmId) {
        g.f(algorithmId, "algorithmId");
        AIEngineLogger.w(LogModule.OTA, this.TAG, "install: use startDownload() instead");
        return false;
    }

    @Override // com.stepos.deepbinder.core.api.IRecycle
    public void onRecycle() {
        LogModule logModule = LogModule.OTA;
        String str = this.TAG;
        int size = this.activeClientTags.size();
        int size2 = this.callbackIds.size();
        int size3 = this.taskStateCallbackIds.size();
        StringBuilder sbD = h0.e.d(size, "onRecycle: detach ", size2, " tags, clear ", " callbacks, ");
        sbD.append(size3);
        sbD.append(" stateCallbacks");
        AIEngineLogger.i(logModule, str, sbD.toString());
        for (Map.Entry<String, String> entry : this.activeClientTags.entrySet()) {
            String key = entry.getKey();
            try {
                OtaRuntime.INSTANCE.dispatcher().detach(key, entry.getValue());
            } catch (Throwable th) {
                kotlin.c.a(th);
            }
            try {
                OtaInteractiveDownloadFlow.INSTANCE.cancelPendingConfirm(key);
                n nVar = n.f10413a;
            } catch (Throwable th2) {
                kotlin.c.a(th2);
            }
        }
        this.activeClientTags.clear();
        this.callbackIds.clear();
        Collection<String> collectionValues = this.taskStateCallbackIds.values();
        g.e(collectionValues, "<get-values>(...)");
        for (String str2 : collectionValues) {
            OtaTaskStateBroadcaster otaTaskStateBroadcaster = OtaTaskStateBroadcaster.INSTANCE;
            g.c(str2);
            otaTaskStateBroadcaster.unregister(str2);
        }
        this.taskStateCallbackIds.clear();
    }

    @Override // com.stepos.core.deepbinder.IOtaDeepBinderService
    public void pauseDownload(String algorithmId) {
        g.f(algorithmId, "algorithmId");
        AIEngineLogger.i(LogModule.OTA, this.TAG, "pauseDownload: ".concat(algorithmId));
        OtaDispatcher.DefaultImpls.pause$default(OtaRuntime.INSTANCE.dispatcher(), algorithmId, null, 2, null);
    }

    @Override // com.stepos.core.deepbinder.IOtaDeepBinderService
    public Bundle queryDownloadMeta(String algorithmId) {
        String strLocalizedUpdateInfo;
        g.f(algorithmId, "algorithmId");
        String strResolveAnyToOta = OtaEngine.INSTANCE.resolveAnyToOta(algorithmId);
        boolean zIsInstalled$default = isInstalled$default(this, algorithmId, strResolveAnyToOta, false, 4, null);
        boolean zIsSuppressed = NotificationCancelSuppressStore.INSTANCE.isSuppressed(strResolveAnyToOta);
        int iEffectiveVersion = OtaBucketLegacy.INSTANCE.effectiveVersion(strResolveAnyToOta);
        OtaRemoteModel otaRemoteModelRemoteIfCtaGranted = remoteIfCtaGranted(strResolveAnyToOta);
        boolean z = zIsInstalled$default && otaRemoteModelRemoteIfCtaGranted != null && iEffectiveVersion < otaRemoteModelRemoteIfCtaGranted.getVersion_code();
        Bundle bundle = new Bundle();
        bundle.putBoolean(ModelFlowMeta.KEY_INSTALLED, zIsInstalled$default);
        bundle.putBoolean(ModelFlowMeta.KEY_ACTIVE, !zIsSuppressed && isRealTaskActive(algorithmId));
        bundle.putBoolean(ModelFlowMeta.KEY_CAN_UPDATE, z);
        bundle.putLong("sizeBytes", otaRemoteModelRemoteIfCtaGranted != null ? otaRemoteModelRemoteIfCtaGranted.getFile_size() : 0L);
        if (otaRemoteModelRemoteIfCtaGranted == null || (strLocalizedUpdateInfo = UpdateInfoI18nKt.localizedUpdateInfo(otaRemoteModelRemoteIfCtaGranted, ctx())) == null) {
            strLocalizedUpdateInfo = "";
        }
        bundle.putString("updateInfo", strLocalizedUpdateInfo);
        bundle.putString("plan", downloadPlanString());
        bundle.putString("modelLabel", resolveModelLabel(strResolveAnyToOta));
        OtaStateSnapshot otaStateSnapshotSnapshotOf = snapshotOf(strResolveAnyToOta);
        bundle.putBoolean(ModelFlowMeta.KEY_CELLULAR_ALLOWED, otaStateSnapshotSnapshotOf != null ? otaStateSnapshotSnapshotOf.getCellularAllowed() : false);
        return bundle;
    }

    @Override // com.stepos.core.deepbinder.IOtaDeepBinderService
    public Bundle queryDownloadResourceGate(long j10) {
        Object objA;
        Context contextCtx = ctx();
        if (!CTAPermissionManager.INSTANCE.isModelServiceEnabled()) {
            AIEngineLogger.i(LogModule.OTA, this.TAG, "queryDownloadResourceGate: model service disabled → SERVICE_DISABLED");
            Bundle bundle = new Bundle();
            bundle.putBoolean(ModelFlowMeta.KEY_GATE_OK, false);
            bundle.putInt(ModelFlowMeta.KEY_GATE_ERROR, ModelFlowMeta.GATE_ERROR_SERVICE_DISABLED);
            return bundle;
        }
        try {
            objA = Long.valueOf(new StatFs(contextCtx.getFilesDir().getAbsolutePath()).getAvailableBytes());
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        if (objA instanceof Result.Failure) {
            objA = 0L;
        }
        long jLongValue = ((Number) objA).longValue();
        AutoUpdateEnv autoUpdateEnv = AutoUpdateEnv.INSTANCE;
        int iBatteryPct = autoUpdateEnv.batteryPct(contextCtx);
        boolean zIsCharging = autoUpdateEnv.isCharging(contextCtx);
        DownloadResourceGate downloadResourceGate = DownloadResourceGate.INSTANCE;
        DownloadResourceGate.Verdict verdictEvaluate = downloadResourceGate.evaluate(jLongValue, j10, iBatteryPct, zIsCharging);
        int iErrorCode = downloadResourceGate.errorCode(verdictEvaluate);
        LogModule logModule = LogModule.OTA;
        String str = this.TAG;
        StringBuilder sbQ = ai.onnxruntime.a.q(j10, "queryDownloadResourceGate: required=", "B avail=");
        sbQ.append(jLongValue);
        sbQ.append("B bat=");
        sbQ.append(iBatteryPct);
        sbQ.append("% charging=");
        sbQ.append(zIsCharging);
        sbQ.append(" verdict=");
        sbQ.append(verdictEvaluate);
        AIEngineLogger.i(logModule, str, sbQ.toString());
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean(ModelFlowMeta.KEY_GATE_OK, verdictEvaluate == DownloadResourceGate.Verdict.OK);
        bundle2.putInt(ModelFlowMeta.KEY_GATE_ERROR, iErrorCode);
        return bundle2;
    }

    @Override // com.stepos.core.deepbinder.IOtaDeepBinderService
    public int queryNoNetworkPromptState(String algorithmId) {
        g.f(algorithmId, "algorithmId");
        String strResolveAnyToOta = OtaEngine.INSTANCE.resolveAnyToOta(algorithmId);
        Object systemService = ctx().getSystemService("keyguard");
        KeyguardManager keyguardManager = systemService instanceof KeyguardManager ? (KeyguardManager) systemService : null;
        int i10 = 1;
        if (keyguardManager != null && keyguardManager.isKeyguardLocked()) {
            AIEngineLogger.i(LogModule.OTA, this.TAG, "noNetPrompt SUPPRESSED(keyguard): ".concat(algorithmId));
            return 3;
        }
        int iRecentDecision = NoNetworkPromptStore.INSTANCE.recentDecision(strResolveAnyToOta, System.currentTimeMillis());
        if (iRecentDecision != 1) {
            i10 = 2;
            if (iRecentDecision != 2) {
                i10 = 0;
            }
        }
        AIEngineLogger.i(LogModule.OTA, this.TAG, com.stepos.core.ota.d.h("noNetPromptState: ", i10, algorithmId, " -> "));
        return i10;
    }

    @Override // com.stepos.core.deepbinder.IOtaDeepBinderService
    public Bundle queryPrecheckEnv() {
        DownloadConfirmPlanner.Plan planPlanFor = DownloadConfirmPlanner.INSTANCE.planFor(ctx());
        boolean z = planPlanFor != DownloadConfirmPlanner.Plan.NO_NETWORK;
        boolean z3 = planPlanFor == DownloadConfirmPlanner.Plan.CONFIRM_ONLY;
        boolean zIsModelServiceEnabled = CTAPermissionManager.INSTANCE.isModelServiceEnabled();
        int i10 = !zIsModelServiceEnabled ? ModelFlowMeta.GATE_ERROR_SERVICE_DISABLED : !z ? ModelFlowMeta.ENV_ERROR_NO_NETWORK : 0;
        Bundle bundle = new Bundle();
        bundle.putBoolean(ModelFlowMeta.KEY_HAS_NETWORK, z);
        bundle.putBoolean(ModelFlowMeta.KEY_IS_WIFI, z3);
        bundle.putBoolean(ModelFlowMeta.KEY_ENV_OK, i10 == 0);
        bundle.putInt(ModelFlowMeta.KEY_ENV_ERROR, i10);
        bundle.putBoolean(ModelFlowMeta.KEY_SERVICE_ENABLED, zIsModelServiceEnabled);
        return bundle;
    }

    @Override // com.stepos.core.deepbinder.IOtaDeepBinderService
    public Bundle queryUpdateMeta(String algorithmId) {
        String strLocalizedUpdateInfo;
        g.f(algorithmId, "algorithmId");
        String strResolveAnyToOta = OtaEngine.INSTANCE.resolveAnyToOta(algorithmId);
        boolean zIsInstalled = isInstalled(algorithmId, strResolveAnyToOta, true);
        boolean zIsSuppressed = NotificationCancelSuppressStore.INSTANCE.isSuppressed(strResolveAnyToOta);
        int iEffectiveVersion = OtaBucketLegacy.INSTANCE.effectiveVersion(strResolveAnyToOta);
        OtaRemoteModel otaRemoteModelRemoteIfCtaGranted = remoteIfCtaGranted(strResolveAnyToOta);
        boolean z = zIsInstalled && otaRemoteModelRemoteIfCtaGranted != null && iEffectiveVersion < otaRemoteModelRemoteIfCtaGranted.getVersion_code();
        Bundle bundle = new Bundle();
        bundle.putBoolean(ModelFlowMeta.KEY_INSTALLED, zIsInstalled);
        bundle.putBoolean(ModelFlowMeta.KEY_ACTIVE, !zIsSuppressed && isRealTaskActive(algorithmId));
        bundle.putBoolean(ModelFlowMeta.KEY_HAS_UPDATE, z);
        bundle.putLong("sizeBytes", otaRemoteModelRemoteIfCtaGranted != null ? otaRemoteModelRemoteIfCtaGranted.getFile_size() : 0L);
        if (otaRemoteModelRemoteIfCtaGranted == null || (strLocalizedUpdateInfo = UpdateInfoI18nKt.localizedUpdateInfo(otaRemoteModelRemoteIfCtaGranted, ctx())) == null) {
            strLocalizedUpdateInfo = "";
        }
        bundle.putString("updateInfo", strLocalizedUpdateInfo);
        bundle.putString("plan", updatePlanString());
        bundle.putString("modelLabel", resolveModelLabel(strResolveAnyToOta));
        OtaStateSnapshot otaStateSnapshotSnapshotOf = snapshotOf(strResolveAnyToOta);
        bundle.putBoolean(ModelFlowMeta.KEY_CELLULAR_ALLOWED, otaStateSnapshotSnapshotOf != null ? otaStateSnapshotSnapshotOf.getCellularAllowed() : false);
        return bundle;
    }

    @Override // com.stepos.core.deepbinder.IOtaDeepBinderService
    public void recordNoNetworkDownloadDecision(String algorithmId, boolean z) {
        g.f(algorithmId, "algorithmId");
        String strResolveAnyToOta = OtaEngine.INSTANCE.resolveAnyToOta(algorithmId);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!z) {
            NoNetworkPromptStore.INSTANCE.recordDecision(strResolveAnyToOta, 1, jCurrentTimeMillis);
            AIEngineLogger.i(LogModule.OTA, this.TAG, ai.onnxruntime.a.l("noNetDecision DECLINED: ", algorithmId, " ota=", strResolveAnyToOta));
            return;
        }
        NoNetworkPromptStore.INSTANCE.recordDecision(strResolveAnyToOta, 2, jCurrentTimeMillis);
        OtaRemoteModel otaRemoteModel = RemoteModelsRepository.get(strResolveAnyToOta);
        PendingAutoUpdateStore.INSTANCE.put(new PendingAutoUpdateStore.Record(strResolveAnyToOta, otaRemoteModel != null ? otaRemoteModel.getVersion_code() : 0, false, otaRemoteModel != null ? otaRemoteModel.getFile_size() : 0L, null, jCurrentTimeMillis, true));
        try {
            ModelUpdateConditionManager.INSTANCE.refresh();
            n nVar = n.f10413a;
        } catch (Throwable th) {
            kotlin.c.a(th);
        }
        AIEngineLogger.i(LogModule.OTA, this.TAG, ai.onnxruntime.a.l("noNetDecision SCHEDULED deferred download: ", algorithmId, " ota=", strResolveAnyToOta));
    }

    @Override // com.stepos.core.deepbinder.IOtaDeepBinderService
    public void registerDownloadCallback(String algorithmId, IDownloadCallback callback) {
        String strPutIfAbsent;
        g.f(algorithmId, "algorithmId");
        g.f(callback, "callback");
        ConcurrentHashMap<IDownloadCallback, String> concurrentHashMap = this.callbackIds;
        String strValueOf = concurrentHashMap.get(callback);
        if (strValueOf == null && (strPutIfAbsent = concurrentHashMap.putIfAbsent(callback, (strValueOf = String.valueOf(System.identityHashCode(callback))))) != null) {
            strValueOf = strPutIfAbsent;
        }
        String str = strValueOf;
        AIEngineLogger.d(LogModule.OTA, this.TAG, ai.onnxruntime.a.l("registerDownloadCallback: ", algorithmId, " id=", str));
        CallbackSubscriber callbackSubscriberCallbacks = OtaRuntime.INSTANCE.callbacks();
        String strResolveAnyToOta = OtaEngine.INSTANCE.resolveAnyToOta(algorithmId);
        g.c(str);
        callbackSubscriberCallbacks.register(strResolveAnyToOta, str, callback);
    }

    @Override // com.stepos.core.deepbinder.IOtaDeepBinderService
    public void registerTaskStateCallback(IOtaTaskStateCallback callback) {
        String strPutIfAbsent;
        g.f(callback, "callback");
        ConcurrentHashMap<IOtaTaskStateCallback, String> concurrentHashMap = this.taskStateCallbackIds;
        String strValueOf = concurrentHashMap.get(callback);
        if (strValueOf == null && (strPutIfAbsent = concurrentHashMap.putIfAbsent(callback, (strValueOf = String.valueOf(System.identityHashCode(callback))))) != null) {
            strValueOf = strPutIfAbsent;
        }
        String str = strValueOf;
        AIEngineLogger.d(LogModule.OTA, this.TAG, "registerTaskStateCallback: id=" + str);
        OtaTaskStateBroadcaster otaTaskStateBroadcaster = OtaTaskStateBroadcaster.INSTANCE;
        g.c(str);
        otaTaskStateBroadcaster.register(str, callback);
    }

    @Override // com.stepos.core.deepbinder.IOtaDeepBinderService
    public void requestCta(String algorithmId, final ICtaResultCallback callback) {
        g.f(algorithmId, "algorithmId");
        g.f(callback, "callback");
        AIEngineLogger.i(LogModule.OTA, this.TAG, "requestCta: " + algorithmId + " hasCta=" + hasCTA());
        requireCTA(new CTADialogGate.CtaContinuation() { // from class: com.stepos.core.ota.deepbinder.OtaDeepBinderServiceImpl.requestCta.1
            @Override // com.stepos.core.cta.CTADialogGate.CtaContinuation
            public boolean getRunsOnMainThread() {
                return CTADialogGate.CtaContinuation.DefaultImpls.getRunsOnMainThread(this);
            }

            @Override // com.stepos.core.cta.CTADialogGate.CtaContinuation
            public final void onContinue(Context context) {
                g.f(context, "<unused var>");
                try {
                    callback.onResult(true);
                    n nVar = n.f10413a;
                } catch (Throwable th) {
                    kotlin.c.a(th);
                }
            }
        }, new cb.d(10, this, callback));
    }

    @Override // com.stepos.core.deepbinder.IOtaDeepBinderService
    public boolean reset(String algorithmId) {
        g.f(algorithmId, "algorithmId");
        return uninstall(algorithmId);
    }

    @Override // com.stepos.core.deepbinder.IOtaDeepBinderService
    public void resumeDownload(final String algorithmId) {
        String str;
        g.f(algorithmId, "algorithmId");
        int iCallingUid = callingUid();
        String[] packagesForUid = ctx().getPackageManager().getPackagesForUid(iCallingUid);
        if (packagesForUid == null || (str = (String) l.e0(packagesForUid)) == null) {
            str = "?";
        }
        LogModule logModule = LogModule.OTA;
        String str2 = this.TAG;
        boolean zHasCTA = hasCTA();
        StringBuilder sbF = h0.e.f("resumeDownload: algo=", algorithmId, " uid=", iCallingUid, " pkg=");
        sbF.append(str);
        sbF.append(" hasCta=");
        sbF.append(zHasCTA);
        AIEngineLogger.i(logModule, str2, sbF.toString());
        if (OtaInteractiveDownloadFlow.INSTANCE.ensureServiceEnabledOrPrompt(algorithmId)) {
            requireCTA$default(this, new CTADialogGate.CtaContinuation() { // from class: com.stepos.core.ota.deepbinder.OtaDeepBinderServiceImpl.resumeDownload.1
                @Override // com.stepos.core.cta.CTADialogGate.CtaContinuation
                public boolean getRunsOnMainThread() {
                    return CTADialogGate.CtaContinuation.DefaultImpls.getRunsOnMainThread(this);
                }

                @Override // com.stepos.core.cta.CTADialogGate.CtaContinuation
                public final void onContinue(Context context) {
                    g.f(context, "<unused var>");
                    OtaRuntime.INSTANCE.dispatcher().resume(algorithmId, TriggerSource.USER);
                }
            }, null, 2, null);
        }
    }

    @Override // com.stepos.core.deepbinder.IOtaDeepBinderService
    public void setWlanAutoUpgrade(boolean z) {
        AIEngineLogger.i(LogModule.OTA, this.TAG, "setWlanAutoUpgrade: " + z);
        CTAPermissionManager.INSTANCE.setWlanAutoUpgrade(z);
    }

    @Override // com.stepos.core.deepbinder.IOtaDeepBinderService
    public void startDownload(String algorithmId) {
        String str;
        g.f(algorithmId, "algorithmId");
        int iCallingUid = callingUid();
        String[] packagesForUid = ctx().getPackageManager().getPackagesForUid(iCallingUid);
        if (packagesForUid == null || (str = (String) l.e0(packagesForUid)) == null) {
            str = "?";
        }
        LogModule logModule = LogModule.OTA;
        String str2 = this.TAG;
        boolean zHasCTA = hasCTA();
        StringBuilder sbF = h0.e.f("startDownload: algo=", algorithmId, " uid=", iCallingUid, " pkg=");
        sbF.append(str);
        sbF.append(" hasCta=");
        sbF.append(zHasCTA);
        AIEngineLogger.i(logModule, str2, sbF.toString());
        OtaInteractiveDownloadFlow.INSTANCE.requestStartDownload(algorithmId, iCallingUid);
    }

    @Override // com.stepos.core.deepbinder.IOtaDeepBinderService
    public void startUpdate(String algorithmId) {
        g.f(algorithmId, "algorithmId");
        OtaInteractiveDownloadFlow.INSTANCE.requestStartUpdate(algorithmId, callingUid());
    }

    @Override // com.stepos.core.deepbinder.IOtaDeepBinderService
    public void triggerCheckUpdate(final String algorithmId) throws ExecutionException, InterruptedException, TimeoutException {
        g.f(algorithmId, "algorithmId");
        if (hasCTA()) {
            triggerCheckUpdateBlocking(algorithmId);
        } else {
            requireCTA$default(this, new CTADialogGate.CtaContinuation() { // from class: com.stepos.core.ota.deepbinder.OtaDeepBinderServiceImpl.triggerCheckUpdate.1
                @Override // com.stepos.core.cta.CTADialogGate.CtaContinuation
                public boolean getRunsOnMainThread() {
                    return CTADialogGate.CtaContinuation.DefaultImpls.getRunsOnMainThread(this);
                }

                @Override // com.stepos.core.cta.CTADialogGate.CtaContinuation
                public final void onContinue(Context context) {
                    g.f(context, "<unused var>");
                    OtaDeepBinderServiceImpl.this.triggerCheckUpdateAsync(algorithmId);
                }
            }, null, 2, null);
        }
    }

    @Override // com.stepos.core.deepbinder.IOtaDeepBinderService
    public boolean uninstall(String algorithmId) {
        g.f(algorithmId, "algorithmId");
        return ModelUninstaller.INSTANCE.uninstall(ctx(), algorithmId);
    }

    @Override // com.stepos.core.deepbinder.IOtaDeepBinderService
    public void unregisterDownloadCallback(String algorithmId, IDownloadCallback callback) {
        g.f(algorithmId, "algorithmId");
        g.f(callback, "callback");
        String strRemove = this.callbackIds.remove(callback);
        if (strRemove == null) {
            return;
        }
        AIEngineLogger.d(LogModule.OTA, this.TAG, ai.onnxruntime.a.l("unregisterDownloadCallback: ", algorithmId, " id=", strRemove));
        OtaRuntime.INSTANCE.callbacks().unregister(OtaEngine.INSTANCE.resolveAnyToOta(algorithmId), strRemove);
    }

    @Override // com.stepos.core.deepbinder.IOtaDeepBinderService
    public void unregisterTaskStateCallback(IOtaTaskStateCallback callback) {
        g.f(callback, "callback");
        String strRemove = this.taskStateCallbackIds.remove(callback);
        if (strRemove == null) {
            return;
        }
        AIEngineLogger.d(LogModule.OTA, this.TAG, "unregisterTaskStateCallback: id=".concat(strRemove));
        OtaTaskStateBroadcaster.INSTANCE.unregister(strRemove);
    }
}
