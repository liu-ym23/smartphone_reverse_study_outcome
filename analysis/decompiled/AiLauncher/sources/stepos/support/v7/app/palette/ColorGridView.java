package stepos.support.v7.app.palette;

import O6.s;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: classes5.dex */
class ColorGridView extends View {

    /* renamed from: a, reason: collision with root package name */
    public int f40626a;

    /* renamed from: b, reason: collision with root package name */
    public int f40627b;

    /* renamed from: c, reason: collision with root package name */
    public final Paint f40628c;

    /* renamed from: d, reason: collision with root package name */
    public final Path f40629d;

    /* renamed from: e, reason: collision with root package name */
    public final Paint f40630e;

    /* renamed from: f, reason: collision with root package name */
    public int[][] f40631f;

    /* renamed from: g, reason: collision with root package name */
    public int f40632g;

    /* renamed from: h, reason: collision with root package name */
    public int f40633h;

    /* renamed from: i, reason: collision with root package name */
    public final RectF f40634i;

    /* renamed from: j, reason: collision with root package name */
    public final Paint f40635j;

    /* renamed from: k, reason: collision with root package name */
    public int f40636k;

    public ColorGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f40628c = new Paint(1);
        this.f40629d = new Path();
        Paint paint = new Paint(1);
        this.f40630e = paint;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        paint.setStrokeWidth(s.a(4.0f, getContext()));
        paint.setColor(-1711276033);
        this.f40634i = new RectF();
        Paint paint2 = new Paint(1);
        this.f40635j = paint2;
        paint2.setStyle(style);
        paint2.setStrokeWidth(s.a(4.0f, getContext()));
        paint2.setColor(-1);
    }

    public void a(int[][] iArr) {
        this.f40631f = iArr;
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f40631f == null) {
            return;
        }
        canvas.clipPath(this.f40629d);
        for (int i10 = 0; i10 < 7; i10++) {
            for (int i11 = 0; i11 < 7; i11++) {
                this.f40628c.setColor(this.f40631f[i10][i11]);
                int i12 = this.f40632g;
                int i13 = i11 * i12;
                int i14 = i10 * i12;
                int i15 = i13 + i12;
                int i16 = i12 + i14;
                if (i10 == 3 && i11 == 3) {
                    RectF rectF = this.f40634i;
                    int i17 = this.f40636k;
                    rectF.set(i13 - i17, i14 - i17, i15 + i17, i17 + i16);
                }
                canvas.drawRect(i13, i14, i15, i16, this.f40628c);
            }
        }
        canvas.drawCircle(this.f40626a, this.f40627b, this.f40633h, this.f40630e);
        RectF rectF2 = this.f40634i;
        int i18 = this.f40636k;
        canvas.drawRoundRect(rectF2, i18, i18, this.f40635j);
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        int i14 = i10 / 2;
        this.f40626a = i14;
        this.f40627b = i11 / 2;
        this.f40632g = i10 / 7;
        int iA = (int) (i14 - s.a(2.0f, getContext()));
        this.f40633h = iA;
        this.f40629d.addCircle(i10 / 2.0f, i11 / 2.0f, iA, Path.Direction.CW);
        this.f40636k = (int) s.a(2.0f, getContext());
    }
}
