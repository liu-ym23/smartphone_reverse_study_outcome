package stepai.aios.guiagent.llm;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lstepai/aios/guiagent/llm/ToolCall;", "", "id", "", "type", "function", "Lstepai/aios/guiagent/llm/FunctionCall;", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Lstepai/aios/guiagent/llm/FunctionCall;)V", "getId", "()Ljava/lang/String;", "getType", "getFunction", "()Lstepai/aios/guiagent/llm/FunctionCall;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ToolCall {
    private final FunctionCall function;
    private final String id;
    private final String type;

    public ToolCall(String id, String type, FunctionCall function) {
        k.f(id, "id");
        k.f(type, "type");
        k.f(function, "function");
        this.id = id;
        this.type = type;
        this.function = function;
    }

    public static /* synthetic */ ToolCall copy$default(ToolCall toolCall, String str, String str2, FunctionCall functionCall, int i, Object obj) {
        if ((i & 1) != 0) {
            str = toolCall.id;
        }
        if ((i & 2) != 0) {
            str2 = toolCall.type;
        }
        if ((i & 4) != 0) {
            functionCall = toolCall.function;
        }
        return toolCall.copy(str, str2, functionCall);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component3, reason: from getter */
    public final FunctionCall getFunction() {
        return this.function;
    }

    public final ToolCall copy(String id, String type, FunctionCall function) {
        k.f(id, "id");
        k.f(type, "type");
        k.f(function, "function");
        return new ToolCall(id, type, function);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ToolCall)) {
            return false;
        }
        ToolCall toolCall = (ToolCall) other;
        return k.b(this.id, toolCall.id) && k.b(this.type, toolCall.type) && k.b(this.function, toolCall.function);
    }

    public final FunctionCall getFunction() {
        return this.function;
    }

    public final String getId() {
        return this.id;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        return this.function.hashCode() + B7.a.c(this.id.hashCode() * 31, 31, this.type);
    }

    public String toString() {
        String str = this.id;
        String str2 = this.type;
        FunctionCall functionCall = this.function;
        StringBuilder sbW = B7.a.w("ToolCall(id=", str, ", type=", str2, ", function=");
        sbW.append(functionCall);
        sbW.append(")");
        return sbW.toString();
    }

    public /* synthetic */ ToolCall(String str, String str2, FunctionCall functionCall, int i, e eVar) {
        this(str, (i & 2) != 0 ? "function" : str2, functionCall);
    }
}
