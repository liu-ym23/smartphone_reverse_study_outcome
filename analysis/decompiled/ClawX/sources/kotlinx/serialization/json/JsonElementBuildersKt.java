package kotlinx.serialization.json;

import c5.o;
import com.stepos.stepclaw.SecurePrefs;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.ExperimentalSerializationApi;
import p5.l;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0004\n\u0002\u0010\u0001\n\u0002\b\u0006\n\u0002\u0010\u001e\n\u0002\b\u0004\u001a3\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a3\u0010\u0007\u001a\u00020\b2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a1\u0010\n\u001a\u0004\u0018\u00010\u000b*\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0087\u0080\b\u001a1\u0010\u000e\u001a\u0004\u0018\u00010\u000b*\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0087\u0080\b\u001a'\u0010\u000f\u001a\u0004\u0018\u00010\u000b*\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0087\u0080\b¢\u0006\u0002\u0010\u0012\u001a\"\u0010\u000f\u001a\u0004\u0018\u00010\u000b*\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0013H\u0087\u0080\b\u001a\"\u0010\u000f\u001a\u0004\u0018\u00010\u000b*\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\rH\u0087\u0080\b\u001a\"\u0010\u000f\u001a\u0004\u0018\u00010\u000b*\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0014H\u0087\u0080\b\u001a\u001d\u0010\u0015\u001a\u00020\u0011*\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0087\u0080\b¢\u0006\u0002\u0010\u0016\u001a\u0018\u0010\u0015\u001a\u00020\u0011*\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0013H\u0087\u0080\b\u001a\u0018\u0010\u0015\u001a\u00020\u0011*\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\rH\u0087\u0080\b\u001a\u0018\u0010\u0015\u001a\u00020\u0011*\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0014H\u0087\u0080\b\u001a'\u0010\u0017\u001a\u00020\u0011*\u00020\t2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0087\u0080\b\u001a'\u0010\u0018\u001a\u00020\u0011*\u00020\t2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0087\u0080\b\u001a#\u0010\u0019\u001a\u00020\u0011*\u00020\t2\u000e\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u001bH\u0087\u0080\b¢\u0006\u0002\b\u001c\u001a#\u0010\u0019\u001a\u00020\u0011*\u00020\t2\u000e\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u001bH\u0087\u0080\b¢\u0006\u0002\b\u001d\u001a#\u0010\u0019\u001a\u00020\u0011*\u00020\t2\u000e\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u001bH\u0087\u0080\b¢\u0006\u0002\b\u001e\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001f"}, d2 = {"buildJsonObject", "Lkotlinx/serialization/json/JsonObject;", "builderAction", "Lkotlin/Function1;", "Lkotlinx/serialization/json/JsonObjectBuilder;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lkotlin/ExtensionFunctionType;", "buildJsonArray", "Lkotlinx/serialization/json/JsonArray;", "Lkotlinx/serialization/json/JsonArrayBuilder;", "putJsonObject", "Lkotlinx/serialization/json/JsonElement;", "key", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "putJsonArray", "put", "value", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "(Lkotlinx/serialization/json/JsonObjectBuilder;Ljava/lang/String;Ljava/lang/Boolean;)Lkotlinx/serialization/json/JsonElement;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "add", "(Lkotlinx/serialization/json/JsonArrayBuilder;Ljava/lang/Boolean;)Z", "addJsonObject", "addJsonArray", "addAll", "values", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "addAllStrings", "addAllBooleans", "addAllNumbers", "kotlinx-serialization-json"}, k = 2, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public final class JsonElementBuildersKt {
    public static final boolean add(JsonArrayBuilder jsonArrayBuilder, Boolean bool) {
        p.e(jsonArrayBuilder, "<this>");
        return jsonArrayBuilder.add(JsonElementKt.JsonPrimitive(bool));
    }

    @ExperimentalSerializationApi
    public static final boolean addAllBooleans(JsonArrayBuilder jsonArrayBuilder, Collection<Boolean> values) {
        p.e(jsonArrayBuilder, "<this>");
        p.e(values, "values");
        ArrayList arrayList = new ArrayList(o.n0(values, 10));
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            arrayList.add(JsonElementKt.JsonPrimitive((Boolean) it.next()));
        }
        return jsonArrayBuilder.addAll(arrayList);
    }

    @ExperimentalSerializationApi
    public static final boolean addAllNumbers(JsonArrayBuilder jsonArrayBuilder, Collection<? extends Number> values) {
        p.e(jsonArrayBuilder, "<this>");
        p.e(values, "values");
        ArrayList arrayList = new ArrayList(o.n0(values, 10));
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            arrayList.add(JsonElementKt.JsonPrimitive((Number) it.next()));
        }
        return jsonArrayBuilder.addAll(arrayList);
    }

    @ExperimentalSerializationApi
    public static final boolean addAllStrings(JsonArrayBuilder jsonArrayBuilder, Collection<String> values) {
        p.e(jsonArrayBuilder, "<this>");
        p.e(values, "values");
        ArrayList arrayList = new ArrayList(o.n0(values, 10));
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            arrayList.add(JsonElementKt.JsonPrimitive((String) it.next()));
        }
        return jsonArrayBuilder.addAll(arrayList);
    }

    public static final boolean addJsonArray(JsonArrayBuilder jsonArrayBuilder, l builderAction) {
        p.e(jsonArrayBuilder, "<this>");
        p.e(builderAction, "builderAction");
        JsonArrayBuilder jsonArrayBuilder2 = new JsonArrayBuilder();
        builderAction.invoke(jsonArrayBuilder2);
        return jsonArrayBuilder.add(jsonArrayBuilder2.build());
    }

    public static final boolean addJsonObject(JsonArrayBuilder jsonArrayBuilder, l builderAction) {
        p.e(jsonArrayBuilder, "<this>");
        p.e(builderAction, "builderAction");
        JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
        builderAction.invoke(jsonObjectBuilder);
        return jsonArrayBuilder.add(jsonObjectBuilder.build());
    }

    public static final JsonArray buildJsonArray(l builderAction) {
        p.e(builderAction, "builderAction");
        JsonArrayBuilder jsonArrayBuilder = new JsonArrayBuilder();
        builderAction.invoke(jsonArrayBuilder);
        return jsonArrayBuilder.build();
    }

    public static final JsonObject buildJsonObject(l builderAction) {
        p.e(builderAction, "builderAction");
        JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
        builderAction.invoke(jsonObjectBuilder);
        return jsonObjectBuilder.build();
    }

    public static final JsonElement put(JsonObjectBuilder jsonObjectBuilder, String key, Boolean bool) {
        p.e(jsonObjectBuilder, "<this>");
        p.e(key, "key");
        return jsonObjectBuilder.put(key, JsonElementKt.JsonPrimitive(bool));
    }

    public static final JsonElement putJsonArray(JsonObjectBuilder jsonObjectBuilder, String key, l builderAction) {
        p.e(jsonObjectBuilder, "<this>");
        p.e(key, "key");
        p.e(builderAction, "builderAction");
        JsonArrayBuilder jsonArrayBuilder = new JsonArrayBuilder();
        builderAction.invoke(jsonArrayBuilder);
        return jsonObjectBuilder.put(key, jsonArrayBuilder.build());
    }

    public static final JsonElement putJsonObject(JsonObjectBuilder jsonObjectBuilder, String key, l builderAction) {
        p.e(jsonObjectBuilder, "<this>");
        p.e(key, "key");
        p.e(builderAction, "builderAction");
        JsonObjectBuilder jsonObjectBuilder2 = new JsonObjectBuilder();
        builderAction.invoke(jsonObjectBuilder2);
        return jsonObjectBuilder.put(key, jsonObjectBuilder2.build());
    }

    public static final boolean add(JsonArrayBuilder jsonArrayBuilder, Number number) {
        p.e(jsonArrayBuilder, "<this>");
        return jsonArrayBuilder.add(JsonElementKt.JsonPrimitive(number));
    }

    public static final JsonElement put(JsonObjectBuilder jsonObjectBuilder, String key, Number number) {
        p.e(jsonObjectBuilder, "<this>");
        p.e(key, "key");
        return jsonObjectBuilder.put(key, JsonElementKt.JsonPrimitive(number));
    }

    public static final boolean add(JsonArrayBuilder jsonArrayBuilder, String str) {
        p.e(jsonArrayBuilder, "<this>");
        return jsonArrayBuilder.add(JsonElementKt.JsonPrimitive(str));
    }

    public static final JsonElement put(JsonObjectBuilder jsonObjectBuilder, String key, String str) {
        p.e(jsonObjectBuilder, "<this>");
        p.e(key, "key");
        return jsonObjectBuilder.put(key, JsonElementKt.JsonPrimitive(str));
    }

    public static final boolean add(JsonArrayBuilder jsonArrayBuilder, Void r12) {
        p.e(jsonArrayBuilder, "<this>");
        return jsonArrayBuilder.add(JsonNull.INSTANCE);
    }

    public static final JsonElement put(JsonObjectBuilder jsonObjectBuilder, String key, Void r22) {
        p.e(jsonObjectBuilder, "<this>");
        p.e(key, "key");
        return jsonObjectBuilder.put(key, JsonNull.INSTANCE);
    }
}
