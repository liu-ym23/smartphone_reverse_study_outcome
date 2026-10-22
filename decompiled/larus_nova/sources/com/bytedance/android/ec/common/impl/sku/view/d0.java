package com.bytedance.android.ec.common.impl.sku.view;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes43.dex */
public final class d0<T> implements com.bytedance.android.ec.core.utils.y.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SpecItemView f43484a;

    public d0(SpecItemView r100) {
        this.f43484a = r100;
    }

    @Override // com.bytedance.android.ec.core.utils.y.c
    public final void accept(Object r100) {
        this.f43484a.post(new c0(this, (Bitmap) r100));
    }
}
