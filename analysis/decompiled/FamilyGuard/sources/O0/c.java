package O0;

import O0.g;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import java.nio.ByteBuffer;
import java.util.List;
import v0.ComponentCallbacks2C1180c;
import x0.InterfaceC1277a;
import z0.k;

/* loaded from: classes.dex */
public class c extends Drawable implements g.b, Animatable {

    /* renamed from: a, reason: collision with root package name */
    private final a f4304a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f4305b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f4306c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f4307d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f4308e;

    /* renamed from: f, reason: collision with root package name */
    private int f4309f;

    /* renamed from: g, reason: collision with root package name */
    private int f4310g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f4311h;

    /* renamed from: i, reason: collision with root package name */
    private Paint f4312i;

    /* renamed from: j, reason: collision with root package name */
    private Rect f4313j;

    /* renamed from: k, reason: collision with root package name */
    private List<androidx.vectordrawable.graphics.drawable.b> f4314k;

    static final class a extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        final g f4315a;

        a(g gVar) {
            this.f4315a = gVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return newDrawable();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new c(this);
        }
    }

    public c(Context context, InterfaceC1277a interfaceC1277a, k<Bitmap> kVar, int i5, int i6, Bitmap bitmap) {
        this(new a(new g(ComponentCallbacks2C1180c.c(context), interfaceC1277a, i5, i6, kVar, bitmap)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Drawable.Callback b() {
        Drawable.Callback callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        return callback;
    }

    private Rect d() {
        if (this.f4313j == null) {
            this.f4313j = new Rect();
        }
        return this.f4313j;
    }

    private Paint h() {
        if (this.f4312i == null) {
            this.f4312i = new Paint(2);
        }
        return this.f4312i;
    }

    private void j() {
        List<androidx.vectordrawable.graphics.drawable.b> list = this.f4314k;
        if (list != null) {
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                this.f4314k.get(i5).b(this);
            }
        }
    }

    private void l() {
        this.f4309f = 0;
    }

    private void n() {
        X0.j.a(!this.f4307d, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.f4304a.f4315a.f() == 1) {
            invalidateSelf();
        } else {
            if (this.f4305b) {
                return;
            }
            this.f4305b = true;
            this.f4304a.f4315a.s(this);
            invalidateSelf();
        }
    }

    private void o() {
        this.f4305b = false;
        this.f4304a.f4315a.t(this);
    }

    @Override // O0.g.b
    public void a() {
        if (b() == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        if (g() == f() - 1) {
            this.f4309f++;
        }
        int i5 = this.f4310g;
        if (i5 == -1 || this.f4309f < i5) {
            return;
        }
        j();
        stop();
    }

    public ByteBuffer c() {
        return this.f4304a.f4315a.b();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f4307d) {
            return;
        }
        if (this.f4311h) {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), d());
            this.f4311h = false;
        }
        canvas.drawBitmap(this.f4304a.f4315a.c(), (Rect) null, d(), h());
    }

    public Bitmap e() {
        return this.f4304a.f4315a.e();
    }

    public int f() {
        return this.f4304a.f4315a.f();
    }

    public int g() {
        return this.f4304a.f4315a.d();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f4304a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f4304a.f4315a.i();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f4304a.f4315a.l();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    public int i() {
        return this.f4304a.f4315a.k();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f4305b;
    }

    public void k() {
        this.f4307d = true;
        this.f4304a.f4315a.a();
    }

    public void m(k<Bitmap> kVar, Bitmap bitmap) {
        this.f4304a.f4315a.p(kVar, bitmap);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f4311h = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i5) {
        h().setAlpha(i5);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        h().setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z5, boolean z6) {
        X0.j.a(!this.f4307d, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.f4308e = z5;
        if (!z5) {
            o();
        } else if (this.f4306c) {
            n();
        }
        return super.setVisible(z5, z6);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f4306c = true;
        l();
        if (this.f4308e) {
            n();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f4306c = false;
        o();
    }

    c(a aVar) {
        this.f4308e = true;
        this.f4310g = -1;
        this.f4304a = (a) X0.j.d(aVar);
    }
}
