package ff;

import android.content.Context;
import android.content.IntentFilter;
import android.os.BatteryManager;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static BatteryManager f19681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static IntentFilter f19682b;

    static {
        f19682b = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    }

    public static BatteryManager a(Context r10) {
        if (f19681a != null) goto L16;
        monitor-enter(b.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f19681a != null) goto L11;
        f19681a = (BatteryManager) r10.getSystemService("batterymanager");     // Catch: Throwable -> L9
    L11:
        monitor-exit(b.class);     // Catch: Throwable -> L9
    L16:
        return f19681a;
    }

    public static float b(Context r10) {
        if (r10 != null) goto L5;
        return -1.0f;
    L5:
        BatteryManager r11 = a(r10);
        if (r11 != null) goto L8;
        return -1.0f;
    L8:
        float r12 = r11.getLongProperty(2);
        if (r12 >= (-1.0E7f)) goto L11;
    L31:
        return -1.0f;
    L11:
        if (r12 > 1.0E7f) goto L31;
        if (c.c() == true) goto L27;
        if (c.b() == true) goto L27;
        if (c.a() == false) goto L25;
        if (r12 > 10000.0f) goto L23;
        return r12;
    L23:
        return r12 / 1000.0f;
    L25:
        return r12 / 1000.0f;
    L27:
        if (r12 >= (-10000.0f)) goto L30;
        r12 = r12 / 1000.0f;
    L30:
        return -r12;
    }
}
