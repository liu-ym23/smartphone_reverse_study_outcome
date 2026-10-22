package K;

import android.view.View;
import android.view.WindowInsets;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class w0 extends v0 {

    /* renamed from: f, reason: collision with root package name */
    public static final z0 f1013f = z0.f(null, WindowInsets.CONSUMED);

    public w0(@NonNull z0 z0Var, @NonNull WindowInsets windowInsets) {
        super(z0Var, windowInsets);
    }

    @Override // K.x0
    public final void d(@NonNull View view) {
    }

    @Override // K.x0
    @NonNull
    public D.c f(int i4) {
        return D.c.c(this.f1005c.getInsets(y0.a(i4)));
    }
}
