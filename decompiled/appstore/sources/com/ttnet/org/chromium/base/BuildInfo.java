package com.ttnet.org.chromium.base;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.bytedanceos.common.ad.param.AdReportParam;
import com.ttnet.org.chromium.base.annotations.CalledByNative;

/* JADX INFO: loaded from: classes4.dex */
public class BuildInfo {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static PackageInfo f18225m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static boolean f18226n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static String f18227o = "";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f18228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f18229b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f18230c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f18231d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f18232e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f18233f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f18234g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f18235h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f18236i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f18237j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f18238k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f18239l;

    public static /* synthetic */ class a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static BuildInfo f18240a;

        static {
            f18240a = new BuildInfo(null);
        }

        public static /* synthetic */ BuildInfo a() {
            return f18240a;
        }
    }

    static {
    }

    public /* synthetic */ BuildInfo(a r10) {
        this();
    }

    public static BuildInfo a() {
        return b.a();
    }

    public static boolean b() {
        return true;
    }

    public static boolean c() {
        String r10 = Build.TYPE;
        if ("eng".equals(r10) == false) goto L5;
    L8:
        return true;
    L5:
        if ("userdebug".equals(r10) == true) goto L8;
        return false;
    }

    public static String d(CharSequence r10) {
        if (r10 != null) goto L5;
        return "";
    L5:
        return r10.toString();
    }

    public static long e(PackageInfo r10) {
        return jf.c.a(r10);
    }

    public static boolean f() {
        if (e.d().getApplicationInfo().targetSdkVersion < 30) goto L5;
        return true;
    L5:
        return false;
    }

    @CalledByNative
    private static String[] getAll() {
        BuildInfo r10 = a();
        String r11 = e.d().getPackageName();
        String r12 = Build.BRAND;
        String r13 = Build.DEVICE;
        String r14 = Build.ID;
        String r15 = Build.MANUFACTURER;
        String r16 = Build.MODEL;
        String r17 = String.valueOf(Build.VERSION.SDK_INT);
        String r18 = Build.TYPE;
        String r19 = Build.BOARD;
        String r110 = String.valueOf(r10.f18229b);
        String r111 = r10.f18228a;
        String r112 = r10.f18230c;
        String r113 = String.valueOf(r10.f18231d);
        String r114 = r10.f18232e;
        String r20 = r10.f18236i;
        String r21 = r10.f18234g;
        String r22 = r10.f18233f;
        String r23 = r10.f18235h;
        String r24 = f18227o;
        String r25 = r10.f18238k;
        String r26 = r10.f18239l;
        String r27 = r10.f18237j;
        if (b() == false) goto L5;
        String r28 = "1";
    L7:
        if (f() == false) goto L9;
        String r29 = "1";
    L11:
        if (c() == false) goto L13;
        String r210 = "1";
    L15:
        return new String[]{r12, r13, r14, r15, r16, r17, r18, r19, r11, r110, r111, r112, r113, r114, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r210};
    L13:
        r210 = AdReportParam.ClickPosType.SKIP;
        goto L15
    L9:
        r29 = AdReportParam.ClickPosType.SKIP;
        goto L11
    L5:
        r28 = AdReportParam.ClickPosType.SKIP;
        goto L7
    }

    public BuildInfo() {
        this.f18228a = "";
        this.f18230c = "";
        this.f18232e = "";
        this.f18233f = "";
        this.f18234g = "";
        this.f18235h = "";
        this.f18236i = "";
        this.f18237j = "";
        this.f18238k = "";
        this.f18239l = "";
        f18226n = true;
        Context r10 = e.d();     // Catch: Exception -> L6
        String r11 = r10.getPackageName();     // Catch: Exception -> L6
        PackageManager r12 = r10.getPackageManager();     // Catch: Exception -> L6
        PackageInfo r13 = r12.getPackageInfo(r11, 0);     // Catch: Exception -> L6
        long r14 = e(r13);     // Catch: Exception -> L6
        this.f18229b = r14;     // Catch: Exception -> L6
        PackageInfo r15 = f18225m;     // Catch: Exception -> L6
        PackageInfo r16 = null;
        if (r15 == null) goto L8;
        this.f18230c = r15.packageName;     // Catch: Exception -> L6
        this.f18231d = e(r15);     // Catch: Exception -> L6
        this.f18232e = d(f18225m.versionName);     // Catch: Exception -> L6
        f18225m = null;     // Catch: Exception -> L6
    L9:
        this.f18228a = d(r12.getApplicationLabel(r13.applicationInfo));     // Catch: Exception -> L6
        this.f18233f = d(r12.getInstallerPackageName(this.f18230c));     // Catch: Exception -> L6
        r16 = r12.getPackageInfo("com.google.android.gms", 0);     // Catch: Exception -> L6 PackageManager.NameNotFoundException -> L27
    L11:
        if (r16 == null) goto L13;
        String r17 = String.valueOf(e(r16));     // Catch: Exception -> L6
    L14:
        this.f18234g = r17;     // Catch: Exception -> L6
        String r18 = "true";
        r12.getPackageInfo("projekt.substratum", 0);     // Catch: Exception -> L6 PackageManager.NameNotFoundException -> L17
    L18:
        this.f18238k = r18;     // Catch: Exception -> L6
        String r19 = "Not Enabled";
        if (c.f18316b != 0) goto L32;
    L23:
        this.f18239l = r19;     // Catch: Exception -> L6
        this.f18235h = TextUtils.join(", ", Build.SUPPORTED_ABIS);     // Catch: Exception -> L6
        this.f18237j = String.format("@%x_%x", new Object[]{Long.valueOf(this.f18231d), Long.valueOf(r13.lastUpdateTime)});     // Catch: Exception -> L6
        String r20 = Build.FINGERPRINT;     // Catch: Exception -> L6
        this.f18236i = r20.substring(0, Math.min(r20.length(), 128));     // Catch: Exception -> L6
        return;
    L32:
        r19 = e.d().getString(c.f18316b);     // Catch: Exception -> L22
    L22:
        r19 = "Not found";
    L17:
        r18 = "false";
        goto L18
    L13:
        r17 = "gms versionCode not available.";
        goto L14
    L8:
        this.f18230c = r11;     // Catch: Exception -> L6
        this.f18231d = r14;     // Catch: Exception -> L6
        this.f18232e = d(r13.versionName);     // Catch: Exception -> L6
    L6:
        e = move-exception;
        j.a("BuildInfo", "NameNotFoundException: " + e, new Object[0]);
    }
}
