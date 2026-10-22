package k2;

import android.graphics.Insets;
import m.x;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: e, reason: collision with root package name */
    public static final a f5574e = new a(0, 0, 0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final int f5575a;

    /* renamed from: b, reason: collision with root package name */
    public final int f5576b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5577c;

    /* renamed from: d, reason: collision with root package name */
    public final int f5578d;

    public a(int i2, int i10, int i11, int i12) {
        this.f5575a = i2;
        this.f5576b = i10;
        this.f5577c = i11;
        this.f5578d = i12;
    }

    public static a a(a aVar, a aVar2) {
        return b(Math.max(aVar.f5575a, aVar2.f5575a), Math.max(aVar.f5576b, aVar2.f5576b), Math.max(aVar.f5577c, aVar2.f5577c), Math.max(aVar.f5578d, aVar2.f5578d));
    }

    public static a b(int i2, int i10, int i11, int i12) {
        return (i2 == 0 && i10 == 0 && i11 == 0 && i12 == 0) ? f5574e : new a(i2, i10, i11, i12);
    }

    public static a c(Insets insets) {
        return b(insets.left, insets.top, insets.right, insets.bottom);
    }

    public final Insets d() {
        return Insets.of(this.f5575a, this.f5576b, this.f5577c, this.f5578d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return this.f5578d == aVar.f5578d && this.f5575a == aVar.f5575a && this.f5577c == aVar.f5577c && this.f5576b == aVar.f5576b;
    }

    public final int hashCode() {
        return (((((this.f5575a * 31) + this.f5576b) * 31) + this.f5577c) * 31) + this.f5578d;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Insets{left=");
        sb2.append(this.f5575a);
        sb2.append(", top=");
        sb2.append(this.f5576b);
        sb2.append(", right=");
        sb2.append(this.f5577c);
        sb2.append(", bottom=");
        return x.m(sb2, this.f5578d, '}');
    }
}
