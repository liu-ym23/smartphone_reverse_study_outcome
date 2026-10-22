package A2;

import android.content.Context;
import android.graphics.Path;
import android.graphics.Rect;

/* renamed from: A2.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0265d implements m {

    /* renamed from: e, reason: collision with root package name */
    private Path f112e;

    /* renamed from: f, reason: collision with root package name */
    private final Context f113f;

    /* renamed from: i, reason: collision with root package name */
    private float f116i;

    /* renamed from: a, reason: collision with root package name */
    private final Rect f108a = new Rect();

    /* renamed from: b, reason: collision with root package name */
    private final Rect f109b = new Rect();

    /* renamed from: c, reason: collision with root package name */
    protected boolean f110c = true;

    /* renamed from: d, reason: collision with root package name */
    private y2.k f111d = y2.k.NORMAL;

    /* renamed from: g, reason: collision with root package name */
    private float f114g = 0.0f;

    /* renamed from: h, reason: collision with root package name */
    private int f115h = -1;

    public AbstractC0265d(Context context) {
        this.f113f = context;
    }

    @Override // A2.m
    public void a(int i5) {
        this.f115h = i5;
    }

    @Override // A2.m
    public Rect b() {
        return this.f109b;
    }

    @Override // y2.g
    public void d(y2.k kVar) {
        this.f111d = kVar;
    }

    @Override // A2.m
    public void e(int i5, int i6, int i7, int i8) {
        l(new Rect(i5, i6, i7, i8));
    }

    @Override // A2.m
    public void f(float f5) {
        this.f116i = f5;
        n((int) Math.ceil(f5 * getBounds().height()));
    }

    protected void g() {
        Path pathH = h();
        if (pathH == null) {
            pathH = new Path();
        } else {
            pathH.reset();
        }
        Path path = pathH;
        Rect rectB = b();
        float fWidth = this.f114g;
        if (fWidth == 0.0f) {
            fWidth = rectB.width() / 2.0f;
        }
        float f5 = fWidth;
        path.addRoundRect(rectB.left, rectB.top, rectB.right, rectB.bottom, f5, f5, Path.Direction.CW);
        m(path);
    }

    @Override // A2.m
    public Rect getBounds() {
        return this.f108a;
    }

    public Path h() {
        return this.f112e;
    }

    public int i() {
        return this.f115h;
    }

    public float j() {
        return this.f116i;
    }

    public y2.k k() {
        return this.f111d;
    }

    public void l(Rect rect) {
        int iWidth;
        this.f108a.set(rect);
        this.f109b.set(this.f108a);
        if (this.f110c) {
            if (this.f115h < 0) {
                this.f115h = this.f108a.width();
            }
            iWidth = this.f108a.height();
        } else {
            if (this.f115h < 0) {
                this.f115h = this.f108a.height();
            }
            iWidth = this.f108a.width();
        }
        n((int) Math.ceil(iWidth * j()));
        g();
    }

    public void m(Path path) {
        this.f112e = path;
    }

    public void n(int i5) {
        if (this.f110c) {
            int iHeight = getBounds().height();
            if (iHeight != 0) {
                this.f116i = i5 / iHeight;
            }
            if (i5 == 0) {
                Rect rect = this.f109b;
                rect.top = rect.bottom;
            } else {
                Rect rect2 = this.f109b;
                rect2.top = rect2.bottom - Math.max(i5, i());
            }
        } else {
            int iWidth = getBounds().width();
            if (iWidth != 0) {
                this.f116i = i5 / iWidth;
            }
            if (i5 == 0) {
                Rect rect3 = this.f109b;
                rect3.right = rect3.left;
            } else {
                Rect rect4 = this.f109b;
                rect4.right = rect4.left + Math.max(i5, i());
            }
        }
        g();
    }

    public void o(boolean z5) {
        this.f110c = z5;
    }

    public void p(float f5) {
        this.f114g = f5;
    }
}
