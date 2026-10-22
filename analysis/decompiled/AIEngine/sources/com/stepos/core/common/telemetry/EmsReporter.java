package com.stepos.core.common.telemetry;

import android.os.PersistableBundle;
import android.os.Process;
import android.util.Log;
import com.stepos.core.ability.speech.PcmDumpBudget;
import com.stepos.deepbinder.annotation.BaseConstantsKt;
import com.stepos.ems.ExceptionManager;
import com.stepos.ems.IExceptionManagerListener;
import com.stepos.ems.exception.actions.impl.ClientAction;
import com.stepos.ems.type.ExceptionType;
import com.stepos.ems.type.LevelType;
import com.tonyodev.fetch2core.server.FileResponse;
import gc.q;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Pair;
import kotlin.Result;
import lb.n;
import mb.l;
import mb.y;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class EmsReporter {
    public static final String AI_POWER_PERF_CODE = "8030001001";
    private static final String TAG = "EmsReporter";
    public static final EmsReporter INSTANCE = new EmsReporter();
    private static final AtomicLong emsOkCount = new AtomicLong();
    private static final AtomicLong emsFailCount = new AtomicLong();

    private EmsReporter() {
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
        if (aiPowerPerfRecord.getExpLogId().length() > 0) {
            jSONObject.put("expLogId", aiPowerPerfRecord.getExpLogId());
        }
        if (aiPowerPerfRecord.getEngineSceneId() != 0) {
            jSONObject.put("engineSceneId", aiPowerPerfRecord.getEngineSceneId());
        }
        JSONArray jSONArray = new JSONArray();
        Set setS0 = l.s0(new String[]{FailStage.VIT_ENCODE, FailStage.AUDIO_ENCODE});
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (PhaseRecord phaseRecord : aiPowerPerfRecord.getPhases()) {
            String phase = setS0.contains(phaseRecord.getPhase()) ? "ENCODE" : phaseRecord.getPhase();
            Integer num = (Integer) linkedHashMap.get(phase);
            linkedHashMap.put(phase, Integer.valueOf(phaseRecord.getDurationMs() + (num != null ? num.intValue() : 0)));
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            String str = (String) entry.getKey();
            int iIntValue = ((Number) entry.getValue()).intValue();
            if (iIntValue > 0) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("phase", str);
                jSONObject2.put("durationMs", iIntValue);
                jSONArray.put(jSONObject2);
            }
        }
        jSONObject.put("phases", jSONArray);
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
            Integer inputSizeBytes = dataVolume.getInputSizeBytes();
            if (inputSizeBytes != null) {
                jSONObject3.put("inputSizeBytes", inputSizeBytes.intValue());
            }
            Integer outputSizeBytes = dataVolume.getOutputSizeBytes();
            if (outputSizeBytes != null) {
                jSONObject3.put("outputSizeBytes", outputSizeBytes.intValue());
            }
            n nVar = n.f10413a;
            jSONObject.put("dataVolume", jSONObject3);
        }
        String string = jSONObject.toString();
        kotlin.jvm.internal.g.e(string, "toString(...)");
        return string;
    }

    private final void reportAiException(InferExceptionRecord inferExceptionRecord, String str) throws IOException {
        Object objA;
        File fileSnapshotFile = ExceptionLogStore.INSTANCE.snapshotFile(str);
        if (fileSnapshotFile == null) {
            return;
        }
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("subject", "AI exception: " + inferExceptionRecord.glanceLabel());
        persistableBundle.putString("exp_log_id", str);
        persistableBundle.putString("subType", inferExceptionRecord.emsSubType());
        String abilityId = inferExceptionRecord.getAbilityId();
        if (q.t0(abilityId)) {
            abilityId = inferExceptionRecord.getModelId();
        }
        persistableBundle.putString("ability_id", abilityId);
        persistableBundle.putString("package", "com.stepos.aiengine");
        persistableBundle.putString("process", "com.stepos.aiengine");
        persistableBundle.putInt("pid", Process.myPid());
        persistableBundle.putInt("uid", Process.myUid());
        String strEmsDetailBody$default = InferExceptionRecord.emsDetailBody$default(inferExceptionRecord, 0, 1, null);
        persistableBundle.putString("exp_reason", inferExceptionRecord.emsReason());
        persistableBundle.putString("exp_detail", strEmsDetailBody$default);
        persistableBundle.putString("summaryLog", strEmsDetailBody$default);
        persistableBundle.putString("stack", strEmsDetailBody$default);
        persistableBundle.putString("detail", strEmsDetailBody$default);
        try {
            objA = ExceptionManager.getInstance().reportException(ExceptionType.AI_EXCEPTION, LevelType.FATAL, persistableBundle, (IExceptionManagerListener) null);
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            Log.w(TAG, "reportException failed: expLogId=" + str, thB);
        }
        List list = (List) (objA instanceof Result.Failure ? null : objA);
        if (list == null) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            FileDescriptor typeFileDescriptor = ((ClientAction) it.next()).getTypeFileDescriptor("aiLog");
            if (typeFileDescriptor != null && typeFileDescriptor.valid()) {
                try {
                    FileInputStream fileInputStream = new FileInputStream(fileSnapshotFile);
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(typeFileDescriptor);
                        try {
                            byte[] bArr = new byte[PcmDumpBudget.HARD_MAX_DIR_MB];
                            while (true) {
                                int i10 = fileInputStream.read(bArr);
                                if (i10 <= 0) {
                                    break;
                                } else {
                                    fileOutputStream.write(bArr, 0, i10);
                                }
                            }
                            fileOutputStream.flush();
                            fileOutputStream.getFD().sync();
                            n nVar = n.f10413a;
                            fileOutputStream.close();
                            fileInputStream.close();
                        } catch (Throwable th2) {
                            try {
                                throw th2;
                            } catch (Throwable th3) {
                                y.q(fileOutputStream, th2);
                                throw th3;
                            }
                        }
                    } finally {
                    }
                } catch (Exception e10) {
                    Log.w(TAG, "write aiLog fd failed", e10);
                }
            }
        }
    }

    public final Pair<Long, Long> emsExceptionStats() {
        return new Pair<>(Long.valueOf(emsOkCount.get()), Long.valueOf(emsFailCount.get()));
    }

    public final void reportAiPowerPerf(AiPowerPerfRecord record) {
        Object objA;
        kotlin.jvm.internal.g.f(record, "record");
        Log.i(TAG, "EMS_REC " + recordToJson(record));
        if (shouldReportToEms$common_release(record.getErrorCode())) {
            try {
                Map<String, String> tags = record.toTags();
                ExceptionManager.getInstance().writeExceptionCode(AI_POWER_PERF_CODE, new HashMap(tags));
                objA = Integer.valueOf(Log.i(TAG, "writeExceptionCode ok: code=8030001001, tags.size=" + tags.size()));
            } catch (Throwable th) {
                objA = kotlin.c.a(th);
            }
            Throwable thB = Result.b(objA);
            if (thB != null) {
                Log.w(TAG, "writeExceptionCode failed: code=8030001001", thB);
            }
        }
    }

    public final void reportInferException(InferExceptionRecord record) {
        Object objA;
        kotlin.jvm.internal.g.f(record, "record");
        if (shouldReportToEms$common_release(record.getErrorCode())) {
            String expLogId = record.getExpLogId();
            if (expLogId.length() == 0) {
                return;
            }
            HashMap map = new HashMap(record.toTags());
            map.put("exp_log_id", expLogId);
            try {
                ExceptionManager.getInstance().writeExceptionCode(AI_POWER_PERF_CODE, map);
                objA = n.f10413a;
            } catch (Throwable th) {
                objA = kotlin.c.a(th);
            }
            Throwable thB = Result.b(objA);
            if (thB != null) {
                Log.w(TAG, "writeExceptionCode threw: code=8030001001", thB);
            }
            boolean z = objA instanceof Result.Failure;
            boolean z3 = !z;
            (!z ? emsOkCount : emsFailCount).incrementAndGet();
            int errorCode = record.getErrorCode();
            int size = map.size();
            StringBuilder sbF = h0.e.f("reportInferException code=8030001001 expLogId=", expLogId, " errorCode=", errorCode, " tags=");
            sbF.append(size);
            sbF.append(" ok=");
            sbF.append(z3);
            Log.i(TAG, sbF.toString());
            reportAiException(record, expLogId);
        }
    }

    public final boolean shouldReportToEms$common_release(int i10) {
        return i10 != 110001;
    }
}
