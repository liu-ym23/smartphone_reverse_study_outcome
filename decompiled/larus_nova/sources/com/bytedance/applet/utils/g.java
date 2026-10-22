package com.bytedance.applet.utils;

import com.larus.platform.model.GeoLocationInfo;
import com.larus.platform.model.LocationResult;
import hq9.a3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class g implements a3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f192287a;

    public g(d r100) {
        this.f192287a = r100;
    }

    @Override // hq9.a3
    public final void a(LocationResult r100, Integer r101, GeoLocationInfo r102) {
        Intrinsics.checkNotNullParameter(r100, "code");
        d r103 = this.f192287a;
        if (r100 != LocationResult.SUCCESS) goto L5;
        boolean r104 = true;
    L6:
        d.a.a(r103, r104, false, false, 6);
        return;
    L5:
        r104 = false;
        goto L6
    }
}
