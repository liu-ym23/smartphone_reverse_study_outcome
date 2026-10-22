package com.bytedance.android.ec.common.impl.sku.view;

import android.graphics.Bitmap;
import android.widget.TextView;

/* JADX INFO: loaded from: classes43.dex */
public final class p<T> implements com.bytedance.android.ec.core.utils.y.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f43551a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TextView f43552b;

    public p(n r100, TextView r101) {
        this.f43551a = r100;
        this.f43552b = r101;
    }

    @Override // com.bytedance.android.ec.core.utils.y.c
    public final void accept(Object r100) {
        this.f43551a.post(new o(this, (Bitmap) r100));
    }
}
