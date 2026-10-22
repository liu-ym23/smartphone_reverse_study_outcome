package com.bytedance.android.livesdk.performance.event;

import com.bytedance.android.livesdkapi.service.IPerformanceEventKitService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class d implements IPerformanceEventKitService {
    public d() {
    }

    @Override // com.bytedance.android.livesdkapi.service.IPerformanceEventKitService
    public final void trigger(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        boolean r102 = c.f154591a;
        c.d(r100, r101);
    }
}
