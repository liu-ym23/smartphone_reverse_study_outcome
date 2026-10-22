package com.bytedance.safetyguard.lxc.internal.d;

import com.bytedance.safetyguard.lxc.api.ProxySessionErrorCode;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ProxySessionStats.kt */
/* JADX INFO: loaded from: classes.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicInteger f10263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicInteger f10264b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicLong f10265c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicLong f10266d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AtomicReference<ProxySessionErrorCode> f10267e;
    private final AtomicReference<String> f;

    public t() {
        this.f10263a = new AtomicInteger(0);
        this.f10264b = new AtomicInteger(0);
        this.f10265c = new AtomicLong(0);
        this.f10266d = new AtomicLong(0);
        this.f10267e = new AtomicReference(null);
        this.f = new AtomicReference(null);
    }

    public final void a() {
        this.f10263a.incrementAndGet();
    }

    public final void b() {
        this.f10264b.incrementAndGet();
    }

    public final void a(int r3) {
        if (r3 <= 0) goto L5;
        this.f10265c.addAndGet(r3);
        return;
    }

    public final void b(int r3) {
        if (r3 <= 0) goto L5;
        this.f10266d.addAndGet(r3);
        return;
    }

    public final void a(ProxySessionErrorCode r2, String r3) {
        d.h.b.o.e(r2, MonitorConstants.CODE);
        this.f10267e.set(r2);
        this.f.set(r3);
    }

    public final u c() {
        return new u(this.f10263a.get(), this.f10264b.get(), this.f10265c.get(), this.f10266d.get(), (ProxySessionErrorCode) ZeusTransformUtils.preCheckCast(this.f10267e.get(), ProxySessionErrorCode.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(this.f.get(), String.class, "com.obric.aiagent.plugin"));
    }
}
