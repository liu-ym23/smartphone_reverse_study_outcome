package androidx.appcompat.graphics.drawable;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.DrawableCompat;
import com.larus.nova.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public class DrawerArrowDrawable extends Drawable {
    public static final int ARROW_DIRECTION_END = 3;
    public static final int ARROW_DIRECTION_LEFT = 0;
    public static final int ARROW_DIRECTION_RIGHT = 1;
    public static final int ARROW_DIRECTION_START = 2;
    private static final float ARROW_HEAD_ANGLE = 0.0f;
    private float mArrowHeadLength;
    private float mArrowShaftLength;
    private float mBarGap;
    private float mBarLength;
    private int mDirection;
    private float mMaxCutForBarSize;
    private final Paint mPaint;
    private final Path mPath;
    private float mProgress;
    private final int mSize;
    private boolean mSpin;
    private boolean mVerticalMirror;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ArrowDirection {
    }

    private static float lerp(float r100, float r101, float r102) {
        return r100 + ((r101 - r100) * r102);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public float getBarThickness() {
        return this.mPaint.getStrokeWidth();
    }

    public int getColor() {
        return this.mPaint.getColor();
    }

    static {
        ARROW_HEAD_ANGLE = (float) Math.toRadians(45.0d);
    }

    public float getArrowHeadLength() {
        return this.mArrowHeadLength;
    }

    public float getArrowShaftLength() {
        return this.mArrowShaftLength;
    }

    public float getBarLength() {
        return this.mBarLength;
    }

    public int getDirection() {
        return this.mDirection;
    }

    public float getGapSize() {
        return this.mBarGap;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mSize;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mSize;
    }

    public final Paint getPaint() {
        return this.mPaint;
    }

    public float getProgress() {
        return this.mProgress;
    }

    public boolean isSpinEnabled() {
        return this.mSpin;
    }

    public DrawerArrowDrawable(Context r100) {
        Paint r101 = new Paint();
        this.mPaint = r101;
        this.mPath = new Path();
        this.mVerticalMirror = false;
        this.mDirection = 2;
        r101.setStyle(Paint.Style.STROKE);
        r101.setStrokeJoin(Paint.Join.MITER);
        r101.setStrokeCap(Paint.Cap.BUTT);
        r101.setAntiAlias(true);
        TypedArray r102 = r100.getTheme().obtainStyledAttributes(null, new int[]{R.attr.arrowHeadLength, R.attr.arrowShaftLength, R.attr.barLength, R.attr.color, R.attr.drawableSize, R.attr.gapBetweenBars, R.attr.spinBars, R.attr.thickness}, R.attr.drawerArrowStyle, R.style.Base_Widget_AppCompat_DrawerArrowToggle);
        setColor(r102.getColor(3, 0));
        setBarThickness(r102.getDimension(7, 0.0f));
        setSpinEnabled(r102.getBoolean(6, true));
        setGapSize(Math.round(r102.getDimension(5, 0.0f)));
        this.mSize = r102.getDimensionPixelSize(4, 0);
        this.mBarLength = Math.round(r102.getDimension(2, 0.0f));
        this.mArrowHeadLength = Math.round(r102.getDimension(0, 0.0f));
        this.mArrowShaftLength = r102.getDimension(1, 0.0f);
        r102.recycle();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r110) {
        Rect r100 = getBounds();
        int r101 = this.mDirection;
        boolean r102 = false;
        if (r101 == 0) goto L13;
        if (r101 != 1) goto L6;
    L12:
        r102 = true;
        goto L13
    L6:
        if (r101 == 3) goto L11;
        if (DrawableCompat.getLayoutDirection(this) != 1) goto L13;
    L11:
        if (DrawableCompat.getLayoutDirection(this) == 0) goto L12;
    L13:
        float r103 = this.mArrowHeadLength;
        float r104 = lerp(this.mBarLength, (float) Math.sqrt((r103 * r103) * 2.0f), this.mProgress);
        float r105 = lerp(this.mBarLength, this.mArrowShaftLength, this.mProgress);
        float r106 = Math.round(lerp(0.0f, this.mMaxCutForBarSize, this.mProgress));
        float r107 = lerp(0.0f, ARROW_HEAD_ANGLE, this.mProgress);
        if (r102 == false) goto L16;
        float r111 = 0.0f;
    L18:
        if (r102 == false) goto L20;
        float r112 = 180.0f;
    L21:
        float r113 = lerp(r111, r112, this.mProgress);
        double r114 = r104;
        double r115 = r107;
        boolean r108 = r102;
        float r109 = Math.round(Math.cos(r115) * r114);
        float r116 = Math.round(r114 * Math.sin(r115));
        this.mPath.rewind();
        float r117 = lerp(this.mBarGap + this.mPaint.getStrokeWidth(), -this.mMaxCutForBarSize, this.mProgress);
        float r118 = (-r105) / 2.0f;
        this.mPath.moveTo(r118 + r106, 0.0f);
        this.mPath.rLineTo(r105 - (r106 * 2.0f), 0.0f);
        this.mPath.moveTo(r118, r117);
        this.mPath.rLineTo(r109, r116);
        this.mPath.moveTo(r118, -r117);
        this.mPath.rLineTo(r109, -r116);
        this.mPath.close();
        r110.save();
        float r119 = this.mPaint.getStrokeWidth();
        float r120 = r100.height() - (3.0f * r119);
        float r121 = this.mBarGap;
        r110.translate(r100.centerX(), ((((int) (r120 - (2.0f * r121))) / 4) * 2) + ((r119 * 1.5f) + r121));
        if (this.mSpin == true) goto L24;
        if (r108 == false) goto L30;
        r110.rotate(180.0f);
    L30:
        r110.drawPath(this.mPath, this.mPaint);
        r110.restore();
        return;
    L24:
        if ((this.mVerticalMirror ^ r108) == false) goto L26;
        int r122 = -1;
    L27:
        r110.rotate(r113 * r122);
        goto L30
    L26:
        r122 = 1;
        goto L27
    L20:
        r112 = 0.0f;
        goto L21
    L16:
        r111 = -180.0f;
        goto L18
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r100) {
        if (r100 == this.mPaint.getAlpha()) goto L6;
        this.mPaint.setAlpha(r100);
        invalidateSelf();
        return;
    }

    public void setArrowHeadLength(float r100) {
        if (this.mArrowHeadLength == r100) goto L6;
        this.mArrowHeadLength = r100;
        invalidateSelf();
        return;
    }

    public void setArrowShaftLength(float r100) {
        if (this.mArrowShaftLength == r100) goto L6;
        this.mArrowShaftLength = r100;
        invalidateSelf();
        return;
    }

    public void setBarLength(float r100) {
        if (this.mBarLength == r100) goto L6;
        this.mBarLength = r100;
        invalidateSelf();
        return;
    }

    public void setBarThickness(float r100) {
        if (this.mPaint.getStrokeWidth() == r100) goto L6;
        this.mPaint.setStrokeWidth(r100);
        this.mMaxCutForBarSize = (float) (((double) (r100 / 2.0f)) * Math.cos(ARROW_HEAD_ANGLE));
        invalidateSelf();
        return;
    }

    public void setColor(int r100) {
        if (r100 == this.mPaint.getColor()) goto L6;
        this.mPaint.setColor(r100);
        invalidateSelf();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r100) {
        this.mPaint.setColorFilter(r100);
        invalidateSelf();
    }

    public void setDirection(int r100) {
        if (r100 == this.mDirection) goto L6;
        this.mDirection = r100;
        invalidateSelf();
        return;
    }

    public void setGapSize(float r100) {
        if (r100 == this.mBarGap) goto L6;
        this.mBarGap = r100;
        invalidateSelf();
        return;
    }

    public void setProgress(float r100) {
        if (this.mProgress == r100) goto L6;
        this.mProgress = r100;
        invalidateSelf();
        return;
    }

    public void setSpinEnabled(boolean r100) {
        if (this.mSpin == r100) goto L6;
        this.mSpin = r100;
        invalidateSelf();
        return;
    }

    public void setVerticalMirror(boolean r100) {
        if (this.mVerticalMirror == r100) goto L6;
        this.mVerticalMirror = r100;
        invalidateSelf();
        return;
    }
}
