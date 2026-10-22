package com.bytedance.android.livesdk.chatroom.viewmodule.welfare;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes8.dex */
public final class d extends BaseControllerListener<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f117609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function2 f117610b;

    public static final class a extends BaseAnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f117611a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f117612b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ d f117613c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Animatable f117614d;

        @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
        public final void onAnimationStart(AnimatedDrawable2 r100) {
        }

        @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
        public final void onAnimationStop(AnimatedDrawable2 r100) {
            this.f117613c.f117609a.invoke();
        }

        public a(d r100, Animatable r101) {
            this.f117613c = r100;
            this.f117614d = r101;
            this.f117611a = -1;
            this.f117612b = -1;
        }

        @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
        public final void onAnimationFrame(AnimatedDrawable2 r100, int r101) {
            int r102 = this.f117612b;
            if (r102 >= 0) goto L8;
            if (r100 == null) goto L6;
            r102 = r100.getFrameCount();
        L6:
            this.f117612b = r102;
        L8:
            if (this.f117612b <= 0) goto L11;
            this.f117613c.f117610b.invoke(Integer.valueOf(r101), Integer.valueOf(this.f117612b));
        L11:
            if (r101 >= this.f117611a) goto L15;
            this.f117614d.stop();
            if (this.f117612b >= 0) goto L15;
            this.f117613c.f117610b.invoke(Integer.valueOf(r101), Integer.valueOf(r101));
        L15:
            this.f117611a = r101;
        }
    }

    public d(Function0 r100, Function2 r101) {
        this.f117609a = r100;
        this.f117610b = r101;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
        if (r102 == null) goto L5;
        r102.start();
    L5:
        if ((r102 instanceof AnimatedDrawable2) == false) goto L8;
        ((AnimatedDrawable2) r102).setAnimationListener(new a(this, r102));
        return;
    }
}
