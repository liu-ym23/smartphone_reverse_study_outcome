package com.bytedance.android.shopping.extensions;

import android.graphics.Color;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.t0;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.core.utils.z1;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class k {

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00020\u0001¨\u0006\u0005"}, d2 = {"com/bytedance/android/shopping/extensions/k$a", "Lcom/google/gson/reflect/TypeToken;", "", "", "", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a extends TypeToken<Map<String, Object>> {
        public a() {
        }
    }

    public static final boolean m(int r100) {
        if (r100 == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static final HashMap<String, String> A(JSONObject r100) throws JSONException {
        Intrinsics.checkNotNullParameter(r100, "$this$toStringMap");
        HashMap<String, String> r101 = new HashMap();
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L6;
        String r103 = r102.next();
        r101.put(r103, r100.get(r103).toString());
        goto L4
    L6:
        return r101;
    }

    public static final <K, V> Map<K, V> b(Map<K, ? extends V> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$filterNotNullValues");
        ArrayList r101 = new ArrayList();
        Iterator<Map.Entry<K, ? extends V>> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L12;
        Map.Entry<K, ? extends V> r103 = r102.next();
        K r104 = r103.getKey();
        V r105 = r103.getValue();
        if (r105 == null) goto L8;
        Pair r106 = TuplesKt.to(r104, r105);
    L9:
        if (r106 == null) goto L4;
        r101.add(r106);
        goto L4
    L8:
        r106 = null;
        goto L9
    L12:
        return MapsKt.toMap(r101);
    }

    public static final boolean c(String r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100.length() <= 0) goto L6;
        return true;
    }

    public static final float d(Float r100) {
        if (r100 != null) goto L6;
        return 0.0f;
    L6:
        return r100.floatValue();
    }

    public static final int f(Integer r100) {
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.intValue();
    }

    public static final long h(Long r100) {
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.longValue();
    }

    public static final boolean i(Boolean r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return r100.booleanValue();
    }

    public static String j(String r100) {
        Intrinsics.checkNotNullParameter("", "default");
        if (r100 == null) goto L5;
        return r100;
    L5:
        return "";
    }

    public static final int o(String r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toColorInt");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(Integer.valueOf(Color.parseColor(r100)));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r102) == false) goto L10;
        r102 = null;
    L10:
        Integer r103 = (Integer) r102;
        if (r103 != null) goto L17;
        return 0;
    L17:
        return r103.intValue();
    L5:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public static final int q(Boolean r100) {
        return Intrinsics.areEqual(r100, Boolean.TRUE) ? 1 : 0;
    }

    public static final JSONArray s(List<String> r100) {
        JSONArray r101 = new JSONArray();
        if (r100 == null) goto L8;
        Iterator<T> r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        r101.put((String) r102.next());
    L8:
        return r101;
    }

    public static final JSONArray t(String r100) {
    L6:
        e = move-exception;
        ECExceptionMonitor.f(e, "json_format_error");
        return null;
    L3:
        if (c(r100) == false) goto L12;
        return new JSONArray(r100);
    L12:
        return null;
    }

    public static final JSONObject u(String r100) {
    L6:
        e = move-exception;
        ECExceptionMonitor.f(e, "json_format_error");
    L9:
        return new JSONObject();
    L3:
        if (c(r100) == false) goto L9;
        return new JSONObject(r100);
    }

    public static JSONObject v(Object r100) {
        if (r100 == null) goto L8;
        return tv5.a.b(r100);
    L5:
        e = move-exception;
        ECExceptionMonitor.f(e, "json_format_error");
    L8:
        return new JSONObject();
    }

    public static final JSONObject w(String r100) {
    L6:
        e = move-exception;
        ECExceptionMonitor.f(e, "json_format_error");
        return null;
    L3:
        if (c(r100) == false) goto L12;
        return new JSONObject(r100);
    L12:
        return null;
    }

    public static final String x(Object r100) {
        if (r100 != null) goto L6;
        return (String) r100;
    L6:
        return u0.d(r100);
    }

    public static final Map<String, Object> z(String r100) {
        int r101 = t0.f45720a;     // Catch: Exception -> L4
        return (Map) t0.a.f45721a.fromJson(r100, new a().getType());
    L4:
        return null;
    }

    public static final String a(String r100, Function1<? super JSONObject, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "block");
        JSONObject r102 = z1.g(r100);
        if (r102 == null) goto L5;
        r101.invoke(r102);
        return r102.toString();
    L5:
        return null;
    }

    public static final float e(Float r100, float r101) {
        if (r100 != null) goto L4;
        return r101;
    L4:
        return r100.floatValue();
    }

    public static final int g(Integer r100, int r101) {
        if (r100 != null) goto L4;
        return r101;
    L4:
        return r100.intValue();
    }

    public static final String k(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "default");
        if (c(r100) == true) goto L6;
        r100 = null;
    L6:
        if (r100 != null) goto L8;
        return r101;
    L8:
        return r100;
    }

    public static final boolean n(String r100, boolean r101) {
        if (r100 != null) goto L5;
        return r101;
    L5:
        if (Intrinsics.areEqual(r100, "1") == false) goto L7;
        return true;
    L7:
        if (Intrinsics.areEqual(r100, "true") == true) goto L13;
        return false;
    L13:
        return true;
    }

    public static final float p(String r100, float r101) {
        if (r100 == null) goto L7;
        Float r102 = StringsKt.toFloatOrNull(r100);
        if (r102 != null) goto L6;
        return r101;
    L6:
        return r102.floatValue();
    L7:
        return r101;
    }

    public static final int r(String r100, int r101) {
        if (r100 == null) goto L7;
        Integer r102 = StringsKt.toIntOrNull(r100);
        if (r102 != null) goto L6;
        return r101;
    L6:
        return r102.intValue();
    L7:
        return r101;
    }

    public static final long y(String r100, long r101) {
        if (r100 == null) goto L7;
        Long r102 = StringsKt.toLongOrNull(r100);
        if (r102 != null) goto L6;
        return r101;
    L6:
        return r102.longValue();
    L7:
        return r101;
    }

    public static final void l(JSONObject r100, String r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$safePut");
        Intrinsics.checkNotNullParameter(r101, "key");
        r100.put(r101, r102);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        ECExceptionMonitor.f(e, "json put error");
    }
}
