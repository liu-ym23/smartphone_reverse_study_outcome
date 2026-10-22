package com.bytedance.android.shopping.prepurchase.business.pdp.components;

/* JADX INFO: loaded from: classes13.dex */
public final class k<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LastPageVideoZoomer f181110a;

    public k(LastPageVideoZoomer r100) {
        this.f181110a = r100;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
    public final void onChanged(Object r100) {
        boolean r101 = ((Boolean) r100).booleanValue();
        cf.p r102 = this.f181110a.c();
        if (r102 == null) goto L6;
        r102.a(r101);
        return;
    }
}
