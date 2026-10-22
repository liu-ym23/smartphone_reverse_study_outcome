package com.bytedance.android.ec.common.impl.sku.view;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes43.dex */
public final class z<T> implements com.bytedance.android.ec.core.utils.y.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SpecItemOptimizeView f43586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s.c f43587b;

    public z(SpecItemOptimizeView r100, s.c r101) {
        this.f43586a = r100;
        this.f43587b = r101;
    }

    @Override // com.bytedance.android.ec.core.utils.y.c
    public final void accept(Object r100) {
        this.f43586a.post(new y(this, (Bitmap) r100));
    }
}
