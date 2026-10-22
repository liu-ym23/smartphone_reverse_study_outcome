package com.bytedance.android.live.liveinteract.animation.tasklet;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes46.dex */
public final class f0 extends BaseControllerListener<ImageInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WebPAnimationTasklet f71189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f71190b;

    public f0(WebPAnimationTasklet r100, Function1 r101) {
        this.f71189a = r100;
        this.f71190b = r101;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFailure(String r100, Throwable r101) {
        super.onFailure(r100, r101);
        Function1 r102 = this.f71190b;
        if (r102 == null) goto L5;
        Unit r103 = (Unit) r102.invoke(Boolean.FALSE);
    L5:
        WebPAnimationTasklet r104 = this.f71189a;
        Function2<d, Boolean, Unit> r105 = r104.f71162k;
        if (r105 == null) goto L9;
        Unit r106 = r105.invoke(r104, Boolean.FALSE);
        return;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
        super.onFinalImageSet(r100, (ImageInfo) r101, r102);
        if ((r102 instanceof AnimatedDrawable2) == false) goto L5;
        AnimatedDrawable2 r103 = (AnimatedDrawable2) r102;
        com.bytedance.android.live.core.utils.fresco.c.c(r103);
        r103.setAnimationListener(new e0(this));
    L5:
        Function1 r104 = this.f71190b;
        if (r104 == null) goto L9;
        Unit r105 = (Unit) r104.invoke(Boolean.TRUE);
        return;
    }
}
