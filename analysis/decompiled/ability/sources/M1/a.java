package M1;

import K1.b;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.PowerManager;
import android.os.SystemClock;
import com.stepos.aiengine.algorithm.chat.LlmRuntimeArgsBundle;

/* loaded from: classes2.dex */
public final class a extends b {
    public PowerManager c;
    public BatteryManager d;
    public boolean e;
    public int f;
    public float g;
    public long h;

    public final synchronized void d() {
        boolean z10;
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j5 = this.h;
            if (j5 == 0 || jElapsedRealtime - j5 >= 5000) {
                this.h = jElapsedRealtime;
                Intent intentRegisterReceiver = ((Context) this.f904a).registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
                if (intentRegisterReceiver == null) {
                    return;
                }
                int intExtra = intentRegisterReceiver.getIntExtra("status", -1);
                if (intExtra == 2) {
                    z10 = true;
                    this.e = z10;
                    this.f = intentRegisterReceiver.getIntExtra("level", 0);
                    this.g = intentRegisterReceiver.getIntExtra(LlmRuntimeArgsBundle.KEY_TEMPERATURE, 0) / 10.0f;
                } else {
                    if (intExtra == 5) {
                        BatteryManager batteryManager = this.d;
                        if (batteryManager != null ? batteryManager.isCharging() : false) {
                            z10 = true;
                            this.e = z10;
                            this.f = intentRegisterReceiver.getIntExtra("level", 0);
                            this.g = intentRegisterReceiver.getIntExtra(LlmRuntimeArgsBundle.KEY_TEMPERATURE, 0) / 10.0f;
                        }
                    }
                    z10 = false;
                    this.e = z10;
                    this.f = intentRegisterReceiver.getIntExtra("level", 0);
                    this.g = intentRegisterReceiver.getIntExtra(LlmRuntimeArgsBundle.KEY_TEMPERATURE, 0) / 10.0f;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
