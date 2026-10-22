package d8;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b1 extends w2 {

    /* renamed from: m, reason: collision with root package name */
    public static final DecimalFormat f1944m;

    /* renamed from: n, reason: collision with root package name */
    public static final DecimalFormat f1945n;

    /* renamed from: f, reason: collision with root package name */
    public long f1946f;

    /* renamed from: g, reason: collision with root package name */
    public long f1947g;

    /* renamed from: h, reason: collision with root package name */
    public long f1948h;

    /* renamed from: j, reason: collision with root package name */
    public long f1949j;

    /* renamed from: k, reason: collision with root package name */
    public long f1950k;

    /* renamed from: l, reason: collision with root package name */
    public long f1951l;

    static {
        DecimalFormat decimalFormat = new DecimalFormat();
        f1944m = decimalFormat;
        decimalFormat.setMinimumIntegerDigits(2);
        DecimalFormat decimalFormat2 = new DecimalFormat();
        f1945n = decimalFormat2;
        decimalFormat2.setMinimumIntegerDigits(3);
    }

    public static long o(int i8) throws l4 {
        long j4 = i8 >> 4;
        int i9 = i8 & 15;
        if (j4 > 9 || i9 > 9) {
            throw new l4("Invalid LOC Encoding");
        }
        while (true) {
            int i10 = i9 - 1;
            if (i9 <= 0) {
                return j4;
            }
            j4 *= 10;
            i9 = i10;
        }
    }

    public static String p(long j4, char c3, char c8) {
        StringBuilder sb = new StringBuilder();
        long j8 = j4 - 2147483648L;
        if (j8 < 0) {
            j8 = -j8;
            c3 = c8;
        }
        sb.append(j8 / 3600000);
        long j9 = j8 % 3600000;
        sb.append(" ");
        sb.append(j9 / 60000);
        sb.append(" ");
        q(sb, f1945n, j9 % 60000, 1000L);
        sb.append(" ");
        sb.append(c3);
        return sb.toString();
    }

    public static void q(StringBuilder sb, NumberFormat numberFormat, long j4, long j8) {
        sb.append(j4 / j8);
        long j9 = j4 % j8;
        if (j9 != 0) {
            sb.append(".");
            sb.append(numberFormat.format(j9));
        }
    }

    public static int r(long j4) {
        byte b9 = 0;
        while (j4 > 9) {
            b9 = (byte) (b9 + 1);
            j4 /= 10;
        }
        return (int) ((j4 << 4) + (b9 & 255));
    }

    @Override // d8.w2
    public final void j(u uVar) throws l4 {
        if (uVar.f() != 0) {
            throw new l4("Invalid LOC version");
        }
        this.f1946f = o(uVar.f());
        this.f1947g = o(uVar.f());
        this.f1948h = o(uVar.f());
        this.f1949j = uVar.e();
        this.f1950k = uVar.e();
        this.f1951l = uVar.e();
    }

    @Override // d8.w2
    public final String k() {
        StringBuilder sb = new StringBuilder();
        sb.append(p(this.f1949j, 'N', 'S'));
        sb.append(" ");
        sb.append(p(this.f1950k, 'E', 'W'));
        sb.append(" ");
        long j4 = this.f1951l - 10000000;
        DecimalFormat decimalFormat = f1944m;
        q(sb, decimalFormat, j4, 100L);
        sb.append("m ");
        q(sb, decimalFormat, this.f1946f, 100L);
        sb.append("m ");
        q(sb, decimalFormat, this.f1947g, 100L);
        sb.append("m ");
        q(sb, decimalFormat, this.f1948h, 100L);
        sb.append("m");
        return sb.toString();
    }

    @Override // d8.w2
    public final void l(b0.j jVar, n nVar, boolean z) {
        jVar.m(0);
        jVar.m(r(this.f1946f));
        jVar.m(r(this.f1947g));
        jVar.m(r(this.f1948h));
        jVar.l(this.f1949j);
        jVar.l(this.f1950k);
        jVar.l(this.f1951l);
    }
}
