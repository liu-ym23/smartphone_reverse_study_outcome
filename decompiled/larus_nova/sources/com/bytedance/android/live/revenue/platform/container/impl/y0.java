package com.bytedance.android.live.revenue.platform.container.impl;

import com.ss.cast.discovery.mdns.nsdhelper.NsdHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w0 f91366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f91367b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.scope.j f91368c;

    public y0(w0 r100, Object r101, com.bytedance.android.scope.j r102) {
        Intrinsics.checkNotNullParameter(r100, NsdHelper.serviceInfoKey);
        Intrinsics.checkNotNullParameter(r101, "instance");
        Intrinsics.checkNotNullParameter(r102, "scope");
        this.f91366a = r100;
        this.f91367b = r101;
        this.f91368c = r102;
    }
}
