package com.bytedance.android.shopping.deepfeed.weights.common;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: classes13.dex */
public final class c extends BaseControllerListener<ImageInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SimpleDraweeView f174224a;

    public c(SimpleDraweeView r100) {
        this.f174224a = r100;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
        ImageInfo r103 = (ImageInfo) r101;
        if (r103 != null) goto L5;
        return;
    L5:
        if (r103.getHeight() <= 0) goto L9;
        this.f174224a.setAspectRatio(r103.getWidth() / r103.getHeight());
        return;
    }
}
