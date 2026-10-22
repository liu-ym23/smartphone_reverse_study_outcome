package com.baidu.mshield.utility;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.stepos.activeview.utils.Constants;
import com.stepos.alphame.utils.Consts;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import kotlin.UByte;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static String f8354a;

    public static String a(String str) {
        try {
            String str2 = new String(com.baidu.mshield.b.f.a.a(Base64.decode(str, 10), com.baidu.mshield.b.f.a.a(16)), Constants.UTF_8_CODE);
            return !TextUtils.isEmpty(str2) ? str2 : "";
        } catch (Throwable th) {
            com.baidu.mshield.b.c.a.a(th);
            return "";
        }
    }

    public static synchronized String b(Context context) {
        try {
            if (!TextUtils.isEmpty(f8354a)) {
                return f8354a;
            }
            String strA = a(context, false);
            if (!TextUtils.isEmpty(strA)) {
                f8354a = strA;
                return strA;
            }
            com.baidu.mshield.sharedpreferences.a aVarA = com.baidu.mshield.sharedpreferences.a.a(context);
            String strQ = aVarA.q();
            if (!TextUtils.isEmpty(strQ)) {
                try {
                    String strA2 = a(strQ);
                    if (!TextUtils.isEmpty(strA2)) {
                        f8354a = strA2;
                        return strA2;
                    }
                } catch (Throwable th) {
                    com.baidu.mshield.b.c.a.a(th);
                }
            }
            String strN = aVarA.n();
            if (!TextUtils.isEmpty(strN)) {
                aVarA.i(new String(Base64.encode(com.baidu.mshield.b.f.a.b(strN.getBytes(Constants.UTF_8_CODE), com.baidu.mshield.b.f.a.a(16)), 10), Constants.UTF_8_CODE));
                f8354a = strN;
                return strN;
            }
            String strC = c(context);
            String strE = e(context);
            if (TextUtils.isEmpty(strE)) {
                strE = "0";
            }
            String str = strC + Consts.SPLITTER_DETAIL + new StringBuffer(strE).reverse().toString();
            String str2 = new String(Base64.encode(com.baidu.mshield.b.f.a.b(str.getBytes(Constants.UTF_8_CODE), com.baidu.mshield.b.f.a.a(16)), 10), Constants.UTF_8_CODE);
            String strN2 = aVarA.n();
            if (!TextUtils.isEmpty(strN2)) {
                f8354a = strN2;
                return strN2;
            }
            aVarA.h(str);
            aVarA.i(str2);
            f8354a = str;
            return str;
        } catch (Throwable th2) {
            com.baidu.mshield.b.c.a.a(th2);
            return "";
        }
    }

    public static String c(Context context) {
        String strE;
        String strA = "";
        try {
            strE = e(context);
            try {
                strA = a(context);
            } catch (Throwable th) {
                th = th;
                com.baidu.mshield.b.c.a.a(th);
                return a((strE + strA + UUID.randomUUID().toString()).getBytes(), true);
            }
        } catch (Throwable th2) {
            th = th2;
            strE = "";
        }
        return a((strE + strA + UUID.randomUUID().toString()).getBytes(), true);
    }

    public static String d(Context context) {
        try {
            try {
                if (TextUtils.isEmpty(com.baidu.sec.privacy.e.a.a(context).c("bd_setting_i", true))) {
                    e(context);
                }
                TextUtils.isEmpty(e(context));
                return "";
            } catch (Throwable th) {
                com.baidu.mshield.b.c.a.a(th);
                return "";
            }
        } catch (Exception unused) {
            return "";
        }
    }

    @SuppressLint({"MissingPermission"})
    public static String e(Context context) {
        return "";
    }

    public static String f(Context context) {
        return "";
    }

    public static String g(Context context) {
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            if (displayMetrics.widthPixels < displayMetrics.heightPixels) {
                return displayMetrics.widthPixels + "*" + displayMetrics.heightPixels;
            }
            return displayMetrics.heightPixels + "*" + displayMetrics.widthPixels;
        } catch (Throwable th) {
            com.baidu.mshield.b.c.a.a(th);
            return "";
        }
    }

    public static String h(Context context) {
        try {
            String strF = com.baidu.mshield.sharedpreferences.a.a(context).f();
            return !TextUtils.isEmpty(strF) ? strF : "";
        } catch (Throwable th) {
            com.baidu.mshield.b.c.a.a(th);
            return "";
        }
    }

    public static String i(Context context) {
        try {
            if (TextUtils.isEmpty(com.baidu.mshield.b.e.a.d(context, "bd_setting_i"))) {
                e(context);
            }
            TextUtils.isEmpty(e(context));
        } catch (Throwable unused) {
        }
        return "";
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0035 A[Catch: all -> 0x0085, TryCatch #1 {all -> 0x0085, blocks: (B:3:0x0004, B:15:0x0025, B:17:0x0035, B:20:0x0057, B:23:0x0063, B:14:0x0022), top: B:28:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0056 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0057 A[Catch: all -> 0x0085, TRY_LEAVE, TryCatch #1 {all -> 0x0085, blocks: (B:3:0x0004, B:15:0x0025, B:17:0x0035, B:20:0x0057, B:23:0x0063, B:14:0x0022), top: B:28:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String j(android.content.Context r7) {
        /*
            java.lang.String r0 = "com.baidu"
            java.lang.String r1 = ""
            java.lang.String r2 = a(r7)     // Catch: java.lang.Throwable -> L85
            r3 = 1
            com.baidu.sec.privacy.e.a r4 = com.baidu.sec.privacy.e.a.a(r7)     // Catch: java.lang.Throwable -> L20
            java.lang.String r5 = "bd_setting_i"
            java.lang.String r4 = r4.c(r5, r3)     // Catch: java.lang.Throwable -> L20
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L1e
            if (r5 == 0) goto L25
            java.lang.String r4 = e(r7)     // Catch: java.lang.Throwable -> L1e
            goto L25
        L1e:
            r5 = move-exception
            goto L22
        L20:
            r5 = move-exception
            r4 = r1
        L22:
            com.baidu.mshield.b.c.a.a(r5)     // Catch: java.lang.Throwable -> L85
        L25:
            com.baidu.sec.privacy.e.a r5 = com.baidu.sec.privacy.e.a.a(r7)     // Catch: java.lang.Throwable -> L85
            java.lang.String r6 = "com.baidu.deviceid"
            java.lang.String r5 = r5.c(r6, r3)     // Catch: java.lang.Throwable -> L85
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L85
            if (r6 == 0) goto L54
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L85
            r5.<init>(r0)     // Catch: java.lang.Throwable -> L85
            r5.append(r4)     // Catch: java.lang.Throwable -> L85
            r5.append(r2)     // Catch: java.lang.Throwable -> L85
            java.lang.String r0 = r5.toString()     // Catch: java.lang.Throwable -> L85
            byte[] r0 = r0.getBytes()     // Catch: java.lang.Throwable -> L85
            java.lang.String r0 = a(r0, r3)     // Catch: java.lang.Throwable -> L85
            com.baidu.sec.privacy.e.a r2 = com.baidu.sec.privacy.e.a.a(r7)     // Catch: java.lang.Throwable -> L85
            java.lang.String r5 = r2.c(r0, r3)     // Catch: java.lang.Throwable -> L85
        L54:
            if (r5 != 0) goto L57
            return r1
        L57:
            java.lang.String r7 = e(r7)     // Catch: java.lang.Throwable -> L85
            boolean r0 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Throwable -> L85
            if (r0 == 0) goto L63
            java.lang.String r7 = "0"
        L63:
            java.lang.StringBuffer r0 = new java.lang.StringBuffer     // Catch: java.lang.Throwable -> L85
            r0.<init>(r7)     // Catch: java.lang.Throwable -> L85
            java.lang.StringBuffer r7 = r0.reverse()     // Catch: java.lang.Throwable -> L85
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L85
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L85
            r0.<init>()     // Catch: java.lang.Throwable -> L85
            r0.append(r5)     // Catch: java.lang.Throwable -> L85
            java.lang.String r2 = "|"
            r0.append(r2)     // Catch: java.lang.Throwable -> L85
            r0.append(r7)     // Catch: java.lang.Throwable -> L85
            java.lang.String r7 = r0.toString()     // Catch: java.lang.Throwable -> L85
            return r7
        L85:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mshield.utility.c.j(android.content.Context):java.lang.String");
    }

    public static String a(Context context) {
        return com.baidu.mshield.core.a.a("arid");
    }

    public static String a(byte[] bArr, boolean z4) throws NoSuchAlgorithmException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(bArr);
            return a(messageDigest.digest(), "", z4);
        } catch (NoSuchAlgorithmException e4) {
            com.baidu.mshield.b.c.a.a(e4);
            return null;
        }
    }

    public static String a(byte[] bArr, String str, boolean z4) {
        StringBuilder sb = new StringBuilder();
        for (byte b4 : bArr) {
            String hexString = Integer.toHexString(b4 & UByte.MAX_VALUE);
            if (z4) {
                hexString = hexString.toUpperCase();
            }
            if (hexString.length() == 1) {
                sb.append("0");
            }
            sb.append(hexString);
            sb.append(str);
        }
        return sb.toString();
    }

    public static String a() {
        return Build.DISPLAY;
    }

    public static String a(Context context, boolean z4) {
        try {
            Bundle bundleA = g.a(context, "getRemoteZid", null, z4, null, false);
            if (bundleA == null) {
                return "";
            }
            String string = bundleA.getString("_zid");
            return !TextUtils.isEmpty(string) ? string : "";
        } catch (Throwable th) {
            a.a(th);
            return "";
        }
    }
}
