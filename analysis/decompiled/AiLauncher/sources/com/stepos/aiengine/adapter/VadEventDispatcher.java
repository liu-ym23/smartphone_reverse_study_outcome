package com.stepos.aiengine.adapter;

import Y8.t;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.adapter.VadEventDispatcher;
import com.stepos.aiengine.algorithm.vad.VadDetectionListener;
import com.stepos.core.callback.InferResult;
import com.stepos.core.data.ContentParams;
import com.stepos.core.data.TextContent;
import com.stepos.core.data.base.Content;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.i;
import p9.p;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u0000 \u00112\u00020\u0001:\u0001\u0013B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u001a\b\u0002\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\b\u0010\tJ#\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R&\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/stepos/aiengine/adapter/VadEventDispatcher;", "", "Lcom/stepos/aiengine/algorithm/vad/VadDetectionListener;", "listener", "Lkotlin/Function2;", "", "LY8/t;", "logTerminal", "<init>", "(Lcom/stepos/aiengine/algorithm/vad/VadDetectionListener;Lp9/p;)V", "inferId", "Lcom/stepos/core/callback/InferResult;", "Lcom/stepos/core/data/base/Content;", "result", "onInferResult", "(Ljava/lang/String;Lcom/stepos/core/callback/InferResult;)V", UxipConstants.f30680s, "c", "(Lcom/stepos/core/data/base/Content;)V", Const.INTENT_KEY_APIKEY, "Lcom/stepos/aiengine/algorithm/vad/VadDetectionListener;", Const.INTENT_KEY_PKGNAME, "Lp9/p;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class VadEventDispatcher {

    @Deprecated
    public static final String EVENT_AUDIO_LEVEL = "vad.audio_level";

    @Deprecated
    public static final String EVENT_SPEECH_END = "vad.speech_end";

    @Deprecated
    public static final String EVENT_SPEECH_START = "vad.speech_start";

    @Deprecated
    public static final String EVENT_WARNING = "vad.warning";

    @Deprecated
    public static final String KEY_ELAPSED_MS = "vad.elapsed_ms";

    @Deprecated
    public static final String KEY_END_REASON = "vad.end_reason";

    @Deprecated
    public static final String KEY_EVENT_TYPE = "vad.event_type";

    @Deprecated
    public static final String KEY_PEAK = "vad.peak";

    @Deprecated
    public static final String KEY_PROBABILITY = "vad.probability";

    @Deprecated
    public static final String KEY_RMS = "vad.rms";

    @Deprecated
    public static final String KEY_WARNING_CODE = "vad.warning_code";

    @Deprecated
    public static final String KEY_WARNING_MESSAGE = "vad.warning_message";

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final VadDetectionListener listener;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final p<String, String, t> logTerminal;

    /* JADX WARN: Multi-variable type inference failed */
    public VadEventDispatcher(VadDetectionListener listener, p<? super String, ? super String, t> logTerminal) {
        kotlin.jvm.internal.p.i(listener, "listener");
        kotlin.jvm.internal.p.i(logTerminal, "logTerminal");
        this.listener = listener;
        this.logTerminal = logTerminal;
    }

    public static final t b(String str, String str2) {
        kotlin.jvm.internal.p.i(str, "<unused var>");
        kotlin.jvm.internal.p.i(str2, "<unused var>");
        return t.f7040a;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    public final void c(Content value) {
        ContentParams params;
        TextContent textContent = value instanceof TextContent ? (TextContent) value : null;
        if (textContent == null || (params = textContent.getParams()) == null) {
            return;
        }
        String string = params.getString(KEY_EVENT_TYPE, "");
        switch (string.hashCode()) {
            case -1146649978:
                if (string.equals(EVENT_AUDIO_LEVEL)) {
                    this.listener.onAudioLevel(params.getFloat(KEY_RMS, 0.0f), params.getFloat(KEY_PEAK, 0.0f), params.getFloat(KEY_PROBABILITY, 0.0f));
                    break;
                }
                break;
            case -425331846:
                if (string.equals(EVENT_SPEECH_START)) {
                    this.listener.onSpeechStart(params.getLong(KEY_ELAPSED_MS, 0L));
                    break;
                }
                break;
            case 158686663:
                if (string.equals(EVENT_WARNING)) {
                    this.listener.onWarning(params.getString(KEY_WARNING_CODE, ""), params.getString(KEY_WARNING_MESSAGE, ""));
                    break;
                }
                break;
            case 1657642483:
                if (string.equals(EVENT_SPEECH_END)) {
                    this.listener.onSpeechEnd(params.getLong(KEY_ELAPSED_MS, 0L), params.getString(KEY_END_REASON, ""));
                    break;
                }
                break;
        }
    }

    public final void onInferResult(String inferId, InferResult<? extends Content> result) {
        kotlin.jvm.internal.p.i(inferId, "inferId");
        kotlin.jvm.internal.p.i(result, "result");
        if (result instanceof InferResult.Result) {
            c(((InferResult.Result) result).getValue());
            return;
        }
        if (result instanceof InferResult.Error) {
            InferResult.Error error = (InferResult.Error) result;
            this.logTerminal.invoke(inferId, "onError(" + error.getErrorCode() + ")");
            this.listener.onError(error.getErrorCode(), error.getMessage());
            return;
        }
        if (kotlin.jvm.internal.p.d(result, InferResult.Complete.INSTANCE)) {
            this.logTerminal.invoke(inferId, "onComplete");
        } else if (result instanceof InferResult.Cancelled) {
            this.logTerminal.invoke(inferId, "onCancelled");
        } else if (!(result instanceof InferResult.Progress) && !(result instanceof InferResult.RoutingDecision)) {
            throw new NoWhenBranchMatchedException();
        }
    }

    public /* synthetic */ VadEventDispatcher(VadDetectionListener vadDetectionListener, p pVar, int i10, i iVar) {
        this(vadDetectionListener, (i10 & 2) != 0 ? new p() { // from class: O4.r0
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return VadEventDispatcher.b((String) obj, (String) obj2);
            }
        } : pVar);
    }
}
