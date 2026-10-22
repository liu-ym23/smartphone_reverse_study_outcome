package u5;

import java.util.Iterator;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class d implements Iterable, q5.a {

    /* renamed from: a, reason: collision with root package name */
    public final int f5663a;

    /* renamed from: b, reason: collision with root package name */
    public final int f5664b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5665c;

    public d(int i8, int i9, int i10) {
        if (i10 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i10 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f5663a = i8;
        this.f5664b = a.a.J(i8, i9, i10);
        this.f5665c = i10;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        if (isEmpty() && ((d) obj).isEmpty()) {
            return true;
        }
        d dVar = (d) obj;
        return this.f5663a == dVar.f5663a && this.f5664b == dVar.f5664b && this.f5665c == dVar.f5665c;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f5663a * 31) + this.f5664b) * 31) + this.f5665c;
    }

    public boolean isEmpty() {
        int i8 = this.f5665c;
        int i9 = this.f5664b;
        int i10 = this.f5663a;
        return i8 > 0 ? i10 > i9 : i10 < i9;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new e(this.f5663a, this.f5664b, this.f5665c);
    }

    public String toString() {
        StringBuilder sb;
        int i8 = this.f5664b;
        int i9 = this.f5663a;
        int i10 = this.f5665c;
        if (i10 > 0) {
            sb = new StringBuilder();
            sb.append(i9);
            sb.append("..");
            sb.append(i8);
            sb.append(" step ");
        } else {
            sb = new StringBuilder();
            sb.append(i9);
            sb.append(" downTo ");
            sb.append(i8);
            sb.append(" step ");
            i10 = -i10;
        }
        sb.append(i10);
        return sb.toString();
    }
}
