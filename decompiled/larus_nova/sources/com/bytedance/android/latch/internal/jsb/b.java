package com.bytedance.android.latch.internal.jsb;

import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyArray;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import com.bytedance.vmsdk.jsbridge.utils.ReadableArray;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMapKeySetIterator;
import com.bytedance.vmsdk.jsbridge.utils.ReadableType;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class b {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f58307a = null;

        static {
            int[] r100 = new int[ReadableType.values().length];
            r100[ReadableType.Boolean.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r100[ReadableType.Long.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r100[ReadableType.Number.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[ReadableType.String.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[ReadableType.Map.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r100[ReadableType.Array.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r100[ReadableType.Null.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            f58307a = r100;
        }
    }

    public static final <T> JavaOnlyArray a(List<? extends T> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof JavaOnlyArray) == true) goto L5;
        JavaOnlyArray r101 = new JavaOnlyArray();
        Iterator<T> r102 = r100.iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        r101.add(e(r102.next()));
        goto L8
    L10:
        return r101;
    L5:
        return (JavaOnlyArray) r100;
    }

    public static final <T> JavaOnlyMap b(Map<String, ? extends T> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof JavaOnlyMap) == true) goto L5;
        JavaOnlyMap r101 = new JavaOnlyMap();
        Iterator<Map.Entry<String, ? extends T>> r102 = r100.entrySet().iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        Map.Entry<String, ? extends T> r103 = r102.next();
        r101.put(r103.getKey(), e(r103.getValue()));
        goto L8
    L10:
        return r101;
    L5:
        return (JavaOnlyMap) r100;
    }

    public static final JSONArray c(ReadableArray r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        JSONArray r101 = new JSONArray();
        int r102 = r100.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L19;
        ReadableType r104 = r100.getType(r103);
        if (r104 != null) goto L7;
        int r105 = -1;
    L8:
        switch(r105) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            default: goto L10;
        };
    L11:
        r101.put(JSONObject.NULL);
    L18:
        r103 = r103 + 1;
        goto L3
    L12:
        r101.put(c(r100.getArray(r103)));
        goto L18
    L13:
        r101.put(d(r100.getMap(r103)));
        goto L18
    L14:
        r101.put(r100.getString(r103));
        goto L18
    L15:
        r101.put(r100.getDouble(r103));
        goto L18
    L16:
        r101.put(r100.getLong(r103));
        goto L18
    L17:
        r101.put(r100.getBoolean(r103));
        goto L18
    L10:
        throw new IllegalStateException(("Failed to convert type in ReadableMap: " + r104).toString());
    L7:
        r105 = a.f58307a[r104.ordinal()];
        goto L8
    L19:
        return r101;
    }

    public static final JSONObject d(ReadableMap r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        JSONObject r101 = new JSONObject();
        ReadableMapKeySetIterator r102 = r100.keySetIterator();
    L4:
        if (r102.hasNextKey() == false) goto L19;
        String r103 = r102.nextKey();
        ReadableType r104 = r100.getType(r103);
        if (r104 != null) goto L8;
        int r105 = -1;
    L9:
        switch(r105) {
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            default: goto L11;
        };
    L11:
        throw new IllegalStateException(("Failed to convert type in ReadableMap: " + r104).toString());
    L13:
        r101.put(r103, c(r100.getArray(r103)));
        goto L4
    L14:
        r101.put(r103, d(r100.getMap(r103)));
        goto L4
    L15:
        r101.put(r103, r100.getString(r103));
        goto L4
    L16:
        r101.put(r103, r100.getDouble(r103));
        goto L4
    L17:
        r101.put(r103, r100.getLong(r103));
        goto L4
    L18:
        r101.put(r103, r100.getBoolean(r103));
        goto L4
    L12:
        r101.put(r103, JSONObject.NULL);
        goto L4
    L8:
        r105 = a.f58307a[r104.ordinal()];
        goto L9
    L19:
        return r101;
    }

    public static final Object e(Object r100) {
        if ((r100 instanceof Map) == false) goto L6;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, *>");
        return b((Map) r100);
    L6:
        if ((r100 instanceof List) == false) goto L9;
        return a((List) r100);
    L9:
        if ((r100 instanceof JSONObject) == false) goto L12;
        return g((JSONObject) r100);
    L12:
        if ((r100 instanceof JSONArray) == true) goto L14;
        return r100;
    L14:
        return f((JSONArray) r100);
    }

    public static final JavaOnlyArray f(JSONArray r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        JavaOnlyArray r101 = new JavaOnlyArray();
        int r102 = r100.length();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L39;
        Object r104 = r100.opt(r103);
        if ((r104 instanceof Float) == false) goto L7;
        boolean r105 = true;
    L8:
        if (r105 == false) goto L11;
        r101.pushDouble(JSONArrayProtectorUtils.getDouble(r100, r103));
    L36:
        r103 = r103 + 1;
        goto L3
    L11:
        if ((r104 instanceof Long) == false) goto L19;
        long r106 = JSONArrayProtectorUtils.getLong(r100, r103);
        if (r106 <= Integer.MAX_VALUE) goto L15;
    L17:
        r101.pushString(String.valueOf(r106));
        goto L36
    L15:
        if (r106 < Integer.MIN_VALUE) goto L17;
        r101.pushInt((int) r106);
        goto L36
    L19:
        if ((r104 instanceof Number) == false) goto L22;
        r101.pushInt(JSONArrayProtectorUtils.getInt(r100, r103));
        goto L36
    L22:
        if ((r104 instanceof String) == false) goto L25;
        r101.pushString(JSONArrayProtectorUtils.getString(r100, r103));
        goto L36
    L25:
        if ((r104 instanceof Boolean) == false) goto L28;
        r101.pushBoolean(JSONArrayProtectorUtils.getBoolean(r100, r103));
        goto L36
    L28:
        if ((r104 instanceof JSONObject) == false) goto L31;
        r101.pushMap(g(JSONArrayProtectorUtils.getJSONObject(r100, r103)));
        goto L36
    L31:
        if ((r104 instanceof JSONArray) == false) goto L34;
        r101.pushArray(f(JSONArrayProtectorUtils.getJSONArray(r100, r103)));
        goto L36
    L34:
        if (Intrinsics.areEqual(r104, JSONObject.NULL) == false) goto L38;
        r101.pushNull();
        goto L36
    L38:
        throw new IllegalStateException(("Failed to convert value " + r104 + " of type " + r104.getClass()).toString());
    L7:
        r105 = r104 instanceof Double;
        goto L8
    L39:
        return r101;
    }

    public static final JavaOnlyMap g(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        JavaOnlyMap r101 = new JavaOnlyMap();
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L39;
        String r103 = r102.next();
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.String");
        String r104 = r103;
        Object r105 = r100.opt(r104);
        if ((r105 instanceof Float) == false) goto L8;
        boolean r106 = true;
    L9:
        if (r106 == true) goto L10;
        if ((r105 instanceof Long) == true) goto L13;
        if ((r105 instanceof Number) == true) goto L21;
        if ((r105 instanceof String) == true) goto L24;
        if ((r105 instanceof Boolean) == true) goto L27;
        if ((r105 instanceof JSONObject) == true) goto L30;
        if ((r105 instanceof JSONArray) == true) goto L33;
        if (Intrinsics.areEqual(r105, JSONObject.NULL) == false) goto L38;
        r101.putNull(r104);
        goto L4
    L38:
        throw new IllegalStateException(("Failed to convert value " + r105 + " of type " + r105.getClass()).toString());
    L33:
        r101.putArray(r104, f(JSONObjectProtectorUtils.getJSONArray(r100, r104)));
        goto L4
    L30:
        r101.putMap(r104, g(JSONObjectProtectorUtils.getJSONObject(r100, r104)));
        goto L4
    L27:
        r101.putBoolean(r104, JSONObjectProtectorUtils.getBoolean(r100, r104));
        goto L4
    L24:
        r101.putString(r104, JSONObjectProtectorUtils.getString(r100, r104));
        goto L4
    L21:
        r101.putInt(r104, JSONObjectProtectorUtils.getInt(r100, r104));
        goto L4
    L13:
        long r107 = JSONObjectProtectorUtils.getLong(r100, r104);
        if (r107 > Integer.MAX_VALUE) goto L18;
        if (r107 < Integer.MIN_VALUE) goto L18;
        r101.putInt(r104, (int) r107);
    L18:
        r101.putString(r104, String.valueOf(r107));
        goto L4
    L10:
        r101.putDouble(r104, JSONObjectProtectorUtils.getDouble(r100, r104));
        goto L4
    L8:
        r106 = r105 instanceof Double;
        goto L9
    L39:
        return r101;
    }
}
