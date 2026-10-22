package com.bytedance.android.live.browser.service;

import com.bytedance.android.livesdk.log.j0;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class z implements x9.b {
    public z() {
    }

    @Override // x9.b
    public final void logV3(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "extra");
        j0.l().sendLog(r100, r101, new Object[0]);
    }

    @Override // x9.b
    public final void t(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "map");
        Map r102 = MapsKt.toMutableMap(r101);
        r102.put("no_prefix", "1");
        j0.l().e(r100, r102, new Object[0]);
    }
}
