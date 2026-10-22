package com.obric.appstore.base;

/* JADX INFO: loaded from: classes3.dex */
public abstract class o extends IPageLoadViewModel {
    public o() {
    }

    @Override // com.obric.appstore.base.IPageLoadViewModel
    public void B(boolean r10, boolean r11) {
        q(new n(true, z() + 1, 0, r10, r11, 4, null));
    }

    @Override // com.obric.appstore.base.ILoadViewModel
    public void r(boolean r10, boolean r11) {
        q(new n(false, 1, 0, r10, r11, 4, null));
    }
}
