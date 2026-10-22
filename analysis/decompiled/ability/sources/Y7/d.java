package Y7;

import Z6.k;

/* loaded from: classes3.dex */
public class d implements Iterable, T7.a {

    /* renamed from: a, reason: collision with root package name */
    public final int f1569a;
    public final int b;
    public final int c;

    public d(int i, int i6, int i10) {
        if (i10 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i10 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f1569a = i;
        this.b = k.D(i, i6, i10);
        this.c = i10;
    }

    @Override // java.lang.Iterable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final e iterator() {
        return new e(this.f1569a, this.b, this.c);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        if (isEmpty() && ((d) obj).isEmpty()) {
            return true;
        }
        d dVar = (d) obj;
        return this.f1569a == dVar.f1569a && this.b == dVar.b && this.c == dVar.c;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f1569a * 31) + this.b) * 31) + this.c;
    }

    public boolean isEmpty() {
        int i = this.c;
        int i6 = this.b;
        int i10 = this.f1569a;
        return i > 0 ? i10 > i6 : i10 < i6;
    }

    public String toString() {
        StringBuilder sb;
        int i = this.b;
        int i6 = this.f1569a;
        int i10 = this.c;
        if (i10 > 0) {
            sb = new StringBuilder();
            sb.append(i6);
            sb.append("..");
            sb.append(i);
            sb.append(" step ");
        } else {
            sb = new StringBuilder();
            sb.append(i6);
            sb.append(" downTo ");
            sb.append(i);
            sb.append(" step ");
            i10 = -i10;
        }
        sb.append(i10);
        return sb.toString();
    }
}
