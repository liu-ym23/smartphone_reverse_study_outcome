package e0;

import android.graphics.Rect;
import java.util.List;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class j0 {

    /* renamed from: a, reason: collision with root package name */
    public final x0 f2313a;

    /* renamed from: b, reason: collision with root package name */
    public final Rect[][] f2314b;

    /* renamed from: c, reason: collision with root package name */
    public final Rect[][] f2315c;

    public j0() {
        this(new x0());
    }

    public abstract x0 b();

    public void c(x0 x0Var) {
        for (int i8 = 1; i8 <= 512; i8 <<= 1) {
            List<Rect> listE = x0Var.f2338a.e(i8);
            int iT = b8.h.t(i8);
            this.f2314b[iT] = (Rect[]) listE.toArray(new Rect[listE.size()]);
            if (i8 != 8) {
                List<Rect> listF = x0Var.f2338a.f(i8);
                this.f2315c[iT] = (Rect[]) listF.toArray(new Rect[listF.size()]);
            }
        }
    }

    public abstract void d(x.b bVar);

    public abstract void e(x.b bVar);

    public abstract void f(x.b bVar);

    public abstract void g(x.b bVar);

    public j0(x0 x0Var) {
        this.f2314b = new Rect[10][];
        this.f2315c = new Rect[10][];
        this.f2313a = x0Var;
        c(x0Var);
    }

    public final void a() {
    }
}
