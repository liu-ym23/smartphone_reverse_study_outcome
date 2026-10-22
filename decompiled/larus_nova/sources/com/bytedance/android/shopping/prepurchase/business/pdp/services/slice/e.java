package com.bytedance.android.shopping.prepurchase.business.pdp.services.slice;

/* JADX INFO: loaded from: classes13.dex */
public final class e<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PdpDynamicFeatureService f182173a;

    public e(PdpDynamicFeatureService r100) {
        this.f182173a = r100;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
    public final void onChanged(Object r100) {
        if (((Boolean) r100).booleanValue() == false) goto L14;
        PdpDynamicFeatureService r101 = this.f182173a;
        if (r101.f182145q == false) goto L7;
        r101.Y0(true);
        return;
    L7:
        c r102 = r101.f182143o;
        if (r102 == null) goto L16;
        e73.a r103 = r102.f182165a;
        if (r103 == null) goto L17;
        r102.b(r103.e());
        return;
    L17:
        return;
    L16:
        return;
    }
}
