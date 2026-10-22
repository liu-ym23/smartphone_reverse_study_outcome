package stepos.widget;

import android.content.Context;
import android.content.IntentExt;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.view.RemotableViewMethod;
import android.view.View;
import android.widget.RemoteViews;
import com.android.internal.R;

@RemoteViews.RemoteView
/* loaded from: classes.dex */
public class LiveNotificationProgressBar extends View {
    private static final int DEFAULT_HEIGHT_DP = 24;
    private static final int DEFAULT_STEP_RADIUS = 3;
    private static final int MAX_PROGRESS = 100;
    private static final String TAG = LiveNotificationProgressBar.class.getSimpleName();
    BitmapShader bitmapShader;
    private Paint mBgPaint;
    private RectF mBgRectF;
    private int mBorderWidth;
    private int mCurProgress;
    private float mCurProgressX;
    private Bitmap mIndicatorBitmap;
    private boolean mIsFinish;
    private int mLoadingColor;
    private Paint mPgPaint;
    private int mProgressBgColor;
    private int mProgressHeight;
    private int mProgressRadius;
    private int mStepColor;
    private int mStepNum;
    private final int mStepPadding;
    private Paint mStepPaint;
    private int mStepRadius;
    private Bitmap pgBitmap;
    private Canvas pgCanvas;
    private PorterDuffXfermode stepMode;
    private PorterDuffXfermode xfermode;

    public LiveNotificationProgressBar(Context context) {
        this(context, null, 0);
    }

    public LiveNotificationProgressBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LiveNotificationProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.xfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER);
        this.stepMode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        this.mStepPadding = dp2px(4);
        initAttrs(attrs);
        init();
    }

    private void initAttrs(AttributeSet attrs) {
        TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.LiveNotificationProgressBar);
        try {
            this.mLoadingColor = ta.getColor(2, Color.parseColor("#40c4ff"));
            this.mProgressBgColor = ta.getColor(3, Color.parseColor("#40c4ff"));
            this.mStepColor = ta.getColor(5, Color.parseColor("#40c4ff"));
            this.mProgressRadius = (int) ta.getDimension(0, 0.0f);
            this.mBorderWidth = (int) ta.getDimension(1, 0.0f);
            this.mProgressHeight = (int) ta.getDimension(4, 12.0f);
            this.mStepNum = ta.getInt(6, 0);
        } finally {
            ta.recycle();
        }
    }

    private void init() {
        this.mBgPaint = new Paint(5);
        this.mBgPaint.setStyle(Paint.Style.FILL);
        this.mBgPaint.setStrokeWidth(this.mBorderWidth);
        this.mPgPaint = new Paint(1);
        this.mPgPaint.setStyle(Paint.Style.FILL);
        this.mStepPaint = new Paint(1);
        this.mStepPaint.setStyle(Paint.Style.FILL);
        this.mStepRadius = dp2px(3);
    }

    private void initPgBimap() {
        int top = (getMeasuredHeight() - this.mProgressHeight) / 2;
        this.mBgRectF = new RectF(this.mBorderWidth, top, getMeasuredWidth() - this.mBorderWidth, this.mProgressHeight + top);
        this.pgBitmap = Bitmap.createBitmap(getMeasuredWidth() - this.mBorderWidth, this.mProgressHeight, Bitmap.Config.ARGB_8888);
        this.pgCanvas = new Canvas(this.pgBitmap);
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSpecSize = View.MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecMode = View.MeasureSpec.getMode(heightMeasureSpec);
        int heightSpecSize = View.MeasureSpec.getSize(heightMeasureSpec);
        int height = 0;
        switch (heightSpecMode) {
            case IntentExt.STEPOS_FLAG_DISABLE_SNAPSHOT /* -2147483648 */:
                height = dp2px(24);
                break;
            case 0:
            case 1073741824:
                height = heightSpecSize;
                break;
        }
        setMeasuredDimension(widthSpecSize, height);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.pgBitmap == null) {
            initPgBimap();
        }
        drawBackGround(canvas);
        drawProgress(canvas);
        drawStep(canvas);
        drawIndicator(canvas);
    }

    private void drawBackGround(Canvas canvas) {
        this.mBgPaint.setColor(this.mProgressBgColor);
        canvas.drawRoundRect(this.mBgRectF, this.mProgressRadius, this.mProgressRadius, this.mBgPaint);
    }

    private void drawProgress(Canvas canvas) {
        this.mPgPaint.setColor(this.mLoadingColor);
        this.mCurProgressX = (this.mCurProgress / 100.0f) * getMeasuredWidth();
        this.pgCanvas.save();
        this.pgCanvas.clipRect(0.0f, 0.0f, this.mCurProgressX, this.mProgressHeight);
        this.pgCanvas.drawColor(this.mLoadingColor);
        this.pgCanvas.restore();
        this.bitmapShader = new BitmapShader(this.pgBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        this.mPgPaint.setShader(this.bitmapShader);
        canvas.drawRoundRect(this.mBgRectF, this.mProgressRadius, this.mProgressRadius, this.mPgPaint);
    }

    private void drawStep(Canvas canvas) {
        if (this.mStepNum == 0 || this.mStepNum == 1 || this.mStepNum > 5) {
            Log.w(TAG, "drawStep: 节点数量不符合设计");
            return;
        }
        this.mStepPaint.setColor(this.mStepColor);
        this.mStepPaint.setXfermode(this.stepMode);
        int padding = (getMeasuredWidth() - (this.mStepPadding * 2)) / (this.mStepNum - 1);
        float cy = getMeasuredHeight() / 2;
        canvas.drawCircle(this.mStepRadius + this.mStepPadding, cy, this.mStepRadius, this.mStepPaint);
        canvas.drawCircle((getMeasuredWidth() - this.mStepRadius) - this.mStepPadding, cy, this.mStepRadius, this.mStepPaint);
        for (int i = 1; i <= this.mStepNum - 2; i++) {
            canvas.drawCircle((i * padding) + this.mStepPadding, cy, this.mStepRadius, this.mStepPaint);
        }
    }

    private void drawIndicator(Canvas canvas) {
        if (this.mIndicatorBitmap == null) {
            return;
        }
        Paint paint = new Paint(1);
        paint.setXfermode(this.xfermode);
        float top = (getMeasuredHeight() - this.mIndicatorBitmap.getHeight()) / 2;
        canvas.drawBitmap(this.mIndicatorBitmap, this.mCurProgressX, top, paint);
    }

    @RemotableViewMethod
    public void setProgress(int curProgress) {
        if (curProgress == this.mCurProgress) {
            return;
        }
        if (this.mCurProgress < 100) {
            this.mCurProgress = curProgress;
        } else {
            this.mCurProgress = 100;
            finishLoad();
        }
        invalidate();
    }

    public void finishLoad() {
        this.mIsFinish = true;
    }

    public void reset() {
        this.mCurProgress = 0;
        this.mIsFinish = false;
        initPgBimap();
    }

    public int getProgress() {
        return this.mCurProgress;
    }

    public boolean isFinish() {
        return this.mIsFinish;
    }

    private int dp2px(int dp) {
        float density = getContext().getResources().getDisplayMetrics().density;
        return (int) (dp * density);
    }

    @RemotableViewMethod
    public void setIndicatorBitmap(Bitmap bitmap) {
        this.mIndicatorBitmap = bitmap;
    }

    @RemotableViewMethod
    public void setProgressBgColor(int color) {
        this.mProgressBgColor = color;
    }

    @RemotableViewMethod
    public void setProgressLoadingColor(int color) {
        this.mLoadingColor = color;
    }

    @RemotableViewMethod
    public void setProgressStepNum(int num) {
        this.mStepNum = num;
    }
}
