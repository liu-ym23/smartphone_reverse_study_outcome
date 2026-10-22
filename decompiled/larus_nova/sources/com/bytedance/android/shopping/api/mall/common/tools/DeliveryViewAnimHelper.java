package com.bytedance.android.shopping.api.mall.common.tools;

import android.R;
import android.animation.Animator;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.PixelCopy;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.ImageView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.ec.hybrid.list.view.MallLynxTaskBanner;
import com.bytedance.android.ec.hybrid.tools.UIToolsKt;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes13.dex */
public final class DeliveryViewAnimHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Uri f170384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f170385b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f170386c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f170387d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f170388e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Bitmap f170389f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Bitmap f170390g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f170391h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static String f170392i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static String f170393j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static int f170394k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final long f170395l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Lazy f170396m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final DeliveryViewAnimHelper f170397n = null;

    public static final class a implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f170398a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f170399b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f170400c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f170401d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f170402e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ ImageView f170403f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ ImageView f170404g;

        /* JADX INFO: renamed from: com.bytedance.android.shopping.api.mall.common.tools.DeliveryViewAnimHelper$a$a, reason: collision with other inner class name */
        public static final class C2561a implements Animator.AnimatorListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f170405a;

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationRepeat(Animator r100) {
                Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            }

            public C2561a(a r100) {
                this.f170405a = r100;
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator r100) {
                Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
                ImageView r101 = this.f170405a.f170403f;
                if (r101 == null) goto L6;
                UIToolsKt.b(r101);
                return;
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator r100) {
                Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
                ImageView r101 = this.f170405a.f170403f;
                if (r101 == null) goto L6;
                UIToolsKt.b(r101);
                return;
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator r100) {
                Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
                ImageView r101 = this.f170405a.f170403f;
                if (r101 == null) goto L6;
                Intrinsics.checkNotNullParameter(r101, "$this$inVisible");
                r101.setVisibility(4);
                return;
            }
        }

        public static final class b implements Animator.AnimatorListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f170406a;

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationRepeat(Animator r100) {
                Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator r100) {
                Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            }

            public b(a r100) {
                this.f170406a = r100;
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator r100) {
                Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
                ImageView r101 = this.f170406a.f170404g;
                if (r101 == null) goto L6;
                UIToolsKt.b(r101);
                return;
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator r100) {
                Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
                ImageView r101 = this.f170406a.f170404g;
                if (r101 == null) goto L6;
                UIToolsKt.b(r101);
                return;
            }
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            ViewTreeObserver r100 = this.f170398a.getViewTreeObserver();
            if (r100 == null) goto L5;
            r100.removeOnPreDrawListener(this);
        L5:
            int[] r101 = new int[2];
            this.f170398a.getLocationOnScreen(r101);
            float r102 = RangesKt.coerceAtMost(this.f170399b / RangesKt.coerceAtLeast(this.f170398a.getMeasuredWidth(), 1), 0.5f);
            float r103 = RangesKt.coerceAtMost(this.f170400c / RangesKt.coerceAtLeast(this.f170398a.getMeasuredHeight(), 1), 0.5f);
            float r104 = this.f170401d - r101[0];
            float r105 = this.f170402e - r101[1];
            View r106 = this.f170398a;
            r106.setPivotX(0.0f);
            r106.setPivotY(0.0f);
            r106.setScaleX(r102);
            r106.setScaleY(r103);
            r106.setTranslationX(r104);
            r106.setTranslationY(r105);
            r106.setAlpha(0.0f);
            ImageView r107 = this.f170403f;
            if (r107 == null) goto L24;
            ViewPropertyAnimator r108 = r107.animate();
            if (r108 == null) goto L24;
            ViewPropertyAnimator r109 = r108.alpha(0.0f);
            if (r109 == null) goto L24;
            ViewPropertyAnimator r110 = r109.translationX(0.0f);
            if (r110 == null) goto L24;
            ViewPropertyAnimator r111 = r110.translationY(0.0f);
            if (r111 == null) goto L24;
            ViewPropertyAnimator r112 = r111.scaleX(1.0f);
            if (r112 == null) goto L24;
            ViewPropertyAnimator r113 = r112.scaleY(1.0f);
            if (r113 == null) goto L24;
            Uri r114 = DeliveryViewAnimHelper.f170384a;
            ViewPropertyAnimator r115 = r113.setDuration(DeliveryViewAnimHelper.f170395l);
            if (r115 == null) goto L24;
            ViewPropertyAnimator r116 = r115.setListener(new C2561a(this));
            if (r116 == null) goto L24;
            r116.start();
        L24:
            View r117 = this.f170398a;
            if (r117 == null) goto L43;
            ViewPropertyAnimator r118 = r117.animate();
            if (r118 == null) goto L43;
            ViewPropertyAnimator r119 = r118.alpha(1.0f);
            if (r119 == null) goto L43;
            ViewPropertyAnimator r120 = r119.translationX(0.0f);
            if (r120 == null) goto L43;
            ViewPropertyAnimator r121 = r120.translationY(0.0f);
            if (r121 == null) goto L43;
            ViewPropertyAnimator r122 = r121.scaleX(1.0f);
            if (r122 == null) goto L43;
            ViewPropertyAnimator r123 = r122.scaleY(1.0f);
            if (r123 == null) goto L43;
            Uri r124 = DeliveryViewAnimHelper.f170384a;
            ViewPropertyAnimator r125 = r123.setDuration(DeliveryViewAnimHelper.f170395l);
            if (r125 == null) goto L43;
            ViewPropertyAnimator r126 = r125.setListener(new b(this));
            if (r126 == null) goto L43;
            r126.start();
        L43:
            return true;
        }

        public a(View r100, int r101, int r102, int r103, int r104, ImageView r105, ImageView r106) {
            this.f170398a = r100;
            this.f170399b = r101;
            this.f170400c = r102;
            this.f170401d = r103;
            this.f170402e = r104;
            this.f170403f = r105;
            this.f170404g = r106;
        }
    }

    public DeliveryViewAnimHelper() {
    }

    public static void b() {
        f170385b = 0;
        f170386c = 0;
        f170387d = 0;
        f170388e = 0;
        f170391h = "";
        f170392i = "";
        f170393j = "";
        f170394k = -1;
        f170384a = null;
        f170389f = null;
        f170390g = null;
    }

    static {
        f170397n = new DeliveryViewAnimHelper();
        f170391h = "";
        f170392i = "";
        f170393j = "";
        f170394k = -1;
        f170395l = 250;
        f170396m = LazyKt.lazy(DeliveryViewAnimHelper$deliveryService$2.INSTANCE);
    }

    public static View a(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static Uri d(Uri r100, View r110) {
        if (r110 == null) goto L20;
        int r101 = View.generateViewId();
        Uri.Builder r102 = r100.buildUpon();
        r110.setId(r101);
        DeliveryViewAnimHelper r103 = f170397n;
        r103.getClass();
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L12
        if (Build.VERSION.SDK_INT < 26) goto L10;
        Rect r105 = new Rect();     // Catch: Throwable -> L12
        boolean r106 = r110.getGlobalVisibleRect(r105);     // Catch: Throwable -> L12
        Activity r107 = MallLynxTaskBanner.f47420b.getActivity(r110.getContext());     // Catch: Throwable -> L12
        if (r106 == false) goto L10;
        if (r107 == null) goto L10;
        Bitmap r108 = Bitmap.createBitmap(a(r107.getWindow()).getWidth(), a(r107.getWindow()).getHeight(), Bitmap.Config.RGB_565);     // Catch: Throwable -> L12
        PixelCopy.request(r107.getWindow(), r108, new f(r103, r108), new Handler(Looper.getMainLooper()));     // Catch: Throwable -> L12
        Bitmap r109 = Bitmap.createBitmap(r105.width(), r105.height(), Bitmap.Config.RGB_565);     // Catch: Throwable -> L12
        PixelCopy.request(r107.getWindow(), r105, r109, new g(r103, r109), new Handler(Looper.getMainLooper()));     // Catch: Throwable -> L12
    L10:
        Object r111 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        Throwable r112 = Result.m9452exceptionOrNullimpl(r111);
        if (r112 == null) goto L17;
        EnsureManager.ensureNotReachHere(r112);
    L17:
        r102.appendQueryParameter("share_element_view_id", String.valueOf(r101));
        r100 = r102.build();
        f170397n.getClass();
        Rect r113 = new Rect();
        if (r110.getGlobalVisibleRect(r113) == false) goto L20;
        f170385b = r113.left;
        f170386c = r113.top;
        f170387d = r113.width();
        f170388e = r113.height();
    L12:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L20:
        return r100;
    }

    public static void c(Activity r110, ImageView r111, ImageView r112, int r113, int r114, int r115, int r116, boolean r117) {
        Intrinsics.checkNotNullParameter(r110, "deliveryActivity");
        if (f170389f != null) goto L5;
    L15:
        boolean r100 = false;
    L16:
        if (r100 == true) goto L18;
        return;
    L18:
        View r101 = a(r110.getWindow());
        View r102 = r110.findViewById(R.id.content);
        r110.overridePendingTransition(0, 0);
        if (r117 == false) goto L21;
        r102.setBackgroundColor(-1);
    L21:
        int[] r103 = new int[2];
        if (r112 == null) goto L24;
        r112.getLocationOnScreen(r103);
        r112.setPivotX(0.0f);
        r112.setPivotY(0.0f);
        r112.setTranslationX(r113 - r103[0]);
        r112.setTranslationY(r114 - r103[1]);
        r112.setAlpha(1.0f);
        b0.e(r112);
    L24:
        boolean r104 = r101 instanceof ViewGroup;
        if (r104 == true) goto L27;
        View r105 = null;
    L28:
        ViewGroup r106 = (ViewGroup) r105;
        if (r106 == null) goto L31;
        r106.addView(r111, 0);
    L31:
        if (r104 == true) goto L33;
        r101 = null;
    L33:
        ViewGroup r107 = (ViewGroup) r101;
        if (r107 == null) goto L36;
        r107.addView(r112, 1);
    L36:
        ViewTreeObserver r108 = r102.getViewTreeObserver();
        if (r108 == null) goto L40;
        r108.addOnPreDrawListener(new a(r102, r115, r116, r113, r114, r112, r111));
        return;
    L40:
        return;
    L27:
        r105 = r101;
        goto L28
    L5:
        if (f170390g == null) goto L15;
        if (f170385b <= 0) goto L15;
        if (f170386c <= 0) goto L15;
        if (f170387d <= 0) goto L15;
        if (f170388e <= 0) goto L15;
        r100 = true;
        goto L16
    }
}
