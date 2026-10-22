package stepai.aios.guiagent.llm;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003J=\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lstepai/aios/guiagent/llm/JsonSchemaProperty;", "", "type", "", "description", "enum", "", "items", "Lstepai/aios/guiagent/llm/JsonSchema;", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lstepai/aios/guiagent/llm/JsonSchema;)V", "getType", "()Ljava/lang/String;", "getDescription", "getEnum", "()Ljava/util/List;", "getItems", "()Lstepai/aios/guiagent/llm/JsonSchema;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class JsonSchemaProperty {
    private final String description;
    private final List<String> enum;
    private final JsonSchema items;
    private final String type;

    public JsonSchemaProperty(String type, String str, List<String> list, JsonSchema jsonSchema) {
        k.f(type, "type");
        this.type = type;
        this.description = str;
        this.enum = list;
        this.items = jsonSchema;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ JsonSchemaProperty copy$default(JsonSchemaProperty jsonSchemaProperty, String str, String str2, List list, JsonSchema jsonSchema, int i, Object obj) {
        if ((i & 1) != 0) {
            str = jsonSchemaProperty.type;
        }
        if ((i & 2) != 0) {
            str2 = jsonSchemaProperty.description;
        }
        if ((i & 4) != 0) {
            list = jsonSchemaProperty.enum;
        }
        if ((i & 8) != 0) {
            jsonSchema = jsonSchemaProperty.items;
        }
        return jsonSchemaProperty.copy(str, str2, list, jsonSchema);
    }

    /* renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final List<String> component3() {
        return this.enum;
    }

    /* renamed from: component4, reason: from getter */
    public final JsonSchema getItems() {
        return this.items;
    }

    public final JsonSchemaProperty copy(String type, String description, List<String> list, JsonSchema items) {
        k.f(type, "type");
        return new JsonSchemaProperty(type, description, list, items);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof JsonSchemaProperty)) {
            return false;
        }
        JsonSchemaProperty jsonSchemaProperty = (JsonSchemaProperty) other;
        return k.b(this.type, jsonSchemaProperty.type) && k.b(this.description, jsonSchemaProperty.description) && k.b(this.enum, jsonSchemaProperty.enum) && k.b(this.items, jsonSchemaProperty.items);
    }

    public final String getDescription() {
        return this.description;
    }

    public final List<String> getEnum() {
        return this.enum;
    }

    public final JsonSchema getItems() {
        return this.items;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        int iHashCode = this.type.hashCode() * 31;
        String str = this.description;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        List<String> list = this.enum;
        int iHashCode3 = (iHashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        JsonSchema jsonSchema = this.items;
        return iHashCode3 + (jsonSchema != null ? jsonSchema.hashCode() : 0);
    }

    public String toString() {
        String str = this.type;
        String str2 = this.description;
        List<String> list = this.enum;
        JsonSchema jsonSchema = this.items;
        StringBuilder sbW = B7.a.w("JsonSchemaProperty(type=", str, ", description=", str2, ", enum=");
        sbW.append(list);
        sbW.append(", items=");
        sbW.append(jsonSchema);
        sbW.append(")");
        return sbW.toString();
    }

    public /* synthetic */ JsonSchemaProperty(String str, String str2, List list, JsonSchema jsonSchema, int i, e eVar) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : list, (i & 8) != 0 ? null : jsonSchema);
    }
}
