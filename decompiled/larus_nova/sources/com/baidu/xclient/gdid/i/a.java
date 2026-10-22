package com.baidu.xclient.gdid.i;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Point;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.view.Display;
import android.view.WindowManager;
import androidx.core.content.ContextCompat;
import com.baidu.platform.comapi.bmsdk.BmLocated;
import com.baidu.xclient.gdid.j.d;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.huawei.hms.utils.FileUtil;
import com.obric.sva.sdk.data.ISmModel;
import java.io.BufferedReader;
import java.io.File;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes39.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f33620a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f33621b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f33622c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f33623d;

    public static int a(long r100) {
    L71:
        th = move-exception;
        d.a(th);
        return 0;
    L3:
        if (g() == false) goto L29;
        String r101 = Build.BOARD.trim().toUpperCase();     // Catch: Throwable -> L71
        if (r101.startsWith("SQW100-") == false) goto L8;
        return 3072;
    L8:
        if (r101.startsWith("SQC100-") == false) goto L10;
    L28:
        return 2048;
    L10:
        if (r101.startsWith("SQK100-") == true) goto L28;
        if (r101.startsWith("SQN100-") == true) goto L28;
        if (r101.startsWith("SQR100-") == true) goto L28;
        if (r101.startsWith("STA100-") == true) goto L28;
        if (r101.startsWith("STK100-") == true) goto L28;
        if (r101.startsWith("STL100-") == true) goto L28;
        if (r101.startsWith("STR100-") == true) goto L28;
        if (r101.startsWith("STJ100-") == false) goto L29;
        return ISmModel.VERSION_0600;
    L29:
        float r102 = r100 / 1024.0f;
        if (r102 <= 10.0f) goto L34;
        return 12288;
    L34:
        if (r102 <= 8.0f) goto L38;
        return 10240;
    L38:
        if (r102 <= 7.0f) goto L42;
        return 8192;
    L42:
        if (r102 <= 5.0f) goto L46;
        return BmLocated.HALF_LEFT_BOTTOM;
    L46:
        if (r102 <= 4.0f) goto L50;
        return BmLocated.HALF_LEFT_TOP;
    L50:
        if (r102 <= 3.0f) goto L54;
        return 4096;
    L54:
        if (r102 <= 2.0f) goto L57;
        return 3072;
    L57:
        if (r102 <= 1.0f) goto L60;
        return 2048;
    L60:
        if (r102 <= 0.75f) goto L64;
        return 1024;
    L64:
        if (r102 <= 0.5f) goto L68;
        return ISmModel.VERSION_0300;
    L68:
        if (r102 <= 0.25f) goto L77;
        return 512;
    L77:
        return 0;
    }

    public static long a() {
    L9:
        th = move-exception;
        d.a(th);
        return -1;
    L3:
        if ("mounted".equals(Environment.getExternalStorageState()) == true) goto L5;
        return -1;
    L5:
        if (f33622c != 0) goto L7;
        StatFs r100 = new StatFs(Environment.getExternalStorageDirectory().getPath());     // Catch: Throwable -> L9
        f33622c = ((long) r100.getBlockSize()) * ((long) r100.getBlockCount());     // Catch: Throwable -> L9
    L7:
        return f33622c;
    }

    public static long a(String r100) {
        return CastLongProtector.valueOf(r100).longValue();
    L4:
        e = move-exception;
        d.a(e);
        return Long.MIN_VALUE;
    }

    public static String a(Context r100) {
        int r101 = a(g(r100));     // Catch: Throwable -> L21
        if (r101 > 0) goto L8;
        return null;
    L8:
        if ((r101 % 1024) == 0) goto L11;
        if (r101 < 1024) goto L20;
        if ((r101 % 512) != 0) goto L20;
        return String.format("%.1f %s", new Object[]{Float.valueOf(r101 / 1024.0f), "GB"});
    L20:
        return a(Long.valueOf(r101));
    L11:
        return String.format("%d %s", new Object[]{Integer.valueOf(r101 / 1024), "GB"});
    L21:
        th = move-exception;
        d.a(th);
        return null;
    }

    public static String a(Long r100) {
    L11:
        th = move-exception;
        d.a(th);
        return "";
    L4:
        if (r100.longValue() < FileUtil.LOCAL_REPORT_FILE_MAX_SIZE) goto L10;
        return String.format("%.2f %s", new Object[]{Float.valueOf(r100.longValue() / 1024.0f), "GB"});
    L10:
        return String.format("%d %s", new Object[]{r100, "MB"});
    }

    public static long b() {
    L9:
        th = move-exception;
        d.a(th);
        return -1;
    L3:
        if ("mounted".equals(Environment.getExternalStorageState()) == true) goto L5;
        return -1;
    L5:
        if (f33623d != 0) goto L7;
        StatFs r100 = new StatFs(Environment.getExternalStorageDirectory().getPath());     // Catch: Throwable -> L9
        f33623d = ((long) r100.getAvailableBlocks()) * r100.getBlockSize();     // Catch: Throwable -> L9
    L7:
        return f33623d;
    }

    public static String b(Context r100) {
        ActivityManager r101 = (ActivityManager) r100.getSystemService("activity");     // Catch: Throwable -> L17
        ActivityManager.MemoryInfo r102 = new ActivityManager.MemoryInfo();     // Catch: Throwable -> L17
        r101.getMemoryInfo(r102);     // Catch: Throwable -> L17
        int r103 = (int) (r102.availMem / 1048576);     // Catch: Throwable -> L17
        if ((r103 % 1024) == 0) goto L7;
        if (r103 < 1024) goto L16;
        if ((r103 % 512) != 0) goto L16;
        return String.format("%.1f %s", new Object[]{Float.valueOf(r103 / 1024.0f), "GB"});
    L16:
        return a(Long.valueOf(r103));
    L7:
        return String.format("%d %s", new Object[]{Integer.valueOf(r103 / 1024), "GB"});
    L17:
        th = move-exception;
        d.a(th);
        return "";
    }

    public static long c() {
    L7:
        th = move-exception;
        d.a(th);
        return -1;
    L3:
        if (f33620a != 0) goto L5;
        StatFs r100 = new StatFs(Environment.getDataDirectory().getPath());     // Catch: Throwable -> L7
        f33620a = ((long) r100.getBlockSize()) * ((long) r100.getBlockCount());     // Catch: Throwable -> L7
    L5:
        return f33620a;
    }

    public static String c(Context r100) {
        WindowManager r101 = (WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW);
        if (r101 != null) goto L6;
        return "";
    L6:
        Display r102 = r101.getDefaultDisplay();
        Point r103 = new Point();
        r102.getRealSize(r103);
        int r104 = r103.x;
        return r103.y + "X" + r104;
    }

    public static int d(Context r100) {
        if (r100.getResources().getConfiguration().orientation != 2) goto L8;
        return 0;
    L8:
        return 1;
    L9:
        th = move-exception;
        d.a(th);
        return 1;
    }

    public static long d() {
    L7:
        th = move-exception;
        d.a(th);
        return -1;
    L3:
        if (f33621b != 0) goto L5;
        StatFs r100 = new StatFs(Environment.getDataDirectory().getPath());     // Catch: Throwable -> L7
        f33621b = ((long) r100.getBlockSize()) * ((long) r100.getAvailableBlocks());     // Catch: Throwable -> L7
    L5:
        return f33621b;
    }

    public static int e(Context r100) {
        BatteryManager r101 = (BatteryManager) r100.getSystemService("batterymanager");     // Catch: Throwable -> L8
        if (r101 != null) goto L6;
        return 0;
    L6:
        return r101.getIntProperty(4);
    L8:
        th = move-exception;
        d.a(th);
        return 0;
    }

    public static long e() {
        File r100 = com.baidu.mshield.b.e.a.a(com.baidu.xclient.gdid.d.f33591b, "/proc/meminfo");
        long r101 = 0;
        if (r100 != null) goto L5;
    L35:
        return r101;
    L5:
        if (r100.exists() == false) goto L35;
        BufferedReader r102 = new BufferedReader(new PolarisFileReaderWrapper(r100));     // Catch: Throwable -> L20
    L38:
        String r103 = r102.readLine();     // Catch: Throwable -> L18
        if (r103 == null) goto L12;
        if (r103.startsWith("MemTotal:") == false) goto L38;
    L12:
        String r104 = r103.substring(9).trim().toUpperCase();     // Catch: Throwable -> L18
        int r105 = r104.indexOf(" KB");     // Catch: Throwable -> L18
        if (r105 <= 0) goto L36;
        long r106 = a(r104.substring(0, r105));     // Catch: Throwable -> L18
        if (r106 <= 0) goto L36;
        r101 = r106 / 1024;     // Catch: Throwable -> L18
    L36:
        r102.close();     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        d.a(th);
    L18:
        th = th;
    L40:
        d.a(th);     // Catch: Throwable -> L28
        if (r102 == null) goto L35;
    L28:
        th = move-exception;
        if (r102 != null) goto L44;
    L34:
        throw th;
    L44:
        r102.close();     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        d.a(th);
    L20:
        th = th;
        r102 = null;
        goto L40
    }

    public static String f() {
        return Build.MANUFACTURER.trim();
    L4:
        th = move-exception;
        d.a(th);
        return "";
    }

    public static boolean f(Context r100) {
        int r101 = INVOKEVIRTUAL_com_baidu_xclient_gdid_i_a_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r100, null, new IntentFilter("android.intent.action.BATTERY_CHANGED")).getIntExtra("status", -1);     // Catch: Throwable -> L10
        if (r101 != 2) goto L7;
    L8:
        return true;
    L7:
        if (r101 == 5) goto L8;
        return false;
    L10:
        th = move-exception;
        d.a(th);
        return false;
    }

    public static long g(Context r100) {
        long r101 = h(r100);     // Catch: Throwable -> L7
        if (r101 > 0) goto L12;
        return e();
    L12:
        return r101;
    L7:
        th = move-exception;
        d.a(th);
        return 0;
    }

    public static boolean g() {
    L9:
        th = move-exception;
        d.a(th);
        return false;
    L4:
        if (f().toUpperCase().equals("BLACKBERRY") == true) goto L7;
        if (f().equals("RIM") == true) goto L7;
        return false;
    L7:
        return true;
    }

    public static long h(Context r100) {
        if (r100 != null) goto L11;
    L10:
        return 0;
    L11:
        ActivityManager r101 = (ActivityManager) r100.getSystemService("activity");     // Catch: Throwable -> L8
        ActivityManager.MemoryInfo r102 = new ActivityManager.MemoryInfo();     // Catch: Throwable -> L8
        if (r101 == null) goto L13;
        r101.getMemoryInfo(r102);     // Catch: Throwable -> L8
        return r102.totalMem / 1048576;
    L13:
        return 0;
    L8:
        th = move-exception;
        d.a(th);
        goto L10
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_baidu_xclient_gdid_i_a_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r110) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L42:
    L36:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L40;
        throw e;
    L40:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r110 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, null, null, 2, r100);     // Catch: Exception -> L36
        int r103 = r102.result;     // Catch: Exception -> L36
        if (r103 == 1) goto L23;
        if (r103 == 2) goto L21;
        if (r103 == 3) goto L19;
        return r100.registerReceiver(r101, r110);
    L19:
        return r102.intent;
    L21:
        return new Intent();
    L23:
        return r100.registerReceiver(r101, r110);
    L25:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
        return r100.registerReceiver(r101, r110, null, ReceiverRegisterLancet.sReceiverHandler);
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L35;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
        return ContextCompat.registerReceiver(r100, r101, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);
    L35:
        return r100.registerReceiver(r101, r110);
    }
}
