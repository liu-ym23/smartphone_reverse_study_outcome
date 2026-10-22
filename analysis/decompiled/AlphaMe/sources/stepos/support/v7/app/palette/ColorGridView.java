package stepos.support.v7.app.palette;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import m2.o;

/* loaded from: classes2.dex */
class ColorGridView extends View {

    /* renamed from: a, reason: collision with root package name */
    public int f14525a;

    /* renamed from: b, reason: collision with root package name */
    public int f14526b;

    /* renamed from: c, reason: collision with root package name */
    public final Paint f14527c;

    /* renamed from: d, reason: collision with root package name */
    public final Path f14528d;

    /* renamed from: e, reason: collision with root package name */
    public final Paint f14529e;

    /* renamed from: f, reason: collision with root package name */
    public int f14530f;

    /* renamed from: g, reason: collision with root package name */
    public int f14531g;

    /* renamed from: h, reason: collision with root package name */
    public final RectF f14532h;

    /* renamed from: i, reason: collision with root package name */
    public final Paint f14533i;

    /* renamed from: j, reason: collision with root package name */
    public int f14534j;

    public ColorGridView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14527c = new Paint(1);
        this.f14528d = new Path();
        Paint paint = new Paint(1);
        this.f14529e = paint;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        paint.setStrokeWidth(o.c(getContext(), 4.0f));
        paint.setColor(-1711276033);
        this.f14532h = new RectF();
        Paint paint2 = new Paint(1);
        this.f14533i = paint2;
        paint2.setStyle(style);
        paint2.setStrokeWidth(o.c(getContext(), 4.0f));
        paint2.setColor(-1);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        int i8 = i4 / 2;
        this.f14525a = i8;
        this.f14526b = i5 / 2;
        this.f14530f = i4 / 7;
        int iC = (int) (i8 - o.c(getContext(), 2.0f));
        this.f14531g = iC;
        this.f14528d.addCircle(i4 / 2.0f, i5 / 2.0f, iC, Path.Direction.CW);
        this.f14534j = (int) o.c(getContext(), 2.0f);
    }
}
