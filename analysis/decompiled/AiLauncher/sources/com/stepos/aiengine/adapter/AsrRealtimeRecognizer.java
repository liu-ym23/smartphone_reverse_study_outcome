package com.stepos.aiengine.adapter;

import La.H;
import La.K;
import Y8.t;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.adapter.AsrRealtimeRecognizer;
import com.stepos.aiengine.algorithm.asr.AsrParamKeys;
import com.stepos.aiengine.algorithm.asr.AsrRealtimeRecognitionListener;
import com.stepos.aiengine.algorithm.asr.IAsrRealtimeRecognizer;
import com.stepos.aiengine.api.trace.AiTraceKeys;
import com.stepos.aiengine.args.ExecutionBundle;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.o0;
import com.stepos.core.AbilityHandle;
import com.stepos.core.InferenceCallback;
import com.stepos.core.callback.InferResult;
import com.stepos.core.data.AudioContent;
import com.stepos.core.data.ContentParams;
import com.stepos.core.data.base.Content;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 42\u00020\u0001:\u0001\u001eB\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010 R\u001c\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00103\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102¨\u00065"}, d2 = {"Lcom/stepos/aiengine/adapter/AsrRealtimeRecognizer;", "Lcom/stepos/aiengine/algorithm/asr/IAsrRealtimeRecognizer;", "Lcom/stepos/core/AbilityHandle;", "handle", "Landroid/os/Bundle;", "executionParams", "<init>", "(Lcom/stepos/core/AbilityHandle;Landroid/os/Bundle;)V", "Lcom/stepos/aiengine/algorithm/asr/AsrRealtimeRecognitionListener;", "listener", "", "openChannel", "(Lcom/stepos/aiengine/algorithm/asr/AsrRealtimeRecognitionListener;)Z", "", "pcmData", "", "sampleRate", "channelCount", "writePcmData", "([BII)Z", "LY8/t;", "closeChannel", "()V", "isOpen", "()Z", "", "inferId", o0.TRACK_STATUS_TERMINAL, Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;)V", Const.INTENT_KEY_APIKEY, "Lcom/stepos/core/AbilityHandle;", "Landroid/os/Bundle;", "Ljava/util/concurrent/atomic/AtomicReference;", "c", "Ljava/util/concurrent/atomic/AtomicReference;", "inferIdRef", "Lcom/stepos/aiengine/adapter/AsrRealtimeResultDispatcher;", Const.INTENT_KEY_UMID, "Lcom/stepos/aiengine/adapter/AsrRealtimeResultDispatcher;", "resultDispatcher", "Ljava/util/concurrent/atomic/AtomicLong;", "e", "Ljava/util/concurrent/atomic/AtomicLong;", "closeChannelAtMs", "Ljava/util/concurrent/atomic/AtomicInteger;", "f", "Ljava/util/concurrent/atomic/AtomicInteger;", "feedSeq", Const.INTENT_KEY_BACKGROUND_COMMAND, "Z", "opened", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AsrRealtimeRecognizer implements IAsrRealtimeRecognizer {

    @Deprecated
    public static final String TAG = "AsrRealtimeRecognizer";

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final AbilityHandle handle;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Bundle executionParams;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final AtomicReference<String> inferIdRef;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public AsrRealtimeResultDispatcher resultDispatcher;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final AtomicLong closeChannelAtMs;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final AtomicInteger feedSeq;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public volatile boolean opened;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/aiengine/adapter/AsrRealtimeRecognizer$a;", "", "<init>", "()V", "Lcom/stepos/core/data/ContentParams$Builder;", "builder", "Landroid/os/Bundle;", "source", "", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/core/data/ContentParams$Builder;Landroid/os/Bundle;)Z", "", "TAG", "Ljava/lang/String;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: com.stepos.aiengine.adapter.AsrRealtimeRecognizer$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final boolean a(ContentParams.Builder builder, Bundle source) {
            boolean z10;
            p.i(builder, "builder");
            p.i(source, "source");
            String string = source.getString(AsrParamKeys.REALTIME_TURN_DETECTION_TYPE);
            if (string != null) {
                builder.putString(AsrParamKeys.REALTIME_TURN_DETECTION_TYPE, string);
                z10 = true;
            } else {
                z10 = false;
            }
            if (source.containsKey(AsrParamKeys.REALTIME_TURN_DETECTION_SILENCE_MS)) {
                builder.putInt(AsrParamKeys.REALTIME_TURN_DETECTION_SILENCE_MS, source.getInt(AsrParamKeys.REALTIME_TURN_DETECTION_SILENCE_MS));
                z10 = true;
            }
            if (source.containsKey(AsrParamKeys.REALTIME_TURN_DETECTION_THRESHOLD)) {
                builder.putDouble(AsrParamKeys.REALTIME_TURN_DETECTION_THRESHOLD, source.getDouble(AsrParamKeys.REALTIME_TURN_DETECTION_THRESHOLD));
                z10 = true;
            }
            if (source.containsKey(AsrParamKeys.REALTIME_SEGMENTATION_MAX_CHARS)) {
                builder.putInt(AsrParamKeys.REALTIME_SEGMENTATION_MAX_CHARS, source.getInt(AsrParamKeys.REALTIME_SEGMENTATION_MAX_CHARS));
                z10 = true;
            }
            if (!source.containsKey(AsrParamKeys.REALTIME_SEGMENTATION_PUNCT_WINDOW)) {
                return z10;
            }
            builder.putInt(AsrParamKeys.REALTIME_SEGMENTATION_PUNCT_WINDOW, source.getInt(AsrParamKeys.REALTIME_SEGMENTATION_PUNCT_WINDOW));
            return true;
        }

        public Companion() {
        }
    }

    public AsrRealtimeRecognizer(AbilityHandle handle, Bundle bundle) {
        p.i(handle, "handle");
        this.handle = handle;
        this.executionParams = bundle;
        this.inferIdRef = new AtomicReference<>(null);
        this.closeChannelAtMs = new AtomicLong(0L);
        this.feedSeq = new AtomicInteger(0);
    }

    public static final t c(AsrRealtimeRecognizer asrRealtimeRecognizer, String id, String label) {
        p.i(id, "id");
        p.i(label, "label");
        asrRealtimeRecognizer.b(id, label);
        return t.f7040a;
    }

    public final void b(String inferId, String terminal) {
        long andSet = this.closeChannelAtMs.getAndSet(0L);
        if (andSet > 0) {
            Log.i(TAG, "[DIAG] closeChannel DONE: " + terminal + " received, inferId=" + inferId + ", closeChannel→terminal cost=" + (SystemClock.elapsedRealtime() - andSet) + Const.SP_KEY_GSM_UPLOAD_MXSIZE);
        } else {
            Log.i(TAG, "[DIAG] stream terminal: " + terminal + " received (no closeChannel, server-driven end), inferId=" + inferId);
        }
        this.resultDispatcher = null;
    }

    @Override // com.stepos.aiengine.algorithm.asr.IAsrRealtimeRecognizer
    public void closeChannel() {
        String andSet = this.inferIdRef.getAndSet(null);
        if (andSet == null) {
            return;
        }
        this.closeChannelAtMs.set(SystemClock.elapsedRealtime());
        Log.i(TAG, "[DIAG] closeChannel: completeInput sent to service, inferId=" + andSet);
        AudioContent audioContent = new AudioContent(new byte[0], 16000, 1, 2, null, 16, null);
        audioContent.setParams(new ContentParams.Builder().putBoolean(AsrParamKeys.REALTIME_FEED_EOF, true).putInt(AsrParamKeys.REALTIME_FEED_TOTAL, this.feedSeq.get()).build());
        this.handle.feedInput(andSet, audioContent);
        this.handle.completeInput(andSet);
        this.opened = false;
    }

    @Override // com.stepos.aiengine.algorithm.asr.IAsrRealtimeRecognizer
    /* renamed from: isOpen, reason: from getter */
    public boolean getOpened() {
        return this.opened;
    }

    @Override // com.stepos.aiengine.algorithm.asr.IAsrRealtimeRecognizer
    public boolean openChannel(AsrRealtimeRecognitionListener listener) {
        p.i(listener, "listener");
        if (this.opened) {
            return false;
        }
        AudioContent audioContent = new AudioContent(new byte[0], 16000, 1, 2, null, 16, null);
        this.feedSeq.set(0);
        ContentParams.Builder builder = new ContentParams.Builder();
        builder.putBoolean(AsrParamKeys.REALTIME_FEED_ORDERED, true);
        Bundle bundle = this.executionParams;
        if (bundle != null) {
            ExecutionBundle.Companion companion = ExecutionBundle.INSTANCE;
            if (companion.hasExecutionParams(bundle)) {
                companion.fromBundle(this.executionParams).applyTo(builder);
            }
            String string = this.executionParams.getString("trace_id");
            if (string != null) {
                if (H.x0(string)) {
                    string = null;
                }
                if (string != null) {
                    builder.putString(AiTraceKeys.CP_TRACE_ID, K.R1(string, 128));
                }
            }
            INSTANCE.a(builder, this.executionParams);
            TaskPriorityArg.INSTANCE.applyTo(builder, this.executionParams);
        }
        audioContent.setParams(builder.build());
        this.resultDispatcher = new AsrRealtimeResultDispatcher(listener, null, new p9.p() { // from class: O4.b
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return AsrRealtimeRecognizer.c(this.f5205a, (String) obj, (String) obj2);
            }
        }, 2, null);
        String strInfer = this.handle.infer(audioContent, new InferenceCallback<Content>() { // from class: com.stepos.aiengine.adapter.AsrRealtimeRecognizer$openChannel$inferId$1
            @Override // com.stepos.core.InferenceCallback
            public void onNext(String inferId, InferResult<? extends Content> result) {
                p.i(inferId, "inferId");
                p.i(result, "result");
                if ((result instanceof InferResult.Error) || (result instanceof InferResult.Cancelled) || p.d(result, InferResult.Complete.INSTANCE)) {
                    this.f23520a.opened = false;
                    this.f23520a.inferIdRef.set(null);
                }
                AsrRealtimeResultDispatcher asrRealtimeResultDispatcher = this.f23520a.resultDispatcher;
                if (asrRealtimeResultDispatcher != null) {
                    asrRealtimeResultDispatcher.onInferResult(inferId, result);
                }
            }
        });
        this.inferIdRef.set(strInfer);
        this.opened = true;
        Log.i(TAG, "[DIAG] openChannel: realtime session opened, inferId=" + strInfer);
        return true;
    }

    @Override // com.stepos.aiengine.algorithm.asr.IAsrRealtimeRecognizer
    public boolean writePcmData(byte[] pcmData, int sampleRate, int channelCount) {
        p.i(pcmData, "pcmData");
        String str = this.inferIdRef.get();
        if (str == null) {
            return false;
        }
        if (pcmData.length == 0) {
            return true;
        }
        AudioContent audioContent = new AudioContent(pcmData, sampleRate, channelCount, 2, null, 16, null);
        audioContent.setParams(new ContentParams.Builder().putInt(AsrParamKeys.REALTIME_FEED_SEQ, this.feedSeq.getAndIncrement()).build());
        this.handle.feedInput(str, audioContent);
        return true;
    }
}
