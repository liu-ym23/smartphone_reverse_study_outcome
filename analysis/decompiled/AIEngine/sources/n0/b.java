package n0;

import android.graphics.Insets;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: e, reason: collision with root package name */
    public static final b f10587e = new b(0, 0, 0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final int f10588a;

    /* renamed from: b, reason: collision with root package name */
    public final int f10589b;

    /* renamed from: c, reason: collision with root package name */
    public final int f10590c;

    /* renamed from: d, reason: collision with root package name */
    public final int f10591d;

    public b(int i10, int i11, int i12, int i13) {
        this.f10588a = i10;
        this.f10589b = i11;
        this.f10590c = i12;
        this.f10591d = i13;
    }

    public static b a(int i10, int i11, int i12, int i13) {
        return (i10 == 0 && i11 == 0 && i12 == 0 && i13 == 0) ? f10587e : new b(i10, i11, i12, i13);
    }

    public static b b(Insets insets) {
        return a(insets.left, insets.top, insets.right, insets.bottom);
    }

    public final Insets c() {
        return Insets.of(this.f10588a, this.f10589b, this.f10590c, this.f10591d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f10591d == bVar.f10591d && this.f10588a == bVar.f10588a && this.f10590c == bVar.f10590c && this.f10589b == bVar.f10589b;
    }

    public final int hashCode() {
        return (((((this.f10588a * 31) + this.f10589b) * 31) + this.f10590c) * 31) + this.f10591d;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Insets{left=");
        sb2.append(this.f10588a);
        sb2.append(", top=");
        sb2.append(this.f10589b);
        sb2.append(", right=");
        sb2.append(this.f10590c);
        sb2.append(", bottom=");
        return a0.a.l(sb2, this.f10591d, '}');
    }
}
