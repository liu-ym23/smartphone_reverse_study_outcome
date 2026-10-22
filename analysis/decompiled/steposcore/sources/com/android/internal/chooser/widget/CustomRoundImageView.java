package com.android.internal.chooser.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ImageView;
import com.android.internal.policy.StepOSSystemBarController;

/* loaded from: classes.dex */
public class CustomRoundImageView extends ImageView {
    private static int BLACKSTORKECOLOR = Color.parseColor("#0D000000");
    private static int WHITESTORKECOLOR = Color.parseColor("#FFFFFF");
    private Bitmap mBitmap;
    private Paint mBitmapPaint;
    private BitmapShader mBitmapShader;
    private int mBorderRadiusDefault;
    private float mCorrectionPreviewAngle;
    private float mCorrectionThumbnailAngle;
    private Matrix mMatrix;
    private boolean mPaintPreviewBlackStroke;
    private boolean mPaintThumbnailStroke;
    private RectF mPreviewRoundRect;
    private boolean mPreviewScale;
    private RectF mRoundRect;
    private Paint mStrokePaint;
    private RectF mThumbnailRoundRect;
    private int textColor;
    private int textDrawStrokeWidth;
    private float textSize;
    private String textString;
    private float x;
    private float y;

    public CustomRoundImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mBorderRadiusDefault = 10;
        this.mPreviewScale = false;
        this.mCorrectionPreviewAngle = 2.0f;
        this.mCorrectionThumbnailAngle = 1.0f;
        this.mPaintPreviewBlackStroke = false;
        this.mPaintThumbnailStroke = false;
        this.textString = "";
        this.textSize = 30.0f;
        this.x = -1000.0f;
        this.y = -1000.0f;
        this.textColor = 17171608;
        this.textDrawStrokeWidth = 10;
        this.mBitmapPaint = new Paint();
        this.mBitmapPaint.setAntiAlias(true);
        this.mStrokePaint = new Paint(1);
        this.mStrokePaint.setStyle(Paint.Style.STROKE);
        this.mMatrix = new Matrix();
        int defaultRadius = (int) TypedValue.applyDimension(1, 0.0f, getResources().getDisplayMetrics());
        this.mBorderRadiusDefault = defaultRadius;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bm) {
        super.setImageBitmap(bm);
        this.mBitmap = bm;
        this.mBitmapShader = new BitmapShader(bm, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.mRoundRect = new RectF(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        this.mPreviewRoundRect = new RectF(this.mCorrectionPreviewAngle + getPaddingLeft(), this.mCorrectionPreviewAngle + getPaddingTop(), (getWidth() - this.mCorrectionPreviewAngle) - getPaddingRight(), (getHeight() - this.mCorrectionPreviewAngle) - getPaddingBottom());
        this.mThumbnailRoundRect = new RectF(this.mCorrectionThumbnailAngle + getPaddingLeft(), this.mCorrectionThumbnailAngle + getPaddingTop(), (getWidth() - this.mCorrectionThumbnailAngle) - getPaddingRight(), (getHeight() - this.mCorrectionThumbnailAngle) - getPaddingBottom());
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (getDrawable() == null || this.mRoundRect == null || this.mPreviewRoundRect == null || this.mBorderRadiusDefault == 0 || this.mThumbnailRoundRect == null) {
            super.onDraw(canvas);
            return;
        }
        if (this.mBitmapShader != null) {
            float scale = Math.min((getWidth() * 1.0f) / this.mBitmap.getWidth(), (getHeight() * 1.0f) / this.mBitmap.getHeight());
            this.mMatrix.setScale(scale, scale);
            this.mBitmapShader.setLocalMatrix(this.mMatrix);
        }
        this.mBitmapPaint.setShader(this.mBitmapShader);
        canvas.drawRoundRect(this.mRoundRect, this.mBorderRadiusDefault, this.mBorderRadiusDefault, this.mBitmapPaint);
        canvas.save();
        if (this.mPaintThumbnailStroke) {
            paintThumbnailStroke(canvas);
            this.mPaintThumbnailStroke = false;
        } else {
            if (this.mPaintPreviewBlackStroke) {
                paintStroke(canvas, BLACKSTORKECOLOR);
                this.mPaintPreviewBlackStroke = false;
            }
            paintVideoDurationText(canvas);
        }
    }

    private void paintStroke(Canvas canvas, int color) {
        this.mStrokePaint.setColor(color);
        this.mStrokePaint.setStrokeWidth(1.0f);
        canvas.drawRoundRect(this.mPreviewRoundRect, this.mBorderRadiusDefault, this.mBorderRadiusDefault, this.mStrokePaint);
    }

    private void paintThumbnailStroke(Canvas canvas) {
        this.mStrokePaint.setColor(BLACKSTORKECOLOR);
        this.mStrokePaint.setStrokeWidth(2.0f);
        canvas.drawRoundRect(this.mThumbnailRoundRect, this.mBorderRadiusDefault, this.mBorderRadiusDefault, this.mStrokePaint);
    }

    private void paintVideoDurationText(Canvas canvas) {
        if (!"".equals(this.textString) && this.textString != null) {
            Paint paint = new Paint();
            paint.setTextSize(this.textSize);
            paint.setTypeface(Typeface.create("sans-serif-medium", 1));
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(4.0f);
            paint.setColor(StepOSSystemBarController.COLO_BLACK);
            canvas.drawText(this.textString, this.x == -1000.0f ? (canvas.getWidth() - (this.textSize * this.textString.length())) + 40.0f : this.x, this.y == -1000.0f ? canvas.getHeight() - 20 : this.y, paint);
            paint.setColor(Color.parseColor("#FFFFFFFF"));
            paint.setStyle(Paint.Style.FILL);
            canvas.drawText(this.textString, this.x == -1000.0f ? (canvas.getWidth() - (this.textSize * this.textString.length())) + 40.0f : this.x, this.y == -1000.0f ? canvas.getHeight() - 20 : this.y, paint);
        }
    }

    public void setBorderRadius(int radius) {
        this.mBorderRadiusDefault = (int) TypedValue.applyDimension(1, radius, getResources().getDisplayMetrics());
        invalidate();
    }

    public void setPreviewScale(boolean isPreview) {
        this.mPreviewScale = isPreview;
        invalidate();
    }

    public void setPaintRectf(RectF rectf) {
        this.mPreviewRoundRect = rectf;
        drawableStateChanged();
    }

    public void setPaintPreviewStrokeBlack(boolean paintStroke) {
        this.mPaintPreviewBlackStroke = paintStroke;
        drawableStateChanged();
    }

    public void setPainteThumbnailStroke(boolean paintStroke) {
        this.mPaintThumbnailStroke = paintStroke;
        drawableStateChanged();
    }

    public void setDrawText(String string) {
        this.textString = string;
        drawableStateChanged();
    }

    public void setDrawTextSize(float textSize) {
        this.textSize = textSize;
        drawableStateChanged();
    }

    public void setDrawLocalXY(float x, float y) {
        this.x = x;
        this.y = y;
        drawableStateChanged();
    }

    public void setDrawTextColorResourse(int textColor) {
        this.textColor = textColor;
        drawableStateChanged();
    }

    public void setDrawTextStrokeWidth(int textDrawStrokeWidth) {
        this.textDrawStrokeWidth = textDrawStrokeWidth;
        drawableStateChanged();
    }
}
