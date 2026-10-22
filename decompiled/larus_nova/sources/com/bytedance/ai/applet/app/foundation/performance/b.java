package com.bytedance.ai.applet.app.foundation.performance;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b extends e {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f34264p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f34265q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f34266r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Long f34267s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Long f34268t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f34269u;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ai.applet.app.foundation.performance.e
    public final String b() {
        return this.f34269u;
    }

    @Override // com.bytedance.ai.applet.app.foundation.performance.e
    public final void a(Map<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        r100.put("path", this.f34264p);
        String r101 = this.f34265q;
        if (r101 == null) goto L5;
        r100.put("navigation_type", r101);
    L5:
        String r102 = this.f34266r;
        if (r102 == null) goto L8;
        r100.put("referrer_path", r102);
    L8:
        Long r103 = this.f34267s;
        if (r103 == null) goto L11;
        r100.put("route_duration", Long.valueOf(r103.longValue()));
    L11:
        Long r104 = this.f34268t;
        if (r104 == null) goto L15;
        r100.put("app_launch_duration", Long.valueOf(r104.longValue()));
        return;
    }

    public b(String r210, String r211, long r212, long r213, long r214, AppletPerformanceErrorCode r215, String r310, Long r311, Long r312, Long r313, Long r314, boolean r315, Long r316, String r317, String r318, String r319, Long r410, Long r411) {
        Intrinsics.checkNotNullParameter(r210, "appId");
        Intrinsics.checkNotNullParameter(r211, "appName");
        Intrinsics.checkNotNullParameter(r215, "errorCode");
        Intrinsics.checkNotNullParameter(r317, "path");
        super(r210, r211, r212, r213, r214, r215, r310, null, null, r311, r312, r313, r314, r315, r316);
        this.f34264p = r317;
        this.f34265q = r318;
        this.f34266r = r319;
        this.f34267s = r410;
        this.f34268t = r411;
        this.f34269u = "applet_page_performance";
    }
}
