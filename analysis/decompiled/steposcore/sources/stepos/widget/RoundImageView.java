package stepos.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.RemotableViewMethod;
import android.widget.ImageView;
import android.widget.RemoteViews;
import com.android.internal.R;

@RemoteViews.RemoteView
/* loaded from: classes.dex */
public class RoundImageView extends ImageView {
    private Bitmap mBitmap;
    private Paint mBitmapPaint;
    private BitmapShader mBitmapShader;
    private int mBorderRadiusDefault;
    private Matrix mMatrix;
    private RectF mRoundRect;

    public RoundImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mBorderRadiusDefault = 12;
        this.mBitmapPaint = new Paint();
        this.mBitmapPaint.setAntiAlias(true);
        this.mMatrix = new Matrix();
        int defaultRadius = (int) TypedValue.applyDimension(1, 4.0f, getResources().getDisplayMetrics());
        TypedArray typedArray = getResources().obtainAttributes(attrs, R.styleable.RoundImageView);
        this.mBorderRadiusDefault = (int) typedArray.getDimension(0, defaultRadius);
        typedArray.recycle();
    }

    @Override // android.widget.ImageView
    @RemotableViewMethod
    public void setImageBitmap(Bitmap bm) {
        super.setImageBitmap(bm);
        this.mBitmap = bm;
        this.mBitmapShader = new BitmapShader(bm, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.mRoundRect = new RectF(0.0f, 0.0f, getWidth(), getHeight());
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (getDrawable() == null || this.mRoundRect == null) {
            return;
        }
        if (this.mBitmapShader != null) {
            float scale = Math.max((getWidth() * 1.0f) / this.mBitmap.getWidth(), (getHeight() * 1.0f) / this.mBitmap.getHeight());
            this.mMatrix.setScale(scale, scale);
            this.mBitmapShader.setLocalMatrix(this.mMatrix);
        }
        this.mBitmapPaint.setShader(this.mBitmapShader);
        canvas.drawRoundRect(this.mRoundRect, this.mBorderRadiusDefault, this.mBorderRadiusDefault, this.mBitmapPaint);
    }

    public void setBorderRadius(int radius) {
        this.mBorderRadiusDefault = radius;
    }
}
