package Jc;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.stepos.common.R$dimen;

/* loaded from: classes5.dex */
public class c extends a {

    /* renamed from: b, reason: collision with root package name */
    public final float f3832b;

    /* renamed from: c, reason: collision with root package name */
    public final int f3833c;

    /* renamed from: d, reason: collision with root package name */
    public final Paint f3834d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f3835e;

    /* renamed from: f, reason: collision with root package name */
    public int f3836f;

    /* renamed from: g, reason: collision with root package name */
    public com.stepos.common.widget.h f3837g;

    public c(Context context, Drawable drawable) {
        super(drawable);
        this.f3833c = -65536;
        this.f3832b = context.getResources().getDimension(R$dimen.mc_new_message_view_radius);
        Paint paint = new Paint();
        this.f3834d = paint;
        paint.setAntiAlias(true);
        paint.setColor(-65536);
        paint.setStyle(Paint.Style.FILL);
        com.stepos.common.widget.h hVar = new com.stepos.common.widget.h(context);
        this.f3837g = hVar;
        hVar.x(true);
    }

    public void b() {
        this.f3837g.o();
    }

    public void c(int i10) {
        this.f3836f = i10;
        this.f3837g.u(i10);
        if (i10 <= 0) {
            this.f3837g.t(0);
        } else {
            this.f3837g.t(1);
        }
    }

    public void d(boolean z10) {
        this.f3835e = z10;
    }

    @Override // Jc.a, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f3835e) {
            Rect bounds = super.getBounds();
            canvas.save();
            int i10 = this.f3837g.i();
            int iC = this.f3837g.c();
            if (this.f3836f > 0) {
                canvas.translate(bounds.right - (i10 >> 1), bounds.top - (iC >> 1));
            } else {
                canvas.translate(bounds.right - i10, bounds.top);
            }
            this.f3837g.a(canvas);
            canvas.restore();
        }
    }

    @Override // Jc.a, android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        super.setAlpha(i10);
        this.f3837g.p(i10);
    }
}
