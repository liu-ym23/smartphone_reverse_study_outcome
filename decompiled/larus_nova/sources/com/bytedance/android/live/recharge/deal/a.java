package com.bytedance.android.live.recharge.deal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f89693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f89694b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f89695c;

    public a(m r100, i r101) {
        com.bytedance.live.kmp.util.c r102 = com.bytedance.live.kmp.util.c.f255167a;
        long r103 = System.currentTimeMillis();
        Intrinsics.checkNotNullParameter(r100, "requestParams");
        Intrinsics.checkNotNullParameter(r101, "dealSet");
        this.f89693a = r100;
        this.f89694b = r101;
        this.f89695c = r103;
    }
}
