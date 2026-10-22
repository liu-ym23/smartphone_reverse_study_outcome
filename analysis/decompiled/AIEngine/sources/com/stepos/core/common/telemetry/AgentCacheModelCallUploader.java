package com.stepos.core.common.telemetry;

import com.stepos.agentcache.sdk.api.AgentCacheSdk;
import com.stepos.agentcache.sdk.api.LogLevel;
import com.stepos.agentcache.sdk.api.LogMessage;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.cta.CtaGateManager;
import gc.q;
import java.util.Map;
import kotlin.Result;
import lb.n;
import org.json.JSONException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AgentCacheModelCallUploader implements ModelCallUploader {
    public static final AgentCacheModelCallUploader INSTANCE = new AgentCacheModelCallUploader();
    private static final String TAG = "ModelCallFlywheel";

    private AgentCacheModelCallUploader() {
    }

    private final boolean ctaAllowsReport(ModelCallRecord modelCallRecord, String str) {
        if (CtaGateManager.INSTANCE.isGranted()) {
            return true;
        }
        logSkipReportLog(modelCallRecord, str, "CTA not granted");
        return false;
    }

    private final String downlinkLog(ModelCallRecord modelCallRecord) {
        String status = modelCallRecord.getStatus();
        long e2eMs = modelCallRecord.getE2eMs();
        int errorCode = modelCallRecord.getErrorCode();
        ModelCallFlywheelBizMapper modelCallFlywheelBizMapper = ModelCallFlywheelBizMapper.INSTANCE;
        String strStepTraceId = modelCallFlywheelBizMapper.stepTraceId(modelCallRecord);
        if (strStepTraceId == null) {
            strStepTraceId = "";
        }
        String strReportLogFields = modelCallFlywheelBizMapper.reportLogFields(modelCallRecord);
        StringBuilder sbL = com.stepos.core.ota.d.l("status=", e2eMs, status, " e2eMs=");
        sbL.append(" errorCode=");
        sbL.append(errorCode);
        sbL.append(" stepTraceId=");
        sbL.append(strStepTraceId);
        return ai.onnxruntime.a.o(sbL, " ", strReportLogFields);
    }

    private final String firstLog(ModelCallRecord modelCallRecord) {
        long ttftMs = modelCallRecord.getTtftMs();
        String abilityId = modelCallRecord.getAbilityId();
        return ai.onnxruntime.a.o(a0.a.o("first_response_ms=", ttftMs, " abilityId=", abilityId), " ", ModelCallFlywheelBizMapper.INSTANCE.reportLogFields(modelCallRecord));
    }

    private final void invokeReportLog(ModelCallRecord modelCallRecord, String str, LogMessage logMessage, int i10) {
        logReportLog(modelCallRecord, str, logMessage, i10);
        AgentCacheSdk.INSTANCE.reportLog(str, ModelCallFlywheelBizMapper.NODE_NAME, logMessage, i10);
    }

    private final void logReportEvent(ModelCallRecord modelCallRecord, String str, Map<String, ? extends Object> map, Map<String, ? extends Object> map2, int i10) {
        LogModule logModule = LogModule.SERVICE;
        StringBuilder sbS = ai.onnxruntime.a.s("reportEvent inferId=", modelCallRecord.getInferId(), " traceId=", str, " nodeName=model_call statusCode=");
        sbS.append(i10);
        sbS.append(" commonFields=");
        sbS.append(map);
        sbS.append(" bizData=");
        sbS.append(map2);
        sbS.append(" inputText= outputText=");
        AIEngineLogger.d(logModule, TAG, sbS.toString());
    }

    private final void logReportLog(ModelCallRecord modelCallRecord, String str, LogMessage logMessage, int i10) {
        LogModule logModule = LogModule.SERVICE;
        StringBuilder sb2 = new StringBuilder("reportLog inferId=");
        sb2.append(modelCallRecord.getInferId());
        sb2.append(" traceId=");
        sb2.append(str);
        sb2.append(" nodeName=model_call level=");
        sb2.append(logMessage.getLevel());
        sb2.append(" event=");
        sb2.append(logMessage.getEvent());
        sb2.append(" statusCode=");
        sb2.append(i10);
        sb2.append(" log=");
        sb2.append(logMessage.getLog());
        String stack = logMessage.getStack();
        if (stack != null) {
            if (q.t0(stack)) {
                stack = null;
            }
            if (stack != null) {
                sb2.append(" stack=");
                sb2.append(stack);
            }
        }
        n nVar = n.f10413a;
        String string = sb2.toString();
        kotlin.jvm.internal.g.e(string, "toString(...)");
        AIEngineLogger.d(logModule, TAG, string);
    }

    private final void logSkipReportLog(ModelCallRecord modelCallRecord, String str, String str2) {
        LogModule logModule = LogModule.SERVICE;
        StringBuilder sbS = ai.onnxruntime.a.s("reportLog skipped event=", str, " inferId=", modelCallRecord.getInferId(), " reason=");
        sbS.append(str2);
        AIEngineLogger.d(logModule, TAG, sbS.toString());
    }

    private final String uplinkLog(ModelCallRecord modelCallRecord) {
        String abilityId = modelCallRecord.getAbilityId();
        String transport = modelCallRecord.getTransport();
        ModelCallFlywheelBizMapper modelCallFlywheelBizMapper = ModelCallFlywheelBizMapper.INSTANCE;
        String strStepTraceId = modelCallFlywheelBizMapper.stepTraceId(modelCallRecord);
        if (strStepTraceId == null) {
            strStepTraceId = "";
        }
        return ai.onnxruntime.a.p(ai.onnxruntime.a.s("abilityId=", abilityId, " transport=", transport, " stepTraceId="), strStepTraceId, " ", modelCallFlywheelBizMapper.reportLogFields(modelCallRecord));
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    @Override // com.stepos.core.common.telemetry.ModelCallUploader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onDownlink(com.stepos.core.common.telemetry.ModelCallRecord r11) throws org.json.JSONException {
        /*
            r10 = this;
            java.lang.String r0 = "record"
            kotlin.jvm.internal.g.f(r11, r0)
            com.stepos.core.common.telemetry.LogcatModelCallUploader r0 = com.stepos.core.common.telemetry.LogcatModelCallUploader.INSTANCE
            r0.onDownlink(r11)
            java.lang.String r0 = "downlink"
            boolean r1 = r10.ctaAllowsReport(r11, r0)
            if (r1 != 0) goto L14
            goto L8b
        L14:
            com.stepos.core.common.telemetry.ModelCallFlywheelBizMapper r1 = com.stepos.core.common.telemetry.ModelCallFlywheelBizMapper.INSTANCE
            java.lang.String r3 = r1.reportTraceId(r11)
            boolean r2 = gc.q.t0(r3)
            if (r2 == 0) goto L26
            java.lang.String r1 = "blank traceId"
            r10.logSkipReportLog(r11, r0, r1)
            return
        L26:
            int r7 = r1.statusCode(r11)
            com.stepos.agentcache.sdk.api.LogMessage r2 = new com.stepos.agentcache.sdk.api.LogMessage
            r4 = 200(0xc8, float:2.8E-43)
            if (r7 != r4) goto L33
            com.stepos.agentcache.sdk.api.LogLevel r4 = com.stepos.agentcache.sdk.api.LogLevel.INFO
            goto L35
        L33:
            com.stepos.agentcache.sdk.api.LogLevel r4 = com.stepos.agentcache.sdk.api.LogLevel.WARN
        L35:
            java.lang.String r5 = r10.downlinkLog(r11)
            java.lang.String r6 = ""
            r2.<init>(r4, r0, r5, r6)
            r10.invokeReportLog(r11, r3, r2, r7)     // Catch: java.lang.Throwable -> L69
            java.util.Map r6 = r1.bizData(r11)     // Catch: java.lang.Throwable -> L69
            java.util.Map r5 = r1.commonFields(r0)     // Catch: java.lang.Throwable -> L69
            r2 = r10
            r4 = r3
            r3 = r11
            r2.logReportEvent(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L66
            r10 = r3
            r3 = r4
            com.stepos.agentcache.sdk.api.AgentCacheSdk r2 = com.stepos.agentcache.sdk.api.AgentCacheSdk.INSTANCE     // Catch: java.lang.Throwable -> L63
            java.lang.String r4 = "model_call"
            r9 = r7
            java.lang.String r7 = ""
            java.lang.String r8 = ""
            boolean r11 = r2.reportEvent(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L63
            java.lang.Boolean r11 = java.lang.Boolean.valueOf(r11)     // Catch: java.lang.Throwable -> L63
            goto L70
        L63:
            r0 = move-exception
        L64:
            r11 = r0
            goto L6c
        L66:
            r0 = move-exception
            r10 = r3
            goto L64
        L69:
            r0 = move-exception
            r10 = r11
            goto L64
        L6c:
            kotlin.Result$Failure r11 = kotlin.c.a(r11)
        L70:
            java.lang.Throwable r11 = kotlin.Result.b(r11)
            if (r11 == 0) goto L8b
            com.stepos.core.common.log.LogModule r0 = com.stepos.core.common.log.LogModule.SERVICE
            java.lang.String r10 = r10.getInferId()
            java.lang.String r1 = "report downlink failed inferId="
            java.lang.String r10 = ai.onnxruntime.a.k(r1, r10)
            java.lang.Object[] r10 = new java.lang.Object[]{r10, r11}
            java.lang.String r11 = "ModelCallFlywheel"
            com.stepos.core.common.log.AIEngineLogger.w(r0, r11, r10)
        L8b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.common.telemetry.AgentCacheModelCallUploader.onDownlink(com.stepos.core.common.telemetry.ModelCallRecord):void");
    }

    @Override // com.stepos.core.common.telemetry.ModelCallUploader
    public void onFirstCall(ModelCallRecord record) throws JSONException {
        Object objA;
        kotlin.jvm.internal.g.f(record, "record");
        LogcatModelCallUploader.INSTANCE.onFirstCall(record);
        if (ctaAllowsReport(record, "model_call.first")) {
            String strReportTraceId = ModelCallFlywheelBizMapper.INSTANCE.reportTraceId(record);
            if (q.t0(strReportTraceId)) {
                logSkipReportLog(record, "model_call.first", "blank traceId");
                return;
            }
            try {
                invokeReportLog(record, strReportTraceId, new LogMessage(LogLevel.INFO, "model_call.first", firstLog(record), ""), 200);
                objA = n.f10413a;
            } catch (Throwable th) {
                objA = kotlin.c.a(th);
            }
            Throwable thB = Result.b(objA);
            if (thB != null) {
                AIEngineLogger.w(LogModule.SERVICE, TAG, ai.onnxruntime.a.k("reportLog first failed inferId=", record.getInferId()), thB);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    @Override // com.stepos.core.common.telemetry.ModelCallUploader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onUplink(com.stepos.core.common.telemetry.ModelCallRecord r11) {
        /*
            r10 = this;
            java.lang.String r0 = "record"
            kotlin.jvm.internal.g.f(r11, r0)
            com.stepos.core.common.telemetry.LogcatModelCallUploader r0 = com.stepos.core.common.telemetry.LogcatModelCallUploader.INSTANCE
            r0.onUplink(r11)
            java.lang.String r0 = "uplink"
            boolean r1 = r10.ctaAllowsReport(r11, r0)
            if (r1 != 0) goto L14
            goto L85
        L14:
            com.stepos.core.common.telemetry.ModelCallFlywheelBizMapper r1 = com.stepos.core.common.telemetry.ModelCallFlywheelBizMapper.INSTANCE
            java.lang.String r3 = r1.reportTraceId(r11)
            boolean r2 = gc.q.t0(r3)
            if (r2 == 0) goto L26
            java.lang.String r1 = "blank traceId"
            r10.logSkipReportLog(r11, r0, r1)
            return
        L26:
            com.stepos.agentcache.sdk.api.LogMessage r2 = new com.stepos.agentcache.sdk.api.LogMessage
            com.stepos.agentcache.sdk.api.LogLevel r4 = com.stepos.agentcache.sdk.api.LogLevel.INFO
            java.lang.String r5 = r10.uplinkLog(r11)
            java.lang.String r6 = ""
            r2.<init>(r4, r0, r5, r6)
            r4 = 200(0xc8, float:2.8E-43)
            r10.invokeReportLog(r11, r3, r2, r4)     // Catch: java.lang.Throwable -> L63
            java.util.Map r6 = r1.uplinkBizData(r11)     // Catch: java.lang.Throwable -> L63
            java.util.Map r5 = r1.commonFields(r0)     // Catch: java.lang.Throwable -> L63
            r7 = 200(0xc8, float:2.8E-43)
            r2 = r10
            r4 = r3
            r3 = r11
            r2.logReportEvent(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L60
            r10 = r3
            r3 = r4
            com.stepos.agentcache.sdk.api.AgentCacheSdk r2 = com.stepos.agentcache.sdk.api.AgentCacheSdk.INSTANCE     // Catch: java.lang.Throwable -> L5d
            java.lang.String r4 = "model_call"
            java.lang.String r7 = ""
            java.lang.String r8 = ""
            r9 = 200(0xc8, float:2.8E-43)
            boolean r11 = r2.reportEvent(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L5d
            java.lang.Boolean r11 = java.lang.Boolean.valueOf(r11)     // Catch: java.lang.Throwable -> L5d
            goto L6a
        L5d:
            r0 = move-exception
        L5e:
            r11 = r0
            goto L66
        L60:
            r0 = move-exception
            r10 = r3
            goto L5e
        L63:
            r0 = move-exception
            r10 = r11
            goto L5e
        L66:
            kotlin.Result$Failure r11 = kotlin.c.a(r11)
        L6a:
            java.lang.Throwable r11 = kotlin.Result.b(r11)
            if (r11 == 0) goto L85
            com.stepos.core.common.log.LogModule r0 = com.stepos.core.common.log.LogModule.SERVICE
            java.lang.String r10 = r10.getInferId()
            java.lang.String r1 = "report uplink failed inferId="
            java.lang.String r10 = ai.onnxruntime.a.k(r1, r10)
            java.lang.Object[] r10 = new java.lang.Object[]{r10, r11}
            java.lang.String r11 = "ModelCallFlywheel"
            com.stepos.core.common.log.AIEngineLogger.w(r0, r11, r10)
        L85:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.common.telemetry.AgentCacheModelCallUploader.onUplink(com.stepos.core.common.telemetry.ModelCallRecord):void");
    }
}
