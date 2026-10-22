package androidx.compose.ui.layout;

import java.lang.invoke.VarHandle;
import s1.k0;
import u1.y0;
import xb.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
final class OnSizeChangedModifier extends y0 {

    /* renamed from: c, reason: collision with root package name */
    public l f975c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof OnSizeChangedModifier) && this.f975c == ((OnSizeChangedModifier) obj).f975c;
    }

    @Override // u1.y0
    public final w0.l g() {
        l lVar = this.f975c;
        k0 k0Var = new k0();
        k0Var.f11262s = lVar;
        long j10 = Integer.MIN_VALUE;
        k0Var.f11263t = (j10 & 4294967295L) | (j10 << 32);
        VarHandle.storeStoreFence();
        return k0Var;
    }

    public final int hashCode() {
        return this.f975c.hashCode();
    }

    @Override // u1.y0
    public final void i(w0.l lVar) {
        k0 k0Var = (k0) lVar;
        k0Var.f11262s = this.f975c;
        long j10 = Integer.MIN_VALUE;
        k0Var.f11263t = (j10 & 4294967295L) | (j10 << 32);
    }
}
