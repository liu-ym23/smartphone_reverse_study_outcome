package A2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PathEffect;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import y2.AbstractC1325f;

/* loaded from: classes.dex */
public class z extends AbstractC0264c {

    /* renamed from: c, reason: collision with root package name */
    private final Paint f149c;

    /* renamed from: d, reason: collision with root package name */
    private final Paint f150d;

    /* renamed from: e, reason: collision with root package name */
    protected float[] f151e;

    /* renamed from: f, reason: collision with root package name */
    private int f152f;

    /* renamed from: g, reason: collision with root package name */
    private int f153g;

    /* renamed from: h, reason: collision with root package name */
    private final float[] f154h;

    /* renamed from: i, reason: collision with root package name */
    private PathEffect f155i;

    /* renamed from: j, reason: collision with root package name */
    private PathEffect f156j;

    /* renamed from: k, reason: collision with root package name */
    private int f157k;

    /* renamed from: l, reason: collision with root package name */
    private int f158l;

    /* renamed from: m, reason: collision with root package name */
    private int f159m;

    /* renamed from: n, reason: collision with root package name */
    private int f160n;

    /* renamed from: o, reason: collision with root package name */
    private final Rect f161o;

    /* renamed from: p, reason: collision with root package name */
    private int f162p;

    /* renamed from: q, reason: collision with root package name */
    private int f163q;

    public z(Context context, int i5, int i6, PathEffect pathEffect, PathEffect pathEffect2, int i7, int i8, int i9, int i10) {
        super(context);
        Paint paint = new Paint();
        this.f149c = paint;
        Paint paint2 = new Paint();
        this.f150d = paint2;
        this.f161o = new Rect();
        this.f152f = i5;
        this.f153g = i6;
        this.f154h = new float[i5 + 1];
        this.f151e = new float[i6 + 1];
        this.f155i = pathEffect;
        this.f156j = pathEffect2;
        this.f157k = i7;
        this.f158l = i8;
        this.f159m = i9;
        this.f160n = i10;
        paint.setColor(i7);
        paint.setPathEffect(pathEffect);
        paint.setStrokeWidth(i9);
        paint.setAntiAlias(true);
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        paint2.setColor(i8);
        paint2.setPathEffect(pathEffect2);
        paint2.setStrokeWidth(i10);
        paint2.setAntiAlias(true);
        paint2.setStyle(style);
    }

    @Override // y2.i
    public void a(z2.f fVar) {
    }

    @Override // y2.i
    public void c(Canvas canvas) {
        canvas.save();
        for (float f5 : this.f154h) {
            Rect rect = this.f161o;
            canvas.drawLine(f5, rect.top, f5, rect.bottom, this.f149c);
        }
        for (float f6 : this.f151e) {
            Rect rect2 = this.f161o;
            canvas.drawLine(rect2.left, f6, rect2.right, f6, this.f150d);
        }
        canvas.restore();
    }

    @Override // y2.i
    public boolean d() {
        return false;
    }

    @Override // y2.i
    public boolean g(MotionEvent motionEvent, AbstractC1325f abstractC1325f) {
        return false;
    }

    @Override // y2.i
    public int[] j(AbstractC1325f abstractC1325f, int i5, int i6) {
        int size = View.MeasureSpec.getSize(i5);
        View.MeasureSpec.getMode(i5);
        int size2 = View.MeasureSpec.getSize(i6);
        View.MeasureSpec.getMode(i6);
        this.f162p = size;
        this.f163q = size2;
        return new int[]{size, size2};
    }

    @Override // y2.i
    public void l(AbstractC1325f abstractC1325f, boolean z5, int i5, int i6, int i7, int i8) {
        float f5 = (i7 - i5) / this.f152f;
        float f6 = (i8 - i6) / this.f153g;
        for (int i9 = 0; i9 < this.f152f + 1; i9++) {
            this.f154h[i9] = i5 + (i9 * f5);
        }
        for (int i10 = 0; i10 < this.f153g + 1; i10++) {
            this.f151e[i10] = i6 + (i10 * f6);
        }
        this.f161o.set(i5, i6, i7, i8);
    }

    @Override // A2.AbstractC0264c
    public Rect m() {
        return null;
    }

    @Override // A2.AbstractC0264c
    public int n() {
        return this.f163q;
    }

    @Override // A2.AbstractC0264c
    public int o() {
        return this.f162p;
    }

    public float[] p() {
        return this.f154h;
    }

    public float[] q() {
        return this.f151e;
    }

    public void r(int i5) {
        this.f157k = i5;
        this.f149c.setColor(i5);
    }

    public void s(PathEffect pathEffect) {
        this.f155i = pathEffect;
        this.f149c.setPathEffect(pathEffect);
    }

    public void t(int i5) {
        this.f159m = i5;
        this.f149c.setStrokeWidth(i5);
    }
}
