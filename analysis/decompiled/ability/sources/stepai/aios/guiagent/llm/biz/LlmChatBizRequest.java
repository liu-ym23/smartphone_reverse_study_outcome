package stepai.aios.guiagent.llm.biz;

import B7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import stepai.aios.guiagent.llm.LlmChatRequest;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lstepai/aios/guiagent/llm/biz/LlmChatBizRequest;", "", "llmChatRequest", "Lstepai/aios/guiagent/llm/LlmChatRequest;", "sessionId", "", "purpose", "Lstepai/aios/guiagent/llm/biz/LlmChatPurpose;", AppAgent.CONSTRUCT, "(Lstepai/aios/guiagent/llm/LlmChatRequest;Ljava/lang/String;Lstepai/aios/guiagent/llm/biz/LlmChatPurpose;)V", "getLlmChatRequest", "()Lstepai/aios/guiagent/llm/LlmChatRequest;", "getSessionId", "()Ljava/lang/String;", "getPurpose", "()Lstepai/aios/guiagent/llm/biz/LlmChatPurpose;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class LlmChatBizRequest {
    private final LlmChatRequest llmChatRequest;
    private final LlmChatPurpose purpose;
    private final String sessionId;

    public LlmChatBizRequest(LlmChatRequest llmChatRequest, String sessionId, LlmChatPurpose purpose) {
        k.f(llmChatRequest, "llmChatRequest");
        k.f(sessionId, "sessionId");
        k.f(purpose, "purpose");
        this.llmChatRequest = llmChatRequest;
        this.sessionId = sessionId;
        this.purpose = purpose;
    }

    public static /* synthetic */ LlmChatBizRequest copy$default(LlmChatBizRequest llmChatBizRequest, LlmChatRequest llmChatRequest, String str, LlmChatPurpose llmChatPurpose, int i, Object obj) {
        if ((i & 1) != 0) {
            llmChatRequest = llmChatBizRequest.llmChatRequest;
        }
        if ((i & 2) != 0) {
            str = llmChatBizRequest.sessionId;
        }
        if ((i & 4) != 0) {
            llmChatPurpose = llmChatBizRequest.purpose;
        }
        return llmChatBizRequest.copy(llmChatRequest, str, llmChatPurpose);
    }

    /* renamed from: component1, reason: from getter */
    public final LlmChatRequest getLlmChatRequest() {
        return this.llmChatRequest;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: component3, reason: from getter */
    public final LlmChatPurpose getPurpose() {
        return this.purpose;
    }

    public final LlmChatBizRequest copy(LlmChatRequest llmChatRequest, String sessionId, LlmChatPurpose purpose) {
        k.f(llmChatRequest, "llmChatRequest");
        k.f(sessionId, "sessionId");
        k.f(purpose, "purpose");
        return new LlmChatBizRequest(llmChatRequest, sessionId, purpose);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LlmChatBizRequest)) {
            return false;
        }
        LlmChatBizRequest llmChatBizRequest = (LlmChatBizRequest) other;
        return k.b(this.llmChatRequest, llmChatBizRequest.llmChatRequest) && k.b(this.sessionId, llmChatBizRequest.sessionId) && this.purpose == llmChatBizRequest.purpose;
    }

    public final LlmChatRequest getLlmChatRequest() {
        return this.llmChatRequest;
    }

    public final LlmChatPurpose getPurpose() {
        return this.purpose;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public int hashCode() {
        return this.purpose.hashCode() + a.c(this.llmChatRequest.hashCode() * 31, 31, this.sessionId);
    }

    public String toString() {
        return "LlmChatBizRequest(llmChatRequest=" + this.llmChatRequest + ", sessionId=" + this.sessionId + ", purpose=" + this.purpose + ")";
    }

    public /* synthetic */ LlmChatBizRequest(LlmChatRequest llmChatRequest, String str, LlmChatPurpose llmChatPurpose, int i, e eVar) {
        this(llmChatRequest, str, (i & 4) != 0 ? LlmChatPurpose.ACTION_EXECUTION : llmChatPurpose);
    }
}
