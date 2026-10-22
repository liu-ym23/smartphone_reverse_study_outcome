package com.stepos.aiengine.adapter;

import Y8.t;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.adapter.AsrSseStreamEventDispatcher;
import com.stepos.aiengine.algorithm.asr.AsrSseStreamListener;
import com.stepos.aiengine.algorithm.asr.AsrSseStreamResult;
import com.stepos.core.callback.InferResult;
import com.stepos.core.data.ContentParams;
import com.stepos.core.data.TextContent;
import com.stepos.core.data.base.Content;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.i;
import p9.InterfaceC5063a;
import p9.p;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0000\u0018\u0000 \u001b2\u00020\u0001:\u0001\u0015B;\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u001a\b\u0002\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u0010\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R&\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/stepos/aiengine/adapter/AsrSseStreamEventDispatcher;", "", "Lcom/stepos/aiengine/algorithm/asr/AsrSseStreamListener;", "listener", "Lkotlin/Function2;", "", "LY8/t;", "logTerminal", "Lkotlin/Function0;", "onTerminalText", "<init>", "(Lcom/stepos/aiengine/algorithm/asr/AsrSseStreamListener;Lp9/p;Lp9/a;)V", "inferId", "Lcom/stepos/core/callback/InferResult;", "Lcom/stepos/core/data/base/Content;", "result", "onInferResult", "(Ljava/lang/String;Lcom/stepos/core/callback/InferResult;)V", UxipConstants.f30680s, "e", "(Lcom/stepos/core/data/base/Content;)V", Const.INTENT_KEY_APIKEY, "Lcom/stepos/aiengine/algorithm/asr/AsrSseStreamListener;", Const.INTENT_KEY_PKGNAME, "Lp9/p;", "c", "Lp9/a;", Const.INTENT_KEY_UMID, "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AsrSseStreamEventDispatcher {

    @Deprecated
    public static final String EVENT_DELTA = "asr.delta";

    @Deprecated
    public static final String EVENT_DONE = "asr.done";

    @Deprecated
    public static final String EVENT_SPEECH_START = "asr.speech_start";

    @Deprecated
    public static final String EVENT_WARNING = "asr.warning";

    @Deprecated
    public static final String KEY_EVENT_TYPE = "asr.event_type";

    @Deprecated
    public static final String KEY_SEGMENT_END_MS = "asr.segment.end_ms";

    @Deprecated
    public static final String KEY_SEGMENT_INDEX = "asr.segment.index";

    @Deprecated
    public static final String KEY_SEGMENT_START_MS = "asr.segment.start_ms";

    @Deprecated
    public static final String KEY_WARNING_CODE = "asr.warning_code";

    @Deprecated
    public static final String KEY_WARNING_MESSAGE = "asr.warning_message";

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final AsrSseStreamListener listener;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final p<String, String, t> logTerminal;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5063a<t> onTerminalText;

    /* JADX WARN: Multi-variable type inference failed */
    public AsrSseStreamEventDispatcher(AsrSseStreamListener listener, p<? super String, ? super String, t> logTerminal, InterfaceC5063a<t> onTerminalText) {
        kotlin.jvm.internal.p.i(listener, "listener");
        kotlin.jvm.internal.p.i(logTerminal, "logTerminal");
        kotlin.jvm.internal.p.i(onTerminalText, "onTerminalText");
        this.listener = listener;
        this.logTerminal = logTerminal;
        this.onTerminalText = onTerminalText;
    }

    public static final t c(String str, String str2) {
        kotlin.jvm.internal.p.i(str, "<unused var>");
        kotlin.jvm.internal.p.i(str2, "<unused var>");
        return t.f7040a;
    }

    public static final t d() {
        return t.f7040a;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void e(Content value) {
        String string;
        String string2;
        String string3;
        TextContent textContent = value instanceof TextContent ? (TextContent) value : null;
        if (textContent == null) {
            return;
        }
        ContentParams params = textContent.getParams();
        int i10 = params != null ? params.getInt("asr.segment.index", 0) : 0;
        long j10 = params != null ? params.getLong("asr.segment.start_ms", 0L) : 0L;
        long j11 = params != null ? params.getLong("asr.segment.end_ms", 0L) : 0L;
        String str = "";
        if (params == null || (string = params.getString("asr.event_type", "")) == null) {
            string = "";
        }
        switch (string.hashCode()) {
            case -1161084214:
                if (string.equals("asr.delta")) {
                    this.listener.onRecognizing(i10, textContent.getText(), j10, j11);
                    break;
                }
                break;
            case -453086672:
                if (string.equals("asr.done")) {
                    this.onTerminalText.invoke();
                    this.listener.onRecognized(new AsrSseStreamResult(i10, textContent.getText(), j10, j11, null, null, 48, null));
                    break;
                }
                break;
            case 289226611:
                if (string.equals(EVENT_SPEECH_START)) {
                    this.listener.onSpeechStart(i10);
                    break;
                }
                break;
            case 463125038:
                if (string.equals(EVENT_WARNING)) {
                    AsrSseStreamListener asrSseStreamListener = this.listener;
                    if (params == null || (string2 = params.getString(KEY_WARNING_CODE, "")) == null) {
                        string2 = "";
                    }
                    if (params != null && (string3 = params.getString(KEY_WARNING_MESSAGE, "")) != null) {
                        str = string3;
                    }
                    asrSseStreamListener.onWarning(string2, str);
                    break;
                }
                break;
        }
    }

    public final void onInferResult(String inferId, InferResult<? extends Content> result) {
        kotlin.jvm.internal.p.i(inferId, "inferId");
        kotlin.jvm.internal.p.i(result, "result");
        if (result instanceof InferResult.Result) {
            e(((InferResult.Result) result).getValue());
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
            this.listener.onComplete();
        } else if (result instanceof InferResult.Cancelled) {
            this.logTerminal.invoke(inferId, "onCancelled");
            this.listener.onCancelled();
        } else {
            if (result instanceof InferResult.Progress) {
                return;
            }
            if (!(result instanceof InferResult.RoutingDecision)) {
                throw new NoWhenBranchMatchedException();
            }
            InferResult.RoutingDecision routingDecision = (InferResult.RoutingDecision) result;
            this.listener.onRoutingDecision(routingDecision.getExecutionLocation(), routingDecision.getReason());
        }
    }

    public /* synthetic */ AsrSseStreamEventDispatcher(AsrSseStreamListener asrSseStreamListener, p pVar, InterfaceC5063a interfaceC5063a, int i10, i iVar) {
        this(asrSseStreamListener, (i10 & 2) != 0 ? new p() { // from class: O4.d
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return AsrSseStreamEventDispatcher.c((String) obj, (String) obj2);
            }
        } : pVar, (i10 & 4) != 0 ? new InterfaceC5063a() { // from class: O4.e
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return AsrSseStreamEventDispatcher.d();
            }
        } : interfaceC5063a);
    }
}
