package com.obric.matrix.platform.sdk.ones.commonmonitor.fps;

import androidx.lifecycle.i;
import androidx.lifecycle.o;
import androidx.lifecycle.p;
import androidx.lifecycle.x;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: FPSMonitor.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class FPSMonitor$monitorLifecycleOwnerFps$1 implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ p f33642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f33643b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c f33644c;

    @x(a = i.a.ON_RESUME)
    public final void onResume() {
        String r0 = this.f33643b;
        d.h.b.o.c(r0, "TAG");
        com.obric.matrix.platform.sdk.ones.internal.b.b.b(r0, "start fps monitor", null, 4, null);
        b.a(b.f33651a);
        this.f33644c.a();
    }

    @x(a = i.a.ON_PAUSE)
    public final void onPause() {
        String r0 = this.f33643b;
        d.h.b.o.c(r0, "TAG");
        com.obric.matrix.platform.sdk.ones.internal.b.b.b(r0, "onPause fps stop", null, 4, null);
        this.f33644c.b();
    }

    @x(a = i.a.ON_DESTROY)
    public final void onDestroy() {
        String r0 = this.f33643b;
        d.h.b.o.c(r0, "TAG");
        com.obric.matrix.platform.sdk.ones.internal.b.b.b(r0, "onDestroy", null, 4, null);
        this.f33642a.getLifecycle().b((o) ZeusTransformUtils.preCheckCast(this, o.class, "com.obric.aiagent.plugin"));
    }
}
