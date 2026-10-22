package com.stepos.ability.net.biz.model;

import androidx.appfunctions.metadata.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bHÆ\u0003J=\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR$\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/stepos/ability/net/biz/model/OutputSchema;", "", "type", "", "properties", "", "Lcom/stepos/ability/net/biz/model/Property;", "required", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/util/Map;Ljava/util/List;)V", "getType", "()Ljava/lang/String;", "getProperties", "()Ljava/util/Map;", "getRequired", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "net_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class OutputSchema {

    @SerializedName("properties")
    private final Map<String, Property> properties;

    @SerializedName("required")
    private final List<String> required;

    @SerializedName("type")
    private final String type;

    public OutputSchema(String type, Map<String, Property> map, List<String> list) {
        k.f(type, "type");
        this.type = type;
        this.properties = map;
        this.required = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OutputSchema copy$default(OutputSchema outputSchema, String str, Map map, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = outputSchema.type;
        }
        if ((i & 2) != 0) {
            map = outputSchema.properties;
        }
        if ((i & 4) != 0) {
            list = outputSchema.required;
        }
        return outputSchema.copy(str, map, list);
    }

    /* renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    public final Map<String, Property> component2() {
        return this.properties;
    }

    public final List<String> component3() {
        return this.required;
    }

    public final OutputSchema copy(String type, Map<String, Property> properties, List<String> required) {
        k.f(type, "type");
        return new OutputSchema(type, properties, required);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OutputSchema)) {
            return false;
        }
        OutputSchema outputSchema = (OutputSchema) other;
        return k.b(this.type, outputSchema.type) && k.b(this.properties, outputSchema.properties) && k.b(this.required, outputSchema.required);
    }

    public final Map<String, Property> getProperties() {
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
        Map<String, Property> map = this.properties;
        int iHashCode2 = (iHashCode + (map == null ? 0 : map.hashCode())) * 31;
        List<String> list = this.required;
        return iHashCode2 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        String str = this.type;
        Map<String, Property> map = this.properties;
        List<String> list = this.required;
        StringBuilder sb = new StringBuilder("OutputSchema(type=");
        sb.append(str);
        sb.append(", properties=");
        sb.append(map);
        sb.append(", required=");
        return a.q(sb, list, ")");
    }
}
