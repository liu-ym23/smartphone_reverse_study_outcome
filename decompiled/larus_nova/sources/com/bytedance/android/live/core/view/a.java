package com.bytedance.android.live.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f66542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f66543b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f66544c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f66545d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f66546e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LiveCircleView f66547f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ValueAnimator f66548g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ValueAnimator f66549h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AnimatorSet f66550i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f66551j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ViewOnAttachStateChangeListenerC1100a f66552k;

    /* JADX INFO: renamed from: com.bytedance.android.live.core.view.a$a, reason: collision with other inner class name */
    public class ViewOnAttachStateChangeListenerC1100a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f66553a;

        public ViewOnAttachStateChangeListenerC1100a(a r100) {
            this.f66553a = r100;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r100) {
            a r101 = this.f66553a;
            if (r101.f66544c == false) goto L6;
            r101.c(0);
            r101.d();
            return;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r100) {
            a r101 = this.f66553a;
            r101.a();
            r101.c(8);
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f66554a;

        public b(a r100) {
            this.f66554a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            int r101 = ((Integer) r100.getAnimatedValue()).intValue();
            float r102 = r100.getAnimatedFraction();
            if (r102 > 0.5f) goto L5;
            float r103 = 1.0f - ((r102 / 0.5f) * 0.08f);
        L6:
            View r104 = this.f66554a.f66545d;
            if (r104 == null) goto L10;
            r104.setScaleX(r103);
            this.f66554a.f66545d.setScaleY(r103);
        L10:
            if (r101 >= 730) goto L12;
            return;
        L12:
            if (r101 >= 740) goto L18;
            a r105 = this.f66554a;
            if (r105.f66542a == true) goto L19;
            r105.f66542a = true;
            r105.f66549h.start();
            return;
        L19:
            return;
        L18:
            return;
        L5:
            r103 = 0.92f + (((r102 - 0.5f) / 0.5f) * 0.08f);
            goto L6
        }
    }

    public class c implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f66555a;

        public c(a r100) {
            this.f66555a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            int r101 = ((Integer) r100.getAnimatedValue()).intValue();
            if (r101 >= 0) goto L5;
            return;
        L5:
            if (r101 > 640) goto L11;
            float r102 = (r101 * 1.0f) / 640.0f;
            LiveCircleView r103 = this.f66555a.f66547f;
            if (r103 == null) goto L12;
            r103.setFraction(r102);
            return;
        L12:
            return;
        }
    }

    public class d extends AnimatorListenerAdapter {
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
        }

        public d() {
        }
    }

    public class e extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f66556a;

        public e(a r100) {
            this.f66556a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            ValueAnimator r101 = this.f66556a.f66549h;
            if (r101 == null) goto L5;
            r101.cancel();
        L5:
            ValueAnimator r102 = this.f66556a.f66548g;
            if (r102 == null) goto L8;
            r102.cancel();
        L8:
            a r103 = this.f66556a;
            r103.f66543b = false;
            r103.f66542a = false;
        }
    }

    public final void a() {
        AnimatorSet r100 = this.f66550i;
        if (r100 == null) goto L5;
        r100.cancel();
        this.f66543b = false;
        this.f66542a = false;
    L5:
        ValueAnimator r101 = this.f66549h;
        if (r101 == null) goto L9;
        r101.cancel();
        return;
    }

    public final void d() {
        if (LiveInfraSettingKeys.LIVE_AVATAR_BORDER_ANIM_OPTIMIZE.getValue().booleanValue() == true) goto L6;
    L11:
        boolean r100 = true;
    L13:
        if (r100 == true) goto L17;
        ALogger.d("AvatarBorderViewController", "isAvatarBorderViewVisible return not");
        return;
    L17:
        if (this.f66551j == false) goto L21;
        ALogger.d("AvatarBorderViewController", "not to show anim by degrade");
        return;
    L21:
        if (this.f66548g != null) goto L24;
        ValueAnimator r101 = ValueAnimator.ofInt(new int[]{0, 800});
        this.f66548g = r101;
        r101.setRepeatCount(-1);
        this.f66548g.setRepeatMode(1);
        this.f66548g.addUpdateListener(new b(this));
    L24:
        if (this.f66549h != null) goto L27;
        ValueAnimator r102 = ValueAnimator.ofInt(new int[]{0, 800});
        this.f66549h = r102;
        r102.setRepeatCount(-1);
        this.f66549h.setRepeatMode(1);
        this.f66549h.setDuration(800);
        this.f66549h.addUpdateListener(new c(this));
        this.f66549h.addListener(new d());
    L27:
        if (this.f66550i != null) goto L29;
        AnimatorSet r103 = new AnimatorSet();
        this.f66550i = r103;
        r103.setDuration(800);
        this.f66550i.addListener(new e(this));
    L29:
        this.f66550i.play(this.f66548g);
        this.f66543b = true;
        this.f66550i.start();
        return;
    L6:
        if (b(this.f66545d) == true) goto L11;
        if (b(this.f66546e) == true) goto L11;
        r100 = false;
        goto L13
    }

    static {
    }

    public static boolean b(View r100) {
        if (r100 != null) goto L4;
    L12:
        return false;
    L4:
        if (r100.getVisibility() != 0) goto L12;
        if (r100.getParent() == null) goto L12;
        if ((r100.getParent() instanceof View) == false) goto L12;
        if (((View) r100.getParent()).getVisibility() != 0) goto L12;
        return true;
    }

    public final void c(int r100) {
        if (r100 != 0) goto L14;
        LiveCircleView r101 = this.f66547f;
        if (r101 == null) goto L7;
        r101.setVisibility(0);
    L7:
        View r102 = this.f66545d;
        if (r102 == null) goto L26;
        r102.setVisibility(0);
        View r103 = this.f66546e;
        if (r103 != null) goto L12;
        return;
    L12:
        if (this.f66545d == r103) goto L28;
        r103.setVisibility(8);
        return;
    L28:
        return;
    L26:
        return;
    L14:
        LiveCircleView r104 = this.f66547f;
        if (r104 == null) goto L17;
        r104.setVisibility(8);
    L17:
        View r105 = this.f66545d;
        if (r105 != null) goto L20;
    L22:
        View r106 = this.f66546e;
        if (r106 == null) goto L30;
        r106.setVisibility(0);
        return;
    L30:
        return;
    L20:
        if (r105 == this.f66546e) goto L22;
        r105.setVisibility(8);
        goto L22
    }

    public a(SimpleDraweeView r100, LiveCircleView r101) {
        this.f66544c = true;
        this.f66551j = false;
        ViewOnAttachStateChangeListenerC1100a r102 = new ViewOnAttachStateChangeListenerC1100a(this);
        this.f66552k = r102;
        this.f66545d = r100;
        this.f66546e = r100;
        this.f66547f = r101;
        r101.setVisibility(0);
        r100.addOnAttachStateChangeListener(r102);
    }

    public a(View r100, LiveCircleView r101, Boolean r102) {
        this.f66544c = true;
        int r103 = 0;
        this.f66551j = false;
        ViewOnAttachStateChangeListenerC1100a r104 = new ViewOnAttachStateChangeListenerC1100a(this);
        this.f66552k = r104;
        this.f66544c = r102.booleanValue();
        this.f66545d = r100;
        this.f66546e = r100;
        this.f66547f = r101;
        if (r102.booleanValue() == true) goto L6;
        r103 = 8;
    L6:
        r101.setVisibility(r103);
        r100.addOnAttachStateChangeListener(r104);
    }
}
