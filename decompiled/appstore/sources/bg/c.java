package bg;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.OpenEndRange;

/* JADX INFO: loaded from: classes4.dex */
public final class c extends bg.a implements ClosedRange, OpenEndRange {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f6005e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c f6006f = null;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final c a() {
            return c.e();
        }

        public a() {
        }
    }

    static {
        f6005e = new a(null);
        f6006f = new c(1, 0);
    }

    public c(int r10, int r11) {
        super(r10, r11, 1);
    }

    public static final /* synthetic */ c e() {
        return f6006f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.ranges.ClosedRange, kotlin.ranges.OpenEndRange
    public /* bridge */ /* synthetic */ boolean contains(Comparable r10) {
        return f(((Number) r10).intValue());
    }

    @Override // bg.a
    public boolean equals(Object r10) {
        if ((r10 instanceof c) == true) goto L5;
    L13:
        return false;
    L5:
        if (isEmpty() == true) goto L7;
    L8:
        c r11 = (c) r10;
        if (a() != r11.a()) goto L13;
        if (b() != r11.b()) goto L13;
    L12:
        return true;
    L7:
        if (((c) r10).isEmpty() == true) goto L12;
        goto L8
    }

    public boolean f(int r10) {
        if (a() <= r10) goto L5;
    L7:
        return false;
    L5:
        if (r10 > b()) goto L7;
        return true;
    }

    public Integer g() {
        if (b() == Integer.MAX_VALUE) goto L7;
        return Integer.valueOf(b() + 1);
    L7:
        throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.");
    }

    @Override // kotlin.ranges.OpenEndRange
    public /* bridge */ /* synthetic */ Comparable getEndExclusive() {
        return g();
    }

    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ Comparable getEndInclusive() {
        return h();
    }

    @Override // kotlin.ranges.ClosedRange, kotlin.ranges.OpenEndRange
    public /* bridge */ /* synthetic */ Comparable getStart() {
        return i();
    }

    public Integer h() {
        return Integer.valueOf(b());
    }

    @Override // bg.a
    public int hashCode() {
        if (isEmpty() == false) goto L5;
        return -1;
    L5:
        int r10 = a() * 31;
        return b() + r10;
    }

    public Integer i() {
        return Integer.valueOf(a());
    }

    @Override // bg.a, kotlin.ranges.ClosedRange, kotlin.ranges.OpenEndRange
    public boolean isEmpty() {
        if (a() <= b()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // bg.a
    public String toString() {
        return a() + ".." + b();
    }
}
