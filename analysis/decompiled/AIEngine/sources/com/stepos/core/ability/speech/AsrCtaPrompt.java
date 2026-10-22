package com.stepos.core.ability.speech;

import android.content.Context;
import com.stepos.core.ability.factory.AIEngineAbilityId;
import com.stepos.core.ability.handler.BinderResultHandler;
import com.stepos.core.ability.handler.IResultHandler;
import com.stepos.core.ability.handler.InferResult;
import com.stepos.core.ability.telemetry.ModelCallBridge;
import com.stepos.core.callback.IInferenceCallback;
import com.stepos.core.common.cloud.CloudErrorUserMessage;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.common.settings.UserSetupState;
import com.stepos.core.cta.CTADialogGate;
import com.stepos.core.error.AIEngineError;
import java.util.Set;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AsrCtaPrompt {
    private static final String TAG = "AsrCtaPrompt";
    public static final AsrCtaPrompt INSTANCE = new AsrCtaPrompt();
    private static final Set<String> ASR_ABILITY_IDS = mb.l.s0(new String[]{AIEngineAbilityId.ASR, AIEngineAbilityId.ASR_FILE, "stepos-asr-realtime", "stepos-asr-sse"});

    private AsrCtaPrompt() {
    }

    private final boolean canPromptAuthorization() {
        Context context = l7.a.f10344a;
        if (context == null) {
            context = null;
        }
        if (context == null) {
            AIEngineLogger.d(LogModule.ABILITY, TAG, "skip CTA dialog: ContextHolder not ready");
            return false;
        }
        if (UserSetupState.INSTANCE.isSetupComplete(context)) {
            return true;
        }
        AIEngineLogger.i(LogModule.ABILITY, TAG, "skip CTA dialog: user_setup_complete not complete");
        return false;
    }

    private final InferResult.Error cancelledResult() {
        return new InferResult.Error(-100, "CTA not granted");
    }

    private final InferResult.Error ctaDeniedResult() {
        return new InferResult.Error(AIEngineError.CTA_NOT_GRANTED, CloudErrorUserMessage.INSTANCE.ofCtaNotGranted(false));
    }

    private final void emitCancelled(String str, IInferenceCallback iInferenceCallback, String str2) {
        if (iInferenceCallback != null) {
            new BinderResultHandler(iInferenceCallback).onResult(str, INSTANCE.cancelledResult());
        }
        ModelCallBridge.reportTerminal$default(ModelCallBridge.INSTANCE, str, new InferResult.Error(-100, str2), null, 4, null);
    }

    private final void emitCtaDenied(String str, IInferenceCallback iInferenceCallback, String str2) {
        if (iInferenceCallback != null) {
            new BinderResultHandler(iInferenceCallback).onResult(str, INSTANCE.ctaDeniedResult());
        }
        ModelCallBridge.reportTerminal$default(ModelCallBridge.INSTANCE, str, new InferResult.Error(AIEngineError.CTA_NOT_GRANTED, str2), null, 4, null);
    }

    public final boolean handleCtaNotGranted(int i10, String inferId, IInferenceCallback iInferenceCallback, String devReason) {
        kotlin.jvm.internal.g.f(inferId, "inferId");
        kotlin.jvm.internal.g.f(devReason, "devReason");
        a0.a.x(h0.e.f("CTA not granted inferId=", inferId, " uid=", i10, ": "), devReason, LogModule.ABILITY, TAG);
        if (!canPromptAuthorization()) {
            emitCtaDenied(inferId, iInferenceCallback, devReason);
            return false;
        }
        emitCancelled(inferId, iInferenceCallback, devReason);
        CTADialogGate.INSTANCE.promptAuthorization(i10);
        return true;
    }

    public final boolean isAsrAbilityId(String abilityId) {
        kotlin.jvm.internal.g.f(abilityId, "abilityId");
        return ASR_ABILITY_IDS.contains(abilityId);
    }

    public final boolean handleCtaNotGranted(int i10, String inferId, IResultHandler resultHandler, String devReason) {
        kotlin.jvm.internal.g.f(inferId, "inferId");
        kotlin.jvm.internal.g.f(resultHandler, "resultHandler");
        kotlin.jvm.internal.g.f(devReason, "devReason");
        a0.a.x(h0.e.f("CTA not granted inferId=", inferId, " uid=", i10, ": "), devReason, LogModule.ABILITY, TAG);
        if (!canPromptAuthorization()) {
            resultHandler.onResult(inferId, ctaDeniedResult());
            ModelCallBridge.reportTerminal$default(ModelCallBridge.INSTANCE, inferId, new InferResult.Error(AIEngineError.CTA_NOT_GRANTED, devReason), null, 4, null);
            return false;
        }
        resultHandler.onResult(inferId, cancelledResult());
        ModelCallBridge.reportTerminal$default(ModelCallBridge.INSTANCE, inferId, new InferResult.Error(-100, devReason), null, 4, null);
        CTADialogGate.INSTANCE.promptAuthorization(i10);
        return true;
    }
}
