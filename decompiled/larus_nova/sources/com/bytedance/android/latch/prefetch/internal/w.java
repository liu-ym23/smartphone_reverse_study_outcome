package com.bytedance.android.latch.prefetch.internal;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, s> f58494a;

    public w() {
        throw null;
    }

    public w(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        JSONObject r101 = r100.optJSONObject("pages");
        if (r101 == null) goto L8;
        Map<String, s> r102 = new LinkedHashMap();
        Iterator<String> r103 = r101.keys();
    L6:
        if (r103.hasNext() == false) goto L9;
        String r104 = r103.next();
        r102.put(r104, new s(JSONObjectProtectorUtils.getJSONObject(r101, r104)));
    L9:
        this.f58494a = r102;
        return;
    L8:
        r102 = MapsKt.emptyMap();
        goto L9
    }

    public static final boolean a(w r100, Object r101, Object r102) {
        r100.getClass();
        if (r101 != r102) goto L6;
        return true;
    L6:
        if (r101 != JSONObject.NULL) goto L10;
        if (r102 != null) goto L10;
        return true;
    L10:
        if ((r101 instanceof String) == false) goto L16;
        if (r102 != null) goto L13;
    L15:
        return false;
    L13:
        if (TextUtils.equals((CharSequence) r101, r102.toString()) == false) goto L15;
        return true;
    L16:
        Double r103 = null;
        r103 = null;
        Integer r104 = null;
        Boolean r105 = null;
        r105 = null;
        r104 = null;
        if ((r101 instanceof Boolean) == false) goto L33;
        if (r102 == null) goto L15;
        if ((r102 instanceof Boolean) == false) goto L24;
        r105 = (Boolean) r102;
    L68:
        return Intrinsics.areEqual(r101, r105);
    L24:
        if ((r102 instanceof String) == false) goto L68;
        String r106 = (String) r102;
        if (StringsKt.equals("true", r106, true) == false) goto L29;
        r105 = Boolean.TRUE;
        goto L68
    L29:
        if (StringsKt.equals("false", r106, true) == false) goto L68;
        r105 = Boolean.FALSE;
        goto L68
    L33:
        if ((r101 instanceof Integer) == false) goto L47;
        if (r102 == null) goto L15;
        if ((r102 instanceof Integer) == false) goto L40;
        r104 = (Integer) r102;
    L69:
        return Intrinsics.areEqual(r101, r104);
    L40:
        if ((r102 instanceof Number) == false) goto L43;
        r104 = Integer.valueOf(((Number) r102).intValue());
        goto L69
    L43:
        if ((r102 instanceof String) == false) goto L69;
        r104 = StringsKt.toIntOrNull((String) r102);     // Catch: NumberFormatException -> L61
        goto L69
    L47:
        if ((r101 instanceof Double) == false) goto L15;
        if (r102 == null) goto L15;
        Double r107 = (Double) r101;
        if ((r102 instanceof Double) == false) goto L54;
        r103 = (Double) r102;
    L60:
        return Intrinsics.areEqual(r107, r103);
    L54:
        if ((r102 instanceof Number) == false) goto L57;
        r103 = Double.valueOf(((Number) r102).doubleValue());
        goto L60
    L57:
        if ((r102 instanceof String) == false) goto L60;
        r103 = StringsKt.toDoubleOrNull((String) r102);     // Catch: NumberFormatException -> L62
        goto L60
    }
}
