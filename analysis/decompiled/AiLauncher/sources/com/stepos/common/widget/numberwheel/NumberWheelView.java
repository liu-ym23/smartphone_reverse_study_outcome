package com.stepos.common.widget.numberwheel;

import O6.t;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import androidx.dynamicanimation.animation.e;
import androidx.dynamicanimation.animation.g;
import androidx.dynamicanimation.animation.i;
import androidx.dynamicanimation.animation.j;
import com.stepos.common.R$color;
import com.stepos.common.R$styleable;

/* loaded from: classes3.dex */
public class NumberWheelView extends View {
    private static final int DEFAULT_BLUR_OBJECT_SIZE = 40;
    public static final int DEFAULT_TEXT_SIZE = 60;
    private static final int MAX_ROTATION = 90;
    private static final int STATE_COMPLETE_DISMISS = 2;
    private static final int STATE_DURING_DISMISS = 1;
    private static final int STATE_NORMAL = 0;
    private int centerX;
    private int centerY;
    private BlurMaskFilter[] mBlurMaskFilters;
    private Camera mCamera;
    private int mCurrentNumber;
    private Paint mCurrentPaint;
    private a mDismissListener;
    private boolean mIsFlipUp;
    private int mNextNumber;
    private Paint mNextPaint;
    private Paint mPaint;
    protected i mSpringAnimation;
    private int mState;
    private int mTextColor;
    private int mTextSize;
    private float mTranslateProgress;

    public interface a {
    }

    public NumberWheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentNumber = 0;
        this.mNextNumber = 0;
        this.mTranslateProgress = 0.0f;
        this.mIsFlipUp = true;
        this.mState = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.NumberWheelView);
        this.mTextSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.NumberWheelView_numberWheelTextSize, t.a(context, 60.0d));
        this.mTextColor = typedArrayObtainStyledAttributes.getColor(R$styleable.NumberWheelView_numberWheelTextColor, androidx.core.content.a.c(context, R$color.fd_sys_color_on_surface_default));
        c();
    }

    public static /* synthetic */ void a(NumberWheelView numberWheelView, e eVar, boolean z10, float f10, float f11) {
        numberWheelView.mCurrentNumber = numberWheelView.mNextNumber;
        if (numberWheelView.mState == 1) {
            numberWheelView.mState = 2;
        } else {
            numberWheelView.mTranslateProgress = 0.0f;
        }
    }

    public static /* synthetic */ void b(NumberWheelView numberWheelView, e eVar, float f10, float f11) {
        numberWheelView.mTranslateProgress = f10;
        numberWheelView.invalidate();
        if (numberWheelView.mState != 0) {
            numberWheelView.requestLayout();
        }
    }

    public final void c() {
        Paint paint = new Paint(1);
        this.mPaint = paint;
        paint.setTextSize(this.mTextSize);
        this.mPaint.setTextAlign(Paint.Align.CENTER);
        this.mPaint.setColor(this.mTextColor);
        this.mCamera = new Camera();
        this.mCurrentPaint = new Paint(this.mPaint);
        this.mNextPaint = new Paint(this.mPaint);
        BlurMaskFilter[] blurMaskFilterArr = new BlurMaskFilter[40];
        this.mBlurMaskFilters = blurMaskFilterArr;
        blurMaskFilterArr[0] = null;
        int i10 = 1;
        while (true) {
            BlurMaskFilter[] blurMaskFilterArr2 = this.mBlurMaskFilters;
            if (i10 >= blurMaskFilterArr2.length) {
                setLayerType(1, this.mPaint);
                i iVarB = new i(new g()).B(new j().f(0.65f).h(250.0f));
                this.mSpringAnimation = iVarB;
                iVarB.c(new e.r() { // from class: com.stepos.common.widget.numberwheel.a
                    @Override // androidx.dynamicanimation.animation.e.r
                    public final void b(e eVar, float f10, float f11) {
                        NumberWheelView.b(this.f29522a, eVar, f10, f11);
                    }
                });
                this.mSpringAnimation.b(new e.q() { // from class: com.stepos.common.widget.numberwheel.b
                    @Override // androidx.dynamicanimation.animation.e.q
                    public final void a(e eVar, boolean z10, float f10, float f11) {
                        NumberWheelView.a(this.f29523a, eVar, z10, f10, f11);
                    }
                });
                return;
            }
            blurMaskFilterArr2[i10] = new BlurMaskFilter(i10, BlurMaskFilter.Blur.NORMAL);
            i10++;
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mState == 2) {
            return;
        }
        float f10 = this.mTranslateProgress;
        float f11 = f10 / 90.0f;
        this.mCurrentPaint.setAlpha((int) ((1.0f - (f10 / 90.0f)) * 255.0f));
        BlurMaskFilter[] blurMaskFilterArr = this.mBlurMaskFilters;
        int length = (int) (blurMaskFilterArr.length * f11);
        if (length < blurMaskFilterArr.length && length >= 0) {
            this.mCurrentPaint.setMaskFilter(blurMaskFilterArr[length]);
        }
        canvas.save();
        this.mCamera.save();
        float f12 = this.mTranslateProgress;
        if (f12 <= 90.0f) {
            if (this.mIsFlipUp) {
                this.mCamera.rotateX(f12);
                canvas.translate(this.centerX, this.centerY - this.mTranslateProgress);
            } else {
                this.mCamera.rotateX(-f12);
                canvas.translate(this.centerX, this.centerY + this.mTranslateProgress);
            }
            this.mCamera.applyToCanvas(canvas);
            canvas.drawText(String.valueOf(this.mCurrentNumber), 0.0f, this.centerY / 2.0f, this.mCurrentPaint);
        }
        this.mCamera.restore();
        canvas.restore();
        if (this.mState == 1) {
            return;
        }
        this.mNextPaint.setAlpha((int) (255.0f * f11));
        BlurMaskFilter[] blurMaskFilterArr2 = this.mBlurMaskFilters;
        int length2 = (int) (blurMaskFilterArr2.length * (1.0f - f11));
        if (length2 >= 0 && length2 < blurMaskFilterArr2.length) {
            this.mNextPaint.setMaskFilter(blurMaskFilterArr2[length2]);
        }
        canvas.save();
        this.mCamera.save();
        if (this.mIsFlipUp) {
            this.mCamera.rotateX(((this.mTranslateProgress / 90.0f) * 90.0f) - 90.0f);
            canvas.translate(this.centerX, this.centerY + (90.0f - this.mTranslateProgress));
        } else {
            this.mCamera.rotateX(90.0f - ((this.mTranslateProgress / 90.0f) * 90.0f));
            canvas.translate(this.centerX, this.centerY - (90.0f - this.mTranslateProgress));
        }
        this.mCamera.applyToCanvas(canvas);
        canvas.drawText(String.valueOf(this.mNextNumber), 0.0f, this.centerY / 2.0f, this.mNextPaint);
        this.mCamera.restore();
        canvas.restore();
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        float fMeasureText = this.mPaint.measureText(String.valueOf(9));
        Paint.FontMetrics fontMetrics = this.mPaint.getFontMetrics();
        float f10 = fontMetrics.descent - fontMetrics.ascent;
        float fMax = Math.max(fMeasureText, getSuggestedMinimumWidth());
        float fMax2 = Math.max(f10, getSuggestedMinimumHeight());
        if (this.mState != 0) {
            setMeasuredDimension((int) (fMax * (1.0f - Math.min(this.mTranslateProgress / 90.0f, 1.0f))), (int) fMax2);
        } else {
            setMeasuredDimension((int) fMax, ((int) fMax2) + t.a(getContext(), 30.0d));
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.centerX = i10 / 2;
        this.centerY = i11 / 2;
    }

    public void setTextColor(int i10) {
        this.mPaint.setColor(i10);
        this.mCurrentPaint.setColor(i10);
        this.mNextPaint.setColor(i10);
        invalidate();
    }

    public void setTextSize(int i10) {
        float f10 = i10;
        this.mPaint.setTextSize(f10);
        this.mCurrentPaint.setTextSize(f10);
        this.mNextPaint.setTextSize(f10);
        requestLayout();
    }

    public void setTypeface(Typeface typeface) {
        this.mPaint.setTypeface(typeface);
        this.mCurrentPaint.setTypeface(typeface);
        this.mNextPaint.setTypeface(typeface);
        requestLayout();
    }
}
