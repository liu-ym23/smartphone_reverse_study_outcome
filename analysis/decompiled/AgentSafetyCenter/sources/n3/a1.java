package n3;

import android.graphics.Rect;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class a1 {

    /* renamed from: a, reason: collision with root package name */
    public final Rect[][] f8685a;

    /* renamed from: b, reason: collision with root package name */
    public final Rect[][] f8686b;

    public a1(m1 m1Var) {
        this.f8685a = new Rect[10][];
        this.f8686b = new Rect[10][];
        c(m1Var);
    }

    public abstract m1 b();

    public void c(m1 m1Var) {
        for (int i = 1; i <= 512; i <<= 1) {
            List<Rect> listF = m1Var.f8737a.f(i);
            int iC = h5.t.C(i);
            this.f8685a[iC] = (Rect[]) listF.toArray(new Rect[listF.size()]);
            if (i != 8) {
                List<Rect> listG = m1Var.f8737a.g(i);
                this.f8686b[iC] = (Rect[]) listG.toArray(new Rect[listG.size()]);
            }
        }
    }

    public abstract void d(f3.b bVar);

    public abstract void e(f3.b bVar);

    public a1() {
        this(new m1(null));
    }

    public final void a() {
    }
}
