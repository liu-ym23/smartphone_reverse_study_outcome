package androidx.compose.ui.layout;

import android.annotation.SuppressLint;
import b0.n;
import java.lang.invoke.VarHandle;
import s1.p;
import s1.s0;
import u1.f;
import u1.g0;
import u1.y0;
import w0.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
@SuppressLint({"ModifierNodeInspectableProperties"})
/* loaded from: classes.dex */
final class RulerProviderModifierElement extends y0 {

    /* renamed from: c, reason: collision with root package name */
    public p f976c;

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        RulerProviderModifierElement rulerProviderModifierElement = obj instanceof RulerProviderModifierElement ? (RulerProviderModifierElement) obj : null;
        return (rulerProviderModifierElement != null ? rulerProviderModifierElement.f976c : null) == this.f976c;
    }

    @Override // u1.y0
    public final l g() {
        p pVar = this.f976c;
        s0 s0Var = new s0();
        s0Var.f11294s = pVar;
        s0Var.f11295t = new n(18, s0Var, pVar);
        VarHandle.storeStoreFence();
        return s0Var;
    }

    public final int hashCode() {
        return this.f976c.hashCode();
    }

    @Override // u1.y0
    public final void i(l lVar) {
        s0 s0Var = (s0) lVar;
        p pVar = this.f976c;
        if (s0Var.f11294s != pVar) {
            s0Var.f11294s = pVar;
            g0.V(f.u(s0Var), false, 7);
        }
    }
}
