package kotlin.time;

import bg.f;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlin.text.StringsKt__StringsKt;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f21273a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f21274b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f21275c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f21276d = 0;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final long a() {
            return b.a();
        }

        public a() {
        }
    }

    static {
        f21273a = new a(null);
        f21274b = d(0);
        f21275c = d.b(4611686018427387903L);
        f21276d = d.b(-4611686018427387903L);
    }

    public static final /* synthetic */ long a() {
        return f21274b;
    }

    public static final void b(long r10, StringBuilder r11, int r12, int r13, int r14, String r15, boolean r16) {
        r11.append(r12);
        if (r13 == 0) goto L17;
        r11.append('.');
        String r17 = StringsKt__StringsKt.b0(String.valueOf(r13), r14, '0');
        int r18 = -1;
        int r19 = r17.length() - 1;
        if (r19 < 0) goto L12;
    L6:
        int r20 = r19 - 1;
        if (r17.charAt(r19) != '0') goto L8;
        if (r20 < 0) goto L12;
        r19 = r20;
        goto L6
    L8:
        r18 = r19;
    L12:
        int r21 = r18 + 1;
        if (r16 == true) goto L16;
        if (r21 >= 3) goto L16;
        r11.append(r17, 0, r21);
        q.f(r11, "append(...)");
    L16:
        r11.append(r17, 0, ((r18 + 3) / 3) * 3);
        q.f(r11, "append(...)");
    L17:
        r11.append(r15);
    }

    public static int c(long r10, long r11) {
        long r12 = r10 ^ r11;
        if (r12 < 0) goto L12;
        if ((((int) r12) & 1) == 0) goto L12;
        int r13 = (((int) r10) & 1) - (((int) r11) & 1);
        if (u(r10) == true) goto L10;
        return r13;
    L10:
        return -r13;
    L12:
        return q.j(r10, r11);
    }

    public static long d(long r10) {
        if (c.a() == true) goto L5;
    L20:
        return r10;
    L5:
        if (s(r10) == false) goto L12;
        if (new f(-4611686018426999999L, 4611686018426999999L).d(p(r10)) == true) goto L20;
        throw new AssertionError(p(r10) + " ns is out of nanoseconds range");
    L12:
        if (new f(-4611686018427387903L, 4611686018427387903L).d(p(r10)) == false) goto L19;
        if (new f(-4611686018426L, 4611686018426L).d(p(r10)) == false) goto L20;
        throw new AssertionError(p(r10) + " ms is denormalized");
    L19:
        throw new AssertionError(p(r10) + " ms is out of milliseconds range");
    }

    public static final long e(long r10) {
        if (u(r10) == true) goto L5;
        return r10;
    L5:
        return x(r10);
    }

    public static final int f(long r10) {
        if (t(r10) == false) goto L6;
        return 0;
    L6:
        return (int) (h(r10) % ((long) 24));
    }

    public static final long g(long r10) {
        return v(r10, DurationUnit.DAYS);
    }

    public static final long h(long r10) {
        return v(r10, DurationUnit.HOURS);
    }

    public static final long i(long r10) {
        if (r(r10) == false) goto L8;
        if (q(r10) == false) goto L8;
        return p(r10);
    L8:
        return v(r10, DurationUnit.MILLISECONDS);
    }

    public static final long j(long r10) {
        return v(r10, DurationUnit.MINUTES);
    }

    public static final long k(long r10) {
        return v(r10, DurationUnit.SECONDS);
    }

    public static final int l(long r10) {
        if (t(r10) == false) goto L6;
        return 0;
    L6:
        return (int) (j(r10) % ((long) 60));
    }

    public static final int m(long r10) {
        if (t(r10) == false) goto L6;
        return 0;
    L6:
        if (r(r10) == false) goto L9;
        long r11 = d.c(p(r10) % ((long) 1000));
    L11:
        return (int) r11;
    L9:
        r11 = p(r10) % ((long) 1000000000);
        goto L11
    }

    public static final int n(long r10) {
        if (t(r10) == false) goto L6;
        return 0;
    L6:
        return (int) (k(r10) % ((long) 60));
    }

    public static final DurationUnit o(long r10) {
        if (s(r10) == false) goto L6;
        return DurationUnit.NANOSECONDS;
    L6:
        return DurationUnit.MILLISECONDS;
    }

    public static final long p(long r10) {
        return r10 >> 1;
    }

    public static final boolean q(long r10) {
        return !t(r10);
    }

    public static final boolean r(long r10) {
        if ((((int) r10) & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static final boolean s(long r10) {
        if ((((int) r10) & 1) == 0) goto L7;
        return false;
    L7:
        return true;
    }

    public static final boolean t(long r10) {
        if (r10 != f21275c) goto L5;
    L8:
        return true;
    L5:
        if (r10 == f21276d) goto L8;
        return false;
    }

    public static final boolean u(long r10) {
        if (r10 >= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final long v(long r10, DurationUnit r11) {
        q.g(r11, "unit");
        if (r10 != f21275c) goto L6;
        return Long.MAX_VALUE;
    L6:
        if (r10 != f21276d) goto L9;
        return Long.MIN_VALUE;
    L9:
        return e.a(p(r10), o(r10), r11);
    }

    public static String w(long r14) {
        if (r14 != 0) goto L6;
        return "0s";
    L6:
        if (r14 != f21275c) goto L9;
        return "Infinity";
    L9:
        if (r14 != f21276d) goto L11;
        return "-Infinity";
    L11:
        boolean r10 = u(r14);
        StringBuilder r11 = new StringBuilder();
        if (r10 == false) goto L14;
        r11.append('-');
    L14:
        long r12 = e(r14);
        long r13 = g(r12);
        int r15 = f(r12);
        int r16 = l(r12);
        int r17 = n(r12);
        int r18 = m(r12);
        int r19 = 0;
        if (r13 == 0) goto L17;
        boolean r20 = true;
    L18:
        if (r15 == 0) goto L20;
        boolean r21 = true;
    L21:
        if (r16 == 0) goto L23;
        boolean r22 = true;
    L24:
        if (r17 != 0) goto L28;
        if (r18 != 0) goto L28;
        boolean r110 = false;
    L29:
        if (r20 == false) goto L32;
        r11.append(r13);
        r11.append('d');
        r19 = 1;
    L32:
        if (r21 == true) goto L36;
        if (r20 == false) goto L40;
        if (r22 == true) goto L36;
        if (r110 == true) goto L36;
    L40:
        if (r22 == true) goto L44;
        if (r110 == false) goto L48;
        if (r21 == true) goto L44;
        if (r20 == true) goto L44;
    L48:
        if (r110 == false) goto L66;
        int r111 = r19 + 1;
        if (r19 <= 0) goto L52;
        r11.append(TokenParser.SP);
    L52:
        if (r17 != 0) goto L64;
        if (r20 == true) goto L64;
        if (r21 == true) goto L64;
        if (r22 == true) goto L64;
        if (r18 < 1000000) goto L61;
        b(r14, r11, r18 / 1000000, r18 % 1000000, 6, "ms", false);
    L65:
        r19 = r111;
        goto L66
    L61:
        if (r18 < 1000) goto L63;
        b(r14, r11, r18 / 1000, r18 % 1000, 3, "us", false);
        goto L65
    L63:
        r11.append(r18);
        r11.append("ns");
    L64:
        b(r14, r11, r17, r18, 9, "s", false);
    L66:
        if (r10 == false) goto L69;
        if (r19 <= 1) goto L69;
        r11.insert(1, '(').append(')');
    L69:
        String r112 = r11.toString();
        q.f(r112, "toString(...)");
        return r112;
    L44:
        int r23 = r19 + 1;
        if (r19 <= 0) goto L47;
        r11.append(TokenParser.SP);
    L47:
        r11.append(r16);
        r11.append('m');
        r19 = r23;
    L36:
        int r24 = r19 + 1;
        if (r19 <= 0) goto L39;
        r11.append(TokenParser.SP);
    L39:
        r11.append(r15);
        r11.append('h');
        r19 = r24;
    L28:
        r110 = true;
        goto L29
    L23:
        r22 = false;
        goto L24
    L20:
        r21 = false;
        goto L21
    L17:
        r20 = false;
        goto L18
    }

    public static final long x(long r10) {
        return d.a(-p(r10), ((int) r10) & 1);
    }
}
