package com.bytedance.ai.bridge.method.net.download;

import com.bytedance.ai.monitor.AppletMonitorableEvent;
import com.bytedance.android.livesdkapi.monitor.ILiveHybridMonitor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class k implements k5.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a.j f35746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f35747b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a.b f35748c;

    @Override // k5.j
    public final void a(AppletMonitorableEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        r100.e("file_size", this.f35746a.f35724c);
        r100.e("duration", this.f35747b);
        r100.f("applet_id", this.f35748c.f35647b.f35702a);
        r100.f(ILiveHybridMonitor.BusinessParams.CONTAINER_TYPE, this.f35748c.f35648c);
        r100.d("status_code", this.f35746a.f35722a);
    }

    public k(a.j r100, long r101, a.b r102) {
        this.f35746a = r100;
        this.f35747b = r101;
        this.f35748c = r102;
    }
}
