package com.bytedance.android.live.browser;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class UtilsKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f62573a = null;

    static {
        f62573a = LazyKt.lazy(UtilsKt$JS_SAFE_ELEMENT_ADAPTER$2.INSTANCE);
    }

    public static final Object a(Object r100) {
        if ((r100 instanceof JSONObject) == false) goto L7;
        Object r101 = new ReadonlyJSONObjectMap((JSONObject) r100);
    L13:
        return r101;
    L7:
        if ((r100 instanceof JSONArray) == false) goto L10;
        r101 = new f0((JSONArray) r100);
        goto L13
    L10:
        if (Intrinsics.areEqual(r100, JSONObject.NULL) == false) goto L14;
        return null;
    L14:
        return r100;
    }

    public static final Object b(JsonElement r100) {
        if ((r100 instanceof JsonNull) == false) goto L6;
        return null;
    L6:
        if ((r100 instanceof JsonObject) == false) goto L9;
        return i((JsonObject) r100);
    L9:
        if ((r100 instanceof JsonArray) == false) goto L12;
        JsonArray r101 = (JsonArray) r100;
        Intrinsics.checkNotNullParameter(r101, "$this$toList");
        return new GsonList(r101);
    L12:
        if ((r100 instanceof JsonPrimitive) == false) goto L26;
        JsonPrimitive r102 = (JsonPrimitive) r100;
        if (r102.isNumber() == false) goto L17;
        return r102.getAsNumber();
    L17:
        if (r102.isString() == false) goto L20;
        return r102.getAsString();
    L20:
        if (r102.isBoolean() == false) goto L24;
        return Boolean.valueOf(r102.getAsBoolean());
    L24:
        throw new IllegalStateException("Unknown JsonPrimitive type: " + JsonPrimitive.class.getCanonicalName());
    L26:
        throw new IllegalStateException("Unknown JsonElement type: " + r100.getClass().getCanonicalName());
    }

    public static final void e(JsonArray r100) {
        int r101 = r100.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L36;
        JsonElement r103 = r100.get(r102);
        if (r103 == null) goto L33;
        if (r103.isJsonObject() == false) goto L11;
        f(r103.getAsJsonObject());
        goto L33
    L11:
        if (r103.isJsonArray() == false) goto L14;
        e(r103.getAsJsonArray());
        goto L33
    L14:
        if (r103.isJsonPrimitive() == false) goto L35;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L17
        Object r105 = Result.m9449constructorimpl(Long.valueOf(r103.getAsLong()));     // Catch: Throwable -> L17
    L20:
        if (Result.m9455isFailureimpl(r105) == false) goto L22;
        r105 = null;
    L22:
        Long r106 = (Long) r105;
        if (r106 == null) goto L33;
        long r107 = r106.longValue();
        if (r107 < Integer.MAX_VALUE) goto L27;
    L30:
        boolean r108 = true;
    L31:
        if (r108 == false) goto L33;
        r100.set(r102, new JsonPrimitive(String.valueOf(r107)));
        goto L33
    L27:
        if (r107 <= Integer.MIN_VALUE) goto L30;
        r108 = false;
    L17:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L20
    L35:
        throw new RuntimeException("Unknown type of json: " + r103);
    L33:
        r102 = r102 + 1;
        goto L3
    }

    public static final void f(JsonObject r100) {
        Iterator r101 = SequencesKt.filter(CollectionsKt.asSequence(r100.entrySet()), UtilsKt$memberNumbersToString$1.INSTANCE).iterator();
    L4:
        if (r101.hasNext() == false) goto L24;
        Map.Entry r102 = (Map.Entry) r101.next();
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L8
        Object r104 = Result.m9449constructorimpl(Long.valueOf(((JsonElement) r102.getValue()).getAsLong()));     // Catch: Throwable -> L8
    L11:
        if (Result.m9455isFailureimpl(r104) == false) goto L13;
        r104 = null;
    L13:
        Long r105 = (Long) r104;
        if (r105 == null) goto L4;
        long r106 = r105.longValue();
        if (r106 < Integer.MAX_VALUE) goto L18;
    L21:
        boolean r107 = true;
    L22:
        if (r107 == false) goto L4;
        r102.setValue(new JsonPrimitive(String.valueOf(r106)));
        goto L4
    L18:
        if (r106 <= Integer.MIN_VALUE) goto L21;
        r107 = false;
    L8:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public static final ReadonlyJSONObjectMap g(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toImmutableDelegatedMap");
        return new ReadonlyJSONObjectMap(r100);
    }

    public static final <T extends JsonElement> String h(T r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toJsSafeString");
        StringWriter r101 = new StringWriter();
        JsonWriter r102 = new JsonWriter(r101);
        r102.setLenient(true);
        ((TypeAdapter) f62573a.getValue()).write(r102, r100);
        return r101.toString();
    }

    public static final GsonMap i(JsonObject r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toMap");
        return new GsonMap(r100);
    }

    public static final JSONArray c(JSONArray r100, JSONArray r101, JSONObject r102) {
        int r103 = r102.optInt("_length", -1);
        JSONObject r104 = r102.optJSONObject("_filter_keys");
        if (r103 <= (-1)) goto L5;
        int r105 = RangesKt.coerceAtMost(r103, r100.length());
    L6:
        int r106 = 0;
    L7:
        if (r106 >= r105) goto L23;
        Object r107 = r100.opt(r106);
        if ((r107 instanceof JSONObject) == false) goto L15;
        if (r104 != null) goto L12;
        Object r108 = (JSONObject) r107;
    L13:
        r101.put(r108);
    L22:
        r106 = r106 + 1;
        goto L7
    L12:
        JSONObject r109 = new JSONObject();
        d((JSONObject) r107, r109, r104);
        r108 = r109;
        goto L13
    L15:
        if ((r107 instanceof JSONArray) == false) goto L21;
        JSONArray r110 = (JSONArray) r107;
        if (r104 == null) goto L20;
        JSONArray r111 = new JSONArray();
        c(r110, r111, r104);
        r110 = r111;
    L20:
        r101.put(r110);
        goto L22
    L21:
        r101.put(r107);
        goto L22
    L23:
        return r101;
    L5:
        r105 = r100.length();
        goto L6
    }

    public static final JSONObject d(JSONObject r100, JSONObject r101, JSONObject r102) {
        Iterator<String> r103 = r102.keys();
    L4:
        if (r103.hasNext() == false) goto L20;
        String r104 = r103.next();
        Object r105 = r100.opt(r104);
        if ((r105 instanceof JSONObject) == true) goto L7;
        if ((r105 instanceof JSONArray) == true) goto L14;
        r101.put(r104, r105);
        goto L4
    L14:
        JSONObject r106 = r102.optJSONObject(r104);
        JSONArray r107 = (JSONArray) r105;
        if (r106 == null) goto L18;
        JSONArray r108 = new JSONArray();
        c(r107, r108, r106);
        r107 = r108;
    L18:
        r101.put(r104, r107);
        goto L4
    L7:
        JSONObject r109 = r102.optJSONObject(r104);
        JSONObject r110 = (JSONObject) r105;
        if (r109 == null) goto L11;
        JSONObject r111 = new JSONObject();
        d(r110, r111, r109);
        r110 = r111;
    L11:
        r101.put(r104, r110);
        goto L4
    L20:
        return r101;
    }
}
