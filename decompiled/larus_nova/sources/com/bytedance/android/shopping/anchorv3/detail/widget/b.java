package com.bytedance.android.shopping.anchorv3.detail.widget;

import android.graphics.Bitmap;
import com.bytedance.android.ec.core.utils.y;

/* JADX INFO: loaded from: classes12.dex */
public final class b<T> implements y.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnchorV3CommonBannerView f164906a;

    public b(AnchorV3CommonBannerView r100) {
        this.f164906a = r100;
    }

    @Override // com.bytedance.android.ec.core.utils.y.c
    public final void accept(Object r100) {
        this.f164906a.post(new a(this, (Bitmap) r100));
    }
}
