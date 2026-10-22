package com.bytedance.android.livesdk.gift.platform.business.toolbar;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes9.dex */
public final class j extends BaseControllerListener<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f130226a;

    public static final class a extends BaseAnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f130227a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Animatable f130228b;

        @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
        public final void onAnimationStart(AnimatedDrawable2 r100) {
        }

        @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
        public final void onAnimationStop(AnimatedDrawable2 r100) {
        }

        public a(Animatable r100) {
            this.f130228b = r100;
            this.f130227a = -1;
        }

        @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
        public final void onAnimationFrame(AnimatedDrawable2 r100, int r101) {
            if (r101 >= this.f130227a) goto L7;
            Animatable r102 = this.f130228b;
            if (r102 == null) goto L7;
            r102.stop();
        L7:
            this.f130227a = r101;
        }
    }

    public j(Function0 r100) {
        this.f130226a = r100;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
        if (r102 == null) goto L4;
        r102.start();
    L4:
        this.f130226a.invoke();
        if ((r102 instanceof AnimatedDrawable2) == false) goto L8;
        ((AnimatedDrawable2) r102).setAnimationListener(new a(r102));
        return;
    }
}
