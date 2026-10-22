package d.p;

import com.bytedance.crash.dumper.Scraps;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: Duration.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a implements Comparable<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1042a f38671a = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f38672c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f38673d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final long f38674e = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f38675b;

    /* JADX INFO: renamed from: d.p.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Duration.kt */
    public static final class C1042a {
        public /* synthetic */ C1042a(h r1) {
            this();
        }

        private C1042a() {
        }
    }

    public static boolean a(long r3, Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L6;
        return false;
    L6:
        if (r3 == ((a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin")).a()) goto L8;
        return false;
    L8:
        return true;
    }

    public static final boolean b(long r2) {
        if (r2 >= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static int o(long r0) {
        return Long.hashCode(r0);
    }

    private static final long q(long r1) {
        return r1 >> 1;
    }

    private static final boolean r(long r0) {
        if ((((int) r0) & 1) == 0) goto L7;
        return false;
    L7:
        return true;
    }

    private static final boolean s(long r0) {
        if ((((int) r0) & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final /* synthetic */ long a() {
        return this.f38675b;
    }

    public boolean equals(Object r3) {
        return a(this.f38675b, r3);
    }

    public int hashCode() {
        return o(this.f38675b);
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(a r3) {
        return e(((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.aiagent.plugin")).a());
    }

    private static final d t(long r0) {
        if (r(r0) == false) goto L6;
        return d.f38678a;
    L6:
        return d.f38680c;
    }

    public static long p(long r7) {
        if (b.a() == false) goto L35;
        boolean r1 = true;
        if (r(r7) == false) goto L16;
        long r3 = q(r7);
        if ((-4611686018426999999L) <= r3) goto L9;
    L11:
        r1 = false;
    L12:
        if (r1 == true) goto L35;
        throw new AssertionError(q(r7) + " ns is out of nanoseconds range");
    L9:
        if (r3 >= 4611686018427000000L) goto L11;
    L16:
        long r4 = q(r7);
        if ((-4611686018427387903L) <= r4) goto L19;
    L21:
        boolean r0 = false;
    L22:
        if (r0 == false) goto L34;
        long r5 = q(r7);
        if ((-4611686018426L) <= r5) goto L26;
    L28:
        r1 = false;
    L29:
        if (r1 == false) goto L35;
        throw new AssertionError(q(r7) + " ms is denormalized");
    L26:
        if (r5 >= 4611686018427L) goto L28;
    L34:
        throw new AssertionError(q(r7) + " ms is out of milliseconds range");
    L19:
        if (r4 >= 4611686018427387904L) goto L21;
        r0 = true;
    L35:
        return r7;
    }

    static {
        f38671a = new C1042a(null);
        f38672c = p(0);
        f38673d = c.b(4611686018427387903L);
        f38674e = c.b(-4611686018427387903L);
    }

    public static final long a(long r2) {
        return c.a(-q(r2), ((int) r2) & 1);
    }

    public static final boolean c(long r2) {
        if (r2 != f38673d) goto L5;
    L8:
        return true;
    L5:
        if (r2 == f38674e) goto L8;
        return false;
    }

    public static final long d(long r1) {
        if (b(r1) == true) goto L5;
        return r1;
    L5:
        return a(r1);
    }

    public int e(long r3) {
        return a(this.f38675b, r3);
    }

    public static int a(long r4, long r6) {
        long r0 = r4 ^ r6;
        if (r0 < 0) goto L12;
        if ((((int) r0) & 1) == 0) goto L12;
        int r1 = (((int) r4) & 1) - (((int) r6) & 1);
        if (b(r4) == true) goto L10;
        return r1;
    L10:
        return -r1;
    L12:
        return o.a(r4, r6);
    }

    public static final int f(long r2) {
        if (c(r2) == false) goto L6;
        return 0;
    L6:
        return (int) (k(r2) % ((long) 24));
    }

    public static final int g(long r2) {
        if (c(r2) == false) goto L6;
        return 0;
    L6:
        return (int) (l(r2) % ((long) 60));
    }

    public static final int h(long r2) {
        if (c(r2) == false) goto L6;
        return 0;
    L6:
        return (int) (m(r2) % ((long) 60));
    }

    public static final int i(long r2) {
        if (c(r2) == false) goto L6;
        return 0;
    L6:
        if (s(r2) == false) goto L8;
        long r3 = c.a(q(r2) % ((long) 1000));
    L10:
        return (int) r3;
    L8:
        r3 = q(r2) % ((long) 1000000000);
        goto L10
    }

    public static final long a(long r2, d r4) {
        o.e(r4, Scraps.INNER_UNIT);
        if (r2 != f38673d) goto L6;
        return Long.MAX_VALUE;
    L6:
        if (r2 != f38674e) goto L9;
        return Long.MIN_VALUE;
    L9:
        return e.b(q(r2), t(r2), r4);
    }

    public static final long j(long r1) {
        return a(r1, d.g);
    }

    public static final long k(long r1) {
        return a(r1, d.f);
    }

    public static final long l(long r1) {
        return a(r1, d.f38682e);
    }

    public static final long m(long r1) {
        return a(r1, d.f38681d);
    }

    public String toString() {
        return n(this.f38675b);
    }

    public static String n(long r14) {
        if (r14 != 0) goto L6;
        return "0s";
    L6:
        if (r14 != f38673d) goto L9;
        return "Infinity";
    L9:
        if (r14 != f38674e) goto L11;
        return "-Infinity";
    L11:
        boolean r2 = b(r14);
        StringBuilder r11 = new StringBuilder();
        if (r2 == false) goto L14;
        r11.append('-');
    L14:
        long r3 = d(r14);
        long r5 = j(r3);
        int r7 = f(r3);
        int r8 = g(r3);
        int r9 = h(r3);
        int r10 = i(r3);
        int r1 = 0;
        if (r5 == 0) goto L17;
        boolean r0 = true;
    L18:
        if (r7 == 0) goto L20;
        boolean r4 = true;
    L21:
        if (r8 == 0) goto L23;
        boolean r6 = true;
    L24:
        if (r9 != 0) goto L28;
        if (r10 != 0) goto L28;
        boolean r13 = false;
    L29:
        if (r0 == false) goto L32;
        r11.append(r5).append('d');
        r1 = 1;
    L32:
        if (r4 == true) goto L36;
        if (r0 == false) goto L40;
        if (r6 == true) goto L36;
        if (r13 == true) goto L36;
    L40:
        if (r6 == true) goto L44;
        if (r13 == false) goto L48;
        if (r4 == true) goto L44;
        if (r0 == true) goto L44;
    L48:
        if (r13 == false) goto L66;
        int r15 = r1 + 1;
        if (r1 <= 0) goto L52;
        r11.append(' ');
    L52:
        if (r9 != 0) goto L64;
        if (r0 == true) goto L64;
        if (r4 == true) goto L64;
        if (r6 == true) goto L64;
        if (r10 < 1000000) goto L61;
        a(r14, r11, r10 / 1000000, r10 % 1000000, 6, "ms", false);
    L65:
        r1 = r15;
        goto L66
    L61:
        if (r10 < 1000) goto L63;
        a(r14, r11, r10 / 1000, r10 % 1000, 3, "us", false);
        goto L65
    L63:
        r11.append(r10).append("ns");
    L64:
        a(r14, r11, r9, r10, 9, "s", false);
    L66:
        if (r2 == false) goto L69;
        if (r1 <= 1) goto L69;
        r11.insert(1, '(').append(')');
    L69:
        String r16 = r11.toString();
        o.c(r16, "toString(...)");
        return r16;
    L44:
        int r12 = r1 + 1;
        if (r1 <= 0) goto L47;
        r11.append(' ');
    L47:
        r11.append(r8).append('m');
        r1 = r12;
    L36:
        int r17 = r1 + 1;
        if (r1 <= 0) goto L39;
        r11.append(' ');
    L39:
        r11.append(r7).append('h');
        r1 = r17;
    L28:
        r13 = true;
        goto L29
    L23:
        r6 = false;
        goto L24
    L20:
        r4 = false;
        goto L21
    L17:
        r0 = false;
        goto L18
    }

    private static final void a(long r5, StringBuilder r7, int r8, int r9, int r10, String r11, boolean r12) {
        r7.append(r8);
        if (r9 == 0) goto L20;
        r7.append('.');
        String r6 = d.o.o.a(String.valueOf(r9), r10, '0');
        CharSequence r13 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin");
        int r0 = -1;
        int r14 = r13.length() - 1;
        if (r14 < 0) goto L15;
    L6:
        int r3 = r14 - 1;
        if (r13.charAt(r14) == '0') goto L9;
        boolean r4 = true;
    L10:
        if (r4 == true) goto L11;
        if (r3 < 0) goto L15;
        r14 = r3;
        goto L6
    L11:
        r0 = r14;
        goto L15
    L9:
        r4 = false;
    L15:
        int r1 = r0 + 1;
        if (r12 == true) goto L19;
        if (r1 >= 3) goto L19;
        o.c(r7.append((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"), 0, r1), "append(...)");
    L19:
        o.c(r7.append((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"), 0, ((r1 + 2) / 3) * 3), "append(...)");
    L20:
        r7.append(r11);
    }
}
