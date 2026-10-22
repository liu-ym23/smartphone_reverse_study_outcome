package com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor;

import com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor;
import com.bytedance.android.livesdk.k6;
import com.bytedance.android.livesdk.l6;

/* JADX INFO: loaded from: classes8.dex */
public final class n extends DynamicFactor<Integer> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f123170b;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String c() {
        return "live_device_performance";
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void d() {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void e() {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final Integer b() {
        if (this.f123170b == true) goto L5;
        int r100 = l6.f146990a.getValue().intValue();
    L7:
        return Integer.valueOf(r100);
    L5:
        r100 = k6.f142267a.getValue().intValue();
        goto L7
    }

    public n(boolean r100) {
        this.f123170b = r100;
    }
}
