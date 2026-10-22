package f3;

import android.graphics.Insets;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: e, reason: collision with root package name */
    public static final b f3899e = new b(0, 0, 0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final int f3900a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3901b;

    /* renamed from: c, reason: collision with root package name */
    public final int f3902c;

    /* renamed from: d, reason: collision with root package name */
    public final int f3903d;

    public b(int i, int i3, int i10, int i11) {
        this.f3900a = i;
        this.f3901b = i3;
        this.f3902c = i10;
        this.f3903d = i11;
    }

    public static b a(int i, int i3, int i10, int i11) {
        return (i == 0 && i3 == 0 && i10 == 0 && i11 == 0) ? f3899e : new b(i, i3, i10, i11);
    }

    public static b b(Insets insets) {
        return a(insets.left, insets.top, insets.right, insets.bottom);
    }

    public final Insets c() {
        return Insets.of(this.f3900a, this.f3901b, this.f3902c, this.f3903d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f3903d == bVar.f3903d && this.f3900a == bVar.f3900a && this.f3902c == bVar.f3902c && this.f3901b == bVar.f3901b;
    }

    public final int hashCode() {
        return (((((this.f3900a * 31) + this.f3901b) * 31) + this.f3902c) * 31) + this.f3903d;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Insets{left=");
        sb2.append(this.f3900a);
        sb2.append(", top=");
        sb2.append(this.f3901b);
        sb2.append(", right=");
        sb2.append(this.f3902c);
        sb2.append(", bottom=");
        return androidx.activity.b.l(sb2, this.f3903d, '}');
    }
}
