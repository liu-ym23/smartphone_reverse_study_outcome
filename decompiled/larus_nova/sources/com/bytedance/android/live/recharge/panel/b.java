package com.bytedance.android.live.recharge.panel;

import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.android.live.recharge.nopassword.NoPasswordScene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b {
    public static final RechargeBizScene a(com.bytedance.android.live.recharge.model.d r100) {
        Intrinsics.checkNotNullParameter(r100, "entranceParams");
        NoPasswordScene r101 = com.bytedance.android.live.recharge.core.f.g(RechargeServices.b()).B1(r100);
        int r102 = a.f90149a[r101.ordinal()];
        if (r102 == 1) goto L11;
        if (r102 == 2) goto L13;
        if (r102 == 3) goto L13;
        return RechargeBizScene.SCENE_NORMAL;
    L13:
        return RechargeBizScene.SCENE_FANS_NOPASSWORD;
    L11:
        return RechargeBizScene.SCENE_PK_NOPASSWORD;
    }
}
