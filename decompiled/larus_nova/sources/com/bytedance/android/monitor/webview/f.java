package com.bytedance.android.monitor.webview;

import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class f {
    public static void a(JSONObject r100, JSONObject r101) {
        if (r101 == null) goto L8;
        Iterator<String> r102 = r101.keys();
    L6:
        if (r102.hasNext() == false) goto L10;
        String r103 = r102.next();
        bz2.e.h(r100, r103, bz2.e.d(r101, r103));
        goto L6
    L10:
        return;
    }
}
