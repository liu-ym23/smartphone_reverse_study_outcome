package com.android.ttcjpaysdk.kmp.base.extension;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ouc.b;
import ouc.d0;
import ouc.g0;
import ouc.i;
import ouc.k;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\b\u0002\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0086\b\u001a\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0002H\u0086\b¢\u0006\u0002\u0010\u0005\u001a\u0017\u0010\u0006\u001a\u00020\u0007*\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0007H\u0086\b\u001a\u0016\u0010\b\u001a\u0004\u0018\u00010\u0007*\u0004\u0018\u00010\u0002H\u0086\b¢\u0006\u0002\u0010\t\u001a\u000f\u0010\n\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0086\b\u001a\u0011\u0010\u000b\u001a\u0004\u0018\u00010\f*\u0004\u0018\u00010\u0002H\u0086\b\u001a\u000f\u0010\r\u001a\u00020\u000e*\u0004\u0018\u00010\u0002H\u0086\b\u001a\u0011\u0010\u000f\u001a\u0004\u0018\u00010\u000e*\u0004\u0018\u00010\u0002H\u0086\b\u001a\u000f\u0010\u0010\u001a\u00020\u0011*\u0004\u0018\u00010\u0002H\u0086\b\u001a\u0011\u0010\u0012\u001a\u0004\u0018\u00010\u0011*\u0004\u0018\u00010\u0002H\u0086\b\u001a\u000f\u0010\u0013\u001a\u00020\u0014*\u0004\u0018\u00010\u0002H\u0086\b\u001a\u0011\u0010\u0015\u001a\u0004\u0018\u00010\u0014*\u0004\u0018\u00010\u0002H\u0086\b\u001a\u0017\u0010\u0016\u001a\u00020\u0001*\u0004\u0018\u00010\u000e2\u0006\u0010\u0017\u001a\u00020\fH\u0086\b\u001a\u0017\u0010\u0018\u001a\u00020\u0001*\u0004\u0018\u00010\u000e2\u0006\u0010\u0017\u001a\u00020\fH\u0086\b\u001a\u001f\u0010\u0016\u001a\u00020\u0001*\u0004\u0018\u00010\u000e2\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0001H\u0086\b\u001a\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u000e2\u0006\u0010\u0017\u001a\u00020\fH\u0086\b¢\u0006\u0002\u0010\u001a\u001a\u0017\u0010\u001b\u001a\u00020\u0007*\u0004\u0018\u00010\u000e2\u0006\u0010\u0017\u001a\u00020\fH\u0086\b\u001a\u001f\u0010\u001b\u001a\u00020\u0007*\u0004\u0018\u00010\u000e2\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0007H\u0086\b\u001a\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u0007*\u0004\u0018\u00010\u000e2\u0006\u0010\u0017\u001a\u00020\fH\u0086\b¢\u0006\u0002\u0010\u001d\u001a\u0017\u0010\u001e\u001a\u00020\u0007*\u0004\u0018\u00010\u000e2\u0006\u0010\u0017\u001a\u00020\fH\u0086\b\u001a\u001f\u0010\u001e\u001a\u00020\u0007*\u0004\u0018\u00010\u000e2\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0007H\u0086\b\u001a\u0017\u0010\u001f\u001a\u00020 *\u0004\u0018\u00010\u000e2\u0006\u0010\u0017\u001a\u00020\fH\u0086\b\u001a\u001f\u0010\u001f\u001a\u00020 *\u0004\u0018\u00010\u000e2\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020 H\u0086\b\u001a\u0017\u0010!\u001a\u00020 *\u0004\u0018\u00010\u000e2\u0006\u0010\u0017\u001a\u00020\fH\u0086\b\u001a\u001e\u0010\"\u001a\u0004\u0018\u00010 *\u0004\u0018\u00010\u000e2\u0006\u0010\u0017\u001a\u00020\fH\u0086\b¢\u0006\u0002\u0010#\u001a\u0017\u0010$\u001a\u00020%*\u0004\u0018\u00010\u000e2\u0006\u0010\u0017\u001a\u00020\fH\u0086\b\u001a\u001f\u0010$\u001a\u00020%*\u0004\u0018\u00010\u000e2\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020%H\u0086\b\u001a\u001e\u0010&\u001a\u0004\u0018\u00010%*\u0004\u0018\u00010\u000e2\u0006\u0010\u0017\u001a\u00020\fH\u0086\b¢\u0006\u0002\u0010'\u001a\u0017\u0010(\u001a\u00020)*\u0004\u0018\u00010\u000e2\u0006\u0010\u0017\u001a\u00020\fH\u0086\b\u001a\u001f\u0010(\u001a\u00020)*\u0004\u0018\u00010\u000e2\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020)H\u0086\b\u001a\u001e\u0010*\u001a\u0004\u0018\u00010)*\u0004\u0018\u00010\u000e2\u0006\u0010\u0017\u001a\u00020\fH\u0086\b¢\u0006\u0002\u0010+\u001a\u0017\u0010,\u001a\u00020\f*\u0004\u0018\u00010\u000e2\u0006\u0010\u0017\u001a\u00020\fH\u0086\b\u001a\u0017\u0010-\u001a\u00020\f*\u0004\u0018\u00010\u000e2\u0006\u0010\u0017\u001a\u00020\fH\u0086\b\u001a\u001f\u0010,\u001a\u00020\f*\u0004\u0018\u00010\u000e2\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\fH\u0086\b\u001a\u0019\u0010.\u001a\u0004\u0018\u00010\f*\u0004\u0018\u00010\u000e2\u0006\u0010\u0017\u001a\u00020\fH\u0086\b\u001a\u0019\u0010/\u001a\u0004\u0018\u00010\u0014*\u0004\u0018\u00010\u000e2\u0006\u0010\u0017\u001a\u00020\fH\u0086\b\u001a\u0017\u00100\u001a\u00020\u000e*\u0004\u0018\u00010\u000e2\u0006\u0010\u0017\u001a\u00020\fH\u0086\b\u001a\u001f\u00100\u001a\u00020\u000e*\u0004\u0018\u00010\u000e2\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000eH\u0086\b\u001a\u0019\u00101\u001a\u0004\u0018\u00010\u000e*\u0004\u0018\u00010\u000e2\u0006\u0010\u0017\u001a\u00020\fH\u0086\b\u001a\u0017\u00102\u001a\u0004\u0018\u00010\u000e*\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\fH\u0086\b\u001a\u0015\u00103\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\fH\u0086\b\u001a\u0017\u00104\u001a\u00020\u0011*\u0004\u0018\u00010\u000e2\u0006\u0010\u0017\u001a\u00020\fH\u0086\b\u001a\u001f\u00104\u001a\u00020\u0011*\u0004\u0018\u00010\u000e2\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0011H\u0086\b\u001a\u0019\u00105\u001a\u0004\u0018\u00010\u0011*\u0004\u0018\u00010\u000e2\u0006\u0010\u0017\u001a\u00020\fH\u0086\b\u001a\u0017\u00106\u001a\u0004\u0018\u00010\u0011*\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\fH\u0086\b\u001a\u0015\u00107\u001a\u00020\u0011*\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\fH\u0086\b\u001a\u0015\u00108\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\fH\u0086\b\u001a\u0015\u00109\u001a\b\u0012\u0004\u0012\u00020\f0:*\u0004\u0018\u00010\u0011H\u0086\b\u001a\u0015\u0010-\u001a\u00020\f*\u00020\u00112\u0006\u0010;\u001a\u00020\u0007H\u0086\b¨\u0006<"}, d2 = {"toBoolean", "", "Lkotlinx/serialization/json/JsonElement;", "defaultValue", "toBooleanOrNull", "(Lkotlinx/serialization/json/JsonElement;)Ljava/lang/Boolean;", "toInt", "", "toIntOrNull", "(Lkotlinx/serialization/json/JsonElement;)Ljava/lang/Integer;", "isString", "toStringOrNull", "", "toJsonObject", "Lkotlinx/serialization/json/JsonObject;", "toJsonObjectOrNull", "toJsonArray", "Lkotlinx/serialization/json/JsonArray;", "toJsonArrayOrNull", "toJsonPrimitive", "Lkotlinx/serialization/json/JsonPrimitive;", "toJsonPrimitiveOrNull", "getBoolean", "key", "optBoolean", "getBooleanOrNull", "(Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;)Ljava/lang/Boolean;", "getInt", "getIntOrNull", "(Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;)Ljava/lang/Integer;", "optInt", "getLong", "", "optLong", "getLongOrNull", "(Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;)Ljava/lang/Long;", "getFloat", "", "getFloatOrNull", "(Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;)Ljava/lang/Float;", "getDouble", "", "getDoubleOrNull", "(Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;)Ljava/lang/Double;", "getString", "optString", "getStringOrNull", "asPrimitive", "getJsonObject", "getJsonObjectOrNull", "optJSONObject", "getJSONObject", "getJsonArray", "getJsonArrayOrNull", "optJSONArray", "getJSONArray", "has", "toStringList", "", "index", "cj_base_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class CJJsonExtentionKt {
    public static final boolean isString(i r100) {
        if ((r100 instanceof g0) == false) goto L5;
        g0 r101 = (g0) r100;
    L6:
        if (r101 != null) goto L10;
        return false;
    L10:
        return r101.c();
    L5:
        r101 = null;
        goto L6
    }

    public static final Boolean toBooleanOrNull(i r100) {
        if ((r100 instanceof g0) == false) goto L5;
        g0 r101 = (g0) r100;
    L6:
        if (r101 != null) goto L8;
        return null;
    L8:
        return k.f(r101);
    L5:
        r101 = null;
        goto L6
    }

    public static final Integer toIntOrNull(i r100) {
        if ((r100 instanceof g0) == false) goto L5;
        g0 r101 = (g0) r100;
    L6:
        if (r101 != null) goto L8;
        return null;
    L8:
        return k.l(r101);
    L5:
        r101 = null;
        goto L6
    }

    public static final b toJsonArray(i r100) {
        if ((r100 instanceof b) == false) goto L5;
        b r101 = (b) r100;
    L6:
        if (r101 == null) goto L8;
        return r101;
    L8:
        return new b(new ArrayList());
    L5:
        r101 = null;
        goto L6
    }

    public static final b toJsonArrayOrNull(i r100) {
        if ((r100 instanceof b) == true) goto L7;
        return null;
    L7:
        return (b) r100;
    }

    public static final d0 toJsonObject(i r100) {
        if ((r100 instanceof d0) == false) goto L5;
        d0 r101 = (d0) r100;
    L6:
        if (r101 == null) goto L8;
        return r101;
    L8:
        return new d0(new LinkedHashMap());
    L5:
        r101 = null;
        goto L6
    }

    public static final d0 toJsonObjectOrNull(i r100) {
        if ((r100 instanceof d0) == true) goto L7;
        return null;
    L7:
        return (d0) r100;
    }

    public static final g0 toJsonPrimitive(i r100) {
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type kotlinx.serialization.json.JsonPrimitive");
        return (g0) r100;
    }

    public static final g0 toJsonPrimitiveOrNull(i r100) {
        if ((r100 instanceof g0) == true) goto L7;
        return null;
    L7:
        return (g0) r100;
    }

    public static final List<String> toStringList(b r100) {
        if (r100 == null) goto L16;
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<i> r102 = r100.iterator();
    L5:
        if (r102.hasNext() == false) goto L20;
        i r103 = r102.next();
        if ((r103 instanceof g0) == false) goto L9;
        String r104 = k.g((g0) r103);
    L12:
        if (r104 != null) goto L14;
        r104 = "";
    L14:
        r101.add(r104);
        goto L5
    L9:
        if (r103 == null) goto L11;
        r104 = r103.toString();
        goto L12
    L11:
        r104 = null;
        goto L12
    L20:
        return r101;
    L16:
        return CollectionsKt.emptyList();
    }

    public static final String toStringOrNull(i r100) {
        if ((r100 instanceof g0) == true) goto L9;
        if (r100 != null) goto L10;
        return null;
    L10:
        return r100.toString();
    L9:
        return k.g((g0) r100);
    }

    public static final g0 asPrimitive(d0 r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        if (r100 == null) goto L5;
        i r102 = (i) r100.get(r101);
    L7:
        if ((r102 instanceof g0) == true) goto L9;
        return null;
    L9:
        return (g0) r102;
    L5:
        r102 = null;
        goto L7
    }

    public static final boolean getBoolean(d0 r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Boolean r102 = null;
        if (r100 == null) goto L5;
        i r103 = (i) r100.get(r101);
    L7:
        if ((r103 instanceof g0) == false) goto L9;
        g0 r104 = (g0) r103;
    L10:
        if (r104 == null) goto L12;
        r102 = k.f(r104);
    L12:
        if (r102 != null) goto L16;
        return false;
    L16:
        return r102.booleanValue();
    L9:
        r104 = null;
        goto L10
    L5:
        r103 = null;
        goto L7
    }

    public static final Boolean getBooleanOrNull(d0 r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        if (r100 == null) goto L5;
        i r102 = (i) r100.get(r101);
    L7:
        if ((r102 instanceof g0) == false) goto L9;
        g0 r103 = (g0) r102;
    L10:
        if (r103 != null) goto L12;
        return null;
    L12:
        return k.f(r103);
    L9:
        r103 = null;
        goto L10
    L5:
        r102 = null;
        goto L7
    }

    public static final double getDouble(d0 r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Double r102 = null;
        if (r100 == null) goto L5;
        i r103 = (i) r100.get(r101);
    L7:
        if ((r103 instanceof g0) == false) goto L9;
        g0 r104 = (g0) r103;
    L10:
        if (r104 == null) goto L12;
        r102 = k.i(r104);
    L12:
        if (r102 != null) goto L16;
        return Double.NaN;
    L16:
        return r102.doubleValue();
    L9:
        r104 = null;
        goto L10
    L5:
        r103 = null;
        goto L7
    }

    public static final Double getDoubleOrNull(d0 r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        if (r100 == null) goto L5;
        i r102 = (i) r100.get(r101);
    L7:
        if ((r102 instanceof g0) == false) goto L9;
        g0 r103 = (g0) r102;
    L10:
        if (r103 != null) goto L12;
        return null;
    L12:
        return k.i(r103);
    L9:
        r103 = null;
        goto L10
    L5:
        r102 = null;
        goto L7
    }

    public static final float getFloat(d0 r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Float r102 = null;
        if (r100 == null) goto L5;
        i r103 = (i) r100.get(r101);
    L7:
        if ((r103 instanceof g0) == false) goto L9;
        g0 r104 = (g0) r103;
    L10:
        if (r104 == null) goto L12;
        r102 = k.j(r104);
    L12:
        if (r102 != null) goto L16;
        return Float.NaN;
    L16:
        return r102.floatValue();
    L9:
        r104 = null;
        goto L10
    L5:
        r103 = null;
        goto L7
    }

    public static final Float getFloatOrNull(d0 r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        if (r100 == null) goto L5;
        i r102 = (i) r100.get(r101);
    L7:
        if ((r102 instanceof g0) == false) goto L9;
        g0 r103 = (g0) r102;
    L10:
        if (r103 != null) goto L12;
        return null;
    L12:
        return k.j(r103);
    L9:
        r103 = null;
        goto L10
    L5:
        r102 = null;
        goto L7
    }

    public static final int getInt(d0 r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Integer r102 = null;
        if (r100 == null) goto L5;
        i r103 = (i) r100.get(r101);
    L7:
        if ((r103 instanceof g0) == false) goto L9;
        g0 r104 = (g0) r103;
    L10:
        if (r104 == null) goto L12;
        r102 = k.l(r104);
    L12:
        if (r102 != null) goto L16;
        return 0;
    L16:
        return r102.intValue();
    L9:
        r104 = null;
        goto L10
    L5:
        r103 = null;
        goto L7
    }

    public static final Integer getIntOrNull(d0 r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        if (r100 == null) goto L5;
        i r102 = (i) r100.get(r101);
    L7:
        if ((r102 instanceof g0) == false) goto L9;
        g0 r103 = (g0) r102;
    L10:
        if (r103 != null) goto L12;
        return null;
    L12:
        return k.l(r103);
    L9:
        r103 = null;
        goto L10
    L5:
        r102 = null;
        goto L7
    }

    public static final b getJSONArray(d0 r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "key");
        i r102 = (i) r100.get(r101);
        if ((r102 instanceof b) == false) goto L5;
        b r103 = (b) r102;
    L6:
        if (r103 == null) goto L9;
        return r103;
    L9:
        throw new Exception("json not key=" + r101);
    L5:
        r103 = null;
        goto L6
    }

    public static final d0 getJSONObject(d0 r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "key");
        i r102 = (i) r100.get(r101);
        if ((r102 instanceof d0) == false) goto L5;
        d0 r103 = (d0) r102;
    L6:
        if (r103 == null) goto L9;
        return r103;
    L9:
        throw new Exception("json not key=" + r101);
    L5:
        r103 = null;
        goto L6
    }

    public static final b getJsonArray(d0 r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        b r102 = new b(new ArrayList());
        b r103 = null;
        if (r100 == null) goto L5;
        i r104 = (i) r100.get(r101);
    L7:
        if ((r104 instanceof b) == false) goto L9;
        r103 = (b) r104;
    L9:
        if (r103 != null) goto L12;
        return r102;
    L12:
        return r103;
    L5:
        r104 = null;
        goto L7
    }

    public static final b getJsonArrayOrNull(d0 r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        if (r100 == null) goto L5;
        i r102 = (i) r100.get(r101);
    L7:
        if ((r102 instanceof b) == true) goto L9;
        return null;
    L9:
        return (b) r102;
    L5:
        r102 = null;
        goto L7
    }

    public static final d0 getJsonObject(d0 r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        d0 r102 = new d0(new LinkedHashMap());
        d0 r103 = null;
        if (r100 == null) goto L5;
        i r104 = (i) r100.get(r101);
    L7:
        if ((r104 instanceof d0) == false) goto L9;
        r103 = (d0) r104;
    L9:
        if (r103 != null) goto L12;
        return r102;
    L12:
        return r103;
    L5:
        r104 = null;
        goto L7
    }

    public static final d0 getJsonObjectOrNull(d0 r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        if (r100 == null) goto L5;
        i r102 = (i) r100.get(r101);
    L7:
        if ((r102 instanceof d0) == true) goto L9;
        return null;
    L9:
        return (d0) r102;
    L5:
        r102 = null;
        goto L7
    }

    public static final long getLong(d0 r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Long r102 = null;
        if (r100 == null) goto L5;
        i r103 = (i) r100.get(r101);
    L7:
        if ((r103 instanceof g0) == false) goto L9;
        g0 r104 = (g0) r103;
    L10:
        if (r104 == null) goto L12;
        r102 = k.q(r104);
    L12:
        if (r102 != null) goto L16;
        return 0;
    L16:
        return r102.longValue();
    L9:
        r104 = null;
        goto L10
    L5:
        r103 = null;
        goto L7
    }

    public static final Long getLongOrNull(d0 r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        if (r100 == null) goto L5;
        i r102 = (i) r100.get(r101);
    L7:
        if ((r102 instanceof g0) == false) goto L9;
        g0 r103 = (g0) r102;
    L10:
        if (r103 != null) goto L12;
        return null;
    L12:
        return k.q(r103);
    L9:
        r103 = null;
        goto L10
    L5:
        r102 = null;
        goto L7
    }

    public static final String getString(d0 r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        String r102 = null;
        if (r100 == null) goto L5;
        i r103 = (i) r100.get(r101);
    L7:
        if ((r103 instanceof g0) == false) goto L9;
        g0 r104 = (g0) r103;
    L10:
        if (r104 == null) goto L12;
        r102 = r104.a();
    L12:
        if (r102 != null) goto L15;
        return "";
    L15:
        return r102;
    L9:
        r104 = null;
        goto L10
    L5:
        r103 = null;
        goto L7
    }

    public static final String getStringOrNull(d0 r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        if (r100 == null) goto L5;
        i r102 = (i) r100.get(r101);
    L7:
        if ((r102 instanceof g0) == false) goto L9;
        g0 r103 = (g0) r102;
    L10:
        if (r103 != null) goto L12;
        return null;
    L12:
        return r103.a();
    L9:
        r103 = null;
        goto L10
    L5:
        r102 = null;
        goto L7
    }

    public static final boolean has(d0 r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "key");
        if (r100.get(r101) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean optBoolean(d0 r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Boolean r102 = null;
        if (r100 == null) goto L5;
        i r103 = (i) r100.get(r101);
    L7:
        if ((r103 instanceof g0) == false) goto L9;
        g0 r104 = (g0) r103;
    L10:
        if (r104 == null) goto L12;
        r102 = k.f(r104);
    L12:
        if (r102 != null) goto L16;
        return false;
    L16:
        return r102.booleanValue();
    L9:
        r104 = null;
        goto L10
    L5:
        r103 = null;
        goto L7
    }

    public static final int optInt(d0 r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Integer r102 = null;
        if (r100 == null) goto L5;
        i r103 = (i) r100.get(r101);
    L7:
        if ((r103 instanceof g0) == false) goto L9;
        g0 r104 = (g0) r103;
    L10:
        if (r104 == null) goto L12;
        r102 = k.l(r104);
    L12:
        if (r102 != null) goto L16;
        return 0;
    L16:
        return r102.intValue();
    L9:
        r104 = null;
        goto L10
    L5:
        r103 = null;
        goto L7
    }

    public static final b optJSONArray(d0 r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "key");
        i r102 = (i) r100.get(r101);
        if ((r102 instanceof b) == true) goto L7;
        return null;
    L7:
        return (b) r102;
    }

    public static final d0 optJSONObject(d0 r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "key");
        i r102 = (i) r100.get(r101);
        if ((r102 instanceof d0) == true) goto L7;
        return null;
    L7:
        return (d0) r102;
    }

    public static final long optLong(d0 r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Long r102 = null;
        if (r100 == null) goto L5;
        i r103 = (i) r100.get(r101);
    L7:
        if ((r103 instanceof g0) == false) goto L9;
        g0 r104 = (g0) r103;
    L10:
        if (r104 == null) goto L12;
        r102 = k.q(r104);
    L12:
        if (r102 != null) goto L16;
        return 0;
    L16:
        return r102.longValue();
    L9:
        r104 = null;
        goto L10
    L5:
        r103 = null;
        goto L7
    }

    public static final String optString(b r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        i r102 = (i) CollectionsKt.getOrNull(r100, r101);
        if ((r102 instanceof g0) == false) goto L5;
        String r103 = k.g((g0) r102);
    L8:
        if (r103 != null) goto L11;
        return "";
    L11:
        return r103;
    L5:
        if (r102 == null) goto L7;
        r103 = r102.toString();
        goto L8
    L7:
        r103 = null;
        goto L8
    }

    public static final boolean toBoolean(i r100, boolean r101) {
        Boolean r102 = null;
        if ((r100 instanceof g0) == false) goto L5;
        g0 r103 = (g0) r100;
    L6:
        if (r103 == null) goto L8;
        r102 = k.f(r103);
    L8:
        if (r102 != null) goto L10;
        return r101;
    L10:
        return r102.booleanValue();
    L5:
        r103 = null;
        goto L6
    }

    public static final int toInt(i r100, int r101) {
        Integer r102 = null;
        if ((r100 instanceof g0) == false) goto L5;
        g0 r103 = (g0) r100;
    L6:
        if (r103 == null) goto L8;
        r102 = k.l(r103);
    L8:
        if (r102 != null) goto L10;
        return r101;
    L10:
        return r102.intValue();
    L5:
        r103 = null;
        goto L6
    }

    public static final String optString(d0 r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        String r102 = null;
        if (r100 == null) goto L5;
        i r103 = (i) r100.get(r101);
    L7:
        if ((r103 instanceof g0) == false) goto L9;
        g0 r104 = (g0) r103;
    L10:
        if (r104 == null) goto L12;
        r102 = r104.a();
    L12:
        if (r102 != null) goto L15;
        return "";
    L15:
        return r102;
    L9:
        r104 = null;
        goto L10
    L5:
        r103 = null;
        goto L7
    }

    public static final boolean getBoolean(d0 r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Boolean r103 = null;
        if (r100 == null) goto L5;
        i r104 = (i) r100.get(r101);
    L7:
        if ((r104 instanceof g0) == false) goto L9;
        g0 r105 = (g0) r104;
    L10:
        if (r105 == null) goto L12;
        r103 = k.f(r105);
    L12:
        if (r103 != null) goto L14;
        return r102;
    L14:
        return r103.booleanValue();
    L9:
        r105 = null;
        goto L10
    L5:
        r104 = null;
        goto L7
    }

    public static final double getDouble(d0 r100, String r101, double r102) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Double r103 = null;
        if (r100 == null) goto L5;
        i r104 = (i) r100.get(r101);
    L7:
        if ((r104 instanceof g0) == false) goto L9;
        g0 r105 = (g0) r104;
    L10:
        if (r105 == null) goto L12;
        r103 = k.i(r105);
    L12:
        if (r103 != null) goto L14;
        return r102;
    L14:
        return r103.doubleValue();
    L9:
        r105 = null;
        goto L10
    L5:
        r104 = null;
        goto L7
    }

    public static final float getFloat(d0 r100, String r101, float r102) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Float r103 = null;
        if (r100 == null) goto L5;
        i r104 = (i) r100.get(r101);
    L7:
        if ((r104 instanceof g0) == false) goto L9;
        g0 r105 = (g0) r104;
    L10:
        if (r105 == null) goto L12;
        r103 = k.j(r105);
    L12:
        if (r103 != null) goto L14;
        return r102;
    L14:
        return r103.floatValue();
    L9:
        r105 = null;
        goto L10
    L5:
        r104 = null;
        goto L7
    }

    public static final int getInt(d0 r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Integer r103 = null;
        if (r100 == null) goto L5;
        i r104 = (i) r100.get(r101);
    L7:
        if ((r104 instanceof g0) == false) goto L9;
        g0 r105 = (g0) r104;
    L10:
        if (r105 == null) goto L12;
        r103 = k.l(r105);
    L12:
        if (r103 != null) goto L14;
        return r102;
    L14:
        return r103.intValue();
    L9:
        r105 = null;
        goto L10
    L5:
        r104 = null;
        goto L7
    }

    public static final b getJsonArray(d0 r100, String r101, b r102) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "defaultValue");
        b r103 = null;
        if (r100 == null) goto L5;
        i r104 = (i) r100.get(r101);
    L7:
        if ((r104 instanceof b) == false) goto L9;
        r103 = (b) r104;
    L9:
        if (r103 != null) goto L12;
        return r102;
    L12:
        return r103;
    L5:
        r104 = null;
        goto L7
    }

    public static final d0 getJsonObject(d0 r100, String r101, d0 r102) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "defaultValue");
        d0 r103 = null;
        if (r100 == null) goto L5;
        i r104 = (i) r100.get(r101);
    L7:
        if ((r104 instanceof d0) == false) goto L9;
        r103 = (d0) r104;
    L9:
        if (r103 != null) goto L12;
        return r102;
    L12:
        return r103;
    L5:
        r104 = null;
        goto L7
    }

    public static final long getLong(d0 r100, String r101, long r102) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Long r103 = null;
        if (r100 == null) goto L5;
        i r104 = (i) r100.get(r101);
    L7:
        if ((r104 instanceof g0) == false) goto L9;
        g0 r105 = (g0) r104;
    L10:
        if (r105 == null) goto L12;
        r103 = k.q(r105);
    L12:
        if (r103 != null) goto L14;
        return r102;
    L14:
        return r103.longValue();
    L9:
        r105 = null;
        goto L10
    L5:
        r104 = null;
        goto L7
    }

    public static final String getString(d0 r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "defaultValue");
        String r103 = null;
        if (r100 == null) goto L5;
        i r104 = (i) r100.get(r101);
    L7:
        if ((r104 instanceof g0) == false) goto L9;
        g0 r105 = (g0) r104;
    L10:
        if (r105 == null) goto L12;
        r103 = r105.a();
    L12:
        if (r103 != null) goto L15;
        return r102;
    L15:
        return r103;
    L9:
        r105 = null;
        goto L10
    L5:
        r104 = null;
        goto L7
    }

    public static final int optInt(d0 r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Integer r103 = null;
        if (r100 == null) goto L5;
        i r104 = (i) r100.get(r101);
    L7:
        if ((r104 instanceof g0) == false) goto L9;
        g0 r105 = (g0) r104;
    L10:
        if (r105 == null) goto L12;
        r103 = k.l(r105);
    L12:
        if (r103 != null) goto L14;
        return r102;
    L14:
        return r103.intValue();
    L9:
        r105 = null;
        goto L10
    L5:
        r104 = null;
        goto L7
    }
}
