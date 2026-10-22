package android.content.res.stepostheme.iconfilter.filters;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.hardware.display.StepOSDisplayManager;

/* loaded from: classes.dex */
public class ColorGradientFilter extends BaseFilter {
    private ColorMatrix mColorMatrix;
    private int mStartR = 0;
    private int mStartG = 0;
    private int mStartB = 0;
    private int mEndR = StepOSDisplayManager.BACK_SCREEN_BRIGHTNESS_MAX;
    private int mEndG = StepOSDisplayManager.BACK_SCREEN_BRIGHTNESS_MAX;
    private int mEndB = StepOSDisplayManager.BACK_SCREEN_BRIGHTNESS_MAX;

    public void setStartColor(int startColor) {
        this.mStartR = Color.red(startColor);
        this.mStartG = Color.green(startColor);
        this.mStartB = Color.blue(startColor);
        this.mColorMatrix = null;
    }

    public void setEndColor(int endColor) {
        this.mEndR = Color.red(endColor);
        this.mEndG = Color.green(endColor);
        this.mEndB = Color.blue(endColor);
        this.mColorMatrix = null;
    }

    @Override // android.content.res.stepostheme.iconfilter.filters.BaseFilter
    public Bitmap filter(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        if (this.mColorMatrix == null) {
            synchronized (this) {
                if (this.mColorMatrix == null) {
                    this.mColorMatrix = createColorMatrix();
                }
            }
        }
        Bitmap dstBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(dstBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColorFilter(new ColorMatrixColorFilter(this.mColorMatrix));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return dstBitmap;
    }

    private ColorMatrix createColorMatrix() {
        ColorMatrix matrix = new ColorMatrix();
        float[] floatMatrix = {((this.mEndR - this.mStartR) * 0.299f) / 255.0f, ((this.mEndR - this.mStartR) * 0.587f) / 255.0f, ((this.mEndR - this.mStartR) * 0.114f) / 255.0f, 0.0f, this.mStartR, ((this.mEndG - this.mStartG) * 0.299f) / 255.0f, ((this.mEndG - this.mStartG) * 0.587f) / 255.0f, ((this.mEndG - this.mStartG) * 0.114f) / 255.0f, 0.0f, this.mStartG, ((this.mEndB - this.mStartB) * 0.299f) / 255.0f, ((this.mEndB - this.mStartB) * 0.587f) / 255.0f, ((this.mEndB - this.mStartB) * 0.114f) / 255.0f, 0.0f, this.mStartB, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
        matrix.set(floatMatrix);
        return matrix;
    }
}
