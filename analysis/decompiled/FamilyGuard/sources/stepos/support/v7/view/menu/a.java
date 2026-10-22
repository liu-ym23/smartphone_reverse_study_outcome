package stepos.support.v7.view.menu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public class a extends c5.a {

    /* renamed from: b, reason: collision with root package name */
    private final float f21243b;

    /* renamed from: c, reason: collision with root package name */
    private final int f21244c;

    /* renamed from: d, reason: collision with root package name */
    private final Paint f21245d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f21246e;

    /* renamed from: f, reason: collision with root package name */
    private int f21247f;

    /* renamed from: g, reason: collision with root package name */
    private com.stepos.common.widget.g f21248g;

    public a(Context context, Drawable drawable) {
        super(drawable);
        this.f21244c = -65536;
        this.f21243b = context.getResources().getDimension(H1.f.f2164z);
        Paint paint = new Paint();
        this.f21245d = paint;
        paint.setAntiAlias(true);
        paint.setColor(-65536);
        paint.setStyle(Paint.Style.FILL);
        com.stepos.common.widget.g gVar = new com.stepos.common.widget.g(context);
        this.f21248g = gVar;
        gVar.x(true);
    }

    void b() {
        this.f21248g.o();
    }

    public void c(int i5) {
        this.f21247f = i5;
        this.f21248g.u(i5);
        if (i5 <= 0) {
            this.f21248g.t(0);
        } else {
            this.f21248g.t(1);
        }
    }

    public void d(boolean z5) {
        this.f21246e = z5;
    }

    @Override // c5.a, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f21246e) {
            Rect bounds = super.getBounds();
            canvas.save();
            int i5 = this.f21248g.i();
            int iC = this.f21248g.c();
            if (this.f21247f > 0) {
                canvas.translate(bounds.right - (i5 >> 1), bounds.top - (iC >> 1));
            } else {
                canvas.translate(bounds.right - i5, bounds.top);
            }
            this.f21248g.a(canvas);
            canvas.restore();
        }
    }

    @Override // c5.a, android.graphics.drawable.Drawable
    public void setAlpha(int i5) {
        super.setAlpha(i5);
        this.f21248g.p(i5);
    }
}
