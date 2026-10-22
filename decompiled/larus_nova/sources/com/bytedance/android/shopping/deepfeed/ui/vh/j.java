package com.bytedance.android.shopping.deepfeed.ui.vh;

import android.graphics.drawable.Animatable;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.infeed.data.idl.InFeedUrlModel;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: classes13.dex */
public final class j extends BaseControllerListener<ImageInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DeepFeedProductBannerImageVH f173835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ECUrlModel f173836b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f173837c;

    public j(DeepFeedProductBannerImageVH r100, InFeedUrlModel r101, int r102) {
        this.f173835a = r100;
        this.f173836b = r101;
        this.f173837c = r102;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
        ImageInfo r103 = (ImageInfo) r101;
        DeepFeedProductBannerImageVH r104 = this.f173835a;
        ECUrlModel r105 = this.f173836b;
        int r106 = this.f173837c;
        int r107 = DeepFeedProductBannerImageVH.f173801k;
        if (r106 == 0) goto L5;
        r104.getClass();
        return;
    L5:
        r104.itemView.post(new k(r104, r105, r106));
    }
}
