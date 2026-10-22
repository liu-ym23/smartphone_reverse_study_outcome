package com.stepos.core.ota.deepbinder;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.StatFs;
import android.widget.Toast;
import androidx.datastore.preferences.protobuf.b1;
import com.stepos.core.ability.speech.z;
import com.stepos.core.common.R;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.common.util.TraceIdKeys;
import com.stepos.core.cta.CTADialogGate;
import com.stepos.core.cta.CTAPermissionManager;
import com.stepos.core.download.ModelFlowMeta;
import com.stepos.core.ota.OtaDispatcher;
import com.stepos.core.ota.OtaEngine;
import com.stepos.core.ota.bridge.CallbackSubscriber;
import com.stepos.core.ota.confirm.DownloadConfirmPlanner;
import com.stepos.core.ota.confirm.InteractiveSessionRegistry;
import com.stepos.core.ota.confirm.UpdateConfirmPlanner;
import com.stepos.core.ota.confirmui.ConfirmDecisionBus;
import com.stepos.core.ota.confirmui.OtaConfirmTrampolineActivity;
import com.stepos.core.ota.data.OtaRemoteModel;
import com.stepos.core.ota.data.UpdateInfoI18nKt;
import com.stepos.core.ota.deepbinder.DownloadResourceGate;
import com.stepos.core.ota.display.ModelDisplayLookup;
import com.stepos.core.ota.display.ModelLabelResolver;
import com.stepos.core.ota.domain.OtaState;
import com.stepos.core.ota.domain.OtaStateSnapshot;
import com.stepos.core.ota.domain.TriggerSource;
import com.stepos.core.ota.install.InstalledPathResolver;
import com.stepos.core.ota.install.OtaBucketLegacy;
import com.stepos.core.ota.process.OtaProcess;
import com.stepos.core.ota.process.OtaRuntime;
import com.stepos.core.ota.push.AutoUpdateEnv;
import com.stepos.core.ota.remote.RemoteModelsRepository;
import gc.q;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.jvm.internal.g;
import lb.n;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class OtaInteractiveDownloadFlow {
    private static final long CTA_TO_CONFIRM_DELAY_MS = 350;
    private static final String TAG = "OtaInteractiveDlFlow";
    private static volatile String lastCtaDownloadAlgorithmId;
    public static final OtaInteractiveDownloadFlow INSTANCE = new OtaInteractiveDownloadFlow();
    private static final ConcurrentHashMap.KeySetView<String, Boolean> pendingDownloads = ConcurrentHashMap.newKeySet();
    private static final ConcurrentHashMap.KeySetView<String, Boolean> pendingUpdates = ConcurrentHashMap.newKeySet();
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());
    private static final ConcurrentHashMap<String, String> pendingConfirmReqIds = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, Runnable> pendingConfirmRunnables = new ConcurrentHashMap<>();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class DownloadSkipReason {
        private static final /* synthetic */ sb.a $ENTRIES;
        private static final /* synthetic */ DownloadSkipReason[] $VALUES;
        public static final DownloadSkipReason TASK_ACTIVE = new DownloadSkipReason("TASK_ACTIVE", 0);
        public static final DownloadSkipReason ALREADY_UP_TO_DATE = new DownloadSkipReason("ALREADY_UP_TO_DATE", 1);

        private static final /* synthetic */ DownloadSkipReason[] $values() {
            return new DownloadSkipReason[]{TASK_ACTIVE, ALREADY_UP_TO_DATE};
        }

        static {
            DownloadSkipReason[] downloadSkipReasonArr$values = $values();
            $VALUES = downloadSkipReasonArr$values;
            $ENTRIES = kotlin.enums.a.a(downloadSkipReasonArr$values);
        }

        private DownloadSkipReason(String str, int i10) {
        }

        public static sb.a<DownloadSkipReason> getEntries() {
            return $ENTRIES;
        }

        public static DownloadSkipReason valueOf(String str) {
            return (DownloadSkipReason) Enum.valueOf(DownloadSkipReason.class, str);
        }

        public static DownloadSkipReason[] values() {
            return (DownloadSkipReason[]) $VALUES.clone();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;

        static {
            int[] iArr = new int[DownloadSkipReason.values().length];
            try {
                iArr[DownloadSkipReason.TASK_ACTIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DownloadSkipReason.ALREADY_UP_TO_DATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[DownloadConfirmPlanner.Plan.values().length];
            try {
                iArr2[DownloadConfirmPlanner.Plan.CONFIRM_ONLY.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[DownloadConfirmPlanner.Plan.CONFIRM_THEN_CELLULAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[DownloadConfirmPlanner.Plan.NO_NETWORK.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[UpdateConfirmPlanner.UpdatePlan.values().length];
            try {
                iArr3[UpdateConfirmPlanner.UpdatePlan.WIFI_AUTO_ON.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr3[UpdateConfirmPlanner.UpdatePlan.WIFI_AUTO_OFF.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr3[UpdateConfirmPlanner.UpdatePlan.CELLULAR_AUTO_ON.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr3[UpdateConfirmPlanner.UpdatePlan.CELLULAR_AUTO_OFF.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[UpdateConfirmPlanner.UpdatePlan.NO_NETWORK.ordinal()] = 5;
            } catch (NoSuchFieldError unused10) {
            }
            $EnumSwitchMapping$2 = iArr3;
            int[] iArr4 = new int[ConfirmDecisionBus.Decision.values().length];
            try {
                iArr4[ConfirmDecisionBus.Decision.CONFIRM.ordinal()] = 1;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr4[ConfirmDecisionBus.Decision.CONFIRM_CELLULAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr4[ConfirmDecisionBus.Decision.ENABLE_WIFI_AUTO_AND_UPDATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr4[ConfirmDecisionBus.Decision.ENABLE_WIFI_AUTO_ONLY.ordinal()] = 4;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr4[ConfirmDecisionBus.Decision.CANCEL.ordinal()] = 5;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr4[ConfirmDecisionBus.Decision.SCHEDULE_WIFI_DOWNLOAD.ordinal()] = 6;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr4[ConfirmDecisionBus.Decision.OPEN_SERVICE_SETTINGS.ordinal()] = 7;
            } catch (NoSuchFieldError unused17) {
            }
            $EnumSwitchMapping$3 = iArr4;
        }
    }

    private OtaInteractiveDownloadFlow() {
    }

    private final Context appContext() {
        return OtaEngine.INSTANCE.getAppContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void continueAfterCtaIfNeeded$lambda$11(List list, Context context) {
        if (INSTANCE.hasPending()) {
            AIEngineLogger.d(LogModule.OTA, TAG, "continueAfterCtaIfNeeded: skip, pending already set");
            CTADialogGate.INSTANCE.clearContinueAlgorithmIds();
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!q.t0((String) obj)) {
                arrayList.add(obj);
            }
        }
        List<String> listO0 = kotlin.collections.a.o0(arrayList);
        if (listO0.isEmpty()) {
            CTADialogGate.INSTANCE.clearContinueAlgorithmIds();
            return;
        }
        AIEngineLogger.i(LogModule.OTA, TAG, "continueAfterCtaIfNeeded: recover ids=" + listO0);
        Context contextApplicationContext = CTADialogGate.INSTANCE.applicationContext();
        if (contextApplicationContext == null) {
            contextApplicationContext = context.getApplicationContext();
        }
        for (String str : listO0) {
            OtaInteractiveDownloadFlow otaInteractiveDownloadFlow = INSTANCE;
            g.c(contextApplicationContext);
            otaInteractiveDownloadFlow.showDownloadConfirm(str, contextApplicationContext);
        }
        CTADialogGate.INSTANCE.clearContinueAlgorithmIds();
        lastCtaDownloadAlgorithmId = null;
    }

    private final void doStartDownload(String str, String str2, TriggerSource triggerSource, boolean z, boolean z3, boolean z10) {
        if (!z10) {
            DownloadSkipReason downloadSkipReasonResolveStartUpdateSkip = z3 ? resolveStartUpdateSkip(str, str2) : resolveStartDownloadSkip(str, str2);
            if ((downloadSkipReasonResolveStartUpdateSkip == null ? -1 : WhenMappings.$EnumSwitchMapping$0[downloadSkipReasonResolveStartUpdateSkip.ordinal()]) != -1) {
                notifyDownloadSkip(str, str2, downloadSkipReasonResolveStartUpdateSkip, "doStartDownload");
                return;
            }
        }
        String strK = ai.onnxruntime.a.k("binder:", str);
        LogModule logModule = LogModule.OTA;
        AIEngineLogger.i(logModule, TAG, "doStartDownload: " + str + " trigger=" + triggerSource + " cellularAllowed=" + z);
        if (OtaDispatcher.DefaultImpls.download$default(OtaRuntime.INSTANCE.dispatcher(), str, triggerSource, strK, null, z, 8, null)) {
            return;
        }
        ai.onnxruntime.a.w("doStartDownload not enqueued: ", str, logModule, TAG);
    }

    public static /* synthetic */ void doStartDownload$default(OtaInteractiveDownloadFlow otaInteractiveDownloadFlow, String str, String str2, TriggerSource triggerSource, boolean z, boolean z3, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            triggerSource = TriggerSource.USER;
        }
        otaInteractiveDownloadFlow.doStartDownload(str, str2, triggerSource, (i10 & 8) != 0 ? false : z, (i10 & 16) != 0 ? false : z3, (i10 & 32) != 0 ? false : z10);
    }

    private final void drainPending(Context context) {
        ConcurrentHashMap.KeySetView<String, Boolean> pendingDownloads2 = pendingDownloads;
        g.e(pendingDownloads2, "pendingDownloads");
        List<String> listO0 = kotlin.collections.a.O0(pendingDownloads2);
        pendingDownloads2.clear();
        ConcurrentHashMap.KeySetView<String, Boolean> pendingUpdates2 = pendingUpdates;
        g.e(pendingUpdates2, "pendingUpdates");
        List<String> listO02 = kotlin.collections.a.O0(pendingUpdates2);
        pendingUpdates2.clear();
        if (listO0.isEmpty() && lastCtaDownloadAlgorithmId != null) {
            String str = lastCtaDownloadAlgorithmId;
            g.c(str);
            listO0 = b1.P(str);
            lastCtaDownloadAlgorithmId = null;
            AIEngineLogger.w(LogModule.OTA, TAG, "drainPending: recovered from lastCtaDownload ids=" + listO0);
        }
        if (listO0.isEmpty() && listO02.isEmpty()) {
            AIEngineLogger.w(LogModule.OTA, TAG, "drainPending: empty queue");
            return;
        }
        AIEngineLogger.i(LogModule.OTA, TAG, "drainPending: downloads=" + listO0 + " updates=" + listO02);
        Context contextApplicationContext = CTADialogGate.INSTANCE.applicationContext();
        if (contextApplicationContext == null) {
            contextApplicationContext = context.getApplicationContext();
        }
        for (String str2 : listO0) {
            OtaInteractiveDownloadFlow otaInteractiveDownloadFlow = INSTANCE;
            g.c(str2);
            g.c(contextApplicationContext);
            otaInteractiveDownloadFlow.showDownloadConfirm(str2, contextApplicationContext);
        }
        for (String str3 : listO02) {
            OtaInteractiveDownloadFlow otaInteractiveDownloadFlow2 = INSTANCE;
            g.c(str3);
            g.c(contextApplicationContext);
            otaInteractiveDownloadFlow2.showUpdateConfirm(str3, contextApplicationContext);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void emitCtaRejected(java.lang.String r7) {
        /*
            r6 = this;
            com.stepos.core.ota.process.OtaRuntime r6 = com.stepos.core.ota.process.OtaRuntime.INSTANCE     // Catch: java.lang.Throwable -> L15
            com.stepos.core.ota.bridge.CallbackSubscriber r0 = r6.callbacks()     // Catch: java.lang.Throwable -> L15
            r4 = 4
            r5 = 0
            r2 = 14
            r3 = 0
            r1 = r7
            com.stepos.core.ota.bridge.CallbackSubscriber.emitTransient$default(r0, r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L12
            lb.n r6 = lb.n.f10413a     // Catch: java.lang.Throwable -> L12
            goto L1c
        L12:
            r0 = move-exception
        L13:
            r6 = r0
            goto L18
        L15:
            r0 = move-exception
            r1 = r7
            goto L13
        L18:
            kotlin.Result$Failure r6 = kotlin.c.a(r6)
        L1c:
            java.lang.Throwable r6 = kotlin.Result.b(r6)
            if (r6 == 0) goto L33
            com.stepos.core.common.log.LogModule r7 = com.stepos.core.common.log.LogModule.OTA
            java.lang.String r0 = "emitCtaRejected failed otaId="
            java.lang.String r0 = ai.onnxruntime.a.k(r0, r1)
            java.lang.Object[] r6 = new java.lang.Object[]{r0, r6}
            java.lang.String r0 = "OtaInteractiveDlFlow"
            com.stepos.core.common.log.AIEngineLogger.w(r7, r0, r6)
        L33:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.deepbinder.OtaInteractiveDownloadFlow.emitCtaRejected(java.lang.String):void");
    }

    private final void emitGateBlocked(String str, int i10, int i11) {
        String str2;
        try {
            str2 = str;
            try {
                CallbackSubscriber.emitTransient$default(OtaRuntime.INSTANCE.callbacks(), str2, i10, 0, 4, null);
                n nVar = n.f10413a;
            } catch (Throwable th) {
                th = th;
                kotlin.c.a(th);
                CallbackSubscriber.emitTransient$default(OtaRuntime.INSTANCE.callbacks(), str2, i11, 0, 4, null);
                n nVar2 = n.f10413a;
            }
        } catch (Throwable th2) {
            th = th2;
            str2 = str;
        }
        try {
            CallbackSubscriber.emitTransient$default(OtaRuntime.INSTANCE.callbacks(), str2, i11, 0, 4, null);
            n nVar22 = n.f10413a;
        } catch (Throwable th3) {
            kotlin.c.a(th3);
        }
    }

    private final boolean ensureServiceEnabled(String str, String str2) {
        if (CTAPermissionManager.INSTANCE.isModelServiceEnabled()) {
            return true;
        }
        rejectServiceDisabled(str, str2);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void flushAfterCta$lambda$8(Context context) {
        INSTANCE.drainPending(context);
    }

    private final void handleBusDownloadDecision(String str, String str2, ConfirmDecisionBus.Decision decision) {
        int i10 = WhenMappings.$EnumSwitchMapping$3[decision.ordinal()];
        if (i10 != 1 && i10 != 2) {
            try {
                CallbackSubscriber.emitTransient$default(OtaRuntime.INSTANCE.callbacks(), str2, 15, 0, 4, null);
                n nVar = n.f10413a;
                return;
            } catch (Throwable th) {
                kotlin.c.a(th);
                return;
            }
        }
        if (passResourceGateOrPrompt(str, str2)) {
            try {
                CallbackSubscriber.emitTransient$default(OtaRuntime.INSTANCE.callbacks(), str2, 13, 0, 4, null);
                n nVar2 = n.f10413a;
            } catch (Throwable th2) {
                kotlin.c.a(th2);
            }
            doStartDownload$default(this, str, str2, null, decision == ConfirmDecisionBus.Decision.CONFIRM_CELLULAR, false, true, 20, null);
        }
    }

    private final void handleBusUpdateDecision(String str, String str2, ConfirmDecisionBus.Decision decision) {
        String str3;
        switch (WhenMappings.$EnumSwitchMapping$3[decision.ordinal()]) {
            case 1:
            case 2:
                boolean z = true;
                if (passResourceGateOrPrompt(str, str2)) {
                    try {
                        CallbackSubscriber.emitTransient$default(OtaRuntime.INSTANCE.callbacks(), str2, 13, 0, 4, null);
                        n nVar = n.f10413a;
                    } catch (Throwable th) {
                        kotlin.c.a(th);
                    }
                    if (decision != ConfirmDecisionBus.Decision.CONFIRM_CELLULAR) {
                        z = false;
                    }
                    doStartDownload$default(this, str, str2, null, z, true, true, 4, null);
                    return;
                }
                return;
            case 3:
                CTAPermissionManager.INSTANCE.setWlanAutoUpgrade(true);
                if (passResourceGateOrPrompt(str, str2)) {
                    try {
                        str3 = str2;
                        try {
                            CallbackSubscriber.emitTransient$default(OtaRuntime.INSTANCE.callbacks(), str3, 13, 0, 4, null);
                            n nVar2 = n.f10413a;
                        } catch (Throwable th2) {
                            th = th2;
                            kotlin.c.a(th);
                            doStartDownload$default(this, str, str3, null, false, true, true, 12, null);
                            return;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        str3 = str2;
                    }
                    doStartDownload$default(this, str, str3, null, false, true, true, 12, null);
                    return;
                }
                return;
            case 4:
                CTAPermissionManager.INSTANCE.setWlanAutoUpgrade(true);
                try {
                    CallbackSubscriber.emitTransient$default(OtaRuntime.INSTANCE.callbacks(), str2, 15, 0, 4, null);
                    n nVar3 = n.f10413a;
                    return;
                } catch (Throwable th4) {
                    kotlin.c.a(th4);
                    return;
                }
            case 5:
            case 6:
                try {
                    CallbackSubscriber.emitTransient$default(OtaRuntime.INSTANCE.callbacks(), str2, 15, 0, 4, null);
                    n nVar4 = n.f10413a;
                    return;
                } catch (Throwable th5) {
                    kotlin.c.a(th5);
                    return;
                }
            case 7:
                emitGateBlocked(str2, 16, 14);
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final boolean isAlreadyUpToDate(String str, String str2) {
        OtaStateSnapshot otaStateSnapshot = OtaRuntime.INSTANCE.snapshot().get(str2);
        if (((otaStateSnapshot != null ? otaStateSnapshot.getState() : null) instanceof OtaState.Failed) || !InstalledPathResolver.INSTANCE.isUsable(str, str2, true)) {
            return false;
        }
        int iEffectiveVersion = OtaBucketLegacy.INSTANCE.effectiveVersion(str2);
        OtaRemoteModel otaRemoteModel = RemoteModelsRepository.get(str2);
        return otaRemoteModel == null || iEffectiveVersion >= otaRemoteModel.getVersion_code();
    }

    private final boolean isConfirmInFlight(String str, String str2) {
        return hasPendingConfirm(str) || InteractiveSessionRegistry.isActive$default(InteractiveSessionRegistry.INSTANCE, str2, 0L, 2, null);
    }

    private final boolean isConfirmedUpdate(String str, String str2) {
        if (!InstalledPathResolver.INSTANCE.isUsable(str, str2, true)) {
            return false;
        }
        int iEffectiveVersion = OtaBucketLegacy.INSTANCE.effectiveVersion(str2);
        OtaRemoteModel otaRemoteModel = RemoteModelsRepository.get(str2);
        return otaRemoteModel != null && iEffectiveVersion < otaRemoteModel.getVersion_code();
    }

    private final void launchUnifiedConfirm(String str, String str2, Context context, String str3, long j10, String str4, l<? super ConfirmDecisionBus.Decision, n> lVar) {
        Object objA;
        if (!InteractiveSessionRegistry.INSTANCE.tryBegin(str2)) {
            h0.e.k("launchUnifiedConfirm: session busy, skip algo=", str, LogModule.OTA, TAG);
            return;
        }
        String strResolveLabel = resolveLabel(str2);
        String strRegister = ConfirmDecisionBus.INSTANCE.register(new cb.e(str, str2, lVar, 1), new ai.onnxruntime.a(24));
        pendingConfirmReqIds.put(str, strRegister);
        try {
            context.startActivity(OtaConfirmTrampolineActivity.Companion.newIntent(context, strRegister, str3, j10, strResolveLabel, str4, (448 & 64) != 0 ? "" : null, (448 & TraceIdKeys.MAX_LENGTH) != 0 ? 0L : 0L, (448 & 256) != 0 ? false : false));
            AIEngineLogger.i(LogModule.OTA, TAG, "launchUnifiedConfirm: algo=" + str + " plan=" + str3 + " reqId=" + strRegister + " size=" + (j10 / 1024) + "KB");
            objA = n.f10413a;
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            AIEngineLogger.e(LogModule.OTA, TAG, "startActivity(trampoline) failed, cancel interactive request", thB);
            ConfirmDecisionBus.INSTANCE.clear(strRegister);
            pendingConfirmReqIds.remove(str);
            InteractiveSessionRegistry.INSTANCE.end(str2);
            try {
                CallbackSubscriber.emitTransient$default(OtaRuntime.INSTANCE.callbacks(), str2, 15, 0, 4, null);
                n nVar = n.f10413a;
            } catch (Throwable th2) {
                kotlin.c.a(th2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void launchUnifiedConfirm$lambda$22(String str, String str2, l lVar, ConfirmDecisionBus.Decision d8) {
        g.f(d8, "d");
        pendingConfirmReqIds.remove(str);
        InteractiveSessionRegistry.INSTANCE.end(str2);
        lVar.invoke(d8);
    }

    private final CTADialogGate.CtaContinuation mainThreadContinuation(final l<? super Context, n> lVar) {
        return new CTADialogGate.CtaContinuation() { // from class: com.stepos.core.ota.deepbinder.OtaInteractiveDownloadFlow.mainThreadContinuation.1
            @Override // com.stepos.core.cta.CTADialogGate.CtaContinuation
            public boolean getRunsOnMainThread() {
                return true;
            }

            @Override // com.stepos.core.cta.CTADialogGate.CtaContinuation
            public void onContinue(Context hostContext) {
                g.f(hostContext, "hostContext");
                lVar.invoke(hostContext);
            }
        };
    }

    private final void notifyDownloadSkip(String str, String str2, DownloadSkipReason downloadSkipReason, String str3) {
        int i10 = WhenMappings.$EnumSwitchMapping$0[downloadSkipReason.ordinal()];
        if (i10 == 1) {
            CallbackSubscriber.resyncToCallbacks$default(OtaRuntime.INSTANCE.callbacks(), str2, null, 2, null);
        } else {
            if (i10 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            OtaRuntime.INSTANCE.callbacks().resyncToCallbacks(str2, InstalledPathResolver.INSTANCE.resolve(str, str2, true));
        }
        AIEngineLogger.i(LogModule.OTA, TAG, str3 + " skipped reason=" + downloadSkipReason + " algo=" + str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean passResourceGateOrPrompt(String str, String str2) {
        Object objA;
        if (!ensureServiceEnabled(str, str2)) {
            return false;
        }
        OtaRemoteModel otaRemoteModel = RemoteModelsRepository.get(str2);
        long file_size = otaRemoteModel != null ? otaRemoteModel.getFile_size() : 0L;
        Context contextAppContext = appContext();
        try {
            objA = Long.valueOf(new StatFs(contextAppContext.getFilesDir().getAbsolutePath()).getAvailableBytes());
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        if (objA instanceof Result.Failure) {
            objA = 0L;
        }
        long jLongValue = ((Number) objA).longValue();
        AutoUpdateEnv autoUpdateEnv = AutoUpdateEnv.INSTANCE;
        int iBatteryPct = autoUpdateEnv.batteryPct(contextAppContext);
        boolean zIsCharging = autoUpdateEnv.isCharging(contextAppContext);
        DownloadResourceGate.Verdict verdictEvaluate = DownloadResourceGate.INSTANCE.evaluate(jLongValue, file_size, iBatteryPct, zIsCharging);
        LogModule logModule = LogModule.OTA;
        StringBuilder sb2 = new StringBuilder("resourceGate(server) algo=");
        sb2.append(str);
        sb2.append(" verdict=");
        sb2.append(verdictEvaluate);
        sb2.append(" avail=");
        sb2.append(jLongValue);
        a0.a.s(file_size, "B size=", "B bat=", sb2);
        sb2.append(iBatteryPct);
        sb2.append("% charging=");
        sb2.append(zIsCharging);
        AIEngineLogger.i(logModule, TAG, sb2.toString());
        if (verdictEvaluate == DownloadResourceGate.Verdict.OK) {
            return true;
        }
        Pair pair = verdictEvaluate == DownloadResourceGate.Verdict.INSUFFICIENT_SPACE ? new Pair(ModelFlowMeta.PLAN_GATE_INSUFFICIENT_SPACE, 18) : new Pair(ModelFlowMeta.PLAN_GATE_LOW_BATTERY, 19);
        launchUnifiedConfirm(str, str2, appContext(), (String) pair.f9985a, file_size, "", new com.stepos.core.ability.text.e(str2, ((Number) pair.f9986b).intValue()));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n passResourceGateOrPrompt$lambda$36(String str, int i10, ConfirmDecisionBus.Decision it) {
        g.f(it, "it");
        INSTANCE.emitGateBlocked(str, i10, 15);
        return n.f10413a;
    }

    private final void rejectServiceDisabled(String str, String str2) {
        h0.e.k("model service disabled → gate dialog ", str, LogModule.OTA, TAG);
        launchUnifiedConfirm(str, str2, appContext(), ModelFlowMeta.PLAN_GATE_SERVICE_DISABLED, 0L, "", new com.stepos.core.ability.e(str2, 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n rejectServiceDisabled$lambda$39(String str, ConfirmDecisionBus.Decision it) {
        g.f(it, "it");
        INSTANCE.emitGateBlocked(str, 16, 14);
        return n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n requestStartDownload$lambda$1(String str) {
        OtaInteractiveDownloadFlow otaInteractiveDownloadFlow = INSTANCE;
        otaInteractiveDownloadFlow.showDownloadConfirm(str, otaInteractiveDownloadFlow.appContext());
        return n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n requestStartDownload$lambda$2(Context ctx) {
        g.f(ctx, "ctx");
        INSTANCE.flushAfterCta(ctx);
        return n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n requestStartDownload$lambda$3(String str, String str2) {
        pendingDownloads.remove(str);
        INSTANCE.emitCtaRejected(str2);
        return n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n requestStartUpdate$lambda$5(String str) {
        OtaInteractiveDownloadFlow otaInteractiveDownloadFlow = INSTANCE;
        otaInteractiveDownloadFlow.showUpdateConfirm(str, otaInteractiveDownloadFlow.appContext());
        return n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n requestStartUpdate$lambda$6(Context ctx) {
        g.f(ctx, "ctx");
        INSTANCE.flushAfterCta(ctx);
        return n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n requestStartUpdate$lambda$7(String str, String str2) {
        pendingUpdates.remove(str);
        INSTANCE.emitCtaRejected(str2);
        return n.f10413a;
    }

    private final String resolveLabel(String str) {
        return ModelLabelResolver.INSTANCE.resolve(appContext(), str, ModelDisplayLookup.INSTANCE.readDir(appContext(), str, OtaEngine.INSTANCE.bucketDirOf(str)));
    }

    private final DownloadSkipReason resolveStartDownloadSkip(String str, String str2) {
        DownloadSkipReason downloadSkipReasonResolveTaskActiveSkip = resolveTaskActiveSkip(str, str2);
        if (downloadSkipReasonResolveTaskActiveSkip != null) {
            return downloadSkipReasonResolveTaskActiveSkip;
        }
        if (isAlreadyUpToDate(str, str2)) {
            return DownloadSkipReason.ALREADY_UP_TO_DATE;
        }
        return null;
    }

    private final DownloadSkipReason resolveStartUpdateSkip(String str, String str2) {
        DownloadSkipReason downloadSkipReasonResolveTaskActiveSkip = resolveTaskActiveSkip(str, str2);
        if (downloadSkipReasonResolveTaskActiveSkip != null) {
            return downloadSkipReasonResolveTaskActiveSkip;
        }
        int iEffectiveVersion = OtaBucketLegacy.INSTANCE.effectiveVersion(str2);
        OtaRemoteModel otaRemoteModel = RemoteModelsRepository.get(str2);
        if (otaRemoteModel == null || iEffectiveVersion >= otaRemoteModel.getVersion_code()) {
            return DownloadSkipReason.ALREADY_UP_TO_DATE;
        }
        return null;
    }

    private final DownloadSkipReason resolveTaskActiveSkip(String str, String str2) {
        OtaRuntime otaRuntime = OtaRuntime.INSTANCE;
        OtaStateSnapshot otaStateSnapshot = otaRuntime.snapshot().get(str2);
        OtaState state = otaStateSnapshot != null ? otaStateSnapshot.getState() : null;
        if (!(state instanceof OtaState.Queued) && !(state instanceof OtaState.Checking) && !(state instanceof OtaState.Downloading) && !(state instanceof OtaState.Verifying) && !(state instanceof OtaState.Installing) && !(state instanceof OtaState.Activating)) {
            return null;
        }
        LogModule logModule = LogModule.OTA;
        OtaStateSnapshot otaStateSnapshot2 = otaRuntime.snapshot().get(str2);
        AIEngineLogger.i(logModule, TAG, "task active: " + str + " state=" + (otaStateSnapshot2 != null ? otaStateSnapshot2.getState() : null));
        return DownloadSkipReason.TASK_ACTIVE;
    }

    private final void scheduleConfirm(String str, zb.a<n> aVar) {
        if (isConfirmInFlight(str, toOtaId(str))) {
            return;
        }
        ConcurrentHashMap<String, Runnable> concurrentHashMap = pendingConfirmRunnables;
        Runnable runnableRemove = concurrentHashMap.remove(str);
        if (runnableRemove != null) {
            mainHandler.removeCallbacks(runnableRemove);
        }
        androidx.appcompat.app.l lVar = new androidx.appcompat.app.l(14, str, aVar);
        concurrentHashMap.put(str, lVar);
        mainHandler.postDelayed(lVar, CTA_TO_CONFIRM_DELAY_MS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void scheduleConfirm$lambda$15(String str, zb.a aVar) {
        pendingConfirmRunnables.remove(str);
        aVar.invoke();
    }

    private final void showDownloadConfirm(String str, Context context) {
        String str2;
        Object objA;
        String strLocalizedUpdateInfo;
        String otaId = toOtaId(str);
        if (pendingConfirmReqIds.containsKey(str)) {
            h0.e.k("showDownloadConfirm: already showing, skip algo=", str, LogModule.OTA, TAG);
            return;
        }
        if (ensureServiceEnabled(str, otaId)) {
            DownloadSkipReason downloadSkipReasonResolveStartDownloadSkip = resolveStartDownloadSkip(str, otaId);
            if ((downloadSkipReasonResolveStartDownloadSkip == null ? -1 : WhenMappings.$EnumSwitchMapping$0[downloadSkipReasonResolveStartDownloadSkip.ordinal()]) != -1) {
                notifyDownloadSkip(str, otaId, downloadSkipReasonResolveStartDownloadSkip, "startDownload");
                return;
            }
            DownloadConfirmPlanner.Plan planPlanFor = DownloadConfirmPlanner.INSTANCE.planFor(appContext());
            AIEngineLogger.i(LogModule.OTA, TAG, "showDownloadConfirm: " + str + " plan=" + planPlanFor);
            if (planPlanFor == DownloadConfirmPlanner.Plan.NO_NETWORK) {
                emitGateBlocked(otaId, 17, 15);
                Toast.makeText(appContext(), R.string.mdl_dl_no_network_toast, 0).show();
                return;
            }
            int i10 = WhenMappings.$EnumSwitchMapping$1[planPlanFor.ordinal()];
            if (i10 == 1) {
                str2 = ModelFlowMeta.PLAN_DL_CONFIRM_ONLY;
            } else {
                if (i10 != 2) {
                    if (i10 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    return;
                }
                str2 = ModelFlowMeta.PLAN_DL_CONFIRM_THEN_CELLULAR;
            }
            String str3 = str2;
            try {
                CallbackSubscriber.emitTransient$default(OtaRuntime.INSTANCE.callbacks(), otaId, 10, 0, 4, null);
                objA = n.f10413a;
            } catch (Throwable th) {
                objA = kotlin.c.a(th);
            }
            Throwable thB = Result.b(objA);
            if (thB != null) {
                AIEngineLogger.w(LogModule.OTA, TAG, ai.onnxruntime.a.k("emit WAITING failed otaId=", otaId), thB);
            }
            OtaRemoteModel otaRemoteModel = RemoteModelsRepository.get(otaId);
            long file_size = otaRemoteModel != null ? otaRemoteModel.getFile_size() : 0L;
            if (otaRemoteModel == null || (strLocalizedUpdateInfo = UpdateInfoI18nKt.localizedUpdateInfo(otaRemoteModel, appContext())) == null) {
                strLocalizedUpdateInfo = "";
            }
            launchUnifiedConfirm(str, otaId, context, str3, file_size, strLocalizedUpdateInfo, new f(0, str, otaId));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n showDownloadConfirm$lambda$18(String str, String str2, ConfirmDecisionBus.Decision decision) {
        g.f(decision, "decision");
        INSTANCE.handleBusDownloadDecision(str, str2, decision);
        return n.f10413a;
    }

    private final void showUpdateConfirm(String str, Context context) {
        String str2;
        Object objA;
        String strLocalizedUpdateInfo;
        String otaId = toOtaId(str);
        if (pendingConfirmReqIds.containsKey(str)) {
            h0.e.k("showUpdateConfirm: already showing, skip algo=", str, LogModule.OTA, TAG);
            return;
        }
        if (ensureServiceEnabled(str, otaId)) {
            DownloadSkipReason downloadSkipReasonResolveStartUpdateSkip = resolveStartUpdateSkip(str, otaId);
            if ((downloadSkipReasonResolveStartUpdateSkip == null ? -1 : WhenMappings.$EnumSwitchMapping$0[downloadSkipReasonResolveStartUpdateSkip.ordinal()]) != -1) {
                notifyDownloadSkip(str, otaId, downloadSkipReasonResolveStartUpdateSkip, "startUpdate");
                return;
            }
            UpdateConfirmPlanner.UpdatePlan updatePlanPlanFor = UpdateConfirmPlanner.INSTANCE.planFor(appContext());
            AIEngineLogger.i(LogModule.OTA, TAG, "showUpdateConfirm: " + str + " plan=" + updatePlanPlanFor);
            if (updatePlanPlanFor == UpdateConfirmPlanner.UpdatePlan.NO_NETWORK) {
                emitGateBlocked(otaId, 17, 15);
                Toast.makeText(appContext(), R.string.mdl_dl_no_network_toast, 0).show();
                return;
            }
            int i10 = WhenMappings.$EnumSwitchMapping$2[updatePlanPlanFor.ordinal()];
            if (i10 == 1) {
                str2 = ModelFlowMeta.PLAN_UPD_WIFI_AUTO_ON;
            } else if (i10 == 2) {
                str2 = ModelFlowMeta.PLAN_UPD_WIFI_AUTO_OFF;
            } else if (i10 == 3) {
                str2 = ModelFlowMeta.PLAN_UPD_CELLULAR_AUTO_ON;
            } else {
                if (i10 != 4) {
                    if (i10 != 5) {
                        throw new NoWhenBranchMatchedException();
                    }
                    return;
                }
                str2 = ModelFlowMeta.PLAN_UPD_CELLULAR_AUTO_OFF;
            }
            String str3 = str2;
            try {
                CallbackSubscriber.emitTransient$default(OtaRuntime.INSTANCE.callbacks(), otaId, 10, 0, 4, null);
                objA = n.f10413a;
            } catch (Throwable th) {
                objA = kotlin.c.a(th);
            }
            Throwable thB = Result.b(objA);
            if (thB != null) {
                AIEngineLogger.w(LogModule.OTA, TAG, ai.onnxruntime.a.k("emit WAITING failed otaId=", otaId), thB);
            }
            OtaRemoteModel otaRemoteModel = RemoteModelsRepository.get(otaId);
            long file_size = otaRemoteModel != null ? otaRemoteModel.getFile_size() : 0L;
            if (otaRemoteModel == null || (strLocalizedUpdateInfo = UpdateInfoI18nKt.localizedUpdateInfo(otaRemoteModel, appContext())) == null) {
                strLocalizedUpdateInfo = "";
            }
            launchUnifiedConfirm(str, otaId, context, str3, file_size, strLocalizedUpdateInfo, new com.stepos.ability.sdk.client.b(4, str, (Object) otaId));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n showUpdateConfirm$lambda$21(String str, String str2, ConfirmDecisionBus.Decision decision) {
        g.f(decision, "decision");
        INSTANCE.handleBusUpdateDecision(str, str2, decision);
        return n.f10413a;
    }

    private final String toOtaId(String str) {
        return OtaEngine.INSTANCE.resolveAnyToOta(str);
    }

    public final void cancelPendingConfirm(String algorithmId) {
        g.f(algorithmId, "algorithmId");
        Runnable runnableRemove = pendingConfirmRunnables.remove(algorithmId);
        if (runnableRemove != null) {
            mainHandler.removeCallbacks(runnableRemove);
        }
        String strRemove = pendingConfirmReqIds.remove(algorithmId);
        if (strRemove != null) {
            ConfirmDecisionBus.INSTANCE.clear(strRemove);
            AIEngineLogger.i(LogModule.OTA, TAG, ai.onnxruntime.a.l("cancelPendingConfirm: algo=", algorithmId, " reqId=", strRemove));
        }
        InteractiveSessionRegistry.INSTANCE.end(toOtaId(algorithmId));
    }

    public final void continueAfterCtaIfNeeded(Context context, List<String> algorithmIds) {
        g.f(context, "context");
        g.f(algorithmIds, "algorithmIds");
        mainHandler.postDelayed(new androidx.appcompat.app.l(13, algorithmIds, context), 430L);
    }

    public final boolean ensureServiceEnabledOrPrompt(String algorithmId) {
        g.f(algorithmId, "algorithmId");
        return ensureServiceEnabled(algorithmId, toOtaId(algorithmId));
    }

    public final void executeConfirmedDownload(String algorithmId, boolean z, boolean z3) {
        g.f(algorithmId, "algorithmId");
        String otaId = toOtaId(algorithmId);
        LogModule logModule = LogModule.OTA;
        StringBuilder sbS = ai.onnxruntime.a.s("executeConfirmedDownload: ", algorithmId, " otaId=", otaId, " cellularAllowed=");
        sbS.append(z);
        sbS.append(" enableWifiAuto=");
        sbS.append(z3);
        AIEngineLogger.i(logModule, TAG, sbS.toString());
        if (z3) {
            CTAPermissionManager.INSTANCE.setWlanAutoUpgrade(true);
        }
        InteractiveSessionRegistry.INSTANCE.end(otaId);
        doStartDownload$default(this, algorithmId, otaId, null, z, isConfirmedUpdate(algorithmId, otaId), true, 4, null);
    }

    public final void flushAfterCta(Context context) {
        g.f(context, "context");
        AIEngineLogger.i(LogModule.OTA, TAG, a0.a.f("flushAfterCta pendingDl=", pendingDownloads.size(), pendingUpdates.size(), " pendingUpd="));
        mainHandler.postDelayed(new a6.e(context, 4), CTA_TO_CONFIRM_DELAY_MS);
    }

    public final boolean hasPending() {
        ConcurrentHashMap.KeySetView<String, Boolean> pendingDownloads2 = pendingDownloads;
        g.e(pendingDownloads2, "pendingDownloads");
        if (!pendingDownloads2.isEmpty()) {
            return true;
        }
        ConcurrentHashMap.KeySetView<String, Boolean> pendingUpdates2 = pendingUpdates;
        g.e(pendingUpdates2, "pendingUpdates");
        return !pendingUpdates2.isEmpty();
    }

    public final boolean hasPendingConfirm(String algorithmId) {
        g.f(algorithmId, "algorithmId");
        return pendingConfirmReqIds.containsKey(algorithmId) || pendingConfirmRunnables.containsKey(algorithmId);
    }

    public final void requestStartDownload(String algorithmId, int i10) {
        g.f(algorithmId, "algorithmId");
        String otaId = toOtaId(algorithmId);
        if (isConfirmInFlight(algorithmId, otaId)) {
            AIEngineLogger.i(LogModule.OTA, TAG, "requestStartDownload: confirm in flight, ignore algo=".concat(algorithmId));
            try {
                CallbackSubscriber.emitTransient$default(OtaRuntime.INSTANCE.callbacks(), otaId, 10, 0, 4, null);
                n nVar = n.f10413a;
                return;
            } catch (Throwable th) {
                kotlin.c.a(th);
                return;
            }
        }
        LogModule logModule = LogModule.OTA;
        CTAPermissionManager cTAPermissionManager = CTAPermissionManager.INSTANCE;
        boolean zHasCTAPermission = cTAPermissionManager.hasCTAPermission();
        StringBuilder sbS = ai.onnxruntime.a.s("requestStartDownload: ", algorithmId, " otaId=", otaId, " hasCta=");
        sbS.append(zHasCTAPermission);
        AIEngineLogger.i(logModule, TAG, sbS.toString());
        if (ensureServiceEnabled(algorithmId, otaId)) {
            int i11 = 1;
            if (cTAPermissionManager.hasCTAPermission()) {
                scheduleConfirm(algorithmId, new e(algorithmId, i11));
                return;
            }
            if (OtaProcess.INSTANCE.isOtaProcess(appContext())) {
                AIEngineLogger.d(logModule, TAG, "CTA not granted in :ota process, skip dialog");
                emitCtaRejected(otaId);
                return;
            }
            pendingDownloads.add(algorithmId);
            lastCtaDownloadAlgorithmId = algorithmId;
            CTADialogGate cTADialogGate = CTADialogGate.INSTANCE;
            cTADialogGate.registerInteractiveDownload(algorithmId);
            cTADialogGate.ensureGranted(i10, mainThreadContinuation(new com.stepos.core.common.cloud.d(19)), new d(i11, algorithmId, otaId));
        }
    }

    public final void requestStartUpdate(String algorithmId, int i10) {
        g.f(algorithmId, "algorithmId");
        String otaId = toOtaId(algorithmId);
        if (isConfirmInFlight(algorithmId, otaId)) {
            AIEngineLogger.i(LogModule.OTA, TAG, "requestStartUpdate: confirm in flight, ignore algo=".concat(algorithmId));
            try {
                CallbackSubscriber.emitTransient$default(OtaRuntime.INSTANCE.callbacks(), otaId, 10, 0, 4, null);
                n nVar = n.f10413a;
                return;
            } catch (Throwable th) {
                kotlin.c.a(th);
                return;
            }
        }
        LogModule logModule = LogModule.OTA;
        CTAPermissionManager cTAPermissionManager = CTAPermissionManager.INSTANCE;
        boolean zHasCTAPermission = cTAPermissionManager.hasCTAPermission();
        StringBuilder sbS = ai.onnxruntime.a.s("requestStartUpdate: ", algorithmId, " otaId=", otaId, " hasCta=");
        sbS.append(zHasCTAPermission);
        AIEngineLogger.i(logModule, TAG, sbS.toString());
        if (ensureServiceEnabled(algorithmId, otaId)) {
            if (cTAPermissionManager.hasCTAPermission()) {
                scheduleConfirm(algorithmId, new e(algorithmId, 0));
            } else if (OtaProcess.INSTANCE.isOtaProcess(appContext())) {
                AIEngineLogger.d(logModule, TAG, "CTA not granted in :ota process, skip dialog");
                emitCtaRejected(otaId);
            } else {
                pendingUpdates.add(algorithmId);
                CTADialogGate.INSTANCE.ensureGranted(i10, mainThreadContinuation(new com.stepos.core.common.telemetry.b(13)), new z(1, algorithmId, otaId));
            }
        }
    }
}
