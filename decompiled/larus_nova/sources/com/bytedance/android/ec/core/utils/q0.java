package com.bytedance.android.ec.core.utils;

import com.facebook.drawee.controller.ControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: classes43.dex */
public abstract class q0 implements ControllerListener<ImageInfo> {
    public q0() {
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public final void onFailure(String r100, Throwable r101) {
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public final void onIntermediateImageFailed(String r100, Throwable r101) {
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public final void onRelease(String r100) {
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public final void onSubmit(String r100, Object r101) {
    }
}
