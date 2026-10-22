package v5;

import android.graphics.drawable.BitmapDrawable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final BitmapDrawable f14788a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f14789b;

    public g(BitmapDrawable bitmapDrawable, boolean z10) {
        this.f14788a = bitmapDrawable;
        this.f14789b = z10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.f14788a.equals(gVar.f14788a) && this.f14789b == gVar.f14789b;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f14789b) + (this.f14788a.hashCode() * 31);
    }
}
