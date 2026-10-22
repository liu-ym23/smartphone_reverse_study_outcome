package com.bytedance.crash.general;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Locale;
import java.util.UUID;

/* JADX INFO: compiled from: RomInfoHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static i f7493a;

    /* JADX INFO: compiled from: RomInfoHelper.java */
    static class a extends i {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f7494d;

        a() {
            super("gionee", "amigo");
            this.f7494d = c.a("ro.gn.sv.version");
        }

        @Override // com.bytedance.crash.general.c.i
        boolean a() {
            if (TextUtils.isEmpty(Build.DISPLAY) == false) goto L5;
        L7:
            return false;
        L5:
            if (Build.DISPLAY.toLowerCase(f7504c).contains("amigo") == false) goto L7;
            return true;
        }

        @Override // com.bytedance.crash.general.c.i
        String b() {
            return Build.DISPLAY + "_" + this.f7494d;
        }
    }

    /* JADX INFO: compiled from: RomInfoHelper.java */
    static class b extends i {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f7495d;

        b() {
            super("oppo", "coloros");
            this.f7495d = c.a("ro.build.version.opporom");
        }

        @Override // com.bytedance.crash.general.c.i
        boolean a() {
            if (TextUtils.isEmpty(Build.MANUFACTURER) == false) goto L5;
        L7:
            return false;
        L5:
            if (Build.MANUFACTURER.toLowerCase(f7504c).contains("oppo") == false) goto L7;
            return true;
        }

        @Override // com.bytedance.crash.general.c.i
        String b() {
            return "coloros_" + this.f7495d + "_" + Build.DISPLAY;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.crash.general.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: RomInfoHelper.java */
    static class C0166c extends i {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f7496d;

        C0166c() {
            super("huawei", "emotionui");
            this.f7496d = c.a("ro.build.version.emui");
        }

        @Override // com.bytedance.crash.general.c.i
        boolean a() {
            if (TextUtils.isEmpty(this.f7496d) == true) goto L23;
            String r3 = this.f7496d.toLowerCase(f7504c);
            if (r3.startsWith("emotionui") == false) goto L7;
        L8:
            return true;
        L7:
            if (r3.startsWith("magicui") == true) goto L8;
        L23:
            String r4 = Build.BRAND;     // Catch: Throwable -> L21
            if (TextUtils.isEmpty(r4) == true) goto L25;
            if (r4.toLowerCase(f7504c).startsWith("huawei") == false) goto L25;
            return true;
        L25:
            String r5 = Build.MANUFACTURER;     // Catch: Throwable -> L22
            if (TextUtils.isEmpty(r5) == true) goto L19;
            if (r5.toLowerCase(f7504c).startsWith("huawei") == false) goto L27;
            return true;
        L27:
            return false;
        L19:
            return false;
        L28:
            return false;
        }

        @Override // com.bytedance.crash.general.c.i
        String b() {
            if (TextUtils.isEmpty(this.f7496d) == true) goto L9;
            if (this.f7496d.toLowerCase(f7504c).contains("emotionui") == false) goto L9;
            return this.f7496d + "_" + Build.DISPLAY;
        L9:
            if (Build.DISPLAY != null) goto L12;
            return SensitiveType.UNKNOWN;
        L12:
            return Build.DISPLAY;
        }
    }

    /* JADX INFO: compiled from: RomInfoHelper.java */
    static class d extends i {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f7497d;

        d() {
            super("letv", "eui");
            this.f7497d = c.a("ro.letv.release.version");
        }

        @Override // com.bytedance.crash.general.c.i
        boolean a() {
            return !TextUtils.isEmpty(this.f7497d);
        }

        @Override // com.bytedance.crash.general.c.i
        String b() {
            return "eui_" + this.f7497d + "_" + Build.DISPLAY;
        }
    }

    /* JADX INFO: compiled from: RomInfoHelper.java */
    static class e extends i {
        e() {
            super("meizu", "flyme");
        }

        @Override // com.bytedance.crash.general.c.i
        boolean a() {
            if (TextUtils.isEmpty(Build.DISPLAY) == true) goto L8;
            if (Build.DISPLAY.toLowerCase(f7504c).contains("flyme") == false) goto L8;
            return true;
        L8:
            if (TextUtils.isEmpty(Build.USER) == false) goto L10;
            return false;
        L10:
            if (Build.USER.equals("flyme") == false) goto L14;
            return true;
        L14:
            return false;
        }
    }

    /* JADX INFO: compiled from: RomInfoHelper.java */
    static class f extends i {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f7498d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f7499e;

        f() {
            super("vivo", "funtouch");
            this.f7498d = c.a("ro.vivo.os.build.display.id");
            this.f7499e = c.a("ro.vivo.product.version");
        }

        @Override // com.bytedance.crash.general.c.i
        boolean a() {
            if (TextUtils.isEmpty(this.f7498d) == false) goto L5;
        L7:
            return false;
        L5:
            if (this.f7498d.toLowerCase(f7504c).contains("funtouch") == false) goto L7;
            return true;
        }

        @Override // com.bytedance.crash.general.c.i
        String b() {
            return this.f7498d + "_" + this.f7499e;
        }
    }

    /* JADX INFO: compiled from: RomInfoHelper.java */
    static class g extends i {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f7500d;

        g() {
            super("xiaomi", "miui");
            this.f7500d = c.a("ro.miui.ui.version.name");
        }

        @Override // com.bytedance.crash.general.c.i
        boolean a() {
            return c.b("miui.os.Build");
        }

        @Override // com.bytedance.crash.general.c.i
        String b() {
            return "miui_" + this.f7500d + "_" + Build.VERSION.INCREMENTAL;
        }
    }

    /* JADX INFO: compiled from: RomInfoHelper.java */
    static class h extends i {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f7501d;

        h() {
            super("qiku", "360");
            this.f7501d = c.a("ro.build.uiversion");
        }

        @Override // com.bytedance.crash.general.c.i
        boolean a() {
            String r2 = Build.MANUFACTURER + Build.BRAND;
            if (TextUtils.isEmpty(r2) == false) goto L5;
            return false;
        L5:
            String r3 = r2.toLowerCase(f7504c);
            if (r3.contains("360") == false) goto L8;
        L9:
            return true;
        L8:
            if (r3.contains("qiku") == true) goto L9;
            return false;
        }

        @Override // com.bytedance.crash.general.c.i
        String b() {
            return this.f7501d + "_" + Build.DISPLAY;
        }
    }

    /* JADX INFO: compiled from: RomInfoHelper.java */
    static abstract class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected static String f7502a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected static String f7503b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        protected static final Locale f7504c = null;

        abstract boolean a();

        static {
            f7504c = Locale.getDefault();
        }

        i(String r1, String r2) {
            f7502a = r1;
            f7503b = r2;
        }

        String b() {
            if (Build.DISPLAY != null) goto L6;
            return SensitiveType.UNKNOWN;
        L6:
            return Build.DISPLAY;
        }
    }

    /* JADX INFO: compiled from: RomInfoHelper.java */
    static class j extends i {
        j() {
            super("sony", "sony");
        }

        @Override // com.bytedance.crash.general.c.i
        boolean a() {
            String r1 = Build.BRAND + Build.MANUFACTURER;
            if (TextUtils.isEmpty(r1) == false) goto L5;
        L7:
            return false;
        L5:
            if (r1.toLowerCase(f7504c).contains("sony") == false) goto L7;
            return true;
        }
    }

    /* JADX INFO: compiled from: RomInfoHelper.java */
    static class k extends i {
        @Override // com.bytedance.crash.general.c.i
        boolean a() {
            return true;
        }

        k() {
            super(SensitiveType.UNKNOWN, SensitiveType.UNKNOWN);
        }
    }

    static {
    }

    static /* synthetic */ String a(String r0) {
        return d(r0);
    }

    static /* synthetic */ boolean b(String r0) {
        return c(r0);
    }

    static boolean a() {
        String[] r0 = {"/data/local/su", "/data/local/bin/su", "/data/local/xbin/su", "/system/xbin/su", "/system/bin/su", "/system/bin/.ext/su", "/system/bin/failsafe/su", "/system/sd/xbin/su", "/system/usr/we-need-root/su", "/sbin/su", "/su/bin/su"};
        int r2 = 0;
    L4:
        if (r2 >= 11) goto L11;
        if (new File(r0[r2]).exists() == false) goto L10;
        return true;
    L10:
        r2 = r2 + 1;
        goto L4
    L11:
        return false;
    }

    private static boolean c(String r1) {
        ZeusTransformUtils.forName(r1, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        return true;
    L5:
        return false;
    }

    public static String b() {
        String r0 = Build.VERSION.RELEASE;
        if (r0.contains(".") == false) goto L6;
        return r0;
    L6:
        return r0 + ".0";
    }

    public static int c() {
        return Build.VERSION.SDK_INT;
    }

    static String d() {
        String r0 = UUID.randomUUID().toString();     // Catch: Throwable -> L7
        if (TextUtils.isEmpty(r0) == true) goto L5;
        return r0;
    L5:
        return "0000-1111-2222-3333-4444";
    L10:
        return "0000-1111-2222-3333-4444";
    }

    static String e() {
        return System.getProperty("os.version");
    L4:
        return SensitiveType.UNKNOWN;
    }

    static boolean f() {
        return c("ohos.utils.system.SystemCapability");
    }

    static String g() {
        if (Build.VERSION.INCREMENTAL != null) goto L6;
        return SensitiveType.UNKNOWN;
    L6:
        return Build.VERSION.INCREMENTAL;
    }

    static String h() {
        return i().b();
    }

    private static i i() {
        if (f7493a != null) goto L15;
        monitor-enter(i.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f7493a != null) goto L9;
        f7493a = j();     // Catch: Throwable -> L11
    L9:
        monitor-exit(i.class);     // Catch: Throwable -> L11
    L15:
        return f7493a;
    }

    private static i j() {
        C0166c r0 = new C0166c();
        if (r0.a() == false) goto L5;
        return r0;
    L5:
        g r1 = new g();
        if (r1.a() == false) goto L8;
        return r1;
    L8:
        f r2 = new f();
        if (r2.a() == false) goto L11;
        return r2;
    L11:
        b r3 = new b();
        if (r3.a() == false) goto L14;
        return r3;
    L14:
        e r4 = new e();
        if (r4.a() == false) goto L17;
        return r4;
    L17:
        d r5 = new d();
        if (r5.a() == false) goto L20;
        return r5;
    L20:
        j r6 = new j();
        if (r6.a() == false) goto L23;
        return r6;
    L23:
        a r7 = new a();
        if (r7.a() == false) goto L26;
        return r7;
    L26:
        h r8 = new h();
        if (r8.a() == false) goto L30;
        return r8;
    L30:
        return new k();
    }

    public static String a(String r8, String r9) {
        return (String) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.forName("android.os.SystemProperties", "com.obric.aiagent.plugin").getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class, String.class}).invoke(null, new Object[]{r8, r9}), String.class, "com.obric.aiagent.plugin");
    L5:
        e = move-exception;
        e.printStackTrace();
        return r9;
    }

    private static String d(String r1) {
        return a(r1, "");
    }
}
