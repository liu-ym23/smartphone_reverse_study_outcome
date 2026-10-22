package n3;

import android.view.DisplayCutout;
import android.view.WindowInsets;
import java.lang.invoke.VarHandle;
import java.util.Objects;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class d1 extends c1 {
    public d1(m1 m1Var, WindowInsets windowInsets) {
        super(m1Var, windowInsets);
    }

    @Override // n3.j1
    public m1 a() {
        return m1.h(null, this.f8687c.consumeDisplayCutout());
    }

    @Override // n3.b1, n3.j1
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d1)) {
            return false;
        }
        d1 d1Var = (d1) obj;
        return Objects.equals(this.f8687c, d1Var.f8687c) && Objects.equals(this.f8691g, d1Var.f8691g) && b1.K(this.f8692h, d1Var.f8692h);
    }

    @Override // n3.j1
    public f h() {
        DisplayCutout displayCutout = this.f8687c.getDisplayCutout();
        if (displayCutout == null) {
            return null;
        }
        f fVar = new f();
        fVar.f8712a = displayCutout;
        VarHandle.storeStoreFence();
        return fVar;
    }

    @Override // n3.j1
    public int hashCode() {
        return this.f8687c.hashCode();
    }

    public d1(m1 m1Var, d1 d1Var) {
        super(m1Var, d1Var);
    }
}
