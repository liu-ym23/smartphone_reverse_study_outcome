package com.stepos.ailauncher.chat.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Outline;
import android.graphics.Paint;
import android.provider.Settings;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import androidx.dynamicanimation.animation.e;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ame.sdk.SkillStoreKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import p9.InterfaceC5063a;
import v9.C5685n;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0017\u0010\u0018J-\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00042\u000e\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u001a¢\u0006\u0004\b\u001e\u0010\u001fJ;\u0010!\u001a\u00020\u001d2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00042\u000e\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u001a2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000f0\u001a¢\u0006\u0004\b!\u0010\"Jw\u0010+\u001a\u00020\u001d2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00042\u000e\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u001a2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u00042\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u001aH\u0002¢\u0006\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020#8\u0002X\u0082T¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u0010/\u001a\u00020#8\u0002X\u0082T¢\u0006\u0006\n\u0004\b/\u0010.R\u0014\u00100\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b0\u00101R\u0014\u00102\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b2\u00101R\u0014\u00103\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b3\u00101R\u0014\u00104\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b4\u00101R\u0014\u00106\u001a\u0002058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0014\u00108\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b8\u00101R\u0014\u00109\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b9\u00101R\u0014\u0010:\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b:\u00101R\u0014\u0010;\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b;\u00101R\u0014\u0010<\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b<\u00101R\u0014\u0010>\u001a\u00020=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?¨\u0006@"}, d2 = {"Lcom/stepos/ailauncher/chat/view/L5;", "", "<init>", "()V", "", "dampingRatio", "u", "(F)F", "Landroid/view/View;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "Lcom/stepos/ailauncher/chat/view/U5;", "v", "(Landroid/view/View;)Lcom/stepos/ailauncher/chat/view/U5;", "pivotXPx", "pivotYPx", "LY8/t;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroid/view/View;FF)V", "", "anchorHeightPx", "gapPx", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Landroid/view/View;II)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Landroid/view/View;)V", "restCornerDp", "Lkotlin/Function0;", "Ly7/E;", "handleProvider", "Lcom/stepos/ailauncher/chat/view/F5;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Landroid/view/View;FLp9/a;)Lcom/stepos/ailauncher/chat/view/F5;", "onEnd", "k", "(Landroid/view/View;FLp9/a;Lp9/a;)Lcom/stepos/ailauncher/chat/view/F5;", "", "alphaDurationMs", "scaleFrom", "scaleTo", "alphaFrom", "alphaTo", "scaleStiffness", "scaleDampingRatio", "l", "(Landroid/view/View;FLp9/a;JFFFFFFLp9/a;)Lcom/stepos/ailauncher/chat/view/F5;", "ENTER_MS", "J", "EXIT_MS", "START_SCALE", "F", "END_SCALE", "START_ALPHA", "END_ALPHA", "Landroid/view/animation/PathInterpolator;", "ALPHA_EASING", "Landroid/view/animation/PathInterpolator;", "ENTER_SCALE_STIFFNESS", "ENTER_SCALE_DAMPING_RATIO", "EXIT_SCALE_STIFFNESS", "EXIT_SCALE_DAMPING_RATIO", "OVERSHOOT_PAD_SAFETY", "Landroid/graphics/Paint;", "SCALE_LAYER_PAINT", "Landroid/graphics/Paint;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class L5 {
    private static final float END_ALPHA = 1.0f;
    private static final float END_SCALE = 1.0f;
    private static final long ENTER_MS = 133;
    private static final float ENTER_SCALE_DAMPING_RATIO = 0.6f;
    private static final float ENTER_SCALE_STIFFNESS = 246.74f;
    private static final long EXIT_MS = 133;
    private static final float EXIT_SCALE_DAMPING_RATIO = 1.0f;
    private static final float EXIT_SCALE_STIFFNESS = 986.96f;
    private static final float OVERSHOOT_PAD_SAFETY = 1.25f;
    private static final float START_ALPHA = 0.0f;
    private static final float START_SCALE = 0.5f;
    public static final L5 INSTANCE = new L5();
    private static final PathInterpolator ALPHA_EASING = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
    private static final Paint SCALE_LAYER_PAINT = new Paint(3);

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/chat/view/L5$a", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "LY8/t;", "getOutline", "(Landroid/view/View;Landroid/graphics/Outline;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a extends ViewOutlineProvider {
        final /* synthetic */ float $radiusPx;

        public a(float f10) {
            this.$radiusPx = f10;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            kotlin.jvm.internal.p.i(view, "view");
            kotlin.jvm.internal.p.i(outline, "outline");
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), C5685n.i(this.$radiusPx, Math.min(view.getWidth(), view.getHeight()) / 2.0f));
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"com/stepos/ailauncher/chat/view/L5$b", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "LY8/t;", "onAnimationEnd", "(Landroid/animation/Animator;)V", "onAnimationCancel", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends AnimatorListenerAdapter {
        final /* synthetic */ float $alphaTo;
        final /* synthetic */ View $content;
        final /* synthetic */ Ref$BooleanRef $ended;
        final /* synthetic */ InterfaceC5063a<Y8.t> $onEnd;
        final /* synthetic */ Ref$IntRef $pending;
        final /* synthetic */ float $scaleTo;

        public b(Ref$BooleanRef ref$BooleanRef, Ref$IntRef ref$IntRef, View view, InterfaceC5063a<Y8.t> interfaceC5063a, float f10, float f11) {
            this.$ended = ref$BooleanRef;
            this.$pending = ref$IntRef;
            this.$content = view;
            this.$onEnd = interfaceC5063a;
            this.$scaleTo = f10;
            this.$alphaTo = f11;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            kotlin.jvm.internal.p.i(animation, "animation");
            L5.n(this.$ended, this.$pending, this.$content, this.$onEnd, this.$scaleTo, this.$alphaTo);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            kotlin.jvm.internal.p.i(animation, "animation");
            L5.n(this.$ended, this.$pending, this.$content, this.$onEnd, this.$scaleTo, this.$alphaTo);
        }
    }

    public static final void m(Ref$BooleanRef ref$BooleanRef, View view, InterfaceC5063a<Y8.t> interfaceC5063a, float f10, float f11) {
        if (ref$BooleanRef.f34815a) {
            return;
        }
        ref$BooleanRef.f34815a = true;
        t(view, f10, f11);
        view.setLayerType(0, null);
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
    }

    public static final void n(Ref$BooleanRef ref$BooleanRef, Ref$IntRef ref$IntRef, View view, InterfaceC5063a<Y8.t> interfaceC5063a, float f10, float f11) {
        if (ref$BooleanRef.f34815a) {
            return;
        }
        int i10 = ref$IntRef.f34818a - 1;
        ref$IntRef.f34818a = i10;
        if (i10 <= 0) {
            m(ref$BooleanRef, view, interfaceC5063a, f10, f11);
        }
    }

    public static final Y8.t o() {
        return Y8.t.f7040a;
    }

    public static final void p(View view, androidx.dynamicanimation.animation.e eVar, float f10, float f11) {
        view.setScaleX(f10);
        view.setScaleY(f10);
    }

    public static final void q(View view, float f10, Ref$BooleanRef ref$BooleanRef, Ref$IntRef ref$IntRef, InterfaceC5063a interfaceC5063a, float f11, androidx.dynamicanimation.animation.e eVar, boolean z10, float f12, float f13) {
        view.setScaleX(f10);
        view.setScaleY(f10);
        n(ref$BooleanRef, ref$IntRef, view, interfaceC5063a, f10, f11);
    }

    public static final void r(View view, float f10, float f11, ValueAnimator it) {
        kotlin.jvm.internal.p.i(it, "it");
        view.setAlpha(f10 + ((f11 - f10) * ALPHA_EASING.getInterpolation(it.getAnimatedFraction())));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Y8.t s(Ref$BooleanRef ref$BooleanRef, Ref$ObjectRef ref$ObjectRef, Ref$ObjectRef ref$ObjectRef2, View view, InterfaceC5063a interfaceC5063a, float f10, float f11) {
        if (ref$BooleanRef.f34815a) {
            return Y8.t.f7040a;
        }
        androidx.dynamicanimation.animation.i iVar = (androidx.dynamicanimation.animation.i) ref$ObjectRef.f34820a;
        if (iVar != null) {
            iVar.d();
        }
        ref$ObjectRef.f34820a = null;
        Animator animator = (Animator) ref$ObjectRef2.f34820a;
        if (animator != null) {
            animator.cancel();
        }
        ref$ObjectRef2.f34820a = null;
        m(ref$BooleanRef, view, interfaceC5063a, f10, f11);
        return Y8.t.f7040a;
    }

    public static final void t(View view, float f10, float f11) {
        view.setScaleX(f10);
        view.setScaleY(f10);
        view.setAlpha(f11);
    }

    public final void g(View content, float pivotXPx, float pivotYPx) {
        kotlin.jvm.internal.p.i(content, "content");
        content.setPivotX(pivotXPx);
        content.setPivotY(C5685n.m(pivotYPx, 0.0f, content.getMeasuredHeight()));
        content.setScaleX(0.5f);
        content.setScaleY(0.5f);
        content.setAlpha(0.0f);
        content.setLayerType(2, SCALE_LAYER_PAINT);
    }

    public final void h(View content, int anchorHeightPx, int gapPx) {
        kotlin.jvm.internal.p.i(content, "content");
        g(content, content.getMeasuredWidth(), C5685n.m((-gapPx) - (anchorHeightPx / 2.0f), 0.0f, content.getMeasuredHeight()));
    }

    public final void i(View content) {
        kotlin.jvm.internal.p.i(content, "content");
        g(content, 0.0f, 0.0f);
    }

    public final F5 j(View content, float restCornerDp, InterfaceC5063a<y7.E> handleProvider) {
        kotlin.jvm.internal.p.i(content, "content");
        kotlin.jvm.internal.p.i(handleProvider, "handleProvider");
        return l(content, restCornerDp, handleProvider, 133L, 0.5f, 1.0f, 0.0f, 1.0f, ENTER_SCALE_STIFFNESS, 0.6f, null);
    }

    public final F5 k(View content, float restCornerDp, InterfaceC5063a<y7.E> handleProvider, InterfaceC5063a<Y8.t> onEnd) {
        kotlin.jvm.internal.p.i(content, "content");
        kotlin.jvm.internal.p.i(handleProvider, "handleProvider");
        kotlin.jvm.internal.p.i(onEnd, "onEnd");
        return l(content, restCornerDp, handleProvider, 133L, 1.0f, 0.5f, 1.0f, 0.0f, EXIT_SCALE_STIFFNESS, 1.0f, onEnd);
    }

    /* JADX WARN: Type inference failed for: r11v0, types: [T, androidx.dynamicanimation.animation.e, androidx.dynamicanimation.animation.i] */
    /* JADX WARN: Type inference failed for: r8v1, types: [T, android.animation.Animator, android.animation.ValueAnimator] */
    public final F5 l(final View content, float restCornerDp, InterfaceC5063a<y7.E> handleProvider, long alphaDurationMs, float scaleFrom, final float scaleTo, final float alphaFrom, final float alphaTo, float scaleStiffness, float scaleDampingRatio, final InterfaceC5063a<Y8.t> onEnd) {
        content.setOutlineProvider(new a(content.getResources().getDisplayMetrics().density * restCornerDp));
        content.setClipToOutline(true);
        content.setLayerType(2, SCALE_LAYER_PAINT);
        C2851i7.INSTANCE.m(handleProvider.invoke(), restCornerDp, content);
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        final Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
        if (Settings.Global.getFloat(content.getContext().getContentResolver(), "animator_duration_scale", 1.0f) == 0.0f) {
            m(ref$BooleanRef, content, onEnd, scaleTo, alphaTo);
            return new F5(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.G5
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return L5.o();
                }
            });
        }
        final Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.f34818a = 2;
        androidx.dynamicanimation.animation.g gVar = new androidx.dynamicanimation.animation.g(scaleFrom);
        content.setScaleX(scaleFrom);
        content.setScaleY(scaleFrom);
        ?? iVar = new androidx.dynamicanimation.animation.i(gVar);
        iVar.o(0.002f);
        iVar.B(new androidx.dynamicanimation.animation.j(scaleTo).h(scaleStiffness).f(scaleDampingRatio));
        iVar.q(scaleFrom);
        iVar.c(new e.r() { // from class: com.stepos.ailauncher.chat.view.H5
            @Override // androidx.dynamicanimation.animation.e.r
            public final void b(androidx.dynamicanimation.animation.e eVar, float f10, float f11) {
                L5.p(content, eVar, f10, f11);
            }
        });
        iVar.b(new e.q() { // from class: com.stepos.ailauncher.chat.view.I5
            @Override // androidx.dynamicanimation.animation.e.q
            public final void a(androidx.dynamicanimation.animation.e eVar, boolean z10, float f10, float f11) {
                L5.q(content, scaleTo, ref$BooleanRef, ref$IntRef, onEnd, alphaTo, eVar, z10, f10, f11);
            }
        });
        iVar.t();
        ref$ObjectRef2.f34820a = iVar;
        content.setAlpha(alphaFrom);
        ?? OfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        OfFloat.setDuration(alphaDurationMs);
        OfFloat.setInterpolator(new LinearInterpolator());
        OfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.ailauncher.chat.view.J5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                L5.r(content, alphaFrom, alphaTo, valueAnimator);
            }
        });
        OfFloat.addListener(new b(ref$BooleanRef, ref$IntRef, content, onEnd, scaleTo, alphaTo));
        OfFloat.start();
        ref$ObjectRef.f34820a = OfFloat;
        return new F5(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.K5
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return L5.s(ref$BooleanRef, ref$ObjectRef2, ref$ObjectRef, content, onEnd, scaleTo, alphaTo);
            }
        });
    }

    public final float u(float dampingRatio) {
        if (dampingRatio >= 1.0f) {
            return 0.0f;
        }
        if (dampingRatio <= 0.0f) {
            return 1.0f;
        }
        double d10 = dampingRatio;
        return (float) Math.exp(((-d10) * 3.141592653589793d) / Math.sqrt(1.0d - (d10 * d10)));
    }

    public final U5 v(View content) {
        kotlin.jvm.internal.p.i(content, "content");
        float fU = u(0.6f) * 1.25f;
        float fE = C5685n.e(content.getMeasuredWidth(), 0.0f);
        float fE2 = C5685n.e(content.getMeasuredHeight(), 0.0f);
        int iF = C5685n.f((int) Math.ceil(content.getPivotX() * fU), 0);
        int iF2 = C5685n.f((int) Math.ceil(content.getPivotY() * fU), 0);
        int iCeil = (int) Math.ceil(C5685n.e(fE - content.getPivotX(), 0.0f) * fU);
        int iCeil2 = (int) Math.ceil(C5685n.e(fE2 - content.getPivotY(), 0.0f) * fU);
        FrameLayout frameLayout = new FrameLayout(content.getContext());
        frameLayout.setClipChildren(false);
        frameLayout.setClipToPadding(false);
        frameLayout.setPadding(iF, iF2, iCeil, iCeil2);
        frameLayout.addView(content, new FrameLayout.LayoutParams(-2, -2));
        frameLayout.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return new U5(frameLayout, iF, iF2, iCeil, iCeil2);
    }
}
