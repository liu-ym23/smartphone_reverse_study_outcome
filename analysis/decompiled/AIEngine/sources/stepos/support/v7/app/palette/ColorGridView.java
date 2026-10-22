package stepos.support.v7.app.palette;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
class ColorGridView extends View {

    /* renamed from: a, reason: collision with root package name */
    public int f12203a;

    /* renamed from: b, reason: collision with root package name */
    public int f12204b;

    /* renamed from: c, reason: collision with root package name */
    public final Paint f12205c;

    /* renamed from: d, reason: collision with root package name */
    public final Path f12206d;

    /* renamed from: e, reason: collision with root package name */
    public final Paint f12207e;
    public int h;

    /* renamed from: j, reason: collision with root package name */
    public int f12208j;

    /* renamed from: k, reason: collision with root package name */
    public final RectF f12209k;

    /* renamed from: l, reason: collision with root package name */
    public final Paint f12210l;

    /* renamed from: m, reason: collision with root package name */
    public int f12211m;

    public ColorGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12205c = new Paint(1);
        this.f12206d = new Path();
        Paint paint = new Paint(1);
        this.f12207e = paint;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        paint.setStrokeWidth(l8.f.a(4.0f, getContext()));
        paint.setColor(-1711276033);
        this.f12209k = new RectF();
        Paint paint2 = new Paint(1);
        this.f12210l = paint2;
        paint2.setStyle(style);
        paint2.setStrokeWidth(l8.f.a(4.0f, getContext()));
        paint2.setColor(-1);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        int i14 = i10 / 2;
        this.f12203a = i14;
        this.f12204b = i11 / 2;
        this.h = i10 / 7;
        int iA = (int) (i14 - l8.f.a(2.0f, getContext()));
        this.f12208j = iA;
        this.f12206d.addCircle(i10 / 2.0f, i11 / 2.0f, iA, Path.Direction.CW);
        this.f12211m = (int) l8.f.a(2.0f, getContext());
    }
}
