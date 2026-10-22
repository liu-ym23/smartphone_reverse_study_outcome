package v7;

import java.util.Iterator;

/* loaded from: classes.dex */
public class b implements Iterable, r7.a {

    /* renamed from: f, reason: collision with root package name */
    public final int f10523f;

    /* renamed from: g, reason: collision with root package name */
    public final int f10524g;

    /* renamed from: h, reason: collision with root package name */
    public final int f10525h;

    public b(int i2, int i10, int i11) {
        if (i11 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i11 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f10523f = i2;
        this.f10524g = ib.c.B(i2, i10, i11);
        this.f10525h = i11;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        if (isEmpty() && ((b) obj).isEmpty()) {
            return true;
        }
        b bVar = (b) obj;
        return this.f10523f == bVar.f10523f && this.f10524g == bVar.f10524g && this.f10525h == bVar.f10525h;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f10523f * 31) + this.f10524g) * 31) + this.f10525h;
    }

    public boolean isEmpty() {
        int i2 = this.f10525h;
        int i10 = this.f10524g;
        int i11 = this.f10523f;
        return i2 > 0 ? i11 > i10 : i11 < i10;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new c(this.f10523f, this.f10524g, this.f10525h);
    }

    public String toString() {
        StringBuilder sb2;
        int i2 = this.f10524g;
        int i10 = this.f10523f;
        int i11 = this.f10525h;
        if (i11 > 0) {
            sb2 = new StringBuilder();
            sb2.append(i10);
            sb2.append("..");
            sb2.append(i2);
            sb2.append(" step ");
        } else {
            sb2 = new StringBuilder();
            sb2.append(i10);
            sb2.append(" downTo ");
            sb2.append(i2);
            sb2.append(" step ");
            i11 = -i11;
        }
        sb2.append(i11);
        return sb2.toString();
    }
}
