package d1;

import android.graphics.Paint;
import android.graphics.Shader;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public int f2967a = 3;

    /* renamed from: b, reason: collision with root package name */
    public Object f2968b;

    /* renamed from: c, reason: collision with root package name */
    public Object f2969c;

    /* renamed from: d, reason: collision with root package name */
    public Object f2970d;

    /* renamed from: e, reason: collision with root package name */
    public Object f2971e;

    public f(Paint paint) {
        this.f2968b = paint;
    }

    public int a() {
        Paint.Cap strokeCap = ((Paint) this.f2968b).getStrokeCap();
        int i = strokeCap == null ? -1 : g.f2973a[strokeCap.ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i != 2) {
            return i != 3 ? 0 : 2;
        }
        return 1;
    }

    public int b() {
        Paint.Join strokeJoin = ((Paint) this.f2968b).getStrokeJoin();
        int i = strokeJoin == null ? -1 : g.f2974b[strokeJoin.ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i != 2) {
            return i != 3 ? 0 : 1;
        }
        return 2;
    }

    public void c(float f5) {
        ((Paint) this.f2968b).setAlpha((int) Math.rint(f5 * 255.0f));
    }

    public void d(int i) {
        if (this.f2967a == i) {
            return;
        }
        this.f2967a = i;
        ((Paint) this.f2968b).setBlendMode(f0.p(i));
    }

    public void e(long j10) {
        ((Paint) this.f2968b).setColor(f0.r(j10));
    }

    public void f(l lVar) {
        this.f2970d = lVar;
        ((Paint) this.f2968b).setColorFilter(lVar != null ? lVar.f3010a : null);
    }

    public void g(Shader shader) {
        this.f2969c = shader;
        ((Paint) this.f2968b).setShader(shader);
    }

    public void h(int i) {
        ((Paint) this.f2968b).setStrokeCap(i == 2 ? Paint.Cap.SQUARE : i == 1 ? Paint.Cap.ROUND : i == 0 ? Paint.Cap.BUTT : Paint.Cap.BUTT);
    }

    public void i(int i) {
        ((Paint) this.f2968b).setStrokeJoin(i == 0 ? Paint.Join.MITER : i == 2 ? Paint.Join.BEVEL : i == 1 ? Paint.Join.ROUND : Paint.Join.MITER);
    }

    public void j(int i) {
        ((Paint) this.f2968b).setStyle(i == 1 ? Paint.Style.STROKE : Paint.Style.FILL);
    }
}
