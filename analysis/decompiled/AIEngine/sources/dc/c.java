package dc;

import java.util.Iterator;
import mb.y;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class c implements Iterable<Integer>, ac.a {

    /* renamed from: a, reason: collision with root package name */
    public final int f8451a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8452b;

    /* renamed from: c, reason: collision with root package name */
    public final int f8453c;

    public c(int i10, int i11, int i12) {
        if (i12 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i12 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f8451a = i10;
        this.f8452b = y.z(i10, i11, i12);
        this.f8453c = i12;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        if (isEmpty() && ((c) obj).isEmpty()) {
            return true;
        }
        c cVar = (c) obj;
        return this.f8451a == cVar.f8451a && this.f8452b == cVar.f8452b && this.f8453c == cVar.f8453c;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f8451a * 31) + this.f8452b) * 31) + this.f8453c;
    }

    public boolean isEmpty() {
        int i10 = this.f8453c;
        int i11 = this.f8452b;
        int i12 = this.f8451a;
        return i10 > 0 ? i12 > i11 : i12 < i11;
    }

    @Override // java.lang.Iterable
    public final Iterator<Integer> iterator() {
        return new d(this.f8451a, this.f8452b, this.f8453c);
    }

    public String toString() {
        StringBuilder sb2;
        int i10 = this.f8452b;
        int i11 = this.f8451a;
        int i12 = this.f8453c;
        if (i12 > 0) {
            sb2 = new StringBuilder();
            sb2.append(i11);
            sb2.append("..");
            sb2.append(i10);
            sb2.append(" step ");
        } else {
            sb2 = new StringBuilder();
            sb2.append(i11);
            sb2.append(" downTo ");
            sb2.append(i10);
            sb2.append(" step ");
            i12 = -i12;
        }
        sb2.append(i12);
        return sb2.toString();
    }
}
