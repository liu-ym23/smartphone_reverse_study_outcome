package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.view.combo.GroupWaveAnimationView;
import com.larus.nova.R;
import qz1.e;
import qz1.f;
import qz1.g;
import qz1.h;

/* JADX INFO: loaded from: classes9.dex */
public class LiveGiftGroupComboViewNew extends FrameLayout {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f126678g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LottieAnimationView f126679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f126680b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AnimatorSet f126681c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Animator.AnimatorListener f126682d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LottieAnimationView f126683e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public GroupWaveAnimationView f126684f;

    public class a implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f126685a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LiveGiftGroupComboViewNew f126686b;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            this.f126686b.f126680b = 0;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            this.f126685a.run();
            this.f126686b.f126684f.removeAllViews();
            this.f126686b.f126680b = 0;
        }

        public a(LiveGiftGroupComboViewNew r100, Runnable r101) {
            this.f126686b = r100;
            this.f126685a = r101;
        }
    }

    public final void a() {
        AnimatorSet r100 = this.f126681c;
        if (r100 != null) goto L5;
    L7:
        this.f126681c = null;
        LottieAnimationView r101 = this.f126679a;
        if (r101 == null) goto L13;
        Animator.AnimatorListener r102 = this.f126682d;
        if (r102 == null) goto L14;
        r101.removeAnimatorListener(r102);
        this.f126682d = null;
        return;
    L14:
        return;
    L13:
        return;
    L5:
        if (r100.isRunning() == false) goto L7;
        this.f126681c.removeAllListeners();
        this.f126681c.cancel();
        goto L7
    }

    public LiveGiftGroupComboViewNew(Context r100) {
        this(r100, null);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [qz1.e] */
    public final void b(final Runnable r110) {
        this.f126679a.setVisibility(0);
        if (this.f126680b != 0) goto L7;
        a();
        this.f126680b = 1;
        this.f126681c = new AnimatorSet();
        ObjectAnimator r100 = ObjectAnimator.ofFloat(this, LiveDegradeFpsAnimator.SCALE_X, new float[]{0.9f, 1.1f, 1.0f});
        ObjectAnimator r101 = ObjectAnimator.ofFloat(this, LiveDegradeFpsAnimator.SCALE_Y, new float[]{0.9f, 1.1f, 1.0f});
        this.f126681c.playTogether(new Animator[]{r100, r101});
        this.f126681c.setDuration(300);
        this.f126681c.setInterpolator(new PathInterpolator(0.42f, 0.0f, 0.58f, 1.0f));
        this.f126681c.addListener(new f(this, r110));
        this.f126681c.start();
        this.f126684f.a();
        LottieAnimationView r111 = this.f126683e;
        if (r111 == null) goto L9;
        r111.cancelAnimation();
        this.f126683e.playAnimation();
        return;
    L9:
        return;
    L7:
        ?? r102 = new e(this, r110);
        a();
        this.f126680b = 1;
        this.f126681c = new AnimatorSet();
        ObjectAnimator r112 = ObjectAnimator.ofFloat(this, LiveDegradeFpsAnimator.SCALE_X, new float[]{1.0f, 0.95f, 1.0f});
        ObjectAnimator r103 = ObjectAnimator.ofFloat(this, LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.0f, 0.95f, 1.0f});
        this.f126681c.playTogether(new Animator[]{r112, r103});
        this.f126681c.setDuration(200);
        this.f126681c.setInterpolator(new PathInterpolator(0.42f, 0.0f, 0.58f, 1.0f));
        this.f126681c.addListener(new g(r102));
        this.f126681c.start();
        this.f126679a.setSpeed(-20.0f);
        this.f126682d = new h();
        this.f126684f.a();
        this.f126679a.addAnimatorListener(this.f126682d);
    }

    public final void c(Runnable r100) {
        a();
        this.f126680b = 2;
        this.f126679a.setSpeed(1.0f);
        a r101 = new a(this, r100);
        this.f126682d = r101;
        this.f126679a.addAnimatorListener(r101);
        this.f126679a.playAnimation();
    }

    public LiveGiftGroupComboViewNew(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public LiveGiftGroupComboViewNew(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f126680b = 0;
        View.inflate(r100, R.layout.ttlive_base_gift_group_combo_view, this);
        this.f126679a = (LottieAnimationView) findViewById(R.id.combo_bg);
        this.f126683e = (LottieAnimationView) findViewById(R.id.dot_anim);
        this.f126684f = (GroupWaveAnimationView) findViewById(R.id.wave_anim);
        this.f126679a.setImageAssetsFolder("images");
        this.f126679a.setAnimation("ttlive_gift_group_combo_button.json");
        this.f126683e.setAnimation("ttlive_gift_group_dot.json");
        this.f126679a.loop(false);
        this.f126683e.loop(true);
    }
}
