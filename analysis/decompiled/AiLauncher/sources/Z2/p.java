package Z2;

import G2.a;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;

/* loaded from: classes2.dex */
public abstract class p {

    /* renamed from: c, reason: collision with root package name */
    public l f7256c;

    /* renamed from: a, reason: collision with root package name */
    public boolean f7254a = false;

    /* renamed from: b, reason: collision with root package name */
    public boolean f7255b = false;

    /* renamed from: d, reason: collision with root package name */
    public RectF f7257d = new RectF();

    /* renamed from: e, reason: collision with root package name */
    public final Path f7258e = new Path();

    public static p a(View view) {
        return new q(view);
    }

    public abstract void b(View view);

    public final boolean c() {
        RectF rectF = this.f7257d;
        return rectF.left <= rectF.right && rectF.top <= rectF.bottom;
    }

    public void d(Canvas canvas, a.InterfaceC0037a interfaceC0037a) {
        if (!i() || this.f7258e.isEmpty()) {
            interfaceC0037a.a(canvas);
            return;
        }
        canvas.save();
        canvas.clipPath(this.f7258e);
        interfaceC0037a.a(canvas);
        canvas.restore();
    }

    public void e(View view, RectF rectF) {
        this.f7257d = rectF;
        j();
        b(view);
    }

    public void f(View view, l lVar) {
        this.f7256c = lVar;
        j();
        b(view);
    }

    public void g(View view, boolean z10) {
        if (z10 != this.f7254a) {
            this.f7254a = z10;
            b(view);
        }
    }

    public void h(View view, boolean z10) {
        this.f7255b = z10;
        b(view);
    }

    public abstract boolean i();

    public final void j() {
        if (!c() || this.f7256c == null) {
            return;
        }
        m.l().e(this.f7256c, 1.0f, this.f7257d, this.f7258e);
    }
}
