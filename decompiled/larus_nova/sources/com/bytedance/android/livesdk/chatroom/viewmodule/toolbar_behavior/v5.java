package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.graphics.drawable.Animatable;
import android.view.View;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes8.dex */
public final class v5 extends BaseControllerListener<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t5 f117440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f117441b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0 f117442c;

    public static final class a extends BaseAnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v5 f117443a;

        @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
        public final void onAnimationFrame(AnimatedDrawable2 r100, int r101) {
        }

        public a(v5 r100) {
            this.f117443a = r100;
        }

        @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
        public final void onAnimationStart(AnimatedDrawable2 r100) {
            this.f117443a.f117441b.invoke();
        }

        @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
        public final void onAnimationStop(AnimatedDrawable2 r100) {
            this.f117443a.f117442c.invoke();
        }
    }

    public v5(ToolbarVrModeBehavior r100, Function0 r101, Function0 r102) {
        this.f117440a = r100;
        this.f117441b = r101;
        this.f117442c = r102;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
        t5 r103 = this.f117440a;
        r103.f117381e = true;
        if (r103.f117382f == false) goto L8;
        View r104 = r103.f117378b;
        if (r104 == null) goto L8;
        r104.setVisibility(8);
    L8:
        if ((r102 instanceof AnimatedDrawable2) == false) goto L11;
        ((AnimatedDrawable2) r102).setAnimationListener(new a(this));
        return;
    }
}
