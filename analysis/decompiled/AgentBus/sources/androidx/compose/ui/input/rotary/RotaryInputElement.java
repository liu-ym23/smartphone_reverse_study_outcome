package androidx.compose.ui.input.rotary;

import i1.w0;
import j1.r;
import kotlin.Metadata;
import n0.l;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/ui/input/rotary/RotaryInputElement;", "Li1/w0;", "Le1/a;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
final class RotaryInputElement extends w0 {
    @Override // i1.w0
    public final l d() {
        r rVar = r.f5307j;
        e1.a aVar = new e1.a();
        aVar.f3045t = rVar;
        return aVar;
    }

    public final boolean equals(Object obj) {
        return this == obj || (obj instanceof RotaryInputElement);
    }

    @Override // i1.w0
    public final void f(l lVar) {
        ((e1.a) lVar).f3045t = r.f5307j;
    }

    public final int hashCode() {
        return r.f5307j.hashCode() * 31;
    }
}
