package com.bytedance.ai.applet.app.foundation.performance;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class j extends e {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f34334p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f34335q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f34336r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f34337s;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ai.applet.app.foundation.performance.e
    public final String b() {
        return this.f34337s;
    }

    @Override // com.bytedance.ai.applet.app.foundation.performance.e
    public final void a(Map<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        r100.put("widget_id", this.f34334p);
        r100.put("widget_instance_id", this.f34335q);
        r100.put("is_app_cold_launch", Integer.valueOf(this.f34336r ? 1 : 0));
    }

    public j(String r100, String r101, long r110, long r111, long r112, AppletPerformanceErrorCode r113, String r114, Long r115, Long r116, Long r210, Long r211, Long r212, Long r213, boolean r214, Long r215, String r216, String r217, boolean r218) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        Intrinsics.checkNotNullParameter(r101, "appName");
        Intrinsics.checkNotNullParameter(r113, "errorCode");
        Intrinsics.checkNotNullParameter(r216, "widgetId");
        Intrinsics.checkNotNullParameter(r217, "widgetInstanceId");
        super(r100, r101, r110, r111, r112, r113, r114, r115, r116, r210, r211, r212, r213, r214, r215);
        this.f34334p = r216;
        this.f34335q = r217;
        this.f34336r = r218;
        this.f34337s = "applet_widget_performance";
    }
}
