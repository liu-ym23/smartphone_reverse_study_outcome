package com.android.ttcjpaysdk.base.utils;

import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004J\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b2\u0006\u0010\t\u001a\u00020\nJ\u001c\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\f2\u0006\u0010\t\u001a\u00020\u0004¨\u0006\u000e"}, d2 = {"Lcom/android/ttcjpaysdk/base/utils/CJPayConvertUtils;", "", "()V", "jsonMergeJson", "Lorg/json/JSONObject;", PickerReporterConstants.KEY.TARGET, "source", "jsonToList", "", "json", "Lorg/json/JSONArray;", "jsonToMap", "", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayConvertUtils {
    public static final CJPayConvertUtils INSTANCE = null;

    static {
        INSTANCE = new CJPayConvertUtils();
    }

    private CJPayConvertUtils() {
    }

    public final List<Object> jsonToList(JSONArray r100) {
        Intrinsics.checkNotNullParameter(r100, "json");
        ArrayList r101 = new ArrayList();
        int r102 = r100.length();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L27;
        Object r104 = r100.opt(r103);
        if ((r104 instanceof Long) == false) goto L8;
        r101.add(Long.valueOf(r100.optLong(r103)));
    L26:
        r103 = r103 + 1;
        goto L3
    L8:
        if ((r104 instanceof Double) == false) goto L11;
        r101.add(Double.valueOf(r100.optDouble(r103)));
        goto L26
    L11:
        if ((r104 instanceof Integer) == false) goto L14;
        r101.add(Integer.valueOf(JSONArrayProtectorUtils.getInt(r100, r103)));
        goto L26
    L14:
        if ((r104 instanceof String) == false) goto L17;
        r101.add(r100.optString(r103));
        goto L26
    L17:
        if ((r104 instanceof JSONObject) == false) goto L20;
        r101.add(INSTANCE.jsonToMap(r100.optJSONObject(r103)));
        goto L26
    L20:
        if ((r104 instanceof JSONArray) == false) goto L23;
        r101.add(INSTANCE.jsonToList(r100.optJSONArray(r103)));
        goto L26
    L23:
        if ((r104 instanceof Boolean) == false) goto L25;
        r101.add(Boolean.valueOf(r100.optBoolean(r103)));
        goto L26
    L25:
        r101.add(null);
        goto L26
    L27:
        return r101;
    }

    public final Map<String, Object> jsonToMap(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "json");
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L27;
        String r103 = r102.next();
        Object r104 = r100.opt(r103);
        if ((r104 instanceof Long) == true) goto L7;
        if ((r104 instanceof Double) == true) goto L10;
        if ((r104 instanceof Integer) == true) goto L13;
        if ((r104 instanceof String) == true) goto L16;
        if ((r104 instanceof JSONObject) == true) goto L19;
        if ((r104 instanceof JSONArray) == true) goto L22;
        if ((r104 instanceof Boolean) == true) goto L25;
        r101.put(r103, null);
        goto L4
    L25:
        r101.put(r103, Boolean.valueOf(r100.optBoolean(r103)));
        goto L4
    L22:
        r101.put(r103, INSTANCE.jsonToList(r100.optJSONArray(r103)));
        goto L4
    L19:
        r101.put(r103, INSTANCE.jsonToMap(r100.optJSONObject(r103)));
        goto L4
    L16:
        r101.put(r103, r100.optString(r103));
        goto L4
    L13:
        r101.put(r103, Integer.valueOf(r100.optInt(r103)));
        goto L4
    L10:
        r101.put(r103, Double.valueOf(r100.optDouble(r103)));
        goto L4
    L7:
        r101.put(r103, Long.valueOf(r100.optLong(r103)));
        goto L4
    L27:
        return r101;
    }

    public final JSONObject jsonMergeJson(JSONObject r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        if (r101 != null) goto L17;
        return r100;
    L17:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L11
        Iterator<Map.Entry<String, Object>> r103 = INSTANCE.jsonToMap(r101).entrySet().iterator();     // Catch: Throwable -> L11
    L7:
        if (r103.hasNext() == false) goto L9;
        Map.Entry<String, Object> r104 = r103.next();     // Catch: Throwable -> L11
        KtSafeMethodExtensionKt.safePut(r100, r104.getKey(), r104.getValue());     // Catch: Throwable -> L11
        goto L7
    L9:
        Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L14:
        if (Result.m9456isSuccessimpl(r105) == false) goto L16;
        Unit r106 = (Unit) r105;
    L16:
        return r100;
    L11:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    }
}
