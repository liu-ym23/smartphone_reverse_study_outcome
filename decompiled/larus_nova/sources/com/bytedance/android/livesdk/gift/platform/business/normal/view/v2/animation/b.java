package com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage;
import com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.TrayContainerView;
import com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.TrayWaveControllerView;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f129920i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f129921j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f129922k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f129923l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AnimatedDrawable2 f129924a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AnimatorSet f129925b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HSImageView f129926c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ViewGroup f129927d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TrayWaveControllerView f129928e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final q02.d f129929f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f129930g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final NormalGiftMessage f129931h;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.animation.b$b, reason: collision with other inner class name */
    public static final class C2074b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f129932a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Pair f129933b;

        public C2074b(b r100, Pair r101) {
            this.f129932a = r100;
            this.f129933b = r101;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            Object r101 = r100.getAnimatedValue();
            ViewGroup r102 = null;
            if ((r101 instanceof Integer) == true) goto L5;
            r101 = null;
        L5:
            Integer r103 = (Integer) r101;
            if (r103 == null) goto L19;
            int r104 = r103.intValue();
            ViewGroup r105 = this.f129932a.f129927d;
            if ((r105 instanceof TrayContainerView) == false) goto L11;
            r102 = r105;
        L11:
            TrayContainerView r106 = (TrayContainerView) r102;
            if (r106 == null) goto L20;
            float r107 = r104;
            if (((Number) this.f129933b.getSecond()).intValue() <= r107) goto L16;
            boolean r108 = true;
        L17:
            boolean r109 = this.f129932a.f129930g;
            r106.f129893b = r107;
            r106.f129892a = r108;
            r106.f129894c = r109;
            r106.invalidate();
            return;
        L16:
            r108 = false;
            goto L17
        L20:
            return;
        }
    }

    public static final class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f129934a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f129935b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            q02.d r101 = this.f129934a.f129929f;
            if (r101 == null) goto L6;
            r101.a();
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            if (this.f129935b == true) goto L8;
            q02.d r101 = this.f129934a.f129929f;
            if (r101 == null) goto L9;
            r101.d();
            return;
        L9:
            return;
        }

        public c(b r100, boolean r101) {
            this.f129934a = r100;
            this.f129935b = r101;
        }
    }

    static {
        f129920i = s1.f(65.0f);
        f129921j = s1.f(168.0f);
        f129922k = s1.f(53.0f);
        f129923l = s1.f(138.0f);
    }

    public final void b() {
        AnimatedDrawable2 r100 = this.f129924a;
        if (r100 == null) goto L5;
        r100.stop();
    L5:
        this.f129924a = null;
        TrayWaveControllerView r101 = this.f129928e;
        if (r101 == null) goto L8;
        r101.a();
    L8:
        AnimatorSet r102 = this.f129925b;
        if (r102 != null) goto L11;
        return;
    L11:
        if (r102.isRunning() != true) goto L21;
        AnimatorSet r103 = this.f129925b;
        if (r103 == null) goto L15;
        r103.removeAllListeners();
    L15:
        AnimatorSet r104 = this.f129925b;
        if (r104 == null) goto L18;
        r104.cancel();
    L18:
        this.f129925b = null;
        return;
    }

    public final void a(boolean r110) {
        ViewGroup r100 = this.f129927d;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.setVisibility(0);
        ObjectAnimator r101 = ObjectAnimator.ofFloat(this.f129927d, "alpha", new float[]{0.0f, 1.0f}).setDuration(150);
        if (this.f129930g == false) goto L8;
        Pair r102 = new Pair(Integer.valueOf(f129922k), Integer.valueOf(f129923l));
    L9:
        ValueAnimator r103 = ValueAnimator.ofInt(new int[]{((Number) r102.getFirst()).intValue(), ((Number) r102.getSecond()).intValue()});
        if (r103 == null) goto L12;
        r103.addUpdateListener(new C2074b(this, r102));
        r103.addListener(new c(this, r110));
        r103.setDuration(850);
        r103.setInterpolator(new PathInterpolator(0.17f, 0.17f, 0.4f, 1.0f));
    L13:
        AnimatorSet r111 = new AnimatorSet();
        this.f129925b = r111;
        r111.playTogether(new Animator[]{r103, r101});
        AnimatorSet r112 = this.f129925b;
        if (r112 == null) goto L17;
        r112.start();
        return;
    L17:
        return;
    L12:
        r103 = null;
        goto L13
    L8:
        r102 = new Pair(Integer.valueOf(f129920i), Integer.valueOf(f129921j));
        goto L9
    }

    public b(HSImageView r100, ViewGroup r101, TrayWaveControllerView r102, q02.d r103, boolean r104, NormalGiftMessage r105) {
        this.f129926c = r100;
        this.f129927d = r101;
        this.f129928e = r102;
        this.f129929f = r103;
        this.f129930g = r104;
        this.f129931h = r105;
    }
}
