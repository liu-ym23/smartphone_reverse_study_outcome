package com.bytedance.android.live.profit.redpacket;

import com.bytedance.android.live.revenue.platform.hybrid.api.shareview.LoadFailCode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class f1 implements com.bytedance.android.live.revenue.platform.hybrid.api.shareview.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ xr2.g f88604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RedpacketClientIconModel$getViewForState$$inlined$apply$lambda$1 f88605b;

    @Override // com.bytedance.android.live.revenue.platform.hybrid.api.shareview.f
    public final void a() {
    }

    @Override // com.bytedance.android.live.revenue.platform.hybrid.api.shareview.f
    public final void c() {
    }

    @Override // com.bytedance.android.live.revenue.platform.hybrid.api.shareview.f
    public final void onFallback() {
    }

    @Override // com.bytedance.android.live.revenue.platform.hybrid.api.shareview.f
    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r100, "message");
    }

    @Override // com.bytedance.android.live.revenue.platform.hybrid.api.shareview.f
    public final void e(com.bytedance.android.live.revenue.platform.hybrid.api.shareview.c r100) {
        Intrinsics.checkNotNullParameter(r100, "sharer");
        Intrinsics.checkNotNullParameter(r100, "sharer");
    }

    public f1(xr2.g r100, RedpacketClientIconModel$getViewForState$$inlined$apply$lambda$1 r101) {
        this.f88604a = r100;
        this.f88605b = r101;
    }

    @Override // com.bytedance.android.live.revenue.platform.hybrid.api.shareview.f
    public final void b(String r100, LoadFailCode r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r101, "code");
        this.f88605b.invoke2();
    }
}
