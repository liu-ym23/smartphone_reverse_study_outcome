package com.bytedance.android.shopping.commentv3.audio;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes13.dex */
public final class c {

    public static final class a {
    }

    static {
    }

    public c() {
    }

    public static Map a(Map r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        Map.Entry r103 = (Map.Entry) r102.next();
        Object r104 = r103.getKey();
        Object r105 = r103.getValue();
        if ((r104 instanceof String) == false) goto L7;
        r101.put(r104, r105);
        goto L4
    L7:
        return null;
    L10:
        return r101;
    }
}
