package com.bytedance.android.anniex.worker;

import androidx.camera.video.AudioStats;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyArray;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import com.bytedance.vmsdk.jsbridge.utils.ReadableArray;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMapKeySetIterator;
import com.bytedance.vmsdk.jsbridge.utils.ReadableType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f41506a = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f41507a = null;

        static {
            int[] r100 = new int[ReadableType.values().length];
            r100[ReadableType.String.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r100[ReadableType.Number.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r100[ReadableType.Boolean.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r100[ReadableType.Map.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[ReadableType.Array.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r100[ReadableType.Null.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            f41507a = r100;
        }
    }

    static {
        f41506a = new h();
    }

    public h() {
    }

    @JvmStatic
    public static final JavaOnlyArray a(List<? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "sourceArray");
        JavaOnlyArray r101 = new JavaOnlyArray();
        int r102 = r100.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L32;
        Object r104 = ListProtector.get(r100, r103);
        if ((r104 instanceof Map) == false) goto L9;
        r101.pushMap(f((Map) r104));     // Catch: Exception -> L33
    L31:
        r103 = r103 + 1;
        goto L3
    L9:
        if ((r104 instanceof List) == false) goto L13;
        r101.pushArray(a((List) r104));     // Catch: Exception -> L33
        goto L31
    L13:
        if ((r104 instanceof Boolean) == false) goto L16;
        r101.pushBoolean(((Boolean) r104).booleanValue());
        goto L31
    L16:
        if ((r104 instanceof Integer) == false) goto L19;
        r101.pushInt(((Number) r104).intValue());
        goto L31
    L19:
        if ((r104 instanceof Long) == false) goto L22;
        r101.pushDouble(((Number) r104).longValue());
        goto L31
    L22:
        if ((r104 instanceof Float) == false) goto L25;
        r101.pushDouble(((Number) r104).floatValue());
        goto L31
    L25:
        if ((r104 instanceof Double) == false) goto L28;
        r101.pushDouble(((Number) r104).doubleValue());
        goto L31
    L28:
        if ((r104 instanceof String) == false) goto L30;
        r101.pushString((String) r104);
        goto L31
    L30:
        r101.pushString(r104.toString());
        goto L31
    L32:
        return r101;
    }

    @JvmStatic
    public static final List<Object> b(JavaOnlyArray r100) {
        ArrayList r101 = new ArrayList();
        int r102 = r100.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L23;
        Object r104 = r100.get(r103);
        ReadableType r105 = r100.getType(r103);     // Catch: Throwable -> L20
        if (r105 != null) goto L8;
        int r106 = -1;
    L10:
        if (r106 != 2) goto L12;
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type kotlin.Number");     // Catch: Throwable -> L20
        f41506a.getClass();     // Catch: Throwable -> L20
        r101.add(g((Number) r104));     // Catch: Throwable -> L20
    L22:
        r103 = r103 + 1;
        goto L3
    L12:
        if (r106 != 4) goto L14;
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap");     // Catch: Throwable -> L20
        r101.add(c((JavaOnlyMap) r104));     // Catch: Throwable -> L20
        goto L22
    L14:
        if (r106 == 5) goto L16;
        r101.add(r104);     // Catch: Throwable -> L20
        goto L22
    L16:
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type com.bytedance.vmsdk.jsbridge.utils.JavaOnlyArray");     // Catch: Throwable -> L20
        r101.add(b((JavaOnlyArray) r104));     // Catch: Throwable -> L20
        goto L22
    L8:
        r106 = a.f41507a[r105.ordinal()];     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        id7.c.a("convertJavaOnlyArrayToList " + th);
        goto L22
    L23:
        return r101;
    }

    @JvmStatic
    public static final Map<String, Object> c(JavaOnlyMap r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        LinkedHashMap r101 = new LinkedHashMap();
        if (r100.isEmpty() == false) goto L5;
        return r101;
    L5:
        ReadableMapKeySetIterator r102 = r100.keySetIterator();
    L7:
        if (r102.hasNextKey() == false) goto L26;
        String r103 = r102.nextKey();
        Object r104 = r100.get(r103);
        ReadableType r105 = r100.getType(r103);     // Catch: Throwable -> L24
        if (r105 != null) goto L12;
        int r106 = -1;
    L14:
        if (r106 != 2) goto L16;
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type kotlin.Number");     // Catch: Throwable -> L24
        f41506a.getClass();     // Catch: Throwable -> L24
        r101.put(r103, g((Number) r104));     // Catch: Throwable -> L24
        goto L7
    L16:
        if (r106 != 4) goto L18;
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap");     // Catch: Throwable -> L24
        r101.put(r103, c((JavaOnlyMap) r104));     // Catch: Throwable -> L24
        goto L7
    L18:
        if (r106 != 5) goto L19;
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type com.bytedance.vmsdk.jsbridge.utils.JavaOnlyArray");     // Catch: Throwable -> L24
        r101.put(r103, b((JavaOnlyArray) r104));     // Catch: Throwable -> L24
        goto L7
    L19:
        r101.put(r103, r104);     // Catch: Throwable -> L24
        goto L7
    L12:
        r106 = a.f41507a[r105.ordinal()];     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        id7.c.a("convertJavaOnlyMapToMap " + th);
        goto L7
    L26:
        return r101;
    }

    @JvmStatic
    public static final JavaOnlyArray d(JSONArray r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonArray");
        JavaOnlyArray r101 = new JavaOnlyArray();
        int r102 = r100.length();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L30;
        Object r104 = r100.get(r103);
        if ((r104 instanceof JSONObject) == false) goto L8;
        r101.pushMap(e((JSONObject) r104));
    L29:
        r103 = r103 + 1;
        goto L3
    L8:
        if ((r104 instanceof JSONArray) == false) goto L11;
        r101.pushArray(d((JSONArray) r104));
        goto L29
    L11:
        if ((r104 instanceof Boolean) == false) goto L14;
        r101.pushBoolean(((Boolean) r104).booleanValue());
        goto L29
    L14:
        if ((r104 instanceof Integer) == false) goto L17;
        r101.pushInt(((Number) r104).intValue());
        goto L29
    L17:
        if ((r104 instanceof Long) == false) goto L20;
        r101.pushDouble(((Number) r104).longValue());
        goto L29
    L20:
        if ((r104 instanceof Float) == false) goto L23;
        r101.pushDouble(((Number) r104).floatValue());
        goto L29
    L23:
        if ((r104 instanceof Double) == false) goto L26;
        r101.pushDouble(((Number) r104).doubleValue());
        goto L29
    L26:
        if ((r104 instanceof String) == false) goto L28;
        r101.pushString((String) r104);
        goto L29
    L28:
        r101.pushString(r104.toString());
        goto L29
    L30:
        return r101;
    }

    @JvmStatic
    public static final JavaOnlyMap e(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
        JavaOnlyMap r101 = new JavaOnlyMap();
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L33;
        String r103 = r102.next();
        Object r104 = r100.get(r103);
        if ((r104 instanceof JSONObject) == true) goto L7;
        if (Intrinsics.areEqual(r104, JSONObject.NULL) == true) goto L10;
        if ((r104 instanceof JSONArray) == true) goto L13;
        if ((r104 instanceof Boolean) == true) goto L16;
        if ((r104 instanceof Integer) == true) goto L19;
        if ((r104 instanceof Long) == true) goto L22;
        if ((r104 instanceof Float) == true) goto L25;
        if ((r104 instanceof Double) == true) goto L28;
        if ((r104 instanceof String) == true) goto L31;
        r101.putString(r103, r104.toString());
        goto L4
    L31:
        r101.putString(r103, (String) r104);
        goto L4
    L28:
        r101.putDouble(r103, ((Number) r104).doubleValue());
        goto L4
    L25:
        r101.putDouble(r103, ((Number) r104).floatValue());
        goto L4
    L22:
        r101.putDouble(r103, ((Number) r104).longValue());
        goto L4
    L19:
        r101.putInt(r103, ((Number) r104).intValue());
        goto L4
    L16:
        r101.putBoolean(r103, ((Boolean) r104).booleanValue());
        goto L4
    L13:
        r101.putArray(r103, d((JSONArray) r104));
        goto L4
    L10:
        r101.putMap(r103, null);
        goto L4
    L7:
        r101.putMap(r103, e((JSONObject) r104));
        goto L4
    L33:
        return r101;
    }

    @JvmStatic
    public static final JavaOnlyMap f(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        JavaOnlyMap r101 = new JavaOnlyMap();
        Iterator<Map.Entry<String, ? extends Object>> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L44;
        Map.Entry<String, ? extends Object> r103 = r102.next();
        String r104 = r103.getKey();
        Object r105 = r103.getValue();
        if ((r105 instanceof Map) == false) goto L11;
        r101.putMap(r104, f((Map) r105));     // Catch: Exception -> L9
        goto L4
    L11:
        if ((r105 instanceof List) == true) goto L12;
        if ((r105 instanceof Boolean) == true) goto L16;
        if ((r105 instanceof Integer) == true) goto L19;
        if ((r105 instanceof Long) == true) goto L22;
        if ((r105 instanceof Float) == true) goto L25;
        if ((r105 instanceof Double) == true) goto L28;
        if ((r105 instanceof String) == true) goto L31;
        if ((r105 instanceof JSONObject) == true) goto L34;
        if ((r105 instanceof JSONArray) == true) goto L37;
        if (r105 == null) goto L43;
        if (Intrinsics.areEqual(r105, JSONObject.NULL) == true) goto L43;
        r101.putString(r104, r105.toString());
    L43:
        r101.putNull(r104);
        goto L4
    L37:
        r101.putArray(r104, d((JSONArray) r105));
        goto L4
    L34:
        r101.putMap(r104, e((JSONObject) r105));
        goto L4
    L31:
        r101.putString(r104, (String) r105);
        goto L4
    L28:
        r101.putDouble(r104, ((Number) r105).doubleValue());
        goto L4
    L25:
        r101.putDouble(r104, ((Number) r105).floatValue());
        goto L4
    L22:
        r101.putDouble(r104, ((Number) r105).longValue());
        goto L4
    L19:
        r101.putInt(r104, ((Number) r105).intValue());
        goto L4
    L16:
        r101.putBoolean(r104, ((Boolean) r105).booleanValue());
        goto L4
    L12:
        r101.putArray(r104, a((List) r105));     // Catch: Exception -> L9
        goto L4
    L44:
        return r101;
    }

    public static Number g(Number r100) {
        Intrinsics.checkNotNullParameter(r100, "rawNumber");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(Integer.valueOf(r100.intValue()));     // Catch: Throwable -> L5
    L7:
        Object r103 = null;
        if (Result.m9455isFailureimpl(r102) == false) goto L10;
        r102 = null;
    L10:
        Integer r104 = (Integer) r102;
        if (r104 == null) goto L13;
        int r105 = r104.intValue();
    L38:
        Object r106 = Result.m9449constructorimpl(Double.valueOf(r100.doubleValue()));     // Catch: Throwable -> L16
    L19:
        if (Result.m9455isFailureimpl(r106) == true) goto L22;
        r103 = r106;
    L22:
        Double r107 = (Double) r103;
        if (r107 == null) goto L25;
        double r108 = r107.doubleValue();
    L27:
        if (Double.compare(r105, r108) == 0) goto L29;
        long r109 = (long) r108;
        if (Double.compare(r108, r109) != 0) goto L35;
        return Long.valueOf(r109);
    L35:
        return Double.valueOf(r108);
    L29:
        return Integer.valueOf(r105);
    L25:
        r108 = AudioStats.AUDIO_AMPLITUDE_NONE;
    L16:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L19
    L13:
        r105 = 0;
    L5:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.Object] */
    public static Object h(Object r100) {
        if ((r100 instanceof ReadableArray) == false) goto L9;
        ReadableArray r101 = (ReadableArray) r100;
        int r102 = r101.size();
        ?? r103 = new ArrayList();
        int r104 = 0;
    L5:
        if (r104 >= r102) goto L20;
        r103.add(h(i(r101.getDynamic(r104))));
        r104 = r104 + 1;
    L20:
        return r103;
    L9:
        if ((r100 instanceof ReadableMap) == false) goto L15;
        ReadableMap r105 = (ReadableMap) r100;
        Intrinsics.checkNotNullParameter(r105, "value");
        ReadableMapKeySetIterator r106 = r105.keySetIterator();
        r103 = new HashMap();
    L12:
        if (r106.hasNextKey() == false) goto L20;
        String r107 = r106.nextKey();
        r103.put(r107, h(i(r105.getDynamic(r107))));
        goto L12
    L15:
        if ((r100 instanceof Number) == true) goto L17;
        return r100;
    L17:
        return g((Number) r100);
    }

    public static Object i(sp7.a r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ReadableType r101 = r100.getType();
        if (r101 != null) goto L5;
        int r102 = -1;
    L7:
        if (r102 == 1) goto L23;
        if (r102 == 2) goto L21;
        if (r102 == 3) goto L27;
        if (r102 == 4) goto L26;
        if (r102 == 5) goto L25;
        return null;
    L25:
        return r100.asArray();
    L26:
        return r100.asMap();
    L27:
        return Boolean.valueOf(r100.asBoolean());
    L21:
        return g(Double.valueOf(r100.asDouble()));
    L23:
        return r100.asString();
    L5:
        r102 = a.f41507a[r101.ordinal()];
        goto L7
    }
}
