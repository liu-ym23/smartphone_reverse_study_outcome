package com.bytedance.android.livesdk.gift.platform.business.normal.view.v2;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class p extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Disposable f130000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AnimatorSet f130001b;

    public static final class a extends o12.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p f130002a;

        public a(p r100) {
            this.f130002a = r100;
        }

        @Override // o12.b, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f130002a.b();
        }
    }

    public final void b() {
        ViewParent r100 = getParent();
        if ((r100 instanceof ViewGroup) == true) goto L5;
        r100 = null;
    L5:
        ViewGroup r101 = (ViewGroup) r100;
        if (r101 == null) goto L8;
        r101.removeView(this);
    L8:
        AnimatorSet r102 = this.f130001b;
        if (r102 != null) goto L11;
    L19:
        Disposable r103 = this.f130000a;
        if (r103 == null) goto L23;
        r103.dispose();
        return;
    L23:
        return;
    L11:
        if (r102.isRunning() != true) goto L19;
        AnimatorSet r104 = this.f130001b;
        if (r104 == null) goto L15;
        r104.removeAllListeners();
    L15:
        AnimatorSet r105 = this.f130001b;
        if (r105 == null) goto L18;
        r105.cancel();
    L18:
        this.f130001b = null;
        goto L19
    }

    public p(Context r100, py.k r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, null, 0);
        setBackgroundResource(R.drawable.ttlive_bg_tray_cjb);
        if (r101 == null) goto L6;
        this.f130000a = a1.k(r101).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new n(this, r101), o.f129999a);
    L6:
        if (r102 == false) goto L8;
        FrameLayout.LayoutParams r103 = new FrameLayout.LayoutParams(s1.f(138.0f), s1.f(36.0f));
        r103.gravity = 17;
        Unit r104 = Unit.INSTANCE;
    L9:
        setLayoutParams(r103);
        setAlpha(1.0f);
        return;
    L8:
        r103 = new FrameLayout.LayoutParams(s1.f(168.0f), s1.f(44.0f));
        r103.gravity = 17;
        Unit r105 = Unit.INSTANCE;
        goto L9
    }

    public final AnimatorSet a(float r100, float r101, long r102, long r103, long r110) {
        setX(r100);
        ObjectAnimator r104 = ObjectAnimator.ofFloat(this, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{r100, r101}).setDuration(r102);
        ObjectAnimator r105 = ObjectAnimator.ofFloat(this, "alpha", new float[]{1.0f, 0.0f}).setDuration(r103);
        AnimatorSet r106 = new AnimatorSet();
        this.f130001b = r106;
        r106.setInterpolator(new PathInterpolator(0.4f, 0.75f, 0.74f, 1.0f));
        AnimatorSet r107 = this.f130001b;
        if (r107 == null) goto L5;
        r107.play(r104);
    L5:
        AnimatorSet r108 = this.f130001b;
        if (r108 == null) goto L10;
        AnimatorSet.Builder r109 = r108.play(r105);
        if (r109 == null) goto L10;
        r109.after(r110);
    L10:
        AnimatorSet r111 = this.f130001b;
        if (r111 == null) goto L14;
        r111.addListener(new a(this));
    L14:
        return this.f130001b;
    }
}
