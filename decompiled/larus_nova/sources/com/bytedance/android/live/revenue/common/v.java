package com.bytedance.android.live.revenue.common;

import com.lynx.tasm.LynxError;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f91009a = 0;

    public v() {
    }

    static {
    }

    public static JSONObject g(Map r100) {
        JSONObject r101 = new JSONObject();
        Iterator r102 = ((HashMap) r100).entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        Map.Entry r103 = (Map.Entry) r102.next();     // Catch: Exception -> L7
        r101.put((String) r103.getKey(), r103.getValue());     // Catch: Exception -> L7
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L4
    L9:
        return r101;
    }

    public static void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
        jy0.b.a(r100, r101);
    }

    public static void c(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
        jy0.b.c(r100, null, r101, 2);
    }

    public static void d(String r100, Map r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        if (r100.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L9;
        b(r100, String.valueOf(g(r101)), null);
        return;
    L9:
        return;
    L5:
        r102 = false;
        goto L6
    }

    public static void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
        jy0.b.d(r100, r101);
    }

    public static void f(String r100, Map r101) {
        boolean r102 = false;
        if (r100.length() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == true) goto L13;
        JSONObject r104 = g(r101);
        if (r100.length() != 0) goto L10;
        r102 = true;
    L10:
        if (r102 == true) goto L14;
        jy0.b.d(r100, r104.toString());
        return;
    L14:
        return;
    L13:
        return;
    L5:
        r103 = false;
        goto L6
    }

    public static void h(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
        jy0.b.e(r100, r101, null);
    }

    public static void b(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
        jy0.b.b(r100, r101, r102);
    }
}
