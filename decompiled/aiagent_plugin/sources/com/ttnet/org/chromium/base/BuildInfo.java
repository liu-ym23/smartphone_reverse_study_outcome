package com.ttnet.org.chromium.base;

import android.app.UiModeManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.ttnet.org.chromium.build.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class BuildInfo {
    private static final String TAG = "BuildInfo";
    static final /* synthetic */ boolean n = true;
    private static PackageInfo o = null;
    private static ApplicationInfo p = null;
    private static boolean q = false;
    private static String r = "";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f37600a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f37601b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f37602c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f37603d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f37604e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public boolean l;
    public boolean m;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static BuildInfo f37605a;

        static {
            f37605a = new BuildInfo();
        }

        static /* synthetic */ BuildInfo a() {
            return f37605a;
        }
    }

    static {
    }

    private static String[] getAll() {
        return b().a();
    }

    String[] a() {
        String r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(d.a(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getPackageName();
        String[] r2 = new String[28];
        r2[0] = Build.BRAND;
        r2[1] = Build.DEVICE;
        r2[2] = Build.ID;
        r2[3] = Build.MANUFACTURER;
        r2[4] = Build.MODEL;
        r2[5] = String.valueOf(Build.VERSION.SDK_INT);
        r2[6] = Build.TYPE;
        r2[7] = Build.BOARD;
        r2[8] = r0;
        r2[9] = String.valueOf(this.f37601b);
        r2[10] = this.f37600a;
        r2[11] = this.f37602c;
        r2[12] = String.valueOf(this.f37603d);
        r2[13] = this.f37604e;
        r2[14] = this.i;
        r2[15] = this.g;
        r2[16] = this.f;
        r2[17] = this.h;
        r2[18] = r;
        r2[19] = this.j;
        r2[20] = this.k;
        r2[21] = String.valueOf(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(d.a(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getApplicationInfo().targetSdkVersion);
        String r1 = "1";
        if (c() == false) goto L5;
        String r3 = "1";
    L6:
        r2[22] = r3;
        if (this.l == false) goto L9;
        String r4 = "1";
    L10:
        r2[23] = r4;
        r2[24] = Build.VERSION.INCREMENTAL;
        r2[25] = Build.HARDWARE;
        if (d() == false) goto L13;
        String r5 = "1";
    L14:
        r2[26] = r5;
        if (this.m == true) goto L18;
        r1 = "0";
    L18:
        r2[27] = r1;
        return r2;
    L13:
        r5 = "0";
        goto L14
    L9:
        r4 = "0";
        goto L10
    L5:
        r3 = "0";
        goto L6
    }

    private static String a(CharSequence r2) {
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L6;
        return "";
    L6:
        return r3.toString();
    }

    public static long a(PackageInfo r2) {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return com.ttnet.org.chromium.base.compat.d.a(r2);
    L7:
        return r2.versionCode;
    }

    public static BuildInfo b() {
        return a.a();
    }

    BuildInfo() {
        this.f37600a = "";
        this.f37602c = "";
        this.f37604e = "";
        this.f = "";
        this.g = "";
        this.h = "";
        this.i = "";
        this.j = "";
        this.k = "";
        boolean r1 = true;
        q = true;
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(d.a(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L24
        String r4 = r3.getPackageName();     // Catch: Exception -> L24
        PackageManager r5 = r3.getPackageManager();     // Catch: Exception -> L24
        PackageInfo r6 = r5.getPackageInfo(r4, 0);     // Catch: Exception -> L24
        long r7 = a(r6);     // Catch: Exception -> L24
        this.f37601b = r7;     // Catch: Exception -> L24
        PackageInfo r9 = o;     // Catch: Exception -> L24
        if (r9 == null) goto L6;
        this.f37602c = r9.packageName;     // Catch: Exception -> L24
        this.f37603d = a(o);     // Catch: Exception -> L24
        this.f37604e = a(o.versionName);     // Catch: Exception -> L24
        p = o.applicationInfo;     // Catch: Exception -> L24
        o = null;     // Catch: Exception -> L24
    L7:
        this.f37600a = a(r5.getApplicationLabel(r6.applicationInfo));     // Catch: Exception -> L24
        this.f = a(r5.getInstallerPackageName(this.f37602c));     // Catch: Exception -> L24
        String r8 = "Not Enabled";
        if (BuildConfig.R_STRING_PRODUCT_VERSION != 0) goto L29;
    L12:
        this.k = r8;     // Catch: Exception -> L24
        if (Build.VERSION.SDK_INT < 21) goto L15;
        this.h = TextUtils.join(", ", Build.SUPPORTED_ABIS);     // Catch: Exception -> L24
    L16:
        this.i = Build.FINGERPRINT.substring(0, Math.min(Build.FINGERPRINT.length(), 128));     // Catch: Exception -> L24
        UiModeManager r0 = (UiModeManager) ZeusTransformUtils.preCheckCast(r3.getSystemService("uimode"), UiModeManager.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L24
        if (r0 != null) goto L19;
    L21:
        r1 = false;
    L22:
        this.l = r1;     // Catch: Exception -> L24
        this.m = r3.getPackageManager().hasSystemFeature("android.hardware.type.automotive");     // Catch: Exception -> L24
        return;
    L19:
        if (r0.getCurrentModeType() != 4) goto L21;
    L15:
        this.h = String.format("ABI1: %s, ABI2: %s", new Object[]{Build.CPU_ABI, Build.CPU_ABI2});     // Catch: Exception -> L24
        goto L16
    L29:
        r8 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(d.a(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(BuildConfig.R_STRING_PRODUCT_VERSION);     // Catch: Exception -> L11
    L11:
        r8 = "Not found";
        goto L12
    L6:
        this.f37602c = r4;     // Catch: Exception -> L24
        this.f37603d = r7;     // Catch: Exception -> L24
        this.f37604e = a(r6.versionName);     // Catch: Exception -> L24
        p = r3.getApplicationInfo();     // Catch: Exception -> L24
    L24:
        e = move-exception;
        j.e(TAG, "NameNotFoundException: " + e, new Object[0]);
    }

    public static boolean c() {
        if ("eng".equals(Build.TYPE) == false) goto L5;
    L8:
        return true;
    L5:
        if ("userdebug".equals(Build.TYPE) == true) goto L8;
        return false;
    }

    private static boolean a(String r2, String r3) {
        if ("REL".equals(r3) == false) goto L6;
        return false;
    L6:
        if (r3.toUpperCase(Locale.ROOT).compareTo(r2.toUpperCase(Locale.ROOT)) < 0) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean d() {
        if (Build.VERSION.SDK_INT >= 32) goto L5;
    L7:
        return false;
    L5:
        if (a("Tiramisu", Build.VERSION.CODENAME) == false) goto L7;
        return true;
    }
}
