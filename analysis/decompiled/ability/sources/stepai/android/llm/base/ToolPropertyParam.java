package stepai.android.llm.base;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lstepai/android/llm/base/ToolPropertyParam;", "", "type", "Lstepai/android/llm/base/PropertyType;", "description", "", AppAgent.CONSTRUCT, "(Lstepai/android/llm/base/PropertyType;Ljava/lang/String;)V", "getType", "()Lstepai/android/llm/base/PropertyType;", "getDescription", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "llmbase_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ToolPropertyParam {
    private final String description;
    private final PropertyType type;

    public ToolPropertyParam(PropertyType type, String description) {
        k.f(type, "type");
        k.f(description, "description");
        this.type = type;
        this.description = description;
    }

    public static /* synthetic */ ToolPropertyParam copy$default(ToolPropertyParam toolPropertyParam, PropertyType propertyType, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            propertyType = toolPropertyParam.type;
        }
        if ((i & 2) != 0) {
            str = toolPropertyParam.description;
        }
        return toolPropertyParam.copy(propertyType, str);
    }

    /* renamed from: component1, reason: from getter */
    public final PropertyType getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final ToolPropertyParam copy(PropertyType type, String description) {
        k.f(type, "type");
        k.f(description, "description");
        return new ToolPropertyParam(type, description);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ToolPropertyParam)) {
            return false;
        }
        ToolPropertyParam toolPropertyParam = (ToolPropertyParam) other;
        return this.type == toolPropertyParam.type && k.b(this.description, toolPropertyParam.description);
    }

    public final String getDescription() {
        return this.description;
    }

    public final PropertyType getType() {
        return this.type;
    }

    public int hashCode() {
        return this.description.hashCode() + (this.type.hashCode() * 31);
    }

    public String toString() {
        return "ToolPropertyParam(type=" + this.type + ", description=" + this.description + ")";
    }
}
