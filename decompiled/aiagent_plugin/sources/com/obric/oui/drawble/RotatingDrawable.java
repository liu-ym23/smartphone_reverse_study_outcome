package com.obric.oui.drawble;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.LinearInterpolator;
import androidx.appcompat.graphics.drawable.DrawableWrapper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Objects;

/* JADX INFO: compiled from: RotatingDrawable.kt */
/* JADX INFO: loaded from: classes4.dex */
public class RotatingDrawable extends DrawableWrapper implements Animatable {
    private final Matrix IDENTITY;
    private boolean isRunning;
    private float rotate;
    private float targetScale;
    private final ValueAnimator valueAnimator;

    public static /* synthetic */ void lambda$eJL8g1TzVxVmmTtWJ2PbXwIo9FQ(RotatingDrawable r0, ValueAnimator r1) {
        m1058start$lambda1$lambda0(r0, r1);
    }

    public RotatingDrawable(Drawable r1) {
        super(r1);
        this.valueAnimator = ValueAnimator.ofInt(new int[]{0, 360});
        this.IDENTITY = new Matrix();
    }

    public final float getTargetScale() {
        return this.targetScale;
    }

    public final void setTargetScale(float r1) {
        this.targetScale = r1;
    }

    public void onBoundsChange(Rect r3) {
        o.e(r3, "bounds");
        super.onBoundsChange(r3);
        if (r3.width() >= r3.height()) goto L5;
        this.targetScale = r3.width() / getWrappedDrawable().getIntrinsicWidth();
        return;
    L5:
        this.targetScale = r3.height() / getWrappedDrawable().getIntrinsicHeight();
    }

    public final Matrix getIDENTITY() {
        return this.IDENTITY;
    }

    public void draw(Canvas r6) {
        o.e(r6, "canvas");
        if (getWrappedDrawable() != null) goto L5;
        return;
    L5:
        r6.save();
        r6.rotate(this.rotate, (getBounds().left + getBounds().right) / 2.0f, (getBounds().top + getBounds().bottom) / 2.0f);
        getWrappedDrawable().draw(r6);
        r6.restore();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        ValueAnimator r0 = this.valueAnimator;
        r0.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new LinearInterpolator(), TimeInterpolator.class, "com.obric.aiagent.plugin"));
        r0.setDuration(1000);
        r0.setRepeatMode(1);
        r0.setRepeatCount(-1);
        r0.addUpdateListener(new $$Lambda$RotatingDrawable$eJL8g1TzVxVmmTtWJ2PbXwIo9FQ(this));
        this.valueAnimator.start();
        this.isRunning = true;
    }

    /* JADX INFO: renamed from: start$lambda-1$lambda-0, reason: not valid java name */
    private static final void m1058start$lambda1$lambda0(RotatingDrawable r2, ValueAnimator r3) {
        RotatingDrawable r4 = (RotatingDrawable) ZeusTransformUtils.wrapperContextForParams(r2, RotatingDrawable.class, "com.obric.aiagent.plugin");
        o.e(r4, "this$0");
        o.e(r3, "it");
        Object r5 = r3.getAnimatedValue();
        Objects.requireNonNull(r5, "null cannot be cast to non-null type kotlin.Int");
        r4.rotate = ((Integer) ZeusTransformUtils.preCheckCast(r5, Integer.class, "com.obric.aiagent.plugin")).intValue();
        r4.invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.isRunning = false;
        ValueAnimator r1 = this.valueAnimator;
        r1.removeAllUpdateListeners();
        r1.cancel();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.isRunning;
    }
}
