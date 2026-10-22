package com.bytedance.android.livesdk.livecommerce.iron.widgets;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: classes10.dex */
public final class h implements ControllerListener<ImageInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TopCategoryView f149232a;

    @Override // com.facebook.drawee.controller.ControllerListener
    public final void onIntermediateImageFailed(String r100, Throwable r101) {
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public final void onRelease(String r100) {
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public final void onSubmit(String r100, Object r101) {
    }

    public h(TopCategoryView r100) {
        this.f149232a = r100;
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public final void onFailure(String r100, Throwable r101) {
        this.f149232a.f149169a.setVisibility(0);
        this.f149232a.f149172d.setVisibility(8);
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public final /* bridge */ /* synthetic */ void onIntermediateImageSet(String r100, ImageInfo r101) {
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public final /* bridge */ /* synthetic */ void onFinalImageSet(String r100, ImageInfo r101, Animatable r102) {
    }
}
