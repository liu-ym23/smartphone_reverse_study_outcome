package com.stepos.common.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.stepos.alphame.R;
import com.stepos.alphame.utils.Property;
import java.util.Locale;

/* loaded from: classes.dex */
public class InstallProgressBar extends View {

    /* renamed from: a, reason: collision with root package name */
    public Bitmap f11641a;

    /* renamed from: b, reason: collision with root package name */
    public Bitmap f11642b;

    /* renamed from: c, reason: collision with root package name */
    public final StateListDrawable f11643c;

    /* renamed from: d, reason: collision with root package name */
    public final StateListDrawable f11644d;

    /* renamed from: e, reason: collision with root package name */
    public final StateListDrawable f11645e;

    /* renamed from: f, reason: collision with root package name */
    public final Paint f11646f;

    /* renamed from: g, reason: collision with root package name */
    public float f11647g;

    /* renamed from: h, reason: collision with root package name */
    public int f11648h;

    /* renamed from: i, reason: collision with root package name */
    public int f11649i;

    /* renamed from: j, reason: collision with root package name */
    public int f11650j;

    public InstallProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11647g = -1.0f;
        this.f11649i = 0;
        this.f11648h = 100;
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.f11643c = stateListDrawable;
        stateListDrawable.addState(new int[0], getResources().getDrawable(R.drawable.mc_round_button_normal));
        StateListDrawable stateListDrawable2 = new StateListDrawable();
        this.f11644d = stateListDrawable2;
        stateListDrawable2.addState(new int[0], getResources().getDrawable(R.drawable.mc_button_normal));
        StateListDrawable stateListDrawable3 = new StateListDrawable();
        this.f11645e = stateListDrawable3;
        stateListDrawable3.addState(new int[0], getResources().getDrawable(R.drawable.mc_install_progress_bg_normal));
        Paint paint = new Paint();
        this.f11646f = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
    }

    public static Bitmap b(StateListDrawable stateListDrawable, int i4, int i5) {
        if (i4 == 0) {
            i4 = 1;
        }
        if (i5 == 0) {
            i5 = 1;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i4, i5, stateListDrawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        stateListDrawable.setBounds(0, 0, i4, i5);
        stateListDrawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    public final void a(Canvas canvas, boolean z4) {
        float measuredWidth = z4 ? getMeasuredWidth() : (getProgress() / getMaxProgress()) * getMeasuredWidth();
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
            canvas.drawBitmap(this.f11642b, getMeasuredWidth() - measuredWidth, Property.DEFAULT_FLOAT_VALUE, this.f11646f);
        } else {
            canvas.drawBitmap(this.f11642b, measuredWidth - getMeasuredWidth(), Property.DEFAULT_FLOAT_VALUE, this.f11646f);
        }
        canvas.restore();
    }

    public int getMaxProgress() {
        return this.f11648h;
    }

    public int getMinProgress() {
        return this.f11649i;
    }

    public float getProgress() {
        return this.f11647g;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        canvas.saveLayer(Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, getMeasuredWidth(), getMeasuredHeight(), null, 31);
        canvas.drawBitmap(this.f11641a, Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, (Paint) null);
        float f4 = this.f11647g;
        if (f4 < this.f11649i || f4 > this.f11648h) {
            a(canvas, true);
        } else {
            a(canvas, false);
        }
    }

    @Override // android.view.View
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        super.onLayout(z4, i4, i5, i6, i7);
        if (getMeasuredWidth() != this.f11650j) {
            this.f11641a = null;
            this.f11642b = null;
        }
        if (this.f11641a == null) {
            this.f11641a = b(this.f11643c, getMeasuredWidth(), getMeasuredHeight());
            this.f11650j = getMeasuredWidth();
        }
        if (this.f11642b == null) {
            this.f11642b = b(this.f11645e, getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public synchronized void setAnimProgress(float f4) {
        float f5 = this.f11647g;
        (f4 < f5 ? ObjectAnimator.ofFloat(this, "Progress", Property.DEFAULT_FLOAT_VALUE, f4).setDuration(500L) : ObjectAnimator.ofFloat(this, "Progress", f5, f4).setDuration(500L)).start();
    }

    public void setMaxProgress(int i4) {
        this.f11648h = i4;
    }

    public void setMinProgress(int i4) {
        this.f11649i = i4;
    }

    public synchronized void setProgress(float f4) {
        if (f4 < Property.DEFAULT_FLOAT_VALUE) {
            f4 = 0.0f;
        }
        int i4 = this.f11648h;
        if (f4 > i4) {
            f4 = i4;
        }
        if (Math.abs(f4 - this.f11647g) > 1.0E-6f) {
            this.f11647g = f4;
            invalidate();
        }
    }

    public void setProgressBackColor(int i4) {
        StateListDrawable stateListDrawable = this.f11644d;
        if (stateListDrawable == null || i4 == 0) {
            return;
        }
        ((GradientDrawable) ((DrawableContainer.DrawableContainerState) stateListDrawable.getConstantState()).getChild(0)).setColor(i4);
        ((GradientDrawable) ((DrawableContainer.DrawableContainerState) this.f11643c.getConstantState()).getChild(0)).setColor(i4);
        if (getMeasuredWidth() != 0 && getMeasuredHeight() != 0) {
            Bitmap bitmap = this.f11641a;
            if (bitmap != null) {
                bitmap.recycle();
            }
            this.f11641a = b(this.f11643c, getMeasuredWidth(), getMeasuredHeight());
        }
        invalidate();
    }

    public void setRoundBtnColor(int i4) {
        StateListDrawable stateListDrawable = this.f11645e;
        if (stateListDrawable == null || i4 == 0) {
            return;
        }
        ((GradientDrawable) ((DrawableContainer.DrawableContainerState) stateListDrawable.getConstantState()).getChild(0)).setColor(i4);
        if (getMeasuredWidth() != 0 && getMeasuredHeight() != 0) {
            Bitmap bitmap = this.f11642b;
            if (bitmap != null) {
                bitmap.recycle();
            }
            this.f11642b = b(this.f11645e, getMeasuredWidth(), getMeasuredHeight());
        }
        invalidate();
    }

    public void setRoundRadius(float f4) {
        ((GradientDrawable) ((DrawableContainer.DrawableContainerState) this.f11643c.getConstantState()).getChild(0)).setCornerRadius(TypedValue.applyDimension(0, f4, getContext().getResources().getDisplayMetrics()));
    }
}
