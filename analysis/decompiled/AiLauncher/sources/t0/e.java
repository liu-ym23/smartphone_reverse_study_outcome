package t0;

import android.graphics.Insets;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: e, reason: collision with root package name */
    public static final e f41976e = new e(0, 0, 0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final int f41977a;

    /* renamed from: b, reason: collision with root package name */
    public final int f41978b;

    /* renamed from: c, reason: collision with root package name */
    public final int f41979c;

    /* renamed from: d, reason: collision with root package name */
    public final int f41980d;

    public static class a {
        public static Insets a(int i10, int i11, int i12, int i13) {
            return Insets.of(i10, i11, i12, i13);
        }
    }

    public e(int i10, int i11, int i12, int i13) {
        this.f41977a = i10;
        this.f41978b = i11;
        this.f41979c = i12;
        this.f41980d = i13;
    }

    public static e a(e eVar, e eVar2) {
        return b(Math.max(eVar.f41977a, eVar2.f41977a), Math.max(eVar.f41978b, eVar2.f41978b), Math.max(eVar.f41979c, eVar2.f41979c), Math.max(eVar.f41980d, eVar2.f41980d));
    }

    public static e b(int i10, int i11, int i12, int i13) {
        return (i10 == 0 && i11 == 0 && i12 == 0 && i13 == 0) ? f41976e : new e(i10, i11, i12, i13);
    }

    public static e c(Insets insets) {
        return b(insets.left, insets.top, insets.right, insets.bottom);
    }

    public Insets d() {
        return a.a(this.f41977a, this.f41978b, this.f41979c, this.f41980d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        return this.f41980d == eVar.f41980d && this.f41977a == eVar.f41977a && this.f41979c == eVar.f41979c && this.f41978b == eVar.f41978b;
    }

    public int hashCode() {
        return (((((this.f41977a * 31) + this.f41978b) * 31) + this.f41979c) * 31) + this.f41980d;
    }

    public String toString() {
        return "Insets{left=" + this.f41977a + ", top=" + this.f41978b + ", right=" + this.f41979c + ", bottom=" + this.f41980d + '}';
    }
}
