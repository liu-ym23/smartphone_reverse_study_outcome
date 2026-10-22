package androidx.compose.foundation.layout;

import u1.y0;
import w0.e;
import w0.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
final class BoxChildDataElement extends y0 {

    /* renamed from: c, reason: collision with root package name */
    public final e f874c;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f875f;

    public BoxChildDataElement(e eVar, boolean z10) {
        this.f874c = eVar;
        this.f875f = z10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        BoxChildDataElement boxChildDataElement = obj instanceof BoxChildDataElement ? (BoxChildDataElement) obj : null;
        return boxChildDataElement != null && this.f874c.equals(boxChildDataElement.f874c) && this.f875f == boxChildDataElement.f875f;
    }

    @Override // u1.y0
    public final l g() {
        w.l lVar = new w.l();
        lVar.f15000s = this.f874c;
        lVar.f15001t = this.f875f;
        return lVar;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f875f) + (this.f874c.hashCode() * 31);
    }

    @Override // u1.y0
    public final void i(l lVar) {
        w.l lVar2 = (w.l) lVar;
        lVar2.f15000s = this.f874c;
        lVar2.f15001t = this.f875f;
    }
}
