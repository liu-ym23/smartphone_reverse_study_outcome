package bs3;

import android.os.BatteryManager;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.services.apm.api.EnsureManager;

/* JADX INFO: loaded from: classes14.dex */
public final class e extends b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final BatteryManager f20249e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f20250f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f20251g;

    public e() {
        super(BatteryTypeInf.BATTERY_CONSUME);
        this.f20250f = false;
        this.f20251g = -1;
        this.f20249e = (BatteryManager) com.bytedance.apm.d.getContext().getSystemService("batterymanager");
    }

    @Override // bs3.l
    public final void a(as3.c r100, ms3.a r101) {
        r100.f16109m += r101.f515470g / 1000;
    }

    @Override // bs3.b
    public final void e(boolean r100, boolean r101) {
        if (this.f20237d == true) goto L6;
        return;
    L6:
        if (r100 == true) goto L27;
    L13:
        boolean r102 = true;
    L14:
        int r103 = this.f20249e.getIntProperty(1);     // Catch: Throwable -> L11
        if (r102 == true) goto L20;
        if (r101 == false) goto L20;
        if (this.f20250f == false) goto L20;
        g(true, Math.abs(r103 - this.f20251g), vr3.b.e.f556835a.f556824u);     // Catch: Throwable -> L11
    L20:
        this.f20251g = r103;     // Catch: Throwable -> L11
        this.f20250f = true;     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        if (com.bytedance.apm.d.j() == false) goto L25;
        ps3.b.a(new String[]{"BatteryConsumeStatsImpl error: " + th.getCause()});
    L25:
        EnsureManager.ensureNotReachHere("BatteryConsumeStatsImpl");
        return;
    L27:
        if (this.f20235b == true) goto L13;
        r102 = false;
        goto L14
    }
}
