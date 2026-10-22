package K;

import android.view.DisplayCutout;
import android.view.WindowInsets;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Objects;

/* loaded from: classes.dex */
public abstract class u0 extends t0 {
    public u0(@NonNull z0 z0Var, @NonNull WindowInsets windowInsets) {
        super(z0Var, windowInsets);
    }

    @Override // K.x0
    @NonNull
    public z0 a() {
        return z0.f(null, this.f1005c.consumeDisplayCutout());
    }

    @Override // K.x0
    @Nullable
    public C0075g e() {
        DisplayCutout displayCutout = this.f1005c.getDisplayCutout();
        if (displayCutout == null) {
            return null;
        }
        return new C0075g(displayCutout);
    }

    @Override // K.x0
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u0)) {
            return false;
        }
        u0 u0Var = (u0) obj;
        if (Objects.equals(this.f1005c, u0Var.f1005c)) {
            u0Var.getClass();
            if (Objects.equals(null, null)) {
                return true;
            }
        }
        return false;
    }

    @Override // K.x0
    public int hashCode() {
        return this.f1005c.hashCode();
    }
}
