package y5;

import k4.v;
import kotlin.jvm.internal.p;
import org.tukaani.xz.common.Util;
import x5.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b implements Comparable {

    /* renamed from: b, reason: collision with root package name */
    public static final a f6335b = new a();

    /* renamed from: c, reason: collision with root package name */
    public static final long f6336c = g.d(4611686018427387903L);
    public static final long d = g.d(-4611686018427387903L);

    /* renamed from: e, reason: collision with root package name */
    public static final long f6337e = 9223372036854759646L;

    /* renamed from: a, reason: collision with root package name */
    public final long f6338a;

    public static final long a(long j4, long j8) {
        long j9 = 1000000;
        long j10 = j8 / j9;
        long jA = g.a(j4, j10);
        if (-4611686018426L > jA || jA >= 4611686018427L) {
            return g.d(jA);
        }
        long j11 = ((jA * j9) + (j8 - (j10 * j9))) << 1;
        int i8 = c.f6339a;
        return j11;
    }

    public static final void b(StringBuilder sb, int i8, int i9, int i10, String str, boolean z) {
        sb.append(i8);
        if (i9 != 0) {
            sb.append('.');
            String strZ1 = n.z1(i10, String.valueOf(i9));
            int i11 = -1;
            int length = strZ1.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i12 = length - 1;
                    if (strZ1.charAt(length) != '0') {
                        i11 = length;
                        break;
                    } else if (i12 < 0) {
                        break;
                    } else {
                        length = i12;
                    }
                }
            }
            int i13 = i11 + 1;
            if (z || i13 >= 3) {
                sb.append((CharSequence) strZ1, 0, ((i11 + 3) / 3) * 3);
            } else {
                sb.append((CharSequence) strZ1, 0, i13);
            }
        }
        sb.append(str);
    }

    public static final int c(long j4) {
        if (d(j4)) {
            return 0;
        }
        return (int) ((((int) j4) & 1) == 1 ? ((j4 >> 1) % 1000) * 1000000 : (j4 >> 1) % 1000000000);
    }

    public static final boolean d(long j4) {
        return j4 == f6336c || j4 == d;
    }

    public static final long e(long j4, long j8) {
        int i8 = ((int) j4) & 1;
        if (i8 != (((int) j8) & 1)) {
            return i8 == 1 ? a(j4 >> 1, j8 >> 1) : a(j8 >> 1, j4 >> 1);
        }
        if (i8 == 0) {
            long j9 = (j4 >> 1) + (j8 >> 1);
            if (-4611686018426999999L > j9 || j9 >= 4611686018427000000L) {
                return g.d(j9 / 1000000);
            }
            long j10 = j9 << 1;
            int i9 = c.f6339a;
            return j10;
        }
        long jA = g.a(j4 >> 1, j8 >> 1);
        if (jA == 9223372036854759646L) {
            throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
        }
        if (jA == 4611686018427387903L || jA == -4611686018427387903L) {
            return g.d(jA);
        }
        if (-4611686018426L > jA || jA >= 4611686018427L) {
            return g.d(v.o(jA, -4611686018427387903L, 4611686018427387903L));
        }
        long j11 = (jA * 1000000) << 1;
        int i10 = c.f6339a;
        return j11;
    }

    public static final long f(long j4, d unit) {
        p.e(unit, "unit");
        if (j4 == f6336c) {
            return Util.VLI_MAX;
        }
        if (j4 == d) {
            return Long.MIN_VALUE;
        }
        long j8 = j4 >> 1;
        d sourceUnit = (((int) j4) & 1) == 0 ? d.f6340b : d.f6341c;
        p.e(sourceUnit, "sourceUnit");
        return unit.f6346a.convert(j8, sourceUnit.f6346a);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        long j4 = ((b) obj).f6338a;
        long j8 = this.f6338a;
        long j9 = j8 ^ j4;
        if (j9 < 0 || (((int) j9) & 1) == 0) {
            return p.h(j8, j4);
        }
        int i8 = (((int) j8) & 1) - (((int) j4) & 1);
        return j8 < 0 ? -i8 : i8;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof b) {
            return this.f6338a == ((b) obj).f6338a;
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.f6338a);
    }

    public final String toString() {
        long j4;
        int iF;
        long j8 = this.f6338a;
        if (j8 == 0) {
            return "0s";
        }
        if (j8 == f6336c) {
            return "Infinity";
        }
        if (j8 == d) {
            return "-Infinity";
        }
        int i8 = 0;
        boolean z = j8 < 0;
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append('-');
        }
        if (j8 < 0) {
            j8 = (((int) j8) & 1) + ((-(j8 >> 1)) << 1);
            int i9 = c.f6339a;
        }
        long jF = f(j8, d.f6344g);
        int iF2 = d(j8) ? 0 : (int) (f(j8, d.f6343f) % 24);
        if (d(j8)) {
            j4 = 0;
            iF = 0;
        } else {
            j4 = 0;
            iF = (int) (f(j8, d.f6342e) % 60);
        }
        int iF3 = d(j8) ? 0 : (int) (f(j8, d.d) % 60);
        int iC = c(j8);
        boolean z2 = jF != j4;
        boolean z8 = iF2 != 0;
        boolean z9 = iF != 0;
        boolean z10 = (iF3 == 0 && iC == 0) ? false : true;
        if (z2) {
            sb.append(jF);
            sb.append('d');
            i8 = 1;
        }
        if (z8 || (z2 && (z9 || z10))) {
            int i10 = i8 + 1;
            if (i8 > 0) {
                sb.append(' ');
            }
            sb.append(iF2);
            sb.append('h');
            i8 = i10;
        }
        if (z9 || (z10 && (z8 || z2))) {
            int i11 = i8 + 1;
            if (i8 > 0) {
                sb.append(' ');
            }
            sb.append(iF);
            sb.append('m');
            i8 = i11;
        }
        if (z10) {
            int i12 = i8 + 1;
            if (i8 > 0) {
                sb.append(' ');
            }
            if (iF3 != 0 || z2 || z8 || z9) {
                b(sb, iF3, iC, 9, "s", false);
            } else if (iC >= 1000000) {
                b(sb, iC / 1000000, iC % 1000000, 6, "ms", false);
            } else if (iC >= 1000) {
                b(sb, iC / 1000, iC % 1000, 3, "us", false);
            } else {
                sb.append(iC);
                sb.append("ns");
            }
            i8 = i12;
        }
        if (z && i8 > 1) {
            sb.insert(1, '(').append(')');
        }
        return sb.toString();
    }
}
