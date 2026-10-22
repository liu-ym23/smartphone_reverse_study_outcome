package com.stepos.core.ability.speech;

import com.stepos.core.ability.speech.AsrWsModels;
import com.stepos.core.common.cloud.CloudSseEventLog;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AsrTranscriptLog {
    public static final String PROP_ENABLE = "debug.aiengine.asr.textlog";
    private static final String TAG = "AsrTranscriptLog";
    public static final AsrTranscriptLog INSTANCE = new AsrTranscriptLog();
    private static final AtomicBoolean announced = new AtomicBoolean(false);

    private AsrTranscriptLog() {
    }

    public final String formatWsEvent(String raw, boolean z) {
        kotlin.jvm.internal.g.f(raw, "raw");
        return z ? raw : AsrWsModels.INSTANCE.formatForDiagLog(raw);
    }

    public final boolean isEnabled() {
        boolean zIsEnabled = PcmDumpBudget.INSTANCE.isEnabled(PROP_ENABLE);
        if (zIsEnabled && announced.compareAndSet(false, true)) {
            AIEngineLogger.i(LogModule.ABILITY, TAG, "plaintext transcript log ENABLED (setprop debug.aiengine.asr.textlog 1); disable with setprop debug.aiengine.asr.textlog 0");
        }
        return zIsEnabled;
    }

    public final String textFieldSuffix(String text, boolean z) {
        kotlin.jvm.internal.g.f(text, "text");
        return z ? " text=".concat(text) : "";
    }

    public final String textForLog(String text, boolean z) {
        kotlin.jvm.internal.g.f(text, "text");
        return z ? text : CloudSseEventLog.INSTANCE.redactText(text);
    }

    public final String wsEventTextSuffix(AsrWsModels.ServerEvent event, boolean z) {
        kotlin.jvm.internal.g.f(event, "event");
        if (!z) {
            return "";
        }
        if (!(event instanceof AsrWsModels.ServerEvent.Delta)) {
            return event instanceof AsrWsModels.ServerEvent.Completed ? ai.onnxruntime.a.k(" text=", ((AsrWsModels.ServerEvent.Completed) event).getText()) : "";
        }
        AsrWsModels.ServerEvent.Delta delta = (AsrWsModels.ServerEvent.Delta) event;
        return a0.a.k(" text=", delta.getText(), delta.getStash().length() > 0 ? ai.onnxruntime.a.k(" stash=", delta.getStash()) : "");
    }
}
