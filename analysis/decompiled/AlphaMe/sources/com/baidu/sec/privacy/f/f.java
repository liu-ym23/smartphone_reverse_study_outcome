package com.baidu.sec.privacy.f;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mapauto.auth.constant.ErrorCode;

/* loaded from: classes.dex */
public class f {
    public static boolean a(Context context, int i4) {
        if (com.baidu.sec.privacy.d.a.b(i4)) {
            return b(context, i4);
        }
        return false;
    }

    public static boolean b(Context context, int i4) {
        if (com.baidu.sec.privacy.d.a.a(i4)) {
            return true;
        }
        return c.d(context);
    }

    public static int a(Context context, int i4, String str, int i5, boolean z4, com.baidu.sec.privacy.e.d.a<Integer> aVar, Object... objArr) {
        int iA;
        try {
            if (!com.baidu.sec.privacy.d.a.b(i4)) {
                return i5;
            }
            String str2 = i4 + "";
            if (!TextUtils.isEmpty(str)) {
                str2 = str2 + Base64.encodeToString(str.getBytes(), 0);
            }
            if (!a(str2)) {
                if (com.baidu.sec.privacy.d.a.a(str2) && (iA = com.baidu.sec.privacy.d.a.a(str2, i5)) != i5) {
                    return iA;
                }
                if (b(context, i4)) {
                    int iIntValue = aVar.a(str, objArr).intValue();
                    if (iIntValue != i5) {
                        com.baidu.sec.privacy.d.a.b(str2, iIntValue);
                    }
                    return iIntValue;
                }
                return a(context, i5, z4);
            }
            if (b(context, i4)) {
                int iIntValue2 = aVar.a(str, objArr).intValue();
                if (iIntValue2 == i5) {
                    return com.baidu.sec.privacy.d.a.a(str2) ? com.baidu.sec.privacy.d.a.a(str2, i5) : i5;
                }
                com.baidu.sec.privacy.d.a.b(str2, iIntValue2);
                return iIntValue2;
            }
            if (com.baidu.sec.privacy.d.a.a(str2)) {
                int iA2 = com.baidu.sec.privacy.d.a.a(str2, i5);
                return iA2 == i5 ? a(context, i5, z4) : iA2;
            }
            return a(context, i5, z4);
        } catch (Throwable th) {
            c.a(th);
            return i5;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a(android.content.Context r5, int r6, java.lang.String r7, boolean r8, com.baidu.sec.privacy.e.d.a<java.lang.String> r9, java.lang.Object... r10) {
        /*
            r0 = 64
            r1 = 0
            java.lang.String r2 = ""
            if (r6 != r0) goto L12
            boolean r0 = com.baidu.sec.privacy.d.a.b()     // Catch: java.lang.Throwable -> Lf
            if (r0 == 0) goto L12
            r0 = r1
            goto L13
        Lf:
            r5 = move-exception
            goto Lbd
        L12:
            r0 = 1
        L13:
            if (r0 == 0) goto L1c
            boolean r3 = com.baidu.sec.privacy.d.a.b(r6)     // Catch: java.lang.Throwable -> Lf
            if (r3 != 0) goto L1c
            return r2
        L1c:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lf
            r3.<init>()     // Catch: java.lang.Throwable -> Lf
            r3.append(r6)     // Catch: java.lang.Throwable -> Lf
            r3.append(r2)     // Catch: java.lang.Throwable -> Lf
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> Lf
            boolean r4 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Throwable -> Lf
            if (r4 != 0) goto L48
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lf
            r4.<init>()     // Catch: java.lang.Throwable -> Lf
            r4.append(r3)     // Catch: java.lang.Throwable -> Lf
            byte[] r3 = r7.getBytes()     // Catch: java.lang.Throwable -> Lf
            java.lang.String r1 = android.util.Base64.encodeToString(r3, r1)     // Catch: java.lang.Throwable -> Lf
            r4.append(r1)     // Catch: java.lang.Throwable -> Lf
            java.lang.String r3 = r4.toString()     // Catch: java.lang.Throwable -> Lf
        L48:
            boolean r1 = a(r3)     // Catch: java.lang.Throwable -> Lf
            if (r1 != 0) goto L7d
            boolean r1 = com.baidu.sec.privacy.d.a.a(r3)     // Catch: java.lang.Throwable -> Lf
            if (r1 == 0) goto L5f
            java.lang.String r1 = com.baidu.sec.privacy.d.a.a(r3, r2)     // Catch: java.lang.Throwable -> Lf
            boolean r4 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> Lf
            if (r4 != 0) goto L5f
            return r1
        L5f:
            if (r0 == 0) goto L6d
            boolean r6 = b(r5, r6)     // Catch: java.lang.Throwable -> Lf
            if (r6 == 0) goto L68
            goto L6d
        L68:
            java.lang.String r5 = a(r5, r8)     // Catch: java.lang.Throwable -> Lf
            return r5
        L6d:
            java.lang.Object r5 = r9.a(r7, r10)     // Catch: java.lang.Throwable -> Lf
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Throwable -> Lf
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> Lf
            if (r6 != 0) goto L7c
            com.baidu.sec.privacy.d.a.b(r3, r5)     // Catch: java.lang.Throwable -> Lf
        L7c:
            return r5
        L7d:
            if (r0 == 0) goto La1
            boolean r6 = b(r5, r6)     // Catch: java.lang.Throwable -> Lf
            if (r6 == 0) goto L86
            goto La1
        L86:
            boolean r6 = com.baidu.sec.privacy.d.a.a(r3)     // Catch: java.lang.Throwable -> Lf
            if (r6 == 0) goto L9c
            java.lang.String r6 = com.baidu.sec.privacy.d.a.a(r3, r2)     // Catch: java.lang.Throwable -> Lf
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.Throwable -> Lf
            if (r7 == 0) goto L9b
            java.lang.String r5 = a(r5, r8)     // Catch: java.lang.Throwable -> Lf
            return r5
        L9b:
            return r6
        L9c:
            java.lang.String r5 = a(r5, r8)     // Catch: java.lang.Throwable -> Lf
            return r5
        La1:
            java.lang.Object r5 = r9.a(r7, r10)     // Catch: java.lang.Throwable -> Lf
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Throwable -> Lf
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> Lf
            if (r6 == 0) goto Lb9
            boolean r5 = com.baidu.sec.privacy.d.a.a(r3)     // Catch: java.lang.Throwable -> Lf
            if (r5 == 0) goto Lb8
            java.lang.String r5 = com.baidu.sec.privacy.d.a.a(r3, r2)     // Catch: java.lang.Throwable -> Lf
            return r5
        Lb8:
            return r2
        Lb9:
            com.baidu.sec.privacy.d.a.b(r3, r5)     // Catch: java.lang.Throwable -> Lf
            return r5
        Lbd:
            com.baidu.sec.privacy.f.c.a(r5)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sec.privacy.f.f.a(android.content.Context, int, java.lang.String, boolean, com.baidu.sec.privacy.e.d.a, java.lang.Object[]):java.lang.String");
    }

    public static String a(Context context, int i4, boolean z4, com.baidu.sec.privacy.e.d.a<String> aVar, Object... objArr) {
        return a(context, i4, null, z4, aVar, objArr);
    }

    public static boolean a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("la_in");
        return System.currentTimeMillis() - com.baidu.sec.privacy.d.a.a(sb.toString(), 0L) >= 86400000;
    }

    public static String a(Context context, boolean z4) {
        return !z4 ? "" : !c.c(context) ? "-1000" : "-1001";
    }

    public static int a(Context context, int i4, boolean z4) {
        return !z4 ? i4 : !c.c(context) ? ErrorCode.CODE_UNKNOWN_ERROR : ErrorCode.CODE_INNER_ERROR;
    }
}
