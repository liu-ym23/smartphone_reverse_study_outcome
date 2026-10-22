package androidx.work.impl.utils;

import android.content.Context;
import android.os.PowerManager;
import androidx.work.Logger;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import java.util.HashMap;
import java.util.Iterator;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes28.dex */
public class WakeLocks {
    private static final String TAG = null;
    private static final WeakHashMap<PowerManager.WakeLock, String> sWakeLocks = null;

    static {
        TAG = Logger.tagWithPrefix("WakeLocks");
        sWakeLocks = new WeakHashMap();
    }

    public static void checkWakeLocks() {
        HashMap r100 = new HashMap();
        WeakHashMap<PowerManager.WakeLock, String> r101 = sWakeLocks;
        monitor-enter(r101);
        r100.putAll(r101);     // Catch: Throwable -> L15
        monitor-exit(r101);     // Catch: Throwable -> L15
        Iterator r102 = r100.keySet().iterator();
    L8:
        if (r102.hasNext() == false) goto L14;
        PowerManager.WakeLock r103 = (PowerManager.WakeLock) r102.next();
        if (r103 == null) goto L8;
        if (r103.isHeld() == false) goto L8;
        Logger.get().warning(TAG, String.format("WakeLock held for %s", new Object[]{r100.get(r103)}), new Throwable[0]);
        goto L8
    L14:
        return;
    L15:
        th = move-exception;
        throw th;
    }

    private WakeLocks() {
    }

    public static PowerManager.WakeLock newWakeLock(Context r100, String r101) {
        String r102 = "WorkManager: " + r101;
        PowerManager.WakeLock r103 = ((PowerManager) r100.getApplicationContext().getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK)).newWakeLock(1, r102);
        WeakHashMap<PowerManager.WakeLock, String> r104 = sWakeLocks;
        monitor-enter(r104);
        r104.put(r103, r102);     // Catch: Throwable -> L7
        monitor-exit(r104);     // Catch: Throwable -> L7
        return r103;
    L7:
        th = move-exception;
        throw th;
    }
}
