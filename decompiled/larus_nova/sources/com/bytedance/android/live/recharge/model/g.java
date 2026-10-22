package com.bytedance.android.live.recharge.model;

import com.bytedance.android.live.recharge.utils.t;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final RechargePanelDynamicConfig f90033a = null;

    static {
        f90033a = (RechargePanelDynamicConfig) t.f90505b.getValue(null, t.f90504a[0]);
    }

    public static final boolean a(RechargePanelDynamicConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isAvailable");
        if (r100.getEnable() == true) goto L5;
        return false;
    L5:
        if (r100.getScheme().length() <= 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == false) goto L12;
        return true;
    L12:
        return false;
    L7:
        r101 = false;
        goto L8
    }
}
