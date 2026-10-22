package com.bytedance.android.livesdk.revenue.service.feature;

import com.bytedance.android.live.feature.api.FeatureType;
import com.bytedance.android.live.feature.api.IFeatureService;
import com.bytedance.android.livesdk.revenue.util.f;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import z90.c;

/* JADX INFO: loaded from: classes11.dex */
public final class RevPortraitServiceImpl extends f<IFeatureService> implements IRevFeatureService {
    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    public RevPortraitServiceImpl() {
        super(AnonymousClass1.INSTANCE);
    }

    @Override // com.bytedance.android.livesdk.revenue.service.feature.IRevFeatureService
    public final String getPortrait(String r100) {
        Intrinsics.checkNotNullParameter("live_not_clean_assets", "key");
        c r101 = k().getLivePortraitCenterService();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getPortrait("live_not_clean_assets");
    }

    @Override // com.bytedance.android.livesdk.revenue.service.feature.IRevFeatureService
    public final boolean nb(String r100, Object r101, IRevFeatureService.RevFeatureType r102) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r102, "type");
        z90.a r103 = k().getFeatureManager();
        Intrinsics.checkNotNullParameter(r102, "$this$toType");
        int r104 = a.f157315a[r102.ordinal()];
        if (r104 != 1) goto L5;
        FeatureType r105 = FeatureType.STATIC;
    L17:
        return r103.i(r100, r101, r105);
    L5:
        if (r104 != 2) goto L7;
        r105 = FeatureType.DYNAMIC;
        goto L17
    L7:
        if (r104 != 3) goto L9;
        r105 = FeatureType.MONITOR;
        goto L17
    L9:
        if (r104 != 4) goto L12;
        r105 = FeatureType.DYNAMIC_MONITOR;
        goto L17
    L12:
        throw new NoWhenBranchMatchedException();
    }
}
