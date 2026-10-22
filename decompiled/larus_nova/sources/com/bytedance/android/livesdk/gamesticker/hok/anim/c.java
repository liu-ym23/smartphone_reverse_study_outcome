package com.bytedance.android.livesdk.gamesticker.hok.anim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.gamesticker.hok.HokGameRoleView;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public abstract class c extends com.bytedance.android.livesdk.gamesticker.hok.anim.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AnimatorSet f125579d;

    public static final class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f125580a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0 f125581b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f125581b.invoke();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f125580a.invoke();
        }

        public a(Function0 r100, Function0 r101) {
            this.f125580a = r100;
            this.f125581b = r101;
        }
    }

    @Override // com.bytedance.android.livesdk.gamesticker.hok.anim.a
    public final void a() {
        AnimatorSet r100 = this.f125579d;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.f125579d = null;
    }

    public c() {
    }

    public static HokGameRoleView f(g r100) {
        Intrinsics.checkNotNullParameter(r100, "viewGetter");
        if (r100.d().getVisibility() != 8) goto L7;
        return r100.d();
    L7:
        if (r100.a().getVisibility() != 8) goto L11;
        return r100.a();
    L11:
        return r100.d();
    }

    public static HokGameRoleView g(g r100) {
        Intrinsics.checkNotNullParameter(r100, "viewGetter");
        if (r100.d().getVisibility() != 0) goto L7;
        return r100.d();
    L7:
        if (r100.a().getVisibility() != 0) goto L11;
        return r100.a();
    L11:
        return r100.d();
    }

    public static boolean h(g r100) {
        Intrinsics.checkNotNullParameter(r100, "viewGetter");
        if (r100.d().getVisibility() != 0) goto L5;
    L8:
        return true;
    L5:
        if (r100.a().getVisibility() == 0) goto L8;
        return false;
    }

    public static boolean i(g r100) {
        Intrinsics.checkNotNullParameter(r100, "viewGetter");
        if (r100.b().getVisibility() != 0) goto L5;
    L10:
        return true;
    L5:
        if (r100.c().getVisibility() == 0) goto L10;
        if (r100.e().getVisibility() == 0) goto L10;
        return false;
    }

    public final ValueAnimator j(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        g r101 = this.f125577c;
        if (r101 == null) goto L5;
        float r102 = r101.getHeight();
    L7:
        return ObjectAnimator.ofFloat(r100, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{r102, 0.0f});
    L5:
        r102 = s1.f(28.0f);
        goto L7
    }

    public final ValueAnimator k(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        g r101 = this.f125577c;
        if (r101 == null) goto L5;
        float r102 = r101.getHeight();
    L7:
        return ObjectAnimator.ofFloat(r100, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{0.0f, -r102});
    L5:
        r102 = s1.f(28.0f);
        goto L7
    }

    public final void m(View r100, View r110, Function0<Unit> r111, Function0<Unit> r112) {
        Intrinsics.checkNotNullParameter(r100, "inView");
        Intrinsics.checkNotNullParameter(r110, "outView");
        Intrinsics.checkNotNullParameter(r111, WidgetCostModule.TYPE_ON_START);
        Intrinsics.checkNotNullParameter(r112, "onEnd");
        l(r100, r110, null, null, r111, r112);
    }

    public final void l(View r100, View r101, View r102, View r103, Function0<Unit> r104, Function0<Unit> r105) {
        Intrinsics.checkNotNullParameter(r100, "inView");
        Intrinsics.checkNotNullParameter(r101, "outView");
        Intrinsics.checkNotNullParameter(r104, WidgetCostModule.TYPE_ON_START);
        Intrinsics.checkNotNullParameter(r105, "onEnd");
        List r106 = CollectionsKt.mutableListOf(new ValueAnimator[]{j(r100), k(r101)});
        if (r102 == null) goto L6;
        if (r103 == null) goto L6;
        r106.add(j(r102));
        r106.add(k(r103));
        r100.toString();
        r101.toString();
        r102.toString();
        r103.toString();
    L6:
        AnimatorSet r107 = new AnimatorSet();
        this.f125579d = r107;
        r107.playTogether(CollectionsKt.toList(r106));
        AnimatorSet r108 = this.f125579d;
        if (r108 == null) goto L9;
        r108.setDuration(500);
    L9:
        AnimatorSet r109 = this.f125579d;
        if (r109 == null) goto L12;
        r109.addListener(new a(r104, r105));
    L12:
        AnimatorSet r110 = this.f125579d;
        if (r110 == null) goto L16;
        r110.start();
        return;
    }
}
