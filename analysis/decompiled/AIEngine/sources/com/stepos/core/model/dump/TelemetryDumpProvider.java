package com.stepos.core.model.dump;

import android.os.Build;
import com.stepos.core.common.log.IDumpProvider;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.common.telemetry.AiPowerEventBus;
import com.stepos.core.common.telemetry.AiPowerPerfRecord;
import com.stepos.core.common.telemetry.DataVolume;
import com.stepos.core.common.telemetry.FailStage;
import com.stepos.core.common.telemetry.ModelCallEventBus;
import com.stepos.core.common.telemetry.ModelCallExecutionPath;
import com.stepos.core.common.telemetry.ModelCallRecord;
import com.stepos.core.common.telemetry.PhaseRecord;
import com.stepos.core.ota.d;
import com.stepos.deepbinder.annotation.BaseConstantsKt;
import com.tonyodev.fetch2core.server.FileResponse;
import gc.n;
import gc.o;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.c;
import kotlin.collections.a;
import kotlin.jvm.internal.g;
import mb.l;
import mb.m;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class TelemetryDumpProvider implements IDumpProvider {
    private final String moduleName = "Telemetry";
    private final LogModule logModule = LogModule.MODEL;

    private final void dumpClear(PrintWriter printWriter) {
        if (!isDebugBuild()) {
            printWriter.println("telemetry-clear only available on userdebug/eng builds");
        } else {
            AiPowerEventBus.INSTANCE.clear();
            printWriter.println("Telemetry cleared");
        }
    }

    private final void dumpCloudCorrelation(PrintWriter printWriter) {
        printWriter.println("=== Cloud Correlation Telemetry ===");
        ModelCallEventBus modelCallEventBus = ModelCallEventBus.INSTANCE;
        printWriter.println("EventBus: size=" + modelCallEventBus.size() + ", dropped=" + modelCallEventBus.droppedCount());
        for (ModelCallRecord modelCallRecord : a.K0(100, modelCallEventBus.snapshot())) {
            String inferId = modelCallRecord.getInferId();
            String abilityId = modelCallRecord.getAbilityId();
            ModelCallExecutionPath executionPath = modelCallRecord.getExecutionPath();
            String reconciliationId = modelCallRecord.getReconciliationId();
            String status = modelCallRecord.getStatus();
            long e2eMs = modelCallRecord.getE2eMs();
            StringBuilder sbS = ai.onnxruntime.a.s("  ", inferId, " | ", abilityId, " | ");
            sbS.append(executionPath);
            sbS.append(" | ");
            sbS.append(reconciliationId);
            sbS.append(" | ");
            d.p(e2eMs, status, " | e2e=", sbS);
            sbS.append("ms");
            printWriter.println(sbS.toString());
        }
    }

    private final void dumpCloudCorrelationLast(PrintWriter printWriter) {
        String logJson;
        ModelCallRecord modelCallRecordLast = ModelCallEventBus.INSTANCE.last();
        if (modelCallRecordLast == null || (logJson = modelCallRecordLast.toLogJson()) == null) {
            logJson = "{}";
        }
        printWriter.println(logJson);
    }

    private final void dumpLast(PrintWriter printWriter) {
        AiPowerPerfRecord aiPowerPerfRecordLast = AiPowerEventBus.INSTANCE.last();
        if (aiPowerPerfRecordLast == null) {
            printWriter.println("{}");
        } else {
            printWriter.println(recordToJson(aiPowerPerfRecordLast));
        }
    }

    private final void dumpOverview(PrintWriter printWriter) {
        printWriter.println("=== AI Power/Perf Telemetry ===");
        AiPowerEventBus aiPowerEventBus = AiPowerEventBus.INSTANCE;
        printWriter.println("EventBus: size=" + aiPowerEventBus.size() + ", dropped=" + aiPowerEventBus.droppedCount());
        printWriter.println();
        printWriter.println("Recent records (last 100):");
        for (AiPowerPerfRecord aiPowerPerfRecord : a.K0(100, aiPowerEventBus.snapshot())) {
            String taskId = aiPowerPerfRecord.getTaskId();
            String abilityId = aiPowerPerfRecord.getAbilityId();
            String backend = aiPowerPerfRecord.getBackend();
            String executionLocation = aiPowerPerfRecord.getExecutionLocation();
            String status = aiPowerPerfRecord.getStatus();
            long e2eMs = aiPowerPerfRecord.getE2eMs();
            long ttftMs = aiPowerPerfRecord.getTtftMs();
            StringBuilder sbS = ai.onnxruntime.a.s("  ", taskId, " | ", abilityId, " | ");
            ai.onnxruntime.a.z(sbS, backend, " | ", executionLocation, " | ");
            d.p(e2eMs, status, " | e2e=", sbS);
            printWriter.println(a0.a.d(ttftMs, "ms ttft=", "ms", sbS));
        }
    }

    private final void dumpSince(PrintWriter printWriter, long j10) {
        Iterator<AiPowerPerfRecord> it = AiPowerEventBus.INSTANCE.since(j10).iterator();
        while (it.hasNext()) {
            printWriter.println(recordToJson(it.next()));
        }
    }

    private final void dumpSummaryLine(PrintWriter printWriter) {
        AiPowerEventBus aiPowerEventBus = AiPowerEventBus.INSTANCE;
        printWriter.println("AI Power/Perf: EventBus size=" + aiPowerEventBus.size() + " dropped=" + aiPowerEventBus.droppedCount() + " pendingDispatch=" + aiPowerEventBus.pendingDispatchCount() + " dispatchDropped=" + aiPowerEventBus.dispatchDroppedCount());
        ModelCallEventBus modelCallEventBus = ModelCallEventBus.INSTANCE;
        int size = modelCallEventBus.size();
        long jDroppedCount = modelCallEventBus.droppedCount();
        StringBuilder sb2 = new StringBuilder("Cloud correlation: EventBus size=");
        sb2.append(size);
        sb2.append(" dropped=");
        sb2.append(jDroppedCount);
        printWriter.println(sb2.toString());
    }

    private final boolean isDebugBuild() {
        Object objA;
        try {
            String str = Build.TYPE;
            if (str == null) {
                str = "";
            }
            objA = Boolean.valueOf(m.b0("userdebug", "eng").contains(str));
        } catch (Throwable th) {
            objA = c.a(th);
        }
        Object obj = Boolean.FALSE;
        if (objA instanceof Result.Failure) {
            objA = obj;
        }
        return ((Boolean) objA).booleanValue();
    }

    private final String recordToJson(AiPowerPerfRecord aiPowerPerfRecord) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("traceId", aiPowerPerfRecord.getTraceId());
        jSONObject.put("taskId", aiPowerPerfRecord.getTaskId());
        jSONObject.put("callerUid", aiPowerPerfRecord.getCallerUid());
        jSONObject.put("callerPkg", aiPowerPerfRecord.getCallerPkg());
        jSONObject.put("abilityId", aiPowerPerfRecord.getAbilityId());
        jSONObject.put("modelId", aiPowerPerfRecord.getModelId());
        jSONObject.put("modelVersion", aiPowerPerfRecord.getModelVersion());
        jSONObject.put("engineVersion", aiPowerPerfRecord.getEngineVersion());
        jSONObject.put("backend", aiPowerPerfRecord.getBackend());
        jSONObject.put("hardware", aiPowerPerfRecord.getHardware());
        jSONObject.put("startMonoNs", aiPowerPerfRecord.getStartMonoNs());
        jSONObject.put("endMonoNs", aiPowerPerfRecord.getEndMonoNs());
        jSONObject.put("startWallMs", aiPowerPerfRecord.getStartWallMs());
        jSONObject.put("e2eMs", aiPowerPerfRecord.getE2eMs());
        jSONObject.put("ttftMs", aiPowerPerfRecord.getTtftMs());
        jSONObject.put("decodeTps", Float.valueOf(aiPowerPerfRecord.getDecodeTps()));
        jSONObject.put("modelCacheState", aiPowerPerfRecord.getModelCacheState());
        if (aiPowerPerfRecord.getModelLoadMs() > 0) {
            jSONObject.put("modelLoadMs", aiPowerPerfRecord.getModelLoadMs());
        }
        jSONObject.put(FileResponse.FIELD_STATUS, aiPowerPerfRecord.getStatus());
        jSONObject.put(BaseConstantsKt.KEY_ERROR_CODE, aiPowerPerfRecord.getErrorCode());
        if (aiPowerPerfRecord.getEngineSceneId() != 0) {
            jSONObject.put("engineSceneId", aiPowerPerfRecord.getEngineSceneId());
        }
        if (aiPowerPerfRecord.getCpuAttributedMs() != -1) {
            jSONObject.put("cpuAttributedMs", aiPowerPerfRecord.getCpuAttributedMs());
        }
        if (aiPowerPerfRecord.getNpuAttributedMs() != -1) {
            jSONObject.put("npuAttributedMs", aiPowerPerfRecord.getNpuAttributedMs());
        }
        if (aiPowerPerfRecord.getGpuAttributedMs() != -1) {
            jSONObject.put("gpuAttributedMs", aiPowerPerfRecord.getGpuAttributedMs());
        }
        if (aiPowerPerfRecord.getDspAttributedMs() != -1) {
            jSONObject.put("dspAttributedMs", aiPowerPerfRecord.getDspAttributedMs());
        }
        if (aiPowerPerfRecord.getCpuEnergyUj() != -1) {
            jSONObject.put("cpuEnergyUj", aiPowerPerfRecord.getCpuEnergyUj());
        }
        if (aiPowerPerfRecord.getNpuPerfLevel().length() > 0) {
            jSONObject.put("npuPerfLevel", aiPowerPerfRecord.getNpuPerfLevel());
        }
        if (aiPowerPerfRecord.getCpuFreqMhzAvg() != -1) {
            jSONObject.put("cpuFreqMhzAvg", aiPowerPerfRecord.getCpuFreqMhzAvg());
        }
        if (aiPowerPerfRecord.getDdrFreqMhzAvg() != -1) {
            jSONObject.put("ddrFreqMhzAvg", aiPowerPerfRecord.getDdrFreqMhzAvg());
        }
        if (aiPowerPerfRecord.getShellTempC() > 0.0f) {
            jSONObject.put("shellTempC", Math.round(aiPowerPerfRecord.getShellTempC() * 10.0f) / 10.0d);
        }
        JSONArray jSONArray = new JSONArray();
        Set setS0 = l.s0(new String[]{FailStage.VIT_ENCODE, FailStage.AUDIO_ENCODE});
        List<PhaseRecord> phases = aiPowerPerfRecord.getPhases();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : phases) {
            PhaseRecord phaseRecord = (PhaseRecord) obj;
            String phase = setS0.contains(phaseRecord.getPhase()) ? "ENCODE" : phaseRecord.getPhase();
            Object arrayList = linkedHashMap.get(phase);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(phase, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            String str = (String) entry.getKey();
            List<PhaseRecord> list = (List) entry.getValue();
            Iterator it = list.iterator();
            int durationMs = 0;
            while (it.hasNext()) {
                durationMs += ((PhaseRecord) it.next()).getDurationMs();
            }
            if (durationMs > 0) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("phase", str);
                jSONObject2.put("durationMs", durationMs);
                ArrayList arrayList2 = new ArrayList();
                for (PhaseRecord phaseRecord2 : list) {
                    Long lValueOf = phaseRecord2.getBeginMs() >= 0 ? Long.valueOf(phaseRecord2.getBeginMs()) : null;
                    if (lValueOf != null) {
                        arrayList2.add(lValueOf);
                    }
                }
                Long l10 = (Long) a.C0(arrayList2);
                if (l10 != null) {
                    jSONObject2.put("beginMs", l10.longValue());
                }
                jSONArray.put(jSONObject2);
            }
        }
        jSONObject.put("phases", jSONArray);
        DataVolume dataVolume = aiPowerPerfRecord.getDataVolume();
        if (dataVolume != null) {
            JSONObject jSONObject3 = new JSONObject();
            Integer inputTokens = dataVolume.getInputTokens();
            if (inputTokens != null) {
                jSONObject3.put("inputTokens", inputTokens.intValue());
            }
            Integer outputTokens = dataVolume.getOutputTokens();
            if (outputTokens != null) {
                jSONObject3.put("outputTokens", outputTokens.intValue());
            }
            Integer imageTokens = dataVolume.getImageTokens();
            if (imageTokens != null) {
                jSONObject3.put("imageTokens", imageTokens.intValue());
            }
            Integer audioTokens = dataVolume.getAudioTokens();
            if (audioTokens != null) {
                jSONObject3.put("audioTokens", audioTokens.intValue());
            }
            Long kvCacheSizeBytes = dataVolume.getKvCacheSizeBytes();
            if (kvCacheSizeBytes != null) {
                jSONObject3.put("kvCacheSizeBytes", kvCacheSizeBytes.longValue());
            }
            Integer inputSizeBytes = dataVolume.getInputSizeBytes();
            if (inputSizeBytes != null) {
                jSONObject3.put("inputSizeBytes", inputSizeBytes.intValue());
            }
            Integer outputSizeBytes = dataVolume.getOutputSizeBytes();
            if (outputSizeBytes != null) {
                jSONObject3.put("outputSizeBytes", outputSizeBytes.intValue());
            }
            if (jSONObject3.length() > 0) {
                jSONObject.put("dataVolume", jSONObject3);
            }
        }
        String string = jSONObject.toString();
        g.e(string, "toString(...)");
        return string;
    }

    @Override // com.stepos.core.common.log.IDumpProvider
    public void dump(PrintWriter writer, String[] args) {
        Long lD0;
        g.f(writer, "writer");
        g.f(args, "args");
        if (l.a0("--telemetry", args)) {
            dumpOverview(writer);
            return;
        }
        if (l.a0("--telemetry-last", args)) {
            dumpLast(writer);
            return;
        }
        for (String str : args) {
            if (o.k0(str, "--telemetry-since", false)) {
                int length = args.length;
                int i10 = 0;
                while (true) {
                    if (i10 >= length) {
                        i10 = -1;
                        break;
                    } else if (o.k0(args[i10], "--telemetry-since", false)) {
                        break;
                    } else {
                        i10++;
                    }
                }
                String str2 = (String) l.g0(args, i10 + 1);
                dumpSince(writer, (str2 == null || (lD0 = n.d0(str2)) == null) ? 0L : lD0.longValue());
                return;
            }
        }
        if (l.a0("--telemetry-clear", args)) {
            dumpClear(writer);
            return;
        }
        if (l.a0("--cloud-correlation", args)) {
            dumpCloudCorrelation(writer);
        } else if (l.a0("--cloud-correlation-last", args)) {
            dumpCloudCorrelationLast(writer);
        } else {
            dumpSummaryLine(writer);
        }
    }

    @Override // com.stepos.core.common.log.IDumpProvider
    public void dumpStats(PrintWriter writer) {
        g.f(writer, "writer");
        dumpSummaryLine(writer);
    }

    @Override // com.stepos.core.common.log.IDumpProvider
    public String getHelp() {
        return "Telemetry: --telemetry, --telemetry-last, --telemetry-since <wallMs>, --telemetry-clear; Cloud correlation: --cloud-correlation, --cloud-correlation-last";
    }

    @Override // com.stepos.core.common.log.IDumpProvider
    public LogModule getLogModule() {
        return this.logModule;
    }

    @Override // com.stepos.core.common.log.IDumpProvider
    public String getModuleName() {
        return this.moduleName;
    }

    @Override // com.stepos.core.common.log.IDumpProvider
    public boolean supportsArg(String arg) {
        g.f(arg, "arg");
        return o.k0(arg, "--telemetry", false) || o.k0(arg, "--cloud-correlation", false);
    }
}
