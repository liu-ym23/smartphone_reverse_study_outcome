package com.amap.api.col.jmsl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import io.ktor.sse.ServerSentEventKt;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* renamed from: com.amap.api.col.jmsl.j0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1567j0 {

    /* renamed from: a, reason: collision with root package name */
    public static String f16669a = "";

    /* renamed from: b, reason: collision with root package name */
    public static String f16670b = "";

    /* renamed from: c, reason: collision with root package name */
    public static String f16671c = "";

    /* renamed from: d, reason: collision with root package name */
    public static String f16672d = "";

    /* renamed from: e, reason: collision with root package name */
    public static String f16673e = null;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f16674f = false;

    /* renamed from: g, reason: collision with root package name */
    public static final C1554g f16675g = new C1554g();

    /* renamed from: h, reason: collision with root package name */
    public static final Set<String> f16676h;

    /* renamed from: com.amap.api.col.jmsl.j0$a */
    public static class a extends AbstractRunnableC1545d2 {

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Context f16677d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f16678e;

        public a(Context context, String str) {
            this.f16677d = context;
            this.f16678e = str;
        }

        @Override // com.amap.api.col.jmsl.AbstractRunnableC1545d2
        public final void runTask() {
            FileOutputStream fileOutputStream;
            try {
                File file = new File(D1.a(this.f16677d, "k.store"));
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                fileOutputStream = new FileOutputStream(file);
                try {
                    fileOutputStream.write(C1604s2.t(this.f16678e));
                    try {
                        fileOutputStream.close();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        C1611u1.b(th, "AI", "stf");
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable th3) {
                                th3.printStackTrace();
                            }
                        }
                    } catch (Throwable th4) {
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable th5) {
                                th5.printStackTrace();
                            }
                        }
                        throw th4;
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                fileOutputStream = null;
            }
        }
    }

    static {
        HashSet hashSet = new HashSet(64);
        f16676h = hashSet;
        hashSet.add("AL");
        hashSet.add("AD");
        hashSet.add("AT");
        hashSet.add("BY");
        hashSet.add("BE");
        hashSet.add("BA");
        hashSet.add("BG");
        hashSet.add("HR");
        hashSet.add("CY");
        hashSet.add("CZ");
        hashSet.add("DK");
        hashSet.add("EE");
        hashSet.add("FI");
        hashSet.add("FR");
        hashSet.add("DE");
        hashSet.add("GR");
        hashSet.add("HU");
        hashSet.add("IS");
        hashSet.add("IE");
        hashSet.add("IT");
        hashSet.add("LV");
        hashSet.add("LI");
        hashSet.add("LT");
        hashSet.add("LU");
        hashSet.add("MT");
        hashSet.add("MD");
        hashSet.add("MC");
        hashSet.add("ME");
        hashSet.add("NL");
        hashSet.add("MK");
        hashSet.add("NO");
        hashSet.add("PL");
        hashSet.add("PT");
        hashSet.add("RO");
        hashSet.add("RU");
        hashSet.add("SM");
        hashSet.add("RS");
        hashSet.add("SK");
        hashSet.add("SI");
        hashSet.add("ES");
        hashSet.add("SE");
        hashSet.add("CH");
        hashSet.add("TR");
        hashSet.add("UA");
        hashSet.add("GB");
        hashSet.add("VA");
    }

    public static String a(Context context) throws PackageManager.NameNotFoundException {
        String str;
        Bundle bundle;
        Throwable th;
        FileInputStream fileInputStream;
        String str2 = f16672d;
        str = "";
        if (str2 == null || str2.equals("")) {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                return f16672d;
            }
            String string = bundle.getString("com.amap.api.v2.apikey");
            f16672d = string;
            if (string == null) {
                File file = new File(D1.a(context, "k.store"));
                if (file.exists()) {
                    try {
                        fileInputStream = new FileInputStream(file);
                        try {
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            String strN = C1604s2.n(bArr);
                            str = strN.length() == 32 ? strN : "";
                            try {
                                fileInputStream.close();
                            } catch (Throwable th2) {
                                th2.printStackTrace();
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            try {
                                C1611u1.b(th, "AI", "gKe");
                                try {
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                } catch (Throwable th4) {
                                    th4.printStackTrace();
                                }
                                f16672d = str;
                                return f16672d;
                            } finally {
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (Throwable th5) {
                                        th5.printStackTrace();
                                    }
                                }
                            }
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        fileInputStream = null;
                    }
                }
                f16672d = str;
            }
        }
        return f16672d;
    }

    public static void b(int i10) {
        f16675g.b(i10);
    }

    public static void c(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f16672d = str;
        if (context != null) {
            V1.h().f(new a(context, str));
        }
    }

    public static void d(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f16672d = str;
    }

    public static void e(String str, int i10) {
        f16675g.c(str, i10);
    }

    public static boolean f() {
        if (f16674f) {
            return true;
        }
        if (i(f16673e)) {
            f16674f = true;
            return true;
        }
        if (!TextUtils.isEmpty(f16673e)) {
            f16674f = false;
            f16673e = null;
            return false;
        }
        if (i(f16670b)) {
            f16674f = true;
            return true;
        }
        if (!TextUtils.isEmpty(f16670b)) {
            f16674f = false;
            f16670b = null;
            return false;
        }
        return true;
    }

    public static String g() {
        return f16675g.a();
    }

    public static String h(Context context) {
        try {
        } catch (Throwable th) {
            C1611u1.b(th, "AI", "gAN");
        }
        if (!"".equals(f16669a)) {
            return f16669a;
        }
        PackageManager packageManager = context.getPackageManager();
        f16669a = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0));
        return f16669a;
    }

    public static boolean i(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        str.toCharArray();
        for (char c10 : str.toCharArray()) {
            if (('A' > c10 || c10 > 'z') && (('0' > c10 || c10 > ':') && c10 != '.')) {
                try {
                    C1541c2.f(C1604s2.l(), str, "errorPackage");
                } catch (Throwable unused) {
                }
                return false;
            }
        }
        return true;
    }

    public static int j() {
        return f16675g.d();
    }

    public static String k(Context context) {
        try {
        } catch (Throwable th) {
            C1611u1.b(th, "AI", "gAV");
        }
        if (!"".equals(f16671c)) {
            return f16671c;
        }
        f16671c = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        String str = f16671c;
        return str == null ? "" : str;
    }

    public static String l(Context context) {
        try {
            return a(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return f16672d;
        }
    }

    public static boolean m() {
        String strA = f16675g.a();
        if (strA == null || strA.isEmpty()) {
            return false;
        }
        return f16676h.contains(strA.toUpperCase());
    }

    public static String n(Context context) {
        try {
            int i10 = C1602s0.f16864a;
            if (context != null) {
                C1602s0.f16866c = context.getApplicationContext();
            }
        } catch (Throwable unused) {
        }
        try {
            return a(context);
        } catch (Throwable th) {
            C1611u1.b(th, "AI", "gKy");
            return f16672d;
        }
    }

    public static boolean o() {
        String strA = f16675g.a();
        return (strA == null || strA.isEmpty() || "ZH".equalsIgnoreCase(strA)) ? false : true;
    }

    public static String p(Context context) {
        String str;
        try {
            str = f16670b;
        } catch (Throwable th) {
            C1611u1.b(th, "AI", "gpck");
        }
        if (str != null && !"".equals(str)) {
            return f16670b;
        }
        String packageName = context.getPackageName();
        f16670b = packageName;
        if (!i(packageName)) {
            f16670b = context.getPackageName();
        }
        return f16670b;
    }

    public static String q(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            byte[] bArrDigest = MessageDigest.getInstance(C1604s2.m("IU0hBMQ")).digest(packageInfo.signatures[0].toByteArray());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b10 : bArrDigest) {
                String upperCase = Integer.toHexString(b10 & 255).toUpperCase(Locale.US);
                if (upperCase.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(upperCase);
                stringBuffer.append(ServerSentEventKt.COLON);
            }
            String strP = packageInfo.packageName;
            if (i(strP)) {
                strP = packageInfo.packageName;
            }
            if (!TextUtils.isEmpty(f16670b)) {
                strP = p(context);
            }
            stringBuffer.append(strP);
            String string = stringBuffer.toString();
            f16673e = string;
            return string;
        } catch (Throwable th) {
            C1611u1.b(th, "AI", "gsp");
            return f16673e;
        }
    }
}
