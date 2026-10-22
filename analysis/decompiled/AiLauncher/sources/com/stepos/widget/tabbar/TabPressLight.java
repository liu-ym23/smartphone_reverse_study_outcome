package com.stepos.widget.tabbar;

import Y8.t;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.view.View;
import android.view.animation.PathInterpolator;
import com.stepos.launcher.assistant.slidepanel.ConstConfig;
import kotlin.Metadata;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0001\u0018\u0000 Q2\u00020\u0001:\u0001QB)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\fJC\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n0\u0014H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0019\u0010\fJ\u000f\u0010\u001a\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ'\u0010 \u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u000eH\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u000eH\u0002¢\u0006\u0004\b#\u0010$J\u001f\u0010)\u001a\u00020\n2\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u000eH\u0000¢\u0006\u0004\b'\u0010(J\u0017\u0010.\u001a\u00020\n2\u0006\u0010+\u001a\u00020*H\u0000¢\u0006\u0004\b,\u0010-J\u0017\u00103\u001a\u00020\n2\u0006\u00100\u001a\u00020/H\u0000¢\u0006\u0004\b1\u00102J\u000f\u00105\u001a\u00020\nH\u0000¢\u0006\u0004\b4\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u00106R\u0014\u0010\u0006\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u00107R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u00107R\u0014\u00109\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010;\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u00107R\u0014\u0010<\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u00107R\u0014\u0010=\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u00107R\u0014\u0010>\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010@\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010?R\u0016\u0010A\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010C\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010E\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010DR\u0016\u0010F\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010DR\u0016\u0010G\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010DR\u0016\u0010H\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010BR\u0018\u0010I\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010K\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010JR\u0018\u0010L\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010N\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010DR\u0016\u0010O\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010DR\u0016\u0010P\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010D¨\u0006R"}, d2 = {"Lcom/stepos/widget/tabbar/TabPressLight;", "", "Landroid/view/View;", "host", "", "color", "enterDurationMs", "exitDurationMs", "<init>", "(Landroid/view/View;III)V", "LY8/t;", "startEnter", "()V", "startExit", "", "from", "to", "durationMs", "Landroid/view/animation/PathInterpolator;", "interpolator", "Lkotlin/Function1;", "onValue", "Landroid/animation/ValueAnimator;", "animate", "(FFILandroid/view/animation/PathInterpolator;Lp9/l;)Landroid/animation/ValueAnimator;", "cancelAnimators", "fullRadius", "()F", "cx", "cy", "radius", "Landroid/graphics/RadialGradient;", "gradient", "(FFF)Landroid/graphics/RadialGradient;", "relativeAlpha", "shade", "(F)I", "x", "y", "onHotspotChanged$StepOSWidget_release", "(FF)V", "onHotspotChanged", "", "nowPressed", "onPressedChanged$StepOSWidget_release", "(Z)V", "onPressedChanged", "Landroid/graphics/Canvas;", "canvas", "draw$StepOSWidget_release", "(Landroid/graphics/Canvas;)V", "draw", "release$StepOSWidget_release", "release", "Landroid/view/View;", "I", "Landroid/graphics/Paint;", "paint", "Landroid/graphics/Paint;", "maxAlpha", "opaque", "clear", "scaleInterpolator", "Landroid/view/animation/PathInterpolator;", "alphaInterpolator", "pressed", "Z", ConstConfig.KEY_VIEW_SCALE_PROPERTY, "F", ConstConfig.KEY_VIEW_ALPHA_PROPERTY, "hotspotX", "hotspotY", "hotspotSet", "scaleAnimator", "Landroid/animation/ValueAnimator;", "alphaAnimator", "shader", "Landroid/graphics/RadialGradient;", "shaderX", "shaderY", "shaderRadius", "Companion", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TabPressLight {
    private static final Companion Companion = new Companion(null);
    private static final float PEAK_ALPHA = 0.9f;
    private static final float RADIUS_OVER_SHORT_SIDE = 0.64f;
    private float alpha;
    private ValueAnimator alphaAnimator;
    private final PathInterpolator alphaInterpolator;
    private final int clear;
    private final int enterDurationMs;
    private final int exitDurationMs;
    private final View host;
    private boolean hotspotSet;
    private float hotspotX;
    private float hotspotY;
    private final int maxAlpha;
    private final int opaque;
    private final Paint paint;
    private boolean pressed;
    private float scale;
    private ValueAnimator scaleAnimator;
    private final PathInterpolator scaleInterpolator;
    private RadialGradient shader;
    private float shaderRadius;
    private float shaderX;
    private float shaderY;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/stepos/widget/tabbar/TabPressLight$Companion;", "", "<init>", "()V", "RADIUS_OVER_SHORT_SIDE", "", "PEAK_ALPHA", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        private Companion() {
        }
    }

    public TabPressLight(View host, int i10, int i11, int i12) {
        kotlin.jvm.internal.p.i(host, "host");
        this.host = host;
        this.enterDurationMs = i11;
        this.exitDurationMs = i12;
        this.paint = new Paint(1);
        this.maxAlpha = Color.alpha(i10);
        this.opaque = (-16777216) | i10;
        this.clear = 16777215 & i10;
        this.scaleInterpolator = new PathInterpolator(0.0f, 0.0f, 0.1f, 1.0f);
        this.alphaInterpolator = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.shaderX = Float.NaN;
        this.shaderY = Float.NaN;
        this.shaderRadius = Float.NaN;
    }

    private final ValueAnimator animate(float from, float to, int durationMs, PathInterpolator interpolator, final InterfaceC5074l<? super Float, t> onValue) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(from, to);
        valueAnimatorOfFloat.setDuration(durationMs);
        valueAnimatorOfFloat.setInterpolator(interpolator);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.widget.tabbar.r
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                TabPressLight.animate$lambda$7$lambda$6(onValue, this, valueAnimator);
            }
        });
        kotlin.jvm.internal.p.h(valueAnimatorOfFloat, "apply(...)");
        return valueAnimatorOfFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animate$lambda$7$lambda$6(InterfaceC5074l interfaceC5074l, TabPressLight tabPressLight, ValueAnimator animation) {
        kotlin.jvm.internal.p.i(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        kotlin.jvm.internal.p.g(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        interfaceC5074l.invoke((Float) animatedValue);
        tabPressLight.host.invalidate();
    }

    private final void cancelAnimators() {
        ValueAnimator valueAnimator = this.scaleAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.alphaAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        this.scaleAnimator = null;
        this.alphaAnimator = null;
    }

    private final float fullRadius() {
        float width = this.host.getWidth();
        float height = this.host.getHeight();
        if (width <= 0.0f || height <= 0.0f) {
            return 0.0f;
        }
        return Math.min(width, height) * RADIUS_OVER_SHORT_SIDE;
    }

    private final RadialGradient gradient(float cx, float cy, float radius) {
        RadialGradient radialGradient = this.shader;
        if (radialGradient != null && this.shaderX == cx && this.shaderY == cy && this.shaderRadius == radius) {
            return radialGradient;
        }
        RadialGradient radialGradient2 = new RadialGradient(cx, cy, radius, new int[]{shade(1.0f), shade(0.82f), shade(0.52f), shade(0.29f), shade(0.07f), this.clear}, new float[]{0.0f, 0.17f, 0.46f, 0.69f, 0.91f, 1.0f}, Shader.TileMode.CLAMP);
        this.shader = radialGradient2;
        this.shaderX = cx;
        this.shaderY = cy;
        this.shaderRadius = radius;
        return radialGradient2;
    }

    private final int shade(float relativeAlpha) {
        return (this.opaque & 16777215) | (C5685n.n((int) (relativeAlpha * 255.0f), 0, 255) << 24);
    }

    private final void startEnter() {
        cancelAnimators();
        ValueAnimator valueAnimatorAnimate = animate(this.scale, 1.0f, this.enterDurationMs, this.scaleInterpolator, new InterfaceC5074l() { // from class: com.stepos.widget.tabbar.p
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TabPressLight.startEnter$lambda$0(this.f31384a, ((Float) obj).floatValue());
            }
        });
        valueAnimatorAnimate.start();
        this.scaleAnimator = valueAnimatorAnimate;
        ValueAnimator valueAnimatorAnimate2 = animate(this.alpha, 1.0f, this.enterDurationMs, this.alphaInterpolator, new InterfaceC5074l() { // from class: com.stepos.widget.tabbar.q
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TabPressLight.startEnter$lambda$2(this.f31385a, ((Float) obj).floatValue());
            }
        });
        valueAnimatorAnimate2.start();
        this.alphaAnimator = valueAnimatorAnimate2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t startEnter$lambda$0(TabPressLight tabPressLight, float f10) {
        tabPressLight.scale = f10;
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t startEnter$lambda$2(TabPressLight tabPressLight, float f10) {
        tabPressLight.alpha = f10;
        return t.f7040a;
    }

    private final void startExit() {
        cancelAnimators();
        ValueAnimator valueAnimatorAnimate = animate(this.alpha, 0.0f, this.exitDurationMs, this.alphaInterpolator, new InterfaceC5074l() { // from class: com.stepos.widget.tabbar.s
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TabPressLight.startExit$lambda$4(this.f31388a, ((Float) obj).floatValue());
            }
        });
        valueAnimatorAnimate.addListener(new AnimatorListenerAdapter() { // from class: com.stepos.widget.tabbar.TabPressLight$startExit$2$1
            private boolean cancelled;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                kotlin.jvm.internal.p.i(animation, "animation");
                this.cancelled = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                kotlin.jvm.internal.p.i(animation, "animation");
                if (this.cancelled || this.this$0.pressed) {
                    return;
                }
                this.this$0.scale = 0.0f;
                this.this$0.alpha = 0.0f;
                this.this$0.host.invalidate();
            }
        });
        valueAnimatorAnimate.start();
        this.alphaAnimator = valueAnimatorAnimate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t startExit$lambda$4(TabPressLight tabPressLight, float f10) {
        tabPressLight.alpha = f10;
        return t.f7040a;
    }

    public final void draw$StepOSWidget_release(Canvas canvas) {
        kotlin.jvm.internal.p.i(canvas, "canvas");
        if (this.alpha <= 0.0f || this.scale <= 0.0f) {
            return;
        }
        float fFullRadius = fullRadius() * this.scale;
        if (fFullRadius <= 0.0f) {
            return;
        }
        float width = this.hotspotSet ? this.hotspotX : this.host.getWidth() / 2.0f;
        float height = this.hotspotSet ? this.hotspotY : this.host.getHeight() / 2.0f;
        this.paint.setShader(gradient(width, height, fFullRadius));
        this.paint.setAlpha((int) (this.maxAlpha * this.alpha * 0.9f));
        canvas.drawCircle(width, height, fFullRadius, this.paint);
    }

    public final void onHotspotChanged$StepOSWidget_release(float x10, float y10) {
        this.hotspotX = x10;
        this.hotspotY = y10;
        this.hotspotSet = true;
        if (this.alpha <= 0.0f || this.scale <= 0.0f) {
            return;
        }
        this.host.invalidate();
    }

    public final void onPressedChanged$StepOSWidget_release(boolean nowPressed) {
        if (nowPressed == this.pressed) {
            return;
        }
        this.pressed = nowPressed;
        if (nowPressed) {
            startEnter();
        } else {
            startExit();
        }
    }

    public final void release$StepOSWidget_release() {
        cancelAnimators();
        this.scale = 0.0f;
        this.alpha = 0.0f;
        this.pressed = false;
    }
}
