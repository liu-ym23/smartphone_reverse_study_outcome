package e0;

import android.view.DisplayCutout;
import android.view.WindowInsets;
import java.util.Objects;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class m0 extends l0 {
    public m0(x0 x0Var, WindowInsets windowInsets) {
        super(x0Var, windowInsets);
    }

    @Override // e0.t0
    public x0 a() {
        return x0.c(null, this.f2316c.consumeDisplayCutout());
    }

    @Override // e0.t0
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m0)) {
            return false;
        }
        m0 m0Var = (m0) obj;
        return Objects.equals(this.f2316c, m0Var.f2316c) && Objects.equals(null, null) && k0.z(this.f2317e, m0Var.f2317e);
    }

    @Override // e0.t0
    public d g() {
        DisplayCutout displayCutout = this.f2316c.getDisplayCutout();
        if (displayCutout == null) {
            return null;
        }
        return new d(displayCutout);
    }

    @Override // e0.t0
    public int hashCode() {
        return this.f2316c.hashCode();
    }
}
