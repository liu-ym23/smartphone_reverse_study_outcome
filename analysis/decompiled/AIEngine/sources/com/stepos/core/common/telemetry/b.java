package com.stepos.core.common.telemetry;

import android.content.Context;
import android.os.collector.scene.StepOSPerfSceneData;
import com.stepos.aiengine.model.AvailableModelInfo;
import com.stepos.aiengine.service.AIEngineManagerService;
import com.stepos.base.model.ReleaseReason;
import com.stepos.core.common.telemetry.InferExceptionRecord;
import com.stepos.core.common.telemetry.scene.AiStageSceneDonator;
import com.stepos.core.deepbinder.IOtaDeepBinderService;
import com.stepos.core.ota.OtaContainer;
import com.stepos.core.ota.OtaEngine;
import com.stepos.core.ota.adapter.FileSystemModelStorage;
import com.stepos.core.ota.crypto.AtRestSealer;
import com.stepos.core.ota.deepbinder.OtaDeepBinderServiceImpl;
import com.stepos.core.ota.deepbinder.OtaInteractiveDownloadFlow;
import com.stepos.core.ota.display.ModelDisplayResourceStore;
import com.stepos.core.ota.domain.OtaStore;
import com.stepos.core.ota.domain.model.ModelManifest;
import com.stepos.core.ota.install.PreInstallModels;
import com.stepos.core.ota.process.OtaProcessBootstrap;
import com.stepos.core.ota.process.OtaProcessClient;
import com.stepos.core.ota.push.OtaPushRegistrar;
import com.stepos.deepbinder.core.exception.ErrorCodes;
import fc.i;
import java.io.File;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.coroutines.d;
import kotlinx.coroutines.CoroutineDispatcher;
import lb.n;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7386a;

    public /* synthetic */ b(int i10) {
        this.f7386a = i10;
    }

    @Override // zb.l
    public final Object invoke(Object obj) {
        switch (this.f7386a) {
            case 0:
                return Long.valueOf(AiPowerPerfRecord.toTags$lambda$13$lambda$5$lambda$3((PhaseRecord) obj));
            case 1:
                return FailStack.toLines$lambda$0((String) obj);
            case 2:
                return Long.valueOf(InferExceptionRecord.Companion.flattenPhases$lambda$7$lambda$5((PhaseRecord) obj));
            case 3:
                return AiStageSceneDonator.scheduleExitRetry$lambda$11$lambda$10((StepOSPerfSceneData) obj);
            case 4:
                return Boolean.valueOf(OtaContainer.init$lambda$4((String) obj));
            case 5:
                return OtaContainer.init$lambda$11((String) obj);
            case 6:
                return OtaEngine.initInOtaProcess$lambda$9((String) obj);
            case 7:
                return OtaEngine.initInOtaProcess$lambda$7((Context) obj);
            case 8:
                return OtaEngine.init$lambda$3((Context) obj);
            case 9:
                return OtaEngine.release$lambda$25((String) obj);
            case 10:
                return Boolean.valueOf(FileSystemModelStorage.payloadBytes$lambda$2((File) obj));
            case 11:
                return Boolean.valueOf(AtRestSealer.sealDir_gIAlu_s$lambda$2$lambda$1((File) obj));
            case 12:
                return Boolean.valueOf(OtaDeepBinderServiceImpl.recordUpdatablePending$lambda$24$lambda$21((AvailableModelInfo) obj));
            case 13:
                return OtaInteractiveDownloadFlow.requestStartUpdate$lambda$6((Context) obj);
            case 14:
                return ModelDisplayResourceStore.lockOf$lambda$1((String) obj);
            case 15:
                return Boolean.valueOf(ModelDisplayResourceStore.findLocalZip$lambda$55((File) obj));
            case 16:
                return Boolean.valueOf(ModelDisplayResourceStore.findLocalZip$lambda$57((File) obj));
            case 17:
                return OtaStore._init_$lambda$1((ModelManifest) obj);
            case 18:
                return Boolean.valueOf(PreInstallModels.presetSealer_delegate$lambda$1$lambda$0((String) obj));
            case 19:
                return OtaProcessBootstrap.start$lambda$1((Context) obj);
            case 20:
                return OtaProcessClient.ensureCallbackBridge$lambda$5((String) obj);
            case 21:
                return OtaPushRegistrar.ctaInitializer$lambda$0((Context) obj);
            case 22:
                String modelId = (String) obj;
                d6.c cVar = d6.c.f8388a;
                kotlin.jvm.internal.g.f(modelId, "modelId");
                ConcurrentHashMap.KeySetView<String, Boolean> keySetView = d6.c.f8391d;
                if (!keySetView.contains(modelId)) {
                    ReleaseReason releaseReason = ReleaseReason.f6338b;
                    cVar.getClass();
                    Set<Integer> setKeySet = d6.c.f8389b.keySet();
                    kotlin.jvm.internal.g.e(setKeySet, "<get-keys>(...)");
                    d6.c.a(modelId, releaseReason, kotlin.collections.a.R0(setKeySet));
                }
                cVar.getClass();
                d6.c.f8390c.remove(modelId);
                keySetView.remove(modelId);
                return n.f10413a;
            case 23:
                Pair it = (Pair) obj;
                kotlin.jvm.internal.g.f(it, "it");
                return (Comparable) it.f9986b;
            case ErrorCodes.GET_INSTANCE_METHOD_INVOCATION_ERROR /* 24 */:
                kotlin.jvm.internal.g.f((String) obj, "it");
                return new ConcurrentHashMap();
            case 25:
                i it2 = (i) obj;
                kotlin.jvm.internal.g.f(it2, "it");
                return it2.iterator();
            case 26:
                return obj;
            case 27:
                IOtaDeepBinderService it3 = (IOtaDeepBinderService) obj;
                kotlin.jvm.internal.g.f(it3, "it");
                return it3.getPresetModels();
            case ErrorCodes.GET_CONTENT_URI_ERROR /* 28 */:
                return CoroutineDispatcher.Key._init_$lambda$0((d.a) obj);
            default:
                AiPowerPerfRecord record = (AiPowerPerfRecord) obj;
                int i10 = AIEngineManagerService.f5926c;
                kotlin.jvm.internal.g.f(record, "record");
                EmsReporter emsReporter = EmsReporter.INSTANCE;
                emsReporter.reportAiPowerPerf(record);
                InferExceptionRecord inferExceptionRecordFrom = InferExceptionRecord.Companion.from(record);
                if (inferExceptionRecordFrom != null && ExceptionLogStore.INSTANCE.write(inferExceptionRecordFrom)) {
                    emsReporter.reportInferException(inferExceptionRecordFrom);
                }
                return n.f10413a;
        }
    }
}
