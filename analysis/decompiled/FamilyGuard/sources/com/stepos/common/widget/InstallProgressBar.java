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
import java.util.Locale;

/* loaded from: classes.dex */
public class InstallProgressBar extends View {

    /* renamed from: a, reason: collision with root package name */
    private Bitmap f13998a;

    /* renamed from: b, reason: collision with root package name */
    private Bitmap f13999b;

    /* renamed from: c, reason: collision with root package name */
    private StateListDrawable f14000c;

    /* renamed from: d, reason: collision with root package name */
    private StateListDrawable f14001d;

    /* renamed from: e, reason: collision with root package name */
    private StateListDrawable f14002e;

    /* renamed from: f, reason: collision with root package name */
    private Paint f14003f;

    /* renamed from: g, reason: collision with root package name */
    private float f14004g;

    /* renamed from: h, reason: collision with root package name */
    private int f14005h;

    /* renamed from: i, reason: collision with root package name */
    private int f14006i;

    /* renamed from: j, reason: collision with root package name */
    private int f14007j;

    /* renamed from: k, reason: collision with root package name */
    private ObjectAnimator f14008k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f14009l;

    public InstallProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14004g = -1.0f;
        this.f14009l = false;
        g();
    }

    private static boolean a(float f5, float f6) {
        return Math.abs(f5 - f6) <= 1.0E-6f;
    }

    private void b(Canvas canvas, boolean z5) {
        float measuredWidth = z5 ? getMeasuredWidth() : (getProgress() / getMaxProgress()) * getMeasuredWidth();
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
            canvas.drawBitmap(this.f13999b, getMeasuredWidth() - measuredWidth, 0.0f, this.f14003f);
        } else {
            canvas.drawBitmap(this.f13999b, measuredWidth - getMeasuredWidth(), 0.0f, this.f14003f);
        }
        canvas.restore();
    }

    private void c(Canvas canvas) {
        canvas.saveLayer(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), null, 31);
        canvas.drawBitmap(this.f13998a, 0.0f, 0.0f, (Paint) null);
    }

    private Bitmap d(StateListDrawable stateListDrawable, int i5, int i6) {
        if (i5 == 0) {
            i5 = 1;
        }
        if (i6 == 0) {
            i6 = 1;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i5, i6, stateListDrawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        stateListDrawable.setBounds(0, 0, i5, i6);
        stateListDrawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    private Drawable e(int i5) {
        return getResources().getDrawable(i5);
    }

    private ObjectAnimator f(float f5) {
        float f6 = this.f14004g;
        return f5 < f6 ? ObjectAnimator.ofFloat(this, "Progress", 0.0f, f5).setDuration(500L) : ObjectAnimator.ofFloat(this, "Progress", f6, f5).setDuration(500L);
    }

    private void g() {
        this.f14006i = 0;
        this.f14005h = 100;
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.f14000c = stateListDrawable;
        stateListDrawable.addState(new int[0], e(H1.g.f2191g));
        StateListDrawable stateListDrawable2 = new StateListDrawable();
        this.f14001d = stateListDrawable2;
        stateListDrawable2.addState(new int[0], e(H1.g.f2186b));
        StateListDrawable stateListDrawable3 = new StateListDrawable();
        this.f14002e = stateListDrawable3;
        stateListDrawable3.addState(new int[0], e(H1.g.f2189e));
        Paint paint = new Paint();
        this.f14003f = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
    }

    public int getMaxProgress() {
        return this.f14005h;
    }

    public int getMinProgress() {
        return this.f14006i;
    }

    public float getProgress() {
        return this.f14004g;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        c(canvas);
        float f5 = this.f14004g;
        if (f5 < this.f14006i || f5 > this.f14005h) {
            b(canvas, true);
        } else {
            b(canvas, false);
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z5, int i5, int i6, int i7, int i8) {
        super.onLayout(z5, i5, i6, i7, i8);
        if (getMeasuredWidth() != this.f14007j) {
            this.f13998a = null;
            this.f13999b = null;
        }
        if (this.f13998a == null) {
            if (this.f14009l) {
                this.f13998a = d(this.f14001d, getMeasuredWidth(), getMeasuredHeight());
            } else {
                this.f13998a = d(this.f14000c, getMeasuredWidth(), getMeasuredHeight());
            }
            this.f14007j = getMeasuredWidth();
        }
        if (this.f13999b == null) {
            this.f13999b = d(this.f14002e, getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public synchronized void setAnimProgress(float f5) {
        ObjectAnimator objectAnimatorF = f(f5);
        this.f14008k = objectAnimatorF;
        objectAnimatorF.start();
    }

    public void setMaxProgress(int i5) {
        this.f14005h = i5;
    }

    public void setMinProgress(int i5) {
        this.f14006i = i5;
    }

    public synchronized void setProgress(float f5) {
        if (f5 < 0.0f) {
            f5 = 0.0f;
        }
        int i5 = this.f14005h;
        if (f5 > i5) {
            f5 = i5;
        }
        if (!a(f5, this.f14004g)) {
            this.f14004g = f5;
            invalidate();
        }
    }

    public void setProgressBackColor(int i5) {
        StateListDrawable stateListDrawable = this.f14001d;
        if (stateListDrawable == null || i5 == 0) {
            return;
        }
        ((GradientDrawable) ((DrawableContainer.DrawableContainerState) stateListDrawable.getConstantState()).getChild(0)).setColor(i5);
        ((GradientDrawable) ((DrawableContainer.DrawableContainerState) this.f14000c.getConstantState()).getChild(0)).setColor(i5);
        if (getMeasuredWidth() != 0 && getMeasuredHeight() != 0) {
            Bitmap bitmap = this.f13998a;
            if (bitmap != null) {
                bitmap.recycle();
            }
            if (this.f14009l) {
                this.f13998a = d(this.f14001d, getMeasuredWidth(), getMeasuredHeight());
            } else {
                this.f13998a = d(this.f14000c, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        invalidate();
    }

    public void setRoundBtnColor(int i5) {
        StateListDrawable stateListDrawable = this.f14002e;
        if (stateListDrawable == null || i5 == 0) {
            return;
        }
        ((GradientDrawable) ((DrawableContainer.DrawableContainerState) stateListDrawable.getConstantState()).getChild(0)).setColor(i5);
        if (getMeasuredWidth() != 0 && getMeasuredHeight() != 0) {
            Bitmap bitmap = this.f13999b;
            if (bitmap != null) {
                bitmap.recycle();
            }
            this.f13999b = d(this.f14002e, getMeasuredWidth(), getMeasuredHeight());
        }
        invalidate();
    }

    public void setRoundRadius(float f5) {
        ((GradientDrawable) ((DrawableContainer.DrawableContainerState) this.f14000c.getConstantState()).getChild(0)).setCornerRadius(TypedValue.applyDimension(0, f5, getContext().getResources().getDisplayMetrics()));
    }
}
