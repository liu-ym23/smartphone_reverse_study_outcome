package stepai.aios.guiagent.llm;

import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lstepai/aios/guiagent/llm/FunctionDefinition;", "", HintConstants.AUTOFILL_HINT_NAME, "", "description", "parameters", "Lstepai/aios/guiagent/llm/JsonSchema;", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Lstepai/aios/guiagent/llm/JsonSchema;)V", "getName", "()Ljava/lang/String;", "getDescription", "getParameters", "()Lstepai/aios/guiagent/llm/JsonSchema;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class FunctionDefinition {
    private final String description;
    private final String name;
    private final JsonSchema parameters;

    public FunctionDefinition(String name, String description, JsonSchema parameters) {
        k.f(name, "name");
        k.f(description, "description");
        k.f(parameters, "parameters");
        this.name = name;
        this.description = description;
        this.parameters = parameters;
    }

    public static /* synthetic */ FunctionDefinition copy$default(FunctionDefinition functionDefinition, String str, String str2, JsonSchema jsonSchema, int i, Object obj) {
        if ((i & 1) != 0) {
            str = functionDefinition.name;
        }
        if ((i & 2) != 0) {
            str2 = functionDefinition.description;
        }
        if ((i & 4) != 0) {
            jsonSchema = functionDefinition.parameters;
        }
        return functionDefinition.copy(str, str2, jsonSchema);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component3, reason: from getter */
    public final JsonSchema getParameters() {
        return this.parameters;
    }

    public final FunctionDefinition copy(String name, String description, JsonSchema parameters) {
        k.f(name, "name");
        k.f(description, "description");
        k.f(parameters, "parameters");
        return new FunctionDefinition(name, description, parameters);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FunctionDefinition)) {
            return false;
        }
        FunctionDefinition functionDefinition = (FunctionDefinition) other;
        return k.b(this.name, functionDefinition.name) && k.b(this.description, functionDefinition.description) && k.b(this.parameters, functionDefinition.parameters);
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getName() {
        return this.name;
    }

    public final JsonSchema getParameters() {
        return this.parameters;
    }

    public int hashCode() {
        return this.parameters.hashCode() + B7.a.c(this.name.hashCode() * 31, 31, this.description);
    }

    public String toString() {
        String str = this.name;
        String str2 = this.description;
        JsonSchema jsonSchema = this.parameters;
        StringBuilder sbW = B7.a.w("FunctionDefinition(name=", str, ", description=", str2, ", parameters=");
        sbW.append(jsonSchema);
        sbW.append(")");
        return sbW.toString();
    }
}
