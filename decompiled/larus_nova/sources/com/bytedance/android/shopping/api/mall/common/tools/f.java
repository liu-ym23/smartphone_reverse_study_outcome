package com.bytedance.android.shopping.api.mall.common.tools;

import android.graphics.Bitmap;
import android.view.PixelCopy;

/* JADX INFO: loaded from: classes13.dex */
public final class f implements PixelCopy.OnPixelCopyFinishedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DeliveryViewAnimHelper f170434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Bitmap f170435b;

    public f(DeliveryViewAnimHelper r100, Bitmap r101) {
        this.f170434a = r100;
        this.f170435b = r101;
    }

    @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
    public final void onPixelCopyFinished(int r100) {
        if (r100 != 0) goto L5;
        DeliveryViewAnimHelper r101 = this.f170434a;
        Bitmap r102 = this.f170435b;
        r101.getClass();
        DeliveryViewAnimHelper.f170389f = r102;
        return;
    }
}
