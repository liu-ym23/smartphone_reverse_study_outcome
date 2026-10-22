package stepai.aios.guiagent.llm.parser;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lstepai/aios/guiagent/llm/parser/ParseResult;", "", "prefix", "", "toolCalls", "", "Lstepai/aios/guiagent/llm/parser/ToolCall;", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/util/List;)V", "getPrefix", "()Ljava/lang/String;", "getToolCalls", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ParseResult {
    private final String prefix;
    private final List<ToolCall> toolCalls;

    public ParseResult(String prefix, List<ToolCall> toolCalls) {
        k.f(prefix, "prefix");
        k.f(toolCalls, "toolCalls");
        this.prefix = prefix;
        this.toolCalls = toolCalls;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ParseResult copy$default(ParseResult parseResult, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = parseResult.prefix;
        }
        if ((i & 2) != 0) {
            list = parseResult.toolCalls;
        }
        return parseResult.copy(str, list);
    }

    /* renamed from: component1, reason: from getter */
    public final String getPrefix() {
        return this.prefix;
    }

    public final List<ToolCall> component2() {
        return this.toolCalls;
    }

    public final ParseResult copy(String prefix, List<ToolCall> toolCalls) {
        k.f(prefix, "prefix");
        k.f(toolCalls, "toolCalls");
        return new ParseResult(prefix, toolCalls);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ParseResult)) {
            return false;
        }
        ParseResult parseResult = (ParseResult) other;
        return k.b(this.prefix, parseResult.prefix) && k.b(this.toolCalls, parseResult.toolCalls);
    }

    public final String getPrefix() {
        return this.prefix;
    }

    public final List<ToolCall> getToolCalls() {
        return this.toolCalls;
    }

    public int hashCode() {
        return this.toolCalls.hashCode() + (this.prefix.hashCode() * 31);
    }

    public String toString() {
        return "ParseResult(prefix=" + this.prefix + ", toolCalls=" + this.toolCalls + ")";
    }
}
