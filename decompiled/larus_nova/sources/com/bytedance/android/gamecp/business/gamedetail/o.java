package com.bytedance.android.gamecp.business.gamedetail;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Map<String, String> f55311a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Map<String, String> f55312b;

    public static Map a() {
        Map<String, String> r100 = f55312b;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new LinkedHashMap();
    }

    public static boolean c() {
        if (Intrinsics.areEqual(com.bytedance.android.gamecp.host_api.a.b().getLogService().J0(), "gpsdk_") == false) goto L6;
        return true;
    L6:
        return false;
    }

    static {
    }

    public static Map b(String r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        if (r100.length() <= 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L15;
    L14:
        return r101;
    L15:
        JSONObject r103 = new JSONObject(r100);     // Catch: Exception -> L12
        Iterator<String> r104 = r103.keys();     // Catch: Exception -> L12
    L9:
        if (r104.hasNext() == false) goto L14;
        String r105 = r104.next();     // Catch: Exception -> L12
        r101.put(r105, (String) r103.opt(r105));     // Catch: Exception -> L12
    L12:
        e = move-exception;
        yr.c.b("", String.valueOf(e.getMessage()));
        goto L14
    L5:
        r102 = false;
        goto L6
    }
}
