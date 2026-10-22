package stepai.aios.guiagent.llm.config;

import D7.v;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.stepos.agentframework.adapter.bff.BffConstant;
import com.stepos.aiengine.algorithm.chat.LlmRuntimeArgsBundle;
import com.stepos.aiengine.update.AlgorithmUpdateBundle;
import j9.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import stepai.aios.guiagent.config.LlmConfig;
import stepai.aios.guiagent.llm.LlmChatRequest;
import stepai.aios.guiagent.llm.Message;
import stepai.aios.guiagent.llm.ResponseFormat;
import stepai.aios.guiagent.llm.Tool;
import stepai.aios.guiagent.llm.ToolChoice;
import stepai.aios.guiagent.llm.parser.IModelCell;
import stepai.aios.guiagent.llm.parser.ModelParam;
import stepai.aios.guiagent.runtime.a;
import ua.C2052a;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 &2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0006J\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\bJ\u000e\u0010 \u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\bJ\u0016\u0010!\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\bJ\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\nJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\nJ\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\nJ\u0006\u0010\u0012\u001a\u00020\u0000J\u0014\u0010\u0014\u001a\u00020\u00002\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0018J\u0014\u0010\u0019\u001a\u00020\u00002\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u0015J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\rJ\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\bJ\u0006\u0010$\u001a\u00020%R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u0012\u0010\u000f\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010\u0010\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010\u0011\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lstepai/aios/guiagent/llm/config/LlmRequestBuilder;", "", AppAgent.CONSTRUCT, "()V", "messages", "", "Lstepai/aios/guiagent/llm/Message;", AlgorithmUpdateBundle.KEY_SUFFIX_MODEL, "", LlmRuntimeArgsBundle.KEY_TEMPERATURE, "", "Ljava/lang/Float;", "maxTokens", "", "Ljava/lang/Integer;", "topP", "frequencyPenalty", "presencePenalty", "stream", "", "tools", "", "Lstepai/aios/guiagent/llm/Tool;", "toolChoice", "Lstepai/aios/guiagent/llm/ToolChoice;", "stop", "seed", "responseFormat", "Lstepai/aios/guiagent/llm/ResponseFormat;", "message", "system", "text", BffConstant.Role.User, "userWithImage", "imageBase64", "type", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "Lstepai/aios/guiagent/llm/LlmChatRequest;", "Companion", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LlmRequestBuilder {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Float frequencyPenalty;
    private Integer maxTokens;
    private final List<Message> messages = new ArrayList();
    private String model;
    private Float presencePenalty;
    private ResponseFormat responseFormat;
    private Integer seed;
    private List<String> stop;
    private boolean stream;
    private Float temperature;
    private ToolChoice toolChoice;
    private List<Tool> tools;
    private Float topP;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007JE\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ-\u0010\t\u001a\u00020\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\f\u001a\u00020\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u0013J(\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00112\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¨\u0006\u0017"}, d2 = {"Lstepai/aios/guiagent/llm/config/LlmRequestBuilder$Companion;", "", AppAgent.CONSTRUCT, "()V", "buildBasicChat", "Lstepai/aios/guiagent/llm/LlmChatRequest;", "userMessage", "", "systemPrompt", "buildImageChatRequest", "imageBase64Num1", "imageBase64Num2", AlgorithmUpdateBundle.KEY_SUFFIX_MODEL, "maxTokens", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lstepai/aios/guiagent/llm/LlmChatRequest;", "messageList", "", "Lstepai/aios/guiagent/llm/Message;", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;)Lstepai/aios/guiagent/llm/LlmChatRequest;", "toolChat", "tools", "Lstepai/aios/guiagent/llm/Tool;", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public static /* synthetic */ LlmChatRequest buildBasicChat$default(Companion companion, String str, String str2, int i, Object obj) {
            if ((i & 2) != 0) {
                str2 = null;
            }
            return companion.buildBasicChat(str, str2);
        }

        public static /* synthetic */ LlmChatRequest buildImageChatRequest$default(Companion companion, String str, String str2, String str3, String str4, String str5, Integer num, int i, Object obj) {
            if ((i & 8) != 0) {
                str4 = null;
            }
            if ((i & 32) != 0) {
                num = null;
            }
            return companion.buildImageChatRequest(str, str2, str3, str4, str5, num);
        }

        public static /* synthetic */ LlmChatRequest toolChat$default(Companion companion, String str, List list, String str2, int i, Object obj) {
            if ((i & 4) != 0) {
                str2 = null;
            }
            return companion.toolChat(str, list, str2);
        }

        public final LlmChatRequest buildBasicChat(String userMessage, String systemPrompt) {
            k.f(userMessage, "userMessage");
            LlmRequestBuilder llmRequestBuilder = new LlmRequestBuilder();
            if (systemPrompt != null && !m.s0(systemPrompt)) {
                llmRequestBuilder.system(systemPrompt);
            }
            llmRequestBuilder.user(userMessage);
            return llmRequestBuilder.build();
        }

        public final LlmChatRequest buildImageChatRequest(String userMessage, String imageBase64Num1, String imageBase64Num2, String systemPrompt, String model, Integer maxTokens) {
            ModelParam modelParam;
            ModelParam modelParam2;
            ModelParam modelParam3;
            ModelParam modelParam4;
            k.f(userMessage, "userMessage");
            k.f(imageBase64Num2, "imageBase64Num2");
            k.f(model, "model");
            a aVar = C2052a.c;
            if (aVar == null) {
                throw new IllegalStateException("GuiAgentManager is not initialized");
            }
            LlmConfig llmConfig = aVar.f6128a.getLlmConfig();
            Float frequencyPenalty = null;
            IModelCell modelCell = llmConfig != null ? llmConfig.getModelCell() : null;
            Float fValueOf = (modelCell == null || (modelParam4 = modelCell.getModelParam()) == null) ? null : Float.valueOf(modelParam4.getTemperature());
            Float fValueOf2 = (modelCell == null || (modelParam3 = modelCell.getModelParam()) == null) ? null : Float.valueOf(modelParam3.getTopP());
            if (modelCell != null && (modelParam2 = modelCell.getModelParam()) != null) {
                frequencyPenalty = modelParam2.getFrequencyPenalty();
            }
            if (modelCell != null && (modelParam = modelCell.getModelParam()) != null) {
                maxTokens = Integer.valueOf(modelParam.getMaxToken());
            }
            LlmRequestBuilder llmRequestBuilder = new LlmRequestBuilder();
            if (systemPrompt != null && !m.s0(systemPrompt)) {
                llmRequestBuilder.system(systemPrompt);
            }
            if (imageBase64Num1 != null) {
                llmRequestBuilder.userWithImage(userMessage, imageBase64Num1);
            }
            llmRequestBuilder.userWithImage(userMessage, imageBase64Num2);
            llmRequestBuilder.model(model);
            if (maxTokens != null) {
                llmRequestBuilder.maxTokens(maxTokens.intValue());
            }
            if (fValueOf != null) {
                llmRequestBuilder.temperature(fValueOf.floatValue());
            }
            if (fValueOf2 != null) {
                llmRequestBuilder.topP(fValueOf2.floatValue());
            }
            if (frequencyPenalty != null) {
                llmRequestBuilder.frequencyPenalty(frequencyPenalty.floatValue());
            }
            return llmRequestBuilder.build();
        }

        public final LlmChatRequest toolChat(String userMessage, List<Tool> tools, String systemPrompt) {
            k.f(userMessage, "userMessage");
            k.f(tools, "tools");
            LlmRequestBuilder llmRequestBuilder = new LlmRequestBuilder();
            if (systemPrompt != null && !m.s0(systemPrompt)) {
                llmRequestBuilder.system(systemPrompt);
            }
            llmRequestBuilder.user(userMessage);
            llmRequestBuilder.tools(tools);
            llmRequestBuilder.toolChoice(ToolChoice.Auto.INSTANCE);
            return llmRequestBuilder.build();
        }

        private Companion() {
        }

        public static /* synthetic */ LlmChatRequest buildImageChatRequest$default(Companion companion, List list, String str, Integer num, int i, Object obj) {
            if ((i & 4) != 0) {
                num = null;
            }
            return companion.buildImageChatRequest(list, str, num);
        }

        public final LlmChatRequest buildImageChatRequest(List<Message> messageList, String model, Integer maxTokens) {
            ModelParam modelParam;
            ModelParam modelParam2;
            ModelParam modelParam3;
            ModelParam modelParam4;
            k.f(messageList, "messageList");
            k.f(model, "model");
            a aVar = C2052a.c;
            if (aVar != null) {
                LlmConfig llmConfig = aVar.f6128a.getLlmConfig();
                Float frequencyPenalty = null;
                IModelCell modelCell = llmConfig != null ? llmConfig.getModelCell() : null;
                Float fValueOf = (modelCell == null || (modelParam4 = modelCell.getModelParam()) == null) ? null : Float.valueOf(modelParam4.getTemperature());
                Float fValueOf2 = (modelCell == null || (modelParam3 = modelCell.getModelParam()) == null) ? null : Float.valueOf(modelParam3.getTopP());
                if (modelCell != null && (modelParam2 = modelCell.getModelParam()) != null) {
                    frequencyPenalty = modelParam2.getFrequencyPenalty();
                }
                if (modelCell != null && (modelParam = modelCell.getModelParam()) != null) {
                    maxTokens = Integer.valueOf(modelParam.getMaxToken());
                }
                LlmRequestBuilder llmRequestBuilder = new LlmRequestBuilder();
                Iterator<T> it = messageList.iterator();
                while (it.hasNext()) {
                    llmRequestBuilder.message((Message) it.next());
                }
                llmRequestBuilder.model(model);
                if (maxTokens != null) {
                    llmRequestBuilder.maxTokens(maxTokens.intValue());
                }
                if (fValueOf != null) {
                    llmRequestBuilder.temperature(fValueOf.floatValue());
                }
                if (fValueOf2 != null) {
                    llmRequestBuilder.topP(fValueOf2.floatValue());
                }
                if (frequencyPenalty != null) {
                    llmRequestBuilder.frequencyPenalty(frequencyPenalty.floatValue());
                }
                return llmRequestBuilder.build();
            }
            throw new IllegalStateException("GuiAgentManager is not initialized");
        }
    }

    public final LlmChatRequest build() {
        return new LlmChatRequest(v.f1(this.messages), this.model, this.temperature, this.maxTokens, this.topP, null, this.frequencyPenalty, this.presencePenalty, this.stream, this.tools, this.toolChoice, this.stop, this.seed, this.responseFormat, null, 16416, null);
    }

    public final LlmRequestBuilder frequencyPenalty(float frequencyPenalty) {
        this.frequencyPenalty = Float.valueOf(frequencyPenalty);
        return this;
    }

    public final LlmRequestBuilder maxTokens(int maxTokens) {
        this.maxTokens = Integer.valueOf(maxTokens);
        return this;
    }

    public final LlmRequestBuilder message(Message message) {
        k.f(message, "message");
        this.messages.add(message);
        return this;
    }

    public final LlmRequestBuilder model(String model) {
        k.f(model, "model");
        this.model = model;
        return this;
    }

    public final LlmRequestBuilder presencePenalty(float presencePenalty) {
        this.presencePenalty = Float.valueOf(presencePenalty);
        return this;
    }

    public final LlmRequestBuilder responseFormat(String type) {
        k.f(type, "type");
        this.responseFormat = new ResponseFormat(type);
        return this;
    }

    public final LlmRequestBuilder seed(int seed) {
        this.seed = Integer.valueOf(seed);
        return this;
    }

    public final LlmRequestBuilder stop(List<String> stop) {
        k.f(stop, "stop");
        this.stop = stop;
        return this;
    }

    public final LlmRequestBuilder stream() {
        this.stream = true;
        return this;
    }

    public final LlmRequestBuilder system(String text) {
        k.f(text, "text");
        this.messages.add(LlmMessageBuilder.INSTANCE.system(text));
        return this;
    }

    public final LlmRequestBuilder temperature(float temperature) {
        this.temperature = Float.valueOf(temperature);
        return this;
    }

    public final LlmRequestBuilder toolChoice(ToolChoice toolChoice) {
        k.f(toolChoice, "toolChoice");
        this.toolChoice = toolChoice;
        return this;
    }

    public final LlmRequestBuilder tools(List<Tool> tools) {
        k.f(tools, "tools");
        this.tools = tools;
        return this;
    }

    public final LlmRequestBuilder topP(float topP) {
        this.topP = Float.valueOf(topP);
        return this;
    }

    public final LlmRequestBuilder user(String text) {
        k.f(text, "text");
        this.messages.add(LlmMessageBuilder.INSTANCE.user(text));
        return this;
    }

    public final LlmRequestBuilder userWithImage(String text, String imageBase64) {
        k.f(text, "text");
        k.f(imageBase64, "imageBase64");
        this.messages.add(LlmMessageBuilder.INSTANCE.userWithImage(text, imageBase64));
        return this;
    }
}
