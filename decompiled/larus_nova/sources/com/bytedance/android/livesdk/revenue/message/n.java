package com.bytedance.android.livesdk.revenue.message;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class n implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ylc.b f157199a;

    public n(ylc.e r100) {
        Intrinsics.checkNotNullParameter(r100, "original");
        this.f157199a = r100;
    }

    @Override // com.bytedance.android.livesdk.revenue.message.d
    public final com.ss.ugc.live.sdk.message.wrsc.data.a b(com.bytedance.android.live.revenue.platform.network.dynamic.k r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return this.f157199a.b(r100.f91528a);
    }

    @Override // com.bytedance.android.livesdk.revenue.message.d
    public final void a(com.bytedance.android.live.revenue.platform.network.dynamic.k r100, com.bytedance.android.live.revenue.platform.network.dynamic.g r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "listener");
        this.f157199a.f(r101);
    }

    @Override // com.bytedance.android.livesdk.revenue.message.d
    public final void c(com.bytedance.android.live.revenue.platform.network.dynamic.k r100, com.bytedance.android.live.revenue.platform.network.dynamic.g r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "listener");
        this.f157199a.a(r100.f91528a, r101);
    }
}
