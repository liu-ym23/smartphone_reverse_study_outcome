package com.bytedance.android.monitorV2.webview;

import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class l {
    public static void a(JSONObject r100, JSONObject r101) {
        if (r101 == null) goto L8;
        Iterator<String> r102 = r101.keys();
    L6:
        if (r102.hasNext() == false) goto L10;
        String r103 = r102.next();
        com.bytedance.android.monitorV2.util.l.p(r100, r103, com.bytedance.android.monitorV2.util.l.k(r101, r103));
        goto L6
    L10:
        return;
    }
}
