package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.graphics.drawable.Animatable;
import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes8.dex */
public final class z3 extends BaseControllerListener<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ToolbarMultiCameraBehavior f117528a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f117529b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0 f117530c;

    public static final class a extends BaseAnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ z3 f117531a;

        @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
        public final void onAnimationFrame(AnimatedDrawable2 r100, int r101) {
        }

        public a(z3 r100) {
            this.f117531a = r100;
        }

        @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
        public final void onAnimationStart(AnimatedDrawable2 r100) {
            this.f117531a.f117529b.invoke();
        }

        @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
        public final void onAnimationStop(AnimatedDrawable2 r100) {
            this.f117531a.f117530c.invoke();
        }
    }

    public z3(ToolbarMultiCameraBehavior r100, Function0 r101, Function0 r102) {
        this.f117528a = r100;
        this.f117529b = r101;
        this.f117530c = r102;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
        ToolbarMultiCameraBehavior r103 = this.f117528a;
        r103.f117019h = true;
        if (r103.f117020i == false) goto L8;
        HSImageView r104 = r103.f117014c;
        if (r104 == null) goto L8;
        r104.setVisibility(8);
    L8:
        if ((r102 instanceof AnimatedDrawable2) == false) goto L11;
        ((AnimatedDrawable2) r102).setAnimationListener(new a(this));
        return;
    }
}
