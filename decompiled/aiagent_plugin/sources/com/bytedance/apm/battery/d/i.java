package com.bytedance.apm.battery.d;

import android.app.usage.NetworkStatsManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: BatteryTrafficAllInterface.java */
/* JADX INFO: loaded from: classes.dex */
public class i extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f4318c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f4319d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long[] f4320e;
    private Method f;
    private Object g;
    private boolean h;

    public i() {
        super("traffic_all_interface");
        this.f4318c = "source_bytes";
        this.f4319d = "source_packets";
        this.h = false;
    }

    @Override // com.bytedance.apm.battery.d.b
    public void b(boolean r10, boolean r11) {
        if (a() == true) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT >= 23) goto L21;
        return;
    L21:
        long[] r2 = b();     // Catch: Throwable -> L13
        if (this.f4320e == null) goto L11;
        if (r11 == false) goto L11;
        String r12 = com.bytedance.apm.battery.a.a().h();     // Catch: Throwable -> L13
        a(r10, r2[0] - this.f4320e[0], "source_bytes", r12);     // Catch: Throwable -> L13
        a(r10, r2[1] - this.f4320e[1], "source_packets", r12);     // Catch: Throwable -> L13
    L11:
        this.f4320e = r2;     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        if (com.bytedance.apm.c.i() == false) goto L18;
        com.bytedance.apm.h.e.c(com.bytedance.apm.h.b.f4646b, new String[]{"handleTrafficMonitor error: " + th.getCause()});
    L18:
        if (this.h == true) goto L25;
        com.bytedance.services.apm.api.a.a(th, "BatteryTrafficAllInterface");
        this.h = true;
        return;
    }

    private void a(boolean r12, long r13, String r15, String r16) {
        if (r13 < 0) goto L5;
        com.bytedance.apm.battery.c.a.a().a(new com.bytedance.apm.e.a(r12, System.currentTimeMillis(), "traffic_all_interface", this.f4301b, r13, r16, r15));
        return;
    L5:
        if (com.bytedance.apm.c.i() == false) goto L7;
        com.bytedance.apm.h.e.c(com.bytedance.apm.h.b.f4646b, new String[]{"BatteryTrafficAllInterface value error: " + r13});
    L7:
        com.bytedance.apm.h.a.b("APM-Battery", "BatteryTrafficAllInterface value error: " + r13);
    }

    private long[] b() {
        if (this.f != null) goto L10;
        NetworkStatsManager r1 = (NetworkStatsManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService("netstats"), NetworkStatsManager.class, "com.obric.aiagent.plugin");
        Field r5 = r1.getClass().getDeclaredField("mService");
        r5.setAccessible(true);
        Object r2 = r5.get(r1);
        this.g = r2;
        Method[] r3 = r2.getClass().getDeclaredMethods();
        int r6 = r3.length;
        int r7 = 0;
    L5:
        if (r7 >= r6) goto L10;
        Method r8 = r3[r7];
        if (TextUtils.equals("getDataLayerSnapshotForUid", r8.getName()) == true) goto L8;
        r7 = r7 + 1;
        goto L5
    L8:
        this.f = r8;
        r8.setAccessible(true);
    L10:
        Object r4 = this.f.invoke(this.g, new Object[]{Integer.valueOf(Process.myUid())});
        Field r9 = r4.getClass().getDeclaredField("rxBytes");
        r9.setAccessible(true);
        long[] r10 = (long[]) ZeusTransformUtils.preCheckCast((long[]) ZeusTransformUtils.preCheckCast(r9.get(r4), long[].class, "com.obric.aiagent.plugin"), long[].class, "com.obric.aiagent.plugin");
        Field r11 = r4.getClass().getDeclaredField("txBytes");
        r11.setAccessible(true);
        long[] r12 = (long[]) ZeusTransformUtils.preCheckCast((long[]) ZeusTransformUtils.preCheckCast(r11.get(r4), long[].class, "com.obric.aiagent.plugin"), long[].class, "com.obric.aiagent.plugin");
        Field r13 = r4.getClass().getDeclaredField("rxPackets");
        r13.setAccessible(true);
        long[] r14 = (long[]) ZeusTransformUtils.preCheckCast((long[]) ZeusTransformUtils.preCheckCast(r13.get(r4), long[].class, "com.obric.aiagent.plugin"), long[].class, "com.obric.aiagent.plugin");
        Field r15 = r4.getClass().getDeclaredField("txPackets");
        r15.setAccessible(true);
        return new long[]{a(r10) + a(r12), a(r14) + a((long[]) ZeusTransformUtils.preCheckCast((long[]) ZeusTransformUtils.preCheckCast(r15.get(r4), long[].class, "com.obric.aiagent.plugin"), long[].class, "com.obric.aiagent.plugin"))};
    }

    private long a(long[] r6) {
        long r0 = 0;
        if (r6 != null) goto L5;
    L10:
        return r0;
    L5:
        if (r6.length == 0) goto L10;
        int r5 = r6.length;
        int r2 = 0;
    L8:
        if (r2 >= r5) goto L10;
        r0 = r0 + r6[r2];
        r2 = r2 + 1;
        goto L8
    }

    @Override // com.bytedance.apm.battery.d.l
    public void a(com.bytedance.apm.battery.c.b r3, com.bytedance.apm.e.a r4) {
        if (r4.a() == false) goto L11;
        if (TextUtils.equals(r4.h(), "source_bytes") == false) goto L8;
        r3.o(r4.d());
        return;
    L8:
        if (TextUtils.equals(r4.h(), "source_packets") == false) goto L18;
        r3.p(r4.d());
        return;
    L18:
        return;
    L11:
        if (TextUtils.equals(r4.h(), "source_bytes") == false) goto L14;
        r3.f(r4.d());
        return;
    L14:
        if (TextUtils.equals(r4.h(), "source_packets") == false) goto L21;
        r3.g(r4.d());
        return;
    }
}
