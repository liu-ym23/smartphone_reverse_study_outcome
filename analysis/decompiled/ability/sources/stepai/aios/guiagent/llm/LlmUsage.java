package stepai.aios.guiagent.llm;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lstepai/aios/guiagent/llm/LlmUsage;", "", "promptTokens", "", "completionTokens", "totalTokens", AppAgent.CONSTRUCT, "(III)V", "getPromptTokens", "()I", "getCompletionTokens", "getTotalTokens", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class LlmUsage {
    private final int completionTokens;
    private final int promptTokens;
    private final int totalTokens;

    public LlmUsage(int i, int i6, int i10) {
        this.promptTokens = i;
        this.completionTokens = i6;
        this.totalTokens = i10;
    }

    public static /* synthetic */ LlmUsage copy$default(LlmUsage llmUsage, int i, int i6, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i = llmUsage.promptTokens;
        }
        if ((i11 & 2) != 0) {
            i6 = llmUsage.completionTokens;
        }
        if ((i11 & 4) != 0) {
            i10 = llmUsage.totalTokens;
        }
        return llmUsage.copy(i, i6, i10);
    }

    /* renamed from: component1, reason: from getter */
    public final int getPromptTokens() {
        return this.promptTokens;
    }

    /* renamed from: component2, reason: from getter */
    public final int getCompletionTokens() {
        return this.completionTokens;
    }

    /* renamed from: component3, reason: from getter */
    public final int getTotalTokens() {
        return this.totalTokens;
    }

    public final LlmUsage copy(int promptTokens, int completionTokens, int totalTokens) {
        return new LlmUsage(promptTokens, completionTokens, totalTokens);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LlmUsage)) {
            return false;
        }
        LlmUsage llmUsage = (LlmUsage) other;
        return this.promptTokens == llmUsage.promptTokens && this.completionTokens == llmUsage.completionTokens && this.totalTokens == llmUsage.totalTokens;
    }

    public final int getCompletionTokens() {
        return this.completionTokens;
    }

    public final int getPromptTokens() {
        return this.promptTokens;
    }

    public final int getTotalTokens() {
        return this.totalTokens;
    }

    public int hashCode() {
        return Integer.hashCode(this.totalTokens) + androidx.constraintlayout.core.dsl.a.a(this.completionTokens, Integer.hashCode(this.promptTokens) * 31, 31);
    }

    public String toString() {
        int i = this.promptTokens;
        int i6 = this.completionTokens;
        return androidx.appfunctions.metadata.a.o(androidx.appfunctions.metadata.a.s(i, "LlmUsage(promptTokens=", i6, ", completionTokens=", ", totalTokens="), ")", this.totalTokens);
    }
}
