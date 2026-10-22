package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.frame.DropFramesFrameScheduler;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: classes10.dex */
public final class p extends BaseControllerListener<ImageInfo> {
    public p() {
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
        super.onFinalImageSet(r100, (ImageInfo) r101, r102);
        if ((r102 instanceof AnimatedDrawable2) == true) goto L5;
        Animatable r103 = null;
    L6:
        AnimatedDrawable2 r104 = (AnimatedDrawable2) r103;
        if (r104 == null) goto L10;
        r104.setPrivateFrameScheduler(new DropFramesFrameScheduler(((AnimatedDrawable2) r102).getAnimationBackend()));
        return;
    L10:
        return;
    L5:
        r103 = r102;
        goto L6
    }
}
