package com.bytedance.android.ecom.bcm.track.impl.util;

import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f51160a = 0;

    static {
    }

    public static void a(JSONObject r100, JSONObject r101) {
        if (r100 == null) goto L15;
        Iterator<String> r102 = r100.keys();     // Catch: JSONException -> L8
    L5:
        if (r102.hasNext() == false) goto L16;
        String r103 = r102.next();     // Catch: JSONException -> L8
        r101.put(r103, r100.get(r103));     // Catch: JSONException -> L8
        goto L5
    L16:
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    }
}
