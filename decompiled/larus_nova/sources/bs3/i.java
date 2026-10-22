package bs3;

import android.app.usage.NetworkStatsManager;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.services.apm.api.EnsureManager;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes14.dex */
public final class i extends b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long[] f20257e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Method f20258f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Object f20259g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f20260h;

    public i() {
        super(BatteryTypeInf.BATTERY_NET_ALL_INTERFACE);
        this.f20260h = false;
    }

    public final long[] j() throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        if (this.f20258f != null) goto L10;
        NetworkStatsManager r100 = (NetworkStatsManager) com.bytedance.apm.d.getContext().getSystemService("netstats");
        Field r101 = r100.getClass().getDeclaredField("mService");
        r101.setAccessible(true);
        Object r102 = r101.get(r100);
        this.f20259g = r102;
        Method[] r103 = r102.getClass().getDeclaredMethods();
        int r104 = r103.length;
        int r105 = 0;
    L5:
        if (r105 >= r104) goto L10;
        Method r106 = r103[r105];
        if (TextUtils.equals("getDataLayerSnapshotForUid", r106.getName()) == true) goto L8;
        r105 = r105 + 1;
        goto L5
    L8:
        this.f20258f = r106;
        r106.setAccessible(true);
    L10:
        Object r107 = this.f20258f.invoke(this.f20259g, new Object[]{Integer.valueOf(Process.myUid())});
        Field r108 = r107.getClass().getDeclaredField("rxBytes");
        r108.setAccessible(true);
        long[] r109 = (long[]) r108.get(r107);
        Field r110 = r107.getClass().getDeclaredField("txBytes");
        r110.setAccessible(true);
        long[] r111 = (long[]) r110.get(r107);
        Field r112 = r107.getClass().getDeclaredField("rxPackets");
        r112.setAccessible(true);
        long[] r113 = (long[]) r112.get(r107);
        Field r114 = r107.getClass().getDeclaredField("txPackets");
        r114.setAccessible(true);
        return new long[]{l(r109) + l(r111), l(r113) + l((long[]) r114.get(r107))};
    }

    public static long l(long[] r100) {
        long r101 = 0;
        if (r100 != null) goto L5;
    L10:
        return r101;
    L5:
        if (r100.length == 0) goto L10;
        int r102 = r100.length;
        int r103 = 0;
    L8:
        if (r103 >= r102) goto L10;
        r101 = r101 + r100[r103];
        r103 = r103 + 1;
        goto L8
    }

    @Override // bs3.l
    public final void a(as3.c r100, ms3.a r101) {
        if (r101.f515465b == false) goto L11;
        if (TextUtils.equals(r101.f515471h, "source_bytes") == false) goto L8;
        r100.f16107k += r101.f515470g;
        return;
    L8:
        if (TextUtils.equals(r101.f515471h, "source_packets") == false) goto L18;
        r100.f16108l += r101.f515470g;
        return;
    L18:
        return;
    L11:
        if (TextUtils.equals(r101.f515471h, "source_bytes") == false) goto L14;
        r100.f16116t += r101.f515470g;
        return;
    L14:
        if (TextUtils.equals(r101.f515471h, "source_packets") == false) goto L21;
        r100.f16117u += r101.f515470g;
        return;
    }

    @Override // bs3.b
    public final void e(boolean r110, boolean r111) {
        if (this.f20237d == true) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT >= 23) goto L21;
        return;
    L21:
        long[] r100 = j();     // Catch: Throwable -> L13
        long[] r101 = this.f20257e;     // Catch: Throwable -> L13
        if (r101 == null) goto L11;
        if (r111 == false) goto L11;
        String r112 = vr3.b.e.f556835a.f556824u;     // Catch: Throwable -> L13
        k(r110, r100[0] - r101[0], "source_bytes", r112);     // Catch: Throwable -> L13
        k(r110, r100[1] - this.f20257e[1], "source_packets", r112);     // Catch: Throwable -> L13
    L11:
        this.f20257e = r100;     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        if (com.bytedance.apm.d.j() == false) goto L18;
        ps3.b.a(new String[]{"handleTrafficMonitor error: " + th.getCause()});
    L18:
        if (this.f20260h == true) goto L25;
        EnsureManager.ensureNotReachHere(th, "BatteryTrafficAllInterface");
        this.f20260h = true;
        return;
    }

    public final void k(boolean r110, long r111, String r112, String r113) {
        if (r111 < 0) goto L5;
        as3.b.a.f16095a.g(new ms3.a(r110, System.currentTimeMillis(), BatteryTypeInf.BATTERY_NET_ALL_INTERFACE, this.f20235b, r111, r113, r112));
        return;
    L5:
        if (com.bytedance.apm.d.j() == false) goto L8;
        ps3.b.a(new String[]{"BatteryTrafficAllInterface value error: " + r111});
    }
}
