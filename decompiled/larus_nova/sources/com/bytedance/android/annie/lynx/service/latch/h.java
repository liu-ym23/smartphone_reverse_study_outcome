package com.bytedance.android.annie.lynx.service.latch;

import com.bytedance.android.annie.service.latch.ILatchService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class h extends hx.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ILatchService.a f39572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g f39573b;

    public h(ILatchService.a r100, g r101) {
        this.f39572a = r100;
        this.f39573b = r101;
    }

    @Override // hx.a
    public final void b(com.bytedance.android.latch.a.d r100, com.bytedance.android.latch.internal.perf.a r101) {
        Intrinsics.checkNotNullParameter(r100, "process");
        Intrinsics.checkNotNullParameter(r101, "jsbPromiseMetric");
        ILatchService.a r102 = this.f39572a;
        this.f39573b.getClass();
        r102.b(new ILatchService.b(r101.f58348a, r101.f58349b, r101.f58350c));
    }

    @Override // hx.a
    public final void d(com.bytedance.android.latch.a.d r100, com.bytedance.android.latch.internal.perf.e r101) {
        Intrinsics.checkNotNullParameter(r100, "process");
        Intrinsics.checkNotNullParameter(r101, "perfMetric");
        ILatchService.a r102 = this.f39572a;
        this.f39573b.getClass();
        r102.a(new ILatchService.c(r101.f58370a, r101.f58371b, r101.f58372c));
    }

    @Override // hx.a
    public final void e(com.bytedance.android.latch.a.d r100, dx.c r110) {
        Intrinsics.checkNotNullParameter(r100, "process");
        Intrinsics.checkNotNullParameter(r110, "result");
        this.f39572a.c(r110.f470410a, r110.f470411b, r110.f470412c, r110.f470413d, r110.f470414e, r110.f470415f, r110.f470416g);
    }
}
