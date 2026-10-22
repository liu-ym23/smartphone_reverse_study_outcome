package com.bytedance.android.ec.monitor.duration;

import com.bytedance.android.ec.core.opt.monitor.ReportDuration;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class i implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f47987a = null;

    public i() {
    }

    static {
        f47987a = new i();
    }

    @Override // com.bytedance.android.ec.monitor.duration.e
    public final void a(ReportDuration r100) {
        Intrinsics.checkNotNullParameter(r100, "reportDuration");
        DurationMonitorManager.f47981d.getClass();
        ((e) DurationMonitorManager.f47980c.getValue()).a(r100);
    }

    @Override // com.bytedance.android.ec.monitor.duration.e
    public final String create(String r100) {
        Intrinsics.checkNotNullParameter(r100, "business");
        DurationMonitorManager.f47981d.getClass();
        return ((e) DurationMonitorManager.f47980c.getValue()).create(r100);
    }

    @Override // com.bytedance.android.ec.monitor.duration.e
    public final d get(String r100) {
        Intrinsics.checkNotNullParameter(r100, "monitorKey");
        DurationMonitorManager.f47981d.getClass();
        return ((e) DurationMonitorManager.f47980c.getValue()).get(r100);
    }
}
