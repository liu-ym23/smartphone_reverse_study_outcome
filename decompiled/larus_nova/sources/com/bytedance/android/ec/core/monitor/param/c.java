package com.bytedance.android.ec.core.monitor.param;

import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.bytedance.android.ec.core.utils.x0;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class c {
    public static final void a(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$convertMegaObject");
        JSONObject r101 = r100.optJSONObject("mega_object");
        if (r101 == null) goto L9;
        Map<String, Object> r102 = z1.j(r101);
        if ((!r102.isEmpty()) == true) goto L8;
        r102 = null;
    L8:
        if (r102 == null) goto L9;
    L10:
        if (r102 == null) goto L15;
        Iterator<Map.Entry<String, Object>> r103 = r102.entrySet().iterator();
    L13:
        if (r103.hasNext() == false) goto L15;
        Map.Entry<String, Object> r104 = r103.next();
        KtSafeMethodExtensionKt.safePut(r100, "mega_object_" + r104.getKey(), r104.getValue());
    L15:
        r100.remove("mega_object");
        return;
    L9:
        r102 = k.z(r100.optString("mega_object"));
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Map<String, String> b(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$convertPassThrough");
        Map<String, String> r101 = MapsKt.toMutableMap(r100);
        String r102 = r100.get("pass_through");
        if ((r102 instanceof String) == true) goto L14;
    L6:
        JSONArray r103 = null;
    L7:
        Iterator r104 = ((LinkedHashMap) d(r103)).entrySet().iterator();
    L9:
        if (r104.hasNext() == false) goto L11;
        Map.Entry r105 = (Map.Entry) r104.next();
        r101.put(r105.getKey(), ((JSONObject) r105.getValue()).toString());
        goto L9
    L11:
        r101.remove("pass_through");
        return r101;
    L14:
        r103 = new JSONArray(r102);     // Catch: Exception -> L13
        goto L7
    }

    public static final void c(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$convertPassThrough");
        Object r101 = r100.opt("pass_through");
        if ((r101 instanceof JSONArray) == false) goto L6;
        JSONArray r102 = (JSONArray) r101;
    L10:
        Iterator r103 = ((LinkedHashMap) d(r102)).entrySet().iterator();
    L12:
        if (r103.hasNext() == false) goto L14;
        Map.Entry r104 = (Map.Entry) r103.next();
        KtSafeMethodExtensionKt.safePut(r100, (String) r104.getKey(), r104.getValue());
        goto L12
    L14:
        r100.remove("pass_through");
        return;
    L6:
        if ((r101 instanceof String) == true) goto L17;
    L9:
        r102 = null;
        goto L10
    L17:
        r102 = new JSONArray((String) r101);     // Catch: Exception -> L16
        goto L10
    }

    public static final Map<String, JSONObject> d(JSONArray r110) {
        LinkedHashMap r100 = new LinkedHashMap();
        if (r110 == null) goto L16;
        int r101 = r110.length();
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L16;
        JSONObject r103 = JSONArrayProtectorUtils.getJSONObject(r110, r102);
        JSONArray r104 = r103.optJSONArray(RemoteMessageConst.TO);
        if (r104 == null) goto L15;
        Iterator r105 = ((ArrayList) z1.h(r104)).iterator();
    L10:
        if (r105.hasNext() == false) goto L15;
        String r106 = StringsKt.replace$default(r105.next().toString(), '.', '_', false, 4, null);
        JSONObject r107 = (JSONObject) r100.get(r106);
        if (r107 != null) goto L14;
        r107 = new JSONObject();
    L14:
        x0.b(r107, z1.f(r103.optString("data")), false);
        r100.put(r106, r107);
    L15:
        r102 = r102 + 1;
    L16:
        return r100;
    }
}
