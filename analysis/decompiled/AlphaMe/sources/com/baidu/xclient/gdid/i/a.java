package com.baidu.xclient.gdid.i;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Point;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.view.Display;
import android.view.WindowManager;
import com.baidu.platform.comapi.bmsdk.BmLocated;
import com.baidu.xclient.gdid.j.d;
import com.stepos.alphame.perfbinder.PerfBinderHelper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import okhttp3.internal.ws.RealWebSocket;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static long f9531a;

    /* renamed from: b, reason: collision with root package name */
    public static long f9532b;

    /* renamed from: c, reason: collision with root package name */
    public static long f9533c;

    /* renamed from: d, reason: collision with root package name */
    public static long f9534d;

    public static int a(long j4) {
        try {
            if (g()) {
                String upperCase = Build.BOARD.trim().toUpperCase();
                if (upperCase.startsWith("SQW100-")) {
                    return 3072;
                }
                if (!upperCase.startsWith("SQC100-") && !upperCase.startsWith("SQK100-") && !upperCase.startsWith("SQN100-") && !upperCase.startsWith("SQR100-") && !upperCase.startsWith("STA100-") && !upperCase.startsWith("STK100-") && !upperCase.startsWith("STL100-") && !upperCase.startsWith("STR100-")) {
                    if (upperCase.startsWith("STJ100-")) {
                        return 1536;
                    }
                }
                return 2048;
            }
            float f4 = j4 / 1024.0f;
            if (f4 > 10.0f) {
                return 12288;
            }
            if (f4 > 8.0f) {
                return BmLocated.HALF_RIGHT_BOTTOM;
            }
            if (f4 > 7.0f) {
                return 8192;
            }
            if (f4 > 5.0f) {
                return BmLocated.HALF_LEFT_BOTTOM;
            }
            if (f4 > 4.0f) {
                return BmLocated.HALF_LEFT_TOP;
            }
            if (f4 > 3.0f) {
                return 4096;
            }
            if (f4 > 2.0f) {
                return 3072;
            }
            if (f4 > 1.0f) {
                return 2048;
            }
            if (f4 > 0.75f) {
                return 1024;
            }
            if (f4 > 0.5f) {
                return 768;
            }
            return f4 > 0.25f ? 512 : 0;
        } catch (Throwable th) {
            d.a(th);
            return 0;
        }
    }

    public static long b() {
        try {
            if (!"mounted".equals(Environment.getExternalStorageState())) {
                return -1L;
            }
            if (f9534d == 0) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                f9534d = statFs.getAvailableBlocks() * statFs.getBlockSize();
            }
            return f9534d;
        } catch (Throwable th) {
            d.a(th);
            return -1L;
        }
    }

    public static long c() {
        try {
            if (f9531a == 0) {
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                f9531a = statFs.getBlockSize() * statFs.getBlockCount();
            }
            return f9531a;
        } catch (Throwable th) {
            d.a(th);
            return -1L;
        }
    }

    public static int d(Context context) {
        try {
            return context.getResources().getConfiguration().orientation == 2 ? 0 : 1;
        } catch (Throwable th) {
            d.a(th);
            return 1;
        }
    }

    public static int e(Context context) {
        try {
            BatteryManager batteryManager = (BatteryManager) context.getSystemService("batterymanager");
            if (batteryManager == null) {
                return 0;
            }
            return batteryManager.getIntProperty(4);
        } catch (Throwable th) {
            d.a(th);
            return 0;
        }
    }

    public static String f() {
        try {
            return Build.MANUFACTURER.trim();
        } catch (Throwable th) {
            d.a(th);
            return "";
        }
    }

    public static long g(Context context) {
        try {
            long jH = h(context);
            return jH <= 0 ? e() : jH;
        } catch (Throwable th) {
            d.a(th);
            return 0L;
        }
    }

    @SuppressLint({"NewApi"})
    public static long h(Context context) {
        if (context != null) {
            try {
                ActivityManager activityManager = (ActivityManager) context.getSystemService(PerfBinderHelper.EVENT_KIND_ACTIVITY);
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                if (activityManager == null) {
                    return 0L;
                }
                activityManager.getMemoryInfo(memoryInfo);
                return memoryInfo.totalMem / 1048576;
            } catch (Throwable th) {
                d.a(th);
            }
        }
        return 0L;
    }

    public static long a() {
        try {
            if (!"mounted".equals(Environment.getExternalStorageState())) {
                return -1L;
            }
            if (f9533c == 0) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                f9533c = statFs.getBlockSize() * statFs.getBlockCount();
            }
            return f9533c;
        } catch (Throwable th) {
            d.a(th);
            return -1L;
        }
    }

    public static String b(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(PerfBinderHelper.EVENT_KIND_ACTIVITY);
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            int i4 = (int) (memoryInfo.availMem / 1048576);
            return i4 % 1024 == 0 ? String.format("%d %s", Integer.valueOf(i4 / 1024), "GB") : (i4 < 1024 || i4 % 512 != 0) ? a(Long.valueOf(i4)) : String.format("%.1f %s", Float.valueOf(i4 / 1024.0f), "GB");
        } catch (Throwable th) {
            d.a(th);
            return "";
        }
    }

    public static String c(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            return "";
        }
        Display defaultDisplay = windowManager.getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        int i4 = point.x;
        return point.y + "X" + i4;
    }

    public static long d() {
        try {
            if (f9532b == 0) {
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                f9532b = statFs.getBlockSize() * statFs.getAvailableBlocks();
            }
            return f9532b;
        } catch (Throwable th) {
            d.a(th);
            return -1L;
        }
    }

    @SuppressLint({"DefaultLocale"})
    public static long e() {
        BufferedReader bufferedReader;
        String line;
        File fileA = com.baidu.mshield.b.e.a.a(com.baidu.xclient.gdid.d.f9502b, "/proc/meminfo");
        long j4 = 0;
        if (fileA != null && fileA.exists()) {
            try {
                bufferedReader = new BufferedReader(new FileReader(fileA));
                do {
                    try {
                        line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            d.a(th);
                            return j4;
                        } finally {
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Throwable th2) {
                                    d.a(th2);
                                }
                            }
                        }
                    }
                } while (!line.startsWith("MemTotal:"));
                String upperCase = line.substring(9).trim().toUpperCase();
                int iIndexOf = upperCase.indexOf(" KB");
                if (iIndexOf > 0) {
                    long jA = a(upperCase.substring(0, iIndexOf));
                    if (jA > 0) {
                        j4 = jA / RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
        }
        return j4;
    }

    public static boolean f(Context context) {
        try {
            int intExtra = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")).getIntExtra("status", -1);
            return intExtra == 2 || intExtra == 5;
        } catch (Throwable th) {
            d.a(th);
            return false;
        }
    }

    public static boolean g() {
        try {
            if (!f().toUpperCase().equals("BLACKBERRY")) {
                if (!f().equals("RIM")) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            d.a(th);
            return false;
        }
    }

    public static long a(String str) {
        try {
            return Long.valueOf(str).longValue();
        } catch (NumberFormatException e4) {
            d.a(e4);
            return Long.MIN_VALUE;
        }
    }

    public static String a(Context context) {
        try {
            int iA = a(g(context));
            if (iA <= 0) {
                return null;
            }
            return iA % 1024 == 0 ? String.format("%d %s", Integer.valueOf(iA / 1024), "GB") : (iA < 1024 || iA % 512 != 0) ? a(Long.valueOf(iA)) : String.format("%.1f %s", Float.valueOf(iA / 1024.0f), "GB");
        } catch (Throwable th) {
            d.a(th);
            return null;
        }
    }

    public static String a(Long l4) {
        try {
            return l4.longValue() >= 10240 ? String.format("%.2f %s", Float.valueOf(l4.longValue() / 1024.0f), "GB") : String.format("%d %s", l4, "MB");
        } catch (Throwable th) {
            d.a(th);
            return "";
        }
    }
}
