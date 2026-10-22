package com.bytedance.android.livesdk.monitor;

import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes11.dex */
public final class b {
    public static void a(int r100, String r101, String r102, HashMap<String, String> r103, HashMap<String, Object> r104) {
        if (r103 != null) goto L4;
        r103 = new HashMap();
    L4:
        Iterator<String> r105 = r104.keySet().iterator();
    L6:
        if (r105.hasNext() == false) goto L10;
        String r106 = r105.next();
        if (r104.get(r106) == null) goto L6;
        r103.put(r106, String.valueOf(r104.get(r106)));
        goto L6
    L10:
        r103.put("follow_action", r102);
        Boolean r107 = vt2.a.f557192a;
        vt2.a.d("ttlive_follow_result_trace", r100, r101, r103);
        vt2.a.c("ttlive_follow_result_trace", r100, r101, r103);
    }
}
