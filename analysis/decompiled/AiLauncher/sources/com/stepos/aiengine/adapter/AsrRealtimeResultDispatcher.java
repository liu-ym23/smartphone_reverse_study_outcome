package com.stepos.aiengine.adapter;

import Y8.t;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.adapter.AsrRealtimeResultDispatcher;
import com.stepos.aiengine.algorithm.asr.AsrRealtimeRecognitionListener;
import com.stepos.aiengine.algorithm.asr.AsrRealtimeRecognitionResult;
import com.stepos.aiengine.algorithm.asr.AsrStreamSegmentTracker;
import com.stepos.core.callback.InferResult;
import com.stepos.core.data.ContentParams;
import com.stepos.core.data.TextContent;
import com.stepos.core.data.base.Content;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.i;
import p9.p;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\b\u0000\u0018\u0000 -2\u00020\u0001:\u0001-B5\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u001a\b\u0002\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u0010\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b \u0010!J!\u0010&\u001a\u00020%2\b\u0010#\u001a\u0004\u0018\u00010\"2\u0006\u0010$\u001a\u00020\u0007H\u0002¢\u0006\u0004\b&\u0010'R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R&\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010,¨\u0006."}, d2 = {"Lcom/stepos/aiengine/adapter/AsrRealtimeResultDispatcher;", "", "Lcom/stepos/aiengine/algorithm/asr/AsrRealtimeRecognitionListener;", "listener", "Lcom/stepos/aiengine/algorithm/asr/AsrStreamSegmentTracker;", "segmentTracker", "Lkotlin/Function2;", "", "LY8/t;", "logTerminal", "<init>", "(Lcom/stepos/aiengine/algorithm/asr/AsrRealtimeRecognitionListener;Lcom/stepos/aiengine/algorithm/asr/AsrStreamSegmentTracker;Lp9/p;)V", "inferId", "Lcom/stepos/core/callback/InferResult;", "Lcom/stepos/core/data/base/Content;", "result", "onInferResult", "(Ljava/lang/String;Lcom/stepos/core/callback/InferResult;)V", UxipConstants.f30680s, "c", "(Lcom/stepos/core/data/base/Content;)V", "", "errorCode", "message", Const.INTENT_KEY_UMID, "(ILjava/lang/String;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(I)Ljava/lang/String;", "f", "()V", "Lcom/stepos/aiengine/algorithm/asr/AsrStreamSegmentTracker$RecognizedEvent;", "event", "e", "(Lcom/stepos/aiengine/algorithm/asr/AsrStreamSegmentTracker$RecognizedEvent;)V", "Lcom/stepos/core/data/ContentParams;", "params", "primaryKey", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lcom/stepos/core/data/ContentParams;Ljava/lang/String;)J", Const.INTENT_KEY_APIKEY, "Lcom/stepos/aiengine/algorithm/asr/AsrRealtimeRecognitionListener;", Const.INTENT_KEY_PKGNAME, "Lcom/stepos/aiengine/algorithm/asr/AsrStreamSegmentTracker;", "Lp9/p;", "Companion", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AsrRealtimeResultDispatcher {
    public static final String EVENT_BLOCKED = "asr.blocked";
    public static final String EVENT_DELTA = "asr.delta";
    public static final String EVENT_FORCED = "asr.forced";
    public static final String KEY_END_MS = "asr.segment.end_ms";
    public static final String KEY_ERROR_CODE = "asr.error_code";
    public static final String KEY_EVENT_TYPE = "asr.event_type";
    public static final String KEY_NOTICE = "asr.notice";
    public static final String KEY_RAW_DELTA = "asr.raw_delta";
    public static final String KEY_SPEAKER_ID = "asr.segment.speaker_id";
    public static final String KEY_START_MS = "asr.segment.start_ms";
    public static final String KEY_STASH = "asr.stash";

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final AsrRealtimeRecognitionListener listener;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final AsrStreamSegmentTracker segmentTracker;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final p<String, String, t> logTerminal;

    /* JADX WARN: Multi-variable type inference failed */
    public AsrRealtimeResultDispatcher(AsrRealtimeRecognitionListener listener, AsrStreamSegmentTracker segmentTracker, p<? super String, ? super String, t> logTerminal) {
        kotlin.jvm.internal.p.i(listener, "listener");
        kotlin.jvm.internal.p.i(segmentTracker, "segmentTracker");
        kotlin.jvm.internal.p.i(logTerminal, "logTerminal");
        this.listener = listener;
        this.segmentTracker = segmentTracker;
        this.logTerminal = logTerminal;
    }

    public static final t b(String str, String str2) {
        kotlin.jvm.internal.p.i(str, "<unused var>");
        kotlin.jvm.internal.p.i(str2, "<unused var>");
        return t.f7040a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c(Content value) {
        String string;
        String text;
        String string2;
        String string3;
        String string4;
        TextContent textContent = value instanceof TextContent ? (TextContent) value : null;
        if (textContent == null) {
            return;
        }
        ContentParams params = textContent.getParams();
        long jG = g(params, "asr.segment.start_ms");
        long jG2 = g(params, "asr.segment.end_ms");
        String str = "";
        String str2 = (params == null || (string4 = params.getString("asr.segment.speaker_id", "")) == null) ? "" : string4;
        if (params == null || (string = params.getString("asr.event_type", "")) == null) {
            string = "";
        }
        int iHashCode = string.hashCode();
        if (iHashCode != -1567216121) {
            if (iHashCode != -1161084214) {
                if (iHashCode == -682759042 && string.equals("asr.blocked")) {
                    int iCurrentIndex = this.segmentTracker.currentIndex();
                    int i10 = params != null ? params.getInt("asr.error_code", 0) : 0;
                    if (params != null && (string3 = params.getString("asr.notice", "")) != null) {
                        str = string3;
                    }
                    this.listener.onSegmentBlocked(iCurrentIndex, i10, str);
                    AsrStreamSegmentTracker.RecognizedEvent recognizedEventCloseAfterAbort = this.segmentTracker.closeAfterAbort(textContent.getText(), jG, jG2, str2);
                    if (recognizedEventCloseAfterAbort != null) {
                        e(recognizedEventCloseAfterAbort);
                        return;
                    }
                    return;
                }
            } else if (string.equals("asr.delta")) {
                if (params == null || (text = params.getString(KEY_RAW_DELTA, "")) == null) {
                    text = "";
                }
                if (text.length() == 0) {
                    text = textContent.getText();
                }
                String str3 = text;
                if (params != null && (string2 = params.getString(KEY_STASH, "")) != null) {
                    str = string2;
                }
                AsrStreamSegmentTracker.DeltaOutcome deltaOutcomeRecordDelta = this.segmentTracker.recordDelta(str3.length() == 0 ? str : str3, jG, jG2, str2, str3.length() > 0 ? 1 : 0);
                if (deltaOutcomeRecordDelta.getSegmentOpened()) {
                    this.listener.onSpeechStart(deltaOutcomeRecordDelta.getIndex());
                }
                this.listener.onRecognizing(deltaOutcomeRecordDelta.getIndex(), str3, str, jG, jG2);
                return;
            }
        } else if (string.equals("asr.forced")) {
            AsrStreamSegmentTracker.ForcedOutcome forcedOutcomeEmitForcedSegment = this.segmentTracker.emitForcedSegment(textContent.getText(), jG, jG2, str2);
            if (forcedOutcomeEmitForcedSegment != null) {
                if (forcedOutcomeEmitForcedSegment.getSegmentOpened()) {
                    this.listener.onSpeechStart(forcedOutcomeEmitForcedSegment.getEvent().getIndex());
                }
                e(forcedOutcomeEmitForcedSegment.getEvent());
                return;
            }
            return;
        }
        AsrStreamSegmentTracker.RecognizedEvent recognizedEventCompleteSegment = this.segmentTracker.completeSegment(textContent.getText(), jG, jG2, str2);
        if (recognizedEventCompleteSegment != null) {
            e(recognizedEventCompleteSegment);
        }
    }

    public final void d(int errorCode, String message) {
        if (errorCode == -100) {
            this.listener.onCancelled();
        } else {
            this.listener.onError(errorCode, message);
        }
    }

    public final void e(AsrStreamSegmentTracker.RecognizedEvent event) {
        this.listener.onRecognized(new AsrRealtimeRecognitionResult(event.getIndex(), event.getText(), event.getStartTime(), event.getEndTime(), null, 0.0f, event.getSpeakerId(), null, 176, null));
    }

    public final void f() {
        AsrStreamSegmentTracker.RecognizedEvent recognizedEventFlushBeforeTerminal = this.segmentTracker.flushBeforeTerminal();
        if (recognizedEventFlushBeforeTerminal != null) {
            e(recognizedEventFlushBeforeTerminal);
        }
    }

    public final long g(ContentParams params, String primaryKey) {
        if (params == null) {
            return 0L;
        }
        long j10 = params.getLong(primaryKey, 0L);
        if (j10 > 0) {
            return j10;
        }
        return params.getLong(kotlin.jvm.internal.p.d(primaryKey, "asr.segment.start_ms") ? "start_time" : "end_time", 0L);
    }

    public final String h(int errorCode) {
        if (errorCode == -100) {
            return "onCancelled(code=" + errorCode + ")";
        }
        return "onError(code=" + errorCode + ")";
    }

    public final void onInferResult(String inferId, InferResult<? extends Content> result) {
        kotlin.jvm.internal.p.i(inferId, "inferId");
        kotlin.jvm.internal.p.i(result, "result");
        if (result instanceof InferResult.Result) {
            c(((InferResult.Result) result).getValue());
            return;
        }
        if (result instanceof InferResult.Error) {
            f();
            InferResult.Error error = (InferResult.Error) result;
            this.logTerminal.invoke(inferId, h(error.getErrorCode()));
            d(error.getErrorCode(), error.getMessage());
            return;
        }
        if (kotlin.jvm.internal.p.d(result, InferResult.Complete.INSTANCE)) {
            f();
            this.logTerminal.invoke(inferId, "onComplete");
            this.listener.onComplete();
        } else if (result instanceof InferResult.Cancelled) {
            f();
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

    public /* synthetic */ AsrRealtimeResultDispatcher(AsrRealtimeRecognitionListener asrRealtimeRecognitionListener, AsrStreamSegmentTracker asrStreamSegmentTracker, p pVar, int i10, i iVar) {
        this(asrRealtimeRecognitionListener, (i10 & 2) != 0 ? new AsrStreamSegmentTracker(true) : asrStreamSegmentTracker, (i10 & 4) != 0 ? new p() { // from class: O4.c
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return AsrRealtimeResultDispatcher.b((String) obj, (String) obj2);
            }
        } : pVar);
    }
}
