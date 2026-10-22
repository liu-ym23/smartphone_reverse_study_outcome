package com.stepos.common.scrollbarview;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

/* loaded from: classes3.dex */
public class b extends Drawable implements Drawable.Callback {
    private static final boolean DEBUG = false;
    private static final int OPAQUE = 255;
    private static final String TAG = "StepOSSScrollBarView";
    private int mAbsTranslation;
    private int mAlpha = OPAQUE;
    private boolean mAlwaysDrawHorizontalTrack;
    private boolean mAlwaysDrawVerticalTrack;
    private boolean mBoundsChanged;
    private ColorFilter mColorFilter;
    private int mExtent;
    private boolean mHasSetAlpha;
    private boolean mHasSetColorFilter;
    private Drawable mHorizontalThumbDrawable;
    private Drawable mHorizontalTrackDrawable;
    private boolean mMutated;
    private int mOffset;
    private a mProxy;
    private int mRange;
    private boolean mRangeChanged;
    private int mThumbOffset;
    private final boolean mVertical;
    private Drawable mVerticalThumbDrawable;
    private Drawable mVerticalTrackDrawable;

    public b(boolean z10, a aVar) {
        this.mVertical = z10;
        this.mProxy = aVar;
    }

    public final void a(Canvas canvas, Rect rect, int i10) {
        boolean z10 = this.mRangeChanged || this.mBoundsChanged;
        boolean z11 = this.mVertical;
        Drawable drawable = z11 ? this.mVerticalThumbDrawable : this.mHorizontalThumbDrawable;
        if (drawable == null) {
            return;
        }
        if (z10) {
            if (z11) {
                int i11 = rect.left;
                int i12 = rect.top;
                int i13 = this.mThumbOffset;
                drawable.setBounds(i11, i12 + i13, rect.right, i12 + i13 + i10);
            } else {
                int i14 = rect.left;
                int i15 = this.mThumbOffset;
                drawable.setBounds(i14 + i15, rect.top, i14 + i15 + i10, rect.bottom);
            }
            if (drawable instanceof GradientDrawable) {
                ((GradientDrawable) drawable).setCornerRadius(this.mVertical ? drawable.getBounds().width() / 2 : drawable.getBounds().height() / 2);
            }
        }
        drawable.draw(canvas);
    }

    public final void b(Canvas canvas, Rect rect) {
        Drawable drawable = this.mVertical ? this.mVerticalTrackDrawable : this.mHorizontalTrackDrawable;
        if (drawable != null) {
            if (this.mBoundsChanged) {
                drawable.setBounds(rect);
            }
            if (drawable instanceof GradientDrawable) {
                ((GradientDrawable) drawable).setCornerRadius(this.mVertical ? drawable.getBounds().width() / 2 : drawable.getBounds().height() / 2);
            }
            drawable.draw(canvas);
        }
    }

    public Drawable c() {
        return this.mVertical ? this.mVerticalThumbDrawable : this.mHorizontalThumbDrawable;
    }

    public int d() {
        return this.mThumbOffset;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z10;
        boolean z11;
        int i10 = this.mExtent;
        int i11 = this.mRange;
        if (i10 <= 0 || i11 <= this.mProxy.a() * i10) {
            z10 = this.mVertical ? this.mAlwaysDrawVerticalTrack : this.mAlwaysDrawHorizontalTrack;
            z11 = false;
        } else {
            z10 = true;
            z11 = true;
        }
        Rect bounds = getBounds();
        if (canvas.quickReject(bounds.left, bounds.top, bounds.right, bounds.bottom)) {
            return;
        }
        if (z10) {
            b(canvas, bounds);
        }
        if (z11) {
            int iHeight = this.mVertical ? bounds.height() : bounds.width();
            int iC = this.mProxy.c(iHeight, this.mVertical ? bounds.width() : bounds.height(), i10, i11, this.mAbsTranslation);
            this.mThumbOffset = this.mProxy.d(iHeight, iC, i10, i11, this.mOffset, this.mAbsTranslation);
            a(canvas, bounds, iC);
        }
    }

    @Override // android.graphics.drawable.Drawable
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public b mutate() {
        if (!this.mMutated && super.mutate() == this) {
            Drawable drawable = this.mVerticalTrackDrawable;
            if (drawable != null) {
                drawable.mutate();
            }
            Drawable drawable2 = this.mVerticalThumbDrawable;
            if (drawable2 != null) {
                drawable2.mutate();
            }
            Drawable drawable3 = this.mHorizontalTrackDrawable;
            if (drawable3 != null) {
                drawable3.mutate();
            }
            Drawable drawable4 = this.mHorizontalThumbDrawable;
            if (drawable4 != null) {
                drawable4.mutate();
            }
            this.mMutated = true;
        }
        return this;
    }

    public final void f(Drawable drawable) {
        if (drawable != null) {
            if (this.mMutated) {
                drawable.mutate();
            }
            drawable.setState(getState());
            drawable.setCallback(this);
            if (this.mHasSetAlpha) {
                drawable.setAlpha(this.mAlpha);
            }
            if (this.mHasSetColorFilter) {
                drawable.setColorFilter(this.mColorFilter);
            }
        }
    }

    public void g(boolean z10) {
        this.mAlwaysDrawVerticalTrack = z10;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mAlpha;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.mColorFilter;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public void h(int i10, int i11, int i12, int i13) {
        if (this.mRange == i10 && this.mOffset == i11 && this.mExtent == i12 && this.mAbsTranslation == i13) {
            return;
        }
        this.mRange = i10;
        this.mOffset = i11;
        this.mExtent = i12;
        this.mAbsTranslation = i13;
        this.mRangeChanged = true;
    }

    public void i(a aVar) {
        this.mProxy = aVar;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable drawable = this.mVerticalTrackDrawable;
        if (drawable != null && drawable.isStateful()) {
            return true;
        }
        Drawable drawable2 = this.mVerticalThumbDrawable;
        if (drawable2 != null && drawable2.isStateful()) {
            return true;
        }
        Drawable drawable3 = this.mHorizontalTrackDrawable;
        if (drawable3 != null && drawable3.isStateful()) {
            return true;
        }
        Drawable drawable4 = this.mHorizontalThumbDrawable;
        return (drawable4 != null && drawable4.isStateful()) || super.isStateful();
    }

    public void j(int i10) {
        Rect bounds = getBounds();
        if (this.mVertical) {
            int i11 = bounds.right;
            setBounds(i11 - i10, bounds.top, i11, bounds.bottom);
        } else {
            int i12 = bounds.left;
            int i13 = bounds.bottom;
            setBounds(i12, i13 - i10, bounds.right, i13);
        }
    }

    public void k(Drawable drawable) {
        if (this.mVertical) {
            Drawable drawable2 = this.mVerticalThumbDrawable;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            f(drawable);
            this.mVerticalThumbDrawable = drawable;
            return;
        }
        Drawable drawable3 = this.mHorizontalThumbDrawable;
        if (drawable3 != null) {
            drawable3.setCallback(null);
        }
        f(drawable);
        this.mHorizontalThumbDrawable = drawable;
    }

    public void l(Drawable drawable) {
        if (this.mVertical) {
            Drawable drawable2 = this.mVerticalTrackDrawable;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            f(drawable);
            this.mVerticalTrackDrawable = drawable;
            return;
        }
        Drawable drawable3 = this.mHorizontalTrackDrawable;
        if (drawable3 != null) {
            drawable3.setCallback(null);
        }
        f(drawable);
        this.mHorizontalTrackDrawable = drawable;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.mBoundsChanged = true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean zOnStateChange = super.onStateChange(iArr);
        Drawable drawable = this.mVerticalTrackDrawable;
        if (drawable != null) {
            zOnStateChange |= drawable.setState(iArr);
        }
        Drawable drawable2 = this.mVerticalThumbDrawable;
        if (drawable2 != null) {
            zOnStateChange |= drawable2.setState(iArr);
        }
        Drawable drawable3 = this.mHorizontalTrackDrawable;
        if (drawable3 != null) {
            zOnStateChange |= drawable3.setState(iArr);
        }
        Drawable drawable4 = this.mHorizontalThumbDrawable;
        return drawable4 != null ? drawable4.setState(iArr) | zOnStateChange : zOnStateChange;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
        scheduleSelf(runnable, j10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.mAlpha = i10;
        this.mHasSetAlpha = true;
        Drawable drawable = this.mVerticalTrackDrawable;
        if (drawable != null) {
            drawable.setAlpha(i10);
        }
        Drawable drawable2 = this.mVerticalThumbDrawable;
        if (drawable2 != null) {
            drawable2.setAlpha(i10);
        }
        Drawable drawable3 = this.mHorizontalTrackDrawable;
        if (drawable3 != null) {
            drawable3.setAlpha(i10);
        }
        Drawable drawable4 = this.mHorizontalThumbDrawable;
        if (drawable4 != null) {
            drawable4.setAlpha(i10);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mColorFilter = colorFilter;
        this.mHasSetColorFilter = true;
        Drawable drawable = this.mVerticalTrackDrawable;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
        Drawable drawable2 = this.mVerticalThumbDrawable;
        if (drawable2 != null) {
            drawable2.setColorFilter(colorFilter);
        }
        Drawable drawable3 = this.mHorizontalTrackDrawable;
        if (drawable3 != null) {
            drawable3.setColorFilter(colorFilter);
        }
        Drawable drawable4 = this.mHorizontalThumbDrawable;
        if (drawable4 != null) {
            drawable4.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i10, int i11, int i12, int i13) {
        super.setHotspotBounds(i10, i11, i12, i13);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("ScrollBarDrawable: range=");
        sb2.append(this.mRange);
        sb2.append(" offset=");
        sb2.append(this.mOffset);
        sb2.append(" extent=");
        sb2.append(this.mExtent);
        sb2.append(",direction:");
        sb2.append(this.mVertical ? "vertical" : "horizontal");
        return sb2.toString();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
