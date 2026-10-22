package androidx.compose.foundation;

import i1.w0;
import kotlin.Metadata;
import m.x;
import n0.l;
import o.a1;
import o.y0;
import q7.k;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/ScrollingLayoutElement;", "Li1/w0;", "Lo/a1;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ScrollingLayoutElement extends w0 {

    /* renamed from: a, reason: collision with root package name */
    public final y0 f716a;

    public ScrollingLayoutElement(y0 y0Var) {
        this.f716a = y0Var;
    }

    @Override // i1.w0
    public final l d() {
        a1 a1Var = new a1();
        a1Var.f7014t = this.f716a;
        a1Var.f7015u = true;
        return a1Var;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ScrollingLayoutElement) {
            return k.a(this.f716a, ((ScrollingLayoutElement) obj).f716a);
        }
        return false;
    }

    @Override // i1.w0
    public final void f(l lVar) {
        a1 a1Var = (a1) lVar;
        a1Var.f7014t = this.f716a;
        a1Var.f7015u = true;
    }

    public final int hashCode() {
        return Boolean.hashCode(true) + x.e(this.f716a.hashCode() * 31, 31, false);
    }
}
