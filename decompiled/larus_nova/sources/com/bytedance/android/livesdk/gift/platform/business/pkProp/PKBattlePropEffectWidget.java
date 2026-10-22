package com.bytedance.android.livesdk.gift.platform.business.pkProp;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.GiftRecyclableWidget;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.live.datacontext.n;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.AnimationListener;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.downloadlib.addownload.AdQuickAppManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/pkProp/PKBattlePropEffectWidget;", "Lcom/bytedance/android/GiftRecyclableWidget;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PKBattlePropEffectWidget extends GiftRecyclableWidget {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HSImageView f130003b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public u02.a f130004c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AnimatedDrawable2 f130005d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AnimatorSet f130006e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AnimatorSet f130007f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f130008g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public HSImageView f130009h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AnimatorSet f130010i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c f130011j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final d f130012k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final b f130013l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f130014m;

    public static final class a {
    }

    public static final class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PKBattlePropEffectWidget f130015a;

        public b(PKBattlePropEffectWidget r100) {
            this.f130015a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            PKBattlePropEffectWidget r101 = this.f130015a;
            r101.f130014m = false;
            HSImageView r102 = r101.f130009h;
            if (r102 == null) goto L6;
            r102.setVisibility(8);
            return;
        }
    }

    public static final class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PKBattlePropEffectWidget f130016a;

        public c(PKBattlePropEffectWidget r100) {
            this.f130016a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            HSImageView r101 = this.f130016a.f130003b;
            if (r101 == null) goto L5;
            r101.setVisibility(8);
        L5:
            u02.a r102 = this.f130016a.f130004c;
            if (r102 == null) goto L9;
            r102.onEnd();
            return;
        }
    }

    public static final class d implements AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PKBattlePropEffectWidget f130017a;

        @Override // com.facebook.fresco.animation.drawable.AnimationListener
        public final void onAnimationRepeat(AnimatedDrawable2 r100) {
        }

        @Override // com.facebook.fresco.animation.drawable.AnimationListener
        public final void onAnimationReset(AnimatedDrawable2 r100) {
        }

        @Override // com.facebook.fresco.animation.drawable.AnimationListener
        public final void onAnimationStart(AnimatedDrawable2 r100) {
        }

        @Override // com.facebook.fresco.animation.drawable.AnimationListener
        public final void onAnimationStop(AnimatedDrawable2 r100) {
        }

        public d(PKBattlePropEffectWidget r100) {
            this.f130017a = r100;
        }

        @Override // com.facebook.fresco.animation.drawable.AnimationListener
        public final void onAnimationFrame(AnimatedDrawable2 r210, int r211) {
            if (r210 == null) goto L5;
            int r100 = r210.getFrameCount();
        L7:
            if (r211 < (r100 - 1)) goto L40;
            AnimatedDrawable2 r101 = this.f130017a.f130005d;
            if (r101 == null) goto L11;
            r101.stop();
        L11:
            AnimatedDrawable2 r102 = this.f130017a.f130005d;
            View r103 = null;
            if (r102 == null) goto L14;
            r102.setAnimationListener(null);
        L14:
            GiftContext r104 = com.bytedance.android.livesdk.gift.util.b.b();
            if (r104 == null) goto L19;
            n<View> r105 = r104.getGiftIcon();
            if (r105 == null) goto L19;
            r103 = r105.getValue();
        L19:
            PKBattlePropEffectWidget r106 = this.f130017a;
            HSImageView r107 = r106.f130003b;
            if (r107 == null) goto L34;
            if (r103 == null) goto L34;
            if (r106.f130008g == false) goto L34;
            int[] r108 = new int[2];
            r103.getLocationOnScreen(r108);
            r108[0] = r108[0] + (r103.getWidth() / 2);
            r108[1] = r108[1] + (r103.getHeight() / 2);
            HSImageView r109 = this.f130017a.f130003b;
            Intrinsics.checkNotNull(r109);
            int[] r110 = {r8 + (r9.getWidth() / 2), r8 + (r9.getHeight() / 2)};
            r109.getLocationOnScreen(r110);
            int r111 = r110[0];
            HSImageView r112 = this.f130017a.f130003b;
            Intrinsics.checkNotNull(r112);
            int r113 = r110[1];
            HSImageView r114 = this.f130017a.f130003b;
            Intrinsics.checkNotNull(r114);
            PKBattlePropEffectWidget r115 = this.f130017a;
            HSImageView r116 = r115.f130003b;
            Intrinsics.checkNotNull(r116);
            Intrinsics.checkNotNullParameter(r116, "animationView");
            Intrinsics.checkNotNullParameter(r110, "sourceLocation");
            Intrinsics.checkNotNullParameter(r108, "targetLocation");
            AnimatorSet r117 = new AnimatorSet();
            ObjectAnimator r118 = ObjectAnimator.ofFloat(r116, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{0.0f, (r108[0] - r110[0]) + 2});
            ObjectAnimator r119 = ObjectAnimator.ofFloat(r116, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{0.0f, (r108[1] - r110[1]) + 4});
            om3.a r120 = new om3.a(0.42f, 0.0f, 0.58f, 1.0f);
            r119.setInterpolator(r120);
            r118.setInterpolator(r120);
            r118.setDuration(500);
            r119.setDuration(500);
            ObjectAnimator r121 = ObjectAnimator.ofFloat(r116, LiveDegradeFpsAnimator.SCALE_X, new float[]{1.0f, 0.5f});
            ObjectAnimator r122 = ObjectAnimator.ofFloat(r116, LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.0f, 0.5f});
            r121.setDuration(500);
            r122.setDuration(500);
            ObjectAnimator r123 = ObjectAnimator.ofFloat(r116, LiveDegradeFpsAnimator.SCALE_X, new float[]{0.5f, 0.0f});
            ObjectAnimator r124 = ObjectAnimator.ofFloat(r116, LiveDegradeFpsAnimator.SCALE_Y, new float[]{0.5f, 0.0f});
            r123.setDuration(200);
            r124.setDuration(200);
            r123.setStartDelay(750);
            r124.setStartDelay(750);
            r117.playTogether(new Animator[]{r118, r119, r121, r122, r123, r124});
            r115.f130006e = r117;
            AnimatorSet r125 = this.f130017a.f130006e;
            if (r125 == null) goto L28;
            r125.start();
        L28:
            PKBattlePropEffectWidget r126 = this.f130017a;
            Intrinsics.checkNotNullParameter(r103, "animationView");
            AnimatorSet r127 = new AnimatorSet();
            ObjectAnimator r128 = ObjectAnimator.ofFloat(r103, LiveDegradeFpsAnimator.SCALE_X, new float[]{0.4f, 1.04f, 1.0f});
            ObjectAnimator r129 = ObjectAnimator.ofFloat(r103, LiveDegradeFpsAnimator.SCALE_Y, new float[]{0.4f, 1.04f, 1.0f});
            r128.setDuration(250);
            r129.setDuration(250);
            r128.setStartDelay(950);
            r129.setStartDelay(950);
            ObjectAnimator r130 = ObjectAnimator.ofFloat(r103, LiveDegradeFpsAnimator.SCALE_X, new float[]{1.04f, 0.98f, 1.0f});
            ObjectAnimator r131 = ObjectAnimator.ofFloat(r103, LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.04f, 0.98f, 1.0f});
            r130.setDuration(150);
            r131.setDuration(150);
            r130.setStartDelay(AdQuickAppManager.DEFAULT_QUICK_APP_CHECK_TIME);
            r131.setStartDelay(AdQuickAppManager.DEFAULT_QUICK_APP_CHECK_TIME);
            ObjectAnimator r132 = ObjectAnimator.ofFloat(r103, LiveDegradeFpsAnimator.SCALE_X, new float[]{0.98f, 1.01f, 1.0f});
            ObjectAnimator r133 = ObjectAnimator.ofFloat(r103, LiveDegradeFpsAnimator.SCALE_Y, new float[]{0.98f, 1.01f, 1.0f});
            r132.setDuration(150);
            r133.setDuration(150);
            r132.setStartDelay(1350);
            r133.setStartDelay(1350);
            ObjectAnimator r134 = ObjectAnimator.ofFloat(r103, LiveDegradeFpsAnimator.SCALE_X, new float[]{1.01f, 1.0f, 1.0f});
            ObjectAnimator r135 = ObjectAnimator.ofFloat(r103, LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.01f, 1.0f, 1.0f});
            r134.setDuration(150);
            r135.setDuration(150);
            r134.setStartDelay(1500);
            r135.setStartDelay(1500);
            r127.playTogether(new Animator[]{r128, r130, r132, r134, r129, r131, r133, r135});
            r126.f130007f = r127;
            AnimatorSet r136 = this.f130017a.f130007f;
            if (r136 == null) goto L31;
            r136.start();
        L31:
            PKBattlePropEffectWidget r137 = this.f130017a;
            AnimatorSet r138 = r137.f130007f;
            if (r138 == null) goto L41;
            r138.addListener(r137.f130011j);
            return;
        L41:
            return;
        L34:
            if (r107 == null) goto L36;
            r107.setVisibility(8);
        L36:
            u02.a r139 = this.f130017a.f130004c;
            if (r139 == null) goto L43;
            r139.onEnd();
            return;
        L43:
            return;
        L40:
            return;
        L5:
            r100 = 0;
            goto L7
        }
    }

    static {
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_base_pk_battle_prop_effect_widget;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        this.f130004c = null;
    }

    public PKBattlePropEffectWidget() {
        this.f130011j = new c(this);
        this.f130012k = new d(this);
        this.f130013l = new b(this);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        GiftContext r101 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r101 == null) goto L7;
        n<PKBattlePropEffectWidget> r102 = r101.getPkBattlePropEffectWidget();
        if (r102 == null) goto L7;
        r102.setValue(this);
    L7:
        this.f130003b = (HSImageView) this.containerView.findViewById(R.id.drop_animation_view);
        this.f130009h = (HSImageView) this.containerView.findViewById(R.id.fly_icon);
    }
}
