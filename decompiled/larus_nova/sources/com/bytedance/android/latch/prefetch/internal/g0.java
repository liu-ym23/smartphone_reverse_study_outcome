package com.bytedance.android.latch.prefetch.internal;

import android.net.Uri;
import com.bytedance.android.annie.card.base.BaseHybridComponent;
import com.bytedance.locallife.cube.PrefetchTiming;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class g0 {
    public static final JSONObject b(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "originalObject");
        JSONObject r101 = new JSONObject();
        Iterator r102 = SequencesKt.sorted(SequencesKt.asSequence(r100.keys())).iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        String r103 = (String) r102.next();
        Object r104 = r100.get(r103);
        if ((r104 instanceof JSONObject) == true) goto L7;
        r101.put(r103, r104);
        goto L4
    L7:
        r101.put(r103, b((JSONObject) r104));
        goto L4
    L9:
        return r101;
    }

    public static final boolean c(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return Intrinsics.areEqual(r100.optString("__type"), PrefetchTiming.JSB);
    }

    public static final JSONObject d(Map<String, ? extends Object> r100) {
        if (r100 == null) goto L4;
        JSONObject r101 = new JSONObject();
        Iterator<T> r102 = r100.entrySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        Map.Entry r103 = (Map.Entry) r102.next();
        r101.put((String) r103.getKey(), r103.getValue());
        goto L7
    L9:
        return r101;
    L4:
        return new JSONObject();
    }

    public static final SortedMap<String, String> e(JSONObject r100) throws JSONException {
        TreeMap r101 = new TreeMap();
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L6;
        String r103 = r102.next();
        r101.put(r103, JSONObjectProtectorUtils.getString(r100, r103));
        goto L4
    L6:
        return r101;
    }

    public static final SortedMap<String, f0<?>> f(JSONObject r100) throws JSONException {
        TreeMap r101 = new TreeMap();
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L28;
        String r103 = r102.next();
        JSONObject r104 = JSONObjectProtectorUtils.getJSONObject(r100, r103);
        String r105 = JSONObjectProtectorUtils.getString(r104, "source");
        Locale r106 = Locale.ROOT;
        if (r105 == null) goto L27;
        String r107 = r105.toLowerCase(r106);
        switch(r107.hashCode()) {
            case -892481938: goto L23;
            case -855399539: goto L19;
            case -423400308: goto L15;
            case 107944136: goto L11;
            default: goto L4;
        };
    L11:
        if (r107.equals("query") == false) goto L4;
        r101.put(r103, new u(JSONObjectProtectorUtils.getString(r104, "value")));
        goto L4
    L15:
        if (r107.equals(BaseHybridComponent.INITIAL_PROPS_QUERY_KEY) == false) goto L4;
        r101.put(r103, new m(JSONObjectProtectorUtils.getString(r104, "value")));
        goto L4
    L19:
        if (r107.equals("globalProps") == false) goto L4;
        r101.put(r103, new d(JSONObjectProtectorUtils.getString(r104, "value")));
        goto L4
    L23:
        if (r107.equals("static") == false) goto L4;
        r101.put(r103, new e0(r104.get("value")));
        goto L4
    L27:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L28:
        return r101;
    }

    public static final String a(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "baseUrl");
        Uri.Builder r102 = UriProtector.parse(r100).buildUpon();
        if (r101 == null) goto L9;
        Iterator<Map.Entry<String, ? extends Object>> r103 = r101.entrySet().iterator();
    L6:
        if (r103.hasNext() == false) goto L9;
        Map.Entry<String, ? extends Object> r104 = r103.next();
        r102.appendQueryParameter(r104.getKey(), r104.getValue().toString());
    L9:
        return r102.toString();
    }
}
