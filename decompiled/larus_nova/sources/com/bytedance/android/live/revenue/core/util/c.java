package com.bytedance.android.live.revenue.core.util;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c {
    public static final void a(Class r100) {
        Intrinsics.checkNotNullParameter(r100, "serviceCls");
        throw new IllegalArgumentException("Service not found: " + r100 + "\nPlease ensure that revenue-host-impl module contains service implementation.");
    }
}
