package com.stepos.aiengine.adapter;

import La.C0953c;
import M5.b;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.algorithm.asr.AsrAudioFile;
import com.stepos.aiengine.algorithm.asr.AsrSseRecognitionListener;
import com.stepos.aiengine.algorithm.asr.AsrSseRecognitionResult;
import com.stepos.aiengine.algorithm.asr.IAsrSseRecognition;
import com.stepos.aiengine.algorithm.asr.IAsrSseStreamRecognizer;
import com.stepos.aiengine.api.task.AlgorithmToken;
import com.stepos.aiengine.args.ExecutionBundle;
import com.stepos.aiengine.args.SingleFileBundle;
import com.stepos.ame.sdk.SkillStoreKt;
import com.stepos.core.AbilityHandle;
import com.stepos.core.InferenceCallback;
import com.stepos.core.callback.InferResult;
import com.stepos.core.data.AudioContent;
import com.stepos.core.data.ContentParams;
import com.stepos.core.data.TextContent;
import com.stepos.core.data.base.Content;
import com.stepos.core.error.AIEngineError;
import com.stepos.statsapp.v3.lib.plugin.net.multipart.e;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 -2\u00020\u0001:\u0001-B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ1\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0011\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ+\u0010$\u001a\u00020#2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u00052\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b$\u0010%J!\u0010)\u001a\u00020\u00192\u0006\u0010'\u001a\u00020&2\b\u0010(\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b)\u0010*R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010+R\"\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010,¨\u0006."}, d2 = {"Lcom/stepos/aiengine/adapter/AsrSseAbilityAdapter;", "Lcom/stepos/aiengine/algorithm/asr/IAsrSseRecognition;", "Lcom/stepos/core/AbilityHandle;", "handle", "Lkotlin/Function1;", "Landroid/os/Bundle;", "", "waitMsOverride", "<init>", "(Lcom/stepos/core/AbilityHandle;Lp9/l;)V", "Lcom/stepos/aiengine/api/task/AlgorithmToken;", b.CREDENTIAL_TOKEN, "params", "Lcom/stepos/aiengine/algorithm/asr/IAsrSseStreamRecognizer;", "openChannel", "(Lcom/stepos/aiengine/api/task/AlgorithmToken;Landroid/os/Bundle;)Lcom/stepos/aiengine/algorithm/asr/IAsrSseStreamRecognizer;", "Lcom/stepos/aiengine/algorithm/asr/AsrAudioFile;", "audio", "Lcom/stepos/aiengine/algorithm/asr/AsrSseRecognitionListener;", "listener", "args", "", "recognize", "(Lcom/stepos/aiengine/api/task/AlgorithmToken;Lcom/stepos/aiengine/algorithm/asr/AsrAudioFile;Lcom/stepos/aiengine/algorithm/asr/AsrSseRecognitionListener;Landroid/os/Bundle;)I", e.f30860s, "", "cancel", "(J)Z", "Lcom/stepos/core/data/AudioContent;", Const.INTENT_KEY_PKGNAME, "(Landroid/os/Bundle;)Lcom/stepos/core/data/AudioContent;", "Lcom/stepos/core/data/base/Content;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "audioBundle", "requestArgs", "LY8/t;", "c", "(Lcom/stepos/core/data/base/Content;Landroid/os/Bundle;Landroid/os/Bundle;)V", "Lcom/stepos/core/data/ContentParams$Builder;", "builder", "bundle", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/core/data/ContentParams$Builder;Landroid/os/Bundle;)Z", "Lcom/stepos/core/AbilityHandle;", "Lp9/l;", "Companion", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AsrSseAbilityAdapter implements IAsrSseRecognition {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final AbilityHandle handle;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5074l<Bundle, Long> waitMsOverride;

    /* JADX WARN: Multi-variable type inference failed */
    public AsrSseAbilityAdapter(AbilityHandle handle, InterfaceC5074l<? super Bundle, Long> interfaceC5074l) {
        p.i(handle, "handle");
        this.handle = handle;
        this.waitMsOverride = interfaceC5074l;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a(com.stepos.core.data.ContentParams.Builder r4, android.os.Bundle r5) {
        /*
            r3 = this;
            java.lang.String r3 = "__trace_id"
            r0 = 0
            if (r5 == 0) goto L17
            java.lang.String r1 = "trace_id"
            java.lang.String r1 = r5.getString(r1)
            if (r1 == 0) goto L17
            boolean r2 = La.H.x0(r1)
            if (r2 != 0) goto L14
            goto L15
        L14:
            r1 = r0
        L15:
            if (r1 != 0) goto L2b
        L17:
            if (r5 == 0) goto L26
            java.lang.String r5 = r5.getString(r3)
            if (r5 == 0) goto L26
            boolean r1 = La.H.x0(r5)
            if (r1 != 0) goto L26
            r0 = r5
        L26:
            if (r0 != 0) goto L2a
            r3 = 0
            return r3
        L2a:
            r1 = r0
        L2b:
            r5 = 128(0x80, float:1.8E-43)
            java.lang.String r5 = La.K.R1(r1, r5)
            r4.putString(r3, r5)
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.aiengine.adapter.AsrSseAbilityAdapter.a(com.stepos.core.data.ContentParams$Builder, android.os.Bundle):boolean");
    }

    public final AudioContent b(Bundle audio) {
        ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) audio.getParcelable(SingleFileBundle.KEY_FILE_DESCRIPTOR);
        byte[] byteArray = audio.getByteArray(SingleFileBundle.KEY_BYTES);
        String string = audio.getString("path");
        String string2 = audio.getString("audio_url");
        int i10 = audio.getInt("sample_rate", 16000);
        int i11 = audio.getInt("channel_count", 1);
        if (string2 != null) {
            return new AudioContent(new byte[0], i10, i11, 102, null, 16, null);
        }
        if (parcelFileDescriptor != null) {
            return new AudioContent(new byte[0], i10, i11, 101, parcelFileDescriptor);
        }
        if (byteArray != null) {
            return new AudioContent(byteArray, i10, i11, 2, null, 16, null);
        }
        if (string == null) {
            return null;
        }
        byte[] bytes = string.getBytes(C0953c.UTF_8);
        p.h(bytes, "getBytes(...)");
        return new AudioContent(bytes, i10, i11, 100, null, 16, null);
    }

    public final void c(Content content, Bundle audioBundle, Bundle requestArgs) {
        boolean z10;
        ContentParams.Builder builder = new ContentParams.Builder();
        ExecutionBundle.Companion companion = ExecutionBundle.INSTANCE;
        boolean z11 = true;
        if (companion.hasExecutionParams(audioBundle)) {
            companion.fromBundle(audioBundle).applyTo(builder);
            z10 = true;
        } else {
            z10 = false;
        }
        String string = audioBundle.getString("audio_url");
        if (string != null) {
            builder.putString("audio_url", string);
            z10 = true;
        }
        String string2 = audioBundle.getString(SingleFileBundle.KEY_CLOUD_BIZ_CODE);
        if (string2 != null) {
            builder.putString(SingleFileBundle.KEY_CLOUD_BIZ_CODE, string2);
            z10 = true;
        }
        String string3 = audioBundle.getString(SingleFileBundle.KEY_CLOUD_SOURCE_TYPE);
        if (string3 != null) {
            builder.putString(SingleFileBundle.KEY_CLOUD_SOURCE_TYPE, string3);
            z10 = true;
        }
        if (a(builder, requestArgs) || a(builder, audioBundle)) {
            z10 = true;
        }
        TaskPriorityArg taskPriorityArg = TaskPriorityArg.INSTANCE;
        if (!taskPriorityArg.applyTo(builder, requestArgs) && !taskPriorityArg.applyTo(builder, audioBundle)) {
            z11 = z10;
        }
        if (z11) {
            content.setParams(builder.build());
        }
    }

    @Override // com.stepos.aiengine.algorithm.asr.IAsrSseRecognition
    public boolean cancel(long identity) {
        return this.handle.cancel(String.valueOf(identity));
    }

    @Override // com.stepos.aiengine.algorithm.asr.IAsrSseRecognition
    public IAsrSseStreamRecognizer openChannel(AlgorithmToken token, Bundle params) {
        p.i(token, "token");
        return new AsrSseStreamRecognizer(this.handle, params);
    }

    @Override // com.stepos.aiengine.algorithm.asr.IAsrSseRecognition
    public int recognize(AlgorithmToken token, AsrAudioFile audio, final AsrSseRecognitionListener listener, Bundle args) {
        p.i(token, "token");
        p.i(audio, "audio");
        p.i(listener, "listener");
        AudioContent audioContentB = b(audio.getAudio());
        if (audioContentB == null) {
            listener.onError(AIEngineError.INPUT_DATA_INVALID, "audio Bundle missing 'fd', 'bytes' or 'path' key");
            return -1;
        }
        c(audioContentB, audio.getAudio(), args);
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        InterfaceC5074l<Bundle, Long> interfaceC5074l = this.waitMsOverride;
        long jLongValue = interfaceC5074l != null ? interfaceC5074l.invoke(audio.getAudio()).longValue() : 300000L;
        final StringBuilder sb2 = new StringBuilder();
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        this.handle.infer(String.valueOf(token.getIdentity()), (String) audioContentB, (InferenceCallback) new InferenceCallback<Content>() { // from class: com.stepos.aiengine.adapter.AsrSseAbilityAdapter.recognize.1
            /* JADX WARN: Type inference failed for: r4v22, types: [T, java.lang.String] */
            @Override // com.stepos.core.InferenceCallback
            public void onNext(String inferId, InferResult<? extends Content> result) {
                String string;
                p.i(inferId, "inferId");
                p.i(result, "result");
                if (result instanceof InferResult.Result) {
                    Content value = ((InferResult.Result) result).getValue();
                    TextContent textContent = value instanceof TextContent ? (TextContent) value : null;
                    if (textContent == null) {
                        return;
                    }
                    ContentParams params = textContent.getParams();
                    String str = "";
                    if (params != null && (string = params.getString("asr.event_type", "")) != null) {
                        str = string;
                    }
                    if (p.d(str, "asr.delta")) {
                        sb2.append(textContent.getText());
                        listener.onRecognizing(textContent.getText());
                        return;
                    } else if (p.d(str, "asr.done")) {
                        ref$ObjectRef.f34820a = textContent.getText();
                        return;
                    } else {
                        if (textContent.getText().length() > 0) {
                            sb2.append(textContent.getText());
                            return;
                        }
                        return;
                    }
                }
                if (result instanceof InferResult.Error) {
                    InferResult.Error error = (InferResult.Error) result;
                    listener.onError(error.getErrorCode(), error.getMessage());
                    countDownLatch.countDown();
                    return;
                }
                if (p.d(result, InferResult.Complete.INSTANCE)) {
                    AsrSseRecognitionListener asrSseRecognitionListener = listener;
                    String string2 = ref$ObjectRef.f34820a;
                    if (string2 == null) {
                        string2 = sb2.toString();
                        p.h(string2, "toString(...)");
                    }
                    asrSseRecognitionListener.onComplete(new AsrSseRecognitionResult(string2, null, 2, null));
                    countDownLatch.countDown();
                    return;
                }
                if (result instanceof InferResult.Cancelled) {
                    listener.onCancelled();
                    countDownLatch.countDown();
                } else {
                    if (result instanceof InferResult.Progress) {
                        return;
                    }
                    if (!(result instanceof InferResult.RoutingDecision)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    listener.onRoutingDecision(((InferResult.RoutingDecision) result).getExecutionLocation());
                }
            }
        });
        if (countDownLatch.await(jLongValue, TimeUnit.MILLISECONDS)) {
            return 0;
        }
        this.handle.cancel(String.valueOf(token.getIdentity()));
        listener.onError(AIEngineError.TIMEOUT, "client wait timeout after " + jLongValue + Const.SP_KEY_GSM_UPLOAD_MXSIZE);
        return 0;
    }

    public /* synthetic */ AsrSseAbilityAdapter(AbilityHandle abilityHandle, InterfaceC5074l interfaceC5074l, int i10, i iVar) {
        this(abilityHandle, (i10 & 2) != 0 ? null : interfaceC5074l);
    }
}
