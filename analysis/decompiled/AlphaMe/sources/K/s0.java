package K;

import android.view.WindowInsets;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public abstract class s0 extends x0 {

    /* renamed from: c, reason: collision with root package name */
    public final WindowInsets f1005c;

    /* renamed from: d, reason: collision with root package name */
    public D.c f1006d;

    public s0(@NonNull z0 z0Var, @NonNull WindowInsets windowInsets) {
        super(z0Var);
        this.f1006d = null;
        this.f1005c = windowInsets;
    }

    @Override // K.x0
    @NonNull
    public final D.c h() {
        if (this.f1006d == null) {
            WindowInsets windowInsets = this.f1005c;
            this.f1006d = D.c.b(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
        }
        return this.f1006d;
    }

    @Override // K.x0
    public boolean k() {
        return this.f1005c.isRound();
    }

    @Override // K.x0
    public void l(D.c[] cVarArr) {
    }

    @Override // K.x0
    public void m(@Nullable z0 z0Var) {
    }
}
