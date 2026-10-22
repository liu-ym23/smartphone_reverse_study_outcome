package com.bytedance.android.live.liveinteract.animation;

import android.graphics.drawable.Animatable;
import com.bytedance.android.live.core.log.ALogger;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class e0 extends BaseControllerListener<ImageInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y f70975a;

    public e0(y r100) {
        this.f70975a = r100;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFailure(String r100, Throwable r101) {
        ALogger.e("interact_emoji", "receiver extra emoji load failed " + r101);
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
        ImageInfo r103 = (ImageInfo) r101;
        Intrinsics.checkNotNullParameter(r100, "id");
        if ((r102 instanceof AnimatedDrawable2) == false) goto L6;
        ((AnimatedDrawable2) r102).setAnimationListener(new d0(this));
        return;
    }
}
