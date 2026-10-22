package C7;

/* loaded from: classes3.dex */
public final class e implements Comparable {
    public static final e e = new e(2, 2, 21);

    /* renamed from: a, reason: collision with root package name */
    public final int f306a;
    public final int b;
    public final int c;
    public final int d;

    public e(int i, int i6, int i10) {
        this.f306a = i;
        this.b = i6;
        this.c = i10;
        if (i >= 0 && i < 256 && i6 >= 0 && i6 < 256 && i10 >= 0 && i10 < 256) {
            this.d = (i << 16) + (i6 << 8) + i10;
            return;
        }
        throw new IllegalArgumentException(("Version components are out of range: " + i + '.' + i6 + '.' + i10).toString());
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        e other = (e) obj;
        kotlin.jvm.internal.k.f(other, "other");
        return this.d - other.d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        e eVar = obj instanceof e ? (e) obj : null;
        return eVar != null && this.d == eVar.d;
    }

    public final int hashCode() {
        return this.d;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f306a);
        sb.append('.');
        sb.append(this.b);
        sb.append('.');
        sb.append(this.c);
        return sb.toString();
    }
}
