package stepai.aios.guiagent.llm;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lstepai/aios/guiagent/llm/Tool;", "", "type", "", "function", "Lstepai/aios/guiagent/llm/FunctionDefinition;", AppAgent.CONSTRUCT, "(Ljava/lang/String;Lstepai/aios/guiagent/llm/FunctionDefinition;)V", "getType", "()Ljava/lang/String;", "getFunction", "()Lstepai/aios/guiagent/llm/FunctionDefinition;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class Tool {
    private final FunctionDefinition function;
    private final String type;

    public Tool(String type, FunctionDefinition function) {
        k.f(type, "type");
        k.f(function, "function");
        this.type = type;
        this.function = function;
    }

    public static /* synthetic */ Tool copy$default(Tool tool, String str, FunctionDefinition functionDefinition, int i, Object obj) {
        if ((i & 1) != 0) {
            str = tool.type;
        }
        if ((i & 2) != 0) {
            functionDefinition = tool.function;
        }
        return tool.copy(str, functionDefinition);
    }

    /* renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final FunctionDefinition getFunction() {
        return this.function;
    }

    public final Tool copy(String type, FunctionDefinition function) {
        k.f(type, "type");
        k.f(function, "function");
        return new Tool(type, function);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Tool)) {
            return false;
        }
        Tool tool = (Tool) other;
        return k.b(this.type, tool.type) && k.b(this.function, tool.function);
    }

    public final FunctionDefinition getFunction() {
        return this.function;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        return this.function.hashCode() + (this.type.hashCode() * 31);
    }

    public String toString() {
        return "Tool(type=" + this.type + ", function=" + this.function + ")";
    }

    public /* synthetic */ Tool(String str, FunctionDefinition functionDefinition, int i, e eVar) {
        this((i & 1) != 0 ? "function" : str, functionDefinition);
    }
}
