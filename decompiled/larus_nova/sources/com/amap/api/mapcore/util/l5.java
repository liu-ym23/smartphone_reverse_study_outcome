package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.vivo.libra.CallBack;
import java.security.MessageDigest;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import kotlin.UByte;

/* JADX INFO: loaded from: classes28.dex */
public class l5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f27515a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f27516b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f27517c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f27518d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static String f27519e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static boolean f27520f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final f7 f27521g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Set<String> f27522h = null;

    public static class a extends a9 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f27523b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f27524c;

        @Override // com.amap.api.mapcore.util.a9
        public final void runTask() {
            PolarisFileWrapper r100 = new PolarisFileWrapper(q6.a(this.f27523b, "k.store"));     // Catch: Throwable -> L14
            if (r100.getParentFile().exists() == true) goto L5;
            r100.getParentFile().mkdirs();     // Catch: Throwable -> L14
        L5:
            PolarisFileOutputStreamWrapper r101 = new PolarisFileOutputStreamWrapper(r100);     // Catch: Throwable -> L14
            r101.write(x5.e(this.f27524c));     // Catch: Throwable -> L12
            r101.close();     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            th.printStackTrace();
            return;
        L12:
            Throwable th10 = th;
        L40:
            p6.a(th10, "AI", "stf");     // Catch: Throwable -> L23
            if (r101 == null) goto L42;
            r101.close();     // Catch: Throwable -> L20
            return;
        L20:
            th = move-exception;
            th.printStackTrace();
            return;
        L42:
            return;
        L23:
            th = move-exception;
            if (r101 != null) goto L32;
        L29:
            throw th;
        L32:
            r101.close();     // Catch: Throwable -> L27
        L27:
            th = move-exception;
            th.printStackTrace();
        L14:
            th = move-exception;
            th10 = th;
            r101 = null;
            goto L40
        }

        public a(Context r100, String r101) {
            this.f27523b = r100;
            this.f27524c = r101;
        }
    }

    public static boolean a() {
        if (f27520f == false) goto L7;
        return true;
    L7:
        if (a(f27519e) == false) goto L11;
        f27520f = true;     // Catch: Throwable -> L23
        return true;
    L11:
        if (TextUtils.isEmpty(f27519e) == true) goto L15;
        f27520f = false;     // Catch: Throwable -> L23
        f27519e = null;     // Catch: Throwable -> L23
        return false;
    L15:
        if (a(f27516b) == false) goto L19;
        f27520f = true;     // Catch: Throwable -> L23
        return true;
    L19:
        if (TextUtils.isEmpty(f27516b) == true) goto L22;
        f27520f = false;     // Catch: Throwable -> L23
        f27516b = null;     // Catch: Throwable -> L23
        return false;
    L22:
        return true;
    }

    static {
        f27521g = new f7();
        HashSet r100 = new HashSet(64);
        f27522h = r100;
        r100.add("AL");
        r100.add("AD");
        r100.add("AT");
        r100.add("BY");
        r100.add("BE");
        r100.add("BA");
        r100.add("BG");
        r100.add("HR");
        r100.add("CY");
        r100.add("CZ");
        r100.add("DK");
        r100.add("EE");
        r100.add("FI");
        r100.add("FR");
        r100.add("DE");
        r100.add("GR");
        r100.add("HU");
        r100.add("IS");
        r100.add("IE");
        r100.add("IT");
        r100.add("LV");
        r100.add("LI");
        r100.add("LT");
        r100.add("LU");
        r100.add("MT");
        r100.add("MD");
        r100.add("MC");
        r100.add("ME");
        r100.add("NL");
        r100.add("MK");
        r100.add("NO");
        r100.add("PL");
        r100.add("PT");
        r100.add("RO");
        r100.add("RU");
        r100.add(CallBack.EVENT_SLEEP_MODE);
        r100.add("RS");
        r100.add("SK");
        r100.add("SI");
        r100.add("ES");
        r100.add("SE");
        r100.add("CH");
        r100.add("TR");
        r100.add("UA");
        r100.add("GB");
        r100.add("VA");
    }

    public static String b() {
        return f27521g.a();
    }

    public static int c() {
        return f27521g.b();
    }

    public static boolean d() {
        String r100 = f27521g.a();
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.isEmpty() == false) goto L8;
        return false;
    L8:
        return f27522h.contains(r100.toUpperCase());
    }

    public static boolean e() {
        String r100 = f27521g.a();
        if (r100 != null) goto L5;
    L11:
        return false;
    L5:
        if (r100.isEmpty() == true) goto L11;
        if ("ZH".equalsIgnoreCase(r100) == true) goto L11;
        return true;
    }

    private static String a(Context r100) throws PackageManager.NameNotFoundException {
        String r101 = f27518d;
        String r102 = "";
        if (r101 != null) goto L5;
    L6:
        ApplicationInfo r103 = r100.getPackageManager().getApplicationInfo(r100.getPackageName(), 128);
        if (r103 == null) goto L52;
        Bundle r104 = r103.metaData;
        if (r104 == null) goto L52;
        String r105 = r104.getString("com.amap.api.v2.apikey");
        f27518d = r105;
        if (r105 != null) goto L50;
        PolarisFileWrapper r106 = new PolarisFileWrapper(q6.a(r100, "k.store"));
        if (r106.exists() == true) goto L59;
    L41:
        f27518d = r102;
        goto L50
    L59:
        PolarisFileInputStreamWrapper r107 = new PolarisFileInputStreamWrapper(r106);     // Catch: Throwable -> L27
        byte[] r108 = new byte[r107.available()];     // Catch: Throwable -> L25
        r107.read(r108);     // Catch: Throwable -> L25
        String r109 = x5.c(r108);     // Catch: Throwable -> L25
        if (r109.length() != 32) goto L65;
        r102 = r109;
    L65:
        r107.close();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        th.printStackTrace();
    L25:
        Throwable th10 = th;
    L63:
        p6.a(th10, "AI", "gKe");     // Catch: Throwable -> L42
    L34:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L42
    L36:
        if (r107 == null) goto L41;
        r107.close();     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        th.printStackTrace();
        goto L41
    L31:
        if (r106.exists() == false) goto L36;
        r106.delete();     // Catch: Throwable -> L34
    L42:
        th = move-exception;
        if (r107 != null) goto L53;
    L48:
        throw th;
    L53:
        r107.close();     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        th.printStackTrace();
    L27:
        th = move-exception;
        th10 = th;
        r107 = null;
    L50:
        return f27518d;
    L52:
        return f27518d;
    L5:
        if (r101.equals("") == false) goto L50;
        goto L6
    }

    public static String b(Context r100) {
    L9:
        th = move-exception;
        p6.a(th, "AI", "gAN");
    L12:
        return f27515a;
    L4:
        if ("".equals(f27515a) == false) goto L6;
        PackageManager r101 = r100.getPackageManager();     // Catch: Throwable -> L9
        f27515a = (String) r101.getApplicationLabel(r101.getApplicationInfo(r100.getPackageName(), 0));     // Catch: Throwable -> L9
        goto L12
    L6:
        return f27515a;
    }

    public static String c(Context r100) {
    L9:
        th = move-exception;
        p6.a(th, "AI", "gAV");
    L11:
        String r101 = f27517c;
        if (r101 != null) goto L14;
        return "";
    L14:
        return r101;
    L4:
        if ("".equals(f27517c) == false) goto L6;
        f27517c = r100.getPackageManager().getPackageInfo(r100.getPackageName(), 0).versionName;     // Catch: Throwable -> L9
        goto L11
    L6:
        return f27517c;
    }

    public static String d(Context r100) {
        return a(r100);
    L4:
        th = move-exception;
        th.printStackTrace();
        return f27518d;
    }

    public static String e(Context r100) {
        int r101 = m5.f27562a;     // Catch: Throwable -> L10
        if (r100 == null) goto L13;
        m5.f27564c = r100.getApplicationContext();     // Catch: Throwable -> L10
    L13:
        return a(r100);
    L7:
        th = move-exception;
        p6.a(th, "AI", "gKy");
        return f27518d;
    }

    public static String f(Context r100) {
        String r101 = f27516b;     // Catch: Throwable -> L13
        if (r101 != null) goto L6;
    L9:
        String r102 = r100.getPackageName();     // Catch: Throwable -> L13
        f27516b = r102;     // Catch: Throwable -> L13
        if (a(r102) == true) goto L16;
        f27516b = r100.getPackageName();     // Catch: Throwable -> L13
    L16:
        return f27516b;
    L6:
        if ("".equals(r101) == true) goto L9;
        return f27516b;
    L13:
        th = move-exception;
        p6.a(th, "AI", "gpck");
        goto L16
    }

    public static String g(Context r100) {
        PackageInfo r101 = r100.getPackageManager().getPackageInfo(r100.getPackageName(), 64);     // Catch: Throwable -> L18
        int r102 = 0;
        byte[] r103 = r101.signatures[0].toByteArray();     // Catch: Throwable -> L18
        byte[] r104 = MessageDigest.getInstance(x5.b("IU0hBMQ")).digest(r103);     // Catch: Throwable -> L18
        StringBuffer r105 = new StringBuffer();     // Catch: Throwable -> L18
    L4:
        if (r102 >= r104.length) goto L9;
        String r106 = Integer.toHexString(r104[r102] & UByte.MAX_VALUE).toUpperCase(Locale.US);     // Catch: Throwable -> L18
        if (r106.length() != 1) goto L8;
        r105.append("0");     // Catch: Throwable -> L18
    L8:
        r105.append(r106);     // Catch: Throwable -> L18
        r105.append(":");     // Catch: Throwable -> L18
        r102 = r102 + 1;     // Catch: Throwable -> L18
        goto L4
    L9:
        String r107 = r101.packageName;     // Catch: Throwable -> L18
        if (a(r107) == false) goto L13;
        r107 = r101.packageName;     // Catch: Throwable -> L18
    L13:
        if (TextUtils.isEmpty(f27516b) == true) goto L16;
        r107 = f(r100);     // Catch: Throwable -> L18
    L16:
        r105.append(r107);     // Catch: Throwable -> L18
        String r108 = r105.toString();     // Catch: Throwable -> L18
        f27519e = r108;     // Catch: Throwable -> L18
        return r108;
    L18:
        th = move-exception;
        p6.a(th, "AI", "gsp");
        return f27519e;
    }

    private static boolean a(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L21;
        r100.toCharArray();
        char[] r101 = r100.toCharArray();
        int r102 = r101.length;
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L19;
        char r104 = r101[r103];
        if ('A' > r104) goto L11;
        if (r104 > 'z') goto L11;
    L18:
        r103 = r103 + 1;
    L11:
        if ('0' > r104) goto L15;
        if (r104 <= ':') goto L18;
    L15:
        if (r104 == '.') goto L18;
        t6.a(x5.b(), r100, "errorPackage");     // Catch: Throwable -> L22
    L17:
        return false;
    L19:
        return true;
    L21:
        return false;
    }

    public static void b(String r100) {
        f27521g.a(r100);
    }

    public static void a(int r100) {
        f27521g.a(r100);
    }

    public static void a(Context r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return;
    L5:
        f27518d = r101;
        if (r100 == null) goto L9;
        z8.f().d(new a(r100, r101));
        return;
    }

    public static void a(String r100, int r101) {
        f27521g.a(r100, r101);
    }
}
