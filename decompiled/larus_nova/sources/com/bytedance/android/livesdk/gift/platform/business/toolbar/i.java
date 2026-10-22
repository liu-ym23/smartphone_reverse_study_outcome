package com.bytedance.android.livesdk.gift.platform.business.toolbar;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes9.dex */
public final class i extends BaseControllerListener<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f130221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f130222b;

    public static final class a extends BaseAnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f130223a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i f130224b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Animatable f130225c;

        @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
        public final void onAnimationStart(AnimatedDrawable2 r100) {
            this.f130224b.f130221a.invoke(this.f130225c);
        }

        @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
        public final void onAnimationStop(AnimatedDrawable2 r100) {
            this.f130224b.f130222b.invoke();
        }

        public a(i r100, Animatable r101) {
            this.f130224b = r100;
            this.f130225c = r101;
            this.f130223a = -1;
        }

        @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
        public final void onAnimationFrame(AnimatedDrawable2 r100, int r101) {
            if (r101 >= this.f130223a) goto L5;
            this.f130225c.stop();
        L5:
            this.f130223a = r101;
        }
    }

    public i(Function1 r100, Function0 r101) {
        this.f130221a = r100;
        this.f130222b = r101;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
        if ((r102 instanceof AnimatedDrawable2) == false) goto L5;
        ((AnimatedDrawable2) r102).setAnimationListener(new a(this, r102));
    L5:
        if (r102 == null) goto L8;
        r102.start();
        return;
    }
}
