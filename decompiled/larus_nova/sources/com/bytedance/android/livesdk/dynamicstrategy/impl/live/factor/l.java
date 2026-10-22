package com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor;

import android.os.Build;
import com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor;

/* JADX INFO: loaded from: classes8.dex */
public final class l extends DynamicFactor<String> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final l f123168b = null;

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String c() {
        return "device_type";
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void d() {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void e() {
    }

    static {
        f123168b = new l();
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String b() {
        String r100 = Build.MODEL;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public l() {
    }
}
