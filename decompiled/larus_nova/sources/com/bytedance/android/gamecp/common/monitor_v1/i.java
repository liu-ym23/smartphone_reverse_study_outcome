package com.bytedance.android.gamecp.common.monitor_v1;

import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f56612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f56613b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f56614c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f56615d;

    public i(String r100, String r101, long r102) {
        this.f56612a = r100;
        this.f56613b = r101;
        this.f56614c = r102;
        this.f56615d = "Normal";
    }

    public final void a() {
        com.bytedance.android.gamecp.base.cache.c<String, FMPMonitorTracker.b> r100 = FMPMonitorTracker.f56549a;
        FMPMonitorTracker.b r101 = FMPMonitorTracker.f(this.f56612a, this.f56613b);
        if (r101 != null) goto L5;
        return;
    L5:
        boolean r102 = true;
        r101.f56570k = true;
        r101.f56567h.put("render_duration", String.valueOf(this.f56614c));
        r101.f56567h.put("fcp_v2_render_duration", String.valueOf(this.f56614c));
        String r103 = r101.f56567h.get("render_begin");
        if (r103 == null) goto L8;
        long r104 = CastLongProtector.parseLong(r103);
    L9:
        long r105 = this.f56614c + r104;
        r101.f56567h.put("fmp_time", String.valueOf(r105));
        r101.f56567h.put("fcp_v2_time", String.valueOf(r105));
        r101.f56567h.put("fmp_result_type", String.valueOf(this.f56615d));
        r101.f56567h.put("fcp_v2_result_type", String.valueOf(this.f56615d));
        String r106 = this.f56612a;
        String r107 = this.f56613b;
        FMPMonitorTracker.b r108 = FMPMonitorTracker.g(r106);
        if (r108 == null) goto L38;
        String r109 = r108.f56568i.get("exit_time");
        if (r109 == null) goto L17;
        Long r110 = StringsKt.toLongOrNull(r109);
        if (r110 == null) goto L17;
        long r111 = r110.longValue();
    L19:
        if (r111 <= 0) goto L27;
        if ((r108.f56563d + r105) > r111) goto L24;
        r102 = false;
    L24:
        if (r102 == false) goto L27;
        return;
    L27:
        if (r101.f56569j == false) goto L32;
        if (r101.f56570k == true) goto L32;
        return;
    L32:
        if (r101.f56571l == true) goto L34;
    L36:
        FMPMonitorTracker.q(r106, r107, false);
        return;
    L34:
        if (r101.f56572m == true) goto L36;
        return;
    L17:
        r111 = 0;
        goto L19
    L38:
        return;
    L8:
        r104 = 0;
        goto L9
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
