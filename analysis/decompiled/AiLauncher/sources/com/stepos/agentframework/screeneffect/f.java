package com.stepos.agentframework.screeneffect;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RuntimeShader;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u0014\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0017\u0018\u00002\u00020\u0001J/\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0016\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0018\u0010\u0013R\"\u0010\u0019\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\rR\"\u0010\u001e\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\rR\"\u0010!\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\u001a\u001a\u0004\b\"\u0010\u001c\"\u0004\b#\u0010\rR\"\u0010%\u001a\u00020$8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010,\u001a\u00020+8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00102\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u0010\u001a\u001a\u0004\b3\u0010\u001c\"\u0004\b4\u0010\rR\"\u00105\u001a\u00020$8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u0010&\u001a\u0004\b6\u0010(\"\u0004\b7\u0010*R\"\u00109\u001a\u0002088\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010?\u001a\u0002088\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010:\u001a\u0004\b@\u0010<\"\u0004\bA\u0010>R\"\u0010B\u001a\u0002088\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010:\u001a\u0004\bC\u0010<\"\u0004\bD\u0010>R\u0014\u0010F\u001a\u00020E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010I\u001a\u00020H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010L\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010N\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\"\u0010P\u001a\u00020\n8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bP\u0010\u001a\u001a\u0004\bQ\u0010\u001c\"\u0004\bR\u0010\rR\"\u0010S\u001a\u00020\n8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bS\u0010\u001a\u001a\u0004\bT\u0010\u001c\"\u0004\bU\u0010\rR\"\u0010V\u001a\u00020\n8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bV\u0010\u001a\u001a\u0004\bW\u0010\u001c\"\u0004\bX\u0010\rR\"\u0010Y\u001a\u00020\n8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bY\u0010\u001a\u001a\u0004\bZ\u0010\u001c\"\u0004\b[\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\"\u0010\u0004\u001a\u00020\u00028\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\\\u001a\u0004\ba\u0010^\"\u0004\bb\u0010`R\"\u0010c\u001a\u00020\n8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bc\u0010\u001a\u001a\u0004\bd\u0010\u001c\"\u0004\be\u0010\rR\u0014\u0010f\u001a\u00020H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bf\u0010J¨\u0006g"}, d2 = {"Lcom/stepos/agentframework/screeneffect/f;", "Landroid/view/View;", "", "w", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "oldw", "oldh", "LY8/t;", "onSizeChanged", "(IIII)V", "", "timeValue", Const.INTENT_KEY_PKGNAME, "(F)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "onDetachedFromWindow", "()V", "Landroid/graphics/RuntimeShader;", "shade", "c", "(Landroid/graphics/RuntimeShader;)V", Const.INTENT_KEY_UMID, "rect_ratio_horz", "F", "getRect_ratio_horz", "()F", "setRect_ratio_horz", "rect_ratio_vert", "getRect_ratio_vert", "setRect_ratio_vert", "rect_ratio_vert_t", "getRect_ratio_vert_t", "setRect_ratio_vert_t", "", "default_corner_radius", "D", "getDefault_corner_radius", "()D", "setDefault_corner_radius", "(D)V", "", "animation_duration", "J", "getAnimation_duration", "()J", "setAnimation_duration", "(J)V", "color_change_speed", "getColor_change_speed", "setColor_change_speed", "max_alpha", "getMax_alpha", "setMax_alpha", "", "color1", "[F", "getColor1", "()[F", "setColor1", "([F)V", "color2", "getColor2", "setColor2", "color3", "getColor3", "setColor3", "", "shaderSource", "Ljava/lang/String;", "Landroid/graphics/Paint;", "mPaint", "Landroid/graphics/Paint;", "Landroid/animation/ValueAnimator;", "valueAnimator", "Landroid/animation/ValueAnimator;", "shader", "Landroid/graphics/RuntimeShader;", "rectX", "getRectX", "setRectX", "rectY", "getRectY", "setRectY", "rectWidth", "getRectWidth", "setRectWidth", "rectHeight", "getRectHeight", "setRectHeight", "I", "getW", "()I", "setW", "(I)V", "getH", "setH", "adjustSizeRatio", "getAdjustSizeRatio", "setAdjustSizeRatio", "backgroundPaint", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public class f extends View {
    private float adjustSizeRatio;
    private long animation_duration;
    private final Paint backgroundPaint;
    private float[] color1;
    private float[] color2;
    private float[] color3;
    private float color_change_speed;
    private double default_corner_radius;
    private int h;
    private final Paint mPaint;
    private double max_alpha;
    private float rectHeight;
    private float rectWidth;
    private float rectX;
    private float rectY;
    private float rect_ratio_horz;
    private float rect_ratio_vert;
    private float rect_ratio_vert_t;
    private RuntimeShader shader;
    private final String shaderSource;
    private ValueAnimator valueAnimator;
    private int w;

    public static final void e(f fVar, ValueAnimator animation) {
        p.i(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        p.g(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        fVar.b(((Float) animatedValue).floatValue());
        fVar.invalidate();
    }

    public void b(float timeValue) {
        RuntimeShader runtimeShader = this.shader;
        if (runtimeShader != null) {
            runtimeShader.setFloatUniform("iTime", timeValue);
        }
    }

    public final void c(RuntimeShader shade) {
        int i10 = this.w;
        float f10 = i10 * this.rect_ratio_horz;
        float f11 = this.adjustSizeRatio;
        float f12 = f10 / f11;
        this.rectWidth = f12;
        int i11 = this.h;
        float f13 = (i11 * this.rect_ratio_vert) / f11;
        this.rectHeight = f13;
        float f14 = (i10 - f12) * 0.5f;
        this.rectX = f14;
        float f15 = (i11 - f13) * this.rect_ratio_vert_t;
        this.rectY = f15;
        if (shade != null) {
            shade.setFloatUniform("rectProps", f14, f15, f12, f13);
        }
    }

    public final void d() {
        ValueAnimator valueAnimator = this.valueAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 6.283185f);
        this.valueAnimator = valueAnimatorOfFloat;
        if (valueAnimatorOfFloat != null) {
            valueAnimatorOfFloat.setDuration(this.animation_duration);
            valueAnimatorOfFloat.setRepeatCount(-1);
            valueAnimatorOfFloat.setRepeatMode(2);
            valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.agentframework.screeneffect.e
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    f.e(this.f23300a, valueAnimator2);
                }
            });
            valueAnimatorOfFloat.start();
        }
    }

    public final float getAdjustSizeRatio() {
        return this.adjustSizeRatio;
    }

    public final long getAnimation_duration() {
        return this.animation_duration;
    }

    public final float[] getColor1() {
        return this.color1;
    }

    public final float[] getColor2() {
        return this.color2;
    }

    public final float[] getColor3() {
        return this.color3;
    }

    public final float getColor_change_speed() {
        return this.color_change_speed;
    }

    public final double getDefault_corner_radius() {
        return this.default_corner_radius;
    }

    public final int getH() {
        return this.h;
    }

    public final double getMax_alpha() {
        return this.max_alpha;
    }

    public final float getRectHeight() {
        return this.rectHeight;
    }

    public final float getRectWidth() {
        return this.rectWidth;
    }

    public final float getRectX() {
        return this.rectX;
    }

    public final float getRectY() {
        return this.rectY;
    }

    public final float getRect_ratio_horz() {
        return this.rect_ratio_horz;
    }

    public final float getRect_ratio_vert() {
        return this.rect_ratio_vert;
    }

    public final float getRect_ratio_vert_t() {
        return this.rect_ratio_vert_t;
    }

    public final int getW() {
        return this.w;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.valueAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        p.i(canvas, "canvas");
        super.onDraw(canvas);
        canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.backgroundPaint);
        canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.mPaint);
    }

    @Override // android.view.View
    public void onSizeChanged(int w10, int h10, int oldw, int oldh) {
        super.onSizeChanged(w10, h10, oldw, oldh);
        this.w = w10;
        this.h = h10;
        RuntimeShader runtimeShader = new RuntimeShader(this.shaderSource);
        runtimeShader.setFloatUniform("color1", this.color1);
        runtimeShader.setFloatUniform("color2", this.color2);
        runtimeShader.setFloatUniform("color3", this.color3);
        c(runtimeShader);
        runtimeShader.setFloatUniform("iTime", 0.0f);
        this.mPaint.setShader(runtimeShader);
        this.shader = runtimeShader;
        d();
    }

    public final void setAdjustSizeRatio(float f10) {
        this.adjustSizeRatio = f10;
    }

    public final void setAnimation_duration(long j10) {
        this.animation_duration = j10;
    }

    public final void setColor1(float[] fArr) {
        p.i(fArr, "<set-?>");
        this.color1 = fArr;
    }

    public final void setColor2(float[] fArr) {
        p.i(fArr, "<set-?>");
        this.color2 = fArr;
    }

    public final void setColor3(float[] fArr) {
        p.i(fArr, "<set-?>");
        this.color3 = fArr;
    }

    public final void setColor_change_speed(float f10) {
        this.color_change_speed = f10;
    }

    public final void setDefault_corner_radius(double d10) {
        this.default_corner_radius = d10;
    }

    public final void setH(int i10) {
        this.h = i10;
    }

    public final void setMax_alpha(double d10) {
        this.max_alpha = d10;
    }

    public final void setRectHeight(float f10) {
        this.rectHeight = f10;
    }

    public final void setRectWidth(float f10) {
        this.rectWidth = f10;
    }

    public final void setRectX(float f10) {
        this.rectX = f10;
    }

    public final void setRectY(float f10) {
        this.rectY = f10;
    }

    public final void setRect_ratio_horz(float f10) {
        this.rect_ratio_horz = f10;
    }

    public final void setRect_ratio_vert(float f10) {
        this.rect_ratio_vert = f10;
    }

    public final void setRect_ratio_vert_t(float f10) {
        this.rect_ratio_vert_t = f10;
    }

    public final void setW(int i10) {
        this.w = i10;
    }
}
