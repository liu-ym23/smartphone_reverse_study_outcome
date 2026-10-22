package stepai.aios.guiagent.llm;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.aiengine.update.AlgorithmUpdateBundle;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\"\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u000eHÆ\u0003J_\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001J\u0013\u0010%\u001a\u00020\u00052\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006*"}, d2 = {"Lstepai/aios/guiagent/llm/LlmStreamResponse;", "", "delta", "", "finished", "", AlgorithmUpdateBundle.KEY_SUFFIX_MODEL, "usage", "Lstepai/aios/guiagent/llm/LlmUsage;", "error", "toolCalls", "", "Lstepai/aios/guiagent/llm/ToolCall;", "finishReason", "Lstepai/aios/guiagent/llm/FinishReason;", AppAgent.CONSTRUCT, "(Ljava/lang/String;ZLjava/lang/String;Lstepai/aios/guiagent/llm/LlmUsage;Ljava/lang/String;Ljava/util/List;Lstepai/aios/guiagent/llm/FinishReason;)V", "getDelta", "()Ljava/lang/String;", "getFinished", "()Z", "getModel", "getUsage", "()Lstepai/aios/guiagent/llm/LlmUsage;", "getError", "getToolCalls", "()Ljava/util/List;", "getFinishReason", "()Lstepai/aios/guiagent/llm/FinishReason;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class LlmStreamResponse {
    private final String delta;
    private final String error;
    private final FinishReason finishReason;
    private final boolean finished;
    private final String model;
    private final List<ToolCall> toolCalls;
    private final LlmUsage usage;

    public LlmStreamResponse(String delta, boolean z10, String str, LlmUsage llmUsage, String str2, List<ToolCall> list, FinishReason finishReason) {
        k.f(delta, "delta");
        this.delta = delta;
        this.finished = z10;
        this.model = str;
        this.usage = llmUsage;
        this.error = str2;
        this.toolCalls = list;
        this.finishReason = finishReason;
    }

    public static /* synthetic */ LlmStreamResponse copy$default(LlmStreamResponse llmStreamResponse, String str, boolean z10, String str2, LlmUsage llmUsage, String str3, List list, FinishReason finishReason, int i, Object obj) {
        if ((i & 1) != 0) {
            str = llmStreamResponse.delta;
        }
        if ((i & 2) != 0) {
            z10 = llmStreamResponse.finished;
        }
        if ((i & 4) != 0) {
            str2 = llmStreamResponse.model;
        }
        if ((i & 8) != 0) {
            llmUsage = llmStreamResponse.usage;
        }
        if ((i & 16) != 0) {
            str3 = llmStreamResponse.error;
        }
        if ((i & 32) != 0) {
            list = llmStreamResponse.toolCalls;
        }
        if ((i & 64) != 0) {
            finishReason = llmStreamResponse.finishReason;
        }
        List list2 = list;
        FinishReason finishReason2 = finishReason;
        String str4 = str3;
        String str5 = str2;
        return llmStreamResponse.copy(str, z10, str5, llmUsage, str4, list2, finishReason2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getDelta() {
        return this.delta;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getFinished() {
        return this.finished;
    }

    /* renamed from: component3, reason: from getter */
    public final String getModel() {
        return this.model;
    }

    /* renamed from: component4, reason: from getter */
    public final LlmUsage getUsage() {
        return this.usage;
    }

    /* renamed from: component5, reason: from getter */
    public final String getError() {
        return this.error;
    }

    public final List<ToolCall> component6() {
        return this.toolCalls;
    }

    /* renamed from: component7, reason: from getter */
    public final FinishReason getFinishReason() {
        return this.finishReason;
    }

    public final LlmStreamResponse copy(String delta, boolean finished, String model, LlmUsage usage, String error, List<ToolCall> toolCalls, FinishReason finishReason) {
        k.f(delta, "delta");
        return new LlmStreamResponse(delta, finished, model, usage, error, toolCalls, finishReason);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LlmStreamResponse)) {
            return false;
        }
        LlmStreamResponse llmStreamResponse = (LlmStreamResponse) other;
        return k.b(this.delta, llmStreamResponse.delta) && this.finished == llmStreamResponse.finished && k.b(this.model, llmStreamResponse.model) && k.b(this.usage, llmStreamResponse.usage) && k.b(this.error, llmStreamResponse.error) && k.b(this.toolCalls, llmStreamResponse.toolCalls) && this.finishReason == llmStreamResponse.finishReason;
    }

    public final String getDelta() {
        return this.delta;
    }

    public final String getError() {
        return this.error;
    }

    public final FinishReason getFinishReason() {
        return this.finishReason;
    }

    public final boolean getFinished() {
        return this.finished;
    }

    public final String getModel() {
        return this.model;
    }

    public final List<ToolCall> getToolCalls() {
        return this.toolCalls;
    }

    public final LlmUsage getUsage() {
        return this.usage;
    }

    public int hashCode() {
        int iD = androidx.appfunctions.metadata.a.d(this.delta.hashCode() * 31, 31, this.finished);
        String str = this.model;
        int iHashCode = (iD + (str == null ? 0 : str.hashCode())) * 31;
        LlmUsage llmUsage = this.usage;
        int iHashCode2 = (iHashCode + (llmUsage == null ? 0 : llmUsage.hashCode())) * 31;
        String str2 = this.error;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<ToolCall> list = this.toolCalls;
        int iHashCode4 = (iHashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        FinishReason finishReason = this.finishReason;
        return iHashCode4 + (finishReason != null ? finishReason.hashCode() : 0);
    }

    public String toString() {
        String str = this.delta;
        boolean z10 = this.finished;
        String str2 = this.model;
        LlmUsage llmUsage = this.usage;
        String str3 = this.error;
        List<ToolCall> list = this.toolCalls;
        FinishReason finishReason = this.finishReason;
        StringBuilder sbL = androidx.constraintlayout.core.dsl.a.l("LlmStreamResponse(delta=", str, ", finished=", ", model=", z10);
        sbL.append(str2);
        sbL.append(", usage=");
        sbL.append(llmUsage);
        sbL.append(", error=");
        sbL.append(str3);
        sbL.append(", toolCalls=");
        sbL.append(list);
        sbL.append(", finishReason=");
        sbL.append(finishReason);
        sbL.append(")");
        return sbL.toString();
    }

    public /* synthetic */ LlmStreamResponse(String str, boolean z10, String str2, LlmUsage llmUsage, String str3, List list, FinishReason finishReason, int i, e eVar) {
        this(str, (i & 2) != 0 ? false : z10, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : llmUsage, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : list, (i & 64) != 0 ? null : finishReason);
    }
}
