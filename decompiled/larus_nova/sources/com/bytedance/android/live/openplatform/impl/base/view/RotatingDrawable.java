package com.bytedance.android.live.openplatform.impl.base.view;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.LinearInterpolator;
import androidx.appcompat.graphics.drawable.DrawableWrapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/base/view/RotatingDrawable;", "Landroidx/appcompat/graphics/drawable/DrawableWrapper;", "Landroid/graphics/drawable/Animatable;", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class RotatingDrawable extends DrawableWrapper implements Animatable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f84095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ValueAnimator f84096b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f84097c;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RotatingDrawable f84098a;

        public a(RotatingDrawable r100) {
            this.f84098a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            RotatingDrawable r101 = this.f84098a;
            Object r102 = r100.getAnimatedValue();
            if (r102 == null) goto L7;
            r101.f84095a = ((Integer) r102).intValue();
            this.f84098a.invalidateSelf();
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        this.f84097c = false;
        ValueAnimator r100 = this.f84096b;
        r100.removeAllUpdateListeners();
        r100.cancel();
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        ValueAnimator r100 = this.f84096b;
        r100.setInterpolator(new LinearInterpolator());
        r100.setDuration(1000);
        r100.setRepeatMode(1);
        r100.setRepeatCount(-1);
        r100.addUpdateListener(new a(this));
        this.f84096b.start();
        this.f84097c = true;
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        return this.f84097c;
    }

    public RotatingDrawable(Drawable r100) {
        super(r100);
        this.f84096b = ValueAnimator.ofInt(new int[]{0, 360});
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (getWrappedDrawable() != null) goto L5;
        return;
    L5:
        r100.save();
        r100.rotate(this.f84095a, (getBounds().left + getBounds().right) / 2.0f, (getBounds().top + getBounds().bottom) / 2.0f);
        getWrappedDrawable().draw(r100);
        r100.restore();
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "bounds");
        super.onBoundsChange(r100);
        if (r100.width() >= r100.height()) goto L5;
        r100.width();
        getWrappedDrawable().getIntrinsicWidth();
        return;
    L5:
        r100.height();
        getWrappedDrawable().getIntrinsicHeight();
    }
}
