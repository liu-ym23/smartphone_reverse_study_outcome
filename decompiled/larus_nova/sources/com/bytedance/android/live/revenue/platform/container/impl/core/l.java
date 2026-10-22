package com.bytedance.android.live.revenue.platform.container.impl.core;

import com.bytedance.android.live.revenue.platform.container.impl.RevenueJsDriver;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RevenueJsDriver f91208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zy0.b f91209b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f91210c;

    public l(RevenueJsDriver r100, zy0.b r101) {
        Intrinsics.checkNotNullParameter(r101, "impl");
        Intrinsics.checkNotNullParameter("0.0.0.0", "version");
        this.f91208a = r100;
        this.f91209b = r101;
        this.f91210c = "0.0.0.0";
    }
}
