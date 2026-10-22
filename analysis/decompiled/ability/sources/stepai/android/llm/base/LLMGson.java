package stepai.android.llm.base;

import Ja.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import j9.m;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import stepai.android.llm.base.twoway.TTSFlowData;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lstepai/android/llm/base/LLMGson;", "", AppAgent.CONSTRUCT, "()V", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "toJson", "", "request", "Lstepai/android/llm/base/LLMRequest;", "llmbase_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LLMGson {
    public static final LLMGson INSTANCE = new LLMGson();
    private static final Gson gson;

    static {
        Gson gsonCreate = new GsonBuilder().registerTypeAdapter(Role.class, new RoleAdapter()).registerTypeAdapter(LLMRequestContent.class, new LLMRequestContentAdapter()).registerTypeAdapter(TTSFlowData.class, new a()).create();
        k.e(gsonCreate, "create(...)");
        gson = gsonCreate;
    }

    private LLMGson() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JsonElement gson$lambda$1(TTSFlowData tTSFlowData, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        if (!m.s0(tTSFlowData.getType())) {
            jsonObject.addProperty("type", tTSFlowData.getType());
        }
        if (!m.s0(tTSFlowData.getText())) {
            jsonObject.addProperty("text", tTSFlowData.getText());
        }
        if (!m.s0(tTSFlowData.getReason())) {
            jsonObject.addProperty("reason", tTSFlowData.getReason());
        }
        if (!m.s0(tTSFlowData.getMessage())) {
            jsonObject.addProperty("message", tTSFlowData.getMessage());
        }
        return jsonObject;
    }

    public final Gson getGson() {
        return gson;
    }

    public final String toJson(LLMRequest request) {
        k.f(request, "request");
        String json = gson.toJson(request);
        k.e(json, "toJson(...)");
        return json;
    }
}
