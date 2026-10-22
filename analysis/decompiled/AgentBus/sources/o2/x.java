package o2;

import android.graphics.Rect;
import java.util.List;

/* loaded from: classes.dex */
public abstract class x {

    /* renamed from: a, reason: collision with root package name */
    public final j0 f7246a;

    /* renamed from: b, reason: collision with root package name */
    public final Rect[][] f7247b;

    /* renamed from: c, reason: collision with root package name */
    public final Rect[][] f7248c;

    public x() {
        this(new j0());
    }

    public final void a() {
    }

    public void b(j0 j0Var) {
        for (int i2 = 1; i2 <= 512; i2 <<= 1) {
            List<Rect> listE = j0Var.f7236a.e(i2);
            int iZ = n7.m.z(i2);
            this.f7247b[iZ] = (Rect[]) listE.toArray(new Rect[listE.size()]);
            if (i2 != 8) {
                List<Rect> listF = j0Var.f7236a.f(i2);
                this.f7248c[iZ] = (Rect[]) listF.toArray(new Rect[listF.size()]);
            }
        }
    }

    public abstract void c(k2.a aVar);

    public abstract void d(k2.a aVar);

    public abstract void e(k2.a aVar);

    public abstract void f(k2.a aVar);

    public x(j0 j0Var) {
        this.f7247b = new Rect[10][];
        this.f7248c = new Rect[10][];
        this.f7246a = j0Var;
        b(j0Var);
    }
}
