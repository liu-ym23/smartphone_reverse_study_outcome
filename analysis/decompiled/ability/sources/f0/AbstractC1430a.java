package f0;

import android.content.IntentFilter;
import android.os.BatteryManager;

/* renamed from: f0.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC1430a {

    /* renamed from: a, reason: collision with root package name */
    public static BatteryManager f4432a;

    static {
        new IntentFilter("android.intent.action.BATTERY_CHANGED");
    }
}
