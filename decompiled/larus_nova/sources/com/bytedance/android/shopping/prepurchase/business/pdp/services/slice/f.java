package com.bytedance.android.shopping.prepurchase.business.pdp.services.slice;

/* JADX INFO: loaded from: classes13.dex */
public final class f<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PdpDynamicFeatureService f182174a;

    public f(PdpDynamicFeatureService r100) {
        this.f182174a = r100;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
    public final void onChanged(Object r100) {
        if (((Boolean) r100).booleanValue() == true) goto L14;
        PdpDynamicFeatureService r101 = this.f182174a;
        if (r101.f182145q == false) goto L7;
        r101.Y0(false);
        return;
    L7:
        c r102 = r101.f182143o;
        if (r102 == null) goto L16;
        e73.a r103 = r102.f182165a;
        if (r103 == null) goto L17;
        r102.b(r103.d());
        return;
    L17:
        return;
    L16:
        return;
    }
}
