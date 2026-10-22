package com.bytedance.android.live.core.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug;
import android.os.SystemClock;
import com.bytedance.common.utility.Logger;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.obric.sva.sdk.data.ISmModel;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes45.dex */
public class PerformanceUtil {
    private static final long CPU_STAT_WAITING = 360;
    public static final int DEVICE_PERFORMANCE_HIGH = 3;
    public static final int DEVICE_PERFORMANCE_MEDIUM = 2;
    public static final int DEVICE_PERFORMANCE_POOR = 1;
    public static final int DEVICE_PERFORMANCE_UNKOWN = 0;
    private static final int DEVICE_SCORE_0 = 0;
    private static final int DEVICE_SCORE_1 = 1;
    private static final int DEVICE_SCORE_2 = 2;
    private static final int DEVICE_SCORE_3 = 3;
    private static final int DEVICE_SCORE_4 = 4;
    private static final int DEVICE_SCORE_5 = 5;
    private static final int DEVICE_SCORE_6 = 6;
    private static final int DEVICE_SCORE_7 = 7;
    private static final int[] MAX_CLOCK_SPEED_FOR_SCORE = null;
    private static final int[] MAX_RAM_FOR_SCORE = null;
    private static final long MB = 1048576;
    private static final int MHZ_IN_KHZ = 1000;
    private static String sCpuSpeedRateValue;
    private static String sCpuValue;
    private static long sLastGetCpuSpeedRateTime;
    private static long sLastGetCpuTime;

    static {
        MAX_RAM_FOR_SCORE = new int[]{0, 192, 290, 512, 1024, ISmModel.VERSION_0600, 2048};
        MAX_CLOCK_SPEED_FOR_SCORE = new int[]{0, TTVideoEngineInterface.PLAYER_OPTION_ABR_SWITCH_PENALTY_PARAMETER, 620, 1020, TTVideoEngineInterface.PLAYER_OPTION_ENABLE_CACHE_INFO, 1520, 2020};
        sLastGetCpuTime = -1;
        sCpuValue = "";
        sLastGetCpuSpeedRateTime = -1;
        sCpuSpeedRateValue = "";
    }

    private static int getClockSpeedScore() {
        e0.a r100 = e0.f66128a;
        int r101 = -1;
        int r102 = 0;
        int r103 = -1;
    L79:
        if (r102 >= e0.c()) goto L23;
        PolarisFileWrapper r104 = new PolarisFileWrapper("/sys/devices/system/cpu/cpu" + r102 + "/cpufreq/cpuinfo_max_freq");     // Catch: IOException -> L53
        if (r104.exists() == false) goto L22;
        byte[] r105 = new byte[128];     // Catch: IOException -> L53
        PolarisFileInputStreamWrapper r106 = new PolarisFileInputStreamWrapper(r104);     // Catch: IOException -> L53
        r106.read(r105);     // Catch: Throwable -> L18 NumberFormatException -> L77
        int r107 = 0;
    L11:
        if (Character.isDigit(r105[r107]) == false) goto L14;
        if (r107 >= 128) goto L14;
        r107 = r107 + 1;     // Catch: Throwable -> L18 NumberFormatException -> L77
    L14:
        Integer r108 = Integer.valueOf(Integer.parseInt(new String(r105, 0, r107)));     // Catch: Throwable -> L18 NumberFormatException -> L77
        if (r108.intValue() <= r103) goto L21;
        r103 = r108.intValue();     // Catch: Throwable -> L18 NumberFormatException -> L77
    L18:
        th = move-exception;
        r106.close();     // Catch: IOException -> L53
        throw th;     // Catch: IOException -> L53
    L21:
        r106.close();     // Catch: IOException -> L53
    L22:
        r102 = r102 + 1;     // Catch: IOException -> L53
        goto L79
    L23:
        if (r103 != (-1)) goto L52;
        PolarisFileInputStreamWrapper r109 = new PolarisFileInputStreamWrapper("/proc/cpuinfo");     // Catch: IOException -> L53
        byte[] r110 = new byte[1024];     // Catch: Throwable -> L41
        int r111 = r109.read(r110);     // Catch: Throwable -> L41 Throwable -> L78
        int r112 = 0;
    L27:
        if (r112 >= r111) goto L45;
        byte r113 = r110[r112];     // Catch: Throwable -> L41 Throwable -> L78
        if (r113 == 10) goto L31;
        if (r112 == 0) goto L31;
    L44:
        r112 = r112 + 1;
    L31:
        if (r113 != 10) goto L33;
        r112 = r112 + 1;     // Catch: Throwable -> L41 Throwable -> L78
    L33:
        int r114 = r112;
    L34:
        if (r114 >= r111) goto L44;
        int r115 = r114 - r112;     // Catch: Throwable -> L41 Throwable -> L78
        if (r110[r114] != "cpu MHz".charAt(r115)) goto L44;
        if (r115 == 6) goto L39;
        r114 = r114 + 1;
        goto L34
    L39:
        int r116 = e0.a(r110, r114);     // Catch: Throwable -> L41 Throwable -> L78
    L46:
        int r117 = r116 * 1000;
        if (r117 <= r103) goto L49;
        r103 = r117;
    L49:
        r109.close();     // Catch: IOException -> L53
        goto L52
    L45:
        r116 = -1;
    L41:
        th = move-exception;
        r109.close();     // Catch: IOException -> L53
        throw th;     // Catch: IOException -> L53
    L52:
        r101 = r103;
    L54:
        long r118 = r101;
        if (r118 != (-1)) goto L57;
        return 0;
    L57:
        int[] r119 = MAX_CLOCK_SPEED_FOR_SCORE;
        if (r118 > (r119[1] * 1000)) goto L61;
        return 1;
    L61:
        if (r118 > (r119[2] * 1000)) goto L64;
        return 2;
    L64:
        if (r118 > (r119[3] * 1000)) goto L67;
        return 3;
    L67:
        if (r118 > (r119[4] * 1000)) goto L70;
        return 4;
    L70:
        if (r118 > (r119[5] * 1000)) goto L73;
        return 5;
    L73:
        if (r118 > (r119[6] * 1000)) goto L75;
        return 6;
    L75:
        return 7;
    }

    public static long getDalvikPss() {
        Debug.MemoryInfo r100 = new Debug.MemoryInfo();
        Debug.getMemoryInfo(r100);
        return r100.dalvikPss;
    }

    public static float getDeviceCpuUsage() {
        RandomAccessFile r100 = new RandomAccessFile("/proc/stat", "r");     // Catch: Throwable -> L10
        String[] r101 = r100.readLine().split(" +");     // Catch: Throwable -> L10
        long r102 = CastLongProtector.parseLong(r101[4]);     // Catch: Throwable -> L10
        long r103 = ((((CastLongProtector.parseLong(r101[2]) + CastLongProtector.parseLong(r101[3])) + CastLongProtector.parseLong(r101[5])) + CastLongProtector.parseLong(r101[6])) + CastLongProtector.parseLong(r101[7])) + CastLongProtector.parseLong(r101[8]);
        Thread.sleep(CPU_STAT_WAITING);     // Catch: Exception -> L13 Throwable -> L10
    L7:
        r100.seek(0);     // Catch: Throwable -> L10
        String r104 = r100.readLine();     // Catch: Throwable -> L10
        r100.close();     // Catch: Throwable -> L10
        String[] r105 = r104.split(" +");     // Catch: Throwable -> L10
        long r106 = CastLongProtector.parseLong(r105[4]);     // Catch: Throwable -> L10
        long r110 = ((((CastLongProtector.parseLong(r105[2]) + CastLongProtector.parseLong(r105[3])) + CastLongProtector.parseLong(r105[5])) + CastLongProtector.parseLong(r105[6])) + CastLongProtector.parseLong(r105[7])) + CastLongProtector.parseLong(r105[8]);
        return (r110 - r103) / ((r110 + r106) - (r103 + r102));
    L10:
        th = move-exception;
        th.printStackTrace();
        return 0.0f;
    }

    public static long getNativePss() {
        Debug.MemoryInfo r100 = new Debug.MemoryInfo();
        Debug.getMemoryInfo(r100);
        return r100.nativePss;
    }

    public static long getOtherPss() {
        Debug.MemoryInfo r100 = new Debug.MemoryInfo();
        Debug.getMemoryInfo(r100);
        return r100.otherPss;
    }

    public static long getTotalPss() {
        Debug.MemoryInfo r100 = new Debug.MemoryInfo();
        Debug.getMemoryInfo(r100);
        return r100.getTotalPss();
    }

    private static int getNumCoresScore() {
        int r100 = e0.c();
        if (r100 >= 1) goto L6;
        return 0;
    L6:
        if (r100 != 1) goto L10;
        return 2;
    L10:
        if (r100 > 3) goto L13;
        return 4;
    L13:
        return 6;
    }

    private PerformanceUtil() {
    }

    public static String getCpuSpeedRate() {
        return sCpuSpeedRateValue;
    }

    public static String getCpuUsage(String r100) {
        if ((SystemClock.elapsedRealtime() - sLastGetCpuTime) <= 5000) goto L6;
        i60.a.c();
        sCpuValue = String.valueOf(i60.a.d());
        sLastGetCpuTime = SystemClock.elapsedRealtime();
    L6:
        return sCpuValue;
    }

    private static int getRamScore(Context r100) {
        e0.a r101 = e0.f66128a;
        ActivityManager.MemoryInfo r102 = new ActivityManager.MemoryInfo();
        ActivityManager r103 = (ActivityManager) r100.getSystemService("activity");
        if (r103 != null) goto L5;
        long r104 = -1;
    L6:
        int[] r105 = MAX_RAM_FOR_SCORE;
        if (r104 > (((long) r105[0]) * 1048576)) goto L10;
        return 0;
    L10:
        if (r104 > (((long) r105[1]) * 1048576)) goto L13;
        return 1;
    L13:
        if (r104 > (((long) r105[2]) * 1048576)) goto L16;
        return 2;
    L16:
        if (r104 > (((long) r105[3]) * 1048576)) goto L19;
        return 3;
    L19:
        if (r104 > (((long) r105[4]) * 1048576)) goto L22;
        return 4;
    L22:
        if (r104 > (((long) r105[5]) * 1048576)) goto L25;
        return 5;
    L25:
        if (r104 > (((long) r105[6]) * 1048576)) goto L27;
        return 6;
    L27:
        return 7;
    L5:
        r103.getMemoryInfo(r102);
        r104 = r102.totalMem;
        goto L6
    }

    public static int getTotalScore(Context r100) {
        int r101 = getNumCoresScore();
        int r102 = getClockSpeedScore();
        int r103 = getRamScore(r100);
        Logger.d("PUtil", "coreScore " + r101 + " clockSpeedScore " + r102 + " ramScore " + r103);
        if (r101 == 0) goto L23;
        if (r102 == 0) goto L29;
        if (r103 != 0) goto L8;
        return 0;
    L8:
        if (r101 <= 4) goto L21;
        if (r102 <= 4) goto L27;
        if (r103 > 4) goto L13;
        return 1;
    L13:
        if (r101 == 6) goto L15;
        return 2;
    L15:
        if (r102 != 7) goto L25;
        if (r103 != 7) goto L26;
        return 3;
    L26:
        return 2;
    L25:
        return 2;
    L27:
        return 1;
    L21:
        return 1;
    L29:
        return 0;
    L23:
        return 0;
    }
}
