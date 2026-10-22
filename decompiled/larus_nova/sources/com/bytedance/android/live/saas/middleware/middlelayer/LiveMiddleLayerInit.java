package com.bytedance.android.live.saas.middleware.middlelayer;

import com.ss.alog.middleware.ALogService;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import om0.a;
import om0.b;
import om0.c;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/middlelayer/LiveMiddleLayerInit;", "", "()V", "initMiddleLayer", "", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class LiveMiddleLayerInit {
    public static final LiveMiddleLayerInit INSTANCE = null;

    private LiveMiddleLayerInit() {
    }

    static {
        INSTANCE = new LiveMiddleLayerInit();
    }

    @JvmStatic
    public static final void initMiddleLayer() {
        ALogServiceImpl r100 = new ALogServiceImpl();
        AppLogServiceImpl r101 = new AppLogServiceImpl();
        CommonServiceImpl r102 = new CommonServiceImpl();
        SettingServiceImpl r103 = new SettingServiceImpl();
        a r104 = new a(r100, r101, new MonitorServiceImpl(), r103, new NetworkServiceImpl(), r102);
        b r105 = c.f524232a;
        Intrinsics.checkNotNullParameter(r104, "middleLayer");
        if (c.f524235d == true) goto L6;
        c.f524234c = r104;
        c.f524235d = true;
    L6:
        ALogService.setAlogService(new ALoggerServiceImpl());
    }
}
