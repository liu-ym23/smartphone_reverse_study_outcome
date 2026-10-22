package e1;

import android.app.usage.NetworkStatsManager;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.apm.battery.config.Constants;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class i extends b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f19261e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f19262f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long[] f19263g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Method f19264h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Object f19265i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f19266j;

    public i() {
        super(BatteryTypeInf.BATTERY_NET_ALL_INTERFACE);
        this.f19261e = "source_bytes";
        this.f19262f = "source_packets";
        this.f19266j = false;
    }

    @Override // e1.b
    public void a(boolean r10, boolean r11) {
        if (b() == true) goto L20;
        return;
    L20:
        long[] r12 = d();     // Catch: Throwable -> L9
        if (this.f19263g == null) goto L11;
        if (r11 == false) goto L11;
        String r13 = y0.a.E().D();     // Catch: Throwable -> L9
        e(r10, r12[0] - this.f19263g[0], "source_bytes", r13);     // Catch: Throwable -> L9
        e(r10, r12[1] - this.f19263g[1], "source_packets", r13);     // Catch: Throwable -> L9
    L11:
        this.f19263g = r12;     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        if (w0.c.B() == false) goto L17;
        s1.c.d(s1.b.f24484b, new String[]{"handleTrafficMonitor error: " + th.getCause()});
    L17:
        if (this.f19266j == true) goto L23;
        i6.a.d(th, "BatteryTrafficAllInterface");
        this.f19266j = true;
        return;
    }

    public final long[] d() {
        if (this.f19264h != null) goto L10;
        NetworkStatsManager r10 = (NetworkStatsManager) w0.c.g().getSystemService("netstats");
        Field r11 = r10.getClass().getDeclaredField("mService");
        r11.setAccessible(true);
        Object r12 = r11.get(r10);
        this.f19265i = r12;
        Method[] r13 = r12.getClass().getDeclaredMethods();
        int r14 = r13.length;
        int r15 = 0;
    L5:
        if (r15 >= r14) goto L10;
        Method r16 = r13[r15];
        if (TextUtils.equals("getDataLayerSnapshotForUid", r16.getName()) == true) goto L8;
        r15 = r15 + 1;
        goto L5
    L8:
        this.f19264h = r16;
        r16.setAccessible(true);
    L10:
        Object r17 = this.f19264h.invoke(this.f19265i, new Object[]{Integer.valueOf(Process.myUid())});
        Field r18 = r17.getClass().getDeclaredField("rxBytes");
        r18.setAccessible(true);
        long[] r19 = (long[]) r18.get(r17);
        Field r20 = r17.getClass().getDeclaredField("txBytes");
        r20.setAccessible(true);
        long[] r21 = (long[]) r20.get(r17);
        Field r22 = r17.getClass().getDeclaredField("rxPackets");
        r22.setAccessible(true);
        long[] r23 = (long[]) r22.get(r17);
        Field r24 = r17.getClass().getDeclaredField("txPackets");
        r24.setAccessible(true);
        return new long[]{f(r19) + f(r21), f(r23) + f((long[]) r24.get(r17))};
    }

    public final void e(boolean r12, long r13, String r15, String r16) {
        if (r13 < 0) goto L5;
        d1.a.h().l(new p1.a(r12, System.currentTimeMillis(), BatteryTypeInf.BATTERY_NET_ALL_INTERFACE, this.f19239b, r13, r16, r15));
        return;
    L5:
        if (w0.c.B() == false) goto L7;
        s1.c.d(s1.b.f24484b, new String[]{"BatteryTrafficAllInterface value error: " + r13});
    L7:
        s1.a.d(Constants.TAG_BATTERY, "BatteryTrafficAllInterface value error: " + r13);
    }

    public final long f(long[] r10) {
        long r11 = 0;
        if (r10 != null) goto L5;
    L10:
        return r11;
    L5:
        if (r10.length == 0) goto L10;
        int r12 = r10.length;
        int r13 = 0;
    L8:
        if (r13 >= r12) goto L10;
        r11 = r11 + r10[r13];
        r13 = r13 + 1;
        goto L8
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void updateStatsRet(d1.b r10, p1.a r11) {
        if (r11.k() == false) goto L11;
        if (TextUtils.equals(r11.e(), "source_bytes") == false) goto L8;
        r10.k(r11.a());
        return;
    L8:
        if (TextUtils.equals(r11.e(), "source_packets") == false) goto L18;
        r10.o(r11.a());
        return;
    L18:
        return;
    L11:
        if (TextUtils.equals(r11.e(), "source_bytes") == false) goto L14;
        r10.a(r11.a());
        return;
    L14:
        if (TextUtils.equals(r11.e(), "source_packets") == false) goto L21;
        r10.e(r11.a());
        return;
    }
}
