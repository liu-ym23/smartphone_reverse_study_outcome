package com.bytedance.android.ec.store.utils;

import com.bytedance.android.ec.core.utils.t0;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class m {

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001¨\u0006\u0005"}, d2 = {"com/bytedance/android/ec/store/utils/m$a", "Lcom/google/gson/reflect/TypeToken;", "", "", "", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a extends TypeToken<Map<String, ? extends Object>> {
        public a() {
        }
    }

    public static final Map<String, String> b(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$notNullValue");
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator<Map.Entry<String, String>> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Map.Entry<String, String> r103 = r102.next();
        String r104 = r103.getValue();
        if (r104 == null) goto L4;
        String r105 = (String) r101.put(r103.getKey(), r104);
        goto L4
    L8:
        return r101;
    }

    public static final Map<String, Object> c(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$objectToMap");
        int r101 = t0.f45720a;     // Catch: Exception -> L5
        Gson r102 = t0.a.f45721a;     // Catch: Exception -> L5
        return (Map) r102.fromJson(r102.toJson(r100), new a().getType());
    L5:
        e = move-exception;
        dm.a.a("ec_shop, Any.objectToMap").b(e.toString(), null);
        return null;
    }

    public static final Object a(Object r100, Type r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$anyToObject");
        Intrinsics.checkNotNullParameter(r101, "type");
        int r102 = t0.f45720a;     // Catch: Exception -> L5
        Gson r103 = t0.a.f45721a;     // Catch: Exception -> L5
        return r103.fromJson(r103.toJson(r100), r101);
    L5:
        e = move-exception;
        dm.a.a("ec_shop, Any.anyToObject").b(e.toString(), null);
        return null;
    }
}
