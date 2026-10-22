package K;

import android.view.WindowInsets;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public abstract class t0 extends s0 {

    /* renamed from: e, reason: collision with root package name */
    public D.c f1007e;

    public t0(@NonNull z0 z0Var, @NonNull WindowInsets windowInsets) {
        super(z0Var, windowInsets);
        this.f1007e = null;
    }

    @Override // K.x0
    @NonNull
    public z0 b() {
        return z0.f(null, this.f1005c.consumeStableInsets());
    }

    @Override // K.x0
    @NonNull
    public z0 c() {
        return z0.f(null, this.f1005c.consumeSystemWindowInsets());
    }

    @Override // K.x0
    @NonNull
    public final D.c g() {
        if (this.f1007e == null) {
            WindowInsets windowInsets = this.f1005c;
            this.f1007e = D.c.b(windowInsets.getStableInsetLeft(), windowInsets.getStableInsetTop(), windowInsets.getStableInsetRight(), windowInsets.getStableInsetBottom());
        }
        return this.f1007e;
    }

    @Override // K.x0
    public boolean j() {
        return this.f1005c.isConsumed();
    }
}
