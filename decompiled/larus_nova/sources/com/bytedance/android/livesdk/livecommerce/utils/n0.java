package com.bytedance.android.livesdk.livecommerce.utils;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f153102a = 0;

    static {
    }

    public static String a(String r100, String r101, String r102) {
        if (r100 != null) goto L5;
        return "";
    L5:
        if (r102 != null) goto L26;
        return r100;
    L26:
    L15:
        e = move-exception;
        ECExceptionMonitor.e(e);
        JSONObject r103 = new JSONObject();
    L28:
    L21:
        e = move-exception;
        ECExceptionMonitor.e(e);
        e.toString();
    L24:
        return r103.toString();
    L18:
        if (r103.opt(r101) != null) goto L24;
        r103.put(r101, r102);     // Catch: Exception -> L21
        goto L24
    L8:
        if (r100.length() <= 0) goto L10;
        boolean r104 = true;
    L11:
        if (r104 == false) goto L13;
        r103 = new JSONObject(r100);     // Catch: Exception -> L15
    L25:
        goto L28
    L13:
        r103 = new JSONObject();     // Catch: Exception -> L15
        goto L25
    L10:
        r104 = false;
        goto L11
    }
}
