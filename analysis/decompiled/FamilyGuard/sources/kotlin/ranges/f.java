package kotlin.ranges;

import W3.C;
import c4.C0586c;
import k4.InterfaceC0814a;

/* loaded from: classes.dex */
public class f implements Iterable<Integer>, InterfaceC0814a {

    /* renamed from: d, reason: collision with root package name */
    public static final a f17961d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final int f17962a;

    /* renamed from: b, reason: collision with root package name */
    private final int f17963b;

    /* renamed from: c, reason: collision with root package name */
    private final int f17964c;

    public static final class a {
        public /* synthetic */ a(j4.g gVar) {
            this();
        }

        public final f a(int i5, int i6, int i7) {
            return new f(i5, i6, i7);
        }

        private a() {
        }
    }

    public f(int i5, int i6, int i7) {
        if (i7 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i7 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f17962a = i5;
        this.f17963b = C0586c.c(i5, i6, i7);
        this.f17964c = i7;
    }

    public final int a() {
        return this.f17962a;
    }

    public final int c() {
        return this.f17963b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof f)) {
            return false;
        }
        if (isEmpty() && ((f) obj).isEmpty()) {
            return true;
        }
        f fVar = (f) obj;
        return this.f17962a == fVar.f17962a && this.f17963b == fVar.f17963b && this.f17964c == fVar.f17964c;
    }

    public final int f() {
        return this.f17964c;
    }

    @Override // java.lang.Iterable
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public C iterator() {
        return new g(this.f17962a, this.f17963b, this.f17964c);
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f17962a * 31) + this.f17963b) * 31) + this.f17964c;
    }

    public boolean isEmpty() {
        return this.f17964c > 0 ? this.f17962a > this.f17963b : this.f17962a < this.f17963b;
    }

    public String toString() {
        StringBuilder sb;
        int i5;
        if (this.f17964c > 0) {
            sb = new StringBuilder();
            sb.append(this.f17962a);
            sb.append("..");
            sb.append(this.f17963b);
            sb.append(" step ");
            i5 = this.f17964c;
        } else {
            sb = new StringBuilder();
            sb.append(this.f17962a);
            sb.append(" downTo ");
            sb.append(this.f17963b);
            sb.append(" step ");
            i5 = -this.f17964c;
        }
        sb.append(i5);
        return sb.toString();
    }
}
