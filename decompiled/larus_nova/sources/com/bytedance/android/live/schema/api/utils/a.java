package com.bytedance.android.live.schema.api.utils;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import om0.c;

/* JADX INFO: loaded from: classes47.dex */
public final class a {
    static {
    }

    public static String e(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == false) goto L11;
        return "WebcastRedirect";
    L11:
        return "WebcastRedirect_" + r100;
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }

    @JvmStatic
    public static final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        pm0.a r102 = c.c();
        if (r102 == null) goto L6;
        r102.d(e(r100), r101);
        return;
    }

    @JvmStatic
    public static final void c(String r100, Throwable r101) {
        pm0.a r102 = c.c();
        if (r102 == null) goto L9;
        String r103 = e(r100);
        if (r101 != null) goto L7;
        r101 = new Exception();
    L7:
        r102.e(r103, r101);
        return;
    }

    @JvmStatic
    public static final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        pm0.a r102 = c.c();
        if (r102 == null) goto L6;
        r102.i(e(r100), r101);
        return;
    }

    @JvmStatic
    public static final void b(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        pm0.a r103 = c.c();
        if (r103 == null) goto L9;
        String r104 = e(r100);
        if (r102 != null) goto L7;
        r102 = new Exception();
    L7:
        r103.e(r104, r101, r102);
        return;
    }
}
