package com.bytedance.android.shopping.prepurchase.business.pdp;

import com.bytedance.android.shopping.anchorv4.helper.u;
import com.bytedance.android.shopping.anchorv4.params.AnchorV4Param;
import com.bytedance.android.shopping.prepurchase.arch.container.aware.DataFetchLifecycleDispatcher;
import com.bytedance.android.shopping.prepurchase.arch.container.aware.RenderLifecycleDispatcher;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.PdpRootComponent;
import com.bytedance.android.shopping.prepurchase.business.pdp.repository.PdpDataFetchService;
import com.bytedance.android.shopping.prepurchase.business.pdp.repository.PdpDataStore;
import com.bytedance.android.shopping.prepurchase.business.pdp.services.slice.PdpDynamicFeatureService;
import kotlin.jvm.internal.Intrinsics;
import n83.m;

/* JADX INFO: loaded from: classes13.dex */
public final class g extends pg3.a<e, PdpDataStore> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AnchorV4Param f181851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f181852b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u f181853c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m f181854d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f181855e;

    @Override // pg3.c
    public final wg3.a b() {
        return new wg3.a(this.f181851a, this.f181855e);
    }

    @Override // pg3.c
    public final e d() {
        return new e(this.f181851a, new a(this.f181852b));
    }

    @Override // pg3.c
    public final PdpDynamicFeatureService e() {
        return new PdpDynamicFeatureService();
    }

    @Override // pg3.c
    public final PdpRootComponent f() {
        if (this.f181851a.getNativeParams().getFullMode() == false) goto L5;
        PdpRootComponent.a r100 = new b();
    L7:
        return new PdpRootComponent(r100, this.f181853c, this.f181854d);
    L5:
        r100 = new c(this.f181851a);
        goto L7
    }

    @Override // pg3.c
    public final PdpDataFetchService a(DataFetchLifecycleDispatcher r100) {
        Intrinsics.checkNotNullParameter(r100, "contentQueryListener");
        return new PdpDataFetchService(r100, this.f181853c);
    }

    @Override // pg3.c
    public final xg3.d c(RenderLifecycleDispatcher r100) {
        Intrinsics.checkNotNullParameter(r100, "renderListener");
        return new xg3.d(r100, new f(this));
    }

    public g(AnchorV4Param r100, boolean r101, u r102, m r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "param");
        this.f181851a = r100;
        this.f181852b = r101;
        this.f181853c = r102;
        this.f181854d = r103;
        this.f181855e = r104;
    }
}
