package w6;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.PowerManager;
import android.os.SystemClock;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.apm.constant.CommonServiceName;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.watson.assist.api.IAssistStat;
import u6.b;

/* JADX INFO: loaded from: classes.dex */
public class a extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PowerManager f25370c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BatteryManager f25371d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f25372e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f25373f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f25374g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f25375h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f25376i;

    public a(Context r10, IAssistStat r11) {
        super(r10, r11);
        this.f25372e = false;
        this.f25373f = -1;
        this.f25374g = 0;
        this.f25375h = 0.0f;
        this.f25376i = 0;
        this.f25370c = (PowerManager) this.f24886a.getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);
        this.f25371d = (BatteryManager) this.f24886a.getSystemService("batterymanager");
    }

    public int c() {
        i();
        return this.f25374g;
    }

    public float d() {
        i();
        return this.f25375h;
    }

    public final int e() {
        PowerManager r10 = this.f25370c;
        if (r10 != null) goto L5;
        return -1;
    L5:
        return r10.isPowerSaveMode() ? 1 : 0;
    }

    public boolean f() {
        i();
        return this.f25372e;
    }

    public final boolean g() {
        BatteryManager r10 = this.f25371d;
        if (r10 != null) goto L5;
        return false;
    L5:
        return r10.isCharging();
    }

    public int h() {
        return e();
    }

    public final synchronized void i() {
        monitor-enter(this);
        long r10 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L18
        long r11 = this.f25376i;     // Catch: Throwable -> L18
        if (r11 != 0) goto L6;
    L7:
        this.f25376i = r10;     // Catch: Throwable -> L18
        Intent r12 = this.f24886a.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));     // Catch: Throwable -> L18
        if (r12 != null) goto L11;
        monitor-exit(this);
        return;
    L11:
        int r13 = r12.getIntExtra("status", -1);     // Catch: Throwable -> L18
        this.f25373f = r13;     // Catch: Throwable -> L18
        if (r13 != 2) goto L14;
    L21:
        boolean r14 = true;
    L22:
        this.f25372e = r14;     // Catch: Throwable -> L18
        this.f25374g = r12.getIntExtra("level", 0);     // Catch: Throwable -> L18
        this.f25375h = r12.getIntExtra(CommonServiceName.MONITOR_TYPE_TEMPERATURE, 0) / 10.0f;     // Catch: Throwable -> L18
    L23:
        monitor-exit(this);
        return;
    L14:
        if (r13 == 5) goto L16;
    L20:
        r14 = false;
        goto L22
    L16:
        if (g() == false) goto L20;
    L6:
        if ((r10 - r11) < PerfConsts.DEFAULT_SERIOUS_BLOCK_INTERVAL_MS) goto L23;
    L18:
        th = move-exception;
        throw th;
    }
}
