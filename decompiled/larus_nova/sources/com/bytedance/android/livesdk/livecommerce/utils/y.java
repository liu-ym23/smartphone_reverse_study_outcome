package com.bytedance.android.livesdk.livecommerce.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public final class y {
    public static Map<String, String> a(List<si2.k> r100) {
        HashMap r101 = new HashMap();
        if (r100 == null) goto L8;
        Iterator<si2.k> r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        si2.k r103 = r102.next();
        r101.put(r103.f45605a, r103.f45606b);
    L8:
        return r101;
    }
}
