package com.bytedance.android.live.revenue.platform.network.impl;

import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public abstract class b implements INetworkService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<INetworkService.Biz, List<com.bytedance.android.livesdk.revenue.network.a>> f91537a;

    public b() {
        this.f91537a = new ConcurrentHashMap();
    }

    @Override // com.bytedance.android.live.revenue.platform.network.api.INetworkService
    public final void K0(INetworkService.Biz r100, com.bytedance.android.livesdk.revenue.network.a r101) {
        Intrinsics.checkNotNullParameter(r100, "biz");
        Intrinsics.checkNotNullParameter(r101, "middleware");
        List<com.bytedance.android.livesdk.revenue.network.a> r102 = this.f91537a.get(r100);
        if (r102 != null) goto L5;
        return;
    L5:
        this.f91537a.put(r100, CollectionsKt.minus(r102, r101));
    }

    @Override // com.bytedance.android.live.revenue.platform.network.api.INetworkService
    public final void s(INetworkService.Biz r100, com.bytedance.android.livesdk.revenue.network.a r101) {
        Intrinsics.checkNotNullParameter(r100, "biz");
        Intrinsics.checkNotNullParameter(r101, "middleware");
        List<com.bytedance.android.livesdk.revenue.network.a> r102 = this.f91537a.get(r100);
        ConcurrentHashMap<INetworkService.Biz, List<com.bytedance.android.livesdk.revenue.network.a>> r103 = this.f91537a;
        if (r102 == null) goto L5;
        List<com.bytedance.android.livesdk.revenue.network.a> r104 = CollectionsKt.plus(r102, r101);
    L6:
        r103.put(r100, r104);
        return;
    L5:
        r104 = CollectionsKt.listOf(r101);
        goto L6
    }
}
