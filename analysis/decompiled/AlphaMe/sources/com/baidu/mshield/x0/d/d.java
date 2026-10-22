package com.baidu.mshield.x0.d;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Base64;
import ch.qos.logback.classic.net.SyslogAppender;
import com.baidu.mshield.rp.Report;
import com.baidu.mshield.x0.EngineImpl;
import com.baidu.mshield.x6.f.k;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static String f8386a = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f8387b = {"L3N5c3RlbS94YmluL3N1", "L3N5c3RlbS9iaW4vc3U", "L3N5c3RlbS94YmluLy5zdQ==", "L3N5c3RlbS9iaW4vLnN1", "L3N5c3RlbS9iaW4vLnN1dg==", "L3N5c3RlbS94YmluLy5zdXY=", "L3N5c3RlbS94YmluL2Jkc3U=", "L3N5c3RlbS9iaW4vYmRzdQ==", "L3N5c3RlbS94YmluL2F1", "L3N5c3RlbS9iaW4vYXU=", "L3N5c3RlbS94YmluL2t1LnN1ZA==", "L3N5c3RlbS9iaW4va3Uuc3Vk", "L3N5c3RlbS9iaW4vLnJncw==", "L3N5c3RlbS94YmluLy5yZ3M=", "L3NiaW4vc3U="};

    /* renamed from: c, reason: collision with root package name */
    public static boolean f8388c = false;

    public static class a extends com.baidu.mshield.x0.d.h.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f8389b;

        public a(Context context) {
            this.f8389b = context;
        }

        @Override // com.baidu.mshield.x0.d.h.b
        public void a() {
            boolean unused = d.f8388c = true;
            d.p(this.f8389b);
            boolean unused2 = d.f8388c = false;
        }
    }

    public static class b implements com.baidu.mshield.x0.e.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f8390a;

        public b(Context context) {
            this.f8390a = context;
        }

        @Override // com.baidu.mshield.x0.e.b
        public boolean a() {
            return true;
        }

        @Override // com.baidu.mshield.x0.e.b
        public void a(String str) {
            try {
                if (str.contains("mshield")) {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", "mshield");
                    jSONObject.put("1", str.replaceAll(SyslogAppender.DEFAULT_STACKTRACE_PATTERN, ";").replaceAll("\n", ";"));
                    jSONArray.put(jSONObject);
                    d.a(this.f8390a, new c(), jSONArray, "1003138");
                }
            } catch (Throwable th) {
                d.a(th);
            }
        }
    }

    public static void b(Context context, JSONArray jSONArray, String str) {
        try {
            c cVar = new c();
            String str2 = EngineImpl.KEY_CUID;
            cVar.f8382c = 0;
            String str3 = com.baidu.mshield.x0.a.f8364a;
            if (jSONArray == null || jSONArray.length() == 0) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("0", Long.toString(System.currentTimeMillis()));
                jSONObject2.put("1", cVar.f8380a);
                jSONObject2.put("2", cVar.f8381b);
                jSONObject2.put("3", String.valueOf(c(context)));
                jSONObject2.put("4", cVar.f8382c);
                jSONObject2.put("5", cVar.f8383d);
                jSONObject2.put("6", cVar.f8384e);
                jSONObject2.put("7", cVar.f8385f);
                jSONObject2.put("8", com.baidu.mshield.x0.a.f8367d);
                jSONObject2.put("9", EngineImpl.sLoadVersion);
                jSONObject2.put("10", str);
                jSONObject.put("Common_section", jSONObject2);
                jSONObject.put("Module_section", jSONArray);
                b(context, jSONObject.toString());
            } catch (Throwable th) {
                a(th);
            }
        } catch (Throwable th2) {
            a(th2);
        }
    }

    public static String c(Context context) {
        try {
            String str = EngineImpl.sAppkey;
            return str != null ? str : "";
        } catch (Throwable th) {
            a(th);
            return "";
        }
    }

    public static byte[] d() {
        char[] cArr = new char[16];
        try {
            char[] charArray = f8386a.toCharArray();
            for (int i4 = 0; i4 < 16; i4++) {
                int iNextInt = new Random().nextInt(62);
                if (iNextInt >= 0 && iNextInt < charArray.length) {
                    cArr[i4] = charArray[iNextInt];
                }
            }
        } catch (Throwable th) {
            a(th);
        }
        return new String(cArr).getBytes();
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0024, code lost:
    
        r0 = r1.trim();
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0057 -> B:62:0x005a). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String e() throws java.io.IOException {
        /*
            java.lang.String r0 = ""
            r1 = 0
            java.lang.Runtime r2 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L42
            java.lang.String r3 = "getprop ro.build.version.security_patch"
            java.lang.Process r2 = r2.exec(r3)     // Catch: java.lang.Throwable -> L42
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L42
            java.io.InputStream r2 = r2.getInputStream()     // Catch: java.lang.Throwable -> L42
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L42
            java.io.LineNumberReader r2 = new java.io.LineNumberReader     // Catch: java.lang.Throwable -> L3d
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L3d
            r1 = r0
        L1c:
            if (r1 == 0) goto L2f
            java.lang.String r1 = r2.readLine()     // Catch: java.lang.Throwable -> L29
            if (r1 == 0) goto L1c
            java.lang.String r0 = r1.trim()     // Catch: java.lang.Throwable -> L29
            goto L2f
        L29:
            r1 = move-exception
            r4 = r2
            r2 = r1
            r1 = r3
            r3 = r4
            goto L44
        L2f:
            r3.close()     // Catch: java.lang.Throwable -> L33
            goto L37
        L33:
            r1 = move-exception
            a(r1)
        L37:
            r2.close()     // Catch: java.io.IOException -> L3b
            goto L5a
        L3b:
            r1 = move-exception
            goto L57
        L3d:
            r2 = move-exception
            r4 = r3
            r3 = r1
            r1 = r4
            goto L44
        L42:
            r2 = move-exception
            r3 = r1
        L44:
            a(r2)     // Catch: java.lang.Throwable -> L5b
            if (r1 == 0) goto L51
            r1.close()     // Catch: java.lang.Throwable -> L4d
            goto L51
        L4d:
            r1 = move-exception
            a(r1)
        L51:
            if (r3 == 0) goto L5a
            r3.close()     // Catch: java.io.IOException -> L3b
            goto L5a
        L57:
            a(r1)
        L5a:
            return r0
        L5b:
            r0 = move-exception
            if (r1 == 0) goto L66
            r1.close()     // Catch: java.lang.Throwable -> L62
            goto L66
        L62:
            r1 = move-exception
            a(r1)
        L66:
            if (r3 == 0) goto L70
            r3.close()     // Catch: java.io.IOException -> L6c
            goto L70
        L6c:
            r1 = move-exception
            a(r1)
        L70:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mshield.x0.d.d.e():java.lang.String");
    }

    public static int f(Context context) {
        try {
            return com.baidu.mshield.b.e.c.a(context, context.getPackageName(), 0).versionCode;
        } catch (Throwable th) {
            a(th);
            return 0;
        }
    }

    public static JSONObject g(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            int i4 = 0;
            int i5 = 0;
            for (String str : f8387b) {
                if (new File(new String(Base64.decode(str, 0))).exists()) {
                    jSONObject.put(Integer.toString(i5), "1");
                } else {
                    jSONObject.put(Integer.toString(i5), "0");
                }
                i5++;
            }
            try {
                File file = new File(new String(Base64.decode("L3NiaW5fb3JpZw==", 0)));
                if (file.exists() && file.isDirectory()) {
                    jSONObject.put(Integer.toString(i5), "0");
                    String[] list = file.list();
                    int length = list.length;
                    while (true) {
                        if (i4 >= length) {
                            break;
                        }
                        String str2 = list[i4];
                        com.baidu.mshield.b.c.a.b(str2 + " exits!!");
                        if (str2.startsWith("su")) {
                            jSONObject.put(Integer.toString(i5), "1");
                            break;
                        }
                        i4++;
                    }
                } else {
                    jSONObject.put(Integer.toString(i5), "0");
                }
            } catch (Throwable th) {
                a(th);
            }
        } catch (Throwable th2) {
            a(th2);
        }
        return jSONObject;
    }

    public static String h(Context context) {
        try {
            File file = new File(context.getFilesDir(), com.baidu.mshield.x0.a.f8364a);
            if (!file.exists()) {
                file.mkdirs();
            }
            return file.getAbsolutePath();
        } catch (Throwable th) {
            a(th);
            return "";
        }
    }

    public static String i(Context context) {
        try {
            return com.baidu.xclient.gdid.a.c(context);
        } catch (Throwable th) {
            a(th);
            return "";
        }
    }

    public static String j(Context context) {
        try {
            return Long.toString(com.baidu.mshield.b.e.c.a(context, context.getPackageName(), 0).firstInstallTime);
        } catch (Throwable th) {
            a(th);
            return "";
        }
    }

    public static String k(Context context) {
        return "4.2.6";
    }

    public static String l(Context context) {
        try {
            return new String(com.baidu.mshield.b.f.d.a(Base64.decode(com.baidu.mshield.x0.a.f8365b, 0), com.baidu.mshield.b.f.a.a(16)));
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void m(Context context) {
        com.baidu.mshield.x0.e.a.a().a(new b(context));
    }

    public static boolean n(Context context) {
        try {
            if (!k.a(context, new String[]{"android.permission.ACCESS_NETWORK_STATE"})) {
                return true;
            }
            NetworkInfo networkInfoA = com.baidu.mshield.b.e.b.a(context);
            if (networkInfoA == null) {
                return false;
            }
            return networkInfoA.isConnected();
        } catch (Throwable th) {
            a(th);
            return false;
        }
    }

    public static boolean o(Context context) {
        try {
            return com.baidu.mshield.b.e.a.b(context, "adb_enabled") > 0;
        } catch (Throwable th) {
            a(th);
            return false;
        }
    }

    public static void p(Context context) {
        try {
            com.baidu.mshield.x0.l.a aVar = new com.baidu.mshield.x0.l.a(context);
            List<com.baidu.mshield.x0.l.b> listE = aVar.e();
            if (listE == null) {
                return;
            }
            com.baidu.mshield.b.c.a.b("re_con==" + listE.size());
            for (com.baidu.mshield.x0.l.b bVar : listE) {
                if (a(context, aVar.a(), bVar.f8442b)) {
                    a(context, bVar);
                }
            }
        } catch (Throwable th) {
            a(th);
        }
    }

    public static void q(Context context) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        String strA = "";
        com.baidu.mshield.b.c.a.b("setAliveDate begin");
        try {
            PackageInfo packageInfoA = com.baidu.mshield.b.e.c.a(context, context.getPackageName(), 16384);
            int i4 = packageInfoA.applicationInfo.flags;
            i = ((i4 & 1) == 1 || (i4 & 128) == 128) ? 1 : 0;
            try {
                strA = com.baidu.mshield.b.f.e.a(new File(packageInfoA.applicationInfo.sourceDir));
            } catch (Throwable unused) {
            }
        } catch (Throwable th) {
            a(th);
        }
        try {
            jSONObject2.put("0", "0");
            jSONObject2.put("15", Integer.toString(i));
            jSONObject2.put("14", j(context));
            jSONObject2.put("16", e());
            jSONObject2.put("17", strA);
            jSONObject2.put("18", e(context));
            jSONObject2.put("19", f(context));
            jSONObject2.put("990", com.baidu.xclient.gdid.a.d(context));
            jSONObject2.put("989", k(context));
            jSONObject2.put("993", e.a(context));
            jSONObject2.put("995", g.b(context));
            if (a(context, "plc31", true)) {
                jSONObject2.put("997", i(context));
            }
            jSONObject2.put("998", e.b(context));
            jSONObject2.put("999", TextUtils.isEmpty(com.baidu.mshield.utility.c.j(context)) ? com.baidu.mshield.utility.c.i(context) : com.baidu.mshield.utility.c.j(context));
            jSONObject2.put("981", new com.baidu.mshield.x0.l.c(context).a());
            jSONObject.put("0", new JSONObject().put("1001003", jSONObject2));
            com.baidu.mshield.b.c.a.b("setAliveDate begin to report" + jSONObject.toString());
            c(context, jSONObject.toString());
        } catch (Throwable th2) {
            a(th2);
        }
    }

    public static String a(long j4, String str) {
        if (j4 >= 0) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    return new SimpleDateFormat(str).format(new Date(j4));
                }
            } catch (Throwable th) {
                a(th);
            }
        }
        return "";
    }

    public static void c(Context context, String str) {
        try {
            Report.getInstance(context).w(str);
        } catch (Throwable th) {
            a(th);
        }
    }

    public static String f() {
        try {
            return new String(com.baidu.mshield.b.f.d.a(Base64.decode(f.f8392b, 2), com.baidu.mshield.b.f.a.a(16)));
        } catch (Throwable th) {
            a(th);
            return "";
        }
    }

    public static String c() {
        try {
            return UUID.randomUUID().toString();
        } catch (Throwable th) {
            a(th);
            return "";
        }
    }

    public static void a(Throwable th) {
        com.baidu.mshield.b.c.a.a(th);
    }

    public static String d(Context context) {
        try {
            String str = EngineImpl.sSecKey;
            return str != null ? str : "";
        } catch (Throwable th) {
            a(th);
            return "";
        }
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5) {
        try {
            Report.getInstance(context).i(str, str2, str3, str4, str5);
        } catch (Throwable th) {
            a(th);
        }
    }

    public static String a(String str, String str2, long j4) {
        try {
            return com.baidu.mshield.b.f.e.a(str + j4 + str2);
        } catch (Throwable th) {
            a(th);
            return null;
        }
    }

    public static boolean a(Context context, String str, boolean z4) {
        try {
            String strC = new com.baidu.mshield.x0.l.a(context).c(str);
            if (!TextUtils.isEmpty(strC)) {
                return new JSONObject(strC).optInt("1") == 1;
            }
        } catch (Throwable th) {
            a(th);
        }
        return z4;
    }

    public static String e(Context context) {
        return com.baidu.mshield.b.a.d.a(context);
    }

    public static boolean a(Context context, String str, boolean z4, com.baidu.mshield.x0.l.a aVar) {
        if (aVar == null) {
            try {
                aVar = new com.baidu.mshield.x0.l.a(context);
            } catch (Throwable th) {
                a(th);
            }
        }
        String strC = aVar.c(str);
        if (!TextUtils.isEmpty(strC)) {
            return new JSONObject(strC).optInt("1") == 1;
        }
        return z4;
    }

    public static void b(Context context, String str) {
        try {
            Report.getInstance(context).sr(str);
        } catch (Throwable th) {
            a(th);
        }
    }

    public static void a(Context context, String str, c cVar, com.baidu.mshield.x0.l.a aVar) {
        if (cVar == null) {
            return;
        }
        if (aVar == null) {
            try {
                aVar = new com.baidu.mshield.x0.l.a(context);
            } catch (Throwable th) {
                a(th);
                return;
            }
        }
        String strC = aVar.c(str);
        if (TextUtils.isEmpty(strC)) {
            return;
        }
        JSONObject jSONObject = new JSONObject(strC);
        cVar.f8384e = jSONObject.optInt("2");
        cVar.f8383d = jSONObject.optInt("3");
        cVar.f8385f = jSONObject.optInt("4");
    }

    public static void b(Context context) {
        try {
            synchronized (d.class) {
                try {
                    if (f8388c) {
                        return;
                    }
                    com.baidu.mshield.x0.d.h.d.b().a(new a(context));
                } finally {
                }
            }
        } catch (Throwable th) {
            a(th);
        }
    }

    public static String b() {
        try {
            Calendar calendar = Calendar.getInstance();
            return calendar.get(1) + "" + calendar.get(2) + "" + calendar.get(5);
        } catch (Throwable th) {
            a(th);
            return "";
        }
    }

    public static void a(Context context, JSONArray jSONArray, String str) {
        try {
            c cVar = new c();
            String str2 = EngineImpl.KEY_CUID;
            cVar.f8382c = 0;
            String str3 = com.baidu.mshield.x0.a.f8364a;
            a(context, cVar, jSONArray, str, true);
        } catch (Throwable th) {
            a(th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x0097 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static org.json.JSONObject b(android.content.Context r11, com.baidu.mshield.x0.l.b r12, java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 303
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mshield.x0.d.d.b(android.content.Context, com.baidu.mshield.x0.l.b, java.lang.String):org.json.JSONObject");
    }

    public static void a(Context context, c cVar, JSONArray jSONArray, String str) {
        a(context, cVar, jSONArray, str, true);
    }

    public static void a(Context context, c cVar, JSONArray jSONArray, String str, boolean z4) {
        if (jSONArray == null || jSONArray.length() == 0 || cVar == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            int length = jSONArray.length();
            for (int i4 = 0; i4 < length; i4++) {
                JSONObject jSONObject3 = jSONArray.getJSONObject(i4);
                jSONObject3.put("991", i(context));
                jSONObject3.put("995", g.b(context));
                jSONObject3.put("998", e.b(context));
                jSONObject3.put("989", k(context));
            }
            jSONObject2.put("0", Long.toString(System.currentTimeMillis()));
            jSONObject2.put("1", cVar.f8380a);
            jSONObject2.put("2", cVar.f8381b);
            jSONObject2.put("3", String.valueOf(c(context)));
            jSONObject2.put("4", cVar.f8382c);
            jSONObject2.put("5", cVar.f8383d);
            jSONObject2.put("6", cVar.f8384e);
            jSONObject2.put("7", cVar.f8385f);
            jSONObject2.put("8", com.baidu.mshield.x0.a.f8367d);
            jSONObject2.put("9", EngineImpl.sLoadVersion);
            jSONObject2.put("10", str);
            jSONObject.put("Common_section", jSONObject2);
            jSONObject.put("Module_section", jSONArray);
            a(context, jSONObject.toString());
        } catch (Throwable th) {
            a(th);
        }
    }

    public static int a(Context context, String str) {
        try {
            Report.getInstance(context).s(str);
            return 0;
        } catch (Throwable th) {
            a(th);
            return 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static org.json.JSONObject a(android.content.Context r12, java.lang.String r13, org.json.JSONArray r14) {
        /*
            java.lang.String r0 = ""
            java.lang.String r1 = " "
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> La8
            java.lang.String r5 = c(r12)     // Catch: java.lang.Throwable -> La8
            java.lang.String r6 = com.baidu.mshield.x0.a.f8367d     // Catch: java.lang.Throwable -> La8
            java.lang.String r7 = com.baidu.mshield.x0.EngineImpl.sLoadVersion     // Catch: java.lang.Throwable -> La8
            r8 = 0
            java.lang.String r9 = r12.getPackageName()     // Catch: java.lang.Throwable -> L33
            android.content.pm.PackageInfo r9 = com.baidu.mshield.b.e.c.a(r12, r9, r8)     // Catch: java.lang.Throwable -> L33
            java.lang.String r9 = r9.versionName     // Catch: java.lang.Throwable -> L33
            android.content.pm.ApplicationInfo r10 = r12.getApplicationInfo()     // Catch: java.lang.Throwable -> L31
            android.content.pm.PackageManager r11 = r12.getPackageManager()     // Catch: java.lang.Throwable -> L31
            java.lang.CharSequence r10 = r10.loadLabel(r11)     // Catch: java.lang.Throwable -> L31
            java.lang.String r0 = r10.toString()     // Catch: java.lang.Throwable -> L31
            goto L38
        L31:
            r10 = move-exception
            goto L35
        L33:
            r10 = move-exception
            r9 = r0
        L35:
            a(r10)     // Catch: java.lang.Throwable -> La8
        L38:
            java.lang.String r10 = "1"
            r2.put(r10, r0)     // Catch: java.lang.Throwable -> La8
            java.lang.String r0 = "2"
            com.baidu.mshield.x0.EngineImpl r10 = com.baidu.mshield.x0.EngineImpl.getInstance(r12)     // Catch: java.lang.Throwable -> La8
            java.lang.String r11 = "p"
            java.lang.String r10 = r10.getPropertyByType(r11)     // Catch: java.lang.Throwable -> La8
            r2.put(r0, r10)     // Catch: java.lang.Throwable -> La8
            java.lang.String r0 = "3"
            r2.put(r0, r9)     // Catch: java.lang.Throwable -> La8
            java.lang.String r0 = "4"
            java.lang.String r9 = com.baidu.mshield.utility.c.b(r12)     // Catch: java.lang.Throwable -> La8
            r2.put(r0, r9)     // Catch: java.lang.Throwable -> La8
            java.lang.String r0 = "5"
            r2.put(r0, r13)     // Catch: java.lang.Throwable -> La8
            java.lang.String r13 = "6"
            r2.put(r13, r3)     // Catch: java.lang.Throwable -> La8
            java.lang.String r13 = "7"
            r2.put(r13, r1)     // Catch: java.lang.Throwable -> La8
            java.lang.String r13 = "8"
            r2.put(r13, r5)     // Catch: java.lang.Throwable -> La8
            java.lang.String r13 = "9"
            r2.put(r13, r6)     // Catch: java.lang.Throwable -> La8
            java.lang.String r13 = "10"
            r2.put(r13, r7)     // Catch: java.lang.Throwable -> La8
            java.lang.String r13 = "11"
            r2.put(r13, r1)     // Catch: java.lang.Throwable -> La8
            java.lang.String r13 = "12"
            r2.put(r13, r1)     // Catch: java.lang.Throwable -> La8
            java.lang.String r13 = "13"
            r2.put(r13, r1)     // Catch: java.lang.Throwable -> La8
            java.lang.String r13 = "14"
            com.baidu.mshield.x0.EngineImpl r0 = com.baidu.mshield.x0.EngineImpl.getInstance(r12)     // Catch: java.lang.Throwable -> La8
            java.lang.String r1 = "ws"
            java.lang.String r0 = r0.getPropertyByType(r1)     // Catch: java.lang.Throwable -> La8
            r2.put(r13, r0)     // Catch: java.lang.Throwable -> La8
            java.lang.String r13 = "plc31"
            boolean r13 = a(r12, r13, r8)     // Catch: java.lang.Throwable -> La8
            if (r13 == 0) goto Laa
            java.lang.String r13 = "997"
            java.lang.String r0 = i(r12)     // Catch: java.lang.Throwable -> La8
            r2.put(r13, r0)     // Catch: java.lang.Throwable -> La8
            goto Laa
        La8:
            r12 = move-exception
            goto Lb9
        Laa:
            java.lang.String r13 = "989"
            java.lang.String r12 = k(r12)     // Catch: java.lang.Throwable -> La8
            r2.put(r13, r12)     // Catch: java.lang.Throwable -> La8
            java.lang.String r12 = "module_section"
            r2.put(r12, r14)     // Catch: java.lang.Throwable -> La8
            goto Lbc
        Lb9:
            a(r12)
        Lbc:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mshield.x0.d.d.a(android.content.Context, java.lang.String, org.json.JSONArray):org.json.JSONObject");
    }

    public static String b(String str) {
        try {
            return TextUtils.isEmpty(str) ? "" : Base64.encodeToString(com.baidu.mshield.b.f.d.b(str.getBytes(), com.baidu.mshield.b.f.a.a(16)), 0);
        } catch (Throwable th) {
            a(th);
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x011c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0106 A[Catch: all -> 0x010e, TryCatch #5 {all -> 0x010e, blocks: (B:20:0x0050, B:22:0x0057, B:24:0x006b, B:26:0x0074, B:28:0x0087, B:30:0x0090, B:32:0x0097, B:34:0x00a3, B:36:0x00ac, B:38:0x00c8, B:40:0x00d1, B:42:0x00da, B:44:0x00e3, B:46:0x00ec, B:48:0x00f5, B:50:0x00fe, B:52:0x0106, B:55:0x0111, B:84:0x01ab, B:87:0x01b3, B:88:0x01bc, B:83:0x01a8, B:19:0x004d, B:57:0x011c, B:59:0x0129, B:61:0x0137, B:64:0x0150, B:67:0x015a, B:69:0x0163, B:71:0x0174, B:73:0x017d, B:75:0x0184, B:77:0x018d, B:79:0x0196, B:81:0x019f, B:72:0x0179), top: B:103:0x004d, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01b3 A[Catch: all -> 0x010e, TRY_ENTER, TryCatch #5 {all -> 0x010e, blocks: (B:20:0x0050, B:22:0x0057, B:24:0x006b, B:26:0x0074, B:28:0x0087, B:30:0x0090, B:32:0x0097, B:34:0x00a3, B:36:0x00ac, B:38:0x00c8, B:40:0x00d1, B:42:0x00da, B:44:0x00e3, B:46:0x00ec, B:48:0x00f5, B:50:0x00fe, B:52:0x0106, B:55:0x0111, B:84:0x01ab, B:87:0x01b3, B:88:0x01bc, B:83:0x01a8, B:19:0x004d, B:57:0x011c, B:59:0x0129, B:61:0x0137, B:64:0x0150, B:67:0x015a, B:69:0x0163, B:71:0x0174, B:73:0x017d, B:75:0x0184, B:77:0x018d, B:79:0x0196, B:81:0x019f, B:72:0x0179), top: B:103:0x004d, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01bc A[Catch: all -> 0x010e, TRY_LEAVE, TryCatch #5 {all -> 0x010e, blocks: (B:20:0x0050, B:22:0x0057, B:24:0x006b, B:26:0x0074, B:28:0x0087, B:30:0x0090, B:32:0x0097, B:34:0x00a3, B:36:0x00ac, B:38:0x00c8, B:40:0x00d1, B:42:0x00da, B:44:0x00e3, B:46:0x00ec, B:48:0x00f5, B:50:0x00fe, B:52:0x0106, B:55:0x0111, B:84:0x01ab, B:87:0x01b3, B:88:0x01bc, B:83:0x01a8, B:19:0x004d, B:57:0x011c, B:59:0x0129, B:61:0x0137, B:64:0x0150, B:67:0x015a, B:69:0x0163, B:71:0x0174, B:73:0x017d, B:75:0x0184, B:77:0x018d, B:79:0x0196, B:81:0x019f, B:72:0x0179), top: B:103:0x004d, inners: #4 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static org.json.JSONArray a(android.content.Context r12, com.baidu.mshield.x0.l.b r13, java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 470
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mshield.x0.d.d.a(android.content.Context, com.baidu.mshield.x0.l.b, java.lang.String):org.json.JSONArray");
    }

    public static boolean a(Context context, String str, String str2) {
        try {
            if (TextUtils.isEmpty(str2)) {
                return false;
            }
            if (str2.equals(context.getPackageName()) || str2.equals(com.baidu.mshield.x0.a.f8364a)) {
                return true;
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                    if (str2.equals(jSONArray.get(i4))) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        } catch (Throwable th) {
            a(th);
            return false;
        }
    }

    public static void a(Context context, com.baidu.mshield.x0.l.b bVar) {
        try {
            com.baidu.mshield.x0.l.a aVar = new com.baidu.mshield.x0.l.a(context);
            String strD = aVar.d(bVar.f8444d);
            String strB = b();
            if (strD.equals(strB)) {
                return;
            }
            String strA = aVar.a(bVar.f8444d);
            if (!new com.baidu.mshield.x0.i.c(context, null).a(a(context, bVar, strA).toString())) {
                b(context, bVar, strA);
            }
            aVar.c(bVar.f8444d, strB);
        } catch (Throwable th) {
            a(th);
        }
    }

    public static String a(String str) {
        try {
            return TextUtils.isEmpty(str) ? "" : new String(com.baidu.mshield.b.f.d.a(Base64.decode(str, 0), com.baidu.mshield.b.f.a.a(16)));
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String a(Context context, com.baidu.mshield.x0.l.a aVar, String str, String str2) {
        if (aVar == null) {
            try {
                aVar = new com.baidu.mshield.x0.l.a(context);
            } catch (Throwable th) {
                a(th);
            }
        }
        String strC = aVar.c(str);
        if (!TextUtils.isEmpty(strC)) {
            JSONObject jSONObject = new JSONObject(strC).getJSONObject("5");
            if (jSONObject.has(str2)) {
                return jSONObject.optString(str2, "");
            }
        }
        return "";
    }

    public static String a() {
        String property = System.getProperty("http.proxyHost");
        return TextUtils.isEmpty(property) ? "" : property;
    }

    public static JSONArray a(JSONArray jSONArray, int i4) {
        JSONArray jSONArray2 = new JSONArray();
        try {
            int length = jSONArray.length();
            for (int i5 = 0; i5 < length; i5++) {
                if (i5 != i4) {
                    jSONArray2.put(jSONArray.get(i5));
                }
            }
        } catch (Throwable th) {
            a(th);
        }
        return jSONArray2;
    }
}
