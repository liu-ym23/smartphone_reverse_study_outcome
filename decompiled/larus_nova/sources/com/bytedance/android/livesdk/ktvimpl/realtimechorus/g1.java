package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.frame.DropFramesFrameScheduler;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes10.dex */
public final class g1 extends BaseControllerListener<ImageInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f146576a;

    public g1(Function0 r100) {
        this.f146576a = r100;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
        ImageInfo r103 = (ImageInfo) r101;
        if ((r102 instanceof AnimatedDrawable2) == true) goto L5;
        Animatable r104 = null;
    L6:
        AnimatedDrawable2 r105 = (AnimatedDrawable2) r104;
        if (r105 == null) goto L10;
        r105.setAnimationBackend(new f1(r105.getAnimationBackend()));
        r105.setPrivateFrameScheduler(new DropFramesFrameScheduler(((AnimatedDrawable2) r102).getAnimationBackend()));
        r105.setAnimationListener(new e1(this, r102));
        r105.start();
        return;
    L10:
        return;
    L5:
        r104 = r102;
        goto L6
    }
}
