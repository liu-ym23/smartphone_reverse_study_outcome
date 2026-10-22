package e1;

import android.os.BatteryManager;
import com.bytedance.apm.battery.config.BatteryTypeInf;

/* JADX INFO: loaded from: classes.dex */
public class e extends b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final BatteryManager f19253e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f19254f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f19255g;

    public e() {
        super(BatteryTypeInf.BATTERY_CONSUME);
        this.f19254f = false;
        this.f19255g = -1;
        this.f19253e = (BatteryManager) w0.c.g().getSystemService("batterymanager");
    }

    @Override // e1.b
    public void a(boolean r10, boolean r11) {
        if (b() == true) goto L5;
        return;
    L5:
        if (r10 == true) goto L20;
    L12:
        boolean r12 = true;
    L13:
        d(r11, r12);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        if (w0.c.B() == false) goto L18;
        s1.c.d(s1.b.f24484b, new String[]{"BatteryConsumeStatsImpl error: " + th.getCause()});
    L18:
        i6.a.a("BatteryConsumeStatsImpl");
        return;
    L20:
        if (this.f19239b == true) goto L12;
        r12 = false;
        goto L13
    }

    public final void d(boolean r10, boolean r11) {
        int r12 = this.f19253e.getIntProperty(1);
        if (r11 == true) goto L8;
        if (r10 == false) goto L8;
        if (this.f19254f == false) goto L8;
        c(true, Math.abs(r12 - this.f19255g), y0.a.E().D());
    L8:
        this.f19255g = r12;
        this.f19254f = true;
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void updateStatsRet(d1.b r10, p1.a r11) {
        r10.j(r11.a() / 1000);
    }
}
