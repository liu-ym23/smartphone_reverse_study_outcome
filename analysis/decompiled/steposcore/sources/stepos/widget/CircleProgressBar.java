package stepos.widget;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.RemotableViewMethod;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ProgressBar;
import android.widget.RemoteViews;
import com.android.internal.R;

@RemoteViews.RemoteView
/* loaded from: classes.dex */
public class CircleProgressBar extends ProgressBar {
    public static final int BAR_COLOR_DEF = -15505157;
    public static final float BAR_WIDTH_DEF_DIP = 3.0f;
    public static final int RIM_COLOR_DEF = 201326592;
    public static final String START_ANGLE_PROPERTY = "startAngle";
    public static final String SWEEP_ANGLE_PROPERTY = "sweepAngle";
    private final long LOADING_ANIM_DURATION;
    private ObjectAnimator mAngleAnim;
    private int mBarColor;
    private Paint mBarPaint;
    private int mBarPostition;
    private float mBarWidth;
    private Drawable mCenterIcon;
    private RectF mCircleBound;
    private boolean mClockwiseLoading;
    private float mHeadSign;
    private boolean mIndeterminate;
    private int mMax;
    private boolean mNeedUpdateBound;
    private int mProgress;
    private int mRimColor;
    private Paint mRimPaint;
    private float mStartAngle;
    private float mSweepAngle;

    public CircleProgressBar(Context context) {
        this(context, null);
    }

    public CircleProgressBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleProgressBar(Context context, AttributeSet attrs, int defStyle) {
        this(context, attrs, defStyle, 0);
    }

    public CircleProgressBar(Context context, AttributeSet attrs, int defStyle, int styleRes) {
        super(context, attrs, defStyle, styleRes);
        this.LOADING_ANIM_DURATION = 2000L;
        this.mBarPostition = 0;
        this.mBarPaint = new Paint();
        this.mRimPaint = new Paint();
        this.mCenterIcon = null;
        this.mCircleBound = new RectF();
        this.mNeedUpdateBound = false;
        this.mAngleAnim = null;
        this.mHeadSign = 0.0f;
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CircleProgressBar, defStyle, styleRes);
        this.mCenterIcon = a.getDrawable(0);
        if (this.mCenterIcon != null) {
            this.mCenterIcon.setBounds(0, 0, this.mCenterIcon.getIntrinsicWidth(), this.mCenterIcon.getIntrinsicHeight());
        }
        this.mBarColor = a.getColor(1, BAR_COLOR_DEF);
        this.mRimColor = a.getColor(2, RIM_COLOR_DEF);
        new DisplayMetrics();
        DisplayMetrics dm = getResources().getDisplayMetrics();
        int barWidthPx = (int) (dm.density * 3.0f);
        this.mBarWidth = a.getDimensionPixelSize(3, barWidthPx);
        this.mClockwiseLoading = a.getBoolean(4, false);
        super.setIndeterminate(false);
        a.recycle();
        init();
    }

    private void init() {
        setCircleBound();
        setPaint();
        if (!this.mIndeterminate) {
            this.mBarPostition = getPosByProgress(this.mProgress);
        }
    }

    private void setPaint() {
        if (this.mBarPaint == null) {
            this.mBarPaint = new Paint();
        }
        this.mBarPaint.setColor(this.mBarColor);
        this.mBarPaint.setAntiAlias(true);
        this.mBarPaint.setStyle(Paint.Style.STROKE);
        this.mBarPaint.setStrokeWidth(this.mBarWidth);
        this.mBarPaint.setStrokeCap(Paint.Cap.ROUND);
        if (this.mRimPaint == null) {
            this.mRimPaint = new Paint();
        }
        this.mRimPaint.setColor(this.mRimColor);
        this.mRimPaint.setAntiAlias(true);
        this.mRimPaint.setStyle(Paint.Style.STROKE);
        this.mRimPaint.setStrokeWidth(this.mBarWidth);
    }

    private void setCircleBound() {
        if (this.mCircleBound == null) {
            this.mCircleBound = new RectF();
        }
        this.mCircleBound.left = getPaddingLeft() + this.mBarWidth;
        this.mCircleBound.top = getPaddingTop() + this.mBarWidth;
        this.mCircleBound.right = (getWidth() - getPaddingRight()) - this.mBarWidth;
        this.mCircleBound.bottom = (getHeight() - getPaddingBottom()) - this.mBarWidth;
    }

    private int getPosByProgress(int progress) {
        int max = this.mClockwiseLoading ? 360 : 180;
        if (this.mMax <= 0) {
            return 0;
        }
        if (progress >= this.mMax) {
            return max;
        }
        float scale = progress / this.mMax;
        int position = (int) (max * scale);
        return position;
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas canvas2;
        if (this.mNeedUpdateBound) {
            setCircleBound();
        }
        if (this.mIndeterminate) {
            drawLoadingAnimation(canvas);
            canvas2 = canvas;
        } else {
            canvas.drawArc(this.mCircleBound, 360.0f, 360.0f, false, this.mRimPaint);
            canvas2 = canvas;
            if (this.mClockwiseLoading) {
                canvas2.drawArc(this.mCircleBound, -90.0f, this.mBarPostition, false, this.mBarPaint);
            } else {
                canvas2.drawArc(this.mCircleBound, this.mBarPostition + 90, this.mBarPostition * (-2), false, this.mBarPaint);
            }
        }
        if (this.mCenterIcon == null || this.mIndeterminate) {
            return;
        }
        int restoreCount = canvas2.save();
        canvas2.translate((getWidth() / 2) - (this.mCenterIcon.getIntrinsicWidth() / 2), (getHeight() / 2) - (this.mCenterIcon.getIntrinsicHeight() / 2));
        this.mCenterIcon.draw(canvas2);
        canvas2.restoreToCount(restoreCount);
    }

    private void drawLoadingAnimation(Canvas canvas) {
        canvas.drawArc(this.mCircleBound, -90.0f, 360.0f, false, this.mRimPaint);
        canvas.drawArc(this.mCircleBound, this.mStartAngle, this.mSweepAngle, false, this.mBarPaint);
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        this.mNeedUpdateBound = true;
        postInvalidate();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
        if (this.mIndeterminate) {
            if (visibility == 8 || visibility == 4) {
                if (this.mAngleAnim != null) {
                    this.mAngleAnim.end();
                    return;
                }
                return;
            }
            startLoadingAnimation();
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mAngleAnim != null) {
            this.mAngleAnim.end();
        }
    }

    @Override // android.widget.ProgressBar
    @RemotableViewMethod
    public void setMax(int max) {
        if (this.mIndeterminate) {
            return;
        }
        if (max < 0) {
            max = 0;
        }
        if (max != this.mMax) {
            this.mMax = max;
            if (this.mProgress > max) {
                this.mProgress = max;
            }
            postInvalidate();
        }
    }

    @Override // android.widget.ProgressBar
    @RemotableViewMethod
    public void setProgress(int progress) {
        if (this.mIndeterminate) {
            return;
        }
        if (progress < 0) {
            progress = 0;
        }
        if (progress > this.mMax) {
            progress = this.mMax;
        }
        if (progress != this.mProgress) {
            this.mProgress = progress;
            this.mBarPostition = getPosByProgress(this.mProgress);
        }
        postInvalidate();
    }

    @RemotableViewMethod
    public void setCircleBarColor(int barColor) {
        if (this.mBarColor != barColor) {
            this.mBarColor = barColor;
            this.mBarPaint.setColor(this.mBarColor);
            postInvalidate();
        }
    }

    @RemotableViewMethod
    public void setCircleRimColor(int rimColor) {
        if (this.mRimColor != rimColor) {
            this.mRimColor = rimColor;
            this.mRimPaint.setColor(this.mRimColor);
            postInvalidate();
        }
    }

    @RemotableViewMethod
    public void setCircleBarWidth(float barWidth) {
        if (Math.abs(this.mBarWidth - barWidth) < 1.0E-6d) {
            return;
        }
        if (barWidth < 0.0f) {
            this.mBarWidth = 0.0f;
        } else {
            this.mBarWidth = barWidth;
        }
        this.mBarPaint.setStrokeWidth(this.mBarWidth);
        this.mRimPaint.setStrokeWidth(this.mBarWidth);
        this.mNeedUpdateBound = true;
        postInvalidate();
    }

    @RemotableViewMethod
    public void setCircleCenterIcon(int centerIconId) {
        if (this.mIndeterminate) {
            return;
        }
        if (-1 == centerIconId) {
            this.mCenterIcon = null;
        } else {
            this.mCenterIcon = this.mContext.getResources().getDrawable(centerIconId);
        }
        this.mCenterIcon.setBounds(0, 0, this.mCenterIcon.getIntrinsicWidth(), this.mCenterIcon.getIntrinsicHeight());
        postInvalidate();
    }

    @Override // android.widget.ProgressBar
    @RemotableViewMethod
    public void setIndeterminate(boolean indeterminate) {
        if (this.mIndeterminate != indeterminate) {
            this.mIndeterminate = indeterminate;
            init();
            if (getVisibility() == 0 && this.mIndeterminate) {
                startLoadingAnimation();
            } else if (this.mAngleAnim != null) {
                this.mAngleAnim.end();
            }
            postInvalidate();
        }
    }

    public void setClockwiseLoading(boolean clockwiseLoading) {
        this.mClockwiseLoading = clockwiseLoading;
    }

    private float getStartPoint(float point) {
        float startPoint = point;
        if (startPoint > -90.0f && startPoint <= 162.0f) {
            startPoint = point * 1.1f;
        } else if (startPoint > 162.0f && startPoint <= 216.0f) {
            startPoint = ((startPoint - 162.0f) * 0.95f) + 178.2f;
        } else if (startPoint > 216.0f && startPoint <= 270.0f) {
            startPoint = ((startPoint - 216.0f) * 0.75f) + 229.5f;
        }
        if (startPoint < -90.0f) {
            startPoint = -90.0f;
        }
        if (startPoint > 270.0f) {
            return 270.0f;
        }
        return startPoint;
    }

    private float getArcDistance(float startPoint) {
        if (startPoint > -90.0f && startPoint <= -36.0f) {
            float distance = (90.0f + startPoint) * 2.0f;
            return distance;
        }
        if (startPoint > -36.0f && startPoint <= 18.0f) {
            float distance2 = (((36.0f + startPoint) * 2.0f) / 3.0f) + 108.0f;
            return distance2;
        }
        if (startPoint > 18.0f && startPoint <= 90.0f) {
            float distance3 = 144.0f - ((startPoint - 18.0f) / 4.0f);
            return distance3;
        }
        if (startPoint > 90.0f && startPoint <= 162.0f) {
            float distance4 = 126.0f - ((startPoint - 90.0f) / 2.0f);
            return distance4;
        }
        if (startPoint <= 162.0f || startPoint > 270.0f) {
            return 0.0f;
        }
        float distance5 = 90.0f - (((startPoint - 162.0f) * 90.0f) / 108.0f);
        return distance5;
    }

    public float getSweepAngle() {
        return this.mSweepAngle;
    }

    public void setSweepAngle(float sweepAngle) {
        this.mSweepAngle = sweepAngle;
        postInvalidate();
    }

    public float getStartAngle() {
        return this.mStartAngle;
    }

    public void setStartAngle(float startAngle) {
        this.mStartAngle = startAngle;
        postInvalidate();
    }

    private ObjectAnimator propertyAnimator(Object target, String propertyName, float begin, float end, int duration) {
        PropertyValuesHolder pvhA = PropertyValuesHolder.ofFloat(propertyName, begin, end);
        ObjectAnimator anim = ObjectAnimator.ofPropertyValuesHolder(target, pvhA);
        anim.setDuration(duration);
        return anim;
    }

    private void startLoadingAnimation(int duration) {
        if (this.mAngleAnim != null) {
            this.mAngleAnim.setDuration(duration);
            this.mAngleAnim.setRepeatCount(-1);
            this.mAngleAnim.setInterpolator(new AccelerateInterpolator());
            this.mAngleAnim.start();
            postInvalidate();
        }
    }

    private void startLoadingAnimation() {
        if (this.mAngleAnim != null && this.mAngleAnim.isRunning()) {
            return;
        }
        this.mAngleAnim = createLoadingAnimator();
        this.mAngleAnim.start();
    }

    private ObjectAnimator createLoadingAnimator() {
        Keyframe key1 = Keyframe.ofFloat(0.0f, -90.0f);
        Keyframe key2 = Keyframe.ofFloat(0.5f, 330.0f);
        Keyframe key3 = Keyframe.ofFloat(1.0f, 630.0f);
        PropertyValuesHolder pvhStart = PropertyValuesHolder.ofKeyframe(START_ANGLE_PROPERTY, key1, key2, key3);
        PropertyValuesHolder pvhSweep = PropertyValuesHolder.ofFloat(SWEEP_ANGLE_PROPERTY, 0.0f, -144.0f, 0.0f);
        ObjectAnimator loadingAnim = ObjectAnimator.ofPropertyValuesHolder(this, pvhStart, pvhSweep);
        loadingAnim.setDuration(2000L);
        loadingAnim.setInterpolator(new LinearInterpolator());
        loadingAnim.setRepeatCount(-1);
        return loadingAnim;
    }

    protected void setHeadSign(float headSign) {
        this.mHeadSign = headSign;
    }

    protected float getHeadSign() {
        return this.mHeadSign;
    }

    @Override // android.widget.ProgressBar
    public int getMax() {
        return this.mMax;
    }

    @Override // android.widget.ProgressBar
    public int getProgress() {
        if (this.mIndeterminate) {
            return 0;
        }
        return this.mProgress;
    }
}
