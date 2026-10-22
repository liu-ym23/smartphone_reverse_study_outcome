package D;

import android.graphics.Insets;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: e, reason: collision with root package name */
    public static final c f356e = new c(0, 0, 0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final int f357a;

    /* renamed from: b, reason: collision with root package name */
    public final int f358b;

    /* renamed from: c, reason: collision with root package name */
    public final int f359c;

    /* renamed from: d, reason: collision with root package name */
    public final int f360d;

    public c(int i4, int i5, int i6, int i7) {
        this.f357a = i4;
        this.f358b = i5;
        this.f359c = i6;
        this.f360d = i7;
    }

    public static c a(c cVar, c cVar2) {
        return b(Math.max(cVar.f357a, cVar2.f357a), Math.max(cVar.f358b, cVar2.f358b), Math.max(cVar.f359c, cVar2.f359c), Math.max(cVar.f360d, cVar2.f360d));
    }

    public static c b(int i4, int i5, int i6, int i7) {
        return (i4 == 0 && i5 == 0 && i6 == 0 && i7 == 0) ? f356e : new c(i4, i5, i6, i7);
    }

    public static c c(Insets insets) {
        return b(insets.left, insets.top, insets.right, insets.bottom);
    }

    public final Insets d() {
        return b.a(this.f357a, this.f358b, this.f359c, this.f360d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        return this.f360d == cVar.f360d && this.f357a == cVar.f357a && this.f359c == cVar.f359c && this.f358b == cVar.f358b;
    }

    public final int hashCode() {
        return (((((this.f357a * 31) + this.f358b) * 31) + this.f359c) * 31) + this.f360d;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Insets{left=");
        sb.append(this.f357a);
        sb.append(", top=");
        sb.append(this.f358b);
        sb.append(", right=");
        sb.append(this.f359c);
        sb.append(", bottom=");
        return B0.g.o(sb, this.f360d, '}');
    }
}
