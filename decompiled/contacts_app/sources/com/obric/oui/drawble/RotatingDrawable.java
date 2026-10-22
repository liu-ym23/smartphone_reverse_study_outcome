package com.obric.oui.drawble;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.LinearInterpolator;
import androidx.appcompat.graphics.drawable.DrawableWrapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RotatingDrawable.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u0017H\u0016J\b\u0010\u001e\u001a\u00020\u0017H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\n \u0015*\u0004\u0018\u00010\u00140\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/obric/oui/drawble/RotatingDrawable;", "Landroidx/appcompat/graphics/drawable/DrawableWrapper;", "Landroid/graphics/drawable/Animatable;", "drawable", "Landroid/graphics/drawable/Drawable;", "(Landroid/graphics/drawable/Drawable;)V", "IDENTITY", "Landroid/graphics/Matrix;", "getIDENTITY", "()Landroid/graphics/Matrix;", "isRunning", "", "rotate", "", "targetScale", "getTargetScale", "()F", "setTargetScale", "(F)V", "valueAnimator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "draw", "", "canvas", "Landroid/graphics/Canvas;", "onBoundsChange", "bounds", "Landroid/graphics/Rect;", "start", "stop", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class RotatingDrawable extends DrawableWrapper implements Animatable {
    private final Matrix IDENTITY;
    private boolean isRunning;
    private float rotate;
    private float targetScale;
    private final ValueAnimator valueAnimator;

    public static /* synthetic */ void $r8$lambda$eJL8g1TzVxVmmTtWJ2PbXwIo9FQ(RotatingDrawable r0, ValueAnimator r1) {
        m495start$lambda1$lambda0(r0, r1);
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

    protected void onBoundsChange(Rect r3) {
        Intrinsics.checkNotNullParameter(r3, "bounds");
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
        Intrinsics.checkNotNullParameter(r6, "canvas");
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
        r0.setInterpolator(new LinearInterpolator());
        r0.setDuration(1000);
        r0.setRepeatMode(1);
        r0.setRepeatCount(-1);
        r0.addUpdateListener(new RotatingDrawable$$ExternalSyntheticLambda0(this));
        this.valueAnimator.start();
        this.isRunning = true;
    }

    /* JADX INFO: renamed from: start$lambda-1$lambda-0, reason: not valid java name */
    private static final void m495start$lambda1$lambda0(RotatingDrawable r1, ValueAnimator r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "it");
        Object r3 = r2.getAnimatedValue();
        if (r3 == null) goto L7;
        r1.rotate = ((Integer) r3).intValue();
        r1.invalidateSelf();
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
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
