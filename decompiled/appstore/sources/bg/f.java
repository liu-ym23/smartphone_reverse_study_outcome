package bg;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.OpenEndRange;

/* JADX INFO: loaded from: classes4.dex */
public final class f extends d implements ClosedRange, OpenEndRange {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f6015e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final f f6016f = null;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f6015e = new a(null);
        f6016f = new f(1, 0);
    }

    public f(long r10, long r11) {
        super(r10, r11, 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.ranges.ClosedRange, kotlin.ranges.OpenEndRange
    public /* bridge */ /* synthetic */ boolean contains(Comparable r10) {
        return d(((Number) r10).longValue());
    }

    public boolean d(long r10) {
        if (a() <= r10) goto L5;
    L7:
        return false;
    L5:
        if (r10 > b()) goto L7;
        return true;
    }

    public Long e() {
        if (b() == Long.MAX_VALUE) goto L7;
        return Long.valueOf(b() + 1);
    L7:
        throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.");
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof f) == true) goto L5;
    L13:
        return false;
    L5:
        if (isEmpty() == true) goto L7;
    L8:
        f r11 = (f) r10;
        if (a() != r11.a()) goto L13;
        if (b() != r11.b()) goto L13;
    L12:
        return true;
    L7:
        if (((f) r10).isEmpty() == true) goto L12;
        goto L8
    }

    public Long f() {
        return Long.valueOf(b());
    }

    public Long g() {
        return Long.valueOf(a());
    }

    @Override // kotlin.ranges.OpenEndRange
    public /* bridge */ /* synthetic */ Comparable getEndExclusive() {
        return e();
    }

    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ Comparable getEndInclusive() {
        return f();
    }

    @Override // kotlin.ranges.ClosedRange, kotlin.ranges.OpenEndRange
    public /* bridge */ /* synthetic */ Comparable getStart() {
        return g();
    }

    public int hashCode() {
        if (isEmpty() == false) goto L6;
        return -1;
    L6:
        return (int) ((((long) 31) * (a() ^ (a() >>> 32))) + (b() ^ (b() >>> 32)));
    }

    @Override // kotlin.ranges.ClosedRange, kotlin.ranges.OpenEndRange
    public boolean isEmpty() {
        if (a() <= b()) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        return a() + ".." + b();
    }
}
