package com.bytedance.android.shopping.anchorv4.containers;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.shopping.utils.c0;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes12.dex */
public final class l implements c0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f166221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Activity f166222b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Rect f166223c;

    public static final class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f166224a;

        public a(l r100) {
            this.f166224a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f166224a.f166222b.finish();
            this.f166224a.f166222b.overridePendingTransition(0, R.anim.ec_commerce_activity_no_anim);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f166224a.f166222b.finish();
            this.f166224a.f166222b.overridePendingTransition(0, R.anim.ec_commerce_activity_no_anim);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v9, types: [T, android.view.View, com.bytedance.android.shopping.anchorv4.containers.c] */
    @Override // com.bytedance.android.shopping.utils.c0.a
    public final void onPageTranslucent() {
        k r100 = this.f166221a;
        Rect r101 = this.f166223c;
        Activity r102 = this.f166222b;
        a r103 = new a(this);
        r100.getClass();
        View r104 = r102.getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L8;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r105 = ThreadMethodProxy.currentThread();
        if (r105 == com.larus.home.impl.utils.c.f346341a) goto L8;
        com.larus.home.impl.utils.c.a(r105, "getDecorView");
    L8:
        if ((r104 instanceof ViewGroup) == true) goto L10;
        r104 = null;
    L10:
        ViewGroup r106 = (ViewGroup) r104;
        if (r106 != 0) goto L13;
        r102.finish();
        return;
    L13:
        r106.setBackgroundColor(0);
        Ref.ObjectRef r107 = new Ref.ObjectRef();
        r107.element = null;
        if (ECSettingKeys.M() == false) goto L16;
        ?? r108 = new c(r102);
        r107.element = r108;
        r106.addView(r108, 0, new ViewGroup.LayoutParams(-1, -1));
    L16:
        View r109 = r102.findViewById(android.R.id.content);
        Rect r110 = k.a(r109);
        float r111 = r101.width() / Math.max(r110.width(), 1);
        float r112 = r101.height() / Math.max(r110.height(), 1);
        float r113 = r101.left - r110.left;
        float r114 = r101.top - r110.top;
        r109.setPivotX(0.0f);
        r109.setPivotY(0.0f);
        ViewPropertyAnimator r115 = r109.animate();
        if (r115 == null) goto L37;
        ViewPropertyAnimator r116 = r115.alpha(0.0f);
        if (r116 == null) goto L37;
        ViewPropertyAnimator r117 = r116.translationX(r113);
        if (r117 == null) goto L37;
        ViewPropertyAnimator r118 = r117.translationY(r114);
        if (r118 == null) goto L37;
        ViewPropertyAnimator r119 = r118.scaleX(r111);
        if (r119 == null) goto L37;
        ViewPropertyAnimator r120 = r119.scaleY(r112);
        if (r120 == null) goto L37;
        ViewPropertyAnimator r121 = r120.setInterpolator(new cr3.a(0.0f, 0.45f, 0.25f));
        if (r121 == null) goto L37;
        float r122 = r113;
        ViewPropertyAnimator r123 = r121.setDuration(230);
        if (r123 == null) goto L38;
        ViewPropertyAnimator r124 = r123.setUpdateListener(new m(r107));
        if (r124 == null) goto L38;
        ViewPropertyAnimator r125 = r124.setListener(r103);
        if (r125 == null) goto L38;
        r125.start();
    L38:
        WeakReference<View> r126 = r100.f166218a;
        if (r126 == null) goto L41;
        View r127 = r126.get();
    L42:
        View r128 = r127;
        int r129 = 0;
    L43:
        if (r128 == null) goto L53;
        if (r129 >= 5) goto L53;
        if ((r128 instanceof com.bytedance.android.ec.hybrid.ui.i) == true) goto L54;
        Object r130 = r128.getParent();
        if ((r130 instanceof View) == true) goto L52;
        r130 = null;
    L52:
        r128 = (View) r130;
        r129 = r129 + 1;
    L54:
        if (r127 == null) goto L104;
        if (r128 == null) goto L105;
        Result.Companion r131 = Result.Companion;     // Catch: Throwable -> L91
        ImageView r132 = new ImageView(r102);     // Catch: Throwable -> L91
        Bitmap r133 = Bitmap.createBitmap(r127.getWidth(), r127.getHeight(), Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L91
        r128.draw(new Canvas(r133));     // Catch: Throwable -> L91
        r132.setImageBitmap(r133);     // Catch: Throwable -> L91
        r100.f166219b = r132;     // Catch: Throwable -> L91
        int r134 = r106.getChildCount();     // Catch: Throwable -> L91
        int r135 = 0;
    L57:
        if (r135 >= r134) goto L62;
        if ((r106.getChildAt(r135) instanceof c) == true) goto L60;
        r135 = r135 + 1;     // Catch: Throwable -> L91
        goto L57
    L60:
        int r136 = r135 + 1;     // Catch: Throwable -> L91
    L63:
        r106.addView(r132, r136, new ViewGroup.LayoutParams(r127.getWidth(), r127.getHeight()));     // Catch: Throwable -> L91
        float r137 = 0;
        if (r111 <= r137) goto L66;
        int r138 = 1;
        float r139 = 1 / r111;     // Catch: Throwable -> L91
    L68:
        if (r112 <= r137) goto L70;
        float r140 = r138 / r112;     // Catch: Throwable -> L91
    L71:
        r132.setPivotX(0.0f);     // Catch: Throwable -> L91
        r132.setPivotY(0.0f);     // Catch: Throwable -> L91
        r132.setTranslationX(0.0f);     // Catch: Throwable -> L91
        r132.setTranslationY(0.0f);     // Catch: Throwable -> L91
        r132.setScaleX(r139);     // Catch: Throwable -> L91
        r132.setScaleY(r140);     // Catch: Throwable -> L91
        r132.setAlpha(0.0f);     // Catch: Throwable -> L91
        ViewPropertyAnimator r141 = r132.animate();     // Catch: Throwable -> L91
        if (r141 == null) goto L88;
        ViewPropertyAnimator r142 = r141.alpha(1.0f);     // Catch: Throwable -> L91
        if (r142 == null) goto L88;
        ViewPropertyAnimator r143 = r142.translationX(r122);     // Catch: Throwable -> L91
        if (r143 == null) goto L88;
        ViewPropertyAnimator r144 = r143.translationY(r114);     // Catch: Throwable -> L91
        if (r144 == null) goto L88;
        ViewPropertyAnimator r145 = r144.scaleX(1.0f);     // Catch: Throwable -> L91
        if (r145 == null) goto L88;
        ViewPropertyAnimator r146 = r145.scaleY(1.0f);     // Catch: Throwable -> L91
        if (r146 == null) goto L88;
        ViewPropertyAnimator r147 = r146.setInterpolator(new cr3.a(0.0f, 0.45f, 0.25f));     // Catch: Throwable -> L91
        if (r147 == null) goto L88;
        ViewPropertyAnimator r148 = r147.setDuration(230);     // Catch: Throwable -> L91
        if (r148 == null) goto L88;
        r148.start();     // Catch: Throwable -> L91
        Unit r149 = Unit.INSTANCE;     // Catch: Throwable -> L91
    L89:
        Result.m9449constructorimpl(r149);     // Catch: Throwable -> L91
        return;
    L88:
        r149 = null;
        goto L89
    L70:
        r140 = 1.0f;
        goto L71
    L66:
        r138 = 1;
        r139 = 1.0f;
        goto L68
    L62:
        r136 = 0;
    L91:
        th = move-exception;
        Result.Companion r150 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    L105:
        return;
    L104:
        return;
    L53:
        r128 = r127;
        goto L54
    L41:
        r127 = null;
    L37:
        r122 = r113;
        goto L38
    }

    @Override // com.bytedance.android.shopping.utils.c0.a
    public final void onPageTranslucentError() {
        this.f166222b.finish();
    }

    public l(k r100, Activity r101, Rect r102) {
        this.f166221a = r100;
        this.f166222b = r101;
        this.f166223c = r102;
    }
}
