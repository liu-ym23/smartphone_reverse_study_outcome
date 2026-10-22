package com.bytedance.android.live.liveinteract.animation.tasklet;

import android.graphics.drawable.Animatable;
import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: classes46.dex */
public final class b0 extends BaseControllerListener<ImageInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ z f71169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HSImageView f71170b;

    public b0(z r100, HSImageView r101) {
        this.f71169a = r100;
        this.f71170b = r101;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFailure(String r100, Throwable r101) {
        super.onFailure(r100, r101);
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
        super.onFinalImageSet(r100, (ImageInfo) r101, r102);
        if ((r102 instanceof AnimatedDrawable2) == false) goto L6;
        z r103 = this.f71169a;
        HSImageView r104 = this.f71170b;
        AnimatedDrawable2 r105 = (AnimatedDrawable2) r102;
        r103.getClass();
        r105.setAnimationListener(new a0(r103, r104));
        com.bytedance.android.live.core.utils.fresco.c.c(r105);
        r102.start();
        return;
    }
}
