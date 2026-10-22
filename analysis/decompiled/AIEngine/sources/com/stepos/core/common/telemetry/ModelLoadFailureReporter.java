package com.stepos.core.common.telemetry;

import android.os.Process;
import android.os.SystemClock;
import com.stepos.base.model.ModelLoadException;
import com.stepos.core.common.log.Sanitizer;
import com.stepos.core.common.utils.AppUtils;
import com.stepos.core.error.AIEngineError;
import gc.o;
import gc.r;
import mb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelLoadFailureReporter {
    public static final ModelLoadFailureReporter INSTANCE = new ModelLoadFailureReporter();
    private static final int MAX_EXCEPTION_MSG = 256;
    private static final int STACK_DIGEST_BYTES = 8;
    private static final int STACK_DIGEST_FRAMES = 8;

    private ModelLoadFailureReporter() {
    }

    private final String digestStack(Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        kotlin.jvm.internal.g.e(stackTrace, "getStackTrace(...)");
        String strZ0 = kotlin.collections.a.z0(l.m0(stackTrace), "\n", null, null, new com.stepos.core.common.cloud.d(8), 30);
        return strZ0.length() == 0 ? "" : Sanitizer.hashHex(strZ0, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence digestStack$lambda$1(StackTraceElement stackTraceElement) {
        return stackTraceElement.getClassName() + "#" + stackTraceElement.getMethodName() + ":" + stackTraceElement.getLineNumber();
    }

    private final int resolveErrorCode(Throwable th) {
        Integer num;
        ModelLoadException modelLoadException = th instanceof ModelLoadException ? (ModelLoadException) th : null;
        return (modelLoadException == null || (num = modelLoadException.f6319a) == null) ? AIEngineError.MODEL_LOAD_FAILED : num.intValue();
    }

    public final void report(String str, String modelId, boolean z, String backendKey, Throwable error) {
        String abilityId = str;
        kotlin.jvm.internal.g.f(abilityId, "abilityId");
        kotlin.jvm.internal.g.f(modelId, "modelId");
        kotlin.jvm.internal.g.f(backendKey, "backendKey");
        kotlin.jvm.internal.g.f(error, "error");
        long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iResolveErrorCode = resolveErrorCode(error);
        String strConcat = "load-".concat(modelId);
        String strO = ai.onnxruntime.a.o(ai.onnxruntime.a.r(jCurrentTimeMillis, "E", "-", iResolveErrorCode), "-", r.R0(8, strConcat));
        String strText = Sanitizer.text(error.getMessage(), 256);
        Integer numCurrentCallerUid = LoadCallerContext.INSTANCE.currentCallerUid();
        int iIntValue = numCurrentCallerUid != null ? numCurrentCallerUid.intValue() : Process.myUid();
        String callerPackage = numCurrentCallerUid != null ? AppUtils.INSTANCE.getCallerPackage(numCurrentCallerUid.intValue()) : "com.stepos.aiengine";
        boolean zIsCallerForeground = numCurrentCallerUid != null ? AppUtils.INSTANCE.isCallerForeground(numCurrentCallerUid.intValue()) : z;
        AiPowerEventBus aiPowerEventBus = AiPowerEventBus.INSTANCE;
        if (abilityId.length() == 0) {
            abilityId = modelId;
        }
        int i10 = iIntValue;
        aiPowerEventBus.post(new AiPowerPerfRecord("", strConcat, i10, callerPackage, abilityId, modelId, "", EngineVersionProvider.INSTANCE.get(), backendKey, o.k0(backendKey, "QNN_", false) ? "NPU" : "CPU", "LOCAL", jElapsedRealtimeNanos, jElapsedRealtimeNanos, jCurrentTimeMillis, 0L, 0L, 0.0f, "COLD", 0, 0, 0, 0, 0, 0L, null, 0, 0, 0.0f, "FAILED", iResolveErrorCode, strO, zIsCallerForeground, error.getClass().getSimpleName(), strText, digestStack(error), FailStack.format$default(FailStack.INSTANCE, error, 0, 2, null), 0L, null, FailStage.MODEL_LOAD, null, 0, null, null, 267911168, 1968, null));
    }
}
