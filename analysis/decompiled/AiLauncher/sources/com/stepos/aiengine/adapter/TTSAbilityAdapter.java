package com.stepos.aiengine.adapter;

import La.H;
import La.K;
import M5.b;
import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.algorithm.tts.ITTS;
import com.stepos.aiengine.api.task.AlgorithmToken;
import com.stepos.aiengine.api.task.IBundleCallback;
import com.stepos.aiengine.api.trace.AiTraceKeys;
import com.stepos.aiengine.args.ExecutionBundle;
import com.stepos.core.AbilityHandle;
import com.stepos.core.InferenceCallback;
import com.stepos.core.callback.InferResult;
import com.stepos.core.data.AudioContent;
import com.stepos.core.data.ContentParams;
import com.stepos.core.data.TextContent;
import com.stepos.core.data.base.Content;
import com.stepos.statsapp.v3.lib.plugin.net.multipart.e;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J/\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/stepos/aiengine/adapter/TTSAbilityAdapter;", "Lcom/stepos/aiengine/algorithm/tts/ITTS;", "Lcom/stepos/core/AbilityHandle;", "handle", "<init>", "(Lcom/stepos/core/AbilityHandle;)V", "Lcom/stepos/aiengine/api/task/AlgorithmToken;", b.CREDENTIAL_TOKEN, "", "text", "Landroid/os/Bundle;", "args", "Lcom/stepos/aiengine/api/task/IBundleCallback;", "callback", "", "synthesize", "(Lcom/stepos/aiengine/api/task/AlgorithmToken;Ljava/lang/String;Landroid/os/Bundle;Lcom/stepos/aiengine/api/task/IBundleCallback;)I", "", e.f30860s, "", "cancel", "(J)Z", "Lcom/stepos/core/data/ContentParams;", Const.INTENT_KEY_APIKEY, "(Landroid/os/Bundle;)Lcom/stepos/core/data/ContentParams;", "Lcom/stepos/core/AbilityHandle;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TTSAbilityAdapter implements ITTS {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final AbilityHandle handle;

    public TTSAbilityAdapter(AbilityHandle handle) {
        p.i(handle, "handle");
        this.handle = handle;
    }

    public final ContentParams a(Bundle args) {
        boolean z10;
        ContentParams.Builder builder = new ContentParams.Builder();
        ExecutionBundle.Companion companion = ExecutionBundle.INSTANCE;
        if (companion.hasExecutionParams(args)) {
            companion.fromBundle(args).applyTo(builder);
            z10 = true;
        } else {
            z10 = false;
        }
        String string = args.getString("tts.voice");
        if (string != null) {
            if (H.x0(string)) {
                string = null;
            }
            if (string != null) {
                builder.putString("tts.voice", string);
                z10 = true;
            }
        }
        String string2 = args.getString("tts.instruction");
        if (string2 != null) {
            if (H.x0(string2)) {
                string2 = null;
            }
            if (string2 != null) {
                builder.putString("tts.instruction", string2);
                z10 = true;
            }
        }
        if (args.containsKey("tts.speed")) {
            builder.putFloat("tts.speed", args.getFloat("tts.speed", 1.0f));
            z10 = true;
        }
        if (args.containsKey("tts.volume")) {
            builder.putFloat("tts.volume", args.getFloat("tts.volume", 1.0f));
            z10 = true;
        }
        String string3 = args.getString("trace_id");
        if (string3 != null) {
            if (H.x0(string3)) {
                string3 = null;
            }
            if (string3 != null) {
                builder.putString(AiTraceKeys.CP_TRACE_ID, K.R1(string3, 128));
                z10 = true;
            }
        }
        if (TaskPriorityArg.INSTANCE.applyTo(builder, args) ? true : z10) {
            return builder.build();
        }
        return null;
    }

    @Override // com.stepos.aiengine.algorithm.tts.ITTS
    public boolean cancel(long identity) {
        return this.handle.cancel(String.valueOf(identity));
    }

    @Override // com.stepos.aiengine.algorithm.tts.ITTS
    public int synthesize(AlgorithmToken token, String text, Bundle args, final IBundleCallback callback) {
        p.i(token, "token");
        p.i(text, "text");
        p.i(args, "args");
        p.i(callback, "callback");
        TextContent textContent = new TextContent(text);
        ContentParams contentParamsA = a(args);
        if (contentParamsA != null) {
            textContent.setParams(contentParamsA);
        }
        this.handle.infer(String.valueOf(token.getIdentity()), (String) textContent, (InferenceCallback) new InferenceCallback<Content>() { // from class: com.stepos.aiengine.adapter.TTSAbilityAdapter.synthesize.2
            @Override // com.stepos.core.InferenceCallback
            public void onNext(String inferId, InferResult<? extends Content> result) {
                p.i(inferId, "inferId");
                p.i(result, "result");
                if (result instanceof InferResult.Result) {
                    Content value = ((InferResult.Result) result).getValue();
                    AudioContent audioContent = value instanceof AudioContent ? (AudioContent) value : null;
                    if (audioContent == null) {
                        return;
                    }
                    IBundleCallback iBundleCallback = callback;
                    Bundle bundle = new Bundle();
                    bundle.putByteArray("pcm_data", audioContent.getAudioBytes());
                    bundle.putInt("sample_rate", audioContent.getSampleRate());
                    bundle.putInt("channel_count", audioContent.getChannelCount());
                    iBundleCallback.onCall(bundle);
                    return;
                }
                if (result instanceof InferResult.Error) {
                    IBundleCallback iBundleCallback2 = callback;
                    Bundle bundle2 = new Bundle();
                    InferResult.Error error = (InferResult.Error) result;
                    bundle2.putString("exception", "[" + error.getErrorCode() + "] " + error.getMessage());
                    bundle2.putBoolean("is_done", true);
                    iBundleCallback2.onCall(bundle2);
                    return;
                }
                if (p.d(result, InferResult.Complete.INSTANCE)) {
                    IBundleCallback iBundleCallback3 = callback;
                    Bundle bundle3 = new Bundle();
                    bundle3.putBoolean("is_done", true);
                    iBundleCallback3.onCall(bundle3);
                    return;
                }
                if (result instanceof InferResult.Cancelled) {
                    IBundleCallback iBundleCallback4 = callback;
                    Bundle bundle4 = new Bundle();
                    bundle4.putBoolean("is_done", true);
                    iBundleCallback4.onCall(bundle4);
                    return;
                }
                if (!(result instanceof InferResult.RoutingDecision)) {
                    if (!(result instanceof InferResult.Progress)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    return;
                }
                IBundleCallback iBundleCallback5 = callback;
                Bundle bundle5 = new Bundle();
                InferResult.RoutingDecision routingDecision = (InferResult.RoutingDecision) result;
                bundle5.putString("routing", routingDecision.getExecutionLocation());
                bundle5.putString("routing_reason", routingDecision.getReason());
                iBundleCallback5.onCall(bundle5);
            }
        });
        return 0;
    }
}
