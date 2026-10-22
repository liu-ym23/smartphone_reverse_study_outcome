package com.bytedance.android.ec.common.impl.sku.view;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes43.dex */
public final class w<T> implements com.bytedance.android.ec.core.utils.y.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SpecItemOptimizeView f43581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s.c f43582b;

    public w(SpecItemOptimizeView r100, s.c r101) {
        this.f43581a = r100;
        this.f43582b = r101;
    }

    @Override // com.bytedance.android.ec.core.utils.y.c
    public final void accept(Object r100) {
        this.f43581a.post(new v(this, (Bitmap) r100));
    }
}
