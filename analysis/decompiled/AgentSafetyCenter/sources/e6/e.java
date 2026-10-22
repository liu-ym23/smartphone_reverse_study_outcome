package e6;

import android.graphics.drawable.Drawable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e extends j {

    /* renamed from: a, reason: collision with root package name */
    public Drawable f3525a;

    /* renamed from: b, reason: collision with root package name */
    public i f3526b;

    /* renamed from: c, reason: collision with root package name */
    public Throwable f3527c;

    @Override // e6.j
    public final Drawable a() {
        return this.f3525a;
    }

    @Override // e6.j
    public final i b() {
        return this.f3526b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return yb.k.a(this.f3525a, eVar.f3525a) && yb.k.a(this.f3526b, eVar.f3526b) && this.f3527c.equals(eVar.f3527c);
    }

    public final int hashCode() {
        Drawable drawable = this.f3525a;
        int iHashCode = drawable != null ? drawable.hashCode() : 0;
        return this.f3527c.hashCode() + ((this.f3526b.hashCode() + (iHashCode * 31)) * 31);
    }
}
