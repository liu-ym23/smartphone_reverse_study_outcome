package com.tencent.bugly.proguard;

import Z7.C1139k;
import Z7.C1143o;
import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Debug;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes4.dex */
public final class ab {

    /* renamed from: a, reason: collision with root package name */
    public static final ArrayList<a> f31554a = new ArrayList<a>() { // from class: com.tencent.bugly.proguard.ab.1
        {
            byte b10 = 0;
            add(new l(b10));
            add(new f(b10));
            add(new g(b10));
            add(new m(b10));
            add(new h(b10));
            add(new i(b10));
            add(new k(b10));
            add(new e(b10));
            add(new j(b10));
            add(new b(b10));
            add(new d(b10));
            add(new c(b10));
        }
    };

    /* renamed from: b, reason: collision with root package name */
    public static final Map<Integer, String> f31555b = new HashMap<Integer, String>() { // from class: com.tencent.bugly.proguard.ab.2
        {
            put(1, "GPRS");
            put(2, "EDGE");
            put(3, "UMTS");
            put(8, "HSDPA");
            put(9, "HSUPA");
            put(10, "HSPA");
            put(4, "CDMA");
            put(5, "EVDO_0");
            put(6, "EVDO_A");
            put(7, "1xRTT");
            put(11, "iDen");
            put(12, "EVDO_B");
            put(13, "LTE");
            put(14, "eHRPD");
            put(15, "HSPA+");
        }
    };

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f31556c = {"/su", "/su/bin/su", "/sbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/data/local/su", "/system/xbin/su", "/system/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/system/bin/cufsdosck", "/system/xbin/cufsdosck", "/system/bin/cufsmgr", "/system/xbin/cufsmgr", "/system/bin/cufaevdd", "/system/xbin/cufaevdd", "/system/bin/conbb", "/system/xbin/conbb"};

    public static abstract class a {
        public a() {
        }

        public abstract String a();

        public /* synthetic */ a(byte b10) {
            this();
        }
    }

    public static class b extends a {
        public b() {
            super((byte) 0);
        }

        @Override // com.tencent.bugly.proguard.ab.a
        public final String a() {
            String strJ = C1143o.j("ro.gn.gnromvernumber");
            if (C1143o.G(strJ) || strJ.equals("fail")) {
                return null;
            }
            return "amigo/" + strJ + "/" + C1143o.j("ro.build.display.id");
        }

        public /* synthetic */ b(byte b10) {
            this();
        }
    }

    public static class c extends a {
        public c() {
            super((byte) 0);
        }

        @Override // com.tencent.bugly.proguard.ab.a
        public final String a() {
            return C1143o.j("ro.build.fingerprint") + "/" + C1143o.j("ro.build.rom.id");
        }

        public /* synthetic */ c(byte b10) {
            this();
        }
    }

    public static class d extends a {
        public d() {
            super((byte) 0);
        }

        @Override // com.tencent.bugly.proguard.ab.a
        public final String a() {
            String strJ = C1143o.j("ro.build.tyd.kbstyle_version");
            if (C1143o.G(strJ) || strJ.equals("fail")) {
                return null;
            }
            return "dido/".concat(strJ);
        }

        public /* synthetic */ d(byte b10) {
            this();
        }
    }

    public static class e extends a {
        public e() {
            super((byte) 0);
        }

        @Override // com.tencent.bugly.proguard.ab.a
        public final String a() {
            String strJ = C1143o.j("ro.aa.romver");
            if (C1143o.G(strJ) || strJ.equals("fail")) {
                return null;
            }
            return "htc/" + strJ + "/" + C1143o.j("ro.build.description");
        }

        public /* synthetic */ e(byte b10) {
            this();
        }
    }

    public static class f extends a {
        public f() {
            super((byte) 0);
        }

        @Override // com.tencent.bugly.proguard.ab.a
        public final String a() {
            String strJ = C1143o.j("ro.build.version.emui");
            if (C1143o.G(strJ) || strJ.equals("fail")) {
                return null;
            }
            return "HuaWei/EMOTION/".concat(strJ);
        }

        public /* synthetic */ f(byte b10) {
            this();
        }
    }

    public static class g extends a {
        public g() {
            super((byte) 0);
        }

        @Override // com.tencent.bugly.proguard.ab.a
        public final String a() {
            String strJ = C1143o.j("ro.lenovo.series");
            if (C1143o.G(strJ) || strJ.equals("fail")) {
                return null;
            }
            return "Lenovo/VIBE/".concat(String.valueOf(C1143o.j("ro.build.version.incremental")));
        }

        public /* synthetic */ g(byte b10) {
            this();
        }
    }

    public static class h extends a {
        public h() {
            super((byte) 0);
        }

        @Override // com.tencent.bugly.proguard.ab.a
        public final String a() {
            String strJ = C1143o.j("ro.meizu.product.model");
            if (C1143o.G(strJ) || strJ.equals("fail")) {
                return null;
            }
            return "Meizu/FLYME/" + C1143o.j("ro.build.display.id");
        }

        public /* synthetic */ h(byte b10) {
            this();
        }
    }

    public static class i extends a {
        public i() {
            super((byte) 0);
        }

        @Override // com.tencent.bugly.proguard.ab.a
        public final String a() {
            String strJ = C1143o.j("ro.build.version.opporom");
            if (C1143o.G(strJ) || strJ.equals("fail")) {
                return null;
            }
            return "Oppo/COLOROS/".concat(strJ);
        }

        public /* synthetic */ i(byte b10) {
            this();
        }
    }

    public static class j extends a {
        public j() {
            super((byte) 0);
        }

        @Override // com.tencent.bugly.proguard.ab.a
        public final String a() {
            String strJ = C1143o.j("ro.lewa.version");
            if (C1143o.G(strJ) || strJ.equals("fail")) {
                return null;
            }
            return "tcl/" + strJ + "/" + C1143o.j("ro.build.display.id");
        }

        public /* synthetic */ j(byte b10) {
            this();
        }
    }

    public static class k extends a {
        public k() {
            super((byte) 0);
        }

        @Override // com.tencent.bugly.proguard.ab.a
        public final String a() {
            String strJ = C1143o.j("ro.vivo.os.build.display.id");
            if (C1143o.G(strJ) || strJ.equals("fail")) {
                return null;
            }
            return "vivo/FUNTOUCH/".concat(strJ);
        }

        public /* synthetic */ k(byte b10) {
            this();
        }
    }

    public static class l extends a {
        public l() {
            super((byte) 0);
        }

        @Override // com.tencent.bugly.proguard.ab.a
        public final String a() {
            String strJ = C1143o.j("ro.miui.ui.version.name");
            if (C1143o.G(strJ) || strJ.equals("fail")) {
                return null;
            }
            return "XiaoMi/MIUI/".concat(strJ);
        }

        public /* synthetic */ l(byte b10) {
            this();
        }
    }

    public static class m extends a {
        public m() {
            super((byte) 0);
        }

        @Override // com.tencent.bugly.proguard.ab.a
        public final String a() {
            String strJ = C1143o.j("ro.build.nubia.rom.name");
            if (C1143o.G(strJ) || strJ.equals("fail")) {
                return null;
            }
            return "Zte/NUBIA/" + strJ + "_" + C1143o.j("ro.build.nubia.rom.code");
        }

        public /* synthetic */ m(byte b10) {
            this();
        }
    }

    public static String a() {
        try {
            return Build.MODEL;
        } catch (Throwable th) {
            if (C1139k.e(th)) {
                return "fail";
            }
            th.printStackTrace();
            return "fail";
        }
    }

    public static String b(Context context) {
        if (context == null || context.getApplicationInfo() == null) {
            return "fail";
        }
        String str = context.getApplicationInfo().nativeLibraryDir;
        return TextUtils.isEmpty(str) ? "fail" : str.endsWith("arm") ? "armeabi-v7a" : str.endsWith("arm64") ? "arm64-v8a" : str.endsWith("x86") ? "x86" : str.endsWith("x86_64") ? "x86_64" : "fail";
    }

    public static long c(Context context) {
        long pss;
        ActivityManager activityManager;
        try {
            activityManager = (ActivityManager) context.getSystemService("activity");
        } catch (Throwable unused) {
            pss = Debug.getPss();
        }
        if (activityManager == null) {
            return 0L;
        }
        pss = activityManager.getProcessMemoryInfo(new int[]{Process.myPid()})[0].getTotalPss();
        return pss * 1024;
    }

    public static String d() {
        try {
            return Build.VERSION.RELEASE;
        } catch (Throwable th) {
            if (C1139k.e(th)) {
                return "fail";
            }
            th.printStackTrace();
            return "fail";
        }
    }

    public static int e() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (Throwable th) {
            if (C1139k.e(th)) {
                return -1;
            }
            th.printStackTrace();
            return -1;
        }
    }

    public static String f(Context context) {
        TelephonyManager telephonyManager;
        String str = "unknown";
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return null;
            }
            if (activeNetworkInfo.getType() == 1) {
                return "WIFI";
            }
            if (activeNetworkInfo.getType() != 0 || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null) {
                return "unknown";
            }
            int networkType = telephonyManager.getNetworkType();
            String str2 = f31555b.get(Integer.valueOf(networkType));
            if (str2 != null) {
                return str2;
            }
            try {
                return "MOBILE(" + networkType + ")";
            } catch (Exception e10) {
                e = e10;
                str = str2;
                if (!C1139k.e(e)) {
                    e.printStackTrace();
                }
                return str;
            }
        } catch (Exception e11) {
            e = e11;
        }
    }

    public static String g() {
        try {
            return String.valueOf(System.getProperty("os.arch"));
        } catch (Throwable th) {
            if (C1139k.e(th)) {
                return "fail";
            }
            th.printStackTrace();
            return "fail";
        }
    }

    public static long h() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getBlockCount() * statFs.getBlockSize();
        } catch (Throwable th) {
            if (C1139k.e(th)) {
                return -1L;
            }
            th.printStackTrace();
            return -1L;
        }
    }

    public static long i() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Throwable th) {
            if (C1139k.e(th)) {
                return -1L;
            }
            th.printStackTrace();
            return -1L;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001d, code lost:
    
        r0 = java.lang.Long.parseLong(r2.replaceAll("[^\\d]", ""));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static long j() {
        /*
            r0 = 0
            r2 = 0
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L3a
            java.io.FileReader r4 = new java.io.FileReader     // Catch: java.lang.Throwable -> L3a
            java.lang.String r5 = "/proc/self/status"
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L3a
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L3a
            java.lang.String r2 = r3.readLine()     // Catch: java.lang.Throwable -> L2a
        L13:
            if (r2 == 0) goto L31
            java.lang.String r4 = "VmSize"
            boolean r4 = r2.startsWith(r4)     // Catch: java.lang.Throwable -> L2a
            if (r4 == 0) goto L2c
            java.lang.String r4 = "[^\\d]"
            java.lang.String r5 = ""
            java.lang.String r2 = r2.replaceAll(r4, r5)     // Catch: java.lang.Throwable -> L2a
            long r0 = java.lang.Long.parseLong(r2)     // Catch: java.lang.Throwable -> L2a
            goto L31
        L2a:
            r2 = move-exception
            goto L3e
        L2c:
            java.lang.String r2 = r3.readLine()     // Catch: java.lang.Throwable -> L2a
            goto L13
        L31:
            r3.close()     // Catch: java.lang.Throwable -> L35
            goto L44
        L35:
            r2 = move-exception
            r2.printStackTrace()
            goto L44
        L3a:
            r3 = move-exception
            r6 = r3
            r3 = r2
            r2 = r6
        L3e:
            Z7.C1139k.e(r2)     // Catch: java.lang.Throwable -> L48
            if (r3 == 0) goto L44
            goto L31
        L44:
            r2 = 1024(0x400, double:5.06E-321)
            long r0 = r0 * r2
            return r0
        L48:
            r0 = move-exception
            if (r3 == 0) goto L53
            r3.close()     // Catch: java.lang.Throwable -> L4f
            goto L53
        L4f:
            r1 = move-exception
            r1.printStackTrace()
        L53:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ab.j():long");
    }

    public static long k() {
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }

    public static long l() throws IOException {
        FileReader fileReader;
        Throwable th;
        BufferedReader bufferedReader;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader, 2048);
                try {
                    String line = bufferedReader.readLine();
                    if (line != null) {
                        long j10 = Long.parseLong(line.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) * 1024;
                        try {
                            bufferedReader.close();
                        } catch (IOException e10) {
                            if (!C1139k.e(e10)) {
                                e10.printStackTrace();
                            }
                        }
                        try {
                            fileReader.close();
                        } catch (IOException e11) {
                            if (!C1139k.e(e11)) {
                                e11.printStackTrace();
                            }
                        }
                        return j10;
                    }
                    try {
                        bufferedReader.close();
                    } catch (IOException e12) {
                        if (!C1139k.e(e12)) {
                            e12.printStackTrace();
                        }
                    }
                    try {
                        fileReader.close();
                        return -1L;
                    } catch (IOException e13) {
                        if (C1139k.e(e13)) {
                            return -1L;
                        }
                        e13.printStackTrace();
                        return -1L;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        if (!C1139k.e(th)) {
                            th.printStackTrace();
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e14) {
                                if (!C1139k.e(e14)) {
                                    e14.printStackTrace();
                                }
                            }
                        }
                        if (fileReader == null) {
                            return -2L;
                        }
                        try {
                            fileReader.close();
                            return -2L;
                        } catch (IOException e15) {
                            if (C1139k.e(e15)) {
                                return -2L;
                            }
                            e15.printStackTrace();
                            return -2L;
                        }
                    } catch (Throwable th3) {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e16) {
                                if (!C1139k.e(e16)) {
                                    e16.printStackTrace();
                                }
                            }
                        }
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (IOException e17) {
                                if (!C1139k.e(e17)) {
                                    e17.printStackTrace();
                                }
                            }
                        }
                        throw th3;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
            }
        } catch (Throwable th5) {
            fileReader = null;
            th = th5;
            bufferedReader = null;
        }
    }

    public static long m() throws IOException {
        FileReader fileReader;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                BufferedReader bufferedReader2 = new BufferedReader(fileReader, 2048);
                try {
                    bufferedReader2.readLine();
                    String line = bufferedReader2.readLine();
                    if (line == null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e10) {
                            if (!C1139k.e(e10)) {
                                e10.printStackTrace();
                            }
                        }
                        try {
                            fileReader.close();
                        } catch (IOException e11) {
                            if (!C1139k.e(e11)) {
                                e11.printStackTrace();
                            }
                        }
                        return -1L;
                    }
                    long j10 = Long.parseLong(line.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) * 1024;
                    String line2 = bufferedReader2.readLine();
                    if (line2 == null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e12) {
                            if (!C1139k.e(e12)) {
                                e12.printStackTrace();
                            }
                        }
                        try {
                            fileReader.close();
                        } catch (IOException e13) {
                            if (!C1139k.e(e13)) {
                                e13.printStackTrace();
                            }
                        }
                        return -1L;
                    }
                    long j11 = j10 + (Long.parseLong(line2.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) * 1024);
                    String line3 = bufferedReader2.readLine();
                    if (line3 == null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e14) {
                            if (!C1139k.e(e14)) {
                                e14.printStackTrace();
                            }
                        }
                        try {
                            fileReader.close();
                        } catch (IOException e15) {
                            if (!C1139k.e(e15)) {
                                e15.printStackTrace();
                            }
                        }
                        return -1L;
                    }
                    long j12 = j11 + (Long.parseLong(line3.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) * 1024);
                    try {
                        bufferedReader2.close();
                    } catch (IOException e16) {
                        if (!C1139k.e(e16)) {
                            e16.printStackTrace();
                        }
                    }
                    try {
                        fileReader.close();
                    } catch (IOException e17) {
                        if (!C1139k.e(e17)) {
                            e17.printStackTrace();
                        }
                    }
                    return j12;
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    try {
                        if (!C1139k.e(th)) {
                            th.printStackTrace();
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e18) {
                                if (!C1139k.e(e18)) {
                                    e18.printStackTrace();
                                }
                            }
                        }
                        if (fileReader == null) {
                            return -2L;
                        }
                        try {
                            fileReader.close();
                            return -2L;
                        } catch (IOException e19) {
                            if (C1139k.e(e19)) {
                                return -2L;
                            }
                            e19.printStackTrace();
                            return -2L;
                        }
                    } catch (Throwable th2) {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e20) {
                                if (!C1139k.e(e20)) {
                                    e20.printStackTrace();
                                }
                            }
                        }
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (IOException e21) {
                                if (!C1139k.e(e21)) {
                                    e21.printStackTrace();
                                }
                            }
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            fileReader = null;
        }
    }

    public static long n() {
        if (!v()) {
            return 0L;
        }
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return statFs.getBlockCount() * statFs.getBlockSize();
        } catch (Throwable th) {
            if (C1139k.e(th)) {
                return -2L;
            }
            th.printStackTrace();
            return -2L;
        }
    }

    public static long o() {
        if (!v()) {
            return 0L;
        }
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Throwable th) {
            if (C1139k.e(th)) {
                return -2L;
            }
            th.printStackTrace();
            return -2L;
        }
    }

    public static String p() {
        return "";
    }

    public static String q() {
        Iterator<a> it = f31554a.iterator();
        while (it.hasNext()) {
            String strA = it.next().a();
            if (!TextUtils.isEmpty(strA)) {
                return strA;
            }
        }
        return null;
    }

    public static boolean r() {
        return !TextUtils.isEmpty(new i((byte) 0).a());
    }

    public static boolean s() {
        return !TextUtils.isEmpty(new k((byte) 0).a());
    }

    public static boolean t() {
        boolean z10;
        String[] strArr = f31556c;
        int length = strArr.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                z10 = false;
                break;
            }
            if (new File(strArr[i10]).exists()) {
                z10 = true;
                break;
            }
            i10++;
        }
        String str = Build.TAGS;
        return (str != null && str.contains("test-keys")) || z10;
    }

    public static boolean u() {
        float fMaxMemory = (float) ((Runtime.getRuntime().maxMemory() * 1.0d) / 1048576.0d);
        float f10 = (float) ((Runtime.getRuntime().totalMemory() * 1.0d) / 1048576.0d);
        float f11 = fMaxMemory - f10;
        C1139k.h("maxMemory : %f", Float.valueOf(fMaxMemory));
        C1139k.h("totalMemory : %f", Float.valueOf(f10));
        C1139k.h("freeMemory : %f", Float.valueOf(f11));
        return f11 < 10.0f;
    }

    public static boolean v() {
        try {
            return Environment.getExternalStorageState().equals("mounted");
        } catch (Throwable th) {
            if (C1139k.e(th)) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }
}
