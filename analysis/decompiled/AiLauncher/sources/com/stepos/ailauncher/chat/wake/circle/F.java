package com.stepos.ailauncher.chat.wake.circle;

import A1.g;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import coil.a;
import coil.c;
import coil.decode.i;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieListener;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.R$drawable;
import com.stepos.ailauncher.chat.R$raw;
import com.stepos.ailauncher.chat.R$string;
import kotlin.C4848b;
import kotlin.Metadata;
import o6.C5009a;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 32\u00020\u0001:\u00014B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\b¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001a\u0010\u0015J\u0017\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001f\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010 R\u0018\u0010!\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010#\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010\"R\u0018\u0010$\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010'\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u001b\u0010.\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0011\u00102\u001a\u00020/8F¢\u0006\u0006\u001a\u0004\b0\u00101¨\u00065"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/circle/F;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/view/ViewGroup;", "parent", "LY8/t;", "p", "(Landroid/view/ViewGroup;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()V", "o", "", "density", "Lcom/airbnb/lottie/LottieAnimationView;", "f", "(F)Lcom/airbnb/lottie/LottieAnimationView;", "gesture", "l", "(Lcom/airbnb/lottie/LottieAnimationView;)V", "", "error", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/Throwable;)V", "n", "Landroid/view/View;", "bubble", "e", "(Landroid/view/View;)V", "m", "Landroid/content/Context;", "guideView", "Landroid/view/View;", "bubbleView", "gestureView", "Lcom/airbnb/lottie/LottieAnimationView;", "Ly7/E;", "bubbleGlassHandle", "Ly7/E;", "Lcoil/c;", "svgImageLoader$delegate", "LY8/h;", "k", "()Lcoil/c;", "svgImageLoader", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Z", "shouldShowGuide", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class F {
    private static final int BUBBLE_CORNER_RADIUS_DP = 24;
    private static final int BUBBLE_HEIGHT_DP = 48;
    private static final int BUBBLE_PADDING_H_DP = 16;
    private static final long ENTER_DURATION_MS = 300;
    private static final long EXIT_DURATION_MS = 300;
    public static final int GESTURE_HEIGHT_DP = 150;
    private static final int GESTURE_TOP_MARGIN_DP = 8;
    public static final int GESTURE_WIDTH_DP = 190;
    private static final int HAND_SIZE_DP = 56;
    private static final int HAND_TOP_MARGIN_DP = 11;
    public static final int INTRO_END_FRAME = 40;
    public static final int INTRO_START_FRAME = 0;
    private static final String KEY_GUIDE_SHOWN = "circle_select_guide_shown";
    public static final int LOOP_END_FRAME = 160;
    public static final int LOOP_START_FRAME = 40;
    private static final String TAG = "CircleSelectGuide";
    private static final int TEXT_COLOR = -419430401;
    private static final float TEXT_SIZE_SP = 14.0f;
    private static final int TEXT_WEIGHT = 500;
    private static final int TOP_MARGIN_DP = 205;
    private y7.E bubbleGlassHandle;
    private View bubbleView;
    private final Context context;
    private LottieAnimationView gestureView;
    private View guideView;

    /* renamed from: svgImageLoader$delegate, reason: from kotlin metadata */
    private final Y8.h svgImageLoader;
    private static final PathInterpolator EXIT_INTERPOLATOR = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/chat/wake/circle/F$b", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "LY8/t;", "onAnimationEnd", "(Landroid/animation/Animator;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends AnimatorListenerAdapter {
        final /* synthetic */ LottieAnimationView $gesture;
        final /* synthetic */ View $view;
        final /* synthetic */ F this$0;

        public b(LottieAnimationView lottieAnimationView, View view, F f10) {
            this.$gesture = lottieAnimationView;
            this.$view = view;
            this.this$0 = f10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            kotlin.jvm.internal.p.i(animation, "animation");
            LottieAnimationView lottieAnimationView = this.$gesture;
            if (lottieAnimationView != null) {
                this.this$0.n(lottieAnimationView);
            }
            ViewParent parent = this.$view.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(this.$view);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/stepos/ailauncher/chat/wake/circle/F$c", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "LY8/t;", "onAnimationCancel", "(Landroid/animation/Animator;)V", "onAnimationEnd", "", "cancelled", "Z", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c extends AnimatorListenerAdapter {
        final /* synthetic */ LottieAnimationView $gesture;
        private boolean cancelled;

        public c(LottieAnimationView lottieAnimationView) {
            this.$gesture = lottieAnimationView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            kotlin.jvm.internal.p.i(animation, "animation");
            this.cancelled = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            kotlin.jvm.internal.p.i(animation, "animation");
            if (this.cancelled) {
                return;
            }
            this.$gesture.removeAllAnimatorListeners();
            this.$gesture.setMinAndMaxFrame(40, F.LOOP_END_FRAME);
            this.$gesture.setRepeatCount(-1);
            this.$gesture.playAnimation();
        }
    }

    public F(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        this.context = context;
        this.svgImageLoader = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.wake.circle.C
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return F.r(this.f26704a);
            }
        });
    }

    public static final void g(F f10, Throwable th) {
        kotlin.jvm.internal.p.f(th);
        f10.i(th);
    }

    public static final void q(F f10, TextView textView) {
        f10.e(textView);
    }

    public static final coil.c r(F f10) {
        c.a aVarD = new c.a(f10.context).d(false);
        a.C0194a c0194a = new a.C0194a();
        c0194a.a(new i.b(false, 1, null));
        return aVarD.i(c0194a.e()).e();
    }

    public final void e(View bubble) {
        m();
        y7.E eU = y7.H.a(s7.p.f40121a, bubble).x(true).w(24 * this.context.getResources().getDisplayMetrics().density).i(y7.o.INSTANCE.h()).u();
        if (eU.c() <= 0) {
            eU = null;
        }
        this.bubbleGlassHandle = eU;
    }

    public final LottieAnimationView f(float density) {
        LottieAnimationView lottieAnimationView = new LottieAnimationView(this.context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) (GESTURE_WIDTH_DP * density), (int) (GESTURE_HEIGHT_DP * density));
        layoutParams.topMargin = (int) (8 * density);
        lottieAnimationView.setLayoutParams(layoutParams);
        lottieAnimationView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        lottieAnimationView.setIgnoreDisabledSystemAnimations(true);
        lottieAnimationView.setFailureListener(new LottieListener() { // from class: com.stepos.ailauncher.chat.wake.circle.E
            @Override // com.airbnb.lottie.LottieListener
            public final void onResult(Object obj) {
                F.g(this.f26707a, (Throwable) obj);
            }
        });
        lottieAnimationView.setAnimation(R$raw.lottie_circle_select_guide);
        return lottieAnimationView;
    }

    public final void h() {
        ViewPropertyAnimator viewPropertyAnimatorAnimate;
        View view = this.guideView;
        if (view == null) {
            return;
        }
        LottieAnimationView lottieAnimationView = this.gestureView;
        C5009a.y(C5009a.INSTANCE, KEY_GUIDE_SHOWN, true, false, 4, null);
        m();
        View view2 = this.bubbleView;
        if (view2 != null && (viewPropertyAnimatorAnimate = view2.animate()) != null) {
            viewPropertyAnimatorAnimate.cancel();
        }
        view.animate().alpha(0.0f).setDuration(300L).setInterpolator(EXIT_INTERPOLATOR).setListener(new b(lottieAnimationView, view, this)).start();
        this.guideView = null;
        this.bubbleView = null;
        this.gestureView = null;
    }

    public final void i(Throwable error) {
        LottieAnimationView lottieAnimationView;
        Log.e(TAG, "gesture lottie failed, falling back to static hand", error);
        View view = this.guideView;
        LinearLayout linearLayout = view instanceof LinearLayout ? (LinearLayout) view : null;
        if (linearLayout == null || (lottieAnimationView = this.gestureView) == null) {
            return;
        }
        n(lottieAnimationView);
        linearLayout.removeView(lottieAnimationView);
        this.gestureView = null;
        float f10 = this.context.getResources().getDisplayMetrics().density;
        ImageView imageView = new ImageView(this.context);
        int i10 = (int) (56 * f10);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i10, i10);
        layoutParams.topMargin = (int) (11 * f10);
        imageView.setLayoutParams(layoutParams);
        k().c(new g.a(imageView.getContext()).d(Integer.valueOf(R$raw.ic_circle_select_hand)).r(imageView).c());
        linearLayout.addView(imageView);
    }

    public final boolean j() {
        if (C5009a.b(C5009a.INSTANCE, KEY_GUIDE_SHOWN, false, 2, null)) {
            return !C5009a.g(r0, KEY_GUIDE_SHOWN, false, false, 6, null);
        }
        return true;
    }

    public final coil.c k() {
        return (coil.c) this.svgImageLoader.getValue();
    }

    public final void l(LottieAnimationView gesture) {
        gesture.setRepeatCount(0);
        gesture.setMinAndMaxFrame(0, 40);
        gesture.addAnimatorListener(new c(gesture));
        gesture.playAnimation();
    }

    public final void m() {
        y7.E e10 = this.bubbleGlassHandle;
        if (e10 != null) {
            e10.g();
        }
        this.bubbleGlassHandle = null;
    }

    public final void n(LottieAnimationView gesture) {
        gesture.removeAllAnimatorListeners();
        gesture.removeAllUpdateListeners();
        gesture.animate().cancel();
        gesture.cancelAnimation();
        gesture.setFailureListener(null);
        gesture.setImageDrawable(null);
    }

    public final void o() {
        ViewPropertyAnimator viewPropertyAnimatorAnimate;
        View view = this.guideView;
        if (view == null) {
            return;
        }
        m();
        View view2 = this.bubbleView;
        if (view2 != null && (viewPropertyAnimatorAnimate = view2.animate()) != null) {
            viewPropertyAnimatorAnimate.cancel();
        }
        LottieAnimationView lottieAnimationView = this.gestureView;
        if (lottieAnimationView != null) {
            n(lottieAnimationView);
        }
        view.animate().cancel();
        ViewParent parent = view.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        this.guideView = null;
        this.bubbleView = null;
        this.gestureView = null;
    }

    public final void p(ViewGroup parent) {
        kotlin.jvm.internal.p.i(parent, "parent");
        if (j()) {
            float f10 = this.context.getResources().getDisplayMetrics().density;
            LinearLayout linearLayout = new LinearLayout(this.context);
            linearLayout.setOrientation(1);
            linearLayout.setGravity(1);
            final TextView textView = new TextView(this.context);
            textView.setText(textView.getContext().getString(R$string.circle_select_guide_tip));
            textView.setTextColor(TEXT_COLOR);
            textView.setTextSize(2, 14.0f);
            textView.setTypeface(Typeface.create(Typeface.DEFAULT, 500, false));
            textView.setGravity(17);
            textView.setBackgroundResource(R$drawable.bg_circle_select_guide);
            int i10 = (int) (16 * f10);
            textView.setPadding(i10, 0, i10, 0);
            textView.setLayoutParams(new LinearLayout.LayoutParams(-2, (int) (48 * f10)));
            LottieAnimationView lottieAnimationViewF = f(f10);
            linearLayout.addView(textView);
            linearLayout.addView(lottieAnimationViewF);
            ConstraintLayout.b bVar = new ConstraintLayout.b(-2, -2);
            bVar.f12664t = 0;
            bVar.f12668v = 0;
            bVar.f12642i = 0;
            ((ViewGroup.MarginLayoutParams) bVar).topMargin = (int) (TOP_MARGIN_DP * f10);
            parent.addView(linearLayout, bVar);
            this.guideView = linearLayout;
            this.bubbleView = textView;
            this.gestureView = lottieAnimationViewF;
            textView.post(new Runnable() { // from class: com.stepos.ailauncher.chat.wake.circle.D
                @Override // java.lang.Runnable
                public final void run() {
                    F.q(this.f26705a, textView);
                }
            });
            textView.setAlpha(0.0f);
            textView.animate().alpha(1.0f).setDuration(300L).start();
            l(lottieAnimationViewF);
        }
    }
}
