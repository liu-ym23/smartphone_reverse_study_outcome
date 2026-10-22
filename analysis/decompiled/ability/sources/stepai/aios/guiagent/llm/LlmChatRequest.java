package stepai.aios.guiagent.llm;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.aiengine.algorithm.chat.LlmRuntimeArgsBundle;
import com.stepos.aiengine.update.AlgorithmUpdateBundle;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b1\b\u0086\b\u0018\u00002\u00020\u0001BÇ\u0001\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u00106\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010!J\u0010\u00107\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010$J\u0010\u00108\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010!J\u0010\u00109\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010$J\u0010\u0010:\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010!J\u0010\u0010;\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010!J\t\u0010<\u001a\u00020\u0010HÆ\u0003J\u0011\u0010=\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0003HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u0011\u0010?\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J\u0010\u0010@\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010$J\u000b\u0010A\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\u0010\u0010B\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010$JÐ\u0001\u0010C\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010DJ\u0013\u0010E\u001a\u00020\u00102\b\u0010F\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010G\u001a\u00020\nHÖ\u0001J\t\u0010H\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010%\u001a\u0004\b#\u0010$R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b&\u0010!R\u0015\u0010\f\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010%\u001a\u0004\b'\u0010$R\u0015\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b(\u0010!R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b)\u0010!R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0019\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001dR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0019\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001dR\u0015\u0010\u0016\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010%\u001a\u0004\b0\u0010$R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0015\u0010\u0019\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010%\u001a\u0004\b3\u0010$¨\u0006I"}, d2 = {"Lstepai/aios/guiagent/llm/LlmChatRequest;", "", "messages", "", "Lstepai/aios/guiagent/llm/Message;", AlgorithmUpdateBundle.KEY_SUFFIX_MODEL, "", LlmRuntimeArgsBundle.KEY_TEMPERATURE, "", "maxTokens", "", "topP", "topK", "frequencyPenalty", "presencePenalty", "stream", "", "tools", "Lstepai/aios/guiagent/llm/Tool;", "toolChoice", "Lstepai/aios/guiagent/llm/ToolChoice;", "stop", "seed", "responseFormat", "Lstepai/aios/guiagent/llm/ResponseFormat;", "candidateCount", AppAgent.CONSTRUCT, "(Ljava/util/List;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Float;ZLjava/util/List;Lstepai/aios/guiagent/llm/ToolChoice;Ljava/util/List;Ljava/lang/Integer;Lstepai/aios/guiagent/llm/ResponseFormat;Ljava/lang/Integer;)V", "getMessages", "()Ljava/util/List;", "getModel", "()Ljava/lang/String;", "getTemperature", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getMaxTokens", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTopP", "getTopK", "getFrequencyPenalty", "getPresencePenalty", "getStream", "()Z", "getTools", "getToolChoice", "()Lstepai/aios/guiagent/llm/ToolChoice;", "getStop", "getSeed", "getResponseFormat", "()Lstepai/aios/guiagent/llm/ResponseFormat;", "getCandidateCount", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Float;ZLjava/util/List;Lstepai/aios/guiagent/llm/ToolChoice;Ljava/util/List;Ljava/lang/Integer;Lstepai/aios/guiagent/llm/ResponseFormat;Ljava/lang/Integer;)Lstepai/aios/guiagent/llm/LlmChatRequest;", "equals", "other", "hashCode", "toString", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class LlmChatRequest {
    private final Integer candidateCount;
    private final Float frequencyPenalty;
    private final Integer maxTokens;
    private final List<Message> messages;
    private final String model;
    private final Float presencePenalty;
    private final ResponseFormat responseFormat;
    private final Integer seed;
    private final List<String> stop;
    private final boolean stream;
    private final Float temperature;
    private final ToolChoice toolChoice;
    private final List<Tool> tools;
    private final Integer topK;
    private final Float topP;

    public LlmChatRequest(List<Message> messages, String str, Float f, Integer num, Float f7, Integer num2, Float f9, Float f10, boolean z10, List<Tool> list, ToolChoice toolChoice, List<String> list2, Integer num3, ResponseFormat responseFormat, Integer num4) {
        k.f(messages, "messages");
        this.messages = messages;
        this.model = str;
        this.temperature = f;
        this.maxTokens = num;
        this.topP = f7;
        this.topK = num2;
        this.frequencyPenalty = f9;
        this.presencePenalty = f10;
        this.stream = z10;
        this.tools = list;
        this.toolChoice = toolChoice;
        this.stop = list2;
        this.seed = num3;
        this.responseFormat = responseFormat;
        this.candidateCount = num4;
    }

    public final List<Message> component1() {
        return this.messages;
    }

    public final List<Tool> component10() {
        return this.tools;
    }

    /* renamed from: component11, reason: from getter */
    public final ToolChoice getToolChoice() {
        return this.toolChoice;
    }

    public final List<String> component12() {
        return this.stop;
    }

    /* renamed from: component13, reason: from getter */
    public final Integer getSeed() {
        return this.seed;
    }

    /* renamed from: component14, reason: from getter */
    public final ResponseFormat getResponseFormat() {
        return this.responseFormat;
    }

    /* renamed from: component15, reason: from getter */
    public final Integer getCandidateCount() {
        return this.candidateCount;
    }

    /* renamed from: component2, reason: from getter */
    public final String getModel() {
        return this.model;
    }

    /* renamed from: component3, reason: from getter */
    public final Float getTemperature() {
        return this.temperature;
    }

    /* renamed from: component4, reason: from getter */
    public final Integer getMaxTokens() {
        return this.maxTokens;
    }

    /* renamed from: component5, reason: from getter */
    public final Float getTopP() {
        return this.topP;
    }

    /* renamed from: component6, reason: from getter */
    public final Integer getTopK() {
        return this.topK;
    }

    /* renamed from: component7, reason: from getter */
    public final Float getFrequencyPenalty() {
        return this.frequencyPenalty;
    }

    /* renamed from: component8, reason: from getter */
    public final Float getPresencePenalty() {
        return this.presencePenalty;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getStream() {
        return this.stream;
    }

    public final LlmChatRequest copy(List<Message> messages, String model, Float temperature, Integer maxTokens, Float topP, Integer topK, Float frequencyPenalty, Float presencePenalty, boolean stream, List<Tool> tools, ToolChoice toolChoice, List<String> stop, Integer seed, ResponseFormat responseFormat, Integer candidateCount) {
        k.f(messages, "messages");
        return new LlmChatRequest(messages, model, temperature, maxTokens, topP, topK, frequencyPenalty, presencePenalty, stream, tools, toolChoice, stop, seed, responseFormat, candidateCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LlmChatRequest)) {
            return false;
        }
        LlmChatRequest llmChatRequest = (LlmChatRequest) other;
        return k.b(this.messages, llmChatRequest.messages) && k.b(this.model, llmChatRequest.model) && k.b(this.temperature, llmChatRequest.temperature) && k.b(this.maxTokens, llmChatRequest.maxTokens) && k.b(this.topP, llmChatRequest.topP) && k.b(this.topK, llmChatRequest.topK) && k.b(this.frequencyPenalty, llmChatRequest.frequencyPenalty) && k.b(this.presencePenalty, llmChatRequest.presencePenalty) && this.stream == llmChatRequest.stream && k.b(this.tools, llmChatRequest.tools) && k.b(this.toolChoice, llmChatRequest.toolChoice) && k.b(this.stop, llmChatRequest.stop) && k.b(this.seed, llmChatRequest.seed) && k.b(this.responseFormat, llmChatRequest.responseFormat) && k.b(this.candidateCount, llmChatRequest.candidateCount);
    }

    public final Integer getCandidateCount() {
        return this.candidateCount;
    }

    public final Float getFrequencyPenalty() {
        return this.frequencyPenalty;
    }

    public final Integer getMaxTokens() {
        return this.maxTokens;
    }

    public final List<Message> getMessages() {
        return this.messages;
    }

    public final String getModel() {
        return this.model;
    }

    public final Float getPresencePenalty() {
        return this.presencePenalty;
    }

    public final ResponseFormat getResponseFormat() {
        return this.responseFormat;
    }

    public final Integer getSeed() {
        return this.seed;
    }

    public final List<String> getStop() {
        return this.stop;
    }

    public final boolean getStream() {
        return this.stream;
    }

    public final Float getTemperature() {
        return this.temperature;
    }

    public final ToolChoice getToolChoice() {
        return this.toolChoice;
    }

    public final List<Tool> getTools() {
        return this.tools;
    }

    public final Integer getTopK() {
        return this.topK;
    }

    public final Float getTopP() {
        return this.topP;
    }

    public int hashCode() {
        int iHashCode = this.messages.hashCode() * 31;
        String str = this.model;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Float f = this.temperature;
        int iHashCode3 = (iHashCode2 + (f == null ? 0 : f.hashCode())) * 31;
        Integer num = this.maxTokens;
        int iHashCode4 = (iHashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        Float f7 = this.topP;
        int iHashCode5 = (iHashCode4 + (f7 == null ? 0 : f7.hashCode())) * 31;
        Integer num2 = this.topK;
        int iHashCode6 = (iHashCode5 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Float f9 = this.frequencyPenalty;
        int iHashCode7 = (iHashCode6 + (f9 == null ? 0 : f9.hashCode())) * 31;
        Float f10 = this.presencePenalty;
        int iD = androidx.appfunctions.metadata.a.d((iHashCode7 + (f10 == null ? 0 : f10.hashCode())) * 31, 31, this.stream);
        List<Tool> list = this.tools;
        int iHashCode8 = (iD + (list == null ? 0 : list.hashCode())) * 31;
        ToolChoice toolChoice = this.toolChoice;
        int iHashCode9 = (iHashCode8 + (toolChoice == null ? 0 : toolChoice.hashCode())) * 31;
        List<String> list2 = this.stop;
        int iHashCode10 = (iHashCode9 + (list2 == null ? 0 : list2.hashCode())) * 31;
        Integer num3 = this.seed;
        int iHashCode11 = (iHashCode10 + (num3 == null ? 0 : num3.hashCode())) * 31;
        ResponseFormat responseFormat = this.responseFormat;
        int iHashCode12 = (iHashCode11 + (responseFormat == null ? 0 : responseFormat.hashCode())) * 31;
        Integer num4 = this.candidateCount;
        return iHashCode12 + (num4 != null ? num4.hashCode() : 0);
    }

    public String toString() {
        return "LlmChatRequest(messages=" + this.messages + ", model=" + this.model + ", temperature=" + this.temperature + ", maxTokens=" + this.maxTokens + ", topP=" + this.topP + ", topK=" + this.topK + ", frequencyPenalty=" + this.frequencyPenalty + ", presencePenalty=" + this.presencePenalty + ", stream=" + this.stream + ", tools=" + this.tools + ", toolChoice=" + this.toolChoice + ", stop=" + this.stop + ", seed=" + this.seed + ", responseFormat=" + this.responseFormat + ", candidateCount=" + this.candidateCount + ")";
    }

    public /* synthetic */ LlmChatRequest(List list, String str, Float f, Integer num, Float f7, Integer num2, Float f9, Float f10, boolean z10, List list2, ToolChoice toolChoice, List list3, Integer num3, ResponseFormat responseFormat, Integer num4, int i, e eVar) {
        this(list, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : f, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : f7, (i & 32) != 0 ? null : num2, (i & 64) != 0 ? null : f9, (i & 128) != 0 ? null : f10, (i & 256) != 0 ? false : z10, (i & 512) != 0 ? null : list2, (i & 1024) != 0 ? null : toolChoice, (i & 2048) != 0 ? null : list3, (i & 4096) != 0 ? null : num3, (i & 8192) != 0 ? null : responseFormat, (i & 16384) != 0 ? null : num4);
    }
}
