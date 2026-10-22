package com.bytedance.android.shopping.api.mall.common.homepage.card.common;

import android.graphics.drawable.Animatable;
import android.view.ViewGroup;
import com.bytedance.android.shopping.api.mall.common.tools.b0;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: classes13.dex */
public final class i extends BaseControllerListener<ImageInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SimpleDraweeView f170315a;

    public i(SimpleDraweeView r100) {
        this.f170315a = r100;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFailure(String r100, Throwable r101) {
        super.onFailure(r100, r101);
        b0.e(this.f170315a);
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
        ImageInfo r103 = (ImageInfo) r101;
        super.onFinalImageSet(r100, r103, r102);
        if (r103 == null) goto L22;
        if (r102 != null) goto L6;
        return;
    L6:
        if ((r102 instanceof AnimatedDrawable2) == false) goto L20;
        ViewGroup.LayoutParams r104 = this.f170315a.getLayoutParams();
        if (r104 != null) goto L10;
        r104 = new ViewGroup.LayoutParams(r103.getWidth(), r103.getHeight());
    L10:
        r104.width = r103.getWidth();
        r104.height = r103.getHeight();
        AnimatedDrawable2 r105 = (AnimatedDrawable2) r102;
        if (r105.isRunning() == false) goto L14;
        r102.stop();
    L14:
        if (r105.getLoopDurationMs() <= 0) goto L16;
        this.f170315a.postDelayed(new g(this), r105.getLoopDurationMs());
    L16:
        AnimationBackend r106 = r105.getAnimationBackend();
        if (r106 == null) goto L19;
        r105.setAnimationBackend(new c(r106));
    L19:
        this.f170315a.setLayoutParams(r104);
        r105.setAnimationListener(new h(r102, this));
        r102.start();
        return;
    L20:
        b0.e(this.f170315a);
        return;
    }
}
