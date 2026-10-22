package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: classes13.dex */
public final class v<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t f169406a;

    public v(t r100) {
        this.f169406a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = (Boolean) r100;
        this.f169406a.h(true);
    }
}
