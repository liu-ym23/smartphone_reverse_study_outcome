package bs3;

import com.bytedance.apm.battery.config.BatteryTypeInf;

/* JADX INFO: loaded from: classes14.dex */
public final class f extends b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f20252e;

    public f() {
        super(BatteryTypeInf.BATTERY_CPU_ACTIVE);
        this.f20252e = 0;
    }

    @Override // bs3.l
    public final void a(as3.c r100, ms3.a r101) {
        if (r101.f515465b == false) goto L5;
        r100.f16101e += (long) ((r101.f515470g / com.bytedance.apm.util.b.f()) * 1000.0d);
        return;
    L5:
        r100.f16110n += (long) ((r101.f515470g / com.bytedance.apm.util.b.f()) * 1000.0d);
    }

    @Override // bs3.b
    public final void e(boolean r100, boolean r101) {
        long r102 = com.bytedance.apm.util.b.a();
        long r103 = this.f20252e;
        if (r103 <= 0) goto L9;
        if (r101 == false) goto L9;
        long r104 = r102 - r103;
        if (r104 <= 0) goto L9;
        g(r100, r104, vr3.b.e.f556835a.f556824u);
    L9:
        this.f20252e = r102;
    }
}
