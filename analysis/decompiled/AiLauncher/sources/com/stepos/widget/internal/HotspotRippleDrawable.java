package com.stepos.widget.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.view.animation.DecelerateInterpolator;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.launcher.assistant.slidepanel.ConstConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u00002\u00020\u0001B?\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0003\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0003\u0010\b\u001a\u00020\u0006\u0012\b\b\u0003\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0010J\u000f\u0010\u0013\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0010J\u000f\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0017\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0018\u0010\u0016J\u001f\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020 H\u0014¢\u0006\u0004\b\"\u0010#J\u0017\u0010&\u001a\u00020\u00142\u0006\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0014H\u0016¢\u0006\u0004\b(\u0010\u0016J\u0017\u0010+\u001a\u00020\u00142\u0006\u0010*\u001a\u00020)H\u0014¢\u0006\u0004\b+\u0010,J\u0017\u0010.\u001a\u00020\u00142\u0006\u0010-\u001a\u00020\u0002H\u0016¢\u0006\u0004\b.\u0010/J\u0019\u00102\u001a\u00020\u00142\b\u00101\u001a\u0004\u0018\u000100H\u0016¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\u0002H\u0017¢\u0006\u0004\b4\u00105R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u00106R\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u00106R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u00106R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u00107R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u00107R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u00107R\u0014\u00109\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010;\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u00106R\u0016\u0010<\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u00107R\u0016\u0010=\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u00107R\u0016\u0010>\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010@\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u00107R\u0016\u0010A\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010?R\u0018\u0010C\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010E\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010G\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010H¨\u0006I"}, d2 = {"Lcom/stepos/widget/internal/HotspotRippleDrawable;", "Landroid/graphics/drawable/Drawable;", "", "color", "enterDurationMs", "exitDurationMs", "", "fadeRadiusPx", "cornerRadiusPx", "coreFraction", "<init>", "(IIIFFF)V", "Landroid/graphics/RadialGradient;", "edgeFadeShader", "()Landroid/graphics/RadialGradient;", "fadeSpreadRadius", "()F", "targetRadius", "centerX", "centerY", "LY8/t;", "startEnter", "()V", "startExit", "cancelAnimator", "x", "y", "setHotspot", "(FF)V", "", "isStateful", "()Z", "", VoiceWakeupReceiver.EXTRA_STATE, "onStateChange", "([I)Z", "Landroid/graphics/Canvas;", "canvas", "draw", "(Landroid/graphics/Canvas;)V", "jumpToCurrentState", "Landroid/graphics/Rect;", "bounds", "onBoundsChange", "(Landroid/graphics/Rect;)V", ConstConfig.KEY_VIEW_ALPHA_PROPERTY, "setAlpha", "(I)V", "Landroid/graphics/ColorFilter;", "colorFilter", "setColorFilter", "(Landroid/graphics/ColorFilter;)V", "getOpacity", "()I", "I", "F", "Landroid/graphics/Paint;", "paint", "Landroid/graphics/Paint;", "maxAlpha", "hotspotX", "hotspotY", "hotspotSet", "Z", "radius", "pressed", "Landroid/animation/ValueAnimator;", "animator", "Landroid/animation/ValueAnimator;", "edgeFade", "Landroid/graphics/RadialGradient;", "edgeFadeBounds", "Landroid/graphics/Rect;", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HotspotRippleDrawable extends Drawable {
    private ValueAnimator animator;
    private final int color;
    private final float coreFraction;
    private final float cornerRadiusPx;
    private RadialGradient edgeFade;
    private Rect edgeFadeBounds;
    private final int enterDurationMs;
    private final int exitDurationMs;
    private final float fadeRadiusPx;
    private boolean hotspotSet;
    private float hotspotX;
    private float hotspotY;
    private final int maxAlpha;
    private final Paint paint;
    private boolean pressed;
    private float radius;

    public /* synthetic */ HotspotRippleDrawable(int i10, int i11, int i12, float f10, float f11, float f12, int i13, kotlin.jvm.internal.i iVar) {
        this(i10, i11, i12, (i13 & 8) != 0 ? 0.0f : f10, (i13 & 16) != 0 ? 0.0f : f11, (i13 & 32) != 0 ? 1.0f : f12);
    }

    private final void cancelAnimator() {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.animator = null;
    }

    private final float centerX() {
        return this.hotspotSet ? this.hotspotX : getBounds().exactCenterX();
    }

    private final float centerY() {
        return this.hotspotSet ? this.hotspotY : getBounds().exactCenterY();
    }

    private final RadialGradient edgeFadeShader() {
        if (this.fadeRadiusPx <= 0.0f || this.coreFraction >= 1.0f) {
            return null;
        }
        Rect bounds = getBounds();
        p.h(bounds, "getBounds(...)");
        RadialGradient radialGradient = this.edgeFade;
        if (radialGradient != null && p.d(this.edgeFadeBounds, bounds)) {
            return radialGradient;
        }
        int i10 = this.color;
        int i11 = (-16777216) | i10;
        int i12 = i10 & 16777215;
        float f10 = this.coreFraction;
        RadialGradient radialGradient2 = new RadialGradient(centerX(), centerY(), fadeSpreadRadius(), f10 <= 0.0f ? new int[]{i11, i12} : new int[]{i11, i11, i12}, f10 <= 0.0f ? new float[]{0.0f, 1.0f} : new float[]{0.0f, f10, 1.0f}, Shader.TileMode.CLAMP);
        this.edgeFade = radialGradient2;
        this.edgeFadeBounds = new Rect(bounds);
        return radialGradient2;
    }

    private final float fadeSpreadRadius() {
        int iWidth = getBounds().width();
        int iHeight = getBounds().height();
        float fMin = Math.min(iWidth, iHeight) / 2.0f;
        if (this.cornerRadiusPx >= fMin - 0.5f && iWidth == iHeight) {
            return fMin + ((float) Math.hypot(centerX() - getBounds().exactCenterX(), centerY() - getBounds().exactCenterY()));
        }
        float f10 = iWidth;
        float f11 = iHeight;
        return b9.c.g((float) Math.hypot(centerX(), centerY()), (float) Math.hypot(f10 - centerX(), centerY()), (float) Math.hypot(centerX(), f11 - centerY()), (float) Math.hypot(f10 - centerX(), f11 - centerY()));
    }

    private final void startEnter() {
        cancelAnimator();
        float f10 = this.radius;
        this.paint.setAlpha(this.maxAlpha);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f10, targetRadius());
        valueAnimatorOfFloat.setDuration(this.enterDurationMs);
        valueAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.widget.internal.e
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                HotspotRippleDrawable.startEnter$lambda$1$lambda$0(this.f31249a, valueAnimator);
            }
        });
        valueAnimatorOfFloat.start();
        this.animator = valueAnimatorOfFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startEnter$lambda$1$lambda$0(HotspotRippleDrawable hotspotRippleDrawable, ValueAnimator animation) {
        p.i(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        p.g(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        hotspotRippleDrawable.radius = ((Float) animatedValue).floatValue();
        hotspotRippleDrawable.invalidateSelf();
    }

    private final void startExit() {
        cancelAnimator();
        final float f10 = this.radius;
        final float fTargetRadius = targetRadius();
        final int alpha = this.paint.getAlpha();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(this.exitDurationMs);
        valueAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.widget.internal.f
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                HotspotRippleDrawable.startExit$lambda$3$lambda$2(this.f31250a, f10, fTargetRadius, alpha, valueAnimator);
            }
        });
        valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.stepos.widget.internal.HotspotRippleDrawable$startExit$1$2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                p.i(animation, "animation");
                this.this$0.radius = 0.0f;
                this.this$0.paint.setAlpha(0);
                this.this$0.invalidateSelf();
            }
        });
        valueAnimatorOfFloat.start();
        this.animator = valueAnimatorOfFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startExit$lambda$3$lambda$2(HotspotRippleDrawable hotspotRippleDrawable, float f10, float f11, int i10, ValueAnimator animation) {
        p.i(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        p.g(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float fFloatValue = ((Float) animatedValue).floatValue();
        hotspotRippleDrawable.radius = f10 + ((f11 - f10) * fFloatValue);
        hotspotRippleDrawable.paint.setAlpha((int) (i10 * (1.0f - fFloatValue)));
        hotspotRippleDrawable.invalidateSelf();
    }

    private final float targetRadius() {
        float fCenterX = centerX();
        float fCenterY = centerY();
        float f10 = getBounds().left;
        float f11 = getBounds().top;
        double d10 = fCenterX - f10;
        double d11 = fCenterY - f11;
        double d12 = fCenterX - getBounds().right;
        double d13 = fCenterY - getBounds().bottom;
        return b9.c.g((float) Math.hypot(d10, d11), (float) Math.hypot(d12, d11), (float) Math.hypot(d10, d13), (float) Math.hypot(d12, d13));
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        p.i(canvas, "canvas");
        if (this.paint.getAlpha() == 0 || this.radius <= 0.0f) {
            return;
        }
        this.paint.setShader(edgeFadeShader());
        canvas.drawCircle(centerX(), centerY(), this.radius, this.paint);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        cancelAnimator();
        if (this.pressed) {
            this.radius = targetRadius();
            this.paint.setAlpha(this.maxAlpha);
        } else {
            this.radius = 0.0f;
            this.paint.setAlpha(0);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect bounds) {
        p.i(bounds, "bounds");
        super.onBoundsChange(bounds);
        this.edgeFade = null;
        this.edgeFadeBounds = null;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] state) {
        p.i(state, "state");
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        for (int i10 : state) {
            if (i10 == 16842910) {
                z12 = true;
            }
            if (i10 == 16842919) {
                z11 = true;
            }
        }
        if (z11 && z12) {
            z10 = true;
        }
        if (z10 == this.pressed) {
            return super.onStateChange(state);
        }
        this.pressed = z10;
        if (z10) {
            startEnter();
        } else {
            startExit();
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        this.paint.setAlpha(alpha);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float x10, float y10) {
        this.hotspotX = x10;
        this.hotspotY = y10;
        this.hotspotSet = true;
        this.edgeFade = null;
        this.edgeFadeBounds = null;
    }

    public HotspotRippleDrawable(int i10, int i11, int i12, float f10, float f11, float f12) {
        this.color = i10;
        this.enterDurationMs = i11;
        this.exitDurationMs = i12;
        this.fadeRadiusPx = f10;
        this.cornerRadiusPx = f11;
        this.coreFraction = f12;
        Paint paint = new Paint(1);
        this.paint = paint;
        this.maxAlpha = Color.alpha(i10);
        paint.setColor(i10);
        paint.setAlpha(0);
    }
}
