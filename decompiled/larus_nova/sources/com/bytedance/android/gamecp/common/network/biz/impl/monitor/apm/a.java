package com.bytedance.android.gamecp.common.network.biz.impl.monitor.apm;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Request;
import mu.f;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f56667a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c<Long, Long> f56668b;

    public a(long r100) {
        this.f56667a = r100;
        this.f56668b = new c(r100, new mu.a(this), new mu.b());
    }

    @Override // mu.f
    public final void a(Request r100, Exception r101) {
        this.f56668b.a(1L);
    }

    @Override // mu.f
    public final void b(Request r100, SsResponse r101, long r102) {
        this.f56668b.a(1L);
    }
}
