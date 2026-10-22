package com.bytedance.applet.impl;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ai.bridge.service.IHostLocationPermissionDepend;
import com.bytedance.ai.bridge.service.OnPermissionGrantCallback;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class t implements IHostLocationPermissionDepend {
    public t() {
    }

    @Override // com.bytedance.ai.bridge.service.IHostLocationPermissionDepend
    public final void requestPermission(Activity r100, e3.d r101, String r102, final OnPermissionGrantCallback r103) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "bridgeContext");
        Intrinsics.checkNotNullParameter(r102, "bridgeName");
        Intrinsics.checkNotNullParameter(r103, "callback");
        com.larus.platform.service.i2 r104 = com.larus.platform.service.i2.f365748b;
        if ((r100 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r105 = (FragmentActivity) r100;
    L6:
        r104.a(r105, CollectionsKt.listOf(new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}), new s(r103));
        return;
    L5:
        r105 = null;
        goto L6
    }
}
