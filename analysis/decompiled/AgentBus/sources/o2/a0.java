package o2;

import android.view.DisplayCutout;
import android.view.WindowInsets;
import java.util.Objects;

/* loaded from: classes.dex */
public abstract class a0 extends z {
    public a0(j0 j0Var, WindowInsets windowInsets) {
        super(j0Var, windowInsets);
    }

    @Override // o2.g0
    public j0 a() {
        return j0.a(null, this.f7249b.consumeDisplayCutout());
    }

    @Override // o2.g0
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a0)) {
            return false;
        }
        a0 a0Var = (a0) obj;
        return Objects.equals(this.f7249b, a0Var.f7249b) && Objects.equals(null, null) && y.z(this.f7251d, a0Var.f7251d);
    }

    @Override // o2.g0
    public c g() {
        DisplayCutout displayCutout = this.f7249b.getDisplayCutout();
        if (displayCutout == null) {
            return null;
        }
        return new c(displayCutout);
    }

    @Override // o2.g0
    public int hashCode() {
        return this.f7249b.hashCode();
    }
}
