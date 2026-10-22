package androidx.legacy.content;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.util.SparseArray;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.obric.performance.power.monitor.cpu.d;
import fna.g;

/* JADX INFO: loaded from: classes17.dex */
public abstract class WakefulBroadcastReceiver extends BroadcastReceiver {
    private static final String EXTRA_WAKE_LOCK_ID = "androidx.contentpager.content.wakelockid";
    private static int mNextId;
    private static final SparseArray<PowerManager.WakeLock> sActiveWakeLocks = null;

    static {
        sActiveWakeLocks = new SparseArray();
        mNextId = 1;
    }

    public WakefulBroadcastReceiver() {
    }

    public static void INVOKEVIRTUAL_androidx_legacy_content_WakefulBroadcastReceiver_com_obric_performance_power_monitor_cpu_WakeLockLancet_release(PowerManager.WakeLock r100) {
        if (g.d() == true) goto L6;
        r100.release();
        return;
    L6:
        r100.release();
        d.b(r100);
    }

    public static boolean completeWakefulIntent(Intent r100) {
        int r101 = r100.getIntExtra(EXTRA_WAKE_LOCK_ID, 0);
        if (r101 != 0) goto L5;
        return false;
    L5:
        SparseArray<PowerManager.WakeLock> r102 = sActiveWakeLocks;
        monitor-enter(r102);
        PowerManager.WakeLock r103 = r102.get(r101);     // Catch: Throwable -> L15
        if (r103 == null) goto L13;
        INVOKEVIRTUAL_androidx_legacy_content_WakefulBroadcastReceiver_com_obric_performance_power_monitor_cpu_WakeLockLancet_release(r103);     // Catch: Throwable -> L15
        r102.remove(r101);     // Catch: Throwable -> L15
        monitor-exit(r102);     // Catch: Throwable -> L15
        return true;
    L13:
        monitor-exit(r102);     // Catch: Throwable -> L15
        return true;
    L15:
        th = move-exception;
        throw th;
    }

    public static void INVOKEVIRTUAL_androidx_legacy_content_WakefulBroadcastReceiver_com_obric_performance_power_monitor_cpu_WakeLockLancet_acquire(PowerManager.WakeLock r100, long r101) {
        if (g.d() == true) goto L6;
        r100.acquire(r101);
        return;
    L6:
        r100.acquire(r101);
        d.a(r100);
    }

    public static ComponentName startWakefulService(Context r100, Intent r101) {
        SparseArray<PowerManager.WakeLock> r102 = sActiveWakeLocks;
        monitor-enter(r102);
        int r103 = mNextId;     // Catch: Throwable -> L15
        int r104 = r103 + 1;     // Catch: Throwable -> L15
        mNextId = r104;     // Catch: Throwable -> L15
        if (r104 > 0) goto L7;
        mNextId = 1;     // Catch: Throwable -> L15
    L7:
        r101.putExtra(EXTRA_WAKE_LOCK_ID, r103);     // Catch: Throwable -> L15
        ComponentName r105 = r100.startService(r101);     // Catch: Throwable -> L15
        if (r105 != null) goto L12;
        monitor-exit(r102);     // Catch: Throwable -> L15
        return null;
    L12:
        PowerManager.WakeLock r106 = ((PowerManager) r100.getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK)).newWakeLock(1, "androidx.core:wake:" + r105.flattenToShortString());     // Catch: Throwable -> L15
        r106.setReferenceCounted(false);     // Catch: Throwable -> L15
        INVOKEVIRTUAL_androidx_legacy_content_WakefulBroadcastReceiver_com_obric_performance_power_monitor_cpu_WakeLockLancet_acquire(r106, 60000);     // Catch: Throwable -> L15
        r102.put(r103, r106);     // Catch: Throwable -> L15
        monitor-exit(r102);     // Catch: Throwable -> L15
        return r105;
    L15:
        th = move-exception;
        throw th;
    }
}
