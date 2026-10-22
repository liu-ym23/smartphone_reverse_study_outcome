package com.stepos.aiengine.adapter;

import La.C;
import La.C0953c;
import La.H;
import La.K;
import M5.b;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.algorithm.sla.ISla;
import com.stepos.aiengine.algorithm.sla.SlaAudioInput;
import com.stepos.aiengine.algorithm.sla.SlaDecision;
import com.stepos.aiengine.algorithm.sla.SlaExecutability;
import com.stepos.aiengine.algorithm.sla.SlaExecution;
import com.stepos.aiengine.algorithm.sla.SlaInput;
import com.stepos.aiengine.algorithm.sla.SlaListener;
import com.stepos.aiengine.algorithm.sla.SlaRejectReason;
import com.stepos.aiengine.algorithm.sla.SlaResult;
import com.stepos.aiengine.api.task.AlgorithmToken;
import com.stepos.aiengine.api.trace.AiTraceKeys;
import com.stepos.aiengine.args.SingleFileBundle;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import com.stepos.core.AbilityHandle;
import com.stepos.core.InferenceCallback;
import com.stepos.core.callback.InferResult;
import com.stepos.core.data.AudioContent;
import com.stepos.core.data.ContentParams;
import com.stepos.core.data.TextContent;
import com.stepos.core.data.base.Content;
import com.stepos.core.error.AIEngineError;
import com.stepos.statsapp.v3.lib.plugin.net.multipart.e;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.collections.a;
import kotlin.jvm.internal.p;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J1\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u001e\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001e\u0010 J\u0017\u0010\"\u001a\u00020!2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\"\u0010#J\u0019\u0010'\u001a\u00020&2\b\u0010%\u001a\u0004\u0018\u00010$H\u0002¢\u0006\u0004\b'\u0010(J\u0019\u0010*\u001a\u00020)2\b\u0010%\u001a\u0004\u0018\u00010$H\u0002¢\u0006\u0004\b*\u0010+R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010,R\u0014\u0010.\u001a\u00020\u00168\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001e\u0010-¨\u0006/"}, d2 = {"Lcom/stepos/aiengine/adapter/SlaAbilityAdapter;", "Lcom/stepos/aiengine/algorithm/sla/ISla;", "Lcom/stepos/core/AbilityHandle;", "handle", "<init>", "(Lcom/stepos/core/AbilityHandle;)V", "Lcom/stepos/aiengine/api/task/AlgorithmToken;", b.CREDENTIAL_TOKEN, "Lcom/stepos/aiengine/algorithm/sla/SlaInput;", "input", "Landroid/os/Bundle;", "args", "Lcom/stepos/aiengine/algorithm/sla/SlaListener;", "listener", "", "recognize", "(Lcom/stepos/aiengine/api/task/AlgorithmToken;Lcom/stepos/aiengine/algorithm/sla/SlaInput;Landroid/os/Bundle;Lcom/stepos/aiengine/algorithm/sla/SlaListener;)I", "", e.f30860s, "", "cancel", "(J)Z", "", "json", "LY8/t;", "c", "(Ljava/lang/String;Lcom/stepos/aiengine/algorithm/sla/SlaListener;)V", "Lcom/stepos/core/data/ContentParams;", Const.INTENT_KEY_APIKEY, "(Landroid/os/Bundle;)Lcom/stepos/core/data/ContentParams;", Const.INTENT_KEY_PKGNAME, "Lcom/stepos/core/data/AudioContent;", "(Landroid/os/Bundle;)Lcom/stepos/core/data/AudioContent;", "Lcom/stepos/aiengine/algorithm/sla/SlaResult;", "f", "(Ljava/lang/String;)Lcom/stepos/aiengine/algorithm/sla/SlaResult;", "Lorg/json/JSONObject;", "obj", "Lcom/stepos/aiengine/algorithm/sla/SlaDecision;", Const.INTENT_KEY_UMID, "(Lorg/json/JSONObject;)Lcom/stepos/aiengine/algorithm/sla/SlaDecision;", "Lcom/stepos/aiengine/algorithm/sla/SlaExecution;", "e", "(Lorg/json/JSONObject;)Lcom/stepos/aiengine/algorithm/sla/SlaExecution;", "Lcom/stepos/core/AbilityHandle;", "Ljava/lang/String;", "tag", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SlaAbilityAdapter implements ISla {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final AbilityHandle handle;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final String tag;

    public SlaAbilityAdapter(AbilityHandle handle) {
        p.i(handle, "handle");
        this.handle = handle;
        this.tag = "SlaAbilityAdapter";
    }

    public final ContentParams a(Bundle args) {
        boolean zBooleanValue;
        Boolean boolC1;
        int iIntValue;
        Integer numW;
        ContentParams.Builder builder = new ContentParams.Builder();
        for (String str : args.keySet()) {
            if (p.d(str, "executeAtomic")) {
                Object obj = args.get(str);
                if (obj instanceof Boolean) {
                    zBooleanValue = ((Boolean) obj).booleanValue();
                } else if ((obj instanceof String) && (boolC1 = H.C1((String) obj)) != null) {
                    zBooleanValue = boolC1.booleanValue();
                }
                builder.putBoolean("sla.executeAtomic", zBooleanValue);
            } else if (p.d(str, "task_priority")) {
                Object obj2 = args.get(str);
                if (obj2 instanceof Integer) {
                    iIntValue = ((Number) obj2).intValue();
                } else if ((obj2 instanceof String) && (numW = C.w((String) obj2)) != null) {
                    iIntValue = numW.intValue();
                }
                builder.putInt("task_priority", iIntValue);
            } else {
                Object obj3 = args.get(str);
                String str2 = obj3 instanceof String ? (String) obj3 : null;
                if (str2 != null) {
                    if (p.d(str, "trace_id")) {
                        builder.putString(AiTraceKeys.CP_TRACE_ID, K.R1(str2, 128));
                    } else {
                        builder.putString("sla.arg." + str, str2);
                    }
                }
            }
        }
        return builder.build();
    }

    public final AudioContent b(Bundle b10) {
        ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) b10.getParcelable(SingleFileBundle.KEY_FILE_DESCRIPTOR);
        byte[] byteArray = b10.getByteArray(SingleFileBundle.KEY_BYTES);
        String string = b10.getString("path");
        int i10 = b10.getInt("sample_rate", 16000);
        int i11 = b10.getInt("channel_count", 1);
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

    public final void c(String json, SlaListener listener) {
        Object objB;
        Object objB2;
        if (H.x0(json)) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(new JSONObject(json).optString("phase", ""));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = "";
        }
        String str = (String) objB;
        if (p.d(str, "sla_output")) {
            try {
                objB2 = Result.b(new JSONObject(json).optString("slaOutput", ""));
            } catch (Throwable th2) {
                Result.Companion companion3 = Result.INSTANCE;
                objB2 = Result.b(C4849c.a(th2));
            }
            String str2 = (String) (Result.g(objB2) ? "" : objB2);
            p.f(str2);
            listener.onSlaOutput(str2);
            return;
        }
        if (!p.d(str, "decision")) {
            listener.onResult(f(json));
            return;
        }
        JSONObject jSONObject = new JSONObject(json);
        SlaDecision slaDecisionD = d(jSONObject.optJSONObject("decision"));
        boolean zOptBoolean = jSONObject.optBoolean("canExecute", false);
        int iOptInt = jSONObject.optInt("execErrorCode", 0);
        String strOptString = jSONObject.optString("execReason");
        p.f(strOptString);
        if (strOptString.length() <= 0) {
            strOptString = null;
        }
        listener.onDecision(slaDecisionD, new SlaExecutability(zOptBoolean, iOptInt, strOptString));
    }

    @Override // com.stepos.aiengine.algorithm.sla.ISla
    public boolean cancel(long identity) {
        return this.handle.cancel(String.valueOf(identity));
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.aiengine.algorithm.sla.SlaDecision d(org.json.JSONObject r20) {
        /*
            Method dump skipped, instructions count: 368
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.aiengine.adapter.SlaAbilityAdapter.d(org.json.JSONObject):com.stepos.aiengine.algorithm.sla.SlaDecision");
    }

    public final SlaExecution e(JSONObject obj) {
        Object objB;
        String str;
        String string;
        if (obj == null) {
            return new SlaExecution(false, "unknown", SlaExecution.Status.NOT_DISPATCHED, 0, null, null, 0L, 120, null);
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            String strOptString = obj.optString("status", "NOT_DISPATCHED");
            p.h(strOptString, "optString(...)");
            objB = Result.b(SlaExecution.Status.valueOf(strOptString));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        SlaExecution.Status status = SlaExecution.Status.NOT_DISPATCHED;
        if (Result.g(objB)) {
            objB = status;
        }
        SlaExecution.Status status2 = (SlaExecution.Status) objB;
        boolean zOptBoolean = obj.optBoolean("dispatched", false);
        String strOptString2 = obj.optString("executor", "unknown");
        p.h(strOptString2, "optString(...)");
        int iOptInt = obj.optInt("errorCode", 0);
        String strOptString3 = obj.optString(C3081a.ERROR_MSG);
        p.f(strOptString3);
        String str2 = strOptString3.length() > 0 ? strOptString3 : null;
        JSONObject jSONObjectOptJSONObject = obj.optJSONObject("result");
        if (jSONObjectOptJSONObject == null || (string = jSONObjectOptJSONObject.toString()) == null) {
            String strOptString4 = obj.optString("result");
            p.f(strOptString4);
            str = strOptString4.length() > 0 ? strOptString4 : null;
        } else {
            str = string;
        }
        return new SlaExecution(zOptBoolean, strOptString2, status2, iOptInt, str2, str, obj.optLong("elapsedMs", 0L));
    }

    public final SlaResult f(String json) {
        Object objB;
        if (H.x0(json)) {
            return new SlaResult(new SlaDecision(null, "", a.i(), null, 0.0f, null, SlaRejectReason.NO_MATCH, 32, null), new SlaExecution(false, "unknown", SlaExecution.Status.NOT_DISPATCHED, 0, null, null, 0L, 120, null), null, 0L, 0L, null, 28, null);
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            JSONObject jSONObject = new JSONObject(json);
            SlaDecision slaDecisionD = d(jSONObject.optJSONObject("decision"));
            SlaExecution slaExecutionE = e(jSONObject.optJSONObject("execution"));
            String strOptString = jSONObject.optString("asrText");
            p.f(strOptString);
            if (strOptString.length() <= 0) {
                strOptString = null;
            }
            objB = Result.b(new SlaResult(slaDecisionD, slaExecutionE, strOptString, jSONObject.optLong("totalElapsedMs", 0L), jSONObject.optLong("modelInferMs", 0L), json));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.w(this.tag, "parseResult: failed to parse JSON, returning fallback. raw_len=" + json.length(), thE);
            objB = new SlaResult(new SlaDecision(null, "", a.i(), null, 0.0f, null, SlaRejectReason.NO_MATCH, 32, null), new SlaExecution(false, "unknown", SlaExecution.Status.NOT_DISPATCHED, 0, "JSON parse failed: " + thE.getMessage(), null, 0L, 104, null), null, 0L, 0L, json, 28, null);
        }
        return (SlaResult) objB;
    }

    @Override // com.stepos.aiengine.algorithm.sla.ISla
    public int recognize(AlgorithmToken algorithmToken, SlaAudioInput slaAudioInput, SlaListener slaListener) {
        return ISla.DefaultImpls.recognize(this, algorithmToken, slaAudioInput, slaListener);
    }

    @Override // com.stepos.aiengine.algorithm.sla.ISla
    public int recognize(AlgorithmToken algorithmToken, SlaInput slaInput, SlaListener slaListener) {
        return ISla.DefaultImpls.recognize(this, algorithmToken, slaInput, slaListener);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [com.stepos.core.data.TextContent] */
    @Override // com.stepos.aiengine.algorithm.sla.ISla
    public int recognize(AlgorithmToken token, SlaInput input, Bundle args, final SlaListener listener) {
        AudioContent textContent;
        p.i(token, "token");
        p.i(input, "input");
        p.i(listener, "listener");
        if (input instanceof SlaInput.Audio) {
            textContent = b(((SlaInput.Audio) input).getAudio());
            if (textContent == null) {
                listener.onError(AIEngineError.INPUT_DATA_INVALID, "audio Bundle missing 'fd', 'bytes' or 'path' key");
                return AIEngineError.INPUT_DATA_INVALID;
            }
        } else if (input instanceof SlaInput.Text) {
            SlaInput.Text text = (SlaInput.Text) input;
            if (H.x0(text.getText())) {
                listener.onError(AIEngineError.INPUT_DATA_INVALID, "text input is blank");
                return AIEngineError.INPUT_DATA_INVALID;
            }
            textContent = new TextContent(text.getText());
        } else {
            throw new NoWhenBranchMatchedException();
        }
        if (args != null) {
            textContent.setParams(a(args));
        }
        this.handle.infer(String.valueOf(token.getIdentity()), (String) textContent, (InferenceCallback) new InferenceCallback<Content>() { // from class: com.stepos.aiengine.adapter.SlaAbilityAdapter.recognize.2
            @Override // com.stepos.core.InferenceCallback
            public void onNext(String inferId, InferResult<? extends Content> result) {
                String text2;
                p.i(inferId, "inferId");
                p.i(result, "result");
                if (result instanceof InferResult.Result) {
                    Content value = ((InferResult.Result) result).getValue();
                    TextContent textContent2 = value instanceof TextContent ? (TextContent) value : null;
                    if (textContent2 == null || (text2 = textContent2.getText()) == null) {
                        return;
                    }
                    SlaAbilityAdapter.this.c(text2, listener);
                    return;
                }
                if (result instanceof InferResult.Error) {
                    InferResult.Error error = (InferResult.Error) result;
                    listener.onError(error.getErrorCode(), error.getMessage());
                    return;
                }
                if (p.d(result, InferResult.Complete.INSTANCE)) {
                    return;
                }
                if (result instanceof InferResult.Cancelled) {
                    listener.onCancelled();
                } else if (result instanceof InferResult.RoutingDecision) {
                    InferResult.RoutingDecision routingDecision = (InferResult.RoutingDecision) result;
                    listener.onRoutingDecision(routingDecision.getExecutionLocation(), routingDecision.getReason());
                } else if (!(result instanceof InferResult.Progress)) {
                    throw new NoWhenBranchMatchedException();
                }
            }
        });
        return 0;
    }
}
