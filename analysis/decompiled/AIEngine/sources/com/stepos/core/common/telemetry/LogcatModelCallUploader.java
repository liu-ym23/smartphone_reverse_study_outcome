package com.stepos.core.common.telemetry;

import android.util.Log;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import kotlin.NoWhenBranchMatchedException;
import org.json.JSONException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class LogcatModelCallUploader implements ModelCallUploader {
    private static final String AUDIT_TAG = "ModelCall";
    public static final LogcatModelCallUploader INSTANCE = new LogcatModelCallUploader();
    private static final String TAG = "ModelCallReporter";

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ModelCallExecutionPath.values().length];
            try {
                iArr[ModelCallExecutionPath.EDGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ModelCallExecutionPath.CLOUD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private LogcatModelCallUploader() {
    }

    @Override // com.stepos.core.common.telemetry.ModelCallUploader
    public void onDownlink(ModelCallRecord record) throws JSONException {
        String str;
        kotlin.jvm.internal.g.f(record, "record");
        a0.a.y("MODEL_CALL_DOWNLINK ", record.toLogJson(), TAG);
        AIEngineLogger.i(LogModule.ABILITY, TAG, "MODEL_CALL_DOWNLINK " + record.toLogJson());
        int i10 = WhenMappings.$EnumSwitchMapping$0[record.getExecutionPath().ordinal()];
        if (i10 == 1) {
            str = "EDGE";
        } else {
            if (i10 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            str = "CLOUD";
        }
        LogModule logModule = LogModule.INFERENCE;
        String abilityId = record.getAbilityId();
        String modelId = record.getModelId();
        String status = record.getStatus();
        long e2eMs = record.getE2eMs();
        long ttftMs = record.getTtftMs();
        int errorCode = record.getErrorCode();
        String callerPkg = record.getCallerPkg();
        String inferId = record.getInferId();
        StringBuilder sbS = ai.onnxruntime.a.s("[INFER-AUDIT] ability=", abilityId, " modelId=", modelId, " loc=");
        ai.onnxruntime.a.z(sbS, str, " status=", status, " e2eMs=");
        sbS.append(e2eMs);
        a0.a.s(ttftMs, " ttftMs=", " err=", sbS);
        h0.e.h(errorCode, " pkg=", callerPkg, " inferId=", sbS);
        a0.a.z(sbS, inferId, logModule, AUDIT_TAG);
    }

    @Override // com.stepos.core.common.telemetry.ModelCallUploader
    public void onFirstCall(ModelCallRecord record) throws JSONException {
        kotlin.jvm.internal.g.f(record, "record");
        String str = "MODEL_CALL_FIRST " + record.toLogJson();
        Log.i(TAG, str);
        AIEngineLogger.i(LogModule.ABILITY, TAG, str);
    }

    @Override // com.stepos.core.common.telemetry.ModelCallUploader
    public void onUplink(ModelCallRecord record) {
        kotlin.jvm.internal.g.f(record, "record");
        a0.a.y("MODEL_CALL_UPLINK ", record.toEstablishedLogJson(), TAG);
        h0.e.k("MODEL_CALL_UPLINK ", record.toEstablishedLogJson(), LogModule.ABILITY, TAG);
    }
}
