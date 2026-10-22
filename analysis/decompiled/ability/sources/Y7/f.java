package Y7;

/* loaded from: classes3.dex */
public final class f extends d implements c {
    public static final f d = new f(1, 0, 1);

    public final boolean e(int i) {
        return this.f1569a <= i && i <= this.b;
    }

    @Override // Y7.d
    public final boolean equals(Object obj) {
        if (!(obj instanceof f)) {
            return false;
        }
        if (isEmpty() && ((f) obj).isEmpty()) {
            return true;
        }
        f fVar = (f) obj;
        return this.f1569a == fVar.f1569a && this.b == fVar.b;
    }

    @Override // Y7.c
    public final Comparable getEndInclusive() {
        return Integer.valueOf(this.b);
    }

    @Override // Y7.c
    public final Comparable getStart() {
        return Integer.valueOf(this.f1569a);
    }

    @Override // Y7.d
    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (this.f1569a * 31) + this.b;
    }

    @Override // Y7.d
    public final boolean isEmpty() {
        return this.f1569a > this.b;
    }

    @Override // Y7.d
    public final String toString() {
        return this.f1569a + ".." + this.b;
    }
}
