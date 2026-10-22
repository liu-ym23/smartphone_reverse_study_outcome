package e6;

import android.graphics.drawable.Drawable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class q extends j {

    /* renamed from: a, reason: collision with root package name */
    public final Drawable f3592a;

    /* renamed from: b, reason: collision with root package name */
    public final i f3593b;

    /* renamed from: c, reason: collision with root package name */
    public final v5.f f3594c;

    /* renamed from: d, reason: collision with root package name */
    public final c6.a f3595d;

    /* renamed from: e, reason: collision with root package name */
    public final String f3596e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f3597f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f3598g;

    public q(Drawable drawable, i iVar, v5.f fVar, c6.a aVar, String str, boolean z10, boolean z11) {
        this.f3592a = drawable;
        this.f3593b = iVar;
        this.f3594c = fVar;
        this.f3595d = aVar;
        this.f3596e = str;
        this.f3597f = z10;
        this.f3598g = z11;
    }

    @Override // e6.j
    public final Drawable a() {
        return this.f3592a;
    }

    @Override // e6.j
    public final i b() {
        return this.f3593b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return yb.k.a(this.f3592a, qVar.f3592a) && yb.k.a(this.f3593b, qVar.f3593b) && this.f3594c == qVar.f3594c && yb.k.a(this.f3595d, qVar.f3595d) && yb.k.a(this.f3596e, qVar.f3596e) && this.f3597f == qVar.f3597f && this.f3598g == qVar.f3598g;
    }

    public final int hashCode() {
        int iHashCode = (this.f3594c.hashCode() + ((this.f3593b.hashCode() + (this.f3592a.hashCode() * 31)) * 31)) * 31;
        c6.a aVar = this.f3595d;
        int iHashCode2 = (iHashCode + (aVar != null ? aVar.hashCode() : 0)) * 31;
        String str = this.f3596e;
        return Boolean.hashCode(this.f3598g) + k0.a.h((iHashCode2 + (str != null ? str.hashCode() : 0)) * 31, 31, this.f3597f);
    }
}
