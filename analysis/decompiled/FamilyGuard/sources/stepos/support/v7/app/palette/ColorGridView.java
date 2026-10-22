package stepos.support.v7.app.palette;

import N1.i;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: classes.dex */
class ColorGridView extends View {

    /* renamed from: a, reason: collision with root package name */
    private int f20890a;

    /* renamed from: b, reason: collision with root package name */
    private int f20891b;

    /* renamed from: c, reason: collision with root package name */
    private final Paint f20892c;

    /* renamed from: d, reason: collision with root package name */
    private final Path f20893d;

    /* renamed from: e, reason: collision with root package name */
    private final Paint f20894e;

    /* renamed from: f, reason: collision with root package name */
    private int[][] f20895f;

    /* renamed from: g, reason: collision with root package name */
    private int f20896g;

    /* renamed from: h, reason: collision with root package name */
    private int f20897h;

    /* renamed from: i, reason: collision with root package name */
    private final RectF f20898i;

    /* renamed from: j, reason: collision with root package name */
    private final Paint f20899j;

    /* renamed from: k, reason: collision with root package name */
    private int f20900k;

    public ColorGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20892c = new Paint(1);
        this.f20893d = new Path();
        Paint paint = new Paint(1);
        this.f20894e = paint;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        paint.setStrokeWidth(i.a(4.0f, getContext()));
        paint.setColor(-1711276033);
        this.f20898i = new RectF();
        Paint paint2 = new Paint(1);
        this.f20899j = paint2;
        paint2.setStyle(style);
        paint2.setStrokeWidth(i.a(4.0f, getContext()));
        paint2.setColor(-1);
    }

    public void a(int[][] iArr) {
        this.f20895f = iArr;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f20895f == null) {
            return;
        }
        canvas.clipPath(this.f20893d);
        for (int i5 = 0; i5 < 7; i5++) {
            for (int i6 = 0; i6 < 7; i6++) {
                this.f20892c.setColor(this.f20895f[i5][i6]);
                int i7 = this.f20896g;
                int i8 = i6 * i7;
                int i9 = i5 * i7;
                int i10 = i8 + i7;
                int i11 = i7 + i9;
                if (i5 == 3 && i6 == 3) {
                    RectF rectF = this.f20898i;
                    int i12 = this.f20900k;
                    rectF.set(i8 - i12, i9 - i12, i10 + i12, i12 + i11);
                }
                canvas.drawRect(i8, i9, i10, i11, this.f20892c);
            }
        }
        canvas.drawCircle(this.f20890a, this.f20891b, this.f20897h, this.f20894e);
        RectF rectF2 = this.f20898i;
        int i13 = this.f20900k;
        canvas.drawRoundRect(rectF2, i13, i13, this.f20899j);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i5, int i6, int i7, int i8) {
        super.onSizeChanged(i5, i6, i7, i8);
        int i9 = i5 / 2;
        this.f20890a = i9;
        this.f20891b = i6 / 2;
        this.f20896g = i5 / 7;
        int iA = (int) (i9 - i.a(2.0f, getContext()));
        this.f20897h = iA;
        this.f20893d.addCircle(i5 / 2.0f, i6 / 2.0f, iA, Path.Direction.CW);
        this.f20900k = (int) i.a(2.0f, getContext());
    }
}
