package com.stepos.aiengine.adapter;

import La.H;
import La.K;
import Y8.t;
import android.os.Bundle;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.adapter.VadDetector;
import com.stepos.aiengine.algorithm.vad.IVadDetector;
import com.stepos.aiengine.algorithm.vad.VadDetectionListener;
import com.stepos.aiengine.algorithm.vad.VadParamKeys;
import com.stepos.aiengine.api.trace.AiTraceKeys;
import com.stepos.core.AbilityHandle;
import com.stepos.core.InferenceCallback;
import com.stepos.core.callback.InferResult;
import com.stepos.core.data.AudioContent;
import com.stepos.core.data.ContentParams;
import com.stepos.core.data.base.Content;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 -2\u00020\u0001:\u0001\u0019B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001c\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010,\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006."}, d2 = {"Lcom/stepos/aiengine/adapter/VadDetector;", "Lcom/stepos/aiengine/algorithm/vad/IVadDetector;", "Lcom/stepos/core/AbilityHandle;", "handle", "Landroid/os/Bundle;", "params", "<init>", "(Lcom/stepos/core/AbilityHandle;Landroid/os/Bundle;)V", "Lcom/stepos/aiengine/algorithm/vad/VadDetectionListener;", "listener", "", "openChannel", "(Lcom/stepos/aiengine/algorithm/vad/VadDetectionListener;)Z", "", "pcmData", "", "sampleRate", "channelCount", "writePcmData", "([BII)Z", "LY8/t;", "closeChannel", "()V", "isOpen", "()Z", Const.INTENT_KEY_APIKEY, "Lcom/stepos/core/AbilityHandle;", Const.INTENT_KEY_PKGNAME, "Landroid/os/Bundle;", "Ljava/util/concurrent/atomic/AtomicReference;", "", "c", "Ljava/util/concurrent/atomic/AtomicReference;", "inferIdRef", "Lcom/stepos/aiengine/adapter/VadEventDispatcher;", Const.INTENT_KEY_UMID, "Lcom/stepos/aiengine/adapter/VadEventDispatcher;", "dispatcher", "Ljava/util/concurrent/atomic/AtomicInteger;", "e", "Ljava/util/concurrent/atomic/AtomicInteger;", "feedSeq", "f", "Z", "opened", Const.INTENT_KEY_BACKGROUND_COMMAND, "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class VadDetector implements IVadDetector {

    @Deprecated
    public static final String TAG = "VadDetector";

    @Deprecated
    public static final int TARGET_CHANNEL_COUNT = 1;

    @Deprecated
    public static final int TARGET_SAMPLE_RATE = 16000;

    @Deprecated
    public static final int TRACE_ID_MAX_LEN = 128;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final AbilityHandle handle;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Bundle params;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final AtomicReference<String> inferIdRef;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public VadEventDispatcher dispatcher;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final AtomicInteger feedSeq;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public volatile boolean opened;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u000e8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/stepos/aiengine/adapter/VadDetector$a;", "", "<init>", "()V", "Lcom/stepos/core/data/ContentParams$Builder;", "builder", "Landroid/os/Bundle;", "source", "", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/core/data/ContentParams$Builder;Landroid/os/Bundle;)Z", "", "TAG", "Ljava/lang/String;", "", "TARGET_SAMPLE_RATE", "I", "TARGET_CHANNEL_COUNT", "TRACE_ID_MAX_LEN", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: com.stepos.aiengine.adapter.VadDetector$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public static final void b(Bundle bundle, ContentParams.Builder builder, Ref$BooleanRef ref$BooleanRef, String str) {
            if (bundle.containsKey(str)) {
                builder.putBoolean(str, bundle.getBoolean(str, false));
                ref$BooleanRef.f34815a = true;
            }
        }

        public static final void c(Bundle bundle, ContentParams.Builder builder, Ref$BooleanRef ref$BooleanRef, String str) {
            float fFloatValue;
            Object obj = bundle.get(str);
            if (obj == null) {
                return;
            }
            if (obj instanceof Float) {
                fFloatValue = ((Number) obj).floatValue();
            } else if (obj instanceof Double) {
                fFloatValue = (float) ((Number) obj).doubleValue();
            } else if (!(obj instanceof Number)) {
                return;
            } else {
                fFloatValue = ((Number) obj).floatValue();
            }
            if (Float.isInfinite(fFloatValue) || Float.isNaN(fFloatValue)) {
                return;
            }
            builder.putFloat(str, fFloatValue);
            ref$BooleanRef.f34815a = true;
        }

        public static final void d(Bundle bundle, ContentParams.Builder builder, Ref$BooleanRef ref$BooleanRef, String str) {
            if (bundle.containsKey(str)) {
                builder.putInt(str, bundle.getInt(str));
                ref$BooleanRef.f34815a = true;
            }
        }

        public final boolean a(ContentParams.Builder builder, Bundle source) {
            p.i(builder, "builder");
            p.i(source, "source");
            Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
            d(source, builder, ref$BooleanRef, "vad.speech_start_ms");
            d(source, builder, ref$BooleanRef, "vad.silence_duration_ms");
            d(source, builder, ref$BooleanRef, "vad.leading_silence_timeout_ms");
            d(source, builder, ref$BooleanRef, "vad.max_duration_ms");
            d(source, builder, ref$BooleanRef, VadParamKeys.LEVEL_INTERVAL_MS);
            c(source, builder, ref$BooleanRef, "vad.threshold");
            c(source, builder, ref$BooleanRef, "vad.min_speech_rms");
            b(source, builder, ref$BooleanRef, VadParamKeys.LEVEL_ENABLED);
            return ref$BooleanRef.f34815a;
        }

        public Companion() {
        }
    }

    public VadDetector(AbilityHandle handle, Bundle bundle) {
        p.i(handle, "handle");
        this.handle = handle;
        this.params = bundle;
        this.inferIdRef = new AtomicReference<>(null);
        this.feedSeq = new AtomicInteger(0);
    }

    public static final t b(VadDetector vadDetector, String id, String label) {
        p.i(id, "id");
        p.i(label, "label");
        Log.i(TAG, "[DIAG] vad session terminal: " + label + ", inferId=" + id);
        vadDetector.dispatcher = null;
        return t.f7040a;
    }

    @Override // com.stepos.aiengine.algorithm.vad.IVadDetector
    public void closeChannel() {
        String andSet = this.inferIdRef.getAndSet(null);
        if (andSet == null) {
            return;
        }
        AudioContent audioContent = new AudioContent(new byte[0], 16000, 1, 2, null, 16, null);
        audioContent.setParams(new ContentParams.Builder().putBoolean(VadParamKeys.FEED_EOF, true).putInt(VadParamKeys.FEED_TOTAL, this.feedSeq.get()).build());
        this.handle.feedInput(andSet, audioContent);
        Log.i(TAG, "[DIAG] closeChannel: completeInput sent, inferId=" + andSet + " frames=" + this.feedSeq.get());
        this.handle.completeInput(andSet);
        this.opened = false;
    }

    @Override // com.stepos.aiengine.algorithm.vad.IVadDetector
    /* renamed from: isOpen, reason: from getter */
    public boolean getOpened() {
        return this.opened;
    }

    @Override // com.stepos.aiengine.algorithm.vad.IVadDetector
    public boolean openChannel(VadDetectionListener listener) {
        p.i(listener, "listener");
        if (this.opened) {
            return false;
        }
        this.feedSeq.set(0);
        AudioContent audioContent = new AudioContent(new byte[0], 16000, 1, 2, null, 16, null);
        ContentParams.Builder builder = new ContentParams.Builder();
        builder.putBoolean(VadParamKeys.FEED_ORDERED, true);
        Bundle bundle = this.params;
        if (bundle != null) {
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
        this.dispatcher = new VadEventDispatcher(listener, new p9.p() { // from class: O4.q0
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return VadDetector.b(this.f5241a, (String) obj, (String) obj2);
            }
        });
        String strInfer = this.handle.infer(audioContent, new InferenceCallback<Content>() { // from class: com.stepos.aiengine.adapter.VadDetector$openChannel$inferId$1
            @Override // com.stepos.core.InferenceCallback
            public void onNext(String inferId, InferResult<? extends Content> result) {
                p.i(inferId, "inferId");
                p.i(result, "result");
                if ((result instanceof InferResult.Error) || (result instanceof InferResult.Cancelled) || p.d(result, InferResult.Complete.INSTANCE)) {
                    this.f23616a.opened = false;
                    this.f23616a.inferIdRef.set(null);
                }
                VadEventDispatcher vadEventDispatcher = this.f23616a.dispatcher;
                if (vadEventDispatcher != null) {
                    vadEventDispatcher.onInferResult(inferId, result);
                }
            }
        });
        this.inferIdRef.set(strInfer);
        this.opened = true;
        Log.i(TAG, "[DIAG] openChannel: vad session opened, inferId=" + strInfer);
        return true;
    }

    @Override // com.stepos.aiengine.algorithm.vad.IVadDetector
    public boolean writePcmData(byte[] pcmData, int sampleRate, int channelCount) {
        p.i(pcmData, "pcmData");
        String str = this.inferIdRef.get();
        if (str == null || pcmData.length == 0) {
            return false;
        }
        AudioContent audioContent = new AudioContent(pcmData, sampleRate, channelCount, 2, null, 16, null);
        audioContent.setParams(new ContentParams.Builder().putInt(VadParamKeys.FEED_SEQ, this.feedSeq.getAndIncrement()).build());
        this.handle.feedInput(str, audioContent);
        return true;
    }
}
