package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.live;

import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class f<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveSearchComponent f181167a;

    public f(LiveSearchComponent r100) {
        this.f181167a = r100;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
    public final void onChanged(Object r100) {
        float r101 = ((Number) r100).floatValue();
        LiveSearchComponent r102 = this.f181167a;
        if (r102.f181157u == false) goto L6;
        return;
    L6:
        if (r101 >= 0) goto L8;
        ExtensionsKt.gone(r102.e2());
        return;
    L8:
        ExtensionsKt.visible(r102.e2());
    }
}
