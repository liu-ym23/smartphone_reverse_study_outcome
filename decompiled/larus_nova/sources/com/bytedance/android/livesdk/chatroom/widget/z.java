package com.bytedance.android.livesdk.chatroom.widget;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: classes8.dex */
public final class z extends BaseControllerListener<ImageInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FansRankListAnimationWidget f119265a;

    public z(FansRankListAnimationWidget r100) {
        this.f119265a = r100;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFailure(String r100, Throwable r101) {
        FansRankListAnimationWidget r102 = this.f119265a;
        int r103 = FansRankListAnimationWidget.f118489o;
        r102.wq();
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
        ImageInfo r103 = (ImageInfo) r101;
        if (r102 != null) goto L5;
    L7:
        FansRankListAnimationWidget r104 = this.f119265a;
        if (r104.f118503n == null) goto L15;
        AnimatedDrawable2 r105 = r104.f118502m;
        if (r105 == null) goto L15;
        r105.start();
        AnimatedDrawable2 r106 = r104.f118503n;
        if (r106 == null) goto L14;
        r106.start();
    L14:
        r104.contentView.postDelayed(new d0(r104), 4000);
        return;
    L15:
        r104.wq();
        return;
    L5:
        if ((r102 instanceof AnimatedDrawable2) == false) goto L7;
        AnimatedDrawable2 r107 = (AnimatedDrawable2) r102;
        this.f119265a.f118503n = r107;
        r107.setAnimationListener(new y(this));
        goto L7
    }
}
