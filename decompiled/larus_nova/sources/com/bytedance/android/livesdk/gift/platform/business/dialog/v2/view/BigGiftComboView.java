package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.livesdk.gift.biggift.view.d;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.l1;
import com.bytedance.android.livesdk.gift.model.n;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.view.combo.ComboProgressAnimationView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.view.combo.RoundWaveAnimationView;
import com.larus.nova.R;
import io.reactivex.disposables.Disposable;
import jy0.b;

/* JADX INFO: loaded from: classes9.dex */
public class BigGiftComboView extends BaseGiftComboView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f126630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f126631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AnimatorSet f126632c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f126633d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f126634e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ComboProgressAnimationView f126635f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RoundWaveAnimationView f126636g;

    public class a implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Long f126637a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Long f126638b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Runnable f126639c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ BigGiftComboView f126640d;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            this.f126640d.f126633d = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            if (this.f126640d.f126633d == false) goto L5;
            return;
        L5:
            Runnable r101 = this.f126639c;
            if (r101 == null) goto L8;
            r101.run();
        L8:
            this.f126640d.f126631b.setVisibility(8);
            this.f126640d.f126630a.setVisibility(8);
            this.f126638b = Long.valueOf(System.currentTimeMillis());
            b.d("BigGiftComboView", "show time:" + (this.f126638b.longValue() - this.f126637a.longValue()) + "ms");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            this.f126637a = Long.valueOf(System.currentTimeMillis());
        }

        public a(BigGiftComboView r100, d r101) {
            this.f126640d = r100;
            this.f126639c = r101;
        }
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView
    public final void a(long r100) {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView
    public final void b(h2 r100) {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView
    public void setComboCount(int r100) {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView
    public void setGiftType(String r100) {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView
    public final void d() {
        AnimatorSet r100 = this.f126632c;
        if (r100 != null) goto L5;
    L7:
        this.f126631b.setVisibility(8);
        this.f126630a.setVisibility(8);
        RoundWaveAnimationView r101 = this.f126636g;
        if (r101 == null) goto L14;
        Disposable r102 = r101.f128697a;
        if (r102 == null) goto L12;
        r102.dispose();
    L12:
        r101.removeAllViews();
        return;
    L14:
        return;
    L5:
        if (r100.isRunning() == false) goto L7;
        this.f126632c.cancel();
        this.f126632c.removeAllListeners();
        this.f126632c = null;
        goto L7
    }

    public BigGiftComboView(Context r100) {
        this(r100, null);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView
    public void setCountDownTime(long r100) {
        this.f126634e = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView
    public void setIsGroupSend(boolean r100) {
        ComboProgressAnimationView r101 = this.f126635f;
        if (r101 == null) goto L6;
        r101.setGroupSend(r100);
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView
    public void setIsSeriesSend(boolean r100) {
        ComboProgressAnimationView r101 = this.f126635f;
        if (r101 == null) goto L6;
        r101.setSeriesSend(r100);
        return;
    }

    public BigGiftComboView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public BigGiftComboView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f126634e = 10000;
        View.inflate(r100, R.layout.ttlive_base_gift_combo_view_v3, this);
        this.f126630a = findViewById(R.id.combo_bg);
        this.f126631b = findViewById(R.id.combo_title);
        ComboProgressAnimationView r103 = (ComboProgressAnimationView) findViewById(R.id.combo_progress);
        this.f126635f = r103;
        r103.setVisibility(4);
        this.f126636g = (RoundWaveAnimationView) findViewById(R.id.round_wave_anim_view);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView
    public final void c(Runnable r110, int r111, int r112) {
        AnimatorSet r100 = this.f126632c;
        if (r100 != null) goto L5;
    L7:
        this.f126630a.setAlpha(1.0f);
        this.f126631b.setAlpha(1.0f);
        this.f126632c = new AnimatorSet();
        ObjectAnimator r101 = ObjectAnimator.ofFloat(this.f126631b, LiveDegradeFpsAnimator.SCALE_X, new float[]{1.0f, 0.9f, 1.0f}).setDuration(133);
        ObjectAnimator r102 = ObjectAnimator.ofFloat(this.f126631b, LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.0f, 0.9f, 1.0f}).setDuration(133);
        ObjectAnimator r103 = ObjectAnimator.ofFloat(this.f126630a, LiveDegradeFpsAnimator.SCALE_X, new float[]{1.0f, 0.9f, 1.0f}).setDuration(133);
        ObjectAnimator r104 = ObjectAnimator.ofFloat(this.f126630a, LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.0f, 0.9f, 1.0f}).setDuration(133);
        ObjectAnimator r105 = ObjectAnimator.ofFloat(this.f126630a, "rotation", new float[]{0.0f, 360.0f}).setDuration(this.f126634e);
        this.f126632c.playTogether(new Animator[]{r101, r102, r103, r104, r105});
        this.f126632c.addListener(new a(this, (d) r110));
        this.f126633d = false;
        this.f126632c.start();
        this.f126631b.setVisibility(0);
        this.f126630a.setVisibility(0);
        this.f126635f.setVisibility(0);
        this.f126635f.i(r112, r111);
        this.f126635f.j();
        RoundWaveAnimationView r113 = this.f126636g;
        if (r113 == null) goto L11;
        r113.a();
        return;
    L11:
        return;
    L5:
        if (r100.isRunning() == false) goto L7;
        this.f126632c.cancel();
        this.f126632c.removeAllListeners();
        this.f126632c = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView
    public final void e(h2 r100, l1 r101, n r102) {
        ComboProgressAnimationView r103 = this.f126635f;
        if (r103 == null) goto L6;
        r103.setGift(r100);
        return;
    }
}
