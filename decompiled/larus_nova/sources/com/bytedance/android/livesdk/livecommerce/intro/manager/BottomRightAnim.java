package com.bytedance.android.livesdk.livecommerce.intro.manager;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.LinearInterpolator;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.android.livesdk.livecommerce.room.widgets.anim.CartCardLinkedAnimController;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.utils.o0;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes10.dex */
public final class BottomRightAnim {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BottomRightAnim f148302a = null;

    public static final class a extends qh2.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Function0 f148303d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Function3 f148304e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Function0 f148305f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ View f148306g;

        @Override // qh2.a, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            super.onAnimationEnd(r100);
            this.f148303d.invoke();
        }

        public a(Function3 r100, Function0 r101, Function0 r102, Function3 r103, Function0 r104, View r105) {
            this.f148303d = r102;
            this.f148304e = r103;
            this.f148305f = r104;
            this.f148306g = r105;
            super(r100, r101, 2);
        }
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f148307a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function3 f148308b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function0 f148309c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ View f148310d;

        public b(Function0 r100, Function3 r101, Function0 r102, View r103) {
            this.f148307a = r100;
            this.f148308b = r101;
            this.f148309c = r102;
            this.f148310d = r103;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Object r101 = r100.getAnimatedValue();
            if ((r101 instanceof Float) == true) goto L5;
            r101 = null;
        L5:
            Float r102 = (Float) r101;
            if (r102 == null) goto L11;
            float r103 = r102.floatValue();
            Function3 r104 = this.f148308b;
            if (r104 == null) goto L12;
            Unit r105 = (Unit) r104.invoke(210, Integer.valueOf((int) (r103 * this.f148310d.getHeight())), Float.valueOf(1.0f - r100.getAnimatedFraction()));
            return;
        L12:
            return;
        }
    }

    public static final class c implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f148311a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f148312b;

        public c(View r100, Function1 r101) {
            this.f148311a = r100;
            this.f148312b = r101;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
            this.f148311a.removeOnLayoutChangeListener(this);
            Function1 r109 = this.f148312b;
            if (r100 == null) goto L5;
            int r110 = r100.getMeasuredHeight();
        L6:
            r109.invoke(Integer.valueOf(r110));
            return;
        L5:
            r110 = 0;
            goto L6
        }
    }

    public BottomRightAnim() {
    }

    static {
        f148302a = new BottomRightAnim();
    }

    public static void i(View r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Integer r102 = Integer.valueOf(r100.getMeasuredHeight());
        boolean r103 = false;
        if (r102.intValue() <= 0) goto L10;
        f148302a.getClass();
        int[] r104 = new int[2];
        r100.getLocationOnScreen(r104);
        if (r104[0] <= 0) goto L7;
        boolean r105 = true;
    L8:
        if (r105 == false) goto L10;
        r103 = true;
        goto L10
    L7:
        r105 = false;
    L10:
        if (r103 == true) goto L13;
        r102 = null;
    L13:
        if (r102 == null) goto L15;
        r101.invoke(Integer.valueOf(r102.intValue()));
        return;
    L15:
        r100.addOnLayoutChangeListener(new c(r100, r101));
        r100.requestLayout();
    }

    public static final float b(BottomRightAnim r100, RoomContextController r101, int r102) {
        r100.getClass();
        ECContext r103 = r101.r();
        if (r103 == null) goto L20;
        com.bytedance.live.datacontext.i<CartCardLinkedAnimController> r104 = r103.getLinkedAnimController();
        if (r104 == null) goto L20;
        CartCardLinkedAnimController r105 = r104.getValue();
        if (r105 == null) goto L20;
        yk2.c r106 = r105.f151982d;
        if (r106 == null) goto L20;
        View r107 = r106.getView();
        if (r107 == null) goto L20;
        Intrinsics.checkNotNullParameter(r107, "view");
        int[] r108 = new int[2];
        r107.getLocationOnScreen(r108);
        int r109 = 0;
        int r110 = r108[0];
        if (r110 <= 0) goto L16;
        r109 = r110;
    L16:
        if (r109 <= 0) goto L20;
        return (r109 - UtilityKotlinExtentionsKt.d(8)) + (r107.getWidth() / 2);
    L20:
        return r102;
    }

    public static void e(final View r110, Function3 r111, Function0 r112) {
        Intrinsics.checkNotNullParameter(r110, "view");
        Intrinsics.checkNotNullParameter(r112, "onAnimEnd");
        com.bytedance.android.livesdk.livecommerce.intro.utils.k.c("[anim] hideSwitchAnimation");
        Function0<Integer> r100 = new BottomRightAnim$hideSwitchAnimationV2$getViewHeight$1(r110);
        ViewPropertyAnimator r101 = r110.animate().alpha(0.0f).setDuration(167);
        f148302a.getClass();
        r101.setInterpolator(new LinearInterpolator()).setListener(new a(r111, r100, r112, r111, r100, r110)).setUpdateListener(new b(r112, r111, r100, r110)).start();
    }

    public static final float[] a(BottomRightAnim r100, RoomContextController r101, View r102, float[] r103) {
        r100.getClass();
        ECContext r104 = r101.r();
        if (r104 == null) goto L20;
        com.bytedance.live.datacontext.i<CartCardLinkedAnimController> r105 = r104.getLinkedAnimController();
        if (r105 == null) goto L21;
        CartCardLinkedAnimController r106 = r105.getValue();
        if (r106 == null) goto L22;
        yk2.c r107 = r106.f151982d;
        if (r107 == null) goto L23;
        View r108 = r107.getView();
        if (r108 == null) goto L26;
        int[] r109 = {0, 0};
        r108.getLocationOnScreen(r109);
        int r110 = r109[0];
        int r111 = r109[1];
        r102.getLocationOnScreen(r109);
        int r112 = r109[1];
        if (r110 <= 0) goto L24;
        if (r111 <= 0) goto L25;
        if (r112 > 0) goto L19;
        return r103;
    L19:
        return new float[]{((r110 - UtilityKotlinExtentionsKt.c(12)) - o0.a(r102)) + (r108.getWidth() / 2.0f), (r111 - r112) + UtilityKotlinExtentionsKt.c(5)};
    L25:
        return r103;
    L24:
        return r103;
    L26:
        return r103;
    L23:
        return r103;
    L22:
        return r103;
    L21:
        return r103;
    L20:
        return r103;
    }

    public static void c(final RoomContextController r100, final View r101, final Function3 r102, final Function0 r110) {
        Intrinsics.checkNotNullParameter(r100, "contextController");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r110, "onAnimEnd");
        com.bytedance.android.livesdk.livecommerce.intro.utils.k.c("[anim] hideLinkedAnimation");
        final Function0<Integer> r103 = new BottomRightAnim$hideLinkedAnimation$getViewHeight$1(r101);
        i(r101, new BottomRightAnim$hideLinkedAnimation$1(r101, r100, r110, r102, r103));
    }

    public static void d(final RoomContextController r100, final View r101, final Function3 r110, final Function0 r111) {
        Intrinsics.checkNotNullParameter(r100, "contextController");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r111, "onAnimEnd");
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_INTRO_CARD_ANIM_OPT().c() == false) goto L6;
        Intrinsics.checkNotNullParameter(r100, "contextController");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r111, "onAnimEnd");
        com.bytedance.android.livesdk.livecommerce.intro.utils.k.c("[anim] hideLinkedAnimationV3");
        final Function0<Integer> r102 = new BottomRightAnim$hideLinkedAnimationV3$getViewHeight$1(r101);
        i(r101, new BottomRightAnim$hideLinkedAnimationV3$1(r101, r111, r110, r102, r100));
        return;
    L6:
        com.bytedance.android.livesdk.livecommerce.intro.utils.k.c("[anim] hideLinkedAnimationV2");
        final Function0<Integer> r103 = new BottomRightAnim$hideLinkedAnimationV2$getViewHeight$1(r101);
        final Ref.BooleanRef r104 = new Ref.BooleanRef();
        r104.element = false;
        i(r101, new BottomRightAnim$hideLinkedAnimationV2$1(r101, r111, r110, r103, r104, r100));
    }

    public static void h(final RoomContextController r100, final View r101, final Function3 r110, final Function0 r111, final Function0 r112) {
        Intrinsics.checkNotNullParameter(r100, "contextController");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r111, "onAnimEnd");
        Intrinsics.checkNotNullParameter(r112, "onAnimStart");
        com.bytedance.android.livesdk.livecommerce.intro.utils.k.c("[anim] showSwitchAnimation");
        final Function0<Integer> r102 = new BottomRightAnim$showSwitchAnimationV2$getViewHeight$1(r101);
        i(r101, new BottomRightAnim$showSwitchAnimationV2$1(r101, r100, r112, r111, r110, r102));
    }

    public static void f(RoomContextController r100, View r101, boolean r110, Function3 r111, Function0 r112, Function0 r113) {
        Intrinsics.checkNotNullParameter(r100, "contextController");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r112, "onAnimEnd");
        Intrinsics.checkNotNullParameter(r113, "onAnimStart");
        int r102 = com.bytedance.android.livesdk.livecommerce.intro.utils.k.f148548a;
        com.bytedance.android.livesdk.livecommerce.intro.utils.k.c("[anim] showLinkedAnimation, ignoreLinkedAnim = " + r110);
        i(r101, new BottomRightAnim$showLinkedAnimation$1(r101, r112, r111, r100, r113, r110));
    }

    public final void g(RoomContextController r110, View r111, boolean r112, Function3<? super Integer, ? super Integer, ? super Float, Unit> r113, Function0<Unit> r114, Function0<Unit> r115) {
        Intrinsics.checkNotNullParameter(r110, "contextController");
        Intrinsics.checkNotNullParameter(r111, "view");
        Intrinsics.checkNotNullParameter(r114, "onAnimEnd");
        Intrinsics.checkNotNullParameter(r115, "onAnimStart");
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_INTRO_CARD_ANIM_OPT().c() == false) goto L6;
        Intrinsics.checkNotNullParameter(r110, "contextController");
        Intrinsics.checkNotNullParameter(r111, "view");
        Intrinsics.checkNotNullParameter(r114, "onAnimEnd");
        Intrinsics.checkNotNullParameter(r115, "onAnimStart");
        int r100 = com.bytedance.android.livesdk.livecommerce.intro.utils.k.f148548a;
        com.bytedance.android.livesdk.livecommerce.intro.utils.k.c("[anim] showLinkedAnimationV3, ignoreLinkedAnim = " + r112);
        i(r111, new BottomRightAnim$showLinkedAnimationV3$1(this, r111, r115, r113, r114, r110, r112));
        return;
    L6:
        int r101 = com.bytedance.android.livesdk.livecommerce.intro.utils.k.f148548a;
        com.bytedance.android.livesdk.livecommerce.intro.utils.k.c("[anim] showLinkedAnimationV2, ignoreLinkedAnim = " + r112);
        i(r111, new BottomRightAnim$showLinkedAnimationV2$1(this, r111, r115, r113, r114, r110, r112));
    }
}
