package com.baidu.mshield.x6.f;

import android.content.Context;
import android.nfc.NfcManager;
import android.text.TextUtils;
import android.util.Base64;
import ch.qos.logback.classic.net.SyslogAppender;
import ch.qos.logback.core.pattern.color.ANSIConstants;
import com.baidu.mshield.MH;
import com.baidu.mshield.x6.EngineImpl;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.UnknownHostException;
import java.util.Calendar;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class f {
    public static String a() {
        String str = EngineImpl.sAppkey;
        return str != null ? str : "";
    }

    public static String b() {
        String str = EngineImpl.sSecKey;
        return str != null ? str : "";
    }

    public static String c() {
        try {
            Calendar calendar = Calendar.getInstance();
            return calendar.get(1) + "" + calendar.get(2) + "" + calendar.get(5);
        } catch (Throwable th) {
            b(th);
            return "";
        }
    }

    public static String d(Context context) {
        try {
            return a(context, false) ? new com.baidu.mshield.x6.b.b(context).g() : l.f8522e;
        } catch (Throwable th) {
            b(th);
            return "";
        }
    }

    public static String e(Context context) {
        try {
            return MH.getVersion(context);
        } catch (Throwable th) {
            b(th);
            return "";
        }
    }

    public static String f(Context context) {
        try {
            return new String(h.a(Base64.decode(g.f8514b, 0), com.baidu.mshield.b.f.a.a(16)));
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String g(Context context) {
        String strB = "";
        try {
            com.baidu.mshield.x6.b.c cVar = new com.baidu.mshield.x6.b.c(context);
            strB = cVar.b();
            if (TextUtils.isEmpty(strB)) {
                com.baidu.mshield.b.c.a.a("cloud token is empty");
                strB = cVar.e();
            }
            com.baidu.mshield.b.c.a.a("getUserHoldToken : " + strB);
        } catch (Throwable th) {
            b(th);
        }
        return strB;
    }

    public static void h(Context context) {
        try {
            b.c(context);
            com.baidu.mshield.x6.b.b bVar = new com.baidu.mshield.x6.b.b(context);
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jO = bVar.o() * 60000;
            long jK = bVar.K();
            if (!bVar.n() || jCurrentTimeMillis - jK > jO) {
                com.baidu.mshield.x6.e.h.a(context).a(3);
            }
            if (!bVar.f()) {
                j(context);
                bVar.d(true);
            }
            com.baidu.mshield.x6.e.h.a(context).a(1, false);
            if (bVar.a()) {
                return;
            }
            com.baidu.mshield.x6.e.h.a(context).a();
        } catch (Throwable th) {
            b(th);
        }
    }

    public static void i(Context context) {
        try {
            String strA = l.a(context);
            com.baidu.mshield.x6.b.b bVar = new com.baidu.mshield.x6.b.b(context);
            if (TextUtils.isEmpty(strA)) {
                bVar.a(System.currentTimeMillis(), false);
                return;
            }
            JSONObject jSONObject = new JSONObject(strA);
            try {
                String strOptString = jSONObject.optString("sig");
                if (TextUtils.isEmpty(strOptString)) {
                    com.baidu.mshield.b.c.a.a("sig sdata is empty ");
                } else {
                    String strA2 = com.baidu.mshield.b.f.e.a(strOptString);
                    l.f8520c = strA2;
                    bVar.h(strA2);
                    String str = new String(com.baidu.mshield.b.a.c.b(Base64.decode(strOptString.getBytes(), 0)), "utf-8");
                    com.baidu.mshield.b.c.a.a("requestSigPolicy ungzSig : ".concat(str));
                    l.f8518a = str;
                }
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("sgs");
                if (jSONObjectOptJSONObject != null) {
                    String strOptString2 = jSONObjectOptJSONObject.optString("3", "");
                    l.f8519b = strOptString2;
                    com.baidu.mshield.b.c.a.a("requestSgsPolicy : " + strOptString2);
                }
            } catch (Throwable th) {
                b(th);
            }
            try {
                JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("drf");
                if (jSONObjectOptJSONObject2 != null) {
                    l.f8521d = jSONObjectOptJSONObject2.toString();
                    com.baidu.mshield.b.c.a.a("requestSigPolicy ungzDrf : ".concat(new String(com.baidu.mshield.b.a.c.b(Base64.decode(jSONObjectOptJSONObject2.optString("1").getBytes(), 0)), "utf-8")));
                    bVar.g(jSONObjectOptJSONObject2.optString("2"));
                } else {
                    l.f8521d = "";
                }
            } catch (Throwable th2) {
                b(th2);
            }
            bVar.a(System.currentTimeMillis(), true);
            try {
                JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("rmf");
                if (jSONObjectOptJSONObject3 == null) {
                    l.f8522e = "";
                    return;
                }
                if (a(context, false)) {
                    bVar.v(jSONObjectOptJSONObject3.toString());
                    l.f8522e = "";
                } else {
                    l.f8522e = jSONObjectOptJSONObject3.toString();
                    bVar.p();
                }
                com.baidu.mshield.b.c.a.a("requestSigPolicy ungzRmf : ".concat(new String(com.baidu.mshield.b.a.c.b(Base64.decode(jSONObjectOptJSONObject3.optString("1").getBytes(), 0)), "utf-8")));
            } catch (Throwable th3) {
                b(th3);
            }
        } catch (Throwable th4) {
            b(th4);
        }
    }

    public static void j(Context context) {
        try {
            String strA = com.baidu.mshield.x6.c.a.a(context);
            String strB = com.baidu.mshield.x6.c.a.b(context);
            com.baidu.mshield.x6.b.b bVar = new com.baidu.mshield.x6.b.b(context);
            if (!TextUtils.isEmpty(strA)) {
                bVar.o(com.baidu.mshield.b.f.e.a(strA));
            }
            if (TextUtils.isEmpty(strB)) {
                return;
            }
            bVar.n(com.baidu.mshield.b.f.e.a(strB));
        } catch (Throwable th) {
            b(th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0078 A[Catch: all -> 0x007f, TRY_ENTER, TryCatch #2 {all -> 0x007f, blocks: (B:11:0x002f, B:13:0x0036, B:15:0x004a, B:17:0x0062, B:20:0x0078, B:30:0x00a8, B:32:0x00b9, B:35:0x00ca, B:37:0x00d3, B:23:0x0081, B:25:0x008b, B:26:0x0096, B:28:0x0099, B:29:0x00a2, B:10:0x002b), top: B:45:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0081 A[Catch: all -> 0x007f, TryCatch #2 {all -> 0x007f, blocks: (B:11:0x002f, B:13:0x0036, B:15:0x004a, B:17:0x0062, B:20:0x0078, B:30:0x00a8, B:32:0x00b9, B:35:0x00ca, B:37:0x00d3, B:23:0x0081, B:25:0x008b, B:26:0x0096, B:28:0x0099, B:29:0x00a2, B:10:0x002b), top: B:45:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static org.json.JSONObject a(android.content.Context r8, org.json.JSONObject r9, java.lang.String r10, java.lang.String r11, boolean r12) {
        /*
            org.json.JSONObject r12 = new org.json.JSONObject
            r12.<init>()
            long r0 = java.lang.System.currentTimeMillis()
            java.lang.String r2 = ""
            r3 = 0
            java.lang.String r4 = r8.getPackageName()     // Catch: java.lang.Throwable -> L29
            android.content.pm.PackageInfo r4 = com.baidu.mshield.b.e.c.a(r8, r4, r3)     // Catch: java.lang.Throwable -> L29
            java.lang.String r4 = r4.versionName     // Catch: java.lang.Throwable -> L29
            android.content.pm.ApplicationInfo r5 = r8.getApplicationInfo()     // Catch: java.lang.Throwable -> L27
            android.content.pm.PackageManager r6 = r8.getPackageManager()     // Catch: java.lang.Throwable -> L27
            java.lang.CharSequence r5 = r5.loadLabel(r6)     // Catch: java.lang.Throwable -> L27
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L27
            goto L2f
        L27:
            r5 = move-exception
            goto L2b
        L29:
            r5 = move-exception
            r4 = r2
        L2b:
            b(r5)     // Catch: java.lang.Throwable -> L7f
            r5 = r2
        L2f:
            java.lang.String r6 = "1"
            r12.put(r6, r5)     // Catch: java.lang.Throwable -> L7f
            java.lang.String r5 = "2"
            com.baidu.mshield.x6.EngineImpl r6 = com.baidu.mshield.x6.EngineImpl.getInstance(r8)     // Catch: java.lang.Throwable -> L7f
            java.lang.String r7 = "p"
            java.lang.String r6 = r6.getPropertyByType(r7)     // Catch: java.lang.Throwable -> L7f
            r12.put(r5, r6)     // Catch: java.lang.Throwable -> L7f
            java.lang.String r5 = "3"
            r12.put(r5, r4)     // Catch: java.lang.Throwable -> L7f
            java.lang.String r4 = "4"
            java.lang.String r5 = com.baidu.mshield.utility.c.b(r8)     // Catch: java.lang.Throwable -> L7f
            r12.put(r4, r5)     // Catch: java.lang.Throwable -> L7f
            java.lang.String r4 = "5"
            r12.put(r4, r10)     // Catch: java.lang.Throwable -> L7f
            java.lang.String r10 = "6"
            r12.put(r10, r0)     // Catch: java.lang.Throwable -> L7f
            java.lang.String r10 = "7"
            r12.put(r10, r2)     // Catch: java.lang.Throwable -> L7f
            java.lang.String r10 = "8"
            java.lang.String r0 = a()     // Catch: java.lang.Throwable -> L7f
            r12.put(r10, r0)     // Catch: java.lang.Throwable -> L7f
            java.lang.String r10 = com.baidu.mshield.x6.EngineImpl.sLoadVersion     // Catch: java.lang.Throwable -> L7f
            boolean r0 = android.text.TextUtils.isEmpty(r10)     // Catch: java.lang.Throwable -> L7f
            java.lang.String r1 = "0"
            r4 = 1
            java.lang.String r5 = "10"
            java.lang.String r6 = "9"
            if (r0 == 0) goto L81
            r12.put(r6, r11)     // Catch: java.lang.Throwable -> L7f
            r12.put(r5, r1)     // Catch: java.lang.Throwable -> L7f
            goto La8
        L7f:
            r8 = move-exception
            goto Le0
        L81:
            java.lang.String r0 = "/"
            java.lang.String[] r10 = r10.split(r0)     // Catch: java.lang.Throwable -> L7f
            int r0 = r10.length     // Catch: java.lang.Throwable -> L7f
            r7 = 2
            if (r0 != r7) goto L96
            r11 = r10[r3]     // Catch: java.lang.Throwable -> L7f
            r12.put(r6, r11)     // Catch: java.lang.Throwable -> L7f
            r10 = r10[r4]     // Catch: java.lang.Throwable -> L7f
            r12.put(r5, r10)     // Catch: java.lang.Throwable -> L7f
            goto La8
        L96:
            int r0 = r10.length     // Catch: java.lang.Throwable -> L7f
            if (r0 != r4) goto La2
            r12.put(r6, r11)     // Catch: java.lang.Throwable -> L7f
            r10 = r10[r3]     // Catch: java.lang.Throwable -> L7f
            r12.put(r5, r10)     // Catch: java.lang.Throwable -> L7f
            goto La8
        La2:
            r12.put(r6, r11)     // Catch: java.lang.Throwable -> L7f
            r12.put(r5, r1)     // Catch: java.lang.Throwable -> L7f
        La8:
            java.lang.String r10 = "11"
            r12.put(r10, r2)     // Catch: java.lang.Throwable -> L7f
            java.lang.String r10 = "12"
            r12.put(r10, r2)     // Catch: java.lang.Throwable -> L7f
            java.lang.String r10 = "13"
            r12.put(r10, r4)     // Catch: java.lang.Throwable -> L7f
            java.lang.String r10 = "14"
            com.baidu.mshield.x6.EngineImpl r11 = com.baidu.mshield.x6.EngineImpl.getInstance(r8)     // Catch: java.lang.Throwable -> L7f
            java.lang.String r0 = "ws"
            java.lang.String r11 = r11.getPropertyByType(r0)     // Catch: java.lang.Throwable -> L7f
            r12.put(r10, r11)     // Catch: java.lang.Throwable -> L7f
            if (r9 == 0) goto Le3
            java.lang.String r10 = "989"
            java.lang.String r8 = e(r8)     // Catch: java.lang.Throwable -> L7f
            r9.put(r10, r8)     // Catch: java.lang.Throwable -> L7f
            java.lang.String r8 = "module_section"
            org.json.JSONArray r10 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L7f
            r10.<init>()     // Catch: java.lang.Throwable -> L7f
            org.json.JSONArray r9 = r10.put(r9)     // Catch: java.lang.Throwable -> L7f
            r12.put(r8, r9)     // Catch: java.lang.Throwable -> L7f
            goto Le3
        Le0:
            b(r8)
        Le3:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mshield.x6.f.f.a(android.content.Context, org.json.JSONObject, java.lang.String, java.lang.String, boolean):org.json.JSONObject");
    }

    public static void b(Throwable th) {
        com.baidu.mshield.b.c.a.a(th);
    }

    public static String b(Context context) {
        if (!TextUtils.isEmpty(l.f8521d)) {
            return l.f8521d;
        }
        i(context);
        return l.f8521d;
    }

    public static String e() {
        return l.f8519b;
    }

    public static String d() {
        return l.f8520c;
    }

    public static String b(String str) {
        try {
            return TextUtils.isEmpty(str) ? "" : Base64.encodeToString(com.baidu.mshield.b.f.a.b(str.getBytes(), com.baidu.mshield.b.f.a.a()), 0);
        } catch (Throwable th) {
            b(th);
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x005d A[Catch: all -> 0x0020, TryCatch #0 {all -> 0x0020, blocks: (B:7:0x0009, B:8:0x0012, B:11:0x0019, B:41:0x0062, B:14:0x0023, B:33:0x0053, B:34:0x0055, B:35:0x0057, B:36:0x0059, B:37:0x005b, B:38:0x005d, B:39:0x005f, B:40:0x0061, B:42:0x0065), top: B:48:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int c(java.lang.String r6) {
        /*
            r0 = -1
            if (r6 == 0) goto L86
            java.lang.String r1 = ""
            if (r6 != r1) goto L9
            goto L86
        L9:
            java.lang.String r1 = r6.trim()     // Catch: java.lang.Throwable -> L20
            char[] r1 = r1.toCharArray()     // Catch: java.lang.Throwable -> L20
            r2 = 0
        L12:
            int r3 = r1.length     // Catch: java.lang.Throwable -> L20
            int r3 = r3 + (-1)
            if (r2 >= r3) goto L65
            if (r2 != 0) goto L23
            char r3 = r1[r2]     // Catch: java.lang.Throwable -> L20
            int r0 = java.lang.Character.getNumericValue(r3)     // Catch: java.lang.Throwable -> L20
            goto L62
        L20:
            r6 = move-exception
            goto L82
        L23:
            char r3 = r1[r2]     // Catch: java.lang.Throwable -> L20
            int r2 = r2 + 1
            char r4 = r1[r2]     // Catch: java.lang.Throwable -> L20
            int r4 = java.lang.Character.getNumericValue(r4)     // Catch: java.lang.Throwable -> L20
            r5 = 37
            if (r3 == r5) goto L61
            r5 = 38
            if (r3 == r5) goto L5f
            r5 = 42
            if (r3 == r5) goto L5d
            r5 = 43
            if (r3 == r5) goto L5b
            r5 = 45
            if (r3 == r5) goto L59
            r5 = 47
            if (r3 == r5) goto L57
            r5 = 94
            if (r3 == r5) goto L55
            r5 = 120(0x78, float:1.68E-43)
            if (r3 == r5) goto L5d
            r5 = 124(0x7c, float:1.74E-43)
            if (r3 == r5) goto L53
            r0 = r4
            goto L62
        L53:
            r0 = r0 | r4
            goto L62
        L55:
            r0 = r0 ^ r4
            goto L62
        L57:
            int r0 = r0 / r4
            goto L62
        L59:
            int r0 = r0 - r4
            goto L62
        L5b:
            int r0 = r0 + r4
            goto L62
        L5d:
            int r0 = r0 * r4
            goto L62
        L5f:
            r0 = r0 & r4
            goto L62
        L61:
            int r0 = r0 % r4
        L62:
            int r2 = r2 + 1
            goto L12
        L65:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L20
            r1.<init>()     // Catch: java.lang.Throwable -> L20
            java.lang.String r2 = "illegalArithmetic expr："
            r1.append(r2)     // Catch: java.lang.Throwable -> L20
            r1.append(r6)     // Catch: java.lang.Throwable -> L20
            java.lang.String r6 = "，res："
            r1.append(r6)     // Catch: java.lang.Throwable -> L20
            r1.append(r0)     // Catch: java.lang.Throwable -> L20
            java.lang.String r6 = r1.toString()     // Catch: java.lang.Throwable -> L20
            com.baidu.mshield.b.c.a.a(r6)     // Catch: java.lang.Throwable -> L20
            goto L85
        L82:
            b(r6)
        L85:
            return r0
        L86:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "illegalArithmetic expr is empty : "
            r1.<init>(r2)
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            com.baidu.mshield.b.c.a.a(r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mshield.x6.f.f.c(java.lang.String):int");
    }

    public static String c(Context context) {
        try {
        } catch (Throwable th) {
            b(th);
        }
        if (!TextUtils.isEmpty(l.f8518a)) {
            return l.f8518a;
        }
        i(context);
        return l.f8518a;
    }

    public static JSONObject a(Context context, JSONObject jSONObject, String str, boolean z4) {
        return a(context, jSONObject, str, "mshield_x6", z4);
    }

    public static String a(String str, String str2, long j4) throws UnsupportedEncodingException {
        return com.baidu.mshield.b.f.e.a(str + j4 + str2);
    }

    public static boolean a(Context context, String str, boolean z4) {
        try {
            String strA = new com.baidu.mshield.x6.b.a(context).a(str);
            if (!TextUtils.isEmpty(strA)) {
                return new JSONObject(strA).optInt("1") == 1;
            }
        } catch (Throwable th) {
            b(th);
        }
        return z4;
    }

    public static String a(Throwable th) {
        if (th == null) {
            return "";
        }
        for (Throwable cause = th; cause != null; cause = cause.getCause()) {
            try {
                if (cause instanceof UnknownHostException) {
                    return "";
                }
            } catch (Throwable th2) {
                b(th2);
                return "";
            }
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        String string = stringWriter.toString();
        printWriter.close();
        return string.replaceAll(SyslogAppender.DEFAULT_STACKTRACE_PATTERN, ";").replaceAll("\n", ";");
    }

    public static boolean a(Context context) {
        try {
            return ((NfcManager) context.getSystemService("nfc")).getDefaultAdapter() != null;
        } catch (Throwable th) {
            b(th);
            return false;
        }
    }

    public static boolean a(Context context, boolean z4) {
        try {
            String strA = a(context, "plc104");
            if (!TextUtils.isEmpty(strA)) {
                JSONObject jSONObject = new JSONObject(strA).getJSONObject("5");
                if (jSONObject.has(ANSIConstants.BLUE_FG)) {
                    return jSONObject.optInt(ANSIConstants.BLUE_FG) == 1;
                }
            }
        } catch (Throwable th) {
            b(th);
        }
        return z4;
    }

    public static String a(Context context, String str) {
        try {
            return new com.baidu.mshield.x6.b.a(context).a(str);
        } catch (Throwable th) {
            b(th);
            return "";
        }
    }

    public static String a(String str) {
        try {
            return TextUtils.isEmpty(str) ? "" : new String(com.baidu.mshield.b.f.a.a(Base64.decode(str, 0), com.baidu.mshield.b.f.a.a()));
        } catch (Throwable th) {
            b(th);
            return "";
        }
    }
}
