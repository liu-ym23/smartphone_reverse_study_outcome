package com.stepos.common.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.stepos.common.R$drawable;
import java.util.Locale;

/* loaded from: classes3.dex */
public class InstallProgressBar extends View {
    private static final float FLOAT_ESPINON = 1.0E-6f;
    private int mMaxProgress;
    private int mMinProgress;
    private Bitmap mNormalBitmap;
    private ObjectAnimator mObjectAnimator;
    private float mProgress;
    private StateListDrawable mProgressBgDrawable;
    private Bitmap mProgressBitmap;
    private Paint mProgressPaint;
    private StateListDrawable mProgressSolidDrawable;
    private StateListDrawable mSecondProgressBgDrawable;
    private boolean mUseSecondStyle;
    private int mWidth;

    public InstallProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mProgress = -1.0f;
        this.mUseSecondStyle = false;
        g();
    }

    public static boolean a(float f10, float f11) {
        return Math.abs(f10 - f11) <= FLOAT_ESPINON;
    }

    public final void b(Canvas canvas, boolean z10) {
        float measuredWidth = z10 ? getMeasuredWidth() : (getProgress() / getMaxProgress()) * getMeasuredWidth();
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
            canvas.drawBitmap(this.mProgressBitmap, getMeasuredWidth() - measuredWidth, 0.0f, this.mProgressPaint);
        } else {
            canvas.drawBitmap(this.mProgressBitmap, measuredWidth - getMeasuredWidth(), 0.0f, this.mProgressPaint);
        }
        canvas.restore();
    }

    public final void c(Canvas canvas) {
        canvas.saveLayer(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), null, 31);
        canvas.drawBitmap(this.mNormalBitmap, 0.0f, 0.0f, (Paint) null);
    }

    public final Bitmap d(StateListDrawable stateListDrawable, int i10, int i11) {
        if (i10 == 0) {
            i10 = 1;
        }
        if (i11 == 0) {
            i11 = 1;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i10, i11, stateListDrawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        stateListDrawable.setBounds(0, 0, i10, i11);
        stateListDrawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    public final Drawable e(int i10) {
        return getResources().getDrawable(i10);
    }

    public final ObjectAnimator f(float f10) {
        float f11 = this.mProgress;
        return f10 < f11 ? ObjectAnimator.ofFloat(this, "Progress", 0.0f, f10).setDuration(500L) : ObjectAnimator.ofFloat(this, "Progress", f11, f10).setDuration(500L);
    }

    public final void g() {
        this.mMinProgress = 0;
        this.mMaxProgress = 100;
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.mProgressBgDrawable = stateListDrawable;
        stateListDrawable.addState(new int[0], e(R$drawable.mc_round_button_normal));
        StateListDrawable stateListDrawable2 = new StateListDrawable();
        this.mSecondProgressBgDrawable = stateListDrawable2;
        stateListDrawable2.addState(new int[0], e(R$drawable.mc_button_normal));
        StateListDrawable stateListDrawable3 = new StateListDrawable();
        this.mProgressSolidDrawable = stateListDrawable3;
        stateListDrawable3.addState(new int[0], e(R$drawable.mc_install_progress_bg_normal));
        Paint paint = new Paint();
        this.mProgressPaint = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
    }

    public int getMaxProgress() {
        return this.mMaxProgress;
    }

    public int getMinProgress() {
        return this.mMinProgress;
    }

    public float getProgress() {
        return this.mProgress;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        c(canvas);
        float f10 = this.mProgress;
        if (f10 < this.mMinProgress || f10 > this.mMaxProgress) {
            b(canvas, true);
        } else {
            b(canvas, false);
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (getMeasuredWidth() != this.mWidth) {
            this.mNormalBitmap = null;
            this.mProgressBitmap = null;
        }
        if (this.mNormalBitmap == null) {
            if (this.mUseSecondStyle) {
                this.mNormalBitmap = d(this.mSecondProgressBgDrawable, getMeasuredWidth(), getMeasuredHeight());
            } else {
                this.mNormalBitmap = d(this.mProgressBgDrawable, getMeasuredWidth(), getMeasuredHeight());
            }
            this.mWidth = getMeasuredWidth();
        }
        if (this.mProgressBitmap == null) {
            this.mProgressBitmap = d(this.mProgressSolidDrawable, getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public synchronized void setAnimProgress(float f10) {
        ObjectAnimator objectAnimatorF = f(f10);
        this.mObjectAnimator = objectAnimatorF;
        objectAnimatorF.start();
    }

    public void setMaxProgress(int i10) {
        this.mMaxProgress = i10;
    }

    public void setMinProgress(int i10) {
        this.mMinProgress = i10;
    }

    public synchronized void setProgress(float f10) {
        if (f10 < 0.0f) {
            f10 = 0.0f;
        }
        int i10 = this.mMaxProgress;
        if (f10 > i10) {
            f10 = i10;
        }
        if (!a(f10, this.mProgress)) {
            this.mProgress = f10;
            invalidate();
        }
    }

    public void setProgressBackColor(int i10) {
        StateListDrawable stateListDrawable = this.mSecondProgressBgDrawable;
        if (stateListDrawable == null || i10 == 0) {
            return;
        }
        ((GradientDrawable) ((DrawableContainer.DrawableContainerState) stateListDrawable.getConstantState()).getChild(0)).setColor(i10);
        ((GradientDrawable) ((DrawableContainer.DrawableContainerState) this.mProgressBgDrawable.getConstantState()).getChild(0)).setColor(i10);
        if (getMeasuredWidth() != 0 && getMeasuredHeight() != 0) {
            Bitmap bitmap = this.mNormalBitmap;
            if (bitmap != null) {
                bitmap.recycle();
            }
            if (this.mUseSecondStyle) {
                this.mNormalBitmap = d(this.mSecondProgressBgDrawable, getMeasuredWidth(), getMeasuredHeight());
            } else {
                this.mNormalBitmap = d(this.mProgressBgDrawable, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        invalidate();
    }

    public void setRoundBtnColor(int i10) {
        StateListDrawable stateListDrawable = this.mProgressSolidDrawable;
        if (stateListDrawable == null || i10 == 0) {
            return;
        }
        ((GradientDrawable) ((DrawableContainer.DrawableContainerState) stateListDrawable.getConstantState()).getChild(0)).setColor(i10);
        if (getMeasuredWidth() != 0 && getMeasuredHeight() != 0) {
            Bitmap bitmap = this.mProgressBitmap;
            if (bitmap != null) {
                bitmap.recycle();
            }
            this.mProgressBitmap = d(this.mProgressSolidDrawable, getMeasuredWidth(), getMeasuredHeight());
        }
        invalidate();
    }

    public void setRoundRadius(float f10) {
        ((GradientDrawable) ((DrawableContainer.DrawableContainerState) this.mProgressBgDrawable.getConstantState()).getChild(0)).setCornerRadius(TypedValue.applyDimension(0, f10, getContext().getResources().getDisplayMetrics()));
    }
}
