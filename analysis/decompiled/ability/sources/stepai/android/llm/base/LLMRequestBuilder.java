package stepai.android.llm.base;

import D7.v;
import H4.o;
import S7.k;
import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.stepos.ability.commoninternal.AgentCache;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import com.stepos.aiengine.algorithm.chat.LlmRuntimeArgsBundle;
import com.stepos.aiengine.update.AlgorithmUpdateBundle;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.EmptyList;
import kotlin.collections.a;
import stepai.android.llm.base.LLMRequestContent;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0005\u001a\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\u00002\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0004\b\u000e\u0010\u000fJM\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0014\b\u0002\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00130\u00122\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001b¢\u0006\u0004\b\u001e\u0010\u001dJ!\u0010 \u001a\u00020\u00002\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0004\b \u0010\u000fJ\u0017\u0010!\u001a\u00020\u00002\b\u0010!\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b!\u0010\u0006J\u0015\u0010#\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b#\u0010$J\r\u0010&\u001a\u00020%¢\u0006\u0004\b&\u0010'R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010(R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020*0)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020\u000b0)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010,R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020.0)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010,R\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u00100R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u00101R\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u00102R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u00102R\u0018\u0010!\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010(¨\u00063"}, d2 = {"Lstepai/android/llm/base/LLMRequestBuilder;", "", AppAgent.CONSTRUCT, "()V", "", AlgorithmUpdateBundle.KEY_SUFFIX_MODEL, "(Ljava/lang/String;)Lstepai/android/llm/base/LLMRequestBuilder;", "", "maxTokens", "(Ljava/lang/Integer;)Ljava/lang/Integer;", "Lkotlin/Function1;", "Lstepai/android/llm/base/MessageBuilder;", "LC7/r;", "init", "message", "(LS7/k;)Lstepai/android/llm/base/LLMRequestBuilder;", HintConstants.AUTOFILL_HINT_NAME, "description", "", "Lstepai/android/llm/base/ToolPropertyParam;", "parameters", "", "required", "Lstepai/android/llm/base/ParameterType;", "parameterType", AgentCache.AGENT_CACHE_TASK_TYPE_TOOL, "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/List;Lstepai/android/llm/base/ParameterType;)Lstepai/android/llm/base/LLMRequestBuilder;", "", LlmRuntimeArgsBundle.KEY_TEMPERATURE, "(F)Lstepai/android/llm/base/LLMRequestBuilder;", "topP", "Lstepai/android/llm/base/SimpleMessageBuilder;", "simpleMessage", AgentBusWakeContract.EXTRA_TRACE_ID, "", "stream", "(Z)Lstepai/android/llm/base/LLMRequestBuilder;", "Lstepai/android/llm/base/LLMRequest;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "()Lstepai/android/llm/base/LLMRequest;", "Ljava/lang/String;", "", "Lstepai/android/llm/base/LLMRequestMessage;", "messages", "Ljava/util/List;", "messageBuilders", "Lstepai/android/llm/base/Tool;", "tools", "Z", "I", "F", "llmbase_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LLMRequestBuilder {
    private boolean stream;
    private float temperature;
    private String traceId;
    private String model = "";
    private final List<LLMRequestMessage> messages = new ArrayList();
    private final List<MessageBuilder> messageBuilders = new ArrayList();
    private final List<Tool> tools = new ArrayList();
    private int maxTokens = 8192;
    private float topP = 1.0f;

    public static LLMRequestBuilder tool$default(LLMRequestBuilder lLMRequestBuilder, String str, String str2, Map map, List list, ParameterType parameterType, int i, Object obj) {
        if ((i & 4) != 0) {
            map = a.M();
        }
        Map map2 = map;
        if ((i & 8) != 0) {
            list = EmptyList.f4893a;
        }
        List list2 = list;
        if ((i & 16) != 0) {
            parameterType = ParameterType.OBJECT;
        }
        return lLMRequestBuilder.tool(str, str2, map2, list2, parameterType);
    }

    public final LLMRequest build() {
        return new LLMRequest(this.traceId, this.model, v.f1(this.messages), v.f1(this.tools), this.stream, this.maxTokens, Float.valueOf(this.temperature), Float.valueOf(this.topP), null, null, 768, null);
    }

    public final Integer maxTokens(Integer maxTokens) {
        if (maxTokens == null) {
            return null;
        }
        this.maxTokens = maxTokens.intValue();
        return maxTokens;
    }

    public final LLMRequestBuilder message(k init) {
        kotlin.jvm.internal.k.f(init, "init");
        MessageBuilder messageBuilder = new MessageBuilder();
        init.invoke(messageBuilder);
        this.messageBuilders.add(messageBuilder);
        this.messages.add(messageBuilder.build());
        return this;
    }

    public final LLMRequestBuilder model(String model) {
        this.model = model;
        return this;
    }

    public final LLMRequestBuilder simpleMessage(k init) {
        kotlin.jvm.internal.k.f(init, "init");
        SimpleMessageBuilder simpleMessageBuilder = new SimpleMessageBuilder();
        init.invoke(simpleMessageBuilder);
        this.messages.add(new LLMRequestMessage(simpleMessageBuilder.build().getRole(), o.M(new LLMRequestContent.Text(simpleMessageBuilder.build().getContent(), null, 2, null))));
        return this;
    }

    public final LLMRequestBuilder stream(boolean stream) {
        this.stream = stream;
        return this;
    }

    public final LLMRequestBuilder temperature(float temperature) {
        this.temperature = temperature;
        return this;
    }

    public final LLMRequestBuilder tool(String name, String description, Map<String, ToolPropertyParam> parameters, List<String> required, ParameterType parameterType) {
        kotlin.jvm.internal.k.f(name, "name");
        kotlin.jvm.internal.k.f(description, "description");
        kotlin.jvm.internal.k.f(parameters, "parameters");
        kotlin.jvm.internal.k.f(required, "required");
        kotlin.jvm.internal.k.f(parameterType, "parameterType");
        ArrayList arrayList = new ArrayList(parameters.size());
        for (Map.Entry<String, ToolPropertyParam> entry : parameters.entrySet()) {
            String key = entry.getKey();
            ToolPropertyParam value = entry.getValue();
            arrayList.add(new Pair(key, new ToolProperty(value.getType().getValue(), value.getDescription())));
        }
        this.tools.add(new Tool(ToolType.FUNCTION.getValue(), new ToolFunction(name, description, new ToolParameters(parameterType.getValue(), a.X(arrayList), required))));
        return this;
    }

    public final LLMRequestBuilder topP(float topP) {
        this.topP = topP;
        return this;
    }

    public final LLMRequestBuilder traceId(String traceId) {
        this.traceId = traceId;
        return this;
    }
}
