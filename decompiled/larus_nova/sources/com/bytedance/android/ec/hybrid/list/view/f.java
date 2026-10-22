package com.bytedance.android.ec.hybrid.list.view;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: classes44.dex */
public final class f extends BaseControllerListener<ImageInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WrapHeightDraweeView f47438a;

    public f(WrapHeightDraweeView r100) {
        this.f47438a = r100;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onIntermediateImageSet(String r100, Object r101) {
        ImageInfo r102 = (ImageInfo) r101;
        WrapHeightDraweeView r103 = this.f47438a;
        r103.getClass();
        if (r102 == null) goto L6;
        r103.setAspectRatio(r102.getWidth() / r102.getHeight());
        return;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
        ImageInfo r103 = (ImageInfo) r101;
        WrapHeightDraweeView r104 = this.f47438a;
        r104.getClass();
        if (r103 == null) goto L6;
        r104.setAspectRatio(r103.getWidth() / r103.getHeight());
        return;
    }
}
