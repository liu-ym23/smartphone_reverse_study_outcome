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
import com.stepos.aiengine.R;
import java.util.Locale;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class InstallProgressBar extends View {

    /* renamed from: a, reason: collision with root package name */
    public Bitmap f6916a;

    /* renamed from: b, reason: collision with root package name */
    public Bitmap f6917b;

    /* renamed from: c, reason: collision with root package name */
    public final StateListDrawable f6918c;

    /* renamed from: d, reason: collision with root package name */
    public final StateListDrawable f6919d;

    /* renamed from: e, reason: collision with root package name */
    public final StateListDrawable f6920e;
    public final Paint h;

    /* renamed from: j, reason: collision with root package name */
    public float f6921j;

    /* renamed from: k, reason: collision with root package name */
    public int f6922k;

    /* renamed from: l, reason: collision with root package name */
    public int f6923l;

    /* renamed from: m, reason: collision with root package name */
    public int f6924m;

    public InstallProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6921j = -1.0f;
        this.f6923l = 0;
        this.f6922k = 100;
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.f6918c = stateListDrawable;
        stateListDrawable.addState(new int[0], getResources().getDrawable(R.drawable.mc_round_button_normal));
        StateListDrawable stateListDrawable2 = new StateListDrawable();
        this.f6919d = stateListDrawable2;
        stateListDrawable2.addState(new int[0], getResources().getDrawable(R.drawable.mc_button_normal));
        StateListDrawable stateListDrawable3 = new StateListDrawable();
        this.f6920e = stateListDrawable3;
        stateListDrawable3.addState(new int[0], getResources().getDrawable(R.drawable.mc_install_progress_bg_normal));
        Paint paint = new Paint();
        this.h = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
    }

    public static Bitmap b(StateListDrawable stateListDrawable, int i10, int i11) {
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

    public final void a(Canvas canvas, boolean z) {
        float measuredWidth = z ? getMeasuredWidth() : (getProgress() / getMaxProgress()) * getMeasuredWidth();
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
            canvas.drawBitmap(this.f6917b, getMeasuredWidth() - measuredWidth, 0.0f, this.h);
        } else {
            canvas.drawBitmap(this.f6917b, measuredWidth - getMeasuredWidth(), 0.0f, this.h);
        }
        canvas.restore();
    }

    public int getMaxProgress() {
        return this.f6922k;
    }

    public int getMinProgress() {
        return this.f6923l;
    }

    public float getProgress() {
        return this.f6921j;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        canvas.saveLayer(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), null, 31);
        canvas.drawBitmap(this.f6916a, 0.0f, 0.0f, (Paint) null);
        float f8 = this.f6921j;
        if (f8 < this.f6923l || f8 > this.f6922k) {
            a(canvas, true);
        } else {
            a(canvas, false);
        }
    }

    @Override // android.view.View
    public final void onLayout(boolean z, int i10, int i11, int i12, int i13) {
        super.onLayout(z, i10, i11, i12, i13);
        if (getMeasuredWidth() != this.f6924m) {
            this.f6916a = null;
            this.f6917b = null;
        }
        if (this.f6916a == null) {
            this.f6916a = b(this.f6918c, getMeasuredWidth(), getMeasuredHeight());
            this.f6924m = getMeasuredWidth();
        }
        if (this.f6917b == null) {
            this.f6917b = b(this.f6920e, getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public synchronized void setAnimProgress(float f8) {
        float f9 = this.f6921j;
        (f8 < f9 ? ObjectAnimator.ofFloat(this, "Progress", 0.0f, f8).setDuration(500L) : ObjectAnimator.ofFloat(this, "Progress", f9, f8).setDuration(500L)).start();
    }

    public void setMaxProgress(int i10) {
        this.f6922k = i10;
    }

    public void setMinProgress(int i10) {
        this.f6923l = i10;
    }

    public synchronized void setProgress(float f8) {
        if (f8 < 0.0f) {
            f8 = 0.0f;
        }
        int i10 = this.f6922k;
        if (f8 > i10) {
            f8 = i10;
        }
        if (!(Math.abs(f8 - this.f6921j) <= 1.0E-6f)) {
            this.f6921j = f8;
            invalidate();
        }
    }

    public void setProgressBackColor(int i10) {
        StateListDrawable stateListDrawable = this.f6919d;
        if (stateListDrawable == null || i10 == 0) {
            return;
        }
        ((GradientDrawable) ((DrawableContainer.DrawableContainerState) stateListDrawable.getConstantState()).getChild(0)).setColor(i10);
        ((GradientDrawable) ((DrawableContainer.DrawableContainerState) this.f6918c.getConstantState()).getChild(0)).setColor(i10);
        if (getMeasuredWidth() != 0 && getMeasuredHeight() != 0) {
            Bitmap bitmap = this.f6916a;
            if (bitmap != null) {
                bitmap.recycle();
            }
            this.f6916a = b(this.f6918c, getMeasuredWidth(), getMeasuredHeight());
        }
        invalidate();
    }

    public void setRoundBtnColor(int i10) {
        StateListDrawable stateListDrawable = this.f6920e;
        if (stateListDrawable == null || i10 == 0) {
            return;
        }
        ((GradientDrawable) ((DrawableContainer.DrawableContainerState) stateListDrawable.getConstantState()).getChild(0)).setColor(i10);
        if (getMeasuredWidth() != 0 && getMeasuredHeight() != 0) {
            Bitmap bitmap = this.f6917b;
            if (bitmap != null) {
                bitmap.recycle();
            }
            this.f6917b = b(this.f6920e, getMeasuredWidth(), getMeasuredHeight());
        }
        invalidate();
    }

    public void setRoundRadius(float f8) {
        ((GradientDrawable) ((DrawableContainer.DrawableContainerState) this.f6918c.getConstantState()).getChild(0)).setCornerRadius(TypedValue.applyDimension(0, f8, getContext().getResources().getDisplayMetrics()));
    }
}
