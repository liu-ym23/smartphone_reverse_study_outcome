package com.zyql.ai.selector.camera.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;

/* loaded from: classes4.dex */
public class TypeButton extends View {
    public static final int TYPE_CANCEL = 1;
    public static final int TYPE_CONFIRM = 2;
    private float button_radius;
    private int button_size;
    private int button_type;
    private float center_X;
    private float center_Y;
    private float index;
    private Paint mPaint;
    private Path path;
    private RectF rectF;
    private float strokeWidth;

    public TypeButton(Context context) {
        super(context);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.button_type == 1) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(-287515428);
            Paint paint = this.mPaint;
            Paint.Style style = Paint.Style.FILL;
            paint.setStyle(style);
            canvas.drawCircle(this.center_X, this.center_Y, this.button_radius, this.mPaint);
            this.mPaint.setColor(-16777216);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(this.strokeWidth);
            Path path = this.path;
            float f10 = this.center_X;
            float f11 = this.index;
            path.moveTo(f10 - (f11 / 7.0f), this.center_Y + f11);
            Path path2 = this.path;
            float f12 = this.center_X;
            float f13 = this.index;
            path2.lineTo(f12 + f13, this.center_Y + f13);
            this.path.arcTo(this.rectF, 90.0f, -180.0f);
            Path path3 = this.path;
            float f14 = this.center_X;
            float f15 = this.index;
            path3.lineTo(f14 - f15, this.center_Y - f15);
            canvas.drawPath(this.path, this.mPaint);
            this.mPaint.setStyle(style);
            this.path.reset();
            Path path4 = this.path;
            float f16 = this.center_X;
            float f17 = this.index;
            path4.moveTo(f16 - f17, (float) (this.center_Y - (f17 * 1.5d)));
            Path path5 = this.path;
            float f18 = this.center_X;
            float f19 = this.index;
            path5.lineTo(f18 - f19, (float) (this.center_Y - (f19 / 2.3d)));
            Path path6 = this.path;
            double d10 = this.center_X;
            float f20 = this.index;
            path6.lineTo((float) (d10 - (f20 * 1.6d)), this.center_Y - f20);
            this.path.close();
            canvas.drawPath(this.path, this.mPaint);
        }
        if (this.button_type == 2) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(-1);
            this.mPaint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(this.center_X, this.center_Y, this.button_radius, this.mPaint);
            this.mPaint.setAntiAlias(true);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(-16724992);
            this.mPaint.setStrokeWidth(this.strokeWidth);
            this.path.moveTo(this.center_X - (this.button_size / 6.0f), this.center_Y);
            Path path7 = this.path;
            float f21 = this.center_X;
            int i10 = this.button_size;
            path7.lineTo(f21 - (i10 / 21.2f), this.center_Y + (i10 / 7.7f));
            Path path8 = this.path;
            float f22 = this.center_X;
            int i11 = this.button_size;
            path8.lineTo(f22 + (i11 / 4.0f), this.center_Y - (i11 / 8.5f));
            Path path9 = this.path;
            float f23 = this.center_X;
            int i12 = this.button_size;
            path9.lineTo(f23 - (i12 / 21.2f), this.center_Y + (i12 / 9.4f));
            this.path.close();
            canvas.drawPath(this.path, this.mPaint);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        int i12 = this.button_size;
        setMeasuredDimension(i12, i12);
    }

    public TypeButton(Context context, int i10, int i11) {
        super(context);
        this.button_type = i10;
        this.button_size = i11;
        float f10 = i11;
        float f11 = f10 / 2.0f;
        this.button_radius = f11;
        this.center_X = f11;
        this.center_Y = f11;
        this.mPaint = new Paint();
        this.path = new Path();
        this.strokeWidth = f10 / 50.0f;
        this.index = this.button_size / 12.0f;
        float f12 = this.center_X;
        float f13 = this.center_Y;
        float f14 = this.index;
        this.rectF = new RectF(f12, f13 - f14, (2.0f * f14) + f12, f13 + f14);
    }
}
