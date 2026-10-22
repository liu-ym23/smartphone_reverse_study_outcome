package kotlin.time;

import La.H;
import androidx.exifinterface.media.ExifInterface;
import com.airbnb.lottie.utils.Utils;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.util.date.GMTDateParser;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import v9.C5685n;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b%\b\u0087@\u0018\u0000 O2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001/B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0010\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u0011\u0010\u0005J\u0018\u0010\u0012\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\u000b¢\u0006\u0004\b\u0018\u0010\u000fJ\r\u0010\u0019\u001a\u00020\u000b¢\u0006\u0004\b\u0019\u0010\u000fJ\r\u0010\u001a\u001a\u00020\u000b¢\u0006\u0004\b\u001a\u0010\u000fJ\r\u0010\u001b\u001a\u00020\u000b¢\u0006\u0004\b\u001b\u0010\u000fJ\u0018\u0010\u001c\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010 \u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\u000f\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b#\u0010$J?\u0010,\u001a\u00020+*\u00060%j\u0002`&2\u0006\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\"2\u0006\u0010*\u001a\u00020\u000bH\u0002¢\u0006\u0004\b,\u0010-J\r\u0010.\u001a\u00020\"¢\u0006\u0004\b.\u0010$R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010 R\u0014\u00101\u001a\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b0\u0010\u0005R\u0014\u00104\u001a\u00020\u001e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b2\u00103R\u0011\u00106\u001a\u00020\u00008F¢\u0006\u0006\u001a\u0004\b5\u0010\u0005R\u001a\u0010;\u001a\u00020\u00068@X\u0081\u0004¢\u0006\f\u0012\u0004\b9\u0010:\u001a\u0004\b7\u00108R\u001a\u0010>\u001a\u00020\u00068@X\u0081\u0004¢\u0006\f\u0012\u0004\b=\u0010:\u001a\u0004\b<\u00108R\u001a\u0010A\u001a\u00020\u00068@X\u0081\u0004¢\u0006\f\u0012\u0004\b@\u0010:\u001a\u0004\b?\u00108R\u001a\u0010D\u001a\u00020\u00068@X\u0081\u0004¢\u0006\f\u0012\u0004\bC\u0010:\u001a\u0004\bB\u00108R\u0011\u0010F\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\bE\u0010\u0005R\u0011\u0010H\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\bG\u0010\u0005R\u0011\u0010J\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\bI\u0010\u0005R\u0011\u0010L\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\bK\u0010\u0005R\u0011\u0010N\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\bM\u0010\u0005\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006P"}, d2 = {"Lkotlin/time/a;", "", "", "rawValue", "l", "(J)J", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "D", "(J)Z", "C", "L", "H", "(JJ)J", "thisMillis", "otherNanos", "c", "(JJJ)J", "F", "G", ExifInterface.LONGITUDE_EAST, "B", "k", "(JJ)I", "Lkotlin/time/DurationUnit;", "unit", "J", "(JLkotlin/time/DurationUnit;)J", "", "K", "(J)Ljava/lang/String;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "whole", "fractional", "fractionalSize", "isoZeroes", "LY8/t;", "e", "(JLjava/lang/StringBuilder;IIILjava/lang/String;Z)V", "I", Const.INTENT_KEY_APIKEY, "z", UxipConstants.f30680s, "y", "(J)Lkotlin/time/DurationUnit;", "storageUnit", "o", "absoluteValue", "p", "(J)I", "getHoursComponent$annotations", "()V", "hoursComponent", "v", "getMinutesComponent$annotations", "minutesComponent", "x", "getSecondsComponent$annotations", "secondsComponent", "w", "getNanosecondsComponent$annotations", "nanosecondsComponent", "q", "inWholeDays", "r", "inWholeHours", "t", "inWholeMinutes", "u", "inWholeSeconds", "s", "inWholeMilliseconds", Const.INTENT_KEY_PKGNAME, "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class a implements Comparable<a> {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    public static final long f36189c = l(0);

    /* renamed from: d, reason: collision with root package name */
    public static final long f36190d = b.j(4611686018427387903L);

    /* renamed from: e, reason: collision with root package name */
    public static final long f36191e = b.j(-4611686018427387903L);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final long rawValue;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\f¨\u0006\u000f"}, d2 = {"Lkotlin/time/a$a;", "", "<init>", "()V", "", UxipConstants.f30680s, "Lkotlin/time/a;", "c", "(Ljava/lang/String;)J", "ZERO", "J", Const.INTENT_KEY_PKGNAME, "()J", "INFINITE", Const.INTENT_KEY_APIKEY, "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: kotlin.time.a$a, reason: collision with other inner class name and from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final long a() {
            return a.f36190d;
        }

        public final long b() {
            return a.f36189c;
        }

        public final long c(String value) {
            p.i(value, "value");
            try {
                return b.p(value, true);
            } catch (IllegalArgumentException e10) {
                throw new IllegalArgumentException("Invalid ISO duration string format: '" + value + "'.", e10);
            }
        }

        public Companion() {
        }
    }

    public /* synthetic */ a(long j10) {
        this.rawValue = j10;
    }

    public static int A(long j10) {
        return Long.hashCode(j10);
    }

    public static final boolean B(long j10) {
        return !E(j10);
    }

    public static final boolean C(long j10) {
        return (((int) j10) & 1) == 1;
    }

    public static final boolean D(long j10) {
        return (((int) j10) & 1) == 0;
    }

    public static final boolean E(long j10) {
        return j10 == f36190d || j10 == f36191e;
    }

    public static final boolean F(long j10) {
        return j10 < 0;
    }

    public static final boolean G(long j10) {
        return j10 > 0;
    }

    public static final long H(long j10, long j11) {
        if (E(j10)) {
            if (B(j11) || (j11 ^ j10) >= 0) {
                return j10;
            }
            throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
        }
        if (E(j11)) {
            return j11;
        }
        if ((((int) j10) & 1) != (((int) j11) & 1)) {
            return C(j10) ? c(j10, z(j10), z(j11)) : c(j10, z(j11), z(j10));
        }
        long jZ = z(j10) + z(j11);
        return D(j10) ? b.m(jZ) : b.k(jZ);
    }

    public static final String I(long j10) {
        StringBuilder sb2 = new StringBuilder();
        if (F(j10)) {
            sb2.append('-');
        }
        sb2.append("PT");
        long jO = o(j10);
        long jR = r(jO);
        int iV = v(jO);
        int iX = x(jO);
        int iW = w(jO);
        long j11 = E(j10) ? 9999999999999L : jR;
        boolean z10 = false;
        boolean z11 = j11 != 0;
        boolean z12 = (iX == 0 && iW == 0) ? false : true;
        if (iV != 0 || (z12 && z11)) {
            z10 = true;
        }
        if (z11) {
            sb2.append(j11);
            sb2.append('H');
        }
        if (z10) {
            sb2.append(iV);
            sb2.append(GMTDateParser.MONTH);
        }
        if (z12 || (!z11 && !z10)) {
            e(j10, sb2, iX, iW, 9, ExifInterface.LATITUDE_SOUTH, true);
        }
        return sb2.toString();
    }

    public static final long J(long j10, DurationUnit unit) {
        p.i(unit, "unit");
        if (j10 == f36190d) {
            return Long.MAX_VALUE;
        }
        if (j10 == f36191e) {
            return Long.MIN_VALUE;
        }
        return Ma.c.b(z(j10), y(j10), unit);
    }

    public static String K(long j10) {
        if (j10 == 0) {
            return "0s";
        }
        if (j10 == f36190d) {
            return "Infinity";
        }
        if (j10 == f36191e) {
            return "-Infinity";
        }
        boolean zF = F(j10);
        StringBuilder sb2 = new StringBuilder();
        if (zF) {
            sb2.append('-');
        }
        long jO = o(j10);
        long jQ = q(jO);
        int iP = p(jO);
        int iV = v(jO);
        int iX = x(jO);
        int iW = w(jO);
        int i10 = 0;
        boolean z10 = jQ != 0;
        boolean z11 = iP != 0;
        boolean z12 = iV != 0;
        boolean z13 = (iX == 0 && iW == 0) ? false : true;
        if (z10) {
            sb2.append(jQ);
            sb2.append(GMTDateParser.DAY_OF_MONTH);
            i10 = 1;
        }
        if (z11 || (z10 && (z12 || z13))) {
            int i11 = i10 + 1;
            if (i10 > 0) {
                sb2.append(' ');
            }
            sb2.append(iP);
            sb2.append(GMTDateParser.HOURS);
            i10 = i11;
        }
        if (z12 || (z13 && (z11 || z10))) {
            int i12 = i10 + 1;
            if (i10 > 0) {
                sb2.append(' ');
            }
            sb2.append(iV);
            sb2.append(GMTDateParser.MINUTES);
            i10 = i12;
        }
        if (z13) {
            int i13 = i10 + 1;
            if (i10 > 0) {
                sb2.append(' ');
            }
            if (iX != 0 || z10 || z11 || z12) {
                e(j10, sb2, iX, iW, 9, "s", false);
            } else if (iW >= 1000000) {
                e(j10, sb2, iW / 1000000, iW % 1000000, 6, Const.SP_KEY_GSM_UPLOAD_MXSIZE, false);
            } else if (iW >= 1000) {
                e(j10, sb2, iW / 1000, iW % 1000, 3, "us", false);
            } else {
                sb2.append(iW);
                sb2.append("ns");
            }
            i10 = i13;
        }
        if (zF && i10 > 1) {
            sb2.insert(1, '(').append(')');
        }
        return sb2.toString();
    }

    public static final long L(long j10) {
        return b.i(-z(j10), ((int) j10) & 1);
    }

    public static final long c(long j10, long j11, long j12) {
        long jO = b.o(j12);
        long j13 = j11 + jO;
        if (-4611686018426L > j13 || j13 >= 4611686018427L) {
            return b.j(C5685n.o(j13, -4611686018427387903L, 4611686018427387903L));
        }
        return b.l(b.n(j13) + (j12 - b.n(jO)));
    }

    public static final void e(long j10, StringBuilder sb2, int i10, int i11, int i12, String str, boolean z10) {
        sb2.append(i10);
        if (i11 != 0) {
            sb2.append('.');
            String strJ0 = H.J0(String.valueOf(i11), i12, '0');
            int i13 = -1;
            int length = strJ0.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i14 = length - 1;
                    if (strJ0.charAt(length) != '0') {
                        i13 = length;
                        break;
                    } else if (i14 < 0) {
                        break;
                    } else {
                        length = i14;
                    }
                }
            }
            int i15 = i13 + 1;
            if (z10 || i15 >= 3) {
                sb2.append((CharSequence) strJ0, 0, ((i13 + 3) / 3) * 3);
                p.h(sb2, "append(...)");
            } else {
                sb2.append((CharSequence) strJ0, 0, i15);
                p.h(sb2, "append(...)");
            }
        }
        sb2.append(str);
    }

    public static final /* synthetic */ a i(long j10) {
        return new a(j10);
    }

    public static int k(long j10, long j11) {
        long j12 = j10 ^ j11;
        if (j12 < 0 || (((int) j12) & 1) == 0) {
            return p.l(j10, j11);
        }
        int i10 = (((int) j10) & 1) - (((int) j11) & 1);
        return F(j10) ? -i10 : i10;
    }

    public static long l(long j10) {
        if (!Ma.b.a()) {
            return j10;
        }
        if (D(j10)) {
            long jZ = z(j10);
            if (-4611686018426999999L <= jZ && jZ < 4611686018427000000L) {
                return j10;
            }
            throw new AssertionError(z(j10) + " ns is out of nanoseconds range");
        }
        long jZ2 = z(j10);
        if (-4611686018427387903L > jZ2 || jZ2 >= 4611686018427387904L) {
            throw new AssertionError(z(j10) + " ms is out of milliseconds range");
        }
        long jZ3 = z(j10);
        if (-4611686018426L > jZ3 || jZ3 >= 4611686018427L) {
            return j10;
        }
        throw new AssertionError(z(j10) + " ms is denormalized");
    }

    public static boolean m(long j10, Object obj) {
        return (obj instanceof a) && j10 == ((a) obj).getRawValue();
    }

    public static final boolean n(long j10, long j11) {
        return j10 == j11;
    }

    public static final long o(long j10) {
        return F(j10) ? L(j10) : j10;
    }

    public static final int p(long j10) {
        if (E(j10)) {
            return 0;
        }
        return (int) (r(j10) % 24);
    }

    public static final long q(long j10) {
        return J(j10, DurationUnit.DAYS);
    }

    public static final long r(long j10) {
        return J(j10, DurationUnit.HOURS);
    }

    public static final long s(long j10) {
        return (C(j10) && B(j10)) ? z(j10) : J(j10, DurationUnit.MILLISECONDS);
    }

    public static final long t(long j10) {
        return J(j10, DurationUnit.MINUTES);
    }

    public static final long u(long j10) {
        return J(j10, DurationUnit.SECONDS);
    }

    public static final int v(long j10) {
        if (E(j10)) {
            return 0;
        }
        return (int) (t(j10) % 60);
    }

    public static final int w(long j10) {
        if (E(j10)) {
            return 0;
        }
        return (int) (C(j10) ? b.n(z(j10) % 1000) : z(j10) % Utils.SECOND_IN_NANOS);
    }

    public static final int x(long j10) {
        if (E(j10)) {
            return 0;
        }
        return (int) (u(j10) % 60);
    }

    public static final DurationUnit y(long j10) {
        return D(j10) ? DurationUnit.NANOSECONDS : DurationUnit.MILLISECONDS;
    }

    public static final long z(long j10) {
        return j10 >> 1;
    }

    /* renamed from: M, reason: from getter */
    public final /* synthetic */ long getRawValue() {
        return this.rawValue;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(a aVar) {
        return j(aVar.getRawValue());
    }

    public boolean equals(Object other) {
        return m(this.rawValue, other);
    }

    public int hashCode() {
        return A(this.rawValue);
    }

    public int j(long j10) {
        return k(this.rawValue, j10);
    }

    public String toString() {
        return K(this.rawValue);
    }
}
