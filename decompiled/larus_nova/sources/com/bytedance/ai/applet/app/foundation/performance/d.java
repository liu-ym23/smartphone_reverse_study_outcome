package com.bytedance.ai.applet.app.foundation.performance;

import com.bytedance.ai.monitor.AppletMonitorableEvent;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class d implements k5.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map<String, Object> f34279a;

    public d(Map<String, ? extends Object> r100) {
        this.f34279a = r100;
    }

    @Override // k5.j
    public final void a(AppletMonitorableEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        r100.h(this.f34279a);
    }
}
