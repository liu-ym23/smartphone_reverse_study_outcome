package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ogc;

import android.graphics.drawable.Animatable;
import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: classes8.dex */
public final class c extends BaseControllerListener<ImageInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OgcVSWebActivityBehavior f116644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HSImageView f116645b;

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFailure(String r100, Throwable r101) {
    }

    public c(OgcVSWebActivityBehavior r100, HSImageView r101) {
        this.f116644a = r100;
        this.f116645b = r101;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
        ImageInfo r103 = (ImageInfo) r101;
        if ((r102 instanceof AnimatedDrawable2) == true) goto L5;
        Animatable r104 = null;
    L6:
        AnimatedDrawable2 r105 = (AnimatedDrawable2) r104;
        if (r105 == null) goto L9;
        int r106 = r105.getFrameCount();
    L10:
        if (r105 == null) goto L12;
        r105.setAnimationListener(new b(this, r106));
    L12:
        if (r102 == null) goto L15;
        r102.start();
        return;
    L15:
        return;
    L9:
        r106 = 0;
        goto L10
    L5:
        r104 = r102;
        goto L6
    }
}
