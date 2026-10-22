package stepos.support.v7.app.palette;

import a5.l;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;

/* loaded from: classes4.dex */
class ColorGridView extends View {

    /* renamed from: a, reason: collision with root package name */
    public int f6319a;
    public int b;
    public final Paint c;
    public final Path d;
    public final Paint e;
    public int f;
    public int g;
    public final RectF h;
    public final Paint i;

    /* renamed from: j, reason: collision with root package name */
    public int f6320j;

    public ColorGridView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new Paint(1);
        this.d = new Path();
        Paint paint = new Paint(1);
        this.e = paint;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        paint.setStrokeWidth(l.c(4.0f, getContext()));
        paint.setColor(-1711276033);
        this.h = new RectF();
        Paint paint2 = new Paint(1);
        this.i = paint2;
        paint2.setStyle(style);
        paint2.setStrokeWidth(l.c(4.0f, getContext()));
        paint2.setColor(-1);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i6, int i10, int i11) {
        super.onSizeChanged(i, i6, i10, i11);
        int i12 = i / 2;
        this.f6319a = i12;
        this.b = i6 / 2;
        this.f = i / 7;
        int iC = (int) (i12 - l.c(2.0f, getContext()));
        this.g = iC;
        this.d.addCircle(i / 2.0f, i6 / 2.0f, iC, Path.Direction.CW);
        this.f6320j = (int) l.c(2.0f, getContext());
    }
}
