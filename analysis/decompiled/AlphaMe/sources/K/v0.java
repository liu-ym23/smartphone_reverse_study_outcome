package K;

import android.view.WindowInsets;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public abstract class v0 extends u0 {
    public v0(@NonNull z0 z0Var, @NonNull WindowInsets windowInsets) {
        super(z0Var, windowInsets);
    }

    @Override // K.x0
    @NonNull
    public z0 i(int i4, int i5, int i6, int i7) {
        return z0.f(null, this.f1005c.inset(i4, i5, i6, i7));
    }
}
