package com.bytedance.android.live.revenue.platform.container.impl;

import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f91364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Method f91365b;

    public y(String r100, Method r101) {
        Intrinsics.checkNotNullParameter(r100, "methodId");
        Intrinsics.checkNotNullParameter(r101, "methodInstance");
        this.f91364a = r100;
        this.f91365b = r101;
    }
}
