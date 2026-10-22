package com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor;

import com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor;

/* JADX INFO: loaded from: classes8.dex */
public final class f extends DynamicFactor<Boolean> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f123155b = null;

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String c() {
        return "is_local_test";
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void d() {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void e() {
    }

    static {
        f123155b = new f();
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final Boolean b() {
        return Boolean.valueOf(com.bytedance.android.live.core.utils.v.a());
    }

    public f() {
    }
}
