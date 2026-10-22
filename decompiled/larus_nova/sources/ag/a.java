package ag;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.PointF;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.WindowManagerLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: ag.a$a, reason: collision with other inner class name */
    public static final class C0064a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WindowManager f3251a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f3252b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ WindowManager.LayoutParams f3253c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f3254d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Boolean f3255e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Context f3256f;

        public C0064a(WindowManager r100, View r101, WindowManager.LayoutParams r102, int r103, Boolean r104, Context r105) {
            this.f3251a = r100;
            this.f3252b = r101;
            this.f3253c = r102;
            this.f3254d = r103;
            this.f3255e = r104;
            this.f3256f = r105;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Object r101 = r100.getAnimatedValue();
            if ((r101 instanceof PointF) == true) goto L5;
            r101 = null;
        L5:
            PointF r102 = (PointF) r101;
            if (r102 != null) goto L18;
            r102 = new PointF();
        L18:
            WindowManager r103 = this.f3251a;     // Catch: IllegalArgumentException -> L17
            if (r103 == null) goto L20;
            View r104 = this.f3252b;     // Catch: IllegalArgumentException -> L17
            WindowManager.LayoutParams r105 = this.f3253c;     // Catch: IllegalArgumentException -> L17
            r105.x = ((int) r102.x) - this.f3254d;     // Catch: IllegalArgumentException -> L17
            if (Intrinsics.areEqual(this.f3255e, Boolean.TRUE) == false) goto L14;
            int r106 = ((int) r102.y) - eh.b.b(this.f3256f);     // Catch: IllegalArgumentException -> L17
            int r107 = this.f3254d;     // Catch: IllegalArgumentException -> L17
        L15:
            r105.y = r106 - r107;     // Catch: IllegalArgumentException -> L17
            Unit r108 = Unit.INSTANCE;     // Catch: IllegalArgumentException -> L17
            r103.updateViewLayout(r104, r105);     // Catch: IllegalArgumentException -> L17
            return;
        L14:
            r106 = (int) r102.y;     // Catch: IllegalArgumentException -> L17
            r107 = this.f3254d;     // Catch: IllegalArgumentException -> L17
            goto L15
        L20:
            return;
        }
    }

    public static final class b implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f3257a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0 f3258b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ WindowManager f3259c;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            Function0 r101 = this.f3258b;
            if (r101 == null) goto L14;
            Unit r102 = (Unit) r101.invoke();
        L14:
            Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L11
            WindowManager r104 = this.f3259c;     // Catch: Throwable -> L11
            if (r104 == null) goto L8;
            r104.removeView(this.f3257a);     // Catch: Throwable -> L11
            Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L11
        L9:
            Result.m9449constructorimpl(r105);     // Catch: Throwable -> L11
            return;
        L8:
            r105 = null;
        L11:
            th = move-exception;
            Result.Companion r106 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f3257a.setVisibility(8);
            Function0 r101 = this.f3258b;
            if (r101 == null) goto L14;
            Unit r102 = (Unit) r101.invoke();
        L14:
            Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L11
            WindowManager r104 = this.f3259c;     // Catch: Throwable -> L11
            if (r104 == null) goto L8;
            r104.removeView(this.f3257a);     // Catch: Throwable -> L11
            Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L11
        L9:
            Result.m9449constructorimpl(r105);     // Catch: Throwable -> L11
            return;
        L8:
            r105 = null;
        L11:
            th = move-exception;
            Result.Companion r106 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
        }

        public b(View r100, Function0 r101, WindowManager r102) {
            this.f3257a = r100;
            this.f3258b = r101;
            this.f3259c = r102;
        }
    }

    public static void b(View r210, View r211, long r212, View r213, Float r214, Float r215, Integer r216, AnimatorSet r310, Boolean r311, Function0 r312) {
        Intrinsics.checkNotNullParameter(r210, "sourceView");
        Intrinsics.checkNotNullParameter(r211, "destinationView");
        int[] r100 = new int[2];
        r210.getLocationOnScreen(r100);
        float r101 = r100[0] + (r210.getWidth() / 2);
        float r110 = r100[1] + (r210.getHeight() / 2);
        int[] r102 = new int[2];
        r211.getLocationOnScreen(r102);
        float r103 = r102[0] + (r211.getWidth() / 2);
        float r104 = r102[1] + (r211.getHeight() / 2);
        if (r214 == null) goto L6;
        if (r215 == null) goto L6;
        float r105 = r215.floatValue();
        r103 = r103 - r214.floatValue();
        r104 = r104 - r105;
    L6:
        Context r106 = r210.getContext();
        Context r107 = r211.getContext();
        c(r106, r107, r101, r110, r103, r104, r212, r213, r214, r215, r216, r310, r311, r312);
    }

    public static void a(Context r110, float[] r111, float[] r210, long r211, View r212, Float r213, Float r214, Integer r215, AnimatorSet r216, Boolean r217, Function0 r218) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "sourceLocation");
        Intrinsics.checkNotNullParameter(r210, "destinationLocation");
        if (r111.length == 2) goto L5;
    L13:
        dm.a.a("AddCartMotion").b("length of location array is not correct!", null);
        return;
    L5:
        if (r210.length != 2) goto L13;
        float r100 = r210[0];
        float r101 = r210[1];
        if (r213 == null) goto L11;
        if (r214 == null) goto L11;
        float r102 = r214.floatValue();
        r100 = r100 - r213.floatValue();
        r101 = r101 - r102;
    L11:
        float r103 = r101;
        float r104 = r111[0];
        float r105 = r111[1];
        c(r110, r110, r104, r105, r100, r103, r211, r212, r213, r214, r215, r216, r217, r218);
    }

    public static void c(Context r110, Context r111, float r112, float r210, float r211, float r212, long r213, View r214, Float r215, Float r216, Integer r217, AnimatorSet r218, Boolean r310, Function0 r311) {
        Object r100 = r111.getSystemService(LiveEndPageData.TAG_WINDOW);
        if ((r100 instanceof WindowManager) == true) goto L5;
        r100 = null;
    L5:
        WindowManager r101 = (WindowManager) r100;
        int r102 = vf4.a.a(r110, 5.0f);
        WindowManager.LayoutParams r103 = new WindowManager.LayoutParams();
        float r113 = 10.0f;
        if (r215 == null) goto L8;
        float r114 = r215.floatValue();
    L9:
        r103.width = vf4.a.a(r110, r114);
        if (r216 == null) goto L12;
        r113 = r216.floatValue();
    L12:
        r103.height = vf4.a.a(r110, r113);
        r103.x = ((int) r112) - r102;
        if (r217 != null) goto L15;
        int r115 = ((int) r210) - eh.b.b(r110);
    L16:
        r103.y = r115 - r102;
        r103.flags = 664;
        r103.format = -3;
        r103.gravity = 8388659;
        if (r217 == null) goto L19;
        int r116 = r217.intValue();
    L20:
        r103.type = r116;
        if (r214 != null) goto L23;
        View r104 = th.a.d(r111, R.layout.shopping_view_add_cart_motion, null, 4);
    L24:
        if (r101 == null) goto L27;
        WindowManagerLancet.bindToAssistantWindowIfNeeded(r104, r103);
        r101.addView(r104, r103);
    L27:
        if (r212 >= r210) goto L29;
        TypeEvaluator r105 = new c(new PointF((r112 + r211) / 2, (float) (((double) r212) - (((double) (r210 - r212)) * 0.3d))));
    L30:
        ValueAnimator r117 = ValueAnimator.ofObject(r105, new Object[]{new PointF(r112, r210), new PointF(r211, r212)});
        r117.addUpdateListener(new C0064a(r101, r104, r103, r102, r310, r110));
        ObjectAnimator r106 = ObjectAnimator.ofFloat(r104, LiveDegradeFpsAnimator.SCALE_X, new float[]{1.0f, 0.3f});
        ObjectAnimator r107 = ObjectAnimator.ofFloat(r104, LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.0f, 0.3f});
        AnimatorSet r108 = new AnimatorSet();
        r108.setDuration(600);
        r108.setInterpolator(new DecelerateInterpolator());
        r108.setStartDelay(r213);
        r108.addListener(new b(r104, r311, r101));
        if (r218 == null) goto L33;
        r108.playTogether(new Animator[]{r218});
    L33:
        r108.playTogether(new Animator[]{r117, r106, r107});
        r108.start();
        return;
    L29:
        r105 = new ag.b();
        goto L30
    L23:
        r104 = r214;
        goto L24
    L19:
        r116 = 99;
        goto L20
    L15:
        r115 = (int) r210;
        goto L16
    L8:
        r114 = 10.0f;
        goto L9
    }
}
