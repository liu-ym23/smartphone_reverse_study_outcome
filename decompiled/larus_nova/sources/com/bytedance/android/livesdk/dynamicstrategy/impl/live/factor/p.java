package com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor;

import com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class p extends DynamicFactor<Integer> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DataCenter f123172b;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String c() {
        return "live_enter_type";
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void d() {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void e() {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final Integer b() {
        String r100 = (String) this.f123172b.get("data_live_enter_type_correct", "");
        if (r100 == null) goto L16;
        int r101 = r100.hashCode();
        if (r101 == 3091780) goto L14;
        if (r101 != 94750088) goto L16;
        if (r100.equals("click") == false) goto L16;
        int r102 = 1;
    L18:
        return Integer.valueOf(r102);
    L14:
        if (r100.equals("draw") == false) goto L16;
        r102 = 2;
    L16:
        r102 = 0;
        goto L18
    }

    public p(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        this.f123172b = r100;
    }
}
