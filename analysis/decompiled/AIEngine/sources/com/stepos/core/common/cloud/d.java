package com.stepos.core.common.cloud;

import ad.n;
import android.content.Context;
import b7.r;
import com.stepos.aiengine.model.AvailableModelInfo;
import com.stepos.core.common.log.LogDumpHelper;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.common.log.LogStatistics;
import com.stepos.core.common.log.TraceContext;
import com.stepos.core.common.net.NetWorkManager;
import com.stepos.core.common.telemetry.AiPowerPerfRecord;
import com.stepos.core.common.telemetry.FailStack;
import com.stepos.core.common.telemetry.InferExceptionRecord;
import com.stepos.core.common.telemetry.ModelLoadFailureReporter;
import com.stepos.core.common.telemetry.PowerPerfTracker;
import com.stepos.core.deepbinder.IOtaDeepBinderService;
import com.stepos.core.model.concurrency.ThreadPoolManagerImpl;
import com.stepos.core.ota.OtaEngine;
import com.stepos.core.ota.crypto.AtRestDecryptorBootstrap;
import com.stepos.core.ota.crypto.KeyCenterClient;
import com.stepos.core.ota.crypto.OtaAtRestDecryptor;
import com.stepos.core.ota.deepbinder.OtaDeepBinderServiceImpl;
import com.stepos.core.ota.deepbinder.OtaInteractiveDownloadFlow;
import com.stepos.core.ota.display.ModelDisplayResourceStore;
import com.stepos.core.ota.domain.OtaStateSnapshot;
import com.stepos.core.ota.install.PreInstallModels;
import com.stepos.core.ota.process.OtaProcessBootstrap;
import com.stepos.core.ota.process.OtaProcessService;
import com.stepos.core.performance.data.GlobalVerdict;
import com.stepos.core.performance.orchestrator.PerformanceOrchestratorImpl;
import com.stepos.deepbinder.core.exception.ErrorCodes;
import java.io.File;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Pair;
import kotlin.coroutines.d;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7372a;

    public /* synthetic */ d(int i10) {
        this.f7372a = i10;
    }

    @Override // zb.l
    public final Object invoke(Object obj) {
        switch (this.f7372a) {
            case 0:
                return CloudRequestHeaderLog.format$lambda$3((Map.Entry) obj);
            case 1:
                return LogDumpHelper.dumpHelp$lambda$1((LogModule) obj);
            case 2:
                return LogStatistics.toString$lambda$11((Map.Entry) obj);
            case 3:
                return TraceContext.addEvent$lambda$2((Map.Entry) obj);
            case 4:
                return NetWorkManager.rawOkHttpClient$lambda$3((n.a) obj);
            case 5:
                return Boolean.valueOf(AiPowerPerfRecord.toTags$lambda$13$lambda$5$lambda$4(((Long) obj).longValue()));
            case 6:
                return Boolean.valueOf(FailStack.toLines$lambda$1((String) obj));
            case 7:
                return Boolean.valueOf(InferExceptionRecord.Companion.flattenPhases$lambda$7$lambda$6(((Long) obj).longValue()));
            case 8:
                return ModelLoadFailureReporter.digestStack$lambda$1((StackTraceElement) obj);
            case 9:
                return PowerPerfTracker.digestStack$lambda$1((StackTraceElement) obj);
            case 10:
                return ThreadPoolManagerImpl.enqueueOrReject$lambda$9((Integer) obj);
            case 11:
                return OtaEngine.initInOtaProcess$lambda$6((Context) obj);
            case 12:
                return OtaEngine.init$lambda$4((Context) obj);
            case 13:
                return OtaEngine.wireSharedRuntime$lambda$10((String) obj);
            case 14:
                return Boolean.valueOf(AtRestDecryptorBootstrap.install$lambda$3$lambda$2((String) obj));
            case 15:
                return KeyCenterClient.redact$lambda$17((gc.h) obj);
            case 16:
                return Boolean.valueOf(OtaAtRestDecryptor._init_$lambda$1((String) obj));
            case 17:
                return Boolean.valueOf(OtaDeepBinderServiceImpl.recordUpdatablePending$lambda$24$lambda$20((AvailableModelInfo) obj));
            case 18:
                return OtaDeepBinderServiceImpl.recordUpdatablePending$lambda$24$lambda$22((AvailableModelInfo) obj);
            case 19:
                return OtaInteractiveDownloadFlow.requestStartDownload$lambda$2((Context) obj);
            case 20:
                return ModelDisplayResourceStore.findLocalZip$lambda$56((File) obj);
            case 21:
                return Boolean.valueOf(PreInstallModels.writePresetMeta$lambda$26$lambda$24((File) obj));
            case 22:
                return OtaProcessBootstrap.start$lambda$2((Context) obj);
            case 23:
                return OtaProcessService.handleIdleExitDump$lambda$18((OtaStateSnapshot) obj);
            case ErrorCodes.GET_INSTANCE_METHOD_INVOCATION_ERROR /* 24 */:
                kotlin.jvm.internal.g.f((Integer) obj, "it");
                return new CopyOnWriteArraySet();
            case 25:
                Pair it = (Pair) obj;
                kotlin.jvm.internal.g.f(it, "it");
                return Long.valueOf(((r) it.f9985a).getLastUsedAtMonoNs());
            case 26:
                return PerformanceOrchestratorImpl.dumpAuditLog$lambda$5$lambda$4((GlobalVerdict) obj);
            case 27:
                IOtaDeepBinderService it2 = (IOtaDeepBinderService) obj;
                kotlin.jvm.internal.g.f(it2, "it");
                return it2.getAvailableModelsForce();
            case ErrorCodes.GET_CONTENT_URI_ERROR /* 28 */:
                return ExecutorCoroutineDispatcher.Key._init_$lambda$0((d.a) obj);
            default:
                Class it3 = (Class) obj;
                kotlin.jvm.internal.g.f(it3, "it");
                return it3.getSimpleName();
        }
    }
}
