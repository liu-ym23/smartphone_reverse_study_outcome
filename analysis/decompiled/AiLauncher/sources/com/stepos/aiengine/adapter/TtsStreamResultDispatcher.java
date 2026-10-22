package com.stepos.aiengine.adapter;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.algorithm.tts.TtsStreamListener;
import com.stepos.core.callback.InferResult;
import com.stepos.core.data.AudioContent;
import com.stepos.core.data.ContentParams;
import com.stepos.core.data.TextContent;
import com.stepos.core.data.base.Content;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 #2\u00020\u0001:\u0001#B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u001eR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001eR\u0014\u0010\"\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\u001e¨\u0006$"}, d2 = {"Lcom/stepos/aiengine/adapter/TtsStreamResultDispatcher;", "", "Lcom/stepos/aiengine/algorithm/tts/TtsStreamListener;", "listener", "<init>", "(Lcom/stepos/aiengine/algorithm/tts/TtsStreamListener;)V", "LY8/t;", "notifyUserCancelled", "()V", "", "inferId", "Lcom/stepos/core/callback/InferResult;", "Lcom/stepos/core/data/base/Content;", "result", "onInferResult", "(Ljava/lang/String;Lcom/stepos/core/callback/InferResult;)V", "Lcom/stepos/core/callback/InferResult$Progress;", "progress", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/core/callback/InferResult$Progress;)V", UxipConstants.f30680s, Const.INTENT_KEY_APIKEY, "(Lcom/stepos/core/data/base/Content;)V", "", "errorCode", "message", "c", "(ILjava/lang/String;)V", "Lcom/stepos/aiengine/algorithm/tts/TtsStreamListener;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "openedEmitted", "inputClosedEmitted", Const.INTENT_KEY_UMID, "terminalEmitted", "Companion", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TtsStreamResultDispatcher {
    public static final String KEY_INPUT_CLOSED = "tts.input.closed";
    public static final String KEY_SESSION_OPENED = "tts.session.opened";
    public static final String KEY_TTS_FEED_EOF = "tts_feed_eof";
    public static final String KEY_TTS_FEED_ORDERED = "tts_feed_ordered";
    public static final String KEY_TTS_FEED_SEQ = "tts_feed_seq";
    public static final String KEY_TTS_FEED_TOTAL = "tts_feed_total";
    public static final String KEY_TTS_STREAM_START = "tts_stream_start";

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final TtsStreamListener listener;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final AtomicBoolean openedEmitted;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final AtomicBoolean inputClosedEmitted;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final AtomicBoolean terminalEmitted;

    public TtsStreamResultDispatcher(TtsStreamListener listener) {
        p.i(listener, "listener");
        this.listener = listener;
        this.openedEmitted = new AtomicBoolean(false);
        this.inputClosedEmitted = new AtomicBoolean(false);
        this.terminalEmitted = new AtomicBoolean(false);
    }

    public final void a(Content value) {
        if (this.terminalEmitted.get()) {
            return;
        }
        AudioContent audioContent = value instanceof AudioContent ? (AudioContent) value : null;
        if (audioContent == null) {
            return;
        }
        this.listener.onAudioChunk(audioContent.getAudioBytes(), audioContent.getSampleRate(), audioContent.getChannelCount(), audioContent.getEncoding());
    }

    public final void b(InferResult.Progress progress) {
        ContentParams params;
        if (this.terminalEmitted.get()) {
            return;
        }
        Content extra = progress.getExtra();
        TextContent textContent = extra instanceof TextContent ? (TextContent) extra : null;
        if (textContent == null || (params = textContent.getParams()) == null) {
            return;
        }
        if (params.getBoolean(KEY_SESSION_OPENED, false)) {
            if (this.openedEmitted.compareAndSet(false, true)) {
                this.listener.onOpened();
            }
        } else if (params.getBoolean(KEY_INPUT_CLOSED, false) && this.inputClosedEmitted.compareAndSet(false, true)) {
            this.listener.onClosed();
        }
    }

    public final void c(int errorCode, String message) {
        if (errorCode == -100) {
            if (this.terminalEmitted.compareAndSet(false, true)) {
                this.listener.onCancelled(-1, "unknown");
            }
        } else if (this.terminalEmitted.compareAndSet(false, true)) {
            this.listener.onError(errorCode, message);
        }
    }

    public final void notifyUserCancelled() {
        if (this.terminalEmitted.compareAndSet(false, true)) {
            this.listener.onCancelled(0, "user requested");
        }
    }

    public final void onInferResult(String inferId, InferResult<? extends Content> result) {
        p.i(inferId, "inferId");
        p.i(result, "result");
        if (result instanceof InferResult.Result) {
            a(((InferResult.Result) result).getValue());
            return;
        }
        if (result instanceof InferResult.Progress) {
            b((InferResult.Progress) result);
            return;
        }
        if (result instanceof InferResult.Error) {
            InferResult.Error error = (InferResult.Error) result;
            c(error.getErrorCode(), error.getMessage());
            return;
        }
        if (p.d(result, InferResult.Complete.INSTANCE)) {
            if (this.terminalEmitted.compareAndSet(false, true)) {
                this.listener.onComplete();
            }
        } else if (result instanceof InferResult.Cancelled) {
            if (this.terminalEmitted.compareAndSet(false, true)) {
                this.listener.onCancelled(-1, "unknown");
            }
        } else {
            if (!(result instanceof InferResult.RoutingDecision)) {
                throw new NoWhenBranchMatchedException();
            }
            if (this.terminalEmitted.get()) {
                return;
            }
            InferResult.RoutingDecision routingDecision = (InferResult.RoutingDecision) result;
            this.listener.onRoutingDecision(routingDecision.getExecutionLocation(), routingDecision.getReason());
        }
    }
}
