package com.stepos.ailauncher.sheet;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.dynamicanimation.animation.e;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$BooleanRef;
import p9.InterfaceC5063a;
import v9.C5685n;

@Metadata(d1 = {"\u0000L\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0015\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\b\u001a%\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\r\u001a;\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u0005¢\u0006\u0004\b\u0015\u0010\u0016\u001ae\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u001a\u001a\u00020\u00192\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b¢\u0006\u0004\b\u001f\u0010 \u001a\u001f\u0010\"\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\"\u0010#\u001a\u001d\u0010$\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u0002¢\u0006\u0004\b$\u0010#\u001a\u0015\u0010%\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b%\u0010&\u001a\u001f\u0010'\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u0002H\u0002¢\u0006\u0004\b'\u0010#\"\u0014\u0010(\u001a\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b(\u0010)\"\u0014\u0010+\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,¨\u0006-"}, d2 = {"", "whiteBar", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Z)I", "", "progress", "f", "(F)F", "fromColor", "toColor", "t", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(IIF)I", "Landroid/view/View;", "panel", "", "durationMs", "dimView", "startDimAlpha", "Landroid/animation/ValueAnimator;", "n", "(Landroid/view/View;IJLandroid/view/View;F)Landroid/animation/ValueAnimator;", "endDimAlpha", "restorePanelOnEnd", "Lcom/stepos/ailauncher/sheet/g0;", "colorSpring", "Lkotlin/Function0;", "LY8/t;", "onEnd", "Landroidx/dynamicanimation/animation/i;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Landroid/view/View;IILandroid/view/View;FZLcom/stepos/ailauncher/sheet/g0;Lp9/a;)Landroidx/dynamicanimation/animation/i;", "color", "e", "(Landroid/view/View;I)V", "q", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroid/view/View;)V", Const.INTENT_KEY_UMID, "HALF_EXIT_COLOR_START_PROGRESS", "F", "Landroid/animation/ArgbEvaluator;", "exitColorEvaluator", "Landroid/animation/ArgbEvaluator;", "sheet_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.sheet.d, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3436d {
    public static final float HALF_EXIT_COLOR_START_PROGRESS = 0.08f;
    private static final ArgbEvaluator exitColorEvaluator = new ArgbEvaluator();

    public static final void d(View view, int i10) {
        Drawable foreground = view.getForeground();
        if (foreground instanceof ColorDrawable) {
            ((ColorDrawable) foreground).setColor(i10);
        } else {
            view.setForeground(new ColorDrawable(i10));
        }
    }

    public static final void e(View view, int i10) {
        q(view, i10);
    }

    public static final float f(float f10) {
        if (f10 <= 0.08f) {
            return 0.0f;
        }
        float fM = C5685n.m((f10 - 0.08f) / 0.92f, 0.0f, 1.0f);
        return fM * fM;
    }

    public static final void g(View panel) {
        kotlin.jvm.internal.p.i(panel, "panel");
        if (panel.getForeground() instanceof ColorDrawable) {
            panel.setForeground(null);
        }
    }

    public static final int h(boolean z10) {
        return z10 ? -1 : -16777216;
    }

    public static final int i(int i10, int i11, float f10) {
        Object objEvaluate = exitColorEvaluator.evaluate(C5685n.m(f10, 0.0f, 1.0f), Integer.valueOf(i10), Integer.valueOf(i11));
        kotlin.jvm.internal.p.g(objEvaluate, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) objEvaluate).intValue();
    }

    public static final androidx.dynamicanimation.animation.i j(final View view, final int i10, final int i11, final View view2, final float f10, final boolean z10, SheetSpring colorSpring, final InterfaceC5063a<Y8.t> interfaceC5063a) {
        final Drawable background;
        Drawable background2;
        Drawable.ConstantState constantState;
        Drawable drawableNewDrawable;
        Drawable drawableMutate;
        kotlin.jvm.internal.p.i(colorSpring, "colorSpring");
        if (view == null && view2 == null) {
            if (interfaceC5063a != null) {
                interfaceC5063a.invoke();
            }
            return null;
        }
        if (view == null || (background2 = view.getBackground()) == null || (constantState = background2.getConstantState()) == null || (drawableNewDrawable = constantState.newDrawable()) == null || (drawableMutate = drawableNewDrawable.mutate()) == null) {
            background = view != null ? view.getBackground() : null;
        } else {
            background = drawableMutate;
        }
        final ArgbEvaluator argbEvaluator = new ArgbEvaluator();
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        androidx.dynamicanimation.animation.i iVar = new androidx.dynamicanimation.animation.i(new androidx.dynamicanimation.animation.g(0.0f));
        iVar.o(0.002f);
        iVar.B(new androidx.dynamicanimation.animation.j(1.0f).h(colorSpring.getStiffness()).f(colorSpring.getDampingRatio()));
        iVar.c(new e.r() { // from class: com.stepos.ailauncher.sheet.b
            @Override // androidx.dynamicanimation.animation.e.r
            public final void b(androidx.dynamicanimation.animation.e eVar, float f11, float f12) {
                C3436d.l(view, argbEvaluator, i10, i11, view2, f10, eVar, f11, f12);
            }
        });
        iVar.b(new e.q() { // from class: com.stepos.ailauncher.sheet.c
            @Override // androidx.dynamicanimation.animation.e.q
            public final void a(androidx.dynamicanimation.animation.e eVar, boolean z11, float f11, float f12) {
                C3436d.m(z10, background, view, ref$BooleanRef, i11, view2, f10, interfaceC5063a, eVar, z11, f11, f12);
            }
        });
        iVar.t();
        return iVar;
    }

    public static final void k(Ref$BooleanRef ref$BooleanRef, boolean z10, Drawable drawable, View view, int i10, View view2, float f10, InterfaceC5063a<Y8.t> interfaceC5063a) {
        if (ref$BooleanRef.f34815a) {
            return;
        }
        ref$BooleanRef.f34815a = true;
        if (!z10 || drawable == null) {
            if (view != null) {
                e(view, i10);
            }
        } else if (view != null) {
            view.setBackground(drawable);
        }
        if (view2 != null) {
            view2.setAlpha(f10);
        }
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
    }

    public static final void l(View view, ArgbEvaluator argbEvaluator, int i10, int i11, View view2, float f10, androidx.dynamicanimation.animation.e eVar, float f11, float f12) {
        float fM = C5685n.m(f11, 0.0f, 1.0f);
        if (view != null) {
            Object objEvaluate = argbEvaluator.evaluate(fM, Integer.valueOf(i10), Integer.valueOf(i11));
            kotlin.jvm.internal.p.g(objEvaluate, "null cannot be cast to non-null type kotlin.Int");
            e(view, ((Integer) objEvaluate).intValue());
        }
        if (view2 != null) {
            view2.setAlpha(f10 * fM);
        }
    }

    public static final void m(boolean z10, Drawable drawable, View view, Ref$BooleanRef ref$BooleanRef, int i10, View view2, float f10, InterfaceC5063a interfaceC5063a, androidx.dynamicanimation.animation.e eVar, boolean z11, float f11, float f12) {
        if (!z11) {
            k(ref$BooleanRef, z10, drawable, view, i10, view2, f10, interfaceC5063a);
        } else {
            if (!z10 || drawable == null || view == null) {
                return;
            }
            view.setBackground(drawable);
        }
    }

    public static final ValueAnimator n(final View panel, final int i10, long j10, final View view, final float f10) {
        kotlin.jvm.internal.p.i(panel, "panel");
        Drawable foreground = panel.getForeground();
        ColorDrawable colorDrawable = foreground instanceof ColorDrawable ? (ColorDrawable) foreground : null;
        int color = colorDrawable != null ? colorDrawable.getColor() : 16777215 & i10;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(C5685n.g(j10, 1L));
        valueAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        final int i11 = color;
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.ailauncher.sheet.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                C3436d.p(panel, i11, i10, view, f10, valueAnimator);
            }
        });
        valueAnimatorOfFloat.start();
        kotlin.jvm.internal.p.h(valueAnimatorOfFloat, "apply(...)");
        return valueAnimatorOfFloat;
    }

    public static /* synthetic */ ValueAnimator o(View view, int i10, long j10, View view2, float f10, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            view2 = null;
        }
        View view3 = view2;
        if ((i11 & 16) != 0) {
            f10 = 0.0f;
        }
        return n(view, i10, j10, view3, f10);
    }

    public static final void p(View view, int i10, int i11, View view2, float f10, ValueAnimator animation) {
        kotlin.jvm.internal.p.i(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        kotlin.jvm.internal.p.g(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float fFloatValue = ((Float) animatedValue).floatValue();
        d(view, i(i10, i11, fFloatValue));
        if (view2 != null) {
            view2.setAlpha(f10 * (1.0f - fFloatValue));
        }
    }

    public static final void q(View panel, int i10) {
        kotlin.jvm.internal.p.i(panel, "panel");
        Drawable background = panel.getBackground();
        Drawable drawableMutate = background != null ? background.mutate() : null;
        if (drawableMutate instanceof GradientDrawable) {
            g(panel);
            ((GradientDrawable) drawableMutate).setColor(i10);
        } else if (drawableMutate instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawableMutate;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            boolean z10 = false;
            for (int i11 = 0; i11 < numberOfLayers; i11++) {
                Drawable drawable = layerDrawable.getDrawable(i11);
                Drawable drawableMutate2 = drawable != null ? drawable.mutate() : null;
                if (drawableMutate2 instanceof GradientDrawable) {
                    ((GradientDrawable) drawableMutate2).setColor(i10);
                } else if (drawableMutate2 instanceof ColorDrawable) {
                    ((ColorDrawable) drawableMutate2).setColor(i10);
                }
                z10 = true;
            }
            if (z10) {
                g(panel);
            } else {
                d(panel, i10);
            }
        } else if (drawableMutate instanceof ColorDrawable) {
            g(panel);
            ((ColorDrawable) drawableMutate).setColor(i10);
        } else {
            d(panel, i10);
        }
        panel.invalidate();
    }
}
