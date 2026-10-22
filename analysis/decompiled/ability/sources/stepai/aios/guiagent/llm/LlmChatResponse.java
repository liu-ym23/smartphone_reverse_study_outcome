package stepai.aios.guiagent.llm;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.JsonElement;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bq\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0006HÆ\u0003J\t\u0010(\u001a\u00020\bHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0011\u0010+\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0012HÆ\u0003Ju\u0010.\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÆ\u0001J\u0013\u0010/\u001a\u00020\b2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u000202HÖ\u0001J\t\u00103\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u00064"}, d2 = {"Lstepai/aios/guiagent/llm/LlmChatResponse;", "", "id", "", "content", "timestamp", "", "success", "", "error", "usage", "Lstepai/aios/guiagent/llm/LlmUsage;", "toolCalls", "", "Lstepai/aios/guiagent/llm/ToolCall;", "finishReason", "Lstepai/aios/guiagent/llm/FinishReason;", "rawResponse", "Lcom/google/gson/JsonElement;", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;JZLjava/lang/String;Lstepai/aios/guiagent/llm/LlmUsage;Ljava/util/List;Lstepai/aios/guiagent/llm/FinishReason;Lcom/google/gson/JsonElement;)V", "getId", "()Ljava/lang/String;", "getContent", "getTimestamp", "()J", "getSuccess", "()Z", "getError", "getUsage", "()Lstepai/aios/guiagent/llm/LlmUsage;", "getToolCalls", "()Ljava/util/List;", "getFinishReason", "()Lstepai/aios/guiagent/llm/FinishReason;", "getRawResponse", "()Lcom/google/gson/JsonElement;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class LlmChatResponse {
    private final String content;
    private final String error;
    private final FinishReason finishReason;
    private final String id;
    private final JsonElement rawResponse;
    private final boolean success;
    private final long timestamp;
    private final List<ToolCall> toolCalls;
    private final LlmUsage usage;

    public LlmChatResponse(String str, String content, long j5, boolean z10, String str2, LlmUsage llmUsage, List<ToolCall> list, FinishReason finishReason, JsonElement jsonElement) {
        k.f(content, "content");
        this.id = str;
        this.content = content;
        this.timestamp = j5;
        this.success = z10;
        this.error = str2;
        this.usage = llmUsage;
        this.toolCalls = list;
        this.finishReason = finishReason;
        this.rawResponse = jsonElement;
    }

    public static /* synthetic */ LlmChatResponse copy$default(LlmChatResponse llmChatResponse, String str, String str2, long j5, boolean z10, String str3, LlmUsage llmUsage, List list, FinishReason finishReason, JsonElement jsonElement, int i, Object obj) {
        if ((i & 1) != 0) {
            str = llmChatResponse.id;
        }
        if ((i & 2) != 0) {
            str2 = llmChatResponse.content;
        }
        if ((i & 4) != 0) {
            j5 = llmChatResponse.timestamp;
        }
        if ((i & 8) != 0) {
            z10 = llmChatResponse.success;
        }
        if ((i & 16) != 0) {
            str3 = llmChatResponse.error;
        }
        if ((i & 32) != 0) {
            llmUsage = llmChatResponse.usage;
        }
        if ((i & 64) != 0) {
            list = llmChatResponse.toolCalls;
        }
        if ((i & 128) != 0) {
            finishReason = llmChatResponse.finishReason;
        }
        if ((i & 256) != 0) {
            jsonElement = llmChatResponse.rawResponse;
        }
        FinishReason finishReason2 = finishReason;
        JsonElement jsonElement2 = jsonElement;
        long j6 = j5;
        return llmChatResponse.copy(str, str2, j6, z10, str3, llmUsage, list, finishReason2, jsonElement2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: component3, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    /* renamed from: component5, reason: from getter */
    public final String getError() {
        return this.error;
    }

    /* renamed from: component6, reason: from getter */
    public final LlmUsage getUsage() {
        return this.usage;
    }

    public final List<ToolCall> component7() {
        return this.toolCalls;
    }

    /* renamed from: component8, reason: from getter */
    public final FinishReason getFinishReason() {
        return this.finishReason;
    }

    /* renamed from: component9, reason: from getter */
    public final JsonElement getRawResponse() {
        return this.rawResponse;
    }

    public final LlmChatResponse copy(String id, String content, long timestamp, boolean success, String error, LlmUsage usage, List<ToolCall> toolCalls, FinishReason finishReason, JsonElement rawResponse) {
        k.f(content, "content");
        return new LlmChatResponse(id, content, timestamp, success, error, usage, toolCalls, finishReason, rawResponse);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LlmChatResponse)) {
            return false;
        }
        LlmChatResponse llmChatResponse = (LlmChatResponse) other;
        return k.b(this.id, llmChatResponse.id) && k.b(this.content, llmChatResponse.content) && this.timestamp == llmChatResponse.timestamp && this.success == llmChatResponse.success && k.b(this.error, llmChatResponse.error) && k.b(this.usage, llmChatResponse.usage) && k.b(this.toolCalls, llmChatResponse.toolCalls) && this.finishReason == llmChatResponse.finishReason && k.b(this.rawResponse, llmChatResponse.rawResponse);
    }

    public final String getContent() {
        return this.content;
    }

    public final String getError() {
        return this.error;
    }

    public final FinishReason getFinishReason() {
        return this.finishReason;
    }

    public final String getId() {
        return this.id;
    }

    public final JsonElement getRawResponse() {
        return this.rawResponse;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final List<ToolCall> getToolCalls() {
        return this.toolCalls;
    }

    public final LlmUsage getUsage() {
        return this.usage;
    }

    public int hashCode() {
        String str = this.id;
        int iD = androidx.appfunctions.metadata.a.d(androidx.appfunctions.metadata.a.c(B7.a.c((str == null ? 0 : str.hashCode()) * 31, 31, this.content), 31, this.timestamp), 31, this.success);
        String str2 = this.error;
        int iHashCode = (iD + (str2 == null ? 0 : str2.hashCode())) * 31;
        LlmUsage llmUsage = this.usage;
        int iHashCode2 = (iHashCode + (llmUsage == null ? 0 : llmUsage.hashCode())) * 31;
        List<ToolCall> list = this.toolCalls;
        int iHashCode3 = (iHashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        FinishReason finishReason = this.finishReason;
        int iHashCode4 = (iHashCode3 + (finishReason == null ? 0 : finishReason.hashCode())) * 31;
        JsonElement jsonElement = this.rawResponse;
        return iHashCode4 + (jsonElement != null ? jsonElement.hashCode() : 0);
    }

    public String toString() {
        String str = this.id;
        String str2 = this.content;
        long j5 = this.timestamp;
        boolean z10 = this.success;
        String str3 = this.error;
        LlmUsage llmUsage = this.usage;
        List<ToolCall> list = this.toolCalls;
        FinishReason finishReason = this.finishReason;
        JsonElement jsonElement = this.rawResponse;
        StringBuilder sbW = B7.a.w("LlmChatResponse(id=", str, ", content=", str2, ", timestamp=");
        sbW.append(j5);
        sbW.append(", success=");
        sbW.append(z10);
        sbW.append(", error=");
        sbW.append(str3);
        sbW.append(", usage=");
        sbW.append(llmUsage);
        sbW.append(", toolCalls=");
        sbW.append(list);
        sbW.append(", finishReason=");
        sbW.append(finishReason);
        sbW.append(", rawResponse=");
        sbW.append(jsonElement);
        sbW.append(")");
        return sbW.toString();
    }

    public /* synthetic */ LlmChatResponse(String str, String str2, long j5, boolean z10, String str3, LlmUsage llmUsage, List list, FinishReason finishReason, JsonElement jsonElement, int i, e eVar) {
        this((i & 1) != 0 ? null : str, str2, (i & 4) != 0 ? System.currentTimeMillis() : j5, (i & 8) != 0 ? true : z10, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : llmUsage, (i & 64) != 0 ? null : list, (i & 128) != 0 ? null : finishReason, (i & 256) != 0 ? null : jsonElement);
    }
}
