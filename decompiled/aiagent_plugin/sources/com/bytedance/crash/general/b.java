package com.bytedance.crash.general;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.support.v4.media.session.PlaybackStateCompat;
import android.system.Os;
import android.system.OsConstants;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.bytedance.crash.o.i;
import com.bytedance.crash.o.r;
import com.bytedance.crash.o.t;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* JADX INFO: compiled from: HardwareInfoHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    public static long a() {
        return 1000 / i();
    }

    private static long i() {
        long r1 = -1;
        if (Build.VERSION.SDK_INT < 21) goto L15;
        r1 = Os.sysconf(OsConstants._SC_CLK_TCK);
    L10:
        if (r1 > 0) goto L17;
        return 100;
    L17:
        return r1;
    L15:
        int r0 = t.a("libcore.io.OsConstants", "_SC_CLK_TCK");     // Catch: Throwable -> L14
        Object r3 = t.b("libcore.io.Libcore", RomInfo.KEY_OS_TYPE);     // Catch: Throwable -> L14
        if (r3 == null) goto L10;
        r1 = ((Long) ZeusTransformUtils.preCheckCast(t.a("libcore.io.Os", "sysconf", new Class[]{Integer.TYPE}).invoke(r3, new Object[]{Integer.valueOf(r0)}), Long.class, "com.obric.aiagent.plugin")).longValue();     // Catch: Throwable -> L14
        goto L10
    }

    public static String b() {
        StringBuilder r0 = new StringBuilder();
    L19:
        e = move-exception;
        StringBuilder r2 = r0;
        Exception e2 = e;
    L21:
        r.a(e2);
    L22:
        r0 = r2;
    L23:
        String r1 = r0.toString();
        if (TextUtils.isEmpty(r1) == false) goto L33;
        return SensitiveType.UNKNOWN;
    L33:
        return r1;
    L4:
        if (Build.VERSION.SDK_INT < 21) goto L18;
        String[] r3 = Build.SUPPORTED_ABIS;     // Catch: Exception -> L19
        if (r3.length <= 0) goto L23;
        r2 = new StringBuilder();     // Catch: Exception -> L19
        int r4 = 0;
    L27:
    L15:
        e2 = e;
        goto L21
    L10:
        if (r4 >= r3.length) goto L22;
        r2.append(r3[r4]);     // Catch: Exception -> L15
        if (r4 == (r3.length - 1)) goto L14;
        r2.append(", ");     // Catch: Exception -> L15
    L14:
        r4 = r4 + 1;
        goto L27
    L18:
        r0 = new StringBuilder(Build.CPU_ABI);     // Catch: Exception -> L19
        goto L23
    }

    public static String c() {
        if (TextUtils.isEmpty(Build.HARDWARE) == false) goto L6;
        return SensitiveType.UNKNOWN;
    L6:
        return Build.HARDWARE;
    }

    public static String d() {
        FileReader r1 = null;
        FileReader r2 = new FileReader("/proc/cpuinfo");     // Catch: Throwable -> L31 IOException -> L33
    L67:
        BufferedReader r3 = new BufferedReader(r2);     // Catch: Throwable -> L25 IOException -> L28
    L69:
        String r4 = r3.readLine();     // Catch: Throwable -> L21 IOException -> L23
        if (r4 == null) goto L19;
        if (r4.contains(":") == false) goto L69;
        String[] r5 = r4.split(":");     // Catch: Throwable -> L21 IOException -> L23
        if (r5[0].contains("Hardware") == true) goto L13;
        if (r5[0].contains("model name") == false) goto L69;
    L13:
        String r0 = r5[1];     // Catch: Throwable -> L21 IOException -> L23
        r2.close();     // Catch: IOException -> L16
        r3.close();     // Catch: IOException -> L16
    L18:
        return r0;
    L16:
        e = move-exception;
        r.b(e);
        goto L18
    L19:
        r2.close();     // Catch: IOException -> L38
        r3.close();     // Catch: IOException -> L38
    L45:
        if (Build.BOARD != null) goto L48;
        return SensitiveType.UNKNOWN;
    L48:
        return Build.BOARD;
    L23:
        e = e;
    L30:
        r1 = r2;
    L60:
        r.b(e);     // Catch: Throwable -> L49
        if (r1 == null) goto L40;
        r1.close();     // Catch: IOException -> L38
    L40:
        if (r3 == null) goto L45;
        r3.close();     // Catch: IOException -> L38
    L49:
        th = th;
    L50:
        if (r1 != null) goto L62;
    L54:
        if (r3 == null) goto L58;
        r3.close();     // Catch: IOException -> L52
    L52:
        e = move-exception;
        r.b(e);
    L58:
        throw th;
    L62:
        r1.close();     // Catch: IOException -> L52
    L21:
        th = th;
    L27:
        r1 = r2;
    L28:
        e = e;
        r3 = null;
    L25:
        th = th;
        r3 = null;
    L38:
        e = move-exception;
        r.b(e);
    L33:
        e = e;
        r3 = null;
    L31:
        th = th;
        r3 = null;
        goto L50
    }

    public static String e() {
        if (TextUtils.isEmpty(Build.MANUFACTURER) == false) goto L6;
        return SensitiveType.UNKNOWN;
    L6:
        return Build.MANUFACTURER;
    }

    public static String f() {
        if (TextUtils.isEmpty(Build.BRAND) == false) goto L6;
        return SensitiveType.UNKNOWN;
    L6:
        return Build.BRAND;
    }

    public static String g() {
        String r0 = Build.BRAND;
        String r1 = Build.MODEL;
        if (TextUtils.isEmpty(r1) == false) goto L7;
        if (r0 != null) goto L13;
        return SensitiveType.UNKNOWN;
    L13:
        return r0;
    L7:
        if (r0 != null) goto L9;
    L12:
        return r1;
    L9:
        if (r1.contains(r0) == true) goto L12;
        return r0 + ' ' + r1;
    }

    public static String a(DisplayMetrics r2) {
        return r2.heightPixels + "x" + r2.widthPixels;
    }

    public static int b(DisplayMetrics r0) {
        return r0.densityDpi;
    }

    public static String c(DisplayMetrics r1) {
        int r2 = r1.densityDpi;
        if (r2 != 120) goto L5;
        return "ldpi";
    L5:
        if (r2 != 240) goto L7;
        return "hdpi";
    L7:
        if (r2 == 320) goto L9;
        return "mdpi";
    L9:
        return "xhdpi";
    }

    private static long j() {
        BufferedReader r0 = null;
        BufferedReader r1 = new BufferedReader(new FileReader("/proc/meminfo"));     // Catch: Throwable -> L16
        String r2 = r1.readLine();     // Catch: Throwable -> L12
        if (r2 != null) goto L7;
    L11:
        i.a(r1);
        return 0;
    L7:
        if (r2.startsWith("MemTotal:") == false) goto L11;
        long r3 = Long.parseLong(r2.substring(9).trim().split(" ")[0]) * 1024;
        i.a(r1);
        return r3;
    L12:
        r0 = r1;
    L13:
        i.a(r0);
        return 0;
    }

    private static long k() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.crash.i.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L6;
        ActivityManager r1 = (ActivityManager) ZeusTransformUtils.preCheckCast(r0.getSystemService("activity"), ActivityManager.class, "com.obric.aiagent.plugin");
        ActivityManager.MemoryInfo r2 = new ActivityManager.MemoryInfo();
        r1.getMemoryInfo(r2);
        return r2.totalMem;
    L6:
        return 0;
    }

    static String a(long r22) {
        if (r22 > 0) goto L6;
        return "Invalid";
    L6:
        long[] r1 = {256, 512, 1024, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH, 3072, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM, 5120, 6144, PlaybackStateCompat.ACTION_PLAY_FROM_URI, 10240, 12288, 16384, 24576, PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID, 49152, PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH, PlaybackStateCompat.ACTION_PREPARE_FROM_URI, PlaybackStateCompat.ACTION_SET_REPEAT_MODE, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED, 1048576};
        String[] r2 = {"256MB", "512MB", "1GB", "2GB", "3GB", "4GB", "5GB", "6GB", "8GB", "10GB", "12GB", "16GB", "24GB", "32GB", "48GB", "64GB", "128GB", "256GB", "512GB", "1TB"};
        int r3 = 0;
    L7:
        if (r3 >= 20) goto L13;
        if (r22 < ((r1[r3] * 1024) * 1024)) goto L11;
        r3 = r3 + 1;
        goto L7
    L11:
        return r2[r3];
    L13:
        return "1TB+";
    }

    public static String h() {
        long r0 = j();
        if (r0 != 0) goto L6;
        r0 = k();
    L6:
        return a(r0);
    }
}
