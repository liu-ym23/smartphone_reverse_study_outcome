package com.bytedance.android.livesdk.revenue.service.performance;

import com.bytedance.android.livesdk.config.PerformanceTestSettings;
import com.bytedance.android.livesdk.config.ce1;
import com.bytedance.android.livesdk.performance.x;
import com.bytedance.android.scope.o;

/* JADX INFO: loaded from: classes11.dex */
public final class f implements o, a {
    public f() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // com.bytedance.android.livesdk.revenue.service.performance.a
    public final boolean J6() {
        return PerformanceTestSettings.TEST_DISABLE_VIDEO_GIFT.getValue().booleanValue();
    }

    @Override // com.bytedance.android.livesdk.revenue.service.performance.a
    public final boolean ki() {
        ce1 r100 = x.f154829a;
        if (r100.enable == true) goto L5;
    L7:
        return false;
    L5:
        if (r100.giftTrayWidgetEnable == false) goto L7;
        return true;
    }

    @Override // com.bytedance.android.livesdk.revenue.service.performance.a
    public final boolean ub() {
        return PerformanceTestSettings.TEST_DISABLE_NORMAL_GIFT.getValue().booleanValue();
    }
}
