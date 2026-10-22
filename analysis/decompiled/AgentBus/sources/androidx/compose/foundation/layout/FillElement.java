package androidx.compose.foundation.layout;

import i1.w0;
import kotlin.Metadata;
import n.f;
import n0.l;
import r.u;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/layout/FillElement;", "Li1/w0;", "Lr/u;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FillElement extends w0 {

    /* renamed from: a, reason: collision with root package name */
    public final int f730a;

    public FillElement(int i2) {
        this.f730a = i2;
    }

    @Override // i1.w0
    public final l d() {
        u uVar = new u();
        uVar.f8940t = this.f730a;
        uVar.f8941u = 1.0f;
        return uVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FillElement) {
            return this.f730a == ((FillElement) obj).f730a;
        }
        return false;
    }

    @Override // i1.w0
    public final void f(l lVar) {
        u uVar = (u) lVar;
        uVar.f8940t = this.f730a;
        uVar.f8941u = 1.0f;
    }

    public final int hashCode() {
        return Float.hashCode(1.0f) + (f.d(this.f730a) * 31);
    }
}
