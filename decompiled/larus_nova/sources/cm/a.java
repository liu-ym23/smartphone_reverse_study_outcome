package cm;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f24151a = 0;

    static {
    }

    public static JSONArray a(List r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        JSONArray r101 = new JSONArray();
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L43;
        Object r103 = r102.next();
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L41
        if ((r103 instanceof Float) == false) goto L10;
        Object r105 = r101.put(((Number) r103).floatValue());     // Catch: Throwable -> L41
    L39:
        Result.m9449constructorimpl(r105);     // Catch: Throwable -> L41
        goto L4
    L10:
        if ((r103 instanceof Long) == false) goto L13;
        r105 = r101.put(((Number) r103).longValue());     // Catch: Throwable -> L41
        goto L39
    L13:
        if ((r103 instanceof Integer) == false) goto L16;
        r105 = r101.put(((Number) r103).intValue());     // Catch: Throwable -> L41
        goto L39
    L16:
        if ((r103 instanceof Double) == false) goto L19;
        r105 = r101.put(((Number) r103).doubleValue());     // Catch: Throwable -> L41
        goto L39
    L19:
        if ((r103 instanceof String) == false) goto L22;
        r105 = r101.put(r103);     // Catch: Throwable -> L41
        goto L39
    L22:
        if ((r103 instanceof Boolean) == false) goto L25;
        r105 = r101.put(((Boolean) r103).booleanValue());     // Catch: Throwable -> L41
        goto L39
    L25:
        if ((r103 instanceof Map) == false) goto L31;
        if (r103 == null) goto L29;
        r105 = r101.put(b((Map) r103));     // Catch: Throwable -> L41
        goto L39
    L29:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");     // Catch: Throwable -> L41
    L31:
        if ((r103 instanceof List) == false) goto L36;
        if (r103 == null) goto L35;
        r105 = r101.put(a((List) r103));     // Catch: Throwable -> L41
        goto L39
    L35:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");     // Catch: Throwable -> L41
    L36:
        if (r103 != null) goto L38;
        r105 = r101.put(JSONObject.NULL);     // Catch: Throwable -> L41
        goto L39
    L38:
        r105 = Unit.INSTANCE;     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L4
    L43:
        return r101;
    }

    public static JSONObject b(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        JSONObject r101 = new JSONObject();
        Iterator r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L43;
        Map.Entry r103 = (Map.Entry) r102.next();
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L41
        String r105 = (String) r103.getKey();     // Catch: Throwable -> L41
        Object r106 = r103.getValue();     // Catch: Throwable -> L41
        if ((r106 instanceof Long) == false) goto L10;
        Object r107 = r101.putOpt(r105, r106);     // Catch: Throwable -> L41
    L39:
        Result.m9449constructorimpl(r107);     // Catch: Throwable -> L41
        goto L4
    L10:
        if ((r106 instanceof Float) == false) goto L13;
        r107 = r101.putOpt(r105, Double.valueOf(((Number) r106).floatValue()));     // Catch: Throwable -> L41
        goto L39
    L13:
        if ((r106 instanceof Integer) == false) goto L16;
        r107 = r101.putOpt(r105, r106);     // Catch: Throwable -> L41
        goto L39
    L16:
        if ((r106 instanceof Double) == false) goto L19;
        r107 = r101.putOpt(r105, r106);     // Catch: Throwable -> L41
        goto L39
    L19:
        if ((r106 instanceof String) == false) goto L22;
        r107 = r101.putOpt(r105, r106);     // Catch: Throwable -> L41
        goto L39
    L22:
        if ((r106 instanceof Boolean) == false) goto L25;
        r107 = r101.putOpt(r105, r106);     // Catch: Throwable -> L41
        goto L39
    L25:
        if ((r106 instanceof JSONObject) == false) goto L28;
        r107 = r101.putOpt(r105, r106);     // Catch: Throwable -> L41
        goto L39
    L28:
        if ((r106 instanceof JSONArray) == false) goto L31;
        r107 = r101.putOpt(r105, r106);     // Catch: Throwable -> L41
        goto L39
    L31:
        if ((r106 instanceof Map) == false) goto L34;
        r107 = r101.putOpt(r105, b((Map) r106));     // Catch: Throwable -> L41
        goto L39
    L34:
        if ((r106 instanceof List) == false) goto L36;
        r107 = r101.putOpt(r105, a((List) r106));     // Catch: Throwable -> L41
        goto L39
    L36:
        if (r106 != null) goto L38;
        r107 = r101.putOpt(r105, JSONObject.NULL);     // Catch: Throwable -> L41
        goto L39
    L38:
        r107 = Unit.INSTANCE;     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L4
    L43:
        return r101;
    }
}
