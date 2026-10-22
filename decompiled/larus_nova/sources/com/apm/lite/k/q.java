package com.apm.lite.k;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes39.dex */
public final class q {
    public static Float a(Map<? super String, Float> r100) {
        Iterator r101 = ((HashMap) r100).values().iterator();
        float r102 = 0.0f;
    L4:
        if (r101.hasNext() == false) goto L9;
        Float r103 = (Float) r101.next();
        if (r103 == null) goto L4;
        r102 = r102 + r103.floatValue();
        goto L4
    L9:
        return Float.valueOf(r102);
    }

    public static Long b(Map<? super String, Long> r100, String r101, Long r102) {
        if (r100 == null) goto L4;
        HashMap r103 = (HashMap) r100;
        Long r104 = (Long) r103.get(r101);
        if (r104 == null) goto L8;
        r102 = Long.valueOf(r104.longValue() + r102.longValue());
    L8:
        r103.put(r101, r102);
        return r102;
    L4:
        return -1L;
    }
}
