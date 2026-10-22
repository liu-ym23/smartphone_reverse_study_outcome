package com.stepos.core.performance.signal;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Debug;
import android.os.PowerManager;
import com.stepos.base.awareness.data.ThermalState;
import com.stepos.core.ability.speech.PcmDumpBudget;
import com.stepos.core.common.cloud.FileStorageUploader;
import com.stepos.core.ota.crypto.CryptoHeaderParser;
import com.stepos.core.performance.data.AicGroupPressureLevel;
import com.stepos.core.performance.data.CpuTopology;
import com.stepos.core.performance.data.SignalSnapshot;
import com.tonyodev.fetch2core.server.FileResponse;
import gc.a;
import gc.n;
import gc.o;
import gc.q;
import java.io.File;
import java.nio.charset.Charset;
import java.util.Locale;
import kotlin.Pair;
import kotlin.Result;
import kotlin.b;
import kotlin.c;
import kotlin.jvm.internal.g;
import lb.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class SystemStateCollector {
    private final long CACHE_TTL_MS;
    private final d activityManager$delegate;
    private volatile long cacheTimestampMs;
    private volatile SignalSnapshot cachedSnapshot;
    private final Context context;
    private volatile CpuTopology cpuTopology;
    private final IPerformanceDataProvider perfDataProvider;

    public SystemStateCollector(Context context, IPerformanceDataProvider perfDataProvider) {
        g.f(context, "context");
        g.f(perfDataProvider, "perfDataProvider");
        this.context = context;
        this.perfDataProvider = perfDataProvider;
        this.activityManager$delegate = b.b(new b6.g(this, 12));
        this.CACHE_TTL_MS = FileStorageUploader.LOG_HEARTBEAT_MS;
        this.cpuTopology = perfDataProvider.getCpuTopology();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ActivityManager activityManager_delegate$lambda$0(SystemStateCollector systemStateCollector) {
        Object systemService = systemStateCollector.context.getSystemService("activity");
        g.d(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        return (ActivityManager) systemService;
    }

    public static /* synthetic */ SignalSnapshot collect$default(SystemStateCollector systemStateCollector, boolean z, long j10, Integer num, int i10, long j11, long j12, int i11, String str, long j13, long j14, long j15, long j16, AicGroupPressureLevel aicGroupPressureLevel, int i12, long j17, boolean z3, int i13, Object obj) {
        boolean z10;
        SystemStateCollector systemStateCollector2;
        boolean z11;
        long j18;
        Integer num2;
        int i14;
        long j19;
        long j20;
        int i15;
        String str2;
        long j21;
        long j22;
        long j23;
        long j24;
        AicGroupPressureLevel aicGroupPressureLevel2 = (i13 & 4096) != 0 ? AicGroupPressureLevel.NORMAL : aicGroupPressureLevel;
        int i16 = (i13 & PcmDumpBudget.HARD_MAX_DIR_MB) != 0 ? 0 : i12;
        long j25 = (i13 & 16384) != 0 ? 0L : j17;
        if ((i13 & 32768) != 0) {
            z10 = false;
            z11 = z;
            j18 = j10;
            num2 = num;
            i14 = i10;
            j19 = j11;
            j20 = j12;
            i15 = i11;
            str2 = str;
            j21 = j13;
            j22 = j14;
            j23 = j15;
            j24 = j16;
            systemStateCollector2 = systemStateCollector;
        } else {
            z10 = z3;
            systemStateCollector2 = systemStateCollector;
            z11 = z;
            j18 = j10;
            num2 = num;
            i14 = i10;
            j19 = j11;
            j20 = j12;
            i15 = i11;
            str2 = str;
            j21 = j13;
            j22 = j14;
            j23 = j15;
            j24 = j16;
        }
        return systemStateCollector2.collect(z11, j18, num2, i14, j19, j20, i15, str2, j21, j22, j23, j24, aicGroupPressureLevel2, i16, j25, z10);
    }

    private final ActivityManager getActivityManager() {
        return (ActivityManager) this.activityManager$delegate.getValue();
    }

    private final boolean isQualcomm(String str) {
        Locale locale = Locale.ROOT;
        String upperCase = str.toUpperCase(locale);
        g.e(upperCase, "toUpperCase(...)");
        if (o.k0(upperCase, "SM", false)) {
            return true;
        }
        String HARDWARE = Build.HARDWARE;
        g.e(HARDWARE, "HARDWARE");
        String lowerCase = HARDWARE.toLowerCase(locale);
        g.e(lowerCase, "toLowerCase(...)");
        return q.l0(lowerCase, "qcom", false);
    }

    private final Pair<Integer, Boolean> readBatteryInfo() {
        try {
            Intent intentRegisterReceiver = this.context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int intExtra = intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra("level", 50) : 50;
            int intExtra2 = intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra("scale", 100) : 100;
            boolean z = true;
            int intExtra3 = intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra(FileResponse.FIELD_STATUS, 1) : 1;
            if (intExtra3 != 2 && intExtra3 != 5) {
                z = false;
            }
            if (intExtra2 > 0) {
                intExtra = (intExtra * 100) / intExtra2;
            }
            return new Pair<>(Integer.valueOf(intExtra), Boolean.valueOf(z));
        } catch (Exception unused) {
            return new Pair<>(50, Boolean.FALSE);
        }
    }

    private final float readCpuTemperature() {
        File[] fileArrListFiles;
        Long lD0;
        File file = new File("/sys/class/thermal");
        if (!file.exists() || (fileArrListFiles = file.listFiles()) == null) {
            return 35.0f;
        }
        for (File file2 : fileArrListFiles) {
            File file3 = new File(file2, FileResponse.FIELD_TYPE);
            File file4 = new File(file2, "temp");
            if (file3.exists() && file4.exists()) {
                Charset charset = a.f9106b;
                String lowerCase = q.L0(wb.d.Z(file3, charset)).toString().toLowerCase(Locale.ROOT);
                g.e(lowerCase, "toLowerCase(...)");
                if ((q.l0(lowerCase, "cpu", false) || q.l0(lowerCase, "skin", false) || q.l0(lowerCase, "soc", false)) && (lD0 = n.d0(q.L0(wb.d.Z(file4, charset)).toString())) != null) {
                    long jLongValue = lD0.longValue();
                    float f8 = jLongValue;
                    if (jLongValue > 1000) {
                        f8 /= 1000.0f;
                    }
                    if (10.0f <= f8 && f8 <= 100.0f) {
                        return f8;
                    }
                }
            }
        }
        return 35.0f;
    }

    private final ActivityManager.MemoryInfo readMemoryInfo() {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        getActivityManager().getMemoryInfo(memoryInfo);
        return memoryInfo;
    }

    private final long readSelfProcessMemMb() {
        try {
            Debug.getMemoryInfo(new Debug.MemoryInfo());
            return r4.getTotalPss() / 1024;
        } catch (Exception unused) {
            return 0L;
        }
    }

    @SuppressLint({"NewApi"})
    private final String readSocModel() {
        if (Build.VERSION.SDK_INT >= 31) {
            String SOC_MODEL = Build.SOC_MODEL;
            g.e(SOC_MODEL, "SOC_MODEL");
            String upperCase = SOC_MODEL.toUpperCase(Locale.ROOT);
            g.e(upperCase, "toUpperCase(...)");
            return upperCase;
        }
        String HARDWARE = Build.HARDWARE;
        g.e(HARDWARE, "HARDWARE");
        String upperCase2 = HARDWARE.toUpperCase(Locale.ROOT);
        g.e(upperCase2, "toUpperCase(...)");
        return upperCase2;
    }

    private final float readThermalHeadroom() {
        Object systemService = this.context.getSystemService("power");
        PowerManager powerManager = systemService instanceof PowerManager ? (PowerManager) systemService : null;
        if (powerManager != null) {
            try {
                return powerManager.getThermalHeadroom(30);
            } catch (Exception unused) {
            }
        }
        return -1.0f;
    }

    private final ThermalState readThermalState(float f8) {
        Object objA;
        Object systemService = this.context.getSystemService("power");
        PowerManager powerManager = systemService instanceof PowerManager ? (PowerManager) systemService : null;
        if (powerManager != null) {
            try {
                objA = Integer.valueOf(powerManager.getCurrentThermalStatus());
            } catch (Throwable th) {
                objA = c.a(th);
            }
        } else {
            objA = null;
        }
        Integer num = (Integer) (objA instanceof Result.Failure ? null : objA);
        if ((num != null && num.intValue() == 0) || (num != null && num.intValue() == 1)) {
            return ThermalState.f6200b;
        }
        if (num != null && num.intValue() == 2) {
            return ThermalState.f6201c;
        }
        if (num != null && num.intValue() == 3) {
            return ThermalState.f6202d;
        }
        if ((num != null && num.intValue() == 4) || ((num != null && num.intValue() == 5) || (num != null && num.intValue() == 6))) {
            return ThermalState.f6203e;
        }
        ThermalState.f6199a.getClass();
        return f8 < 40.0f ? ThermalState.f6200b : f8 < 45.0f ? ThermalState.f6201c : f8 < 50.0f ? ThermalState.f6202d : ThermalState.f6203e;
    }

    public final SignalSnapshot collect(boolean z, long j10, Integer num, int i10, long j11, long j12, int i11, String str, long j13, long j14, long j15, long j16, AicGroupPressureLevel aicgroupPressureLevel, int i12, long j17, boolean z3) {
        g.f(aicgroupPressureLevel, "aicgroupPressureLevel");
        long jCurrentTimeMillis = System.currentTimeMillis();
        SignalSnapshot signalSnapshot = this.cachedSnapshot;
        if (signalSnapshot != null && jCurrentTimeMillis - this.cacheTimestampMs < this.CACHE_TTL_MS) {
            return SignalSnapshot.copy$default(signalSnapshot, 0.0f, 0.0f, null, 0, false, 0L, 0L, 0L, false, z, j10, num, null, false, false, null, i10, j11, j12, i11, str, j13, j14, j15, j16, null, aicgroupPressureLevel, i12, j17, z3, 0L, 1107358207, null);
        }
        float cpuTemperature = readCpuTemperature();
        float thermalHeadroom = readThermalHeadroom();
        ThermalState thermalState = readThermalState(cpuTemperature);
        Pair<Integer, Boolean> batteryInfo = readBatteryInfo();
        int iIntValue = batteryInfo.f9985a.intValue();
        boolean zBooleanValue = batteryInfo.f9986b.booleanValue();
        ActivityManager.MemoryInfo memoryInfo = readMemoryInfo();
        long selfProcessMemMb = readSelfProcessMemMb();
        String socModel = readSocModel();
        long j18 = memoryInfo.availMem;
        long j19 = CryptoHeaderParser.MAX_BLOCK_SIZE;
        SignalSnapshot signalSnapshot2 = new SignalSnapshot(cpuTemperature, thermalHeadroom, thermalState, iIntValue, zBooleanValue, j18 / j19, memoryInfo.totalMem / j19, selfProcessMemMb, memoryInfo.lowMemory, z, j10, num, socModel, isQualcomm(socModel), isQualcomm(socModel), this.cpuTopology, i10, j11, j12, i11, str, j13, j14, j15, j16, kotlin.collections.b.d0(), aicgroupPressureLevel, i12, j17, z3, 0L, 1073741824, null);
        this.cachedSnapshot = signalSnapshot2;
        this.cacheTimestampMs = jCurrentTimeMillis;
        return signalSnapshot2;
    }

    public final void invalidate() {
        this.cacheTimestampMs = 0L;
    }

    public final void refreshCpuTopology() {
        this.cpuTopology = this.perfDataProvider.getCpuTopology();
    }
}
