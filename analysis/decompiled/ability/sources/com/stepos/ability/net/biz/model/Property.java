package com.stepos.ability.net.biz.model;

import B7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÆ\u0003JO\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR$\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/stepos/ability/net/biz/model/Property;", "", "type", "", "description", "properties", "", "items", "Lcom/stepos/ability/net/biz/model/Item;", "default", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/stepos/ability/net/biz/model/Item;Ljava/lang/Object;)V", "getType", "()Ljava/lang/String;", "getDescription", "getProperties", "()Ljava/util/Map;", "getItems", "()Lcom/stepos/ability/net/biz/model/Item;", "getDefault", "()Ljava/lang/Object;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "net_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Property {

    @SerializedName("default")
    private final Object default;

    @SerializedName("description")
    private final String description;

    @SerializedName("items")
    private final Item items;

    @SerializedName("properties")
    private final Map<String, Property> properties;

    @SerializedName("type")
    private final String type;

    public Property(String type, String str, Map<String, Property> map, Item item, Object obj) {
        k.f(type, "type");
        this.type = type;
        this.description = str;
        this.properties = map;
        this.items = item;
        this.default = obj;
    }

    public static /* synthetic */ Property copy$default(Property property, String str, String str2, Map map, Item item, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            str = property.type;
        }
        if ((i & 2) != 0) {
            str2 = property.description;
        }
        if ((i & 4) != 0) {
            map = property.properties;
        }
        if ((i & 8) != 0) {
            item = property.items;
        }
        if ((i & 16) != 0) {
            obj = property.default;
        }
        Object obj3 = obj;
        Map map2 = map;
        return property.copy(str, str2, map2, item, obj3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final Map<String, Property> component3() {
        return this.properties;
    }

    /* renamed from: component4, reason: from getter */
    public final Item getItems() {
        return this.items;
    }

    /* renamed from: component5, reason: from getter */
    public final Object getDefault() {
        return this.default;
    }

    public final Property copy(String type, String description, Map<String, Property> properties, Item items, Object obj) {
        k.f(type, "type");
        return new Property(type, description, properties, items, obj);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Property)) {
            return false;
        }
        Property property = (Property) other;
        return k.b(this.type, property.type) && k.b(this.description, property.description) && k.b(this.properties, property.properties) && k.b(this.items, property.items) && k.b(this.default, property.default);
    }

    public final Object getDefault() {
        return this.default;
    }

    public final String getDescription() {
        return this.description;
    }

    public final Item getItems() {
        return this.items;
    }

    public final Map<String, Property> getProperties() {
        return this.properties;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        int iHashCode = this.type.hashCode() * 31;
        String str = this.description;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Map<String, Property> map = this.properties;
        int iHashCode3 = (iHashCode2 + (map == null ? 0 : map.hashCode())) * 31;
        Item item = this.items;
        int iHashCode4 = (iHashCode3 + (item == null ? 0 : item.hashCode())) * 31;
        Object obj = this.default;
        return iHashCode4 + (obj != null ? obj.hashCode() : 0);
    }

    public String toString() {
        String str = this.type;
        String str2 = this.description;
        Map<String, Property> map = this.properties;
        Item item = this.items;
        Object obj = this.default;
        StringBuilder sbW = a.w("Property(type=", str, ", description=", str2, ", properties=");
        sbW.append(map);
        sbW.append(", items=");
        sbW.append(item);
        sbW.append(", default=");
        sbW.append(obj);
        sbW.append(")");
        return sbW.toString();
    }

    public /* synthetic */ Property(String str, String str2, Map map, Item item, Object obj, int i, e eVar) {
        this(str, str2, (i & 4) != 0 ? null : map, (i & 8) != 0 ? null : item, (i & 16) != 0 ? null : obj);
    }
}
