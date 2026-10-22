package com.bytedance.apm.impl;

import android.os.Handler;
import b27.e;
import com.bytedance.apm.PerfConfig;
import com.bytedance.apm.block.evil.EvilMethodSwitcher;
import com.bytedance.apm.block.g;
import com.bytedance.apm.block.trace.MethodCollector;
import com.bytedance.apm.d;
import com.bytedance.services.apm.api.ILaunchTrace;
import com.ss.android.common.applog.EventVerify;
import ct3.f;
import es3.h;

/* JADX INFO: loaded from: classes.dex */
public class LaunchTraceImpl implements ILaunchTrace {
    public LaunchTraceImpl() {
    }

    @Override // com.bytedance.services.apm.api.ILaunchTrace
    public void cancelTrace() {
        if (ct3.a.f465313b == false) goto L5;
        com.bytedance.apm.launch.evil.b.b();
    L5:
        f r100 = ct3.a.f465312a;
        if (r100 == null) goto L9;
        r100.f465342c.clear();
        ct3.a.f465312a = null;
        return;
    }

    @Override // com.bytedance.services.apm.api.ILaunchTrace
    public void startTrace() {
        f r100 = new f("start_trace", "launch_stats");
        ct3.a.f465312a = r100;
        r100.f465340a = System.currentTimeMillis();
        if (d.l() == false) goto L28;
        boolean r101 = EvilMethodSwitcher.isOpenLaunchEvilMethod();
        ct3.a.f465313b = r101;
        if (r101 == true) goto L7;
        return;
    L7:
        monitor-enter(com.bytedance.apm.launch.evil.b.class);
    L25:
        th = move-exception;
        throw th;
    L9:
        if (com.bytedance.apm.launch.evil.b.f190617a == false) goto L13;
        monitor-exit(com.bytedance.apm.launch.evil.b.class);
        return;
    L13:
        com.bytedance.apm.launch.evil.b.f190617a = true;     // Catch: Throwable -> L25
        if (com.bytedance.apm.launch.evil.b.f190618b == true) goto L22;
        com.bytedance.apm.launch.evil.b.f190618b = true;     // Catch: Throwable -> L25
        long r102 = EvilMethodSwitcher.getLaunchEvilThresholdMs();     // Catch: Throwable -> L25
        if (r102 >= 70) goto L18;
        r102 = 1000;
    L18:
        a47.a.f1768j = r102;     // Catch: Throwable -> L25
        a47.a.f1770l = true;     // Catch: Throwable -> L25
        if (EvilMethodSwitcher.isMessageKeyEnable() == false) goto L21;
        PerfConfig.setReportMessage();     // Catch: Throwable -> L25
    L21:
        h.f473717z.g();     // Catch: Throwable -> L25
        MethodCollector.getInstance().onStart();     // Catch: Throwable -> L25
        a47.a.f1769k = true;     // Catch: Throwable -> L25
        EvilMethodSwitcher.isLaunchLimitEvilMethodDepth();     // Catch: Throwable -> L25
        a47.a r103 = new a47.a(true);     // Catch: Throwable -> L25
        com.bytedance.apm.launch.evil.b.f190619c = r103;     // Catch: Throwable -> L25
        r103.j();     // Catch: Throwable -> L25
        e.d(true, EventVerify.TYPE_LAUNCH, null);     // Catch: Throwable -> L25
        new Handler().postDelayed(new com.bytedance.apm.launch.evil.a(), 10000);     // Catch: Throwable -> L25
    L22:
        g.f190348c = true;     // Catch: Throwable -> L25
        g.f190346a.add("app_launch_evil_method_scene_apm_2");     // Catch: Throwable -> L25
        monitor-exit(com.bytedance.apm.launch.evil.b.class);
        return;
    }

    @Override // com.bytedance.services.apm.api.ILaunchTrace
    public void endSpan(String r100, String r101) {
        f r102 = ct3.a.f465312a;
        if (r102 == null) goto L6;
        r102.a(r100, r101);
        return;
    }

    @Override // com.bytedance.services.apm.api.ILaunchTrace
    public void startSpan(String r100, String r101) {
        f r102 = ct3.a.f465312a;
        if (r102 == null) goto L6;
        r102.d(r100, r101);
        return;
    }

    @Override // com.bytedance.services.apm.api.ILaunchTrace
    public void endTrace(int r100, String r101, long r102) {
        if (ct3.a.f465313b == false) goto L5;
        com.bytedance.apm.launch.evil.b.b();
    L5:
        f r103 = ct3.a.f465312a;
        if (r103 == null) goto L9;
        r103.b(r100, r101, r102);
        return;
    }
}
