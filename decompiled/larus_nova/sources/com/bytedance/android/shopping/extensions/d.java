package com.bytedance.android.shopping.extensions;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class d {

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0001¨\u0006\u0004"}, d2 = {"com/bytedance/android/shopping/extensions/d$a", "Lcom/google/gson/reflect/TypeToken;", "", "", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a extends TypeToken<Map<String, ? extends String>> {
        public a() {
        }
    }

    public static final void a(JSONObject r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$appendByString");
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L21;
        return;
    L21:
        Iterator r103 = ((Map) GsonProtectorUtils.fromJson(u0.c(), r101, new a().getType())).entrySet().iterator();     // Catch: JSONException -> L16 JsonSyntaxException -> L18
    L13:
        if (r103.hasNext() == false) goto L26;
        Map.Entry r104 = (Map.Entry) r103.next();     // Catch: JSONException -> L16 JsonSyntaxException -> L18
        r100.put((String) r104.getKey(), r104.getValue());     // Catch: JSONException -> L16 JsonSyntaxException -> L18
    L26:
        return;
    L18:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return;
    L16:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return;
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public static final void b(JSONObject r100, String r101, String r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r102 != null) goto L14;
        return;
    L14:
    L11:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return;
    L7:
        if (r100.opt(r101) == null) goto L9;
        return;
    L9:
        r100.put(r101, r102);     // Catch: Exception -> L11
    }
}
