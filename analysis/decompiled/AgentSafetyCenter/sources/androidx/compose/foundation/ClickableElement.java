package androidx.compose.foundation;

import a2.g;
import t.r;
import t.t0;
import u1.y0;
import v.k;
import w0.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
final class ClickableElement extends y0 {

    /* renamed from: c, reason: collision with root package name */
    public final k f843c;

    /* renamed from: f, reason: collision with root package name */
    public final t0 f844f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f845g;

    /* renamed from: h, reason: collision with root package name */
    public final String f846h;
    public final g i;

    /* renamed from: j, reason: collision with root package name */
    public final xb.a f847j;

    public ClickableElement(k kVar, t0 t0Var, boolean z10, String str, g gVar, xb.a aVar) {
        this.f843c = kVar;
        this.f844f = t0Var;
        this.f845g = z10;
        this.f846h = str;
        this.i = gVar;
        this.f847j = aVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ClickableElement.class != obj.getClass()) {
            return false;
        }
        ClickableElement clickableElement = (ClickableElement) obj;
        return yb.k.a(this.f843c, clickableElement.f843c) && yb.k.a(this.f844f, clickableElement.f844f) && this.f845g == clickableElement.f845g && yb.k.a(this.f846h, clickableElement.f846h) && yb.k.a(this.i, clickableElement.i) && this.f847j == clickableElement.f847j;
    }

    @Override // u1.y0
    public final l g() {
        return new r(this.f843c, this.f844f, this.f845g, this.f846h, this.i, this.f847j);
    }

    public final int hashCode() {
        k kVar = this.f843c;
        int iHashCode = (kVar != null ? kVar.hashCode() : 0) * 31;
        t0 t0Var = this.f844f;
        int iH = k0.a.h((iHashCode + (t0Var != null ? t0Var.hashCode() : 0)) * 31, 31, this.f845g);
        String str = this.f846h;
        int iHashCode2 = (iH + (str != null ? str.hashCode() : 0)) * 31;
        g gVar = this.i;
        return this.f847j.hashCode() + ((iHashCode2 + (gVar != null ? Integer.hashCode(gVar.f45a) : 0)) * 31);
    }

    @Override // u1.y0
    public final void i(l lVar) {
        ((r) lVar).I0(this.f843c, this.f844f, this.f845g, this.f846h, this.i, this.f847j);
    }
}
