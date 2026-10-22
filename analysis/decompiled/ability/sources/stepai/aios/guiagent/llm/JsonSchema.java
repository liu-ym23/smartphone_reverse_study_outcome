package stepai.aios.guiagent.llm;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bHÆ\u0003J=\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lstepai/aios/guiagent/llm/JsonSchema;", "", "type", "", "properties", "", "Lstepai/aios/guiagent/llm/JsonSchemaProperty;", "required", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/util/Map;Ljava/util/List;)V", "getType", "()Ljava/lang/String;", "getProperties", "()Ljava/util/Map;", "getRequired", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class JsonSchema {
    private final Map<String, JsonSchemaProperty> properties;
    private final List<String> required;
    private final String type;

    public JsonSchema(String type, Map<String, JsonSchemaProperty> map, List<String> list) {
        k.f(type, "type");
        this.type = type;
        this.properties = map;
        this.required = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ JsonSchema copy$default(JsonSchema jsonSchema, String str, Map map, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = jsonSchema.type;
        }
        if ((i & 2) != 0) {
            map = jsonSchema.properties;
        }
        if ((i & 4) != 0) {
            list = jsonSchema.required;
        }
        return jsonSchema.copy(str, map, list);
    }

    /* renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    public final Map<String, JsonSchemaProperty> component2() {
        return this.properties;
    }

    public final List<String> component3() {
        return this.required;
    }

    public final JsonSchema copy(String type, Map<String, JsonSchemaProperty> properties, List<String> required) {
        k.f(type, "type");
        return new JsonSchema(type, properties, required);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof JsonSchema)) {
            return false;
        }
        JsonSchema jsonSchema = (JsonSchema) other;
        return k.b(this.type, jsonSchema.type) && k.b(this.properties, jsonSchema.properties) && k.b(this.required, jsonSchema.required);
    }

    public final Map<String, JsonSchemaProperty> getProperties() {
        return this.properties;
    }

    public final List<String> getRequired() {
        return this.required;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        int iHashCode = this.type.hashCode() * 31;
        Map<String, JsonSchemaProperty> map = this.properties;
        int iHashCode2 = (iHashCode + (map == null ? 0 : map.hashCode())) * 31;
        List<String> list = this.required;
        return iHashCode2 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        String str = this.type;
        Map<String, JsonSchemaProperty> map = this.properties;
        List<String> list = this.required;
        StringBuilder sb = new StringBuilder("JsonSchema(type=");
        sb.append(str);
        sb.append(", properties=");
        sb.append(map);
        sb.append(", required=");
        return androidx.appfunctions.metadata.a.q(sb, list, ")");
    }

    public /* synthetic */ JsonSchema(String str, Map map, List list, int i, e eVar) {
        this(str, (i & 2) != 0 ? null : map, (i & 4) != 0 ? null : list);
    }
}
