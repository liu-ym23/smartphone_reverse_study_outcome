package p1;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import g.x0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class d extends x0 {

    /* renamed from: q, reason: collision with root package name */
    public Drawable f4698q;

    /* renamed from: r, reason: collision with root package name */
    public final Rect f4699r;

    /* renamed from: s, reason: collision with root package name */
    public final Rect f4700s;

    /* renamed from: t, reason: collision with root package name */
    public int f4701t;

    /* renamed from: u, reason: collision with root package name */
    public final boolean f4702u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f4703v;

    public d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f4699r = new Rect();
        this.f4700s = new Rect();
        this.f4701t = 119;
        this.f4702u = true;
        this.f4703v = false;
        k.a(context, attributeSet, 0, 0);
        int[] iArr = d1.a.f1766h;
        k.b(context, attributeSet, iArr, 0, 0, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
        this.f4701t = typedArrayObtainStyledAttributes.getInt(1, this.f4701t);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(0);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.f4702u = typedArrayObtainStyledAttributes.getBoolean(2, true);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.f4698q;
        if (drawable != null) {
            if (this.f4703v) {
                this.f4703v = false;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                boolean z = this.f4702u;
                Rect rect = this.f4699r;
                if (z) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                int i8 = this.f4701t;
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = drawable.getIntrinsicHeight();
                Rect rect2 = this.f4700s;
                Gravity.apply(i8, intrinsicWidth, intrinsicHeight, rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    @Override // android.view.View
    public final void drawableHotspotChanged(float f3, float f7) {
        super.drawableHotspotChanged(f3, f7);
        Drawable drawable = this.f4698q;
        if (drawable != null) {
            drawable.setHotspot(f3, f7);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f4698q;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        this.f4698q.setState(getDrawableState());
    }

    @Override // android.view.View
    public Drawable getForeground() {
        return this.f4698q;
    }

    @Override // android.view.View
    public int getForegroundGravity() {
        return this.f4701t;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f4698q;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // g.x0, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i8, int i9, int i10, int i11) {
        super.onLayout(z, i8, i9, i10, i11);
        this.f4703v = z | this.f4703v;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i8, int i9, int i10, int i11) {
        super.onSizeChanged(i8, i9, i10, i11);
        this.f4703v = true;
    }

    @Override // android.view.View
    public void setForeground(Drawable drawable) {
        Drawable drawable2 = this.f4698q;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.f4698q);
            }
            this.f4698q = drawable;
            this.f4703v = true;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.f4701t == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public void setForegroundGravity(int i8) {
        if (this.f4701t != i8) {
            if ((8388615 & i8) == 0) {
                i8 |= 8388611;
            }
            if ((i8 & 112) == 0) {
                i8 |= 48;
            }
            this.f4701t = i8;
            if (i8 == 119 && this.f4698q != null) {
                this.f4698q.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f4698q;
    }
}
