package com.stepos.aiengine.adapter;

import La.H;
import La.K;
import Y8.t;
import android.os.Bundle;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.adapter.AsrSseStreamRecognizer;
import com.stepos.aiengine.algorithm.asr.AsrSseStreamListener;
import com.stepos.aiengine.algorithm.asr.AsrSseStreamParamKeys;
import com.stepos.aiengine.algorithm.asr.IAsrSseStreamRecognizer;
import com.stepos.aiengine.api.trace.AiTraceKeys;
import com.stepos.aiengine.args.ExecutionBundle;
import com.stepos.core.AbilityHandle;
import com.stepos.core.InferenceCallback;
import com.stepos.core.callback.InferResult;
import com.stepos.core.data.AudioContent;
import com.stepos.core.data.ContentParams;
import com.stepos.core.data.base.Content;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;
import x5.d;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 02\u00020\u0001:\u0001\u001dB\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u001c\u0010\u0016R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001c\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\"0!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.¨\u00061"}, d2 = {"Lcom/stepos/aiengine/adapter/AsrSseStreamRecognizer;", "Lcom/stepos/aiengine/algorithm/asr/IAsrSseStreamRecognizer;", "Lcom/stepos/core/AbilityHandle;", "handle", "Landroid/os/Bundle;", "params", "<init>", "(Lcom/stepos/core/AbilityHandle;Landroid/os/Bundle;)V", "Lcom/stepos/aiengine/algorithm/asr/AsrSseStreamListener;", "listener", "", "openChannel", "(Lcom/stepos/aiengine/algorithm/asr/AsrSseStreamListener;)Z", "", "pcmData", "", "sampleRate", "channelCount", "writePcmData", "([BII)Z", "LY8/t;", "closeChannel", "()V", d.EXTRA_ENABLED, "setVadEnabled", "(ZLandroid/os/Bundle;)V", "isOpen", "()Z", "c", Const.INTENT_KEY_APIKEY, "Lcom/stepos/core/AbilityHandle;", Const.INTENT_KEY_PKGNAME, "Landroid/os/Bundle;", "Ljava/util/concurrent/atomic/AtomicReference;", "", "Ljava/util/concurrent/atomic/AtomicReference;", "inferIdRef", "Lcom/stepos/aiengine/adapter/AsrSseStreamEventDispatcher;", Const.INTENT_KEY_UMID, "Lcom/stepos/aiengine/adapter/AsrSseStreamEventDispatcher;", "dispatcher", "Ljava/util/concurrent/atomic/AtomicInteger;", "e", "Ljava/util/concurrent/atomic/AtomicInteger;", "feedSeq", "f", "Z", "opened", Const.INTENT_KEY_BACKGROUND_COMMAND, "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AsrSseStreamRecognizer implements IAsrSseStreamRecognizer {

    @Deprecated
    public static final String TAG = "AsrSseStreamRecognizer";

    @Deprecated
    public static final int TARGET_CHANNEL_COUNT = 1;

    @Deprecated
    public static final int TARGET_SAMPLE_RATE = 16000;

    @Deprecated
    public static final int TRACE_ID_MAX_LEN = 128;

    @Deprecated
    public static final String VAD_LEADING_SILENCE_TIMEOUT_MS = "vad.leading_silence_timeout_ms";

    @Deprecated
    public static final String VAD_MAX_DURATION_MS = "vad.max_duration_ms";

    @Deprecated
    public static final String VAD_MIN_SPEECH_RMS = "vad.min_speech_rms";

    @Deprecated
    public static final String VAD_SILENCE_DURATION_MS = "vad.silence_duration_ms";

    @Deprecated
    public static final String VAD_SPEECH_START_MS = "vad.speech_start_ms";

    @Deprecated
    public static final String VAD_THRESHOLD = "vad.threshold";

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final AbilityHandle handle;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Bundle params;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final AtomicReference<String> inferIdRef;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public AsrSseStreamEventDispatcher dispatcher;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final AtomicInteger feedSeq;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public volatile boolean opened;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000b\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\nJ'\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00138\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00138\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0012R\u0014\u0010\u0019\u001a\u00020\f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0012R\u0014\u0010\u001a\u001a\u00020\f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0012R\u0014\u0010\u001b\u001a\u00020\f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0012R\u0014\u0010\u001c\u001a\u00020\f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001c\u0010\u0012R\u0014\u0010\u001d\u001a\u00020\f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001d\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/stepos/aiengine/adapter/AsrSseStreamRecognizer$a;", "", "<init>", "()V", "Lcom/stepos/core/data/ContentParams$Builder;", "builder", "Landroid/os/Bundle;", "source", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/core/data/ContentParams$Builder;Landroid/os/Bundle;)V", Const.INTENT_KEY_PKGNAME, "", "key", Const.INTENT_KEY_UMID, "(Lcom/stepos/core/data/ContentParams$Builder;Landroid/os/Bundle;Ljava/lang/String;)V", "c", "TAG", "Ljava/lang/String;", "", "TARGET_SAMPLE_RATE", "I", "TARGET_CHANNEL_COUNT", "TRACE_ID_MAX_LEN", "VAD_THRESHOLD", "VAD_MIN_SPEECH_RMS", "VAD_SPEECH_START_MS", "VAD_SILENCE_DURATION_MS", "VAD_LEADING_SILENCE_TIMEOUT_MS", "VAD_MAX_DURATION_MS", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: com.stepos.aiengine.adapter.AsrSseStreamRecognizer$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final void a(ContentParams.Builder builder, Bundle source) {
            p.i(builder, "builder");
            p.i(source, "source");
            if (source.containsKey(AsrSseStreamParamKeys.VAD_ENABLED)) {
                builder.putBoolean(AsrSseStreamParamKeys.VAD_ENABLED, source.getBoolean(AsrSseStreamParamKeys.VAD_ENABLED, false));
            }
            if (source.containsKey(AsrSseStreamParamKeys.STREAM_MAX_DURATION_MS)) {
                builder.putInt(AsrSseStreamParamKeys.STREAM_MAX_DURATION_MS, source.getInt(AsrSseStreamParamKeys.STREAM_MAX_DURATION_MS));
            }
            b(builder, source);
        }

        public final void b(ContentParams.Builder builder, Bundle source) {
            p.i(builder, "builder");
            p.i(source, "source");
            d(builder, source, "vad.speech_start_ms");
            d(builder, source, "vad.silence_duration_ms");
            d(builder, source, "vad.leading_silence_timeout_ms");
            d(builder, source, "vad.max_duration_ms");
            c(builder, source, "vad.threshold");
            c(builder, source, "vad.min_speech_rms");
        }

        public final void c(ContentParams.Builder builder, Bundle source, String key) {
            if (source.containsKey(key)) {
                float f10 = source.getFloat(key, Float.NaN);
                if (Float.isNaN(f10) || f10 == 0.0f) {
                    f10 = (float) source.getDouble(key, 0.0d);
                }
                builder.putFloat(key, f10);
            }
        }

        public final void d(ContentParams.Builder builder, Bundle source, String key) {
            if (source.containsKey(key)) {
                builder.putInt(key, source.getInt(key));
            }
        }

        public Companion() {
        }
    }

    public AsrSseStreamRecognizer(AbilityHandle handle, Bundle bundle) {
        p.i(handle, "handle");
        this.handle = handle;
        this.params = bundle;
        this.inferIdRef = new AtomicReference<>(null);
        this.feedSeq = new AtomicInteger(0);
    }

    public static final t d(AsrSseStreamRecognizer asrSseStreamRecognizer, String id, String label) {
        p.i(id, "id");
        p.i(label, "label");
        Log.i(TAG, "[DIAG] asr-sse stream terminal: " + label + ", inferId=" + id);
        asrSseStreamRecognizer.dispatcher = null;
        return t.f7040a;
    }

    public static final t e(AsrSseStreamRecognizer asrSseStreamRecognizer) {
        asrSseStreamRecognizer.c();
        return t.f7040a;
    }

    public final void c() {
        this.opened = false;
        this.inferIdRef.set(null);
    }

    @Override // com.stepos.aiengine.algorithm.asr.IAsrSseStreamRecognizer
    public void closeChannel() {
        String andSet = this.inferIdRef.getAndSet(null);
        if (andSet == null) {
            return;
        }
        AudioContent audioContent = new AudioContent(new byte[0], 16000, 1, 2, null, 16, null);
        audioContent.setParams(new ContentParams.Builder().putBoolean(AsrSseStreamParamKeys.FEED_EOF, true).putInt(AsrSseStreamParamKeys.FEED_TOTAL, this.feedSeq.get()).build());
        this.handle.feedInput(andSet, audioContent);
        Log.i(TAG, "[DIAG] closeChannel: completeInput sent, inferId=" + andSet + " frames=" + this.feedSeq.get());
        this.handle.completeInput(andSet);
        this.opened = false;
    }

    @Override // com.stepos.aiengine.algorithm.asr.IAsrSseStreamRecognizer
    /* renamed from: isOpen, reason: from getter */
    public boolean getOpened() {
        return this.opened;
    }

    @Override // com.stepos.aiengine.algorithm.asr.IAsrSseStreamRecognizer
    public boolean openChannel(AsrSseStreamListener listener) {
        p.i(listener, "listener");
        if (this.opened) {
            return false;
        }
        this.feedSeq.set(0);
        AudioContent audioContent = new AudioContent(new byte[0], 16000, 1, 2, null, 16, null);
        ContentParams.Builder builder = new ContentParams.Builder();
        builder.putBoolean(AsrSseStreamParamKeys.FEED_ORDERED, true);
        Bundle bundle = this.params;
        if (bundle != null) {
            ExecutionBundle.Companion companion = ExecutionBundle.INSTANCE;
            if (companion.hasExecutionParams(bundle)) {
                companion.fromBundle(bundle).applyTo(builder);
            }
            String string = bundle.getString("trace_id");
            if (string != null) {
                if (H.x0(string)) {
                    string = null;
                }
                if (string != null) {
                    builder.putString(AiTraceKeys.CP_TRACE_ID, K.R1(string, 128));
                }
            }
            INSTANCE.a(builder, bundle);
            TaskPriorityArg.INSTANCE.applyTo(builder, bundle);
        }
        audioContent.setParams(builder.build());
        this.dispatcher = new AsrSseStreamEventDispatcher(listener, new p9.p() { // from class: O4.f
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return AsrSseStreamRecognizer.d(this.f5212a, (String) obj, (String) obj2);
            }
        }, new InterfaceC5063a() { // from class: O4.g
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return AsrSseStreamRecognizer.e(this.f5214a);
            }
        });
        String strInfer = this.handle.infer(audioContent, new InferenceCallback<Content>() { // from class: com.stepos.aiengine.adapter.AsrSseStreamRecognizer$openChannel$inferId$1
            @Override // com.stepos.core.InferenceCallback
            public void onNext(String inferId, InferResult<? extends Content> result) {
                p.i(inferId, "inferId");
                p.i(result, "result");
                if ((result instanceof InferResult.Error) || (result instanceof InferResult.Cancelled) || p.d(result, InferResult.Complete.INSTANCE)) {
                    this.f23541a.c();
                }
                AsrSseStreamEventDispatcher asrSseStreamEventDispatcher = this.f23541a.dispatcher;
                if (asrSseStreamEventDispatcher != null) {
                    asrSseStreamEventDispatcher.onInferResult(inferId, result);
                }
            }
        });
        this.inferIdRef.set(strInfer);
        this.opened = true;
        Log.i(TAG, "[DIAG] openChannel: asr-sse stream session opened, inferId=" + strInfer);
        return true;
    }

    @Override // com.stepos.aiengine.algorithm.asr.IAsrSseStreamRecognizer
    public void setVadEnabled(boolean enabled, Bundle params) {
        String str = this.inferIdRef.get();
        if (str == null) {
            return;
        }
        AudioContent audioContent = new AudioContent(new byte[0], 16000, 1, 2, null, 16, null);
        ContentParams.Builder builderPutBoolean = new ContentParams.Builder().putInt(AsrSseStreamParamKeys.FEED_SEQ, this.feedSeq.getAndIncrement()).putBoolean(AsrSseStreamParamKeys.VAD_GATE, true).putBoolean(AsrSseStreamParamKeys.VAD_ENABLED, enabled);
        if (params != null) {
            INSTANCE.b(builderPutBoolean, params);
        }
        audioContent.setParams(builderPutBoolean.build());
        this.handle.feedInput(str, audioContent);
        Log.i(TAG, "[DIAG] setVadEnabled: enabled=" + enabled + ", inferId=" + str);
    }

    @Override // com.stepos.aiengine.algorithm.asr.IAsrSseStreamRecognizer
    public boolean writePcmData(byte[] pcmData, int sampleRate, int channelCount) {
        p.i(pcmData, "pcmData");
        String str = this.inferIdRef.get();
        if (str == null || pcmData.length == 0) {
            return false;
        }
        AudioContent audioContent = new AudioContent(pcmData, sampleRate, channelCount, 2, null, 16, null);
        audioContent.setParams(new ContentParams.Builder().putInt(AsrSseStreamParamKeys.FEED_SEQ, this.feedSeq.getAndIncrement()).build());
        this.handle.feedInput(str, audioContent);
        return true;
    }
}
