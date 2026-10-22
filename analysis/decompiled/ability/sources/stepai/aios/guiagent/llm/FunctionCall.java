package stepai.aios.guiagent.llm;

import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lstepai/aios/guiagent/llm/FunctionCall;", "", HintConstants.AUTOFILL_HINT_NAME, "", "arguments", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getArguments", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class FunctionCall {
    private final String arguments;
    private final String name;

    public FunctionCall(String name, String arguments) {
        k.f(name, "name");
        k.f(arguments, "arguments");
        this.name = name;
        this.arguments = arguments;
    }

    public static /* synthetic */ FunctionCall copy$default(FunctionCall functionCall, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = functionCall.name;
        }
        if ((i & 2) != 0) {
            str2 = functionCall.arguments;
        }
        return functionCall.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final String getArguments() {
        return this.arguments;
    }

    public final FunctionCall copy(String name, String arguments) {
        k.f(name, "name");
        k.f(arguments, "arguments");
        return new FunctionCall(name, arguments);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FunctionCall)) {
            return false;
        }
        FunctionCall functionCall = (FunctionCall) other;
        return k.b(this.name, functionCall.name) && k.b(this.arguments, functionCall.arguments);
    }

    public final String getArguments() {
        return this.arguments;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return this.arguments.hashCode() + (this.name.hashCode() * 31);
    }

    public String toString() {
        return androidx.appfunctions.metadata.a.m("FunctionCall(name=", this.name, ", arguments=", this.arguments, ")");
    }
}
