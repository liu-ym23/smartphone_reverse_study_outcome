package y5;

import android.graphics.drawable.Drawable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d extends e {

    /* renamed from: a, reason: collision with root package name */
    public final Drawable f15905a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f15906b;

    /* renamed from: c, reason: collision with root package name */
    public final v5.f f15907c;

    public d(Drawable drawable, boolean z10, v5.f fVar) {
        this.f15905a = drawable;
        this.f15906b = z10;
        this.f15907c = fVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return yb.k.a(this.f15905a, dVar.f15905a) && this.f15906b == dVar.f15906b && this.f15907c == dVar.f15907c;
    }

    public final int hashCode() {
        return this.f15907c.hashCode() + k0.a.h(this.f15905a.hashCode() * 31, 31, this.f15906b);
    }
}
