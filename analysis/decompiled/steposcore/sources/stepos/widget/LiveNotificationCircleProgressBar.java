package stepos.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.IntentExt;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.RemotableViewMethod;
import android.view.View;
import android.widget.RemoteViews;
import com.android.internal.R;

@RemoteViews.RemoteView
/* loaded from: classes.dex */
public class LiveNotificationCircleProgressBar extends View {
    private static final int DEFAULT_RADIUS = 10;
    private static final int DEFAULT_STROKE_WIDTH = 4;
    private static final int DEFAULT_TEXT_SIZE = 14;
    private boolean isAnimation;
    private ValueAnimator mAnimator;
    private Paint mBgPaint;
    private Paint mBitmapPaint;
    private Bitmap mCloseBitmap;
    private CountDownTimer mCountDownTimer;
    private int mCountdown;
    private float mCurrentAngle;
    private float mCurrentProgress;
    private long mDuration;
    private boolean mEnableClose;
    private int mEndAngle;
    private boolean mHasAnimation;
    private float mMaxProgress;
    private float mPreviousProgress;
    private int mProgressColor;
    private Paint mProgressPaint;
    private int mProgressbarBgColor;
    private int mRadius;
    private RectF mRectF;
    private int mStartAngle;
    private int mStrokeWidth;
    private String mText;
    private int mTextColor;
    private Paint mTextPaint;
    private float mTextSize;

    public LiveNotificationCircleProgressBar(Context context) {
        this(context, null);
    }

    public LiveNotificationCircleProgressBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LiveNotificationCircleProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mStartAngle = -90;
        this.mCurrentAngle = 0.0f;
        this.mEndAngle = 360;
        this.mDuration = 1000L;
        this.isAnimation = false;
        this.mEnableClose = false;
        this.mRectF = new RectF();
        this.mHasAnimation = true;
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.LiveCircleProgressBar);
        this.mRadius = array.getDimensionPixelSize(1, dp2px(10));
        this.mStrokeWidth = array.getDimensionPixelSize(4, dp2px(4));
        this.mProgressbarBgColor = array.getColor(8, context.getResources().getColor(android.R.color.datepicker_default_pressed_text_color_material_dark));
        this.mProgressColor = array.getColor(9, context.getResources().getColor(android.R.color.datepicker_default_pressed_text_color_material_light));
        this.mMaxProgress = array.getInt(3, 100);
        this.mCurrentProgress = array.getInt(0, 0);
        this.mEnableClose = array.getBoolean(2, false);
        String text = array.getString(5);
        this.mText = text == null ? "" : text;
        this.mTextColor = array.getColor(6, Color.parseColor("#000000"));
        this.mTextSize = array.getDimensionPixelSize(7, (int) TypedValue.applyDimension(2, 14.0f, getResources().getDisplayMetrics()));
        array.recycle();
        initPaint();
    }

    private void initPaint() {
        this.mBgPaint = new Paint();
        this.mBgPaint.setStyle(Paint.Style.STROKE);
        this.mBgPaint.setStrokeWidth(this.mStrokeWidth);
        this.mBgPaint.setAntiAlias(true);
        this.mBgPaint.setColor(this.mProgressbarBgColor);
        this.mBgPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mProgressPaint = new Paint();
        this.mProgressPaint.setStyle(Paint.Style.STROKE);
        this.mProgressPaint.setStrokeWidth(this.mStrokeWidth);
        this.mProgressPaint.setColor(this.mProgressColor);
        this.mProgressPaint.setAntiAlias(true);
        this.mProgressPaint.setStrokeCap(Paint.Cap.ROUND);
        if (!this.mEnableClose) {
            this.mTextPaint = new Paint();
            this.mTextPaint.setAntiAlias(true);
            this.mTextPaint.setColor(this.mTextColor);
            this.mTextPaint.setTextAlign(Paint.Align.CENTER);
            this.mTextPaint.setTextSize(this.mTextSize);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = 0;
        switch (View.MeasureSpec.getMode(widthMeasureSpec)) {
            case IntentExt.STEPOS_FLAG_DISABLE_SNAPSHOT /* -2147483648 */:
            case 0:
                width = this.mRadius * 2;
                break;
            case 1073741824:
                width = View.MeasureSpec.getSize(widthMeasureSpec);
                break;
        }
        setMeasuredDimension(width, width);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int centerX = getWidth() / 2;
        this.mRectF.left = this.mStrokeWidth;
        this.mRectF.top = this.mStrokeWidth;
        this.mRectF.right = (centerX * 2) - this.mStrokeWidth;
        this.mRectF.bottom = (centerX * 2) - this.mStrokeWidth;
        drawProgressbarBg(canvas, this.mRectF);
        drawProgress(canvas, this.mRectF);
        drawCenterText(canvas, centerX);
        drawCloseBitmap(canvas, centerX);
    }

    private void drawProgressbarBg(Canvas canvas, RectF rectF) {
        canvas.drawArc(rectF, this.mStartAngle, this.mEndAngle, false, this.mBgPaint);
    }

    private void drawProgress(Canvas canvas, RectF rectF) {
        if (!this.isAnimation) {
            this.mCurrentAngle = (this.mCurrentProgress / this.mMaxProgress) * 360.0f;
        }
        canvas.drawArc(rectF, this.mStartAngle, this.mCurrentAngle, false, this.mProgressPaint);
    }

    private void drawCenterText(Canvas canvas, int centerX) {
        if (this.mEnableClose || TextUtils.isEmpty(this.mText)) {
            return;
        }
        Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
        float textHeight = fontMetrics.descent - fontMetrics.ascent;
        float textOffset = (textHeight / 2.0f) - fontMetrics.descent;
        canvas.drawText(this.mText, centerX, (getHeight() / 2) + textOffset, this.mTextPaint);
    }

    private Bitmap getBitmapFromVectorDrawable(Context context, int drawableId) {
        Drawable drawable = context.getDrawable(drawableId);
        if (drawable instanceof VectorDrawable) {
            Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmap;
        }
        return null;
    }

    private void drawCloseBitmap(Canvas canvas, int centerX) {
        if (!this.mEnableClose) {
            return;
        }
        if (this.mCloseBitmap == null) {
            this.mCloseBitmap = getBitmapFromVectorDrawable(getContext(), android.R.drawable.ic_lockscreen_emergencycall_pressed);
            this.mBitmapPaint = new Paint(1);
            this.mBitmapPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
        }
        if (this.mCloseBitmap != null) {
            float left = centerX - (this.mCloseBitmap.getWidth() / 2);
            float top = (getHeight() / 2) - (this.mCloseBitmap.getHeight() / 2);
            canvas.drawBitmap(this.mCloseBitmap, left, top, this.mBitmapPaint);
        }
    }

    @RemotableViewMethod
    public void setProgress(float progress) {
        if (progress < 0.0f) {
            throw new IllegalArgumentException("Progress value can not be less than 0");
        }
        if (progress > this.mMaxProgress) {
            progress = this.mMaxProgress;
        }
        this.mCurrentProgress = progress;
        float targetAngle = (this.mCurrentProgress / this.mMaxProgress) * 360.0f;
        float lastAngle = (this.mPreviousProgress / this.mMaxProgress) * 360.0f;
        Log.d("LiveNotificationCircleProgressBar", "mCurrentProgress=" + this.mCurrentProgress + ",mPreviousProgress=" + this.mPreviousProgress);
        if (this.mHasAnimation) {
            setAnimator(lastAngle, targetAngle);
        } else {
            this.mCurrentAngle = targetAngle;
            invalidate();
        }
    }

    @RemotableViewMethod
    public void setPreviousProgress(float previousProgress) {
        this.mPreviousProgress = previousProgress;
    }

    @RemotableViewMethod
    public void setProgressWithAnimation(boolean hasAnimation) {
        this.mHasAnimation = hasAnimation;
    }

    @RemotableViewMethod
    public void setProgressBgColor(int color) {
        this.mProgressbarBgColor = color;
        this.mBgPaint.setColor(color);
        invalidate();
    }

    @RemotableViewMethod
    public void setProgressColor(int color) {
        this.mProgressColor = color;
        this.mProgressPaint.setColor(color);
        invalidate();
    }

    @RemotableViewMethod
    public void setText(String text) {
        this.mText = text;
        invalidate();
    }

    @RemotableViewMethod
    public void setCountdown(int countdown) {
        if (countdown <= 0) {
            return;
        }
        this.mCountdown = countdown;
        if (this.mCountDownTimer != null) {
            this.mCountDownTimer.cancel();
            this.mCountDownTimer = null;
        }
        this.mCountDownTimer = new CountDownTimer(this.mCountdown * 1000, 1000L) { // from class: stepos.widget.LiveNotificationCircleProgressBar.1
            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                float result = 1.0f - ((millisUntilFinished / 1000.0f) / LiveNotificationCircleProgressBar.this.mCountdown);
                LiveNotificationCircleProgressBar.this.setProgress(100.0f * result);
                LiveNotificationCircleProgressBar.this.mText = String.valueOf(((int) (millisUntilFinished / 1000)) + 1);
                LiveNotificationCircleProgressBar.this.invalidate();
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                LiveNotificationCircleProgressBar.this.setProgress(100.0f);
                LiveNotificationCircleProgressBar.this.mText = "0";
                LiveNotificationCircleProgressBar.this.invalidate();
            }
        };
        this.mCountDownTimer.start();
    }

    @RemotableViewMethod
    public void setTextColor(int color) {
        this.mTextColor = color;
        if (this.mTextPaint != null) {
            this.mTextPaint.setColor(color);
            invalidate();
        }
    }

    @RemotableViewMethod
    public void setTextSize(float textSize) {
        if (textSize <= 0.0f) {
            throw new IllegalArgumentException("textSize can not be less than 0");
        }
        this.mTextSize = textSize;
        if (this.mTextPaint != null) {
            this.mTextPaint.setTextSize(textSize);
            invalidate();
        }
    }

    @RemotableViewMethod
    public void setEnableClose(boolean enable) {
        this.mEnableClose = enable;
        invalidate();
    }

    private void setAnimator(float start, float target) {
        this.isAnimation = true;
        if (this.mAnimator != null && this.mAnimator.isRunning()) {
            this.mAnimator.cancel();
        }
        this.mAnimator = ValueAnimator.ofFloat(start, target);
        this.mAnimator.setDuration(this.mDuration);
        this.mAnimator.setTarget(Float.valueOf(this.mCurrentAngle));
        this.mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: stepos.widget.LiveNotificationCircleProgressBar$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.lambda$setAnimator$0(valueAnimator);
            }
        });
        this.mAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setAnimator$0(ValueAnimator valueAnimator) {
        this.mCurrentAngle = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    private int dp2px(int dp) {
        float density = getContext().getResources().getDisplayMetrics().density;
        return (int) (dp * density);
    }

    @RemotableViewMethod
    public void setCloseBitmap(Bitmap bitmap) {
        if (this.mCloseBitmap != null && !this.mCloseBitmap.isRecycled()) {
            this.mCloseBitmap.recycle();
        }
        this.mCloseBitmap = bitmap;
        invalidate();
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mCloseBitmap != null && !this.mCloseBitmap.isRecycled()) {
            this.mCloseBitmap.recycle();
            this.mCloseBitmap = null;
        }
        if (this.mAnimator != null) {
            this.mAnimator.cancel();
            this.mAnimator = null;
        }
        if (this.mCountDownTimer != null) {
            this.mCountDownTimer.cancel();
            this.mCountDownTimer = null;
        }
    }
}
