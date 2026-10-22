package com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.animation;

import android.animation.ObjectAnimator;
import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes9.dex */
public final class h extends BaseControllerListener<ImageInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f129954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f129955b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f129956c;

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFailure(String r100, Throwable r101) {
        this.f129954a.b();
        this.f129955b.element = true;
    }

    public h(f r100, Ref.BooleanRef r101, Ref.ObjectRef r102) {
        this.f129954a = r100;
        this.f129955b = r101;
        this.f129956c = r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
        ImageInfo r103 = (ImageInfo) r101;
        if ((r102 instanceof AnimatedDrawable2) == true) goto L5;
        r102 = null;
    L5:
        AnimatedDrawable2 r104 = (AnimatedDrawable2) r102;
        if (r104 == null) goto L17;
        final Ref.BooleanRef r105 = new Ref.BooleanRef();
        r105.element = false;
        this.f129955b.element = true;
        this.f129954a.f129942a = r104;
        com.bytedance.android.live.core.utils.fresco.c.c(r104);
        AnimatedDrawable2 r106 = this.f129954a.f129942a;
        if (r106 == null) goto L10;
        j.a(r106, new ExitAnimationTask$playAchievementWebp$listener$1$onFinalImageSet$$inlined$let$lambda$1(r105, this), ExitAnimationTask$playAchievementWebp$listener$1$onFinalImageSet$1$2.INSTANCE);
    L10:
        AnimatedDrawable2 r107 = this.f129954a.f129942a;
        if (r107 == null) goto L13;
        r107.start();
    L13:
        ObjectAnimator r108 = (ObjectAnimator) this.f129956c.element;
        if (r108 == null) goto L18;
        r108.start();
        return;
    L18:
        return;
    }
}
