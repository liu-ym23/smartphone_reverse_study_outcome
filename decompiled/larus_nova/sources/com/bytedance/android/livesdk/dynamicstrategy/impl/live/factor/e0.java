package com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor;

import com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class e0 extends DynamicFactor<Integer> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DataCenter f123154b;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String c() {
        return "live_user_type";
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void d() {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void e() {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final Integer b() {
        return Integer.valueOf(com.bytedance.android.live.core.utils.a0.d(this.f123154b, false) ? 1 : 0);
    }

    public e0(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        this.f123154b = r100;
    }
}
