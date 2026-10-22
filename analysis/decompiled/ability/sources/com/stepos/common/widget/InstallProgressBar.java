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
import com.stepos.ability.R;
import java.util.Locale;

/* loaded from: classes3.dex */
public class InstallProgressBar extends View {

    /* renamed from: a, reason: collision with root package name */
    public Bitmap f3714a;
    public Bitmap b;
    public final StateListDrawable c;
    public final StateListDrawable d;
    public final StateListDrawable e;
    public final Paint f;
    public float g;
    public int h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public int f3715j;

    public InstallProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = -1.0f;
        this.i = 0;
        this.h = 100;
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.c = stateListDrawable;
        stateListDrawable.addState(new int[0], getResources().getDrawable(R.drawable.mc_round_button_normal));
        StateListDrawable stateListDrawable2 = new StateListDrawable();
        this.d = stateListDrawable2;
        stateListDrawable2.addState(new int[0], getResources().getDrawable(R.drawable.mc_button_normal));
        StateListDrawable stateListDrawable3 = new StateListDrawable();
        this.e = stateListDrawable3;
        stateListDrawable3.addState(new int[0], getResources().getDrawable(R.drawable.mc_install_progress_bg_normal));
        Paint paint = new Paint();
        this.f = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
    }

    public static Bitmap b(StateListDrawable stateListDrawable, int i, int i6) {
        if (i == 0) {
            i = 1;
        }
        if (i6 == 0) {
            i6 = 1;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i6, stateListDrawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        stateListDrawable.setBounds(0, 0, i, i6);
        stateListDrawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    public final void a(Canvas canvas, boolean z10) {
        float measuredWidth = z10 ? getMeasuredWidth() : (getProgress() / getMaxProgress()) * getMeasuredWidth();
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
            canvas.drawBitmap(this.b, getMeasuredWidth() - measuredWidth, 0.0f, this.f);
        } else {
            canvas.drawBitmap(this.b, measuredWidth - getMeasuredWidth(), 0.0f, this.f);
        }
        canvas.restore();
    }

    public int getMaxProgress() {
        return this.h;
    }

    public int getMinProgress() {
        return this.i;
    }

    public float getProgress() {
        return this.g;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        canvas.saveLayer(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), null, 31);
        canvas.drawBitmap(this.f3714a, 0.0f, 0.0f, (Paint) null);
        float f = this.g;
        if (f < this.i || f > this.h) {
            a(canvas, true);
        } else {
            a(canvas, false);
        }
    }

    @Override // android.view.View
    public final void onLayout(boolean z10, int i, int i6, int i10, int i11) {
        super.onLayout(z10, i, i6, i10, i11);
        if (getMeasuredWidth() != this.f3715j) {
            this.f3714a = null;
            this.b = null;
        }
        if (this.f3714a == null) {
            this.f3714a = b(this.c, getMeasuredWidth(), getMeasuredHeight());
            this.f3715j = getMeasuredWidth();
        }
        if (this.b == null) {
            this.b = b(this.e, getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public synchronized void setAnimProgress(float f) {
        float f7 = this.g;
        (f < f7 ? ObjectAnimator.ofFloat(this, "Progress", 0.0f, f).setDuration(500L) : ObjectAnimator.ofFloat(this, "Progress", f7, f).setDuration(500L)).start();
    }

    public void setMaxProgress(int i) {
        this.h = i;
    }

    public void setMinProgress(int i) {
        this.i = i;
    }

    public synchronized void setProgress(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        int i = this.h;
        if (f > i) {
            f = i;
        }
        if (!(Math.abs(f - this.g) <= 1.0E-6f)) {
            this.g = f;
            invalidate();
        }
    }

    public void setProgressBackColor(int i) {
        StateListDrawable stateListDrawable = this.d;
        if (stateListDrawable == null || i == 0) {
            return;
        }
        ((GradientDrawable) ((DrawableContainer.DrawableContainerState) stateListDrawable.getConstantState()).getChild(0)).setColor(i);
        ((GradientDrawable) ((DrawableContainer.DrawableContainerState) this.c.getConstantState()).getChild(0)).setColor(i);
        if (getMeasuredWidth() != 0 && getMeasuredHeight() != 0) {
            Bitmap bitmap = this.f3714a;
            if (bitmap != null) {
                bitmap.recycle();
            }
            this.f3714a = b(this.c, getMeasuredWidth(), getMeasuredHeight());
        }
        invalidate();
    }

    public void setRoundBtnColor(int i) {
        StateListDrawable stateListDrawable = this.e;
        if (stateListDrawable == null || i == 0) {
            return;
        }
        ((GradientDrawable) ((DrawableContainer.DrawableContainerState) stateListDrawable.getConstantState()).getChild(0)).setColor(i);
        if (getMeasuredWidth() != 0 && getMeasuredHeight() != 0) {
            Bitmap bitmap = this.b;
            if (bitmap != null) {
                bitmap.recycle();
            }
            this.b = b(this.e, getMeasuredWidth(), getMeasuredHeight());
        }
        invalidate();
    }

    public void setRoundRadius(float f) {
        ((GradientDrawable) ((DrawableContainer.DrawableContainerState) this.c.getConstantState()).getChild(0)).setCornerRadius(TypedValue.applyDimension(0, f, getContext().getResources().getDisplayMetrics()));
    }
}
