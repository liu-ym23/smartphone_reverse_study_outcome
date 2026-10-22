package com.bytedance.android.live.liveinteract.chatroom.chatroom.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.drawable.Animatable;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class g extends BaseControllerListener<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LinkSucAnimationView f72461a;

    public static final class a extends BaseAnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f72462a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f72463b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Animatable f72464c;

        @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
        public final void onAnimationStop(AnimatedDrawable2 r110) {
            Intrinsics.checkNotNullParameter(r110, "drawable");
            LinkSucAnimationView r111 = this.f72463b.f72461a;
            int r100 = LinkSucAnimationView.f72383j;
            r111.getClass();
            ALogger.i("LinkSucAnimationView", "startMatchFinishAnimation, viewDetached=" + r111.f72391h + ", guestAvatar=" + r111.f72384a);
            if (r111.f72391h == false) goto L5;
        L20:
            Function0<Unit> r101 = r111.f72390g;
            if (r101 == null) goto L23;
            r101.invoke();
        L23:
            LinkSucAnimationView.a r112 = r111.f72389f;
            if (r112 == null) goto L26;
            r112.h();
        L26:
            LinkSucAnimationView r113 = this.f72463b.f72461a;
            r113.getClass();
            ALogger.i("LinkSucAnimationView", "startGuestNameAnimation, guestName=" + r113.f72385b);
            TextView r102 = r113.f72385b;
            if (r102 == null) goto L31;
            Intrinsics.checkNotNull(r102);
            ObjectAnimator r103 = ObjectAnimator.ofFloat(r102, "alpha", new float[]{1.0f, 0.1f});
            TextView r104 = r113.f72385b;
            Intrinsics.checkNotNull(r104);
            ObjectAnimator r105 = ObjectAnimator.ofFloat(r104, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{0.0f, 20.0f});
            AnimatorSet r106 = new AnimatorSet();
            r106.playTogether(new Animator[]{r103, r105});
            r106.setDuration(150);
            r106.start();
            r106.addListener(new e(r113));
            return;
        L31:
            return;
        L5:
            if (r111.f72384a == null) goto L20;
            r111.setVisibility(8);
            ImageView r107 = r111.f72384a;
            if (r107 == null) goto L10;
            r107.setVisibility(0);
        L10:
            py.k r108 = r111.f72388e;
            if (r108 == null) goto L13;
            ImageUtil.loadRoundImage(r111.f72384a, r108);
        L13:
            ImageView r109 = r111.f72384a;
            if (r109 == null) goto L16;
            Intrinsics.checkNotNull(r109);
            r109.setPivotX(r109.getWidth() >> 1);
        L16:
            ImageView r114 = r111.f72384a;
            if (r114 == null) goto L19;
            Intrinsics.checkNotNull(r114);
            r114.setPivotY(r114.getHeight() >> 1);
        L19:
            ImageView r115 = r111.f72384a;
            Intrinsics.checkNotNull(r115);
            ObjectAnimator r116 = ObjectAnimator.ofFloat(r115, LiveDegradeFpsAnimator.SCALE_X, new float[]{0.0f, 0.36f, 0.72f, 1.1f, 1.05f, 1.0f});
            ImageView r117 = r111.f72384a;
            Intrinsics.checkNotNull(r117);
            ObjectAnimator r118 = ObjectAnimator.ofFloat(r117, LiveDegradeFpsAnimator.SCALE_Y, new float[]{0.0f, 0.36f, 0.72f, 1.1f, 1.05f, 1.0f});
            ImageView r119 = r111.f72384a;
            Intrinsics.checkNotNull(r119);
            ObjectAnimator r120 = ObjectAnimator.ofFloat(r119, "alpha", new float[]{0.2f, 0.5f, 1.0f});
            AnimatorSet r121 = new AnimatorSet();
            r121.setDuration(500);
            r121.setInterpolator(new DecelerateInterpolator());
            r121.playTogether(new Animator[]{r116, r118, r120});
            r121.start();
            r121.addListener(new f(r111));
            goto L26
        }

        public a(g r100, Animatable r101) {
            this.f72463b = r100;
            this.f72464c = r101;
            this.f72462a = -1;
        }

        @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
        public final void onAnimationFrame(AnimatedDrawable2 r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "drawable");
            if (r101 >= this.f72462a) goto L5;
            this.f72464c.stop();
        L5:
            this.f72462a = r101;
        }
    }

    public g(LinkSucAnimationView r100) {
        this.f72461a = r100;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
        Intrinsics.checkNotNullParameter(r100, "id");
        if ((r102 instanceof AnimatedDrawable2) == false) goto L6;
        ((AnimatedDrawable2) r102).setAnimationListener(new a(this, r102));
        return;
    }
}
