package e0;

import android.view.View;
import android.view.WindowInsets;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class q0 extends p0 {

    /* renamed from: j, reason: collision with root package name */
    public static final x0 f2328j = x0.c(null, WindowInsets.CONSUMED);

    public q0(x0 x0Var, WindowInsets windowInsets) {
        super(x0Var, windowInsets);
    }

    @Override // e0.o0, e0.k0, e0.t0
    public x.b h(int i8) {
        return x.b.c(this.f2316c.getInsets(w0.a(i8)));
    }

    @Override // e0.o0, e0.k0
    public x.b y(int i8) {
        return x.b.c(this.f2316c.getInsetsIgnoringVisibility(w0.a(i8)));
    }

    @Override // e0.k0, e0.t0
    public void k(View view) {
    }
}
