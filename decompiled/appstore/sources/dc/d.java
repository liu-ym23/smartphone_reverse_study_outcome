package dc;

import androidx.core.util.Pools$SynchronizedPool;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final a f19162n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Pools$SynchronizedPool f19163o = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f19164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f19165b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f19166c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f19167d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f19168e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f19169f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f19170g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f19171h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public double f19172i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f19173j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f19174k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f19175l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f19176m;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final d a() {
            d r10 = (d) d.a().acquire();
            if (r10 != null) goto L6;
            double r11 = 0.0d;
            long r12 = 0;
            int r13 = 0;
            int r14 = 0;
            int r15 = 0;
            int r16 = 0;
            int r17 = 0;
            int r18 = 0;
            double r19 = 0.0d;
            int r110 = 0;
            int r111 = 0;
            int r112 = 0;
            int r113 = 0;
            return new d(r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, 8191, null);
        L6:
            return r10;
        }

        public a() {
        }
    }

    static {
        f19162n = new a(null);
        f19163o = new Pools$SynchronizedPool(5);
    }

    public d(double r10, long r11, int r12, int r13, int r14, int r15, int r16, int r17, double r18, int r19, int r110, int r111, int r112) {
        this.f19164a = r10;
        this.f19165b = r11;
        this.f19166c = r12;
        this.f19167d = r13;
        this.f19168e = r14;
        this.f19169f = r15;
        this.f19170g = r16;
        this.f19171h = r17;
        this.f19172i = r18;
        this.f19173j = r19;
        this.f19174k = r110;
        this.f19175l = r111;
        this.f19176m = r112;
    }

    public static final /* synthetic */ Pools$SynchronizedPool a() {
        return f19163o;
    }

    public final int b() {
        return this.f19176m;
    }

    public final int c() {
        return this.f19174k;
    }

    public final int d() {
        return this.f19175l;
    }

    public final double e() {
        return this.f19172i;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof d) == true) goto L8;
        return false;
    L8:
        d r11 = (d) r10;
        if (q.b(Double.valueOf(this.f19164a), Double.valueOf(r11.f19164a)) == true) goto L12;
        return false;
    L12:
        if (this.f19165b == r11.f19165b) goto L15;
        return false;
    L15:
        if (this.f19166c == r11.f19166c) goto L18;
        return false;
    L18:
        if (this.f19167d == r11.f19167d) goto L21;
        return false;
    L21:
        if (this.f19168e == r11.f19168e) goto L24;
        return false;
    L24:
        if (this.f19169f == r11.f19169f) goto L27;
        return false;
    L27:
        if (this.f19170g == r11.f19170g) goto L30;
        return false;
    L30:
        if (this.f19171h == r11.f19171h) goto L33;
        return false;
    L33:
        if (q.b(Double.valueOf(this.f19172i), Double.valueOf(r11.f19172i)) == true) goto L36;
        return false;
    L36:
        if (this.f19173j == r11.f19173j) goto L39;
        return false;
    L39:
        if (this.f19174k == r11.f19174k) goto L42;
        return false;
    L42:
        if (this.f19175l == r11.f19175l) goto L45;
        return false;
    L45:
        if (this.f19176m == r11.f19176m) goto L47;
        return false;
    L47:
        return true;
    }

    public final double f() {
        return this.f19164a;
    }

    public final void g() {
        this.f19164a = 0.0d;
        this.f19172i = 0.0d;
        this.f19174k = 0;
        this.f19175l = 0;
        this.f19176m = 0;
        this.f19173j = 0;
        this.f19165b = 0;
        this.f19166c = 0;
        this.f19167d = 0;
        this.f19168e = 0;
        this.f19169f = 0;
        this.f19170g = 0;
        this.f19171h = 0;
        f19163o.release(this);
    }

    public final void h(int r10) {
        this.f19170g = r10;
    }

    public int hashCode() {
        return (((((((((((((((((((((((Double.hashCode(this.f19164a) * 31) + Long.hashCode(this.f19165b)) * 31) + Integer.hashCode(this.f19166c)) * 31) + Integer.hashCode(this.f19167d)) * 31) + Integer.hashCode(this.f19168e)) * 31) + Integer.hashCode(this.f19169f)) * 31) + Integer.hashCode(this.f19170g)) * 31) + Integer.hashCode(this.f19171h)) * 31) + Double.hashCode(this.f19172i)) * 31) + Integer.hashCode(this.f19173j)) * 31) + Integer.hashCode(this.f19174k)) * 31) + Integer.hashCode(this.f19175l)) * 31) + Integer.hashCode(this.f19176m);
    }

    public final void i(int r10) {
        this.f19171h = r10;
    }

    public final void j(int r10) {
        this.f19176m = r10;
    }

    public final void k(int r10) {
        this.f19174k = r10;
    }

    public final void l(int r10) {
        this.f19175l = r10;
    }

    public final void m(double r10) {
        this.f19172i = r10;
    }

    public final void n(long r10) {
        this.f19165b = r10;
    }

    public final void o(int r10) {
        this.f19168e = r10;
    }

    public final void p(int r10) {
        this.f19169f = r10;
    }

    public final void q(double r10) {
        this.f19164a = r10;
    }

    public final void r(int r10) {
        this.f19173j = r10;
    }

    public final void s(int r10) {
        this.f19166c = r10;
    }

    public final void t(int r10) {
        this.f19167d = r10;
    }

    public String toString() {
        return "FpsBean(fps=" + this.f19164a + ", duration=" + this.f19165b + ", startX=" + this.f19166c + ", startY=" + this.f19167d + ", endX=" + this.f19168e + ", endY=" + this.f19169f + ", distantX=" + this.f19170g + ", distantY=" + this.f19171h + ", dropRate=" + this.f19172i + ", frameCount=" + this.f19173j + ", drop3=" + this.f19174k + ", drop7=" + this.f19175l + ", drop25=" + this.f19176m + ')';
    }

    public /* synthetic */ d(double r17, long r19, int r21, int r22, int r23, int r24, int r25, int r26, double r27, int r29, int r30, int r31, int r32, int r33, DefaultConstructorMarker r34) {
        double r10 = 0.0d;
        if ((r33 & 1) == 0) goto L5;
        double r11 = 0.0d;
    L7:
        if ((r33 & 2) == 0) goto L9;
        long r12 = 0;
    L11:
        if ((r33 & 4) == 0) goto L13;
        int r13 = 0;
    L15:
        if ((r33 & 8) == 0) goto L17;
        int r14 = 0;
    L19:
        if ((r33 & 16) == 0) goto L21;
        int r15 = 0;
    L23:
        if ((r33 & 32) == 0) goto L25;
        int r16 = 0;
    L27:
        if ((r33 & 64) == 0) goto L29;
        int r18 = 0;
    L31:
        if ((r33 & 128) == 0) goto L33;
        int r110 = 0;
    L35:
        if ((r33 & 256) != 0) goto L39;
        r10 = r27;
    L39:
        if ((r33 & 512) == 0) goto L41;
        int r111 = 0;
    L43:
        if ((r33 & 1024) == 0) goto L45;
        int r112 = 0;
    L47:
        if ((r33 & 2048) == 0) goto L49;
        int r20 = 0;
    L51:
        if ((r33 & 4096) == 0) goto L53;
        int r28 = 0;
    L54:
        this(r11, r12, r13, r14, r15, r16, r18, r110, r10, r111, r112, r20, r28);
        return;
    L53:
        r28 = r32;
        goto L54
    L49:
        r20 = r31;
        goto L51
    L45:
        r112 = r30;
        goto L47
    L41:
        r111 = r29;
        goto L43
    L33:
        r110 = r26;
        goto L35
    L29:
        r18 = r25;
        goto L31
    L25:
        r16 = r24;
        goto L27
    L21:
        r15 = r23;
        goto L23
    L17:
        r14 = r22;
        goto L19
    L13:
        r13 = r21;
        goto L15
    L9:
        r12 = r19;
        goto L11
    L5:
        r11 = r17;
        goto L7
    }
}
