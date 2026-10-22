package com.bytedance.android.live.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class u implements m<String, View> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f102105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f102106b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f102107c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final GradientDrawable f102108d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f102109e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextSwitcher f102110f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AnimatorSet f102111g;

    public static final class a implements ViewSwitcher.ViewFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextSwitcher f102112a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ u f102113b;

        public a(TextSwitcher r100, u r101) {
            this.f102112a = r100;
            this.f102113b = r101;
        }

        @Override // android.widget.ViewSwitcher.ViewFactory
        public final View makeView() {
            TextView r100 = new TextView(this.f102112a.getContext());
            r100.setIncludeFontPadding(false);
            u r101 = this.f102113b;
            r100.setTextSize(r101.f102106b, r101.f102105a);
            r100.setTextColor(ColorProtector.parseColor(this.f102113b.f102107c));
            return r100;
        }
    }

    public static final class b {
    }

    public static final class c implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u f102114a;

        public c(u r100) {
            this.f102114a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            Object r101 = r100.getAnimatedValue();
            if (r101 == null) goto L7;
            int r102 = ((Integer) r101).intValue();
            this.f102114a.f102108d.setAlpha(r102);
            this.f102114a.f102109e.setAlpha((255 - r102) / 255);
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
    }

    public static final class d implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u f102115a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f102116b;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, "p0");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, "p0");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, "p0");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, "p0");
            this.f102115a.f102110f.setText(this.f102116b);
        }

        public d(u r100, String r101) {
            this.f102115a = r100;
            this.f102116b = r101;
        }
    }

    public static final class e implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u f102117a;

        public e(u r100) {
            this.f102117a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            Object r101 = r100.getAnimatedValue();
            if (r101 == null) goto L7;
            int r102 = ((Integer) r101).intValue();
            this.f102117a.f102108d.setAlpha(r102);
            this.f102117a.f102109e.setAlpha((255 - r102) / 255);
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.ui.m
    public final void a() {
        this.f102105a = 8.0f;
        this.f102106b = 1;
    }

    public u(View r100) {
        Intrinsics.checkNotNullParameter(r100, "parentContext");
        this.f102105a = 9.0f;
        this.f102106b = 1;
        this.f102107c = "#E6FFFFFF";
        Drawable r101 = ((ConstraintLayout) r100.findViewById(R.id.guest_send_gift_container)).getBackground().mutate();
        if (r101 == null) goto L7;
        this.f102108d = (GradientDrawable) r101;
        this.f102109e = r100.findViewById(R.id.guest_send_gift_container_bg);
        TextSwitcher r102 = (TextSwitcher) r100.findViewById(R.id.fans_ticket_count);
        Animation r103 = AnimationUtils.loadAnimation(r102.getContext(), R.anim.ttlive_fan_ticket_slide_up_in);
        Animation r104 = AnimationUtils.loadAnimation(r102.getContext(), R.anim.ttlive_fan_ticket_slide_up_out);
        r102.setMeasureAllChildren(false);
        r102.setInAnimation(r103);
        r102.setOutAnimation(r104);
        r102.setFactory(new a(r102, this));
        Unit r105 = Unit.INSTANCE;
        this.f102110f = r102;
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    }

    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public void update2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        AnimatorSet r101 = this.f102111g;
        if (r101 != null) goto L5;
    L9:
        this.f102111g = null;
        if (Intrinsics.areEqual(r100, "0") == false) goto L12;
        this.f102110f.setCurrentText(r100);
    L12:
        this.f102111g = new AnimatorSet();
        ValueAnimator r102 = ValueAnimator.ofInt(new int[]{255, 0});
        r102.setDuration(200);
        r102.addUpdateListener(new c(this));
        ValueAnimator r103 = ValueAnimator.ofInt(new int[]{0, 1});
        r103.setDuration(350);
        r103.setStartDelay(300);
        r103.addListener(new d(this, r100));
        ValueAnimator r104 = ValueAnimator.ofInt(new int[]{0, 255});
        r104.setDuration(200);
        r104.setStartDelay(500);
        r104.addUpdateListener(new e(this));
        AnimatorSet r105 = this.f102111g;
        if (r105 == null) goto L17;
        AnimatorSet.Builder r106 = r105.play(r102);
        if (r106 == null) goto L17;
        r106.before(r103);
    L17:
        AnimatorSet r107 = this.f102111g;
        if (r107 == null) goto L22;
        AnimatorSet.Builder r108 = r107.play(r103);
        if (r108 == null) goto L22;
        r108.before(r104);
    L22:
        AnimatorSet r109 = this.f102111g;
        if (r109 == null) goto L26;
        r109.start();
        return;
    L26:
        return;
    L5:
        if (r101.isStarted() != true) goto L9;
        AnimatorSet r110 = this.f102111g;
        if (r110 == null) goto L9;
        r110.end();
        goto L9
    }

    @Override // com.bytedance.android.live.ui.m
    public /* bridge */ /* synthetic */ void update(String r100) {
        update2(r100);
    }
}
