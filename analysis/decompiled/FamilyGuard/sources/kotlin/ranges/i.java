package kotlin.ranges;

import W3.D;
import c4.C0586c;
import k4.InterfaceC0814a;

/* loaded from: classes.dex */
public class i implements Iterable<Long>, InterfaceC0814a {

    /* renamed from: d, reason: collision with root package name */
    public static final a f17971d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final long f17972a;

    /* renamed from: b, reason: collision with root package name */
    private final long f17973b;

    /* renamed from: c, reason: collision with root package name */
    private final long f17974c;

    public static final class a {
        public /* synthetic */ a(j4.g gVar) {
            this();
        }

        private a() {
        }
    }

    public i(long j5, long j6, long j7) {
        if (j7 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j7 == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        this.f17972a = j5;
        this.f17973b = C0586c.d(j5, j6, j7);
        this.f17974c = j7;
    }

    public final long a() {
        return this.f17972a;
    }

    public final long c() {
        return this.f17973b;
    }

    @Override // java.lang.Iterable
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public D iterator() {
        return new j(this.f17972a, this.f17973b, this.f17974c);
    }
}
