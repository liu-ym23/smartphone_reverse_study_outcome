package com.baidu.mshield.x6.f;

import android.text.TextUtils;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes39.dex */
public class d {
    public static int a(JSONArray r100) {
        int r101 = 0;
        if (r100 != null) goto L19;
    L18:
        return r101;
    L19:
    L16:
        th = move-exception;
        f.b(th);
        goto L18
    L5:
        if (r100.length() <= 0) goto L18;
        int r102 = 1;
        if (r100.length() == 1) goto L10;
        r101 = r100.optInt(0);     // Catch: Throwable -> L16
    L13:
        if (r102 >= r100.length()) goto L18;
        r101 = r101 & r100.optInt(r102);
        r102 = r102 + 1;
        goto L13
    L10:
        return r100.optInt(0);
    }

    public static int b(JSONArray r100) {
        int r101 = 0;
        if (r100 != null) goto L19;
    L18:
        return r101;
    L19:
    L16:
        th = move-exception;
        f.b(th);
        goto L18
    L5:
        if (r100.length() <= 0) goto L18;
        int r102 = 1;
        if (r100.length() == 1) goto L10;
        r101 = r100.optInt(0);     // Catch: Throwable -> L16
    L13:
        if (r102 >= r100.length()) goto L18;
        r101 = r101 << r100.optInt(r102);
        r102 = r102 + 1;
        goto L13
    L10:
        return r100.optInt(0);
    }

    public static int c(JSONArray r100) {
        int r101 = 0;
        if (r100 != null) goto L19;
    L18:
        return r101;
    L19:
    L16:
        th = move-exception;
        f.b(th);
        goto L18
    L5:
        if (r100.length() <= 0) goto L18;
        int r102 = 1;
        if (r100.length() == 1) goto L10;
        r101 = r100.optInt(0);     // Catch: Throwable -> L16
    L13:
        if (r102 >= r100.length()) goto L18;
        r101 = r101 >> r100.optInt(r102);
        r102 = r102 + 1;
        goto L13
    L10:
        return r100.optInt(0);
    }

    public static int d(JSONArray r100) {
        int r101 = 0;
        if (r100 != null) goto L19;
    L18:
        return r101;
    L19:
    L16:
        th = move-exception;
        f.b(th);
        goto L18
    L5:
        if (r100.length() <= 0) goto L18;
        int r102 = 1;
        if (r100.length() == 1) goto L10;
        r101 = r100.optInt(0);     // Catch: Throwable -> L16
    L13:
        if (r102 >= r100.length()) goto L18;
        r101 = r101 | r100.optInt(r102);
        r102 = r102 + 1;
        goto L13
    L10:
        return r100.optInt(0);
    }

    public static int e(JSONArray r100) {
        int r101 = 0;
        if (r100 != null) goto L19;
    L18:
        return r101;
    L19:
    L16:
        th = move-exception;
        f.b(th);
        goto L18
    L5:
        if (r100.length() <= 0) goto L18;
        int r102 = 1;
        if (r100.length() == 1) goto L10;
        r101 = r100.optInt(0);     // Catch: Throwable -> L16
    L13:
        if (r102 >= r100.length()) goto L18;
        r101 = r101 ^ r100.optInt(r102);
        r102 = r102 + 1;
        goto L13
    L10:
        return r100.optInt(0);
    }

    public static int a(int r100, String r101) {
    L30:
        th = move-exception;
        f.b(th);
        return -1;
    L4:
        if (TextUtils.isEmpty(r101) == false) goto L6;
        return -1;
    L6:
        JSONArray r102 = new JSONArray(r101);     // Catch: Throwable -> L30
        if (r102.length() > 0) goto L10;
        return -1;
    L10:
        if (r102.length() == 1) goto L12;
        if (r100 != 1) goto L15;
        int r103 = a(r102);     // Catch: Throwable -> L30
    L35:
        return r103;
    L15:
        if (r100 != 2) goto L17;
        r103 = d(r102);     // Catch: Throwable -> L30
        goto L35
    L17:
        if (r100 != 3) goto L19;
        r103 = e(r102);     // Catch: Throwable -> L30
        goto L35
    L19:
        if (r100 != 4) goto L21;
        r103 = b(r102);     // Catch: Throwable -> L30
        goto L35
    L21:
        if (r100 != 5) goto L34;
        r103 = c(r102);     // Catch: Throwable -> L30
        goto L35
    L34:
        return -1;
    L12:
        return r102.optInt(0);
    }
}
