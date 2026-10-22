package com.bytedance.ai.monitor.auth;

import com.bytedance.ai.monitor.AppletMonitorableEvent;
import java.security.SecureRandom;
import k5.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AppletAuthTaskMonitor.Session f37193a;

    public b(AppletAuthTaskMonitor.Session r100) {
        this.f37193a = r100;
    }

    @Override // k5.j
    public final void a(AppletMonitorableEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        SecureRandom r101 = AppletAuthTaskMonitor.f37154a;
        AppletAuthTaskMonitor.d(r100, this.f37193a, null);
        r100.e("start_ts", this.f37193a.f37159c);
    }
}
