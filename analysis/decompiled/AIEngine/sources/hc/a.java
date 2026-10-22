package hc;

import androidx.datastore.preferences.protobuf.b1;
import dc.h;
import gc.q;
import kotlin.jvm.internal.g;
import kotlin.time.DurationUnit;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a implements Comparable<a> {

    /* renamed from: b, reason: collision with root package name */
    public static final long f9401b;

    /* renamed from: c, reason: collision with root package name */
    public static final long f9402c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f9403d = 0;

    /* renamed from: a, reason: collision with root package name */
    public final long f9404a;

    static {
        int i10 = b.f9405a;
        f9401b = b1.A(4611686018427387903L);
        f9402c = b1.A(-4611686018427387903L);
    }

    public static final long a(long j10, long j11) {
        long j12 = 1000000;
        long j13 = j11 / j12;
        long j14 = j10 + j13;
        if (-4611686018426L > j14 || j14 >= 4611686018427L) {
            return b1.A(h.b0(j14, -4611686018427387903L, 4611686018427387903L));
        }
        return b1.C((j14 * j12) + (j11 - (j13 * j12)));
    }

    public static final void b(StringBuilder sb2, int i10, int i11, int i12, String str, boolean z) {
        sb2.append(i10);
        if (i11 != 0) {
            sb2.append('.');
            String strX0 = q.x0(i12, String.valueOf(i11));
            int i13 = -1;
            int length = strX0.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i14 = length - 1;
                    if (strX0.charAt(length) != '0') {
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
            if (z || i15 >= 3) {
                sb2.append((CharSequence) strX0, 0, ((i13 + 3) / 3) * 3);
            } else {
                sb2.append((CharSequence) strX0, 0, i15);
            }
        }
        sb2.append(str);
    }

    public static final int c(long j10) {
        if (d(j10)) {
            return 0;
        }
        return (int) ((((int) j10) & 1) == 1 ? ((j10 >> 1) % 1000) * 1000000 : (j10 >> 1) % 1000000000);
    }

    public static final boolean d(long j10) {
        return j10 == f9401b || j10 == f9402c;
    }

    public static final long e(long j10, long j11) {
        if (d(j10)) {
            if (!d(j11) || (j11 ^ j10) >= 0) {
                return j10;
            }
            throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
        }
        if (d(j11)) {
            return j11;
        }
        int i10 = ((int) j10) & 1;
        if (i10 != (((int) j11) & 1)) {
            return i10 == 1 ? a(j10 >> 1, j11 >> 1) : a(j11 >> 1, j10 >> 1);
        }
        long j12 = (j10 >> 1) + (j11 >> 1);
        return i10 == 0 ? (-4611686018426999999L > j12 || j12 >= 4611686018427000000L) ? b1.A(j12 / 1000000) : b1.C(j12) : b1.B(j12);
    }

    public static final long g(long j10, DurationUnit unit) {
        g.f(unit, "unit");
        if (j10 == f9401b) {
            return Long.MAX_VALUE;
        }
        if (j10 == f9402c) {
            return Long.MIN_VALUE;
        }
        long j11 = j10 >> 1;
        DurationUnit sourceUnit = (((int) j10) & 1) == 0 ? DurationUnit.f10099b : DurationUnit.f10100c;
        g.f(sourceUnit, "sourceUnit");
        return unit.f10105a.convert(j11, sourceUnit.f10105a);
    }

    @Override // java.lang.Comparable
    public final int compareTo(a aVar) {
        long j10 = aVar.f9404a;
        long j11 = this.f9404a;
        long j12 = j11 ^ j10;
        if (j12 < 0 || (((int) j12) & 1) == 0) {
            return g.h(j11, j10);
        }
        int i10 = (((int) j11) & 1) - (((int) j10) & 1);
        return j11 < 0 ? -i10 : i10;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof a) {
            return this.f9404a == ((a) obj).f9404a;
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.f9404a);
    }

    public final String toString() {
        long j10;
        int iG;
        long j11 = this.f9404a;
        if (j11 == 0) {
            return "0s";
        }
        if (j11 == f9401b) {
            return "Infinity";
        }
        if (j11 == f9402c) {
            return "-Infinity";
        }
        int i10 = 0;
        boolean z = j11 < 0;
        StringBuilder sb2 = new StringBuilder();
        if (z) {
            sb2.append('-');
        }
        if (j11 < 0) {
            j11 = (((int) j11) & 1) + ((-(j11 >> 1)) << 1);
            int i11 = b.f9405a;
        }
        long jG = g(j11, DurationUnit.f10103j);
        int iG2 = d(j11) ? 0 : (int) (g(j11, DurationUnit.h) % 24);
        if (d(j11)) {
            j10 = 0;
            iG = 0;
        } else {
            j10 = 0;
            iG = (int) (g(j11, DurationUnit.f10102e) % 60);
        }
        int iG3 = d(j11) ? 0 : (int) (g(j11, DurationUnit.f10101d) % 60);
        int iC = c(j11);
        boolean z3 = jG != j10;
        boolean z10 = iG2 != 0;
        boolean z11 = iG != 0;
        boolean z12 = (iG3 == 0 && iC == 0) ? false : true;
        if (z3) {
            sb2.append(jG);
            sb2.append('d');
            i10 = 1;
        }
        if (z10 || (z3 && (z11 || z12))) {
            int i12 = i10 + 1;
            if (i10 > 0) {
                sb2.append(' ');
            }
            sb2.append(iG2);
            sb2.append('h');
            i10 = i12;
        }
        if (z11 || (z12 && (z10 || z3))) {
            int i13 = i10 + 1;
            if (i10 > 0) {
                sb2.append(' ');
            }
            sb2.append(iG);
            sb2.append('m');
            i10 = i13;
        }
        if (z12) {
            int i14 = i10 + 1;
            if (i10 > 0) {
                sb2.append(' ');
            }
            if (iG3 != 0 || z3 || z10 || z11) {
                b(sb2, iG3, iC, 9, "s", false);
            } else if (iC >= 1000000) {
                b(sb2, iC / 1000000, iC % 1000000, 6, "ms", false);
            } else if (iC >= 1000) {
                b(sb2, iC / 1000, iC % 1000, 3, "us", false);
            } else {
                sb2.append(iC);
                sb2.append("ns");
            }
            i10 = i14;
        }
        if (z && i10 > 1) {
            sb2.insert(1, '(').append(')');
        }
        return sb2.toString();
    }
}
