package com.amap.api.col.jmsl;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.Arrays;

/* renamed from: com.amap.api.col.jmsl.l0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1575l0 {

    /* renamed from: a, reason: collision with root package name */
    public static byte[] f16717a;

    /* renamed from: b, reason: collision with root package name */
    public static byte[] f16718b;

    public static int a(Context context, String str, String str2, int i10) {
        try {
            return context.getSharedPreferences(str, 0).getInt(str2, i10);
        } catch (Throwable th) {
            C1541c2.b(th, "csp", "giv");
            return i10;
        }
    }

    public static SharedPreferences.Editor b(Context context, String str) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    return context.getSharedPreferences(str, 0).edit();
                }
            } catch (Throwable th) {
                C1611u1.b(th, "sp", "ge");
            }
        }
        return null;
    }

    public static String c(Context context, String str, String str2) {
        byte[] bArrF;
        try {
            try {
                bArrF = C1568j1.f(k(context), C1604s2.p(context.getSharedPreferences(str, 0).getString(str2, "")), n(context));
            } catch (Exception unused) {
                bArrF = new byte[0];
            }
            return C1604s2.n(bArrF);
        } catch (Throwable unused2) {
            return "";
        }
    }

    public static void d(Context context, String str, String str2, String str3) {
        byte[] bArrH;
        if (context == null || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences(str, 0).edit();
            try {
                bArrH = C1568j1.h(k(context), C1604s2.t(str3), n(context));
            } catch (Throwable unused) {
                bArrH = new byte[0];
            }
            editorEdit.putString(str2, C1604s2.d(bArrH));
            e(editorEdit);
        } catch (Throwable unused2) {
        }
    }

    public static void e(SharedPreferences.Editor editor) {
        if (editor == null) {
            return;
        }
        try {
            editor.apply();
        } catch (Throwable th) {
            C1611u1.b(th, "sp", "cm");
        }
    }

    public static void f(SharedPreferences.Editor editor, String str, int i10) {
        try {
            editor.putInt(str, i10);
        } catch (Throwable th) {
            C1541c2.b(th, "csp", "putPrefsInt");
        }
    }

    public static void g(SharedPreferences.Editor editor, String str, long j10) {
        if (editor == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            editor.putLong(str, j10);
        } catch (Throwable th) {
            C1541c2.b(th, "csp", "plv");
        }
    }

    public static void h(SharedPreferences.Editor editor, String str, String str2) {
        if (editor != null) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    editor.putString(str, str2);
                }
            } catch (Throwable th) {
                C1611u1.b(th, "sp", "ps");
            }
        }
    }

    public static void i(SharedPreferences.Editor editor, String str, boolean z10) {
        try {
            editor.putBoolean(str, z10);
        } catch (Throwable th) {
            C1541c2.b(th, "csp", "setPrefsStr");
        }
    }

    public static boolean j(Context context, String str, String str2, boolean z10) {
        try {
            return context.getSharedPreferences(str, 0).getBoolean(str2, z10);
        } catch (Throwable th) {
            C1541c2.b(th, "csp", "gbv");
            return z10;
        }
    }

    public static byte[] k(Context context) {
        if (context == null) {
            return new byte[0];
        }
        byte[] bArr = f16717a;
        if (bArr != null && bArr.length > 0) {
            return bArr;
        }
        byte[] bytes = C1567j0.n(context).getBytes();
        f16717a = bytes;
        return bytes;
    }

    public static byte[] l(Context context, byte[] bArr) {
        try {
            return C1568j1.h(k(context), bArr, n(context));
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    public static String m(Context context, String str, String str2, String str3) {
        if (context == null) {
            return null;
        }
        try {
            return context.getSharedPreferences(str, 0).getString(str2, str3);
        } catch (Throwable th) {
            C1541c2.b(th, "csp", "gsv");
            return str3;
        }
    }

    public static byte[] n(Context context) {
        byte[] bArr = f16718b;
        if (bArr != null && bArr.length > 0) {
            return bArr;
        }
        byte[] bArrCopyOfRange = Arrays.copyOfRange(k(context), 0, k(context).length / 2);
        f16718b = bArrCopyOfRange;
        return bArrCopyOfRange;
    }

    public static byte[] o(Context context, byte[] bArr) {
        try {
            return C1568j1.f(k(context), bArr, n(context));
        } catch (Exception unused) {
            return new byte[0];
        }
    }
}
